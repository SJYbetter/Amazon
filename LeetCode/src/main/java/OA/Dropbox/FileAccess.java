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

    public static List<String> getAllAccessFile(String[][] files, Set<String> set){
        Map<String, List<String>> graph = fileGraph(files);
        List<String> allAccessFiles = new ArrayList<>();
        for (String acc: set){
            allAccessFiles.add(acc);
            dfs(acc, allAccessFiles, graph);
        }
        return allAccessFiles;

    }

    private static void dfs(String file, List<String> files, Map<String, List<String>> graph){
        if (!graph.containsKey(file)) return;
        for (String subFile: graph.get(file)){
            //files.add(subFile);
            dfs(subFile, files, graph);
        }
    }

    private static Map<String, List<String>> fileGraph(String[][] files){
        Map<String, List<String>> graph = new HashMap<>();

        for (String[] relation: files){
            String parent = relation[1];
            String child = relation[0];
            if (parent == null) continue;
            if (!graph.containsKey(parent)){
                graph.put(parent, new ArrayList<>());
            }
            graph.get(parent).add(child);
        }
        return graph;
    }

    public static void main(String[] args){
        String[][] folders = {{"A", null}, {"B", "A"}, {"C", "B"}, {"D", "B"},{"E", "A"},{"F", "E"}, {"G", "F"}};
        Map<String, String> graph = buildFileGraph(folders);
        Set<String> access = new HashSet<>(Arrays.asList("C", "E"));
        System.out.println(hasAccess("B", graph, access));
        System.out.println(hasAccess("C", graph, access));
        System.out.println(hasAccess("F", graph, access));
        System.out.println(hasAccess("G", graph, access));


        for (String file: getAllAccessFile(folders, access)){
            System.out.println(file);
        }
    }
}
