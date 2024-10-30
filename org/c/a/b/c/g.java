/*     */ package org.c.a.b.c;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.b.e;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.h.b;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.b.a.a;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.g.e;
/*     */ import org.c.a.b.h.i;
/*     */ import org.c.a.b.p.c;
/*     */ import org.c.a.b.r.l;
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
/*     */ public class g
/*     */ {
/*  43 */   private static final a a = c.b(g.class);
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
/*     */   private final d a;
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
/*     */   private final a b;
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
/*     */   private final boolean cz;
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
/*     */   
/*     */   public g(b paramb, c paramc, d paramd, c paramc1, b paramb1, boolean paramBoolean, a parama) {
/*  93 */     this.b = paramb.a();
/*  94 */     this.a = (a)paramc;
/*  95 */     this.a = (a)paramd;
/*  96 */     this.a = (a)paramc1;
/*  97 */     this.a = (a)paramb1;
/*  98 */     this.cz = paramBoolean;
/*  99 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ex() {
/* 108 */     if (!this.a.exists()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 114 */       if (!this.a.a(new b(this) { public b a() { return g.a(this.a); } }).isEmpty() && !this.cz) {
/* 115 */         return "Schema " + this.a + " doesn't exist yet";
/*     */       }
/* 117 */       return null;
/*     */     } 
/*     */     
/* 120 */     this.a.a(e.v);
/*     */     
/* 122 */     a.debug("Validating migrations ...");
/* 123 */     m m = new m();
/* 124 */     m.start();
/*     */     
/* 126 */     l l = (l)(new i(this.b.c())).execute(new Callable<l<Integer, String>>(this)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public l<Integer, String> a()
/*     */           {
/* 136 */             e e = new e(g.a(this.a), g.a(this.a), g.a(this.a), g.a(this.a).a(), g.a(this.a).fh(), g.a(this.a), g.a(this.a).eZ(), g.a(this.a).fa(), g.a(this.a).fc());
/*     */             
/* 138 */             e.cx();
/*     */             
/* 140 */             int i = (e.a()).length;
/* 141 */             String str = e.ex();
/* 142 */             return l.a(Integer.valueOf(i), str);
/*     */           }
/*     */         });
/*     */     
/* 146 */     m.stop();
/*     */     
/* 148 */     String str = (String)l.getRight();
/* 149 */     if (str == null) {
/* 150 */       int i = ((Integer)l.getLeft()).intValue();
/* 151 */       if (i == 1) {
/* 152 */         a.info(String.format("Successfully validated 1 migration (execution time %s)", new Object[] {
/* 153 */                 o.format(m.al()) }));
/*     */       } else {
/* 155 */         a.info(String.format("Successfully validated %d migrations (execution time %s)", new Object[] {
/* 156 */                 Integer.valueOf(i), o.format(m.al()) }));
/*     */       } 
/* 158 */       this.a.a(e.w);
/*     */     } else {
/* 160 */       this.a.a(e.x);
/*     */     } 
/*     */ 
/*     */     
/* 164 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */