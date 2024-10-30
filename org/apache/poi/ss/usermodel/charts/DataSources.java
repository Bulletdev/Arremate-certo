/*     */ package org.apache.poi.ss.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.CellValue;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
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
/*     */ public class DataSources
/*     */ {
/*     */   public static <T> ChartDataSource<T> fromArray(T[] paramArrayOfT) {
/*  38 */     return new ArrayDataSource<T>(paramArrayOfT);
/*     */   }
/*     */   
/*     */   public static ChartDataSource<Number> fromNumericCellRange(Sheet paramSheet, CellRangeAddress paramCellRangeAddress) {
/*  42 */     return new AbstractCellRangeDataSource<Number>(paramSheet, paramCellRangeAddress) {
/*     */         public Number getPointAt(int param1Int) {
/*  44 */           CellValue cellValue = getCellValueAt(param1Int);
/*  45 */           if (cellValue != null && cellValue.getCellTypeEnum() == CellType.NUMERIC) {
/*  46 */             return Double.valueOf(cellValue.getNumberValue());
/*     */           }
/*  48 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isNumeric() {
/*  53 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public static ChartDataSource<String> fromStringCellRange(Sheet paramSheet, CellRangeAddress paramCellRangeAddress) {
/*  59 */     return new AbstractCellRangeDataSource<String>(paramSheet, paramCellRangeAddress) {
/*     */         public String getPointAt(int param1Int) {
/*  61 */           CellValue cellValue = getCellValueAt(param1Int);
/*  62 */           if (cellValue != null && cellValue.getCellTypeEnum() == CellType.STRING) {
/*  63 */             return cellValue.getStringValue();
/*     */           }
/*  65 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isNumeric() {
/*  70 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static class ArrayDataSource<T>
/*     */     implements ChartDataSource<T> {
/*     */     private final T[] elements;
/*     */     
/*     */     public ArrayDataSource(T[] param1ArrayOfT) {
/*  80 */       this.elements = (T[])param1ArrayOfT.clone();
/*     */     }
/*     */     
/*     */     public int getPointCount() {
/*  84 */       return this.elements.length;
/*     */     }
/*     */     
/*     */     public T getPointAt(int param1Int) {
/*  88 */       return this.elements[param1Int];
/*     */     }
/*     */     
/*     */     public boolean isReference() {
/*  92 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isNumeric() {
/*  96 */       Class<?> clazz = this.elements.getClass().getComponentType();
/*  97 */       return Number.class.isAssignableFrom(clazz);
/*     */     }
/*     */     
/*     */     public String getFormulaString() {
/* 101 */       throw new UnsupportedOperationException("Literal data source can not be expressed by reference.");
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class AbstractCellRangeDataSource<T> implements ChartDataSource<T> {
/*     */     private final Sheet sheet;
/*     */     private final CellRangeAddress cellRangeAddress;
/*     */     private final int numOfCells;
/*     */     private FormulaEvaluator evaluator;
/*     */     
/*     */     protected AbstractCellRangeDataSource(Sheet param1Sheet, CellRangeAddress param1CellRangeAddress) {
/* 112 */       this.sheet = param1Sheet;
/*     */       
/* 114 */       this.cellRangeAddress = param1CellRangeAddress.copy();
/* 115 */       this.numOfCells = this.cellRangeAddress.getNumberOfCells();
/* 116 */       this.evaluator = param1Sheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
/*     */     }
/*     */     
/*     */     public int getPointCount() {
/* 120 */       return this.numOfCells;
/*     */     }
/*     */     
/*     */     public boolean isReference() {
/* 124 */       return true;
/*     */     }
/*     */     
/*     */     public String getFormulaString() {
/* 128 */       return this.cellRangeAddress.formatAsString(this.sheet.getSheetName(), true);
/*     */     }
/*     */     
/*     */     protected CellValue getCellValueAt(int param1Int) {
/* 132 */       if (param1Int < 0 || param1Int >= this.numOfCells) {
/* 133 */         throw new IndexOutOfBoundsException("Index must be between 0 and " + (this.numOfCells - 1) + " (inclusive), given: " + param1Int);
/*     */       }
/*     */       
/* 136 */       int i = this.cellRangeAddress.getFirstRow();
/* 137 */       int j = this.cellRangeAddress.getFirstColumn();
/* 138 */       int k = this.cellRangeAddress.getLastColumn();
/* 139 */       int m = k - j + 1;
/* 140 */       int n = i + param1Int / m;
/* 141 */       int i1 = j + param1Int % m;
/* 142 */       Row row = this.sheet.getRow(n);
/* 143 */       return (row == null) ? null : this.evaluator.evaluate(row.getCell(i1));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\DataSources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */