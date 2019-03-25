/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

*/


class MedianFinder {
    private PriorityQueue<Integer> minHeap, maxHeap;
    private int size;
    private int median;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((c1,c2) -> c2-c1);
        size = 0;
        median = 0;
    }

    public void addNum(int num) {
        if (size == 0){
            maxHeap.offer(num);
            size ++;
            median = num;
        }

        if (size != 0){
            if (num <= median){
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }

            if (maxHeap.size() > minHeap.size()){
                minHeap.offer(median);
                median = maxHeap.poll();
            }else if (minHeap.size() - maxHeap.size() > 1){
                maxHeap.offer(median);
                median = minHeap.poll();
            }
            size ++;
        }

    }

    public double findMedian() {
        if (size == 0) return 0;
        if (size % 2 != 0) return median;
        return (double) (median + maxHeap.peek())/2;


    }
}
