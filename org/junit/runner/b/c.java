/*     */ package org.junit.runner.b;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import org.junit.runner.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*  22 */   private final List<b> listeners = new CopyOnWriteArrayList<b>();
/*     */ 
/*     */   
/*     */   private volatile boolean do = false;
/*     */ 
/*     */   
/*     */   public void a(b paramb) {
/*  29 */     if (paramb == null) {
/*  30 */       throw new NullPointerException("Cannot add a null listener");
/*     */     }
/*  32 */     this.listeners.add(a(paramb));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(b paramb) {
/*  39 */     if (paramb == null) {
/*  40 */       throw new NullPointerException("Cannot remove a null listener");
/*     */     }
/*  42 */     this.listeners.remove(a(paramb));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b a(b paramb) {
/*  50 */     return paramb.getClass().isAnnotationPresent((Class)b.a.class) ? paramb : new e(paramb, this);
/*     */   }
/*     */ 
/*     */   
/*     */   private abstract class a
/*     */   {
/*     */     private final List<b> aO;
/*     */     
/*     */     a() {
/*  59 */       this(c.a(c.this));
/*     */     }
/*     */     
/*     */     a(List<b> param1List) {
/*  63 */       this.aO = param1List;
/*     */     }
/*     */     
/*     */     void run() {
/*  67 */       int i = this.aO.size();
/*  68 */       ArrayList<b> arrayList = new ArrayList(i);
/*  69 */       ArrayList<a> arrayList1 = new ArrayList(i);
/*  70 */       for (b b : this.aO) {
/*     */         try {
/*  72 */           d(b);
/*  73 */           arrayList.add(b);
/*  74 */         } catch (Exception exception) {
/*  75 */           arrayList1.add(new a(org.junit.runner.c.e, exception));
/*     */         } 
/*     */       } 
/*  78 */       c.a(this.c, arrayList, arrayList1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void d(b param1b) throws Exception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void k(org.junit.runner.c paramc) {
/*  88 */     (new a(this, paramc)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/*  91 */           param1b.h((org.junit.runner.c)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(k paramk) {
/* 100 */     (new a(this, paramk)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 103 */           param1b.a((k)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void l(org.junit.runner.c paramc) {
/* 118 */     (new a(this, paramc)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 121 */           param1b.i((org.junit.runner.c)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m(org.junit.runner.c paramc) {
/* 135 */     (new a(this, paramc)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 138 */           param1b.j((org.junit.runner.c)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void n(org.junit.runner.c paramc) throws d {
/* 150 */     if (this.do) {
/* 151 */       throw new d();
/*     */     }
/* 153 */     (new a(this, paramc)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 156 */           param1b.b((org.junit.runner.c)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(a parama) {
/* 167 */     a(this.listeners, Arrays.asList(new a[] { parama }));
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(List<b> paramList, List<a> paramList1) {
/* 172 */     if (!paramList1.isEmpty()) {
/* 173 */       (new a(this, paramList, paramList1)
/*     */         {
/*     */           protected void d(b param1b) throws Exception {
/* 176 */             for (a a1 : this.aN) {
/* 177 */               param1b.a(a1);
/*     */             }
/*     */           }
/*     */         }).run();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(a parama) {
/* 192 */     (new a(this, parama)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 195 */           param1b.b(this.a);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void o(org.junit.runner.c paramc) {
/* 206 */     (new a(this, paramc)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 209 */           param1b.c((org.junit.runner.c)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void p(org.junit.runner.c paramc) {
/* 222 */     (new a(this, paramc)
/*     */       {
/*     */         protected void d(b param1b) throws Exception {
/* 225 */           param1b.a((org.junit.runner.c)this.c);
/*     */         }
/*     */       }).run();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void iK() {
/* 237 */     this.do = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(b paramb) {
/* 244 */     if (paramb == null) {
/* 245 */       throw new NullPointerException("Cannot add a null listener");
/*     */     }
/* 247 */     this.listeners.add(0, a(paramb));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\b\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */