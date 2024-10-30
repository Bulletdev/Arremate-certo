/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.command.dml.Select;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Constant;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExpressionColumn
/*     */   extends Expression
/*     */ {
/*     */   private final Database database;
/*     */   private final String schemaName;
/*     */   private final String tableAlias;
/*     */   private final String columnName;
/*     */   private ColumnResolver columnResolver;
/*     */   private int queryLevel;
/*     */   private Column column;
/*     */   private boolean evaluatable;
/*     */   
/*     */   public ExpressionColumn(Database paramDatabase, Column paramColumn) {
/*  42 */     this.database = paramDatabase;
/*  43 */     this.column = paramColumn;
/*  44 */     this.schemaName = null;
/*  45 */     this.tableAlias = null;
/*  46 */     this.columnName = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExpressionColumn(Database paramDatabase, String paramString1, String paramString2, String paramString3) {
/*  51 */     this.database = paramDatabase;
/*  52 */     this.schemaName = paramString1;
/*  53 */     this.tableAlias = paramString2;
/*  54 */     this.columnName = paramString3;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*     */     String str;
/*  60 */     boolean bool = (this.database.getSettings()).databaseToUpper;
/*  61 */     if (this.column != null) {
/*  62 */       str = this.column.getSQL();
/*     */     } else {
/*  64 */       str = bool ? Parser.quoteIdentifier(this.columnName) : this.columnName;
/*     */     } 
/*  66 */     if (this.tableAlias != null) {
/*  67 */       String str1 = bool ? Parser.quoteIdentifier(this.tableAlias) : this.tableAlias;
/*  68 */       str = str1 + "." + str;
/*     */     } 
/*  70 */     if (this.schemaName != null) {
/*  71 */       String str1 = bool ? Parser.quoteIdentifier(this.schemaName) : this.schemaName;
/*  72 */       str = str1 + "." + str;
/*     */     } 
/*  74 */     return str;
/*     */   }
/*     */   
/*     */   public TableFilter getTableFilter() {
/*  78 */     return (this.columnResolver == null) ? null : this.columnResolver.getTableFilter();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  83 */     if (this.tableAlias != null && !this.database.equalsIdentifiers(this.tableAlias, paramColumnResolver.getTableAlias())) {
/*     */       return;
/*     */     }
/*     */     
/*  87 */     if (this.schemaName != null && !this.database.equalsIdentifiers(this.schemaName, paramColumnResolver.getSchemaName())) {
/*     */       return;
/*     */     }
/*     */     
/*  91 */     for (Column column : paramColumnResolver.getColumns()) {
/*  92 */       String str = column.getName();
/*  93 */       if (this.database.equalsIdentifiers(this.columnName, str)) {
/*  94 */         mapColumn(paramColumnResolver, column, paramInt);
/*     */         return;
/*     */       } 
/*     */     } 
/*  98 */     if (this.database.equalsIdentifiers("_ROWID_", this.columnName)) {
/*  99 */       Column column = paramColumnResolver.getRowIdColumn();
/* 100 */       if (column != null) {
/* 101 */         mapColumn(paramColumnResolver, column, paramInt);
/*     */         return;
/*     */       } 
/*     */     } 
/* 105 */     Column[] arrayOfColumn = paramColumnResolver.getSystemColumns();
/* 106 */     for (byte b = 0; arrayOfColumn != null && b < arrayOfColumn.length; b++) {
/* 107 */       Column column = arrayOfColumn[b];
/* 108 */       if (this.database.equalsIdentifiers(this.columnName, column.getName())) {
/* 109 */         mapColumn(paramColumnResolver, column, paramInt);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void mapColumn(ColumnResolver paramColumnResolver, Column paramColumn, int paramInt) {
/* 116 */     if (this.columnResolver == null) {
/* 117 */       this.queryLevel = paramInt;
/* 118 */       this.column = paramColumn;
/* 119 */       this.columnResolver = paramColumnResolver;
/* 120 */     } else if (this.queryLevel == paramInt && this.columnResolver != paramColumnResolver && 
/* 121 */       !(paramColumnResolver instanceof org.h2.command.dml.SelectListColumnResolver)) {
/*     */ 
/*     */       
/* 124 */       throw DbException.get(90059, this.columnName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/* 131 */     if (this.columnResolver == null) {
/* 132 */       Schema schema = paramSession.getDatabase().findSchema((this.tableAlias == null) ? paramSession.getCurrentSchemaName() : this.tableAlias);
/*     */       
/* 134 */       if (schema != null) {
/* 135 */         Constant constant = schema.findConstant(this.columnName);
/* 136 */         if (constant != null) {
/* 137 */           return constant.getValue();
/*     */         }
/*     */       } 
/* 140 */       String str = this.columnName;
/* 141 */       if (this.tableAlias != null) {
/* 142 */         str = this.tableAlias + "." + str;
/* 143 */         if (this.schemaName != null) {
/* 144 */           str = this.schemaName + "." + str;
/*     */         }
/*     */       } 
/* 147 */       throw DbException.get(42122, str);
/*     */     } 
/* 149 */     return this.columnResolver.optimize(this, this.column);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 154 */     Value value1 = this.columnResolver.getValue(this.column);
/* 155 */     Select select = this.columnResolver.getSelect();
/* 156 */     if (select == null) {
/* 157 */       throw DbException.get(90016, getSQL());
/*     */     }
/* 159 */     HashMap<ExpressionColumn, Value> hashMap = select.getCurrentGroup();
/* 160 */     if (hashMap == null) {
/*     */       return;
/*     */     }
/*     */     
/* 164 */     Value value2 = (Value)hashMap.get(this);
/* 165 */     if (value2 == null) {
/* 166 */       hashMap.put(this, value1);
/*     */     }
/* 168 */     else if (!this.database.areEqual(value1, value2)) {
/* 169 */       throw DbException.get(90016, getSQL());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/* 176 */     Select select = this.columnResolver.getSelect();
/* 177 */     if (select != null) {
/* 178 */       HashMap hashMap = select.getCurrentGroup();
/* 179 */       if (hashMap != null) {
/* 180 */         Value value1 = (Value)hashMap.get(this);
/* 181 */         if (value1 != null) {
/* 182 */           return value1;
/*     */         }
/*     */       } 
/*     */     } 
/* 186 */     Value value = this.columnResolver.getValue(this.column);
/* 187 */     if (value == null) {
/* 188 */       this.columnResolver.getValue(this.column);
/* 189 */       throw DbException.get(90016, getSQL());
/*     */     } 
/* 191 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 196 */     return this.column.getType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 201 */     if (this.columnResolver != null && paramTableFilter == this.columnResolver.getTableFilter()) {
/* 202 */       this.evaluatable = paramBoolean;
/*     */     }
/*     */   }
/*     */   
/*     */   public Column getColumn() {
/* 207 */     return this.column;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 212 */     return this.column.getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 217 */     return this.column.getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 222 */     return this.column.getDisplaySize();
/*     */   }
/*     */   
/*     */   public String getOriginalColumnName() {
/* 226 */     return this.columnName;
/*     */   }
/*     */   
/*     */   public String getOriginalTableAliasName() {
/* 230 */     return this.tableAlias;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName() {
/* 235 */     return (this.columnName != null) ? this.columnName : this.column.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSchemaName() {
/* 240 */     Table table = this.column.getTable();
/* 241 */     return (table == null) ? null : table.getSchema().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableName() {
/* 246 */     Table table = this.column.getTable();
/* 247 */     return (table == null) ? null : table.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAlias() {
/* 252 */     if (this.column != null) {
/* 253 */       return this.column.getName();
/*     */     }
/* 255 */     if (this.tableAlias != null) {
/* 256 */       return this.tableAlias + "." + this.columnName;
/*     */     }
/* 258 */     return this.columnName;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAutoIncrement() {
/* 263 */     return (this.column.getSequence() != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNullable() {
/* 268 */     return this.column.isNullable() ? 1 : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 273 */     switch (paramExpressionVisitor.getType()) {
/*     */       case 1:
/* 275 */         return false;
/*     */       case 2:
/*     */       case 5:
/*     */       case 8:
/* 279 */         return true;
/*     */       case 0:
/* 281 */         return (this.queryLevel < paramExpressionVisitor.getQueryLevel());
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 286 */         if ((this.database.getSettings()).nestedJoins) {
/* 287 */           if (paramExpressionVisitor.getQueryLevel() < this.queryLevel) {
/* 288 */             return true;
/*     */           }
/* 290 */           if (getTableFilter() == null) {
/* 291 */             return false;
/*     */           }
/* 293 */           return getTableFilter().isEvaluatable();
/*     */         } 
/* 295 */         return (this.evaluatable || paramExpressionVisitor.getQueryLevel() < this.queryLevel);
/*     */       case 4:
/* 297 */         paramExpressionVisitor.addDataModificationId(this.column.getTable().getMaxDataModificationId());
/* 298 */         return true;
/*     */       case 6:
/* 300 */         return (this.columnResolver != paramExpressionVisitor.getResolver());
/*     */       case 7:
/* 302 */         if (this.column != null) {
/* 303 */           paramExpressionVisitor.addDependency((DbObject)this.column.getTable());
/*     */         }
/* 305 */         return true;
/*     */       case 9:
/* 307 */         paramExpressionVisitor.addColumn(this.column);
/* 308 */         return true;
/*     */     } 
/* 310 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 316 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/* 321 */     TableFilter tableFilter = getTableFilter();
/* 322 */     if (paramTableFilter == tableFilter && this.column.getType() == 1) {
/* 323 */       IndexCondition indexCondition = IndexCondition.get(0, this, ValueExpression.get((Value)ValueBoolean.get(true)));
/*     */ 
/*     */       
/* 326 */       paramTableFilter.addIndexCondition(indexCondition);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression getNotIfPossible(Session paramSession) {
/* 332 */     return new Comparison(paramSession, 0, this, ValueExpression.get((Value)ValueBoolean.get(false)));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ExpressionColumn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */