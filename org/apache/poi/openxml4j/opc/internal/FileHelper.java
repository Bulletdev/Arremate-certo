/*    */ package org.apache.poi.openxml4j.opc.internal;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.nio.channels.FileChannel;
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
/*    */ 
/*    */ public final class FileHelper
/*    */ {
/*    */   public static File getDirectory(File paramFile) {
/* 42 */     if (paramFile != null) {
/* 43 */       String str = paramFile.getPath();
/* 44 */       int i = str.length();
/* 45 */       int j = i;
/* 46 */       while (--j >= 0) {
/* 47 */         char c = str.charAt(j);
/* 48 */         if (c == File.separatorChar) {
/* 49 */           return new File(str.substring(0, j));
/*    */         }
/*    */       } 
/*    */     } 
/* 53 */     return null;
/*    */   }
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
/*    */   public static void copyFile(File paramFile1, File paramFile2) throws IOException {
/* 67 */     FileChannel fileChannel1 = (new FileInputStream(paramFile1)).getChannel();
/* 68 */     FileChannel fileChannel2 = (new FileOutputStream(paramFile2)).getChannel();
/* 69 */     fileChannel1.transferTo(0L, fileChannel1.size(), fileChannel2);
/* 70 */     fileChannel1.close();
/* 71 */     fileChannel2.close();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getFilename(File paramFile) {
/* 78 */     if (paramFile != null) {
/* 79 */       String str = paramFile.getPath();
/* 80 */       int i = str.length();
/* 81 */       int j = i;
/* 82 */       while (--j >= 0) {
/* 83 */         char c = str.charAt(j);
/* 84 */         if (c == File.separatorChar)
/* 85 */           return str.substring(j + 1, i); 
/*    */       } 
/*    */     } 
/* 88 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\FileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */