/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.IdentityHashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SynchronizedVerifier
/*    */ {
/*    */   private static volatile boolean enabled;
/* 20 */   private static final Map<Class<?>, AtomicBoolean> DETECT = Collections.synchronizedMap(new HashMap<>());
/*    */   
/* 22 */   private static final Map<Object, Object> CURRENT = Collections.synchronizedMap(new IdentityHashMap<>());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setDetect(Class<?> paramClass, boolean paramBoolean) {
/* 32 */     if (paramBoolean) {
/* 33 */       DETECT.put(paramClass, new AtomicBoolean());
/*    */     } else {
/* 35 */       AtomicBoolean atomicBoolean = DETECT.remove(paramClass);
/* 36 */       if (atomicBoolean == null)
/* 37 */         throw new AssertionError("Detection was not enabled"); 
/* 38 */       if (!atomicBoolean.get()) {
/* 39 */         throw new AssertionError("No object of this class was tested");
/*    */       }
/*    */     } 
/* 42 */     enabled = (DETECT.size() > 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void check(Object paramObject) {
/* 51 */     if (enabled) {
/* 52 */       detectConcurrentAccess(paramObject);
/*    */     }
/*    */   }
/*    */   
/*    */   private static void detectConcurrentAccess(Object paramObject) {
/* 57 */     AtomicBoolean atomicBoolean = DETECT.get(paramObject.getClass());
/* 58 */     if (atomicBoolean != null) {
/* 59 */       atomicBoolean.set(true);
/* 60 */       if (CURRENT.remove(paramObject) != null) {
/* 61 */         throw new AssertionError("Concurrent access");
/*    */       }
/* 63 */       CURRENT.put(paramObject, paramObject);
/*    */       try {
/* 65 */         Thread.sleep(1L);
/* 66 */       } catch (InterruptedException interruptedException) {}
/*    */ 
/*    */       
/* 69 */       Object object = CURRENT.remove(paramObject);
/* 70 */       if (object == null)
/* 71 */         throw new AssertionError("Concurrent access"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\SynchronizedVerifier.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */