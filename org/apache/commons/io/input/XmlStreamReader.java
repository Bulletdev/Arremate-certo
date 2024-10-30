/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.Objects;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.io.ByteOrderMark;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlStreamReader
/*     */   extends Reader
/*     */ {
/*     */   private static final int BUFFER_SIZE = 8192;
/*     */   private static final String UTF_8 = "UTF-8";
/*     */   private static final String US_ASCII = "US-ASCII";
/*     */   private static final String UTF_16BE = "UTF-16BE";
/*     */   private static final String UTF_16LE = "UTF-16LE";
/*     */   private static final String UTF_32BE = "UTF-32BE";
/*     */   private static final String UTF_32LE = "UTF-32LE";
/*     */   private static final String UTF_16 = "UTF-16";
/*     */   private static final String UTF_32 = "UTF-32";
/*     */   private static final String EBCDIC = "CP1047";
/*  93 */   private static final ByteOrderMark[] BOMS = new ByteOrderMark[] { ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   private static final ByteOrderMark[] XML_GUESS_BYTES = new ByteOrderMark[] { new ByteOrderMark("UTF-8", new int[] { 60, 63, 120, 109 }), new ByteOrderMark("UTF-16BE", new int[] { 0, 60, 0, 63 }), new ByteOrderMark("UTF-16LE", new int[] { 60, 0, 63, 0 }), new ByteOrderMark("UTF-32BE", new int[] { 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109 }), new ByteOrderMark("UTF-32LE", new int[] { 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0 }), new ByteOrderMark("CP1047", new int[] { 76, 111, 167, 148 }) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Reader reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String encoding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String defaultEncoding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultEncoding() {
/* 128 */     return this.defaultEncoding;
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
/*     */   public XmlStreamReader(File paramFile) throws IOException {
/* 144 */     this(new FileInputStream(Objects.<File>requireNonNull(paramFile)));
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
/*     */   public XmlStreamReader(InputStream paramInputStream) throws IOException {
/* 159 */     this(paramInputStream, true);
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
/*     */ 
/*     */   
/*     */   public XmlStreamReader(InputStream paramInputStream, boolean paramBoolean) throws IOException {
/* 190 */     this(paramInputStream, paramBoolean, (String)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamReader(InputStream paramInputStream, boolean paramBoolean, String paramString) throws IOException {
/* 223 */     Objects.requireNonNull(paramInputStream, "inputStream");
/* 224 */     this.defaultEncoding = paramString;
/* 225 */     BOMInputStream bOMInputStream1 = new BOMInputStream(new BufferedInputStream(paramInputStream, 8192), false, BOMS);
/* 226 */     BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream1, true, XML_GUESS_BYTES);
/* 227 */     this.encoding = doRawStream(bOMInputStream1, bOMInputStream2, paramBoolean);
/* 228 */     this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
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
/*     */   public XmlStreamReader(URL paramURL) throws IOException {
/* 249 */     this(((URL)Objects.<URL>requireNonNull(paramURL, "url")).openConnection(), (String)null);
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
/*     */   public XmlStreamReader(URLConnection paramURLConnection, String paramString) throws IOException {
/* 272 */     Objects.requireNonNull(paramURLConnection, "conm");
/* 273 */     this.defaultEncoding = paramString;
/* 274 */     boolean bool = true;
/* 275 */     String str = paramURLConnection.getContentType();
/* 276 */     InputStream inputStream = paramURLConnection.getInputStream();
/* 277 */     BOMInputStream bOMInputStream1 = new BOMInputStream(new BufferedInputStream(inputStream, 8192), false, BOMS);
/* 278 */     BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream1, true, XML_GUESS_BYTES);
/* 279 */     if (paramURLConnection instanceof java.net.HttpURLConnection || str != null) {
/* 280 */       this.encoding = processHttpStream(bOMInputStream1, bOMInputStream2, str, true);
/*     */     } else {
/* 282 */       this.encoding = doRawStream(bOMInputStream1, bOMInputStream2, true);
/*     */     } 
/* 284 */     this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
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
/*     */   public XmlStreamReader(InputStream paramInputStream, String paramString) throws IOException {
/* 306 */     this(paramInputStream, paramString, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamReader(InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2) throws IOException {
/* 345 */     Objects.requireNonNull(paramInputStream, "inputStream");
/* 346 */     this.defaultEncoding = paramString2;
/* 347 */     BOMInputStream bOMInputStream1 = new BOMInputStream(new BufferedInputStream(paramInputStream, 8192), false, BOMS);
/* 348 */     BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream1, true, XML_GUESS_BYTES);
/* 349 */     this.encoding = processHttpStream(bOMInputStream1, bOMInputStream2, paramString1, paramBoolean);
/* 350 */     this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamReader(InputStream paramInputStream, String paramString, boolean paramBoolean) throws IOException {
/* 388 */     this(paramInputStream, paramString, paramBoolean, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/* 397 */     return this.encoding;
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 410 */     return this.reader.read(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 420 */     this.reader.close();
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
/*     */   private String doRawStream(BOMInputStream paramBOMInputStream1, BOMInputStream paramBOMInputStream2, boolean paramBoolean) throws IOException {
/* 435 */     String str1 = paramBOMInputStream1.getBOMCharsetName();
/* 436 */     String str2 = paramBOMInputStream2.getBOMCharsetName();
/* 437 */     String str3 = getXmlProlog(paramBOMInputStream2, str2);
/*     */     try {
/* 439 */       return calculateRawEncoding(str1, str2, str3);
/* 440 */     } catch (XmlStreamReaderException xmlStreamReaderException) {
/* 441 */       if (paramBoolean) {
/* 442 */         return doLenientDetection(null, xmlStreamReaderException);
/*     */       }
/* 444 */       throw xmlStreamReaderException;
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
/*     */   
/*     */   private String processHttpStream(BOMInputStream paramBOMInputStream1, BOMInputStream paramBOMInputStream2, String paramString, boolean paramBoolean) throws IOException {
/* 461 */     String str1 = paramBOMInputStream1.getBOMCharsetName();
/* 462 */     String str2 = paramBOMInputStream2.getBOMCharsetName();
/* 463 */     String str3 = getXmlProlog(paramBOMInputStream2, str2);
/*     */     try {
/* 465 */       return calculateHttpEncoding(paramString, str1, str2, str3, paramBoolean);
/* 466 */     } catch (XmlStreamReaderException xmlStreamReaderException) {
/* 467 */       if (paramBoolean) {
/* 468 */         return doLenientDetection(paramString, xmlStreamReaderException);
/*     */       }
/* 470 */       throw xmlStreamReaderException;
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
/*     */   private String doLenientDetection(String paramString, XmlStreamReaderException paramXmlStreamReaderException) throws IOException {
/* 485 */     if (paramString != null && paramString.startsWith("text/html")) {
/* 486 */       paramString = paramString.substring("text/html".length());
/* 487 */       paramString = "text/xml" + paramString;
/*     */       try {
/* 489 */         return calculateHttpEncoding(paramString, paramXmlStreamReaderException.getBomEncoding(), paramXmlStreamReaderException
/* 490 */             .getXmlGuessEncoding(), paramXmlStreamReaderException.getXmlEncoding(), true);
/* 491 */       } catch (XmlStreamReaderException xmlStreamReaderException) {
/* 492 */         paramXmlStreamReaderException = xmlStreamReaderException;
/*     */       } 
/*     */     } 
/* 495 */     String str = paramXmlStreamReaderException.getXmlEncoding();
/* 496 */     if (str == null) {
/* 497 */       str = paramXmlStreamReaderException.getContentTypeEncoding();
/*     */     }
/* 499 */     if (str == null) {
/* 500 */       str = (this.defaultEncoding == null) ? "UTF-8" : this.defaultEncoding;
/*     */     }
/* 502 */     return str;
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
/*     */   String calculateRawEncoding(String paramString1, String paramString2, String paramString3) throws IOException {
/* 518 */     if (paramString1 == null) {
/* 519 */       if (paramString2 == null || paramString3 == null) {
/* 520 */         return (this.defaultEncoding == null) ? "UTF-8" : this.defaultEncoding;
/*     */       }
/* 522 */       if (paramString3.equals("UTF-16") && (paramString2
/* 523 */         .equals("UTF-16BE") || paramString2.equals("UTF-16LE"))) {
/* 524 */         return paramString2;
/*     */       }
/* 526 */       return paramString3;
/*     */     } 
/*     */ 
/*     */     
/* 530 */     if (paramString1.equals("UTF-8")) {
/* 531 */       if (paramString2 != null && !paramString2.equals("UTF-8")) {
/* 532 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 533 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 535 */       if (paramString3 != null && !paramString3.equals("UTF-8")) {
/* 536 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 537 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 539 */       return paramString1;
/*     */     } 
/*     */ 
/*     */     
/* 543 */     if (paramString1.equals("UTF-16BE") || paramString1.equals("UTF-16LE")) {
/* 544 */       if (paramString2 != null && !paramString2.equals(paramString1)) {
/* 545 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 546 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 548 */       if (paramString3 != null && !paramString3.equals("UTF-16") && !paramString3.equals(paramString1)) {
/* 549 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 550 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 552 */       return paramString1;
/*     */     } 
/*     */ 
/*     */     
/* 556 */     if (paramString1.equals("UTF-32BE") || paramString1.equals("UTF-32LE")) {
/* 557 */       if (paramString2 != null && !paramString2.equals(paramString1)) {
/* 558 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 559 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 561 */       if (paramString3 != null && !paramString3.equals("UTF-32") && !paramString3.equals(paramString1)) {
/* 562 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 563 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 565 */       return paramString1;
/*     */     } 
/*     */ 
/*     */     
/* 569 */     String str = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM", new Object[] { paramString1, paramString2, paramString3 });
/* 570 */     throw new XmlStreamReaderException(str, paramString1, paramString2, paramString3);
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
/*     */   String calculateHttpEncoding(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) throws IOException {
/* 591 */     if (paramBoolean && paramString4 != null) {
/* 592 */       return paramString4;
/*     */     }
/*     */ 
/*     */     
/* 596 */     String str1 = getContentTypeMime(paramString1);
/* 597 */     String str2 = getContentTypeEncoding(paramString1);
/* 598 */     boolean bool1 = isAppXml(str1);
/* 599 */     boolean bool2 = isTextXml(str1);
/*     */ 
/*     */     
/* 602 */     if (!bool1 && !bool2) {
/* 603 */       String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 604 */       throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */     } 
/*     */ 
/*     */     
/* 608 */     if (str2 == null) {
/* 609 */       if (bool1) {
/* 610 */         return calculateRawEncoding(paramString2, paramString3, paramString4);
/*     */       }
/* 612 */       return (this.defaultEncoding == null) ? "US-ASCII" : this.defaultEncoding;
/*     */     } 
/*     */ 
/*     */     
/* 616 */     if (str2.equals("UTF-16BE") || str2.equals("UTF-16LE")) {
/* 617 */       if (paramString2 != null) {
/* 618 */         String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 619 */         throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */       } 
/* 621 */       return str2;
/*     */     } 
/*     */ 
/*     */     
/* 625 */     if (str2.equals("UTF-16")) {
/* 626 */       if (paramString2 != null && paramString2.startsWith("UTF-16")) {
/* 627 */         return paramString2;
/*     */       }
/* 629 */       String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 630 */       throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */     } 
/*     */ 
/*     */     
/* 634 */     if (str2.equals("UTF-32BE") || str2.equals("UTF-32LE")) {
/* 635 */       if (paramString2 != null) {
/* 636 */         String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 637 */         throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */       } 
/* 639 */       return str2;
/*     */     } 
/*     */ 
/*     */     
/* 643 */     if (str2.equals("UTF-32")) {
/* 644 */       if (paramString2 != null && paramString2.startsWith("UTF-32")) {
/* 645 */         return paramString2;
/*     */       }
/* 647 */       String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 648 */       throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */     } 
/*     */     
/* 651 */     return str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getContentTypeMime(String paramString) {
/* 661 */     String str = null;
/* 662 */     if (paramString != null) {
/* 663 */       int i = paramString.indexOf(";");
/* 664 */       if (i >= 0) {
/* 665 */         str = paramString.substring(0, i);
/*     */       } else {
/* 667 */         str = paramString;
/*     */       } 
/* 669 */       str = str.trim();
/*     */     } 
/* 671 */     return str;
/*     */   }
/*     */ 
/*     */   
/* 675 */   private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getContentTypeEncoding(String paramString) {
/* 685 */     String str = null;
/* 686 */     if (paramString != null) {
/* 687 */       int i = paramString.indexOf(";");
/* 688 */       if (i > -1) {
/* 689 */         String str1 = paramString.substring(i + 1);
/* 690 */         Matcher matcher = CHARSET_PATTERN.matcher(str1);
/* 691 */         str = matcher.find() ? matcher.group(1) : null;
/* 692 */         str = (str != null) ? str.toUpperCase(Locale.ROOT) : null;
/*     */       } 
/*     */     } 
/* 695 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 701 */   public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);
/*     */   
/*     */   private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
/*     */   
/*     */   private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
/*     */   
/*     */   private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
/*     */   
/*     */   private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
/*     */   
/*     */   private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
/*     */ 
/*     */   
/*     */   private static String getXmlProlog(InputStream paramInputStream, String paramString) throws IOException {
/* 715 */     String str = null;
/* 716 */     if (paramString != null) {
/* 717 */       byte[] arrayOfByte = new byte[8192];
/* 718 */       paramInputStream.mark(8192);
/* 719 */       int i = 0;
/* 720 */       int j = 8192;
/* 721 */       int k = paramInputStream.read(arrayOfByte, i, j);
/* 722 */       int m = -1;
/* 723 */       String str1 = "";
/* 724 */       while (k != -1 && m == -1 && i < 8192) {
/* 725 */         i += k;
/* 726 */         j -= k;
/* 727 */         k = paramInputStream.read(arrayOfByte, i, j);
/* 728 */         str1 = new String(arrayOfByte, 0, i, paramString);
/* 729 */         m = str1.indexOf('>');
/*     */       } 
/* 731 */       if (m == -1) {
/* 732 */         if (k == -1) {
/* 733 */           throw new IOException("Unexpected end of XML stream");
/*     */         }
/* 735 */         throw new IOException("XML prolog or ROOT element not found on first " + i + " bytes");
/*     */       } 
/*     */ 
/*     */       
/* 739 */       int n = i;
/* 740 */       if (n > 0) {
/* 741 */         paramInputStream.reset();
/*     */         
/* 743 */         BufferedReader bufferedReader = new BufferedReader(new StringReader(str1.substring(0, m + 1)));
/* 744 */         StringBuffer stringBuffer = new StringBuffer();
/*     */         String str2;
/* 746 */         while ((str2 = bufferedReader.readLine()) != null) {
/* 747 */           stringBuffer.append(str2);
/*     */         }
/* 749 */         Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer);
/* 750 */         if (matcher.find()) {
/* 751 */           str = matcher.group(1).toUpperCase(Locale.ROOT);
/* 752 */           str = str.substring(1, str.length() - 1);
/*     */         } 
/*     */       } 
/*     */     } 
/* 756 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isAppXml(String paramString) {
/* 767 */     return (paramString != null && (paramString
/* 768 */       .equals("application/xml") || paramString
/* 769 */       .equals("application/xml-dtd") || paramString
/* 770 */       .equals("application/xml-external-parsed-entity") || (paramString
/* 771 */       .startsWith("application/") && paramString.endsWith("+xml"))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isTextXml(String paramString) {
/* 782 */     return (paramString != null && (paramString
/* 783 */       .equals("text/xml") || paramString
/* 784 */       .equals("text/xml-external-parsed-entity") || (paramString
/* 785 */       .startsWith("text/") && paramString.endsWith("+xml"))));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\XmlStreamReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */