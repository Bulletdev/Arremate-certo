/*     */ package org.apache.commons.lang3.exception;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.commons.lang3.tuple.ImmutablePair;
/*     */ import org.apache.commons.lang3.tuple.Pair;
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
/*     */ public class DefaultExceptionContext
/*     */   implements Serializable, ExceptionContext
/*     */ {
/*     */   private static final long serialVersionUID = 20110706L;
/*  46 */   private final List<Pair<String, Object>> contextValues = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultExceptionContext addContextValue(String paramString, Object paramObject) {
/*  53 */     this.contextValues.add(new ImmutablePair(paramString, paramObject));
/*  54 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultExceptionContext setContextValue(String paramString, Object paramObject) {
/*  62 */     this.contextValues.removeIf(paramPair -> StringUtils.equals(paramString, (CharSequence)paramPair.getKey()));
/*  63 */     addContextValue(paramString, paramObject);
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> getContextValues(String paramString) {
/*  72 */     ArrayList<Object> arrayList = new ArrayList();
/*  73 */     for (Pair<String, Object> pair : this.contextValues) {
/*  74 */       if (StringUtils.equals(paramString, (CharSequence)pair.getKey())) {
/*  75 */         arrayList.add(pair.getValue());
/*     */       }
/*     */     } 
/*  78 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getFirstContextValue(String paramString) {
/*  86 */     for (Pair<String, Object> pair : this.contextValues) {
/*  87 */       if (StringUtils.equals(paramString, (CharSequence)pair.getKey())) {
/*  88 */         return pair.getValue();
/*     */       }
/*     */     } 
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getContextLabels() {
/*  99 */     HashSet<Object> hashSet = new HashSet();
/* 100 */     for (Pair<String, Object> pair : this.contextValues) {
/* 101 */       hashSet.add(pair.getKey());
/*     */     }
/* 103 */     return hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Pair<String, Object>> getContextEntries() {
/* 111 */     return this.contextValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormattedExceptionMessage(String paramString) {
/* 122 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 123 */     if (paramString != null) {
/* 124 */       stringBuilder.append(paramString);
/*     */     }
/*     */     
/* 127 */     if (!this.contextValues.isEmpty()) {
/* 128 */       if (stringBuilder.length() > 0) {
/* 129 */         stringBuilder.append('\n');
/*     */       }
/* 131 */       stringBuilder.append("Exception Context:\n");
/*     */       
/* 133 */       byte b = 0;
/* 134 */       for (Pair<String, Object> pair : this.contextValues) {
/* 135 */         stringBuilder.append("\t[");
/* 136 */         stringBuilder.append(++b);
/* 137 */         stringBuilder.append(':');
/* 138 */         stringBuilder.append((String)pair.getKey());
/* 139 */         stringBuilder.append("=");
/* 140 */         Object object = pair.getValue();
/* 141 */         if (object == null) {
/* 142 */           stringBuilder.append("null");
/*     */         } else {
/*     */           String str;
/*     */           try {
/* 146 */             str = object.toString();
/* 147 */           } catch (Exception exception) {
/* 148 */             str = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(exception);
/*     */           } 
/* 150 */           stringBuilder.append(str);
/*     */         } 
/* 152 */         stringBuilder.append("]\n");
/*     */       } 
/* 154 */       stringBuilder.append("---------------------------------");
/*     */     } 
/* 156 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\exception\DefaultExceptionContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */