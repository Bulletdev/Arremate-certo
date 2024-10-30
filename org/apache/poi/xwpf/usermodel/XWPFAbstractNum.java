/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
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
/*    */ public class XWPFAbstractNum
/*    */ {
/*    */   protected XWPFNumbering numbering;
/*    */   private CTAbstractNum ctAbstractNum;
/*    */   
/*    */   protected XWPFAbstractNum() {
/* 30 */     this.ctAbstractNum = null;
/* 31 */     this.numbering = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public XWPFAbstractNum(CTAbstractNum paramCTAbstractNum) {
/* 36 */     this.ctAbstractNum = paramCTAbstractNum;
/*    */   }
/*    */   
/*    */   public XWPFAbstractNum(CTAbstractNum paramCTAbstractNum, XWPFNumbering paramXWPFNumbering) {
/* 40 */     this.ctAbstractNum = paramCTAbstractNum;
/* 41 */     this.numbering = paramXWPFNumbering;
/*    */   }
/*    */   
/*    */   public CTAbstractNum getAbstractNum() {
/* 45 */     return this.ctAbstractNum;
/*    */   }
/*    */   
/*    */   public XWPFNumbering getNumbering() {
/* 49 */     return this.numbering;
/*    */   }
/*    */   
/*    */   public void setNumbering(XWPFNumbering paramXWPFNumbering) {
/* 53 */     this.numbering = paramXWPFNumbering;
/*    */   }
/*    */   
/*    */   public CTAbstractNum getCTAbstractNum() {
/* 57 */     return this.ctAbstractNum;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFAbstractNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */