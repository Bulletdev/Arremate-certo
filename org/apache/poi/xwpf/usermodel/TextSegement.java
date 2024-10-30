/*    */ package org.apache.poi.xwpf.usermodel;
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
/*    */ public class TextSegement
/*    */ {
/*    */   private PositionInParagraph beginPos;
/*    */   private PositionInParagraph endPos;
/*    */   
/*    */   public TextSegement() {
/* 28 */     this.beginPos = new PositionInParagraph();
/* 29 */     this.endPos = new PositionInParagraph();
/*    */   }
/*    */   
/*    */   public TextSegement(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 33 */     PositionInParagraph positionInParagraph1 = new PositionInParagraph(paramInt1, paramInt3, paramInt5);
/* 34 */     PositionInParagraph positionInParagraph2 = new PositionInParagraph(paramInt2, paramInt4, paramInt6);
/* 35 */     this.beginPos = positionInParagraph1;
/* 36 */     this.endPos = positionInParagraph2;
/*    */   }
/*    */   
/*    */   public TextSegement(PositionInParagraph paramPositionInParagraph1, PositionInParagraph paramPositionInParagraph2) {
/* 40 */     this.beginPos = paramPositionInParagraph1;
/* 41 */     this.endPos = paramPositionInParagraph2;
/*    */   }
/*    */   
/*    */   public PositionInParagraph getBeginPos() {
/* 45 */     return this.beginPos;
/*    */   }
/*    */   
/*    */   public PositionInParagraph getEndPos() {
/* 49 */     return this.endPos;
/*    */   }
/*    */   
/*    */   public int getBeginRun() {
/* 53 */     return this.beginPos.getRun();
/*    */   }
/*    */   
/*    */   public void setBeginRun(int paramInt) {
/* 57 */     this.beginPos.setRun(paramInt);
/*    */   }
/*    */   
/*    */   public int getBeginText() {
/* 61 */     return this.beginPos.getText();
/*    */   }
/*    */   
/*    */   public void setBeginText(int paramInt) {
/* 65 */     this.beginPos.setText(paramInt);
/*    */   }
/*    */   
/*    */   public int getBeginChar() {
/* 69 */     return this.beginPos.getChar();
/*    */   }
/*    */   
/*    */   public void setBeginChar(int paramInt) {
/* 73 */     this.beginPos.setChar(paramInt);
/*    */   }
/*    */   
/*    */   public int getEndRun() {
/* 77 */     return this.endPos.getRun();
/*    */   }
/*    */   
/*    */   public void setEndRun(int paramInt) {
/* 81 */     this.endPos.setRun(paramInt);
/*    */   }
/*    */   
/*    */   public int getEndText() {
/* 85 */     return this.endPos.getText();
/*    */   }
/*    */   
/*    */   public void setEndText(int paramInt) {
/* 89 */     this.endPos.setText(paramInt);
/*    */   }
/*    */   
/*    */   public int getEndChar() {
/* 93 */     return this.endPos.getChar();
/*    */   }
/*    */   
/*    */   public void setEndChar(int paramInt) {
/* 97 */     this.endPos.setChar(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\TextSegement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */