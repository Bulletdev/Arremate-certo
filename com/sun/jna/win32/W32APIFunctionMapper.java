/*    */ package com.sun.jna.win32;
/*    */ 
/*    */ import com.sun.jna.FunctionMapper;
/*    */ import com.sun.jna.NativeLibrary;
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
/*    */ public class W32APIFunctionMapper
/*    */   implements FunctionMapper
/*    */ {
/* 35 */   public static final FunctionMapper UNICODE = new W32APIFunctionMapper(true);
/* 36 */   public static final FunctionMapper ASCII = new W32APIFunctionMapper(false);
/*    */   
/*    */   protected W32APIFunctionMapper(boolean paramBoolean) {
/* 39 */     this.suffix = paramBoolean ? "W" : "A";
/*    */   }
/*    */   
/*    */   private final String suffix;
/*    */   
/*    */   public String getFunctionName(NativeLibrary paramNativeLibrary, Method paramMethod) {
/* 45 */     String str = paramMethod.getName();
/* 46 */     if (!str.endsWith("W") && !str.endsWith("A")) {
/*    */       try {
/* 48 */         str = paramNativeLibrary.getFunction(str + this.suffix, 63).getName();
/*    */       }
/* 50 */       catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
/*    */     }
/*    */ 
/*    */     
/* 54 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\win32\W32APIFunctionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */