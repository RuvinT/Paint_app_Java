
public class Circle implements Shape {

	
	static {
		  System.loadLibrary("CircleDll");
		 }
	
	
	
	private native double[] drawCircleShape();
	@Override
	public double[] draw() {
		double[] cirResults=drawCircleShape();
		
		return cirResults;
		
	}
	

}
