package lab1;

import java.io.*;

/**
 *
 * @author dworgolet
 */
public class Startup {
    public static void main(String[] args) throws IOException{
 
        File data = new File(File.separatorChar + "temp" + File.separatorChar +
                "lab1" + File.separatorChar + "test.txt");
        
        BufferedReader dataReader = new BufferedReader(new FileReader(data));
        
        
        try{
            int lineCount = 1;
            List<String[]> records = new ArrayList<>();
            String inputLine = dataReader.readLine();
            while(inputLine != null){
                records.add(inputLine.split(" "));
                if(lineCount >= 3){
                    outputRecord(records);
                    recordsRead++;
                    lineCount = 0;
                }
                inputLine = dataReader.readLine();
                lineCount++;
            }
        }
        catch(IOException e){
            
            
        }
        finally{
            try{
                System.out.println("Total records read: " + recordsRead);
                dataReader.close();
            }
            catch(Exception e){
                
            }
        }
        
              
        
    }
}    