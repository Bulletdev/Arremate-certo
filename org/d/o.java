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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class o<T>
/*    */   extends b<T>
/*    */ {
/* 18 */   private static final b a = new b("matchesSafely", 2, 0);
/*    */ 
/*    */ 
/*    */   
/*    */   private final Class<?> h;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract boolean b(T paramT, g paramg);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected o(Class<?> paramClass) {
/* 33 */     this.h = paramClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected o(b paramb) {
/* 42 */     this.h = paramb.f(getClass());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected o() {
/* 49 */     this(a);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean E(Object paramObject) {
/* 55 */     return (paramObject != null && this.h.isInstance(paramObject) && b((T)paramObject, new g.a()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(Object paramObject, g paramg) {
/* 63 */     if (paramObject == null || !this.h.isInstance(paramObject)) {
/* 64 */       super.a(paramObject, paramg);
/*    */     } else {
/* 66 */       b((T)paramObject, paramg);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\o.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */