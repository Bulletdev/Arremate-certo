/*     */ package org.junit.c;
/*     */ 
/*     */ import org.d.g;
/*     */ import org.d.k;
/*     */ import org.d.m;
/*     */ import org.d.n;
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
/*     */ public class b
/*     */   extends RuntimeException
/*     */   implements m
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*     */   private final String mb;
/*     */   private final boolean dj;
/*     */   private final Object aD;
/*     */   private final k<?> f;
/*     */   
/*     */   @Deprecated
/*     */   public b(String paramString, boolean paramBoolean, Object paramObject, k<?> paramk) {
/*  33 */     this.mb = paramString;
/*  34 */     this.aD = paramObject;
/*  35 */     this.f = paramk;
/*  36 */     this.dj = paramBoolean;
/*     */     
/*  38 */     if (paramObject instanceof Throwable) {
/*  39 */       initCause((Throwable)paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public b(Object paramObject, k<?> paramk) {
/*  51 */     this((String)null, true, paramObject, paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public b(String paramString, Object paramObject, k<?> paramk) {
/*  62 */     this(paramString, true, paramObject, paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public b(String paramString) {
/*  72 */     this(paramString, false, (Object)null, (k<?>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public b(String paramString, Throwable paramThrowable) {
/*  82 */     this(paramString, false, (Object)null, (k<?>)null);
/*  83 */     initCause(paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMessage() {
/*  88 */     return n.b(this);
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/*  92 */     if (this.mb != null) {
/*  93 */       paramg.a(this.mb);
/*     */     }
/*     */     
/*  96 */     if (this.dj) {
/*     */       
/*  98 */       if (this.mb != null) {
/*  99 */         paramg.a(": ");
/*     */       }
/*     */       
/* 102 */       paramg.a("got: ");
/* 103 */       paramg.a(this.aD);
/*     */       
/* 105 */       if (this.f != null) {
/* 106 */         paramg.a(", expected: ");
/* 107 */         paramg.a((m)this.f);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */