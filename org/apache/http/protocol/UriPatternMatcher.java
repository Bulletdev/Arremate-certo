/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class UriPatternMatcher<T>
/*     */ {
/*  63 */   private final Map<String, T> map = new LinkedHashMap<String, T>();
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
/*     */   public synchronized Set<Map.Entry<String, T>> entrySet() {
/*  75 */     return new HashSet<Map.Entry<String, T>>(this.map.entrySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void register(String paramString, T paramT) {
/*  85 */     Args.notNull(paramString, "URI request pattern");
/*  86 */     this.map.put(paramString, paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void unregister(String paramString) {
/*  95 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*  98 */     this.map.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public synchronized void setHandlers(Map<String, T> paramMap) {
/* 106 */     Args.notNull(paramMap, "Map of handlers");
/* 107 */     this.map.clear();
/* 108 */     this.map.putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public synchronized void setObjects(Map<String, T> paramMap) {
/* 116 */     Args.notNull(paramMap, "Map of handlers");
/* 117 */     this.map.clear();
/* 118 */     this.map.putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public synchronized Map<String, T> getObjects() {
/* 126 */     return this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized T lookup(String paramString) {
/* 136 */     Args.notNull(paramString, "Request path");
/*     */     
/* 138 */     T t = this.map.get(paramString);
/* 139 */     if (t == null) {
/*     */       
/* 141 */       String str = null;
/* 142 */       for (String str1 : this.map.keySet()) {
/* 143 */         if (matchUriRequestPattern(str1, paramString))
/*     */         {
/* 145 */           if (str == null || str.length() < str1.length() || (str.length() == str1.length() && str1.endsWith("*"))) {
/*     */ 
/*     */             
/* 148 */             t = this.map.get(str1);
/* 149 */             str = str1;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 154 */     return t;
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
/*     */   protected boolean matchUriRequestPattern(String paramString1, String paramString2) {
/* 166 */     if (paramString1.equals("*")) {
/* 167 */       return true;
/*     */     }
/* 169 */     return ((paramString1.endsWith("*") && paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1))) || (paramString1.startsWith("*") && paramString2.endsWith(paramString1.substring(1, paramString1.length()))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     return this.map.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\UriPatternMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */