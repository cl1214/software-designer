//package com.exam.datastructure.sort.excel;
//
//import com.aiit.common.core.utils.StringUtils;
//import com.aspose.cells.License;
//import com.aspose.cells.PdfSaveOptions;
//import com.aspose.cells.SaveFormat;
//import com.aspose.cells.Workbook;
//import com.aspose.words.*;
//import org.apache.commons.compress.utils.IOUtils;
//
//import java.io.*;
//
//public class PdfUtils {
//
//    public static boolean getLicense() {
//        boolean result = false;
//        try {
//            InputStream is = PdfUtils.class.getClassLoader().getResourceAsStream("\\license.xml");
//            License aposeLic = new License();
//            aposeLic.setLicense(is);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static void excel2pdf(InputStream ins, OutputStream out){
//        // 验证License 若不验证则转化出的pdf文档会有水印产生
//        if (!getLicense()) {
//            return;
//        }
//        try {
//            // 原始excel路径
//            Workbook wb = new Workbook(ins);
//            PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
//            pdfSaveOptions.setOnePagePerSheet(true);
//            // 当excel中对应的sheet页宽度太大时，在PDF中会拆断并分页。此处等比缩放。
//            int[] showSheets={0};
//            // 隐藏workbook中不需要的sheet页。
//            printSheetPage(wb,showSheets);
//            wb.save(out, pdfSaveOptions);
//            out.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(ins);
//            IOUtils.closeQuietly(out);
//        }
//    }
//
//
//    public static void word2pdf(InputStream ins, OutputStream out){
//        // 验证License 若不验证则转化出的pdf文档会有水印产生
//        if (!getLicense()) {
//            return;
//        }
//        FileOutputStream os = null;
//        try {
//            //凭证 不然切换后有水印
//            //生成一个空的PDF文件
//            File file = new File("D:\\a.pdf");
//            os = new FileOutputStream(file);
//            //要转换的word文件
//            Document doc = new Document("D:\\Excel-综合填充.docx");
//
//            doc.save(os, SaveFormat.PDF);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void printSheetPage(Workbook wb, int[] page){
//        for (int i= 1; i < wb.getWorksheets().getCount(); i++)  {
//            wb.getWorksheets().get(i).setVisible(false);
//        }
//        if(null==page||page.length==0){
//            wb.getWorksheets().get(0).setVisible(true);
//        }else{
//            for (int i = 0; i < page.length; i++) {
//                wb.getWorksheets().get(i).setVisible(true);
//            }
//        }
//    }
//
//    public static void doc2pdf(String inPath, String outPath) {
//        if (!getLicense() || StringUtils.isEmpty(inPath) || StringUtils.isEmpty(outPath)) {
//            return;
//        }
//        try {
//            long old = System.currentTimeMillis();
//            File file = new File(outPath);
//            FileOutputStream os = new FileOutputStream(file);
//            Document doc = new Document(inPath);
//
//            doc.save(os, SaveFormat.PDF);
//            os.close();
//            // EPUB, XPS, SWF 相互转换
//            long now = System.currentTimeMillis();
//            System.out.println("Word转换成功，共耗时：" + ((now - old) / 1000.0) + "秒");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void doc2pdf1(String inPath, String outPath) {
//        try {
//            Document wordDoc = new Document(inPath);
//            PdfSaveOptions pso = new PdfSaveOptions();
//            wordDoc.save(outPath, SaveFormat.PDF);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void word2Pdf2(String inpath,String outpath) throws Exception {
//        if (!getLicense()) {
//            System.out.println("非法------------");
//            return;
//        }
//
//        System.out.println("开始使用Aspose.words进行转换");
//
//        long old = System.currentTimeMillis();
//        File file = new File(outpath);
//
//        FileOutputStream os = new FileOutputStream(file);
//
//        //解决乱码
//        //如果是windows执行，不需要加这个
//        String osName = System.getProperty("os.name", "");
//        if (osName.startsWith("Mac OS")) {
//        } else if (osName.startsWith("Windows")) {
//        } else { // assume Unix or Linux
//            //如果是linux执行，需要添加这个 ，如果还有乱码，可以把/usr/share/fonts/chinese路径下的所有文件拷贝到有问题的环境。并且再执行：source /etc/profile
//            new FontSettings().setFontsFolder("/usr/share/fonts/chinese",true);
//        }
//
//        Document doc = new Document(inpath);
//
//        //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
//        doc.save(os, SaveFormat.PDF);
//        long now = System.currentTimeMillis();
//        System.out.println("Aspose.words转换结束，共耗时：" + ((now - old) / 1000.0) + "秒");
//    }
//
//    public static void doc2pdf(Document doc, String targetFile) {
//        if (!getLicense()) {
//            System.out.println("非法------------");
//            return;
//        }
//        System.out.println("开始使用Aspose.words进行转换");
//        try {
//            long old = System.currentTimeMillis();
//            //新建一个空白pdf文档
//            File file = new File(targetFile);
//            FileOutputStream os = new FileOutputStream(file);
//            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
//            doc.save(os, com.aspose.words.SaveFormat.PDF);
//            os.close();
//            long now = System.currentTimeMillis();
//            //转化用时
//            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
////        InputStream is = Document.class
////                .getResourceAsStream("/com.aspose.words.lic_2999.xml");
////        com.aspose.words.License asposeLicense = new com.aspose.words.License();
////        asposeLicense.setLicense(is);
////        System.out.println("Aspose isLicensed: " + asposeLicense.isLicensed());
//        Document document = new Document("D:\\Excel-综合填充.docx");
//        TableCollection tables = document.getFirstSection().getBody().getTables();
//        for (Table table : tables) {
//            RowCollection rows = table.getRows();
//            table.setAllowAutoFit(false);
//            for (Row row : rows) {
//                CellCollection cells = row.getCells();
//                for (Cell cell : cells) {
//                    CellFormat cellFormat = cell.getCellFormat();
//                    cellFormat.setFitText(false);
//                    cellFormat.setWrapText(true);
//                }
//            }
//        }
//        document.updateTableLayout();
//        doc2pdf(document, "D:\\a.pdf");
//
//    }
//}
