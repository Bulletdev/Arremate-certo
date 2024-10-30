/*    */ package org.junit.f;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Comparator;
/*    */ import org.junit.c.i;
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
/*    */ public enum d
/*    */ {
/* 19 */   a(i.k),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   b(null),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 30 */   c(i.j);
/*    */   
/*    */   private final Comparator<Method> comparator;
/*    */   
/*    */   d(Comparator<Method> paramComparator) {
/* 35 */     this.comparator = paramComparator;
/*    */   }
/*    */   
/*    */   public Comparator<Method> getComparator() {
/* 39 */     return this.comparator;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */