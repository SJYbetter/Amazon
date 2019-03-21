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

    /** initialize your data structure here. */
    public MedianFinder() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1,c2) -> c2-c1);
    }

    public void addNum(int num) {

    }

    public double findMedian() {
        if 

    }
}
