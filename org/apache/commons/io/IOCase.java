/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum IOCase
/*     */ {
/*  41 */   SENSITIVE("Sensitive", true),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   INSENSITIVE("Insensitive", false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   SYSTEM("System", !FilenameUtils.isSystemWindows());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = -6343169151696340687L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */   
/*     */   private final transient boolean sensitive;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOCase forName(String paramString) {
/*  80 */     for (IOCase iOCase : values()) {
/*     */       
/*  82 */       if (iOCase.getName().equals(paramString))
/*     */       {
/*  84 */         return iOCase;
/*     */       }
/*     */     } 
/*  87 */     throw new IllegalArgumentException("Invalid IOCase name: " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   IOCase(String paramString1, boolean paramBoolean) {
/*  98 */     this.name = paramString1;
/*  99 */     this.sensitive = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object readResolve() {
/* 109 */     return forName(this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 119 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCaseSensitive() {
/* 128 */     return this.sensitive;
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
/*     */   public int checkCompareTo(String paramString1, String paramString2) {
/* 144 */     Objects.requireNonNull(paramString1, "str1");
/* 145 */     Objects.requireNonNull(paramString2, "str2");
/* 146 */     return this.sensitive ? paramString1.compareTo(paramString2) : paramString1.compareToIgnoreCase(paramString2);
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
/*     */   public boolean checkEquals(String paramString1, String paramString2) {
/* 161 */     Objects.requireNonNull(paramString1, "str1");
/* 162 */     Objects.requireNonNull(paramString2, "str2");
/* 163 */     return this.sensitive ? paramString1.equals(paramString2) : paramString1.equalsIgnoreCase(paramString2);
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
/*     */   public boolean checkStartsWith(String paramString1, String paramString2) {
/* 178 */     return paramString1.regionMatches(!this.sensitive, 0, paramString2, 0, paramString2.length());
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
/*     */   public boolean checkEndsWith(String paramString1, String paramString2) {
/* 193 */     int i = paramString2.length();
/* 194 */     return paramString1.regionMatches(!this.sensitive, paramString1.length() - i, paramString2, 0, i);
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
/*     */   public int checkIndexOf(String paramString1, int paramInt, String paramString2) {
/* 213 */     int i = paramString1.length() - paramString2.length();
/* 214 */     if (i >= paramInt) {
/* 215 */       for (int j = paramInt; j <= i; j++) {
/* 216 */         if (checkRegionMatches(paramString1, j, paramString2)) {
/* 217 */           return j;
/*     */         }
/*     */       } 
/*     */     }
/* 221 */     return -1;
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
/*     */   public boolean checkRegionMatches(String paramString1, int paramInt, String paramString2) {
/* 237 */     return paramString1.regionMatches(!this.sensitive, paramInt, paramString2, 0, paramString2.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 248 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\IOCase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */