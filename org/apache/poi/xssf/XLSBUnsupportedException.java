/*    */ package org.apache.poi.xssf;
/*    */ 
/*    */ import org.apache.poi.UnsupportedFileFormatException;
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
/*    */ public class XLSBUnsupportedException
/*    */   extends UnsupportedFileFormatException
/*    */ {
/*    */   private static final long serialVersionUID = 7849681804154571175L;
/*    */   public static final String MESSAGE = ".XLSB Binary Workbooks are not supported";
/*    */   
/*    */   public XLSBUnsupportedException() {
/* 29 */     super(".XLSB Binary Workbooks are not supported");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\XLSBUnsupportedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */