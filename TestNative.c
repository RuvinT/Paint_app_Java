#include <jni.h>
#include <stdio.h>

#include <math.h>
#include <windows.h>
#include "simsen_simapi_TestNative.h"
#define PI 3.14159265
double cirDegrees=0.0;
double eigDegrees=0.0;
double groDegrees=0.0;
double	 groX=100.0;
double	 groY=100.0;
double mouseY=0.0;
double mouseX=0.0;
JNIEXPORT jdoubleArray JNICALL Java_simsen_simapi_TestNative_drawCircleShape(JNIEnv *env, jobject obj)

{
    
	jdouble	 cirX=(jdouble)500+100.0*sin(cirDegrees* PI / 180.0);
	jdouble	 cirY=(jdouble)500+100.0*cos(cirDegrees* PI / 180.0);
 
    cirDegrees=cirDegrees+1;
 
   
 
   jdouble outCArray[] = {cirX, cirY};
 
   //  Convert the C's Native jdouble[] to JNI jdoublearray, and return
   jdoubleArray outJNIArray = (*env)->NewDoubleArray(env, 2);  // allocate
   if (NULL == outJNIArray) return NULL;
   (*env)->SetDoubleArrayRegion(env, outJNIArray, 0 , 2, outCArray);  // copy
   return outJNIArray;

}

JNIEXPORT jdoubleArray JNICALL 
Java_simsen_simapi_TestNative_drawEightShape(JNIEnv *env, jobject obj)

{
    
    jdouble	 eigX;
    jdouble	 eigY;
   	if(eigDegrees<=180) {
			 eigX=(jdouble)500-100.0*cos(eigDegrees* PI / 180.0);
			 eigY=(jdouble)200-100.0*sin(eigDegrees* PI / 180.0);
			
			
		}else if(eigDegrees<=360) {
				
				 eigX=(jdouble)700+100.0*cos(eigDegrees* PI / 180.0);
				 eigY=(jdouble)200-100.0*sin(eigDegrees* PI / 180.0);
				
		}else if(eigDegrees<=540) {
				 eigX=(jdouble)700+100.0*cos(eigDegrees* PI / 180.0);
				 eigY=(jdouble)200-100.0*sin(eigDegrees* PI / 180.0);	
				
				
				
			}else {
				 eigX=(jdouble)500-100.0*cos(eigDegrees* PI / 180.0);
				 eigY=(jdouble)200-100.0*sin(eigDegrees* PI / 180.0);	
				
			}
			
			 eigDegrees=eigDegrees+1;
			 if(eigDegrees>720) {eigDegrees=0.0;}
   
 
   jdouble outCArray1[] = {eigX, eigY};
 
   //  Convert the C's Native jdouble[] to JNI jdoublearray, and return
   jdoubleArray outJNIArray1 = (*env)->NewDoubleArray(env, 2);  // allocate
   if (NULL == outJNIArray1) return NULL;
   (*env)->SetDoubleArrayRegion(env, outJNIArray1, 0 , 2, outCArray1);  // copy
   return outJNIArray1;

}



JNIEXPORT jdoubleArray JNICALL 
Java_simsen_simapi_TestNative_drawGroundShape(JNIEnv *env, jobject obj)

{
    

    
    
 
   if((groX<300)&&(groY<=100) ) {groX=groX+2;}
		else if((groX<=350)&&(groX>=300)){
			
			 groX=(jdouble)300+50.0*sin(groDegrees* PI / 180.0);
			 groY=(jdouble)150-50.0*cos(groDegrees* PI / 180.0);
			 groDegrees=groDegrees+1;
		}else if((groX>100)&&(groX<=300)&&(groY>100)&&(groY<200)) {groX=groX-2;
			
			
		}else if((groX<=100)) {
			
			 groX=(jdouble)100+50.0*sin(groDegrees* PI / 180.0);
			 groY=(jdouble)150-50.0*cos(groDegrees* PI / 180.0);
			 groDegrees=groDegrees+1;
		}
		if(groDegrees>360){groDegrees=0.0;}
 
   jdouble outCArray2[] = {groX, groY};
 
   //  Convert the C's Native jdouble[] to JNI jdoublearray, and return
   jdoubleArray outJNIArray2 = (*env)->NewDoubleArray(env, 2);  // allocate
   if (NULL == outJNIArray2) return NULL;
   (*env)->SetDoubleArrayRegion(env, outJNIArray2, 0 , 2, outCArray2);  // copy
   return outJNIArray2;

}


JNIEXPORT jdoubleArray JNICALL Java_simsen_simapi_TestNative_movePointer
  (JNIEnv *env, jobject obj, jdouble mouseFirstX  , jdouble mouseFirstY, jdouble mouseNextX, jdouble mouseNextY,jboolean newPoint)
{

  if(mouseFirstX<mouseNextX) {
         		
					if(((int)mouseX<(int)mouseNextX)&&(newPoint)) {
			 			
						  mouseY=((mouseFirstY-mouseNextY)/(mouseFirstX-mouseNextX))*(mouseX-mouseNextX)+mouseNextY	;		
									
						mouseX=mouseX+1.0;		
						
						
						
					}
					
		        }else if(mouseFirstX>=mouseNextX) {
		        	
		        	if(((int)mouseX>(int)mouseNextX)&&(newPoint)) {
			 			
						  mouseY=((mouseFirstY-mouseNextY)/(mouseFirstX-mouseNextX))*(mouseX-mouseNextX)+mouseNextY	;		
									
						mouseX=mouseX-1.0;		
						
						
						
					}
		        	
		        }
		        
		        
		        jdouble outCArray3[] = {mouseX, mouseY};
 
   //  Convert the C's Native jdouble[] to JNI jdoublearray, and return
   jdoubleArray outJNIArray3 = (*env)->NewDoubleArray(env, 2);  // allocate
   if (NULL == outJNIArray3) return NULL;
   (*env)->SetDoubleArrayRegion(env, outJNIArray3, 0 , 2, outCArray3);  // copy
   return outJNIArray3;
		 
}
