/*    */ package org.junit.c.d;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import org.junit.runner.a.j;
/*    */ import org.junit.runner.c;
/*    */ import org.junit.runner.j;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ public class e
/*    */   extends j {
/*    */   private final j a;
/*    */   private final Comparator<c> comparator;
/*    */   
/*    */   public e(j paramj, Comparator<c> paramComparator) {
/* 15 */     this.a = paramj;
/* 16 */     this.comparator = paramComparator;
/*    */   }
/*    */ 
/*    */   
/*    */   public m a() {
/* 21 */     m m = this.a.a();
/* 22 */     (new j(this.comparator)).I(m);
/* 23 */     return m;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\d\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */