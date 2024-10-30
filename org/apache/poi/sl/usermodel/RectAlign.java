/*    */ package org.apache.poi.sl.usermodel;
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
/*    */ 
/*    */ public enum RectAlign
/*    */ {
/* 29 */   TOP_LEFT("tl"),
/*    */ 
/*    */   
/* 32 */   TOP("t"),
/*    */ 
/*    */   
/* 35 */   TOP_RIGHT("tr"),
/*    */ 
/*    */   
/* 38 */   LEFT("l"),
/*    */ 
/*    */   
/* 41 */   CENTER("ctr"),
/*    */ 
/*    */   
/* 44 */   RIGHT("r"),
/*    */ 
/*    */   
/* 47 */   BOTTOM_LEFT("bl"),
/*    */ 
/*    */   
/* 50 */   BOTTOM("b"),
/*    */ 
/*    */   
/* 53 */   BOTTOM_RIGHT("br");
/*    */   
/*    */   private final String dir;
/*    */ 
/*    */   
/*    */   RectAlign(String paramString1) {
/* 59 */     this.dir = paramString1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 69 */     return this.dir;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\RectAlign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */