package ro.tuc.tp.Model;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void write(String filePath,String toWrite){
        try{
            FileWriter writer=new FileWriter(filePath);
            writer.write(toWrite);
            writer.close();
            System.out.println("OK");
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
