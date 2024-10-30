/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorkbookUtil
/*     */ {
/*     */   public static final String createSafeSheetName(String paramString) {
/*  48 */     return createSafeSheetName(paramString, ' ');
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
/*     */   public static final String createSafeSheetName(String paramString, char paramChar) {
/*  71 */     if (paramString == null) {
/*  72 */       return "null";
/*     */     }
/*  74 */     if (paramString.length() < 1) {
/*  75 */       return "empty";
/*     */     }
/*  77 */     int i = Math.min(31, paramString.length());
/*  78 */     String str = paramString.substring(0, i);
/*  79 */     StringBuilder stringBuilder = new StringBuilder(str);
/*  80 */     for (byte b = 0; b < i; b++) {
/*  81 */       char c = stringBuilder.charAt(b);
/*  82 */       switch (c) {
/*     */         case '\000':
/*     */         case '\003':
/*     */         case '*':
/*     */         case '/':
/*     */         case ':':
/*     */         case '?':
/*     */         case '[':
/*     */         case '\\':
/*     */         case ']':
/*  92 */           stringBuilder.setCharAt(b, paramChar);
/*     */           break;
/*     */         case '\'':
/*  95 */           if (b == 0 || b == i - 1) {
/*  96 */             stringBuilder.setCharAt(b, paramChar);
/*     */           }
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 103 */     return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateSheetName(String paramString) {
/* 130 */     if (paramString == null) {
/* 131 */       throw new IllegalArgumentException("sheetName must not be null");
/*     */     }
/* 133 */     int i = paramString.length();
/* 134 */     if (i < 1 || i > 31) {
/* 135 */       throw new IllegalArgumentException("sheetName '" + paramString + "' is invalid - character count MUST be greater than or equal to 1 and less than or equal to 31");
/*     */     }
/*     */ 
/*     */     
/* 139 */     for (byte b = 0; b < i; b++) {
/* 140 */       char c = paramString.charAt(b);
/* 141 */       switch (c) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case '*':
/*     */         case '/':
/*     */         case ':':
/*     */         case '?':
/*     */         case '[':
/*     */         case '\\':
/*     */         case ']':
/* 154 */           throw new IllegalArgumentException("Invalid char (" + c + ") found at index (" + b + ") in sheet name '" + paramString + "'");
/*     */       } 
/*     */     } 
/* 157 */     if (paramString.charAt(0) == '\'' || paramString.charAt(i - 1) == '\'') {
/* 158 */       throw new IllegalArgumentException("Invalid sheet name '" + paramString + "'. Sheet names must not begin or end with (').");
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
/*     */ 
/*     */   
/*     */   public static void validateSheetState(int paramInt) {
/* 174 */     switch (paramInt) { case 0:
/*     */       case 1:
/*     */       case 2:
/*     */         return; }
/* 178 */      throw new IllegalArgumentException("Ivalid sheet state : " + paramInt + "\n" + "Sheet state must beone of the Workbook.SHEET_STATE_* constants");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\WorkbookUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */