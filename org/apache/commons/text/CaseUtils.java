/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CaseUtils
/*     */ {
/*     */   public static String toCamelCase(String paramString, boolean paramBoolean, char... paramVarArgs) {
/*  78 */     if (StringUtils.isEmpty(paramString)) {
/*  79 */       return paramString;
/*     */     }
/*  81 */     paramString = paramString.toLowerCase();
/*  82 */     int i = paramString.length();
/*  83 */     int[] arrayOfInt = new int[i];
/*  84 */     byte b = 0;
/*  85 */     Set<Integer> set = generateDelimiterSet(paramVarArgs);
/*  86 */     boolean bool = false;
/*  87 */     if (paramBoolean)
/*  88 */       bool = true; 
/*     */     int j;
/*  90 */     for (j = 0; j < i; ) {
/*  91 */       int k = paramString.codePointAt(j);
/*     */       
/*  93 */       if (set.contains(Integer.valueOf(k))) {
/*  94 */         bool = b ? true : false;
/*  95 */         j += Character.charCount(k); continue;
/*  96 */       }  if (bool || (!b && paramBoolean)) {
/*  97 */         int m = Character.toTitleCase(k);
/*  98 */         arrayOfInt[b++] = m;
/*  99 */         j += Character.charCount(m);
/* 100 */         bool = false; continue;
/*     */       } 
/* 102 */       arrayOfInt[b++] = k;
/* 103 */       j += Character.charCount(k);
/*     */     } 
/*     */     
/* 106 */     if (b != 0) {
/* 107 */       return new String(arrayOfInt, 0, b);
/*     */     }
/* 109 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set<Integer> generateDelimiterSet(char[] paramArrayOfchar) {
/* 120 */     HashSet<Integer> hashSet = new HashSet();
/* 121 */     hashSet.add(Integer.valueOf(Character.codePointAt(new char[] { ' ' }, 0)));
/* 122 */     if (ArrayUtils.isEmpty(paramArrayOfchar)) {
/* 123 */       return hashSet;
/*     */     }
/*     */     
/* 126 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 127 */       hashSet.add(Integer.valueOf(Character.codePointAt(paramArrayOfchar, b)));
/*     */     }
/* 129 */     return hashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\CaseUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */