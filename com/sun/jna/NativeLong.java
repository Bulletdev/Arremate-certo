/*    */ package com.sun.jna;
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
/*    */ public class NativeLong
/*    */   extends IntegerType
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 35 */   public static final int SIZE = Native.LONG_SIZE;
/*    */ 
/*    */   
/*    */   public NativeLong() {
/* 39 */     this(0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public NativeLong(long paramLong) {
/* 44 */     this(paramLong, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public NativeLong(long paramLong, boolean paramBoolean) {
/* 49 */     super(SIZE, paramLong, paramBoolean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\NativeLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */