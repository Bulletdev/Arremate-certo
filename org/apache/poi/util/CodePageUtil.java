/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodePageUtil
/*     */ {
/*     */   public static final int CP_037 = 37;
/*     */   public static final int CP_SJIS = 932;
/*     */   public static final int CP_GBK = 936;
/*     */   public static final int CP_MS949 = 949;
/*     */   public static final int CP_UTF16 = 1200;
/*     */   public static final int CP_UTF16_BE = 1201;
/*     */   public static final int CP_WINDOWS_1250 = 1250;
/*     */   public static final int CP_WINDOWS_1251 = 1251;
/*     */   public static final int CP_WINDOWS_1252 = 1252;
/*     */   public static final int CP_WINDOWS_1252_BIFF23 = 32769;
/*     */   public static final int CP_WINDOWS_1253 = 1253;
/*     */   public static final int CP_WINDOWS_1254 = 1254;
/*     */   public static final int CP_WINDOWS_1255 = 1255;
/*     */   public static final int CP_WINDOWS_1256 = 1256;
/*     */   public static final int CP_WINDOWS_1257 = 1257;
/*     */   public static final int CP_WINDOWS_1258 = 1258;
/*     */   public static final int CP_JOHAB = 1361;
/*     */   public static final int CP_MAC_ROMAN = 10000;
/*     */   public static final int CP_MAC_ROMAN_BIFF23 = 32768;
/*     */   public static final int CP_MAC_JAPAN = 10001;
/*     */   public static final int CP_MAC_CHINESE_TRADITIONAL = 10002;
/*     */   public static final int CP_MAC_KOREAN = 10003;
/*     */   public static final int CP_MAC_ARABIC = 10004;
/*     */   public static final int CP_MAC_HEBREW = 10005;
/*     */   public static final int CP_MAC_GREEK = 10006;
/*     */   public static final int CP_MAC_CYRILLIC = 10007;
/*     */   public static final int CP_MAC_CHINESE_SIMPLE = 10008;
/*     */   public static final int CP_MAC_ROMANIA = 10010;
/*     */   public static final int CP_MAC_UKRAINE = 10017;
/*     */   public static final int CP_MAC_THAI = 10021;
/*     */   public static final int CP_MAC_CENTRAL_EUROPE = 10029;
/*     */   public static final int CP_MAC_ICELAND = 10079;
/*     */   public static final int CP_MAC_TURKISH = 10081;
/*     */   public static final int CP_MAC_CROATIAN = 10082;
/*     */   public static final int CP_US_ACSII = 20127;
/*     */   public static final int CP_KOI8_R = 20866;
/*     */   public static final int CP_ISO_8859_1 = 28591;
/*     */   public static final int CP_ISO_8859_2 = 28592;
/*     */   public static final int CP_ISO_8859_3 = 28593;
/*     */   public static final int CP_ISO_8859_4 = 28594;
/*     */   public static final int CP_ISO_8859_5 = 28595;
/*     */   public static final int CP_ISO_8859_6 = 28596;
/*     */   public static final int CP_ISO_8859_7 = 28597;
/*     */   public static final int CP_ISO_8859_8 = 28598;
/*     */   public static final int CP_ISO_8859_9 = 28599;
/*     */   public static final int CP_ISO_2022_JP1 = 50220;
/*     */   public static final int CP_ISO_2022_JP2 = 50221;
/*     */   public static final int CP_ISO_2022_JP3 = 50222;
/*     */   public static final int CP_ISO_2022_KR = 50225;
/*     */   public static final int CP_EUC_JP = 51932;
/*     */   public static final int CP_EUC_KR = 51949;
/*     */   public static final int CP_GB2312 = 52936;
/*     */   public static final int CP_GB18030 = 54936;
/*     */   public static final int CP_US_ASCII2 = 65000;
/*     */   public static final int CP_UTF8 = 65001;
/*     */   public static final int CP_UNICODE = 1200;
/*     */   
/*     */   public static byte[] getBytesInCodePage(String paramString, int paramInt) throws UnsupportedEncodingException {
/* 208 */     String str = codepageToEncoding(paramInt);
/* 209 */     return paramString.getBytes(str);
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
/*     */   public static String getStringFromCodePage(byte[] paramArrayOfbyte, int paramInt) throws UnsupportedEncodingException {
/* 221 */     return getStringFromCodePage(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
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
/*     */   public static String getStringFromCodePage(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) throws UnsupportedEncodingException {
/* 233 */     String str = codepageToEncoding(paramInt3);
/* 234 */     return new String(paramArrayOfbyte, paramInt1, paramInt2, str);
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
/*     */   public static String codepageToEncoding(int paramInt) throws UnsupportedEncodingException {
/* 255 */     return codepageToEncoding(paramInt, false);
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
/*     */   public static String codepageToEncoding(int paramInt, boolean paramBoolean) throws UnsupportedEncodingException {
/* 276 */     if (paramInt <= 0) {
/* 277 */       throw new UnsupportedEncodingException("Codepage number may not be " + paramInt);
/*     */     }
/* 279 */     switch (paramInt) {
/*     */       case 1200:
/* 281 */         return "UTF-16";
/*     */       case 1201:
/* 283 */         return "UTF-16BE";
/*     */       case 65001:
/* 285 */         return "UTF-8";
/*     */       case 37:
/* 287 */         return "cp037";
/*     */       case 936:
/* 289 */         return "GBK";
/*     */       case 949:
/* 291 */         return "ms949";
/*     */       case 1250:
/* 293 */         if (paramBoolean) {
/* 294 */           return "Cp1250";
/*     */         }
/* 296 */         return "windows-1250";
/*     */       case 1251:
/* 298 */         if (paramBoolean) {
/* 299 */           return "Cp1251";
/*     */         }
/* 301 */         return "windows-1251";
/*     */       case 1252:
/*     */       case 32769:
/* 304 */         if (paramBoolean) {
/* 305 */           return "Cp1252";
/*     */         }
/* 307 */         return "windows-1252";
/*     */       case 1253:
/* 309 */         if (paramBoolean) {
/* 310 */           return "Cp1253";
/*     */         }
/* 312 */         return "windows-1253";
/*     */       case 1254:
/* 314 */         if (paramBoolean) {
/* 315 */           return "Cp1254";
/*     */         }
/* 317 */         return "windows-1254";
/*     */       case 1255:
/* 319 */         if (paramBoolean) {
/* 320 */           return "Cp1255";
/*     */         }
/* 322 */         return "windows-1255";
/*     */       case 1256:
/* 324 */         if (paramBoolean) {
/* 325 */           return "Cp1255";
/*     */         }
/* 327 */         return "windows-1256";
/*     */       case 1257:
/* 329 */         if (paramBoolean) {
/* 330 */           return "Cp1257";
/*     */         }
/* 332 */         return "windows-1257";
/*     */       case 1258:
/* 334 */         if (paramBoolean) {
/* 335 */           return "Cp1258";
/*     */         }
/* 337 */         return "windows-1258";
/*     */       case 1361:
/* 339 */         return "johab";
/*     */       case 10000:
/*     */       case 32768:
/* 342 */         return "MacRoman";
/*     */       case 10001:
/* 344 */         return "SJIS";
/*     */       case 10002:
/* 346 */         return "Big5";
/*     */       case 10003:
/* 348 */         return "EUC-KR";
/*     */       case 10004:
/* 350 */         return "MacArabic";
/*     */       case 10005:
/* 352 */         return "MacHebrew";
/*     */       case 10006:
/* 354 */         return "MacGreek";
/*     */       case 10007:
/* 356 */         return "MacCyrillic";
/*     */       case 10008:
/* 358 */         return "EUC_CN";
/*     */       case 10010:
/* 360 */         return "MacRomania";
/*     */       case 10017:
/* 362 */         return "MacUkraine";
/*     */       case 10021:
/* 364 */         return "MacThai";
/*     */       case 10029:
/* 366 */         return "MacCentralEurope";
/*     */       case 10079:
/* 368 */         return "MacIceland";
/*     */       case 10081:
/* 370 */         return "MacTurkish";
/*     */       case 10082:
/* 372 */         return "MacCroatian";
/*     */       case 20127:
/*     */       case 65000:
/* 375 */         return "US-ASCII";
/*     */       case 20866:
/* 377 */         return "KOI8-R";
/*     */       case 28591:
/* 379 */         if (paramBoolean) {
/* 380 */           return "ISO8859_1";
/*     */         }
/* 382 */         return "ISO-8859-1";
/*     */       case 28592:
/* 384 */         if (paramBoolean) {
/* 385 */           return "ISO8859_2";
/*     */         }
/* 387 */         return "ISO-8859-2";
/*     */       case 28593:
/* 389 */         if (paramBoolean) {
/* 390 */           return "ISO8859_3";
/*     */         }
/* 392 */         return "ISO-8859-3";
/*     */       case 28594:
/* 394 */         if (paramBoolean) {
/* 395 */           return "ISO8859_4";
/*     */         }
/* 397 */         return "ISO-8859-4";
/*     */       case 28595:
/* 399 */         if (paramBoolean) {
/* 400 */           return "ISO8859_5";
/*     */         }
/* 402 */         return "ISO-8859-5";
/*     */       case 28596:
/* 404 */         if (paramBoolean) {
/* 405 */           return "ISO8859_6";
/*     */         }
/* 407 */         return "ISO-8859-6";
/*     */       case 28597:
/* 409 */         if (paramBoolean) {
/* 410 */           return "ISO8859_7";
/*     */         }
/* 412 */         return "ISO-8859-7";
/*     */       case 28598:
/* 414 */         if (paramBoolean) {
/* 415 */           return "ISO8859_8";
/*     */         }
/* 417 */         return "ISO-8859-8";
/*     */       case 28599:
/* 419 */         if (paramBoolean) {
/* 420 */           return "ISO8859_9";
/*     */         }
/* 422 */         return "ISO-8859-9";
/*     */       case 50220:
/*     */       case 50221:
/*     */       case 50222:
/* 426 */         return "ISO-2022-JP";
/*     */       case 50225:
/* 428 */         return "ISO-2022-KR";
/*     */       case 51932:
/* 430 */         return "EUC-JP";
/*     */       case 51949:
/* 432 */         return "EUC-KR";
/*     */       case 52936:
/* 434 */         return "GB2312";
/*     */       case 54936:
/* 436 */         return "GB18030";
/*     */       case 932:
/* 438 */         return "SJIS";
/*     */     } 
/* 440 */     return "cp" + paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\CodePageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */