package OA;

import java.util.*;

public class FactualOA {
    //速度和时间算距离那个题 时间*速度那个题的时候有个结果我得.666666667，OJ结果是.6666666666
    public static double solution(double[][] readings, long endTime) {

        double distance = 0;
        if (readings == null || readings.length == 0) return distance;

        //sort according to the timeStamp
        Arrays.sort(readings, (a, b) -> Double.compare(a[0], b[0]));

        double[] prev = readings[0];
        double prevTimeStamp = prev[0];

        //endTime before the first start time
        if (prevTimeStamp >= endTime) return distance;

        for (int i = 1; i < readings.length; i++) {
            double[] cur = readings[i];
            double curTimeStamp = cur[0];
            //need to end for current time
            if (endTime <= curTimeStamp) {
                distance += (endTime - prevTimeStamp) * prev[1];
                break;
            } else {
                distance += (curTimeStamp - prevTimeStamp) * prev[1];
                //update for the prev and prevTimeStamp
                prev = cur;
                prevTimeStamp = curTimeStamp;
            }
        }
        return distance;
    }

        //找最小的距离那个题（其实就是lc296 meeting那个
        //[[1,0],[1,1]] return 1
        //[-4,3], [-2,1], [1,0], [3,2]] return 14
    public static long solution1(long[][] clients){
        //edge case
        int numClients = clients.length;
        long distance = 0;



        if (clients == null || numClients == 0) return distance;
        //get all move x or y position
        long[] X_move = new long[numClients];
        long[] Y_move = new long[numClients];

        for (int i = 0; i < numClients; i ++){
            long x = clients[i][0];
            long y = clients[i][1];
            X_move[i] = x;
            Y_move[i] = y;
        }

        //sort and get the median
        Arrays.sort(X_move);
        Arrays.sort(Y_move);
        long xMedian = X_move[numClients/2];
        long yMedian = Y_move[numClients/2];

        //using Euclidean Distance in one dimension to calculate
        for (int j = 0; j < numClients; j++){
            distance += Math.abs(xMedian - X_move[j]);
            distance += Math.abs(yMedian - Y_move[j]);
        }
        return distance;
    }

    //算所有库的个数的那个题
    private static Map<String, Integer> moduleCount = new HashMap<>();
    public static int solution2(String modulesToBuild, String[][] dependencies){
        //check edge case
        if (dependencies == null || dependencies.length == 0) return 0;
        if (modulesToBuild == null || "".equals(modulesToBuild)) return 0;

        Map<String, List<String>> des = mapifyArgument(dependencies); //这是已经写好的一个方法，也就是dependencies现在已经是map形式了
        //to do

        Set<String> visited = new HashSet<>();
        dfs(modulesToBuild, des, visited);
        return visited.size();
    }

    private static Map<String, List<String>> mapifyArgument(String[][] dependencies){
        Map<String, List<String>> map = new HashMap<>();
        if (dependencies == null || dependencies.length == 0) return map;
        for (String[] pair: dependencies){
            if (!map.containsKey(pair[0])){
                map.put(pair[0], new ArrayList<>());
            }
            map.get(pair[0]).add(pair[1]);
        }
        return map;
    }



    private static void dfs(String modulesToBuild,
                            Map<String, List<String>> des,
                            Set<String> visited){
        List<String> dependencies = des.getOrDefault(modulesToBuild, Collections.emptyList());
        //visited.add(modulesToBuild);
        if (visited.contains(modulesToBuild)) return;
        for (String x: dependencies){
            if (!visited.contains(x)) {
                dfs(x, des, visited);
            }
        }
        visited.add(modulesToBuild);

    }

    public static void main(String[] args){


    }
}
