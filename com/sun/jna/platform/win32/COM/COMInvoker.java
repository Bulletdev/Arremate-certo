/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.Function;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.PointerType;
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
/*    */ public abstract class COMInvoker
/*    */   extends PointerType
/*    */ {
/*    */   protected int _invokeNativeInt(int paramInt, Object[] paramArrayOfObject) {
/* 34 */     Pointer pointer = getPointer().getPointer(0L);
/*    */ 
/*    */     
/* 37 */     Function function = Function.getFunction(pointer.getPointer((paramInt * Native.POINTER_SIZE)));
/*    */     
/* 39 */     return function.invokeInt(paramArrayOfObject);
/*    */   }
/*    */   
/*    */   protected Object _invokeNativeObject(int paramInt, Object[] paramArrayOfObject, Class<?> paramClass) {
/* 43 */     Pointer pointer = getPointer().getPointer(0L);
/*    */ 
/*    */     
/* 46 */     Function function = Function.getFunction(pointer.getPointer((paramInt * Native.POINTER_SIZE)));
/*    */     
/* 48 */     return function.invoke(paramClass, paramArrayOfObject);
/*    */   }
/*    */   
/*    */   protected void _invokeNativeVoid(int paramInt, Object[] paramArrayOfObject) {
/* 52 */     Pointer pointer = getPointer().getPointer(0L);
/*    */ 
/*    */     
/* 55 */     Function function = Function.getFunction(pointer.getPointer((paramInt * Native.POINTER_SIZE)));
/*    */     
/* 57 */     function.invokeVoid(paramArrayOfObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\COMInvoker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */