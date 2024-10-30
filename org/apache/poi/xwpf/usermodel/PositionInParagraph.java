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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PositionInParagraph
/*    */ {
/* 28 */   private int posRun = 0, posText = 0, posChar = 0;
/*    */ 
/*    */   
/*    */   public PositionInParagraph() {}
/*    */   
/*    */   public PositionInParagraph(int paramInt1, int paramInt2, int paramInt3) {
/* 34 */     this.posRun = paramInt1;
/* 35 */     this.posChar = paramInt3;
/* 36 */     this.posText = paramInt2;
/*    */   }
/*    */   
/*    */   public int getRun() {
/* 40 */     return this.posRun;
/*    */   }
/*    */   
/*    */   public void setRun(int paramInt) {
/* 44 */     this.posRun = paramInt;
/*    */   }
/*    */   
/*    */   public int getText() {
/* 48 */     return this.posText;
/*    */   }
/*    */   
/*    */   public void setText(int paramInt) {
/* 52 */     this.posText = paramInt;
/*    */   }
/*    */   
/*    */   public int getChar() {
/* 56 */     return this.posChar;
/*    */   }
/*    */   
/*    */   public void setChar(int paramInt) {
/* 60 */     this.posChar = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\PositionInParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */