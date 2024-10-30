/*     */ package ch.qos.logback.classic.util;
/*     */ 
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LogbackMDCAdapter
/*     */   implements MDCAdapter
/*     */ {
/*  55 */   final ThreadLocal<Map<String, String>> copyOnThreadLocal = new ThreadLocal<Map<String, String>>();
/*     */   
/*     */   private static final int WRITE_OPERATION = 1;
/*     */   
/*     */   private static final int MAP_COPY_OPERATION = 2;
/*     */   
/*  61 */   final ThreadLocal<Integer> lastOperation = new ThreadLocal<Integer>();
/*     */   
/*     */   private Integer getAndSetLastOperation(int paramInt) {
/*  64 */     Integer integer = this.lastOperation.get();
/*  65 */     this.lastOperation.set(Integer.valueOf(paramInt));
/*  66 */     return integer;
/*     */   }
/*     */   
/*     */   private boolean wasLastOpReadOrNull(Integer paramInteger) {
/*  70 */     return (paramInteger == null || paramInteger.intValue() == 2);
/*     */   }
/*     */   
/*     */   private Map<String, String> duplicateAndInsertNewMap(Map<String, String> paramMap) {
/*  74 */     Map<?, ?> map = Collections.synchronizedMap(new HashMap<Object, Object>());
/*  75 */     if (paramMap != null)
/*     */     {
/*     */       
/*  78 */       synchronized (paramMap) {
/*  79 */         map.putAll(paramMap);
/*     */       } 
/*     */     }
/*     */     
/*  83 */     this.copyOnThreadLocal.set(map);
/*  84 */     return (Map)map;
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
/*     */   public void put(String paramString1, String paramString2) throws IllegalArgumentException {
/*  99 */     if (paramString1 == null) {
/* 100 */       throw new IllegalArgumentException("key cannot be null");
/*     */     }
/*     */     
/* 103 */     Map<String, String> map = this.copyOnThreadLocal.get();
/* 104 */     Integer integer = getAndSetLastOperation(1);
/*     */     
/* 106 */     if (wasLastOpReadOrNull(integer) || map == null) {
/* 107 */       Map<String, String> map1 = duplicateAndInsertNewMap(map);
/* 108 */       map1.put(paramString1, paramString2);
/*     */     } else {
/* 110 */       map.put(paramString1, paramString2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/* 119 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 122 */     Map<String, String> map = this.copyOnThreadLocal.get();
/* 123 */     if (map == null) {
/*     */       return;
/*     */     }
/* 126 */     Integer integer = getAndSetLastOperation(1);
/*     */     
/* 128 */     if (wasLastOpReadOrNull(integer)) {
/* 129 */       Map<String, String> map1 = duplicateAndInsertNewMap(map);
/* 130 */       map1.remove(paramString);
/*     */     } else {
/* 132 */       map.remove(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 140 */     this.lastOperation.set(Integer.valueOf(1));
/* 141 */     this.copyOnThreadLocal.remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String paramString) {
/* 149 */     Map map = this.copyOnThreadLocal.get();
/* 150 */     if (map != null && paramString != null) {
/* 151 */       return (String)map.get(paramString);
/*     */     }
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getPropertyMap() {
/* 162 */     this.lastOperation.set(Integer.valueOf(2));
/* 163 */     return this.copyOnThreadLocal.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getKeys() {
/* 171 */     Map<String, String> map = getPropertyMap();
/*     */     
/* 173 */     if (map != null) {
/* 174 */       return map.keySet();
/*     */     }
/* 176 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getCopyOfContextMap() {
/* 185 */     Map<? extends String, ? extends String> map = this.copyOnThreadLocal.get();
/* 186 */     if (map == null) {
/* 187 */       return null;
/*     */     }
/* 189 */     return new HashMap<String, String>(map);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContextMap(Map<String, String> paramMap) {
/* 194 */     this.lastOperation.set(Integer.valueOf(1));
/*     */     
/* 196 */     Map<?, ?> map = Collections.synchronizedMap(new HashMap<Object, Object>());
/* 197 */     map.putAll(paramMap);
/*     */ 
/*     */     
/* 200 */     this.copyOnThreadLocal.set(map);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\LogbackMDCAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */