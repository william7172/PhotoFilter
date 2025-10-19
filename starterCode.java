package PhotoFilters;
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
 
/**
 * Author: Will
 * Date: Nov 12 2024
 * Project: Photo Filters
 * Description: This program applies various filters to an image, including color inversion, grayscale, 
 * sepia tone, and color enhancements. Each method processes the image and saves the output to a specified path.
 */

public class starterCode {

 
	
	
public static void main(String[] args) { 
	getInverted();  // Call the method to generate the different filter image
	} 
//Method to invert colors of an image by reversing the RGB values
public static void getInverted() {
try {//import the file picture
         File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
         BufferedImage image = ImageIO.read(input);
         int x = 10;
         int y =20;
      // Loop through each pixel and invert the colors
	 for(x = 0; x < image.getWidth(); x++) {
		 for(y =0; y< image.getHeight(); y++) {
			 int pixel = image.getRGB(x, y);
	         int alpha = (pixel >> 24) & 0xff;
	         int red = (pixel >> 16) & 0xff;
	         int green = (pixel >> 8) & 0xff;
	         int blue = pixel & 0xff;

	         int new_alpha = 255; 
	         int new_red = 255 - red; 
	         int new_green = 255 - green; 
	         int new_blue =255 - blue; 
	         int newPixel = (new_alpha << 24) | (new_red << 16) | (new_green << 8) | new_blue;
	         image.setRGB(x,y,newPixel); 
		 }
	 }
	 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/inverted_chicken.png"; 
	 File output = new File(outputPath); 
	 ImageIO.write(image, "png", output); 
	 System.out.println("Output file created at: " + outputPath);
 } catch (IOException e) {
     e.printStackTrace();}
 }

//}

public static void getBlackAndWhite() {
	try {
		//Converts the image to black and white based on an average brightness threshold.
		 File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
         BufferedImage image= ImageIO.read(input);
         int x = 10;
         int y =20;
         
	// loop and convert each pixel to black or white based on brightness
	for(x = 0; x < image.getWidth(); x++) {
		for(y =0; y< image.getHeight(); y++) {
			 int pixel = image.getRGB(x, y);
	         int alpha = (pixel >> 24) & 0xff;
	         int red = (pixel >> 16) & 0xff;
	         int green = (pixel >> 8) & 0xff;
	         int blue = pixel & 0xff;
	         
	     int Ave = (red + green + blue)/3;
	     if(Ave < 128) {
	    	 red = 0;
	    	 green = 0;
	    	 blue = 0; // Set to black
	     }
	     else {
	    	 red = 255;
	    	 green = 255;
	    	 blue = 255;// Set to white
	     }
	     int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
         image.setRGB(x, y, newPixel);
		 }
	 }
	 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/getBlackAndWhite_chicken.png"; 
	 File output = new File(outputPath); 
	 ImageIO.write(image, "png", output); 
} catch (IOException e) {
    e.printStackTrace();
}
}

public static void grayscale() {
	try {
		//Converts the image to grayscale by setting the RGB values to the average brightness.
		File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
        BufferedImage image= ImageIO.read(input);
        int x = 10;
        int y =20;
	//loop and set every pixel RGB to average brightness for grayscale
	for(x = 0; x< image.getWidth(); x++) {
		for(y =0; y< image.getHeight(); y++) {
			int pixel = image.getRGB(x, y);
	        int alpha = (pixel >> 24) & 0xff;
	        int red = (pixel >> 16) & 0xff;
	        int green = (pixel >> 8) & 0xff;
	        int blue = pixel & 0xff;
	       int Ave = (red + green + blue)/3;
	       red = Ave;
	       green = Ave;
	       blue = Ave;
	       int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
	       image.setRGB(x, y, newPixel);
		}
	 }
	 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/grayscale_chicken.png"; 
	 File output = new File(outputPath); 
	 ImageIO.write(image, "png", output); 
} catch (IOException e) {
   e.printStackTrace();
}
}
//
//
//
//Applies a sepia tone to the image for a vintage effect.
public static void sepia() {
	try {
		File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
        BufferedImage image= ImageIO.read(input);
        int x = 10;
        int y =20;
	//loop each pixel and adjust colors for sepia effect;
	for(x= 0; x < image.getWidth(); x++) {
		for(y =0; y< image.getHeight(); y++) {
			int pixel = image.getRGB(x, y);
	        int alpha = (pixel >> 24) & 0xff;
	        int red = (pixel >> 16) & 0xff;
	        int green = (pixel >> 8) & 0xff;
	        int blue = pixel & 0xff;
	       int Ave = (red + green + blue)/3;
	       red = Ave;
	       green = Ave;
	       blue = Ave;
	       
	      if(red < 63) {
	    	  red = (int)1.1*red;
	    	  blue = (int)0.9*blue;
	      }
	      else if(red <192) {
	    	  red = (int)1.5*red;
	    	  blue = (int)0.85*blue;
	      }
	      int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
          image.setRGB(x, y, newPixel);
		}
	 }
	 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/sepia_chicken.png"; 
	 File output = new File(outputPath); 
	 ImageIO.write(image, "png", output); 
} catch (IOException e) {
  e.printStackTrace();
}
}
// 
//Applies a red color filter to enhance red tones in the image.
public static void colorFilterRed() {
	try {
		File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
        BufferedImage image= ImageIO.read(input);
        int x = 10;
        int y =20;
        //loop and converts it to red for each pixel
        for(x= 0; x < image.getWidth(); x++) {
    		for(y =0; y< image.getHeight(); y++) {
    			int pixel = image.getRGB(x, y);
    	        int alpha = (pixel >> 24) & 0xff;
    	        int red = (pixel >> 16) & 0xff;
    	        int green = (pixel >> 8) & 0xff;
    	        int blue = pixel & 0xff;
    	        
    	        if(red < 215) {
    	        	red = red + 40;
    	        }
    	        else {
    	        	red = 255;
    	        }
    	        int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
    	          image.setRGB(x, y, newPixel);
    			}
    		 }
    		 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/colorFilterRed_chicken.png"; 
    		 File output = new File(outputPath); 
    		 ImageIO.write(image, "png", output); 
    	} catch (IOException e) {
    	  e.printStackTrace();
    	}
    	}
// Applies a blue color filter to enhance blue tones in the image.
public static void colorFilterBlue() {
	try {
		File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
        BufferedImage image= ImageIO.read(input);
        int x = 10;
        int y =20;
      //loop and converts it to blue for each pixel
        for(x= 0; x < image.getWidth(); x++) {
    		for(y =0; y< image.getHeight(); y++) {
    			int pixel = image.getRGB(x, y);
    	        int alpha = (pixel >> 24) & 0xff;
    	        int red = (pixel >> 16) & 0xff;
    	        int green = (pixel >> 8) & 0xff;
    	        int blue = pixel & 0xff;
    	        
    	        if(blue < 215) {
    	        	blue = blue + 40;
    	        }
    	        else {
    	        	blue = 255;
    	        }
    	        int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
    	          image.setRGB(x, y, newPixel);
    			}
    		 }
    		 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/colorFilterBlue.png"; 
    		 File output = new File(outputPath); 
    		 ImageIO.write(image, "png", output); 
	} catch (IOException e) {
  	  e.printStackTrace();
  	}
  	}
public static void colorFilterGreen() {
	// Applies a green color filter to enhance green tones in the image.
	try {
		File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
        BufferedImage image= ImageIO.read(input);
        int x = 10;
        int y =20;
      //loop and converts it to green for each pixel
        for(x= 0; x < image.getWidth(); x++) {
    		for(y =0; y< image.getHeight(); y++) {
    			int pixel = image.getRGB(x, y);
    	        int alpha = (pixel >> 24) & 0xff;
    	        int red = (pixel >> 16) & 0xff;
    	        int green = (pixel >> 8) & 0xff;
    	        int blue = pixel & 0xff;
    	        
    	        if(green < 215) {
    	        	green = green + 40;
    	        }
    	        else {
    	        	green = 255;
    	        }
    	        int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
    	          image.setRGB(x, y, newPixel);
    			}
    		 }
    		 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/colorFilterGreen.png"; 
    		 File output = new File(outputPath); 
    		 ImageIO.write(image, "png", output); 
	} catch (IOException e) {
  	  e.printStackTrace();
  	}
  	}
 public static void enhanceRedGreen() {
	 try {
		 // create a image that enhance the color of red and green and keep blue the same
		 File input = new File("/Users/william/Desktop/Data structure/PhotoFilters/images/chicken.png");
	        BufferedImage image= ImageIO.read(input);
	        int x = 10;
	        int y =20;
	        //loop every pixel and converts to mainly green and red and keep the blue
	        for(x= 0; x < image.getWidth(); x++) {
	        	for(y =0; y< image.getHeight(); y++) {
	        		int pixel = image.getRGB(x, y);
	    	        int alpha = (pixel >> 24) & 0xff;
	    	        int red = (pixel >> 16) & 0xff;
	    	        int green = (pixel >> 8) & 0xff;
	    	        int blue = pixel & 0xff;
	    	        red = red + 50;
	    	        green =green + 30;
	    	        
	    	        int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
	    	          image.setRGB(x, y, newPixel);
	    			}
	    		 }
	    		 String outputPath = "/Users/william/Desktop/Data structure/PhotoFilters/images/enhanceRedGreen_chicken.png"; 
	    		 File output = new File(outputPath); 
	    		 ImageIO.write(image, "png", output); 
		} catch (IOException e) {
	  	  e.printStackTrace();
	  	}
	  	}
// 
 
 }
