/*     */ package org.apache.commons.text.lookup;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.commons.lang3.ClassUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ConstantStringLookup
/*     */   extends AbstractStringLookup
/*     */ {
/*  67 */   private static final ConcurrentHashMap<String, String> CONSTANT_CACHE = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char FIELD_SEPARATOR = '.';
/*     */ 
/*     */ 
/*     */   
/*  75 */   static final ConstantStringLookup INSTANCE = new ConstantStringLookup();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void clear() {
/*  81 */     CONSTANT_CACHE.clear();
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
/*     */   protected Class<?> fetchClass(String paramString) throws ClassNotFoundException {
/*  95 */     return ClassUtils.getClass(paramString);
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
/*     */   public synchronized String lookup(String paramString) {
/* 109 */     if (paramString == null) {
/* 110 */       return null;
/*     */     }
/*     */     
/* 113 */     String str = CONSTANT_CACHE.get(paramString);
/* 114 */     if (str != null) {
/* 115 */       return str;
/*     */     }
/* 117 */     int i = paramString.lastIndexOf('.');
/* 118 */     if (i < 0) {
/* 119 */       return null;
/*     */     }
/*     */     try {
/* 122 */       Object object = resolveField(paramString.substring(0, i), paramString.substring(i + 1));
/* 123 */       if (object != null) {
/* 124 */         String str1 = Objects.toString(object, null);
/* 125 */         CONSTANT_CACHE.put(paramString, str1);
/* 126 */         str = str1;
/*     */       } 
/* 128 */     } catch (Exception exception) {
/*     */       
/* 130 */       return null;
/*     */     } 
/* 132 */     return str;
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
/*     */   protected Object resolveField(String paramString1, String paramString2) throws Exception {
/* 146 */     Class<?> clazz = fetchClass(paramString1);
/* 147 */     if (clazz == null) {
/* 148 */       return null;
/*     */     }
/* 150 */     return clazz.getField(paramString2).get(null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\ConstantStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */