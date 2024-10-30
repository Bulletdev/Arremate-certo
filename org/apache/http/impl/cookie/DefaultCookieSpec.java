/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieSpec;
/*     */ import org.apache.http.cookie.MalformedCookieException;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class DefaultCookieSpec
/*     */   implements CookieSpec
/*     */ {
/*     */   private final RFC2965Spec strict;
/*     */   private final RFC2109Spec obsoleteStrict;
/*     */   private final NetscapeDraftSpec netscapeDraft;
/*     */   
/*     */   DefaultCookieSpec(RFC2965Spec paramRFC2965Spec, RFC2109Spec paramRFC2109Spec, NetscapeDraftSpec paramNetscapeDraftSpec) {
/*  64 */     this.strict = paramRFC2965Spec;
/*  65 */     this.obsoleteStrict = paramRFC2109Spec;
/*  66 */     this.netscapeDraft = paramNetscapeDraftSpec;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultCookieSpec(String[] paramArrayOfString, boolean paramBoolean) {
/*  72 */     this.strict = new RFC2965Spec(paramBoolean, new CommonCookieAttributeHandler[] { new RFC2965VersionAttributeHandler(), new BasicPathHandler(), new RFC2965DomainAttributeHandler(), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.obsoleteStrict = new RFC2109Spec(paramBoolean, new CommonCookieAttributeHandler[] { new RFC2109VersionHandler(), new BasicPathHandler(), new RFC2109DomainHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     (new CommonCookieAttributeHandler[5])[0] = new BasicDomainHandler(); (new CommonCookieAttributeHandler[5])[1] = new BasicPathHandler(); (new CommonCookieAttributeHandler[5])[2] = new BasicSecureHandler(); (new CommonCookieAttributeHandler[5])[3] = new BasicCommentHandler(); (new String[1])[0] = "EEE, dd-MMM-yy HH:mm:ss z"; this.netscapeDraft = new NetscapeDraftSpec(new CommonCookieAttributeHandler[] { null, null, null, null, new BasicExpiresHandler((paramArrayOfString != null) ? (String[])paramArrayOfString.clone() : new String[1]) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultCookieSpec() {
/*  99 */     this(null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 106 */     Args.notNull(paramHeader, "Header");
/* 107 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 108 */     HeaderElement[] arrayOfHeaderElement = paramHeader.getElements();
/* 109 */     boolean bool1 = false;
/* 110 */     boolean bool2 = false;
/* 111 */     for (HeaderElement headerElement : arrayOfHeaderElement) {
/* 112 */       if (headerElement.getParameterByName("version") != null) {
/* 113 */         bool1 = true;
/*     */       }
/* 115 */       if (headerElement.getParameterByName("expires") != null) {
/* 116 */         bool2 = true;
/*     */       }
/*     */     } 
/* 119 */     if (bool2 || !bool1) {
/*     */       CharArrayBuffer charArrayBuffer;
/*     */       ParserCursor parserCursor;
/* 122 */       NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
/*     */ 
/*     */       
/* 125 */       if (paramHeader instanceof FormattedHeader) {
/* 126 */         charArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
/* 127 */         parserCursor = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), charArrayBuffer.length());
/*     */       }
/*     */       else {
/*     */         
/* 131 */         String str = paramHeader.getValue();
/* 132 */         if (str == null) {
/* 133 */           throw new MalformedCookieException("Header value is null");
/*     */         }
/* 135 */         charArrayBuffer = new CharArrayBuffer(str.length());
/* 136 */         charArrayBuffer.append(str);
/* 137 */         parserCursor = new ParserCursor(0, charArrayBuffer.length());
/*     */       } 
/* 139 */       arrayOfHeaderElement = new HeaderElement[] { netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor) };
/* 140 */       return this.netscapeDraft.parse(arrayOfHeaderElement, paramCookieOrigin);
/*     */     } 
/* 142 */     return "Set-Cookie2".equals(paramHeader.getName()) ? this.strict.parse(arrayOfHeaderElement, paramCookieOrigin) : this.obsoleteStrict.parse(arrayOfHeaderElement, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 151 */     Args.notNull(paramCookie, "Cookie");
/* 152 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 153 */     if (paramCookie.getVersion() > 0) {
/* 154 */       if (paramCookie instanceof org.apache.http.cookie.SetCookie2) {
/* 155 */         this.strict.validate(paramCookie, paramCookieOrigin);
/*     */       } else {
/* 157 */         this.obsoleteStrict.validate(paramCookie, paramCookieOrigin);
/*     */       } 
/*     */     } else {
/* 160 */       this.netscapeDraft.validate(paramCookie, paramCookieOrigin);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 166 */     Args.notNull(paramCookie, "Cookie");
/* 167 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 168 */     if (paramCookie.getVersion() > 0) {
/* 169 */       return (paramCookie instanceof org.apache.http.cookie.SetCookie2) ? this.strict.match(paramCookie, paramCookieOrigin) : this.obsoleteStrict.match(paramCookie, paramCookieOrigin);
/*     */     }
/*     */ 
/*     */     
/* 173 */     return this.netscapeDraft.match(paramCookie, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Header> formatCookies(List<Cookie> paramList) {
/* 178 */     Args.notNull(paramList, "List of cookies");
/* 179 */     int i = Integer.MAX_VALUE;
/* 180 */     boolean bool = true;
/* 181 */     for (Cookie cookie : paramList) {
/* 182 */       if (!(cookie instanceof org.apache.http.cookie.SetCookie2)) {
/* 183 */         bool = false;
/*     */       }
/* 185 */       if (cookie.getVersion() < i) {
/* 186 */         i = cookie.getVersion();
/*     */       }
/*     */     } 
/* 189 */     if (i > 0) {
/* 190 */       return bool ? this.strict.formatCookies(paramList) : this.obsoleteStrict.formatCookies(paramList);
/*     */     }
/*     */ 
/*     */     
/* 194 */     return this.netscapeDraft.formatCookies(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 199 */     return this.strict.getVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getVersionHeader() {
/* 204 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 209 */     return "default";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\DefaultCookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */