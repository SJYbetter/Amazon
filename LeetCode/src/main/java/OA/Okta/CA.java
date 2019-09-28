package OA.Okta;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CA {
    private Queue<CustomerDefinition> queue ;
    private int[] finishJobs;
    private int queueLimit;
    private int nextGuest = 0;
    private static final int QUEUE_TIMER_ID = -1;

    private  static class CustomerDefinition {
        public int arrivalAt;
        public int serviceDuration;
        public int toleranceLimit;

        public CustomerDefinition parseInput(String arrivalText) {
            String[] parts = arrivalText.split(",", 3);
            arrivalAt = Integer.parseInt(parts[0]);
            serviceDuration = Integer.parseInt(parts[1]);
            toleranceLimit = Integer.parseInt(parts[2]);
            return this;
        }
    }

    private static class TimerEvent implements  Comparable<TimerEvent> {
        public int timeAt;
        public int windowId;
        public int serviceDuration;

        public TimerEvent(int timeAt, int windowId) {
            this(timeAt, windowId, 0);
        }

        public TimerEvent(int timeAt, int windowId, int serviceDuration) {
            this.timeAt = timeAt;
            this.windowId = windowId;
            this.serviceDuration = serviceDuration;
        }

        public boolean isCustomer(){
            return this.windowId == QUEUE_TIMER_ID;
        }

        public int compareTo(TimerEvent o) {
            int diff;
            if (o == this) return 0;

            if ((diff = (this.timeAt - o.timeAt)) != 0)
                return diff;

            if ((diff = (this.windowId - o.windowId)) != 0)
                return diff;

            return this.serviceDuration - o.serviceDuration;
        }

        @Override
        public String toString() {
            return String.format("tv: %d %d %d", timeAt, windowId, serviceDuration);
        }
    }
    private PriorityQueue<TimerEvent> pq = new PriorityQueue<TimerEvent>();

    private CustomerDefinition getNextGuest(String[] arrivals){
        return getNextGuest(arrivals, 0);
    }

    /**
     *
     * @param arrivals
     * @param timeAt  workers空闲时间点
     * @return
     */
    private CustomerDefinition getNextGuest(String[] arrivals, int timeAt) {
        CustomerDefinition cd;
        do {
            String describe = arrivals[nextGuest++];
            cd = new CustomerDefinition().parseInput(describe);
        } while (cd.arrivalAt < timeAt);  // 入队
        return cd;
    }

    @Test
    public void serveCustomers(String[] arrivals, int numWindows, int queueSize) {
        queue = new LinkedList<>();
        finishJobs = new int[numWindows];
        queueLimit = queueSize;
        CustomerDefinition cd;

        while (queue.size() < queueLimit) {
            queue.offer(cd = getNextGuest(arrivals, 0));
            pq.add(new TimerEvent(cd.toleranceLimit, QUEUE_TIMER_ID));
        }

        for (int i = 0; i < numWindows; i++) {
            pq.add(new TimerEvent(0, i, 0));
        }

        while (pq.size() > 0) {
            TimerEvent tv = pq.poll();
            if (tv.isCustomer()) {
                queue.remove(tv.serviceDuration);
                if ((cd = getNextGuest(arrivals, tv.timeAt)) != null) {
                    queue.add(cd);
                    pq.add(new TimerEvent(cd.arrivalAt + cd.toleranceLimit, QUEUE_TIMER_ID));
                }
            } else {
                finishJobs[tv.windowId]++;
                cd = queue.poll();
                pq.add(new TimerEvent(tv.timeAt + cd.serviceDuration, tv.windowId));
            }
        }
    }

    @Test
    public  void testInt(){
        System.out.println((int)Math.pow(2, 31)-1);
        System.out.println(Integer.MAX_VALUE);

        PriorityQueue<TimerEvent> q = new PriorityQueue<>();
        q.add(new TimerEvent(5,7));
        q.add(new TimerEvent(3,2));
        q.add(new TimerEvent(5,3));
        q.add(new TimerEvent(9,10));

        while(q.size()>0){
            System.out.println(q.poll());
        }
    }
}
