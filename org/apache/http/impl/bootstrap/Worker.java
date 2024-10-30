/*    */ package org.apache.http.impl.bootstrap;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.ExceptionLogger;
/*    */ import org.apache.http.HttpServerConnection;
/*    */ import org.apache.http.protocol.BasicHttpContext;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ import org.apache.http.protocol.HttpCoreContext;
/*    */ import org.apache.http.protocol.HttpService;
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
/*    */ class Worker
/*    */   implements Runnable
/*    */ {
/*    */   private final HttpService httpservice;
/*    */   private final HttpServerConnection conn;
/*    */   private final ExceptionLogger exceptionLogger;
/*    */   
/*    */   Worker(HttpService paramHttpService, HttpServerConnection paramHttpServerConnection, ExceptionLogger paramExceptionLogger) {
/* 51 */     this.httpservice = paramHttpService;
/* 52 */     this.conn = paramHttpServerConnection;
/* 53 */     this.exceptionLogger = paramExceptionLogger;
/*    */   }
/*    */   
/*    */   public HttpServerConnection getConnection() {
/* 57 */     return this.conn;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     try {
/* 63 */       BasicHttpContext basicHttpContext = new BasicHttpContext();
/* 64 */       HttpCoreContext httpCoreContext = HttpCoreContext.adapt((HttpContext)basicHttpContext);
/* 65 */       while (!Thread.interrupted() && this.conn.isOpen()) {
/* 66 */         this.httpservice.handleRequest(this.conn, (HttpContext)httpCoreContext);
/* 67 */         basicHttpContext.clear();
/*    */       } 
/* 69 */       this.conn.close();
/* 70 */     } catch (Exception exception) {
/* 71 */       this.exceptionLogger.log(exception);
/*    */     } finally {
/*    */       try {
/* 74 */         this.conn.shutdown();
/* 75 */       } catch (IOException iOException) {
/* 76 */         this.exceptionLogger.log(iOException);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\bootstrap\Worker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */