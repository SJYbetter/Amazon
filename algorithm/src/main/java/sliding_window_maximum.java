import java.util.*;
import java.util.stream.Collectors;

public class sliding_window_maximum {

    public static void dump(List<Integer> inputs, int start, int end, int max, double avg, double avg2) {
        dump(inputs, start, end, max, avg, avg2, false);
    }
    public static void dump(List<Integer> inputs, int start, int end, int max, double avg, double avg2,boolean alert) {
        String aa = inputs.subList(start, end + 1).stream().map((x) -> Integer.toString(x)).collect(Collectors.joining(","));

        System.out.println(String.format("%s, max: %d, avg1: %.6f, avg2: %.6f, alert: %s", aa, max, avg, avg2, alert));
    }

    public int[] maxSlidingWindow_v2(int[] nums, int k) {
        int[] result = new int[nums.length == 0 ? 0 : nums.length - k + 1];

        LinkedList<Integer> all_max_then_node_i = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!all_max_then_node_i.isEmpty() && i - k == all_max_then_node_i.getFirst())
                all_max_then_node_i.removeFirst();

            while (!all_max_then_node_i.isEmpty() && nums[all_max_then_node_i.getLast()] < nums[i]) {
                all_max_then_node_i.removeLast();
            }

            all_max_then_node_i.addLast(i);

            int start = i - k + 1;
            if (start < 0) {
                continue;
            }

            result[start] = nums[all_max_then_node_i.getFirst()];
        }
        return result;
    }

    public int[] maxSlidingWindow_v1(int[] nums, int k) {
        int size = nums.length;
        int[] result = new int[size - k + 1];

        TreeMap<Integer, Integer> sortmap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            sortmap.put(nums[i], i);

            int start = i - k + 1;
            if (start < 0) {
                continue;
            } else if (start > 0) {
                int remove_pending = nums[start - 1];
                if (sortmap.get(remove_pending) == start - 1) {
                    sortmap.remove(remove_pending);
                }
            }
            result[start] = sortmap.lastKey();
        }
        return result;
    }

    public int[] maxSlidingWindow_v0(int[] inputs, int k) {
        int max1 = Integer.MIN_VALUE;
        int p1 = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < inputs.length; i++) {
            int value = inputs[i];

            if (value > max1) {
                max1 = value;
                p1 = i;
            }

            int start = i - k + 1;
            if (start < 0) {
                continue;
            } else if (start > 0) {
                // patch something
                if (p1 < start) {
                    // refoound max value
                    max1 = Integer.MIN_VALUE;
                    for (int j = start; j <= i; j++) {
                        value = inputs[j];
                        if (value >= max1) {
                            max1 = value;
                            p1 = j;
                        }
                    }

                }
            }
            result.add(max1);
        }
        return result.stream().mapToInt(x -> (int) x).toArray();
    }

    public static boolean alerter_v2(List<Integer> inputs, int windowSize, float allowedIncrease) {

        long total = 0;
        //avg1 store the curcent window size average
        //avg2 store the last window size average
        float avg1 = 0, avg2 = 0;

        // store the index of number that value is great then node i
        LinkedList<Integer> all_gte_i = new LinkedList<Integer>();

        for (int i = 0; i < inputs.size(); i++) {
            int start = i - windowSize + 1;

            if (!all_gte_i.isEmpty() && all_gte_i.getFirst() == start - 1)
                all_gte_i.removeFirst();
            //find greater number
            while (!all_gte_i.isEmpty() && inputs.get(all_gte_i.getLast()) < inputs.get(i))
                all_gte_i.removeLast();

            all_gte_i.addLast(i);

            total = total + inputs.get(i);

            if (start < 0)
                continue;
            else if (start > 0)
                total = total - inputs.get(start - 1);

            int max = inputs.get(all_gte_i.getFirst());

            avg1 = total * 1.0f / windowSize;

            if (avg1 * allowedIncrease < max) {
                dump(inputs, start, i, max, avg1, avg2, true);
                // return true;
            } else if (start > 0 && avg2 * allowedIncrease < avg1) {
                dump(inputs, start, i, max, avg1, avg2, true);
                // return true;
            } else {
                dump(inputs, start, i, max, avg1, avg2, false);
            }
            avg2 = avg1;
        }
        return false;
    }

    public static boolean alerter_v1(List<Integer> inputs, int windowSize, float allowedIncrease) {

        java.util.TreeMap<Integer, Integer> sortmap = new java.util.TreeMap<Integer, Integer>();

        float avg1 = 0, avg2 = 0;
        long total = 0;

        int size = inputs.size();
        for (int i = 0; i < size; i++) {
            int value = inputs.get(i);
            sortmap.put(value, i);
            total = total + value;

            int start = i - windowSize + 1;
            if (start < 0) {
                continue;
            } else if (start > 0) {
                int remove_pending = inputs.get(start - 1);
                if (sortmap.get(remove_pending) == start - 1) {
                    sortmap.remove(remove_pending);
                }
                total = total - remove_pending;
            }

            int max = sortmap.lastKey();
            avg1 = total * 1.0f / windowSize;

            if (avg1 * allowedIncrease < max) {
                dump(inputs, start, i, max, avg1, avg2);
                // return true;
            } else if (start > 0 && avg2 * allowedIncrease < avg2) {
                dump(inputs, start, i, max, avg1, avg2);
                // return true;
            }

            avg2 = avg1;
        }

        return false;
    }

    private static boolean alerter_v0(List<Integer> inputs, int windowSize, float allowedIncrease) {
        int max1 = Integer.MIN_VALUE,
                max2 = Integer.MIN_VALUE;
        int p1 = 0, p2 = 0;

        long total = 0;
        double avg1 = 0, avg2 = 0;

        for (int i = 0; i < inputs.size(); i++) {
            int value = inputs.get(i);
            total = total + value;

            if (value > max1) {
                max1 = value;
                p1 = i;
            } else if (value > max2) {
                max2 = value;
                p2 = i;
            }

            int start = i - windowSize + 1;
            if (start < 0) {
                continue;
            } else if (start > 0) {
                // patch something
                if (p1 < start) {
                    // refoound max value
                    max1 = Integer.MIN_VALUE;
                    for (int j = start; j <= i; j++) {
                        value = inputs.get(j);
                        if (value >= max1) {
                            max1 = value;
                            p1 = j;
                        }
                    }
                }
            }

            total = total - inputs.get(start);

            avg1 = total * 1.0 / windowSize;
            if (avg1 * allowedIncrease < max1) {
                dump(inputs, start, i, max1, avg1, -1);
                //return true;
            } else if (start != 0 && avg2 * allowedIncrease < avg1) {
                dump(inputs, start, i, max1, avg1, -1);
                //return true;
            }
            avg2 = avg1;
        }

        return false;
    }

    public static void main(String[] argv) {
        Integer[] input = new Integer[]{1, 2, 100, 2, 2, 50, 20};
        alerter_v1(Arrays.asList(input), 3, 1.5f);

        System.out.println("ssssssssss");

        input = new Integer[]{1, 2, 4, 2, 2};
        alerter_v1(Arrays.asList(input), 3, 2f);

        System.out.println("ssssssssss");
        input = new Integer[]{1, 2, 100, 2, 2};
        alerter_v1(Arrays.asList(input), 2, 2.5f);
    }
}