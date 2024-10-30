/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
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
/*    */ public class DrawingTextBody
/*    */ {
/*    */   private final CTTextBody textBody;
/*    */   
/*    */   public DrawingTextBody(CTTextBody paramCTTextBody) {
/* 27 */     this.textBody = paramCTTextBody;
/*    */   }
/*    */   
/*    */   public DrawingParagraph[] getParagraphs() {
/* 31 */     CTTextParagraph[] arrayOfCTTextParagraph = this.textBody.getPArray();
/* 32 */     DrawingParagraph[] arrayOfDrawingParagraph = new DrawingParagraph[arrayOfCTTextParagraph.length];
/*    */     
/* 34 */     for (byte b = 0; b < arrayOfDrawingParagraph.length; b++) {
/* 35 */       arrayOfDrawingParagraph[b] = new DrawingParagraph(arrayOfCTTextParagraph[b]);
/*    */     }
/*    */     
/* 38 */     return arrayOfDrawingParagraph;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\DrawingTextBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */