
public class Ground implements Shape {

	
	static {
		  System.loadLibrary("GroundDll");
		 }
	
	
	
	private native double[] drawGroundShape();
	@Override
	public double[] draw() {
		double[] groResults=drawGroundShape();
		
		return groResults;
		
	}
	

}
