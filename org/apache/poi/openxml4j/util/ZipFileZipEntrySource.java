/*    */ package org.apache.poi.openxml4j.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Enumeration;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipFile;
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
/*    */ public class ZipFileZipEntrySource
/*    */   implements ZipEntrySource
/*    */ {
/*    */   private ZipFile zipArchive;
/*    */   
/*    */   public ZipFileZipEntrySource(ZipFile paramZipFile) {
/* 33 */     this.zipArchive = paramZipFile;
/*    */   }
/*    */   
/*    */   public void close() throws IOException {
/* 37 */     if (this.zipArchive != null) {
/* 38 */       this.zipArchive.close();
/*    */     }
/* 40 */     this.zipArchive = null;
/*    */   }
/*    */   public boolean isClosed() {
/* 43 */     return (this.zipArchive == null);
/*    */   }
/*    */   
/*    */   public Enumeration<? extends ZipEntry> getEntries() {
/* 47 */     if (this.zipArchive == null) {
/* 48 */       throw new IllegalStateException("Zip File is closed");
/*    */     }
/* 50 */     return this.zipArchive.entries();
/*    */   }
/*    */   
/*    */   public InputStream getInputStream(ZipEntry paramZipEntry) throws IOException {
/* 54 */     if (this.zipArchive == null) {
/* 55 */       throw new IllegalStateException("Zip File is closed");
/*    */     }
/* 57 */     return this.zipArchive.getInputStream(paramZipEntry);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4\\util\ZipFileZipEntrySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */