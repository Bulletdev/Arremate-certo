/*    */ package br.com.arremate.k.a.b;
/*    */ 
/*    */ import br.com.arremate.d.b;
/*    */ import br.com.arremate.d.g;
/*    */ import br.com.arremate.d.t.c;
/*    */ import br.com.arremate.d.t.e;
/*    */ import br.com.arremate.f.u;
/*    */ import br.com.arremate.j.i;
/*    */ import br.com.arremate.l.j;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends c
/*    */ {
/*    */   public d(br.com.arremate.l.m.d paramd) {
/* 20 */     super((j)paramd);
/*    */   }
/*    */ 
/*    */   
/*    */   public g a(b paramb, i parami) {
/*    */     br.com.arremate.d.t.d d1;
/* 26 */     if (a().a() == u.a) {
/* 27 */       c c1 = new c(paramb, parami, true);
/*    */     } else {
/* 29 */       d1 = new br.com.arremate.d.t.d(paramb, parami, true);
/*    */     } 
/*    */     
/* 32 */     d1.setName("disputaSC_" + a().v());
/* 33 */     return (g)d1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean d(e parame, double paramDouble) {
/* 38 */     return ((e)d()).c(parame, paramDouble);
/*    */   }
/*    */ 
/*    */   
/*    */   protected g a(i parami) {
/* 43 */     if (a().a() == u.a) {
/* 44 */       return (g)new c(null, parami, false);
/*    */     }
/* 46 */     return (g)new br.com.arremate.d.t.d(null, parami, false);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */