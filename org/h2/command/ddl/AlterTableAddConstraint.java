/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.constraint.Constraint;
/*     */ import org.h2.constraint.ConstraintCheck;
/*     */ import org.h2.constraint.ConstraintReferential;
/*     */ import org.h2.constraint.ConstraintUnique;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
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
/*     */ public class AlterTableAddConstraint
/*     */   extends SchemaCommand
/*     */ {
/*     */   private int type;
/*     */   private String constraintName;
/*     */   private String tableName;
/*     */   private IndexColumn[] indexColumns;
/*     */   private int deleteAction;
/*     */   private int updateAction;
/*     */   private Schema refSchema;
/*     */   private String refTableName;
/*     */   private IndexColumn[] refIndexColumns;
/*     */   private Expression checkExpression;
/*     */   private Index index;
/*     */   private Index refIndex;
/*     */   private String comment;
/*     */   private boolean checkExisting;
/*     */   private boolean primaryKeyHash;
/*     */   private boolean ifTableExists;
/*     */   private final boolean ifNotExists;
/*  54 */   private ArrayList<Index> createdIndexes = New.arrayList();
/*     */ 
/*     */   
/*     */   public AlterTableAddConstraint(Session paramSession, Schema paramSchema, boolean paramBoolean) {
/*  58 */     super(paramSession, paramSchema);
/*  59 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setIfTableExists(boolean paramBoolean) {
/*  63 */     this.ifTableExists = paramBoolean;
/*     */   }
/*     */   
/*     */   private String generateConstraintName(Table paramTable) {
/*  67 */     if (this.constraintName == null) {
/*  68 */       this.constraintName = getSchema().getUniqueConstraintName(this.session, paramTable);
/*     */     }
/*     */     
/*  71 */     return this.constraintName;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*     */     try {
/*  77 */       return tryUpdate();
/*  78 */     } catch (DbException dbException) {
/*  79 */       for (Index index : this.createdIndexes) {
/*  80 */         this.session.getDatabase().removeSchemaObject(this.session, (SchemaObject)index);
/*     */       }
/*  82 */       throw dbException;
/*     */     } finally {
/*  84 */       getSchema().freeUniqueName(this.constraintName);
/*     */     }  } private int tryUpdate() { ConstraintUnique constraintUnique1; ConstraintCheck constraintCheck1; ConstraintReferential constraintReferential1; ArrayList<Constraint> arrayList; int i; Table table2; int j; String str1; boolean bool1;
/*     */     String str2;
/*     */     ConstraintCheck constraintCheck2;
/*     */     boolean bool2;
/*     */     ConstraintUnique constraintUnique2;
/*     */     TableFilter tableFilter;
/*     */     int k;
/*     */     String str3;
/*     */     ConstraintReferential constraintReferential2;
/*  94 */     if (!this.transactional) {
/*  95 */       this.session.commit(true);
/*     */     }
/*  97 */     Database database = this.session.getDatabase();
/*  98 */     Table table1 = getSchema().findTableOrView(this.session, this.tableName);
/*  99 */     if (table1 == null) {
/* 100 */       if (this.ifTableExists) {
/* 101 */         return 0;
/*     */       }
/* 103 */       throw DbException.get(42102, this.tableName);
/*     */     } 
/* 105 */     if (getSchema().findConstraint(this.session, this.constraintName) != null) {
/* 106 */       if (this.ifNotExists) {
/* 107 */         return 0;
/*     */       }
/* 109 */       throw DbException.get(90045, this.constraintName);
/*     */     } 
/*     */     
/* 112 */     this.session.getUser().checkRight(table1, 15);
/* 113 */     database.lockMeta(this.session);
/* 114 */     table1.lock(this.session, true, true);
/*     */     
/* 116 */     switch (this.type) {
/*     */       case 6:
/* 118 */         IndexColumn.mapColumns(this.indexColumns, table1);
/* 119 */         this.index = table1.findPrimaryKey();
/* 120 */         arrayList = table1.getConstraints();
/* 121 */         for (j = 0; arrayList != null && j < arrayList.size(); j++) {
/* 122 */           Constraint constraint = arrayList.get(j);
/* 123 */           if ("PRIMARY KEY".equals(constraint.getConstraintType())) {
/* 124 */             throw DbException.get(90017);
/*     */           }
/*     */         } 
/* 127 */         if (this.index != null) {
/*     */ 
/*     */           
/* 130 */           IndexColumn[] arrayOfIndexColumn = this.index.getIndexColumns();
/* 131 */           if (arrayOfIndexColumn.length != this.indexColumns.length) {
/* 132 */             throw DbException.get(90017);
/*     */           }
/* 134 */           for (byte b = 0; b < arrayOfIndexColumn.length; b++) {
/* 135 */             if ((arrayOfIndexColumn[b]).column != (this.indexColumns[b]).column) {
/* 136 */               throw DbException.get(90017);
/*     */             }
/*     */           } 
/*     */         } 
/* 140 */         if (this.index == null) {
/* 141 */           IndexType indexType = IndexType.createPrimaryKey(table1.isPersistIndexes(), this.primaryKeyHash);
/*     */           
/* 143 */           String str = table1.getSchema().getUniqueIndexName(this.session, table1, "PRIMARY_KEY_");
/*     */           
/* 145 */           int m = getObjectId();
/*     */           try {
/* 147 */             this.index = table1.addIndex(this.session, str, m, this.indexColumns, indexType, true, null);
/*     */           } finally {
/*     */             
/* 150 */             getSchema().freeUniqueName(str);
/*     */           } 
/*     */         } 
/* 153 */         this.index.getIndexType().setBelongsToConstraint(true);
/* 154 */         j = getObjectId();
/* 155 */         str2 = generateConstraintName(table1);
/* 156 */         constraintUnique2 = new ConstraintUnique(getSchema(), j, str2, table1, true);
/*     */         
/* 158 */         constraintUnique2.setColumns(this.indexColumns);
/* 159 */         constraintUnique2.setIndex(this.index, true);
/* 160 */         constraintUnique1 = constraintUnique2;
/*     */         break;
/*     */       
/*     */       case 4:
/* 164 */         IndexColumn.mapColumns(this.indexColumns, table1);
/* 165 */         i = 0;
/* 166 */         if (this.index != null && canUseUniqueIndex(this.index, table1, this.indexColumns)) {
/* 167 */           i = 1;
/* 168 */           this.index.getIndexType().setBelongsToConstraint(true);
/*     */         } else {
/* 170 */           this.index = getUniqueIndex(table1, this.indexColumns);
/* 171 */           if (this.index == null) {
/* 172 */             this.index = createIndex(table1, this.indexColumns, true);
/* 173 */             i = 1;
/*     */           } 
/*     */         } 
/* 176 */         j = getObjectId();
/* 177 */         str2 = generateConstraintName(table1);
/* 178 */         constraintUnique2 = new ConstraintUnique(getSchema(), j, str2, table1, false);
/*     */         
/* 180 */         constraintUnique2.setColumns(this.indexColumns);
/* 181 */         constraintUnique2.setIndex(this.index, i);
/* 182 */         constraintUnique1 = constraintUnique2;
/*     */         break;
/*     */       
/*     */       case 3:
/* 186 */         i = getObjectId();
/* 187 */         str1 = generateConstraintName(table1);
/* 188 */         constraintCheck2 = new ConstraintCheck(getSchema(), i, str1, table1);
/* 189 */         tableFilter = new TableFilter(this.session, table1, null, false, null, 0);
/* 190 */         this.checkExpression.mapColumns((ColumnResolver)tableFilter, 0);
/* 191 */         this.checkExpression = this.checkExpression.optimize(this.session);
/* 192 */         constraintCheck2.setExpression(this.checkExpression);
/* 193 */         constraintCheck2.setTableFilter(tableFilter);
/* 194 */         constraintCheck1 = constraintCheck2;
/* 195 */         if (this.checkExisting) {
/* 196 */           constraintCheck2.checkExistingData(this.session);
/*     */         }
/*     */         break;
/*     */       
/*     */       case 5:
/* 201 */         table2 = this.refSchema.getTableOrView(this.session, this.refTableName);
/* 202 */         this.session.getUser().checkRight(table2, 15);
/* 203 */         if (!table2.canReference()) {
/* 204 */           throw DbException.getUnsupportedException("Reference " + table2.getSQL());
/*     */         }
/*     */         
/* 207 */         bool1 = false;
/* 208 */         IndexColumn.mapColumns(this.indexColumns, table1);
/* 209 */         if (this.index != null && canUseIndex(this.index, table1, this.indexColumns, false)) {
/* 210 */           bool1 = true;
/* 211 */           this.index.getIndexType().setBelongsToConstraint(true);
/*     */         } else {
/* 213 */           this.index = getIndex(table1, this.indexColumns, true);
/* 214 */           if (this.index == null) {
/* 215 */             this.index = createIndex(table1, this.indexColumns, false);
/* 216 */             bool1 = true;
/*     */           } 
/*     */         } 
/* 219 */         if (this.refIndexColumns == null) {
/* 220 */           Index index = table2.getPrimaryKey();
/* 221 */           this.refIndexColumns = index.getIndexColumns();
/*     */         } else {
/* 223 */           IndexColumn.mapColumns(this.refIndexColumns, table2);
/*     */         } 
/* 225 */         if (this.refIndexColumns.length != this.indexColumns.length) {
/* 226 */           throw DbException.get(21002);
/*     */         }
/* 228 */         bool2 = false;
/* 229 */         if (this.refIndex != null && this.refIndex.getTable() == table2 && canUseIndex(this.refIndex, table2, this.refIndexColumns, false)) {
/*     */           
/* 231 */           bool2 = true;
/* 232 */           this.refIndex.getIndexType().setBelongsToConstraint(true);
/*     */         } else {
/* 234 */           this.refIndex = null;
/*     */         } 
/* 236 */         if (this.refIndex == null) {
/* 237 */           this.refIndex = getIndex(table2, this.refIndexColumns, false);
/* 238 */           if (this.refIndex == null) {
/* 239 */             this.refIndex = createIndex(table2, this.refIndexColumns, true);
/* 240 */             bool2 = true;
/*     */           } 
/*     */         } 
/* 243 */         k = getObjectId();
/* 244 */         str3 = generateConstraintName(table1);
/* 245 */         constraintReferential2 = new ConstraintReferential(getSchema(), k, str3, table1);
/*     */         
/* 247 */         constraintReferential2.setColumns(this.indexColumns);
/* 248 */         constraintReferential2.setIndex(this.index, bool1);
/* 249 */         constraintReferential2.setRefTable(table2);
/* 250 */         constraintReferential2.setRefColumns(this.refIndexColumns);
/* 251 */         constraintReferential2.setRefIndex(this.refIndex, bool2);
/* 252 */         if (this.checkExisting) {
/* 253 */           constraintReferential2.checkExistingData(this.session);
/*     */         }
/* 255 */         constraintReferential1 = constraintReferential2;
/* 256 */         table2.addConstraint((Constraint)constraintReferential1);
/* 257 */         constraintReferential2.setDeleteAction(this.deleteAction);
/* 258 */         constraintReferential2.setUpdateAction(this.updateAction);
/*     */         break;
/*     */       
/*     */       default:
/* 262 */         throw DbException.throwInternalError("type=" + this.type);
/*     */     } 
/*     */     
/* 265 */     constraintReferential1.setComment(this.comment);
/* 266 */     if (table1.isTemporary() && !table1.isGlobalTemporary()) {
/* 267 */       this.session.addLocalTempTableConstraint((Constraint)constraintReferential1);
/*     */     } else {
/* 269 */       database.addSchemaObject(this.session, (SchemaObject)constraintReferential1);
/*     */     } 
/* 271 */     table1.addConstraint((Constraint)constraintReferential1);
/* 272 */     return 0; }
/*     */   
/*     */   private Index createIndex(Table paramTable, IndexColumn[] paramArrayOfIndexColumn, boolean paramBoolean) {
/*     */     IndexType indexType;
/* 276 */     int i = getObjectId();
/*     */     
/* 278 */     if (paramBoolean) {
/*     */       
/* 280 */       indexType = IndexType.createUnique(paramTable.isPersistIndexes(), false);
/*     */     } else {
/*     */       
/* 283 */       indexType = IndexType.createNonUnique(paramTable.isPersistIndexes());
/*     */     } 
/* 285 */     indexType.setBelongsToConstraint(true);
/* 286 */     String str1 = (this.constraintName == null) ? "CONSTRAINT" : this.constraintName;
/* 287 */     String str2 = paramTable.getSchema().getUniqueIndexName(this.session, paramTable, str1 + "_INDEX_");
/*     */     
/*     */     try {
/* 290 */       Index index = paramTable.addIndex(this.session, str2, i, paramArrayOfIndexColumn, indexType, true, null);
/*     */       
/* 292 */       this.createdIndexes.add(index);
/* 293 */       return index;
/*     */     } finally {
/* 295 */       getSchema().freeUniqueName(str2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDeleteAction(int paramInt) {
/* 300 */     this.deleteAction = paramInt;
/*     */   }
/*     */   
/*     */   public void setUpdateAction(int paramInt) {
/* 304 */     this.updateAction = paramInt;
/*     */   }
/*     */   
/*     */   private static Index getUniqueIndex(Table paramTable, IndexColumn[] paramArrayOfIndexColumn) {
/* 308 */     if (paramTable.getIndexes() == null) {
/* 309 */       return null;
/*     */     }
/* 311 */     for (Index index : paramTable.getIndexes()) {
/* 312 */       if (canUseUniqueIndex(index, paramTable, paramArrayOfIndexColumn)) {
/* 313 */         return index;
/*     */       }
/*     */     } 
/* 316 */     return null;
/*     */   }
/*     */   
/*     */   private static Index getIndex(Table paramTable, IndexColumn[] paramArrayOfIndexColumn, boolean paramBoolean) {
/* 320 */     if (paramTable.getIndexes() == null) {
/* 321 */       return null;
/*     */     }
/* 323 */     for (Index index : paramTable.getIndexes()) {
/* 324 */       if (canUseIndex(index, paramTable, paramArrayOfIndexColumn, paramBoolean)) {
/* 325 */         return index;
/*     */       }
/*     */     } 
/* 328 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean canUseUniqueIndex(Index paramIndex, Table paramTable, IndexColumn[] paramArrayOfIndexColumn) {
/* 333 */     if (paramIndex.getTable() != paramTable || !paramIndex.getIndexType().isUnique()) {
/* 334 */       return false;
/*     */     }
/* 336 */     Column[] arrayOfColumn = paramIndex.getColumns();
/* 337 */     if (arrayOfColumn.length > paramArrayOfIndexColumn.length) {
/* 338 */       return false;
/*     */     }
/* 340 */     HashSet<Column> hashSet = New.hashSet();
/* 341 */     for (IndexColumn indexColumn : paramArrayOfIndexColumn) {
/* 342 */       hashSet.add(indexColumn.column);
/*     */     }
/* 344 */     for (Column column : arrayOfColumn) {
/*     */ 
/*     */       
/* 347 */       if (!hashSet.contains(column)) {
/* 348 */         return false;
/*     */       }
/*     */     } 
/* 351 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean canUseIndex(Index paramIndex, Table paramTable, IndexColumn[] paramArrayOfIndexColumn, boolean paramBoolean) {
/* 356 */     if (paramIndex.getTable() != paramTable || paramIndex.getCreateSQL() == null)
/*     */     {
/* 358 */       return false;
/*     */     }
/* 360 */     Column[] arrayOfColumn = paramIndex.getColumns();
/*     */     
/* 362 */     if (paramBoolean) {
/* 363 */       if (arrayOfColumn.length < paramArrayOfIndexColumn.length) {
/* 364 */         return false;
/*     */       }
/* 366 */       for (IndexColumn indexColumn : paramArrayOfIndexColumn) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 371 */         int i = paramIndex.getColumnIndex(indexColumn.column);
/* 372 */         if (i < 0 || i >= paramArrayOfIndexColumn.length) {
/* 373 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/* 377 */       if (arrayOfColumn.length != paramArrayOfIndexColumn.length) {
/* 378 */         return false;
/*     */       }
/* 380 */       for (IndexColumn indexColumn : paramArrayOfIndexColumn) {
/*     */         
/* 382 */         int i = paramIndex.getColumnIndex(indexColumn.column);
/* 383 */         if (i < 0) {
/* 384 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 388 */     return true;
/*     */   }
/*     */   
/*     */   public void setConstraintName(String paramString) {
/* 392 */     this.constraintName = paramString;
/*     */   }
/*     */   
/*     */   public void setType(int paramInt) {
/* 396 */     this.type = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 401 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setCheckExpression(Expression paramExpression) {
/* 405 */     this.checkExpression = paramExpression;
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/* 409 */     this.tableName = paramString;
/*     */   }
/*     */   
/*     */   public void setIndexColumns(IndexColumn[] paramArrayOfIndexColumn) {
/* 413 */     this.indexColumns = paramArrayOfIndexColumn;
/*     */   }
/*     */   
/*     */   public IndexColumn[] getIndexColumns() {
/* 417 */     return this.indexColumns;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRefTableName(Schema paramSchema, String paramString) {
/* 427 */     this.refSchema = paramSchema;
/* 428 */     this.refTableName = paramString;
/*     */   }
/*     */   
/*     */   public void setRefIndexColumns(IndexColumn[] paramArrayOfIndexColumn) {
/* 432 */     this.refIndexColumns = paramArrayOfIndexColumn;
/*     */   }
/*     */   
/*     */   public void setIndex(Index paramIndex) {
/* 436 */     this.index = paramIndex;
/*     */   }
/*     */   
/*     */   public void setRefIndex(Index paramIndex) {
/* 440 */     this.refIndex = paramIndex;
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/* 444 */     this.comment = paramString;
/*     */   }
/*     */   
/*     */   public void setCheckExisting(boolean paramBoolean) {
/* 448 */     this.checkExisting = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setPrimaryKeyHash(boolean paramBoolean) {
/* 452 */     this.primaryKeyHash = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\AlterTableAddConstraint.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */