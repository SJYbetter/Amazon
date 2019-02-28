
public class NN{
//返回substring有k个不同的char的个数，无论长度的限制
public static int countkDist(String str, int k){
    //corner case
    if(str == null || str.length() < k || k > 26) return 0;
    // HashSet to avoid duplicate substring, HashMap to store chars in tmp string
    Set<String> set = new HashSet<>();

    for(int left = 0; left < str.length() - k + 1; left++) {
        Map<Character, Integer> chars = new HashMap<>();
        int cnt = 0;
        for(int right = left; right < str.length(); right++) {
            char add = str.charAt(right);
            if(!chars.containsKey(add)) {
                cnt++;
            }
            chars.put(add, chars.getOrDefault(add, 0) + 1);
            if(cnt == k) set.add(str.substring(left, right + 1));
        }
    }
    return set.size();
}


//return the count of substring of length K and exactly K distinct characters.
public static int KDistincKSize(String stringIn, int K){
    if (stringIn == null || "".equals(stringIn) || K<=0) return 0;

    Set<String> set = new HashSet<>();
    Set<Character> charSet = new HashSet<>();
    int j = 0;
    int len = stringIn.length();
    for (int i = 0; i <= len - K; i++) {
        while (j < len && charSet.size() < K) {
            char c = stringIn.charAt(j);
            if (charSet.contains(c)) {
                break;
            }else{
                charSet.add(c);
                j ++;
            }
            if (charSet.size() == K) {
                set.add(stringIn.substring(i, j));
            }
        }
        charSet.remove(stringIn.charAt(i));
    }
    return set.size();
}


//k长度 刚刚好k-1个不同的字符的子串
public List<String> subStringK1(String s, int k){
    if (s == null || "".equals(s) || k > 26) return new ArrayList<>();
    //key is the character, value is corresponding frequency
    Map<Character, Integer> lookup = new HashMap<Character, Integer>();
    //answer by using set to avoid depulicate
    List<String> answer = new ArrayList<>();

    for(int i = 0; i+k < s.length(); i++){
        String item = s.substring(i, i+k);
        int duplicateCount = 0;
        lookup.clear();
        for(char temp : item.toCharArray()){
            lookup.put(temp, lookup.getOrDefault(temp, 0)+1);
            if(lookup.getOrDefault(temp, 0) > 1){
                duplicateCount++;
                }
        }
        //check duplicate character
        if(duplicateCount == 1){
            answer.add(item);
            i += 1;
        }
     }
     return answer;
}


public class MaxAverageSubtree {

private class NodeSummary {
    int total;
    int count;

    public NodeSummary(int total, int count) {
        this.total = total;
        this.count = count;
    }
}
//多茶树的定义


private static class TreeNode {
    int val;
    List<TreeNode> children;
}

private NodeSummary max_summary = null;
private TreeNode max_node = null;

public NodeSummary fix_max_node(NodeSummary currentSummary, TreeNode currentNode) {
    if (max_summary == null ||
            (currentSummary.total * 1.0 / currentSummary.count) > (max_summary.total * 1.0 / max_summary.count)) {
        max_summary = currentSummary;
        max_node = currentNode;
    }
    return currentSummary;
}

public NodeSummary find_max_average_subtree(TreeNode node) {
    if (node.children == null || node.children.size() == 0) {
        return  new NodeSummary(1, node.val);
    }

    int child_total = 0;
    int child_count = 0;

    for (TreeNode child : node.children) {
        NodeSummary summary = this.find_max_average_subtree(child);
        child_total += summary.total;
        child_count += summary.count;
    }

    return fix_max_node(new NodeSummary(child_total + node.val, child_count + 1), node);
}

public TreeNode execute(TreeNode root){
    this.find_max_average_subtree(root);
    return this.max_node;
}
}



public class HighFive {
// definition of record
class Record {
    public int id, score;
    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

public Map<Integer, Double> highFive(Record[] results) {

    // store answer, key is the id of students, value is the average of highest five scores
    Map<Integer, Double> answer = new HashMap<>();
    // use a map to store the information, key is the id, value is highest five scores in pq
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    for (Record r : results) {
        // check whether this student is in the map or not, if not, just put this student id in map
        if (!map.containsKey(r.id)) {
            map.put(r.id, new PriorityQueue<>());
        }
        // 已经把新的id 放到这个map里了， 所以取出来，然后加成绩， 因为上一步没有加成绩的
        PriorityQueue<Integer> pq = map.get(r.id);

        //check pq size first
        if (pq.size() < 5)
            pq.add(r.score);
        else {
            //size > 5, check the peak record
            if (pq.peek() < r.score) {
                pq.poll();
                pq.add(r.score);
            }
        }
    }
    //go through the map and calculate the mean of highest five score
    for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
        int id = entry.getKey();
        PriorityQueue<Integer> hiveScores = entry.getValue();
        double mean = 0.0;
        for (int i = 0; i < 5; i++) {
            mean += hiveScores.poll();
        }
        mean /= 5.0;
        answer.put(id, mean);
    }
    return answer;
}
