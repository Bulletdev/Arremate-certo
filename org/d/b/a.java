/*    */ package org.d.b;
/*    */ 
/*    */ import java.lang.reflect.Array;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class a implements Iterator<Object> {
/*    */   private final Object array;
/*  8 */   private int currentIndex = 0;
/*    */   
/*    */   public a(Object paramObject) {
/* 11 */     if (!paramObject.getClass().isArray()) {
/* 12 */       throw new IllegalArgumentException("not an array");
/*    */     }
/* 14 */     this.array = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 19 */     return (this.currentIndex < Array.getLength(this.array));
/*    */   }
/*    */ 
/*    */   
/*    */   public Object next() {
/* 24 */     return Array.get(this.array, this.currentIndex++);
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 29 */     throw new UnsupportedOperationException("cannot remove items from an array");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */