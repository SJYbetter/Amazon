import java.text.DecimalFormat;
import java.util.*;

public class EpayAlerter {


    public static boolean alerter_v1(List<Integer> inputs, int windowSize, float allowedIncrease) {
        int length = inputs.size();
        if (length == 0) return false;

        // find max value in per slide windows
        int[] maxSlidingWindow = new int[length - windowSize + 1];

        LinkedList<Integer> all_gte_i = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int start = i - windowSize + 1;

            //remove all value not in current windows
            if (!all_gte_i.isEmpty() && all_gte_i.getFirst() < start)
                all_gte_i.removeFirst();

            //remove all value less then current value -> all node in descending order should be great or equal current
            while (!all_gte_i.isEmpty() && inputs.get(all_gte_i.getLast()) < inputs.get(i))
                all_gte_i.removeLast();

            all_gte_i.addLast(i);

            if (start >= 0)
                maxSlidingWindow[start] = all_gte_i.getFirst();
        }


        // calc all average value pre sliding window
        long total = 0;
        float[] aveSlidingWindow = new float[length - windowSize + 1];
        for (int i = 0; i < length; i++) {
            int start = i - windowSize + 1;
            total = total + inputs.get(i);
            if (start < 0)
                continue;
            if (start > 0) {
                // reducing node before current window
                total = total - inputs.get(start - 1);
            }
            aveSlidingWindow[start] = total * 1.0f / windowSize;
        }

        // check the second condition
        float min_avg = aveSlidingWindow[0];
        for (int i = 1; i < aveSlidingWindow.length; i++) {
            float limit = min_avg * allowedIncrease;
            if (aveSlidingWindow[i] > limit)
                return true;
            if (aveSlidingWindow[i] < min_avg)
                min_avg = aveSlidingWindow[i];
        }


        // Create a hashmap, for each individual maximum inputsIndex, map it to the average in all windows it appears
        HashMap<Integer, List<Float>> map = new HashMap<>();
        for (int i = 0; i < maxSlidingWindow.length; i++) {
            int maxInputsIndex = maxSlidingWindow[i];
            float avg = aveSlidingWindow[i];

            if (!map.containsKey(maxInputsIndex)) {
                map.put(maxInputsIndex, new ArrayList<Float>());
                map.get(maxInputsIndex).add(avg);
            } else {
                map.get(maxInputsIndex).add(avg);
            }
        }

        for (Map.Entry<Integer, List<Float>> entry : map.entrySet()){
            int maxInputIndex = entry.getKey();
            List<Float> avgList = entry.getValue();
            int maxValue = inputs.get(maxInputIndex);
            boolean shouldAlert = true;
            for (int windowIndex = 0; windowIndex < avgList.size(); windowIndex++) {
                float limit = avgList.get(windowIndex) * allowedIncrease;
                if (maxValue <= limit) {
                    shouldAlert = false;
                    break;
                }
            }
            if (shouldAlert)
                return true;
        }

        return false;
    }


    public Boolean alerter_orignal(List<Integer> inputs, int windowSize, float allowedIncrease) {

        // First check some special cases
        int len = inputs.size();
        if (len == 0)
            return false;

        // we first scan the nums, and get the maximum sliding window, 
        // but which stores inputsIndex, because there may be duplicate elements
        int[] maxSlidingWindow = new int[len - windowSize + 1];
        int inputsIndex = 0;
        int windowIndex = 0;
        Deque<Integer> dq = new LinkedList<>();
        while (inputsIndex < len) {
            while (!dq.isEmpty() && dq.peek() < inputsIndex - windowSize + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && inputs.get(dq.peekLast()) < inputs.get(inputsIndex)) {
                dq.pollLast();
            }
            dq.addLast(inputsIndex);
            if (inputsIndex >= windowSize - 1)
                maxSlidingWindow[windowIndex++] = dq.peek();

            inputsIndex++;
        }

        // Then we scan the inputs twice, to get the average sliding window
        float[] aveSlidingWindow = new float[len - windowSize + 1];
        inputsIndex = 0;
        windowIndex = 0;
        dq.clear();
        int sum = 0;
        while (inputsIndex < len) {
            while (!dq.isEmpty() && dq.peek() < inputsIndex - windowSize + 1) {
                sum -= inputs.get(dq.poll());
            }
            dq.addLast(inputsIndex);
            sum += inputs.get(inputsIndex);
            if (inputsIndex >= windowSize - 1) {
                float ave = (float) sum / (float) windowSize;
                DecimalFormat newFormat = new DecimalFormat("#.##");
                ave = Float.valueOf(newFormat.format(ave));
                aveSlidingWindow[windowIndex++] = ave;
            }
            inputsIndex++;
        }

        // Now we get the maximum sliding window which stores the inputsIndex of the maximum number in each window
        // And the average sliding window

        // Create a hashmap, for each individual maximum inputsIndex, map it to the average in all windows it appears
        HashMap<Integer, List<Float>> map = new HashMap<>();
        inputsIndex = 0;
        for (; inputsIndex < len - windowSize + 1; inputsIndex++) {
            int maxInputsIndex = maxSlidingWindow[inputsIndex];
            float ave = aveSlidingWindow[inputsIndex];

            if (!map.containsKey(maxInputsIndex)) {
                map.put(maxInputsIndex, new ArrayList<Float>());
                map.get(maxInputsIndex).add(ave);
            } else {
                map.get(maxInputsIndex).add(ave);
            }
        }

        // We check if the first condition meets
        for (Integer maxInputsIndex : map.keySet()) { //- baidu 1point3acres
            List<Float> aves = map.get(maxInputsIndex);
            int max = inputs.get(maxInputsIndex);
            boolean shouldAlert = true;
            for (windowIndex = 0; windowIndex < aves.size(); windowIndex++) {
                float limit = aves.get(windowIndex) * allowedIncrease;  // . 1 point3acres
                if (max <= limit) {
                    shouldAlert = false;
                    break;
                }
            }
            if (shouldAlert)
                return true; // . From 1point 3acres bbs
        }

        // Then we check if the second condition meets
        float prevMinAve = aveSlidingWindow[0];
        for (windowIndex = 1; windowIndex < aveSlidingWindow.length; windowIndex++) {
            float limit = prevMinAve * allowedIncrease;
            if (aveSlidingWindow[windowIndex] > limit)
                return true;
            if (aveSlidingWindow[windowIndex] < prevMinAve)
                prevMinAve = aveSlidingWindow[windowIndex];
        }  // . check 1point3acres for more.
        return false;
    }
}
