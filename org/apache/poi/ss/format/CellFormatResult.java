/*    */ package org.apache.poi.ss.format;
/*    */ 
/*    */ import java.awt.Color;
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
/*    */ public class CellFormatResult
/*    */ {
/*    */   public final boolean applies;
/*    */   public final String text;
/*    */   public final Color textColor;
/*    */   
/*    */   public CellFormatResult(boolean paramBoolean, String paramString, Color paramColor) throws IllegalArgumentException {
/* 54 */     this.applies = paramBoolean;
/* 55 */     if (paramString == null)
/* 56 */       throw new IllegalArgumentException("CellFormatResult text may not be null"); 
/* 57 */     this.text = paramString;
/* 58 */     this.textColor = paramBoolean ? paramColor : null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellFormatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */