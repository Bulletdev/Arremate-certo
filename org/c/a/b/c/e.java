/*     */ package org.c.a.b.c;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.a.h.d;
/*     */ import org.c.a.b.a.a;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.g.d;
/*     */ import org.c.a.b.h.i;
/*     */ import org.c.a.b.p.a;
/*     */ import org.c.a.b.p.c;
/*     */ import org.c.a.b.r.k;
/*     */ import org.c.a.b.r.m;
/*     */ import org.c.a.b.r.o;
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
/*     */ public class e
/*     */ {
/*  46 */   private static final a a = c.b(e.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final a b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.g.e a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final c a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(b paramb, c paramc, c paramc1, a parama, b paramb1) {
/*  83 */     this.a = paramb;
/*  84 */     this.b = paramb.a();
/*  85 */     this.a = (b)new org.c.a.b.g.e(paramc, paramc1, paramb1, g.b, true, true, true, true, true);
/*     */     
/*  87 */     this.a = (b)paramc1;
/*  88 */     this.a = (b)parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hP() {
/*  95 */     this.a.a(org.c.a.a.b.e.B);
/*     */     
/*     */     try {
/*  98 */       m m = new m();
/*  99 */       m.start();
/*     */       
/* 101 */       boolean bool = ((Boolean)(new i(this.b.c())).execute(new Callable<Boolean>(this) {
/*     */             public Boolean b() {
/* 103 */               e.a(this.a).ij();
/* 104 */               e.a(this.a).cx();
/*     */               
/* 106 */               return Boolean.valueOf(e.a(this.a));
/*     */             }
/*     */           })).booleanValue();
/*     */       
/* 110 */       m.stop();
/*     */       
/* 112 */       a.info("Successfully repaired schema history table " + this.a + " (execution time " + 
/* 113 */           o.format(m.al()) + ").");
/* 114 */       if (bool && !this.a.fx()) {
/* 115 */         a.info("Manual cleanup of the remaining effects the failed migration may still be required.");
/*     */       }
/* 117 */     } catch (a a1) {
/* 118 */       this.a.a(org.c.a.a.b.e.D);
/* 119 */       throw a1;
/*     */     } 
/*     */     
/* 122 */     this.a.a(org.c.a.a.b.e.C);
/*     */   }
/*     */   
/*     */   private boolean fw() {
/* 126 */     boolean bool = false;
/* 127 */     for (c c1 : this.a.a()) {
/* 128 */       d d = (d)c1;
/*     */       
/* 130 */       d d1 = d.a();
/* 131 */       a a1 = d.a();
/* 132 */       if (d1 != null && d1
/* 133 */         .c() != null && a1 != null && 
/*     */         
/* 135 */         !a1.a().isSynthetic() && 
/*     */ 
/*     */ 
/*     */         
/* 139 */         a(d1, a1)) {
/* 140 */         this.a.a(a1, d1);
/* 141 */         bool = true;
/*     */       } 
/*     */     } 
/* 144 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean a(d paramd, a parama) {
/* 148 */     return (b(paramd, parama) || 
/* 149 */       c(paramd, parama) || 
/* 150 */       d(paramd, parama));
/*     */   }
/*     */   
/*     */   private boolean b(d paramd, a parama) {
/* 154 */     return !k.j(paramd.d(), parama.d());
/*     */   }
/*     */   
/*     */   private boolean c(d paramd, a parama) {
/* 158 */     return !k.j(paramd.getDescription(), parama.getDescription());
/*     */   }
/*     */   
/*     */   private boolean d(d paramd, a parama) {
/* 162 */     return !k.j(paramd.a(), parama.a());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\c\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */