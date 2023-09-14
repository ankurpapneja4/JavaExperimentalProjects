package org.rssb.pdfoptimizer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.rssb.pdfoptimizer.utils.PdfFontUtils;

import java.io.File;

//@SpringBootTest
class PdfOptimizerApplicationTests {


	@Test
	@Disabled
	void printFontName() {
		String inputFilePath = "D:\\ankur.papneja\\Downloads\\AreaPermanent.pdf";

		File pdfFile = new File( inputFilePath );
		PdfFontUtils.printAllFontNames(pdfFile);
	}


	@Test
	@Disabled
	public void embedFontV2() {
		String inputFilePath = "D:\\ankur.papneja\\Downloads\\AreaPermanent.pdf";
		String fontFilePath = "D:\\ankur.papneja\\Downloads\\WASP39LC.TTF";

		File pdfFile  = new File( inputFilePath );
		File fontFile = new File( fontFilePath  );
		PdfFontUtils.embedFont(pdfFile, fontFile, "F14");
	}

}
