/*     */ package org.apache.poi.hssf.eventusermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFactoryInputStream;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFEventFactory
/*     */ {
/*     */   public void processWorkbookEvents(HSSFRequest paramHSSFRequest, POIFSFileSystem paramPOIFSFileSystem) throws IOException {
/*  54 */     processWorkbookEvents(paramHSSFRequest, paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processWorkbookEvents(HSSFRequest paramHSSFRequest, DirectoryNode paramDirectoryNode) throws IOException {
/*  67 */     String str = null;
/*  68 */     Set set = paramDirectoryNode.getEntryNames();
/*  69 */     for (String str1 : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
/*  70 */       if (set.contains(str1)) {
/*  71 */         str = str1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  76 */     if (str == null) {
/*  77 */       str = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES[0];
/*     */     }
/*     */     
/*  80 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream(str);
/*     */     try {
/*  82 */       processEvents(paramHSSFRequest, (InputStream)documentInputStream);
/*     */     } finally {
/*  84 */       documentInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short abortableProcessWorkbookEvents(HSSFRequest paramHSSFRequest, POIFSFileSystem paramPOIFSFileSystem) throws IOException, HSSFUserException {
/* 100 */     return abortableProcessWorkbookEvents(paramHSSFRequest, paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short abortableProcessWorkbookEvents(HSSFRequest paramHSSFRequest, DirectoryNode paramDirectoryNode) throws IOException, HSSFUserException {
/* 115 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream("Workbook");
/*     */     try {
/* 117 */       return abortableProcessEvents(paramHSSFRequest, (InputStream)documentInputStream);
/*     */     } finally {
/* 119 */       documentInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processEvents(HSSFRequest paramHSSFRequest, InputStream paramInputStream) {
/*     */     try {
/* 136 */       genericProcessEvents(paramHSSFRequest, paramInputStream);
/* 137 */     } catch (HSSFUserException hSSFUserException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short abortableProcessEvents(HSSFRequest paramHSSFRequest, InputStream paramInputStream) throws HSSFUserException {
/* 155 */     return genericProcessEvents(paramHSSFRequest, paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private short genericProcessEvents(HSSFRequest paramHSSFRequest, InputStream paramInputStream) throws HSSFUserException {
/* 168 */     short s = 0;
/*     */ 
/*     */     
/* 171 */     RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(paramInputStream, false);
/*     */ 
/*     */     
/*     */     do {
/* 175 */       Record record = recordFactoryInputStream.nextRecord();
/* 176 */       if (record == null) {
/*     */         break;
/*     */       }
/* 179 */       s = paramHSSFRequest.processRecord(record);
/* 180 */     } while (s == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\HSSFEventFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */