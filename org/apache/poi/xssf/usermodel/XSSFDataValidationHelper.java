/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.ss.usermodel.DataValidation;
/*     */ import org.apache.poi.ss.usermodel.DataValidationConstraint;
/*     */ import org.apache.poi.ss.usermodel.DataValidationHelper;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFDataValidationHelper
/*     */   implements DataValidationHelper
/*     */ {
/*     */   public XSSFDataValidationHelper(XSSFSheet paramXSSFSheet) {}
/*     */   
/*     */   public DataValidationConstraint createDateConstraint(int paramInt, String paramString1, String paramString2, String paramString3) {
/*  52 */     return new XSSFDataValidationConstraint(4, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createDecimalConstraint(int paramInt, String paramString1, String paramString2) {
/*  59 */     return new XSSFDataValidationConstraint(2, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createExplicitListConstraint(String[] paramArrayOfString) {
/*  66 */     return new XSSFDataValidationConstraint(paramArrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createFormulaListConstraint(String paramString) {
/*  73 */     return new XSSFDataValidationConstraint(3, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createNumericConstraint(int paramInt1, int paramInt2, String paramString1, String paramString2) {
/*  79 */     if (paramInt1 == 1)
/*  80 */       return createIntegerConstraint(paramInt2, paramString1, paramString2); 
/*  81 */     if (paramInt1 == 2)
/*  82 */       return createDecimalConstraint(paramInt2, paramString1, paramString2); 
/*  83 */     if (paramInt1 == 6) {
/*  84 */       return createTextLengthConstraint(paramInt2, paramString1, paramString2);
/*     */     }
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createIntegerConstraint(int paramInt, String paramString1, String paramString2) {
/*  93 */     return new XSSFDataValidationConstraint(1, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createTextLengthConstraint(int paramInt, String paramString1, String paramString2) {
/* 100 */     return new XSSFDataValidationConstraint(6, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createTimeConstraint(int paramInt, String paramString1, String paramString2) {
/* 107 */     return new XSSFDataValidationConstraint(5, paramInt, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public DataValidationConstraint createCustomConstraint(String paramString) {
/* 111 */     return new XSSFDataValidationConstraint(7, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidation createValidation(DataValidationConstraint paramDataValidationConstraint, CellRangeAddressList paramCellRangeAddressList) {
/* 118 */     XSSFDataValidationConstraint xSSFDataValidationConstraint = (XSSFDataValidationConstraint)paramDataValidationConstraint;
/* 119 */     CTDataValidation cTDataValidation = CTDataValidation.Factory.newInstance();
/*     */     
/* 121 */     int i = paramDataValidationConstraint.getValidationType();
/* 122 */     switch (i) {
/*     */       case 3:
/* 124 */         cTDataValidation.setType(STDataValidationType.LIST);
/* 125 */         cTDataValidation.setFormula1(paramDataValidationConstraint.getFormula1());
/*     */         break;
/*     */       case 0:
/* 128 */         cTDataValidation.setType(STDataValidationType.NONE);
/*     */         break;
/*     */       case 6:
/* 131 */         cTDataValidation.setType(STDataValidationType.TEXT_LENGTH);
/*     */         break;
/*     */       case 4:
/* 134 */         cTDataValidation.setType(STDataValidationType.DATE);
/*     */         break;
/*     */       case 1:
/* 137 */         cTDataValidation.setType(STDataValidationType.WHOLE);
/*     */         break;
/*     */       case 2:
/* 140 */         cTDataValidation.setType(STDataValidationType.DECIMAL);
/*     */         break;
/*     */       case 5:
/* 143 */         cTDataValidation.setType(STDataValidationType.TIME);
/*     */         break;
/*     */       case 7:
/* 146 */         cTDataValidation.setType(STDataValidationType.CUSTOM);
/*     */         break;
/*     */       default:
/* 149 */         cTDataValidation.setType(STDataValidationType.NONE);
/*     */         break;
/*     */     } 
/* 152 */     if (i != 0 && i != 3) {
/* 153 */       STDataValidationOperator.Enum enum_ = XSSFDataValidation.operatorTypeMappings.get(Integer.valueOf(paramDataValidationConstraint.getOperator()));
/* 154 */       if (enum_ != null) {
/* 155 */         cTDataValidation.setOperator(enum_);
/*     */       }
/* 157 */       if (paramDataValidationConstraint.getFormula1() != null) {
/* 158 */         cTDataValidation.setFormula1(paramDataValidationConstraint.getFormula1());
/*     */       }
/* 160 */       if (paramDataValidationConstraint.getFormula2() != null) {
/* 161 */         cTDataValidation.setFormula2(paramDataValidationConstraint.getFormula2());
/*     */       }
/*     */     } 
/*     */     
/* 165 */     CellRangeAddress[] arrayOfCellRangeAddress = paramCellRangeAddressList.getCellRangeAddresses();
/* 166 */     ArrayList<String> arrayList = new ArrayList();
/* 167 */     for (byte b = 0; b < arrayOfCellRangeAddress.length; b++) {
/* 168 */       CellRangeAddress cellRangeAddress = arrayOfCellRangeAddress[b];
/* 169 */       arrayList.add(cellRangeAddress.formatAsString());
/*     */     } 
/* 171 */     cTDataValidation.setSqref(arrayList);
/* 172 */     cTDataValidation.setAllowBlank(true);
/* 173 */     cTDataValidation.setErrorStyle(STDataValidationErrorStyle.STOP);
/*     */     
/* 175 */     return new XSSFDataValidation(xSSFDataValidationConstraint, paramCellRangeAddressList, cTDataValidation);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDataValidationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */