import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt4;
import org.opencv.core.Size;
import org.opencv.imgproc.*;
import org.opencv.imgcodecs.*;

public class MCScanner
{
   public static void main( String[] args )
   {
	   try{
		   
		   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		   Mat source = Imgcodecs.imread("test_image.jpg", 0);
		   
		   Mat destination = new Mat(source.rows(), source.cols(), source.type());
		   Imgproc.GaussianBlur(source, source, new Size(45, 45), 0);
		   Imgproc.adaptiveThreshold(source, source, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 75,10);
		   Core.bitwise_not(source, source);
		   
		   //Line detection
		   Mat img2 = null;
		   Imgproc.cvtColor(source,img2, Imgproc.COLOR_GRAY2RGB);
		   
		   Mat img3 = null;
		   Imgproc.cvtColor(source,img3, Imgproc.COLOR_GRAY2RGB);
		   
		   MatOfInt4 lines = new MatOfInt4();
		   //Imgproc.HoughLines(img, lines, rho, theta, threshold);
		   
		   //Write to File
		   Imgcodecs.imwrite("gaussian.jpg", source);
		   System.out.println( "Success!");
	   }catch(Exception e){
		   System.out.println("Error has occurred: " + e.getMessage());
	   }
	   
   }
}