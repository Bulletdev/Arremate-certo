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
/*    */ 
/*    */ public class SheetIdentifier
/*    */ {
/*    */   public String _bookName;
/*    */   public NameIdentifier _sheetIdentifier;
/*    */   
/*    */   public SheetIdentifier(String paramString, NameIdentifier paramNameIdentifier) {
/* 25 */     this._bookName = paramString;
/* 26 */     this._sheetIdentifier = paramNameIdentifier;
/*    */   }
/*    */   public String getBookName() {
/* 29 */     return this._bookName;
/*    */   }
/*    */   public NameIdentifier getSheetIdentifier() {
/* 32 */     return this._sheetIdentifier;
/*    */   }
/*    */   protected void asFormulaString(StringBuffer paramStringBuffer) {
/* 35 */     if (this._bookName != null) {
/* 36 */       paramStringBuffer.append(" [").append(this._sheetIdentifier.getName()).append("]");
/*    */     }
/* 38 */     if (this._sheetIdentifier.isQuoted()) {
/* 39 */       paramStringBuffer.append("'").append(this._sheetIdentifier.getName()).append("'");
/*    */     } else {
/* 41 */       paramStringBuffer.append(this._sheetIdentifier.getName());
/*    */     } 
/*    */   }
/*    */   public String asFormulaString() {
/* 45 */     StringBuffer stringBuffer = new StringBuffer(32);
/* 46 */     asFormulaString(stringBuffer);
/* 47 */     return stringBuffer.toString();
/*    */   }
/*    */   public String toString() {
/* 50 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 51 */     stringBuffer.append(getClass().getName());
/* 52 */     stringBuffer.append(" [");
/* 53 */     asFormulaString(stringBuffer);
/* 54 */     stringBuffer.append("]");
/* 55 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\SheetIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */