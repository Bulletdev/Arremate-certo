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
/*    */ 
/*    */ public class TanExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   
/*    */   TanExpression(Matcher paramMatcher) {
/* 40 */     this.arg1 = paramMatcher.group(1);
/* 41 */     this.arg2 = paramMatcher.group(2);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 45 */     double d1 = paramContext.getValue(this.arg1);
/* 46 */     double d2 = paramContext.getValue(this.arg2);
/* 47 */     return d1 * Math.tan(Math.toRadians(d2 / 60000.0D));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\TanExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */