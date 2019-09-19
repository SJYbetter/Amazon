package OA.VMwareOA;

public class ShiftString {
    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        if (leftShifts == rightShifts) {return s;}
        if (s == null || s.isEmpty()) {return s;}
        char [] arr = s.toCharArray();
        leftShifts = leftShifts % s.length();
        int start1 = 0;
        int end1 = leftShifts - 1;

        int start2 = end1 + 1;
        int end2 = s.length() - 1;

        // Left Shift
        reverse(arr, start1, end1);
        reverse(arr, start2, end2);
        reverse(arr, 0, arr.length-1);

        // Right Shifts
        rightShifts = rightShifts % s.length();
        start1 = 0;
        end1 = arr.length - rightShifts - 1;

        start2 = end1 + 1;
        end2 = arr.length - 1;

        reverse(arr, start1, end1);
        reverse(arr, start2, end2);
        reverse(arr, 0, arr.length-1);

        return String.valueOf(arr);
    }

    private static void reverse(char [] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char [] arr, int pos1, int pos2) {
        char temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}

