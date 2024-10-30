/*     */ package org.h2.table;
/*     */ 
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.Mode;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.ConditionAndOr;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.expression.SequenceValue;
/*     */ import org.h2.expression.ValueExpression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.util.DateTimeUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueDate;
/*     */ import org.h2.value.ValueInt;
/*     */ import org.h2.value.ValueLong;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueString;
/*     */ import org.h2.value.ValueTime;
/*     */ import org.h2.value.ValueTimestamp;
/*     */ import org.h2.value.ValueTimestampTimeZone;
/*     */ import org.h2.value.ValueUuid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Column
/*     */ {
/*     */   public static final String ROWID = "_ROWID_";
/*     */   public static final int NOT_NULLABLE = 0;
/*     */   public static final int NULLABLE = 1;
/*     */   public static final int NULLABLE_UNKNOWN = 2;
/*     */   private final int type;
/*     */   private long precision;
/*     */   private int scale;
/*     */   private int displaySize;
/*     */   private Table table;
/*     */   private String name;
/*     */   private int columnId;
/*     */   private boolean nullable = true;
/*     */   private Expression defaultExpression;
/*     */   private Expression checkConstraint;
/*     */   private String checkConstraintSQL;
/*     */   private String originalSQL;
/*     */   private boolean autoIncrement;
/*     */   private long start;
/*     */   private long increment;
/*     */   private boolean convertNullToDefault;
/*     */   private Sequence sequence;
/*     */   private boolean isComputed;
/*     */   private TableFilter computeTableFilter;
/*     */   private int selectivity;
/*     */   private SingleColumnResolver resolver;
/*     */   private String comment;
/*     */   private boolean primaryKey;
/*     */   
/*     */   public Column(String paramString, int paramInt) {
/*  91 */     this(paramString, paramInt, -1L, -1, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Column(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  96 */     this.name = paramString;
/*  97 */     this.type = paramInt1;
/*  98 */     if (paramLong == -1L && paramInt2 == -1 && paramInt3 == -1 && paramInt1 != -1) {
/*  99 */       DataType dataType = DataType.getDataType(paramInt1);
/* 100 */       paramLong = dataType.defaultPrecision;
/* 101 */       paramInt2 = dataType.defaultScale;
/* 102 */       paramInt3 = dataType.defaultDisplaySize;
/*     */     } 
/* 104 */     this.precision = paramLong;
/* 105 */     this.scale = paramInt2;
/* 106 */     this.displaySize = paramInt3;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 111 */     if (paramObject == this)
/* 112 */       return true; 
/* 113 */     if (!(paramObject instanceof Column)) {
/* 114 */       return false;
/*     */     }
/* 116 */     Column column = (Column)paramObject;
/* 117 */     if (this.table == null || column.table == null || this.name == null || column.name == null)
/*     */     {
/* 119 */       return false;
/*     */     }
/* 121 */     if (this.table != column.table) {
/* 122 */       return false;
/*     */     }
/* 124 */     return this.name.equals(column.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 129 */     if (this.table == null || this.name == null) {
/* 130 */       return 0;
/*     */     }
/* 132 */     return this.table.getId() ^ this.name.hashCode();
/*     */   }
/*     */   
/*     */   public Column getClone() {
/* 136 */     Column column = new Column(this.name, this.type, this.precision, this.scale, this.displaySize);
/* 137 */     column.copy(this);
/* 138 */     return column;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value convert(Value paramValue) {
/*     */     try {
/* 149 */       return paramValue.convertTo(this.type);
/* 150 */     } catch (DbException dbException) {
/* 151 */       if (dbException.getErrorCode() == 22018) {
/* 152 */         String str = ((this.table == null) ? "" : (this.table.getName() + ": ")) + getCreateSQL();
/*     */         
/* 154 */         throw DbException.get(22018, paramValue.getSQL() + " (" + str + ")");
/*     */       } 
/*     */ 
/*     */       
/* 158 */       throw dbException;
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean getComputed() {
/* 163 */     return this.isComputed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized Value computeValue(Session paramSession, Row paramRow) {
/* 174 */     this.computeTableFilter.setSession(paramSession);
/* 175 */     this.computeTableFilter.set(paramRow);
/* 176 */     return this.defaultExpression.getValue(paramSession);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComputedExpression(Expression paramExpression) {
/* 186 */     this.isComputed = true;
/* 187 */     this.defaultExpression = paramExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTable(Table paramTable, int paramInt) {
/* 197 */     this.table = paramTable;
/* 198 */     this.columnId = paramInt;
/*     */   }
/*     */   
/*     */   public Table getTable() {
/* 202 */     return this.table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultExpression(Session paramSession, Expression paramExpression) {
/*     */     ValueExpression valueExpression;
/* 214 */     if (paramExpression != null) {
/* 215 */       paramExpression = paramExpression.optimize(paramSession);
/* 216 */       if (paramExpression.isConstant()) {
/* 217 */         valueExpression = ValueExpression.get(paramExpression.getValue(paramSession));
/*     */       }
/*     */     } 
/*     */     
/* 221 */     this.defaultExpression = (Expression)valueExpression;
/*     */   }
/*     */   
/*     */   public int getColumnId() {
/* 225 */     return this.columnId;
/*     */   }
/*     */   
/*     */   public String getSQL() {
/* 229 */     return Parser.quoteIdentifier(this.name);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 233 */     return this.name;
/*     */   }
/*     */   
/*     */   public int getType() {
/* 237 */     return this.type;
/*     */   }
/*     */   
/*     */   public long getPrecision() {
/* 241 */     return this.precision;
/*     */   }
/*     */   
/*     */   public void setPrecision(long paramLong) {
/* 245 */     this.precision = paramLong;
/*     */   }
/*     */   
/*     */   public int getDisplaySize() {
/* 249 */     return this.displaySize;
/*     */   }
/*     */   
/*     */   public int getScale() {
/* 253 */     return this.scale;
/*     */   }
/*     */   
/*     */   public void setNullable(boolean paramBoolean) {
/* 257 */     this.nullable = paramBoolean;
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
/*     */   public Value validateConvertUpdateSequence(Session paramSession, Value paramValue) {
/*     */     Expression expression;
/* 273 */     synchronized (this) {
/* 274 */       expression = this.defaultExpression;
/*     */     } 
/* 276 */     if (paramValue == null) {
/* 277 */       if (expression == null) {
/* 278 */         ValueNull valueNull = ValueNull.INSTANCE;
/*     */       } else {
/* 280 */         paramValue = expression.getValue(paramSession).convertTo(this.type);
/* 281 */         if (this.primaryKey) {
/* 282 */           paramSession.setLastIdentity(paramValue);
/*     */         }
/*     */       } 
/*     */     }
/* 286 */     Mode mode = paramSession.getDatabase().getMode();
/* 287 */     if (paramValue == ValueNull.INSTANCE) {
/* 288 */       if (this.convertNullToDefault) {
/* 289 */         paramValue = expression.getValue(paramSession).convertTo(this.type);
/*     */       }
/* 291 */       if (paramValue == ValueNull.INSTANCE && !this.nullable) {
/* 292 */         if (mode.convertInsertNullToZero) {
/* 293 */           DataType dataType = DataType.getDataType(this.type);
/* 294 */           if (dataType.decimal) {
/* 295 */             paramValue = ValueInt.get(0).convertTo(this.type);
/* 296 */           } else if (dataType.type == 11) {
/* 297 */             ValueTimestamp valueTimestamp = ValueTimestamp.fromMillis(paramSession.getTransactionStart());
/* 298 */           } else if (dataType.type == 24) {
/* 299 */             long l = paramSession.getTransactionStart();
/* 300 */             ValueTimestampTimeZone valueTimestampTimeZone = ValueTimestampTimeZone.fromDateValueAndNanos(DateTimeUtils.dateValueFromDate(l), DateTimeUtils.nanosFromDate(l), (short)0);
/*     */           
/*     */           }
/* 303 */           else if (dataType.type == 9) {
/* 304 */             ValueTime valueTime = ValueTime.fromNanos(0L);
/* 305 */           } else if (dataType.type == 10) {
/* 306 */             ValueDate valueDate = ValueDate.fromMillis(paramSession.getTransactionStart());
/*     */           } else {
/* 308 */             paramValue = ValueString.get("").convertTo(this.type);
/*     */           } 
/*     */         } else {
/* 311 */           throw DbException.get(23502, this.name);
/*     */         } 
/*     */       }
/*     */     } 
/* 315 */     if (this.checkConstraint != null) {
/* 316 */       Value value; this.resolver.setValue(paramValue);
/*     */       
/* 318 */       synchronized (this) {
/* 319 */         value = this.checkConstraint.getValue(paramSession);
/*     */       } 
/*     */       
/* 322 */       if (Boolean.FALSE.equals(value.getBoolean())) {
/* 323 */         throw DbException.get(23513, this.checkConstraint.getSQL());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 328 */     paramValue = paramValue.convertScale(mode.convertOnlyToSmallerScale, this.scale);
/* 329 */     if (this.precision > 0L && 
/* 330 */       !paramValue.checkPrecision(this.precision)) {
/* 331 */       String str = paramValue.getTraceSQL();
/* 332 */       if (str.length() > 127) {
/* 333 */         str = str.substring(0, 128) + "...";
/*     */       }
/* 335 */       throw DbException.get(22001, new String[] { getCreateSQL(), str + " (" + paramValue.getPrecision() + ")" });
/*     */     } 
/*     */ 
/*     */     
/* 339 */     updateSequenceIfRequired(paramSession, paramValue);
/* 340 */     return paramValue;
/*     */   }
/*     */   
/*     */   private void updateSequenceIfRequired(Session paramSession, Value paramValue) {
/* 344 */     if (this.sequence != null) {
/* 345 */       long l1 = this.sequence.getCurrentValue();
/* 346 */       long l2 = this.sequence.getIncrement();
/* 347 */       long l3 = paramValue.getLong();
/* 348 */       boolean bool = false;
/* 349 */       if (l2 > 0L && l3 > l1) {
/* 350 */         bool = true;
/* 351 */       } else if (l2 < 0L && l3 < l1) {
/* 352 */         bool = true;
/*     */       } 
/* 354 */       if (bool) {
/* 355 */         this.sequence.modify(Long.valueOf(l3 + l2), null, null, null);
/* 356 */         paramSession.setLastIdentity((Value)ValueLong.get(l3));
/* 357 */         this.sequence.flush(paramSession);
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
/*     */   public void convertAutoIncrementToSequence(Session paramSession, Schema paramSchema, int paramInt, boolean paramBoolean) {
/*     */     String str;
/* 374 */     if (!this.autoIncrement) {
/* 375 */       DbException.throwInternalError();
/*     */     }
/* 377 */     if ("IDENTITY".equals(this.originalSQL)) {
/* 378 */       this.originalSQL = "BIGINT";
/* 379 */     } else if ("SERIAL".equals(this.originalSQL)) {
/* 380 */       this.originalSQL = "INT";
/*     */     } 
/*     */     
/*     */     do {
/* 384 */       ValueUuid valueUuid = ValueUuid.getNewRandom();
/* 385 */       String str1 = valueUuid.getString();
/* 386 */       str1 = str1.replace('-', '_').toUpperCase();
/* 387 */       str = "SYSTEM_SEQUENCE_" + str1;
/* 388 */     } while (paramSchema.findSequence(str) != null);
/*     */ 
/*     */ 
/*     */     
/* 392 */     Sequence sequence = new Sequence(paramSchema, paramInt, str, this.start, this.increment);
/* 393 */     sequence.setTemporary(paramBoolean);
/* 394 */     paramSession.getDatabase().addSchemaObject(paramSession, (SchemaObject)sequence);
/* 395 */     setAutoIncrement(false, 0L, 0L);
/* 396 */     SequenceValue sequenceValue = new SequenceValue(sequence);
/* 397 */     setDefaultExpression(paramSession, (Expression)sequenceValue);
/* 398 */     setSequence(sequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareExpression(Session paramSession) {
/* 407 */     if (this.defaultExpression != null) {
/* 408 */       this.computeTableFilter = new TableFilter(paramSession, this.table, null, false, null, 0);
/* 409 */       this.defaultExpression.mapColumns(this.computeTableFilter, 0);
/* 410 */       this.defaultExpression = this.defaultExpression.optimize(paramSession);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getCreateSQL() {
/* 415 */     StringBuilder stringBuilder = new StringBuilder();
/* 416 */     if (this.name != null) {
/* 417 */       stringBuilder.append(Parser.quoteIdentifier(this.name)).append(' ');
/*     */     }
/* 419 */     if (this.originalSQL != null) {
/* 420 */       stringBuilder.append(this.originalSQL);
/*     */     } else {
/* 422 */       stringBuilder.append((DataType.getDataType(this.type)).name);
/* 423 */       switch (this.type) {
/*     */         case 6:
/* 425 */           stringBuilder.append('(').append(this.precision).append(", ").append(this.scale).append(')');
/*     */           break;
/*     */         case 12:
/*     */         case 13:
/*     */         case 14:
/*     */         case 21:
/* 431 */           if (this.precision < 2147483647L) {
/* 432 */             stringBuilder.append('(').append(this.precision).append(')');
/*     */           }
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 438 */     if (this.defaultExpression != null) {
/* 439 */       String str = this.defaultExpression.getSQL();
/* 440 */       if (str != null) {
/* 441 */         if (this.isComputed) {
/* 442 */           stringBuilder.append(" AS ").append(str);
/* 443 */         } else if (this.defaultExpression != null) {
/* 444 */           stringBuilder.append(" DEFAULT ").append(str);
/*     */         } 
/*     */       }
/*     */     } 
/* 448 */     if (!this.nullable) {
/* 449 */       stringBuilder.append(" NOT NULL");
/*     */     }
/* 451 */     if (this.convertNullToDefault) {
/* 452 */       stringBuilder.append(" NULL_TO_DEFAULT");
/*     */     }
/* 454 */     if (this.sequence != null) {
/* 455 */       stringBuilder.append(" SEQUENCE ").append(this.sequence.getSQL());
/*     */     }
/* 457 */     if (this.selectivity != 0) {
/* 458 */       stringBuilder.append(" SELECTIVITY ").append(this.selectivity);
/*     */     }
/* 460 */     if (this.comment != null) {
/* 461 */       stringBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/* 463 */     if (this.checkConstraint != null) {
/* 464 */       stringBuilder.append(" CHECK ").append(this.checkConstraintSQL);
/*     */     }
/* 466 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public boolean isNullable() {
/* 470 */     return this.nullable;
/*     */   }
/*     */   
/*     */   public void setOriginalSQL(String paramString) {
/* 474 */     this.originalSQL = paramString;
/*     */   }
/*     */   
/*     */   public String getOriginalSQL() {
/* 478 */     return this.originalSQL;
/*     */   }
/*     */   
/*     */   public Expression getDefaultExpression() {
/* 482 */     return this.defaultExpression;
/*     */   }
/*     */   
/*     */   public boolean isAutoIncrement() {
/* 486 */     return this.autoIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoIncrement(boolean paramBoolean, long paramLong1, long paramLong2) {
/* 497 */     this.autoIncrement = paramBoolean;
/* 498 */     this.start = paramLong1;
/* 499 */     this.increment = paramLong2;
/* 500 */     this.nullable = false;
/* 501 */     if (paramBoolean) {
/* 502 */       this.convertNullToDefault = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setConvertNullToDefault(boolean paramBoolean) {
/* 507 */     this.convertNullToDefault = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rename(String paramString) {
/* 517 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public void setSequence(Sequence paramSequence) {
/* 521 */     this.sequence = paramSequence;
/*     */   }
/*     */   
/*     */   public Sequence getSequence() {
/* 525 */     return this.sequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSelectivity() {
/* 535 */     return (this.selectivity == 0) ? 50 : this.selectivity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectivity(int paramInt) {
/* 544 */     paramInt = (paramInt < 0) ? 0 : ((paramInt > 100) ? 100 : paramInt);
/* 545 */     this.selectivity = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCheckConstraint(Session paramSession, Expression paramExpression) {
/* 556 */     if (paramExpression == null) {
/*     */       return;
/*     */     }
/* 559 */     this.resolver = new SingleColumnResolver(this);
/* 560 */     synchronized (this) {
/* 561 */       String str = this.name;
/* 562 */       if (this.name == null) {
/* 563 */         this.name = "VALUE";
/*     */       }
/* 565 */       paramExpression.mapColumns(this.resolver, 0);
/* 566 */       this.name = str;
/*     */     } 
/* 568 */     paramExpression = paramExpression.optimize(paramSession);
/* 569 */     this.resolver.setValue((Value)ValueNull.INSTANCE);
/*     */     
/* 571 */     synchronized (this) {
/* 572 */       paramExpression.getValue(paramSession);
/*     */     } 
/* 574 */     if (this.checkConstraint == null) {
/* 575 */       this.checkConstraint = paramExpression;
/*     */     } else {
/* 577 */       this.checkConstraint = (Expression)new ConditionAndOr(0, this.checkConstraint, paramExpression);
/*     */     } 
/* 579 */     this.checkConstraintSQL = getCheckConstraintSQL(paramSession, this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCheckConstraint() {
/* 586 */     this.checkConstraint = null;
/* 587 */     this.checkConstraintSQL = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression getCheckConstraint(Session paramSession, String paramString) {
/*     */     String str;
/* 598 */     if (this.checkConstraint == null) {
/* 599 */       return null;
/*     */     }
/* 601 */     Parser parser = new Parser(paramSession);
/*     */     
/* 603 */     synchronized (this) {
/* 604 */       String str1 = this.name;
/* 605 */       this.name = paramString;
/* 606 */       str = this.checkConstraint.getSQL();
/* 607 */       this.name = str1;
/*     */     } 
/* 609 */     return parser.parseExpression(str);
/*     */   }
/*     */ 
/*     */   
/*     */   String getDefaultSQL() {
/* 614 */     return (this.defaultExpression == null) ? null : this.defaultExpression.getSQL();
/*     */   }
/*     */   
/*     */   int getPrecisionAsInt() {
/* 618 */     return MathUtils.convertLongToInt(this.precision);
/*     */   }
/*     */   
/*     */   DataType getDataType() {
/* 622 */     return DataType.getDataType(this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getCheckConstraintSQL(Session paramSession, String paramString) {
/* 633 */     Expression expression = getCheckConstraint(paramSession, paramString);
/* 634 */     return (expression == null) ? "" : expression.getSQL();
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/* 638 */     this.comment = paramString;
/*     */   }
/*     */   
/*     */   public String getComment() {
/* 642 */     return this.comment;
/*     */   }
/*     */   
/*     */   public void setPrimaryKey(boolean paramBoolean) {
/* 646 */     this.primaryKey = paramBoolean;
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
/*     */   boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 658 */     if (paramExpressionVisitor.getType() == 7 && 
/* 659 */       this.sequence != null) {
/* 660 */       paramExpressionVisitor.getDependencies().add(this.sequence);
/*     */     }
/*     */     
/* 663 */     if (this.defaultExpression != null && !this.defaultExpression.isEverything(paramExpressionVisitor)) {
/* 664 */       return false;
/*     */     }
/* 666 */     if (this.checkConstraint != null && !this.checkConstraint.isEverything(paramExpressionVisitor)) {
/* 667 */       return false;
/*     */     }
/* 669 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isPrimaryKey() {
/* 673 */     return this.primaryKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 678 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWideningConversion(Column paramColumn) {
/* 689 */     if (this.type != paramColumn.type) {
/* 690 */       return false;
/*     */     }
/* 692 */     if (this.precision > paramColumn.precision) {
/* 693 */       return false;
/*     */     }
/* 695 */     if (this.scale != paramColumn.scale) {
/* 696 */       return false;
/*     */     }
/* 698 */     if (this.nullable && !paramColumn.nullable) {
/* 699 */       return false;
/*     */     }
/* 701 */     if (this.convertNullToDefault != paramColumn.convertNullToDefault) {
/* 702 */       return false;
/*     */     }
/* 704 */     if (this.primaryKey != paramColumn.primaryKey) {
/* 705 */       return false;
/*     */     }
/* 707 */     if (this.autoIncrement || paramColumn.autoIncrement) {
/* 708 */       return false;
/*     */     }
/* 710 */     if (this.checkConstraint != null || paramColumn.checkConstraint != null) {
/* 711 */       return false;
/*     */     }
/* 713 */     if (this.convertNullToDefault || paramColumn.convertNullToDefault) {
/* 714 */       return false;
/*     */     }
/* 716 */     if (this.defaultExpression != null || paramColumn.defaultExpression != null) {
/* 717 */       return false;
/*     */     }
/* 719 */     if (this.isComputed || paramColumn.isComputed) {
/* 720 */       return false;
/*     */     }
/* 722 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy(Column paramColumn) {
/* 731 */     this.checkConstraint = paramColumn.checkConstraint;
/* 732 */     this.checkConstraintSQL = paramColumn.checkConstraintSQL;
/* 733 */     this.displaySize = paramColumn.displaySize;
/* 734 */     this.name = paramColumn.name;
/* 735 */     this.precision = paramColumn.precision;
/* 736 */     this.scale = paramColumn.scale;
/*     */ 
/*     */     
/* 739 */     this.nullable = paramColumn.nullable;
/* 740 */     this.defaultExpression = paramColumn.defaultExpression;
/* 741 */     this.originalSQL = paramColumn.originalSQL;
/*     */     
/* 743 */     this.convertNullToDefault = paramColumn.convertNullToDefault;
/* 744 */     this.sequence = paramColumn.sequence;
/* 745 */     this.comment = paramColumn.comment;
/* 746 */     this.computeTableFilter = paramColumn.computeTableFilter;
/* 747 */     this.isComputed = paramColumn.isComputed;
/* 748 */     this.selectivity = paramColumn.selectivity;
/* 749 */     this.primaryKey = paramColumn.primaryKey;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\Column.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */