/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum h
/*    */ {
/*  8 */   a(1, "1° lugar"),
/*  9 */   b(2, "2° lugar"),
/* 10 */   c(3, "3° lugar"),
/* 11 */   d(4, "4° lugar"),
/* 12 */   e(5, "5° lugar"),
/* 13 */   f(6, "Acima do 5°"),
/* 14 */   g(7, "1° lugar ME/EPP"),
/* 15 */   h(8, "Lance Derradeiro"),
/* 16 */   i(999, "1° lugar");
/*    */ 
/*    */ 
/*    */   
/*    */   private final int ah;
/*    */ 
/*    */   
/*    */   private final String aH;
/*    */ 
/*    */ 
/*    */   
/*    */   h(int paramInt1, String paramString1) {
/* 28 */     this.ah = paramInt1;
/* 29 */     this.aH = paramString1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int v() {
/* 38 */     return this.ah;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String K() {
/* 47 */     return this.aH;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static h a(int paramInt) {
/* 59 */     for (h h1 : values()) {
/* 60 */       if (h1.v() == paramInt) {
/* 61 */         return h1;
/*    */       }
/*    */     } 
/*    */     
/* 65 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */