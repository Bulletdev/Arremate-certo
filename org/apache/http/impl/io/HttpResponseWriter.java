/*    */ package org.apache.http.impl.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpMessage;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.io.SessionOutputBuffer;
/*    */ import org.apache.http.message.LineFormatter;
/*    */ import org.apache.http.params.HttpParams;
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
/*    */ public class HttpResponseWriter
/*    */   extends AbstractMessageWriter<HttpResponse>
/*    */ {
/*    */   public HttpResponseWriter(SessionOutputBuffer paramSessionOutputBuffer, LineFormatter paramLineFormatter, HttpParams paramHttpParams) {
/* 51 */     super(paramSessionOutputBuffer, paramLineFormatter, paramHttpParams);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void writeHeadLine(HttpResponse paramHttpResponse) throws IOException {
/* 56 */     this.lineFormatter.formatStatusLine(this.lineBuf, paramHttpResponse.getStatusLine());
/* 57 */     this.sessionBuffer.writeLine(this.lineBuf);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\HttpResponseWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */