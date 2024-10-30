/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.Format;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class FormatCache<F extends Format>
/*     */ {
/*     */   static final int NONE = -1;
/*  43 */   private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap<>(7);
/*     */ 
/*     */   
/*  46 */   private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap<>(7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public F getInstance() {
/*  56 */     return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
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
/*     */   public F getInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/*  72 */     Validate.notNull(paramString, "pattern must not be null", new Object[0]);
/*  73 */     if (paramTimeZone == null) {
/*  74 */       paramTimeZone = TimeZone.getDefault();
/*     */     }
/*  76 */     if (paramLocale == null) {
/*  77 */       paramLocale = Locale.getDefault();
/*     */     }
/*  79 */     MultipartKey multipartKey = new MultipartKey(new Object[] { paramString, paramTimeZone, paramLocale });
/*  80 */     Format format = (Format)this.cInstanceCache.get(multipartKey);
/*  81 */     if (format == null) {
/*  82 */       format = (Format)createInstance(paramString, paramTimeZone, paramLocale);
/*  83 */       Format format1 = (Format)this.cInstanceCache.putIfAbsent(multipartKey, (F)format);
/*  84 */       if (format1 != null)
/*     */       {
/*     */         
/*  87 */         format = format1;
/*     */       }
/*     */     } 
/*  90 */     return (F)format;
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
/*     */   protected abstract F createInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private F getDateTimeInstance(Integer paramInteger1, Integer paramInteger2, TimeZone paramTimeZone, Locale paramLocale) {
/* 121 */     if (paramLocale == null) {
/* 122 */       paramLocale = Locale.getDefault();
/*     */     }
/* 124 */     String str = getPatternForStyle(paramInteger1, paramInteger2, paramLocale);
/* 125 */     return getInstance(str, paramTimeZone, paramLocale);
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
/*     */   F getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale) {
/* 143 */     return getDateTimeInstance(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTimeZone, paramLocale);
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
/*     */   F getDateInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale) {
/* 160 */     return getDateTimeInstance(Integer.valueOf(paramInt), (Integer)null, paramTimeZone, paramLocale);
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
/*     */   F getTimeInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale) {
/* 177 */     return getDateTimeInstance((Integer)null, Integer.valueOf(paramInt), paramTimeZone, paramLocale);
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
/*     */   static String getPatternForStyle(Integer paramInteger1, Integer paramInteger2, Locale paramLocale) {
/* 191 */     MultipartKey multipartKey = new MultipartKey(new Object[] { paramInteger1, paramInteger2, paramLocale });
/*     */     
/* 193 */     String str = cDateTimeInstanceCache.get(multipartKey);
/* 194 */     if (str == null) {
/*     */       try {
/*     */         DateFormat dateFormat;
/* 197 */         if (paramInteger1 == null) {
/* 198 */           dateFormat = DateFormat.getTimeInstance(paramInteger2.intValue(), paramLocale);
/* 199 */         } else if (paramInteger2 == null) {
/* 200 */           dateFormat = DateFormat.getDateInstance(paramInteger1.intValue(), paramLocale);
/*     */         } else {
/* 202 */           dateFormat = DateFormat.getDateTimeInstance(paramInteger1.intValue(), paramInteger2.intValue(), paramLocale);
/*     */         } 
/* 204 */         str = ((SimpleDateFormat)dateFormat).toPattern();
/* 205 */         String str1 = cDateTimeInstanceCache.putIfAbsent(multipartKey, str);
/* 206 */         if (str1 != null)
/*     */         {
/*     */ 
/*     */           
/* 210 */           str = str1;
/*     */         }
/* 212 */       } catch (ClassCastException classCastException) {
/* 213 */         throw new IllegalArgumentException("No date time pattern for locale: " + paramLocale);
/*     */       } 
/*     */     }
/* 216 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class MultipartKey
/*     */   {
/*     */     private final Object[] keys;
/*     */ 
/*     */     
/*     */     private int hashCode;
/*     */ 
/*     */ 
/*     */     
/*     */     MultipartKey(Object... param1VarArgs) {
/* 232 */       this.keys = param1VarArgs;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 243 */       return Arrays.equals(this.keys, ((MultipartKey)param1Object).keys);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 251 */       if (this.hashCode == 0) {
/* 252 */         int i = 0;
/* 253 */         for (Object object : this.keys) {
/* 254 */           if (object != null) {
/* 255 */             i = i * 7 + object.hashCode();
/*     */           }
/*     */         } 
/* 258 */         this.hashCode = i;
/*     */       } 
/* 260 */       return this.hashCode;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\FormatCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */