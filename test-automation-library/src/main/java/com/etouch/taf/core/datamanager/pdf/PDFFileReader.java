package com.etouch.taf.core.datamanager.pdf;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PDFFileReader {   
	
	private static Log log = LogUtil.getLog(PDFFileReader.class);
    
    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    public void parsePDFtoText(String pdfFile, String txtFile) throws IOException 
    {
        PdfReader reader = new PdfReader(pdfFile);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        PrintWriter out = new PrintWriter(new FileOutputStream(txtFile));
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            out.println(strategy.getResultantText());
        }
        out.flush();
        out.close();
        reader.close();
    }
    
    /**
     * Parses a PDF and returns a String.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    public String parsePdf(String pdfFile) throws IOException
    {
    	
        PdfReader reader = new PdfReader(pdfFile);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        StringBuffer sb = new StringBuffer();
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            sb.append(strategy.getResultantText());
        }       
        reader.close();
        
        return sb.toString();
    }
    
    /**
     * Extracts images from a PDF file.   
     *
     * Parses a PDF and extracts all the images.
     * @param src the source PDF
     * @param dest the resulting PDF
     */
    public void extractImages(String fileName, String destPath)
        throws IOException, DocumentException {
        PdfReader reader = new PdfReader(fileName);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        ImageRenderListener listener = new ImageRenderListener(destPath);
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            parser.processContent(i, listener);
        }
        reader.close();
    }   
    
}