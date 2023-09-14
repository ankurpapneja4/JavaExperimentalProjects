package org.rssb.pdfoptimizer;

import org.rssb.pdfoptimizer.service.EmbedMissingFontService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfOptimizerApplication {

	public static void main(String[] args) {

		SpringApplication.run(PdfOptimizerApplication.class, args);
		EmbedMissingFontService.processPDF();

	}

}
