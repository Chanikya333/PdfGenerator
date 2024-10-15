package com.pdfgenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.itextpdf.html2pdf.HtmlConverter;
@Service
public class PdfService {
    private final TemplateEngine templateEngine;
    private final String STORAGE_PATH = "pdf-storage/";

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        File storageDir = new File(STORAGE_PATH);
        if (!storageDir.exists()) {
            storageDir.mkdirs(); 
        }
    }
    public String generatePdf(InvoiceRequest request) throws IOException {
        Context context = new Context();
        context.setVariable("seller", request.getSeller());
        context.setVariable("buyer", request.getBuyer());
        context.setVariable("sellerGstin", request.getSellerGstin());
        context.setVariable("buyerGstin", request.getBuyerGstin());
        context.setVariable("sellerAddress", request.getSellerAddress());
        context.setVariable("buyerAddress", request.getBuyerAddress());
        context.setVariable("items", request.getItems()); 
        String htmlContent = templateEngine.process("invoice-template", context);
        String fileName = UUID.randomUUID() + ".pdf";
        File file = new File("pdf-storage/" + fileName);
        HtmlConverter.convertToPdf(htmlContent, new FileOutputStream(file));

        return file.getAbsolutePath();
    }

}
