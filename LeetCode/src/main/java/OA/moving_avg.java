package OA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class moving_avg {

    private static class DayPrice {
        public String day;
        public int price;

        public  DayPrice(String day, int price){
            this.day = day;
            this.price = price;
        }
    }

    private static LinkedList<Integer> days_9 = new LinkedList<Integer>();
    private static LinkedList<Integer> days_50 = new LinkedList<Integer>();
    private static long total_9 = 0;
    private static long total_50 = 0;

    private static double last_ma_9 = -1;
    private static double last_ma_50 = -1;

    private static String push_new_day(String date, int price) {
        days_9.addLast(price);
        days_50.addLast(price);
        total_9 += price;
        total_50 += price;

        while (days_9.size() > 9) {
            price = days_9.removeFirst();
            total_9 -= price;
        }

        while (days_50.size() > 50) {
            price = days_50.removeFirst();
            total_50 -= price;
        }

        if (days_50.size() < 50) {
            return null;
        }

        double ma_9 = total_9 / 9.0;
        double ma_50 = total_50 / 50.0;

        try {
            if (ma_9 >= 0 && ma_50 >= 0 && (
                    (last_ma_9 < last_ma_50 && ma_9 > ma_50) ||
                            (last_ma_9 > last_ma_50 && ma_9 < ma_50))) {
                return date;
            }
            return null;
        } finally {
            last_ma_9 = ma_9;
            last_ma_50 = ma_50;
        }
    }

    public static void main(String[] argv) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line = null;
        boolean is_None = true;
        while ((line = in.readLine()) != null) {
            String[] parts = line.trim().split("\\|", 2);
            String day = push_new_day(parts[0], (int) Math.round(Double.parseDouble(parts[1]) * 100));
            if (day != null) {
                System.out.println(day);
                 is_None = false;
            }
        }
        if (is_None){
            System.out.println("NULL");
        }
    }
}
