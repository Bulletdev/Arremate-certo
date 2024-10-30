/*    */ package org.apache.poi.ss.formula.constant;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.FormulaError;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
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
/*    */ public class ErrorConstant
/*    */ {
/* 30 */   private static final POILogger logger = POILogFactory.getLogger(ErrorConstant.class);
/* 31 */   private static final ErrorConstant NULL = new ErrorConstant(FormulaError.NULL.getCode());
/* 32 */   private static final ErrorConstant DIV_0 = new ErrorConstant(FormulaError.DIV0.getCode());
/* 33 */   private static final ErrorConstant VALUE = new ErrorConstant(FormulaError.VALUE.getCode());
/* 34 */   private static final ErrorConstant REF = new ErrorConstant(FormulaError.REF.getCode());
/* 35 */   private static final ErrorConstant NAME = new ErrorConstant(FormulaError.NAME.getCode());
/* 36 */   private static final ErrorConstant NUM = new ErrorConstant(FormulaError.NUM.getCode());
/* 37 */   private static final ErrorConstant NA = new ErrorConstant(FormulaError.NA.getCode());
/*    */   
/*    */   private final int _errorCode;
/*    */   
/*    */   private ErrorConstant(int paramInt) {
/* 42 */     this._errorCode = paramInt;
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 46 */     return this._errorCode;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 50 */     if (FormulaError.isValidCode(this._errorCode)) {
/* 51 */       return FormulaError.forInt(this._errorCode).getString();
/*    */     }
/* 53 */     return "unknown error code (" + this._errorCode + ")";
/*    */   }
/*    */   
/*    */   public static ErrorConstant valueOf(int paramInt) {
/* 57 */     if (FormulaError.isValidCode(paramInt)) {
/* 58 */       switch (FormulaError.forInt(paramInt)) { case NULL:
/* 59 */           return NULL;
/* 60 */         case DIV0: return DIV_0;
/* 61 */         case VALUE: return VALUE;
/* 62 */         case REF: return REF;
/* 63 */         case NAME: return NAME;
/* 64 */         case NUM: return NUM;
/* 65 */         case NA: return NA; }
/*    */ 
/*    */     
/*    */     }
/* 69 */     logger.log(5, new Object[] { "Warning - unexpected error code (" + paramInt + ")" });
/* 70 */     return new ErrorConstant(paramInt);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 75 */     stringBuffer.append(getClass().getName()).append(" [");
/* 76 */     stringBuffer.append(getText());
/* 77 */     stringBuffer.append("]");
/* 78 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\constant\ErrorConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */