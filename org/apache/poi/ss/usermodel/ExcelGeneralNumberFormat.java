/*    */ package org.apache.poi.ss.usermodel;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.MathContext;
/*    */ import java.math.RoundingMode;
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.DecimalFormatSymbols;
/*    */ import java.text.FieldPosition;
/*    */ import java.text.Format;
/*    */ import java.text.ParsePosition;
/*    */ import java.util.Locale;
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
/*    */ public class ExcelGeneralNumberFormat
/*    */   extends Format
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 41 */   private static final MathContext TO_10_SF = new MathContext(10, RoundingMode.HALF_UP);
/*    */   
/*    */   private final DecimalFormatSymbols decimalSymbols;
/*    */   private final DecimalFormat integerFormat;
/*    */   private final DecimalFormat decimalFormat;
/*    */   private final DecimalFormat scientificFormat;
/*    */   
/*    */   public ExcelGeneralNumberFormat(Locale paramLocale) {
/* 49 */     this.decimalSymbols = DecimalFormatSymbols.getInstance(paramLocale);
/* 50 */     this.scientificFormat = new DecimalFormat("0.#####E0", this.decimalSymbols);
/* 51 */     DataFormatter.setExcelStyleRoundingMode(this.scientificFormat);
/* 52 */     this.integerFormat = new DecimalFormat("#", this.decimalSymbols);
/* 53 */     DataFormatter.setExcelStyleRoundingMode(this.integerFormat);
/* 54 */     this.decimalFormat = new DecimalFormat("#.##########", this.decimalSymbols);
/* 55 */     DataFormatter.setExcelStyleRoundingMode(this.decimalFormat);
/*    */   }
/*    */   
/*    */   public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/*    */     double d1;
/* 60 */     if (paramObject instanceof Number) {
/* 61 */       d1 = ((Number)paramObject).doubleValue();
/* 62 */       if (Double.isInfinite(d1) || Double.isNaN(d1)) {
/* 63 */         return this.integerFormat.format(paramObject, paramStringBuffer, paramFieldPosition);
/*    */       }
/*    */     } else {
/*    */       
/* 67 */       return this.integerFormat.format(paramObject, paramStringBuffer, paramFieldPosition);
/*    */     } 
/*    */     
/* 70 */     double d2 = Math.abs(d1);
/* 71 */     if (d2 >= 1.0E11D || (d2 <= 1.0E-10D && d2 > 0.0D))
/* 72 */       return this.scientificFormat.format(paramObject, paramStringBuffer, paramFieldPosition); 
/* 73 */     if (Math.floor(d1) == d1 || d2 >= 1.0E10D)
/*    */     {
/* 75 */       return this.integerFormat.format(paramObject, paramStringBuffer, paramFieldPosition);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 81 */     double d3 = (new BigDecimal(d1)).round(TO_10_SF).doubleValue();
/* 82 */     return this.decimalFormat.format(d3, paramStringBuffer, paramFieldPosition);
/*    */   }
/*    */   
/*    */   public Object parseObject(String paramString, ParsePosition paramParsePosition) {
/* 86 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ExcelGeneralNumberFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */