/*    */ package com.a.a;
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
/*    */ public class q
/*    */   extends i
/*    */ {
/*    */   public q(f paramf, j paramj) {
/* 42 */     super(paramf, paramj);
/*    */   }
/*    */   
/*    */   public void a(l paraml) {
/* 46 */     if (!this.a.isInRange(0, this.a.aE())) {
/* 47 */       throw new IllegalArgumentException("Group iterator not in range");
/*    */     }
/* 49 */     this.a.j(0, 0);
/*    */     
/* 51 */     if (this.bx) {
/* 52 */       paraml.d(this.a.a(this.a.next()).b());
/*    */     } else {
/* 54 */       paraml.e(this.a.a(this.a.next()).b());
/*    */     } 
/* 56 */     while (this.a.hasNext())
/* 57 */       paraml.d(this.a.a(this.a.next()).b()); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\q.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */