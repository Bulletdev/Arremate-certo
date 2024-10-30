/*    */ package com.sun.jna;
/*    */ 
/*    */ import java.lang.ref.Reference;
/*    */ import java.lang.ref.ReferenceQueue;
/*    */ import java.lang.ref.WeakReference;
/*    */ import java.util.IdentityHashMap;
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
/*    */ public class WeakMemoryHolder
/*    */ {
/* 41 */   ReferenceQueue<Object> referenceQueue = new ReferenceQueue();
/* 42 */   IdentityHashMap<Reference<Object>, Memory> backingMap = new IdentityHashMap<Reference<Object>, Memory>();
/*    */   
/*    */   public synchronized void put(Object paramObject, Memory paramMemory) {
/* 45 */     clean();
/* 46 */     WeakReference<Object> weakReference = new WeakReference(paramObject, this.referenceQueue);
/* 47 */     this.backingMap.put(weakReference, paramMemory);
/*    */   }
/*    */   
/*    */   public synchronized void clean() {
/* 51 */     for (Reference<?> reference = this.referenceQueue.poll(); reference != null; reference = this.referenceQueue.poll())
/* 52 */       this.backingMap.remove(reference); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\WeakMemoryHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */