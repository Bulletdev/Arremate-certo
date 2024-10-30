/*     */ package org.apache.http.message;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class BasicLineParser
/*     */   implements LineParser
/*     */ {
/*     */   @Deprecated
/*  72 */   public static final BasicLineParser DEFAULT = new BasicLineParser();
/*     */   
/*  74 */   public static final BasicLineParser INSTANCE = new BasicLineParser();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ProtocolVersion protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicLineParser(ProtocolVersion paramProtocolVersion) {
/*  91 */     this.protocol = (paramProtocolVersion != null) ? paramProtocolVersion : (ProtocolVersion)HttpVersion.HTTP_1_1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicLineParser() {
/*  99 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ProtocolVersion parseProtocolVersion(String paramString, LineParser paramLineParser) throws ParseException {
/* 106 */     Args.notNull(paramString, "Value");
/*     */     
/* 108 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 109 */     charArrayBuffer.append(paramString);
/* 110 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 111 */     return ((paramLineParser != null) ? paramLineParser : INSTANCE).parseProtocolVersion(charArrayBuffer, parserCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProtocolVersion parseProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException {
/*     */     int i1, i3;
/* 120 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 121 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 122 */     String str = this.protocol.getProtocol();
/* 123 */     int i = str.length();
/*     */     
/* 125 */     int j = paramParserCursor.getPos();
/* 126 */     int k = paramParserCursor.getUpperBound();
/*     */     
/* 128 */     skipWhitespace(paramCharArrayBuffer, paramParserCursor);
/*     */     
/* 130 */     int m = paramParserCursor.getPos();
/*     */ 
/*     */     
/* 133 */     if (m + i + 4 > k) {
/* 134 */       throw new ParseException("Not a valid protocol version: " + paramCharArrayBuffer.substring(j, k));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     boolean bool = true; int n;
/* 141 */     for (n = 0; bool && n < i; n++) {
/* 142 */       bool = (paramCharArrayBuffer.charAt(m + n) == str.charAt(n)) ? true : false;
/*     */     }
/* 144 */     if (bool) {
/* 145 */       bool = (paramCharArrayBuffer.charAt(m + i) == '/') ? true : false;
/*     */     }
/* 147 */     if (!bool) {
/* 148 */       throw new ParseException("Not a valid protocol version: " + paramCharArrayBuffer.substring(j, k));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 153 */     m += i + 1;
/*     */     
/* 155 */     n = paramCharArrayBuffer.indexOf(46, m, k);
/* 156 */     if (n == -1) {
/* 157 */       throw new ParseException("Invalid protocol version number: " + paramCharArrayBuffer.substring(j, k));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 163 */       i1 = Integer.parseInt(paramCharArrayBuffer.substringTrimmed(m, n));
/* 164 */     } catch (NumberFormatException numberFormatException) {
/* 165 */       throw new ParseException("Invalid protocol major version number: " + paramCharArrayBuffer.substring(j, k));
/*     */     } 
/*     */ 
/*     */     
/* 169 */     m = n + 1;
/*     */     
/* 171 */     int i2 = paramCharArrayBuffer.indexOf(32, m, k);
/* 172 */     if (i2 == -1) {
/* 173 */       i2 = k;
/*     */     }
/*     */     
/*     */     try {
/* 177 */       i3 = Integer.parseInt(paramCharArrayBuffer.substringTrimmed(m, i2));
/* 178 */     } catch (NumberFormatException numberFormatException) {
/* 179 */       throw new ParseException("Invalid protocol minor version number: " + paramCharArrayBuffer.substring(j, k));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 184 */     paramParserCursor.updatePos(i2);
/*     */     
/* 186 */     return createProtocolVersion(i1, i3);
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
/*     */   protected ProtocolVersion createProtocolVersion(int paramInt1, int paramInt2) {
/* 201 */     return this.protocol.forVersion(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 210 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 211 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 212 */     int i = paramParserCursor.getPos();
/*     */     
/* 214 */     String str = this.protocol.getProtocol();
/* 215 */     int j = str.length();
/*     */     
/* 217 */     if (paramCharArrayBuffer.length() < j + 4)
/*     */     {
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     if (i < 0) {
/*     */ 
/*     */       
/* 225 */       i = paramCharArrayBuffer.length() - 4 - j;
/* 226 */     } else if (i == 0) {
/*     */       
/* 228 */       while (i < paramCharArrayBuffer.length() && HTTP.isWhitespace(paramCharArrayBuffer.charAt(i)))
/*     */       {
/* 230 */         i++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 235 */     if (i + j + 4 > paramCharArrayBuffer.length()) {
/* 236 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 241 */     boolean bool = true;
/* 242 */     for (byte b = 0; bool && b < j; b++) {
/* 243 */       bool = (paramCharArrayBuffer.charAt(i + b) == str.charAt(b)) ? true : false;
/*     */     }
/* 245 */     if (bool) {
/* 246 */       bool = (paramCharArrayBuffer.charAt(i + j) == '/') ? true : false;
/*     */     }
/*     */     
/* 249 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RequestLine parseRequestLine(String paramString, LineParser paramLineParser) throws ParseException {
/* 257 */     Args.notNull(paramString, "Value");
/*     */     
/* 259 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 260 */     charArrayBuffer.append(paramString);
/* 261 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 262 */     return ((paramLineParser != null) ? paramLineParser : INSTANCE).parseRequestLine(charArrayBuffer, parserCursor);
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
/*     */   public RequestLine parseRequestLine(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException {
/* 280 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 281 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 282 */     int i = paramParserCursor.getPos();
/* 283 */     int j = paramParserCursor.getUpperBound();
/*     */     
/*     */     try {
/* 286 */       skipWhitespace(paramCharArrayBuffer, paramParserCursor);
/* 287 */       int k = paramParserCursor.getPos();
/*     */       
/* 289 */       int m = paramCharArrayBuffer.indexOf(32, k, j);
/* 290 */       if (m < 0) {
/* 291 */         throw new ParseException("Invalid request line: " + paramCharArrayBuffer.substring(i, j));
/*     */       }
/*     */       
/* 294 */       String str1 = paramCharArrayBuffer.substringTrimmed(k, m);
/* 295 */       paramParserCursor.updatePos(m);
/*     */       
/* 297 */       skipWhitespace(paramCharArrayBuffer, paramParserCursor);
/* 298 */       k = paramParserCursor.getPos();
/*     */       
/* 300 */       m = paramCharArrayBuffer.indexOf(32, k, j);
/* 301 */       if (m < 0) {
/* 302 */         throw new ParseException("Invalid request line: " + paramCharArrayBuffer.substring(i, j));
/*     */       }
/*     */       
/* 305 */       String str2 = paramCharArrayBuffer.substringTrimmed(k, m);
/* 306 */       paramParserCursor.updatePos(m);
/*     */       
/* 308 */       ProtocolVersion protocolVersion = parseProtocolVersion(paramCharArrayBuffer, paramParserCursor);
/*     */       
/* 310 */       skipWhitespace(paramCharArrayBuffer, paramParserCursor);
/* 311 */       if (!paramParserCursor.atEnd()) {
/* 312 */         throw new ParseException("Invalid request line: " + paramCharArrayBuffer.substring(i, j));
/*     */       }
/*     */ 
/*     */       
/* 316 */       return createRequestLine(str1, str2, protocolVersion);
/* 317 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 318 */       throw new ParseException("Invalid request line: " + paramCharArrayBuffer.substring(i, j));
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
/*     */ 
/*     */   
/*     */   protected RequestLine createRequestLine(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion) {
/* 337 */     return new BasicRequestLine(paramString1, paramString2, paramProtocolVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatusLine parseStatusLine(String paramString, LineParser paramLineParser) throws ParseException {
/* 345 */     Args.notNull(paramString, "Value");
/*     */     
/* 347 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 348 */     charArrayBuffer.append(paramString);
/* 349 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 350 */     return ((paramLineParser != null) ? paramLineParser : INSTANCE).parseStatusLine(charArrayBuffer, parserCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatusLine parseStatusLine(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException {
/* 359 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 360 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 361 */     int i = paramParserCursor.getPos();
/* 362 */     int j = paramParserCursor.getUpperBound();
/*     */     try {
/*     */       int n;
/*     */       String str2;
/* 366 */       ProtocolVersion protocolVersion = parseProtocolVersion(paramCharArrayBuffer, paramParserCursor);
/*     */ 
/*     */       
/* 369 */       skipWhitespace(paramCharArrayBuffer, paramParserCursor);
/* 370 */       int k = paramParserCursor.getPos();
/*     */       
/* 372 */       int m = paramCharArrayBuffer.indexOf(32, k, j);
/* 373 */       if (m < 0) {
/* 374 */         m = j;
/*     */       }
/*     */       
/* 377 */       String str1 = paramCharArrayBuffer.substringTrimmed(k, m);
/* 378 */       for (byte b = 0; b < str1.length(); b++) {
/* 379 */         if (!Character.isDigit(str1.charAt(b))) {
/* 380 */           throw new ParseException("Status line contains invalid status code: " + paramCharArrayBuffer.substring(i, j));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 386 */         n = Integer.parseInt(str1);
/* 387 */       } catch (NumberFormatException numberFormatException) {
/* 388 */         throw new ParseException("Status line contains invalid status code: " + paramCharArrayBuffer.substring(i, j));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 393 */       k = m;
/*     */       
/* 395 */       if (k < j) {
/* 396 */         str2 = paramCharArrayBuffer.substringTrimmed(k, j);
/*     */       } else {
/* 398 */         str2 = "";
/*     */       } 
/* 400 */       return createStatusLine(protocolVersion, n, str2);
/*     */     }
/* 402 */     catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 403 */       throw new ParseException("Invalid status line: " + paramCharArrayBuffer.substring(i, j));
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
/*     */ 
/*     */   
/*     */   protected StatusLine createStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString) {
/* 422 */     return new BasicStatusLine(paramProtocolVersion, paramInt, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Header parseHeader(String paramString, LineParser paramLineParser) throws ParseException {
/* 430 */     Args.notNull(paramString, "Value");
/*     */     
/* 432 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 433 */     charArrayBuffer.append(paramString);
/* 434 */     return ((paramLineParser != null) ? paramLineParser : INSTANCE).parseHeader(charArrayBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header parseHeader(CharArrayBuffer paramCharArrayBuffer) throws ParseException {
/* 445 */     return (Header)new BufferedHeader(paramCharArrayBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void skipWhitespace(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 453 */     int i = paramParserCursor.getPos();
/* 454 */     int j = paramParserCursor.getUpperBound();
/* 455 */     while (i < j && HTTP.isWhitespace(paramCharArrayBuffer.charAt(i)))
/*     */     {
/* 457 */       i++;
/*     */     }
/* 459 */     paramParserCursor.updatePos(i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicLineParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */