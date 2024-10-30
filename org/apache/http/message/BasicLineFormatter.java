/*     */ package org.apache.http.message;
/*     */ 
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class BasicLineFormatter
/*     */   implements LineFormatter
/*     */ {
/*     */   @Deprecated
/*  64 */   public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
/*     */   
/*  66 */   public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharArrayBuffer initBuffer(CharArrayBuffer paramCharArrayBuffer) {
/*  81 */     CharArrayBuffer charArrayBuffer = paramCharArrayBuffer;
/*  82 */     if (charArrayBuffer != null) {
/*  83 */       charArrayBuffer.clear();
/*     */     } else {
/*  85 */       charArrayBuffer = new CharArrayBuffer(64);
/*     */     } 
/*  87 */     return charArrayBuffer;
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
/*     */   public static String formatProtocolVersion(ProtocolVersion paramProtocolVersion, LineFormatter paramLineFormatter) {
/* 104 */     return ((paramLineFormatter != null) ? paramLineFormatter : INSTANCE).appendProtocolVersion(null, paramProtocolVersion).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer appendProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ProtocolVersion paramProtocolVersion) {
/* 113 */     Args.notNull(paramProtocolVersion, "Protocol version");
/*     */     
/* 115 */     CharArrayBuffer charArrayBuffer = paramCharArrayBuffer;
/* 116 */     int i = estimateProtocolVersionLen(paramProtocolVersion);
/* 117 */     if (charArrayBuffer == null) {
/* 118 */       charArrayBuffer = new CharArrayBuffer(i);
/*     */     } else {
/* 120 */       charArrayBuffer.ensureCapacity(i);
/*     */     } 
/*     */     
/* 123 */     charArrayBuffer.append(paramProtocolVersion.getProtocol());
/* 124 */     charArrayBuffer.append('/');
/* 125 */     charArrayBuffer.append(Integer.toString(paramProtocolVersion.getMajor()));
/* 126 */     charArrayBuffer.append('.');
/* 127 */     charArrayBuffer.append(Integer.toString(paramProtocolVersion.getMinor()));
/*     */     
/* 129 */     return charArrayBuffer;
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
/*     */   protected int estimateProtocolVersionLen(ProtocolVersion paramProtocolVersion) {
/* 143 */     return paramProtocolVersion.getProtocol().length() + 4;
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
/*     */   public static String formatRequestLine(RequestLine paramRequestLine, LineFormatter paramLineFormatter) {
/* 159 */     return ((paramLineFormatter != null) ? paramLineFormatter : INSTANCE).formatRequestLine(null, paramRequestLine).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatRequestLine(CharArrayBuffer paramCharArrayBuffer, RequestLine paramRequestLine) {
/* 168 */     Args.notNull(paramRequestLine, "Request line");
/* 169 */     CharArrayBuffer charArrayBuffer = initBuffer(paramCharArrayBuffer);
/* 170 */     doFormatRequestLine(charArrayBuffer, paramRequestLine);
/*     */     
/* 172 */     return charArrayBuffer;
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
/*     */   protected void doFormatRequestLine(CharArrayBuffer paramCharArrayBuffer, RequestLine paramRequestLine) {
/* 186 */     String str1 = paramRequestLine.getMethod();
/* 187 */     String str2 = paramRequestLine.getUri();
/*     */ 
/*     */     
/* 190 */     int i = str1.length() + 1 + str2.length() + 1 + estimateProtocolVersionLen(paramRequestLine.getProtocolVersion());
/*     */     
/* 192 */     paramCharArrayBuffer.ensureCapacity(i);
/*     */     
/* 194 */     paramCharArrayBuffer.append(str1);
/* 195 */     paramCharArrayBuffer.append(' ');
/* 196 */     paramCharArrayBuffer.append(str2);
/* 197 */     paramCharArrayBuffer.append(' ');
/* 198 */     appendProtocolVersion(paramCharArrayBuffer, paramRequestLine.getProtocolVersion());
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
/*     */   public static String formatStatusLine(StatusLine paramStatusLine, LineFormatter paramLineFormatter) {
/* 215 */     return ((paramLineFormatter != null) ? paramLineFormatter : INSTANCE).formatStatusLine(null, paramStatusLine).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatStatusLine(CharArrayBuffer paramCharArrayBuffer, StatusLine paramStatusLine) {
/* 224 */     Args.notNull(paramStatusLine, "Status line");
/* 225 */     CharArrayBuffer charArrayBuffer = initBuffer(paramCharArrayBuffer);
/* 226 */     doFormatStatusLine(charArrayBuffer, paramStatusLine);
/*     */     
/* 228 */     return charArrayBuffer;
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
/*     */   protected void doFormatStatusLine(CharArrayBuffer paramCharArrayBuffer, StatusLine paramStatusLine) {
/* 243 */     int i = estimateProtocolVersionLen(paramStatusLine.getProtocolVersion()) + 1 + 3 + 1;
/*     */     
/* 245 */     String str = paramStatusLine.getReasonPhrase();
/* 246 */     if (str != null) {
/* 247 */       i += str.length();
/*     */     }
/* 249 */     paramCharArrayBuffer.ensureCapacity(i);
/*     */     
/* 251 */     appendProtocolVersion(paramCharArrayBuffer, paramStatusLine.getProtocolVersion());
/* 252 */     paramCharArrayBuffer.append(' ');
/* 253 */     paramCharArrayBuffer.append(Integer.toString(paramStatusLine.getStatusCode()));
/* 254 */     paramCharArrayBuffer.append(' ');
/* 255 */     if (str != null) {
/* 256 */       paramCharArrayBuffer.append(str);
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
/*     */   public static String formatHeader(Header paramHeader, LineFormatter paramLineFormatter) {
/* 273 */     return ((paramLineFormatter != null) ? paramLineFormatter : INSTANCE).formatHeader(null, paramHeader).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatHeader(CharArrayBuffer paramCharArrayBuffer, Header paramHeader) {
/*     */     CharArrayBuffer charArrayBuffer;
/* 282 */     Args.notNull(paramHeader, "Header");
/*     */ 
/*     */     
/* 285 */     if (paramHeader instanceof FormattedHeader) {
/*     */       
/* 287 */       charArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
/*     */     } else {
/* 289 */       charArrayBuffer = initBuffer(paramCharArrayBuffer);
/* 290 */       doFormatHeader(charArrayBuffer, paramHeader);
/*     */     } 
/* 292 */     return charArrayBuffer;
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
/*     */   protected void doFormatHeader(CharArrayBuffer paramCharArrayBuffer, Header paramHeader) {
/* 307 */     String str1 = paramHeader.getName();
/* 308 */     String str2 = paramHeader.getValue();
/*     */     
/* 310 */     int i = str1.length() + 2;
/* 311 */     if (str2 != null) {
/* 312 */       i += str2.length();
/*     */     }
/* 314 */     paramCharArrayBuffer.ensureCapacity(i);
/*     */     
/* 316 */     paramCharArrayBuffer.append(str1);
/* 317 */     paramCharArrayBuffer.append(": ");
/* 318 */     if (str2 != null) {
/* 319 */       paramCharArrayBuffer.ensureCapacity(paramCharArrayBuffer.length() + str2.length());
/* 320 */       for (byte b = 0; b < str2.length(); b++) {
/* 321 */         char c = str2.charAt(b);
/* 322 */         if (c == '\r' || c == '\n' || c == '\f' || c == '\013')
/*     */         {
/*     */ 
/*     */           
/* 326 */           c = ' ';
/*     */         }
/* 328 */         paramCharArrayBuffer.append(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicLineFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */