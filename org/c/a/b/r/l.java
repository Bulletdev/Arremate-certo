/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ public class l<L, R>
/*    */   implements Comparable<l<L, R>>
/*    */ {
/*    */   private final L left;
/*    */   private final R right;
/*    */   
/*    */   private l(L paramL, R paramR) {
/* 35 */     this.left = paramL;
/* 36 */     this.right = paramR;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <L, R> l<L, R> a(L paramL, R paramR) {
/* 47 */     return new l<>(paramL, paramR);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public L getLeft() {
/* 54 */     return this.left;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public R getRight() {
/* 61 */     return this.right;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 66 */     if (this == paramObject) return true; 
/* 67 */     if (paramObject == null || getClass() != paramObject.getClass()) return false; 
/* 68 */     l l1 = (l)paramObject;
/* 69 */     return (this.left.equals(l1.left) && this.right.equals(l1.right));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 74 */     return Arrays.hashCode(new Object[] { this.left, this.right });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int a(l<L, R> paraml) {
/* 80 */     if (this.left instanceof Comparable) {
/* 81 */       int i = ((Comparable<L>)this.left).compareTo(paraml.left);
/* 82 */       if (i != 0) {
/* 83 */         return i;
/*    */       }
/*    */     } 
/* 86 */     if (this.right instanceof Comparable) {
/* 87 */       int i = ((Comparable<R>)this.right).compareTo(paraml.right);
/* 88 */       if (i != 0) {
/* 89 */         return i;
/*    */       }
/*    */     } 
/* 92 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */