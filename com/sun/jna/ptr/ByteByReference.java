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
/*    */ public class ByteByReference
/*    */   extends ByReference
/*    */ {
/*    */   public ByteByReference() {
/* 31 */     this((byte)0);
/*    */   }
/*    */   
/*    */   public ByteByReference(byte paramByte) {
/* 35 */     super(1);
/* 36 */     setValue(paramByte);
/*    */   }
/*    */   
/*    */   public void setValue(byte paramByte) {
/* 40 */     getPointer().setByte(0L, paramByte);
/*    */   }
/*    */   
/*    */   public byte getValue() {
/* 44 */     return getPointer().getByte(0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 49 */     return String.format("byte@0x%1$x=0x%2$x (%2$d)", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())), Byte.valueOf(getValue()) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ptr\ByteByReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */