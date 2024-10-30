/*    */ package org.junit.c;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.text.NumberFormat;
/*    */ import java.util.List;
/*    */ import org.junit.runner.b.a;
/*    */ import org.junit.runner.b.b;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ 
/*    */ public class k
/*    */   extends b
/*    */ {
/*    */   private final PrintStream b;
/*    */   
/*    */   public k(h paramh) {
/* 17 */     this(paramh.b());
/*    */   }
/*    */   
/*    */   public k(PrintStream paramPrintStream) {
/* 21 */     this.b = paramPrintStream;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(org.junit.runner.k paramk) {
/* 26 */     X(paramk.ao());
/* 27 */     b(paramk);
/* 28 */     c(paramk);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(c paramc) {
/* 33 */     this.b.append('.');
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(a parama) {
/* 38 */     this.b.append('E');
/*    */   }
/*    */ 
/*    */   
/*    */   public void c(c paramc) {
/* 43 */     this.b.append('I');
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private PrintStream a() {
/* 51 */     return this.b;
/*    */   }
/*    */   
/*    */   protected void X(long paramLong) {
/* 55 */     a().println();
/* 56 */     a().println("Time: " + b(paramLong));
/*    */   }
/*    */   
/*    */   protected void b(org.junit.runner.k paramk) {
/* 60 */     List list = paramk.bq();
/* 61 */     if (list.isEmpty()) {
/*    */       return;
/*    */     }
/* 64 */     if (list.size() == 1) {
/* 65 */       a().println("There was " + list.size() + " failure:");
/*    */     } else {
/* 67 */       a().println("There were " + list.size() + " failures:");
/*    */     } 
/* 69 */     byte b1 = 1;
/* 70 */     for (a a : list) {
/* 71 */       a(a, "" + b1++);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void a(a parama, String paramString) {
/* 76 */     a().println(paramString + ") " + parama.fb());
/* 77 */     a().print(parama.fd());
/*    */   }
/*    */   
/*    */   protected void c(org.junit.runner.k paramk) {
/* 81 */     if (paramk.er()) {
/* 82 */       a().println();
/* 83 */       a().print("OK");
/* 84 */       a().println(" (" + paramk.bV() + " test" + ((paramk.bV() == 1) ? "" : "s") + ")");
/*    */     } else {
/*    */       
/* 87 */       a().println();
/* 88 */       a().println("FAILURES!!!");
/* 89 */       a().println("Tests run: " + paramk.bV() + ",  Failures: " + paramk.bW());
/*    */     } 
/* 91 */     a().println();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String b(long paramLong) {
/* 99 */     return NumberFormat.getInstance().format(paramLong / 1000.0D);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */