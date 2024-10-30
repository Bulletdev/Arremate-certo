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
/*    */ public class SinArcTanExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   
/*    */   SinArcTanExpression(Matcher paramMatcher) {
/* 39 */     this.arg1 = paramMatcher.group(1);
/* 40 */     this.arg2 = paramMatcher.group(2);
/* 41 */     this.arg3 = paramMatcher.group(3);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 45 */     double d1 = paramContext.getValue(this.arg1);
/* 46 */     double d2 = paramContext.getValue(this.arg2);
/* 47 */     double d3 = paramContext.getValue(this.arg3);
/* 48 */     return d1 * Math.sin(Math.atan(d3 / d2));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\SinArcTanExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */