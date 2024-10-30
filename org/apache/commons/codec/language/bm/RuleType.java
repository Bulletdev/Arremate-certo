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
/*    */ public enum RuleType
/*    */ {
/* 28 */   APPROX("approx"),
/*    */   
/* 30 */   EXACT("exact"),
/*    */   
/* 32 */   RULES("rules");
/*    */   
/*    */   private final String name;
/*    */   
/*    */   RuleType(String paramString1) {
/* 37 */     this.name = paramString1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 46 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\RuleType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */