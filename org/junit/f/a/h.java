/*     */ package org.junit.f.a;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.c.b;
/*     */ import org.junit.c.e.a.b;
/*     */ import org.junit.c.l;
/*     */ import org.junit.n;
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
/*     */   extends Exception
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final List<Throwable> ad;
/*     */   
/*     */   public h(List<Throwable> paramList) {
/*  29 */     if (paramList.isEmpty()) {
/*  30 */       throw new IllegalArgumentException("List of Throwables must not be empty");
/*     */     }
/*     */     
/*  33 */     this.ad = new ArrayList<Throwable>(paramList.size());
/*  34 */     for (Throwable throwable : paramList) {
/*  35 */       n n; if (throwable instanceof b) {
/*  36 */         n = new n((b)throwable);
/*     */       }
/*  38 */       this.ad.add(n);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Throwable> bq() {
/*  43 */     return Collections.unmodifiableList(this.ad);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMessage() {
/*  48 */     StringBuilder stringBuilder = new StringBuilder(String.format("There were %d errors:", new Object[] { Integer.valueOf(this.ad.size()) }));
/*     */     
/*  50 */     for (Throwable throwable : this.ad) {
/*  51 */       stringBuilder.append(String.format("%n  %s(%s)", new Object[] { throwable.getClass().getName(), throwable.getMessage() }));
/*     */     } 
/*  53 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/*  58 */     for (Throwable throwable : this.ad) {
/*  59 */       throwable.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/*  65 */     for (Throwable throwable : this.ad) {
/*  66 */       throwable.printStackTrace(paramPrintStream);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/*  72 */     for (Throwable throwable : this.ad) {
/*  73 */       throwable.printStackTrace(paramPrintWriter);
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
/*     */   public static void I(List<Throwable> paramList) throws Exception {
/*  88 */     if (paramList.isEmpty()) {
/*     */       return;
/*     */     }
/*  91 */     if (paramList.size() == 1) {
/*  92 */       throw l.a((Throwable)paramList.get(0));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     throw new b(paramList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */