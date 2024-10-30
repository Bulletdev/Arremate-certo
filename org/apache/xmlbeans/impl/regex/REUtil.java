/*     */ package org.apache.xmlbeans.impl.regex;
/*     */ 
/*     */ import java.text.CharacterIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class REUtil
/*     */ {
/*     */   static final int CACHESIZE = 20;
/*     */   
/*     */   static final int composeFromSurrogates(int paramInt1, int paramInt2) {
/*  25 */     return 65536 + (paramInt1 - 55296 << 10) + paramInt2 - 56320;
/*     */   }
/*     */   
/*     */   static final boolean isLowSurrogate(int paramInt) {
/*  29 */     return ((paramInt & 0xFC00) == 56320);
/*     */   }
/*     */   
/*     */   static final boolean isHighSurrogate(int paramInt) {
/*  33 */     return ((paramInt & 0xFC00) == 55296);
/*     */   }
/*     */   
/*     */   static final String decomposeToSurrogates(int paramInt) {
/*  37 */     char[] arrayOfChar = new char[2];
/*  38 */     paramInt -= 65536;
/*  39 */     arrayOfChar[0] = (char)((paramInt >> 10) + 55296);
/*  40 */     arrayOfChar[1] = (char)((paramInt & 0x3FF) + 56320);
/*  41 */     return new String(arrayOfChar);
/*     */   }
/*     */   
/*     */   static final String substring(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2) {
/*  45 */     char[] arrayOfChar = new char[paramInt2 - paramInt1];
/*  46 */     for (byte b = 0; b < arrayOfChar.length; b++)
/*  47 */       arrayOfChar[b] = paramCharacterIterator.setIndex(b + paramInt1); 
/*  48 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final int getOptionValue(int paramInt) {
/*  54 */     char c = Character.MIN_VALUE;
/*  55 */     switch (paramInt) {
/*     */       case 105:
/*  57 */         c = '\002';
/*     */         break;
/*     */       case 109:
/*  60 */         c = '\b';
/*     */         break;
/*     */       case 115:
/*  63 */         c = '\004';
/*     */         break;
/*     */       case 120:
/*  66 */         c = '\020';
/*     */         break;
/*     */       case 117:
/*  69 */         c = ' ';
/*     */         break;
/*     */       case 119:
/*  72 */         c = '@';
/*     */         break;
/*     */       case 70:
/*  75 */         c = 'Ā';
/*     */         break;
/*     */       case 72:
/*  78 */         c = '';
/*     */         break;
/*     */       case 88:
/*  81 */         c = 'Ȁ';
/*     */         break;
/*     */       case 44:
/*  84 */         c = 'Ѐ';
/*     */         break;
/*     */     } 
/*     */     
/*  88 */     return c;
/*     */   }
/*     */   
/*     */   static final int parseOptions(String paramString) throws ParseException {
/*  92 */     if (paramString == null) return 0; 
/*  93 */     int i = 0;
/*  94 */     for (byte b = 0; b < paramString.length(); b++) {
/*  95 */       int j = getOptionValue(paramString.charAt(b));
/*  96 */       if (j == 0)
/*  97 */         throw new ParseException("Unknown Option: " + paramString.substring(b), -1); 
/*  98 */       i |= j;
/*     */     } 
/* 100 */     return i;
/*     */   }
/*     */   
/*     */   static final String createOptionString(int paramInt) {
/* 104 */     StringBuffer stringBuffer = new StringBuffer(9);
/* 105 */     if ((paramInt & 0x100) != 0)
/* 106 */       stringBuffer.append('F'); 
/* 107 */     if ((paramInt & 0x80) != 0)
/* 108 */       stringBuffer.append('H'); 
/* 109 */     if ((paramInt & 0x200) != 0)
/* 110 */       stringBuffer.append('X'); 
/* 111 */     if ((paramInt & 0x2) != 0)
/* 112 */       stringBuffer.append('i'); 
/* 113 */     if ((paramInt & 0x8) != 0)
/* 114 */       stringBuffer.append('m'); 
/* 115 */     if ((paramInt & 0x4) != 0)
/* 116 */       stringBuffer.append('s'); 
/* 117 */     if ((paramInt & 0x20) != 0)
/* 118 */       stringBuffer.append('u'); 
/* 119 */     if ((paramInt & 0x40) != 0)
/* 120 */       stringBuffer.append('w'); 
/* 121 */     if ((paramInt & 0x10) != 0)
/* 122 */       stringBuffer.append('x'); 
/* 123 */     if ((paramInt & 0x400) != 0)
/* 124 */       stringBuffer.append(','); 
/* 125 */     return stringBuffer.toString().intern();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static String stripExtendedComment(String paramString) {
/* 131 */     int i = paramString.length();
/* 132 */     StringBuffer stringBuffer = new StringBuffer(i);
/* 133 */     byte b = 0;
/* 134 */     while (b < i) {
/* 135 */       char c = paramString.charAt(b++);
/*     */       
/* 137 */       if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
/*     */         continue;
/*     */       }
/* 140 */       if (c == '#') {
/* 141 */         while (b < i) {
/* 142 */           c = paramString.charAt(b++);
/* 143 */           if (c == '\r' || c == '\n') {
/*     */             break;
/*     */           }
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/* 150 */       if (c == '\\' && b < i) {
/* 151 */         char c1; if ((c1 = paramString.charAt(b)) == '#' || c1 == '\t' || c1 == '\n' || c1 == '\f' || c1 == '\r' || c1 == ' ') {
/*     */ 
/*     */           
/* 154 */           stringBuffer.append((char)c1);
/* 155 */           b++; continue;
/*     */         } 
/* 157 */         stringBuffer.append('\\');
/* 158 */         stringBuffer.append((char)c1);
/* 159 */         b++;
/*     */         continue;
/*     */       } 
/* 162 */       stringBuffer.append((char)c);
/*     */     } 
/* 164 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 174 */     String str = null;
/*     */     try {
/* 176 */       String str1 = "";
/* 177 */       String str2 = null;
/* 178 */       if (paramArrayOfString.length == 0) {
/* 179 */         System.out.println("Error:Usage: java REUtil -i|-m|-s|-u|-w|-X regularExpression String");
/* 180 */         System.exit(0);
/*     */       } 
/* 182 */       for (byte b1 = 0; b1 < paramArrayOfString.length; b1++) {
/* 183 */         if (paramArrayOfString[b1].length() == 0 || paramArrayOfString[b1].charAt(0) != '-') {
/* 184 */           if (str == null)
/* 185 */           { str = paramArrayOfString[b1]; }
/* 186 */           else if (str2 == null)
/* 187 */           { str2 = paramArrayOfString[b1]; }
/*     */           else
/* 189 */           { System.err.println("Unnecessary: " + paramArrayOfString[b1]); } 
/* 190 */         } else if (paramArrayOfString[b1].equals("-i")) {
/* 191 */           str1 = str1 + "i";
/* 192 */         } else if (paramArrayOfString[b1].equals("-m")) {
/* 193 */           str1 = str1 + "m";
/* 194 */         } else if (paramArrayOfString[b1].equals("-s")) {
/* 195 */           str1 = str1 + "s";
/* 196 */         } else if (paramArrayOfString[b1].equals("-u")) {
/* 197 */           str1 = str1 + "u";
/* 198 */         } else if (paramArrayOfString[b1].equals("-w")) {
/* 199 */           str1 = str1 + "w";
/* 200 */         } else if (paramArrayOfString[b1].equals("-X")) {
/* 201 */           str1 = str1 + "X";
/*     */         } else {
/* 203 */           System.err.println("Unknown option: " + paramArrayOfString[b1]);
/*     */         } 
/*     */       } 
/* 206 */       RegularExpression regularExpression = new RegularExpression(str, str1);
/* 207 */       System.out.println("RegularExpression: " + regularExpression);
/* 208 */       Match match = new Match();
/* 209 */       regularExpression.matches(str2, match);
/* 210 */       for (byte b2 = 0; b2 < match.getNumberOfGroups(); b2++) {
/* 211 */         if (b2 == 0) { System.out.print("Matched range for the whole pattern: "); }
/* 212 */         else { System.out.print("[" + b2 + "]: "); }
/* 213 */          if (match.getBeginning(b2) < 0) {
/* 214 */           System.out.println("-1");
/*     */         } else {
/* 216 */           System.out.print(match.getBeginning(b2) + ", " + match.getEnd(b2) + ", ");
/* 217 */           System.out.println("\"" + match.getCapturedText(b2) + "\"");
/*     */         } 
/*     */       } 
/* 220 */     } catch (ParseException parseException) {
/* 221 */       if (str == null) {
/* 222 */         parseException.printStackTrace();
/*     */       } else {
/* 224 */         System.err.println("org.apache.xerces.utils.regex.ParseException: " + parseException.getMessage());
/* 225 */         String str1 = "        ";
/* 226 */         System.err.println(str1 + str);
/* 227 */         int i = parseException.getLocation();
/* 228 */         if (i >= 0) {
/* 229 */           System.err.print(str1);
/* 230 */           for (byte b = 0; b < i; ) { System.err.print("-"); b++; }
/* 231 */            System.err.println("^");
/*     */         } 
/*     */       } 
/* 234 */     } catch (Exception exception) {
/* 235 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 240 */   static final RegularExpression[] regexCache = new RegularExpression[20];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RegularExpression createRegex(String paramString1, String paramString2) throws ParseException {
/* 249 */     RegularExpression regularExpression = null;
/* 250 */     int i = parseOptions(paramString2);
/* 251 */     synchronized (regexCache) {
/*     */       byte b;
/* 253 */       for (b = 0; b < 20; b++) {
/* 254 */         RegularExpression regularExpression1 = regexCache[b];
/* 255 */         if (regularExpression1 == null) {
/* 256 */           b = -1;
/*     */           break;
/*     */         } 
/* 259 */         if (regularExpression1.equals(paramString1, i)) {
/* 260 */           regularExpression = regularExpression1;
/*     */           break;
/*     */         } 
/*     */       } 
/* 264 */       if (regularExpression != null) {
/* 265 */         if (b != 0) {
/* 266 */           System.arraycopy(regexCache, 0, regexCache, 1, b);
/* 267 */           regexCache[0] = regularExpression;
/*     */         } 
/*     */       } else {
/* 270 */         regularExpression = new RegularExpression(paramString1, paramString2);
/* 271 */         System.arraycopy(regexCache, 0, regexCache, 1, 19);
/* 272 */         regexCache[0] = regularExpression;
/*     */       } 
/*     */     } 
/* 275 */     return regularExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean matches(String paramString1, String paramString2) throws ParseException {
/* 283 */     return createRegex(paramString1, null).matches(paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean matches(String paramString1, String paramString2, String paramString3) throws ParseException {
/* 291 */     return createRegex(paramString1, paramString2).matches(paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String quoteMeta(String paramString) {
/* 300 */     int i = paramString.length();
/* 301 */     StringBuffer stringBuffer = null;
/* 302 */     for (byte b = 0; b < i; b++) {
/* 303 */       char c = paramString.charAt(b);
/* 304 */       if (".*+?{[()|\\^$".indexOf(c) >= 0) {
/* 305 */         if (stringBuffer == null) {
/* 306 */           stringBuffer = new StringBuffer(b + (i - b) * 2);
/* 307 */           if (b > 0) stringBuffer.append(paramString.substring(0, b)); 
/*     */         } 
/* 309 */         stringBuffer.append('\\');
/* 310 */         stringBuffer.append((char)c);
/* 311 */       } else if (stringBuffer != null) {
/* 312 */         stringBuffer.append((char)c);
/*     */       } 
/* 314 */     }  return (stringBuffer != null) ? stringBuffer.toString() : paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void dumpString(String paramString) {
/* 320 */     for (byte b = 0; b < paramString.length(); b++) {
/* 321 */       System.out.print(Integer.toHexString(paramString.charAt(b)));
/* 322 */       System.out.print(" ");
/*     */     } 
/* 324 */     System.out.println();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\REUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */