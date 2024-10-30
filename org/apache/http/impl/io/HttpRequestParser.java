/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.ConnectionClosedException;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpMessage;
/*    */ import org.apache.http.HttpRequestFactory;
/*    */ import org.apache.http.ParseException;
/*    */ import org.apache.http.RequestLine;
/*    */ import org.apache.http.io.SessionInputBuffer;
/*    */ import org.apache.http.message.LineParser;
/*    */ import org.apache.http.message.ParserCursor;
/*    */ import org.apache.http.params.HttpParams;
/*    */ import org.apache.http.util.Args;
/*    */ import org.apache.http.util.CharArrayBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class HttpRequestParser
/*    */   extends AbstractMessageParser<HttpMessage>
/*    */ {
/*    */   private final HttpRequestFactory requestFactory;
/*    */   private final CharArrayBuffer lineBuf;
/*    */   
/*    */   public HttpRequestParser(SessionInputBuffer paramSessionInputBuffer, LineParser paramLineParser, HttpRequestFactory paramHttpRequestFactory, HttpParams paramHttpParams) {
/* 80 */     super(paramSessionInputBuffer, paramLineParser, paramHttpParams);
/* 81 */     this.requestFactory = (HttpRequestFactory)Args.notNull(paramHttpRequestFactory, "Request factory");
/* 82 */     this.lineBuf = new CharArrayBuffer(128);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected HttpMessage parseHead(SessionInputBuffer paramSessionInputBuffer) throws IOException, HttpException, ParseException {
/* 90 */     this.lineBuf.clear();
/* 91 */     int i = paramSessionInputBuffer.readLine(this.lineBuf);
/* 92 */     if (i == -1) {
/* 93 */       throw new ConnectionClosedException("Client closed connection");
/*    */     }
/* 95 */     ParserCursor parserCursor = new ParserCursor(0, this.lineBuf.length());
/* 96 */     RequestLine requestLine = this.lineParser.parseRequestLine(this.lineBuf, parserCursor);
/* 97 */     return (HttpMessage)this.requestFactory.newHttpRequest(requestLine);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\HttpRequestParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */