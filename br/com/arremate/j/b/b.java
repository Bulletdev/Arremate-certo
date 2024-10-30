/*    */ package br.com.arremate.j.b;
/*    */ 
/*    */ import br.com.arremate.l.d;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */ {
/* 16 */   private final HashMap<Long, a> b = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static b a() {
/* 20 */     return a.b();
/*    */   }
/*    */   
/*    */   public a a(d paramd, boolean paramBoolean) {
/* 24 */     synchronized (this.b) {
/* 25 */       a a; long l = paramd.x();
/*    */ 
/*    */       
/* 28 */       if (!this.b.containsKey(Long.valueOf(l))) {
/* 29 */         a = new a(paramd, paramBoolean);
/*    */ 
/*    */ 
/*    */         
/* 33 */         if (l != 0L && a.z() == 1) {
/* 34 */           this.b.put(Long.valueOf(l), a);
/*    */         }
/*    */       } else {
/* 37 */         a = this.b.get(Long.valueOf(l));
/* 38 */         if (a.aa()) {
/* 39 */           a.b();
/* 40 */           this.b.remove(Long.valueOf(l));
/* 41 */           return a;
/*    */         } 
/*    */         
/* 44 */         a.bJ();
/*    */       } 
/*    */       
/* 47 */       return a;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean a(a parama) {
/* 52 */     synchronized (this.b) {
/* 53 */       if (parama.A() > 1) {
/* 54 */         parama.bK();
/* 55 */         return false;
/*    */       } 
/* 57 */       parama.bI();
/*    */       
/* 59 */       d d = parama.a();
/* 60 */       this.b.remove(Long.valueOf(d.x()));
/* 61 */       return true;
/*    */     } 
/*    */   }
/*    */   
/*    */   private b() {}
/*    */   
/*    */   private static class a {
/* 68 */     private static final b a = new b();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */