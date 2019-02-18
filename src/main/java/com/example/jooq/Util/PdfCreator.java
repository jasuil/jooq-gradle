package com.example.jooq.Util;

import org.apache.fontbox.ttf.TrueTypeCollection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class PdfCreator {


    private static final Logger logger = LoggerFactory.getLogger(PdfCreator.class);

    public static void pdf(HttpServletResponse response, ServletContext context) throws Exception {

        final int pageCount = 2;
        final String webroot = context.getRealPath("/");

        // 문서 만들기
        final PDDocument doc = new PDDocument();

        // 배경이미지 로드
      // PDImageXObject pdImage = PDImageXObject.createFromFile( ResourceUtils.getFile("classpath:static/back.gif").getPath(), doc);

                // 폰트 생성
        // ttf 파일 사용하기
        InputStream fontStream = new FileInputStream("D:/utils/fonts/NotoSansThai-hinted/NotoSansThai-Bold.ttf");
        PDType0Font fontGulim = PDType0Font.load(doc, fontStream);

        // ttc 파일 사용하기
   //     File fontFile = new File("C:/Windows/fonts/gulim.ttc");
    //    PDType0Font fontGulim = PDType0Font.load(doc, new TrueTypeCollection(fontFile).getFontByName("Gulim"), true);

//        PDFont font = PDType0Font.load(doc, new
 //                File("/windows/fonts/KozGoPro-Regular.otf"));

        // 두 개의 페이지를 만든다.
        for(int i = 0; i < pageCount; i++) {
            // 페이지 추가
            PDPage blankPage = new PDPage(PDRectangle.A4);
            doc.addPage(blankPage);

            // 현재 페이지 설정
            PDPage page = doc.getPage(i);

            // 컨텐츠 스트림 열기
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

            // 배경 이미지  그리기
       //     contentStream.drawImage(pdImage, 0, 0, 595, 842);

            // 글씨 쓰기
            drawText("หนังสือ", fontGulim, 18, 100, 600, contentStream);
            drawText("หนังสือ", fontGulim, 18, 100, 560, contentStream);


            // 테이블 그리기
            String[][] contents = {
                    {"Apple",    "Banana",    "1"},
                    {"Chestnut", "Persimmon", "2"},
                    {"Eggplang", "Potato",    "3"},
                    {"Guava",    "Radish",    "4"},
                    {"Lemon",    "Lime",      "5"}
            };

            drawTable(page, contentStream, 500, 100, contents);

            // 컨텐츠 스트림 닫기
            contentStream.close();
        }

        // 파일 다운로드 설정
        response.setContentType("application/pdf");
        String fileName = URLEncoder.encode("샘플PDF", "UTF-8");
        response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".pdf");

        // PDF 파일 출력
        doc.save(response.getOutputStream());
        doc.close();

    }

    /**
     * 글씨를 쓴다.
     * @param text
     * @param font
     * @param fontSize
     * @param left
     * @param bottom
     * @param contentStream
     * @throws Exception
     */
    private static void drawText(String text, PDFont font, int fontSize, float left, float bottom, PDPageContentStream contentStream) throws Exception {
        contentStream.beginText();
 //       contentStream.setFont(PDType1Font.COURIER, fontSize);
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(left, bottom);
        contentStream.showText(text);
        contentStream.endText();
    }

    /**
     * 라인을 그린다.
     * @param contentStream
     * @param xStart
     * @param yStart
     * @param xEnd
     * @param yEnd
     * @throws IOException
     */
    private static void drawLine(PDPageContentStream contentStream, float xStart, float yStart, float xEnd, float yEnd) throws IOException {
        contentStream.moveTo(xStart,yStart);
        contentStream.lineTo(xEnd,yEnd);
        contentStream.stroke();
    }

    /**
     * 테이블을 그린다.
     * @param page
     * @param contentStream
     * @param y
     * @param margin
     * @param content
     * @throws Exception
     */
    public static void drawTable(PDPage page, PDPageContentStream contentStream, float y, float margin, String[][] content) throws Exception {
        final int rows = content.length;
        final int cols = content[0].length;

        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;

        final float colWidth = tableWidth / (float)cols;
        final float cellMargin = 5f;

        // 행을 그린다.
        float nexty = y ;
        for(int i = 0; i <= rows; i++) {
            drawLine(contentStream, margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        // 열을 그린다.
        float nextx = margin;
        for(int i = 0; i <= cols; i++) {
            drawLine(contentStream, nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        float textx = margin + cellMargin;
        float texty = y - 15;
        for(int i = 0; i < content.length; i++) {
            for(int j = 0 ; j < content[i].length; j++) {
                String text = content[i][j];
                drawText(text, PDType1Font.HELVETICA_BOLD, 12, textx, texty, contentStream);
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
    }

}
