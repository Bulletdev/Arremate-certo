/*     */ package com.google.a.b.a;
/*     */ 
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class a
/*     */   implements Runnable
/*     */ {
/*  48 */   private static final Logger logger = Logger.getLogger(a.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String gE = "com.google.common.base.FinalizableReference";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final WeakReference<Class<?>> a;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PhantomReference<Object> b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ReferenceQueue<Object> queue;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference) {
/*  74 */     if (!paramClass.getName().equals("com.google.common.base.FinalizableReference")) {
/*  75 */       throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
/*     */     }
/*     */     
/*  78 */     a a1 = new a(paramClass, paramReferenceQueue, paramPhantomReference);
/*  79 */     String str = a.class.getName();
/*  80 */     Thread thread = null;
/*  81 */     if (a != null) {
/*     */       try {
/*  83 */         boolean bool = false;
/*  84 */         long l = 0L;
/*     */         
/*  86 */         thread = a.newInstance(new Object[] {
/*  87 */               null, a1, str, Long.valueOf(l), Boolean.valueOf(bool) });
/*  88 */       } catch (Throwable throwable) {
/*  89 */         logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", throwable);
/*     */       } 
/*     */     }
/*     */     
/*  93 */     if (thread == null) {
/*  94 */       thread = new Thread((ThreadGroup)null, a1, str);
/*     */     }
/*  96 */     thread.setDaemon(true);
/*     */     
/*     */     try {
/*  99 */       if (a != null) {
/* 100 */         a.set(thread, (Object)null);
/*     */       }
/* 102 */     } catch (Throwable throwable) {
/* 103 */       logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", throwable);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     thread.start();
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
/* 120 */   private static final Constructor<Thread> a = a();
/*     */ 
/*     */   
/* 123 */   private static final Field a = (a == null) ? a() : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference) {
/* 130 */     this.queue = paramReferenceQueue;
/*     */     
/* 132 */     this.a = (Field)new WeakReference<>(paramClass);
/*     */ 
/*     */ 
/*     */     
/* 136 */     this.b = paramPhantomReference;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     while (true) {
/*     */       try {
/*     */         do {
/*     */         
/* 145 */         } while (a(this.queue.remove()));
/*     */         
/*     */         break;
/* 148 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
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
/*     */   private boolean a(Reference<?> paramReference) {
/* 161 */     Method method = e();
/* 162 */     if (method == null) {
/* 163 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 170 */       paramReference.clear();
/*     */       
/* 172 */       if (paramReference == this.b)
/*     */       {
/*     */ 
/*     */         
/* 176 */         return false;
/*     */       }
/*     */       
/*     */       try {
/* 180 */         method.invoke(paramReference, new Object[0]);
/* 181 */       } catch (Throwable throwable) {
/* 182 */         logger.log(Level.SEVERE, "Error cleaning up after reference.", throwable);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       if ((paramReference = this.queue.poll()) == null)
/* 190 */         return true; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Method e() {
/* 195 */     Class clazz = this.a.get();
/* 196 */     if (clazz == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 203 */       return null;
/*     */     }
/*     */     try {
/* 206 */       return clazz.getMethod("finalizeReferent", new Class[0]);
/* 207 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 208 */       throw new AssertionError(noSuchMethodException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Field a() {
/*     */     try {
/* 214 */       Field field = Thread.class.getDeclaredField("inheritableThreadLocals");
/* 215 */       field.setAccessible(true);
/* 216 */       return field;
/* 217 */     } catch (Throwable throwable) {
/* 218 */       logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
/*     */ 
/*     */ 
/*     */       
/* 222 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Constructor<Thread> a() {
/*     */     try {
/* 228 */       return Thread.class.getConstructor(new Class[] { ThreadGroup.class, Runnable.class, String.class, long.class, boolean.class });
/*     */     }
/* 230 */     catch (Throwable throwable) {
/*     */       
/* 232 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */