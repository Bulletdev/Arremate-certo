/*     */ package org.c.a.b.c;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.b.e;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.h.i;
/*     */ import org.c.a.b.p.c;
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
/*     */ public class a
/*     */ {
/*  37 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.e.a.a b;
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
/*     */   private final g e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String jS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.a.a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final d a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(b paramb, c paramc, d paramd, g paramg, String paramString, org.c.a.b.a.a parama) {
/*  81 */     this.b = paramb.a();
/*  82 */     this.a = (d)paramc;
/*  83 */     this.a = paramd;
/*  84 */     this.e = paramg;
/*  85 */     this.jS = paramString;
/*  86 */     this.a = (d)parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hO() {
/*  93 */     this.a.a(e.y);
/*     */     
/*     */     try {
/*  96 */       this.a.hS();
/*  97 */       (new i(this.b.c())).execute(new Callable(this)
/*     */           {
/*     */             public Void b() {
/* 100 */               a.a(this.a).hU();
/* 101 */               a.a(this.a).c(a.a(this.a));
/* 102 */               org.c.a.b.p.a a1 = a.a(this.a).b();
/* 103 */               if (a1 != null) {
/* 104 */                 if (a.a(this.a).equals(a1.c()) && 
/* 105 */                   a.a(this.a).equals(a1.getDescription())) {
/* 106 */                   a.b().info("Schema history table " + a.a(this.a) + " already initialized with (" + 
/* 107 */                       a.a(this.a) + "," + a.a(this.a) + "). Skipping.");
/* 108 */                   return null;
/*     */                 } 
/* 110 */                 throw new org.c.a.a.a("Unable to baseline schema history table " + a.a(this.a) + " with (" + 
/* 111 */                     a.a(this.a) + "," + a.a(this.a) + ") as it has already been initialized with (" + a1
/*     */                     
/* 113 */                     .c() + "," + a1.getDescription() + ")");
/*     */               } 
/* 115 */               if (a.a(this.a).fS() && a.a(this.a).equals(g.a("0"))) {
/* 116 */                 throw new org.c.a.a.a("Unable to baseline schema history table " + a.a(this.a) + " with version 0 as this version was used for schema creation");
/*     */               }
/* 118 */               if (a.a(this.a).fR()) {
/* 119 */                 throw new org.c.a.a.a("Unable to baseline schema history table " + a.a(this.a) + " as it already contains migrations");
/*     */               }
/* 121 */               a.a(this.a).a(a.a(this.a), a.a(this.a));
/*     */               
/* 123 */               return null;
/*     */             }
/*     */           });
/* 126 */     } catch (org.c.a.a.a a1) {
/* 127 */       this.a.a(e.A);
/* 128 */       throw a1;
/*     */     } 
/*     */     
/* 131 */     a.info("Successfully baselined schema with version: " + this.e);
/*     */     
/* 133 */     this.a.a(e.z);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */