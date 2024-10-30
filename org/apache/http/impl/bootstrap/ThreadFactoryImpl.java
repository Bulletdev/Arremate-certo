/*    */ package org.apache.http.impl.bootstrap;
/*    */ 
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.atomic.AtomicLong;
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
/*    */ class ThreadFactoryImpl
/*    */   implements ThreadFactory
/*    */ {
/*    */   private final String namePrefix;
/*    */   private final ThreadGroup group;
/*    */   private final AtomicLong count;
/*    */   
/*    */   ThreadFactoryImpl(String paramString, ThreadGroup paramThreadGroup) {
/* 42 */     this.namePrefix = paramString;
/* 43 */     this.group = paramThreadGroup;
/* 44 */     this.count = new AtomicLong();
/*    */   }
/*    */   
/*    */   ThreadFactoryImpl(String paramString) {
/* 48 */     this(paramString, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public Thread newThread(Runnable paramRunnable) {
/* 53 */     return new Thread(this.group, paramRunnable, this.namePrefix + "-" + this.count.incrementAndGet());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\bootstrap\ThreadFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */