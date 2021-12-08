package scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteEmployee
{
    public static void delete(String id)
    {        
        String filePath = "src/data/EmployeeData.txt";
        int pos = 0;

        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String currLine;
        String[] data;

        try(FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr))
        {
            while((currLine = br.readLine()) != null)
            {
                data = currLine.split(" ");
                if(!(data[pos].equalsIgnoreCase(id)))
                    pw.println(currLine);
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
