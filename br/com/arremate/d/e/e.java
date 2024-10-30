/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.e.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import br.com.arremate.l.q.b.g;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.List;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ public abstract class e
/*     */   extends f
/*     */ {
/*     */   private final c a;
/*     */   private final SimpleDateFormat dateFormat;
/*     */   private String Y;
/*     */   private i c;
/*     */   
/*     */   public e(br.com.arremate.l.q.b.e parame, br.com.arremate.j.c.e parame1, p paramp) {
/*  26 */     super(parame, (i)parame1, paramp);
/*     */     
/*  28 */     this.a = new c(b(), parame, parame1);
/*  29 */     this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/*     */     
/*  31 */     this.Y = "";
/*     */   }
/*     */   
/*     */   protected g a(String paramString1, String paramString2) {
/*  35 */     return a(paramString1, paramString2, null);
/*     */   }
/*     */   
/*     */   protected g a(String paramString1, String paramString2, String paramString3) {
/*  39 */     n(paramString2);
/*     */     
/*  41 */     switch (paramString1) {
/*     */       case "2":
/*  43 */         return g.av;
/*     */       case "3":
/*  45 */         return g.t;
/*     */       case "4":
/*  47 */         return g.u;
/*     */       case "5":
/*  49 */         return g.r;
/*     */       case "6":
/*  51 */         return g.au;
/*     */       case "7":
/*  53 */         return g.at;
/*     */     } 
/*     */     
/*  56 */     switch (paramString2) {
/*     */       case "LA":
/*  58 */         return g.f;
/*     */       case "AL":
/*  60 */         return g.k;
/*     */       case "AF":
/*  62 */         return g.n;
/*     */       case "LF":
/*  64 */         switch (paramString3) {
/*     */           case "1":
/*  66 */             return g.h;
/*     */           case "3":
/*     */           case "7":
/*  69 */             return g.i;
/*     */           case "5":
/*  71 */             return g.o;
/*     */           case "11":
/*  73 */             return g.p;
/*     */         } 
/*  75 */         return g.h;
/*     */       
/*     */       case "F":
/*  78 */         return g.a;
/*     */       case "AS":
/*  80 */         return g.b;
/*     */       case "AP":
/*  82 */         return g.c;
/*     */       case "AA":
/*  84 */         return g.d;
/*     */       case "LS":
/*  86 */         return g.e;
/*     */       case "FE":
/*     */       case "PE":
/*  89 */         return g.l;
/*     */       case "RA":
/*  91 */         return g.m;
/*     */       case "AM":
/*     */       case "DM":
/*     */       case "A7":
/*     */       case "D7":
/*  96 */         return g.q;
/*     */       case "E":
/*  98 */         return g.s;
/*     */     } 
/*     */ 
/*     */     
/* 102 */     return null;
/*     */   }
/*     */   
/*     */   private void n(String paramString) {
/* 106 */     if (a() instanceof f) {
/* 107 */       ((f)a()).a().n(paramString);
/*     */     } else {
/* 109 */       ((a)a().a()).n(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String u() {
/* 114 */     if (a() instanceof f)
/* 115 */       return ((f)a()).a().u(); 
/* 116 */     if (a() instanceof g) {
/* 117 */       return ((g)a()).a().u();
/*     */     }
/* 119 */     return ((a)a().a()).u();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 125 */     return this.a.j();
/*     */   }
/*     */ 
/*     */   
/*     */   public final p b() {
/* 130 */     return (p)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.j.c.e a() {
/* 135 */     return (br.com.arremate.j.c.e)super.b();
/*     */   }
/*     */   
/*     */   protected SimpleDateFormat getDateFormat() {
/* 139 */     return this.dateFormat;
/*     */   }
/*     */   
/*     */   protected i i() {
/* 143 */     return this.c;
/*     */   }
/*     */   
/*     */   protected void b(i parami) {
/* 147 */     this.c = parami;
/*     */   }
/*     */   
/*     */   protected String v() {
/* 151 */     return this.Y;
/*     */   }
/*     */   
/*     */   protected void o(String paramString) {
/* 155 */     this.Y = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */