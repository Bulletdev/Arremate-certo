/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
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
/*    */ @Internal
/*    */ public enum FormulaType
/*    */ {
/* 30 */   CELL(0),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   SHARED(1),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   ARRAY(2),
/*    */ 
/*    */   
/* 47 */   CONDFORMAT(3),
/*    */ 
/*    */   
/* 50 */   NAMEDRANGE(4),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 56 */   DATAVALIDATION_LIST(5);
/*    */ 
/*    */ 
/*    */   
/*    */   private final int code;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   FormulaType(int paramInt1) {
/* 66 */     this.code = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FormulaType forInt(int paramInt) {
/* 74 */     for (FormulaType formulaType : values()) {
/* 75 */       if (formulaType.code == paramInt) {
/* 76 */         return formulaType;
/*    */       }
/*    */     } 
/* 79 */     throw new IllegalArgumentException("Invalid FormulaType code: " + paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */