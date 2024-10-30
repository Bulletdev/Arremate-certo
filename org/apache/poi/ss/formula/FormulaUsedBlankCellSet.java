/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.util.CellReference;
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
/*     */ final class FormulaUsedBlankCellSet
/*     */ {
/*     */   private final Map<BookSheetKey, BlankCellSheetGroup> _sheetGroupsByBookSheet;
/*     */   
/*     */   public static final class BookSheetKey
/*     */   {
/*     */     private final int _bookIndex;
/*     */     private final int _sheetIndex;
/*     */     
/*     */     public BookSheetKey(int param1Int1, int param1Int2) {
/*  39 */       this._bookIndex = param1Int1;
/*  40 */       this._sheetIndex = param1Int2;
/*     */     }
/*     */     public int hashCode() {
/*  43 */       return this._bookIndex * 17 + this._sheetIndex;
/*     */     }
/*     */     public boolean equals(Object param1Object) {
/*  46 */       assert param1Object instanceof BookSheetKey : "these private cache key instances are only compared to themselves";
/*  47 */       BookSheetKey bookSheetKey = (BookSheetKey)param1Object;
/*  48 */       return (this._bookIndex == bookSheetKey._bookIndex && this._sheetIndex == bookSheetKey._sheetIndex);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class BlankCellSheetGroup
/*     */   {
/*  60 */     private final List<FormulaUsedBlankCellSet.BlankCellRectangleGroup> _rectangleGroups = new ArrayList<FormulaUsedBlankCellSet.BlankCellRectangleGroup>();
/*  61 */     private int _currentRowIndex = -1;
/*     */     private int _firstColumnIndex;
/*     */     
/*     */     public void addCell(int param1Int1, int param1Int2) {
/*  65 */       if (this._currentRowIndex == -1) {
/*  66 */         this._currentRowIndex = param1Int1;
/*  67 */         this._firstColumnIndex = param1Int2;
/*  68 */         this._lastColumnIndex = param1Int2;
/*     */       }
/*  70 */       else if (this._currentRowIndex == param1Int1 && this._lastColumnIndex + 1 == param1Int2) {
/*  71 */         this._lastColumnIndex = param1Int2;
/*     */       } else {
/*     */         
/*  74 */         if (this._currentRectangleGroup == null) {
/*  75 */           this._currentRectangleGroup = new FormulaUsedBlankCellSet.BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
/*     */         }
/*  77 */         else if (!this._currentRectangleGroup.acceptRow(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex)) {
/*  78 */           this._rectangleGroups.add(this._currentRectangleGroup);
/*  79 */           this._currentRectangleGroup = new FormulaUsedBlankCellSet.BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
/*     */         } 
/*     */         
/*  82 */         this._currentRowIndex = param1Int1;
/*  83 */         this._firstColumnIndex = param1Int2;
/*  84 */         this._lastColumnIndex = param1Int2;
/*     */       } 
/*     */     }
/*     */     private int _lastColumnIndex; private FormulaUsedBlankCellSet.BlankCellRectangleGroup _currentRectangleGroup;
/*     */     
/*     */     public boolean containsCell(int param1Int1, int param1Int2) {
/*  90 */       for (int i = this._rectangleGroups.size() - 1; i >= 0; i--) {
/*  91 */         FormulaUsedBlankCellSet.BlankCellRectangleGroup blankCellRectangleGroup = this._rectangleGroups.get(i);
/*  92 */         if (blankCellRectangleGroup.containsCell(param1Int1, param1Int2)) {
/*  93 */           return true;
/*     */         }
/*     */       } 
/*  96 */       if (this._currentRectangleGroup != null && this._currentRectangleGroup.containsCell(param1Int1, param1Int2)) {
/*  97 */         return true;
/*     */       }
/*  99 */       if (this._currentRowIndex != -1 && this._currentRowIndex == param1Int1 && 
/* 100 */         this._firstColumnIndex <= param1Int2 && param1Int2 <= this._lastColumnIndex) {
/* 101 */         return true;
/*     */       }
/*     */       
/* 104 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class BlankCellRectangleGroup
/*     */   {
/*     */     private final int _firstRowIndex;
/*     */     private final int _firstColumnIndex;
/*     */     private final int _lastColumnIndex;
/*     */     private int _lastRowIndex;
/*     */     
/*     */     public BlankCellRectangleGroup(int param1Int1, int param1Int2, int param1Int3) {
/* 116 */       this._firstRowIndex = param1Int1;
/* 117 */       this._firstColumnIndex = param1Int2;
/* 118 */       this._lastColumnIndex = param1Int3;
/* 119 */       this._lastRowIndex = param1Int1;
/*     */     }
/*     */     
/*     */     public boolean containsCell(int param1Int1, int param1Int2) {
/* 123 */       if (param1Int2 < this._firstColumnIndex) {
/* 124 */         return false;
/*     */       }
/* 126 */       if (param1Int2 > this._lastColumnIndex) {
/* 127 */         return false;
/*     */       }
/* 129 */       if (param1Int1 < this._firstRowIndex) {
/* 130 */         return false;
/*     */       }
/* 132 */       if (param1Int1 > this._lastRowIndex) {
/* 133 */         return false;
/*     */       }
/* 135 */       return true;
/*     */     }
/*     */     
/*     */     public boolean acceptRow(int param1Int1, int param1Int2, int param1Int3) {
/* 139 */       if (param1Int2 != this._firstColumnIndex) {
/* 140 */         return false;
/*     */       }
/* 142 */       if (param1Int3 != this._lastColumnIndex) {
/* 143 */         return false;
/*     */       }
/* 145 */       if (param1Int1 != this._lastRowIndex + 1) {
/* 146 */         return false;
/*     */       }
/* 148 */       this._lastRowIndex = param1Int1;
/* 149 */       return true;
/*     */     }
/*     */     public String toString() {
/* 152 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 153 */       CellReference cellReference1 = new CellReference(this._firstRowIndex, this._firstColumnIndex, false, false);
/* 154 */       CellReference cellReference2 = new CellReference(this._lastRowIndex, this._lastColumnIndex, false, false);
/* 155 */       stringBuffer.append(getClass().getName());
/* 156 */       stringBuffer.append(" [").append(cellReference1.formatAsString()).append(':').append(cellReference2.formatAsString()).append("]");
/* 157 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FormulaUsedBlankCellSet() {
/* 164 */     this._sheetGroupsByBookSheet = new HashMap<BookSheetKey, BlankCellSheetGroup>();
/*     */   }
/*     */   
/*     */   public void addCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 168 */     BlankCellSheetGroup blankCellSheetGroup = getSheetGroup(paramInt1, paramInt2);
/* 169 */     blankCellSheetGroup.addCell(paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   private BlankCellSheetGroup getSheetGroup(int paramInt1, int paramInt2) {
/* 173 */     BookSheetKey bookSheetKey = new BookSheetKey(paramInt1, paramInt2);
/*     */     
/* 175 */     BlankCellSheetGroup blankCellSheetGroup = this._sheetGroupsByBookSheet.get(bookSheetKey);
/* 176 */     if (blankCellSheetGroup == null) {
/* 177 */       blankCellSheetGroup = new BlankCellSheetGroup();
/* 178 */       this._sheetGroupsByBookSheet.put(bookSheetKey, blankCellSheetGroup);
/*     */     } 
/* 180 */     return blankCellSheetGroup;
/*     */   }
/*     */   
/*     */   public boolean containsCell(BookSheetKey paramBookSheetKey, int paramInt1, int paramInt2) {
/* 184 */     BlankCellSheetGroup blankCellSheetGroup = this._sheetGroupsByBookSheet.get(paramBookSheetKey);
/* 185 */     if (blankCellSheetGroup == null) {
/* 186 */       return false;
/*     */     }
/* 188 */     return blankCellSheetGroup.containsCell(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 192 */     return this._sheetGroupsByBookSheet.isEmpty();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaUsedBlankCellSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */