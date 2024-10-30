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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SqrtExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg;
/*    */   
/*    */   SqrtExpression(Matcher paramMatcher) {
/* 38 */     this.arg = paramMatcher.group(1);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 42 */     double d = paramContext.getValue(this.arg);
/* 43 */     return Math.sqrt(d);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\SqrtExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */