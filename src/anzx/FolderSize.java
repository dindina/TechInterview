package anzx;

import java.io.File;
import java.io.IOException;
import sun.lwawt.macosx.CSystemTray;


public class FolderSize {

    public static long calculateFolderSize(File path)
    {
        File[] childFiles = path.listFiles();
        int size=0;
        for(File file : childFiles)
        {
            System.out.println("file " + file.getName());
            if(file.isDirectory())
            {
                System.out.println("directory " + file.getName());
                size += calculateFolderSize(file);
            }
            else // if this is just a file
            {
                 size += file.length();
            }
        }

        return size;
    }

    public static File getPath(File root,String path) throws IOException {
        File[] filesList = root.listFiles();
        if(filesList !=null) {
            for (File file : filesList) {
                if(file.getName().length() > path.length())
                    continue;
                System.out.println(file.getPath());
                String fileName = file.getPath(); // users/dinesh/
                if (fileName.contains(path)) {
                    return file;
                }


                if (file.isDirectory()) {
                    getPath(file, path);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        Long size=0l;
        size=calculateFolderSize(new File("/Users/dirajendran/Downloads/AIML assignment"));

        System.out.println("dina " + size);

        //File file = getPath(new File("/Users/dirajendran/"), "/Users/dirajendran/Library/Application Support/Google/");
        //System.out.println(file);

    }
}
