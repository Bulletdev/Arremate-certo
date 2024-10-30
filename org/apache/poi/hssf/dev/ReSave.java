/*    */ package org.apache.poi.hssf.dev;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.FileInputStream;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
/*    */ public class ReSave
/*    */ {
/*    */   public static void main(String[] paramArrayOfString) throws Exception {
/* 38 */     boolean bool1 = false;
/* 39 */     boolean bool2 = false;
/* 40 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 41 */     for (String str : paramArrayOfString) {
/* 42 */       if (str.equals("-dg")) {
/* 43 */         bool1 = true;
/* 44 */       } else if (str.equals("-bos")) {
/* 45 */         bool2 = true;
/*    */       } else {
/* 47 */         HSSFWorkbook hSSFWorkbook; System.out.print("reading " + str + "...");
/* 48 */         FileInputStream fileInputStream = new FileInputStream(str);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\dev\ReSave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */