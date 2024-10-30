/*    */ package br.com.arremate.k.c;
/*    */ 
/*    */ import br.com.arremate.j.l.a.d;
/*    */ import br.com.arremate.l.d;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */ {
/* 13 */   private static final b a = new b();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 18 */   private final HashMap<Long, d> b = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static b a() {
/* 22 */     return a;
/*    */   }
/*    */   
/*    */   public d a(d paramd) {
/* 26 */     if (!this.b.containsKey(Long.valueOf(paramd.x()))) {
/* 27 */       d d1 = new d(paramd);
/* 28 */       this.b.put(Long.valueOf(paramd.x()), d1);
/*    */     } else {
/* 30 */       ((d)this.b.get(Long.valueOf(paramd.x()))).a(paramd);
/*    */     } 
/* 32 */     return this.b.get(Long.valueOf(paramd.x()));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */