/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.Obsolete;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.ClientCookie;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookiePathComparator;
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
/*     */ @Obsolete
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class RFC2109Spec
/*     */   extends CookieSpecBase
/*     */ {
/*  64 */   static final String[] DATE_PATTERNS = new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean oneHeader;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RFC2109Spec(String[] paramArrayOfString, boolean paramBoolean) {
/*  74 */     super(new CommonCookieAttributeHandler[] { new RFC2109VersionHandler(), new BasicPathHandler()
/*     */           {
/*     */ 
/*     */             
/*     */             public void validate(Cookie param1Cookie, CookieOrigin param1CookieOrigin) throws MalformedCookieException
/*     */             {
/*  80 */               if (!match(param1Cookie, param1CookieOrigin)) {
/*  81 */                 throw new CookieRestrictionViolationException("Illegal 'path' attribute \"" + param1Cookie.getPath() + "\". Path of origin: \"" + param1CookieOrigin.getPath() + "\"");
/*     */               }
/*     */             }
/*     */           }, new RFC2109DomainHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new BasicExpiresHandler((paramArrayOfString != null) ? (String[])paramArrayOfString.clone() : DATE_PATTERNS) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     this.oneHeader = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public RFC2109Spec() {
/*  99 */     this((String[])null, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected RFC2109Spec(boolean paramBoolean, CommonCookieAttributeHandler... paramVarArgs) {
/* 104 */     super(paramVarArgs);
/* 105 */     this.oneHeader = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 111 */     Args.notNull(paramHeader, "Header");
/* 112 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 113 */     if (!paramHeader.getName().equalsIgnoreCase("Set-Cookie")) {
/* 114 */       throw new MalformedCookieException("Unrecognized cookie header '" + paramHeader.toString() + "'");
/*     */     }
/*     */     
/* 117 */     HeaderElement[] arrayOfHeaderElement = paramHeader.getElements();
/* 118 */     return parse(arrayOfHeaderElement, paramCookieOrigin);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 124 */     Args.notNull(paramCookie, "Cookie");
/* 125 */     String str = paramCookie.getName();
/* 126 */     if (str.indexOf(' ') != -1) {
/* 127 */       throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
/*     */     }
/* 129 */     if (str.startsWith("$")) {
/* 130 */       throw new CookieRestrictionViolationException("Cookie name may not start with $");
/*     */     }
/* 132 */     super.validate(paramCookie, paramCookieOrigin);
/*     */   }
/*     */   
/*     */   public List<Header> formatCookies(List<Cookie> paramList) {
/*     */     List<Cookie> list;
/* 137 */     Args.notEmpty(paramList, "List of cookies");
/*     */     
/* 139 */     if (paramList.size() > 1) {
/*     */       
/* 141 */       list = new ArrayList<Cookie>(paramList);
/* 142 */       Collections.sort(list, (Comparator<? super Cookie>)CookiePathComparator.INSTANCE);
/*     */     } else {
/* 144 */       list = paramList;
/*     */     } 
/* 146 */     return this.oneHeader ? doFormatOneHeader(list) : doFormatManyHeaders(list);
/*     */   }
/*     */   
/*     */   private List<Header> doFormatOneHeader(List<Cookie> paramList) {
/* 150 */     int i = Integer.MAX_VALUE;
/*     */     
/* 152 */     for (Cookie cookie : paramList) {
/* 153 */       if (cookie.getVersion() < i) {
/* 154 */         i = cookie.getVersion();
/*     */       }
/*     */     } 
/* 157 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40 * paramList.size());
/* 158 */     charArrayBuffer.append("Cookie");
/* 159 */     charArrayBuffer.append(": ");
/* 160 */     charArrayBuffer.append("$Version=");
/* 161 */     charArrayBuffer.append(Integer.toString(i));
/* 162 */     for (Cookie cookie1 : paramList) {
/* 163 */       charArrayBuffer.append("; ");
/* 164 */       Cookie cookie2 = cookie1;
/* 165 */       formatCookieAsVer(charArrayBuffer, cookie2, i);
/*     */     } 
/* 167 */     ArrayList<BufferedHeader> arrayList = new ArrayList(1);
/* 168 */     arrayList.add(new BufferedHeader(charArrayBuffer));
/* 169 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private List<Header> doFormatManyHeaders(List<Cookie> paramList) {
/* 173 */     ArrayList<BufferedHeader> arrayList = new ArrayList(paramList.size());
/* 174 */     for (Cookie cookie : paramList) {
/* 175 */       int i = cookie.getVersion();
/* 176 */       CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40);
/* 177 */       charArrayBuffer.append("Cookie: ");
/* 178 */       charArrayBuffer.append("$Version=");
/* 179 */       charArrayBuffer.append(Integer.toString(i));
/* 180 */       charArrayBuffer.append("; ");
/* 181 */       formatCookieAsVer(charArrayBuffer, cookie, i);
/* 182 */       arrayList.add(new BufferedHeader(charArrayBuffer));
/*     */     } 
/* 184 */     return (List)arrayList;
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
/*     */   protected void formatParamAsVer(CharArrayBuffer paramCharArrayBuffer, String paramString1, String paramString2, int paramInt) {
/* 198 */     paramCharArrayBuffer.append(paramString1);
/* 199 */     paramCharArrayBuffer.append("=");
/* 200 */     if (paramString2 != null) {
/* 201 */       if (paramInt > 0) {
/* 202 */         paramCharArrayBuffer.append('"');
/* 203 */         paramCharArrayBuffer.append(paramString2);
/* 204 */         paramCharArrayBuffer.append('"');
/*     */       } else {
/* 206 */         paramCharArrayBuffer.append(paramString2);
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
/*     */   protected void formatCookieAsVer(CharArrayBuffer paramCharArrayBuffer, Cookie paramCookie, int paramInt) {
/* 220 */     formatParamAsVer(paramCharArrayBuffer, paramCookie.getName(), paramCookie.getValue(), paramInt);
/* 221 */     if (paramCookie.getPath() != null && 
/* 222 */       paramCookie instanceof ClientCookie && ((ClientCookie)paramCookie).containsAttribute("path")) {
/*     */       
/* 224 */       paramCharArrayBuffer.append("; ");
/* 225 */       formatParamAsVer(paramCharArrayBuffer, "$Path", paramCookie.getPath(), paramInt);
/*     */     } 
/*     */     
/* 228 */     if (paramCookie.getDomain() != null && 
/* 229 */       paramCookie instanceof ClientCookie && ((ClientCookie)paramCookie).containsAttribute("domain")) {
/*     */       
/* 231 */       paramCharArrayBuffer.append("; ");
/* 232 */       formatParamAsVer(paramCharArrayBuffer, "$Domain", paramCookie.getDomain(), paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 239 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getVersionHeader() {
/* 244 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 249 */     return "rfc2109";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2109Spec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */