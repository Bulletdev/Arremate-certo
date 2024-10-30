/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.HttpResponseFactory;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.config.MessageConstraints;
/*    */ import org.apache.http.impl.DefaultHttpResponseFactory;
/*    */ import org.apache.http.io.HttpMessageParser;
/*    */ import org.apache.http.io.HttpMessageParserFactory;
/*    */ import org.apache.http.io.SessionInputBuffer;
/*    */ import org.apache.http.message.BasicLineParser;
/*    */ import org.apache.http.message.LineParser;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*    */ public class DefaultHttpResponseParserFactory
/*    */   implements HttpMessageParserFactory<HttpResponse>
/*    */ {
/* 50 */   public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
/*    */   
/*    */   private final LineParser lineParser;
/*    */   
/*    */   private final HttpResponseFactory responseFactory;
/*    */ 
/*    */   
/*    */   public DefaultHttpResponseParserFactory(LineParser paramLineParser, HttpResponseFactory paramHttpResponseFactory) {
/* 58 */     this.lineParser = (paramLineParser != null) ? paramLineParser : (LineParser)BasicLineParser.INSTANCE;
/* 59 */     this.responseFactory = (paramHttpResponseFactory != null) ? paramHttpResponseFactory : (HttpResponseFactory)DefaultHttpResponseFactory.INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   public DefaultHttpResponseParserFactory() {
/* 64 */     this(null, null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpMessageParser<HttpResponse> create(SessionInputBuffer paramSessionInputBuffer, MessageConstraints paramMessageConstraints) {
/* 70 */     return new DefaultHttpResponseParser(paramSessionInputBuffer, this.lineParser, this.responseFactory, paramMessageConstraints);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpResponseParserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */