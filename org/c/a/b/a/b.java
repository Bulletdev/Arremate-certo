/*     */ package org.c.a.b.a;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.b.c;
/*     */ import org.c.a.a.b.e;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.h.i;
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
/*     */ public class b
/*     */   implements a
/*     */ {
/*     */   private final org.c.a.a.c.b a;
/*     */   private final org.c.a.b.e.a.b a;
/*     */   private final d a;
/*     */   private final Collection<org.c.a.a.b.b> j;
/*     */   private c a;
/*     */   
/*     */   public b(org.c.a.a.c.b paramb, org.c.a.b.e.a.b paramb1, d paramd, Collection<org.c.a.a.b.b> paramCollection) {
/*  54 */     this.a = (c)paramb;
/*  55 */     this.a = (c)paramb1;
/*  56 */     this.a = (c)paramd;
/*  57 */     this.j = paramCollection;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(e parame) {
/*  62 */     a(parame, this.a.a());
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(e parame) {
/*  67 */     a(parame, this.a.b());
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(c paramc) {
/*  72 */     this.a = paramc;
/*     */   }
/*     */ 
/*     */   
/*     */   public void c(e parame) {
/*  77 */     f f = new f((org.c.a.a.c.b)this.a, this.a.b(), this.a);
/*  78 */     for (org.c.a.a.b.b b1 : this.j) {
/*  79 */       if (b1.a(parame, f)) {
/*  80 */         b1.a(parame, f);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(e parame, a parama) {
/* 100 */     f f = new f((org.c.a.a.c.b)this.a, parama, null);
/*     */     
/* 102 */     for (org.c.a.a.b.b b1 : this.j) {
/* 103 */       if (b1.a(parame, f)) {
/* 104 */         if (b1.b(parame, f)) {
/* 105 */           (new i(parama.c())).execute(new Callable<Void>(this, parama, b1, parame, f)
/*     */               {
/*     */                 public Void b() {
/* 108 */                   b.a(this.a, (a)this.a, (org.c.a.a.b.b)this.a, this.H, (c)this.a);
/* 109 */                   return null; }
/*     */               });
/*     */           continue;
/*     */         } 
/* 113 */         a(parama, b1, parame, f);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(a parama, org.c.a.a.b.b paramb, e parame, c paramc) {
/* 120 */     parama.hU();
/* 121 */     parama.c((d)this.a);
/* 122 */     a(paramb, parame, paramc);
/*     */   }
/*     */   
/*     */   private void a(org.c.a.a.b.b paramb, e parame, c paramc) {
/*     */     try {
/* 127 */       paramb.a(parame, paramc);
/* 128 */     } catch (RuntimeException runtimeException) {
/* 129 */       throw new a("Error while executing " + parame.getId() + " callback: " + runtimeException.getMessage(), runtimeException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */