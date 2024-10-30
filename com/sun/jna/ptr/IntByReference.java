/*    */ package com.sun.jna.ptr;
/*    */ 
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
/*    */ 
/*    */ public class IntByReference
/*    */   extends ByReference
/*    */ {
/*    */   public IntByReference() {
/* 31 */     this(0);
/*    */   }
/*    */   
/*    */   public IntByReference(int paramInt) {
/* 35 */     super(4);
/* 36 */     setValue(paramInt);
/*    */   }
/*    */   
/*    */   public void setValue(int paramInt) {
/* 40 */     getPointer().setInt(0L, paramInt);
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 44 */     return getPointer().getInt(0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 49 */     return String.format("int@0x%1$x=0x%2$x (%2$d)", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), Integer.valueOf(getValue()) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\IntByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */