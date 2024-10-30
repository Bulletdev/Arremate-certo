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
/*    */ public final class IntStack
/*    */ {
/*    */   private int[] stack;
/*    */   private int pos;
/*    */   
/*    */   public IntStack(int paramInt) {
/* 33 */     this.stack = new int[paramInt];
/* 34 */     this.pos = -1;
/*    */   }
/*    */   
/*    */   public int pop() {
/* 38 */     if (this.pos >= 0) {
/* 39 */       return this.stack[this.pos--];
/*    */     }
/*    */     
/* 42 */     throw new ArrayIndexOutOfBoundsException("stack underflow");
/*    */   }
/*    */   
/*    */   public void push(int paramInt) {
/* 46 */     if (this.pos + 1 < this.stack.length) {
/* 47 */       this.stack[++this.pos] = paramInt;
/*    */     } else {
/*    */       
/* 50 */       setSize(this.stack.length * 2);
/* 51 */       this.stack[++this.pos] = paramInt;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setSize(int paramInt) {
/* 56 */     if (paramInt != this.stack.length) {
/* 57 */       int[] arrayOfInt = new int[paramInt];
/* 58 */       System.arraycopy(this.stack, 0, arrayOfInt, 0, Math.min(this.stack.length, paramInt));
/*    */       
/* 60 */       this.stack = arrayOfInt;
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


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccol\\util\IntStack.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */