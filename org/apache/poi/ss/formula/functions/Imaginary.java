/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*     */ public class Imaginary
/*     */   extends Fixed1ArgFunction
/*     */   implements FreeRefFunction
/*     */ {
/*  44 */   public static final FreeRefFunction instance = new Imaginary();
/*     */   
/*     */   public static final String GROUP1_REAL_SIGN_REGEX = "([+-]?)";
/*     */   
/*     */   public static final String GROUP2_REAL_INTEGER_OR_DOUBLE_REGEX = "([0-9]+\\.[0-9]+|[0-9]*)";
/*     */   public static final String GROUP3_IMAGINARY_SIGN_REGEX = "([+-]?)";
/*     */   public static final String GROUP4_IMAGINARY_INTEGER_OR_DOUBLE_REGEX = "([0-9]+\\.[0-9]+|[0-9]*)";
/*     */   public static final String GROUP5_IMAGINARY_GROUP_REGEX = "([ij]?)";
/*  52 */   public static final Pattern COMPLEX_NUMBER_PATTERN = Pattern.compile("([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([ij]?)");
/*     */   
/*     */   public static final int GROUP1_REAL_SIGN = 1;
/*     */   
/*     */   public static final int GROUP2_IMAGINARY_INTEGER_OR_DOUBLE = 2;
/*     */   
/*     */   public static final int GROUP3_IMAGINARY_SIGN = 3;
/*     */   public static final int GROUP4_IMAGINARY_INTEGER_OR_DOUBLE = 4;
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*     */     ValueEval valueEval;
/*     */     try {
/*  64 */       valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  65 */     } catch (EvaluationException evaluationException) {
/*  66 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  68 */     String str1 = OperandResolver.coerceValueToString(valueEval);
/*     */     
/*  70 */     Matcher matcher = COMPLEX_NUMBER_PATTERN.matcher(str1);
/*  71 */     boolean bool = matcher.matches();
/*     */     
/*  73 */     String str2 = "";
/*  74 */     if (bool == true) {
/*  75 */       String str = matcher.group(5);
/*  76 */       boolean bool1 = (str.equals("i") || str.equals("j")) ? true : false;
/*     */       
/*  78 */       if (str.length() == 0) {
/*  79 */         return (ValueEval)new StringEval(String.valueOf(0));
/*     */       }
/*     */       
/*  82 */       if (bool1) {
/*  83 */         String str3 = "";
/*  84 */         String str4 = matcher.group(3);
/*  85 */         if (str4.length() != 0 && !str4.equals("+")) {
/*  86 */           str3 = str4;
/*     */         }
/*     */         
/*  89 */         String str5 = matcher.group(4);
/*  90 */         if (str5.length() != 0) {
/*  91 */           str2 = str3 + str5;
/*     */         } else {
/*  93 */           str2 = str3 + "1";
/*     */         } 
/*     */       } 
/*     */     } else {
/*  97 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     } 
/*     */     
/* 100 */     return (ValueEval)new StringEval(str2);
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 104 */     if (paramArrayOfValueEval.length != 1) {
/* 105 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/* 107 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Imaginary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */