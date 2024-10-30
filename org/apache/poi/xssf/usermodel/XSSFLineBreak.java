/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
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
/*    */ class XSSFLineBreak
/*    */   extends XSSFTextRun
/*    */ {
/*    */   private final CTTextCharacterProperties _brProps;
/*    */   
/*    */   XSSFLineBreak(CTRegularTextRun paramCTRegularTextRun, XSSFTextParagraph paramXSSFTextParagraph, CTTextCharacterProperties paramCTTextCharacterProperties) {
/* 29 */     super(paramCTRegularTextRun, paramXSSFTextParagraph);
/* 30 */     this._brProps = paramCTTextCharacterProperties;
/*    */   }
/*    */ 
/*    */   
/*    */   protected CTTextCharacterProperties getRPr() {
/* 35 */     return this._brProps;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 42 */     throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFLineBreak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */