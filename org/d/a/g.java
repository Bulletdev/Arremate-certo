/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class g<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final String message;
/*    */   
/*    */   public g() {
/* 19 */     this("ANYTHING");
/*    */   }
/*    */   
/*    */   public g(String paramString) {
/* 23 */     this.message = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean E(Object paramObject) {
/* 28 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(org.d.g paramg) {
/* 33 */     paramg.a(this.message);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @i
/*    */   public static k<Object> a() {
/* 41 */     return (k<Object>)new g();
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
/*    */   public static k<Object> a(String paramString) {
/* 53 */     return (k<Object>)new g(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */