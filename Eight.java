
public class Eight implements Shape {

	
	static {
		  System.loadLibrary("EightDll");
		 }
	
	
	
	private native double[] drawEightShape();
	@Override
	public double[] draw() {
		double[] eigResults=drawEightShape();
		
		return eigResults;
		
	}
	

}
