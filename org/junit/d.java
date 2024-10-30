/*     */ package org.junit;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.d.k;
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
/*     */ public class d
/*     */ {
/*     */   public static void aM(boolean paramBoolean) {
/*  50 */     b(Boolean.valueOf(paramBoolean), org.d.d.a(Boolean.valueOf(true)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aN(boolean paramBoolean) {
/*  57 */     b(Boolean.valueOf(paramBoolean), org.d.d.a(Boolean.valueOf(false)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void e(String paramString, boolean paramBoolean) {
/*  68 */     if (!paramBoolean) throw new e(paramString);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void f(String paramString, boolean paramBoolean) {
/*  75 */     e(paramString, !paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(Object... paramVarArgs) {
/*  83 */     b(paramVarArgs, org.d.d.c());
/*  84 */     b(Arrays.asList(paramVarArgs), org.d.d.a(org.d.d.c()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void b(T paramT, k<T> paramk) {
/* 105 */     if (!paramk.E(paramT)) {
/* 106 */       throw new e(paramT, paramk);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void b(String paramString, T paramT, k<T> paramk) {
/* 128 */     if (!paramk.E(paramT)) {
/* 129 */       throw new e(paramString, paramT, paramk);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void j(Throwable paramThrowable) {
/* 153 */     b(paramThrowable, org.d.d.b());
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
/*     */   public static void a(String paramString, Throwable paramThrowable) {
/* 167 */     b(paramString, paramThrowable, org.d.d.b());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */