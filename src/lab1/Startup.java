package lab1;

import java.io.*;

/**
 *
 * @author dworgolet
 */
public class Startup {
    
    public static void main(String[] args) throws IOException{
    CustomerAddressService data = new CustomerAddressService();
    
    data.produceDataListFromFile("C:/Temp/lab1.txt",
        new CustomerConsoleOutput());
           
    }
}    