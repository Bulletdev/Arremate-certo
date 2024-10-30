/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.usermodel.DataValidationConstraint;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;
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
/*     */ public class XSSFDataValidationConstraint
/*     */   implements DataValidationConstraint
/*     */ {
/*     */   private static final String LIST_SEPARATOR = ",";
/*  36 */   private static final Pattern LIST_SPLIT_REGEX = Pattern.compile("\\s*,\\s*");
/*     */   
/*     */   private static final String QUOTE = "\"";
/*     */   private String formula1;
/*     */   private String formula2;
/*  41 */   private int validationType = -1;
/*  42 */   private int operator = -1;
/*     */ 
/*     */   
/*     */   private String[] explicitListOfValues;
/*     */ 
/*     */   
/*     */   public XSSFDataValidationConstraint(String[] paramArrayOfString) {
/*  49 */     if (paramArrayOfString == null || paramArrayOfString.length == 0) {
/*  50 */       throw new IllegalArgumentException("List validation with explicit values must specify at least one value");
/*     */     }
/*  52 */     this.validationType = 3;
/*  53 */     setExplicitListValues(paramArrayOfString);
/*     */     
/*  55 */     validate();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFDataValidationConstraint(int paramInt, String paramString) {
/*  60 */     setFormula1(paramString);
/*  61 */     this.validationType = paramInt;
/*  62 */     validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFDataValidationConstraint(int paramInt1, int paramInt2, String paramString) {
/*  69 */     setFormula1(paramString);
/*  70 */     this.validationType = paramInt1;
/*  71 */     this.operator = paramInt2;
/*  72 */     validate();
/*     */   }
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
/*     */   public XSSFDataValidationConstraint(int paramInt1, int paramInt2, String paramString1, String paramString2) {
/*  85 */     setFormula1(paramString1);
/*  86 */     setFormula2(paramString2);
/*  87 */     this.validationType = paramInt1;
/*  88 */     this.operator = paramInt2;
/*     */     
/*  90 */     validate();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     if (3 == paramInt1 && paramString1 != null && paramString1.startsWith("\"") && paramString1.endsWith("\"")) {
/*     */ 
/*     */ 
/*     */       
/*  99 */       String str = paramString1.substring(1, paramString1.length() - 1);
/* 100 */       this.explicitListOfValues = LIST_SPLIT_REGEX.split(str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getExplicitListValues() {
/* 108 */     return this.explicitListOfValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormula1() {
/* 115 */     return this.formula1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormula2() {
/* 122 */     return this.formula2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOperator() {
/* 129 */     return this.operator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValidationType() {
/* 136 */     return this.validationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExplicitListValues(String[] paramArrayOfString) {
/* 143 */     this.explicitListOfValues = paramArrayOfString;
/*     */ 
/*     */ 
/*     */     
/* 147 */     if (this.explicitListOfValues != null && this.explicitListOfValues.length > 0) {
/* 148 */       StringBuilder stringBuilder = new StringBuilder("\"");
/* 149 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 150 */         String str = paramArrayOfString[b];
/* 151 */         if (stringBuilder.length() > 1) {
/* 152 */           stringBuilder.append(",");
/*     */         }
/* 154 */         stringBuilder.append(str);
/*     */       } 
/* 156 */       stringBuilder.append("\"");
/* 157 */       setFormula1(stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormula1(String paramString) {
/* 165 */     this.formula1 = removeLeadingEquals(paramString);
/*     */   }
/*     */   
/*     */   protected static String removeLeadingEquals(String paramString) {
/* 169 */     return isFormulaEmpty(paramString) ? paramString : ((paramString.charAt(0) == '=') ? paramString.substring(1) : paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormula2(String paramString) {
/* 176 */     this.formula2 = removeLeadingEquals(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOperator(int paramInt) {
/* 183 */     this.operator = paramInt;
/*     */   }
/*     */   
/*     */   public void validate() {
/* 187 */     if (this.validationType == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 191 */     if (this.validationType == 3) {
/* 192 */       if (isFormulaEmpty(this.formula1)) {
/* 193 */         throw new IllegalArgumentException("A valid formula or a list of values must be specified for list validation.");
/*     */       }
/*     */     } else {
/* 196 */       if (isFormulaEmpty(this.formula1)) {
/* 197 */         throw new IllegalArgumentException("Formula is not specified. Formula is required for all validation types except explicit list validation.");
/*     */       }
/*     */       
/* 200 */       if (this.validationType != 7) {
/* 201 */         if (this.operator == -1)
/* 202 */           throw new IllegalArgumentException("This validation type requires an operator to be specified."); 
/* 203 */         if ((this.operator == 0 || this.operator == 1) && isFormulaEmpty(this.formula2)) {
/* 204 */           throw new IllegalArgumentException("Between and not between comparisons require two formulae to be specified.");
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static boolean isFormulaEmpty(String paramString) {
/* 211 */     return (paramString == null || paramString.trim().length() == 0);
/*     */   }
/*     */   
/*     */   public String prettyPrint() {
/* 215 */     StringBuilder stringBuilder = new StringBuilder();
/* 216 */     STDataValidationType.Enum enum_ = XSSFDataValidation.validationTypeMappings.get(Integer.valueOf(this.validationType));
/* 217 */     STDataValidationOperator.Enum enum_1 = XSSFDataValidation.operatorTypeMappings.get(Integer.valueOf(this.operator));
/* 218 */     stringBuilder.append(enum_);
/* 219 */     stringBuilder.append(' ');
/* 220 */     if (this.validationType != 0) {
/* 221 */       if (this.validationType != 3 && this.validationType != 0 && this.validationType != 7)
/*     */       {
/*     */         
/* 224 */         stringBuilder.append(",").append(enum_1).append(", ");
/*     */       }
/*     */       
/* 227 */       if (this.validationType == 3 && this.explicitListOfValues != null) {
/* 228 */         stringBuilder.append("\"").append(Arrays.asList(this.explicitListOfValues)).append("\"").append(' ');
/*     */       } else {
/* 230 */         stringBuilder.append("\"").append(this.formula1).append("\"").append(' ');
/*     */       } 
/* 232 */       if (this.formula2 != null) {
/* 233 */         stringBuilder.append("\"").append(this.formula2).append("\"").append(' ');
/*     */       }
/*     */     } 
/* 236 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDataValidationConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */