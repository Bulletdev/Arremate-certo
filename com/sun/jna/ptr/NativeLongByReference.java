/*    */ package com.sun.jna.ptr;
/*    */ 
/*    */ import com.sun.jna.NativeLong;
/*    */ import com.sun.jna.Pointer;
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
/*    */ public class NativeLongByReference
/*    */   extends ByReference
/*    */ {
/*    */   public NativeLongByReference() {
/* 31 */     this(new NativeLong(0L));
/*    */   }
/*    */   
/*    */   public NativeLongByReference(NativeLong paramNativeLong) {
/* 35 */     super(NativeLong.SIZE);
/* 36 */     setValue(paramNativeLong);
/*    */   }
/*    */   
/*    */   public void setValue(NativeLong paramNativeLong) {
/* 40 */     getPointer().setNativeLong(0L, paramNativeLong);
/*    */   }
/*    */   
/*    */   public NativeLong getValue() {
/* 44 */     return getPointer().getNativeLong(0L);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     if (NativeLong.SIZE > 4) {
/* 51 */       return String.format("NativeLong@0x1$%x=0x%2$x (%2$d)", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), 
/* 52 */             Long.valueOf(getValue().longValue()) });
/*    */     }
/* 54 */     return String.format("NativeLong@0x1$%x=0x%2$x (%2$d)", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), 
/* 55 */           Integer.valueOf(getValue().intValue()) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\NativeLongByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */