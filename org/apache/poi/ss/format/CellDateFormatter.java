/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ import java.text.AttributedCharacterIterator;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Formatter;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
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
/*     */ public class CellDateFormatter
/*     */   extends CellFormatter
/*     */ {
/*     */   private boolean amPmUpper;
/*     */   private boolean showM;
/*     */   private boolean showAmPm;
/*     */   private final DateFormat dateFmt;
/*     */   private String sFmt;
/*  41 */   private final Calendar EXCEL_EPOCH_CAL = LocaleUtil.getLocaleCalendar(1904, 0, 1);
/*     */ 
/*     */   
/*  44 */   private static CellDateFormatter SIMPLE_DATE = null;
/*     */   
/*     */   private class DatePartHandler implements CellFormatPart.PartHandler {
/*  47 */     private int mStart = -1;
/*     */     private int mLen;
/*  49 */     private int hStart = -1;
/*     */     
/*     */     private int hLen;
/*     */ 
/*     */     
/*     */     public String handlePart(Matcher param1Matcher, String param1String, CellFormatType param1CellFormatType, StringBuffer param1StringBuffer) {
/*  55 */       int j, i = param1StringBuffer.length();
/*  56 */       char c = param1String.charAt(0);
/*  57 */       switch (c) {
/*     */         case 'S':
/*     */         case 's':
/*  60 */           if (this.mStart >= 0) {
/*  61 */             for (byte b = 0; b < this.mLen; b++)
/*  62 */               param1StringBuffer.setCharAt(this.mStart + b, 'm'); 
/*  63 */             this.mStart = -1;
/*     */           } 
/*  65 */           return param1String.toLowerCase(Locale.ROOT);
/*     */         
/*     */         case 'H':
/*     */         case 'h':
/*  69 */           this.mStart = -1;
/*  70 */           this.hStart = i;
/*  71 */           this.hLen = param1String.length();
/*  72 */           return param1String.toLowerCase(Locale.ROOT);
/*     */         
/*     */         case 'D':
/*     */         case 'd':
/*  76 */           this.mStart = -1;
/*  77 */           if (param1String.length() <= 2) {
/*  78 */             return param1String.toLowerCase(Locale.ROOT);
/*     */           }
/*  80 */           return param1String.toLowerCase(Locale.ROOT).replace('d', 'E');
/*     */         
/*     */         case 'M':
/*     */         case 'm':
/*  84 */           this.mStart = i;
/*  85 */           this.mLen = param1String.length();
/*     */           
/*  87 */           if (this.hStart >= 0) {
/*  88 */             return param1String.toLowerCase(Locale.ROOT);
/*     */           }
/*  90 */           return param1String.toUpperCase(Locale.ROOT);
/*     */         
/*     */         case 'Y':
/*     */         case 'y':
/*  94 */           this.mStart = -1;
/*  95 */           if (param1String.length() == 3)
/*  96 */             param1String = "yyyy"; 
/*  97 */           return param1String.toLowerCase(Locale.ROOT);
/*     */         
/*     */         case '0':
/* 100 */           this.mStart = -1;
/* 101 */           j = param1String.length();
/* 102 */           CellDateFormatter.this.sFmt = "%0" + (j + 2) + "." + j + "f";
/* 103 */           return param1String.replace('0', 'S');
/*     */         
/*     */         case 'A':
/*     */         case 'P':
/*     */         case 'a':
/*     */         case 'p':
/* 109 */           if (param1String.length() > 1) {
/*     */             
/* 111 */             this.mStart = -1;
/* 112 */             CellDateFormatter.this.showAmPm = true;
/* 113 */             CellDateFormatter.this.showM = (Character.toLowerCase(param1String.charAt(1)) == 'm');
/*     */             
/* 115 */             CellDateFormatter.this.amPmUpper = (CellDateFormatter.this.showM || Character.isUpperCase(param1String.charAt(0)));
/*     */             
/* 117 */             return "a";
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       
/* 122 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void finish(StringBuffer param1StringBuffer) {
/* 127 */       if (this.hStart >= 0 && !CellDateFormatter.this.showAmPm) {
/* 128 */         for (byte b = 0; b < this.hLen; b++) {
/* 129 */           param1StringBuffer.setCharAt(this.hStart + b, 'H');
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private DatePartHandler() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public CellDateFormatter(String paramString) {
/* 141 */     super(paramString);
/* 142 */     DatePartHandler datePartHandler = new DatePartHandler();
/* 143 */     StringBuffer stringBuffer = CellFormatPart.parseFormat(paramString, CellFormatType.DATE, datePartHandler);
/*     */     
/* 145 */     datePartHandler.finish(stringBuffer);
/*     */ 
/*     */     
/* 148 */     String str = stringBuffer.toString().replaceAll("((y)(?!y))(?<!yy)", "yy");
/* 149 */     this.dateFmt = new SimpleDateFormat(str, LocaleUtil.getUserLocale());
/* 150 */     this.dateFmt.setTimeZone(LocaleUtil.getUserTimeZone());
/*     */   }
/*     */ 
/*     */   
/*     */   public void formatValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 155 */     if (paramObject == null)
/* 156 */       paramObject = Double.valueOf(0.0D); 
/* 157 */     if (paramObject instanceof Number) {
/* 158 */       Number number = (Number)paramObject;
/* 159 */       long l = number.longValue();
/* 160 */       if (l == 0L) {
/* 161 */         paramObject = this.EXCEL_EPOCH_CAL.getTime();
/*     */       } else {
/* 163 */         Calendar calendar = (Calendar)this.EXCEL_EPOCH_CAL.clone();
/* 164 */         calendar.add(13, (int)(l / 1000L));
/* 165 */         calendar.add(14, (int)(l % 1000L));
/* 166 */         paramObject = calendar.getTime();
/*     */       } 
/*     */     } 
/*     */     
/* 170 */     AttributedCharacterIterator attributedCharacterIterator = this.dateFmt.formatToCharacterIterator(paramObject);
/* 171 */     boolean bool1 = false;
/* 172 */     boolean bool2 = false;
/*     */     
/* 174 */     attributedCharacterIterator.first();
/* 175 */     char c = attributedCharacterIterator.first();
/* 176 */     for (; c != Character.MAX_VALUE; 
/* 177 */       c = attributedCharacterIterator.next()) {
/* 178 */       if (attributedCharacterIterator.getAttribute(DateFormat.Field.MILLISECOND) != null) {
/* 179 */         if (!bool2) {
/* 180 */           Date date = (Date)paramObject;
/* 181 */           int i = paramStringBuffer.length();
/* 182 */           Formatter formatter = new Formatter(paramStringBuffer, Locale.ROOT);
/*     */           try {
/* 184 */             long l = date.getTime() % 1000L;
/* 185 */             formatter.format(LocaleUtil.getUserLocale(), this.sFmt, new Object[] { Double.valueOf(l / 1000.0D) });
/*     */           } finally {
/* 187 */             formatter.close();
/*     */           } 
/* 189 */           paramStringBuffer.delete(i, i + 2);
/* 190 */           bool2 = true;
/*     */         } 
/* 192 */       } else if (attributedCharacterIterator.getAttribute(DateFormat.Field.AM_PM) != null) {
/* 193 */         if (!bool1) {
/* 194 */           if (this.showAmPm)
/* 195 */             if (this.amPmUpper) {
/* 196 */               paramStringBuffer.append(Character.toUpperCase(c));
/* 197 */               if (this.showM)
/* 198 */                 paramStringBuffer.append('M'); 
/*     */             } else {
/* 200 */               paramStringBuffer.append(Character.toLowerCase(c));
/* 201 */               if (this.showM) {
/* 202 */                 paramStringBuffer.append('m');
/*     */               }
/*     */             }  
/* 205 */           bool1 = true;
/*     */         } 
/*     */       } else {
/* 208 */         paramStringBuffer.append(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void simpleValue(StringBuffer paramStringBuffer, Object paramObject) {
/* 219 */     synchronized (CellDateFormatter.class) {
/* 220 */       if (SIMPLE_DATE == null || !SIMPLE_DATE.EXCEL_EPOCH_CAL.equals(this.EXCEL_EPOCH_CAL)) {
/* 221 */         SIMPLE_DATE = new CellDateFormatter("mm/d/y");
/*     */       }
/*     */     } 
/* 224 */     SIMPLE_DATE.formatValue(paramStringBuffer, paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellDateFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */