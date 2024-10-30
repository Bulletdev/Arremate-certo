/*     */ package com.google.gson;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum FieldNamingPolicy
/*     */   implements FieldNamingStrategy
/*     */ {
/*  37 */   IDENTITY {
/*     */     public String translateName(Field param1Field) {
/*  39 */       return param1Field.getName();
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   UPPER_CAMEL_CASE {
/*     */     public String translateName(Field param1Field) {
/*  55 */       return null.upperCaseFirstLetter(param1Field.getName());
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   UPPER_CAMEL_CASE_WITH_SPACES {
/*     */     public String translateName(Field param1Field) {
/*  74 */       return null.upperCaseFirstLetter(null.separateCamelCase(param1Field.getName(), " "));
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   LOWER_CASE_WITH_UNDERSCORES {
/*     */     public String translateName(Field param1Field) {
/*  92 */       return null.separateCamelCase(param1Field.getName(), "_").toLowerCase(Locale.ENGLISH);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   LOWER_CASE_WITH_DASHES {
/*     */     public String translateName(Field param1Field) {
/* 115 */       return null.separateCamelCase(param1Field.getName(), "-").toLowerCase(Locale.ENGLISH);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   LOWER_CASE_WITH_DOTS {
/*     */     public String translateName(Field param1Field) {
/* 138 */       return null.separateCamelCase(param1Field.getName(), ".").toLowerCase(Locale.ENGLISH);
/*     */     }
/*     */   };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String separateCamelCase(String paramString1, String paramString2) {
/* 147 */     StringBuilder stringBuilder = new StringBuilder(); byte b; int i;
/* 148 */     for (b = 0, i = paramString1.length(); b < i; b++) {
/* 149 */       char c = paramString1.charAt(b);
/* 150 */       if (Character.isUpperCase(c) && stringBuilder.length() != 0) {
/* 151 */         stringBuilder.append(paramString2);
/*     */       }
/* 153 */       stringBuilder.append(c);
/*     */     } 
/* 155 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String upperCaseFirstLetter(String paramString) {
/* 162 */     StringBuilder stringBuilder = new StringBuilder();
/* 163 */     byte b = 0;
/* 164 */     char c = paramString.charAt(b);
/* 165 */     int i = paramString.length();
/*     */     
/* 167 */     while (b < i - 1 && 
/* 168 */       !Character.isLetter(c)) {
/*     */ 
/*     */ 
/*     */       
/* 172 */       stringBuilder.append(c);
/* 173 */       c = paramString.charAt(++b);
/*     */     } 
/*     */     
/* 176 */     if (!Character.isUpperCase(c)) {
/* 177 */       String str = modifyString(Character.toUpperCase(c), paramString, ++b);
/* 178 */       return stringBuilder.append(str).toString();
/*     */     } 
/* 180 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String modifyString(char paramChar, String paramString, int paramInt) {
/* 185 */     return (paramInt < paramString.length()) ? (paramChar + paramString
/* 186 */       .substring(paramInt)) : 
/* 187 */       String.valueOf(paramChar);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\FieldNamingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */