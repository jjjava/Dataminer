package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class Handler implements Runnable {

    private String data[];

    public Handler(String data[]) {
        this.data = data;
    }

    @Override
    public void run() {

        try {
            System.out.println("@@@@@@@@@@@@@@@@@@@@ " + data[1]);
            File f = new File(data[1]);

            if (f.isDirectory()) {
                // sql.SQL_Insert_Folder.insertFolders(data);
            } else {

                String dataf[] = new String[5];

                dataf[0] = data[0];
                dataf[1] = data[1];

                String fileName = f.getName();
                String ext[] = fileName.split("\\.");
                int i = ext.length;
                if (i > 1) {
                    dataf[2] = ext[i - 1];
                }

                StringBuffer b = new StringBuffer();
                if (dataf[2].equalsIgnoreCase("txt")
                        || dataf[2].equalsIgnoreCase("xml")
                        || dataf[2].equalsIgnoreCase("sql")
                        || dataf[2].equalsIgnoreCase("java")
                        || dataf[2].equalsIgnoreCase("sh")
                        || dataf[2].equalsIgnoreCase("vbs")
                        || dataf[2].equalsIgnoreCase("bat")) {

                    String line = null;

                    try {
                        System.out.println("path file " + f.getAbsolutePath());
                        FileInputStream fis = new FileInputStream(f);

                        // get max length  
                        int readSize = 1 * 1024 * 1024; // 2Mb  
                        System.out.println("Read size " + readSize);
                        int len = fis.available() < readSize ? fis.available() : readSize;
                        System.out.println("Len buffer " + len);
                        byte[] buffer = new byte[len];

                        // read to buffer  
                        fis.read(buffer, 0, len);
                        System.out.println("Lenght buffer " + buffer.length);
                        String t = new String(buffer);
                        System.out.println("String " + t);
                        

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Erro readFile: " + e.getMessage());
                    }
                }
               
                dataf[3] = b.toString();
                dataf[4] = data[2];

                //    sql.SQL_Insert_Files.insertFiles(dataf);
            }
        } catch (Exception e) {
        }
    }
}