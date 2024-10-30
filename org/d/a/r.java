/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.g;
/*    */ import org.d.p;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class r
/*    */   extends p<String>
/*    */ {
/*    */   protected final String lN;
/*    */   
/*    */   protected r(String paramString) {
/* 14 */     this.lN = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean Z(String paramString) {
/* 19 */     return Y(paramString);
/*    */   }
/*    */   
/*    */   public void a(String paramString, g paramg) {
/* 23 */     paramg.a("was \"").a(paramString).a("\"");
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 28 */     paramg.a("a string ").a(eO()).a(" ").a(this.lN);
/*    */   }
/*    */   
/*    */   protected abstract boolean Y(String paramString);
/*    */   
/*    */   protected abstract String eO();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\r.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */