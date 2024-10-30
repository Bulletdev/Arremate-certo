/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AreaReference
/*     */ {
/*     */   private static final char SHEET_NAME_DELIMITER = '!';
/*     */   private static final char CELL_DELIMITER = ':';
/*     */   private static final char SPECIAL_NAME_DELIMITER = '\'';
/*  34 */   private static final SpreadsheetVersion DEFAULT_SPREADSHEET_VERSION = SpreadsheetVersion.EXCEL97;
/*     */   
/*     */   private final CellReference _firstCell;
/*     */   
/*     */   private final CellReference _lastCell;
/*     */   
/*     */   private final boolean _isSingleCell;
/*     */   
/*     */   private final SpreadsheetVersion _version;
/*     */   
/*     */   @Deprecated
/*     */   public AreaReference(String paramString) {
/*  46 */     this(paramString, DEFAULT_SPREADSHEET_VERSION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AreaReference(String paramString, SpreadsheetVersion paramSpreadsheetVersion) {
/*  56 */     this._version = (null != paramSpreadsheetVersion) ? paramSpreadsheetVersion : DEFAULT_SPREADSHEET_VERSION;
/*  57 */     if (!isContiguous(paramString)) {
/*  58 */       throw new IllegalArgumentException("References passed to the AreaReference must be contiguous, use generateContiguous(ref) if you have non-contiguous references");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  63 */     String[] arrayOfString = separateAreaRefs(paramString);
/*  64 */     String str1 = arrayOfString[0];
/*  65 */     if (arrayOfString.length == 1) {
/*     */ 
/*     */       
/*  68 */       this._firstCell = new CellReference(str1);
/*     */       
/*  70 */       this._lastCell = this._firstCell;
/*  71 */       this._isSingleCell = true;
/*     */       return;
/*     */     } 
/*  74 */     if (arrayOfString.length != 2) {
/*  75 */       throw new IllegalArgumentException("Bad area ref '" + paramString + "'");
/*     */     }
/*     */     
/*  78 */     String str2 = arrayOfString[1];
/*  79 */     if (isPlainColumn(str1)) {
/*  80 */       if (!isPlainColumn(str2)) {
/*  81 */         throw new RuntimeException("Bad area ref '" + paramString + "'");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  87 */       boolean bool1 = CellReference.isPartAbsolute(str1);
/*  88 */       boolean bool2 = CellReference.isPartAbsolute(str2);
/*     */       
/*  90 */       int i = CellReference.convertColStringToIndex(str1);
/*  91 */       int j = CellReference.convertColStringToIndex(str2);
/*     */       
/*  93 */       this._firstCell = new CellReference(0, i, true, bool1);
/*  94 */       this._lastCell = new CellReference(65535, j, true, bool2);
/*  95 */       this._isSingleCell = false;
/*     */     } else {
/*     */       
/*  98 */       this._firstCell = new CellReference(str1);
/*  99 */       this._lastCell = new CellReference(str2);
/* 100 */       this._isSingleCell = str1.equals(str2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isPlainColumn(String paramString) {
/* 105 */     for (int i = paramString.length() - 1; i >= 0; i--) {
/* 106 */       char c = paramString.charAt(i);
/* 107 */       if (c != '$' || i != 0)
/*     */       {
/*     */         
/* 110 */         if (c < 'A' || c > 'Z')
/* 111 */           return false; 
/*     */       }
/*     */     } 
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AreaReference(CellReference paramCellReference1, CellReference paramCellReference2) {
/* 121 */     this._version = DEFAULT_SPREADSHEET_VERSION;
/* 122 */     boolean bool1 = (paramCellReference1.getRow() > paramCellReference2.getRow()) ? true : false;
/* 123 */     boolean bool2 = (paramCellReference1.getCol() > paramCellReference2.getCol()) ? true : false;
/* 124 */     if (bool1 || bool2) {
/*     */       int i, j;
/*     */ 
/*     */       
/*     */       short s1, s2;
/*     */ 
/*     */       
/*     */       boolean bool3, bool4, bool5, bool6;
/*     */       
/* 133 */       if (bool1) {
/* 134 */         i = paramCellReference2.getRow();
/* 135 */         bool3 = paramCellReference2.isRowAbsolute();
/* 136 */         j = paramCellReference1.getRow();
/* 137 */         bool4 = paramCellReference1.isRowAbsolute();
/*     */       } else {
/* 139 */         i = paramCellReference1.getRow();
/* 140 */         bool3 = paramCellReference1.isRowAbsolute();
/* 141 */         j = paramCellReference2.getRow();
/* 142 */         bool4 = paramCellReference2.isRowAbsolute();
/*     */       } 
/* 144 */       if (bool2) {
/* 145 */         s1 = paramCellReference2.getCol();
/* 146 */         bool5 = paramCellReference2.isColAbsolute();
/* 147 */         s2 = paramCellReference1.getCol();
/* 148 */         bool6 = paramCellReference1.isColAbsolute();
/*     */       } else {
/* 150 */         s1 = paramCellReference1.getCol();
/* 151 */         bool5 = paramCellReference1.isColAbsolute();
/* 152 */         s2 = paramCellReference2.getCol();
/* 153 */         bool6 = paramCellReference2.isColAbsolute();
/*     */       } 
/* 155 */       this._firstCell = new CellReference(i, s1, bool3, bool5);
/* 156 */       this._lastCell = new CellReference(j, s2, bool4, bool6);
/*     */     } else {
/* 158 */       this._firstCell = paramCellReference1;
/* 159 */       this._lastCell = paramCellReference2;
/*     */     } 
/* 161 */     this._isSingleCell = false;
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
/*     */   public static boolean isContiguous(String paramString) {
/* 173 */     int i = paramString.indexOf('!');
/* 174 */     if (i != -1) {
/* 175 */       paramString = paramString.substring(i);
/*     */     }
/*     */ 
/*     */     
/* 179 */     if (paramString.indexOf(',') == -1) {
/* 180 */       return true;
/*     */     }
/* 182 */     return false;
/*     */   }
/*     */   
/*     */   public static AreaReference getWholeRow(SpreadsheetVersion paramSpreadsheetVersion, String paramString1, String paramString2) {
/* 186 */     if (null == paramSpreadsheetVersion) {
/* 187 */       paramSpreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
/*     */     }
/* 189 */     return new AreaReference("$A" + paramString1 + ":$" + paramSpreadsheetVersion.getLastColumnName() + paramString2, paramSpreadsheetVersion);
/*     */   }
/*     */   
/*     */   public static AreaReference getWholeColumn(SpreadsheetVersion paramSpreadsheetVersion, String paramString1, String paramString2) {
/* 193 */     if (null == paramSpreadsheetVersion) {
/* 194 */       paramSpreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
/*     */     }
/* 196 */     return new AreaReference(paramString1 + "$1:" + paramString2 + "$" + paramSpreadsheetVersion.getMaxRows(), paramSpreadsheetVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isWholeColumnReference(SpreadsheetVersion paramSpreadsheetVersion, CellReference paramCellReference1, CellReference paramCellReference2) {
/* 204 */     if (null == paramSpreadsheetVersion) {
/* 205 */       paramSpreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     if (paramCellReference1.getRow() == 0 && paramCellReference1.isRowAbsolute() && paramCellReference2.getRow() == paramSpreadsheetVersion.getLastRowIndex() && paramCellReference2.isRowAbsolute())
/*     */     {
/* 213 */       return true;
/*     */     }
/* 215 */     return false;
/*     */   }
/*     */   public boolean isWholeColumnReference() {
/* 218 */     return isWholeColumnReference(this._version, this._firstCell, this._lastCell);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AreaReference[] generateContiguous(String paramString) {
/* 226 */     ArrayList<AreaReference> arrayList = new ArrayList();
/* 227 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ",");
/* 228 */     while (stringTokenizer.hasMoreTokens()) {
/* 229 */       arrayList.add(new AreaReference(stringTokenizer.nextToken()));
/*     */     }
/*     */ 
/*     */     
/* 233 */     return arrayList.<AreaReference>toArray(new AreaReference[arrayList.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSingleCell() {
/* 240 */     return this._isSingleCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellReference getFirstCell() {
/* 248 */     return this._firstCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellReference getLastCell() {
/* 259 */     return this._lastCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellReference[] getAllReferencedCells() {
/* 266 */     if (this._isSingleCell) {
/* 267 */       return new CellReference[] { this._firstCell };
/*     */     }
/*     */ 
/*     */     
/* 271 */     int i = Math.min(this._firstCell.getRow(), this._lastCell.getRow());
/* 272 */     int j = Math.max(this._firstCell.getRow(), this._lastCell.getRow());
/* 273 */     int k = Math.min(this._firstCell.getCol(), this._lastCell.getCol());
/* 274 */     int m = Math.max(this._firstCell.getCol(), this._lastCell.getCol());
/* 275 */     String str = this._firstCell.getSheetName();
/*     */     
/* 277 */     ArrayList<CellReference> arrayList = new ArrayList();
/* 278 */     for (int n = i; n <= j; n++) {
/* 279 */       for (int i1 = k; i1 <= m; i1++) {
/* 280 */         CellReference cellReference = new CellReference(str, n, i1, this._firstCell.isRowAbsolute(), this._firstCell.isColAbsolute());
/* 281 */         arrayList.add(cellReference);
/*     */       } 
/*     */     } 
/* 284 */     return arrayList.<CellReference>toArray(new CellReference[arrayList.size()]);
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
/*     */   public String formatAsString() {
/* 302 */     if (isWholeColumnReference()) {
/* 303 */       return CellReference.convertNumToColString(this._firstCell.getCol()) + ":" + CellReference.convertNumToColString(this._lastCell.getCol());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     StringBuffer stringBuffer = new StringBuffer(32);
/* 310 */     stringBuffer.append(this._firstCell.formatAsString());
/* 311 */     if (!this._isSingleCell) {
/* 312 */       stringBuffer.append(':');
/* 313 */       if (this._lastCell.getSheetName() == null) {
/* 314 */         stringBuffer.append(this._lastCell.formatAsString());
/*     */       } else {
/*     */         
/* 317 */         this._lastCell.appendCellReference(stringBuffer);
/*     */       } 
/*     */     } 
/* 320 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 324 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 325 */     stringBuffer.append(getClass().getName()).append(" [");
/* 326 */     stringBuffer.append(formatAsString());
/* 327 */     stringBuffer.append("]");
/* 328 */     return stringBuffer.toString();
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
/*     */   private static String[] separateAreaRefs(String paramString) {
/* 346 */     int i = paramString.length();
/* 347 */     byte b = -1;
/* 348 */     boolean bool = false;
/* 349 */     byte b1 = 0; while (true) { if (b1 < i)
/* 350 */       { switch (paramString.charAt(b1))
/*     */         { case ':':
/* 352 */             if (!bool) {
/* 353 */               if (b >= 0) {
/* 354 */                 throw new IllegalArgumentException("More than one cell delimiter ':' appears in area reference '" + paramString + "'");
/*     */               }
/*     */               
/* 357 */               b = b1;
/*     */             } 
/*     */             break;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case '\'':
/* 365 */             if (!bool)
/* 366 */             { bool = true; }
/*     */             
/*     */             else
/*     */             
/* 370 */             { if (b1 >= i - 1)
/*     */               {
/*     */                 
/* 373 */                 throw new IllegalArgumentException("Area reference '" + paramString + "' ends with special name delimiter '" + '\'' + "'");
/*     */               }
/*     */               
/* 376 */               if (paramString.charAt(b1 + 1) == '\'')
/*     */               
/* 378 */               { b1++; }
/*     */               else
/*     */               
/* 381 */               { bool = false; }  }  b1++; continue; }  }
/*     */       else { break; }
/*     */        b1++; }
/* 384 */      if (b < 0) {
/* 385 */       return new String[] { paramString };
/*     */     }
/*     */     
/* 388 */     String str1 = paramString.substring(0, b);
/* 389 */     String str2 = paramString.substring(b + 1);
/* 390 */     if (str2.indexOf('!') >= 0)
/*     */     {
/*     */ 
/*     */       
/* 394 */       throw new RuntimeException("Unexpected ! in second cell reference of '" + paramString + "'");
/*     */     }
/*     */ 
/*     */     
/* 398 */     int j = str1.lastIndexOf('!');
/* 399 */     if (j < 0) {
/* 400 */       return new String[] { str1, str2 };
/*     */     }
/*     */     
/* 403 */     String str3 = str1.substring(0, j + 1);
/*     */     
/* 405 */     return new String[] { str1, str3 + str2 };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\AreaReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */