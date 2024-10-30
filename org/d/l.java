/*    */ package org.d;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class l
/*    */ {
/*    */   public static <T> void a(T paramT, k<? super T> paramk) {
/*  8 */     a("", paramT, paramk);
/*    */   }
/*    */   
/*    */   public static <T> void a(String paramString, T paramT, k<? super T> paramk) {
/* 12 */     if (!paramk.E(paramT)) {
/* 13 */       n n = new n();
/* 14 */       n.a(paramString).a("\nExpected: ").a(paramk).a("\n     but: ");
/*    */ 
/*    */ 
/*    */       
/* 18 */       paramk.a(paramT, n);
/*    */       
/* 20 */       throw new AssertionError(n.toString());
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void d(String paramString, boolean paramBoolean) {
/* 25 */     if (!paramBoolean)
/* 26 */       throw new AssertionError(paramString); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\l.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */