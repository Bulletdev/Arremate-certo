/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class l<T>
/*    */   extends b<T>
/*    */ {
/*    */   public boolean E(Object paramObject) {
/* 17 */     return (paramObject == null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 22 */     paramg.a("null");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @i
/*    */   public static k<Object> b() {
/* 34 */     return (k<Object>)new l();
/*    */   }
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
/*    */   @i
/*    */   public static k<Object> c() {
/* 48 */     return k.d(b());
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> e(Class<T> paramClass) {
/* 63 */     return (k<T>)new l();
/*    */   }
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
/*    */   @i
/*    */   public static <T> k<T> f(Class<T> paramClass) {
/* 81 */     return k.d(e(paramClass));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\l.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */