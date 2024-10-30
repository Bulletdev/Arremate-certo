/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import org.apache.http.HttpRequest;
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
/*    */ public class DefaultHttpRequestWriterFactory
/*    */   implements HttpMessageWriterFactory<HttpRequest>
/*    */ {
/* 47 */   public static final DefaultHttpRequestWriterFactory INSTANCE = new DefaultHttpRequestWriterFactory();
/*    */   
/*    */   private final LineFormatter lineFormatter;
/*    */ 
/*    */   
/*    */   public DefaultHttpRequestWriterFactory(LineFormatter paramLineFormatter) {
/* 53 */     this.lineFormatter = (paramLineFormatter != null) ? paramLineFormatter : (LineFormatter)BasicLineFormatter.INSTANCE;
/*    */   }
/*    */   
/*    */   public DefaultHttpRequestWriterFactory() {
/* 57 */     this(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer paramSessionOutputBuffer) {
/* 62 */     return new DefaultHttpRequestWriter(paramSessionOutputBuffer, this.lineFormatter);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpRequestWriterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */