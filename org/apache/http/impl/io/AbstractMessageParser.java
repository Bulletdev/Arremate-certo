/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.MessageConstraintException;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.io.HttpMessageParser;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.message.BasicLineParser;
/*     */ import org.apache.http.message.LineParser;
/*     */ import org.apache.http.params.HttpParamConfig;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMessageParser<T extends HttpMessage>
/*     */   implements HttpMessageParser<T>
/*     */ {
/*     */   private static final int HEAD_LINE = 0;
/*     */   private static final int HEADERS = 1;
/*     */   private final SessionInputBuffer sessionBuffer;
/*     */   private final MessageConstraints messageConstraints;
/*     */   private final List<CharArrayBuffer> headerLines;
/*     */   protected final LineParser lineParser;
/*     */   private int state;
/*     */   private T message;
/*     */   
/*     */   @Deprecated
/*     */   public AbstractMessageParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpParams paramHttpParams) {
/*  86 */     Args.notNull(paramSessionInputBuffer, "Session input buffer");
/*  87 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  88 */     this.sessionBuffer = paramSessionInputBuffer;
/*  89 */     this.messageConstraints = HttpParamConfig.getMessageConstraints(paramHttpParams);
/*  90 */     this.lineParser = (paramLineParser != null) ? paramLineParser : (LineParser)BasicLineParser.INSTANCE;
/*  91 */     this.headerLines = new ArrayList<CharArrayBuffer>();
/*  92 */     this.state = 0;
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
/*     */   public AbstractMessageParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, MessageConstraints paramMessageConstraints) {
/* 111 */     this.sessionBuffer = (SessionInputBuffer)Args.notNull(paramSessionInputBuffer, "Session input buffer");
/* 112 */     this.lineParser = (paramLineParser != null) ? paramLineParser : (LineParser)BasicLineParser.INSTANCE;
/* 113 */     this.messageConstraints = (paramMessageConstraints != null) ? paramMessageConstraints : MessageConstraints.DEFAULT;
/* 114 */     this.headerLines = new ArrayList<CharArrayBuffer>();
/* 115 */     this.state = 0;
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
/*     */   public static Header[] parseHeaders(SessionInputBuffer paramSessionInputBuffer, int paramInt1, int paramInt2, LineParser paramLineParser) throws HttpException, IOException {
/* 142 */     ArrayList<CharArrayBuffer> arrayList = new ArrayList();
/* 143 */     return parseHeaders(paramSessionInputBuffer, paramInt1, paramInt2, (paramLineParser != null) ? paramLineParser : (LineParser)BasicLineParser.INSTANCE, arrayList);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Header[] parseHeaders(SessionInputBuffer paramSessionInputBuffer, int paramInt1, int paramInt2, LineParser paramLineParser, List<CharArrayBuffer> paramList) throws HttpException, IOException {
/* 178 */     Args.notNull(paramSessionInputBuffer, "Session input buffer");
/* 179 */     Args.notNull(paramLineParser, "Line parser");
/* 180 */     Args.notNull(paramList, "Header line list");
/*     */     
/* 182 */     CharArrayBuffer charArrayBuffer1 = null;
/* 183 */     CharArrayBuffer charArrayBuffer2 = null;
/*     */     while (true) {
/* 185 */       if (charArrayBuffer1 == null) {
/* 186 */         charArrayBuffer1 = new CharArrayBuffer(64);
/*     */       } else {
/* 188 */         charArrayBuffer1.clear();
/*     */       } 
/* 190 */       int i = paramSessionInputBuffer.readLine(charArrayBuffer1);
/* 191 */       if (i == -1 || charArrayBuffer1.length() < 1) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       if ((charArrayBuffer1.charAt(0) == ' ' || charArrayBuffer1.charAt(0) == '\t') && charArrayBuffer2 != null) {
/*     */ 
/*     */         
/* 201 */         byte b1 = 0;
/* 202 */         while (b1 < charArrayBuffer1.length()) {
/* 203 */           char c = charArrayBuffer1.charAt(b1);
/* 204 */           if (c != ' ' && c != '\t') {
/*     */             break;
/*     */           }
/* 207 */           b1++;
/*     */         } 
/* 209 */         if (paramInt2 > 0 && charArrayBuffer2.length() + 1 + charArrayBuffer1.length() - b1 > paramInt2)
/*     */         {
/* 211 */           throw new MessageConstraintException("Maximum line length limit exceeded");
/*     */         }
/* 213 */         charArrayBuffer2.append(' ');
/* 214 */         charArrayBuffer2.append(charArrayBuffer1, b1, charArrayBuffer1.length() - b1);
/*     */       } else {
/* 216 */         paramList.add(charArrayBuffer1);
/* 217 */         charArrayBuffer2 = charArrayBuffer1;
/* 218 */         charArrayBuffer1 = null;
/*     */       } 
/* 220 */       if (paramInt1 > 0 && paramList.size() >= paramInt1) {
/* 221 */         throw new MessageConstraintException("Maximum header count exceeded");
/*     */       }
/*     */     } 
/* 224 */     Header[] arrayOfHeader = new Header[paramList.size()];
/* 225 */     for (byte b = 0; b < paramList.size(); b++) {
/* 226 */       CharArrayBuffer charArrayBuffer = paramList.get(b);
/*     */       try {
/* 228 */         arrayOfHeader[b] = paramLineParser.parseHeader(charArrayBuffer);
/* 229 */       } catch (ParseException parseException) {
/* 230 */         throw new ProtocolException(parseException.getMessage());
/*     */       } 
/*     */     } 
/* 233 */     return arrayOfHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T parseHead(SessionInputBuffer paramSessionInputBuffer) throws IOException, HttpException, ParseException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T parse() throws IOException, HttpException {
/*     */     Header[] arrayOfHeader;
/*     */     T t;
/* 255 */     int i = this.state;
/* 256 */     switch (i) {
/*     */       case 0:
/*     */         try {
/* 259 */           this.message = parseHead(this.sessionBuffer);
/* 260 */         } catch (ParseException parseException) {
/* 261 */           throw new ProtocolException(parseException.getMessage(), parseException);
/*     */         } 
/* 263 */         this.state = 1;
/*     */       
/*     */       case 1:
/* 266 */         arrayOfHeader = parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 272 */         this.message.setHeaders(arrayOfHeader);
/* 273 */         t = this.message;
/* 274 */         this.message = null;
/* 275 */         this.headerLines.clear();
/* 276 */         this.state = 0;
/* 277 */         return t;
/*     */     } 
/* 279 */     throw new IllegalStateException("Inconsistent parser state");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\AbstractMessageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */