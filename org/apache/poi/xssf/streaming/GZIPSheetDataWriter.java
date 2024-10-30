/*    */ package org.apache.poi.xssf.streaming;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.Writer;
/*    */ import java.util.zip.GZIPInputStream;
/*    */ import java.util.zip.GZIPOutputStream;
/*    */ import org.apache.poi.util.TempFile;
/*    */ import org.apache.poi.xssf.model.SharedStringsTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GZIPSheetDataWriter
/*    */   extends SheetDataWriter
/*    */ {
/*    */   public GZIPSheetDataWriter() throws IOException {}
/*    */   
/*    */   public GZIPSheetDataWriter(SharedStringsTable paramSharedStringsTable) throws IOException {
/* 48 */     super(paramSharedStringsTable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public File createTempFile() throws IOException {
/* 56 */     return TempFile.createTempFile("poi-sxssf-sheet-xml", ".gz");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Writer createWriter(File paramFile) throws IOException {
/* 64 */     return new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(paramFile)), "UTF-8");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InputStream getWorksheetXMLInputStream() throws IOException {
/* 73 */     File file = getTempFile();
/* 74 */     return new GZIPInputStream(new FileInputStream(file));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\GZIPSheetDataWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */