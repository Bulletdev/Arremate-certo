/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.ParseException;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class BasicHeaderValueParser
/*     */   implements HeaderValueParser
/*     */ {
/*     */   @Deprecated
/*  61 */   public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
/*     */   
/*  63 */   public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
/*     */ 
/*     */   
/*     */   private static final char PARAM_DELIMITER = ';';
/*     */   
/*     */   private static final char ELEM_DELIMITER = ',';
/*     */   
/*  70 */   private static final BitSet TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[] { 61, 59, 44 });
/*  71 */   private static final BitSet VALUE_DELIMS = TokenParser.INIT_BITSET(new int[] { 59, 44 });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   private final TokenParser tokenParser = TokenParser.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HeaderElement[] parseElements(String paramString, HeaderValueParser paramHeaderValueParser) throws ParseException {
/*  91 */     Args.notNull(paramString, "Value");
/*     */     
/*  93 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/*  94 */     charArrayBuffer.append(paramString);
/*  95 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/*  96 */     return ((paramHeaderValueParser != null) ? paramHeaderValueParser : INSTANCE).parseElements(charArrayBuffer, parserCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderElement[] parseElements(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 105 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 106 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 107 */     ArrayList<HeaderElement> arrayList = new ArrayList();
/* 108 */     while (!paramParserCursor.atEnd()) {
/* 109 */       HeaderElement headerElement = parseHeaderElement(paramCharArrayBuffer, paramParserCursor);
/* 110 */       if (!headerElement.getName().isEmpty() || headerElement.getValue() != null) {
/* 111 */         arrayList.add(headerElement);
/*     */       }
/*     */     } 
/* 114 */     return arrayList.<HeaderElement>toArray(new HeaderElement[arrayList.size()]);
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
/*     */   public static HeaderElement parseHeaderElement(String paramString, HeaderValueParser paramHeaderValueParser) throws ParseException {
/* 129 */     Args.notNull(paramString, "Value");
/*     */     
/* 131 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 132 */     charArrayBuffer.append(paramString);
/* 133 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 134 */     return ((paramHeaderValueParser != null) ? paramHeaderValueParser : INSTANCE).parseHeaderElement(charArrayBuffer, parserCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderElement parseHeaderElement(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 143 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 144 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 145 */     NameValuePair nameValuePair = parseNameValuePair(paramCharArrayBuffer, paramParserCursor);
/* 146 */     NameValuePair[] arrayOfNameValuePair = null;
/* 147 */     if (!paramParserCursor.atEnd()) {
/* 148 */       char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos() - 1);
/* 149 */       if (c != ',') {
/* 150 */         arrayOfNameValuePair = parseParameters(paramCharArrayBuffer, paramParserCursor);
/*     */       }
/*     */     } 
/* 153 */     return createHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), arrayOfNameValuePair);
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
/*     */   protected HeaderElement createHeaderElement(String paramString1, String paramString2, NameValuePair[] paramArrayOfNameValuePair) {
/* 167 */     return new BasicHeaderElement(paramString1, paramString2, paramArrayOfNameValuePair);
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
/*     */   public static NameValuePair[] parseParameters(String paramString, HeaderValueParser paramHeaderValueParser) throws ParseException {
/* 182 */     Args.notNull(paramString, "Value");
/*     */     
/* 184 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 185 */     charArrayBuffer.append(paramString);
/* 186 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 187 */     return ((paramHeaderValueParser != null) ? paramHeaderValueParser : INSTANCE).parseParameters(charArrayBuffer, parserCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameValuePair[] parseParameters(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 197 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 198 */     Args.notNull(paramParserCursor, "Parser cursor");
/* 199 */     this.tokenParser.skipWhiteSpace(paramCharArrayBuffer, paramParserCursor);
/* 200 */     ArrayList<NameValuePair> arrayList = new ArrayList();
/* 201 */     while (!paramParserCursor.atEnd()) {
/* 202 */       NameValuePair nameValuePair = parseNameValuePair(paramCharArrayBuffer, paramParserCursor);
/* 203 */       arrayList.add(nameValuePair);
/* 204 */       char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos() - 1);
/* 205 */       if (c == ',') {
/*     */         break;
/*     */       }
/*     */     } 
/* 209 */     return arrayList.<NameValuePair>toArray(new NameValuePair[arrayList.size()]);
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
/*     */   public static NameValuePair parseNameValuePair(String paramString, HeaderValueParser paramHeaderValueParser) throws ParseException {
/* 223 */     Args.notNull(paramString, "Value");
/*     */     
/* 225 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(paramString.length());
/* 226 */     charArrayBuffer.append(paramString);
/* 227 */     ParserCursor parserCursor = new ParserCursor(0, paramString.length());
/* 228 */     return ((paramHeaderValueParser != null) ? paramHeaderValueParser : INSTANCE).parseNameValuePair(charArrayBuffer, parserCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 237 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 238 */     Args.notNull(paramParserCursor, "Parser cursor");
/*     */     
/* 240 */     String str1 = this.tokenParser.parseToken(paramCharArrayBuffer, paramParserCursor, TOKEN_DELIMS);
/* 241 */     if (paramParserCursor.atEnd()) {
/* 242 */       return new BasicNameValuePair(str1, null);
/*     */     }
/* 244 */     char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos());
/* 245 */     paramParserCursor.updatePos(paramParserCursor.getPos() + 1);
/* 246 */     if (c != '=') {
/* 247 */       return createNameValuePair(str1, null);
/*     */     }
/* 249 */     String str2 = this.tokenParser.parseValue(paramCharArrayBuffer, paramParserCursor, VALUE_DELIMS);
/* 250 */     if (!paramParserCursor.atEnd()) {
/* 251 */       paramParserCursor.updatePos(paramParserCursor.getPos() + 1);
/*     */     }
/* 253 */     return createNameValuePair(str1, str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, char[] paramArrayOfchar) {
/* 263 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/* 264 */     Args.notNull(paramParserCursor, "Parser cursor");
/*     */     
/* 266 */     BitSet bitSet = new BitSet();
/* 267 */     if (paramArrayOfchar != null) {
/* 268 */       for (char c1 : paramArrayOfchar) {
/* 269 */         bitSet.set(c1);
/*     */       }
/*     */     }
/* 272 */     bitSet.set(61);
/* 273 */     String str1 = this.tokenParser.parseToken(paramCharArrayBuffer, paramParserCursor, bitSet);
/* 274 */     if (paramParserCursor.atEnd()) {
/* 275 */       return new BasicNameValuePair(str1, null);
/*     */     }
/* 277 */     char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos());
/* 278 */     paramParserCursor.updatePos(paramParserCursor.getPos() + 1);
/* 279 */     if (c != '=') {
/* 280 */       return createNameValuePair(str1, null);
/*     */     }
/* 282 */     bitSet.clear(61);
/* 283 */     String str2 = this.tokenParser.parseValue(paramCharArrayBuffer, paramParserCursor, bitSet);
/* 284 */     if (!paramParserCursor.atEnd()) {
/* 285 */       paramParserCursor.updatePos(paramParserCursor.getPos() + 1);
/*     */     }
/* 287 */     return createNameValuePair(str1, str2);
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
/*     */   protected NameValuePair createNameValuePair(String paramString1, String paramString2) {
/* 300 */     return new BasicNameValuePair(paramString1, paramString2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicHeaderValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */