/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.PrintWriter;
/*    */ import java.nio.charset.Charset;
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*    */ import org.apache.poi.ss.usermodel.Sheet;
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
/*    */ public class DrawingDump
/*    */ {
/*    */   public static void main(String[] paramArrayOfString) throws IOException {
/* 38 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out, Charset.defaultCharset());
/* 39 */     PrintWriter printWriter = new PrintWriter(outputStreamWriter);
/* 40 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(paramArrayOfString[0]));
/* 41 */     HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(nPOIFSFileSystem);
/*    */     try {
/* 43 */       printWriter.println("Drawing group:");
/* 44 */       hSSFWorkbook.dumpDrawingGroupRecords(true);
/*    */       
/* 46 */       boolean bool = true;
/* 47 */       for (Sheet sheet : hSSFWorkbook) {
/*    */         
/* 49 */         printWriter.println("Sheet " + bool + "(" + sheet.getSheetName() + "):");
/* 50 */         ((HSSFSheet)sheet).dumpDrawingRecords(true, printWriter);
/*    */       } 
/*    */     } finally {
/* 53 */       hSSFWorkbook.close();
/* 54 */       nPOIFSFileSystem.close();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\DrawingDump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */