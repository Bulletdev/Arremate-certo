/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ public class DebuggingThreadLocal<T>
/*    */ {
/* 19 */   private final ConcurrentHashMap<Long, T> map = new ConcurrentHashMap<>();
/*    */   
/*    */   public void set(T paramT) {
/* 22 */     this.map.put(Long.valueOf(Thread.currentThread().getId()), paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void remove() {
/* 29 */     this.map.remove(Long.valueOf(Thread.currentThread().getId()));
/*    */   }
/*    */   
/*    */   public T get() {
/* 33 */     return this.map.get(Long.valueOf(Thread.currentThread().getId()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HashMap<Long, T> getSnapshotOfAllThreads() {
/* 42 */     return new HashMap<>(this.map);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\DebuggingThreadLocal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */