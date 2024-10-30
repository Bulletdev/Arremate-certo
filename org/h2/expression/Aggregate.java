/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import org.h2.command.dml.Select;
/*     */ import org.h2.command.dml.SelectOrderBy;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
/*     */ import org.h2.value.ValueLong;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueString;
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
/*     */ public class Aggregate
/*     */   extends Expression
/*     */ {
/*     */   public static final int COUNT_ALL = 0;
/*     */   public static final int COUNT = 1;
/*     */   public static final int GROUP_CONCAT = 2;
/*     */   static final int SUM = 3;
/*     */   static final int MIN = 4;
/*     */   static final int MAX = 5;
/*     */   static final int AVG = 6;
/*     */   static final int STDDEV_POP = 7;
/*     */   static final int STDDEV_SAMP = 8;
/*     */   static final int VAR_POP = 9;
/*     */   static final int VAR_SAMP = 10;
/*     */   static final int BOOL_OR = 11;
/*     */   static final int BOOL_AND = 12;
/*     */   static final int BIT_OR = 13;
/*     */   static final int BIT_AND = 14;
/*     */   static final int SELECTIVITY = 15;
/*     */   static final int HISTOGRAM = 16;
/* 129 */   private static final HashMap<String, Integer> AGGREGATES = New.hashMap();
/*     */   
/*     */   private final int type;
/*     */   
/*     */   private final Select select;
/*     */   
/*     */   private final boolean distinct;
/*     */   
/*     */   private Expression on;
/*     */   
/*     */   private Expression groupConcatSeparator;
/*     */   
/*     */   private ArrayList<SelectOrderBy> groupConcatOrderList;
/*     */   
/*     */   private SortOrder groupConcatSort;
/*     */   
/*     */   private int dataType;
/*     */   
/*     */   private int scale;
/*     */   private long precision;
/*     */   private int displaySize;
/*     */   private int lastGroupRowId;
/*     */   
/*     */   public Aggregate(int paramInt, Expression paramExpression, Select paramSelect, boolean paramBoolean) {
/* 153 */     this.type = paramInt;
/* 154 */     this.on = paramExpression;
/* 155 */     this.select = paramSelect;
/* 156 */     this.distinct = paramBoolean;
/*     */   }
/*     */   
/*     */   static {
/* 160 */     addAggregate("COUNT", 1);
/* 161 */     addAggregate("SUM", 3);
/* 162 */     addAggregate("MIN", 4);
/* 163 */     addAggregate("MAX", 5);
/* 164 */     addAggregate("AVG", 6);
/* 165 */     addAggregate("GROUP_CONCAT", 2);
/*     */     
/* 167 */     addAggregate("STRING_AGG", 2);
/* 168 */     addAggregate("STDDEV_SAMP", 8);
/* 169 */     addAggregate("STDDEV", 8);
/* 170 */     addAggregate("STDDEV_POP", 7);
/* 171 */     addAggregate("STDDEVP", 7);
/* 172 */     addAggregate("VAR_POP", 9);
/* 173 */     addAggregate("VARP", 9);
/* 174 */     addAggregate("VAR_SAMP", 10);
/* 175 */     addAggregate("VAR", 10);
/* 176 */     addAggregate("VARIANCE", 10);
/* 177 */     addAggregate("BOOL_OR", 11);
/*     */     
/* 179 */     addAggregate("SOME", 11);
/* 180 */     addAggregate("BOOL_AND", 12);
/*     */     
/* 182 */     addAggregate("EVERY", 12);
/* 183 */     addAggregate("SELECTIVITY", 15);
/* 184 */     addAggregate("HISTOGRAM", 16);
/* 185 */     addAggregate("BIT_OR", 13);
/* 186 */     addAggregate("BIT_AND", 14);
/*     */   }
/*     */   
/*     */   private static void addAggregate(String paramString, int paramInt) {
/* 190 */     AGGREGATES.put(paramString, Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getAggregateType(String paramString) {
/* 201 */     Integer integer = AGGREGATES.get(paramString);
/* 202 */     return (integer == null) ? -1 : integer.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupConcatOrder(ArrayList<SelectOrderBy> paramArrayList) {
/* 211 */     this.groupConcatOrderList = paramArrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupConcatSeparator(Expression paramExpression) {
/* 220 */     this.groupConcatSeparator = paramExpression;
/*     */   }
/*     */   
/*     */   private SortOrder initOrder(Session paramSession) {
/* 224 */     int i = this.groupConcatOrderList.size();
/* 225 */     int[] arrayOfInt1 = new int[i];
/* 226 */     int[] arrayOfInt2 = new int[i];
/* 227 */     for (byte b = 0; b < i; b++) {
/* 228 */       SelectOrderBy selectOrderBy = this.groupConcatOrderList.get(b);
/* 229 */       arrayOfInt1[b] = b + 1;
/* 230 */       boolean bool = selectOrderBy.descending ? true : false;
/* 231 */       arrayOfInt2[b] = bool;
/*     */     } 
/* 233 */     return new SortOrder(paramSession.getDatabase(), arrayOfInt1, arrayOfInt2, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/*     */     ValueArray valueArray;
/* 242 */     HashMap<Aggregate, AggregateData> hashMap = this.select.getCurrentGroup();
/* 243 */     if (hashMap == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 248 */     int i = this.select.getCurrentGroupRowId();
/* 249 */     if (this.lastGroupRowId == i) {
/*     */       return;
/*     */     }
/*     */     
/* 253 */     this.lastGroupRowId = i;
/*     */     
/* 255 */     AggregateData aggregateData = (AggregateData)hashMap.get(this);
/* 256 */     if (aggregateData == null) {
/* 257 */       aggregateData = AggregateData.create(this.type);
/* 258 */       hashMap.put(this, aggregateData);
/*     */     } 
/* 260 */     Value value = (this.on == null) ? null : this.on.getValue(paramSession);
/* 261 */     if (this.type == 2 && 
/* 262 */       value != ValueNull.INSTANCE) {
/* 263 */       value = value.convertTo(13);
/* 264 */       if (this.groupConcatOrderList != null) {
/* 265 */         int j = this.groupConcatOrderList.size();
/* 266 */         Value[] arrayOfValue = new Value[1 + j];
/* 267 */         arrayOfValue[0] = value;
/* 268 */         for (byte b = 0; b < j; b++) {
/* 269 */           SelectOrderBy selectOrderBy = this.groupConcatOrderList.get(b);
/* 270 */           arrayOfValue[b + 1] = selectOrderBy.expression.getValue(paramSession);
/*     */         } 
/* 272 */         valueArray = ValueArray.get(arrayOfValue);
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     aggregateData.add(paramSession.getDatabase(), this.dataType, this.distinct, (Value)valueArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/* 281 */     if (this.select.isQuickAggregateQuery()) {
/* 282 */       Table table; boolean bool; Index index; int i; Cursor cursor; SearchRow searchRow; Value value1; switch (this.type) {
/*     */         case 0:
/*     */         case 1:
/* 285 */           table = this.select.getTopTableFilter().getTable();
/* 286 */           return (Value)ValueLong.get(table.getRowCount(paramSession));
/*     */         case 4:
/*     */         case 5:
/* 289 */           bool = (this.type == 4) ? true : false;
/* 290 */           index = getColumnIndex();
/* 291 */           i = (index.getIndexColumns()[0]).sortType;
/* 292 */           if ((i & 0x1) != 0) {
/* 293 */             bool = !bool ? true : false;
/*     */           }
/* 295 */           cursor = index.findFirstOrLast(paramSession, bool);
/* 296 */           searchRow = cursor.getSearchRow();
/*     */           
/* 298 */           if (searchRow == null) {
/* 299 */             ValueNull valueNull = ValueNull.INSTANCE;
/*     */           } else {
/* 301 */             value1 = searchRow.getValue(index.getColumns()[0].getColumnId());
/*     */           } 
/* 303 */           return value1;
/*     */       } 
/* 305 */       DbException.throwInternalError("type=" + this.type);
/*     */     } 
/*     */     
/* 308 */     HashMap hashMap = this.select.getCurrentGroup();
/* 309 */     if (hashMap == null) {
/* 310 */       throw DbException.get(90054, getSQL());
/*     */     }
/* 312 */     AggregateData aggregateData = (AggregateData)hashMap.get(this);
/* 313 */     if (aggregateData == null) {
/* 314 */       aggregateData = AggregateData.create(this.type);
/*     */     }
/* 316 */     Value value = aggregateData.getValue(paramSession.getDatabase(), this.dataType, this.distinct);
/* 317 */     if (this.type == 2) {
/* 318 */       ArrayList<Value> arrayList = ((AggregateDataGroupConcat)aggregateData).getList();
/* 319 */       if (arrayList == null || arrayList.size() == 0) {
/* 320 */         return (Value)ValueNull.INSTANCE;
/*     */       }
/* 322 */       if (this.groupConcatOrderList != null) {
/* 323 */         final SortOrder sortOrder = this.groupConcatSort;
/* 324 */         Collections.sort(arrayList, new Comparator<Value>()
/*     */             {
/*     */               public int compare(Value param1Value1, Value param1Value2) {
/* 327 */                 Value[] arrayOfValue1 = ((ValueArray)param1Value1).getList();
/* 328 */                 Value[] arrayOfValue2 = ((ValueArray)param1Value2).getList();
/* 329 */                 return sortOrder.compare(arrayOfValue1, arrayOfValue2);
/*     */               }
/*     */             });
/*     */       } 
/* 333 */       StatementBuilder statementBuilder = new StatementBuilder();
/* 334 */       String str = (this.groupConcatSeparator == null) ? "," : this.groupConcatSeparator.getValue(paramSession).getString();
/*     */       
/* 336 */       for (Value value1 : arrayList) {
/*     */         String str1;
/* 338 */         if (value1.getType() == 17) {
/* 339 */           str1 = ((ValueArray)value1).getList()[0].getString();
/*     */         } else {
/* 341 */           str1 = value1.getString();
/*     */         } 
/* 343 */         if (str1 == null) {
/*     */           continue;
/*     */         }
/* 346 */         if (str != null) {
/* 347 */           statementBuilder.appendExceptFirst(str);
/*     */         }
/* 349 */         statementBuilder.append(str1);
/*     */       } 
/* 351 */       value = ValueString.get(statementBuilder.toString());
/*     */     } 
/* 353 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 358 */     return this.dataType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 363 */     if (this.on != null) {
/* 364 */       this.on.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/* 366 */     if (this.groupConcatOrderList != null) {
/* 367 */       for (SelectOrderBy selectOrderBy : this.groupConcatOrderList) {
/* 368 */         selectOrderBy.expression.mapColumns(paramColumnResolver, paramInt);
/*     */       }
/*     */     }
/* 371 */     if (this.groupConcatSeparator != null) {
/* 372 */       this.groupConcatSeparator.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/* 378 */     if (this.on != null) {
/* 379 */       this.on = this.on.optimize(paramSession);
/* 380 */       this.dataType = this.on.getType();
/* 381 */       this.scale = this.on.getScale();
/* 382 */       this.precision = this.on.getPrecision();
/* 383 */       this.displaySize = this.on.getDisplaySize();
/*     */     } 
/* 385 */     if (this.groupConcatOrderList != null) {
/* 386 */       for (SelectOrderBy selectOrderBy : this.groupConcatOrderList) {
/* 387 */         selectOrderBy.expression = selectOrderBy.expression.optimize(paramSession);
/*     */       }
/* 389 */       this.groupConcatSort = initOrder(paramSession);
/*     */     } 
/* 391 */     if (this.groupConcatSeparator != null) {
/* 392 */       this.groupConcatSeparator = this.groupConcatSeparator.optimize(paramSession);
/*     */     }
/* 394 */     switch (this.type)
/*     */     { case 2:
/* 396 */         this.dataType = 13;
/* 397 */         this.scale = 0;
/* 398 */         this.precision = (this.displaySize = Integer.MAX_VALUE);
/*     */       
/*     */       case 0:
/*     */       case 1:
/* 402 */         this.dataType = 5;
/* 403 */         this.scale = 0;
/* 404 */         this.precision = 19L;
/* 405 */         this.displaySize = 20;
/*     */       
/*     */       case 15:
/* 408 */         this.dataType = 4;
/* 409 */         this.scale = 0;
/* 410 */         this.precision = 10L;
/* 411 */         this.displaySize = 11;
/*     */       
/*     */       case 16:
/* 414 */         this.dataType = 17;
/* 415 */         this.scale = 0;
/* 416 */         this.precision = (this.displaySize = Integer.MAX_VALUE);
/*     */       
/*     */       case 3:
/* 419 */         if (this.dataType == 1)
/*     */         
/* 421 */         { this.dataType = 5; }
/* 422 */         else { if (!DataType.supportsAdd(this.dataType)) {
/* 423 */             throw DbException.get(90015, getSQL());
/*     */           }
/* 425 */           this.dataType = DataType.getAddProofType(this.dataType); }
/*     */       
/*     */       
/*     */       case 6:
/* 429 */         if (!DataType.supportsAdd(this.dataType)) {
/* 430 */           throw DbException.get(90015, getSQL());
/*     */         }
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
/*     */       case 4:
/*     */       case 5:
/* 461 */         return this;
/*     */       case 7: case 8: case 9: case 10: this.dataType = 7; this.precision = 17L; this.displaySize = 24; this.scale = 0;
/*     */       case 11: case 12: this.dataType = 1; this.precision = 1L; this.displaySize = 5; this.scale = 0;
/*     */       case 13: case 14:
/*     */         if (!DataType.supportsAdd(this.dataType))
/* 466 */           throw DbException.get(90015, getSQL());  }  DbException.throwInternalError("type=" + this.type); } public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) { if (this.on != null) {
/* 467 */       this.on.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/* 469 */     if (this.groupConcatOrderList != null) {
/* 470 */       for (SelectOrderBy selectOrderBy : this.groupConcatOrderList) {
/* 471 */         selectOrderBy.expression.setEvaluatable(paramTableFilter, paramBoolean);
/*     */       }
/*     */     }
/* 474 */     if (this.groupConcatSeparator != null) {
/* 475 */       this.groupConcatSeparator.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 481 */     return this.scale;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 486 */     return this.precision;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 491 */     return this.displaySize;
/*     */   }
/*     */   
/*     */   private String getSQLGroupConcat() {
/* 495 */     StatementBuilder statementBuilder = new StatementBuilder("GROUP_CONCAT(");
/* 496 */     if (this.distinct) {
/* 497 */       statementBuilder.append("DISTINCT ");
/*     */     }
/* 499 */     statementBuilder.append(this.on.getSQL());
/* 500 */     if (this.groupConcatOrderList != null) {
/* 501 */       statementBuilder.append(" ORDER BY ");
/* 502 */       for (SelectOrderBy selectOrderBy : this.groupConcatOrderList) {
/* 503 */         statementBuilder.appendExceptFirst(", ");
/* 504 */         statementBuilder.append(selectOrderBy.expression.getSQL());
/* 505 */         if (selectOrderBy.descending) {
/* 506 */           statementBuilder.append(" DESC");
/*     */         }
/*     */       } 
/*     */     } 
/* 510 */     if (this.groupConcatSeparator != null) {
/* 511 */       statementBuilder.append(" SEPARATOR ").append(this.groupConcatSeparator.getSQL());
/*     */     }
/* 513 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*     */     String str;
/* 519 */     switch (this.type) {
/*     */       case 2:
/* 521 */         return getSQLGroupConcat();
/*     */       case 0:
/* 523 */         return "COUNT(*)";
/*     */       case 1:
/* 525 */         str = "COUNT";
/*     */         break;
/*     */       case 15:
/* 528 */         str = "SELECTIVITY";
/*     */         break;
/*     */       case 16:
/* 531 */         str = "HISTOGRAM";
/*     */         break;
/*     */       case 3:
/* 534 */         str = "SUM";
/*     */         break;
/*     */       case 4:
/* 537 */         str = "MIN";
/*     */         break;
/*     */       case 5:
/* 540 */         str = "MAX";
/*     */         break;
/*     */       case 6:
/* 543 */         str = "AVG";
/*     */         break;
/*     */       case 7:
/* 546 */         str = "STDDEV_POP";
/*     */         break;
/*     */       case 8:
/* 549 */         str = "STDDEV_SAMP";
/*     */         break;
/*     */       case 9:
/* 552 */         str = "VAR_POP";
/*     */         break;
/*     */       case 10:
/* 555 */         str = "VAR_SAMP";
/*     */         break;
/*     */       case 12:
/* 558 */         str = "BOOL_AND";
/*     */         break;
/*     */       case 11:
/* 561 */         str = "BOOL_OR";
/*     */         break;
/*     */       case 14:
/* 564 */         str = "BIT_AND";
/*     */         break;
/*     */       case 13:
/* 567 */         str = "BIT_OR";
/*     */         break;
/*     */       default:
/* 570 */         throw DbException.throwInternalError("type=" + this.type);
/*     */     } 
/* 572 */     if (this.distinct) {
/* 573 */       return str + "(DISTINCT " + this.on.getSQL() + ")";
/*     */     }
/* 575 */     return str + StringUtils.enclose(this.on.getSQL());
/*     */   }
/*     */   
/*     */   private Index getColumnIndex() {
/* 579 */     if (this.on instanceof ExpressionColumn) {
/* 580 */       ExpressionColumn expressionColumn = (ExpressionColumn)this.on;
/* 581 */       Column column = expressionColumn.getColumn();
/* 582 */       TableFilter tableFilter = expressionColumn.getTableFilter();
/* 583 */       if (tableFilter != null) {
/* 584 */         Table table = tableFilter.getTable();
/* 585 */         return table.getIndexForColumn(column);
/*     */       } 
/*     */     } 
/*     */     
/* 589 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 594 */     if (paramExpressionVisitor.getType() == 1) {
/* 595 */       Index index; switch (this.type) {
/*     */         case 1:
/* 597 */           if (!this.distinct && this.on.getNullable() == 0) {
/* 598 */             return paramExpressionVisitor.getTable().canGetRowCount();
/*     */           }
/* 600 */           return false;
/*     */         case 0:
/* 602 */           return paramExpressionVisitor.getTable().canGetRowCount();
/*     */         case 4:
/*     */         case 5:
/* 605 */           index = getColumnIndex();
/* 606 */           return (index != null);
/*     */       } 
/* 608 */       return false;
/*     */     } 
/*     */     
/* 611 */     if (this.on != null && !this.on.isEverything(paramExpressionVisitor)) {
/* 612 */       return false;
/*     */     }
/* 614 */     if (this.groupConcatSeparator != null && !this.groupConcatSeparator.isEverything(paramExpressionVisitor))
/*     */     {
/* 616 */       return false;
/*     */     }
/* 618 */     if (this.groupConcatOrderList != null) {
/* 619 */       byte b; int i; for (b = 0, i = this.groupConcatOrderList.size(); b < i; b++) {
/* 620 */         SelectOrderBy selectOrderBy = this.groupConcatOrderList.get(b);
/* 621 */         if (!selectOrderBy.expression.isEverything(paramExpressionVisitor)) {
/* 622 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 626 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 631 */     return (this.on == null) ? 1 : (this.on.getCost() + 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Aggregate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */