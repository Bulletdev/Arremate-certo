/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*     */ import org.apache.poi.hssf.record.FontRecord;
/*     */ import org.apache.poi.hssf.record.common.UnicodeString;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFOptimiser
/*     */ {
/*     */   public static void optimiseFonts(HSSFWorkbook paramHSSFWorkbook) {
/*  54 */     short[] arrayOfShort = new short[paramHSSFWorkbook.getWorkbook().getNumberOfFontRecords() + 1];
/*     */     
/*  56 */     boolean[] arrayOfBoolean = new boolean[arrayOfShort.length];
/*  57 */     for (byte b1 = 0; b1 < arrayOfShort.length; b1++) {
/*  58 */       arrayOfShort[b1] = (short)b1;
/*  59 */       arrayOfBoolean[b1] = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     FontRecord[] arrayOfFontRecord = new FontRecord[arrayOfShort.length]; byte b2;
/*  65 */     for (b2 = 0; b2 < arrayOfShort.length; b2++) {
/*     */       
/*  67 */       if (b2 != 4)
/*     */       {
/*  69 */         arrayOfFontRecord[b2] = paramHSSFWorkbook.getWorkbook().getFontRecordAt(b2);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     for (b2 = 5; b2 < arrayOfShort.length; b2++) {
/*     */ 
/*     */       
/*  80 */       byte b = -1;
/*  81 */       for (byte b4 = 0; b4 < b2 && b == -1; b4++) {
/*  82 */         if (b4 != 4) {
/*     */           
/*  84 */           FontRecord fontRecord = paramHSSFWorkbook.getWorkbook().getFontRecordAt(b4);
/*  85 */           if (fontRecord.sameProperties(arrayOfFontRecord[b2])) {
/*  86 */             b = b4;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  91 */       if (b != -1) {
/*  92 */         arrayOfShort[b2] = (short)b;
/*  93 */         arrayOfBoolean[b2] = true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     for (b2 = 5; b2 < arrayOfShort.length; b2++) {
/*     */ 
/*     */       
/* 104 */       short s = arrayOfShort[b2];
/* 105 */       short s1 = s;
/* 106 */       for (byte b = 0; b < s; b++) {
/* 107 */         if (arrayOfBoolean[b]) s1 = (short)(s1 - 1);
/*     */       
/*     */       } 
/*     */       
/* 111 */       arrayOfShort[b2] = s1;
/*     */     } 
/*     */ 
/*     */     
/* 115 */     for (b2 = 5; b2 < arrayOfShort.length; b2++) {
/* 116 */       if (arrayOfBoolean[b2]) {
/* 117 */         paramHSSFWorkbook.getWorkbook().removeFontRecord(arrayOfFontRecord[b2]);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     paramHSSFWorkbook.resetFontCache();
/*     */ 
/*     */ 
/*     */     
/* 129 */     for (b2 = 0; b2 < paramHSSFWorkbook.getWorkbook().getNumExFormats(); b2++) {
/* 130 */       ExtendedFormatRecord extendedFormatRecord = paramHSSFWorkbook.getWorkbook().getExFormatAt(b2);
/* 131 */       extendedFormatRecord.setFontIndex(arrayOfShort[extendedFormatRecord.getFontIndex()]);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     HashSet<UnicodeString> hashSet = new HashSet();
/* 141 */     for (byte b3 = 0; b3 < paramHSSFWorkbook.getNumberOfSheets(); b3++) {
/* 142 */       HSSFSheet hSSFSheet = paramHSSFWorkbook.getSheetAt(b3);
/* 143 */       for (Row row : hSSFSheet) {
/* 144 */         for (Cell cell : row) {
/* 145 */           if (cell.getCellTypeEnum() == CellType.STRING) {
/* 146 */             HSSFRichTextString hSSFRichTextString = (HSSFRichTextString)cell.getRichStringCellValue();
/* 147 */             UnicodeString unicodeString = hSSFRichTextString.getRawUnicodeString();
/*     */ 
/*     */             
/* 150 */             if (!hashSet.contains(unicodeString)) {
/*     */               short s;
/* 152 */               for (s = 5; s < arrayOfShort.length; s = (short)(s + 1)) {
/* 153 */                 if (s != arrayOfShort[s]) {
/* 154 */                   unicodeString.swapFontUse(s, arrayOfShort[s]);
/*     */                 }
/*     */               } 
/*     */ 
/*     */               
/* 159 */               hashSet.add(unicodeString);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
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
/*     */   public static void optimiseCellStyles(HSSFWorkbook paramHSSFWorkbook) {
/* 177 */     short[] arrayOfShort = new short[paramHSSFWorkbook.getWorkbook().getNumExFormats()];
/* 178 */     boolean[] arrayOfBoolean1 = new boolean[arrayOfShort.length];
/* 179 */     boolean[] arrayOfBoolean2 = new boolean[arrayOfShort.length];
/* 180 */     for (byte b1 = 0; b1 < arrayOfShort.length; b1++) {
/* 181 */       arrayOfBoolean1[b1] = false;
/* 182 */       arrayOfShort[b1] = (short)b1;
/* 183 */       arrayOfBoolean2[b1] = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 188 */     ExtendedFormatRecord[] arrayOfExtendedFormatRecord = new ExtendedFormatRecord[arrayOfShort.length]; int i;
/* 189 */     for (i = 0; i < arrayOfShort.length; i++) {
/* 190 */       arrayOfExtendedFormatRecord[i] = paramHSSFWorkbook.getWorkbook().getExFormatAt(i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     for (i = 21; i < arrayOfShort.length; i++) {
/*     */ 
/*     */       
/* 201 */       byte b = -1;
/* 202 */       for (byte b4 = 0; b4 < i && b == -1; b4++) {
/* 203 */         ExtendedFormatRecord extendedFormatRecord = paramHSSFWorkbook.getWorkbook().getExFormatAt(b4);
/* 204 */         if (extendedFormatRecord.equals(arrayOfExtendedFormatRecord[i])) {
/* 205 */           b = b4;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 210 */       if (b != -1) {
/* 211 */         arrayOfShort[i] = (short)b;
/* 212 */         arrayOfBoolean2[i] = true;
/*     */       } 
/*     */       
/* 215 */       if (b != -1) {
/* 216 */         arrayOfBoolean1[b] = true;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 222 */     for (i = 0; i < paramHSSFWorkbook.getNumberOfSheets(); i++) {
/* 223 */       HSSFSheet hSSFSheet = paramHSSFWorkbook.getSheetAt(i);
/* 224 */       for (Row row : hSSFSheet) {
/* 225 */         for (Cell cell : row) {
/* 226 */           HSSFCell hSSFCell = (HSSFCell)cell;
/* 227 */           short s = hSSFCell.getCellValueRecord().getXFIndex();
/* 228 */           arrayOfBoolean1[s] = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 233 */     for (i = 21; i < arrayOfBoolean1.length; i++) {
/* 234 */       if (!arrayOfBoolean1[i]) {
/*     */         
/* 236 */         arrayOfBoolean2[i] = true;
/* 237 */         arrayOfShort[i] = 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     for (i = 21; i < arrayOfShort.length; i++) {
/*     */ 
/*     */       
/* 248 */       short s = arrayOfShort[i];
/* 249 */       short s1 = s;
/* 250 */       for (byte b = 0; b < s; b++) {
/* 251 */         if (arrayOfBoolean2[b]) s1 = (short)(s1 - 1);
/*     */       
/*     */       } 
/*     */       
/* 255 */       arrayOfShort[i] = s1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 261 */     i = arrayOfShort.length;
/* 262 */     byte b2 = 0; byte b3;
/* 263 */     for (b3 = 21; b3 < i; b3++) {
/* 264 */       if (arrayOfBoolean2[b3 + b2]) {
/* 265 */         paramHSSFWorkbook.getWorkbook().removeExFormatRecord(b3);
/* 266 */         b3--;
/* 267 */         i--;
/* 268 */         b2++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 273 */     for (b3 = 0; b3 < paramHSSFWorkbook.getNumberOfSheets(); b3++) {
/* 274 */       HSSFSheet hSSFSheet = paramHSSFWorkbook.getSheetAt(b3);
/* 275 */       for (Row row : hSSFSheet) {
/* 276 */         for (Cell cell : row) {
/* 277 */           HSSFCell hSSFCell = (HSSFCell)cell;
/* 278 */           short s = hSSFCell.getCellValueRecord().getXFIndex();
/*     */           
/* 280 */           HSSFCellStyle hSSFCellStyle = paramHSSFWorkbook.getCellStyleAt(arrayOfShort[s]);
/*     */ 
/*     */           
/* 283 */           hSSFCell.setCellStyle(hSSFCellStyle);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFOptimiser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */