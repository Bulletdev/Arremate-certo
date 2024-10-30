/*    */ package com.google.gson.internal.reflect;
/*    */ 
/*    */ import com.google.gson.JsonIOException;
/*    */ import java.lang.reflect.AccessibleObject;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
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
/*    */ final class UnsafeReflectionAccessor
/*    */   extends ReflectionAccessor
/*    */ {
/*    */   private static Class unsafeClass;
/* 34 */   private final Object theUnsafe = getUnsafeInstance();
/* 35 */   private final Field overrideField = getOverrideField();
/*    */ 
/*    */ 
/*    */   
/*    */   public void makeAccessible(AccessibleObject paramAccessibleObject) {
/* 40 */     boolean bool = makeAccessibleWithUnsafe(paramAccessibleObject);
/* 41 */     if (!bool) {
/*    */       
/*    */       try {
/* 44 */         paramAccessibleObject.setAccessible(true);
/* 45 */       } catch (SecurityException securityException) {
/* 46 */         throw new JsonIOException("Gson couldn't modify fields for " + paramAccessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", securityException);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean makeAccessibleWithUnsafe(AccessibleObject paramAccessibleObject) {
/* 55 */     if (this.theUnsafe != null && this.overrideField != null) {
/*    */       try {
/* 57 */         Method method1 = unsafeClass.getMethod("objectFieldOffset", new Class[] { Field.class });
/* 58 */         long l = ((Long)method1.invoke(this.theUnsafe, new Object[] { this.overrideField })).longValue();
/* 59 */         Method method2 = unsafeClass.getMethod("putBoolean", new Class[] { Object.class, long.class, boolean.class });
/* 60 */         method2.invoke(this.theUnsafe, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.valueOf(true) });
/* 61 */         return true;
/* 62 */       } catch (Exception exception) {}
/*    */     }
/*    */     
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   private static Object getUnsafeInstance() {
/*    */     try {
/* 70 */       unsafeClass = Class.forName("sun.misc.Unsafe");
/* 71 */       Field field = unsafeClass.getDeclaredField("theUnsafe");
/* 72 */       field.setAccessible(true);
/* 73 */       return field.get((Object)null);
/* 74 */     } catch (Exception exception) {
/* 75 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static Field getOverrideField() {
/*    */     try {
/* 81 */       return AccessibleObject.class.getDeclaredField("override");
/* 82 */     } catch (NoSuchFieldException noSuchFieldException) {
/* 83 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\reflect\UnsafeReflectionAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */