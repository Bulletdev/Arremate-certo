/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.k;
/*    */ 
/*    */ abstract class n<T>
/*    */   extends b<T> {
/*    */   private final Iterable<k<? super T>> h;
/*    */   
/*    */   public n(Iterable<k<? super T>> paramIterable) {
/* 12 */     this.h = paramIterable;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean E(Object paramObject);
/*    */ 
/*    */   
/*    */   public abstract void a(g paramg);
/*    */   
/*    */   protected boolean a(Object paramObject, boolean paramBoolean) {
/* 22 */     for (k<? super T> k : this.h) {
/* 23 */       if (k.E(paramObject) == paramBoolean) {
/* 24 */         return paramBoolean;
/*    */       }
/*    */     } 
/* 27 */     return !paramBoolean;
/*    */   }
/*    */   
/*    */   public void a(g paramg, String paramString) {
/* 31 */     paramg.b("(", " " + paramString + " ", ")", this.h);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */