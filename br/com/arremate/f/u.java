/*    */ package br.com.arremate.f;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.LinkedHashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum u
/*    */ {
/* 12 */   a(1),
/* 13 */   b(2),
/* 14 */   c(3),
/* 15 */   d(4),
/* 16 */   e(5),
/* 17 */   f(6),
/* 18 */   g(7),
/* 19 */   h(8),
/* 20 */   i(9),
/* 21 */   j(10),
/* 22 */   k(11),
/* 23 */   l(11);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int ai;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   u(int paramInt1) {
/* 36 */     this.ai = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int w() {
/* 45 */     return this.ai;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static u a(int paramInt) {
/* 55 */     LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList((Object[])values()));
/* 56 */     for (u u1 : linkedHashSet) {
/* 57 */       if (u1.w() == paramInt) {
/* 58 */         return u1;
/*    */       }
/*    */     } 
/*    */     
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */