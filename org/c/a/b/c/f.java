/*    */ package org.c.a.b.c;
/*    */ 
/*    */ import java.util.concurrent.Callable;
/*    */ import org.c.a.a.f.a;
/*    */ import org.c.a.a.f.c;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.b;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.h.i;
/*    */ import org.c.a.b.p.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class f
/*    */ {
/* 32 */   private static final a a = c.b(f.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final a b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final d[] a;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final c a;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public f(b paramb, d[] paramArrayOfd, c paramc) {
/* 57 */     this.b = paramb.a();
/* 58 */     this.a = (c)paramArrayOfd;
/* 59 */     this.a = paramc;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hS() {
/* 66 */     byte b = 0;
/*    */     while (true) {
/*    */       try {
/* 69 */         (new i(this.b.c())).execute(new Callable(this)
/*    */             {
/*    */               public Void b() {
/* 72 */                 for (d d : f.a(this.a)) {
/* 73 */                   if (d.exists()) {
/* 74 */                     f.a().debug("Schema " + d + " already exists. Skipping schema creation.");
/* 75 */                     return null;
/*    */                   } 
/*    */                 } 
/*    */                 
/* 79 */                 for (d d : f.a(this.a)) {
/* 80 */                   f.a().info("Creating schema " + d + " ...");
/* 81 */                   d.hS();
/*    */                 } 
/*    */                 
/* 84 */                 f.a(this.a).hS();
/* 85 */                 f.a(this.a).a(f.a(this.a));
/*    */                 
/* 87 */                 return null;
/*    */               }
/*    */             });
/*    */         return;
/* 91 */       } catch (RuntimeException runtimeException) {
/* 92 */         if (++b >= 10) {
/* 93 */           throw runtimeException;
/*    */         }
/*    */         try {
/* 96 */           a.debug("Schema creation failed. Retrying in 1 sec ...");
/* 97 */           Thread.sleep(1000L);
/* 98 */         } catch (InterruptedException interruptedException) {}
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\c\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */