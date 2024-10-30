/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.text.FieldPosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.util.LocaleUtil;
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
/*     */ public class ExcelStyleDateFormatter
/*     */   extends SimpleDateFormat
/*     */ {
/*     */   public static final char MMMMM_START_SYMBOL = '';
/*     */   public static final char MMMMM_TRUNCATE_SYMBOL = '';
/*     */   public static final char H_BRACKET_SYMBOL = '';
/*     */   public static final char HH_BRACKET_SYMBOL = '';
/*     */   public static final char M_BRACKET_SYMBOL = '';
/*     */   public static final char MM_BRACKET_SYMBOL = '';
/*     */   public static final char S_BRACKET_SYMBOL = '';
/*     */   public static final char SS_BRACKET_SYMBOL = '';
/*     */   public static final char L_BRACKET_SYMBOL = '';
/*     */   public static final char LL_BRACKET_SYMBOL = '';
/*     */   private static final DecimalFormat format1digit;
/*     */   private static final DecimalFormat format2digits;
/*     */   private static final DecimalFormat format3digit;
/*     */   private static final DecimalFormat format4digits;
/*     */   private double dateToBeFormatted;
/*     */   
/*     */   static {
/*  53 */     DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ROOT);
/*  54 */     format1digit = new DecimalFormat("0", decimalFormatSymbols);
/*  55 */     format2digits = new DecimalFormat("00", decimalFormatSymbols);
/*  56 */     format3digit = new DecimalFormat("0", decimalFormatSymbols);
/*  57 */     format4digits = new DecimalFormat("00", decimalFormatSymbols);
/*  58 */     DataFormatter.setExcelStyleRoundingMode(format1digit, RoundingMode.DOWN);
/*  59 */     DataFormatter.setExcelStyleRoundingMode(format2digits, RoundingMode.DOWN);
/*  60 */     DataFormatter.setExcelStyleRoundingMode(format3digit);
/*  61 */     DataFormatter.setExcelStyleRoundingMode(format4digits);
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
/*     */   public ExcelStyleDateFormatter(String paramString) {
/*  73 */     super(processFormatPattern(paramString), LocaleUtil.getUserLocale());
/*     */     setTimeZone(LocaleUtil.getUserTimeZone());
/*     */     this.dateToBeFormatted = 0.0D;
/*     */   }
/*     */   public ExcelStyleDateFormatter(String paramString, DateFormatSymbols paramDateFormatSymbols) {
/*  78 */     super(processFormatPattern(paramString), paramDateFormatSymbols);
/*     */     setTimeZone(LocaleUtil.getUserTimeZone());
/*     */     this.dateToBeFormatted = 0.0D;
/*     */   } public ExcelStyleDateFormatter(String paramString, Locale paramLocale) {
/*  82 */     super(processFormatPattern(paramString), paramLocale);
/*     */     setTimeZone(LocaleUtil.getUserTimeZone());
/*     */     this.dateToBeFormatted = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String processFormatPattern(String paramString) {
/*  90 */     String str = paramString.replaceAll("MMMMM", "MMM");
/*  91 */     str = str.replaceAll("\\[H\\]", String.valueOf(''));
/*  92 */     str = str.replaceAll("\\[HH\\]", String.valueOf(''));
/*  93 */     str = str.replaceAll("\\[m\\]", String.valueOf(''));
/*  94 */     str = str.replaceAll("\\[mm\\]", String.valueOf(''));
/*  95 */     str = str.replaceAll("\\[s\\]", String.valueOf(''));
/*  96 */     str = str.replaceAll("\\[ss\\]", String.valueOf(''));
/*  97 */     str = str.replaceAll("s.000", "s.SSS");
/*  98 */     str = str.replaceAll("s.00", "s.");
/*  99 */     str = str.replaceAll("s.0", "s.");
/* 100 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDateToBeFormatted(double paramDouble) {
/* 110 */     this.dateToBeFormatted = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/* 117 */     String str = super.format(paramDate, paramStringBuffer, paramFieldPosition).toString();
/*     */ 
/*     */     
/* 120 */     if (str.indexOf('') != -1) {
/* 121 */       str = str.replaceAll("(\\w)\\w+", "$1");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (str.indexOf('') != -1 || str.indexOf('') != -1) {
/*     */       
/* 129 */       float f = (float)this.dateToBeFormatted * 24.0F;
/*     */       
/* 131 */       str = str.replaceAll(String.valueOf(''), format1digit.format(f));
/*     */ 
/*     */ 
/*     */       
/* 135 */       str = str.replaceAll(String.valueOf(''), format2digits.format(f));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     if (str.indexOf('') != -1 || str.indexOf('') != -1) {
/*     */       
/* 143 */       float f = (float)this.dateToBeFormatted * 24.0F * 60.0F;
/* 144 */       str = str.replaceAll(String.valueOf(''), format1digit.format(f));
/*     */ 
/*     */ 
/*     */       
/* 148 */       str = str.replaceAll(String.valueOf(''), format2digits.format(f));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 153 */     if (str.indexOf('') != -1 || str.indexOf('') != -1) {
/*     */       
/* 155 */       float f = (float)(this.dateToBeFormatted * 24.0D * 60.0D * 60.0D);
/* 156 */       str = str.replaceAll(String.valueOf(''), format1digit.format(f));
/*     */ 
/*     */ 
/*     */       
/* 160 */       str = str.replaceAll(String.valueOf(''), format2digits.format(f));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     if (str.indexOf('') != -1 || str.indexOf('') != -1) {
/*     */       
/* 168 */       float f1 = (float)((this.dateToBeFormatted - Math.floor(this.dateToBeFormatted)) * 24.0D * 60.0D * 60.0D);
/* 169 */       float f2 = f1 - (int)f1;
/* 170 */       str = str.replaceAll(String.valueOf(''), format3digit.format((f2 * 10.0F)));
/*     */ 
/*     */ 
/*     */       
/* 174 */       str = str.replaceAll(String.valueOf(''), format4digits.format((f2 * 100.0F)));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     return new StringBuffer(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 185 */     if (!(paramObject instanceof ExcelStyleDateFormatter)) {
/* 186 */       return false;
/*     */     }
/*     */     
/* 189 */     ExcelStyleDateFormatter excelStyleDateFormatter = (ExcelStyleDateFormatter)paramObject;
/* 190 */     return (this.dateToBeFormatted == excelStyleDateFormatter.dateToBeFormatted);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 195 */     return (new Double(this.dateToBeFormatted)).hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ExcelStyleDateFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */