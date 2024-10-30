/*    */ package br.com.arremate.j.i;
/*    */ 
/*    */ import br.com.arremate.l.d;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */ {
/*    */   private final HashMap<Long, b> b;
/*    */   
/*    */   public static c a() {
/* 16 */     return a.b();
/*    */   }
/*    */   
/*    */   private c() {
/* 20 */     this.b = new HashMap<>();
/*    */   }
/*    */   
/*    */   public b a(d paramd) {
/* 24 */     synchronized (this.b) {
/*    */       b b;
/*    */       
/* 27 */       if (!this.b.containsKey(Long.valueOf(paramd.x()))) {
/* 28 */         b = new b(paramd);
/* 29 */         if (paramd.x() != 0L && b.z() == 1) {
/* 30 */           this.b.put(Long.valueOf(paramd.x()), b);
/*    */         }
/*    */       } else {
/* 33 */         b = this.b.get(Long.valueOf(paramd.x()));
/* 34 */         b.bJ();
/*    */       } 
/*    */       
/* 37 */       return b;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean a(b paramb) {
/* 42 */     synchronized (this.b) {
/* 43 */       if (paramb.A() > 1) {
/* 44 */         paramb.bK();
/* 45 */         return false;
/*    */       } 
/* 47 */       d d = paramb.a();
/* 48 */       this.b.remove(Long.valueOf(d.x()));
/* 49 */       return true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static class a
/*    */   {
/* 56 */     private static final c a = new c();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\i\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */