/*     */ package org.apache.http.params;
/*     */ 
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public abstract class AbstractHttpParams
/*     */   implements HttpParams, HttpParamsNames
/*     */ {
/*     */   public long getLongParameter(String paramString, long paramLong) {
/*  54 */     Object object = getParameter(paramString);
/*  55 */     if (object == null) {
/*  56 */       return paramLong;
/*     */     }
/*  58 */     return ((Long)object).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams setLongParameter(String paramString, long paramLong) {
/*  63 */     setParameter(paramString, Long.valueOf(paramLong));
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIntParameter(String paramString, int paramInt) {
/*  69 */     Object object = getParameter(paramString);
/*  70 */     if (object == null) {
/*  71 */       return paramInt;
/*     */     }
/*  73 */     return ((Integer)object).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams setIntParameter(String paramString, int paramInt) {
/*  78 */     setParameter(paramString, Integer.valueOf(paramInt));
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDoubleParameter(String paramString, double paramDouble) {
/*  84 */     Object object = getParameter(paramString);
/*  85 */     if (object == null) {
/*  86 */       return paramDouble;
/*     */     }
/*  88 */     return ((Double)object).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams setDoubleParameter(String paramString, double paramDouble) {
/*  93 */     setParameter(paramString, Double.valueOf(paramDouble));
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBooleanParameter(String paramString, boolean paramBoolean) {
/*  99 */     Object object = getParameter(paramString);
/* 100 */     if (object == null) {
/* 101 */       return paramBoolean;
/*     */     }
/* 103 */     return ((Boolean)object).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams setBooleanParameter(String paramString, boolean paramBoolean) {
/* 108 */     setParameter(paramString, paramBoolean ? Boolean.TRUE : Boolean.FALSE);
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParameterTrue(String paramString) {
/* 114 */     return getBooleanParameter(paramString, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParameterFalse(String paramString) {
/* 119 */     return !getBooleanParameter(paramString, false);
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
/*     */   public Set<String> getNames() {
/* 132 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\AbstractHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */