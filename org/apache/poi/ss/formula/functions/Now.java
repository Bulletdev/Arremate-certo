/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.usermodel.DateUtil;
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
/*    */ public final class Now
/*    */   extends Fixed0ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2) {
/* 34 */     Date date = new Date(System.currentTimeMillis());
/* 35 */     return (ValueEval)new NumberEval(DateUtil.getExcelDate(date));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Now.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */