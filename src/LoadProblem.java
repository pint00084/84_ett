import java.io.*;
import java.util.*;

public class LoadProblem {

	public static void main(String[] args) throws IOException {
		// int count = 0;
		// Scanner input = new Scanner (new File("car-f-92.stu"));
		
		// while(input.hasNextInt()) {
		//	System.out.print(input.nextInt() + "\t");
			// count++;
			// if (count%4 == 0)
			//	 System.out.println();
		// }
				
		// System.out.println();
	
		try {
			BufferedReader reader = new BufferedReader(new FileReader("car-f-92.stu"));
		    String line = reader.readLine();
		    String data[] = null;
		    
		    // while (line != null) {
		    // 	System.out.println(line);
		    // 	line = reader.readLine();
		    //    data = line.split(",");
		    // }
		    // reader.close();
		    
		    BufferedReader br = null;
			while( (line = br .readLine()) != null ) {	
                String[] tmp = line.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/");
             
                Graph g = new Graph();
                g.addVertex(tmp[1]);
                
                for(int y=1;y<tmp.length;y++) {
                	if(g.hasVertex(tmp[y])) {
                		for(int z=1; z<tmp.length; z++) {
                			if(y != z)
                				g.addEdge(tmp[y],tmp[z]);
               			 	else
               			 		continue;
               		 	}
               	 	}
                }
           }
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void Periods() {
		int files = 13;
        int periods;
        
        switch (files) {
            case 0: 
            	System.out.println("/datasheets/problems/car-f-92.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"car-f-92.stu">));
            	periods = 32;
                break;
            case 1:
            	System.out.println("/datasheets/problems/car-s-91.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"car-s-91.stu">));
            	periods = 35;
                break;
            case 2:  
            	System.out.println("/datasheets/problems/ear-f-83.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"ear-f-83.stu">));
            	periods = 24;
                break;
            case 3:  
            	System.out.println("/datasheets/problems/hec-s-92.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"hec-s-92.stu">));
            	periods = 18;
                break;
            case 4:  
            	System.out.println("/datasheets/problems/kfu-s-93.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"kfu-s-93.stu">));
            	periods = 20;
                break;
            case 5:  
            	System.out.println("/datasheets/problems/lse-f-91.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"lse-f-91.stu">));
            	periods = 18;
                break;
            case 6:  
            	System.out.println("/datasheets/problems/pur-s-93.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"pur-s-93.stu">));
            	periods = 42;
                break;
            case 7:  
            	System.out.println("/datasheets/problems/rye-s-93.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"rye-s-93.stu">));
            	periods = 23;
                break;
            case 8:  
            	System.out.println("/datasheets/problems/sta-f-83.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"sta-f-83.stu">));
            	periods = 13;
                break;
            case 9:  
            	System.out.println("/datasheets/problems/tre-s-92.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"tre-s-92.stu">));
            	periods = 23;
                break;
            case 10:  
            	System.out.println("/datasheets/problems/uta-s-92.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"uta-s-92.stu">));
            	periods = 35;
                break;
            case 11:  
            	System.out.println("/datasheets/problems/ute-s-92");
            	// BufferedReader in = new BufferedReader(new FileReader (<"ute-s-92">));
            	periods = 10;
                break;
            default: 
            	System.out.println("/datasheets/problems/yor-f-83.stu");
            	// BufferedReader in = new BufferedReader(new FileReader (<"yor-f-83.stu">));
            	periods = 21;
                break;
        }
        
        System.out.println(periods);
	}
}