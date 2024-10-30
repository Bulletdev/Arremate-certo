/*     */ package org.jsoup.helper;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import org.jsoup.Connection;
/*     */ import org.jsoup.HttpStatusException;
/*     */ import org.jsoup.UnsupportedMimeTypeException;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.parser.TokenQueue;
/*     */ 
/*     */ public class HttpConnection implements Connection {
/*     */   public static Connection connect(String paramString) {
/*  29 */     HttpConnection httpConnection = new HttpConnection();
/*  30 */     httpConnection.url(paramString);
/*  31 */     return httpConnection;
/*     */   }
/*     */   private static final int HTTP_TEMP_REDIR = 307;
/*     */   public static Connection connect(URL paramURL) {
/*  35 */     HttpConnection httpConnection = new HttpConnection();
/*  36 */     httpConnection.url(paramURL);
/*  37 */     return httpConnection;
/*     */   }
/*     */   private Connection.Request req; private Connection.Response res;
/*     */   private static String encodeUrl(String paramString) {
/*  41 */     if (paramString == null)
/*  42 */       return null; 
/*  43 */     return paramString.replaceAll(" ", "%20");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HttpConnection() {
/*  50 */     this.req = new Request();
/*  51 */     this.res = new Response();
/*     */   }
/*     */   
/*     */   public Connection url(URL paramURL) {
/*  55 */     this.req.url(paramURL);
/*  56 */     return this;
/*     */   }
/*     */   
/*     */   public Connection url(String paramString) {
/*  60 */     Validate.notEmpty(paramString, "Must supply a valid URL");
/*     */     try {
/*  62 */       this.req.url(new URL(encodeUrl(paramString)));
/*  63 */     } catch (MalformedURLException malformedURLException) {
/*  64 */       throw new IllegalArgumentException("Malformed URL: " + paramString, malformedURLException);
/*     */     } 
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public Connection userAgent(String paramString) {
/*  70 */     Validate.notNull(paramString, "User agent must not be null");
/*  71 */     this.req.header("User-Agent", paramString);
/*  72 */     return this;
/*     */   }
/*     */   
/*     */   public Connection timeout(int paramInt) {
/*  76 */     this.req.timeout(paramInt);
/*  77 */     return this;
/*     */   }
/*     */   
/*     */   public Connection maxBodySize(int paramInt) {
/*  81 */     this.req.maxBodySize(paramInt);
/*  82 */     return this;
/*     */   }
/*     */   
/*     */   public Connection followRedirects(boolean paramBoolean) {
/*  86 */     this.req.followRedirects(paramBoolean);
/*  87 */     return this;
/*     */   }
/*     */   
/*     */   public Connection referrer(String paramString) {
/*  91 */     Validate.notNull(paramString, "Referrer must not be null");
/*  92 */     this.req.header("Referer", paramString);
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public Connection method(Connection.Method paramMethod) {
/*  97 */     this.req.method(paramMethod);
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public Connection ignoreHttpErrors(boolean paramBoolean) {
/* 102 */     this.req.ignoreHttpErrors(paramBoolean);
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   public Connection ignoreContentType(boolean paramBoolean) {
/* 107 */     this.req.ignoreContentType(paramBoolean);
/* 108 */     return this;
/*     */   }
/*     */   
/*     */   public Connection data(String paramString1, String paramString2) {
/* 112 */     this.req.data(KeyVal.create(paramString1, paramString2));
/* 113 */     return this;
/*     */   }
/*     */   
/*     */   public Connection data(Map<String, String> paramMap) {
/* 117 */     Validate.notNull(paramMap, "Data map must not be null");
/* 118 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/* 119 */       this.req.data(KeyVal.create((String)entry.getKey(), (String)entry.getValue()));
/*     */     }
/* 121 */     return this;
/*     */   }
/*     */   
/*     */   public Connection data(String... paramVarArgs) {
/* 125 */     Validate.notNull(paramVarArgs, "Data key value pairs must not be null");
/* 126 */     Validate.isTrue((paramVarArgs.length % 2 == 0), "Must supply an even number of key value pairs");
/* 127 */     for (byte b = 0; b < paramVarArgs.length; b += 2) {
/* 128 */       String str1 = paramVarArgs[b];
/* 129 */       String str2 = paramVarArgs[b + 1];
/* 130 */       Validate.notEmpty(str1, "Data key must not be empty");
/* 131 */       Validate.notNull(str2, "Data value must not be null");
/* 132 */       this.req.data(KeyVal.create(str1, str2));
/*     */     } 
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   public Connection data(Collection<Connection.KeyVal> paramCollection) {
/* 138 */     Validate.notNull(paramCollection, "Data collection must not be null");
/* 139 */     for (Connection.KeyVal keyVal : paramCollection) {
/* 140 */       this.req.data(keyVal);
/*     */     }
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   public Connection header(String paramString1, String paramString2) {
/* 146 */     this.req.header(paramString1, paramString2);
/* 147 */     return this;
/*     */   }
/*     */   
/*     */   public Connection cookie(String paramString1, String paramString2) {
/* 151 */     this.req.cookie(paramString1, paramString2);
/* 152 */     return this;
/*     */   }
/*     */   
/*     */   public Connection cookies(Map<String, String> paramMap) {
/* 156 */     Validate.notNull(paramMap, "Cookie map must not be null");
/* 157 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/* 158 */       this.req.cookie((String)entry.getKey(), (String)entry.getValue());
/*     */     }
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   public Connection parser(Parser paramParser) {
/* 164 */     this.req.parser(paramParser);
/* 165 */     return this;
/*     */   }
/*     */   
/*     */   public Document get() throws IOException {
/* 169 */     this.req.method(Connection.Method.GET);
/* 170 */     execute();
/* 171 */     return this.res.parse();
/*     */   }
/*     */   
/*     */   public Document post() throws IOException {
/* 175 */     this.req.method(Connection.Method.POST);
/* 176 */     execute();
/* 177 */     return this.res.parse();
/*     */   }
/*     */   
/*     */   public Connection.Response execute() throws IOException {
/* 181 */     this.res = Response.execute(this.req);
/* 182 */     return this.res;
/*     */   }
/*     */   
/*     */   public Connection.Request request() {
/* 186 */     return this.req;
/*     */   }
/*     */   
/*     */   public Connection request(Connection.Request paramRequest) {
/* 190 */     this.req = paramRequest;
/* 191 */     return this;
/*     */   }
/*     */   
/*     */   public Connection.Response response() {
/* 195 */     return this.res;
/*     */   }
/*     */   
/*     */   public Connection response(Connection.Response paramResponse) {
/* 199 */     this.res = paramResponse;
/* 200 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class Base<T extends Connection.Base>
/*     */     implements Connection.Base<T>
/*     */   {
/*     */     URL url;
/*     */     
/*     */     Connection.Method method;
/*     */     
/* 211 */     Map<String, String> headers = new LinkedHashMap<String, String>();
/* 212 */     Map<String, String> cookies = new LinkedHashMap<String, String>();
/*     */ 
/*     */     
/*     */     public URL url() {
/* 216 */       return this.url;
/*     */     }
/*     */     
/*     */     public T url(URL param1URL) {
/* 220 */       Validate.notNull(param1URL, "URL must not be null");
/* 221 */       this.url = param1URL;
/* 222 */       return (T)this;
/*     */     }
/*     */     
/*     */     public Connection.Method method() {
/* 226 */       return this.method;
/*     */     }
/*     */     
/*     */     public T method(Connection.Method param1Method) {
/* 230 */       Validate.notNull(param1Method, "Method must not be null");
/* 231 */       this.method = param1Method;
/* 232 */       return (T)this;
/*     */     }
/*     */     
/*     */     public String header(String param1String) {
/* 236 */       Validate.notNull(param1String, "Header name must not be null");
/* 237 */       return getHeaderCaseInsensitive(param1String);
/*     */     }
/*     */     
/*     */     public T header(String param1String1, String param1String2) {
/* 241 */       Validate.notEmpty(param1String1, "Header name must not be empty");
/* 242 */       Validate.notNull(param1String2, "Header value must not be null");
/* 243 */       removeHeader(param1String1);
/* 244 */       this.headers.put(param1String1, param1String2);
/* 245 */       return (T)this;
/*     */     }
/*     */     
/*     */     public boolean hasHeader(String param1String) {
/* 249 */       Validate.notEmpty(param1String, "Header name must not be empty");
/* 250 */       return (getHeaderCaseInsensitive(param1String) != null);
/*     */     }
/*     */     
/*     */     public T removeHeader(String param1String) {
/* 254 */       Validate.notEmpty(param1String, "Header name must not be empty");
/* 255 */       Map.Entry<String, String> entry = scanHeaders(param1String);
/* 256 */       if (entry != null)
/* 257 */         this.headers.remove(entry.getKey()); 
/* 258 */       return (T)this;
/*     */     }
/*     */     
/*     */     public Map<String, String> headers() {
/* 262 */       return this.headers;
/*     */     }
/*     */     
/*     */     private String getHeaderCaseInsensitive(String param1String) {
/* 266 */       Validate.notNull(param1String, "Header name must not be null");
/*     */       
/* 268 */       String str = this.headers.get(param1String);
/* 269 */       if (str == null)
/* 270 */         str = this.headers.get(param1String.toLowerCase()); 
/* 271 */       if (str == null) {
/* 272 */         Map.Entry<String, String> entry = scanHeaders(param1String);
/* 273 */         if (entry != null)
/* 274 */           str = entry.getValue(); 
/*     */       } 
/* 276 */       return str;
/*     */     }
/*     */     
/*     */     private Map.Entry<String, String> scanHeaders(String param1String) {
/* 280 */       String str = param1String.toLowerCase();
/* 281 */       for (Map.Entry<String, String> entry : this.headers.entrySet()) {
/* 282 */         if (((String)entry.getKey()).toLowerCase().equals(str))
/* 283 */           return entry; 
/*     */       } 
/* 285 */       return null;
/*     */     }
/*     */     
/*     */     public String cookie(String param1String) {
/* 289 */       Validate.notNull(param1String, "Cookie name must not be null");
/* 290 */       return this.cookies.get(param1String);
/*     */     }
/*     */     
/*     */     public T cookie(String param1String1, String param1String2) {
/* 294 */       Validate.notEmpty(param1String1, "Cookie name must not be empty");
/* 295 */       Validate.notNull(param1String2, "Cookie value must not be null");
/* 296 */       this.cookies.put(param1String1, param1String2);
/* 297 */       return (T)this;
/*     */     }
/*     */     
/*     */     public boolean hasCookie(String param1String) {
/* 301 */       Validate.notEmpty("Cookie name must not be empty");
/* 302 */       return this.cookies.containsKey(param1String);
/*     */     }
/*     */     
/*     */     public T removeCookie(String param1String) {
/* 306 */       Validate.notEmpty("Cookie name must not be empty");
/* 307 */       this.cookies.remove(param1String);
/* 308 */       return (T)this;
/*     */     }
/*     */     
/*     */     public Map<String, String> cookies() {
/* 312 */       return this.cookies;
/*     */     }
/*     */     
/*     */     private Base() {} }
/*     */   
/*     */   public static class Request extends Base<Connection.Request> implements Connection.Request { private int timeoutMilliseconds;
/*     */     private int maxBodySizeBytes;
/*     */     private boolean followRedirects;
/*     */     private Collection<Connection.KeyVal> data;
/*     */     private boolean ignoreHttpErrors = false;
/*     */     private boolean ignoreContentType = false;
/*     */     private Parser parser;
/*     */     
/*     */     private Request() {
/* 326 */       this.timeoutMilliseconds = 3000;
/* 327 */       this.maxBodySizeBytes = 1048576;
/* 328 */       this.followRedirects = true;
/* 329 */       this.data = new ArrayList<Connection.KeyVal>();
/* 330 */       this.method = Connection.Method.GET;
/* 331 */       this.headers.put("Accept-Encoding", "gzip");
/* 332 */       this.parser = Parser.htmlParser();
/*     */     }
/*     */     
/*     */     public int timeout() {
/* 336 */       return this.timeoutMilliseconds;
/*     */     }
/*     */     
/*     */     public Request timeout(int param1Int) {
/* 340 */       Validate.isTrue((param1Int >= 0), "Timeout milliseconds must be 0 (infinite) or greater");
/* 341 */       this.timeoutMilliseconds = param1Int;
/* 342 */       return this;
/*     */     }
/*     */     
/*     */     public int maxBodySize() {
/* 346 */       return this.maxBodySizeBytes;
/*     */     }
/*     */     
/*     */     public Connection.Request maxBodySize(int param1Int) {
/* 350 */       Validate.isTrue((param1Int >= 0), "maxSize must be 0 (unlimited) or larger");
/* 351 */       this.maxBodySizeBytes = param1Int;
/* 352 */       return this;
/*     */     }
/*     */     
/*     */     public boolean followRedirects() {
/* 356 */       return this.followRedirects;
/*     */     }
/*     */     
/*     */     public Connection.Request followRedirects(boolean param1Boolean) {
/* 360 */       this.followRedirects = param1Boolean;
/* 361 */       return this;
/*     */     }
/*     */     
/*     */     public boolean ignoreHttpErrors() {
/* 365 */       return this.ignoreHttpErrors;
/*     */     }
/*     */     
/*     */     public Connection.Request ignoreHttpErrors(boolean param1Boolean) {
/* 369 */       this.ignoreHttpErrors = param1Boolean;
/* 370 */       return this;
/*     */     }
/*     */     
/*     */     public boolean ignoreContentType() {
/* 374 */       return this.ignoreContentType;
/*     */     }
/*     */     
/*     */     public Connection.Request ignoreContentType(boolean param1Boolean) {
/* 378 */       this.ignoreContentType = param1Boolean;
/* 379 */       return this;
/*     */     }
/*     */     
/*     */     public Request data(Connection.KeyVal param1KeyVal) {
/* 383 */       Validate.notNull(param1KeyVal, "Key val must not be null");
/* 384 */       this.data.add(param1KeyVal);
/* 385 */       return this;
/*     */     }
/*     */     
/*     */     public Collection<Connection.KeyVal> data() {
/* 389 */       return this.data;
/*     */     }
/*     */     
/*     */     public Request parser(Parser param1Parser) {
/* 393 */       this.parser = param1Parser;
/* 394 */       return this;
/*     */     }
/*     */     
/*     */     public Parser parser() {
/* 398 */       return this.parser;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class Response extends Base<Connection.Response> implements Connection.Response {
/*     */     private static final int MAX_REDIRECTS = 20;
/*     */     private int statusCode;
/*     */     private String statusMessage;
/*     */     private ByteBuffer byteData;
/*     */     private String charset;
/*     */     private String contentType;
/*     */     private boolean executed = false;
/* 410 */     private int numRedirects = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     private Connection.Request req;
/*     */ 
/*     */ 
/*     */     
/* 418 */     private static final Pattern xmlContentTypeRxp = Pattern.compile("application/\\w+\\+xml.*");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Response(Response param1Response) throws IOException {
/* 426 */       if (param1Response != null) {
/* 427 */         param1Response.numRedirects++;
/* 428 */         if (this.numRedirects >= 20)
/* 429 */           throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[] { param1Response.url() })); 
/*     */       } 
/*     */     }
/*     */     
/*     */     static Response execute(Connection.Request param1Request) throws IOException {
/* 434 */       return execute(param1Request, (Response)null);
/*     */     }
/*     */     static Response execute(Connection.Request param1Request, Response param1Response) throws IOException {
/*     */       Response response;
/* 438 */       Validate.notNull(param1Request, "Request must not be null");
/* 439 */       String str = param1Request.url().getProtocol();
/* 440 */       if (!str.equals("http") && !str.equals("https")) {
/* 441 */         throw new MalformedURLException("Only http & https protocols supported");
/*     */       }
/*     */       
/* 444 */       if (param1Request.method() == Connection.Method.GET && param1Request.data().size() > 0)
/* 445 */         serialiseRequestUrl(param1Request); 
/* 446 */       HttpURLConnection httpURLConnection = createConnection(param1Request);
/*     */       
/*     */       try {
/* 449 */         httpURLConnection.connect();
/* 450 */         if (param1Request.method() == Connection.Method.POST) {
/* 451 */           writePost(param1Request.data(), httpURLConnection.getOutputStream());
/*     */         }
/* 453 */         int i = httpURLConnection.getResponseCode();
/* 454 */         boolean bool = false;
/* 455 */         if (i != 200)
/* 456 */           if (i == 302 || i == 301 || i == 303 || i == 307) {
/* 457 */             bool = true;
/* 458 */           } else if (!param1Request.ignoreHttpErrors()) {
/* 459 */             throw new HttpStatusException("HTTP error fetching URL", i, param1Request.url().toString());
/*     */           }  
/* 461 */         response = new Response(param1Response);
/* 462 */         response.setupFromConnection(httpURLConnection, param1Response);
/* 463 */         if (bool && param1Request.followRedirects()) {
/* 464 */           param1Request.method(Connection.Method.GET);
/* 465 */           param1Request.data().clear();
/*     */           
/* 467 */           String str2 = response.header("Location");
/* 468 */           if (str2 != null && str2.startsWith("http:/") && str2.charAt(6) != '/')
/* 469 */             str2 = str2.substring(6); 
/* 470 */           param1Request.url(new URL(param1Request.url(), HttpConnection.encodeUrl(str2)));
/*     */           
/* 472 */           for (Map.Entry<String, String> entry : response.cookies.entrySet()) {
/* 473 */             param1Request.cookie((String)entry.getKey(), (String)entry.getValue());
/*     */           }
/* 475 */           return execute(param1Request, response);
/*     */         } 
/* 477 */         response.req = param1Request;
/*     */ 
/*     */         
/* 480 */         String str1 = response.contentType();
/* 481 */         if (str1 != null && !param1Request.ignoreContentType() && !str1.startsWith("text/") && !str1.startsWith("application/xml") && !xmlContentTypeRxp.matcher(str1).matches())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 487 */           throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml", str1, param1Request.url().toString());
/*     */         }
/*     */         
/* 490 */         BufferedInputStream bufferedInputStream = null;
/* 491 */         InputStream inputStream = null;
/*     */         try {
/* 493 */           inputStream = (httpURLConnection.getErrorStream() != null) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
/* 494 */           bufferedInputStream = (response.hasHeader("Content-Encoding") && response.header("Content-Encoding").equalsIgnoreCase("gzip")) ? new BufferedInputStream(new GZIPInputStream(inputStream)) : new BufferedInputStream(inputStream);
/*     */ 
/*     */ 
/*     */           
/* 498 */           response.byteData = DataUtil.readToByteBuffer(bufferedInputStream, param1Request.maxBodySize());
/* 499 */           response.charset = DataUtil.getCharsetFromContentType(response.contentType);
/*     */         } finally {
/* 501 */           if (bufferedInputStream != null) bufferedInputStream.close(); 
/* 502 */           if (inputStream != null) inputStream.close();
/*     */         
/*     */         } 
/*     */       } finally {
/*     */         
/* 507 */         httpURLConnection.disconnect();
/*     */       } 
/*     */       
/* 510 */       response.executed = true;
/* 511 */       return response;
/*     */     }
/*     */     
/*     */     public int statusCode() {
/* 515 */       return this.statusCode;
/*     */     }
/*     */     
/*     */     public String statusMessage() {
/* 519 */       return this.statusMessage;
/*     */     }
/*     */     
/*     */     public String charset() {
/* 523 */       return this.charset;
/*     */     }
/*     */     
/*     */     public String contentType() {
/* 527 */       return this.contentType;
/*     */     }
/*     */     
/*     */     public Document parse() throws IOException {
/* 531 */       Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
/* 532 */       Document document = DataUtil.parseByteData(this.byteData, this.charset, this.url.toExternalForm(), this.req.parser());
/* 533 */       this.byteData.rewind();
/* 534 */       this.charset = document.outputSettings().charset().name();
/* 535 */       return document;
/*     */     }
/*     */     public String body() {
/*     */       String str;
/* 539 */       Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
/*     */ 
/*     */       
/* 542 */       if (this.charset == null) {
/* 543 */         str = Charset.forName("UTF-8").decode(this.byteData).toString();
/*     */       } else {
/* 545 */         str = Charset.forName(this.charset).decode(this.byteData).toString();
/* 546 */       }  this.byteData.rewind();
/* 547 */       return str;
/*     */     }
/*     */     
/*     */     public byte[] bodyAsBytes() {
/* 551 */       Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
/* 552 */       return this.byteData.array();
/*     */     }
/*     */ 
/*     */     
/*     */     private static HttpURLConnection createConnection(Connection.Request param1Request) throws IOException {
/* 557 */       HttpURLConnection httpURLConnection = (HttpURLConnection)param1Request.url().openConnection();
/* 558 */       httpURLConnection.setRequestMethod(param1Request.method().name());
/* 559 */       httpURLConnection.setInstanceFollowRedirects(false);
/* 560 */       httpURLConnection.setConnectTimeout(param1Request.timeout());
/* 561 */       httpURLConnection.setReadTimeout(param1Request.timeout());
/* 562 */       if (param1Request.method() == Connection.Method.POST)
/* 563 */         httpURLConnection.setDoOutput(true); 
/* 564 */       if (param1Request.cookies().size() > 0)
/* 565 */         httpURLConnection.addRequestProperty("Cookie", getRequestCookieString(param1Request)); 
/* 566 */       for (Map.Entry entry : param1Request.headers().entrySet()) {
/* 567 */         httpURLConnection.addRequestProperty((String)entry.getKey(), (String)entry.getValue());
/*     */       }
/* 569 */       return httpURLConnection;
/*     */     }
/*     */ 
/*     */     
/*     */     private void setupFromConnection(HttpURLConnection param1HttpURLConnection, Connection.Response param1Response) throws IOException {
/* 574 */       this.method = Connection.Method.valueOf(param1HttpURLConnection.getRequestMethod());
/* 575 */       this.url = param1HttpURLConnection.getURL();
/* 576 */       this.statusCode = param1HttpURLConnection.getResponseCode();
/* 577 */       this.statusMessage = param1HttpURLConnection.getResponseMessage();
/* 578 */       this.contentType = param1HttpURLConnection.getContentType();
/*     */       
/* 580 */       Map<String, List<String>> map = param1HttpURLConnection.getHeaderFields();
/* 581 */       processResponseHeaders(map);
/*     */ 
/*     */       
/* 584 */       if (param1Response != null)
/* 585 */         for (Map.Entry entry : param1Response.cookies().entrySet()) {
/* 586 */           if (!hasCookie((String)entry.getKey())) {
/* 587 */             cookie((String)entry.getKey(), (String)entry.getValue());
/*     */           }
/*     */         }  
/*     */     }
/*     */     
/*     */     void processResponseHeaders(Map<String, List<String>> param1Map) {
/* 593 */       for (Map.Entry<String, List<String>> entry : param1Map.entrySet()) {
/* 594 */         String str = (String)entry.getKey();
/* 595 */         if (str == null) {
/*     */           continue;
/*     */         }
/* 598 */         List<String> list = (List)entry.getValue();
/* 599 */         if (str.equalsIgnoreCase("Set-Cookie")) {
/* 600 */           for (String str1 : list) {
/* 601 */             if (str1 == null)
/*     */               continue; 
/* 603 */             TokenQueue tokenQueue = new TokenQueue(str1);
/* 604 */             String str2 = tokenQueue.chompTo("=").trim();
/* 605 */             String str3 = tokenQueue.consumeTo(";").trim();
/* 606 */             if (str3 == null) {
/* 607 */               str3 = "";
/*     */             }
/*     */             
/* 610 */             if (str2 != null && str2.length() > 0)
/* 611 */               cookie(str2, str3); 
/*     */           }  continue;
/*     */         } 
/* 614 */         if (!list.isEmpty()) {
/* 615 */           header(str, list.get(0));
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     private static void writePost(Collection<Connection.KeyVal> param1Collection, OutputStream param1OutputStream) throws IOException {
/* 621 */       OutputStreamWriter outputStreamWriter = new OutputStreamWriter(param1OutputStream, "UTF-8");
/* 622 */       boolean bool = true;
/* 623 */       for (Connection.KeyVal keyVal : param1Collection) {
/* 624 */         if (!bool) {
/* 625 */           outputStreamWriter.append('&');
/*     */         } else {
/* 627 */           bool = false;
/*     */         } 
/* 629 */         outputStreamWriter.write(URLEncoder.encode(keyVal.key(), "UTF-8"));
/* 630 */         outputStreamWriter.write(61);
/* 631 */         outputStreamWriter.write(URLEncoder.encode(keyVal.value(), "UTF-8"));
/*     */       } 
/* 633 */       outputStreamWriter.close();
/*     */     }
/*     */     
/*     */     private static String getRequestCookieString(Connection.Request param1Request) {
/* 637 */       StringBuilder stringBuilder = new StringBuilder();
/* 638 */       boolean bool = true;
/* 639 */       for (Map.Entry entry : param1Request.cookies().entrySet()) {
/* 640 */         if (!bool) {
/* 641 */           stringBuilder.append("; ");
/*     */         } else {
/* 643 */           bool = false;
/* 644 */         }  stringBuilder.append((String)entry.getKey()).append('=').append((String)entry.getValue());
/*     */       } 
/*     */       
/* 647 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     private static void serialiseRequestUrl(Connection.Request param1Request) throws IOException {
/* 652 */       URL uRL = param1Request.url();
/* 653 */       StringBuilder stringBuilder = new StringBuilder();
/* 654 */       boolean bool = true;
/*     */       
/* 656 */       stringBuilder.append(uRL.getProtocol()).append("://").append(uRL.getAuthority()).append(uRL.getPath()).append("?");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 662 */       if (uRL.getQuery() != null) {
/* 663 */         stringBuilder.append(uRL.getQuery());
/* 664 */         bool = false;
/*     */       } 
/* 666 */       for (Connection.KeyVal keyVal : param1Request.data()) {
/* 667 */         if (!bool) {
/* 668 */           stringBuilder.append('&');
/*     */         } else {
/* 670 */           bool = false;
/* 671 */         }  stringBuilder.append(URLEncoder.encode(keyVal.key(), "UTF-8")).append('=').append(URLEncoder.encode(keyVal.value(), "UTF-8"));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 676 */       param1Request.url(new URL(stringBuilder.toString()));
/* 677 */       param1Request.data().clear();
/*     */     }
/*     */     
/*     */     Response() {} }
/*     */   
/*     */   public static class KeyVal implements Connection.KeyVal { private String key;
/*     */     private String value;
/*     */     
/*     */     public static KeyVal create(String param1String1, String param1String2) {
/* 686 */       Validate.notEmpty(param1String1, "Data key must not be empty");
/* 687 */       Validate.notNull(param1String2, "Data value must not be null");
/* 688 */       return new KeyVal(param1String1, param1String2);
/*     */     }
/*     */     
/*     */     private KeyVal(String param1String1, String param1String2) {
/* 692 */       this.key = param1String1;
/* 693 */       this.value = param1String2;
/*     */     }
/*     */     
/*     */     public KeyVal key(String param1String) {
/* 697 */       Validate.notEmpty(param1String, "Data key must not be empty");
/* 698 */       this.key = param1String;
/* 699 */       return this;
/*     */     }
/*     */     
/*     */     public String key() {
/* 703 */       return this.key;
/*     */     }
/*     */     
/*     */     public KeyVal value(String param1String) {
/* 707 */       Validate.notNull(param1String, "Data value must not be null");
/* 708 */       this.value = param1String;
/* 709 */       return this;
/*     */     }
/*     */     
/*     */     public String value() {
/* 713 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 718 */       return this.key + "=" + this.value;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\helper\HttpConnection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */