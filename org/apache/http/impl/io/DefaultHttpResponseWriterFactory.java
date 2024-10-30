/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.io.HttpMessageWriter;
/*    */ import org.apache.http.io.HttpMessageWriterFactory;
/*    */ import org.apache.http.io.SessionOutputBuffer;
/*    */ import org.apache.http.message.BasicLineFormatter;
/*    */ import org.apache.http.message.LineFormatter;
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
/*    */ public class DefaultHttpResponseWriterFactory
/*    */   implements HttpMessageWriterFactory<HttpResponse>
/*    */ {
/* 47 */   public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
/*    */   
/*    */   private final LineFormatter lineFormatter;
/*    */ 
/*    */   
/*    */   public DefaultHttpResponseWriterFactory(LineFormatter paramLineFormatter) {
/* 53 */     this.lineFormatter = (paramLineFormatter != null) ? paramLineFormatter : (LineFormatter)BasicLineFormatter.INSTANCE;
/*    */   }
/*    */   
/*    */   public DefaultHttpResponseWriterFactory() {
/* 57 */     this(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer paramSessionOutputBuffer) {
/* 62 */     return new DefaultHttpResponseWriter(paramSessionOutputBuffer, this.lineFormatter);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpResponseWriterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */