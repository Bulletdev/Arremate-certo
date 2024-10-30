/*     */ package org.apache.http.params;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class BasicHttpParams
/*     */   extends AbstractHttpParams
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = -7086398485908701455L;
/*  57 */   private final Map<String, Object> parameters = new ConcurrentHashMap<String, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getParameter(String paramString) {
/*  65 */     return this.parameters.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams setParameter(String paramString, Object paramObject) {
/*  70 */     if (paramString == null) {
/*  71 */       return this;
/*     */     }
/*  73 */     if (paramObject != null) {
/*  74 */       this.parameters.put(paramString, paramObject);
/*     */     } else {
/*  76 */       this.parameters.remove(paramString);
/*     */     } 
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeParameter(String paramString) {
/*  84 */     if (this.parameters.containsKey(paramString)) {
/*  85 */       this.parameters.remove(paramString);
/*  86 */       return true;
/*     */     } 
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameters(String[] paramArrayOfString, Object paramObject) {
/*  98 */     for (String str : paramArrayOfString) {
/*  99 */       setParameter(str, paramObject);
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
/*     */   public boolean isParameterSet(String paramString) {
/* 115 */     return (getParameter(paramString) != null);
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
/*     */   public boolean isParameterSetLocally(String paramString) {
/* 129 */     return (this.parameters.get(paramString) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 136 */     this.parameters.clear();
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
/*     */   public HttpParams copy() {
/*     */     try {
/* 151 */       return (HttpParams)clone();
/* 152 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 153 */       throw new UnsupportedOperationException("Cloning not supported");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 163 */     BasicHttpParams basicHttpParams = (BasicHttpParams)super.clone();
/* 164 */     copyParams(basicHttpParams);
/* 165 */     return basicHttpParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyParams(HttpParams paramHttpParams) {
/* 176 */     for (Map.Entry<String, Object> entry : this.parameters.entrySet()) {
/* 177 */       paramHttpParams.setParameter((String)entry.getKey(), entry.getValue());
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
/*     */   public Set<String> getNames() {
/* 192 */     return new HashSet<String>(this.parameters.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     return "[parameters=" + this.parameters + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\BasicHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */