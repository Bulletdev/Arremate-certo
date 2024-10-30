/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseFactory;
/*     */ import org.apache.http.NoHttpResponseException;
/*     */ import org.apache.http.ParseException;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.config.MessageConstraints;
/*     */ import org.apache.http.impl.DefaultHttpResponseFactory;
/*     */ import org.apache.http.impl.io.AbstractMessageParser;
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
/*     */ public class DefaultHttpResponseParser
/*     */   extends AbstractMessageParser<HttpResponse>
/*     */ {
/*  59 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */   
/*     */   private final HttpResponseFactory responseFactory;
/*     */ 
/*     */ 
/*     */   
/*     */   private final CharArrayBuffer lineBuf;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpResponseFactory paramHttpResponseFactory, HttpParams paramHttpParams) {
/*  74 */     super(paramSessionInputBuffer, paramLineParser, paramHttpParams);
/*  75 */     Args.notNull(paramHttpResponseFactory, "Response factory");
/*  76 */     this.responseFactory = paramHttpResponseFactory;
/*  77 */     this.lineBuf = new CharArrayBuffer(128);
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
/*  98 */     super(paramSessionInputBuffer, paramLineParser, paramMessageConstraints);
/*  99 */     this.responseFactory = (paramHttpResponseFactory != null) ? paramHttpResponseFactory : (HttpResponseFactory)DefaultHttpResponseFactory.INSTANCE;
/*     */     
/* 101 */     this.lineBuf = new CharArrayBuffer(128);
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
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer, MessageConstraints paramMessageConstraints) {
/* 115 */     this(paramSessionInputBuffer, (LineParser)null, (HttpResponseFactory)null, paramMessageConstraints);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpResponseParser(SessionInputBuffer paramSessionInputBuffer) {
/* 126 */     this(paramSessionInputBuffer, (LineParser)null, (HttpResponseFactory)null, MessageConstraints.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpResponse parseHead(SessionInputBuffer paramSessionInputBuffer) throws IOException, HttpException {
/* 133 */     byte b = 0;
/* 134 */     ParserCursor parserCursor = null;
/*     */     
/*     */     while (true) {
/* 137 */       this.lineBuf.clear();
/* 138 */       int i = paramSessionInputBuffer.readLine(this.lineBuf);
/* 139 */       if (i == -1 && !b)
/*     */       {
/* 141 */         throw new NoHttpResponseException("The target server failed to respond");
/*     */       }
/* 143 */       parserCursor = new ParserCursor(0, this.lineBuf.length());
/* 144 */       if (this.lineParser.hasProtocolVersion(this.lineBuf, parserCursor)) {
/*     */         break;
/*     */       }
/* 147 */       if (i == -1 || reject(this.lineBuf, b))
/*     */       {
/* 149 */         throw new ProtocolException("The server failed to respond with a valid HTTP response");
/*     */       }
/*     */       
/* 152 */       if (this.log.isDebugEnabled()) {
/* 153 */         this.log.debug("Garbage in response: " + this.lineBuf.toString());
/*     */       }
/* 155 */       b++;
/*     */     } 
/*     */     
/* 158 */     StatusLine statusLine = this.lineParser.parseStatusLine(this.lineBuf, parserCursor);
/* 159 */     return this.responseFactory.newHttpResponse(statusLine, null);
/*     */   }
/*     */   
/*     */   protected boolean reject(CharArrayBuffer paramCharArrayBuffer, int paramInt) {
/* 163 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultHttpResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */