package OA.Dropbox;

import java.util.*;

//1. finish hasAcess(String name)
//2. find all access file name
//3. simply the access set
public class FileAccess1 {
    private String[][] folders;
    private Set<String> access;
    //private Map<String, List<String>> graph;
    private Map<String, String> map;
    //private List<String> allAccessFiles;
    public FileAccess1(String[][] folders, Set<String> access){
        this.folders = folders;
        this.access = access;
        this.map = buildAccessMap(folders);
        //this.graph = buildGraph(folders);
    }
/*
    private Map<String, List<String>> buildGraph(String[][] folders){
        Map<String, List<String>> map = new HashMap<>();
        for (String[] f: folders){
            String parent = f[1];
            String child = f[0];
            if (parent == null) continue;
            if (!map.containsKey(parent)){
                map.put(parent, new ArrayList<>());
            }
            map.get(parent).add(child);
        }
        return map;
    }
*/
    private Map<String, String> buildAccessMap(String[][] folders){
        Map<String, String> map = new HashMap<>();
        for (String[] f: folders){
            //if (f[1] == null) continue;
            map.put(f[0], f[1]);
        }
        return map;
    }


    public boolean hasAccess(String name){
        if (name == null) return false;
        if (access.contains(name)) return true;
        boolean upper = hasAccess(map.get(name));
        if (upper){
            access.add(map.get(name));
        }
        return upper;
    }

    public List<String> allAccessFiles(){
        List<String> ans = new ArrayList<>();
        for (String name: map.keySet()){
            if (hasAccess(name)){
                ans.add(name);
            }
        }
        for (String name: ans){
            System.out.println(name);
        }
        return ans;
    }


    public Set<String> simplyAccessFolder(){
        Set<String> res = new HashSet<>();
        for (String name: map.keySet()){
            String father = map.get(name);
            if (hasAccess(father)) continue;
            else if (access.contains(name)){
                res.add(name);
            }
        }
        return res;

    }



    public static void main(String[] args){

        String[][] folders = {{"A", null}, {"B", "A"}, {"C", "B"}, {"D", "B"},{"E", "A"},{"F", "E"}, {"G", "F"}};
        Set<String> access = new HashSet<>(Arrays.asList("C", "E", "G"));
        FileAccess1 fa = new FileAccess1(folders, access);
        List<String> ans = fa.allAccessFiles();
        Set<String> simple = fa.simplyAccessFolder();

        System.out.println("ALL SIMPLE SET");
        for (String s: simple){
            System.out.println(s);
        }

    }
}