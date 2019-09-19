package OA.VMwareOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserNamesSystem {
    public List<String> usernamesSystem(List<String> u) {
        List<String> answer = new ArrayList<>();
        if (u.isEmpty()) { return answer; }

        HashMap<String, Integer> db = new HashMap<>();

        for (String username : u) {
            if (db.containsKey(username)) {
                answer.add(username + String.valueOf(db.get(username)));
                db.put(username, db.get(username) + 1);
            }
            else {
                answer.add(username);
                db.put(username, 1);
            }
        }
        return answer;
    }
}
