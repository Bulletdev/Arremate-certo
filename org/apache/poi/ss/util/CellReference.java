/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*     */ import org.apache.poi.ss.usermodel.Cell;
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
/*     */ public class CellReference
/*     */ {
/*     */   private static final char ABSOLUTE_REFERENCE_MARKER = '$';
/*     */   private static final char SHEET_NAME_DELIMITER = '!';
/*     */   private static final char SPECIAL_NAME_DELIMITER = '\'';
/*     */   
/*     */   public enum NameType
/*     */   {
/*  46 */     CELL,
/*  47 */     NAMED_RANGE,
/*  48 */     COLUMN,
/*  49 */     ROW,
/*  50 */     BAD_CELL_OR_NAMED_RANGE;
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
/*  66 */   private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Z]+)?(\\$?[0-9]+)?", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   private static final Pattern STRICTLY_CELL_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)\\$?([0-9]+)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   private static final Pattern COLUMN_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private static final Pattern ROW_REF_PATTERN = Pattern.compile("\\$?([0-9]+)");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   private static final Pattern NAMED_RANGE_NAME_PATTERN = Pattern.compile("[_A-Z][_.A-Z0-9]*", 2);
/*     */ 
/*     */   
/*     */   private final String _sheetName;
/*     */ 
/*     */   
/*     */   private final int _rowIndex;
/*     */ 
/*     */   
/*     */   private final int _colIndex;
/*     */ 
/*     */   
/*     */   private final boolean _isRowAbs;
/*     */ 
/*     */   
/*     */   private final boolean _isColAbs;
/*     */ 
/*     */   
/*     */   public CellReference(String paramString) {
/* 107 */     if (paramString.toUpperCase(Locale.ROOT).endsWith("#REF!")) {
/* 108 */       throw new IllegalArgumentException("Cell reference invalid: " + paramString);
/*     */     }
/*     */     
/* 111 */     CellRefParts cellRefParts = separateRefParts(paramString);
/* 112 */     this._sheetName = cellRefParts.sheetName;
/*     */     
/* 114 */     String str1 = cellRefParts.colRef;
/* 115 */     this._isColAbs = (str1.length() > 0 && str1.charAt(0) == '$');
/* 116 */     if (this._isColAbs) {
/* 117 */       str1 = str1.substring(1);
/*     */     }
/* 119 */     if (str1.length() == 0) {
/* 120 */       this._colIndex = -1;
/*     */     } else {
/* 122 */       this._colIndex = convertColStringToIndex(str1);
/*     */     } 
/*     */     
/* 125 */     String str2 = cellRefParts.rowRef;
/* 126 */     this._isRowAbs = (str2.length() > 0 && str2.charAt(0) == '$');
/* 127 */     if (this._isRowAbs) {
/* 128 */       str2 = str2.substring(1);
/*     */     }
/* 130 */     if (str2.length() == 0) {
/* 131 */       this._rowIndex = -1;
/*     */     } else {
/* 133 */       this._rowIndex = Integer.parseInt(str2) - 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CellReference(int paramInt1, int paramInt2) {
/* 138 */     this(paramInt1, paramInt2, false, false);
/*     */   }
/*     */   public CellReference(int paramInt, short paramShort) {
/* 141 */     this(paramInt, paramShort & 0xFFFF, false, false);
/*     */   }
/*     */   
/*     */   public CellReference(Cell paramCell) {
/* 145 */     this(paramCell.getRowIndex(), paramCell.getColumnIndex(), false, false);
/*     */   }
/*     */   
/*     */   public CellReference(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 149 */     this(null, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public CellReference(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 154 */     if (paramInt1 < -1) {
/* 155 */       throw new IllegalArgumentException("row index may not be negative, but had " + paramInt1);
/*     */     }
/* 157 */     if (paramInt2 < -1) {
/* 158 */       throw new IllegalArgumentException("column index may not be negative, but had " + paramInt2);
/*     */     }
/* 160 */     this._sheetName = paramString;
/* 161 */     this._rowIndex = paramInt1;
/* 162 */     this._colIndex = paramInt2;
/* 163 */     this._isRowAbs = paramBoolean1;
/* 164 */     this._isColAbs = paramBoolean2;
/*     */   }
/*     */   
/* 167 */   public int getRow() { return this._rowIndex; }
/* 168 */   public short getCol() { return (short)this._colIndex; }
/* 169 */   public boolean isRowAbsolute() { return this._isRowAbs; } public boolean isColAbsolute() {
/* 170 */     return this._isColAbs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetName() {
/* 176 */     return this._sheetName;
/*     */   }
/*     */   
/*     */   public static boolean isPartAbsolute(String paramString) {
/* 180 */     return (paramString.charAt(0) == '$');
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
/*     */   public static int convertColStringToIndex(String paramString) {
/* 192 */     int i = 0;
/* 193 */     char[] arrayOfChar = paramString.toUpperCase(Locale.ROOT).toCharArray();
/* 194 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 195 */       char c = arrayOfChar[b];
/* 196 */       if (c == '$') {
/* 197 */         if (b != 0) {
/* 198 */           throw new IllegalArgumentException("Bad col ref format '" + paramString + "'");
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 204 */         i = i * 26 + c - 65 + 1;
/*     */       } 
/* 206 */     }  return i - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NameType classifyCellReference(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 214 */     int i = paramString.length();
/* 215 */     if (i < 1) {
/* 216 */       throw new IllegalArgumentException("Empty string not allowed");
/*     */     }
/* 218 */     char c = paramString.charAt(0);
/* 219 */     switch (c) {
/*     */       case '$':
/*     */       case '.':
/*     */       case '_':
/*     */         break;
/*     */       default:
/* 225 */         if (!Character.isLetter(c) && !Character.isDigit(c)) {
/* 226 */           throw new IllegalArgumentException("Invalid first char (" + c + ") of cell reference or named range.  Letter expected");
/*     */         }
/*     */         break;
/*     */     } 
/* 230 */     if (!Character.isDigit(paramString.charAt(i - 1)))
/*     */     {
/* 232 */       return validateNamedRangeName(paramString, paramSpreadsheetVersion);
/*     */     }
/* 234 */     Matcher matcher = STRICTLY_CELL_REF_PATTERN.matcher(paramString);
/* 235 */     if (!matcher.matches()) {
/* 236 */       return validateNamedRangeName(paramString, paramSpreadsheetVersion);
/*     */     }
/* 238 */     String str1 = matcher.group(1);
/* 239 */     String str2 = matcher.group(2);
/* 240 */     if (cellReferenceIsWithinRange(str1, str2, paramSpreadsheetVersion))
/*     */     {
/* 242 */       return NameType.CELL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     if (paramString.indexOf('$') >= 0)
/*     */     {
/* 251 */       return NameType.BAD_CELL_OR_NAMED_RANGE;
/*     */     }
/* 253 */     return NameType.NAMED_RANGE;
/*     */   }
/*     */   
/*     */   private static NameType validateNamedRangeName(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 257 */     Matcher matcher1 = COLUMN_REF_PATTERN.matcher(paramString);
/* 258 */     if (matcher1.matches()) {
/* 259 */       String str = matcher1.group(1);
/* 260 */       if (isColumnWithinRange(str, paramSpreadsheetVersion)) {
/* 261 */         return NameType.COLUMN;
/*     */       }
/*     */     } 
/* 264 */     Matcher matcher2 = ROW_REF_PATTERN.matcher(paramString);
/* 265 */     if (matcher2.matches()) {
/* 266 */       String str = matcher2.group(1);
/* 267 */       if (isRowWithinRange(str, paramSpreadsheetVersion)) {
/* 268 */         return NameType.ROW;
/*     */       }
/*     */     } 
/* 271 */     if (!NAMED_RANGE_NAME_PATTERN.matcher(paramString).matches()) {
/* 272 */       return NameType.BAD_CELL_OR_NAMED_RANGE;
/*     */     }
/* 274 */     return NameType.NAMED_RANGE;
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
/*     */   public static boolean cellReferenceIsWithinRange(String paramString1, String paramString2, SpreadsheetVersion paramSpreadsheetVersion) {
/* 315 */     if (!isColumnWithinRange(paramString1, paramSpreadsheetVersion)) {
/* 316 */       return false;
/*     */     }
/* 318 */     return isRowWithinRange(paramString2, paramSpreadsheetVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isColumnWithnRange(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 325 */     return isColumnWithinRange(paramString, paramSpreadsheetVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isColumnWithinRange(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 331 */     String str = paramSpreadsheetVersion.getLastColumnName();
/* 332 */     int i = str.length();
/*     */     
/* 334 */     int j = paramString.length();
/* 335 */     if (j > i)
/*     */     {
/* 337 */       return false;
/*     */     }
/* 339 */     if (j == i && 
/* 340 */       paramString.toUpperCase(Locale.ROOT).compareTo(str) > 0) {
/* 341 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isRowWithnRange(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 354 */     return isRowWithinRange(paramString, paramSpreadsheetVersion);
/*     */   }
/*     */   
/*     */   public static boolean isRowWithinRange(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/* 358 */     int i = Integer.parseInt(paramString) - 1;
/* 359 */     return (0 <= i && i <= paramSpreadsheetVersion.getLastRowIndex());
/*     */   }
/*     */   
/*     */   private static final class CellRefParts {
/*     */     final String sheetName;
/*     */     final String rowRef;
/*     */     final String colRef;
/*     */     
/*     */     private CellRefParts(String param1String1, String param1String2, String param1String3) {
/* 368 */       this.sheetName = param1String1;
/* 369 */       this.rowRef = (param1String2 != null) ? param1String2 : "";
/* 370 */       this.colRef = (param1String3 != null) ? param1String3 : "";
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
/*     */   
/*     */   private static CellRefParts separateRefParts(String paramString) {
/* 385 */     int i = paramString.lastIndexOf('!');
/* 386 */     String str1 = parseSheetName(paramString, i);
/* 387 */     String str2 = paramString.substring(i + 1).toUpperCase(Locale.ROOT);
/* 388 */     Matcher matcher = CELL_REF_PATTERN.matcher(str2);
/* 389 */     if (!matcher.matches()) throw new IllegalArgumentException("Invalid CellReference: " + paramString); 
/* 390 */     String str3 = matcher.group(1);
/* 391 */     String str4 = matcher.group(2);
/*     */     
/* 393 */     return new CellRefParts(str1, str4, str3);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String parseSheetName(String paramString, int paramInt) {
/* 398 */     if (paramInt < 0) {
/* 399 */       return null;
/*     */     }
/*     */     
/* 402 */     boolean bool = (paramString.charAt(0) == '\'') ? true : false;
/* 403 */     if (!bool) {
/*     */       
/* 405 */       if (paramString.indexOf(' ') == -1) {
/* 406 */         return paramString.substring(0, paramInt);
/*     */       }
/* 408 */       throw new IllegalArgumentException("Sheet names containing spaces must be quoted: (" + paramString + ")");
/*     */     } 
/*     */     
/* 411 */     int i = paramInt - 1;
/* 412 */     if (paramString.charAt(i) != '\'') {
/* 413 */       throw new IllegalArgumentException("Mismatched quotes: (" + paramString + ")");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 423 */     StringBuffer stringBuffer = new StringBuffer(paramInt);
/*     */     
/* 425 */     for (byte b = 1; b < i; b++) {
/* 426 */       char c = paramString.charAt(b);
/* 427 */       if (c != '\'') {
/* 428 */         stringBuffer.append(c);
/*     */       
/*     */       }
/* 431 */       else if (b < i && 
/* 432 */         paramString.charAt(b + 1) == '\'') {
/*     */         
/* 434 */         b++;
/* 435 */         stringBuffer.append(c);
/*     */       }
/*     */       else {
/*     */         
/* 439 */         throw new IllegalArgumentException("Bad sheet name quote escaping: (" + paramString + ")");
/*     */       } 
/* 441 */     }  return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String convertNumToColString(int paramInt) {
/* 452 */     int i = paramInt + 1;
/*     */     
/* 454 */     StringBuilder stringBuilder = new StringBuilder(2);
/* 455 */     int j = i;
/*     */     
/* 457 */     while (j > 0) {
/* 458 */       int k = j % 26;
/* 459 */       if (k == 0) k = 26; 
/* 460 */       j = (j - k) / 26;
/*     */ 
/*     */       
/* 463 */       char c = (char)(k + 64);
/* 464 */       stringBuilder.insert(0, c);
/*     */     } 
/*     */     
/* 467 */     return stringBuilder.toString();
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
/*     */   public String formatAsString() {
/* 483 */     StringBuffer stringBuffer = new StringBuffer(32);
/* 484 */     if (this._sheetName != null) {
/* 485 */       SheetNameFormatter.appendFormat(stringBuffer, this._sheetName);
/* 486 */       stringBuffer.append('!');
/*     */     } 
/* 488 */     appendCellReference(stringBuffer);
/* 489 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 494 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 495 */     stringBuffer.append(getClass().getName()).append(" [");
/* 496 */     stringBuffer.append(formatAsString());
/* 497 */     stringBuffer.append("]");
/* 498 */     return stringBuffer.toString();
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
/*     */   public String[] getCellRefParts() {
/* 511 */     return new String[] { this._sheetName, Integer.toString(this._rowIndex + 1), convertNumToColString(this._colIndex) };
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
/*     */   void appendCellReference(StringBuffer paramStringBuffer) {
/* 523 */     if (this._colIndex != -1) {
/* 524 */       if (this._isColAbs) {
/* 525 */         paramStringBuffer.append('$');
/*     */       }
/* 527 */       paramStringBuffer.append(convertNumToColString(this._colIndex));
/*     */     } 
/* 529 */     if (this._rowIndex != -1) {
/* 530 */       if (this._isRowAbs) {
/* 531 */         paramStringBuffer.append('$');
/*     */       }
/* 533 */       paramStringBuffer.append(this._rowIndex + 1);
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
/*     */   public boolean equals(Object paramObject) {
/* 546 */     if (this == paramObject) {
/* 547 */       return true;
/*     */     }
/* 549 */     if (!(paramObject instanceof CellReference)) {
/* 550 */       return false;
/*     */     }
/* 552 */     CellReference cellReference = (CellReference)paramObject;
/* 553 */     return (this._rowIndex == cellReference._rowIndex && this._colIndex == cellReference._colIndex && this._isRowAbs == cellReference._isRowAbs && this._isColAbs == cellReference._isColAbs && ((this._sheetName == null) ? (cellReference._sheetName == null) : this._sheetName.equals(cellReference._sheetName)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 564 */     int i = 17;
/* 565 */     i = 31 * i + this._rowIndex;
/* 566 */     i = 31 * i + this._colIndex;
/* 567 */     i = 31 * i + (this._isRowAbs ? 1 : 0);
/* 568 */     i = 31 * i + (this._isColAbs ? 1 : 0);
/* 569 */     i = 31 * i + ((this._sheetName == null) ? 0 : this._sheetName.hashCode());
/* 570 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */