/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LocaleUtils
/*     */ {
/*  41 */   private static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */   
/*  45 */   private static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Locale toLocale(String paramString) {
/*  91 */     if (paramString == null) {
/*  92 */       return null;
/*     */     }
/*  94 */     if (paramString.isEmpty()) {
/*  95 */       return new Locale("", "");
/*     */     }
/*  97 */     if (paramString.contains("#")) {
/*  98 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 100 */     int i = paramString.length();
/* 101 */     if (i < 2) {
/* 102 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 104 */     char c = paramString.charAt(0);
/* 105 */     if (c == '_') {
/* 106 */       if (i < 3) {
/* 107 */         throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */       }
/* 109 */       char c1 = paramString.charAt(1);
/* 110 */       char c2 = paramString.charAt(2);
/* 111 */       if (!Character.isUpperCase(c1) || !Character.isUpperCase(c2)) {
/* 112 */         throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */       }
/* 114 */       if (i == 3) {
/* 115 */         return new Locale("", paramString.substring(1, 3));
/*     */       }
/* 117 */       if (i < 5) {
/* 118 */         throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */       }
/* 120 */       if (paramString.charAt(3) != '_') {
/* 121 */         throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */       }
/* 123 */       return new Locale("", paramString.substring(1, 3), paramString.substring(4));
/*     */     } 
/*     */     
/* 126 */     return parseLocale(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Locale parseLocale(String paramString) {
/* 137 */     if (isISO639LanguageCode(paramString)) {
/* 138 */       return new Locale(paramString);
/*     */     }
/*     */     
/* 141 */     String[] arrayOfString = paramString.split("_", -1);
/* 142 */     String str = arrayOfString[0];
/* 143 */     if (arrayOfString.length == 2) {
/* 144 */       String str1 = arrayOfString[1];
/* 145 */       if ((isISO639LanguageCode(str) && isISO3166CountryCode(str1)) || 
/* 146 */         isNumericAreaCode(str1)) {
/* 147 */         return new Locale(str, str1);
/*     */       }
/* 149 */     } else if (arrayOfString.length == 3) {
/* 150 */       String str1 = arrayOfString[1];
/* 151 */       String str2 = arrayOfString[2];
/* 152 */       if (isISO639LanguageCode(str) && (str1
/* 153 */         .isEmpty() || isISO3166CountryCode(str1) || isNumericAreaCode(str1)) && 
/* 154 */         !str2.isEmpty()) {
/* 155 */         return new Locale(str, str1, str2);
/*     */       }
/*     */     } 
/* 158 */     throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isISO639LanguageCode(String paramString) {
/* 168 */     return (StringUtils.isAllLowerCase(paramString) && (paramString.length() == 2 || paramString.length() == 3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isISO3166CountryCode(String paramString) {
/* 178 */     return (StringUtils.isAllUpperCase(paramString) && paramString.length() == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isNumericAreaCode(String paramString) {
/* 188 */     return (StringUtils.isNumeric(paramString) && paramString.length() == 3);
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
/*     */   public static List<Locale> localeLookupList(Locale paramLocale) {
/* 205 */     return localeLookupList(paramLocale, paramLocale);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Locale> localeLookupList(Locale paramLocale1, Locale paramLocale2) {
/* 227 */     ArrayList<Locale> arrayList = new ArrayList(4);
/* 228 */     if (paramLocale1 != null) {
/* 229 */       arrayList.add(paramLocale1);
/* 230 */       if (!paramLocale1.getVariant().isEmpty()) {
/* 231 */         arrayList.add(new Locale(paramLocale1.getLanguage(), paramLocale1.getCountry()));
/*     */       }
/* 233 */       if (!paramLocale1.getCountry().isEmpty()) {
/* 234 */         arrayList.add(new Locale(paramLocale1.getLanguage(), ""));
/*     */       }
/* 236 */       if (!arrayList.contains(paramLocale2)) {
/* 237 */         arrayList.add(paramLocale2);
/*     */       }
/*     */     } 
/* 240 */     return Collections.unmodifiableList(arrayList);
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
/*     */   public static List<Locale> availableLocaleList() {
/* 254 */     return SyncAvoid.AVAILABLE_LOCALE_LIST;
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
/*     */   public static Set<Locale> availableLocaleSet() {
/* 268 */     return SyncAvoid.AVAILABLE_LOCALE_SET;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAvailableLocale(Locale paramLocale) {
/* 279 */     return availableLocaleList().contains(paramLocale);
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
/*     */   public static List<Locale> languagesByCountry(String paramString) {
/* 293 */     if (paramString == null) {
/* 294 */       return Collections.emptyList();
/*     */     }
/* 296 */     List<Locale> list = cLanguagesByCountry.get(paramString);
/* 297 */     if (list == null) {
/* 298 */       list = new ArrayList();
/* 299 */       List<Locale> list1 = availableLocaleList();
/* 300 */       for (Locale locale : list1) {
/* 301 */         if (paramString.equals(locale.getCountry()) && locale
/* 302 */           .getVariant().isEmpty()) {
/* 303 */           list.add(locale);
/*     */         }
/*     */       } 
/* 306 */       list = Collections.unmodifiableList(list);
/* 307 */       cLanguagesByCountry.putIfAbsent(paramString, list);
/* 308 */       list = cLanguagesByCountry.get(paramString);
/*     */     } 
/* 310 */     return list;
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
/*     */   public static List<Locale> countriesByLanguage(String paramString) {
/* 324 */     if (paramString == null) {
/* 325 */       return Collections.emptyList();
/*     */     }
/* 327 */     List<Locale> list = cCountriesByLanguage.get(paramString);
/* 328 */     if (list == null) {
/* 329 */       list = new ArrayList();
/* 330 */       List<Locale> list1 = availableLocaleList();
/* 331 */       for (Locale locale : list1) {
/* 332 */         if (paramString.equals(locale.getLanguage()) && 
/* 333 */           !locale.getCountry().isEmpty() && locale
/* 334 */           .getVariant().isEmpty()) {
/* 335 */           list.add(locale);
/*     */         }
/*     */       } 
/* 338 */       list = Collections.unmodifiableList(list);
/* 339 */       cCountriesByLanguage.putIfAbsent(paramString, list);
/* 340 */       list = cCountriesByLanguage.get(paramString);
/*     */     } 
/* 342 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   static class SyncAvoid
/*     */   {
/*     */     private static final List<Locale> AVAILABLE_LOCALE_LIST;
/*     */     
/*     */     private static final Set<Locale> AVAILABLE_LOCALE_SET;
/*     */ 
/*     */     
/*     */     static {
/* 354 */       ArrayList<? extends Locale> arrayList = new ArrayList(Arrays.asList((Object[])Locale.getAvailableLocales()));
/* 355 */       AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(arrayList);
/* 356 */       AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet<>(arrayList));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\LocaleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */