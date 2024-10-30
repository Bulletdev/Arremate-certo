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
/*    */ public class XWPFHyperlink
/*    */ {
/*    */   String id;
/*    */   String url;
/*    */   
/*    */   public XWPFHyperlink(String paramString1, String paramString2) {
/* 28 */     this.id = paramString1;
/* 29 */     this.url = paramString2;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 33 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getURL() {
/* 37 */     return this.url;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */