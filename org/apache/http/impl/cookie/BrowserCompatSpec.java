/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.message.BasicHeaderElement;
/*     */ import org.apache.http.message.BasicHeaderValueFormatter;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class BrowserCompatSpec
/*     */   extends CookieSpecBase
/*     */ {
/*  69 */   private static final String[] DEFAULT_DATE_PATTERNS = new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BrowserCompatSpec(String[] paramArrayOfString, BrowserCompatSpecFactory.SecurityLevel paramSecurityLevel) {
/*  88 */     super(new CommonCookieAttributeHandler[] { new BrowserCompatVersionAttributeHandler(), new BasicDomainHandler(), (paramSecurityLevel == BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_IE_MEDIUM) ? new BasicPathHandler() { public void validate(Cookie param1Cookie, CookieOrigin param1CookieOrigin) throws MalformedCookieException {} } : new BasicPathHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new BasicExpiresHandler((paramArrayOfString != null) ? (String[])paramArrayOfString.clone() : DEFAULT_DATE_PATTERNS) });
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
/*     */   public BrowserCompatSpec(String[] paramArrayOfString) {
/* 105 */     this(paramArrayOfString, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
/*     */   }
/*     */ 
/*     */   
/*     */   public BrowserCompatSpec() {
/* 110 */     this((String[])null, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 116 */     Args.notNull(paramHeader, "Header");
/* 117 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 118 */     String str = paramHeader.getName();
/* 119 */     if (!str.equalsIgnoreCase("Set-Cookie")) {
/* 120 */       throw new MalformedCookieException("Unrecognized cookie header '" + paramHeader.toString() + "'");
/*     */     }
/*     */     
/* 123 */     HeaderElement[] arrayOfHeaderElement = paramHeader.getElements();
/* 124 */     boolean bool1 = false;
/* 125 */     boolean bool2 = false;
/* 126 */     for (HeaderElement headerElement : arrayOfHeaderElement) {
/* 127 */       if (headerElement.getParameterByName("version") != null) {
/* 128 */         bool1 = true;
/*     */       }
/* 130 */       if (headerElement.getParameterByName("expires") != null) {
/* 131 */         bool2 = true;
/*     */       }
/*     */     } 
/* 134 */     if (bool2 || !bool1) {
/*     */       CharArrayBuffer charArrayBuffer;
/*     */       ParserCursor parserCursor;
/* 137 */       NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
/*     */ 
/*     */       
/* 140 */       if (paramHeader instanceof FormattedHeader) {
/* 141 */         charArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
/* 142 */         parserCursor = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), charArrayBuffer.length());
/*     */       }
/*     */       else {
/*     */         
/* 146 */         String str3 = paramHeader.getValue();
/* 147 */         if (str3 == null) {
/* 148 */           throw new MalformedCookieException("Header value is null");
/*     */         }
/* 150 */         charArrayBuffer = new CharArrayBuffer(str3.length());
/* 151 */         charArrayBuffer.append(str3);
/* 152 */         parserCursor = new ParserCursor(0, charArrayBuffer.length());
/*     */       } 
/* 154 */       HeaderElement headerElement = netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor);
/* 155 */       String str1 = headerElement.getName();
/* 156 */       String str2 = headerElement.getValue();
/* 157 */       if (str1 == null || str1.isEmpty()) {
/* 158 */         throw new MalformedCookieException("Cookie name may not be empty");
/*     */       }
/* 160 */       BasicClientCookie basicClientCookie = new BasicClientCookie(str1, str2);
/* 161 */       basicClientCookie.setPath(getDefaultPath(paramCookieOrigin));
/* 162 */       basicClientCookie.setDomain(getDefaultDomain(paramCookieOrigin));
/*     */ 
/*     */       
/* 165 */       NameValuePair[] arrayOfNameValuePair = headerElement.getParameters();
/* 166 */       for (int i = arrayOfNameValuePair.length - 1; i >= 0; i--) {
/* 167 */         NameValuePair nameValuePair = arrayOfNameValuePair[i];
/* 168 */         String str3 = nameValuePair.getName().toLowerCase(Locale.ROOT);
/* 169 */         basicClientCookie.setAttribute(str3, nameValuePair.getValue());
/* 170 */         CookieAttributeHandler cookieAttributeHandler = findAttribHandler(str3);
/* 171 */         if (cookieAttributeHandler != null) {
/* 172 */           cookieAttributeHandler.parse(basicClientCookie, nameValuePair.getValue());
/*     */         }
/*     */       } 
/*     */       
/* 176 */       if (bool2) {
/* 177 */         basicClientCookie.setVersion(0);
/*     */       }
/* 179 */       return (List)Collections.singletonList(basicClientCookie);
/*     */     } 
/* 181 */     return parse(arrayOfHeaderElement, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isQuoteEnclosed(String paramString) {
/* 186 */     return (paramString != null && paramString.startsWith("\"") && paramString.endsWith("\""));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Header> formatCookies(List<Cookie> paramList) {
/* 191 */     Args.notEmpty(paramList, "List of cookies");
/* 192 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(20 * paramList.size());
/* 193 */     charArrayBuffer.append("Cookie");
/* 194 */     charArrayBuffer.append(": ");
/* 195 */     for (byte b = 0; b < paramList.size(); b++) {
/* 196 */       Cookie cookie = paramList.get(b);
/* 197 */       if (b > 0) {
/* 198 */         charArrayBuffer.append("; ");
/*     */       }
/* 200 */       String str1 = cookie.getName();
/* 201 */       String str2 = cookie.getValue();
/* 202 */       if (cookie.getVersion() > 0 && !isQuoteEnclosed(str2)) {
/* 203 */         BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(charArrayBuffer, (HeaderElement)new BasicHeaderElement(str1, str2), false);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 209 */         charArrayBuffer.append(str1);
/* 210 */         charArrayBuffer.append("=");
/* 211 */         if (str2 != null) {
/* 212 */           charArrayBuffer.append(str2);
/*     */         }
/*     */       } 
/*     */     } 
/* 216 */     ArrayList<BufferedHeader> arrayList = new ArrayList(1);
/* 217 */     arrayList.add(new BufferedHeader(charArrayBuffer));
/* 218 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 223 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getVersionHeader() {
/* 228 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 233 */     return "compatibility";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BrowserCompatSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */