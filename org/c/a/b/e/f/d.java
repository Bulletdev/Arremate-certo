/*    */ package org.c.a.b.e.f;
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
/*    */ public class d
/*    */   extends j
/*    */ {
/*    */   private boolean cD;
/*    */   
/*    */   d() {
/* 31 */     super(org.c.a.b.q.d.e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected org.c.a.b.q.d a(String paramString, org.c.a.b.q.d paramd) {
/* 36 */     if (paramString.contains("BEGIN ATOMIC")) {
/* 37 */       this.cD = true;
/*    */     }
/*    */     
/* 40 */     if (paramString.endsWith("END;")) {
/* 41 */       this.cD = false;
/*    */     }
/*    */     
/* 44 */     if (this.cD) {
/* 45 */       return null;
/*    */     }
/* 47 */     return this.g;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\f\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */