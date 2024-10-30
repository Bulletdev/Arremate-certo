/*    */ package org.apache.http.message;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParserCursor
/*    */ {
/*    */   private final int lowerBound;
/*    */   private final int upperBound;
/*    */   private int pos;
/*    */   
/*    */   public ParserCursor(int paramInt1, int paramInt2) {
/* 47 */     if (paramInt1 < 0) {
/* 48 */       throw new IndexOutOfBoundsException("Lower bound cannot be negative");
/*    */     }
/* 50 */     if (paramInt1 > paramInt2) {
/* 51 */       throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
/*    */     }
/* 53 */     this.lowerBound = paramInt1;
/* 54 */     this.upperBound = paramInt2;
/* 55 */     this.pos = paramInt1;
/*    */   }
/*    */   
/*    */   public int getLowerBound() {
/* 59 */     return this.lowerBound;
/*    */   }
/*    */   
/*    */   public int getUpperBound() {
/* 63 */     return this.upperBound;
/*    */   }
/*    */   
/*    */   public int getPos() {
/* 67 */     return this.pos;
/*    */   }
/*    */   
/*    */   public void updatePos(int paramInt) {
/* 71 */     if (paramInt < this.lowerBound) {
/* 72 */       throw new IndexOutOfBoundsException("pos: " + paramInt + " < lowerBound: " + this.lowerBound);
/*    */     }
/* 74 */     if (paramInt > this.upperBound) {
/* 75 */       throw new IndexOutOfBoundsException("pos: " + paramInt + " > upperBound: " + this.upperBound);
/*    */     }
/* 77 */     this.pos = paramInt;
/*    */   }
/*    */   
/*    */   public boolean atEnd() {
/* 81 */     return (this.pos >= this.upperBound);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder stringBuilder = new StringBuilder();
/* 87 */     stringBuilder.append('[');
/* 88 */     stringBuilder.append(Integer.toString(this.lowerBound));
/* 89 */     stringBuilder.append('>');
/* 90 */     stringBuilder.append(Integer.toString(this.pos));
/* 91 */     stringBuilder.append('>');
/* 92 */     stringBuilder.append(Integer.toString(this.upperBound));
/* 93 */     stringBuilder.append(']');
/* 94 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\ParserCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */