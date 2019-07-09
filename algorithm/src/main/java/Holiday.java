import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Holiday {

    public static int date(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("The input year should larger than 0");
        }
        LocalDate octStart = LocalDate.of(year, 10, 1);

        // check the start date is TUESDAY
        if (octStart.getDayOfWeek() == DayOfWeek.TUESDAY) {
            return octStart.plusWeeks(1).getDayOfMonth();
        }
        return octStart.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).plusWeeks(1).getDayOfMonth();
    }

    public static boolean alerter(List<Integer> inputs, int windowSize,float allowedIncrease){

        // First check some special cases
        int len = inputs.size();
        if (len == 0) return false;
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
            if (inputsIndex >= windowSize - 1) {
                maxSlidingWindow[windowIndex ++] = dq.peek();
            }
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
        for (;inputsIndex < len - windowSize + 1; inputsIndex++) {
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
        for (Integer maxInputsIndex : map.keySet()) {
            List<Float> aves = map.get(maxInputsIndex);
            int max = inputs.get(maxInputsIndex);
            boolean shouldAlert = true;
            for (windowIndex = 0; windowIndex < aves.size(); windowIndex++) {
                float limit = aves.get(windowIndex) * allowedIncrease;
                if (max <= limit) {
                    shouldAlert = false;
                    break;
                }

            }
            if (shouldAlert) return true;
        }

        // Then we check if the second condition meets
        float prevMinAve = aveSlidingWindow[0];
        for (windowIndex = 1; windowIndex < aveSlidingWindow.length; windowIndex++) {
            float limit = prevMinAve * allowedIncrease;
            if (aveSlidingWindow[windowIndex] > limit) return true;
            if (aveSlidingWindow[windowIndex] < prevMinAve) {
                prevMinAve = aveSlidingWindow[windowIndex];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Integer[] input = new Integer[]{1, 2, 100, 2, 2,50,20};
        alerter(Arrays.asList(input), 3, 1.5f);

//        int day11 = date(2019);
//        int day22 = date(2018);
//
//        System.out.println(day11);
//        System.out.println(day22);

        // System.out.println(day22);

    }

}
