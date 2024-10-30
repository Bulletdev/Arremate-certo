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
/*    */ public class DoubleByReference
/*    */   extends ByReference
/*    */ {
/*    */   public DoubleByReference() {
/* 30 */     this(0.0D);
/*    */   }
/*    */   
/*    */   public DoubleByReference(double paramDouble) {
/* 34 */     super(8);
/* 35 */     setValue(paramDouble);
/*    */   }
/*    */   
/*    */   public void setValue(double paramDouble) {
/* 39 */     getPointer().setDouble(0L, paramDouble);
/*    */   }
/*    */   
/*    */   public double getValue() {
/* 43 */     return getPointer().getDouble(0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return String.format("double@0x%x=%s", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), Double.valueOf(getValue()) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\DoubleByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */