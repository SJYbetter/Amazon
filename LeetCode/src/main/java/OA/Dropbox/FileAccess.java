package OA.Dropbox;

import java.util.*;

public class FileAccess {
    public static boolean hasAccess(String filename, Map<String, String> map, Set<String> access){
        if (filename == null) return false;
        if (access.contains(filename)) return true;
        boolean upperFile = hasAccess(map.get(filename), map, access);
        if (upperFile){
            access.add(filename);
        }
        return upperFile;
    }

    public static Map<String, String> buildFileGraph(String[][] files){
        Map<String, String> map = new HashMap<>();
        for (String[] f: files){
            map.put(f[0], f[1]);
        }
        return map;
    }

    public static List<String> getAllAccessFile(Map<String, String> map, Set<String> set){
        return new ArrayList<>();
    }

    public static void main(String[] args){
        String[][] folders = {{"A", null}, {"B", "A"}, {"C", "B"}, {"D", "B"},{"E", "A"},{"F", "E"}, {"G", "F"}};
        Map<String, String> graph = buildFileGraph(folders);
        Set<String> access = new HashSet<>(Arrays.asList("C", "E"));
        System.out.println(hasAccess("B", graph, access));
        System.out.println(hasAccess("C", graph, access));
        System.out.println(hasAccess("F", graph, access));
        System.out.println(hasAccess("G", graph, access));
    }
}
