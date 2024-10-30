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
/*    */ public class ModExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   
/*    */   ModExpression(Matcher paramMatcher) {
/* 37 */     this.arg1 = paramMatcher.group(1);
/* 38 */     this.arg2 = paramMatcher.group(2);
/* 39 */     this.arg3 = paramMatcher.group(3);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 43 */     double d1 = paramContext.getValue(this.arg1);
/* 44 */     double d2 = paramContext.getValue(this.arg2);
/* 45 */     double d3 = paramContext.getValue(this.arg3);
/* 46 */     return Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\ModExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */