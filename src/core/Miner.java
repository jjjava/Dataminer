package core;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class Miner {

    public Miner() {
    }

    public static void listPath(File path) {
        File files[];
        int indentLevel = -1;
        indentLevel++;
        files = path.listFiles();
        Arrays.sort(files);

        for (int i = 0, n = files.length; i < n; i++) {
            for (int indent = 0; indent < indentLevel; indent++) {
                System.out.println(" teste "+files[i].getName());
            }
            
            
            String data [] = new String[3];
            data[0] = files[i].getName();
            data[1] = files[i].getAbsolutePath();
            data[2] = new Date(files[i].lastModified()).toString();
          
            core.Handler h = new core.Handler(data);
            h.run();
            System.out.println("File: "+files[i].getName());
            if (files[i].isDirectory()) {
                listPath(files[i]);
            }
        }
        indentLevel--;
    }
}
