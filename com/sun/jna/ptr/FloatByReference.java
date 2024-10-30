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
/*    */ public class FloatByReference
/*    */   extends ByReference
/*    */ {
/*    */   public FloatByReference() {
/* 30 */     this(0.0F);
/*    */   }
/*    */   
/*    */   public FloatByReference(float paramFloat) {
/* 34 */     super(4);
/* 35 */     setValue(paramFloat);
/*    */   }
/*    */   
/*    */   public void setValue(float paramFloat) {
/* 39 */     getPointer().setFloat(0L, paramFloat);
/*    */   }
/*    */   
/*    */   public float getValue() {
/* 43 */     return getPointer().getFloat(0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return String.format("float@0x%x=%s", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), Float.valueOf(getValue()) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\FloatByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */