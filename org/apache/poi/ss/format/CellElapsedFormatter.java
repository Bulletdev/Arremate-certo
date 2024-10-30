/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Formatter;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class CellElapsedFormatter
/*     */   extends CellFormatter
/*     */ {
/*     */   private final List<TimeSpec> specs;
/*     */   private TimeSpec topmost;
/*     */   private final String printfFmt;
/*  37 */   private static final Pattern PERCENTS = Pattern.compile("%");
/*     */   private static final double HOUR__FACTOR = 0.041666666666666664D;
/*     */   private static final double MIN__FACTOR = 6.944444444444444E-4D;
/*     */   private static final double SEC__FACTOR = 1.1574074074074073E-5D;
/*     */   
/*     */   private static class TimeSpec
/*     */   {
/*     */     final char type;
/*     */     final int pos;
/*     */     final int len;
/*     */     final double factor;
/*     */     double modBy;
/*     */     
/*     */     public TimeSpec(char param1Char, int param1Int1, int param1Int2, double param1Double) {
/*  51 */       this.type = param1Char;
/*  52 */       this.pos = param1Int1;
/*  53 */       this.len = param1Int2;
/*  54 */       this.factor = param1Double;
/*  55 */       this.modBy = 0.0D;
/*     */     }
/*     */     
/*     */     public long valueFor(double param1Double) {
/*     */       double d;
/*  60 */       if (this.modBy == 0.0D) {
/*  61 */         d = param1Double / this.factor;
/*     */       } else {
/*  63 */         d = param1Double / this.factor % this.modBy;
/*  64 */       }  if (this.type == '0') {
/*  65 */         return Math.round(d);
/*     */       }
/*  67 */       return (long)d;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class ElapsedPartHandler
/*     */     implements CellFormatPart.PartHandler
/*     */   {
/*     */     private ElapsedPartHandler() {}
/*     */ 
/*     */     
/*     */     public String handlePart(Matcher param1Matcher, String param1String, CellFormatType param1CellFormatType, StringBuffer param1StringBuffer) {
/*  80 */       int j, i = param1StringBuffer.length();
/*  81 */       char c = param1String.charAt(0);
/*  82 */       switch (c) {
/*     */         case '[':
/*  84 */           if (param1String.length() < 3)
/*     */             break; 
/*  86 */           if (CellElapsedFormatter.this.topmost != null) {
/*  87 */             throw new IllegalArgumentException("Duplicate '[' times in format");
/*     */           }
/*  89 */           param1String = param1String.toLowerCase(Locale.ROOT);
/*  90 */           j = param1String.length() - 2;
/*  91 */           CellElapsedFormatter.this.topmost = CellElapsedFormatter.this.assignSpec(param1String.charAt(1), i, j);
/*  92 */           return param1String.substring(1, 1 + j);
/*     */         
/*     */         case '0':
/*     */         case 'h':
/*     */         case 'm':
/*     */         case 's':
/*  98 */           param1String = param1String.toLowerCase(Locale.ROOT);
/*  99 */           CellElapsedFormatter.this.assignSpec(param1String.charAt(0), i, param1String.length());
/* 100 */           return param1String;
/*     */         
/*     */         case '\n':
/* 103 */           return "%n";
/*     */         
/*     */         case '"':
/* 106 */           param1String = param1String.substring(1, param1String.length() - 1);
/*     */           break;
/*     */         
/*     */         case '\\':
/* 110 */           param1String = param1String.substring(1);
/*     */           break;
/*     */         
/*     */         case '*':
/* 114 */           if (param1String.length() > 1) {
/* 115 */             param1String = CellFormatPart.expandChar(param1String);
/*     */           }
/*     */           break;
/*     */         
/*     */         case '_':
/* 120 */           return null;
/*     */       } 
/*     */       
/* 123 */       return CellElapsedFormatter.PERCENTS.matcher(param1String).replaceAll("%%");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellElapsedFormatter(String paramString) {
/* 133 */     super(paramString);
/*     */     
/* 135 */     this.specs = new ArrayList<TimeSpec>();
/*     */     
/* 137 */     StringBuffer stringBuffer = CellFormatPart.parseFormat(paramString, CellFormatType.ELAPSED, new ElapsedPartHandler());
/*     */ 
/*     */     
/* 140 */     ListIterator<TimeSpec> listIterator = this.specs.listIterator(this.specs.size());
/* 141 */     while (listIterator.hasPrevious()) {
/* 142 */       TimeSpec timeSpec = listIterator.previous();
/* 143 */       stringBuffer.replace(timeSpec.pos, timeSpec.pos + timeSpec.len, "%0" + timeSpec.len + "d");
/* 144 */       if (timeSpec.type != this.topmost.type) {
/* 145 */         timeSpec.modBy = modFor(timeSpec.type, timeSpec.len);
/*     */       }
/*     */     } 
/*     */     
/* 149 */     this.printfFmt = stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private TimeSpec assignSpec(char paramChar, int paramInt1, int paramInt2) {
/* 153 */     TimeSpec timeSpec = new TimeSpec(paramChar, paramInt1, paramInt2, factorFor(paramChar, paramInt2));
/* 154 */     this.specs.add(timeSpec);
/* 155 */     return timeSpec;
/*     */   }
/*     */   
/*     */   private static double factorFor(char paramChar, int paramInt) {
/* 159 */     switch (paramChar) {
/*     */       case 'h':
/* 161 */         return 0.041666666666666664D;
/*     */       case 'm':
/* 163 */         return 6.944444444444444E-4D;
/*     */       case 's':
/* 165 */         return 1.1574074074074073E-5D;
/*     */       case '0':
/* 167 */         return 1.1574074074074073E-5D / Math.pow(10.0D, paramInt);
/*     */     } 
/* 169 */     throw new IllegalArgumentException("Uknown elapsed time spec: " + paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double modFor(char paramChar, int paramInt) {
/* 175 */     switch (paramChar) {
/*     */       case 'h':
/* 177 */         return 24.0D;
/*     */       case 'm':
/* 179 */         return 60.0D;
/*     */       case 's':
/* 181 */         return 60.0D;
/*     */       case '0':
/* 183 */         return Math.pow(10.0D, paramInt);
/*     */     } 
/* 185 */     throw new IllegalArgumentException("Uknown elapsed time spec: " + paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void formatValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 192 */     double d = ((Number)paramObject).doubleValue();
/*     */     
/* 194 */     if (d < 0.0D) {
/* 195 */       paramStringBuffer.append('-');
/* 196 */       d = -d;
/*     */     } 
/*     */     
/* 199 */     Long[] arrayOfLong = new Long[this.specs.size()];
/* 200 */     for (byte b = 0; b < this.specs.size(); b++) {
/* 201 */       arrayOfLong[b] = Long.valueOf(((TimeSpec)this.specs.get(b)).valueFor(d));
/*     */     }
/*     */     
/* 204 */     Formatter formatter = new Formatter(paramStringBuffer, Locale.ROOT);
/*     */     try {
/* 206 */       formatter.format(this.printfFmt, (Object[])arrayOfLong);
/*     */     } finally {
/* 208 */       formatter.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void simpleValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 218 */     formatValue(paramStringBuffer, paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellElapsedFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */