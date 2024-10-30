/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.ConnectionClosedException;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestFactory;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.RequestLine;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.impl.DefaultHttpRequestFactory;
/*     */ import org.apache.http.io.SessionInputBuffer;
/*     */ import org.apache.http.message.LineParser;
/*     */ import org.apache.http.message.ParserCursor;
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
/*     */ public class DefaultHttpRequestParser
/*     */   extends AbstractMessageParser<HttpRequest>
/*     */ {
/*     */   private final HttpRequestFactory requestFactory;
/*     */   private final CharArrayBuffer lineBuf;
/*     */   
/*     */   @Deprecated
/*     */   public DefaultHttpRequestParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpRequestFactory paramHttpRequestFactory, HttpParams paramHttpParams) {
/*  78 */     super(paramSessionInputBuffer, paramLineParser, paramHttpParams);
/*  79 */     this.requestFactory = (HttpRequestFactory)Args.notNull(paramHttpRequestFactory, "Request factory");
/*  80 */     this.lineBuf = new CharArrayBuffer(128);
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
/*     */   public DefaultHttpRequestParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpRequestFactory paramHttpRequestFactory, MessageConstraints paramMessageConstraints) {
/* 101 */     super(paramSessionInputBuffer, paramLineParser, paramMessageConstraints);
/* 102 */     this.requestFactory = (paramHttpRequestFactory != null) ? paramHttpRequestFactory : (HttpRequestFactory)DefaultHttpRequestFactory.INSTANCE;
/*     */     
/* 104 */     this.lineBuf = new CharArrayBuffer(128);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpRequestParser(SessionInputBuffer paramSessionInputBuffer, MessageConstraints paramMessageConstraints) {
/* 113 */     this(paramSessionInputBuffer, (LineParser)null, (HttpRequestFactory)null, paramMessageConstraints);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpRequestParser(SessionInputBuffer paramSessionInputBuffer) {
/* 120 */     this(paramSessionInputBuffer, (LineParser)null, (HttpRequestFactory)null, MessageConstraints.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpRequest parseHead(SessionInputBuffer paramSessionInputBuffer) throws IOException, HttpException, ParseException {
/* 128 */     this.lineBuf.clear();
/* 129 */     int i = paramSessionInputBuffer.readLine(this.lineBuf);
/* 130 */     if (i == -1) {
/* 131 */       throw new ConnectionClosedException("Client closed connection");
/*     */     }
/* 133 */     ParserCursor parserCursor = new ParserCursor(0, this.lineBuf.length());
/* 134 */     RequestLine requestLine = this.lineParser.parseRequestLine(this.lineBuf, parserCursor);
/* 135 */     return this.requestFactory.newHttpRequest(requestLine);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpRequestParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */