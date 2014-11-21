package lab1;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author dworgolet
 */
public class CustomerConsoleOutput implements DataOutputStrategy, Comparable<DataOutputStrategy>{
    private static final boolean DEBUG = false;
    private String name = "";
    
    @Override
    public void outputData(List<String> lines) {
        if(DEBUG) System.out.println(lines);
        
        int lineCount = 0;
        for(int i=0; i < lines.size(); i++) {
            
            String value = lines.get(i).replaceAll(",", "");
            String[] parts = value.split(" ");
            
            if(lineCount < 3) {
                switch(lineCount++) {
                    case 0:
                        System.out.println("First Name: " + parts[0] + "\n" +
                                "Last Name: " + parts[1]);
                        break;
                    case 1:
                        System.out.println("Street Address: " + value);
                        break;
                    case 2:
                        String[] addressParts = value.split(" ");
                        if(addressParts.length == 3) {
                            System.out.println("City: " + addressParts[0] + "\n"
                                    + "State: " + addressParts[1] + "\n" +
                                    "Zip: " + addressParts[2]);
                        }else if(addressParts.length == 4) {
                                System.out.println("City: " + addressParts[0] + 
                                        " " + addressParts[1] + "\n"
                                    + "State: " + addressParts[2] + "\n" +
                                    "Zip: " + addressParts[3]);
                        }
                        break;
                }        
            } else {
                lineCount = 0;
                i -= 1;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final CustomerConsoleOutput other = (CustomerConsoleOutput) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(DataOutputStrategy other) {
        return this.name.compareTo(other.getName());
    }
}
