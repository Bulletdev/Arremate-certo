/*    */ package org.apache.poi.extractor;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.apache.poi.POITextExtractor;
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
/*    */ public class CommandLineTextExtractor
/*    */ {
/*    */   public static final String DIVIDER = "=======================";
/*    */   
/*    */   public static void main(String[] paramArrayOfString) throws Exception {
/* 31 */     if (paramArrayOfString.length < 1) {
/* 32 */       System.err.println("Use:");
/* 33 */       System.err.println("   CommandLineTextExtractor <filename> [filename] [filename]");
/* 34 */       System.exit(1);
/*    */     } 
/*    */     
/* 37 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 38 */       System.out.println("=======================");
/*    */       
/* 40 */       File file = new File(paramArrayOfString[b]);
/* 41 */       System.out.println(file);
/*    */       
/* 43 */       POITextExtractor pOITextExtractor = ExtractorFactory.createExtractor(file);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\extractor\CommandLineTextExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */