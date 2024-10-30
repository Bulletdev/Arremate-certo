/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.g;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
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
/*     */ public class h
/*     */   extends f
/*     */ {
/*     */   public h(e parame) {
/*  32 */     this(parame, false);
/*     */   }
/*     */   
/*     */   public h(e parame, boolean paramBoolean) {
/*  36 */     super(parame, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/*  41 */     Object[] arrayOfObject = new Object[o.a.length];
/*  42 */     arrayOfObject[0] = b().a();
/*  43 */     arrayOfObject[1] = b().bo();
/*  44 */     arrayOfObject[2] = b().K();
/*     */     
/*  46 */     if (bA()) {
/*  47 */       arrayOfObject[3] = "Carregando...";
/*  48 */       arrayOfObject[4] = "Carregando...";
/*     */       
/*  50 */       arrayOfObject[5] = "Carregando...";
/*  51 */       arrayOfObject[6] = "Carregando...";
/*  52 */       arrayOfObject[7] = "Carregando...";
/*  53 */       arrayOfObject[8] = "Carregando...";
/*  54 */       arrayOfObject[9] = "Carregando...";
/*  55 */       arrayOfObject[10] = "Carregando...";
/*     */     } else {
/*  57 */       br.com.arremate.l.h h1 = b().f();
/*  58 */       double d = b().f();
/*  59 */       arrayOfObject[3] = Double.valueOf(d);
/*  60 */       arrayOfObject[4] = Double.valueOf(h1.m());
/*     */ 
/*     */       
/*  63 */       if (n.bQ()) {
/*  64 */         arrayOfObject[5] = h1.av();
/*  65 */         arrayOfObject[6] = h1.ay();
/*  66 */         arrayOfObject[7] = h1.bL();
/*  67 */         arrayOfObject[8] = h1.bK();
/*  68 */         arrayOfObject[9] = h1.bH();
/*  69 */         arrayOfObject[10] = h1.bI();
/*     */       } else {
/*  71 */         arrayOfObject[5] = "";
/*  72 */         arrayOfObject[6] = "";
/*  73 */         arrayOfObject[7] = "";
/*  74 */         arrayOfObject[8] = "";
/*  75 */         arrayOfObject[9] = "";
/*  76 */         arrayOfObject[10] = "";
/*     */       } 
/*     */     } 
/*  79 */     arrayOfObject[11] = ck();
/*  80 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String ck() {
/*  86 */     String str1, str2 = b().bo();
/*     */     
/*  88 */     if (b() instanceof br.com.arremate.l.q.b.f) {
/*  89 */       str2 = str2.replace("G", "");
/*  90 */       str1 = b().a().x() + " " + y.h(8, str2);
/*     */     } else {
/*  92 */       str1 = b().a().x() + " " + y.h(5, str2);
/*     */     } 
/*     */ 
/*     */     
/*  96 */     if (b() instanceof g) {
/*  97 */       e e = ((g)b()).a();
/*  98 */       String str3 = e.bo().replace("G", "");
/*  99 */       String str4 = e.a().x() + " " + y.h(8, str3);
/* 100 */       str1 = str4 + " " + y.h(5, str2);
/*     */     } 
/* 102 */     return str1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */