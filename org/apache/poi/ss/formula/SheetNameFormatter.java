/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SheetNameFormatter
/*     */ {
/*     */   private static final char DELIMITER = '\'';
/*  38 */   private static final Pattern CELL_REF_PATTERN = Pattern.compile("([A-Za-z]+)([0-9]+)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String format(String paramString) {
/*  50 */     StringBuffer stringBuffer = new StringBuffer(paramString.length() + 2);
/*  51 */     appendFormat(stringBuffer, paramString);
/*  52 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void appendFormat(StringBuffer paramStringBuffer, String paramString) {
/*  61 */     boolean bool = needsDelimiting(paramString);
/*  62 */     if (bool) {
/*  63 */       paramStringBuffer.append('\'');
/*  64 */       appendAndEscape(paramStringBuffer, paramString);
/*  65 */       paramStringBuffer.append('\'');
/*     */     } else {
/*  67 */       paramStringBuffer.append(paramString);
/*     */     } 
/*     */   }
/*     */   public static void appendFormat(StringBuffer paramStringBuffer, String paramString1, String paramString2) {
/*  71 */     boolean bool = (needsDelimiting(paramString1) || needsDelimiting(paramString2)) ? true : false;
/*  72 */     if (bool) {
/*  73 */       paramStringBuffer.append('\'');
/*  74 */       paramStringBuffer.append('[');
/*  75 */       appendAndEscape(paramStringBuffer, paramString1.replace('[', '(').replace(']', ')'));
/*  76 */       paramStringBuffer.append(']');
/*  77 */       appendAndEscape(paramStringBuffer, paramString2);
/*  78 */       paramStringBuffer.append('\'');
/*     */     } else {
/*  80 */       paramStringBuffer.append('[');
/*  81 */       paramStringBuffer.append(paramString1);
/*  82 */       paramStringBuffer.append(']');
/*  83 */       paramStringBuffer.append(paramString2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void appendAndEscape(StringBuffer paramStringBuffer, String paramString) {
/*  88 */     int i = paramString.length();
/*  89 */     for (byte b = 0; b < i; b++) {
/*  90 */       char c = paramString.charAt(b);
/*  91 */       if (c == '\'')
/*     */       {
/*  93 */         paramStringBuffer.append('\'');
/*     */       }
/*  95 */       paramStringBuffer.append(c);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean needsDelimiting(String paramString) {
/* 100 */     int i = paramString.length();
/* 101 */     if (i < 1) {
/* 102 */       throw new RuntimeException("Zero length string is an invalid sheet name");
/*     */     }
/* 104 */     if (Character.isDigit(paramString.charAt(0)))
/*     */     {
/* 106 */       return true;
/*     */     }
/* 108 */     for (byte b = 0; b < i; b++) {
/* 109 */       char c = paramString.charAt(b);
/* 110 */       if (isSpecialChar(c)) {
/* 111 */         return true;
/*     */       }
/*     */     } 
/* 114 */     if (Character.isLetter(paramString.charAt(0)) && Character.isDigit(paramString.charAt(i - 1)))
/*     */     {
/*     */       
/* 117 */       if (nameLooksLikePlainCellReference(paramString)) {
/* 118 */         return true;
/*     */       }
/*     */     }
/* 121 */     if (nameLooksLikeBooleanLiteral(paramString)) {
/* 122 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean nameLooksLikeBooleanLiteral(String paramString) {
/* 130 */     switch (paramString.charAt(0)) { case 'T':
/*     */       case 't':
/* 132 */         return "TRUE".equalsIgnoreCase(paramString);
/*     */       case 'F': case 'f':
/* 134 */         return "FALSE".equalsIgnoreCase(paramString); }
/*     */     
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isSpecialChar(char paramChar) {
/* 145 */     if (Character.isLetterOrDigit(paramChar)) {
/* 146 */       return false;
/*     */     }
/* 148 */     switch (paramChar) {
/*     */       case '.':
/*     */       case '_':
/* 151 */         return false;
/*     */       case '\t':
/*     */       case '\n':
/*     */       case '\r':
/* 155 */         throw new RuntimeException("Illegal character (0x" + Integer.toHexString(paramChar) + ") found in sheet name");
/*     */     } 
/*     */     
/* 158 */     return true;
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
/*     */ 
/*     */   
/*     */   static boolean cellReferenceIsWithinRange(String paramString1, String paramString2) {
/* 187 */     return CellReference.cellReferenceIsWithinRange(paramString1, paramString2, SpreadsheetVersion.EXCEL97);
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
/*     */   static boolean nameLooksLikePlainCellReference(String paramString) {
/* 213 */     Matcher matcher = CELL_REF_PATTERN.matcher(paramString);
/* 214 */     if (!matcher.matches()) {
/* 215 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 219 */     String str1 = matcher.group(1);
/* 220 */     String str2 = matcher.group(2);
/* 221 */     return cellReferenceIsWithinRange(str1, str2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\SheetNameFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */