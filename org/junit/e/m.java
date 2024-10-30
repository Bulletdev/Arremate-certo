/*     */ package org.junit.e;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.junit.c.b;
/*     */ import org.junit.e;
/*     */ import org.junit.f.a.h;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.runner.c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class m
/*     */   implements l
/*     */ {
/*     */   public l a(l paraml, c paramc) {
/*  54 */     return new l(this, paramc, paraml)
/*     */       {
/*     */         public void io() throws Throwable {
/*  57 */           ArrayList<b> arrayList = new ArrayList();
/*     */           
/*  59 */           m.a(this.a, this.c, arrayList);
/*     */           try {
/*  61 */             this.d.io();
/*  62 */             m.b(this.a, this.c, arrayList);
/*  63 */           } catch (b b) {
/*  64 */             arrayList.add(b);
/*  65 */             m.a(this.a, b, this.c, arrayList);
/*  66 */           } catch (Throwable throwable) {
/*  67 */             arrayList.add(throwable);
/*  68 */             m.a(this.a, throwable, this.c, arrayList);
/*     */           } finally {
/*  70 */             m.c(this.a, this.c, arrayList);
/*     */           } 
/*     */           
/*  73 */           h.I(arrayList);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(c paramc, List<Throwable> paramList) {
/*     */     try {
/*  81 */       f(paramc);
/*  82 */     } catch (Throwable throwable) {
/*  83 */       paramList.add(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Throwable paramThrowable, c paramc, List<Throwable> paramList) {
/*     */     try {
/*  90 */       a(paramThrowable, paramc);
/*  91 */     } catch (Throwable throwable) {
/*  92 */       paramList.add(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(b paramb, c paramc, List<Throwable> paramList) {
/*     */     try {
/* 100 */       if (paramb instanceof e) {
/* 101 */         a((e)paramb, paramc);
/*     */       } else {
/* 103 */         a(paramb, paramc);
/*     */       } 
/* 105 */     } catch (Throwable throwable) {
/* 106 */       paramList.add(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(c paramc, List<Throwable> paramList) {
/*     */     try {
/* 113 */       d(paramc);
/* 114 */     } catch (Throwable throwable) {
/* 115 */       paramList.add(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(c paramc, List<Throwable> paramList) {
/*     */     try {
/* 122 */       e(paramc);
/* 123 */     } catch (Throwable throwable) {
/* 124 */       paramList.add(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void f(c paramc) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(Throwable paramThrowable, c paramc) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(e parame, c paramc) {
/* 145 */     e e1 = parame;
/* 146 */     a((b)e1, paramc);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   protected void a(b paramb, c paramc) {}
/*     */   
/*     */   protected void d(c paramc) {}
/*     */   
/*     */   protected void e(c paramc) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */