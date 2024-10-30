/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.util.BitSet;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class TokenParser
/*     */ {
/*     */   public static final char CR = '\r';
/*     */   public static final char LF = '\n';
/*     */   public static final char SP = ' ';
/*     */   public static final char HT = '\t';
/*     */   public static final char DQUOTE = '"';
/*     */   public static final char ESCAPE = '\\';
/*     */   
/*     */   public static BitSet INIT_BITSET(int... paramVarArgs) {
/*  48 */     BitSet bitSet = new BitSet();
/*  49 */     for (int i : paramVarArgs) {
/*  50 */       bitSet.set(i);
/*     */     }
/*  52 */     return bitSet;
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
/*     */   public static boolean isWhitespace(char paramChar) {
/*  74 */     return (paramChar == ' ' || paramChar == '\t' || paramChar == '\r' || paramChar == '\n');
/*     */   }
/*     */   
/*  77 */   public static final TokenParser INSTANCE = new TokenParser();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String parseToken(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, BitSet paramBitSet) {
/*  89 */     StringBuilder stringBuilder = new StringBuilder();
/*  90 */     boolean bool = false;
/*  91 */     while (!paramParserCursor.atEnd()) {
/*  92 */       char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos());
/*  93 */       if (paramBitSet != null && paramBitSet.get(c))
/*     */         break; 
/*  95 */       if (isWhitespace(c)) {
/*  96 */         skipWhiteSpace(paramCharArrayBuffer, paramParserCursor);
/*  97 */         bool = true; continue;
/*     */       } 
/*  99 */       if (bool && stringBuilder.length() > 0) {
/* 100 */         stringBuilder.append(' ');
/*     */       }
/* 102 */       copyContent(paramCharArrayBuffer, paramParserCursor, paramBitSet, stringBuilder);
/* 103 */       bool = false;
/*     */     } 
/*     */     
/* 106 */     return stringBuilder.toString();
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
/*     */   public String parseValue(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, BitSet paramBitSet) {
/* 120 */     StringBuilder stringBuilder = new StringBuilder();
/* 121 */     boolean bool = false;
/* 122 */     while (!paramParserCursor.atEnd()) {
/* 123 */       char c = paramCharArrayBuffer.charAt(paramParserCursor.getPos());
/* 124 */       if (paramBitSet != null && paramBitSet.get(c))
/*     */         break; 
/* 126 */       if (isWhitespace(c)) {
/* 127 */         skipWhiteSpace(paramCharArrayBuffer, paramParserCursor);
/* 128 */         bool = true; continue;
/* 129 */       }  if (c == '"') {
/* 130 */         if (bool && stringBuilder.length() > 0) {
/* 131 */           stringBuilder.append(' ');
/*     */         }
/* 133 */         copyQuotedContent(paramCharArrayBuffer, paramParserCursor, stringBuilder);
/* 134 */         bool = false; continue;
/*     */       } 
/* 136 */       if (bool && stringBuilder.length() > 0) {
/* 137 */         stringBuilder.append(' ');
/*     */       }
/* 139 */       copyUnquotedContent(paramCharArrayBuffer, paramParserCursor, paramBitSet, stringBuilder);
/* 140 */       bool = false;
/*     */     } 
/*     */     
/* 143 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void skipWhiteSpace(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) {
/* 154 */     int i = paramParserCursor.getPos();
/* 155 */     int j = paramParserCursor.getPos();
/* 156 */     int k = paramParserCursor.getUpperBound();
/* 157 */     for (int m = j; m < k; m++) {
/* 158 */       char c = paramCharArrayBuffer.charAt(m);
/* 159 */       if (!isWhitespace(c)) {
/*     */         break;
/*     */       }
/* 162 */       i++;
/*     */     } 
/* 164 */     paramParserCursor.updatePos(i);
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
/*     */   public void copyContent(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, BitSet paramBitSet, StringBuilder paramStringBuilder) {
/* 179 */     int i = paramParserCursor.getPos();
/* 180 */     int j = paramParserCursor.getPos();
/* 181 */     int k = paramParserCursor.getUpperBound();
/* 182 */     for (int m = j; m < k; m++) {
/* 183 */       char c = paramCharArrayBuffer.charAt(m);
/* 184 */       if ((paramBitSet != null && paramBitSet.get(c)) || isWhitespace(c)) {
/*     */         break;
/*     */       }
/* 187 */       i++;
/* 188 */       paramStringBuilder.append(c);
/*     */     } 
/* 190 */     paramParserCursor.updatePos(i);
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
/*     */   public void copyUnquotedContent(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, BitSet paramBitSet, StringBuilder paramStringBuilder) {
/* 205 */     int i = paramParserCursor.getPos();
/* 206 */     int j = paramParserCursor.getPos();
/* 207 */     int k = paramParserCursor.getUpperBound();
/* 208 */     for (int m = j; m < k; m++) {
/* 209 */       char c = paramCharArrayBuffer.charAt(m);
/* 210 */       if ((paramBitSet != null && paramBitSet.get(c)) || isWhitespace(c) || c == '"') {
/*     */         break;
/*     */       }
/*     */       
/* 214 */       i++;
/* 215 */       paramStringBuilder.append(c);
/*     */     } 
/* 217 */     paramParserCursor.updatePos(i);
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
/*     */   public void copyQuotedContent(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, StringBuilder paramStringBuilder) {
/* 229 */     if (paramParserCursor.atEnd()) {
/*     */       return;
/*     */     }
/* 232 */     int i = paramParserCursor.getPos();
/* 233 */     int j = paramParserCursor.getPos();
/* 234 */     int k = paramParserCursor.getUpperBound();
/* 235 */     char c = paramCharArrayBuffer.charAt(i);
/* 236 */     if (c != '"') {
/*     */       return;
/*     */     }
/* 239 */     i++;
/* 240 */     j++;
/* 241 */     boolean bool = false;
/* 242 */     for (int m = j; m < k; m++, i++) {
/* 243 */       c = paramCharArrayBuffer.charAt(m);
/* 244 */       if (bool) {
/* 245 */         if (c != '"' && c != '\\') {
/* 246 */           paramStringBuilder.append('\\');
/*     */         }
/* 248 */         paramStringBuilder.append(c);
/* 249 */         bool = false;
/*     */       } else {
/* 251 */         if (c == '"') {
/* 252 */           i++;
/*     */           break;
/*     */         } 
/* 255 */         if (c == '\\') {
/* 256 */           bool = true;
/* 257 */         } else if (c != '\r' && c != '\n') {
/* 258 */           paramStringBuilder.append(c);
/*     */         } 
/*     */       } 
/*     */     } 
/* 262 */     paramParserCursor.updatePos(i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\TokenParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */