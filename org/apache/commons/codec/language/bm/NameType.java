/*    */ package org.apache.commons.codec.language.bm;
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
/*    */ 
/*    */ public enum NameType
/*    */ {
/* 30 */   ASHKENAZI("ash"),
/*    */ 
/*    */   
/* 33 */   GENERIC("gen"),
/*    */ 
/*    */   
/* 36 */   SEPHARDIC("sep");
/*    */   
/*    */   private final String name;
/*    */   
/*    */   NameType(String paramString1) {
/* 41 */     this.name = paramString1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 50 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\NameType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */