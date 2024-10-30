/*     */ package org.apache.xmlbeans.impl.util;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.net.URI;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import javax.xml.namespace.a;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.GDate;
/*     */ import org.apache.xmlbeans.GDateBuilder;
/*     */ import org.apache.xmlbeans.GDateSpecification;
/*     */ import org.apache.xmlbeans.XmlCalendar;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XsTypeConverter
/*     */ {
/*     */   private static final String POS_INF_LEX = "INF";
/*     */   private static final String NEG_INF_LEX = "-INF";
/*     */   private static final String NAN_LEX = "NaN";
/*     */   private static final char NAMESPACE_SEP = ':';
/*     */   private static final String EMPTY_PREFIX = "";
/*  43 */   private static final BigDecimal DECIMAL__ZERO = new BigDecimal(0.0D);
/*     */ 
/*     */   
/*  46 */   private static final String[] URI_CHARS_TO_BE_REPLACED = new String[] { " ", "{", "}", "|", "\\", "^", "[", "]", "`" };
/*  47 */   private static final String[] URI_CHARS_REPLACED_WITH = new String[] { "%20", "%7b", "%7d", "%7c", "%5c", "%5e", "%5b", "%5d", "%60" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float lexFloat(CharSequence paramCharSequence) throws NumberFormatException {
/*  53 */     String str = paramCharSequence.toString();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  58 */       if (paramCharSequence.length() > 0) {
/*  59 */         char c = paramCharSequence.charAt(paramCharSequence.length() - 1);
/*  60 */         if ((c == 'f' || c == 'F') && 
/*  61 */           paramCharSequence.charAt(paramCharSequence.length() - 2) != 'N') {
/*  62 */           throw new NumberFormatException("Invalid char '" + c + "' in float.");
/*     */         }
/*     */       } 
/*  65 */       return Float.parseFloat(str);
/*     */     }
/*  67 */     catch (NumberFormatException numberFormatException) {
/*  68 */       if (str.equals("INF")) return Float.POSITIVE_INFINITY; 
/*  69 */       if (str.equals("-INF")) return Float.NEGATIVE_INFINITY; 
/*  70 */       if (str.equals("NaN")) return Float.NaN;
/*     */       
/*  72 */       throw numberFormatException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static float lexFloat(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/*  79 */       return lexFloat(paramCharSequence);
/*     */     }
/*  81 */     catch (NumberFormatException numberFormatException) {
/*  82 */       String str = "invalid float: " + paramCharSequence;
/*  83 */       paramCollection.add(XmlError.forMessage(str));
/*     */       
/*  85 */       return Float.NaN;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printFloat(float paramFloat) {
/*  91 */     if (paramFloat == Float.POSITIVE_INFINITY)
/*  92 */       return "INF"; 
/*  93 */     if (paramFloat == Float.NEGATIVE_INFINITY)
/*  94 */       return "-INF"; 
/*  95 */     if (Float.isNaN(paramFloat)) {
/*  96 */       return "NaN";
/*     */     }
/*  98 */     return Float.toString(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double lexDouble(CharSequence paramCharSequence) throws NumberFormatException {
/* 106 */     String str = paramCharSequence.toString();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 112 */       if (paramCharSequence.length() > 0) {
/* 113 */         char c = paramCharSequence.charAt(paramCharSequence.length() - 1);
/* 114 */         if (c == 'd' || c == 'D')
/* 115 */           throw new NumberFormatException("Invalid char '" + c + "' in double."); 
/*     */       } 
/* 117 */       return Double.parseDouble(str);
/*     */     }
/* 119 */     catch (NumberFormatException numberFormatException) {
/* 120 */       if (str.equals("INF")) return Double.POSITIVE_INFINITY; 
/* 121 */       if (str.equals("-INF")) return Double.NEGATIVE_INFINITY; 
/* 122 */       if (str.equals("NaN")) return Double.NaN;
/*     */       
/* 124 */       throw numberFormatException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static double lexDouble(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 131 */       return lexDouble(paramCharSequence);
/*     */     }
/* 133 */     catch (NumberFormatException numberFormatException) {
/* 134 */       String str = "invalid double: " + paramCharSequence;
/* 135 */       paramCollection.add(XmlError.forMessage(str));
/*     */       
/* 137 */       return Double.NaN;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printDouble(double paramDouble) {
/* 143 */     if (paramDouble == Double.POSITIVE_INFINITY)
/* 144 */       return "INF"; 
/* 145 */     if (paramDouble == Double.NEGATIVE_INFINITY)
/* 146 */       return "-INF"; 
/* 147 */     if (Double.isNaN(paramDouble)) {
/* 148 */       return "NaN";
/*     */     }
/* 150 */     return Double.toString(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigDecimal lexDecimal(CharSequence paramCharSequence) throws NumberFormatException {
/* 158 */     String str = paramCharSequence.toString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     return new BigDecimal(trimTrailingZeros(str));
/*     */   }
/*     */ 
/*     */   
/*     */   public static BigDecimal lexDecimal(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 172 */       return lexDecimal(paramCharSequence);
/*     */     }
/* 174 */     catch (NumberFormatException numberFormatException) {
/* 175 */       String str = "invalid long: " + paramCharSequence;
/* 176 */       paramCollection.add(XmlError.forMessage(str));
/* 177 */       return DECIMAL__ZERO;
/*     */     } 
/*     */   }
/*     */   
/* 181 */   private static final char[] CH_ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0' };
/*     */ 
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */ 
/*     */ 
/*     */   
/*     */   public static String printDecimal(BigDecimal paramBigDecimal) {
/* 189 */     String str = paramBigDecimal.unscaledValue().toString();
/* 190 */     int i = paramBigDecimal.scale();
/* 191 */     if (i == 0 || (paramBigDecimal.longValue() == 0L && i < 0)) {
/* 192 */       return str;
/*     */     }
/* 194 */     byte b = (paramBigDecimal.signum() < 0) ? 1 : 0;
/* 195 */     int j = i;
/*     */     
/* 197 */     StringBuffer stringBuffer = new StringBuffer(str.length() + 1 + Math.abs(i));
/*     */     
/* 199 */     if (b == 1)
/*     */     {
/*     */       
/* 202 */       stringBuffer.append('-');
/*     */     }
/* 204 */     if (i > 0) {
/*     */       
/* 206 */       j -= str.length() - b;
/* 207 */       if (j >= 0)
/*     */       {
/* 209 */         stringBuffer.append("0.");
/*     */         
/* 211 */         for (; j > CH_ZEROS.length; j -= CH_ZEROS.length)
/* 212 */           stringBuffer.append(CH_ZEROS); 
/* 213 */         stringBuffer.append(CH_ZEROS, 0, j);
/* 214 */         stringBuffer.append(str.substring(b));
/*     */       }
/*     */       else
/*     */       {
/* 218 */         j = b - j;
/* 219 */         stringBuffer.append(str.substring(b, j));
/* 220 */         stringBuffer.append('.');
/* 221 */         stringBuffer.append(str.substring(j));
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 226 */       stringBuffer.append(str.substring(b));
/*     */       
/* 228 */       for (; j < -CH_ZEROS.length; j += CH_ZEROS.length)
/* 229 */         stringBuffer.append(CH_ZEROS); 
/* 230 */       stringBuffer.append(CH_ZEROS, 0, -j);
/*     */     } 
/* 232 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigInteger lexInteger(CharSequence paramCharSequence) throws NumberFormatException {
/* 239 */     if (paramCharSequence.length() > 1 && 
/* 240 */       paramCharSequence.charAt(0) == '+' && paramCharSequence.charAt(1) == '-') {
/* 241 */       throw new NumberFormatException("Illegal char sequence '+-'");
/*     */     }
/* 243 */     String str = paramCharSequence.toString();
/*     */ 
/*     */ 
/*     */     
/* 247 */     return new BigInteger(trimInitialPlus(str));
/*     */   }
/*     */ 
/*     */   
/*     */   public static BigInteger lexInteger(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 253 */       return lexInteger(paramCharSequence);
/*     */     }
/* 255 */     catch (NumberFormatException numberFormatException) {
/* 256 */       String str = "invalid long: " + paramCharSequence;
/* 257 */       paramCollection.add(XmlError.forMessage(str));
/* 258 */       return BigInteger.ZERO;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printInteger(BigInteger paramBigInteger) {
/* 264 */     return paramBigInteger.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long lexLong(CharSequence paramCharSequence) throws NumberFormatException {
/* 271 */     String str = paramCharSequence.toString();
/* 272 */     return Long.parseLong(trimInitialPlus(str));
/*     */   }
/*     */ 
/*     */   
/*     */   public static long lexLong(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 278 */       return lexLong(paramCharSequence);
/*     */     }
/* 280 */     catch (NumberFormatException numberFormatException) {
/* 281 */       String str = "invalid long: " + paramCharSequence;
/* 282 */       paramCollection.add(XmlError.forMessage(str));
/* 283 */       return 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printLong(long paramLong) {
/* 289 */     return Long.toString(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short lexShort(CharSequence paramCharSequence) throws NumberFormatException {
/* 297 */     return parseShort(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public static short lexShort(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 303 */       return lexShort(paramCharSequence);
/*     */     }
/* 305 */     catch (NumberFormatException numberFormatException) {
/* 306 */       String str = "invalid short: " + paramCharSequence;
/* 307 */       paramCollection.add(XmlError.forMessage(str));
/* 308 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printShort(short paramShort) {
/* 314 */     return Short.toString(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int lexInt(CharSequence paramCharSequence) throws NumberFormatException {
/* 322 */     return parseInt(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int lexInt(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 328 */       return lexInt(paramCharSequence);
/*     */     }
/* 330 */     catch (NumberFormatException numberFormatException) {
/* 331 */       String str = "invalid int:" + paramCharSequence;
/* 332 */       paramCollection.add(XmlError.forMessage(str));
/* 333 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printInt(int paramInt) {
/* 339 */     return Integer.toString(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte lexByte(CharSequence paramCharSequence) throws NumberFormatException {
/* 347 */     return parseByte(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte lexByte(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 353 */       return lexByte(paramCharSequence);
/*     */     }
/* 355 */     catch (NumberFormatException numberFormatException) {
/* 356 */       String str = "invalid byte: " + paramCharSequence;
/* 357 */       paramCollection.add(XmlError.forMessage(str));
/* 358 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printByte(byte paramByte) {
/* 364 */     return Byte.toString(paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean lexBoolean(CharSequence paramCharSequence) {
/*     */     char c;
/* 371 */     switch (paramCharSequence.length()) {
/*     */       case 1:
/* 373 */         c = paramCharSequence.charAt(0);
/* 374 */         if ('0' == c) return false; 
/* 375 */         if ('1' == c) return true; 
/*     */         break;
/*     */       case 4:
/* 378 */         if ('t' == paramCharSequence.charAt(0) && 'r' == paramCharSequence.charAt(1) && 'u' == paramCharSequence.charAt(2) && 'e' == paramCharSequence.charAt(3))
/*     */         {
/*     */ 
/*     */           
/* 382 */           return true;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 386 */         if ('f' == paramCharSequence.charAt(0) && 'a' == paramCharSequence.charAt(1) && 'l' == paramCharSequence.charAt(2) && 's' == paramCharSequence.charAt(3) && 'e' == paramCharSequence.charAt(4))
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 391 */           return false;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 397 */     String str = "invalid boolean: " + paramCharSequence;
/* 398 */     throw new InvalidLexicalValueException(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean lexBoolean(CharSequence paramCharSequence, Collection paramCollection) {
/*     */     try {
/* 404 */       return lexBoolean(paramCharSequence);
/*     */     }
/* 406 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/* 407 */       paramCollection.add(XmlError.forMessage(invalidLexicalValueException.getMessage()));
/* 408 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printBoolean(boolean paramBoolean) {
/* 414 */     return paramBoolean ? "true" : "false";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String lexString(CharSequence paramCharSequence, Collection paramCollection) {
/* 421 */     return paramCharSequence.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String lexString(CharSequence paramCharSequence) {
/* 429 */     return paramCharSequence.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printString(String paramString) {
/* 434 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b lexQName(CharSequence paramCharSequence, a parama) {
/*     */     String str1, str2;
/* 444 */     boolean bool = false; byte b;
/* 445 */     for (b = 0; b < paramCharSequence.length(); b++) {
/* 446 */       if (paramCharSequence.charAt(b) == ':') {
/* 447 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 451 */     if (bool) {
/* 452 */       str1 = paramCharSequence.subSequence(0, b).toString();
/* 453 */       str2 = paramCharSequence.subSequence(b + 1, paramCharSequence.length()).toString();
/* 454 */       if (b == 0) {
/* 455 */         throw new InvalidLexicalValueException("invalid xsd:QName '" + paramCharSequence.toString() + "'");
/*     */       }
/*     */     } else {
/* 458 */       str1 = "";
/* 459 */       str2 = paramCharSequence.toString();
/*     */     } 
/*     */     
/* 462 */     String str3 = parama.getNamespaceURI(str1);
/*     */     
/* 464 */     if (str3 == null) {
/* 465 */       if (str1 != null && str1.length() > 0) {
/* 466 */         throw new InvalidLexicalValueException("Can't resolve prefix: " + str1);
/*     */       }
/* 468 */       str3 = "";
/*     */     } 
/*     */     
/* 471 */     return new b(str3, str2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static b lexQName(String paramString, Collection paramCollection, a parama) {
/*     */     try {
/* 478 */       return lexQName(paramString, parama);
/*     */     }
/* 480 */     catch (InvalidLexicalValueException invalidLexicalValueException) {
/* 481 */       paramCollection.add(XmlError.forMessage(invalidLexicalValueException.getMessage()));
/* 482 */       int i = paramString.indexOf(':');
/* 483 */       return new b(null, paramString.substring(i));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String printQName(b paramb, a parama, Collection paramCollection) {
/* 490 */     String str2, str1 = paramb.getNamespaceURI();
/* 491 */     assert str1 != null;
/*     */     
/* 493 */     if (str1.length() > 0) {
/* 494 */       str2 = parama.getPrefix(str1);
/* 495 */       if (str2 == null) {
/* 496 */         String str = "NamespaceContext does not provide prefix for namespaceURI " + str1;
/*     */         
/* 498 */         paramCollection.add(XmlError.forMessage(str));
/*     */       } 
/*     */     } else {
/* 501 */       str2 = null;
/*     */     } 
/* 503 */     return getQNameString(str1, paramb.dT(), str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getQNameString(String paramString1, String paramString2, String paramString3) {
/* 511 */     if (paramString3 != null && paramString1 != null && paramString1.length() > 0 && paramString3.length() > 0)
/*     */     {
/*     */ 
/*     */       
/* 515 */       return paramString3 + ':' + paramString2;
/*     */     }
/* 517 */     return paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GDate lexGDate(CharSequence paramCharSequence) {
/* 524 */     return new GDate(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GDate lexGDate(String paramString, Collection paramCollection) {
/*     */     try {
/* 530 */       return lexGDate(paramString);
/*     */     }
/* 532 */     catch (IllegalArgumentException illegalArgumentException) {
/* 533 */       paramCollection.add(XmlError.forMessage(illegalArgumentException.getMessage()));
/* 534 */       return (new GDateBuilder()).toGDate();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printGDate(GDate paramGDate, Collection paramCollection) {
/* 540 */     return paramGDate.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlCalendar lexDateTime(CharSequence paramCharSequence) {
/* 547 */     GDateSpecification gDateSpecification = getGDateValue(paramCharSequence, 14);
/* 548 */     return gDateSpecification.getCalendar();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String printDateTime(Calendar paramCalendar) {
/* 554 */     return printDateTime(paramCalendar, 14);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printTime(Calendar paramCalendar) {
/* 559 */     return printDateTime(paramCalendar, 15);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printDate(Calendar paramCalendar) {
/* 564 */     return printDateTime(paramCalendar, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printDate(Date paramDate) {
/* 569 */     GDateSpecification gDateSpecification = getGDateValue(paramDate, 16);
/* 570 */     return gDateSpecification.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printDateTime(Calendar paramCalendar, int paramInt) {
/* 575 */     GDateSpecification gDateSpecification = getGDateValue(paramCalendar, paramInt);
/* 576 */     return gDateSpecification.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String printDateTime(Date paramDate) {
/* 581 */     GDateSpecification gDateSpecification = getGDateValue(paramDate, 14);
/* 582 */     return gDateSpecification.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence printHexBinary(byte[] paramArrayOfbyte) {
/* 589 */     return HexBin.bytesToString(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] lexHexBinary(CharSequence paramCharSequence) {
/* 594 */     byte[] arrayOfByte = HexBin.decode(paramCharSequence.toString().getBytes());
/* 595 */     if (arrayOfByte != null) {
/* 596 */       return arrayOfByte;
/*     */     }
/* 598 */     throw new InvalidLexicalValueException("invalid hexBinary value");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence printBase64Binary(byte[] paramArrayOfbyte) {
/* 605 */     byte[] arrayOfByte = Base64.encode(paramArrayOfbyte);
/* 606 */     return new String(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] lexBase64Binary(CharSequence paramCharSequence) {
/* 611 */     byte[] arrayOfByte = Base64.decode(paramCharSequence.toString().getBytes());
/* 612 */     if (arrayOfByte != null) {
/* 613 */       return arrayOfByte;
/*     */     }
/* 615 */     throw new InvalidLexicalValueException("invalid base64Binary value");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GDateSpecification getGDateValue(Date paramDate, int paramInt) {
/* 623 */     GDateBuilder gDateBuilder = new GDateBuilder(paramDate);
/* 624 */     gDateBuilder.setBuiltinTypeCode(paramInt);
/* 625 */     return (GDateSpecification)gDateBuilder.toGDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GDateSpecification getGDateValue(Calendar paramCalendar, int paramInt) {
/* 633 */     GDateBuilder gDateBuilder = new GDateBuilder(paramCalendar);
/* 634 */     gDateBuilder.setBuiltinTypeCode(paramInt);
/* 635 */     return (GDateSpecification)gDateBuilder.toGDate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GDateSpecification getGDateValue(CharSequence paramCharSequence, int paramInt) {
/* 642 */     GDateBuilder gDateBuilder = new GDateBuilder(paramCharSequence);
/* 643 */     gDateBuilder.setBuiltinTypeCode(paramInt);
/* 644 */     return (GDateSpecification)gDateBuilder.toGDate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String trimInitialPlus(String paramString) {
/* 650 */     if (paramString.length() > 0 && paramString.charAt(0) == '+') {
/* 651 */       return paramString.substring(1);
/*     */     }
/* 653 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String trimTrailingZeros(String paramString) {
/* 659 */     int i = paramString.length() - 1;
/* 660 */     if (paramString.charAt(i) == '0') {
/*     */       
/* 662 */       int j = paramString.lastIndexOf('.');
/* 663 */       if (j >= 0) {
/*     */         
/* 665 */         for (int k = i; k > j; k--) {
/* 666 */           if (paramString.charAt(k) != '0') {
/* 667 */             return paramString.substring(0, k + 1);
/*     */           }
/*     */         } 
/*     */         
/* 671 */         return paramString.substring(0, j);
/*     */       } 
/*     */     } 
/* 674 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int parseInt(CharSequence paramCharSequence) {
/* 679 */     return parseIntXsdNumber(paramCharSequence, -2147483648, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   private static short parseShort(CharSequence paramCharSequence) {
/* 684 */     return (short)parseIntXsdNumber(paramCharSequence, -32768, 32767);
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte parseByte(CharSequence paramCharSequence) {
/* 689 */     return (byte)parseIntXsdNumber(paramCharSequence, -128, 127);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int parseIntXsdNumber(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 695 */     int k, m, i = paramCharSequence.length();
/* 696 */     if (i < 1) {
/* 697 */       throw new NumberFormatException("For input string: \"" + paramCharSequence.toString() + "\"");
/*     */     }
/* 699 */     byte b = 1;
/* 700 */     int j = 0;
/* 701 */     byte b1 = 0;
/*     */ 
/*     */ 
/*     */     
/* 705 */     char c = paramCharSequence.charAt(0);
/* 706 */     if (c == '-') {
/* 707 */       b1++;
/* 708 */       k = paramInt1 / 10;
/* 709 */       m = -(paramInt1 % 10);
/* 710 */     } else if (c == '+') {
/* 711 */       b1++;
/* 712 */       b = -1;
/* 713 */       k = -(paramInt2 / 10);
/* 714 */       m = paramInt2 % 10;
/*     */     } else {
/* 716 */       b = -1;
/* 717 */       k = -(paramInt2 / 10);
/* 718 */       m = paramInt2 % 10;
/*     */     } 
/*     */     
/* 721 */     for (byte b2 = 0; b2 < i - b1; b2++) {
/* 722 */       c = paramCharSequence.charAt(b2 + b1);
/* 723 */       int n = Character.digit(c, 10);
/*     */       
/* 725 */       if (n < 0) {
/* 726 */         throw new NumberFormatException("For input string: \"" + paramCharSequence.toString() + "\"");
/*     */       }
/* 728 */       if (j < k || (j == k && n > m)) {
/* 729 */         throw new NumberFormatException("For input string: \"" + paramCharSequence.toString() + "\"");
/*     */       }
/* 731 */       j = j * 10 - n;
/*     */     } 
/*     */     
/* 734 */     return b * j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence printAnyURI(CharSequence paramCharSequence) {
/* 740 */     return paramCharSequence;
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
/*     */   public static CharSequence lexAnyURI(CharSequence paramCharSequence) {
/* 768 */     StringBuffer stringBuffer = new StringBuffer(paramCharSequence.toString());
/* 769 */     for (byte b = 0; b < URI_CHARS_TO_BE_REPLACED.length; b++) {
/*     */       
/* 771 */       int i = 0;
/* 772 */       while ((i = stringBuffer.indexOf(URI_CHARS_TO_BE_REPLACED[b], i)) >= 0) {
/*     */         
/* 774 */         stringBuffer.replace(i, i + 1, URI_CHARS_REPLACED_WITH[b]);
/* 775 */         i += 3;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 781 */       URI.create(stringBuffer.toString());
/*     */     }
/* 783 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 785 */       throw new InvalidLexicalValueException("invalid anyURI value: " + paramCharSequence, illegalArgumentException);
/*     */     } 
/*     */     
/* 788 */     return paramCharSequence;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\imp\\util\XsTypeConverter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */