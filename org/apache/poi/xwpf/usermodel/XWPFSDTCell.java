/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
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
/*    */ public class XWPFSDTCell
/*    */   extends AbstractXWPFSDT
/*    */   implements ICell
/*    */ {
/*    */   private final XWPFSDTContentCell cellContent;
/*    */   
/*    */   public XWPFSDTCell(CTSdtCell paramCTSdtCell, XWPFTableRow paramXWPFTableRow, IBody paramIBody) {
/* 34 */     super(paramCTSdtCell.getSdtPr(), paramIBody);
/* 35 */     this.cellContent = new XWPFSDTContentCell(paramCTSdtCell.getSdtContent(), paramXWPFTableRow, paramIBody);
/*    */   }
/*    */ 
/*    */   
/*    */   public ISDTContent getContent() {
/* 40 */     return this.cellContent;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFSDTCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */