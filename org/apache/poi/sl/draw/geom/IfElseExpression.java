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
/*    */ public class IfElseExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   
/*    */   IfElseExpression(Matcher paramMatcher) {
/* 38 */     this.arg1 = paramMatcher.group(1);
/* 39 */     this.arg2 = paramMatcher.group(2);
/* 40 */     this.arg3 = paramMatcher.group(3);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 44 */     double d1 = paramContext.getValue(this.arg1);
/* 45 */     double d2 = paramContext.getValue(this.arg2);
/* 46 */     double d3 = paramContext.getValue(this.arg3);
/* 47 */     return (d1 > 0.0D) ? d2 : d3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\IfElseExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */