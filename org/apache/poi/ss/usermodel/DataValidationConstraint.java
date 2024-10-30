/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface DataValidationConstraint
/*     */ {
/*     */   int getValidationType();
/*     */   
/*     */   int getOperator();
/*     */   
/*     */   void setOperator(int paramInt);
/*     */   
/*     */   String[] getExplicitListValues();
/*     */   
/*     */   void setExplicitListValues(String[] paramArrayOfString);
/*     */   
/*     */   String getFormula1();
/*     */   
/*     */   void setFormula1(String paramString);
/*     */   
/*     */   String getFormula2();
/*     */   
/*     */   void setFormula2(String paramString);
/*     */   
/*     */   public static final class ValidationType
/*     */   {
/*     */     public static final int ANY = 0;
/*     */     public static final int INTEGER = 1;
/*     */     public static final int DECIMAL = 2;
/*     */     public static final int LIST = 3;
/*     */     public static final int DATE = 4;
/*     */     public static final int TIME = 5;
/*     */     public static final int TEXT_LENGTH = 6;
/*     */     public static final int FORMULA = 7;
/*     */   }
/*     */   
/*     */   public static final class OperatorType
/*     */   {
/*     */     public static final int BETWEEN = 0;
/*     */     public static final int NOT_BETWEEN = 1;
/*     */     public static final int EQUAL = 2;
/*     */     public static final int NOT_EQUAL = 3;
/*     */     public static final int GREATER_THAN = 4;
/*     */     public static final int LESS_THAN = 5;
/*     */     public static final int GREATER_OR_EQUAL = 6;
/*     */     public static final int LESS_OR_EQUAL = 7;
/*     */     public static final int IGNORED = 0;
/*     */     
/*     */     public static void validateSecondArg(int param1Int, String param1String) {
/* 114 */       switch (param1Int) {
/*     */         case 0:
/*     */         case 1:
/* 117 */           if (param1String == null)
/* 118 */             throw new IllegalArgumentException("expr2 must be supplied for 'between' comparisons"); 
/*     */           break;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DataValidationConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */