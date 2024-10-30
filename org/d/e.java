/*    */ package org.d;
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
/*    */ public abstract class e<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final String lJ;
/*    */   
/*    */   public e(String paramString) {
/* 27 */     if (paramString == null) {
/* 28 */       throw new IllegalArgumentException("Description should be non null!");
/*    */     }
/* 30 */     this.lJ = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void a(g paramg) {
/* 35 */     paramg.a(this.lJ);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */