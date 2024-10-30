/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.apache.xmlbeans.XmlCursor;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
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
/*    */ public class DrawingParagraph
/*    */ {
/*    */   private final CTTextParagraph p;
/*    */   
/*    */   public DrawingParagraph(CTTextParagraph paramCTTextParagraph) {
/* 30 */     this.p = paramCTTextParagraph;
/*    */   }
/*    */   
/*    */   public CharSequence getText() {
/* 34 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 36 */     XmlCursor xmlCursor = this.p.newCursor();
/* 37 */     xmlCursor.selectPath("./*");
/* 38 */     while (xmlCursor.toNextSelection()) {
/* 39 */       XmlObject xmlObject = xmlCursor.getObject();
/* 40 */       if (xmlObject instanceof CTRegularTextRun) {
/* 41 */         CTRegularTextRun cTRegularTextRun = (CTRegularTextRun)xmlObject;
/* 42 */         stringBuilder.append(cTRegularTextRun.getT()); continue;
/* 43 */       }  if (xmlObject instanceof org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak) {
/* 44 */         stringBuilder.append('\n');
/*    */       }
/*    */     } 
/*    */     
/* 48 */     xmlCursor.dispose();
/*    */     
/* 50 */     return stringBuilder;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\DrawingParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */