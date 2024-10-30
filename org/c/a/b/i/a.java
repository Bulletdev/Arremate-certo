/*    */ package org.c.a.b.i;
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
/*    */ public enum a
/*    */ {
/* 22 */   a("Community"),
/* 23 */   b("Pro"),
/* 24 */   c("Enterprise");
/*    */ 
/*    */ 
/*    */   
/*    */   private final String description;
/*    */ 
/*    */ 
/*    */   
/*    */   a(String paramString1) {
/* 33 */     this.description = "Flyway " + paramString1 + " Edition";
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 37 */     return this.description;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 42 */     return this.description;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\i\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */