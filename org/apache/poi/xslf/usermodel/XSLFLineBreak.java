/*    */ package org.apache.poi.xslf.usermodel;
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
/*    */ class XSLFLineBreak
/*    */   extends XSLFTextRun
/*    */ {
/*    */   private final CTTextCharacterProperties _brProps;
/*    */   
/*    */   XSLFLineBreak(CTRegularTextRun paramCTRegularTextRun, XSLFTextParagraph paramXSLFTextParagraph, CTTextCharacterProperties paramCTTextCharacterProperties) {
/* 29 */     super(paramCTRegularTextRun, paramXSLFTextParagraph);
/* 30 */     this._brProps = paramCTTextCharacterProperties;
/*    */   }
/*    */ 
/*    */   
/*    */   protected CTTextCharacterProperties getRPr(boolean paramBoolean) {
/* 35 */     return this._brProps;
/*    */   }
/*    */   
/*    */   public void setText(String paramString) {
/* 39 */     throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFLineBreak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */