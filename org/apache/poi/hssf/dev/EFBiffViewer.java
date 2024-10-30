/*    */ package org.apache.poi.hssf.dev;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
/*    */ import org.apache.poi.hssf.eventusermodel.HSSFListener;
/*    */ import org.apache.poi.hssf.eventusermodel.HSSFRequest;
/*    */ import org.apache.poi.hssf.record.Record;
/*    */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
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
/*    */ 
/*    */ 
/*    */ public class EFBiffViewer
/*    */ {
/*    */   String file;
/*    */   
/*    */   public void run() throws IOException {
/* 46 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(this.file), true);
/*    */     try {
/* 48 */       InputStream inputStream = BiffViewer.getPOIFSInputStream(nPOIFSFileSystem);
/*    */       try {
/* 50 */         HSSFRequest hSSFRequest = new HSSFRequest();
/*    */         
/* 52 */         hSSFRequest.addListenerForAllRecords(new HSSFListener()
/*    */             {
/*    */               public void processRecord(Record param1Record)
/*    */               {
/* 56 */                 System.out.println(param1Record.toString());
/*    */               }
/*    */             });
/* 59 */         HSSFEventFactory hSSFEventFactory = new HSSFEventFactory();
/*    */         
/* 61 */         hSSFEventFactory.processEvents(hSSFRequest, inputStream);
/*    */       } finally {
/* 63 */         inputStream.close();
/*    */       } 
/*    */     } finally {
/* 66 */       nPOIFSFileSystem.close();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void setFile(String paramString) {
/* 72 */     this.file = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] paramArrayOfString) throws IOException {
/* 77 */     if (paramArrayOfString.length == 1 && !paramArrayOfString[0].equals("--help")) {
/*    */       
/* 79 */       EFBiffViewer eFBiffViewer = new EFBiffViewer();
/*    */       
/* 81 */       eFBiffViewer.setFile(paramArrayOfString[0]);
/* 82 */       eFBiffViewer.run();
/*    */     }
/*    */     else {
/*    */       
/* 86 */       System.out.println("EFBiffViewer");
/* 87 */       System.out.println("Outputs biffview of records based on HSSFEventFactory");
/*    */       
/* 89 */       System.out.println("usage: java org.apache.poi.hssf.dev.EBBiffViewer filename");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\dev\EFBiffViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */