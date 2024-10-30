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
/*    */ public class PinExpression
/*    */   implements Expression
/*    */ {
/*    */   private String arg1;
/*    */   private String arg2;
/*    */   private String arg3;
/*    */   
/*    */   PinExpression(Matcher paramMatcher) {
/* 40 */     this.arg1 = paramMatcher.group(1);
/* 41 */     this.arg2 = paramMatcher.group(2);
/* 42 */     this.arg3 = paramMatcher.group(3);
/*    */   }
/*    */   
/*    */   public double evaluate(Context paramContext) {
/* 46 */     double d1 = paramContext.getValue(this.arg1);
/* 47 */     double d2 = paramContext.getValue(this.arg2);
/* 48 */     double d3 = paramContext.getValue(this.arg3);
/* 49 */     if (d2 < d1) return d1; 
/* 50 */     if (d2 > d3) return d3; 
/* 51 */     return d2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\PinExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */