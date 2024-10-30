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
/*    */ public class MultiplyDivideExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   
/*    */   MultiplyDivideExpression(Matcher paramMatcher) {
/* 33 */     this.arg1 = paramMatcher.group(1);
/* 34 */     this.arg2 = paramMatcher.group(2);
/* 35 */     this.arg3 = paramMatcher.group(3);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 39 */     double d1 = paramContext.getValue(this.arg1);
/* 40 */     double d2 = paramContext.getValue(this.arg2);
/* 41 */     double d3 = paramContext.getValue(this.arg3);
/* 42 */     return d1 * d2 / d3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\MultiplyDivideExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */