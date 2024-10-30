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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Metaphone
/*     */   implements StringEncoder
/*     */ {
/*     */   private static final String VOWELS = "AEIOU";
/*     */   private static final String FRONTV = "EIY";
/*     */   private static final String VARSON = "CSPTG";
/*  72 */   private int maxCodeLen = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String metaphone(String paramString) {
/*  92 */     boolean bool = false;
/*     */     int i;
/*  94 */     if (paramString == null || (i = paramString.length()) == 0) {
/*  95 */       return "";
/*     */     }
/*     */     
/*  98 */     if (i == 1) {
/*  99 */       return paramString.toUpperCase(Locale.ENGLISH);
/*     */     }
/*     */     
/* 102 */     char[] arrayOfChar = paramString.toUpperCase(Locale.ENGLISH).toCharArray();
/*     */     
/* 104 */     StringBuilder stringBuilder1 = new StringBuilder(40);
/* 105 */     StringBuilder stringBuilder2 = new StringBuilder(10);
/*     */     
/* 107 */     switch (arrayOfChar[0]) {
/*     */       case 'G':
/*     */       case 'K':
/*     */       case 'P':
/* 111 */         if (arrayOfChar[1] == 'N') {
/* 112 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1); break;
/*     */         } 
/* 114 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       
/*     */       case 'A':
/* 118 */         if (arrayOfChar[1] == 'E') {
/* 119 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1); break;
/*     */         } 
/* 121 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       
/*     */       case 'W':
/* 125 */         if (arrayOfChar[1] == 'R') {
/* 126 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1);
/*     */           break;
/*     */         } 
/* 129 */         if (arrayOfChar[1] == 'H') {
/* 130 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1);
/* 131 */           stringBuilder1.setCharAt(0, 'W'); break;
/*     */         } 
/* 133 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       
/*     */       case 'X':
/* 137 */         arrayOfChar[0] = 'S';
/* 138 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       default:
/* 141 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */     } 
/* 144 */     int j = stringBuilder1.length();
/* 145 */     byte b = 0;
/*     */     
/* 147 */     while (stringBuilder2.length() < getMaxCodeLen() && b < j) {
/*     */       
/* 149 */       char c = stringBuilder1.charAt(b);
/*     */       
/* 151 */       if (c != 'C' && isPreviousChar(stringBuilder1, b, c)) {
/* 152 */         b++;
/*     */       } else {
/* 154 */         switch (c) {
/*     */           case 'A':
/*     */           case 'E':
/*     */           case 'I':
/*     */           case 'O':
/*     */           case 'U':
/* 160 */             if (b == 0) {
/* 161 */               stringBuilder2.append(c);
/*     */             }
/*     */             break;
/*     */           case 'B':
/* 165 */             if (isPreviousChar(stringBuilder1, b, 'M') && 
/* 166 */               isLastChar(j, b)) {
/*     */               break;
/*     */             }
/* 169 */             stringBuilder2.append(c);
/*     */             break;
/*     */           
/*     */           case 'C':
/* 173 */             if (isPreviousChar(stringBuilder1, b, 'S') && 
/* 174 */               !isLastChar(j, b) && "EIY"
/* 175 */               .indexOf(stringBuilder1.charAt(b + 1)) >= 0) {
/*     */               break;
/*     */             }
/* 178 */             if (regionMatch(stringBuilder1, b, "CIA")) {
/* 179 */               stringBuilder2.append('X');
/*     */               break;
/*     */             } 
/* 182 */             if (!isLastChar(j, b) && "EIY"
/* 183 */               .indexOf(stringBuilder1.charAt(b + 1)) >= 0) {
/* 184 */               stringBuilder2.append('S');
/*     */               break;
/*     */             } 
/* 187 */             if (isPreviousChar(stringBuilder1, b, 'S') && 
/* 188 */               isNextChar(stringBuilder1, b, 'H')) {
/* 189 */               stringBuilder2.append('K');
/*     */               break;
/*     */             } 
/* 192 */             if (isNextChar(stringBuilder1, b, 'H')) {
/* 193 */               if (b == 0 && j >= 3 && 
/*     */                 
/* 195 */                 isVowel(stringBuilder1, 2)) {
/* 196 */                 stringBuilder2.append('K'); break;
/*     */               } 
/* 198 */               stringBuilder2.append('X');
/*     */               break;
/*     */             } 
/* 201 */             stringBuilder2.append('K');
/*     */             break;
/*     */           
/*     */           case 'D':
/* 205 */             if (!isLastChar(j, b + 1) && 
/* 206 */               isNextChar(stringBuilder1, b, 'G') && "EIY"
/* 207 */               .indexOf(stringBuilder1.charAt(b + 2)) >= 0) {
/* 208 */               stringBuilder2.append('J'); b += 2; break;
/*     */             } 
/* 210 */             stringBuilder2.append('T');
/*     */             break;
/*     */           
/*     */           case 'G':
/* 214 */             if (isLastChar(j, b + 1) && 
/* 215 */               isNextChar(stringBuilder1, b, 'H')) {
/*     */               break;
/*     */             }
/* 218 */             if (!isLastChar(j, b + 1) && 
/* 219 */               isNextChar(stringBuilder1, b, 'H') && 
/* 220 */               !isVowel(stringBuilder1, b + 2)) {
/*     */               break;
/*     */             }
/* 223 */             if (b > 0 && (
/* 224 */               regionMatch(stringBuilder1, b, "GN") || 
/* 225 */               regionMatch(stringBuilder1, b, "GNED"))) {
/*     */               break;
/*     */             }
/* 228 */             if (isPreviousChar(stringBuilder1, b, 'G')) {
/*     */               
/* 230 */               bool = true;
/*     */             } else {
/* 232 */               bool = false;
/*     */             } 
/* 234 */             if (!isLastChar(j, b) && "EIY"
/* 235 */               .indexOf(stringBuilder1.charAt(b + 1)) >= 0 && !bool) {
/*     */               
/* 237 */               stringBuilder2.append('J'); break;
/*     */             } 
/* 239 */             stringBuilder2.append('K');
/*     */             break;
/*     */           
/*     */           case 'H':
/* 243 */             if (isLastChar(j, b)) {
/*     */               break;
/*     */             }
/* 246 */             if (b > 0 && "CSPTG"
/* 247 */               .indexOf(stringBuilder1.charAt(b - 1)) >= 0) {
/*     */               break;
/*     */             }
/* 250 */             if (isVowel(stringBuilder1, b + 1)) {
/* 251 */               stringBuilder2.append('H');
/*     */             }
/*     */             break;
/*     */           case 'F':
/*     */           case 'J':
/*     */           case 'L':
/*     */           case 'M':
/*     */           case 'N':
/*     */           case 'R':
/* 260 */             stringBuilder2.append(c);
/*     */             break;
/*     */           case 'K':
/* 263 */             if (b > 0) {
/* 264 */               if (!isPreviousChar(stringBuilder1, b, 'C'))
/* 265 */                 stringBuilder2.append(c); 
/*     */               break;
/*     */             } 
/* 268 */             stringBuilder2.append(c);
/*     */             break;
/*     */           
/*     */           case 'P':
/* 272 */             if (isNextChar(stringBuilder1, b, 'H')) {
/*     */               
/* 274 */               stringBuilder2.append('F'); break;
/*     */             } 
/* 276 */             stringBuilder2.append(c);
/*     */             break;
/*     */           
/*     */           case 'Q':
/* 280 */             stringBuilder2.append('K');
/*     */             break;
/*     */           case 'S':
/* 283 */             if (regionMatch(stringBuilder1, b, "SH") || 
/* 284 */               regionMatch(stringBuilder1, b, "SIO") || 
/* 285 */               regionMatch(stringBuilder1, b, "SIA")) {
/* 286 */               stringBuilder2.append('X'); break;
/*     */             } 
/* 288 */             stringBuilder2.append('S');
/*     */             break;
/*     */           
/*     */           case 'T':
/* 292 */             if (regionMatch(stringBuilder1, b, "TIA") || 
/* 293 */               regionMatch(stringBuilder1, b, "TIO")) {
/* 294 */               stringBuilder2.append('X');
/*     */               break;
/*     */             } 
/* 297 */             if (regionMatch(stringBuilder1, b, "TCH")) {
/*     */               break;
/*     */             }
/*     */ 
/*     */             
/* 302 */             if (regionMatch(stringBuilder1, b, "TH")) {
/* 303 */               stringBuilder2.append('0'); break;
/*     */             } 
/* 305 */             stringBuilder2.append('T');
/*     */             break;
/*     */           
/*     */           case 'V':
/* 309 */             stringBuilder2.append('F'); break;
/*     */           case 'W':
/*     */           case 'Y':
/* 312 */             if (!isLastChar(j, b) && 
/* 313 */               isVowel(stringBuilder1, b + 1)) {
/* 314 */               stringBuilder2.append(c);
/*     */             }
/*     */             break;
/*     */           case 'X':
/* 318 */             stringBuilder2.append('K');
/* 319 */             stringBuilder2.append('S');
/*     */             break;
/*     */           case 'Z':
/* 322 */             stringBuilder2.append('S');
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 328 */         b++;
/*     */       } 
/* 330 */       if (stringBuilder2.length() > getMaxCodeLen()) {
/* 331 */         stringBuilder2.setLength(getMaxCodeLen());
/*     */       }
/*     */     } 
/* 334 */     return stringBuilder2.toString();
/*     */   }
/*     */   
/*     */   private boolean isVowel(StringBuilder paramStringBuilder, int paramInt) {
/* 338 */     return ("AEIOU".indexOf(paramStringBuilder.charAt(paramInt)) >= 0);
/*     */   }
/*     */   
/*     */   private boolean isPreviousChar(StringBuilder paramStringBuilder, int paramInt, char paramChar) {
/* 342 */     boolean bool = false;
/* 343 */     if (paramInt > 0 && paramInt < paramStringBuilder
/* 344 */       .length()) {
/* 345 */       bool = (paramStringBuilder.charAt(paramInt - 1) == paramChar) ? true : false;
/*     */     }
/* 347 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean isNextChar(StringBuilder paramStringBuilder, int paramInt, char paramChar) {
/* 351 */     boolean bool = false;
/* 352 */     if (paramInt >= 0 && paramInt < paramStringBuilder
/* 353 */       .length() - 1) {
/* 354 */       bool = (paramStringBuilder.charAt(paramInt + 1) == paramChar) ? true : false;
/*     */     }
/* 356 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean regionMatch(StringBuilder paramStringBuilder, int paramInt, String paramString) {
/* 360 */     boolean bool = false;
/* 361 */     if (paramInt >= 0 && paramInt + paramString
/* 362 */       .length() - 1 < paramStringBuilder.length()) {
/* 363 */       String str = paramStringBuilder.substring(paramInt, paramInt + paramString.length());
/* 364 */       bool = str.equals(paramString);
/*     */     } 
/* 366 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean isLastChar(int paramInt1, int paramInt2) {
/* 370 */     return (paramInt2 + 1 == paramInt1);
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 388 */     if (!(paramObject instanceof String)) {
/* 389 */       throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
/*     */     }
/* 391 */     return metaphone((String)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String encode(String paramString) {
/* 402 */     return metaphone(paramString);
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
/*     */   public boolean isMetaphoneEqual(String paramString1, String paramString2) {
/* 414 */     return metaphone(paramString1).equals(metaphone(paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxCodeLen() {
/* 421 */     return this.maxCodeLen;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxCodeLen(int paramInt) {
/* 427 */     this.maxCodeLen = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\Metaphone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */