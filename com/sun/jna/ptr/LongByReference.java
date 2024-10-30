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
/*    */ public class LongByReference
/*    */   extends ByReference
/*    */ {
/*    */   public LongByReference() {
/* 30 */     this(0L);
/*    */   }
/*    */   
/*    */   public LongByReference(long paramLong) {
/* 34 */     super(8);
/* 35 */     setValue(paramLong);
/*    */   }
/*    */   
/*    */   public void setValue(long paramLong) {
/* 39 */     getPointer().setLong(0L, paramLong);
/*    */   }
/*    */   
/*    */   public long getValue() {
/* 43 */     return getPointer().getLong(0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return String.format("long@0x%1$x=0x%2$x (%2$d)", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), Long.valueOf(getValue()) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\LongByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */