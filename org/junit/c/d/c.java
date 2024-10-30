/*    */ package org.junit.c.d;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import org.junit.runner.j;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ abstract class c extends j {
/*    */   private final Lock b;
/* 10 */   private volatile m b = (m)new ReentrantLock();
/*    */ 
/*    */ 
/*    */   
/*    */   public final m a() {
/* 15 */     if (this.b == null) {
/* 16 */       this.b.lock();
/*    */       try {
/* 18 */         if (this.b == null) {
/* 19 */           this.b = b();
/*    */         }
/*    */       } finally {
/* 22 */         this.b.unlock();
/*    */       } 
/*    */     } 
/* 25 */     return this.b;
/*    */   }
/*    */   
/*    */   protected abstract m b();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\d\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */