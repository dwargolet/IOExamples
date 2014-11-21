package lab1;

import java.util.*;

/**
 *
 * @author dworgolet
 */
public interface DataOutputStrategy {
    
    public abstract void outputData(List<String> lines);    
    public abstract String getName();
}
