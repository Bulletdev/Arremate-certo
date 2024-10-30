/*    */ package org.d.b;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import org.d.m;
/*    */ 
/*    */ public class d<T>
/*    */   implements Iterator<m> {
/*    */   private Iterator<T> Q;
/*    */   
/*    */   public d(Iterator<T> paramIterator) {
/* 11 */     this.Q = paramIterator;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 16 */     return this.Q.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public m a() {
/* 21 */     return new c(this.Q.next());
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 26 */     this.Q.remove();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\b\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */