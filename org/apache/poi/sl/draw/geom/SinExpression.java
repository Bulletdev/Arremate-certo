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
/*    */ public class SinExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   
/*    */   SinExpression(Matcher paramMatcher) {
/* 39 */     this.arg1 = paramMatcher.group(1);
/* 40 */     this.arg2 = paramMatcher.group(2);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 44 */     double d1 = paramContext.getValue(this.arg1);
/* 45 */     double d2 = paramContext.getValue(this.arg2) / 60000.0D;
/* 46 */     return d1 * Math.sin(Math.toRadians(d2));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\SinExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */