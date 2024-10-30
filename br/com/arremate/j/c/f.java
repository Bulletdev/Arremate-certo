/*    */ package br.com.arremate.j.c;
/*    */ 
/*    */ import br.com.arremate.f.o;
/*    */ import br.com.arremate.l.d;
/*    */ import br.com.arremate.l.n;
/*    */ import br.com.arremate.m.g;
/*    */ import br.com.arremate.m.l;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class f
/*    */ {
/*    */   private final HashMap<Long, c> b;
/*    */   
/*    */   private f() {
/* 22 */     this.b = new HashMap<>();
/* 23 */     Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(a(), 1L, 5L, TimeUnit.MINUTES);
/*    */   }
/*    */   
/*    */   public static f a() {
/* 27 */     return a.b();
/*    */   }
/*    */   
/*    */   public c a(d paramd) {
/* 31 */     long l = paramd.x();
/* 32 */     if (c(l)) {
/* 33 */       return new c(paramd);
/*    */     }
/*    */     
/* 36 */     synchronized (this.b) {
/*    */       c c;
/*    */       
/* 39 */       if (!this.b.containsKey(Long.valueOf(l))) {
/* 40 */         if (paramd.b().a().equals(o.k)) {
/* 41 */           n n = l.a().a(o.a);
/* 42 */           d d1 = g.a(n, l);
/* 43 */           if (d1 == null) {
/* 44 */             c c1 = new c(paramd);
/* 45 */             c1.setMessage("Não foi possível realizar o login! Atualize os dados de acesso da sua empresa!");
/* 46 */             return c1;
/*    */           } 
/*    */           
/* 49 */           paramd = d1;
/*    */         } 
/*    */         
/* 52 */         c = new c(paramd);
/* 53 */         if (c.z() == 1) {
/* 54 */           this.b.put(Long.valueOf(l), c);
/*    */         }
/*    */       } else {
/* 57 */         c = this.b.get(Long.valueOf(l));
/* 58 */         if (c.aa()) {
/* 59 */           c.bM();
/* 60 */           this.b.remove(Long.valueOf(l));
/* 61 */           return c;
/*    */         } 
/*    */         
/* 64 */         if (!c.U() && 
/* 65 */           c.z() != 1) {
/* 66 */           c.bM();
/* 67 */           this.b.remove(Long.valueOf(l));
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 72 */       return c;
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean c(long paramLong) {
/* 77 */     return (paramLong == 0L);
/*    */   }
/*    */   
/*    */   private Runnable a() {
/* 81 */     return () -> {
/*    */         synchronized (this.b) {
/*    */           this.b.entrySet().forEach(());
/*    */         } 
/*    */       };
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
/*    */   private static class a
/*    */   {
/* 98 */     private static final f a = new f();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */