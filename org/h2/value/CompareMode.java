/*     */ package org.h2.value;
/*     */ 
/*     */ import java.text.Collator;
/*     */ import java.util.Locale;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompareMode
/*     */ {
/*     */   public static final String OFF = "OFF";
/*     */   public static final String DEFAULT = "DEFAULT_";
/*     */   public static final String ICU4J = "ICU4J_";
/*     */   public static final String SIGNED = "SIGNED";
/*     */   public static final String UNSIGNED = "UNSIGNED";
/*     */   private static volatile CompareMode lastUsed;
/*     */   private static final boolean CAN_USE_ICU4J;
/*     */   private final String name;
/*     */   private final int strength;
/*     */   private final boolean binaryUnsigned;
/*     */   
/*     */   static {
/*  55 */     boolean bool = false;
/*     */     try {
/*  57 */       Class.forName("com.ibm.icu.text.Collator");
/*  58 */       bool = true;
/*  59 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  62 */     CAN_USE_ICU4J = bool;
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
/*     */   protected CompareMode(String paramString, int paramInt, boolean paramBoolean) {
/*  74 */     this.name = paramString;
/*  75 */     this.strength = paramInt;
/*  76 */     this.binaryUnsigned = paramBoolean;
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
/*     */   public static CompareMode getInstance(String paramString, int paramInt) {
/*  90 */     return getInstance(paramString, paramInt, SysProperties.SORT_BINARY_UNSIGNED);
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
/*     */   public static CompareMode getInstance(String paramString, int paramInt, boolean paramBoolean) {
/* 105 */     CompareMode compareMode = lastUsed;
/* 106 */     if (compareMode != null && 
/* 107 */       StringUtils.equals(compareMode.name, paramString) && compareMode.strength == paramInt && compareMode.binaryUnsigned == paramBoolean)
/*     */     {
/*     */       
/* 110 */       return compareMode;
/*     */     }
/*     */     
/* 113 */     if (paramString == null || paramString.equals("OFF")) {
/* 114 */       compareMode = new CompareMode(paramString, paramInt, paramBoolean);
/*     */     } else {
/*     */       boolean bool;
/* 117 */       if (paramString.startsWith("ICU4J_")) {
/* 118 */         bool = true;
/* 119 */         paramString = paramString.substring("ICU4J_".length());
/* 120 */       } else if (paramString.startsWith("DEFAULT_")) {
/* 121 */         bool = false;
/* 122 */         paramString = paramString.substring("DEFAULT_".length());
/*     */       } else {
/* 124 */         bool = CAN_USE_ICU4J;
/*     */       } 
/* 126 */       if (bool) {
/* 127 */         compareMode = new CompareModeIcu4J(paramString, paramInt, paramBoolean);
/*     */       } else {
/* 129 */         compareMode = new CompareModeDefault(paramString, paramInt, paramBoolean);
/*     */       } 
/*     */     } 
/* 132 */     lastUsed = compareMode;
/* 133 */     return compareMode;
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
/*     */   public boolean equalsChars(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean) {
/* 148 */     char c1 = paramString1.charAt(paramInt1);
/* 149 */     char c2 = paramString2.charAt(paramInt2);
/* 150 */     if (paramBoolean) {
/* 151 */       c1 = Character.toUpperCase(c1);
/* 152 */       c2 = Character.toUpperCase(c2);
/*     */     } 
/* 154 */     return (c1 == c2);
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
/*     */   public int compareString(String paramString1, String paramString2, boolean paramBoolean) {
/* 167 */     if (paramBoolean) {
/* 168 */       return paramString1.compareToIgnoreCase(paramString2);
/*     */     }
/* 170 */     return paramString1.compareTo(paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getName(Locale paramLocale) {
/* 180 */     Locale locale = Locale.ENGLISH;
/* 181 */     String str = paramLocale.getDisplayLanguage(locale) + ' ' + paramLocale.getDisplayCountry(locale) + ' ' + paramLocale.getVariant();
/*     */     
/* 183 */     str = StringUtils.toUpperEnglish(str.trim().replace(' ', '_'));
/* 184 */     return str;
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
/*     */   static boolean compareLocaleNames(Locale paramLocale, String paramString) {
/* 196 */     return (paramString.equalsIgnoreCase(paramLocale.toString()) || paramString.equalsIgnoreCase(getName(paramLocale)));
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
/*     */   public static Collator getCollator(String paramString) {
/* 208 */     Collator collator = null;
/* 209 */     if (paramString.startsWith("ICU4J_")) {
/* 210 */       paramString = paramString.substring("ICU4J_".length());
/* 211 */     } else if (paramString.startsWith("DEFAULT_")) {
/* 212 */       paramString = paramString.substring("DEFAULT_".length());
/*     */     } 
/* 214 */     if (paramString.length() == 2) {
/* 215 */       Locale locale = new Locale(StringUtils.toLowerEnglish(paramString), "");
/* 216 */       if (compareLocaleNames(locale, paramString)) {
/* 217 */         collator = Collator.getInstance(locale);
/*     */       }
/* 219 */     } else if (paramString.length() == 5) {
/*     */       
/* 221 */       int i = paramString.indexOf('_');
/* 222 */       if (i >= 0) {
/* 223 */         String str1 = StringUtils.toLowerEnglish(paramString.substring(0, i));
/* 224 */         String str2 = paramString.substring(i + 1);
/* 225 */         Locale locale = new Locale(str1, str2);
/* 226 */         if (compareLocaleNames(locale, paramString)) {
/* 227 */           collator = Collator.getInstance(locale);
/*     */         }
/*     */       } 
/*     */     } 
/* 231 */     if (collator == null) {
/* 232 */       for (Locale locale : Collator.getAvailableLocales()) {
/* 233 */         if (compareLocaleNames(locale, paramString)) {
/* 234 */           collator = Collator.getInstance(locale);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 239 */     return collator;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 243 */     return (this.name == null) ? "OFF" : this.name;
/*     */   }
/*     */   
/*     */   public int getStrength() {
/* 247 */     return this.strength;
/*     */   }
/*     */   
/*     */   public boolean isBinaryUnsigned() {
/* 251 */     return this.binaryUnsigned;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 256 */     if (paramObject == this)
/* 257 */       return true; 
/* 258 */     if (!(paramObject instanceof CompareMode)) {
/* 259 */       return false;
/*     */     }
/* 261 */     CompareMode compareMode = (CompareMode)paramObject;
/* 262 */     if (!getName().equals(compareMode.getName())) {
/* 263 */       return false;
/*     */     }
/* 265 */     if (this.strength != compareMode.strength) {
/* 266 */       return false;
/*     */     }
/* 268 */     if (this.binaryUnsigned != compareMode.binaryUnsigned) {
/* 269 */       return false;
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 276 */     return getName().hashCode() ^ this.strength ^ (this.binaryUnsigned ? -1 : 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\CompareMode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */