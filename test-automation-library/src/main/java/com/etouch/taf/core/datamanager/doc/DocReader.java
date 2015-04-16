package com.etouch.taf.core.datamanager.doc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hwpf.usermodel.HeaderStories;
import org.apache.poi.hwpf.usermodel.Picture;

import com.etouch.taf.util.LogUtil;

public class DocReader {
	
	/** The Log object **/
	private static Log log = LogUtil.getLog(DocReader.class);
	
	//private String filePath = null;
	private HWPFDocument doc = null;
	
	public DocReader(String filePath)
	{
		try{
				//this.filePath = filePath;
				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
		        this.doc = new HWPFDocument(fs);
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
	}	
	
	
	/*
	 * This method returns the paragraphs from .doc document as a String
	 */
    public String readParagraphs() throws Exception{
    	
    	StringBuffer sb = new StringBuffer();
        WordExtractor we = new WordExtractor(doc);

        /**Get the total number of paragraphs**/
        String[] paragraphs = we.getParagraphText();
        System.out.println("Total Paragraphs: "+paragraphs.length);

        for (int i = 0; i < paragraphs.length; i++) {

            System.out.println("Length of paragraph "+(i +1)+": "+ paragraphs[i].length());
            sb.append(paragraphs[i].toString() + "\n");

        }
        
        return sb.toString();

    }

    /*
     * This method returns the Header from the .doc file.
     */
    public String readHeader(int pageNumber){
    	
    	StringBuffer sb = new StringBuffer();
        HeaderStories headerStore = new HeaderStories( doc);
        String header = headerStore.getHeader(pageNumber);
        sb.append(header);
        return sb.toString();

    }

    /*
     * This method returns the footer from .doc file
     */
    public String readFooter(int pageNumber){
    	StringBuffer sb = new StringBuffer();
        HeaderStories headerStore = new HeaderStories( doc);
        String footer = headerStore.getFooter(pageNumber);
        sb.append(footer);
        
        return sb.toString();

    }
    
    /*
     * This method returns the document summary as a String 
     */
    public String readDocumentSummary() {
    	
    	StringBuffer sb = new StringBuffer();
    	
        DocumentSummaryInformation summaryInfo=doc.getDocumentSummaryInformation();
        String category = summaryInfo.getCategory();
        String company = summaryInfo.getCompany();
        int lineCount=summaryInfo.getLineCount();
        int sectionCount=summaryInfo.getSectionCount();
        int slideCount=summaryInfo.getSlideCount();


    //enter code here
        sb.append("Category: " + category + "\n");
        sb.append("Company: " + company + "\n");
        sb.append("Line Count: " + lineCount + "\n");
        sb.append("Section Count: " + sectionCount + "\n");
        sb.append("Slide Count: " + slideCount);
        
        return sb.toString();

    }
    
    /*
     * This method returns List of images read from the .doc file
     */
    public List<byte[]> readImages(){
    	List<byte[]> result  = new ArrayList<byte[]>(); 
    	
		    try{
		    	
		    	for (Picture picture : doc.getPicturesTable().getAllPictures()) 
		    	{
		             result.add(picture.getContent());
		             System.out.println(picture.getContent());
		    	}
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
    	    	
    	return result;

    }
    
}



