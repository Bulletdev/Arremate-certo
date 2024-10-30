/*    */ package com.google.gson.internal.reflect;
/*    */ 
/*    */ import com.google.gson.internal.JavaVersion;
/*    */ import java.lang.reflect.AccessibleObject;
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
/*    */ public abstract class ReflectionAccessor
/*    */ {
/* 36 */   private static final ReflectionAccessor instance = (JavaVersion.getMajorJavaVersion() < 9) ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void makeAccessible(AccessibleObject paramAccessibleObject);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ReflectionAccessor getInstance() {
/* 52 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\reflect\ReflectionAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */