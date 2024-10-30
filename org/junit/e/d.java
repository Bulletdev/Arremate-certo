/*    */ package org.junit.e;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.d.k;
/*    */ import org.junit.d.a;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class d
/*    */ {
/* 16 */   private final List<k<?>> aJ = new ArrayList<k<?>>();
/*    */   
/*    */   void d(k<?> paramk) {
/* 19 */     this.aJ.add(paramk);
/*    */   }
/*    */   
/*    */   boolean gp() {
/* 23 */     return !this.aJ.isEmpty();
/*    */   }
/*    */   
/*    */   k<Throwable> e() {
/* 27 */     return a.f(f());
/*    */   }
/*    */   
/*    */   private k<Throwable> f() {
/* 31 */     if (this.aJ.size() == 1) {
/* 32 */       return j(this.aJ.get(0));
/*    */     }
/* 34 */     return org.d.d.a(bn());
/*    */   }
/*    */ 
/*    */   
/*    */   private List<k<? super Throwable>> bn() {
/* 39 */     return (List)new ArrayList<k<?>>(this.aJ);
/*    */   }
/*    */ 
/*    */   
/*    */   private k<Throwable> j(k<?> paramk) {
/* 44 */     return (k)paramk;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */