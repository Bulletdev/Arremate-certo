/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.message.BasicHeaderElement;
/*     */ import org.apache.http.message.BasicNameValuePair;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class NetscapeDraftHeaderParser
/*     */ {
/*  53 */   public static final NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
/*     */ 
/*     */   
/*     */   private static final char PARAM_DELIMITER = ';';
/*     */ 
/*     */   
/*  59 */   private static final BitSet TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[] { 61, 59 });
/*  60 */   private static final BitSet VALUE_DELIMS = TokenParser.INIT_BITSET(new int[] { 59 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private final TokenParser tokenParser = TokenParser.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderElement parseHeader(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException {
/*  72 */     Args.notNull(paramCharArrayBuffer, "Char array buffer");
/*  73 */     Args.notNull(paramParserCursor, "Parser cursor");
/*  74 */     NameValuePair nameValuePair = parseNameValuePair(paramCharArrayBuffer, paramParserCursor);
/*  75 */     ArrayList<NameValuePair> arrayList = new ArrayList();
/*  76 */     while (!paramParserCursor.atEnd()) {
/*  77 */       NameValuePair nameValuePair1 = parseNameValuePair(paramCharArrayBuffer, paramParserCursor);
/*  78 */       arrayList.add(nameValuePair1);
/*     */     } 
/*  80 */     return (HeaderElement)new BasicHeaderElement(nameValuePair.getName(), nameValuePair.getValue(), arrayList.<NameValuePair>toArray(new NameValuePair[arrayList.size()]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/*  87 */     String str1 = this.tokenParser.parseToken(paramCharArrayBuffer, paramParserCursor, TOKEN_DELIMS);
/*  88 */     if (paramParserCursor.atEnd()) {
/*  89 */       return (NameValuePair)new BasicNameValuePair(str1, null);
/*     */     }
/*  91 */     char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos());
/*  92 */     paramParserCursor.updatePos(paramParserCursor.getPos() + 1);
/*  93 */     if (c != '=') {
/*  94 */       return (NameValuePair)new BasicNameValuePair(str1, null);
/*     */     }
/*  96 */     String str2 = this.tokenParser.parseToken(paramCharArrayBuffer, paramParserCursor, VALUE_DELIMS);
/*  97 */     if (!paramParserCursor.atEnd()) {
/*  98 */       paramParserCursor.updatePos(paramParserCursor.getPos() + 1);
/*     */     }
/* 100 */     return (NameValuePair)new BasicNameValuePair(str1, str2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\NetscapeDraftHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */