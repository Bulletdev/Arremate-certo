/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSetUtils
/*     */ {
/*     */   public static boolean containsAny(String paramString, String... paramVarArgs) {
/*  52 */     if (StringUtils.isEmpty(paramString) || deepEmpty(paramVarArgs)) {
/*  53 */       return false;
/*     */     }
/*  55 */     CharSet charSet = CharSet.getInstance(paramVarArgs);
/*  56 */     for (char c : paramString.toCharArray()) {
/*  57 */       if (charSet.contains(c)) {
/*  58 */         return true;
/*     */       }
/*     */     } 
/*  61 */     return false;
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
/*     */   public static int count(String paramString, String... paramVarArgs) {
/*  83 */     if (StringUtils.isEmpty(paramString) || deepEmpty(paramVarArgs)) {
/*  84 */       return 0;
/*     */     }
/*  86 */     CharSet charSet = CharSet.getInstance(paramVarArgs);
/*  87 */     byte b = 0;
/*  88 */     for (char c : paramString.toCharArray()) {
/*  89 */       if (charSet.contains(c)) {
/*  90 */         b++;
/*     */       }
/*     */     } 
/*  93 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean deepEmpty(String[] paramArrayOfString) {
/* 104 */     if (paramArrayOfString != null) {
/* 105 */       for (String str : paramArrayOfString) {
/* 106 */         if (StringUtils.isNotEmpty(str)) {
/* 107 */           return false;
/*     */         }
/*     */       } 
/*     */     }
/* 111 */     return true;
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
/*     */   public static String delete(String paramString, String... paramVarArgs) {
/* 133 */     if (StringUtils.isEmpty(paramString) || deepEmpty(paramVarArgs)) {
/* 134 */       return paramString;
/*     */     }
/* 136 */     return modify(paramString, paramVarArgs, false);
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
/*     */   
/*     */   public static String keep(String paramString, String... paramVarArgs) {
/* 159 */     if (paramString == null) {
/* 160 */       return null;
/*     */     }
/* 162 */     if (paramString.isEmpty() || deepEmpty(paramVarArgs)) {
/* 163 */       return "";
/*     */     }
/* 165 */     return modify(paramString, paramVarArgs, true);
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
/*     */   private static String modify(String paramString, String[] paramArrayOfString, boolean paramBoolean) {
/* 177 */     CharSet charSet = CharSet.getInstance(paramArrayOfString);
/* 178 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 179 */     char[] arrayOfChar = paramString.toCharArray();
/* 180 */     for (char c : arrayOfChar) {
/* 181 */       if (charSet.contains(c) == paramBoolean) {
/* 182 */         stringBuilder.append(c);
/*     */       }
/*     */     } 
/* 185 */     return stringBuilder.toString();
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
/*     */   public static String squeeze(String paramString, String... paramVarArgs) {
/* 207 */     if (StringUtils.isEmpty(paramString) || deepEmpty(paramVarArgs)) {
/* 208 */       return paramString;
/*     */     }
/* 210 */     CharSet charSet = CharSet.getInstance(paramVarArgs);
/* 211 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 212 */     char[] arrayOfChar = paramString.toCharArray();
/* 213 */     int i = arrayOfChar.length;
/* 214 */     char c = arrayOfChar[0];
/* 215 */     char c1 = ' ';
/* 216 */     Character character1 = null;
/* 217 */     Character character2 = null;
/* 218 */     stringBuilder.append(c);
/* 219 */     byte b = 1; while (true) { if (b < i)
/* 220 */       { c1 = arrayOfChar[b];
/* 221 */         if (c1 == c)
/* 222 */         { if (character1 != null && c1 == character1.charValue()) {
/*     */             continue;
/*     */           }
/* 225 */           if (character2 == null || c1 != character2.charValue())
/* 226 */           { if (charSet.contains(c1))
/* 227 */             { character1 = Character.valueOf(c1); }
/*     */             else
/*     */             
/* 230 */             { character2 = Character.valueOf(c1);
/*     */ 
/*     */               
/* 233 */               stringBuilder.append(c1);
/* 234 */               c = c1; }  continue; }  }  } else { break; }  stringBuilder.append(c1); c = c1; b++; }
/*     */     
/* 236 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\CharSetUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */