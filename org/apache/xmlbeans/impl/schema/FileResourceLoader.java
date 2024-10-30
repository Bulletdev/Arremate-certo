/*    */ package org.apache.xmlbeans.impl.schema;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipFile;
/*    */ import org.apache.xmlbeans.ResourceLoader;
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
/*    */ public class FileResourceLoader
/*    */   implements ResourceLoader
/*    */ {
/*    */   private File _directory;
/*    */   private ZipFile _zipfile;
/*    */   
/*    */   public FileResourceLoader(File paramFile) throws IOException {
/* 34 */     if (paramFile.isDirectory()) {
/* 35 */       this._directory = paramFile;
/*    */     } else {
/*    */       
/* 38 */       this._zipfile = new ZipFile(paramFile);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InputStream getResourceAsStream(String paramString) {
/*    */     try {
/* 46 */       if (this._zipfile != null) {
/*    */         
/* 48 */         ZipEntry zipEntry = this._zipfile.getEntry(paramString);
/* 49 */         if (zipEntry == null)
/* 50 */           return null; 
/* 51 */         return this._zipfile.getInputStream(zipEntry);
/*    */       } 
/*    */ 
/*    */       
/* 55 */       return new FileInputStream(new File(this._directory, paramString));
/*    */     
/*    */     }
/* 58 */     catch (IOException iOException) {
/*    */       
/* 60 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 66 */     if (this._zipfile != null) {
/*    */ 
/*    */       
/*    */       try {
/* 70 */         this._zipfile.close();
/*    */       }
/* 72 */       catch (IOException iOException) {}
/*    */ 
/*    */ 
/*    */       
/* 76 */       this._zipfile = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\FileResourceLoader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */