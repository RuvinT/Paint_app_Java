import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;




public class TutorialTest extends JPanel implements ActionListener {
	static {
		  System.loadLibrary("ProFin");
		 }
double mouseFirstX=0,mouseFirstY=0;
double mouseNextX=1, mouseNextY=1;
double mouseX=0, mouseY=0;
boolean newPoint=false;
public TutorialTest() {
	
	addMouseListener(new MouseAdapter() {
		
		public void mousePressed(MouseEvent e) {
			
			
			mouseFirstX=mouseNextX;
			mouseFirstY=mouseNextY;
			
			mouseNextX=e.getX();
			mouseNextY=e.getY();
			
			
		newPoint=true;		
			
		}
	});
	
}



	
	
	

	 private native double[] movePointer(double mouseFirstX,double mouseFirstY,double mouseNextX,double mouseNextY,boolean newPoint );
	Timer tm= new Timer(20,this);
	double groX=100,groY=100;
	double cirX=500,cirY=400;
	double eigX=500,eigY=400;
	public void paintComponent(Graphics g) {
	
	
	super.paintComponent(g);
	g.setColor(Color.RED);
	
	g.fillOval((int)groX,(int)groY, 15, 15);
	g.setColor(Color.BLACK);
	g.fillOval((int)cirX,(int)cirY, 15, 15);
	g.setColor(Color.BLUE);
	g.fillOval((int)eigX,(int)eigY, 15, 15);
	g.setColor(Color.CYAN);
	g.fillOval((int)mouseX,(int)mouseY, 15, 15);
	
	g.setColor(Color.black);
	//g.drawPolygon(poly);
	g.drawOval(400, 400, 200, 200);
	g.drawOval(400, 100, 200, 200);
	g.drawOval(600, 100, 200, 200);
	g.drawArc(250, 100, 100, 100, 270, 180);
	g.drawLine(100, 100, 300, 100);
	g.drawArc(50, 100, 100, 100, 90, 180);
	g.drawLine(100, 200, 300, 200);
	
	tm.start();
  
	}
	public void actionPerformed(ActionEvent e) {
		
		//code for circle
		double[] cirResults=new Circle().draw();
		//System.out.println("java output"+cirResults);
		cirX=cirResults[0];
		cirY=cirResults[1];
		
		//code for 8
		
			 double[] eigResults=new Eight().draw();
				//System.out.println("java output"+cirResults);
				eigX=eigResults[0];
				eigY=eigResults[1];
	
		//code for ground shape
			
				 double[] groResults=new Ground().draw();
					//System.out.println("java output"+cirResults);
					groX=groResults[0];
					groY=groResults[1];		
		//point mover
		      			
		double[] poiResults=movePointer(mouseFirstX,mouseFirstY, mouseNextX, mouseNextY ,newPoint);		
		
	//	System.out.println("bool"+newPoint);
	//	System.out.println("mouseX"+mouseX);
		
		mouseX=poiResults[0];
		mouseY=poiResults[1];
		repaint();
		
		
			
		
		
	}
	
	
	public static void main(String[] args) {
		
		//System.out.println(System.getProperty("java.library.path"));
		TutorialTest t=new TutorialTest();
			
		JFrame jf =new JFrame();
		jf.setTitle("test");
		jf.setSize(1000,700);
		jf.setVisible(true);
		JPanel panel = new JPanel();
		panel.setSize(50, 50);
		
	    JButton button = new JButton("Change Speed");
	    panel.add(button, BorderLayout.CENTER);
	    
	    
	    
	    
	    JTextField text=new JTextField("give a number");
	   
	    panel.add(text, BorderLayout.EAST);
		
		
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		jf.add(t,BorderLayout.CENTER);
		jf.add(panel,BorderLayout.PAGE_END);
		
		jf.setVisible(true);
		
		
		button.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	
		    	String s=text.getText();  
		         int speed=Integer.parseInt(s);
		         System.out.print(speed);
		       
		       t.tm.setDelay(speed);
		        
		    }
		});
		
	}

}
