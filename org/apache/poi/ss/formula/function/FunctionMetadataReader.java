/*     */ package org.apache.poi.ss.formula.function;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class FunctionMetadataReader
/*     */ {
/*     */   private static final String METADATA_FILE_NAME = "functionMetadata.txt";
/*     */   private static final String ELLIPSIS = "...";
/*  44 */   private static final Pattern TAB_DELIM_PATTERN = Pattern.compile("\t");
/*  45 */   private static final Pattern SPACE_DELIM_PATTERN = Pattern.compile(" ");
/*  46 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */   
/*  48 */   private static final String[] DIGIT_ENDING_FUNCTION_NAMES = new String[] { "LOG10", "ATAN2", "DAYS360", "SUMXMY2", "SUMX2MY2", "SUMX2PY2" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private static final Set<String> DIGIT_ENDING_FUNCTION_NAMES_SET = new HashSet<String>(Arrays.asList(DIGIT_ENDING_FUNCTION_NAMES));
/*     */   
/*     */   public static FunctionMetadataRegistry createRegistry() {
/*     */     try {
/*  57 */       InputStream inputStream = FunctionMetadataReader.class.getResourceAsStream("functionMetadata.txt");
/*  58 */       if (inputStream == null) {
/*  59 */         throw new RuntimeException("resource 'functionMetadata.txt' not found");
/*     */       }
/*     */       
/*     */       try {
/*     */         BufferedReader bufferedReader;
/*     */         try {
/*  65 */           bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
/*  66 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  67 */           throw new RuntimeException(unsupportedEncodingException);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       finally {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  93 */         inputStream.close();
/*     */       } 
/*  95 */     } catch (IOException iOException) {
/*  96 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void processLine(FunctionDataBuilder paramFunctionDataBuilder, String paramString) {
/* 102 */     String[] arrayOfString = TAB_DELIM_PATTERN.split(paramString, -2);
/* 103 */     if (arrayOfString.length != 8) {
/* 104 */       throw new RuntimeException("Bad line format '" + paramString + "' - expected 8 data fields");
/*     */     }
/* 106 */     int i = parseInt(arrayOfString[0]);
/* 107 */     String str = arrayOfString[1];
/* 108 */     int j = parseInt(arrayOfString[2]);
/* 109 */     int k = parseInt(arrayOfString[3]);
/* 110 */     byte b = parseReturnTypeCode(arrayOfString[4]);
/* 111 */     byte[] arrayOfByte = parseOperandTypeCodes(arrayOfString[5]);
/*     */     
/* 113 */     boolean bool = (arrayOfString[7].length() > 0) ? true : false;
/*     */     
/* 115 */     validateFunctionName(str);
/*     */     
/* 117 */     paramFunctionDataBuilder.add(i, str, j, k, b, arrayOfByte, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte parseReturnTypeCode(String paramString) {
/* 123 */     if (paramString.length() == 0) {
/* 124 */       return 0;
/*     */     }
/* 126 */     return parseOperandTypeCode(paramString);
/*     */   }
/*     */   
/*     */   private static byte[] parseOperandTypeCodes(String paramString) {
/* 130 */     if (paramString.length() < 1) {
/* 131 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 133 */     if (isDash(paramString))
/*     */     {
/* 135 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 137 */     String[] arrayOfString = SPACE_DELIM_PATTERN.split(paramString);
/* 138 */     int i = arrayOfString.length;
/* 139 */     if ("...".equals(arrayOfString[i - 1]))
/*     */     {
/*     */       
/* 142 */       i--;
/*     */     }
/* 144 */     byte[] arrayOfByte = new byte[i];
/* 145 */     for (byte b = 0; b < i; b++) {
/* 146 */       arrayOfByte[b] = parseOperandTypeCode(arrayOfString[b]);
/*     */     }
/* 148 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private static boolean isDash(String paramString) {
/* 152 */     if (paramString.length() == 1) {
/* 153 */       switch (paramString.charAt(0)) {
/*     */         case '-':
/* 155 */           return true;
/*     */       } 
/*     */     }
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   private static byte parseOperandTypeCode(String paramString) {
/* 162 */     if (paramString.length() != 1) {
/* 163 */       throw new RuntimeException("Bad operand type code format '" + paramString + "' expected single char");
/*     */     }
/* 165 */     switch (paramString.charAt(0)) { case 'V':
/* 166 */         return 32;
/* 167 */       case 'R': return 0;
/* 168 */       case 'A': return 64; }
/*     */     
/* 170 */     throw new IllegalArgumentException("Unexpected operand type code '" + paramString + "' (" + paramString.charAt(0) + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void validateFunctionName(String paramString) {
/* 178 */     int i = paramString.length();
/* 179 */     int j = i - 1;
/* 180 */     if (!Character.isDigit(paramString.charAt(j))) {
/*     */       return;
/*     */     }
/* 183 */     while (j >= 0 && 
/* 184 */       Character.isDigit(paramString.charAt(j)))
/*     */     {
/*     */       
/* 187 */       j--;
/*     */     }
/* 189 */     if (DIGIT_ENDING_FUNCTION_NAMES_SET.contains(paramString)) {
/*     */       return;
/*     */     }
/* 192 */     throw new RuntimeException("Invalid function name '" + paramString + "' (is footnote number incorrectly appended)");
/*     */   }
/*     */ 
/*     */   
/*     */   private static int parseInt(String paramString) {
/*     */     try {
/* 198 */       return Integer.parseInt(paramString);
/* 199 */     } catch (NumberFormatException numberFormatException) {
/* 200 */       throw new RuntimeException("Value '" + paramString + "' could not be parsed as an integer");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\function\FunctionMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */