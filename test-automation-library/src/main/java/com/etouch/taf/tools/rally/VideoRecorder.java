package com.etouch.taf.tools.rally;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import com.etouch.taf.util.LogUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class VideoRecorder.
 */
public class VideoRecorder {
	
	/** The log. */
	static Log log = LogUtil.getLog(VideoRecorder.class);
	
	/** The screen recorder. */
	private ScreenRecorder screenRecorder;
	
	private String videoPath;

	/**
	 * Instantiates a new video recorder.
	 *
	 * @param videoFilePath the video file path
	 */
	public VideoRecorder(String videoFilePath)
	{
		try{
				this.videoPath = videoFilePath;
				File videoFolder = new File(videoFilePath); 
		        GraphicsConfiguration gc = GraphicsEnvironment
		           .getLocalGraphicsEnvironment()
		           .getDefaultScreenDevice()
		           .getDefaultConfiguration();
				
				  this.screenRecorder = new ScreenRecorder(gc,null,
			           	  new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
			              new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
			                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
			                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
			                    QualityKey, 1.0f,
			                    KeyFrameIntervalKey, 15 * 60),
			               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
			                    FrameRateKey, Rational.valueOf(30)),
			               null,videoFolder);
		   }catch(AWTException e){
			   log.error(e.getMessage()); 
           }
		catch(IOException e)
        {
			log.error(e.getMessage());
        }

	}
	
	/**
	 * Gets the screen recorder.
	 *
	 * @return the screen recorder
	 */
	public ScreenRecorder getScreenRecorder() {
		return screenRecorder;
	}

	/**
	 * Sets the screen recorder.
	 *
	 * @param screenRecorder the new screen recorder
	 */
	public void setScreenRecorder(ScreenRecorder screenRecorder) {
		this.screenRecorder = screenRecorder;
	}
	
	/**
	 * Start recording.
	 */
	public void startRecording() 
       {
	    try{ 
           	 this.screenRecorder.start();
           	 	
           }catch(IOException e)
	        {
        	   log.error(e.getMessage());
	        }
       }
 
    /**
   	 * Stop recording.
   	 */
   	public void stopRecording() 
       {
    	 try{
    		 	this.screenRecorder.stop();
    		 	
    	 	}catch(Exception e)
    	 	{
    	 		log.error(e.getMessage());
    	 	}
       }
   	
   	
   	public void deleteRecording() {
		
		//File directory = new File("..\\AmazonPOC\\src\\test\\resources\\testdata\\videos");   		
		File fileToBeDeleted = pickLatestVideoFile(videoPath);
		fileToBeDeleted.delete();
		
	}
   	
   	
   	public String getVideoLink()
   	{
   		String videoFileName = pickLatestVideoFile(videoPath).getName();
   		String videoLink = "http://localhost:8080/" + videoFileName ;
   		return videoLink;
   	}
   	
    
		private File pickLatestVideoFile(String videoPath2) {
			File directory = new File(videoPath);
			File[] files = directory.listFiles();

			Arrays.sort(files, new Comparator<File>(){
			    public int compare(File f1, File f2)
			    {
			        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
			    } });
			return files[files.length-1];
	}

		/**
		 * Creates the screenshot.
		 *
		 * @param imagePath the image path
		 * @param imgName the img name
		 * @return the screenshot
		 */
		public void createScreenshot(String imagePath, String imgName) {
			try{
			       // Thread.sleep(10000);
			        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			        ImageIO.write(image, "jpg", new File(imagePath + File.separator + imgName + ".png"));
			       // ImageIO.write(image, "jpg", new File("..\\AmazonPOC\\src\\test\\resources\\testdata\\screenshots\\sample2.png"));
				      
		    	}catch(IOException e){
		    		log.error(e.getMessage());
		    		
		        }catch(AWTException e){
		        	log.error(e.getMessage());		     	   	
		        }
		    }  	
   	

}
