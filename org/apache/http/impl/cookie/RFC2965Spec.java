/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.Obsolete;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.ClientCookie;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookieRestrictionViolationException;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.message.BufferedHeader;
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
/*     */ @Obsolete
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class RFC2965Spec
/*     */   extends RFC2109Spec
/*     */ {
/*     */   public RFC2965Spec() {
/*  69 */     this((String[])null, false);
/*     */   }
/*     */   
/*     */   public RFC2965Spec(String[] paramArrayOfString, boolean paramBoolean) {
/*  73 */     super(paramBoolean, new CommonCookieAttributeHandler[] { new RFC2965VersionAttributeHandler(), new BasicPathHandler()
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             public void validate(Cookie param1Cookie, CookieOrigin param1CookieOrigin) throws MalformedCookieException
/*     */             {
/*  80 */               if (!match(param1Cookie, param1CookieOrigin)) {
/*  81 */                 throw new CookieRestrictionViolationException("Illegal 'path' attribute \"" + param1Cookie.getPath() + "\". Path of origin: \"" + param1CookieOrigin.getPath() + "\"");
/*     */               }
/*     */             }
/*     */           }, new RFC2965DomainAttributeHandler(), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new BasicExpiresHandler((paramArrayOfString != null) ? (String[])paramArrayOfString.clone() : DATE_PATTERNS), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler() });
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
/*     */   RFC2965Spec(boolean paramBoolean, CommonCookieAttributeHandler... paramVarArgs) {
/* 101 */     super(paramBoolean, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 108 */     Args.notNull(paramHeader, "Header");
/* 109 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 110 */     if (!paramHeader.getName().equalsIgnoreCase("Set-Cookie2")) {
/* 111 */       throw new MalformedCookieException("Unrecognized cookie header '" + paramHeader.toString() + "'");
/*     */     }
/*     */     
/* 114 */     HeaderElement[] arrayOfHeaderElement = paramHeader.getElements();
/* 115 */     return createCookies(arrayOfHeaderElement, adjustEffectiveHost(paramCookieOrigin));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Cookie> parse(HeaderElement[] paramArrayOfHeaderElement, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 122 */     return createCookies(paramArrayOfHeaderElement, adjustEffectiveHost(paramCookieOrigin));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Cookie> createCookies(HeaderElement[] paramArrayOfHeaderElement, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 128 */     ArrayList<BasicClientCookie2> arrayList = new ArrayList(paramArrayOfHeaderElement.length);
/* 129 */     for (HeaderElement headerElement : paramArrayOfHeaderElement) {
/* 130 */       String str1 = headerElement.getName();
/* 131 */       String str2 = headerElement.getValue();
/* 132 */       if (str1 == null || str1.isEmpty()) {
/* 133 */         throw new MalformedCookieException("Cookie name may not be empty");
/*     */       }
/*     */       
/* 136 */       BasicClientCookie2 basicClientCookie2 = new BasicClientCookie2(str1, str2);
/* 137 */       basicClientCookie2.setPath(getDefaultPath(paramCookieOrigin));
/* 138 */       basicClientCookie2.setDomain(getDefaultDomain(paramCookieOrigin));
/* 139 */       basicClientCookie2.setPorts(new int[] { paramCookieOrigin.getPort() });
/*     */       
/* 141 */       NameValuePair[] arrayOfNameValuePair = headerElement.getParameters();
/*     */ 
/*     */ 
/*     */       
/* 145 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>(arrayOfNameValuePair.length);
/*     */       
/* 147 */       for (int i = arrayOfNameValuePair.length - 1; i >= 0; i--) {
/* 148 */         NameValuePair nameValuePair = arrayOfNameValuePair[i];
/* 149 */         hashMap.put(nameValuePair.getName().toLowerCase(Locale.ROOT), nameValuePair);
/*     */       } 
/* 151 */       for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 152 */         NameValuePair nameValuePair = (NameValuePair)entry.getValue();
/* 153 */         String str = nameValuePair.getName().toLowerCase(Locale.ROOT);
/*     */         
/* 155 */         basicClientCookie2.setAttribute(str, nameValuePair.getValue());
/*     */         
/* 157 */         CookieAttributeHandler cookieAttributeHandler = findAttribHandler(str);
/* 158 */         if (cookieAttributeHandler != null) {
/* 159 */           cookieAttributeHandler.parse(basicClientCookie2, nameValuePair.getValue());
/*     */         }
/*     */       } 
/* 162 */       arrayList.add(basicClientCookie2);
/*     */     } 
/* 164 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 170 */     Args.notNull(paramCookie, "Cookie");
/* 171 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 172 */     super.validate(paramCookie, adjustEffectiveHost(paramCookieOrigin));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 177 */     Args.notNull(paramCookie, "Cookie");
/* 178 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 179 */     return super.match(paramCookie, adjustEffectiveHost(paramCookieOrigin));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void formatCookieAsVer(CharArrayBuffer paramCharArrayBuffer, Cookie paramCookie, int paramInt) {
/* 188 */     super.formatCookieAsVer(paramCharArrayBuffer, paramCookie, paramInt);
/*     */     
/* 190 */     if (paramCookie instanceof ClientCookie) {
/*     */       
/* 192 */       String str = ((ClientCookie)paramCookie).getAttribute("port");
/* 193 */       if (str != null) {
/* 194 */         paramCharArrayBuffer.append("; $Port");
/* 195 */         paramCharArrayBuffer.append("=\"");
/* 196 */         if (!str.trim().isEmpty()) {
/* 197 */           int[] arrayOfInt = paramCookie.getPorts();
/* 198 */           if (arrayOfInt != null) {
/* 199 */             int i = arrayOfInt.length;
/* 200 */             for (byte b = 0; b < i; b++) {
/* 201 */               if (b > 0) {
/* 202 */                 paramCharArrayBuffer.append(",");
/*     */               }
/* 204 */               paramCharArrayBuffer.append(Integer.toString(arrayOfInt[b]));
/*     */             } 
/*     */           } 
/*     */         } 
/* 208 */         paramCharArrayBuffer.append("\"");
/*     */       } 
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
/*     */   private static CookieOrigin adjustEffectiveHost(CookieOrigin paramCookieOrigin) {
/* 224 */     String str = paramCookieOrigin.getHost();
/*     */ 
/*     */ 
/*     */     
/* 228 */     boolean bool = true;
/* 229 */     for (byte b = 0; b < str.length(); b++) {
/* 230 */       char c = str.charAt(b);
/* 231 */       if (c == '.' || c == ':') {
/* 232 */         bool = false;
/*     */         break;
/*     */       } 
/*     */     } 
/* 236 */     return bool ? new CookieOrigin(str + ".local", paramCookieOrigin.getPort(), paramCookieOrigin.getPath(), paramCookieOrigin.isSecure()) : paramCookieOrigin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 247 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getVersionHeader() {
/* 252 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40);
/* 253 */     charArrayBuffer.append("Cookie2");
/* 254 */     charArrayBuffer.append(": ");
/* 255 */     charArrayBuffer.append("$Version=");
/* 256 */     charArrayBuffer.append(Integer.toString(getVersion()));
/* 257 */     return (Header)new BufferedHeader(charArrayBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 262 */     return "rfc2965";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965Spec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */