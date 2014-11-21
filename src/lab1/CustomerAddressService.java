package lab1;
import java.io.*;
import java.util.*;
/**
 *
 * @author dworgolet
 */
public class CustomerAddressService {
    private DataOutputStrategy output;
    
    public void produceDataListFromFile(String filePath, DataOutputStrategy strategy) {
        if(strategy == null) throw new IllegalArgumentException("a MailListOutputStrategy is required.");
        
        output = strategy;
        List<String> list = new ArrayList<>();
        
        try {
            list = readFileLines(filePath);
            output.outputData(list);
            
        } catch (IOException ex) {

            list.add(ex.getMessage());
            output.outputData(list);
        }
    }
    
    private List<String> readFileLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
	   String line = in.readLine();
	   while(line != null){
		  lines.add(line);
		  line = in.readLine();
	   }
        in.close();
        return lines;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.output);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerAddressService other = (CustomerAddressService) obj;
        if (!Objects.equals(this.output, other.output)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer Address: " + output.toString() + '}';
    }
    
}
