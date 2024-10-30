/*    */ package org.c.a.b.e.g;
/*    */ 
/*    */ import org.c.a.b.q.j;
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
/*    */ public class d
/*    */   extends j
/*    */ {
/*    */   private boolean cE;
/*    */   
/*    */   public d() {
/* 34 */     super(org.c.a.b.q.d.e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected org.c.a.b.q.d a(String paramString, org.c.a.b.q.d paramd) {
/* 39 */     if (paramString.matches("^CREATE( DBA)? (FUNCTION|PROCEDURE).*")) {
/* 40 */       this.cE = true;
/*    */     }
/*    */     
/* 43 */     if (paramString.matches(".*END (FUNCTION|PROCEDURE).*")) {
/* 44 */       this.cE = false;
/*    */     }
/*    */     
/* 47 */     if (this.cE) {
/* 48 */       return null;
/*    */     }
/* 50 */     return this.g;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\g\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */