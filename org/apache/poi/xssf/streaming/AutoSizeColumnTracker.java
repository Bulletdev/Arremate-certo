/*     */ package org.apache.poi.xssf.streaming;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.DataFormatter;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.SheetUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ class AutoSizeColumnTracker
/*     */ {
/*     */   private final int defaultCharWidth;
/*  51 */   private final DataFormatter dataFormatter = new DataFormatter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private final Map<Integer, ColumnWidthPair> maxColumnWidths = new HashMap<Integer, ColumnWidthPair>();
/*     */ 
/*     */   
/*  61 */   private final Set<Integer> untrackedColumns = new HashSet<Integer>();
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean trackAllColumns = false;
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ColumnWidthPair
/*     */   {
/*     */     private double withSkipMergedCells;
/*     */ 
/*     */     
/*     */     private double withUseMergedCells;
/*     */ 
/*     */ 
/*     */     
/*     */     public ColumnWidthPair() {
/*  79 */       this(-1.0D, -1.0D);
/*     */     }
/*     */     
/*     */     public ColumnWidthPair(double param1Double1, double param1Double2) {
/*  83 */       this.withSkipMergedCells = param1Double1;
/*  84 */       this.withUseMergedCells = param1Double2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double getMaxColumnWidth(boolean param1Boolean) {
/*  94 */       return param1Boolean ? this.withUseMergedCells : this.withSkipMergedCells;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMaxColumnWidths(double param1Double1, double param1Double2) {
/* 104 */       this.withUseMergedCells = Math.max(this.withUseMergedCells, param1Double2);
/* 105 */       this.withSkipMergedCells = Math.max(this.withUseMergedCells, param1Double1);
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
/*     */   public AutoSizeColumnTracker(Sheet paramSheet) {
/* 117 */     this.defaultCharWidth = SheetUtil.getDefaultCharWidth(paramSheet.getWorkbook());
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
/*     */   public SortedSet<Integer> getTrackedColumns() {
/* 129 */     TreeSet<Integer> treeSet = new TreeSet(this.maxColumnWidths.keySet());
/* 130 */     return Collections.unmodifiableSortedSet(treeSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isColumnTracked(int paramInt) {
/* 141 */     return (this.trackAllColumns || this.maxColumnWidths.containsKey(Integer.valueOf(paramInt)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllColumnsTracked() {
/* 151 */     return this.trackAllColumns;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trackAllColumns() {
/* 160 */     this.trackAllColumns = true;
/* 161 */     this.untrackedColumns.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void untrackAllColumns() {
/* 170 */     this.trackAllColumns = false;
/* 171 */     this.maxColumnWidths.clear();
/* 172 */     this.untrackedColumns.clear();
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
/*     */   public void trackColumns(Collection<Integer> paramCollection) {
/* 185 */     for (Iterator<Integer> iterator = paramCollection.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 186 */       trackColumn(i); }
/*     */   
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
/*     */   public boolean trackColumn(int paramInt) {
/* 200 */     this.untrackedColumns.remove(Integer.valueOf(paramInt));
/* 201 */     if (!this.maxColumnWidths.containsKey(Integer.valueOf(paramInt))) {
/* 202 */       this.maxColumnWidths.put(Integer.valueOf(paramInt), new ColumnWidthPair());
/* 203 */       return true;
/*     */     } 
/* 205 */     return false;
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
/*     */   private boolean implicitlyTrackColumn(int paramInt) {
/* 217 */     if (!this.untrackedColumns.contains(Integer.valueOf(paramInt))) {
/* 218 */       trackColumn(paramInt);
/* 219 */       return true;
/*     */     } 
/* 221 */     return false;
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
/*     */   public boolean untrackColumns(Collection<Integer> paramCollection) {
/* 235 */     this.untrackedColumns.addAll(paramCollection);
/* 236 */     return this.maxColumnWidths.keySet().removeAll(paramCollection);
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
/*     */   public boolean untrackColumn(int paramInt) {
/* 249 */     this.untrackedColumns.add(Integer.valueOf(paramInt));
/* 250 */     return this.maxColumnWidths.keySet().remove(Integer.valueOf(paramInt));
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
/*     */   public int getBestFitColumnWidth(int paramInt, boolean paramBoolean) {
/* 263 */     if (!this.maxColumnWidths.containsKey(Integer.valueOf(paramInt)))
/*     */     {
/* 265 */       if (this.trackAllColumns) {
/* 266 */         if (!implicitlyTrackColumn(paramInt)) {
/* 267 */           IllegalStateException illegalStateException = new IllegalStateException("Column was explicitly untracked after trackAllColumns() was called.");
/*     */           
/* 269 */           throw new IllegalStateException("Cannot get best fit column width on explicitly untracked column " + paramInt + ". " + "Either explicitly track the column or track all columns.", illegalStateException);
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 275 */         IllegalStateException illegalStateException = new IllegalStateException("Column was never explicitly tracked and isAllColumnsTracked() is false (trackAllColumns() was never called or untrackAllColumns() was called after trackAllColumns() was called).");
/*     */ 
/*     */         
/* 278 */         throw new IllegalStateException("Cannot get best fit column width on untracked column " + paramInt + ". " + "Either explicitly track the column or track all columns.", illegalStateException);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 283 */     double d = ((ColumnWidthPair)this.maxColumnWidths.get(Integer.valueOf(paramInt))).getMaxColumnWidth(paramBoolean);
/* 284 */     return (int)(256.0D * d);
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
/*     */   public void updateColumnWidths(Row paramRow) {
/* 297 */     implicitlyTrackColumnsInRow(paramRow);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 302 */     if (this.maxColumnWidths.size() < paramRow.getPhysicalNumberOfCells()) {
/*     */       
/* 304 */       for (Map.Entry<Integer, ColumnWidthPair> entry : this.maxColumnWidths.entrySet()) {
/* 305 */         int i = ((Integer)entry.getKey()).intValue();
/* 306 */         Cell cell = paramRow.getCell(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 314 */         if (cell != null) {
/* 315 */           ColumnWidthPair columnWidthPair = (ColumnWidthPair)entry.getValue();
/* 316 */           updateColumnWidth(cell, columnWidthPair);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 322 */       for (Cell cell : paramRow) {
/* 323 */         int i = cell.getColumnIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 331 */         if (this.maxColumnWidths.containsKey(Integer.valueOf(i))) {
/* 332 */           ColumnWidthPair columnWidthPair = this.maxColumnWidths.get(Integer.valueOf(i));
/* 333 */           updateColumnWidth(cell, columnWidthPair);
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
/*     */   
/*     */   private void implicitlyTrackColumnsInRow(Row paramRow) {
/* 350 */     if (this.trackAllColumns)
/*     */     {
/* 352 */       for (Cell cell : paramRow) {
/* 353 */         int i = cell.getColumnIndex();
/* 354 */         implicitlyTrackColumn(i);
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
/*     */   private void updateColumnWidth(Cell paramCell, ColumnWidthPair paramColumnWidthPair) {
/* 367 */     double d1 = SheetUtil.getCellWidth(paramCell, this.defaultCharWidth, this.dataFormatter, false);
/* 368 */     double d2 = SheetUtil.getCellWidth(paramCell, this.defaultCharWidth, this.dataFormatter, true);
/* 369 */     paramColumnWidthPair.setMaxColumnWidths(d1, d2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\AutoSizeColumnTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */