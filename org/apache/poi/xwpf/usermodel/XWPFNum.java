/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
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
/*    */ public class XWPFNum
/*    */ {
/*    */   protected XWPFNumbering numbering;
/*    */   private CTNum ctNum;
/*    */   
/*    */   public XWPFNum() {
/* 30 */     this.ctNum = null;
/* 31 */     this.numbering = null;
/*    */   }
/*    */   
/*    */   public XWPFNum(CTNum paramCTNum) {
/* 35 */     this.ctNum = paramCTNum;
/* 36 */     this.numbering = null;
/*    */   }
/*    */   
/*    */   public XWPFNum(XWPFNumbering paramXWPFNumbering) {
/* 40 */     this.ctNum = null;
/* 41 */     this.numbering = paramXWPFNumbering;
/*    */   }
/*    */   
/*    */   public XWPFNum(CTNum paramCTNum, XWPFNumbering paramXWPFNumbering) {
/* 45 */     this.ctNum = paramCTNum;
/* 46 */     this.numbering = paramXWPFNumbering;
/*    */   }
/*    */   
/*    */   public XWPFNumbering getNumbering() {
/* 50 */     return this.numbering;
/*    */   }
/*    */   
/*    */   public void setNumbering(XWPFNumbering paramXWPFNumbering) {
/* 54 */     this.numbering = paramXWPFNumbering;
/*    */   }
/*    */   
/*    */   public CTNum getCTNum() {
/* 58 */     return this.ctNum;
/*    */   }
/*    */   
/*    */   public void setCTNum(CTNum paramCTNum) {
/* 62 */     this.ctNum = paramCTNum;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */