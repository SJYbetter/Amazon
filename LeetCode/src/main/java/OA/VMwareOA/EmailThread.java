package OA.VMwareOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailThread {
    public List<int[]> emailThread(String[] emails) {
        if (emails == null || emails.length == 0) {
            return new ArrayList<>();
        }

        int threadCount = 0;
        List<int[]> res = new ArrayList<>();
        Map<String, int[]> map = new HashMap<>();
        for (String email : emails) {
            String[] info = email.split(","); // what if content has , ?
            String sender = info[0];
            String receiver = info[1];
            String content = info[2];

            String curKey = sender + receiver + content;
            if (!content.contains("---")) { // find a new thread
                threadCount++;
                map.put(curKey, new int[]{threadCount, 1});
                res.add(new int[]{threadCount, 1});
            }
            else { // not a new thread
                // extract previous content
                int startIndex = email.indexOf("---") + 3; // may have space after ---?
                String preContent = email.substring(startIndex);
                String preKey = receiver + sender + preContent;
                if (!map.containsKey(preKey)) { // same person send two messages without response
                    preKey = sender + receiver + preContent;
                }

                int curThreadCount = map.get(preKey)[0];
                int curMessageCount = map.get(preKey)[1] + 1;
                map.put(curKey, new int[]{curThreadCount, curMessageCount});
                res.add(new int[]{curThreadCount, curMessageCount});
            }
        }

        for (int[] r : res) {
            System.out.println(r[0] + "," + r[1]);
        }
        return res;
    }

    public static void main(String[] args){

    }
}
