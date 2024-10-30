/*    */ package org.apache.poi.xssf.dev;
/*    */ 
/*    */ import java.io.FileOutputStream;
/*    */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*    */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
/*    */ public final class XSSFSave
/*    */ {
/*    */   public static void main(String[] paramArrayOfString) throws Exception {
/* 33 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 34 */       OPCPackage oPCPackage = OPCPackage.open(paramArrayOfString[b]);
/* 35 */       XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(oPCPackage);
/*    */       
/* 37 */       int i = paramArrayOfString[b].lastIndexOf('.');
/* 38 */       String str = paramArrayOfString[b].substring(0, i) + "-save.xls" + (xSSFWorkbook.isMacroEnabled() ? "m" : "x");
/* 39 */       FileOutputStream fileOutputStream = new FileOutputStream(str);
/* 40 */       xSSFWorkbook.write(fileOutputStream);
/* 41 */       fileOutputStream.close();
/*    */       
/* 43 */       oPCPackage.close();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\dev\XSSFSave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */