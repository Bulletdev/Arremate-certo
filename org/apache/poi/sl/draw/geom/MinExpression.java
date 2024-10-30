/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.util.regex.Matcher;
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
/*    */ public class MinExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   
/*    */   MinExpression(Matcher paramMatcher) {
/* 33 */     this.arg1 = paramMatcher.group(1);
/* 34 */     this.arg2 = paramMatcher.group(2);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 38 */     double d1 = paramContext.getValue(this.arg1);
/* 39 */     double d2 = paramContext.getValue(this.arg2);
/* 40 */     return Math.min(d1, d2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\MinExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */