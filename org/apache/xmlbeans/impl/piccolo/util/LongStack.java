/*    */ package org.apache.xmlbeans.impl.piccolo.util;
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
/*    */ public final class LongStack
/*    */ {
/*    */   private long[] stack;
/*    */   private int pos;
/*    */   
/*    */   public LongStack(int paramInt) {
/* 33 */     this.stack = new long[paramInt];
/* 34 */     this.pos = -1;
/*    */   }
/*    */   
/*    */   public long pop() {
/* 38 */     if (this.pos >= 0) {
/* 39 */       return this.stack[this.pos--];
/*    */     }
/*    */     
/* 42 */     throw new ArrayIndexOutOfBoundsException("stack underflow");
/*    */   }
/*    */   
/*    */   public void push(long paramLong) {
/* 46 */     if (this.pos + 1 < this.stack.length) {
/* 47 */       this.stack[++this.pos] = paramLong;
/*    */     } else {
/*    */       
/* 50 */       setSize(this.stack.length * 2);
/* 51 */       this.stack[++this.pos] = paramLong;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setSize(int paramInt) {
/* 56 */     if (paramInt != this.stack.length) {
/* 57 */       long[] arrayOfLong = new long[paramInt];
/* 58 */       System.arraycopy(this.stack, 0, arrayOfLong, 0, Math.min(this.stack.length, paramInt));
/*    */       
/* 60 */       this.stack = arrayOfLong;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void clear() {
/* 65 */     this.pos = -1;
/*    */   }
/*    */   
/*    */   public int size() {
/* 69 */     return this.pos + 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccol\\util\LongStack.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */