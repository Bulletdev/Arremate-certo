/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ public class CellAddress
/*     */   implements Comparable<CellAddress>
/*     */ {
/*  37 */   public static final CellAddress A1 = new CellAddress(0, 0);
/*     */ 
/*     */ 
/*     */   
/*     */   private final int _row;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int _col;
/*     */ 
/*     */ 
/*     */   
/*     */   public CellAddress(int paramInt1, int paramInt2) {
/*  50 */     this._row = paramInt1;
/*  51 */     this._col = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellAddress(String paramString) {
/*  62 */     int i = paramString.length();
/*     */     
/*  64 */     byte b = 0;
/*     */     
/*  66 */     for (; b < i; b++) {
/*  67 */       char c = paramString.charAt(b);
/*  68 */       if (Character.isDigit(c)) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/*  73 */     String str1 = paramString.substring(0, b).toUpperCase(Locale.ROOT);
/*  74 */     String str2 = paramString.substring(b);
/*     */ 
/*     */     
/*  77 */     this._row = Integer.parseInt(str2) - 1;
/*  78 */     this._col = CellReference.convertColStringToIndex(str1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellAddress(CellReference paramCellReference) {
/*  87 */     this(paramCellReference.getRow(), paramCellReference.getCol());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellAddress(Cell paramCell) {
/*  96 */     this(paramCell.getRowIndex(), paramCell.getColumnIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow() {
/* 105 */     return this._row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumn() {
/* 114 */     return this._col;
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
/*     */   public int compareTo(CellAddress paramCellAddress) {
/* 130 */     int i = this._row - paramCellAddress._row;
/* 131 */     if (i != 0) return i;
/*     */     
/* 133 */     i = this._col - paramCellAddress._col;
/* 134 */     if (i != 0) return i;
/*     */     
/* 136 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 141 */     if (this == paramObject) {
/* 142 */       return true;
/*     */     }
/* 144 */     if (!(paramObject instanceof CellAddress)) {
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     CellAddress cellAddress = (CellAddress)paramObject;
/* 149 */     return (this._row == cellAddress._row && this._col == cellAddress._col);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 155 */     return this._row + this._col << 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     return formatAsString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatAsString() {
/* 168 */     return CellReference.convertNumToColString(this._col) + (this._row + 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */