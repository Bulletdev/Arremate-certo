/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
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
/*    */ public final class TempFile
/*    */ {
/* 28 */   private static TempFileCreationStrategy strategy = new DefaultTempFileCreationStrategy();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setTempFileCreationStrategy(TempFileCreationStrategy paramTempFileCreationStrategy) {
/* 45 */     if (paramTempFileCreationStrategy == null) {
/* 46 */       throw new IllegalArgumentException("strategy == null");
/*    */     }
/* 48 */     strategy = paramTempFileCreationStrategy;
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static File createTempFile(String paramString1, String paramString2) throws IOException {
/* 66 */     return strategy.createTempFile(paramString1, paramString2);
/*    */   }
/*    */   
/*    */   public static File createTempDirectory(String paramString) throws IOException {
/* 70 */     return strategy.createTempDirectory(paramString);
/*    */   }
/*    */   
/*    */   public static class DefaultTempFileCreationStrategy extends DefaultTempFileCreationStrategy {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\TempFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */