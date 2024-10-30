/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.slf4j.spi.MDCAdapter;
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
/*     */ public class BasicMDCAdapter
/*     */   implements MDCAdapter
/*     */ {
/*  47 */   private InheritableThreadLocal<Map<String, String>> inheritableThreadLocal = new InheritableThreadLocal<Map<String, String>>(this)
/*     */     {
/*     */       protected Map<String, String> d(Map<String, String> param1Map) {
/*  50 */         if (param1Map == null) {
/*  51 */           return null;
/*     */         }
/*  53 */         return new HashMap<String, String>(param1Map);
/*     */       }
/*     */     };
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
/*     */   public void put(String paramString1, String paramString2) {
/*  70 */     if (paramString1 == null) {
/*  71 */       throw new IllegalArgumentException("key cannot be null");
/*     */     }
/*  73 */     Map<Object, Object> map = (Map)this.inheritableThreadLocal.get();
/*  74 */     if (map == null) {
/*  75 */       map = new HashMap<Object, Object>();
/*  76 */       this.inheritableThreadLocal.set(map);
/*     */     } 
/*  78 */     map.put(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String paramString) {
/*  85 */     Map map = this.inheritableThreadLocal.get();
/*  86 */     if (map != null && paramString != null) {
/*  87 */       return (String)map.get(paramString);
/*     */     }
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/*  97 */     Map map = this.inheritableThreadLocal.get();
/*  98 */     if (map != null) {
/*  99 */       map.remove(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 107 */     Map map = this.inheritableThreadLocal.get();
/* 108 */     if (map != null) {
/* 109 */       map.clear();
/* 110 */       this.inheritableThreadLocal.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getKeys() {
/* 121 */     Map map = this.inheritableThreadLocal.get();
/* 122 */     if (map != null) {
/* 123 */       return map.keySet();
/*     */     }
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getCopyOfContextMap() {
/* 135 */     Map<? extends String, ? extends String> map = this.inheritableThreadLocal.get();
/* 136 */     if (map != null) {
/* 137 */       return new HashMap<String, String>(map);
/*     */     }
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContextMap(Map<String, String> paramMap) {
/* 144 */     this.inheritableThreadLocal.set(new HashMap<String, String>(paramMap));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\BasicMDCAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */