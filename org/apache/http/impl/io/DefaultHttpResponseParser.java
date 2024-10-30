/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseFactory;
/*     */ import org.apache.http.NoHttpResponseException;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.impl.DefaultHttpResponseFactory;
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
/*     */ public class DefaultHttpResponseParser
/*     */   extends AbstractMessageParser<HttpResponse>
/*     */ {
/*     */   private final HttpResponseFactory responseFactory;
/*     */   private final CharArrayBuffer lineBuf;
/*     */   
/*     */   @Deprecated
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpResponseFactory paramHttpResponseFactory, HttpParams paramHttpParams) {
/*  78 */     super(paramSessionInputBuffer, paramLineParser, paramHttpParams);
/*  79 */     this.responseFactory = (HttpResponseFactory)Args.notNull(paramHttpResponseFactory, "Response factory");
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
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpResponseFactory paramHttpResponseFactory, MessageConstraints paramMessageConstraints) {
/* 101 */     super(paramSessionInputBuffer, paramLineParser, paramMessageConstraints);
/* 102 */     this.responseFactory = (paramHttpResponseFactory != null) ? paramHttpResponseFactory : (HttpResponseFactory)DefaultHttpResponseFactory.INSTANCE;
/*     */     
/* 104 */     this.lineBuf = new CharArrayBuffer(128);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer, MessageConstraints paramMessageConstraints) {
/* 113 */     this(paramSessionInputBuffer, (LineParser)null, (HttpResponseFactory)null, paramMessageConstraints);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer) {
/* 120 */     this(paramSessionInputBuffer, (LineParser)null, (HttpResponseFactory)null, MessageConstraints.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpResponse parseHead(SessionInputBuffer paramSessionInputBuffer) throws IOException, HttpException, ParseException {
/* 128 */     this.lineBuf.clear();
/* 129 */     int i = paramSessionInputBuffer.readLine(this.lineBuf);
/* 130 */     if (i == -1) {
/* 131 */       throw new NoHttpResponseException("The target server failed to respond");
/*     */     }
/*     */     
/* 134 */     ParserCursor parserCursor = new ParserCursor(0, this.lineBuf.length());
/* 135 */     StatusLine statusLine = this.lineParser.parseStatusLine(this.lineBuf, parserCursor);
/* 136 */     return this.responseFactory.newHttpResponse(statusLine, null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */