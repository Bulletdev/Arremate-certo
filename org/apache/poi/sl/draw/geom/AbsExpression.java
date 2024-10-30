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
/*    */ public class AbsExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg;
/*    */   
/*    */   AbsExpression(Matcher paramMatcher) {
/* 33 */     this.arg = paramMatcher.group(1);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 37 */     double d = paramContext.getValue(this.arg);
/* 38 */     return Math.abs(d);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\AbsExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */