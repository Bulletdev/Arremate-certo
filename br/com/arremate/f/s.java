/*    */ package br.com.arremate.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum s
/*    */ {
/* 11 */   a(1, "/img/bullet_green.png"),
/* 12 */   b(2, "/img/bullet_yellow.png"),
/* 13 */   c(3, "/img/bullet_red.png"),
/* 14 */   d(4, "/img/transparent.png");
/*    */   
/*    */   private final int aj;
/*    */   private final String aL;
/*    */   
/*    */   s(int paramInt1, String paramString1) {
/* 20 */     this.aj = paramInt1;
/* 21 */     this.aL = paramString1;
/*    */   }
/*    */   
/*    */   public static s a(int paramInt) {
/* 25 */     for (s s1 : values()) {
/* 26 */       if (s1.x() == paramInt) {
/* 27 */         return s1;
/*    */       }
/*    */     } 
/*    */     
/* 31 */     return d;
/*    */   }
/*    */   
/*    */   public int x() {
/* 35 */     return this.aj;
/*    */   }
/*    */   
/*    */   public String O() {
/* 39 */     return this.aL;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */