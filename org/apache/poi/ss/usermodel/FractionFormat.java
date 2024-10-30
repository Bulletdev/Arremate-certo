/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.text.FieldPosition;
/*     */ import java.text.Format;
/*     */ import java.text.ParsePosition;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.format.SimpleFraction;
/*     */ import org.apache.poi.ss.formula.eval.NotImplementedException;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class FractionFormat
/*     */   extends Format
/*     */ {
/*  44 */   private static final POILogger LOGGER = POILogFactory.getLogger(FractionFormat.class);
/*  45 */   private static final Pattern DENOM_FORMAT_PATTERN = Pattern.compile("(?:(#+)|(\\d+))");
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MAX_DENOM_POW = 4;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int exactDenom;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int maxDenom;
/*     */ 
/*     */ 
/*     */   
/*     */   private final String wholePartFormatString;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FractionFormat(String paramString1, String paramString2) {
/*  67 */     this.wholePartFormatString = paramString1;
/*     */     
/*  69 */     Matcher matcher = DENOM_FORMAT_PATTERN.matcher(paramString2);
/*  70 */     int i = -1;
/*  71 */     int j = -1;
/*  72 */     if (matcher.find()) {
/*  73 */       if (matcher.group(2) != null) {
/*     */         try {
/*  75 */           i = Integer.parseInt(matcher.group(2));
/*     */ 
/*     */           
/*  78 */           if (i == 0) {
/*  79 */             i = -1;
/*     */           }
/*  81 */         } catch (NumberFormatException numberFormatException) {}
/*     */       
/*     */       }
/*  84 */       else if (matcher.group(1) != null) {
/*  85 */         int k = matcher.group(1).length();
/*  86 */         k = (k > 4) ? 4 : k;
/*  87 */         j = (int)Math.pow(10.0D, k);
/*     */       } else {
/*  89 */         i = 100;
/*     */       } 
/*     */     }
/*  92 */     if (i <= 0 && j <= 0)
/*     */     {
/*  94 */       i = 100;
/*     */     }
/*  96 */     this.exactDenom = i;
/*  97 */     this.maxDenom = j;
/*     */   }
/*     */ 
/*     */   
/*     */   public String format(Number paramNumber) {
/* 102 */     double d1 = paramNumber.doubleValue();
/*     */     
/* 104 */     boolean bool = (d1 < 0.0D) ? true : false;
/* 105 */     double d2 = Math.abs(d1);
/*     */     
/* 107 */     double d3 = Math.floor(d2);
/* 108 */     double d4 = d2 - d3;
/* 109 */     if (d3 + d4 == 0.0D) {
/* 110 */       return "0";
/*     */     }
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
/* 122 */     if (Double.compare(d4, 0.0D) == 0) {
/*     */       
/* 124 */       StringBuilder stringBuilder1 = new StringBuilder();
/* 125 */       if (bool) {
/* 126 */         stringBuilder1.append("-");
/*     */       }
/* 128 */       stringBuilder1.append((int)d3);
/* 129 */       return stringBuilder1.toString();
/*     */     } 
/*     */     
/* 132 */     SimpleFraction simpleFraction = null;
/*     */     
/*     */     try {
/* 135 */       if (this.exactDenom > 0) {
/* 136 */         simpleFraction = SimpleFraction.buildFractionExactDenominator(d4, this.exactDenom);
/*     */       } else {
/* 138 */         simpleFraction = SimpleFraction.buildFractionMaxDenominator(d4, this.maxDenom);
/*     */       } 
/* 140 */     } catch (RuntimeException runtimeException) {
/* 141 */       LOGGER.log(5, new Object[] { "Can't format fraction", runtimeException });
/* 142 */       return Double.toString(d1);
/*     */     } 
/*     */     
/* 145 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */     
/* 148 */     if (bool) {
/* 149 */       stringBuilder.append("-");
/*     */     }
/*     */ 
/*     */     
/* 153 */     if ("".equals(this.wholePartFormatString)) {
/* 154 */       int i = simpleFraction.getDenominator() * (int)d3 + simpleFraction.getNumerator();
/* 155 */       stringBuilder.append(i).append("/").append(simpleFraction.getDenominator());
/* 156 */       return stringBuilder.toString();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 161 */     if (simpleFraction.getNumerator() == 0) {
/* 162 */       stringBuilder.append(Integer.toString((int)d3));
/* 163 */       return stringBuilder.toString();
/* 164 */     }  if (simpleFraction.getNumerator() == simpleFraction.getDenominator()) {
/* 165 */       stringBuilder.append(Integer.toString((int)d3 + 1));
/* 166 */       return stringBuilder.toString();
/*     */     } 
/*     */     
/* 169 */     if (d3 > 0.0D) {
/* 170 */       stringBuilder.append(Integer.toString((int)d3)).append(" ");
/*     */     }
/* 172 */     stringBuilder.append(simpleFraction.getNumerator()).append("/").append(simpleFraction.getDenominator());
/* 173 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/* 177 */     return paramStringBuffer.append(format((Number)paramObject));
/*     */   }
/*     */   
/*     */   public Object parseObject(String paramString, ParsePosition paramParsePosition) {
/* 181 */     throw new NotImplementedException("Reverse parsing not supported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\FractionFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */