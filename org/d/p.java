/*    */ package org.d;
/*    */ 
/*    */ import org.d.b.b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class p<T>
/*    */   extends b<T>
/*    */ {
/* 14 */   private static final b a = new b("matchesSafely", 1, 0);
/*    */ 
/*    */   
/*    */   private final Class<?> h;
/*    */ 
/*    */ 
/*    */   
/*    */   protected p() {
/* 22 */     this(a);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected p(Class<?> paramClass) {
/* 31 */     this.h = paramClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected p(b paramb) {
/* 40 */     this.h = paramb.f(getClass());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract boolean F(T paramT);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void b(T paramT, g paramg) {
/* 54 */     super.a(paramT, paramg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean E(Object paramObject) {
/* 65 */     return (paramObject != null && this.h.isInstance(paramObject) && F((T)paramObject));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(Object paramObject, g paramg) {
/* 73 */     if (paramObject == null) {
/* 74 */       super.a(paramObject, paramg);
/* 75 */     } else if (!this.h.isInstance(paramObject)) {
/* 76 */       paramg.a("was a ").a(paramObject.getClass().getName()).a(" (").a(paramObject).a(")");
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */       
/* 82 */       b((T)paramObject, paramg);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\p.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */