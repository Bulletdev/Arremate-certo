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
/*    */ 
/*    */ 
/*    */ public abstract class f<T>
/*    */   extends p<T>
/*    */ {
/*    */   private final String lJ;
/*    */   
/*    */   public f(String paramString) {
/* 29 */     if (paramString == null) {
/* 30 */       throw new IllegalArgumentException("Description must be non null!");
/*    */     }
/* 32 */     this.lJ = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void a(g paramg) {
/* 37 */     paramg.a(this.lJ);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */