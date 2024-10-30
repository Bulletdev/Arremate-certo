/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpMessage;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.io.SessionOutputBuffer;
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
/*    */ public class DefaultHttpResponseWriter
/*    */   extends AbstractMessageWriter<HttpResponse>
/*    */ {
/*    */   public DefaultHttpResponseWriter(SessionOutputBuffer paramSessionOutputBuffer, LineFormatter paramLineFormatter) {
/* 54 */     super(paramSessionOutputBuffer, paramLineFormatter);
/*    */   }
/*    */   
/*    */   public DefaultHttpResponseWriter(SessionOutputBuffer paramSessionOutputBuffer) {
/* 58 */     super(paramSessionOutputBuffer, null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeHeadLine(HttpResponse paramHttpResponse) throws IOException {
/* 63 */     this.lineFormatter.formatStatusLine(this.lineBuf, paramHttpResponse.getStatusLine());
/* 64 */     this.sessionBuffer.writeLine(this.lineBuf);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpResponseWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */