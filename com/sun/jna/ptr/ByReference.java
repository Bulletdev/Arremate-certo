/*    */ package com.sun.jna.ptr;
/*    */ 
/*    */ import com.sun.jna.Memory;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.PointerType;
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
/*    */ public abstract class ByReference
/*    */   extends PointerType
/*    */ {
/*    */   protected ByReference(int paramInt) {
/* 57 */     setPointer((Pointer)new Memory(paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/*    */     try {
/* 63 */       Method method = getClass().getMethod("getValue", new Class[0]);
/* 64 */       Object object = method.invoke(this, new Object[0]);
/* 65 */       if (object == null) {
/* 66 */         return String.format("null@0x%x", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())) });
/*    */       }
/* 68 */       return String.format("%s@0x%x=%s", new Object[] { object.getClass().getSimpleName(), Long.valueOf(Pointer.nativeValue(getPointer())), object });
/*    */     }
/* 70 */     catch (Exception exception) {
/* 71 */       return String.format("ByReference Contract violated - %s#getValue raised exception: %s", new Object[] {
/* 72 */             getClass().getName(), exception.getMessage()
/*    */           });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\ByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */