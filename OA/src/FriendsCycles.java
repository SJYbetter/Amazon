public class FriendCycles{
    public int friendCircles(String[] friends) {

    if ( null == friends || 0 == friends.length ) return 0;

    int n = friends.length;

    //queue and visited flag for BFS
    Queue queue = new LinkedList();
    boolean[] visited = new boolean[n];
    //min-heap holds the next friend to process at top
    PriorityQueue remaining = new PriorityQueue();

    for (int i = 0; i < n; ++i) { visited = false; remaining.offer(i); }
    //enqueue 0, the first friend enqueue(0, queue, visited, remaining); int circles = 0; while (true) { int cur = queue.poll(); char[] friendsOfCur = friends[cur].toCharArray(); for (int i = 0; i < n; ++i) { if ('Y' == friendsOfCur i != cur !visited) { enqueue(i, queue, visited, remaining); } } //Either all done or move to next circle if (queue.isEmpty()) { circles++; //all done, exit the loop if( remaining.isEmpty() ) break; //otherwise pick up the smallest friend that has not been processed enqueue(remaining.peek(), queue, visited, remaining); } } return circles; } static private void enqueue(int idx, Queue q, boolean[] visited, PriorityQueue remaining ){
    q.offer(idx);
    visited[idx] = true;
    remaining.remove(idx);
    }
}
