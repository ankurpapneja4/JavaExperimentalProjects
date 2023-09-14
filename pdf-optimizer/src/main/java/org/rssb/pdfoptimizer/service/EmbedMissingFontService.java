package org.rssb.pdfoptimizer.service;

import org.rssb.pdfoptimizer.utils.PdfFontUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EmbedMissingFontService {

    public static final Path ROOT_PATH = Paths.get("D:/Badge");
    public static final String FONT_ID = "F14";
    public static final File FONT = Paths.get("D:/Badge/WASP39LC.TTF").toFile();

    public static final void processPDF() {
        try  {
            Files.list( ROOT_PATH )
                    .filter ( path -> path.toString().endsWith(".pdf"))
                    .forEach( pdf  -> PdfFontUtils.embedFont( pdf.toFile() , FONT, FONT_ID));
        }catch (IOException exp){
            exp.printStackTrace();
        }
    }
}
