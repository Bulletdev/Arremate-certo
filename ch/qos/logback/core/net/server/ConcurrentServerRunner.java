/*     */ package ch.qos.logback.core.net.server;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.RejectedExecutionException;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ConcurrentServerRunner<T extends Client>
/*     */   extends ContextAwareBase
/*     */   implements ServerRunner<T>, Runnable
/*     */ {
/*  49 */   private final Lock clientsLock = new ReentrantLock();
/*     */   
/*  51 */   private final Collection<T> clients = new ArrayList<T>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final ServerListener<T> listener;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Executor executor;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean running;
/*     */ 
/*     */ 
/*     */   
/*     */   public ConcurrentServerRunner(ServerListener<T> paramServerListener, Executor paramExecutor) {
/*  68 */     this.listener = paramServerListener;
/*  69 */     this.executor = paramExecutor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRunning() {
/*  76 */     return this.running;
/*     */   }
/*     */   
/*     */   protected void setRunning(boolean paramBoolean) {
/*  80 */     this.running = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() throws IOException {
/*  87 */     this.listener.close();
/*  88 */     accept(new ClientVisitor<T>(this) {
/*     */           public void visit(T param1T) {
/*  90 */             param1T.close();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void accept(ClientVisitor<T> paramClientVisitor) {
/*  99 */     Collection<T> collection = copyClients();
/* 100 */     for (Client client : collection) {
/*     */       try {
/* 102 */         paramClientVisitor.visit((T)client);
/* 103 */       } catch (RuntimeException runtimeException) {
/* 104 */         addError(client + ": " + runtimeException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Collection<T> copyClients() {
/* 115 */     this.clientsLock.lock();
/*     */     try {
/* 117 */       ArrayList<T> arrayList = new ArrayList<T>(this.clients);
/* 118 */       return arrayList;
/*     */     } finally {
/* 120 */       this.clientsLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 128 */     setRunning(true);
/*     */     try {
/* 130 */       addInfo("listening on " + this.listener);
/* 131 */       while (!Thread.currentThread().isInterrupted()) {
/* 132 */         T t = this.listener.acceptClient();
/* 133 */         if (!configureClient(t)) {
/* 134 */           addError((new StringBuilder()).append(t).append(": connection dropped").toString());
/* 135 */           t.close();
/*     */           continue;
/*     */         } 
/*     */         try {
/* 139 */           this.executor.execute(new a(this, t));
/* 140 */         } catch (RejectedExecutionException rejectedExecutionException) {
/* 141 */           addError((new StringBuilder()).append(t).append(": connection dropped").toString());
/* 142 */           t.close();
/*     */         } 
/*     */       } 
/* 145 */     } catch (InterruptedException interruptedException) {
/*     */     
/* 147 */     } catch (Exception exception) {
/* 148 */       addError("listener: " + exception);
/*     */     } 
/*     */     
/* 151 */     setRunning(false);
/* 152 */     addInfo("shutting down");
/* 153 */     this.listener.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addClient(T paramT) {
/* 173 */     this.clientsLock.lock();
/*     */     try {
/* 175 */       this.clients.add(paramT);
/*     */     } finally {
/* 177 */       this.clientsLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeClient(T paramT) {
/* 186 */     this.clientsLock.lock();
/*     */     try {
/* 188 */       this.clients.remove(paramT);
/*     */     } finally {
/* 190 */       this.clientsLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract boolean configureClient(T paramT);
/*     */   
/*     */   private class a
/*     */     implements Client
/*     */   {
/*     */     private final T a;
/*     */     
/*     */     public a(ConcurrentServerRunner this$0, T param1T) {
/* 203 */       this.a = (ConcurrentServerRunner)param1T;
/*     */     }
/*     */     
/*     */     public void run() {
/* 207 */       this.a.addClient((T)this.a);
/*     */       try {
/* 209 */         this.a.run();
/*     */       } finally {
/* 211 */         this.a.removeClient((T)this.a);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void close() {
/* 216 */       this.a.close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\ConcurrentServerRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */