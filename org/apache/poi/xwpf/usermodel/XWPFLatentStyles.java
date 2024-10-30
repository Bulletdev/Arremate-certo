/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
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
/*    */ public class XWPFLatentStyles
/*    */ {
/*    */   protected XWPFStyles styles;
/*    */   private CTLatentStyles latentStyles;
/*    */   
/*    */   protected XWPFLatentStyles() {}
/*    */   
/*    */   protected XWPFLatentStyles(CTLatentStyles paramCTLatentStyles) {
/* 31 */     this(paramCTLatentStyles, null);
/*    */   }
/*    */   
/*    */   protected XWPFLatentStyles(CTLatentStyles paramCTLatentStyles, XWPFStyles paramXWPFStyles) {
/* 35 */     this.latentStyles = paramCTLatentStyles;
/* 36 */     this.styles = paramXWPFStyles;
/*    */   }
/*    */   
/*    */   public int getNumberOfStyles() {
/* 40 */     return this.latentStyles.sizeOfLsdExceptionArray();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isLatentStyle(String paramString) {
/* 47 */     for (CTLsdException cTLsdException : this.latentStyles.getLsdExceptionArray()) {
/* 48 */       if (cTLsdException.getName().equals(paramString)) {
/* 49 */         return true;
/*    */       }
/*    */     } 
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFLatentStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */