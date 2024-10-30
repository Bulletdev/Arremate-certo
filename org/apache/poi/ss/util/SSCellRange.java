/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellRange;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public final class SSCellRange<K extends Cell>
/*     */   implements CellRange<K>
/*     */ {
/*     */   private final int _height;
/*     */   private final int _width;
/*     */   private final K[] _flattenedArray;
/*     */   private final int _firstRow;
/*     */   private final int _firstColumn;
/*     */   
/*     */   private SSCellRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, K[] paramArrayOfK) {
/*  44 */     this._firstRow = paramInt1;
/*  45 */     this._firstColumn = paramInt2;
/*  46 */     this._height = paramInt3;
/*  47 */     this._width = paramInt4;
/*  48 */     this._flattenedArray = (K[])paramArrayOfK.clone();
/*     */   }
/*     */   
/*     */   public static <B extends Cell> SSCellRange<B> create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<B> paramList, Class<B> paramClass) {
/*  52 */     int i = paramList.size();
/*  53 */     if (paramInt3 * paramInt4 != i) {
/*  54 */       throw new IllegalArgumentException("Array size mismatch.");
/*     */     }
/*     */ 
/*     */     
/*  58 */     Cell[] arrayOfCell = (Cell[])Array.newInstance(paramClass, i);
/*  59 */     paramList.toArray(arrayOfCell);
/*  60 */     return new SSCellRange<B>(paramInt1, paramInt2, paramInt3, paramInt4, (B[])arrayOfCell);
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*  64 */     return this._height;
/*     */   }
/*     */   public int getWidth() {
/*  67 */     return this._width;
/*     */   }
/*     */   public int size() {
/*  70 */     return this._height * this._width;
/*     */   }
/*     */   
/*     */   public String getReferenceText() {
/*  74 */     CellRangeAddress cellRangeAddress = new CellRangeAddress(this._firstRow, this._firstRow + this._height - 1, this._firstColumn, this._firstColumn + this._width - 1);
/*  75 */     return cellRangeAddress.formatAsString();
/*     */   }
/*     */   
/*     */   public K getTopLeftCell() {
/*  79 */     return this._flattenedArray[0];
/*     */   }
/*     */   
/*     */   public K getCell(int paramInt1, int paramInt2) {
/*  83 */     if (paramInt1 < 0 || paramInt1 >= this._height) {
/*  84 */       throw new ArrayIndexOutOfBoundsException("Specified row " + paramInt1 + " is outside the allowable range (0.." + (this._height - 1) + ").");
/*     */     }
/*     */     
/*  87 */     if (paramInt2 < 0 || paramInt2 >= this._width) {
/*  88 */       throw new ArrayIndexOutOfBoundsException("Specified colummn " + paramInt2 + " is outside the allowable range (0.." + (this._width - 1) + ").");
/*     */     }
/*     */     
/*  91 */     int i = this._width * paramInt1 + paramInt2;
/*  92 */     return this._flattenedArray[i];
/*     */   }
/*     */   public K[] getFlattenedCells() {
/*  95 */     return (K[])this._flattenedArray.clone();
/*     */   }
/*     */   
/*     */   public K[][] getCells() {
/*  99 */     Class<?> clazz = this._flattenedArray.getClass();
/*     */     
/* 101 */     Cell[][] arrayOfCell = (Cell[][])Array.newInstance(clazz, this._height);
/* 102 */     clazz = clazz.getComponentType();
/* 103 */     for (int i = this._height - 1; i >= 0; i--) {
/*     */       
/* 105 */       Cell[] arrayOfCell1 = (Cell[])Array.newInstance(clazz, this._width);
/* 106 */       int j = this._width * i;
/* 107 */       System.arraycopy(this._flattenedArray, j, arrayOfCell1, 0, this._width);
/*     */     } 
/* 109 */     return (K[][])arrayOfCell;
/*     */   }
/*     */   public Iterator<K> iterator() {
/* 112 */     return new ArrayIterator<K>(this._flattenedArray);
/*     */   }
/*     */   
/*     */   private static final class ArrayIterator<D> implements Iterator<D> {
/*     */     private final D[] _array;
/*     */     private int _index;
/*     */     
/*     */     public ArrayIterator(D[] param1ArrayOfD) {
/* 120 */       this._array = (D[])param1ArrayOfD.clone();
/* 121 */       this._index = 0;
/*     */     }
/*     */     public boolean hasNext() {
/* 124 */       return (this._index < this._array.length);
/*     */     }
/*     */     public D next() {
/* 127 */       if (this._index >= this._array.length) {
/* 128 */         throw new NoSuchElementException(String.valueOf(this._index));
/*     */       }
/* 130 */       return this._array[this._index++];
/*     */     }
/*     */     
/*     */     public void remove() {
/* 134 */       throw new UnsupportedOperationException("Cannot remove cells from this CellRange.");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\SSCellRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */