/*     */ package junit.textui;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Enumeration;
/*     */ import junit.b.b;
/*     */ import junit.b.i;
/*     */ import junit.b.k;
/*     */ import junit.b.l;
/*     */ import junit.b.m;
/*     */ 
/*     */ public class a
/*     */   implements l
/*     */ {
/*     */   PrintStream a;
/*  16 */   int hV = 0;
/*     */   
/*     */   public a(PrintStream paramPrintStream) {
/*  19 */     this.a = paramPrintStream;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void a(m paramm, long paramLong) {
/*  25 */     X(paramLong);
/*  26 */     c(paramm);
/*  27 */     d(paramm);
/*  28 */     e(paramm);
/*     */   }
/*     */   
/*     */   void hk() {
/*  32 */     a().println();
/*  33 */     a().println("<RETURN> to continue");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void X(long paramLong) {
/*  39 */     a().println();
/*  40 */     a().println("Time: " + b(paramLong));
/*     */   }
/*     */   
/*     */   protected void c(m paramm) {
/*  44 */     a(paramm.a(), paramm.bd(), "error");
/*     */   }
/*     */   
/*     */   protected void d(m paramm) {
/*  48 */     a(paramm.b(), paramm.be(), "failure");
/*     */   }
/*     */   
/*     */   protected void a(Enumeration<k> paramEnumeration, int paramInt, String paramString) {
/*  52 */     if (paramInt == 0)
/*  53 */       return;  if (paramInt == 1) {
/*  54 */       a().println("There was " + paramInt + " " + paramString + ":");
/*     */     } else {
/*  56 */       a().println("There were " + paramInt + " " + paramString + "s:");
/*     */     } 
/*  58 */     for (byte b = 1; paramEnumeration.hasMoreElements(); b++) {
/*  59 */       a(paramEnumeration.nextElement(), b);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(k paramk, int paramInt) {
/*  64 */     b(paramk, paramInt);
/*  65 */     a(paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void b(k paramk, int paramInt) {
/*  71 */     a().print(paramInt + ") " + paramk.b());
/*     */   }
/*     */   
/*     */   protected void a(k paramk) {
/*  75 */     a().print(junit.runner.a.aI(paramk.dY()));
/*     */   }
/*     */   
/*     */   protected void e(m paramm) {
/*  79 */     if (paramm.er()) {
/*  80 */       a().println();
/*  81 */       a().print("OK");
/*  82 */       a().println(" (" + paramm.bf() + " test" + ((paramm.bf() == 1) ? "" : "s") + ")");
/*     */     } else {
/*     */       
/*  85 */       a().println();
/*  86 */       a().println("FAILURES!!!");
/*  87 */       a().println("Tests run: " + paramm.bf() + ",  Failures: " + paramm.be() + ",  Errors: " + paramm.bd());
/*     */     } 
/*     */ 
/*     */     
/*  91 */     a().println();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String b(long paramLong) {
/*  99 */     return NumberFormat.getInstance().format(paramLong / 1000.0D);
/*     */   }
/*     */   
/*     */   public PrintStream a() {
/* 103 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami, Throwable paramThrowable) {
/* 110 */     a().print("E");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami, b paramb) {
/* 117 */     a().print("F");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(i parami) {
/* 130 */     a().print(".");
/* 131 */     if (this.hV++ >= 40) {
/* 132 */       a().println();
/* 133 */       this.hV = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\textui\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */