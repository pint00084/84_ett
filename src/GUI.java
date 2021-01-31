import java.awt.*;
import javax.swing.*;

public class GUI {
	
	public GUI() {
		JFrame frame = new JFrame();
		
		JLabel label1 = new JLabel("Εργασία μαθήματος “Αλγόριθμοι και Πολυπλοκότητα”");
		JLabel label2 = new JLabel("Χρονοπρογραμματισμός εξετάσεων Πανεπιστημίου V1.0");
		JLabel label3 = new JLabel("Μπουραζάνης Γεώργιος | ΑΜ: 84");
		
		JLabel label4 = new JLabel("Διάλεξε μια απο τις παρακάτω επιλογές:");

		JButton buttonLd = new JButton("1. Load Data");
		JButton buttonCs = new JButton("2. Check Solution");
		JButton buttonSp = new JButton("3. Solve Problem");
		JButton buttonSa = new JButton("4. Solve All");
		JButton buttonE = new JButton("5. Exit");

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(buttonLd);
		panel.add(buttonCs);
		panel.add(buttonSp);
		panel.add(buttonSa);
		panel.add(buttonE);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Uett Master | Bourazanis Georgios");	
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
		
		int blockSize[] = {100, 500, 200, 300, 600}; 
        int processSize[] = {212, 417, 112, 426}; 
        int m = blockSize.length; 
        int n = processSize.length; 
          
        firstFit(blockSize, m, processSize, n);
        
        Graph Coloring = new Graph();
        /* (3)---(2)
            |   / |
            |  /  |
            | /   |
           (0)---(1)
        */
        int graph[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };
        int gh_gr_col = 3;
        Coloring.graphColoring(graph, gh_gr_col);
	}

	static void firstFit(int blockSize[], int m, int processSize[], int n) { 
        int allocation[] = new int[n]; 
      
        for (int i = 0; i < allocation.length; i++) 
            allocation[i] = -1; 
      
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (blockSize[j] >= processSize[i]) { 
                    allocation[i] = j; 
      
                    blockSize[j] -= processSize[i]; 
      
                    break; 
                } 
            } 
        } 
      
        System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) { 
            System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(""); 
        } 
    } 

}