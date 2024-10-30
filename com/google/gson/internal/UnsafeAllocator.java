/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
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
/*     */ public abstract class UnsafeAllocator
/*     */ {
/*     */   public abstract <T> T newInstance(Class<T> paramClass) throws Exception;
/*     */   
/*     */   public static UnsafeAllocator create() {
/*     */     try {
/*  40 */       Class<?> clazz = Class.forName("sun.misc.Unsafe");
/*  41 */       Field field = clazz.getDeclaredField("theUnsafe");
/*  42 */       field.setAccessible(true);
/*  43 */       final Object unsafe = field.get((Object)null);
/*  44 */       final Method newInstance = clazz.getMethod("allocateInstance", new Class[] { Class.class });
/*  45 */       return new UnsafeAllocator()
/*     */         {
/*     */           public <T> T newInstance(Class<T> param1Class) throws Exception
/*     */           {
/*  49 */             assertInstantiable(param1Class);
/*  50 */             return (T)allocateInstance.invoke(unsafe, new Object[] { param1Class });
/*     */           }
/*     */         };
/*  53 */     } catch (Exception exception) {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  63 */         Method method1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
/*  64 */         method1.setAccessible(true);
/*  65 */         final int constructorId = ((Integer)method1.invoke((Object)null, new Object[] { Object.class })).intValue();
/*     */         
/*  67 */         final Method newInstance = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, int.class });
/*  68 */         method2.setAccessible(true);
/*  69 */         return new UnsafeAllocator()
/*     */           {
/*     */             public <T> T newInstance(Class<T> param1Class) throws Exception
/*     */             {
/*  73 */               assertInstantiable(param1Class);
/*  74 */               return (T)newInstance.invoke((Object)null, new Object[] { param1Class, Integer.valueOf(this.val$constructorId) });
/*     */             }
/*     */           };
/*  77 */       } catch (Exception exception1) {
/*     */ 
/*     */         
/*     */         try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  87 */           final Method newInstance = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
/*  88 */           method.setAccessible(true);
/*  89 */           return new UnsafeAllocator()
/*     */             {
/*     */               public <T> T newInstance(Class<T> param1Class) throws Exception
/*     */               {
/*  93 */                 assertInstantiable(param1Class);
/*  94 */                 return (T)newInstance.invoke((Object)null, new Object[] { param1Class, Object.class });
/*     */               }
/*     */             };
/*  97 */         } catch (Exception exception2) {
/*     */ 
/*     */ 
/*     */           
/* 101 */           return new UnsafeAllocator()
/*     */             {
/*     */               public <T> T newInstance(Class<T> param1Class) {
/* 104 */                 throw new UnsupportedOperationException("Cannot allocate " + param1Class);
/*     */               }
/*     */             };
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void assertInstantiable(Class<?> paramClass) {
/* 115 */     int i = paramClass.getModifiers();
/* 116 */     if (Modifier.isInterface(i)) {
/* 117 */       throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + paramClass.getName());
/*     */     }
/* 119 */     if (Modifier.isAbstract(i))
/* 120 */       throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + paramClass.getName()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\UnsafeAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */