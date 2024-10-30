/*    */ package ch.qos.logback.core.net.server;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.concurrent.ArrayBlockingQueue;
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
/*    */ 
/*    */ class c
/*    */   extends ConcurrentServerRunner<a>
/*    */ {
/*    */   private final int clientQueueSize;
/*    */   
/*    */   public c(ServerListener<a> paramServerListener, Executor paramExecutor, int paramInt) {
/* 40 */     super(paramServerListener, paramExecutor);
/* 41 */     this.clientQueueSize = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean a(a parama) {
/* 49 */     parama.setContext(getContext());
/* 50 */     parama.a(new ArrayBlockingQueue<Serializable>(this.clientQueueSize));
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */