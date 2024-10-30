/*     */ package org.apache.poi.xssf.usermodel.helpers;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.xssf.util.CTColComparator;
/*     */ import org.apache.poi.xssf.util.NumericRanges;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
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
/*     */ public class ColumnHelper
/*     */ {
/*     */   private CTWorksheet worksheet;
/*     */   
/*     */   public ColumnHelper(CTWorksheet paramCTWorksheet) {
/*  45 */     this.worksheet = paramCTWorksheet;
/*  46 */     cleanColumns();
/*     */   }
/*     */   
/*     */   public void cleanColumns() {
/*  50 */     TreeSet<CTCol> treeSet = new TreeSet(CTColComparator.BY_MIN_MAX);
/*  51 */     CTCols cTCols = CTCols.Factory.newInstance();
/*  52 */     CTCols[] arrayOfCTCols = this.worksheet.getColsArray();
/*  53 */     byte b = 0;
/*  54 */     for (b = 0; b < arrayOfCTCols.length; b++) {
/*  55 */       CTCols cTCols1 = arrayOfCTCols[b];
/*  56 */       CTCol[] arrayOfCTCol = cTCols1.getColArray();
/*  57 */       for (CTCol cTCol : arrayOfCTCol) {
/*  58 */         addCleanColIntoCols(cTCols, cTCol, treeSet);
/*     */       }
/*     */     } 
/*  61 */     for (int i = b - 1; i >= 0; i--) {
/*  62 */       this.worksheet.removeCols(i);
/*     */     }
/*     */     
/*  65 */     cTCols.setColArray((CTCol[])treeSet.toArray((Object[])new CTCol[treeSet.size()]));
/*  66 */     this.worksheet.addNewCols();
/*  67 */     this.worksheet.setColsArray(0, cTCols);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTCols addCleanColIntoCols(CTCols paramCTCols, CTCol paramCTCol) {
/*  75 */     TreeSet<CTCol> treeSet = new TreeSet(CTColComparator.BY_MIN_MAX);
/*     */     
/*  77 */     treeSet.addAll(paramCTCols.getColList());
/*  78 */     addCleanColIntoCols(paramCTCols, paramCTCol, treeSet);
/*  79 */     paramCTCols.setColArray((CTCol[])treeSet.toArray((Object[])new CTCol[0]));
/*  80 */     return paramCTCols;
/*     */   }
/*     */   
/*     */   private void addCleanColIntoCols(CTCols paramCTCols, CTCol paramCTCol, TreeSet<CTCol> paramTreeSet) {
/*  84 */     List<CTCol> list = getOverlappingCols(paramCTCol, paramTreeSet);
/*  85 */     if (list.isEmpty()) {
/*  86 */       paramTreeSet.add(cloneCol(paramCTCols, paramCTCol));
/*     */       
/*     */       return;
/*     */     } 
/*  90 */     paramTreeSet.removeAll(list);
/*  91 */     for (CTCol cTCol1 : list) {
/*     */ 
/*     */       
/*  94 */       long[] arrayOfLong1 = getOverlap(paramCTCol, cTCol1);
/*     */       
/*  96 */       CTCol cTCol2 = cloneCol(paramCTCols, cTCol1, arrayOfLong1);
/*  97 */       setColumnAttributes(paramCTCol, cTCol2);
/*  98 */       paramTreeSet.add(cTCol2);
/*     */       
/* 100 */       CTCol cTCol3 = (cTCol1.getMin() < paramCTCol.getMin()) ? cTCol1 : paramCTCol;
/*     */       
/* 102 */       long[] arrayOfLong2 = { Math.min(cTCol1.getMin(), paramCTCol.getMin()), arrayOfLong1[0] - 1L };
/*     */ 
/*     */       
/* 105 */       if (arrayOfLong2[0] <= arrayOfLong2[1]) {
/* 106 */         paramTreeSet.add(cloneCol(paramCTCols, cTCol3, arrayOfLong2));
/*     */       }
/*     */       
/* 109 */       CTCol cTCol4 = (cTCol1.getMax() > paramCTCol.getMax()) ? cTCol1 : paramCTCol;
/*     */       
/* 111 */       long[] arrayOfLong3 = { arrayOfLong1[1] + 1L, Math.max(cTCol1.getMax(), paramCTCol.getMax()) };
/*     */       
/* 113 */       if (arrayOfLong3[0] <= arrayOfLong3[1]) {
/* 114 */         paramTreeSet.add(cloneCol(paramCTCols, cTCol4, arrayOfLong3));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private CTCol cloneCol(CTCols paramCTCols, CTCol paramCTCol, long[] paramArrayOflong) {
/* 120 */     CTCol cTCol = cloneCol(paramCTCols, paramCTCol);
/* 121 */     cTCol.setMin(paramArrayOflong[0]);
/* 122 */     cTCol.setMax(paramArrayOflong[1]);
/* 123 */     return cTCol;
/*     */   }
/*     */   
/*     */   private long[] getOverlap(CTCol paramCTCol1, CTCol paramCTCol2) {
/* 127 */     return getOverlappingRange(paramCTCol1, paramCTCol2);
/*     */   }
/*     */   
/*     */   private List<CTCol> getOverlappingCols(CTCol paramCTCol, TreeSet<CTCol> paramTreeSet) {
/* 131 */     CTCol cTCol = paramTreeSet.lower(paramCTCol);
/* 132 */     NavigableSet navigableSet = (NavigableSet)((cTCol == null) ? paramTreeSet : paramTreeSet.tailSet(cTCol, overlaps(cTCol, paramCTCol)));
/* 133 */     ArrayList<CTCol> arrayList = new ArrayList();
/* 134 */     for (CTCol cTCol1 : navigableSet) {
/* 135 */       if (overlaps(paramCTCol, cTCol1)) {
/* 136 */         arrayList.add(cTCol1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 141 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean overlaps(CTCol paramCTCol1, CTCol paramCTCol2) {
/* 145 */     return (NumericRanges.getOverlappingType(toRange(paramCTCol1), toRange(paramCTCol2)) != -1);
/*     */   }
/*     */   
/*     */   private long[] getOverlappingRange(CTCol paramCTCol1, CTCol paramCTCol2) {
/* 149 */     return NumericRanges.getOverlappingRange(toRange(paramCTCol1), toRange(paramCTCol2));
/*     */   }
/*     */   
/*     */   private long[] toRange(CTCol paramCTCol) {
/* 153 */     return new long[] { paramCTCol.getMin(), paramCTCol.getMax() };
/*     */   }
/*     */   
/*     */   public static void sortColumns(CTCols paramCTCols) {
/* 157 */     CTCol[] arrayOfCTCol = paramCTCols.getColArray();
/* 158 */     Arrays.sort(arrayOfCTCol, CTColComparator.BY_MIN_MAX);
/* 159 */     paramCTCols.setColArray(arrayOfCTCol);
/*     */   }
/*     */   
/*     */   public CTCol cloneCol(CTCols paramCTCols, CTCol paramCTCol) {
/* 163 */     CTCol cTCol = paramCTCols.addNewCol();
/* 164 */     cTCol.setMin(paramCTCol.getMin());
/* 165 */     cTCol.setMax(paramCTCol.getMax());
/* 166 */     setColumnAttributes(paramCTCol, cTCol);
/* 167 */     return cTCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTCol getColumn(long paramLong, boolean paramBoolean) {
/* 174 */     return getColumn1Based(paramLong + 1L, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTCol getColumn1Based(long paramLong, boolean paramBoolean) {
/* 183 */     CTCols cTCols = this.worksheet.getColsArray(0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/*     */     
/* 190 */     for (CTCol cTCol : arrayOfCTCol) {
/* 191 */       long l1 = cTCol.getMin();
/* 192 */       long l2 = cTCol.getMax();
/* 193 */       if (l1 <= paramLong && l2 >= paramLong) {
/* 194 */         if (paramBoolean) {
/* 195 */           if (l1 < paramLong) {
/* 196 */             insertCol(cTCols, l1, paramLong - 1L, new CTCol[] { cTCol });
/*     */           }
/* 198 */           if (l2 > paramLong) {
/* 199 */             insertCol(cTCols, paramLong + 1L, l2, new CTCol[] { cTCol });
/*     */           }
/* 201 */           cTCol.setMin(paramLong);
/* 202 */           cTCol.setMax(paramLong);
/*     */         } 
/* 204 */         return cTCol;
/*     */       } 
/*     */     } 
/* 207 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTCol insertCol(CTCols paramCTCols, long paramLong1, long paramLong2, CTCol[] paramArrayOfCTCol) {
/* 215 */     return insertCol(paramCTCols, paramLong1, paramLong2, paramArrayOfCTCol, false, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private CTCol insertCol(CTCols paramCTCols, long paramLong1, long paramLong2, CTCol[] paramArrayOfCTCol, boolean paramBoolean, CTCol paramCTCol) {
/* 220 */     if (paramBoolean || !columnExists(paramCTCols, paramLong1, paramLong2)) {
/* 221 */       CTCol cTCol = paramCTCols.insertNewCol(0);
/* 222 */       cTCol.setMin(paramLong1);
/* 223 */       cTCol.setMax(paramLong2);
/* 224 */       for (CTCol cTCol1 : paramArrayOfCTCol) {
/* 225 */         setColumnAttributes(cTCol1, cTCol);
/*     */       }
/* 227 */       if (paramCTCol != null) setColumnAttributes(paramCTCol, cTCol); 
/* 228 */       return cTCol;
/*     */     } 
/* 230 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean columnExists(CTCols paramCTCols, long paramLong) {
/* 238 */     return columnExists1Based(paramCTCols, paramLong + 1L);
/*     */   }
/*     */   
/*     */   private boolean columnExists1Based(CTCols paramCTCols, long paramLong) {
/* 242 */     for (CTCol cTCol : paramCTCols.getColArray()) {
/* 243 */       if (cTCol.getMin() == paramLong) {
/* 244 */         return true;
/*     */       }
/*     */     } 
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public void setColumnAttributes(CTCol paramCTCol1, CTCol paramCTCol2) {
/* 251 */     if (paramCTCol1.isSetBestFit()) paramCTCol2.setBestFit(paramCTCol1.getBestFit()); 
/* 252 */     if (paramCTCol1.isSetCustomWidth()) paramCTCol2.setCustomWidth(paramCTCol1.getCustomWidth()); 
/* 253 */     if (paramCTCol1.isSetHidden()) paramCTCol2.setHidden(paramCTCol1.getHidden()); 
/* 254 */     if (paramCTCol1.isSetStyle()) paramCTCol2.setStyle(paramCTCol1.getStyle()); 
/* 255 */     if (paramCTCol1.isSetWidth()) paramCTCol2.setWidth(paramCTCol1.getWidth()); 
/* 256 */     if (paramCTCol1.isSetCollapsed()) paramCTCol2.setCollapsed(paramCTCol1.getCollapsed()); 
/* 257 */     if (paramCTCol1.isSetPhonetic()) paramCTCol2.setPhonetic(paramCTCol1.getPhonetic()); 
/* 258 */     if (paramCTCol1.isSetOutlineLevel()) paramCTCol2.setOutlineLevel(paramCTCol1.getOutlineLevel()); 
/* 259 */     paramCTCol2.setCollapsed(paramCTCol1.isSetCollapsed());
/*     */   }
/*     */   
/*     */   public void setColBestFit(long paramLong, boolean paramBoolean) {
/* 263 */     CTCol cTCol = getOrCreateColumn1Based(paramLong + 1L, false);
/* 264 */     cTCol.setBestFit(paramBoolean);
/*     */   }
/*     */   public void setCustomWidth(long paramLong, boolean paramBoolean) {
/* 267 */     CTCol cTCol = getOrCreateColumn1Based(paramLong + 1L, true);
/* 268 */     cTCol.setCustomWidth(paramBoolean);
/*     */   }
/*     */   
/*     */   public void setColWidth(long paramLong, double paramDouble) {
/* 272 */     CTCol cTCol = getOrCreateColumn1Based(paramLong + 1L, true);
/* 273 */     cTCol.setWidth(paramDouble);
/*     */   }
/*     */   
/*     */   public void setColHidden(long paramLong, boolean paramBoolean) {
/* 277 */     CTCol cTCol = getOrCreateColumn1Based(paramLong + 1L, true);
/* 278 */     cTCol.setHidden(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTCol getOrCreateColumn1Based(long paramLong, boolean paramBoolean) {
/* 286 */     CTCol cTCol = getColumn1Based(paramLong, paramBoolean);
/* 287 */     if (cTCol == null) {
/* 288 */       cTCol = this.worksheet.getColsArray(0).addNewCol();
/* 289 */       cTCol.setMin(paramLong);
/* 290 */       cTCol.setMax(paramLong);
/*     */     } 
/* 292 */     return cTCol;
/*     */   }
/*     */   
/*     */   public void setColDefaultStyle(long paramLong, CellStyle paramCellStyle) {
/* 296 */     setColDefaultStyle(paramLong, paramCellStyle.getIndex());
/*     */   }
/*     */   
/*     */   public void setColDefaultStyle(long paramLong, int paramInt) {
/* 300 */     CTCol cTCol = getOrCreateColumn1Based(paramLong + 1L, true);
/* 301 */     cTCol.setStyle(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColDefaultStyle(long paramLong) {
/* 306 */     if (getColumn(paramLong, false) != null) {
/* 307 */       return (int)getColumn(paramLong, false).getStyle();
/*     */     }
/* 309 */     return -1;
/*     */   }
/*     */   
/*     */   private boolean columnExists(CTCols paramCTCols, long paramLong1, long paramLong2) {
/* 313 */     for (CTCol cTCol : paramCTCols.getColArray()) {
/* 314 */       if (cTCol.getMin() == paramLong1 && cTCol.getMax() == paramLong2) {
/* 315 */         return true;
/*     */       }
/*     */     } 
/* 318 */     return false;
/*     */   }
/*     */   
/*     */   public int getIndexOfColumn(CTCols paramCTCols, CTCol paramCTCol) {
/* 322 */     byte b = 0;
/* 323 */     for (CTCol cTCol : paramCTCols.getColArray()) {
/* 324 */       if (cTCol.getMin() == paramCTCol.getMin() && cTCol.getMax() == paramCTCol.getMax()) {
/* 325 */         return b;
/*     */       }
/* 327 */       b++;
/*     */     } 
/* 329 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\ColumnHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */