import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
		jf.setSize(1000,1000);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.add(t);
		
		
	}

}
