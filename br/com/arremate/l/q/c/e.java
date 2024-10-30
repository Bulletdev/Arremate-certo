/*    */ package br.com.arremate.l.q.c;
/*    */ 
/*    */ import br.com.arremate.k.a.g;
/*    */ import br.com.arremate.l.n;
/*    */ import br.com.arremate.m.n;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */ {
/*    */   public static f b(br.com.arremate.l.q.b.e parame, g paramg) {
/* 12 */     return b(parame, paramg, false);
/*    */   }
/*    */   
/*    */   public static f b(br.com.arremate.l.q.b.e parame, g paramg, boolean paramBoolean) {
/* 16 */     if (n.bR()) {
/* 17 */       return new i(parame, paramg, paramBoolean);
/*    */     }
/* 19 */     return new h(parame, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public static k a(n paramn) {
/* 24 */     if (n.bR()) {
/* 25 */       return new m();
/*    */     }
/* 27 */     return new l();
/*    */   }
/*    */ 
/*    */   
/*    */   public static a a(k paramk, g paramg) {
/* 32 */     if (n.bR()) {
/* 33 */       if (n.bV()) {
/* 34 */         return new d(paramk, paramg);
/*    */       }
/* 36 */       return new b(paramk, paramg);
/*    */     } 
/*    */     
/* 39 */     return new a(paramk, paramg);
/*    */   }
/*    */ 
/*    */   
/*    */   public static a a(k paramk, g paramg, String paramString) {
/* 44 */     return new c(paramk, paramg, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */