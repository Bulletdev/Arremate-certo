/*    */ package ch.qos.logback.classic.net.server;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.core.net.server.Client;
/*    */ import ch.qos.logback.core.net.server.ConcurrentServerRunner;
/*    */ import ch.qos.logback.core.net.server.ServerListener;
/*    */ import java.util.concurrent.Executor;
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
/*    */ class c
/*    */   extends ConcurrentServerRunner<a>
/*    */ {
/*    */   public c(ServerListener<a> paramServerListener, Executor paramExecutor) {
/* 39 */     super(paramServerListener, paramExecutor);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean a(a parama) {
/* 47 */     parama.setLoggerContext((LoggerContext)getContext());
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\server\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */