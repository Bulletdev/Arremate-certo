/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public abstract class CellFormatCondition
/*     */ {
/*     */   private static final int LT = 0;
/*     */   private static final int LE = 1;
/*     */   private static final int GT = 2;
/*     */   private static final int GE = 3;
/*     */   private static final int EQ = 4;
/*     */   private static final int NE = 5;
/*  38 */   private static final Map<String, Integer> TESTS = new HashMap<String, Integer>(); static {
/*  39 */     TESTS.put("<", Integer.valueOf(0));
/*  40 */     TESTS.put("<=", Integer.valueOf(1));
/*  41 */     TESTS.put(">", Integer.valueOf(2));
/*  42 */     TESTS.put(">=", Integer.valueOf(3));
/*  43 */     TESTS.put("=", Integer.valueOf(4));
/*  44 */     TESTS.put("==", Integer.valueOf(4));
/*  45 */     TESTS.put("!=", Integer.valueOf(5));
/*  46 */     TESTS.put("<>", Integer.valueOf(5));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean pass(double paramDouble);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CellFormatCondition getInstance(String paramString1, String paramString2) {
/*  63 */     if (!TESTS.containsKey(paramString1))
/*  64 */       throw new IllegalArgumentException("Unknown test: " + paramString1); 
/*  65 */     int i = ((Integer)TESTS.get(paramString1)).intValue();
/*     */     
/*  67 */     final double c = Double.parseDouble(paramString2);
/*     */     
/*  69 */     switch (i) {
/*     */       case 0:
/*  71 */         return new CellFormatCondition() {
/*     */             public boolean pass(double param1Double) {
/*  73 */               return (param1Double < c);
/*     */             }
/*     */           };
/*     */       case 1:
/*  77 */         return new CellFormatCondition() {
/*     */             public boolean pass(double param1Double) {
/*  79 */               return (param1Double <= c);
/*     */             }
/*     */           };
/*     */       case 2:
/*  83 */         return new CellFormatCondition() {
/*     */             public boolean pass(double param1Double) {
/*  85 */               return (param1Double > c);
/*     */             }
/*     */           };
/*     */       case 3:
/*  89 */         return new CellFormatCondition() {
/*     */             public boolean pass(double param1Double) {
/*  91 */               return (param1Double >= c);
/*     */             }
/*     */           };
/*     */       case 4:
/*  95 */         return new CellFormatCondition() {
/*     */             public boolean pass(double param1Double) {
/*  97 */               return (param1Double == c);
/*     */             }
/*     */           };
/*     */       case 5:
/* 101 */         return new CellFormatCondition() {
/*     */             public boolean pass(double param1Double) {
/* 103 */               return (param1Double != c);
/*     */             }
/*     */           };
/*     */     } 
/* 107 */     throw new IllegalArgumentException("Cannot create for test number " + i + "(\"" + paramString1 + "\")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellFormatCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */