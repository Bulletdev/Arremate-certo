/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum e
/*    */ {
/*  8 */   a("por lote"),
/*  9 */   b("por item"),
/* 10 */   c("outros");
/*    */   
/*    */   private final String aH;
/*    */   
/*    */   e(String paramString1) {
/* 15 */     this.aH = paramString1;
/*    */   }
/*    */   
/*    */   public String K() {
/* 19 */     return this.aH;
/*    */   }
/*    */   
/*    */   public static e a(String paramString) {
/* 23 */     for (e e1 : values()) {
/* 24 */       if (e1.K().equals(paramString.toLowerCase())) {
/* 25 */         return e1;
/*    */       }
/*    */     } 
/*    */     
/* 29 */     return c;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */