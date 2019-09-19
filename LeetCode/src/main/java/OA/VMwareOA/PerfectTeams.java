package OA.VMwareOA;

import java.util.HashMap;
import java.util.Map;

public class PerfectTeams {
    public int differentTeams(String skills) {
        if (skills == null || skills.isEmpty()) {return 0;}
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skills.length(); i++) {
            if (map.containsKey(skills.charAt(i))) {
                map.put(skills.charAt(i), map.get(skills.charAt(i)) + 1);
            }
            else {
                map.put(skills.charAt(i), 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer val : map.values()) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }
    //instead of using hashmap, using an array to reduce the time complexity
    public int differntTeam2(String skills){
        if (skills == null || "".equals(skills)) return 0;
        int[] courseCount = new int[5];
        for (int i = 0; i < skills.length(); i++){
            countCourse(courseCount, skills.charAt(i));
        }
        int teamNum = Integer.MAX_VALUE;
        for (int i: courseCount){
            teamNum = Math.min(i, teamNum);
        }
        return teamNum;
    }

    private void countCourse(int[] courseCount, char c){
        switch (c){
            case 'p':
                courseCount[0] ++;
                break;
            case 'c':
                courseCount[1] ++;
                break;
            case 'm':
                courseCount[2] ++;
                break;
            case 'b':
                courseCount[3] ++;
                break;
            case 'z':
                courseCount[4] ++;
                break;
        }
    }
}
