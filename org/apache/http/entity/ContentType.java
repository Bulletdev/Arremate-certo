/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.UnsupportedCharsetException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.message.BasicHeaderValueFormatter;
/*     */ import org.apache.http.message.BasicHeaderValueParser;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.apache.http.message.ParserCursor;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ import org.apache.http.util.TextUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public final class ContentType
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7768694718232371896L;
/*  72 */   public static final ContentType APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
/*     */   
/*  74 */   public static final ContentType APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
/*     */   
/*  76 */   public static final ContentType APPLICATION_JSON = create("application/json", Consts.UTF_8);
/*     */   
/*  78 */   public static final ContentType APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset)null);
/*     */   
/*  80 */   public static final ContentType APPLICATION_SOAP_XML = create("application/soap+xml", Consts.UTF_8);
/*     */   
/*  82 */   public static final ContentType APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
/*     */   
/*  84 */   public static final ContentType APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
/*     */   
/*  86 */   public static final ContentType APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
/*     */   
/*  88 */   public static final ContentType IMAGE_BMP = create("image/bmp");
/*     */   
/*  90 */   public static final ContentType IMAGE_GIF = create("image/gif");
/*     */   
/*  92 */   public static final ContentType IMAGE_JPEG = create("image/jpeg");
/*     */   
/*  94 */   public static final ContentType IMAGE_PNG = create("image/png");
/*     */   
/*  96 */   public static final ContentType IMAGE_SVG = create("image/svg+xml");
/*     */   
/*  98 */   public static final ContentType IMAGE_TIFF = create("image/tiff");
/*     */   
/* 100 */   public static final ContentType IMAGE_WEBP = create("image/webp");
/*     */   
/* 102 */   public static final ContentType MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
/*     */   
/* 104 */   public static final ContentType TEXT_HTML = create("text/html", Consts.ISO_8859_1);
/*     */   
/* 106 */   public static final ContentType TEXT_PLAIN = create("text/plain", Consts.ISO_8859_1);
/*     */   
/* 108 */   public static final ContentType TEXT_XML = create("text/xml", Consts.ISO_8859_1);
/*     */   
/* 110 */   public static final ContentType WILDCARD = create("*/*", (Charset)null);
/*     */ 
/*     */   
/*     */   private static final Map<String, ContentType> CONTENT_TYPE_MAP;
/*     */ 
/*     */   
/*     */   static {
/* 117 */     ContentType[] arrayOfContentType = { APPLICATION_ATOM_XML, APPLICATION_FORM_URLENCODED, APPLICATION_JSON, APPLICATION_SVG_XML, APPLICATION_XHTML_XML, APPLICATION_XML, IMAGE_BMP, IMAGE_GIF, IMAGE_JPEG, IMAGE_PNG, IMAGE_SVG, IMAGE_TIFF, IMAGE_WEBP, MULTIPART_FORM_DATA, TEXT_HTML, TEXT_PLAIN, TEXT_XML };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 136 */     for (ContentType contentType : arrayOfContentType) {
/* 137 */       hashMap.put(contentType.getMimeType(), contentType);
/*     */     }
/* 139 */     CONTENT_TYPE_MAP = Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */   
/* 143 */   public static final ContentType DEFAULT_TEXT = TEXT_PLAIN;
/* 144 */   public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
/*     */   
/*     */   private final String mimeType;
/*     */   
/*     */   private final Charset charset;
/*     */   
/*     */   private final NameValuePair[] params;
/*     */   
/*     */   ContentType(String paramString, Charset paramCharset) {
/* 153 */     this.mimeType = paramString;
/* 154 */     this.charset = paramCharset;
/* 155 */     this.params = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ContentType(String paramString, Charset paramCharset, NameValuePair[] paramArrayOfNameValuePair) {
/* 162 */     this.mimeType = paramString;
/* 163 */     this.charset = paramCharset;
/* 164 */     this.params = paramArrayOfNameValuePair;
/*     */   }
/*     */   
/*     */   public String getMimeType() {
/* 168 */     return this.mimeType;
/*     */   }
/*     */   
/*     */   public Charset getCharset() {
/* 172 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParameter(String paramString) {
/* 179 */     Args.notEmpty(paramString, "Parameter name");
/* 180 */     if (this.params == null) {
/* 181 */       return null;
/*     */     }
/* 183 */     for (NameValuePair nameValuePair : this.params) {
/* 184 */       if (nameValuePair.getName().equalsIgnoreCase(paramString)) {
/* 185 */         return nameValuePair.getValue();
/*     */       }
/*     */     } 
/* 188 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
/* 198 */     charArrayBuffer.append(this.mimeType);
/* 199 */     if (this.params != null) {
/* 200 */       charArrayBuffer.append("; ");
/* 201 */       BasicHeaderValueFormatter.INSTANCE.formatParameters(charArrayBuffer, this.params, false);
/* 202 */     } else if (this.charset != null) {
/* 203 */       charArrayBuffer.append("; charset=");
/* 204 */       charArrayBuffer.append(this.charset.name());
/*     */     } 
/* 206 */     return charArrayBuffer.toString();
/*     */   }
/*     */   
/*     */   private static boolean valid(String paramString) {
/* 210 */     for (byte b = 0; b < paramString.length(); b++) {
/* 211 */       char c = paramString.charAt(b);
/* 212 */       if (c == '"' || c == ',' || c == ';') {
/* 213 */         return false;
/*     */       }
/*     */     } 
/* 216 */     return true;
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
/*     */   public static ContentType create(String paramString, Charset paramCharset) {
/* 228 */     String str = ((String)Args.notBlank(paramString, "MIME type")).toLowerCase(Locale.ROOT);
/* 229 */     Args.check(valid(str), "MIME type may not contain reserved characters");
/* 230 */     return new ContentType(str, paramCharset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ContentType create(String paramString) {
/* 241 */     return create(paramString, (Charset)null);
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
/*     */   public static ContentType create(String paramString1, String paramString2) throws UnsupportedCharsetException {
/* 257 */     return create(paramString1, !TextUtils.isBlank(paramString2) ? Charset.forName(paramString2) : null);
/*     */   }
/*     */   
/*     */   private static ContentType create(HeaderElement paramHeaderElement, boolean paramBoolean) {
/* 261 */     return create(paramHeaderElement.getName(), paramHeaderElement.getParameters(), paramBoolean);
/*     */   }
/*     */   
/*     */   private static ContentType create(String paramString, NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean) {
/* 265 */     Charset charset = null;
/* 266 */     for (NameValuePair nameValuePair : paramArrayOfNameValuePair) {
/* 267 */       if (nameValuePair.getName().equalsIgnoreCase("charset")) {
/* 268 */         String str = nameValuePair.getValue();
/* 269 */         if (!TextUtils.isBlank(str)) {
/*     */           try {
/* 271 */             charset = Charset.forName(str);
/* 272 */           } catch (UnsupportedCharsetException unsupportedCharsetException) {
/* 273 */             if (paramBoolean) {
/* 274 */               throw unsupportedCharsetException;
/*     */             }
/*     */           } 
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/* 281 */     return new ContentType(paramString, charset, (paramArrayOfNameValuePair != null && paramArrayOfNameValuePair.length > 0) ? paramArrayOfNameValuePair : null);
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
/*     */   public static ContentType create(String paramString, NameValuePair... paramVarArgs) throws UnsupportedCharsetException {
/* 296 */     String str = ((String)Args.notBlank(paramString, "MIME type")).toLowerCase(Locale.ROOT);
/* 297 */     Args.check(valid(str), "MIME type may not contain reserved characters");
/* 298 */     return create(paramString, paramVarArgs, true);
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
/*     */   public static ContentType parse(String paramString) throws ParseException, UnsupportedCharsetException {
/* 313 */     Args.notNull(paramString, "Content type");
/* 314 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 315 */     charArrayBuffer.append(paramString);
/* 316 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 317 */     HeaderElement[] arrayOfHeaderElement = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, parserCursor);
/* 318 */     if (arrayOfHeaderElement.length > 0) {
/* 319 */       return create(arrayOfHeaderElement[0], true);
/*     */     }
/* 321 */     throw new ParseException("Invalid content type: " + paramString);
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
/*     */   public static ContentType get(HttpEntity paramHttpEntity) throws ParseException, UnsupportedCharsetException {
/* 338 */     if (paramHttpEntity == null) {
/* 339 */       return null;
/*     */     }
/* 341 */     Header header = paramHttpEntity.getContentType();
/* 342 */     if (header != null) {
/* 343 */       HeaderElement[] arrayOfHeaderElement = header.getElements();
/* 344 */       if (arrayOfHeaderElement.length > 0) {
/* 345 */         return create(arrayOfHeaderElement[0], true);
/*     */       }
/*     */     } 
/* 348 */     return null;
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
/*     */   public static ContentType getLenient(HttpEntity paramHttpEntity) {
/* 362 */     if (paramHttpEntity == null) {
/* 363 */       return null;
/*     */     }
/* 365 */     Header header = paramHttpEntity.getContentType();
/* 366 */     if (header != null) {
/*     */       try {
/* 368 */         HeaderElement[] arrayOfHeaderElement = header.getElements();
/* 369 */         if (arrayOfHeaderElement.length > 0) {
/* 370 */           return create(arrayOfHeaderElement[0], false);
/*     */         }
/* 372 */       } catch (ParseException parseException) {}
/*     */     }
/*     */ 
/*     */     
/* 376 */     return null;
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
/*     */   public static ContentType getOrDefault(HttpEntity paramHttpEntity) throws ParseException, UnsupportedCharsetException {
/* 392 */     ContentType contentType = get(paramHttpEntity);
/* 393 */     return (contentType != null) ? contentType : DEFAULT_TEXT;
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
/*     */   public static ContentType getLenientOrDefault(HttpEntity paramHttpEntity) throws ParseException, UnsupportedCharsetException {
/* 407 */     ContentType contentType = get(paramHttpEntity);
/* 408 */     return (contentType != null) ? contentType : DEFAULT_TEXT;
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
/*     */   public static ContentType getByMimeType(String paramString) {
/* 421 */     if (paramString == null) {
/* 422 */       return null;
/*     */     }
/* 424 */     return CONTENT_TYPE_MAP.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentType withCharset(Charset paramCharset) {
/* 435 */     return create(getMimeType(), paramCharset);
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
/*     */   public ContentType withCharset(String paramString) {
/* 448 */     return create(getMimeType(), paramString);
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
/*     */   public ContentType withParameters(NameValuePair... paramVarArgs) throws UnsupportedCharsetException {
/* 460 */     if (paramVarArgs.length == 0) {
/* 461 */       return this;
/*     */     }
/* 463 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 464 */     if (this.params != null) {
/* 465 */       for (NameValuePair nameValuePair : this.params) {
/* 466 */         linkedHashMap.put(nameValuePair.getName(), nameValuePair.getValue());
/*     */       }
/*     */     }
/* 469 */     for (NameValuePair nameValuePair : paramVarArgs) {
/* 470 */       linkedHashMap.put(nameValuePair.getName(), nameValuePair.getValue());
/*     */     }
/* 472 */     ArrayList<BasicNameValuePair> arrayList = new ArrayList(linkedHashMap.size() + 1);
/* 473 */     if (this.charset != null && !linkedHashMap.containsKey("charset")) {
/* 474 */       arrayList.add(new BasicNameValuePair("charset", this.charset.name()));
/*     */     }
/* 476 */     for (Map.Entry<Object, Object> entry : linkedHashMap.entrySet()) {
/* 477 */       arrayList.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
/*     */     }
/* 479 */     return create(getMimeType(), arrayList.<NameValuePair>toArray(new NameValuePair[arrayList.size()]), true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\ContentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */