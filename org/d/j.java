/*    */ package org.d;
/*    */ 
/*    */ import org.d.b.b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class j<T, U>
/*    */   extends o<T>
/*    */ {
/* 13 */   private static final b a = new b("featureValueOf", 1, 0);
/*    */ 
/*    */   
/*    */   private final k<? super U> a;
/*    */ 
/*    */   
/*    */   private final String lK;
/*    */   
/*    */   private final String lL;
/*    */ 
/*    */   
/*    */   public j(k<? super U> paramk, String paramString1, String paramString2) {
/* 25 */     super((b)a);
/* 26 */     this.a = paramk;
/* 27 */     this.lK = paramString1;
/* 28 */     this.lL = paramString2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract U L(T paramT);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean b(T paramT, g paramg) {
/* 40 */     U u = L(paramT);
/* 41 */     if (!this.a.E(u)) {
/* 42 */       paramg.a(this.lL).a(" ");
/* 43 */       this.a.a(u, paramg);
/* 44 */       return false;
/*    */     } 
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void a(g paramg) {
/* 51 */     paramg.a(this.lK).a(" ").a(this.a);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */