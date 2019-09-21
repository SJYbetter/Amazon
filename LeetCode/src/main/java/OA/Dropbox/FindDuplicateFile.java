package OA.Dropbox;


/*
import com.sun.tools.javac.util.Convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class FindDuplicateFile {
    public List<List<String>> findDuplicates(String path){
        List<List<String>> res = new ArrayList<>();

        if (path == null || "".equals(path)) return res;
        List<String> filePaths = getAllFiles(path);
        Map<String, List<String>> map = new HashMap<>();

        for (String p: filePaths){
            File file = new File(p);
            String hashCode = hashFile(file, "MD5");
            if (!map.containsKey(hashCode)){
                map.put(hashCode, new ArrayList<>());
            }
            map.get(hashCode).add(p);
        }

        for (List<String> p: map.values()){
            if (p.size() >= 2){
                res.add(p);
            }
        }
        return res;


    }


    private static String hashFile(File file, String algorithm){

        FileInputStream inputStream = new FileInputStream(file);

        MessageDigest digest = MessageDigest.getInstance(algorithm);

        byte[] bytesBuffer = new byte[1024];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
            digest.update(bytesBuffer, 0, bytesRead);
        }

        byte[] hashedBytes = digest.digest();

        return Base64.getEncoder().encodeToString(hashedBytes);


    }


    private void read1KB(String path){
        if ()
    }






    private static List<String> getAllFiles(String path){
        List<String> allFiles = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        stack.push(path);
        while (!stack.isEmpty()){
            String curPath = stack.pop();
            File file = new File(curPath);
            if (file.isFile()){
                allFiles.add(curPath);
            }else if (file.isDirectory()){
                String[] subDir = file.list();
                for (String dir : subDir){
                    stack.push(curPath + "/" + dir);
                }
            }
        }

        return allFiles;
    }

    public static List<List<String>> getDuplicateFilesBySize(String root){
        List<List<String>> res = new ArrayList<>();
        if (root == null || "".equals(root)) return res;
        Map<Long, List<String>> mapSize = getAllFileBySize(root);
        Map<String, List<String>> duplicateMap = new HashMap<>();
        for (List<String> path: mapSize.values()){
            if (path.size() < 2) continue;
            for (String p: path){
                File f = new File(p);
                String hashCode = hashFile(f, "md5");
                if (!duplicateMap.containsKey(hashCode)){
                    duplicateMap.put(hashCode, new ArrayList<>());
                }
                duplicateMap.get(hashCode).add(p);
            }
        }

        for (List<String> path1: duplicateMap.values()){
            if (path1.size() > 1){
                res.add(path1);
            }
        }
        return res;
    }

    private static Map<Long, List<String>> getAllFileBySize(String path){
        Map<Long, List<String>> fileBySize = new HashMap<>();
        Stack<String> s = new Stack<>();
        s.push(path);
        while (!s.isEmpty()){
            String curPath = s.pop();
            File file = new File(curPath);
            if (file.isFile()){
                long size = file.length();
                if (!fileBySize.containsKey(size)){
                    fileBySize.put(size, new ArrayList<>());
                }
                fileBySize.get(size).add(curPath);
            }else if (file.isDirectory()){
                String[] subPath = file.list();
                for (String path1: subPath){
                    String dir = curPath + "/" + path1;
                    s.push(dir);
                }
            }
        }
        return fileBySize;
    }
}



 */
