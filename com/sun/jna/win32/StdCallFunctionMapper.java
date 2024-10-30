/*    */ package com.sun.jna.win32;
/*    */ 
/*    */ import com.sun.jna.Function;
/*    */ import com.sun.jna.FunctionMapper;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.NativeLibrary;
/*    */ import com.sun.jna.NativeMapped;
/*    */ import com.sun.jna.NativeMappedConverter;
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
/*    */ public class StdCallFunctionMapper
/*    */   implements FunctionMapper
/*    */ {
/*    */   protected int getArgumentNativeStackSize(Class<?> paramClass) {
/* 48 */     if (NativeMapped.class.isAssignableFrom(paramClass)) {
/* 49 */       paramClass = NativeMappedConverter.getInstance(paramClass).nativeType();
/*    */     }
/* 51 */     if (paramClass.isArray()) {
/* 52 */       return Native.POINTER_SIZE;
/*    */     }
/*    */     try {
/* 55 */       return Native.getNativeSize(paramClass);
/* 56 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 57 */       throw new IllegalArgumentException("Unknown native stack allocation size for " + paramClass);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFunctionName(NativeLibrary paramNativeLibrary, Method paramMethod) {
/* 70 */     String str1 = paramMethod.getName();
/* 71 */     int i = 0;
/* 72 */     Class[] arrayOfClass = paramMethod.getParameterTypes();
/* 73 */     for (Class<?> clazz : arrayOfClass) {
/* 74 */       i += getArgumentNativeStackSize(clazz);
/*    */     }
/*    */     
/* 77 */     String str2 = str1 + "@" + i;
/* 78 */     byte b = 63;
/*    */     try {
/* 80 */       Function function = paramNativeLibrary.getFunction(str2, b);
/* 81 */       str1 = function.getName();
/* 82 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/*    */       
/*    */       try {
/* 85 */         Function function = paramNativeLibrary.getFunction("_" + str2, b);
/* 86 */         str1 = function.getName();
/* 87 */       } catch (UnsatisfiedLinkError unsatisfiedLinkError1) {}
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 92 */     return str1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\win32\StdCallFunctionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */