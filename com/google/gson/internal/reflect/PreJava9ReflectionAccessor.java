/*    */ package com.google.gson.internal.reflect;
/*    */ 
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
/*    */ final class PreJava9ReflectionAccessor
/*    */   extends ReflectionAccessor
/*    */ {
/*    */   public void makeAccessible(AccessibleObject paramAccessibleObject) {
/* 31 */     paramAccessibleObject.setAccessible(true);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\reflect\PreJava9ReflectionAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */