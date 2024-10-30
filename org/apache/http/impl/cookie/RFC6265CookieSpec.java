/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieOrigin;
/*     */ import org.apache.http.cookie.CookiePriorityComparator;
/*     */ import org.apache.http.cookie.CookieSpec;
/*     */ import org.apache.http.cookie.MalformedCookieException;
/*     */ import org.apache.http.message.BufferedHeader;
/*     */ import org.apache.http.message.ParserCursor;
/*     */ import org.apache.http.message.TokenParser;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class RFC6265CookieSpec
/*     */   implements CookieSpec
/*     */ {
/*     */   private static final char PARAM_DELIMITER = ';';
/*     */   private static final char COMMA_CHAR = ',';
/*     */   private static final char EQUAL_CHAR = '=';
/*     */   private static final char DQUOTE_CHAR = '"';
/*     */   private static final char ESCAPE_CHAR = '\\';
/*  75 */   private static final BitSet TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[] { 61, 59 });
/*  76 */   private static final BitSet VALUE_DELIMS = TokenParser.INIT_BITSET(new int[] { 59 });
/*  77 */   private static final BitSet SPECIAL_CHARS = TokenParser.INIT_BITSET(new int[] { 32, 34, 44, 59, 92 });
/*     */   
/*     */   private final CookieAttributeHandler[] attribHandlers;
/*     */   
/*     */   private final Map<String, CookieAttributeHandler> attribHandlerMap;
/*     */   
/*     */   private final TokenParser tokenParser;
/*     */   
/*     */   protected RFC6265CookieSpec(CommonCookieAttributeHandler... paramVarArgs) {
/*  86 */     this.attribHandlers = (CookieAttributeHandler[])paramVarArgs.clone();
/*  87 */     this.attribHandlerMap = new ConcurrentHashMap<String, CookieAttributeHandler>(paramVarArgs.length);
/*  88 */     for (CommonCookieAttributeHandler commonCookieAttributeHandler : paramVarArgs) {
/*  89 */       this.attribHandlerMap.put(commonCookieAttributeHandler.getAttributeName().toLowerCase(Locale.ROOT), commonCookieAttributeHandler);
/*     */     }
/*  91 */     this.tokenParser = TokenParser.INSTANCE;
/*     */   }
/*     */   
/*     */   static String getDefaultPath(CookieOrigin paramCookieOrigin) {
/*  95 */     String str = paramCookieOrigin.getPath();
/*  96 */     int i = str.lastIndexOf('/');
/*  97 */     if (i >= 0) {
/*  98 */       if (i == 0)
/*     */       {
/* 100 */         i = 1;
/*     */       }
/* 102 */       str = str.substring(0, i);
/*     */     } 
/* 104 */     return str;
/*     */   }
/*     */   
/*     */   static String getDefaultDomain(CookieOrigin paramCookieOrigin) {
/* 108 */     return paramCookieOrigin.getHost();
/*     */   }
/*     */   public final List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/*     */     CharArrayBuffer charArrayBuffer;
/*     */     ParserCursor parserCursor;
/* 113 */     Args.notNull(paramHeader, "Header");
/* 114 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 115 */     if (!paramHeader.getName().equalsIgnoreCase("Set-Cookie")) {
/* 116 */       throw new MalformedCookieException("Unrecognized cookie header: '" + paramHeader.toString() + "'");
/*     */     }
/*     */ 
/*     */     
/* 120 */     if (paramHeader instanceof FormattedHeader) {
/* 121 */       charArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
/* 122 */       parserCursor = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), charArrayBuffer.length());
/*     */     } else {
/* 124 */       String str = paramHeader.getValue();
/* 125 */       if (str == null) {
/* 126 */         throw new MalformedCookieException("Header value is null");
/*     */       }
/* 128 */       charArrayBuffer = new CharArrayBuffer(str.length());
/* 129 */       charArrayBuffer.append(str);
/* 130 */       parserCursor = new ParserCursor(0, charArrayBuffer.length());
/*     */     } 
/* 132 */     String str1 = this.tokenParser.parseToken(charArrayBuffer, parserCursor, TOKEN_DELIMS);
/* 133 */     if (str1.isEmpty()) {
/* 134 */       return Collections.emptyList();
/*     */     }
/* 136 */     if (parserCursor.atEnd()) {
/* 137 */       return Collections.emptyList();
/*     */     }
/* 139 */     char c = charArrayBuffer.charAt(parserCursor.getPos());
/* 140 */     parserCursor.updatePos(parserCursor.getPos() + 1);
/* 141 */     if (c != '=') {
/* 142 */       throw new MalformedCookieException("Cookie value is invalid: '" + paramHeader.toString() + "'");
/*     */     }
/* 144 */     String str2 = this.tokenParser.parseValue(charArrayBuffer, parserCursor, VALUE_DELIMS);
/* 145 */     if (!parserCursor.atEnd()) {
/* 146 */       parserCursor.updatePos(parserCursor.getPos() + 1);
/*     */     }
/* 148 */     BasicClientCookie basicClientCookie = new BasicClientCookie(str1, str2);
/* 149 */     basicClientCookie.setPath(getDefaultPath(paramCookieOrigin));
/* 150 */     basicClientCookie.setDomain(getDefaultDomain(paramCookieOrigin));
/* 151 */     basicClientCookie.setCreationDate(new Date());
/*     */     
/* 153 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 154 */     while (!parserCursor.atEnd()) {
/* 155 */       String str3 = this.tokenParser.parseToken(charArrayBuffer, parserCursor, TOKEN_DELIMS).toLowerCase(Locale.ROOT);
/*     */       
/* 157 */       String str4 = null;
/* 158 */       if (!parserCursor.atEnd()) {
/* 159 */         char c1 = charArrayBuffer.charAt(parserCursor.getPos());
/* 160 */         parserCursor.updatePos(parserCursor.getPos() + 1);
/* 161 */         if (c1 == '=') {
/* 162 */           str4 = this.tokenParser.parseToken(charArrayBuffer, parserCursor, VALUE_DELIMS);
/* 163 */           if (!parserCursor.atEnd()) {
/* 164 */             parserCursor.updatePos(parserCursor.getPos() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/* 168 */       basicClientCookie.setAttribute(str3, str4);
/* 169 */       linkedHashMap.put(str3, str4);
/*     */     } 
/*     */     
/* 172 */     if (linkedHashMap.containsKey("max-age")) {
/* 173 */       linkedHashMap.remove("expires");
/*     */     }
/*     */     
/* 176 */     for (Map.Entry<Object, Object> entry : linkedHashMap.entrySet()) {
/* 177 */       String str3 = (String)entry.getKey();
/* 178 */       String str4 = (String)entry.getValue();
/* 179 */       CookieAttributeHandler cookieAttributeHandler = this.attribHandlerMap.get(str3);
/* 180 */       if (cookieAttributeHandler != null) {
/* 181 */         cookieAttributeHandler.parse(basicClientCookie, str4);
/*     */       }
/*     */     } 
/*     */     
/* 185 */     return (List)Collections.singletonList(basicClientCookie);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 191 */     Args.notNull(paramCookie, "Cookie");
/* 192 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 193 */     for (CookieAttributeHandler cookieAttributeHandler : this.attribHandlers) {
/* 194 */       cookieAttributeHandler.validate(paramCookie, paramCookieOrigin);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 200 */     Args.notNull(paramCookie, "Cookie");
/* 201 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 202 */     for (CookieAttributeHandler cookieAttributeHandler : this.attribHandlers) {
/* 203 */       if (!cookieAttributeHandler.match(paramCookie, paramCookieOrigin)) {
/* 204 */         return false;
/*     */       }
/*     */     } 
/* 207 */     return true;
/*     */   }
/*     */   
/*     */   public List<Header> formatCookies(List<Cookie> paramList) {
/*     */     List<Cookie> list;
/* 212 */     Args.notEmpty(paramList, "List of cookies");
/*     */     
/* 214 */     if (paramList.size() > 1) {
/*     */       
/* 216 */       list = new ArrayList<Cookie>(paramList);
/* 217 */       Collections.sort(list, (Comparator<? super Cookie>)CookiePriorityComparator.INSTANCE);
/*     */     } else {
/* 219 */       list = paramList;
/*     */     } 
/* 221 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(20 * list.size());
/* 222 */     charArrayBuffer.append("Cookie");
/* 223 */     charArrayBuffer.append(": ");
/* 224 */     for (byte b = 0; b < list.size(); b++) {
/* 225 */       Cookie cookie = list.get(b);
/* 226 */       if (b > 0) {
/* 227 */         charArrayBuffer.append(';');
/* 228 */         charArrayBuffer.append(' ');
/*     */       } 
/* 230 */       charArrayBuffer.append(cookie.getName());
/* 231 */       String str = cookie.getValue();
/* 232 */       if (str != null) {
/* 233 */         charArrayBuffer.append('=');
/* 234 */         if (containsSpecialChar(str)) {
/* 235 */           charArrayBuffer.append('"');
/* 236 */           for (byte b1 = 0; b1 < str.length(); b1++) {
/* 237 */             char c = str.charAt(b1);
/* 238 */             if (c == '"' || c == '\\') {
/* 239 */               charArrayBuffer.append('\\');
/*     */             }
/* 241 */             charArrayBuffer.append(c);
/*     */           } 
/* 243 */           charArrayBuffer.append('"');
/*     */         } else {
/* 245 */           charArrayBuffer.append(str);
/*     */         } 
/*     */       } 
/*     */     } 
/* 249 */     ArrayList<BufferedHeader> arrayList = new ArrayList(1);
/* 250 */     arrayList.add(new BufferedHeader(charArrayBuffer));
/* 251 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   boolean containsSpecialChar(CharSequence paramCharSequence) {
/* 255 */     return containsChars(paramCharSequence, SPECIAL_CHARS);
/*     */   }
/*     */   
/*     */   boolean containsChars(CharSequence paramCharSequence, BitSet paramBitSet) {
/* 259 */     for (byte b = 0; b < paramCharSequence.length(); b++) {
/* 260 */       char c = paramCharSequence.charAt(b);
/* 261 */       if (paramBitSet.get(c)) {
/* 262 */         return true;
/*     */       }
/*     */     } 
/* 265 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getVersion() {
/* 270 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Header getVersionHeader() {
/* 275 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC6265CookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */