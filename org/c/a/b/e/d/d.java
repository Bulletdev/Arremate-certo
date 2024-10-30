/*    */ package org.c.a.b.e.d;
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
/*    */ public class d
/*    */   extends j
/*    */ {
/*    */   public d() {
/* 26 */     super(org.c.a.b.q.d.e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aO(String paramString) {
/* 31 */     if (paramString.startsWith("$$")) {
/* 32 */       return "$$";
/*    */     }
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aP(String paramString) {
/* 39 */     if (paramString.startsWith("X'")) {
/* 40 */       return paramString.substring(paramString.indexOf("'"));
/*    */     }
/* 42 */     return super.aP(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */