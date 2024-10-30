/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.usermodel.DateUtil;
/*    */ import org.apache.poi.util.LocaleUtil;
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
/*    */ public final class Today
/*    */   extends Fixed0ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2) {
/* 32 */     Calendar calendar = LocaleUtil.getLocaleCalendar();
/* 33 */     calendar.clear(10);
/* 34 */     calendar.set(11, 0);
/* 35 */     calendar.clear(12);
/* 36 */     calendar.clear(13);
/* 37 */     calendar.clear(14);
/* 38 */     return (ValueEval)new NumberEval(DateUtil.getExcelDate(calendar.getTime()));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Today.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */