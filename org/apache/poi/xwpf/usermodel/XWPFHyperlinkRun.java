/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
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
/*    */ public class XWPFHyperlinkRun
/*    */   extends XWPFRun
/*    */ {
/*    */   private CTHyperlink hyperlink;
/*    */   
/*    */   public XWPFHyperlinkRun(CTHyperlink paramCTHyperlink, CTR paramCTR, IRunBody paramIRunBody) {
/* 31 */     super(paramCTR, paramIRunBody);
/* 32 */     this.hyperlink = paramCTHyperlink;
/*    */   }
/*    */   
/*    */   @Internal
/*    */   public CTHyperlink getCTHyperlink() {
/* 37 */     return this.hyperlink;
/*    */   }
/*    */   
/*    */   public String getAnchor() {
/* 41 */     return this.hyperlink.getAnchor();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getHyperlinkId() {
/* 48 */     return this.hyperlink.getId();
/*    */   }
/*    */   
/*    */   public void setHyperlinkId(String paramString) {
/* 52 */     this.hyperlink.setId(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XWPFHyperlink getHyperlink(XWPFDocument paramXWPFDocument) {
/* 60 */     String str = getHyperlinkId();
/* 61 */     if (str == null) {
/* 62 */       return null;
/*    */     }
/* 64 */     return paramXWPFDocument.getHyperlinkByID(str);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFHyperlinkRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */