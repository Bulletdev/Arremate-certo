/*     */ package org.h2.util;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbbaDetector
/*     */ {
/*     */   private static final boolean TRACE = false;
/*     */   
/*  22 */   private static final ThreadLocal<Deque<Object>> STACK = new ThreadLocal<Deque<Object>>()
/*     */     {
/*     */       protected Deque<Object> initialValue() {
/*  25 */         return new ArrayDeque();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   private static final Map<Object, Map<Object, Exception>> LOCK_ORDERING = new WeakHashMap<>();
/*     */ 
/*     */   
/*  37 */   private static final Set<String> KNOWN_DEADLOCKS = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object begin(Object<?> paramObject) {
/*  47 */     if (paramObject == null) {
/*  48 */       paramObject = (Object<?>)(new SecurityManager() {
/*  49 */           Class<?> clazz = getClassContext()[2];
/*     */         }).clazz;
/*     */     }
/*  52 */     Deque<Object> deque = STACK.get();
/*  53 */     if (!deque.isEmpty()) {
/*     */ 
/*     */       
/*  56 */       if (deque.contains(paramObject))
/*     */       {
/*  58 */         return paramObject;
/*     */       }
/*  60 */       while (!deque.isEmpty()) {
/*  61 */         Object object = deque.peek();
/*  62 */         if (Thread.holdsLock(object)) {
/*     */           break;
/*     */         }
/*  65 */         deque.pop();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     if (deque.size() > 0) {
/*  75 */       markHigher(paramObject, deque);
/*     */     }
/*  77 */     deque.push(paramObject);
/*  78 */     return paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object getTest(Object paramObject) {
/*  83 */     return paramObject;
/*     */   }
/*     */   
/*     */   private static String getObjectName(Object paramObject) {
/*  87 */     return paramObject.getClass().getSimpleName() + "@" + System.identityHashCode(paramObject);
/*     */   }
/*     */   
/*     */   private static synchronized void markHigher(Object paramObject, Deque<Object> paramDeque) {
/*  91 */     Object object = getTest(paramObject);
/*  92 */     Map<Object, Object> map = (Map)LOCK_ORDERING.get(object);
/*  93 */     if (map == null) {
/*  94 */       map = new WeakHashMap<>();
/*  95 */       LOCK_ORDERING.put(object, map);
/*     */     } 
/*  97 */     Exception exception = null;
/*  98 */     for (Object object1 : paramDeque) {
/*  99 */       Object object2 = getTest(object1);
/* 100 */       if (object2 == object) {
/*     */         continue;
/*     */       }
/* 103 */       Map map1 = LOCK_ORDERING.get(object2);
/* 104 */       if (map1 != null) {
/* 105 */         Exception exception1 = (Exception)map1.get(object);
/* 106 */         if (exception1 != null) {
/* 107 */           String str = object.getClass() + " " + object2.getClass();
/* 108 */           if (!KNOWN_DEADLOCKS.contains(str)) {
/* 109 */             String str1 = getObjectName(object) + " synchronized after \n " + getObjectName(object2) + ", but in the past before";
/*     */ 
/*     */             
/* 112 */             RuntimeException runtimeException = new RuntimeException(str1);
/* 113 */             runtimeException.initCause(exception1);
/* 114 */             runtimeException.printStackTrace(System.out);
/*     */             
/* 116 */             KNOWN_DEADLOCKS.add(str);
/*     */           } 
/*     */         } 
/*     */       } 
/* 120 */       if (!map.containsKey(object2)) {
/* 121 */         if (exception == null) {
/* 122 */           exception = new Exception("Before");
/*     */         }
/* 124 */         map.put(object2, exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\AbbaDetector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */