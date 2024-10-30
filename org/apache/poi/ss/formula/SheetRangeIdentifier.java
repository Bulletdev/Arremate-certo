/*    */ package org.apache.poi.ss.formula;
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
/*    */ public class SheetRangeIdentifier
/*    */   extends SheetIdentifier
/*    */ {
/*    */   public NameIdentifier _lastSheetIdentifier;
/*    */   
/*    */   public SheetRangeIdentifier(String paramString, NameIdentifier paramNameIdentifier1, NameIdentifier paramNameIdentifier2) {
/* 24 */     super(paramString, paramNameIdentifier1);
/* 25 */     this._lastSheetIdentifier = paramNameIdentifier2;
/*    */   }
/*    */   public NameIdentifier getFirstSheetIdentifier() {
/* 28 */     return getSheetIdentifier();
/*    */   }
/*    */   public NameIdentifier getLastSheetIdentifier() {
/* 31 */     return this._lastSheetIdentifier;
/*    */   }
/*    */   protected void asFormulaString(StringBuffer paramStringBuffer) {
/* 34 */     super.asFormulaString(paramStringBuffer);
/* 35 */     paramStringBuffer.append(':');
/* 36 */     if (this._lastSheetIdentifier.isQuoted()) {
/* 37 */       paramStringBuffer.append("'").append(this._lastSheetIdentifier.getName()).append("'");
/*    */     } else {
/* 39 */       paramStringBuffer.append(this._lastSheetIdentifier.getName());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\SheetRangeIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */