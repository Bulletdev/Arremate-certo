/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MatchRatingApproachEncoder
/*     */   implements StringEncoder
/*     */ {
/*     */   private static final String SPACE = " ";
/*     */   private static final String EMPTY = "";
/*     */   private static final int ONE = 1;
/*     */   private static final int TWO = 2;
/*     */   private static final int THREE = 3;
/*     */   private static final int FOUR = 4;
/*     */   private static final int FIVE = 5;
/*     */   private static final int SIX = 6;
/*     */   private static final int SEVEN = 7;
/*     */   private static final int ELEVEN = 11;
/*     */   private static final int TWELVE = 12;
/*     */   private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
/*     */   private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";
/*  66 */   private static final String[] DOUBLE_CONSONANT = new String[] { "BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", "TT", "VV", "WW", "XX", "YY", "ZZ" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String cleanName(String paramString) {
/*  84 */     String str = paramString.toUpperCase(Locale.ENGLISH);
/*     */     
/*  86 */     String[] arrayOfString = { "\\-", "[&]", "\\'", "\\.", "[\\,]" };
/*  87 */     for (String str1 : arrayOfString) {
/*  88 */       str = str.replaceAll(str1, "");
/*     */     }
/*     */     
/*  91 */     str = removeAccents(str);
/*  92 */     str = str.replaceAll("\\s+", "");
/*     */     
/*  94 */     return str;
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
/*     */   public final Object encode(Object paramObject) throws EncoderException {
/* 110 */     if (!(paramObject instanceof String)) {
/* 111 */       throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
/*     */     }
/*     */     
/* 114 */     return encode((String)paramObject);
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
/*     */   public final String encode(String paramString) {
/* 127 */     if (paramString == null || "".equalsIgnoreCase(paramString) || " ".equalsIgnoreCase(paramString) || paramString.length() == 1) {
/* 128 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 132 */     paramString = cleanName(paramString);
/*     */ 
/*     */ 
/*     */     
/* 136 */     paramString = removeVowels(paramString);
/*     */ 
/*     */     
/* 139 */     paramString = removeDoubleConsonants(paramString);
/*     */ 
/*     */     
/* 142 */     paramString = getFirst3Last3(paramString);
/*     */     
/* 144 */     return paramString;
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
/*     */   String getFirst3Last3(String paramString) {
/* 160 */     int i = paramString.length();
/*     */     
/* 162 */     if (i > 6) {
/* 163 */       String str1 = paramString.substring(0, 3);
/* 164 */       String str2 = paramString.substring(i - 3, i);
/* 165 */       return str1 + str2;
/*     */     } 
/* 167 */     return paramString;
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
/*     */   int getMinRating(int paramInt) {
/* 184 */     byte b = 0;
/*     */     
/* 186 */     if (paramInt <= 4) {
/* 187 */       b = 5;
/* 188 */     } else if (paramInt <= 7) {
/* 189 */       b = 4;
/* 190 */     } else if (paramInt <= 11) {
/* 191 */       b = 3;
/* 192 */     } else if (paramInt == 12) {
/* 193 */       b = 2;
/*     */     } else {
/* 195 */       b = 1;
/*     */     } 
/*     */     
/* 198 */     return b;
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
/*     */   public boolean isEncodeEquals(String paramString1, String paramString2) {
/* 213 */     if (paramString1 == null || "".equalsIgnoreCase(paramString1) || " ".equalsIgnoreCase(paramString1))
/* 214 */       return false; 
/* 215 */     if (paramString2 == null || "".equalsIgnoreCase(paramString2) || " ".equalsIgnoreCase(paramString2))
/* 216 */       return false; 
/* 217 */     if (paramString1.length() == 1 || paramString2.length() == 1)
/* 218 */       return false; 
/* 219 */     if (paramString1.equalsIgnoreCase(paramString2)) {
/* 220 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 224 */     paramString1 = cleanName(paramString1);
/* 225 */     paramString2 = cleanName(paramString2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     paramString1 = removeVowels(paramString1);
/* 231 */     paramString2 = removeVowels(paramString2);
/*     */ 
/*     */     
/* 234 */     paramString1 = removeDoubleConsonants(paramString1);
/* 235 */     paramString2 = removeDoubleConsonants(paramString2);
/*     */ 
/*     */     
/* 238 */     paramString1 = getFirst3Last3(paramString1);
/* 239 */     paramString2 = getFirst3Last3(paramString2);
/*     */ 
/*     */ 
/*     */     
/* 243 */     if (Math.abs(paramString1.length() - paramString2.length()) >= 3) {
/* 244 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 249 */     int i = Math.abs(paramString1.length() + paramString2.length());
/* 250 */     int j = 0;
/* 251 */     j = getMinRating(i);
/*     */ 
/*     */ 
/*     */     
/* 255 */     int k = leftToRightThenRightToLeftProcessing(paramString1, paramString2);
/*     */ 
/*     */ 
/*     */     
/* 259 */     return (k >= j);
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
/*     */   boolean isVowel(String paramString) {
/* 276 */     return (paramString.equalsIgnoreCase("E") || paramString.equalsIgnoreCase("A") || paramString.equalsIgnoreCase("O") || paramString
/* 277 */       .equalsIgnoreCase("I") || paramString.equalsIgnoreCase("U"));
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
/*     */   int leftToRightThenRightToLeftProcessing(String paramString1, String paramString2) {
/* 294 */     char[] arrayOfChar1 = paramString1.toCharArray();
/* 295 */     char[] arrayOfChar2 = paramString2.toCharArray();
/*     */     
/* 297 */     int i = paramString1.length() - 1;
/* 298 */     int j = paramString2.length() - 1;
/*     */     
/* 300 */     String str1 = "";
/* 301 */     String str2 = "";
/*     */     
/* 303 */     String str3 = "";
/* 304 */     String str4 = "";
/*     */     
/* 306 */     for (byte b = 0; b < arrayOfChar1.length && 
/* 307 */       b <= j; b++) {
/*     */ 
/*     */ 
/*     */       
/* 311 */       str1 = paramString1.substring(b, b + 1);
/* 312 */       str2 = paramString1.substring(i - b, i - b + 1);
/*     */       
/* 314 */       str3 = paramString2.substring(b, b + 1);
/* 315 */       str4 = paramString2.substring(j - b, j - b + 1);
/*     */ 
/*     */       
/* 318 */       if (str1.equals(str3)) {
/* 319 */         arrayOfChar1[b] = ' ';
/* 320 */         arrayOfChar2[b] = ' ';
/*     */       } 
/*     */ 
/*     */       
/* 324 */       if (str2.equals(str4)) {
/* 325 */         arrayOfChar1[i - b] = ' ';
/* 326 */         arrayOfChar2[j - b] = ' ';
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 331 */     String str5 = (new String(arrayOfChar1)).replaceAll("\\s+", "");
/* 332 */     String str6 = (new String(arrayOfChar2)).replaceAll("\\s+", "");
/*     */ 
/*     */     
/* 335 */     if (str5.length() > str6.length()) {
/* 336 */       return Math.abs(6 - str5.length());
/*     */     }
/* 338 */     return Math.abs(6 - str6.length());
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
/*     */   String removeAccents(String paramString) {
/* 350 */     if (paramString == null) {
/* 351 */       return null;
/*     */     }
/*     */     
/* 354 */     StringBuilder stringBuilder = new StringBuilder();
/* 355 */     int i = paramString.length();
/*     */     
/* 357 */     for (byte b = 0; b < i; b++) {
/* 358 */       char c = paramString.charAt(b);
/* 359 */       int j = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű".indexOf(c);
/* 360 */       if (j > -1) {
/* 361 */         stringBuilder.append("AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu".charAt(j));
/*     */       } else {
/* 363 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/*     */     
/* 367 */     return stringBuilder.toString();
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
/*     */   String removeDoubleConsonants(String paramString) {
/* 383 */     String str = paramString.toUpperCase(Locale.ENGLISH);
/* 384 */     for (String str1 : DOUBLE_CONSONANT) {
/* 385 */       if (str.contains(str1)) {
/* 386 */         String str2 = str1.substring(0, 1);
/* 387 */         str = str.replace(str1, str2);
/*     */       } 
/*     */     } 
/* 390 */     return str;
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
/*     */   String removeVowels(String paramString) {
/* 407 */     String str = paramString.substring(0, 1);
/*     */     
/* 409 */     paramString = paramString.replaceAll("A", "");
/* 410 */     paramString = paramString.replaceAll("E", "");
/* 411 */     paramString = paramString.replaceAll("I", "");
/* 412 */     paramString = paramString.replaceAll("O", "");
/* 413 */     paramString = paramString.replaceAll("U", "");
/*     */     
/* 415 */     paramString = paramString.replaceAll("\\s{2,}\\b", " ");
/*     */ 
/*     */     
/* 418 */     if (isVowel(str)) {
/* 419 */       return str + paramString;
/*     */     }
/* 421 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\MatchRatingApproachEncoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */