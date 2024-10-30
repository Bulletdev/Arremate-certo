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
/*    */ public class LiteralValueExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg;
/*    */   
/*    */   LiteralValueExpression(Matcher paramMatcher) {
/* 33 */     this.arg = paramMatcher.group(1);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 37 */     return paramContext.getValue(this.arg);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\LiteralValueExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */