/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import java.util.logging.Level;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JLabel;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.DateUtil;
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
/*     */ public class CellFormat
/*     */ {
/*     */   private final String format;
/*     */   private final CellFormatPart posNumFmt;
/*     */   private final CellFormatPart zeroNumFmt;
/*     */   private final CellFormatPart negNumFmt;
/*     */   private final CellFormatPart textFmt;
/*     */   private final int formatPartCount;
/* 100 */   private static final Pattern ONE_PART = Pattern.compile(CellFormatPart.FORMAT_PAT.pattern() + "(;|$)", 6);
/*     */ 
/*     */ 
/*     */   
/* 104 */   private static final CellFormatPart DEFAULT_TEXT_FORMAT = new CellFormatPart("@");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String INVALID_VALUE_FOR_FORMAT = "###############################################################################################################################################################################################################################################################";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   private static String QUOTE = "\"";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   public static final CellFormat GENERAL_FORMAT = new CellFormat("General")
/*     */     {
/*     */       public CellFormatResult apply(Object param1Object) {
/* 128 */         String str = (new CellGeneralFormatter()).format(param1Object);
/* 129 */         return new CellFormatResult(true, str, null);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 134 */   private static final Map<String, CellFormat> formatCache = new WeakHashMap<String, CellFormat>();
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
/*     */   public static CellFormat getInstance(String paramString) {
/* 146 */     CellFormat cellFormat = formatCache.get(paramString);
/* 147 */     if (cellFormat == null) {
/* 148 */       if (paramString.equals("General") || paramString.equals("@")) {
/* 149 */         cellFormat = GENERAL_FORMAT;
/*     */       } else {
/* 151 */         cellFormat = new CellFormat(paramString);
/* 152 */       }  formatCache.put(paramString, cellFormat);
/*     */     } 
/* 154 */     return cellFormat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CellFormat(String paramString) {
/* 163 */     this.format = paramString;
/* 164 */     Matcher matcher = ONE_PART.matcher(paramString);
/* 165 */     ArrayList<CellFormatPart> arrayList = new ArrayList();
/*     */     
/* 167 */     while (matcher.find()) {
/*     */       try {
/* 169 */         String str = matcher.group();
/*     */ 
/*     */         
/* 172 */         if (str.endsWith(";")) {
/* 173 */           str = str.substring(0, str.length() - 1);
/*     */         }
/* 175 */         arrayList.add(new CellFormatPart(str));
/* 176 */       } catch (RuntimeException runtimeException) {
/* 177 */         CellFormatter.logger.log(Level.WARNING, "Invalid format: " + CellFormatter.quote(matcher.group()), runtimeException);
/*     */         
/* 179 */         arrayList.add(null);
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     this.formatPartCount = arrayList.size();
/*     */     
/* 185 */     switch (this.formatPartCount) {
/*     */       case 1:
/* 187 */         this.posNumFmt = arrayList.get(0);
/* 188 */         this.negNumFmt = null;
/* 189 */         this.zeroNumFmt = null;
/* 190 */         this.textFmt = DEFAULT_TEXT_FORMAT;
/*     */         return;
/*     */       case 2:
/* 193 */         this.posNumFmt = arrayList.get(0);
/* 194 */         this.negNumFmt = arrayList.get(1);
/* 195 */         this.zeroNumFmt = null;
/* 196 */         this.textFmt = DEFAULT_TEXT_FORMAT;
/*     */         return;
/*     */       case 3:
/* 199 */         this.posNumFmt = arrayList.get(0);
/* 200 */         this.negNumFmt = arrayList.get(1);
/* 201 */         this.zeroNumFmt = arrayList.get(2);
/* 202 */         this.textFmt = DEFAULT_TEXT_FORMAT;
/*     */         return;
/*     */     } 
/*     */     
/* 206 */     this.posNumFmt = arrayList.get(0);
/* 207 */     this.negNumFmt = arrayList.get(1);
/* 208 */     this.zeroNumFmt = arrayList.get(2);
/* 209 */     this.textFmt = arrayList.get(3);
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
/*     */ 
/*     */   
/*     */   public CellFormatResult apply(Object paramObject) {
/* 224 */     if (paramObject instanceof Number) {
/* 225 */       Number number = (Number)paramObject;
/* 226 */       double d = number.doubleValue();
/* 227 */       if (d < 0.0D && ((this.formatPartCount == 2 && !this.posNumFmt.hasCondition() && !this.negNumFmt.hasCondition()) || (this.formatPartCount == 3 && !this.negNumFmt.hasCondition()) || (this.formatPartCount == 4 && !this.negNumFmt.hasCondition())))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 235 */         return this.negNumFmt.apply(Double.valueOf(-d));
/*     */       }
/* 237 */       return getApplicableFormatPart(Double.valueOf(d)).apply(Double.valueOf(d));
/*     */     } 
/* 239 */     if (paramObject instanceof Date) {
/*     */ 
/*     */       
/* 242 */       Double double_ = Double.valueOf(DateUtil.getExcelDate((Date)paramObject));
/* 243 */       if (DateUtil.isValidExcelDate(double_.doubleValue())) {
/* 244 */         return getApplicableFormatPart(double_).apply(paramObject);
/*     */       }
/* 246 */       throw new IllegalArgumentException("value " + double_ + " of date " + paramObject + " is not a valid Excel date");
/*     */     } 
/*     */     
/* 249 */     return this.textFmt.apply(paramObject);
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
/*     */   private CellFormatResult apply(Date paramDate, double paramDouble) {
/* 262 */     return getApplicableFormatPart(Double.valueOf(paramDouble)).apply(paramDate);
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
/*     */   public CellFormatResult apply(Cell paramCell) {
/*     */     Double double_;
/* 275 */     switch (ultimateTypeEnum(paramCell)) {
/*     */       case BLANK:
/* 277 */         return apply("");
/*     */       case BOOLEAN:
/* 279 */         return apply(Boolean.valueOf(paramCell.getBooleanCellValue()));
/*     */       case NUMERIC:
/* 281 */         double_ = Double.valueOf(paramCell.getNumericCellValue());
/* 282 */         if (getApplicableFormatPart(double_).getCellFormatType() == CellFormatType.DATE) {
/* 283 */           if (DateUtil.isValidExcelDate(double_.doubleValue())) {
/* 284 */             return apply(paramCell.getDateCellValue(), double_.doubleValue());
/*     */           }
/* 286 */           return apply("###############################################################################################################################################################################################################################################################");
/*     */         } 
/*     */         
/* 289 */         return apply(double_);
/*     */       
/*     */       case STRING:
/* 292 */         return apply(paramCell.getStringCellValue());
/*     */     } 
/* 294 */     return apply("?");
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
/*     */   
/*     */   public CellFormatResult apply(JLabel paramJLabel, Object paramObject) {
/* 308 */     CellFormatResult cellFormatResult = apply(paramObject);
/* 309 */     paramJLabel.setText(cellFormatResult.text);
/* 310 */     if (cellFormatResult.textColor != null) {
/* 311 */       paramJLabel.setForeground(cellFormatResult.textColor);
/*     */     }
/* 313 */     return cellFormatResult;
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
/*     */   
/*     */   private CellFormatResult apply(JLabel paramJLabel, Date paramDate, double paramDouble) {
/* 327 */     CellFormatResult cellFormatResult = apply(paramDate, paramDouble);
/* 328 */     paramJLabel.setText(cellFormatResult.text);
/* 329 */     if (cellFormatResult.textColor != null) {
/* 330 */       paramJLabel.setForeground(cellFormatResult.textColor);
/*     */     }
/* 332 */     return cellFormatResult;
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
/*     */   public CellFormatResult apply(JLabel paramJLabel, Cell paramCell) {
/*     */     Double double_;
/* 345 */     switch (ultimateTypeEnum(paramCell)) {
/*     */       case BLANK:
/* 347 */         return apply(paramJLabel, "");
/*     */       case BOOLEAN:
/* 349 */         return apply(paramJLabel, Boolean.valueOf(paramCell.getBooleanCellValue()));
/*     */       case NUMERIC:
/* 351 */         double_ = Double.valueOf(paramCell.getNumericCellValue());
/* 352 */         if (getApplicableFormatPart(double_).getCellFormatType() == CellFormatType.DATE) {
/* 353 */           if (DateUtil.isValidExcelDate(double_.doubleValue())) {
/* 354 */             return apply(paramJLabel, paramCell.getDateCellValue(), double_.doubleValue());
/*     */           }
/* 356 */           return apply(paramJLabel, "###############################################################################################################################################################################################################################################################");
/*     */         } 
/*     */         
/* 359 */         return apply(paramJLabel, double_);
/*     */       
/*     */       case STRING:
/* 362 */         return apply(paramJLabel, paramCell.getStringCellValue());
/*     */     } 
/* 364 */     return apply(paramJLabel, "?");
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
/*     */   
/*     */   private CellFormatPart getApplicableFormatPart(Object paramObject) {
/* 378 */     if (paramObject instanceof Number) {
/*     */       
/* 380 */       double d = ((Number)paramObject).doubleValue();
/*     */       
/* 382 */       if (this.formatPartCount == 1) {
/* 383 */         if (!this.posNumFmt.hasCondition() || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(d))))
/*     */         {
/* 385 */           return this.posNumFmt;
/*     */         }
/* 387 */         return new CellFormatPart("General");
/*     */       } 
/* 389 */       if (this.formatPartCount == 2) {
/* 390 */         if ((!this.posNumFmt.hasCondition() && d >= 0.0D) || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(d))))
/*     */         {
/* 392 */           return this.posNumFmt; } 
/* 393 */         if (!this.negNumFmt.hasCondition() || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(d))))
/*     */         {
/* 395 */           return this.negNumFmt;
/*     */         }
/*     */         
/* 398 */         return new CellFormatPart(QUOTE + "###############################################################################################################################################################################################################################################################" + QUOTE);
/*     */       } 
/*     */       
/* 401 */       if ((!this.posNumFmt.hasCondition() && d > 0.0D) || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(d))))
/*     */       {
/* 403 */         return this.posNumFmt; } 
/* 404 */       if ((!this.negNumFmt.hasCondition() && d < 0.0D) || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(d))))
/*     */       {
/* 406 */         return this.negNumFmt;
/*     */       }
/*     */       
/* 409 */       return this.zeroNumFmt;
/*     */     } 
/*     */ 
/*     */     
/* 413 */     throw new IllegalArgumentException("value must be a Number");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ultimateType(Cell paramCell) {
/* 433 */     return ultimateTypeEnum(paramCell).getCode();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CellType ultimateTypeEnum(Cell paramCell) {
/* 450 */     CellType cellType = paramCell.getCellTypeEnum();
/* 451 */     if (cellType == CellType.FORMULA) {
/* 452 */       return paramCell.getCachedFormulaResultTypeEnum();
/*     */     }
/* 454 */     return cellType;
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
/*     */   public boolean equals(Object paramObject) {
/* 467 */     if (this == paramObject)
/* 468 */       return true; 
/* 469 */     if (paramObject instanceof CellFormat) {
/* 470 */       CellFormat cellFormat = (CellFormat)paramObject;
/* 471 */       return this.format.equals(cellFormat.format);
/*     */     } 
/* 473 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 483 */     return this.format.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */