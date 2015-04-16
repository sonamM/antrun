package com.etouch.taf.core.datamanager.pdf;
/*
 * This class is used to create a pdf file with selected images.
 */
//import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
 

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.Barcode;
//import com.itextpdf.text.pdf.BarcodeEAN;
//import com.itextpdf.text.pdf.BarcodePDF417;
import com.itextpdf.text.pdf.PdfWriter;
 
public class PDFCreator {  
	
		private static Log log = LogUtil.getLog(PDFCreator.class);
   
 
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String[] imgResource, String imgSourcePath, String filename) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        // Adding a series of images
        Image img;
        
        for (int i = 0; i < imgResource.length; i++) {
            img = Image.getInstance(String.format(imgSourcePath +"\\%s", imgResource[i]));
            if (img.getScaledWidth() > 300 || img.getScaledHeight() > 300) {
                img.scaleToFit(300, 300);
            }
            document.add(new Paragraph(
                    String.format("%s is an image of type %s", imgResource[i], img.getClass().getName())));
            document.add(img);
        }
        
        // Adding a java.awt.Image
        /*java.awt.Image awtImage = Toolkit.getDefaultToolkit().createImage(RESOURCE);
        img = com.itextpdf.text.Image.getInstance(awtImage, null);
        document.add(new Paragraph(
                String.format("%s is an image of type %s", "java.awt.Image", img.getClass().getName())));
        document.add(img);
        // Adding a barcode
        BarcodeEAN codeEAN = new BarcodeEAN();
        codeEAN.setCodeType(Barcode.EAN13);
        codeEAN.setCode("9781935182610");
        img = codeEAN.createImageWithBarcode(writer.getDirectContent(), null, null);
        document.add(new Paragraph(
                String.format("%s is an image of type %s", "barcode", img.getClass().getName())));
        document.add(img);
        // Adding a matrix code
        BarcodePDF417 pdf417 = new BarcodePDF417();
        String text = "iText in Action, a BOOK by Bruno Lowagie.";
        pdf417.setText(text);
        img = pdf417.getImage();
        document.add(new Paragraph(
                String.format("%s is an image of type %s", "barcode", img.getClass().getName())));
        document.add(img);*/
 
        // step 5
        document.close();
    }
   
}
