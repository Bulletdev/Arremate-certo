/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.poifs.dev.POIFSViewable;
/*     */ import org.apache.poi.util.CloseIgnoringInputStream;
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
/*     */ public class POIFSFileSystem
/*     */   extends NPOIFSFileSystem
/*     */   implements POIFSViewable
/*     */ {
/*     */   public static InputStream createNonClosingInputStream(InputStream paramInputStream) {
/*  44 */     return (InputStream)new CloseIgnoringInputStream(paramInputStream);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIFSFileSystem() {}
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
/*     */   public POIFSFileSystem(InputStream paramInputStream) throws IOException {
/*  87 */     super(paramInputStream);
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
/*     */   public POIFSFileSystem(File paramFile, boolean paramBoolean) throws IOException {
/* 104 */     super(paramFile, paramBoolean);
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
/*     */   public POIFSFileSystem(File paramFile) throws IOException {
/* 120 */     super(paramFile);
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
/*     */   public static boolean hasPOIFSHeader(InputStream paramInputStream) throws IOException {
/* 133 */     return NPOIFSFileSystem.hasPOIFSHeader(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasPOIFSHeader(byte[] paramArrayOfbyte) {
/* 140 */     return NPOIFSFileSystem.hasPOIFSHeader(paramArrayOfbyte);
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
/*     */   public static POIFSFileSystem create(File paramFile) throws IOException {
/* 154 */     POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
/* 155 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/* 156 */     pOIFSFileSystem.writeFilesystem(fileOutputStream);
/* 157 */     fileOutputStream.close();
/* 158 */     pOIFSFileSystem.close();
/*     */ 
/*     */     
/* 161 */     return new POIFSFileSystem(paramFile, false);
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
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 176 */     OPOIFSFileSystem.main(paramArrayOfString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\POIFSFileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */