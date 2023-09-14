package org.rssb.pdfoptimizer.utils;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class PdfFontUtils {

    public static void embedFont( File pdfFile, File fontFile, String fontID ){
        try {
            // Load the existing PDF document
            PDDocument document = PDDocument.load(pdfFile);

            // Embed the font
            PDTrueTypeFont font = PDTrueTypeFont.loadTTF(document, fontFile);

            // Update the page's resources to include the embedded font
            for(PDPage page : document.getPages())
            {
                PDResources resources = page.getResources();
                if (resources == null) {
                    resources = new PDResources();
                    page.setResources(resources);
                }
                resources.put(COSName.getPDFName(fontID), font);
            }


            // Save the modified document to a new file
            Path parentPath       = pdfFile.toPath().getParent();
            String outputFileName = pdfFile.getName();
            Path outputFilePath   = parentPath.resolve("Processed/" + outputFileName);

            if( ! outputFilePath.getParent().toFile().exists() )
                outputFilePath.getParent().toFile().mkdirs();

            document.save( outputFilePath.toFile() );
            document.close();

            System.out.println("Processed File : " + outputFileName );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printAllFontNames( File pdfFile ){
        try {
            // Load the existing PDF document
            PDDocument document = PDDocument.load( pdfFile );

            for (PDPage page : document.getPages()) {
                PDResources resources = page.getResources();
                if (resources != null)
                        for (COSName cosName : resources.getFontNames()) {

                            PDFont font = resources.getFont(cosName);
                            System.out.println( cosName + " >>> " + font );
                        }
            }

            // Close the document
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
