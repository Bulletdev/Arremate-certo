/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpMessage;
/*    */ import org.apache.http.HttpRequest;
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
/*    */ public class DefaultHttpRequestWriter
/*    */   extends AbstractMessageWriter<HttpRequest>
/*    */ {
/*    */   public DefaultHttpRequestWriter(SessionOutputBuffer paramSessionOutputBuffer, LineFormatter paramLineFormatter) {
/* 54 */     super(paramSessionOutputBuffer, paramLineFormatter);
/*    */   }
/*    */   
/*    */   public DefaultHttpRequestWriter(SessionOutputBuffer paramSessionOutputBuffer) {
/* 58 */     this(paramSessionOutputBuffer, (LineFormatter)null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeHeadLine(HttpRequest paramHttpRequest) throws IOException {
/* 63 */     this.lineFormatter.formatRequestLine(this.lineBuf, paramHttpRequest.getRequestLine());
/* 64 */     this.sessionBuffer.writeLine(this.lineBuf);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\DefaultHttpRequestWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */