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
/*    */ public class StringStack
/*    */ {
/*    */   private String[] stack;
/*    */   private int pos;
/*    */   
/*    */   public StringStack(int paramInt) {
/* 30 */     this.stack = new String[paramInt];
/* 31 */     this.pos = -1;
/*    */   }
/*    */   
/*    */   public String pop() {
/* 35 */     if (this.pos >= 0) {
/* 36 */       return this.stack[this.pos--];
/*    */     }
/*    */     
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void push(String paramString) {
/* 44 */     if (this.pos + 1 < this.stack.length) {
/* 45 */       this.stack[++this.pos] = paramString;
/*    */     } else {
/*    */       
/* 48 */       setSize(this.stack.length * 2);
/* 49 */       this.stack[++this.pos] = paramString;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setSize(int paramInt) {
/* 54 */     if (paramInt != this.stack.length) {
/* 55 */       String[] arrayOfString = new String[paramInt];
/* 56 */       System.arraycopy(this.stack, 0, arrayOfString, 0, Math.min(this.stack.length, paramInt));
/* 57 */       this.stack = arrayOfString;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void clear() {
/* 62 */     this.pos = -1;
/*    */   }
/*    */   
/*    */   public int size() {
/* 66 */     return this.pos + 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccol\\util\StringStack.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */