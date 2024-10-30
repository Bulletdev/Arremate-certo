/*     */ package org.apache.commons.text.lookup;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class InterpolatorStringLookup
/*     */   extends AbstractStringLookup
/*     */ {
/*  37 */   static final AbstractStringLookup INSTANCE = new InterpolatorStringLookup();
/*     */   private static final char PREFIX_SEPARATOR = ':';
/*     */   private final StringLookup defaultStringLookup;
/*     */   private final Map<String, StringLookup> stringLookupMap;
/*     */   
/*     */   static String toKey(String paramString) {
/*  43 */     return paramString.toLowerCase(Locale.ROOT);
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
/*     */   InterpolatorStringLookup() {
/*  59 */     this((Map<String, ?>)null);
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
/*     */   InterpolatorStringLookup(Map<String, StringLookup> paramMap, StringLookup paramStringLookup, boolean paramBoolean) {
/*  72 */     this.defaultStringLookup = paramStringLookup;
/*  73 */     this.stringLookupMap = new HashMap<>(paramMap.size());
/*  74 */     for (Map.Entry<String, StringLookup> entry : paramMap.entrySet()) {
/*  75 */       this.stringLookupMap.put(toKey((String)entry.getKey()), (StringLookup)entry.getValue());
/*     */     }
/*  77 */     if (paramBoolean) {
/*  78 */       StringLookupFactory.INSTANCE.addDefaultStringLookups(this.stringLookupMap);
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
/*     */   <V> InterpolatorStringLookup(Map<String, V> paramMap) {
/*  92 */     this(StringLookupFactory.INSTANCE.mapStringLookup((paramMap == null) ? new HashMap<>() : paramMap));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   InterpolatorStringLookup(StringLookup paramStringLookup) {
/* 101 */     this(new HashMap<>(), paramStringLookup, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, StringLookup> getStringLookupMap() {
/* 110 */     return this.stringLookupMap;
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
/*     */   public String lookup(String paramString) {
/* 124 */     if (paramString == null) {
/* 125 */       return null;
/*     */     }
/*     */     
/* 128 */     int i = paramString.indexOf(':');
/* 129 */     if (i >= 0) {
/* 130 */       String str1 = toKey(paramString.substring(0, i));
/* 131 */       String str2 = paramString.substring(i + 1);
/* 132 */       StringLookup stringLookup = this.stringLookupMap.get(str1);
/* 133 */       String str3 = null;
/* 134 */       if (stringLookup != null) {
/* 135 */         str3 = stringLookup.lookup(str2);
/*     */       }
/*     */       
/* 138 */       if (str3 != null) {
/* 139 */         return str3;
/*     */       }
/* 141 */       paramString = paramString.substring(i + 1);
/*     */     } 
/* 143 */     if (this.defaultStringLookup != null) {
/* 144 */       return this.defaultStringLookup.lookup(paramString);
/*     */     }
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     return super.toString() + " [stringLookupMap=" + this.stringLookupMap + ", defaultStringLookup=" + this.defaultStringLookup + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\InterpolatorStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */