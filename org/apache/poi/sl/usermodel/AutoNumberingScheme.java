/*     */ package org.apache.poi.sl.usermodel;
/*     */ 
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
/*     */ public enum AutoNumberingScheme
/*     */ {
/*  24 */   alphaLcParenBoth(8, 1),
/*     */   
/*  26 */   alphaUcParenBoth(10, 2),
/*     */   
/*  28 */   alphaLcParenRight(9, 3),
/*     */   
/*  30 */   alphaUcParenRight(11, 4),
/*     */   
/*  32 */   alphaLcPeriod(0, 5),
/*     */   
/*  34 */   alphaUcPeriod(1, 6),
/*     */   
/*  36 */   arabicParenBoth(12, 7),
/*     */   
/*  38 */   arabicParenRight(2, 8),
/*     */   
/*  40 */   arabicPeriod(3, 9),
/*     */   
/*  42 */   arabicPlain(13, 10),
/*     */   
/*  44 */   romanLcParenBoth(4, 11),
/*     */   
/*  46 */   romanUcParenBoth(14, 12),
/*     */   
/*  48 */   romanLcParenRight(5, 13),
/*     */   
/*  50 */   romanUcParenRight(15, 14),
/*     */   
/*  52 */   romanLcPeriod(6, 15),
/*     */   
/*  54 */   romanUcPeriod(7, 16),
/*     */   
/*  56 */   circleNumDbPlain(18, 17),
/*     */   
/*  58 */   circleNumWdBlackPlain(20, 18),
/*     */   
/*  60 */   circleNumWdWhitePlain(19, 19),
/*     */   
/*  62 */   arabicDbPeriod(29, 20),
/*     */   
/*  64 */   arabicDbPlain(28, 21),
/*     */   
/*  66 */   ea1ChsPeriod(17, 22),
/*     */   
/*  68 */   ea1ChsPlain(16, 23),
/*     */   
/*  70 */   ea1ChtPeriod(21, 24),
/*     */   
/*  72 */   ea1ChtPlain(20, 25),
/*     */   
/*  74 */   ea1JpnChsDbPeriod(38, 26),
/*     */   
/*  76 */   ea1JpnKorPlain(26, 27),
/*     */   
/*  78 */   ea1JpnKorPeriod(27, 28),
/*     */   
/*  80 */   arabic1Minus(23, 29),
/*     */   
/*  82 */   arabic2Minus(24, 30),
/*     */   
/*  84 */   hebrew2Minus(25, 31),
/*     */   
/*  86 */   thaiAlphaPeriod(30, 32),
/*     */   
/*  88 */   thaiAlphaParenRight(31, 33),
/*     */   
/*  90 */   thaiAlphaParenBoth(32, 34),
/*     */   
/*  92 */   thaiNumPeriod(33, 35),
/*     */   
/*  94 */   thaiNumParenRight(34, 36),
/*     */   
/*  96 */   thaiNumParenBoth(35, 37),
/*     */   
/*  98 */   hindiAlphaPeriod(36, 38),
/*     */   
/* 100 */   hindiNumPeriod(37, 39),
/*     */   
/* 102 */   hindiNumParenRight(39, 40),
/*     */   
/* 104 */   hindiAlpha1Period(39, 41); public final int nativeId;
/*     */   public final int ooxmlId;
/*     */   private static final String ARABIC_LIST = "0123456789";
/*     */   
/*     */   AutoNumberingScheme(int paramInt1, int paramInt2) {
/* 109 */     this.nativeId = paramInt1;
/* 110 */     this.ooxmlId = paramInt2;
/*     */   }
/*     */   private static final String ALPHA_LIST = "abcdefghijklmnopqrstuvwxyz"; private static final String WINGDINGS_WHITE_LIST = ""; private static final String WINGDINGS_BLACK_LIST = ""; private static final String CIRCLE_DB_LIST = "❶❷❸❹❺❻❼❽❾";
/*     */   public static AutoNumberingScheme forNativeID(int paramInt) {
/* 114 */     for (AutoNumberingScheme autoNumberingScheme : values()) {
/* 115 */       if (autoNumberingScheme.nativeId == paramInt) return autoNumberingScheme; 
/*     */     } 
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   public static AutoNumberingScheme forOoxmlID(int paramInt) {
/* 121 */     for (AutoNumberingScheme autoNumberingScheme : values()) {
/* 122 */       if (autoNumberingScheme.ooxmlId == paramInt) return autoNumberingScheme; 
/*     */     } 
/* 124 */     return null;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 128 */     switch (this) { case alphaLcPeriod:
/* 129 */         return "Lowercase Latin character followed by a period. Example: a., b., c., ...";
/* 130 */       case alphaUcPeriod: return "Uppercase Latin character followed by a period. Example: A., B., C., ...";
/* 131 */       case arabicParenRight: return "Arabic numeral followed by a closing parenthesis. Example: 1), 2), 3), ...";
/* 132 */       case arabicPeriod: return "Arabic numeral followed by a period. Example: 1., 2., 3., ...";
/* 133 */       case romanLcParenBoth: return "Lowercase Roman numeral enclosed in parentheses. Example: (i), (ii), (iii), ...";
/* 134 */       case romanLcParenRight: return "Lowercase Roman numeral followed by a closing parenthesis. Example: i), ii), iii), ...";
/* 135 */       case romanLcPeriod: return "Lowercase Roman numeral followed by a period. Example: i., ii., iii., ...";
/* 136 */       case romanUcPeriod: return "Uppercase Roman numeral followed by a period. Example: I., II., III., ...";
/* 137 */       case alphaLcParenBoth: return "Lowercase alphabetic character enclosed in parentheses. Example: (a), (b), (c), ...";
/* 138 */       case alphaLcParenRight: return "Lowercase alphabetic character followed by a closing parenthesis. Example: a), b), c), ...";
/* 139 */       case alphaUcParenBoth: return "Uppercase alphabetic character enclosed in parentheses. Example: (A), (B), (C), ...";
/* 140 */       case alphaUcParenRight: return "Uppercase alphabetic character followed by a closing parenthesis. Example: A), B), C), ...";
/* 141 */       case arabicParenBoth: return "Arabic numeral enclosed in parentheses. Example: (1), (2), (3), ...";
/* 142 */       case arabicPlain: return "Arabic numeral. Example: 1, 2, 3, ...";
/* 143 */       case romanUcParenBoth: return "Uppercase Roman numeral enclosed in parentheses. Example: (I), (II), (III), ...";
/* 144 */       case romanUcParenRight: return "Uppercase Roman numeral followed by a closing parenthesis. Example: I), II), III), ...";
/* 145 */       case ea1ChsPlain: return "Simplified Chinese.";
/* 146 */       case ea1ChsPeriod: return "Simplified Chinese with single-byte period.";
/* 147 */       case circleNumDbPlain: return "Double byte circle numbers.";
/* 148 */       case circleNumWdWhitePlain: return "Wingdings white circle numbers.";
/* 149 */       case circleNumWdBlackPlain: return "Wingdings black circle numbers.";
/* 150 */       case ea1ChtPlain: return "Traditional Chinese.";
/* 151 */       case ea1ChtPeriod: return "Traditional Chinese with single-byte period.";
/* 152 */       case arabic1Minus: return "Bidi Arabic 1 (AraAlpha) with ANSI minus symbol.";
/* 153 */       case arabic2Minus: return "Bidi Arabic 2 (AraAbjad) with ANSI minus symbol.";
/* 154 */       case hebrew2Minus: return "Bidi Hebrew 2 with ANSI minus symbol.";
/* 155 */       case ea1JpnKorPlain: return "Japanese/Korean.";
/* 156 */       case ea1JpnKorPeriod: return "Japanese/Korean with single-byte period.";
/* 157 */       case arabicDbPlain: return "Double-byte Arabic numbers.";
/* 158 */       case arabicDbPeriod: return "Double-byte Arabic numbers with double-byte period.";
/* 159 */       case thaiAlphaPeriod: return "Thai alphabetic character followed by a period.";
/* 160 */       case thaiAlphaParenRight: return "Thai alphabetic character followed by a closing parenthesis.";
/* 161 */       case thaiAlphaParenBoth: return "Thai alphabetic character enclosed by parentheses.";
/* 162 */       case thaiNumPeriod: return "Thai numeral followed by a period.";
/* 163 */       case thaiNumParenRight: return "Thai numeral followed by a closing parenthesis.";
/* 164 */       case thaiNumParenBoth: return "Thai numeral enclosed in parentheses.";
/* 165 */       case hindiAlphaPeriod: return "Hindi alphabetic character followed by a period.";
/* 166 */       case hindiNumPeriod: return "Hindi numeric character followed by a period.";
/* 167 */       case ea1JpnChsDbPeriod: return "Japanese with double-byte period.";
/* 168 */       case hindiNumParenRight: return "Hindi numeric character followed by a closing parenthesis.";
/* 169 */       case hindiAlpha1Period: return "Hindi alphabetic character followed by a period."; }
/* 170 */      return "Unknown Numbered Scheme";
/*     */   }
/*     */ 
/*     */   
/*     */   public String format(int paramInt) {
/* 175 */     String str1 = formatIndex(paramInt);
/* 176 */     String str2 = formatCase(str1);
/* 177 */     return formatSeperator(str2);
/*     */   }
/*     */ 
/*     */   
/*     */   private String formatSeperator(String paramString) {
/* 182 */     String str = name().toLowerCase(Locale.ROOT);
/* 183 */     if (str.contains("plain")) return paramString; 
/* 184 */     if (str.contains("parenright")) return paramString + ")"; 
/* 185 */     if (str.contains("parenboth")) return "(" + paramString + ")"; 
/* 186 */     if (str.contains("period")) return paramString + "."; 
/* 187 */     if (str.contains("minus")) return paramString + "-"; 
/* 188 */     return paramString;
/*     */   }
/*     */   
/*     */   private String formatCase(String paramString) {
/* 192 */     String str = name().toLowerCase(Locale.ROOT);
/* 193 */     if (str.contains("lc")) return paramString.toLowerCase(Locale.ROOT); 
/* 194 */     if (str.contains("uc")) return paramString.toUpperCase(Locale.ROOT); 
/* 195 */     return paramString;
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
/*     */   private String formatIndex(int paramInt) {
/* 208 */     String str = name().toLowerCase(Locale.ROOT);
/* 209 */     if (str.startsWith("roman"))
/* 210 */       return formatRomanIndex(paramInt); 
/* 211 */     if (str.startsWith("arabic") && !str.contains("db"))
/* 212 */       return getIndexedList(paramInt, "0123456789", false); 
/* 213 */     if (str.startsWith("alpha"))
/* 214 */       return getIndexedList(paramInt, "abcdefghijklmnopqrstuvwxyz", true); 
/* 215 */     if (str.contains("WdWhite")) {
/* 216 */       return (paramInt == 10) ? "" : getIndexedList(paramInt, "", false);
/*     */     }
/* 218 */     if (str.contains("WdBlack")) {
/* 219 */       return (paramInt == 10) ? "" : getIndexedList(paramInt, "", false);
/*     */     }
/* 221 */     if (str.contains("NumDb")) {
/* 222 */       return (paramInt == 10) ? "❿" : getIndexedList(paramInt, "❶❷❸❹❺❻❼❽❾", true);
/*     */     }
/*     */     
/* 225 */     return "?";
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getIndexedList(int paramInt, String paramString, boolean paramBoolean) {
/* 230 */     StringBuilder stringBuilder = new StringBuilder();
/* 231 */     addIndexedChar(paramInt, paramString, paramBoolean, stringBuilder);
/* 232 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static void addIndexedChar(int paramInt, String paramString, boolean paramBoolean, StringBuilder paramStringBuilder) {
/* 236 */     if (paramBoolean) paramInt--; 
/* 237 */     int i = paramString.length();
/* 238 */     if (paramInt >= i) {
/* 239 */       addIndexedChar(paramInt / i, paramString, paramBoolean, paramStringBuilder);
/*     */     }
/* 241 */     paramStringBuilder.append(paramString.charAt(paramInt % i));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String formatRomanIndex(int paramInt) {
/* 247 */     int[] arrayOfInt = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/* 248 */     String[] arrayOfString = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/* 249 */     String[][] arrayOfString1 = { { "XLV", "VL" }, { "XCV", "VC" }, { "CDL", "LD" }, { "CML", "LM" }, { "CMVC", "LMVL" }, { "CDXC", "LDXL" }, { "CDVC", "LDVL" }, { "CMXC", "LMXL" }, { "XCIX", "VCIV" }, { "XLIX", "VLIV" }, { "XLIX", "IL" }, { "XCIX", "IC" }, { "CDXC", "XD" }, { "CDVC", "XDV" }, { "CDIC", "XDIX" }, { "LMVL", "XMV" }, { "CMIC", "XMIX" }, { "CMXC", "XM" }, { "XDV", "VD" }, { "XDIX", "VDIV" }, { "XMV", "VM" }, { "XMIX", "VMIV" }, { "VDIV", "ID" }, { "VMIV", "IM" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 276 */     StringBuilder stringBuilder = new StringBuilder();
/* 277 */     for (byte b = 0; b < 13; b++) {
/* 278 */       while (paramInt >= arrayOfInt[b]) {
/* 279 */         paramInt -= arrayOfInt[b];
/* 280 */         stringBuilder.append(arrayOfString[b]);
/*     */       } 
/*     */     } 
/* 283 */     String str = stringBuilder.toString();
/* 284 */     for (String[] arrayOfString2 : arrayOfString1) {
/* 285 */       str = str.replace(arrayOfString2[0], arrayOfString2[1]);
/*     */     }
/* 287 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\AutoNumberingScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */