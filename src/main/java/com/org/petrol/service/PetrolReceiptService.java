///**
// * 
// */
//package com.org.petrol.service;
//
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.InputStream;
//
//import javax.imageio.ImageIO;
//
//import org.springframework.stereotype.Service;
//
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.io.image.ImageDataFactory;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.borders.Border;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.element.Image;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.properties.HorizontalAlignment;
//import com.itextpdf.layout.properties.TextAlignment;
//import com.itextpdf.layout.properties.UnitValue;
//import com.org.petrol.dto.PetrolReceiptDto;
//
///**
// * 
// */
//@Service
//public class PetrolReceiptService {
//
//    public String generateAndSaveReceiptPdf(PetrolReceiptDto dto) {
////        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
////            PdfWriter writer = new PdfWriter(out);
////            PdfDocument pdf = new PdfDocument(writer);
////            Document document = new Document(pdf);
////
////            PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
////            document.setFont(font).setFontSize(10);
////
////            // Bharat Petroleum logo (make sure file exists)
////            String logoPath = "src/main/resources/bharat_petroleum_logo.png";
//////            Image logo = new Image(ImageDataFactory.create(logoPath))
//////                    .scaleToFit(50, 50)
//////                    .setHorizontalAlignment(HorizontalAlignment.CENTER);
////            InputStream imageStream = getClass().getClassLoader().getResourceAsStream("bharat_petroleum_logo.png");
////
////            if (imageStream != null) {
////                Image logo = new Image(ImageDataFactory.create(imageStream.readAllBytes()))
////                    .scaleToFit(50, 50)
////                    .setHorizontalAlignment(HorizontalAlignment.CENTER);
////                document.add(logo);
////            } else {
////                System.out.println("Logo not found in classpath!");
////            }
////           // document.add(logo);
////
////            // Fuel station header
////            document.add(new Paragraph("SRI LATHA FUEL ALLEY").setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("102, KAMARAJAR NEDUNA SALAI, PERUNKALATHUR\nCHENNAI - 600063")
////                    .setTextAlignment(TextAlignment.CENTER));
////
////            document.add(new Paragraph("---------------------------------------"));
////
//////            document.add(new Paragraph("INV NO.    : " + dto.getInvoiceNo()));
//////            document.add(new Paragraph("RECEIPT    : " + dto.getReceiptType()));
//////            document.add(new Paragraph("VEH NO.    : " + dto.getVehicleNo()));
//////            document.add(new Paragraph("MOB. NO    : " + dto.getMobileNo()));
//////            document.add(new Paragraph("DATE       : " + dto.getDate()));
//////            document.add(new Paragraph("TIME       : " + dto.getTime()));
//////            document.add(new Paragraph("NZ NO.     : " + dto.getNzNo()));
//////            document.add(new Paragraph("PRODUCT    : " + dto.getProduct()));
//////            document.add(new Paragraph("RATE       : Rs. " + String.format("%.2f", dto.getRate())));
//////
//////            document.add(new Paragraph("---------------------------------------"));
//////            document.add(new Paragraph("AMOUNT     : Rs. " + String.format("%.2f", dto.getAmount())));
//////            document.add(new Paragraph("VOLUME     : " + String.format("%.2f", dto.getVolume()) + "L"));
//////            document.add(new Paragraph("---------------------------------------"));
////            
////            document.add(new Paragraph("INV NO.    : " + dto.getInvoiceNo()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("RECEIPT    : " + dto.getReceiptType()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("VEH NO.    : " + dto.getVehicleNo()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("MOB. NO    : " + dto.getMobileNo()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("DATE       : " + dto.getDate()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("TIME       : " + dto.getTime()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("NZ NO.     : " + dto.getNzNo()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("PRODUCT    : " + dto.getProduct()).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("RATE       : Rs. " + String.format("%.2f", dto.getRate())).setTextAlignment(TextAlignment.CENTER));
////
////            document.add(new Paragraph("---------------------------------------").setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("AMOUNT     : Rs. " + String.format("%.2f", dto.getAmount())).setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("VOLUME     : " + String.format("%.2f", dto.getVolume()) + "L").setTextAlignment(TextAlignment.CENTER));
////            document.add(new Paragraph("---------------------------------------").setTextAlignment(TextAlignment.CENTER));
////
////
////            document.close();
////            return new ByteArrayInputStream(out.toByteArray());
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
//    	try {
//            // Folder where PDF will be saved
//            String outputDir = "C:/Users/Z044645/Documents/petrol-receipts/";  // Windows example
//            // String outputDir = "/home/veera/petrol-receipts/";  // Linux example
//
//            // Create directory if it doesn’t exist
//            File dir = new File(outputDir);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            // Dynamic file name
//            String fileName = "receipt_" + dto.getInvoiceNo().replaceAll("[^a-zA-Z0-9]", "_") + ".pdf";
//            String filePath = outputDir + fileName;
//
//            PdfWriter writer = new PdfWriter(filePath);
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf);
//            String format = "%-12s: %s";
//
//            PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
//            document.setFont(font).setFontSize(10);
//
//            // Logo (optional)
//            InputStream imageStream = getClass().getClassLoader().getResourceAsStream("bharat_petroleum_logo.png");
//            if (imageStream != null) {
////                byte[] imageBytes = imageStream.readAllBytes();
////                Image logo = new Image(ImageDataFactory.create(imageBytes))
////                        .scaleToFit(50, 50)
////                        .setHorizontalAlignment(HorizontalAlignment.CENTER);
////            	 BufferedImage colorImage = ImageIO.read(imageStream);
////
////            	    // Convert to grayscale
////            	    BufferedImage grayImage = new BufferedImage(
////            	            colorImage.getWidth(), colorImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
////
////            	    Graphics2D g = grayImage.createGraphics();
////            	    g.drawImage(colorImage, 0, 0, null);
////            	    g.dispose();
////
////            	    // Convert to byte array
////            	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
////            	    ImageIO.write(grayImage, "png", baos);
////
////            	    Image logo = new Image(ImageDataFactory.create(baos.toByteArray()))
////            	            .scaleToFit(50, 50)
////            	            .setHorizontalAlignment(HorizontalAlignment.CENTER);
////            	   BufferedImage original = ImageIO.read(imageStream);
////
////            	    // Create a new image with white background and same size
////            	    BufferedImage noTransparency = new BufferedImage(
////            	            original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB); // ❗ TYPE_INT_RGB = no alpha
////
////            	    Graphics2D g2d = noTransparency.createGraphics();
////
////            	    // Fill with white background
////            	    g2d.setColor(java.awt.Color.WHITE);
////            	    g2d.fillRect(0, 0, noTransparency.getWidth(), noTransparency.getHeight());
////
////            	    // Draw original image on top
////            	    g2d.drawImage(original, 0, 0, null);
////            	    g2d.dispose();
////
////            	    // Convert to grayscale
////            	    BufferedImage gray = new BufferedImage(noTransparency.getWidth(), noTransparency.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
////            	    Graphics2D grayGraphics = gray.createGraphics();
////            	    grayGraphics.drawImage(noTransparency, 0, 0, null);
////            	    grayGraphics.dispose();
////
////            	    // Convert to byte array
////            	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
////            	    ImageIO.write(gray, "png", baos);
////
////            	    Image logo = new Image(ImageDataFactory.create(baos.toByteArray()))
////            	            .scaleToFit(50, 50)
////            	            .setHorizontalAlignment(HorizontalAlignment.CENTER);
//            	BufferedImage original = ImageIO.read(imageStream);
//
//                BufferedImage noTransparency = new BufferedImage(
//                    original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
//                Graphics2D g2d = noTransparency.createGraphics();
//                g2d.setColor(java.awt.Color.WHITE);
//                g2d.fillRect(0, 0, noTransparency.getWidth(), noTransparency.getHeight());
//                g2d.drawImage(original, 0, 0, null);
//                g2d.dispose();
//
//                BufferedImage gray = new BufferedImage(noTransparency.getWidth(), noTransparency.getHeight(),
//                        BufferedImage.TYPE_BYTE_GRAY);
//                Graphics2D grayGraphics = gray.createGraphics();
//                grayGraphics.drawImage(noTransparency, 0, 0, null);
//                grayGraphics.dispose();
//
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ImageIO.write(gray, "png", baos);
//
//                Image logo = new Image(ImageDataFactory.create(baos.toByteArray()))
//                        .scaleToFit(50, 50)
//                        .setHorizontalAlignment(HorizontalAlignment.CENTER)
//                        .setMarginBottom(10);
//                document.add(logo);
//            }
//
//         // Header
//            document.add(new Paragraph("SRI LATHA FUEL ALLEY").setTextAlignment(TextAlignment.CENTER).setBold());
//            document.add(new Paragraph("102, KAMARAJAR NEDUNA SALAI, PERUNKALATHUR\nCHENNAI - 600063")
//                    .setTextAlignment(TextAlignment.CENTER));
//            document.add(new Paragraph("---------------------------------------").setTextAlignment(TextAlignment.CENTER));
//
//            // Table for fields
//            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2}))
//                    .useAllAvailableWidth()
//                    .setFontSize(10);
////
////            table.addCell(new Cell().add("INV NO.").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getInvoiceNo()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("RECEIPT").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getReceiptType()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("VEH NO.").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getVehicleNo()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("MOB. NO").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getMobileNo()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("DATE").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getDate()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("TIME").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getTime()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("NZ NO.").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getNzNo()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("PRODUCT").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(dto.getProduct()).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("RATE").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add("Rs. " + String.format("%.2f", dto.getRate())).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell(1, 2).add("---------------------------------------")
////                    .setBorder(Border.NO_BORDER)
////                    .setTextAlignment(TextAlignment.CENTER));
////
////            table.addCell(new Cell().add("AMOUNT").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add("Rs. " + String.format("%.2f", dto.getAmount())).setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell().add("VOLUME").setBorder(Border.NO_BORDER));
////            table.addCell(new Cell().add(String.format("%.2f", dto.getVolume()) + "L").setBorder(Border.NO_BORDER));
////
////            table.addCell(new Cell(1, 2).add("---------------------------------------")
////                    .setBorder(Border.NO_BORDER)
////                    .setTextAlignment(TextAlignment.CENTER));
//            
//            
//            
//            table.addCell(new Cell().add(new Paragraph("INV NO.")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getInvoiceNo())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("RECEIPT")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getReceiptType())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("VEH NO.")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getVehicleNo())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("MOB. NO")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getMobileNo())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("DATE")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getDate())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("TIME")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getTime())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("NZ NO.")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getNzNo())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("PRODUCT")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(dto.getProduct())).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("RATE")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph("Rs. " + String.format("%.2f", dto.getRate()))).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell(1, 2).add(new Paragraph("---------------------------------------"))
//                    .setBorder(Border.NO_BORDER)
//                    .setTextAlignment(TextAlignment.CENTER));
//
//            table.addCell(new Cell().add(new Paragraph("AMOUNT")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph("Rs. " + String.format("%.2f", dto.getAmount()))).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell().add(new Paragraph("VOLUME")).setBorder(Border.NO_BORDER));
//            table.addCell(new Cell().add(new Paragraph(String.format("%.2f", dto.getVolume()) + "L")).setBorder(Border.NO_BORDER));
//
//            table.addCell(new Cell(1, 2).add(new Paragraph("---------------------------------------"))
//                    .setBorder(Border.NO_BORDER)
//                    .setTextAlignment(TextAlignment.CENTER));
//
//
//            document.add(table);
//
//            document.close();
//            return "Saved successfully: " + filePath;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error while generating PDF: " + e.getMessage();
//        }
//    }
//}

package com.org.petrol.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.org.petrol.dto.PetrolReceiptDto;

@Service
public class PetrolReceiptService {

    public String generateAndSaveReceiptPdf(PetrolReceiptDto dto) {
        try {
            // Output folder
            String outputDir = "C:/Users/Z044645/Documents/petrol-receipts/";
            File dir = new File(outputDir);
            if (!dir.exists()) dir.mkdirs();

            // File path
            String fileName = "receipt_" + dto.getInvoiceNo().replaceAll("[^a-zA-Z0-9]", "_") + ".pdf";
            String filePath = outputDir + fileName;

            // PDF Writer & Document
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Font
            PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
            document.setFont(font).setFontSize(10);

            // Logo (converted to black/white with white background)
            InputStream imageStream = getClass().getClassLoader().getResourceAsStream("bharat-petroleum-black-logo-png_seeklogo-289641.png");
            if (imageStream != null) {
                BufferedImage original = ImageIO.read(imageStream);
                BufferedImage whiteBgImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = whiteBgImage.createGraphics();
                g2d.setColor(java.awt.Color.WHITE);
                g2d.fillRect(0, 0, whiteBgImage.getWidth(), whiteBgImage.getHeight());
                g2d.drawImage(original, 0, 0, null);
                g2d.dispose();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(whiteBgImage, "png", baos);

                Image logo = new Image(ImageDataFactory.create(baos.toByteArray()))
                        .scaleToFit(50, 50)
                        .setHorizontalAlignment(HorizontalAlignment.CENTER)
                        .setMarginBottom(10);
                document.add(logo);
            }

            // Header
            document.add(new Paragraph("SRI LATHA FUEL ALLEY").setTextAlignment(TextAlignment.CENTER).setBold());
            document.add(new Paragraph("102, KAMARAJAR NEDUNA SALAI, PERUNKALATHUR\nCHENNAI - 600063")
                    .setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("---------------------------------------").setTextAlignment(TextAlignment.CENTER));

            // Info table
            Table table = new Table(UnitValue.createPercentArray(new float[]{2, 3}))
                    .useAllAvailableWidth()
                    .setFontSize(10)
                    .setMarginTop(10);

            table.addCell(labelCell("INV NO.:"));
            table.addCell(valueCell(dto.getInvoiceNo()));

            table.addCell(labelCell("RECEIPT:"));
            table.addCell(valueCell(dto.getReceiptType()));

            table.addCell(labelCell("VEH NO.:"));
            table.addCell(valueCell(dto.getVehicleNo()));

            table.addCell(labelCell("MOB. NO:"));
            table.addCell(valueCell(dto.getMobileNo()));

            table.addCell(labelCell("DATE:"));
            table.addCell(valueCell(dto.getDate()));

            table.addCell(labelCell("TIME:"));
            table.addCell(valueCell(dto.getTime()));

            table.addCell(labelCell("NZ NO.:"));
            table.addCell(valueCell(dto.getNzNo()));

            table.addCell(labelCell("PRODUCT:"));
            table.addCell(valueCell(dto.getProduct()));

            table.addCell(labelCell("RATE:"));
            table.addCell(valueCell("Rs. " + String.format("%.2f", dto.getRate())));

            table.addCell(new Cell(1, 2).add(new Paragraph("---------------------------------------"))
                    .setBorder(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.CENTER));

            table.addCell(labelCell("AMOUNT:"));
            table.addCell(valueCell("Rs. " + String.format("%.2f", dto.getAmount())));

            table.addCell(labelCell("VOLUME:"));
            table.addCell(valueCell(String.format("%.2f", dto.getVolume()) + "L"));

            table.addCell(new Cell(1, 2).add(new Paragraph("---------------------------------------"))
                    .setBorder(Border.NO_BORDER)
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(table);
            document.close();
            return "Saved successfully: " + filePath;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error while generating PDF: " + e.getMessage();
        }
    }

    private Cell labelCell(String text) {
        return new Cell()
                .add(new Paragraph(text))
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT);
    }

    private Cell valueCell(String text) {
        return new Cell()
                .add(new Paragraph(text))
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT)
                .setPaddingLeft(5);
    }
}

