/*     */ package org.apache.http.client.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URI;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Scanner;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.apache.http.message.ParserCursor;
/*     */ import org.apache.http.message.TokenParser;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class URLEncodedUtils
/*     */ {
/*     */   public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
/*     */   private static final char QP_SEP_A = '&';
/*     */   private static final char QP_SEP_S = ';';
/*     */   private static final String NAME_VALUE_SEPARATOR = "=";
/*     */   private static final char PATH_SEPARATOR = '/';
/*  75 */   private static final BitSet PATH_SEPARATORS = new BitSet(256);
/*     */   static {
/*  77 */     PATH_SEPARATORS.set(47);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static List<NameValuePair> parse(URI paramURI, String paramString) {
/*  85 */     return parse(paramURI, (paramString != null) ? Charset.forName(paramString) : null);
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
/*     */   public static List<NameValuePair> parse(URI paramURI, Charset paramCharset) {
/*  99 */     Args.notNull(paramURI, "URI");
/* 100 */     String str = paramURI.getRawQuery();
/* 101 */     if (str != null && !str.isEmpty()) {
/* 102 */       return parse(str, paramCharset);
/*     */     }
/* 104 */     return createEmptyList();
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
/*     */   public static List<NameValuePair> parse(HttpEntity paramHttpEntity) throws IOException {
/*     */     CharArrayBuffer charArrayBuffer;
/* 121 */     Args.notNull(paramHttpEntity, "HTTP entity");
/* 122 */     ContentType contentType = ContentType.get(paramHttpEntity);
/* 123 */     if (contentType == null || !contentType.getMimeType().equalsIgnoreCase("application/x-www-form-urlencoded")) {
/* 124 */       return createEmptyList();
/*     */     }
/* 126 */     long l = paramHttpEntity.getContentLength();
/* 127 */     Args.check((l <= 2147483647L), "HTTP entity is too large");
/* 128 */     Charset charset = (contentType.getCharset() != null) ? contentType.getCharset() : HTTP.DEF_CONTENT_CHARSET;
/* 129 */     InputStream inputStream = paramHttpEntity.getContent();
/* 130 */     if (inputStream == null) {
/* 131 */       return createEmptyList();
/*     */     }
/*     */     
/*     */     try {
/* 135 */       charArrayBuffer = new CharArrayBuffer((l > 0L) ? (int)l : 1024);
/* 136 */       InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
/* 137 */       char[] arrayOfChar = new char[1024];
/*     */       int i;
/* 139 */       while ((i = inputStreamReader.read(arrayOfChar)) != -1) {
/* 140 */         charArrayBuffer.append(arrayOfChar, 0, i);
/*     */       }
/*     */     } finally {
/*     */       
/* 144 */       inputStream.close();
/*     */     } 
/* 146 */     if (charArrayBuffer.isEmpty()) {
/* 147 */       return createEmptyList();
/*     */     }
/* 149 */     return parse(charArrayBuffer, charset, new char[] { '&' });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEncoded(HttpEntity paramHttpEntity) {
/* 157 */     Args.notNull(paramHttpEntity, "HTTP entity");
/* 158 */     Header header = paramHttpEntity.getContentType();
/* 159 */     if (header != null) {
/* 160 */       HeaderElement[] arrayOfHeaderElement = header.getElements();
/* 161 */       if (arrayOfHeaderElement.length > 0) {
/* 162 */         String str = arrayOfHeaderElement[0].getName();
/* 163 */         return str.equalsIgnoreCase("application/x-www-form-urlencoded");
/*     */       } 
/*     */     } 
/* 166 */     return false;
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
/*     */   @Deprecated
/*     */   public static void parse(List<NameValuePair> paramList, Scanner paramScanner, String paramString) {
/* 189 */     parse(paramList, paramScanner, "[&;]", paramString);
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
/*     */   @Deprecated
/*     */   public static void parse(List<NameValuePair> paramList, Scanner paramScanner, String paramString1, String paramString2) {
/* 216 */     paramScanner.useDelimiter(paramString1);
/* 217 */     while (paramScanner.hasNext()) {
/*     */ 
/*     */       
/* 220 */       String str1, str2, str3 = paramScanner.next();
/* 221 */       int i = str3.indexOf("=");
/* 222 */       if (i != -1) {
/* 223 */         str1 = decodeFormFields(str3.substring(0, i).trim(), paramString2);
/* 224 */         str2 = decodeFormFields(str3.substring(i + 1).trim(), paramString2);
/*     */       } else {
/* 226 */         str1 = decodeFormFields(str3.trim(), paramString2);
/* 227 */         str2 = null;
/*     */       } 
/* 229 */       paramList.add(new BasicNameValuePair(str1, str2));
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
/*     */   public static List<NameValuePair> parse(String paramString, Charset paramCharset) {
/* 244 */     if (paramString == null) {
/* 245 */       return createEmptyList();
/*     */     }
/* 247 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 248 */     charArrayBuffer.append(paramString);
/* 249 */     return parse(charArrayBuffer, paramCharset, new char[] { '&', ';' });
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
/*     */   public static List<NameValuePair> parse(String paramString, Charset paramCharset, char... paramVarArgs) {
/* 264 */     if (paramString == null) {
/* 265 */       return createEmptyList();
/*     */     }
/* 267 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 268 */     charArrayBuffer.append(paramString);
/* 269 */     return parse(charArrayBuffer, paramCharset, paramVarArgs);
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
/*     */   public static List<NameValuePair> parse(CharArrayBuffer paramCharArrayBuffer, Charset paramCharset, char... paramVarArgs) {
/* 287 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 288 */     TokenParser tokenParser = TokenParser.INSTANCE;
/* 289 */     BitSet bitSet = new BitSet();
/* 290 */     for (char c : paramVarArgs) {
/* 291 */       bitSet.set(c);
/*     */     }
/* 293 */     ParserCursor parserCursor = new ParserCursor(0, paramCharArrayBuffer.length());
/* 294 */     ArrayList<BasicNameValuePair> arrayList = new ArrayList();
/* 295 */     while (!parserCursor.atEnd()) {
/* 296 */       bitSet.set(61);
/* 297 */       String str1 = tokenParser.parseToken(paramCharArrayBuffer, parserCursor, bitSet);
/* 298 */       String str2 = null;
/* 299 */       if (!parserCursor.atEnd()) {
/* 300 */         char c = paramCharArrayBuffer.charAt(parserCursor.getPos());
/* 301 */         parserCursor.updatePos(parserCursor.getPos() + 1);
/* 302 */         if (c == '=') {
/* 303 */           bitSet.clear(61);
/* 304 */           str2 = tokenParser.parseToken(paramCharArrayBuffer, parserCursor, bitSet);
/* 305 */           if (!parserCursor.atEnd()) {
/* 306 */             parserCursor.updatePos(parserCursor.getPos() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/* 310 */       if (!str1.isEmpty()) {
/* 311 */         arrayList.add(new BasicNameValuePair(decodeFormFields(str1, paramCharset), decodeFormFields(str2, paramCharset)));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 316 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   static List<String> splitSegments(CharSequence paramCharSequence, BitSet paramBitSet) {
/* 320 */     ParserCursor parserCursor = new ParserCursor(0, paramCharSequence.length());
/*     */     
/* 322 */     if (parserCursor.atEnd()) {
/* 323 */       return Collections.emptyList();
/*     */     }
/* 325 */     if (paramBitSet.get(paramCharSequence.charAt(parserCursor.getPos()))) {
/* 326 */       parserCursor.updatePos(parserCursor.getPos() + 1);
/*     */     }
/* 328 */     ArrayList<String> arrayList = new ArrayList();
/* 329 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true) {
/* 331 */       if (parserCursor.atEnd()) {
/* 332 */         arrayList.add(stringBuilder.toString());
/*     */         break;
/*     */       } 
/* 335 */       char c = paramCharSequence.charAt(parserCursor.getPos());
/* 336 */       if (paramBitSet.get(c)) {
/* 337 */         arrayList.add(stringBuilder.toString());
/* 338 */         stringBuilder.setLength(0);
/*     */       } else {
/* 340 */         stringBuilder.append(c);
/*     */       } 
/* 342 */       parserCursor.updatePos(parserCursor.getPos() + 1);
/*     */     } 
/* 344 */     return arrayList;
/*     */   }
/*     */   
/*     */   static List<String> splitPathSegments(CharSequence paramCharSequence) {
/* 348 */     return splitSegments(paramCharSequence, PATH_SEPARATORS);
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
/*     */   public static List<String> parsePathSegments(CharSequence paramCharSequence, Charset paramCharset) {
/* 361 */     Args.notNull(paramCharSequence, "Char sequence");
/* 362 */     List<String> list = splitPathSegments(paramCharSequence);
/* 363 */     for (byte b = 0; b < list.size(); b++) {
/* 364 */       list.set(b, urlDecode(list.get(b), (paramCharset != null) ? paramCharset : Consts.UTF_8, false));
/*     */     }
/* 366 */     return list;
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
/*     */   public static List<String> parsePathSegments(CharSequence paramCharSequence) {
/* 378 */     return parsePathSegments(paramCharSequence, Consts.UTF_8);
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
/*     */   public static String formatSegments(Iterable<String> paramIterable, Charset paramCharset) {
/* 391 */     Args.notNull(paramIterable, "Segments");
/* 392 */     StringBuilder stringBuilder = new StringBuilder();
/* 393 */     for (String str : paramIterable) {
/* 394 */       stringBuilder.append('/').append(urlEncode(str, paramCharset, PATHSAFE, false));
/*     */     }
/* 396 */     return stringBuilder.toString();
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
/*     */   public static String formatSegments(String... paramVarArgs) {
/* 408 */     return formatSegments(Arrays.asList(paramVarArgs), Consts.UTF_8);
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
/*     */   public static String format(List<? extends NameValuePair> paramList, String paramString) {
/* 422 */     return format(paramList, '&', paramString);
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
/*     */   public static String format(List<? extends NameValuePair> paramList, char paramChar, String paramString) {
/* 440 */     StringBuilder stringBuilder = new StringBuilder();
/* 441 */     for (NameValuePair nameValuePair : paramList) {
/* 442 */       String str1 = encodeFormFields(nameValuePair.getName(), paramString);
/* 443 */       String str2 = encodeFormFields(nameValuePair.getValue(), paramString);
/* 444 */       if (stringBuilder.length() > 0) {
/* 445 */         stringBuilder.append(paramChar);
/*     */       }
/* 447 */       stringBuilder.append(str1);
/* 448 */       if (str2 != null) {
/* 449 */         stringBuilder.append("=");
/* 450 */         stringBuilder.append(str2);
/*     */       } 
/*     */     } 
/* 453 */     return stringBuilder.toString();
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
/*     */   public static String format(Iterable<? extends NameValuePair> paramIterable, Charset paramCharset) {
/* 469 */     return format(paramIterable, '&', paramCharset);
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
/*     */   public static String format(Iterable<? extends NameValuePair> paramIterable, char paramChar, Charset paramCharset) {
/* 487 */     Args.notNull(paramIterable, "Parameters");
/* 488 */     StringBuilder stringBuilder = new StringBuilder();
/* 489 */     for (NameValuePair nameValuePair : paramIterable) {
/* 490 */       String str1 = encodeFormFields(nameValuePair.getName(), paramCharset);
/* 491 */       String str2 = encodeFormFields(nameValuePair.getValue(), paramCharset);
/* 492 */       if (stringBuilder.length() > 0) {
/* 493 */         stringBuilder.append(paramChar);
/*     */       }
/* 495 */       stringBuilder.append(str1);
/* 496 */       if (str2 != null) {
/* 497 */         stringBuilder.append("=");
/* 498 */         stringBuilder.append(str2);
/*     */       } 
/*     */     } 
/* 501 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 510 */   private static final BitSet UNRESERVED = new BitSet(256);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 516 */   private static final BitSet PUNCT = new BitSet(256);
/*     */ 
/*     */   
/* 519 */   private static final BitSet USERINFO = new BitSet(256);
/*     */ 
/*     */   
/* 522 */   private static final BitSet PATHSAFE = new BitSet(256);
/*     */ 
/*     */   
/* 525 */   private static final BitSet URIC = new BitSet(256);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 535 */   private static final BitSet RESERVED = new BitSet(256);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 542 */   private static final BitSet URLENCODER = new BitSet(256);
/*     */   
/* 544 */   private static final BitSet PATH_SPECIAL = new BitSet(256);
/*     */   private static final int RADIX = 16;
/*     */   
/*     */   static {
/*     */     byte b;
/* 549 */     for (b = 97; b <= 122; b++) {
/* 550 */       UNRESERVED.set(b);
/*     */     }
/* 552 */     for (b = 65; b <= 90; b++) {
/* 553 */       UNRESERVED.set(b);
/*     */     }
/*     */     
/* 556 */     for (b = 48; b <= 57; b++) {
/* 557 */       UNRESERVED.set(b);
/*     */     }
/* 559 */     UNRESERVED.set(95);
/* 560 */     UNRESERVED.set(45);
/* 561 */     UNRESERVED.set(46);
/* 562 */     UNRESERVED.set(42);
/* 563 */     URLENCODER.or(UNRESERVED);
/* 564 */     UNRESERVED.set(33);
/* 565 */     UNRESERVED.set(126);
/* 566 */     UNRESERVED.set(39);
/* 567 */     UNRESERVED.set(40);
/* 568 */     UNRESERVED.set(41);
/*     */     
/* 570 */     PUNCT.set(44);
/* 571 */     PUNCT.set(59);
/* 572 */     PUNCT.set(58);
/* 573 */     PUNCT.set(36);
/* 574 */     PUNCT.set(38);
/* 575 */     PUNCT.set(43);
/* 576 */     PUNCT.set(61);
/*     */     
/* 578 */     USERINFO.or(UNRESERVED);
/* 579 */     USERINFO.or(PUNCT);
/*     */ 
/*     */     
/* 582 */     PATHSAFE.or(UNRESERVED);
/* 583 */     PATHSAFE.set(59);
/* 584 */     PATHSAFE.set(58);
/* 585 */     PATHSAFE.set(64);
/* 586 */     PATHSAFE.set(38);
/* 587 */     PATHSAFE.set(61);
/* 588 */     PATHSAFE.set(43);
/* 589 */     PATHSAFE.set(36);
/* 590 */     PATHSAFE.set(44);
/*     */     
/* 592 */     PATH_SPECIAL.or(PATHSAFE);
/* 593 */     PATH_SPECIAL.set(47);
/*     */     
/* 595 */     RESERVED.set(59);
/* 596 */     RESERVED.set(47);
/* 597 */     RESERVED.set(63);
/* 598 */     RESERVED.set(58);
/* 599 */     RESERVED.set(64);
/* 600 */     RESERVED.set(38);
/* 601 */     RESERVED.set(61);
/* 602 */     RESERVED.set(43);
/* 603 */     RESERVED.set(36);
/* 604 */     RESERVED.set(44);
/* 605 */     RESERVED.set(91);
/* 606 */     RESERVED.set(93);
/*     */     
/* 608 */     URIC.or(RESERVED);
/* 609 */     URIC.or(UNRESERVED);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<NameValuePair> createEmptyList() {
/* 615 */     return new ArrayList<NameValuePair>(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String urlEncode(String paramString, Charset paramCharset, BitSet paramBitSet, boolean paramBoolean) {
/* 623 */     if (paramString == null) {
/* 624 */       return null;
/*     */     }
/* 626 */     StringBuilder stringBuilder = new StringBuilder();
/* 627 */     ByteBuffer byteBuffer = paramCharset.encode(paramString);
/* 628 */     while (byteBuffer.hasRemaining()) {
/* 629 */       int i = byteBuffer.get() & 0xFF;
/* 630 */       if (paramBitSet.get(i)) {
/* 631 */         stringBuilder.append((char)i); continue;
/* 632 */       }  if (paramBoolean && i == 32) {
/* 633 */         stringBuilder.append('+'); continue;
/*     */       } 
/* 635 */       stringBuilder.append("%");
/* 636 */       char c1 = Character.toUpperCase(Character.forDigit(i >> 4 & 0xF, 16));
/* 637 */       char c2 = Character.toUpperCase(Character.forDigit(i & 0xF, 16));
/* 638 */       stringBuilder.append(c1);
/* 639 */       stringBuilder.append(c2);
/*     */     } 
/*     */     
/* 642 */     return stringBuilder.toString();
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
/*     */   private static String urlDecode(String paramString, Charset paramCharset, boolean paramBoolean) {
/* 657 */     if (paramString == null) {
/* 658 */       return null;
/*     */     }
/* 660 */     ByteBuffer byteBuffer = ByteBuffer.allocate(paramString.length());
/* 661 */     CharBuffer charBuffer = CharBuffer.wrap(paramString);
/* 662 */     while (charBuffer.hasRemaining()) {
/* 663 */       char c = charBuffer.get();
/* 664 */       if (c == '%' && charBuffer.remaining() >= 2) {
/* 665 */         char c1 = charBuffer.get();
/* 666 */         char c2 = charBuffer.get();
/* 667 */         int i = Character.digit(c1, 16);
/* 668 */         int j = Character.digit(c2, 16);
/* 669 */         if (i != -1 && j != -1) {
/* 670 */           byteBuffer.put((byte)((i << 4) + j)); continue;
/*     */         } 
/* 672 */         byteBuffer.put((byte)37);
/* 673 */         byteBuffer.put((byte)c1);
/* 674 */         byteBuffer.put((byte)c2); continue;
/*     */       } 
/* 676 */       if (paramBoolean && c == '+') {
/* 677 */         byteBuffer.put((byte)32); continue;
/*     */       } 
/* 679 */       byteBuffer.put((byte)c);
/*     */     } 
/*     */     
/* 682 */     byteBuffer.flip();
/* 683 */     return paramCharset.decode(byteBuffer).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String decodeFormFields(String paramString1, String paramString2) {
/* 694 */     if (paramString1 == null) {
/* 695 */       return null;
/*     */     }
/* 697 */     return urlDecode(paramString1, (paramString2 != null) ? Charset.forName(paramString2) : Consts.UTF_8, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String decodeFormFields(String paramString, Charset paramCharset) {
/* 708 */     if (paramString == null) {
/* 709 */       return null;
/*     */     }
/* 711 */     return urlDecode(paramString, (paramCharset != null) ? paramCharset : Consts.UTF_8, true);
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
/*     */   private static String encodeFormFields(String paramString1, String paramString2) {
/* 726 */     if (paramString1 == null) {
/* 727 */       return null;
/*     */     }
/* 729 */     return urlEncode(paramString1, (paramString2 != null) ? Charset.forName(paramString2) : Consts.UTF_8, URLENCODER, true);
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
/*     */   private static String encodeFormFields(String paramString, Charset paramCharset) {
/* 744 */     if (paramString == null) {
/* 745 */       return null;
/*     */     }
/* 747 */     return urlEncode(paramString, (paramCharset != null) ? paramCharset : Consts.UTF_8, URLENCODER, true);
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
/*     */   static String encUserInfo(String paramString, Charset paramCharset) {
/* 760 */     return urlEncode(paramString, paramCharset, USERINFO, false);
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
/*     */   static String encUric(String paramString, Charset paramCharset) {
/* 773 */     return urlEncode(paramString, paramCharset, URIC, false);
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
/*     */   static String encPath(String paramString, Charset paramCharset) {
/* 786 */     return urlEncode(paramString, paramCharset, PATH_SPECIAL, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\URLEncodedUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */