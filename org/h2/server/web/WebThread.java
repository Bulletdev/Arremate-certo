/*     */ package org.h2.server.web;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Properties;
/*     */ import java.util.StringTokenizer;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class WebThread
/*     */   extends WebApp
/*     */   implements Runnable
/*     */ {
/*     */   protected OutputStream output;
/*     */   protected final Socket socket;
/*     */   private final Thread thread;
/*     */   private InputStream input;
/*     */   private String ifModifiedSince;
/*     */   
/*     */   WebThread(Socket paramSocket, WebServer paramWebServer) {
/*  40 */     super(paramWebServer);
/*  41 */     this.socket = paramSocket;
/*  42 */     this.thread = new Thread(this, "H2 Console thread");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void start() {
/*  49 */     this.thread.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void join(int paramInt) throws InterruptedException {
/*  58 */     this.thread.join(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void stopNow() {
/*  65 */     this.stop = true;
/*     */     try {
/*  67 */       this.socket.close();
/*  68 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getAllowedFile(String paramString) {
/*  74 */     if (!allow()) {
/*  75 */       return "notAllowed.jsp";
/*     */     }
/*  77 */     if (paramString.length() == 0) {
/*  78 */       return "index.do";
/*     */     }
/*  80 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  86 */       this.input = new BufferedInputStream(this.socket.getInputStream());
/*  87 */       this.output = new BufferedOutputStream(this.socket.getOutputStream()); do {  }
/*  88 */       while (!this.stop && 
/*  89 */         process());
/*     */ 
/*     */     
/*     */     }
/*  93 */     catch (Exception exception) {
/*  94 */       DbException.traceThrowable(exception);
/*     */     } 
/*  96 */     IOUtils.closeSilently(this.output);
/*  97 */     IOUtils.closeSilently(this.input);
/*     */     try {
/*  99 */       this.socket.close();
/* 100 */     } catch (IOException iOException) {
/*     */     
/*     */     } finally {
/* 103 */       this.server.remove(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean process() throws IOException {
/* 109 */     boolean bool = false;
/* 110 */     String str = readHeaderLine();
/* 111 */     if (str.startsWith("GET ") || str.startsWith("POST ")) {
/* 112 */       byte[] arrayOfByte; int i = str.indexOf('/'), j = str.lastIndexOf(' ');
/*     */       
/* 114 */       if (i < 0 || j < i) {
/* 115 */         str1 = "";
/*     */       } else {
/* 117 */         str1 = str.substring(i + 1, j).trim();
/*     */       } 
/* 119 */       trace(str + ": " + str1);
/* 120 */       String str1 = getAllowedFile(str1);
/* 121 */       this.attributes = new Properties();
/* 122 */       int k = str1.indexOf("?");
/* 123 */       this.session = null;
/* 124 */       if (k >= 0) {
/* 125 */         String str4 = str1.substring(k + 1);
/* 126 */         parseAttributes(str4);
/* 127 */         str3 = this.attributes.getProperty("jsessionid");
/* 128 */         str1 = str1.substring(0, k);
/* 129 */         this.session = this.server.getSession(str3);
/*     */       } 
/* 131 */       bool = parseHeader();
/* 132 */       String str2 = this.socket.getInetAddress().getHostAddress();
/* 133 */       str1 = processRequest(str1, str2);
/* 134 */       if (str1.length() == 0)
/*     */       {
/* 136 */         return true;
/*     */       }
/*     */ 
/*     */       
/* 140 */       if (this.cache && this.ifModifiedSince != null && this.ifModifiedSince.equals(this.server.getStartDateTime())) {
/*     */         
/* 142 */         arrayOfByte = null;
/* 143 */         str3 = "HTTP/1.1 304 Not Modified\r\n";
/*     */       } else {
/* 145 */         arrayOfByte = this.server.getFile(str1);
/* 146 */         if (arrayOfByte == null) {
/* 147 */           str3 = "HTTP/1.1 404 Not Found\r\n";
/* 148 */           arrayOfByte = ("File not found: " + str1).getBytes(Constants.UTF8);
/* 149 */           str3 = str3 + "Content-Length: " + arrayOfByte.length + "\r\n";
/*     */         } else {
/* 151 */           if (this.session != null && str1.endsWith(".jsp")) {
/* 152 */             String str4 = new String(arrayOfByte, Constants.UTF8);
/* 153 */             if (SysProperties.CONSOLE_STREAM) {
/* 154 */               Iterator<String> iterator = (Iterator)this.session.map.remove("chunks");
/* 155 */               if (iterator != null) {
/* 156 */                 String str5 = "HTTP/1.1 200 OK\r\n";
/* 157 */                 str5 = str5 + "Content-Type: " + this.mimeType + "\r\n";
/* 158 */                 str5 = str5 + "Cache-Control: no-cache\r\n";
/* 159 */                 str5 = str5 + "Transfer-Encoding: chunked\r\n";
/* 160 */                 str5 = str5 + "\r\n";
/* 161 */                 trace(str5);
/* 162 */                 this.output.write(str5.getBytes());
/* 163 */                 while (iterator.hasNext()) {
/* 164 */                   String str6 = iterator.next();
/* 165 */                   str6 = PageParser.parse(str6, this.session.map);
/* 166 */                   arrayOfByte = str6.getBytes(Constants.UTF8);
/* 167 */                   if (arrayOfByte.length == 0) {
/*     */                     continue;
/*     */                   }
/* 170 */                   this.output.write(Integer.toHexString(arrayOfByte.length).getBytes());
/* 171 */                   this.output.write("\r\n".getBytes());
/* 172 */                   this.output.write(arrayOfByte);
/* 173 */                   this.output.write("\r\n".getBytes());
/* 174 */                   this.output.flush();
/*     */                 } 
/* 176 */                 this.output.write("0\r\n\r\n".getBytes());
/* 177 */                 this.output.flush();
/* 178 */                 return bool;
/*     */               } 
/*     */             } 
/* 181 */             str4 = PageParser.parse(str4, this.session.map);
/* 182 */             arrayOfByte = str4.getBytes(Constants.UTF8);
/*     */           } 
/* 184 */           str3 = "HTTP/1.1 200 OK\r\n";
/* 185 */           str3 = str3 + "Content-Type: " + this.mimeType + "\r\n";
/* 186 */           if (!this.cache) {
/* 187 */             str3 = str3 + "Cache-Control: no-cache\r\n";
/*     */           } else {
/* 189 */             str3 = str3 + "Cache-Control: max-age=10\r\n";
/* 190 */             str3 = str3 + "Last-Modified: " + this.server.getStartDateTime() + "\r\n";
/*     */           } 
/* 192 */           str3 = str3 + "Content-Length: " + arrayOfByte.length + "\r\n";
/*     */         } 
/*     */       } 
/* 195 */       String str3 = str3 + "\r\n";
/* 196 */       trace(str3);
/* 197 */       this.output.write(str3.getBytes());
/* 198 */       if (arrayOfByte != null) {
/* 199 */         this.output.write(arrayOfByte);
/*     */       }
/* 201 */       this.output.flush();
/*     */     } 
/* 203 */     return bool;
/*     */   }
/*     */   
/*     */   private String readHeaderLine() throws IOException {
/* 207 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (true) {
/* 209 */       int i = this.input.read();
/* 210 */       if (i == -1)
/* 211 */         throw new IOException("Unexpected EOF"); 
/* 212 */       if (i == 13) {
/* 213 */         if (this.input.read() == 10)
/* 214 */           return (stringBuilder.length() > 0) ? stringBuilder.toString() : null;  continue;
/*     */       } 
/* 216 */       if (i == 10) {
/* 217 */         return (stringBuilder.length() > 0) ? stringBuilder.toString() : null;
/*     */       }
/* 219 */       stringBuilder.append((char)i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void parseAttributes(String paramString) {
/* 225 */     trace("data=" + paramString);
/* 226 */     while (paramString != null) {
/* 227 */       int i = paramString.indexOf('=');
/* 228 */       if (i >= 0) {
/* 229 */         String str2, str1 = paramString.substring(0, i);
/* 230 */         paramString = paramString.substring(i + 1);
/* 231 */         i = paramString.indexOf('&');
/*     */         
/* 233 */         if (i >= 0) {
/* 234 */           str2 = paramString.substring(0, i);
/* 235 */           paramString = paramString.substring(i + 1);
/*     */         } else {
/* 237 */           str2 = paramString;
/*     */         } 
/* 239 */         String str3 = StringUtils.urlDecode(str2);
/* 240 */         this.attributes.put(str1, str3);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 245 */     trace(this.attributes.toString());
/*     */   }
/*     */   
/*     */   private boolean parseHeader() throws IOException {
/* 249 */     boolean bool1 = false;
/* 250 */     trace("parseHeader");
/* 251 */     int i = 0;
/* 252 */     this.ifModifiedSince = null;
/* 253 */     boolean bool2 = false;
/*     */     while (true) {
/* 255 */       String str1 = readHeaderLine();
/* 256 */       if (str1 == null) {
/*     */         break;
/*     */       }
/* 259 */       trace(" " + str1);
/* 260 */       String str2 = StringUtils.toLowerEnglish(str1);
/* 261 */       if (str2.startsWith("if-modified-since")) {
/* 262 */         this.ifModifiedSince = getHeaderLineValue(str1); continue;
/* 263 */       }  if (str2.startsWith("connection")) {
/* 264 */         String str = getHeaderLineValue(str1);
/* 265 */         if ("keep-alive".equals(str))
/* 266 */           bool1 = true;  continue;
/*     */       } 
/* 268 */       if (str2.startsWith("content-type")) {
/* 269 */         String str = getHeaderLineValue(str1);
/* 270 */         if (str.startsWith("multipart/form-data"))
/* 271 */           bool2 = true;  continue;
/*     */       } 
/* 273 */       if (str2.startsWith("content-length")) {
/* 274 */         i = Integer.parseInt(getHeaderLineValue(str1));
/* 275 */         trace("len=" + i); continue;
/* 276 */       }  if (str2.startsWith("user-agent")) {
/* 277 */         boolean bool = str2.contains("webkit/");
/* 278 */         if (bool && this.session != null) {
/*     */ 
/*     */           
/* 281 */           this.session.put("frame-border", "1");
/* 282 */           this.session.put("frameset-border", "2");
/*     */         }  continue;
/* 284 */       }  if (str2.startsWith("accept-language")) {
/* 285 */         Locale locale = (this.session == null) ? null : this.session.locale;
/* 286 */         if (locale == null) {
/* 287 */           String str = getHeaderLineValue(str1);
/* 288 */           StringTokenizer stringTokenizer = new StringTokenizer(str, ",;");
/* 289 */           while (stringTokenizer.hasMoreTokens()) {
/* 290 */             String str3 = stringTokenizer.nextToken();
/* 291 */             if (!str3.startsWith("q=") && 
/* 292 */               this.server.supportsLanguage(str3)) {
/* 293 */               int j = str3.indexOf('-');
/* 294 */               if (j >= 0) {
/* 295 */                 String str4 = str3.substring(0, j);
/* 296 */                 String str5 = str3.substring(j + 1);
/* 297 */                 locale = new Locale(str4, str5);
/*     */               } else {
/* 299 */                 locale = new Locale(str3, "");
/*     */               } 
/* 301 */               this.headerLanguage = locale.getLanguage();
/* 302 */               if (this.session != null) {
/* 303 */                 this.session.locale = locale;
/* 304 */                 this.session.put("language", this.headerLanguage);
/* 305 */                 this.server.readTranslations(this.session, this.headerLanguage);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 312 */       if (str1.trim().length() == 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 316 */     if (!bool2)
/*     */     {
/* 318 */       if (this.session != null && i > 0) {
/* 319 */         byte[] arrayOfByte = DataUtils.newBytes(i); int j;
/* 320 */         for (j = 0; j < i;) {
/* 321 */           j += this.input.read(arrayOfByte, j, i - j);
/*     */         }
/* 323 */         String str = new String(arrayOfByte);
/* 324 */         parseAttributes(str);
/*     */       }  } 
/* 326 */     return bool1;
/*     */   }
/*     */   
/*     */   private static String getHeaderLineValue(String paramString) {
/* 330 */     return paramString.substring(paramString.indexOf(':') + 1).trim();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String adminShutdown() {
/* 335 */     stopNow();
/* 336 */     return super.adminShutdown();
/*     */   }
/*     */   
/*     */   private boolean allow() {
/* 340 */     if (this.server.getAllowOthers()) {
/* 341 */       return true;
/*     */     }
/*     */     try {
/* 344 */       return NetUtils.isLocalAddress(this.socket);
/* 345 */     } catch (UnknownHostException unknownHostException) {
/* 346 */       this.server.traceError(unknownHostException);
/* 347 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void trace(String paramString) {
/* 352 */     this.server.trace(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\WebThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */