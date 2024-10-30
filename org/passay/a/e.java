/*    */ package org.passay.a;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.passay.A;
/*    */ import org.passay.D;
/*    */ import org.passay.a;
/*    */ import org.passay.f;
/*    */ import org.passay.g;
/*    */ import org.passay.m;
/*    */ import org.passay.x;
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
/*    */ public final class e
/*    */ {
/*    */   private static final int jn = 4;
/* 29 */   private static final A a = new A(new D[] { (D)new org.passay.e(4, new g[] { new g((f)m.c, 1), new g((f)m.e, 1), new g((f)m.b, 1), new g((f)m.a, 1) }) });
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
/*    */   public static d a(List<? extends D> paramList, x paramx) {
/* 57 */     boolean bool = (paramList.stream().filter(paramD -> (a.class.isAssignableFrom(paramD.getClass()) && ((a)paramD).a().size() > 0L)).count() > 0L) ? true : false;
/* 58 */     return a(bool, paramx);
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
/*    */   public static d a(boolean paramBoolean, x paramx) {
/* 72 */     if (!paramx.a().equals(x.c.b)) {
/* 73 */       throw new IllegalArgumentException("Password data must have an origin of " + x.c.b);
/*    */     }
/* 75 */     boolean bool = a(paramx);
/* 76 */     return new d(paramBoolean, bool, paramx.getPassword().length());
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
/*    */   private static boolean a(x paramx) {
/* 89 */     return a.a(paramx).isValid();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */