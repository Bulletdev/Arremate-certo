/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
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
/*    */ public class XWPFSDT
/*    */   extends AbstractXWPFSDT
/*    */   implements IBodyElement, IRunBody, IRunElement, ISDTContents
/*    */ {
/*    */   private final ISDTContent content;
/*    */   
/*    */   public XWPFSDT(CTSdtRun paramCTSdtRun, IBody paramIBody) {
/* 33 */     super(paramCTSdtRun.getSdtPr(), paramIBody);
/* 34 */     this.content = new XWPFSDTContent(paramCTSdtRun.getSdtContent(), paramIBody, this);
/*    */   }
/*    */   
/*    */   public XWPFSDT(CTSdtBlock paramCTSdtBlock, IBody paramIBody) {
/* 38 */     super(paramCTSdtBlock.getSdtPr(), paramIBody);
/* 39 */     this.content = new XWPFSDTContent(paramCTSdtBlock.getSdtContent(), paramIBody, this);
/*    */   }
/*    */   
/*    */   public ISDTContent getContent() {
/* 43 */     return this.content;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFSDT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */