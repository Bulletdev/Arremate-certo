/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueGeometry;
/*     */ import org.h2.value.ValueNull;
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
/*     */ public class IndexCursor
/*     */   implements Cursor
/*     */ {
/*     */   private Session session;
/*     */   private final TableFilter tableFilter;
/*     */   private Index index;
/*     */   private Table table;
/*     */   private IndexColumn[] indexColumns;
/*     */   private boolean alwaysFalse;
/*     */   private SearchRow start;
/*     */   private SearchRow end;
/*     */   private SearchRow intersects;
/*     */   private Cursor cursor;
/*     */   private Column inColumn;
/*     */   private int inListIndex;
/*     */   private Value[] inList;
/*     */   private ResultInterface inResult;
/*     */   private HashSet<Value> inResultTested;
/*     */   
/*     */   public IndexCursor(TableFilter paramTableFilter) {
/*  51 */     this.tableFilter = paramTableFilter;
/*     */   }
/*     */   
/*     */   public void setIndex(Index paramIndex) {
/*  55 */     this.index = paramIndex;
/*  56 */     this.table = paramIndex.getTable();
/*  57 */     Column[] arrayOfColumn = this.table.getColumns();
/*  58 */     this.indexColumns = new IndexColumn[arrayOfColumn.length];
/*  59 */     IndexColumn[] arrayOfIndexColumn = paramIndex.getIndexColumns();
/*  60 */     if (arrayOfIndexColumn != null) {
/*  61 */       byte b; int i; for (b = 0, i = arrayOfColumn.length; b < i; b++) {
/*  62 */         int j = paramIndex.getColumnIndex(arrayOfColumn[b]);
/*  63 */         if (j >= 0) {
/*  64 */           this.indexColumns[b] = arrayOfIndexColumn[j];
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
/*     */   public void prepare(Session paramSession, ArrayList<IndexCondition> paramArrayList) {
/*  77 */     this.session = paramSession;
/*  78 */     this.alwaysFalse = false;
/*  79 */     this.start = this.end = null;
/*  80 */     this.inList = null;
/*  81 */     this.inColumn = null;
/*  82 */     this.inResult = null;
/*  83 */     this.inResultTested = null;
/*  84 */     this.intersects = null; byte b;
/*     */     int i;
/*  86 */     for (b = 0, i = paramArrayList.size(); b < i; b++) {
/*  87 */       IndexCondition indexCondition = paramArrayList.get(b);
/*  88 */       if (indexCondition.isAlwaysFalse()) {
/*  89 */         this.alwaysFalse = true;
/*     */         break;
/*     */       } 
/*  92 */       Column column = indexCondition.getColumn();
/*  93 */       if (indexCondition.getCompareType() == 9) {
/*  94 */         if (this.start == null && this.end == null && 
/*  95 */           canUseIndexForIn(column)) {
/*  96 */           this.inColumn = column;
/*  97 */           this.inList = indexCondition.getCurrentValueList(paramSession);
/*  98 */           this.inListIndex = 0;
/*     */         }
/*     */       
/* 101 */       } else if (indexCondition.getCompareType() == 10) {
/* 102 */         if (this.start == null && this.end == null && 
/* 103 */           canUseIndexForIn(column)) {
/* 104 */           this.inColumn = column;
/* 105 */           this.inResult = indexCondition.getCurrentResult();
/*     */         } 
/*     */       } else {
/*     */         
/* 109 */         Value value = indexCondition.getCurrentValue(paramSession);
/* 110 */         boolean bool1 = indexCondition.isStart();
/* 111 */         boolean bool2 = indexCondition.isEnd();
/* 112 */         boolean bool3 = indexCondition.isSpatialIntersects();
/* 113 */         int j = column.getColumnId();
/* 114 */         if (j >= 0) {
/* 115 */           IndexColumn indexColumn = this.indexColumns[j];
/* 116 */           if (indexColumn != null && (indexColumn.sortType & 0x1) != 0) {
/*     */ 
/*     */ 
/*     */             
/* 120 */             boolean bool = bool1;
/* 121 */             bool1 = bool2;
/* 122 */             bool2 = bool;
/*     */           } 
/*     */         } 
/* 125 */         if (bool1) {
/* 126 */           this.start = getSearchRow(this.start, j, value, true);
/*     */         }
/* 128 */         if (bool2) {
/* 129 */           this.end = getSearchRow(this.end, j, value, false);
/*     */         }
/* 131 */         if (bool3) {
/* 132 */           this.intersects = getSpatialSearchRow(this.intersects, j, value);
/*     */         }
/* 134 */         if (bool1 || bool2) {
/*     */ 
/*     */           
/* 137 */           this.inColumn = null;
/* 138 */           this.inList = null;
/* 139 */           this.inResult = null;
/*     */         } 
/* 141 */         if (!(this.session.getDatabase().getSettings()).optimizeIsNull && 
/* 142 */           bool1 && bool2 && 
/* 143 */           value == ValueNull.INSTANCE)
/*     */         {
/* 145 */           this.alwaysFalse = true;
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
/*     */   public void find(Session paramSession, ArrayList<IndexCondition> paramArrayList) {
/* 160 */     prepare(paramSession, paramArrayList);
/* 161 */     if (this.inColumn != null) {
/*     */       return;
/*     */     }
/* 164 */     if (!this.alwaysFalse) {
/* 165 */       if (this.intersects != null && this.index instanceof SpatialIndex) {
/* 166 */         this.cursor = ((SpatialIndex)this.index).findByGeometry(this.tableFilter, this.start, this.end, this.intersects);
/*     */       } else {
/*     */         
/* 169 */         this.cursor = this.index.find(this.tableFilter, this.start, this.end);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canUseIndexForIn(Column paramColumn) {
/* 175 */     if (this.inColumn != null)
/*     */     {
/* 177 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     IndexColumn[] arrayOfIndexColumn = this.index.getIndexColumns();
/* 184 */     if (arrayOfIndexColumn == null) {
/* 185 */       return true;
/*     */     }
/* 187 */     IndexColumn indexColumn = arrayOfIndexColumn[0];
/* 188 */     return (indexColumn == null || indexColumn.column == paramColumn);
/*     */   }
/*     */   private SearchRow getSpatialSearchRow(SearchRow paramSearchRow, int paramInt, Value paramValue) {
/*     */     Row row;
/* 192 */     if (paramSearchRow == null) {
/* 193 */       row = this.table.getTemplateRow();
/* 194 */     } else if (row.getValue(paramInt) != null) {
/*     */ 
/*     */ 
/*     */       
/* 198 */       ValueGeometry valueGeometry = (ValueGeometry)row.getValue(paramInt).convertTo(22);
/*     */       
/* 200 */       paramValue = ((ValueGeometry)paramValue.convertTo(22)).getEnvelopeUnion(valueGeometry);
/*     */     } 
/*     */     
/* 203 */     if (paramInt < 0) {
/* 204 */       row.setKey(paramValue.getLong());
/*     */     } else {
/* 206 */       row.setValue(paramInt, paramValue);
/*     */     } 
/* 208 */     return (SearchRow)row;
/*     */   }
/*     */   
/*     */   private SearchRow getSearchRow(SearchRow paramSearchRow, int paramInt, Value paramValue, boolean paramBoolean) {
/*     */     Row row;
/* 213 */     if (paramSearchRow == null) {
/* 214 */       row = this.table.getTemplateRow();
/*     */     } else {
/* 216 */       paramValue = getMax(row.getValue(paramInt), paramValue, paramBoolean);
/*     */     } 
/* 218 */     if (paramInt < 0) {
/* 219 */       row.setKey(paramValue.getLong());
/*     */     } else {
/* 221 */       row.setValue(paramInt, paramValue);
/*     */     } 
/* 223 */     return (SearchRow)row;
/*     */   }
/*     */   
/*     */   private Value getMax(Value paramValue1, Value paramValue2, boolean paramBoolean) {
/* 227 */     if (paramValue1 == null)
/* 228 */       return paramValue2; 
/* 229 */     if (paramValue2 == null) {
/* 230 */       return paramValue1;
/*     */     }
/* 232 */     if ((this.session.getDatabase().getSettings()).optimizeIsNull) {
/*     */       
/* 234 */       if (paramValue1 == ValueNull.INSTANCE)
/* 235 */         return paramValue2; 
/* 236 */       if (paramValue2 == ValueNull.INSTANCE) {
/* 237 */         return paramValue1;
/*     */       }
/*     */     } 
/* 240 */     int i = paramValue1.compareTo(paramValue2, this.table.getDatabase().getCompareMode());
/* 241 */     if (i == 0) {
/* 242 */       return paramValue1;
/*     */     }
/* 244 */     if ((paramValue1 == ValueNull.INSTANCE || paramValue2 == ValueNull.INSTANCE) && 
/* 245 */       (this.session.getDatabase().getSettings()).optimizeIsNull)
/*     */     {
/* 247 */       return null;
/*     */     }
/*     */     
/* 250 */     if (!paramBoolean) {
/* 251 */       i = -i;
/*     */     }
/* 253 */     return (i > 0) ? paramValue1 : paramValue2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlwaysFalse() {
/* 262 */     return this.alwaysFalse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SearchRow getStart() {
/* 271 */     return this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SearchRow getEnd() {
/* 280 */     return this.end;
/*     */   }
/*     */ 
/*     */   
/*     */   public Row get() {
/* 285 */     if (this.cursor == null) {
/* 286 */       return null;
/*     */     }
/* 288 */     return this.cursor.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchRow getSearchRow() {
/* 293 */     return this.cursor.getSearchRow();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean next() {
/*     */     while (true) {
/* 299 */       if (this.cursor == null) {
/* 300 */         nextCursor();
/* 301 */         if (this.cursor == null) {
/* 302 */           return false;
/*     */         }
/*     */       } 
/* 305 */       if (this.cursor.next()) {
/* 306 */         return true;
/*     */       }
/* 308 */       this.cursor = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void nextCursor() {
/* 313 */     if (this.inList != null) {
/* 314 */       while (this.inListIndex < this.inList.length) {
/* 315 */         Value value = this.inList[this.inListIndex++];
/* 316 */         if (value != ValueNull.INSTANCE) {
/* 317 */           find(value);
/*     */           break;
/*     */         } 
/*     */       } 
/* 321 */     } else if (this.inResult != null) {
/* 322 */       while (this.inResult.next()) {
/* 323 */         Value value = this.inResult.currentRow()[0];
/* 324 */         if (value != ValueNull.INSTANCE) {
/* 325 */           value = this.inColumn.convert(value);
/* 326 */           if (this.inResultTested == null) {
/* 327 */             this.inResultTested = new HashSet<>();
/*     */           }
/* 329 */           if (this.inResultTested.add(value)) {
/* 330 */             find(value);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void find(Value paramValue) {
/* 339 */     paramValue = this.inColumn.convert(paramValue);
/* 340 */     int i = this.inColumn.getColumnId();
/* 341 */     if (this.start == null) {
/* 342 */       this.start = (SearchRow)this.table.getTemplateRow();
/*     */     }
/* 344 */     this.start.setValue(i, paramValue);
/* 345 */     this.cursor = this.index.find(this.tableFilter, this.start, this.start);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean previous() {
/* 350 */     throw DbException.throwInternalError();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\IndexCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */