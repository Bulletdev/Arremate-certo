/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.h;
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
/*     */ public class j
/*     */   extends f
/*     */ {
/*     */   private boolean ah;
/*     */   
/*     */   protected j(e parame) {
/*  24 */     this(parame, false);
/*     */   }
/*     */   
/*     */   protected j(e parame, boolean paramBoolean) {
/*  28 */     super(parame, paramBoolean);
/*  29 */     this.ah = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/*  34 */     Object[] arrayOfObject = new Object[p.a.length];
/*  35 */     arrayOfObject[0] = "/img/transparent.png";
/*  36 */     arrayOfObject[1] = b().a();
/*  37 */     arrayOfObject[2] = b().m();
/*  38 */     arrayOfObject[3] = b().bo();
/*  39 */     arrayOfObject[4] = b().K();
/*     */     
/*  41 */     if (bA()) {
/*  42 */       arrayOfObject[5] = "Carregando...";
/*     */       
/*  44 */       arrayOfObject[6] = "Carregando...";
/*  45 */       arrayOfObject[7] = "Carregando...";
/*  46 */       arrayOfObject[8] = "Carregando...";
/*  47 */       arrayOfObject[9] = "Carregando...";
/*  48 */       arrayOfObject[10] = "Carregando...";
/*  49 */       arrayOfObject[11] = "Carregando...";
/*     */     } else {
/*  51 */       h h = b().f();
/*  52 */       arrayOfObject[5] = Double.valueOf(h.m());
/*     */ 
/*     */       
/*  55 */       if (n.bQ()) {
/*  56 */         arrayOfObject[6] = h.av();
/*  57 */         arrayOfObject[7] = h.ay();
/*  58 */         arrayOfObject[8] = h.bL();
/*  59 */         arrayOfObject[9] = h.bK();
/*  60 */         arrayOfObject[10] = h.bH();
/*  61 */         arrayOfObject[11] = h.bI();
/*     */       } else {
/*  63 */         arrayOfObject[6] = "";
/*  64 */         arrayOfObject[7] = "";
/*  65 */         arrayOfObject[8] = "";
/*  66 */         arrayOfObject[9] = "";
/*  67 */         arrayOfObject[10] = "";
/*  68 */         arrayOfObject[11] = "";
/*     */       } 
/*     */     } 
/*  71 */     arrayOfObject[12] = Boolean.valueOf(bp());
/*  72 */     arrayOfObject[13] = ck();
/*  73 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String ck() {
/*  79 */     String str1, str2 = b().bo();
/*     */     
/*  81 */     if (b() instanceof br.com.arremate.l.q.b.f) {
/*  82 */       str2 = str2.replace("G", "");
/*  83 */       str1 = b().a().x() + " " + y.h(8, str2);
/*     */     } else {
/*  85 */       str1 = b().a().x() + " " + y.h(5, str2);
/*     */     } 
/*     */ 
/*     */     
/*  89 */     if (b() instanceof g) {
/*  90 */       e e = ((g)b()).a();
/*  91 */       String str3 = e.bo().replace("G", "");
/*  92 */       String str4 = e.a().x() + " " + y.h(8, str3);
/*  93 */       str1 = str4 + " " + y.h(5, str2);
/*     */     } 
/*  95 */     return str1;
/*     */   }
/*     */   
/*     */   public void R(boolean paramBoolean) {
/*  99 */     this.ah = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean bp() {
/* 103 */     return this.ah;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */