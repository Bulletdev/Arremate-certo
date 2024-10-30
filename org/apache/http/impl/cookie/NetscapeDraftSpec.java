/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.Obsolete;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.message.BufferedHeader;
/*     */ import org.apache.http.message.ParserCursor;
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
/*     */ @Obsolete
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class NetscapeDraftSpec
/*     */   extends CookieSpecBase
/*     */ {
/*     */   protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yy HH:mm:ss z";
/*     */   
/*     */   public NetscapeDraftSpec(String[] paramArrayOfString) {
/*  68 */     super(new CommonCookieAttributeHandler[] { null, null, null, null, new BasicExpiresHandler((paramArrayOfString != null) ? (String[])paramArrayOfString.clone() : new String[1]) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NetscapeDraftSpec(CommonCookieAttributeHandler... paramVarArgs) {
/*  77 */     super(paramVarArgs);
/*     */   }
/*     */   
/*     */   public NetscapeDraftSpec() {
/*  81 */     this((String[])null);
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
/*     */   public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*     */     CharArrayBuffer charArrayBuffer;
/*     */     ParserCursor parserCursor;
/* 111 */     Args.notNull(paramHeader, "Header");
/* 112 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 113 */     if (!paramHeader.getName().equalsIgnoreCase("Set-Cookie")) {
/* 114 */       throw new MalformedCookieException("Unrecognized cookie header '" + paramHeader.toString() + "'");
/*     */     }
/*     */     
/* 117 */     NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
/*     */ 
/*     */     
/* 120 */     if (paramHeader instanceof FormattedHeader) {
/* 121 */       charArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
/* 122 */       parserCursor = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), charArrayBuffer.length());
/*     */     }
/*     */     else {
/*     */       
/* 126 */       String str = paramHeader.getValue();
/* 127 */       if (str == null) {
/* 128 */         throw new MalformedCookieException("Header value is null");
/*     */       }
/* 130 */       charArrayBuffer = new CharArrayBuffer(str.length());
/* 131 */       charArrayBuffer.append(str);
/* 132 */       parserCursor = new ParserCursor(0, charArrayBuffer.length());
/*     */     } 
/* 134 */     return parse(new HeaderElement[] { netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor) }paramCookieOrigin);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Header> formatCookies(List<Cookie> paramList) {
/* 139 */     Args.notEmpty(paramList, "List of cookies");
/* 140 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(20 * paramList.size());
/* 141 */     charArrayBuffer.append("Cookie");
/* 142 */     charArrayBuffer.append(": ");
/* 143 */     for (byte b = 0; b < paramList.size(); b++) {
/* 144 */       Cookie cookie = paramList.get(b);
/* 145 */       if (b > 0) {
/* 146 */         charArrayBuffer.append("; ");
/*     */       }
/* 148 */       charArrayBuffer.append(cookie.getName());
/* 149 */       String str = cookie.getValue();
/* 150 */       if (str != null) {
/* 151 */         charArrayBuffer.append("=");
/* 152 */         charArrayBuffer.append(str);
/*     */       } 
/*     */     } 
/* 155 */     ArrayList<BufferedHeader> arrayList = new ArrayList(1);
/* 156 */     arrayList.add(new BufferedHeader(charArrayBuffer));
/* 157 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 162 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getVersionHeader() {
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 172 */     return "netscape";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\NetscapeDraftSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */