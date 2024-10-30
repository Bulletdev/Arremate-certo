/*      */ package org.h2.table;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import org.h2.command.Prepared;
/*      */ import org.h2.constraint.Constraint;
/*      */ import org.h2.engine.DbObject;
/*      */ import org.h2.engine.Right;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.expression.Expression;
/*      */ import org.h2.expression.ExpressionVisitor;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.IndexType;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.Trace;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.RowList;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.result.SimpleRow;
/*      */ import org.h2.result.SimpleRowValue;
/*      */ import org.h2.result.SortOrder;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.schema.SchemaObject;
/*      */ import org.h2.schema.SchemaObjectBase;
/*      */ import org.h2.schema.Sequence;
/*      */ import org.h2.schema.TriggerObject;
/*      */ import org.h2.util.New;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class Table
/*      */   extends SchemaObjectBase
/*      */ {
/*      */   public static final int TYPE_CACHED = 0;
/*      */   public static final int TYPE_MEMORY = 1;
/*      */   public static final String TABLE_LINK = "TABLE LINK";
/*      */   public static final String SYSTEM_TABLE = "SYSTEM TABLE";
/*      */   public static final String TABLE = "TABLE";
/*      */   public static final String VIEW = "VIEW";
/*      */   public static final String EXTERNAL_TABLE_ENGINE = "EXTERNAL";
/*      */   protected Column[] columns;
/*      */   protected CompareMode compareMode;
/*      */   protected boolean isHidden;
/*      */   private final HashMap<String, Column> columnMap;
/*      */   private final boolean persistIndexes;
/*      */   private final boolean persistData;
/*      */   private ArrayList<TriggerObject> triggers;
/*      */   private ArrayList<Constraint> constraints;
/*      */   private ArrayList<Sequence> sequences;
/*      */   private ArrayList<TableView> views;
/*      */   private boolean checkForeignKeyConstraints = true;
/*      */   private boolean onCommitDrop;
/*      */   private boolean onCommitTruncate;
/*      */   private volatile Row nullRow;
/*      */   
/*      */   public Table(Schema paramSchema, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*  112 */     this.columnMap = paramSchema.getDatabase().newStringMap();
/*  113 */     initSchemaObjectBase(paramSchema, paramInt, paramString, 11);
/*  114 */     this.persistIndexes = paramBoolean1;
/*  115 */     this.persistData = paramBoolean2;
/*  116 */     this.compareMode = paramSchema.getDatabase().getCompareMode();
/*      */   }
/*      */ 
/*      */   
/*      */   public void rename(String paramString) {
/*  121 */     super.rename(paramString);
/*  122 */     if (this.constraints != null) {
/*  123 */       byte b; int i; for (b = 0, i = this.constraints.size(); b < i; b++) {
/*  124 */         Constraint constraint = this.constraints.get(b);
/*  125 */         constraint.rebuild();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isView() {
/*  131 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void close(Session paramSession);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void unlock(Session paramSession);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Row getRow(Session paramSession, long paramLong) {
/*  184 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void removeRow(Session paramSession, Row paramRow);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void truncate(Session paramSession);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void addRow(Session paramSession, Row paramRow);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void commit(short paramShort, Row paramRow) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void checkSupportAlter();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract String getTableType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract Index getScanIndex(Session paramSession);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Index getScanIndex(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*  257 */     return getScanIndex(paramSession);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract Index getUniqueIndex();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract ArrayList<Index> getIndexes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean isLockedExclusively();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract long getMaxDataModificationId();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean isDeterministic();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean canGetRowCount();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canReference() {
/*  308 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract boolean canDrop();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract long getRowCount(Session paramSession);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract long getRowCountApproximation();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract long getDiskSpaceUsed();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Column getRowIdColumn() {
/*  341 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  346 */     throw DbException.throwInternalError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isQueryComparable() {
/*  357 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addDependencies(HashSet<DbObject> paramHashSet) {
/*  366 */     if (paramHashSet.contains(this)) {
/*      */       return;
/*      */     }
/*      */     
/*  370 */     if (this.sequences != null) {
/*  371 */       for (Sequence sequence : this.sequences) {
/*  372 */         paramHashSet.add(sequence);
/*      */       }
/*      */     }
/*  375 */     ExpressionVisitor expressionVisitor = ExpressionVisitor.getDependenciesVisitor(paramHashSet);
/*      */     
/*  377 */     for (Column column : this.columns) {
/*  378 */       column.isEverything(expressionVisitor);
/*      */     }
/*  380 */     if (this.constraints != null) {
/*  381 */       for (Constraint constraint : this.constraints) {
/*  382 */         constraint.isEverything(expressionVisitor);
/*      */       }
/*      */     }
/*  385 */     paramHashSet.add(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public ArrayList<DbObject> getChildren() {
/*  390 */     ArrayList<Index> arrayList1 = New.arrayList();
/*  391 */     ArrayList<Index> arrayList2 = getIndexes();
/*  392 */     if (arrayList2 != null) {
/*  393 */       arrayList1.addAll(arrayList2);
/*      */     }
/*  395 */     if (this.constraints != null) {
/*  396 */       arrayList1.addAll(this.constraints);
/*      */     }
/*  398 */     if (this.triggers != null) {
/*  399 */       arrayList1.addAll(this.triggers);
/*      */     }
/*  401 */     if (this.sequences != null) {
/*  402 */       arrayList1.addAll(this.sequences);
/*      */     }
/*  404 */     if (this.views != null) {
/*  405 */       arrayList1.addAll(this.views);
/*      */     }
/*  407 */     ArrayList arrayList = this.database.getAllRights();
/*  408 */     for (Right right : arrayList) {
/*  409 */       if (right.getGrantedObject() == this) {
/*  410 */         arrayList1.add(right);
/*      */       }
/*      */     } 
/*  413 */     return (ArrayList)arrayList1;
/*      */   }
/*      */   
/*      */   protected void setColumns(Column[] paramArrayOfColumn) {
/*  417 */     this.columns = paramArrayOfColumn;
/*  418 */     if (this.columnMap.size() > 0) {
/*  419 */       this.columnMap.clear();
/*      */     }
/*  421 */     for (byte b = 0; b < paramArrayOfColumn.length; b++) {
/*  422 */       Column column = paramArrayOfColumn[b];
/*  423 */       int i = column.getType();
/*  424 */       if (i == -1) {
/*  425 */         throw DbException.get(50004, column.getSQL());
/*      */       }
/*      */       
/*  428 */       column.setTable(this, b);
/*  429 */       String str = column.getName();
/*  430 */       if (this.columnMap.get(str) != null) {
/*  431 */         throw DbException.get(42121, str);
/*      */       }
/*      */       
/*  434 */       this.columnMap.put(str, column);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renameColumn(Column paramColumn, String paramString) {
/*  445 */     for (Column column : this.columns) {
/*  446 */       if (column != paramColumn)
/*      */       {
/*      */         
/*  449 */         if (column.getName().equals(paramString)) {
/*  450 */           throw DbException.get(42121, paramString);
/*      */         }
/*      */       }
/*      */     } 
/*  454 */     this.columnMap.remove(paramColumn.getName());
/*  455 */     paramColumn.rename(paramString);
/*  456 */     this.columnMap.put(paramString, paramColumn);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLockedExclusivelyBy(Session paramSession) {
/*  466 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateRows(Prepared paramPrepared, Session paramSession, RowList paramRowList) {
/*  479 */     Session.Savepoint savepoint = paramSession.setSavepoint();
/*      */     
/*  481 */     byte b = 0;
/*  482 */     paramRowList.reset(); while (paramRowList.hasNext()) {
/*  483 */       if ((++b & 0x7F) == 0) {
/*  484 */         paramPrepared.checkCanceled();
/*      */       }
/*  486 */       Row row = paramRowList.next();
/*  487 */       paramRowList.next();
/*      */       try {
/*  489 */         removeRow(paramSession, row);
/*  490 */       } catch (DbException dbException) {
/*  491 */         if (dbException.getErrorCode() == 90131) {
/*  492 */           paramSession.rollbackTo(savepoint, false);
/*  493 */           paramSession.startStatementWithinTransaction();
/*  494 */           savepoint = paramSession.setSavepoint();
/*      */         } 
/*  496 */         throw dbException;
/*      */       } 
/*  498 */       paramSession.log(this, (short)1, row);
/*      */     } 
/*      */     
/*  501 */     paramRowList.reset(); while (paramRowList.hasNext()) {
/*  502 */       if ((++b & 0x7F) == 0) {
/*  503 */         paramPrepared.checkCanceled();
/*      */       }
/*  505 */       paramRowList.next();
/*  506 */       Row row = paramRowList.next();
/*      */       try {
/*  508 */         addRow(paramSession, row);
/*  509 */       } catch (DbException dbException) {
/*  510 */         if (dbException.getErrorCode() == 90131) {
/*  511 */           paramSession.rollbackTo(savepoint, false);
/*  512 */           paramSession.startStatementWithinTransaction();
/*  513 */           savepoint = paramSession.setSavepoint();
/*      */         } 
/*  515 */         throw dbException;
/*      */       } 
/*  517 */       paramSession.log(this, (short)0, row);
/*      */     } 
/*      */   }
/*      */   
/*      */   public ArrayList<TableView> getViews() {
/*  522 */     return this.views;
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeChildrenAndResources(Session paramSession) {
/*  527 */     while (this.views != null && this.views.size() > 0) {
/*  528 */       TableView tableView = this.views.get(0);
/*  529 */       this.views.remove(0);
/*  530 */       this.database.removeSchemaObject(paramSession, (SchemaObject)tableView);
/*      */     } 
/*  532 */     while (this.triggers != null && this.triggers.size() > 0) {
/*  533 */       TriggerObject triggerObject = this.triggers.get(0);
/*  534 */       this.triggers.remove(0);
/*  535 */       this.database.removeSchemaObject(paramSession, (SchemaObject)triggerObject);
/*      */     } 
/*  537 */     while (this.constraints != null && this.constraints.size() > 0) {
/*  538 */       Constraint constraint = this.constraints.get(0);
/*  539 */       this.constraints.remove(0);
/*  540 */       this.database.removeSchemaObject(paramSession, (SchemaObject)constraint);
/*      */     } 
/*  542 */     for (Right right : this.database.getAllRights()) {
/*  543 */       if (right.getGrantedObject() == this) {
/*  544 */         this.database.removeDatabaseObject(paramSession, (DbObject)right);
/*      */       }
/*      */     } 
/*  547 */     this.database.removeMeta(paramSession, getId());
/*      */ 
/*      */     
/*  550 */     while (this.sequences != null && this.sequences.size() > 0) {
/*  551 */       Sequence sequence = this.sequences.get(0);
/*  552 */       this.sequences.remove(0);
/*      */ 
/*      */       
/*  555 */       if (this.database.getDependentTable((SchemaObject)sequence, this) == null) {
/*  556 */         this.database.removeSchemaObject(paramSession, (SchemaObject)sequence);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dropMultipleColumnsConstraintsAndIndexes(Session paramSession, ArrayList<Column> paramArrayList) {
/*  573 */     HashSet<Constraint> hashSet = New.hashSet();
/*  574 */     if (this.constraints != null) {
/*  575 */       for (Column column : paramArrayList) {
/*  576 */         byte b; int i; for (b = 0, i = this.constraints.size(); b < i; b++) {
/*  577 */           Constraint constraint = this.constraints.get(b);
/*  578 */           HashSet hashSet2 = constraint.getReferencedColumns(this);
/*  579 */           if (hashSet2.contains(column))
/*      */           {
/*      */             
/*  582 */             if (hashSet2.size() == 1) {
/*  583 */               hashSet.add(constraint);
/*      */             } else {
/*  585 */               throw DbException.get(90083, constraint.getSQL());
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*  591 */     HashSet<Index> hashSet1 = New.hashSet();
/*  592 */     ArrayList<Index> arrayList = getIndexes();
/*  593 */     if (arrayList != null)
/*  594 */       for (Column column : paramArrayList) {
/*  595 */         byte b; int i; for (b = 0, i = arrayList.size(); b < i; b++) {
/*  596 */           Index index = arrayList.get(b);
/*  597 */           if (index.getCreateSQL() != null)
/*      */           {
/*      */             
/*  600 */             if (index.getColumnIndex(column) >= 0)
/*      */             {
/*      */               
/*  603 */               if ((index.getColumns()).length == 1) {
/*  604 */                 hashSet1.add(index);
/*      */               } else {
/*  606 */                 throw DbException.get(90083, index.getSQL());
/*      */               } 
/*      */             }
/*      */           }
/*      */         } 
/*      */       }  
/*  612 */     for (Constraint constraint : hashSet) {
/*  613 */       paramSession.getDatabase().removeSchemaObject(paramSession, (SchemaObject)constraint);
/*      */     }
/*  615 */     for (Index index : hashSet1) {
/*      */ 
/*      */       
/*  618 */       if (getIndexes().contains(index)) {
/*  619 */         paramSession.getDatabase().removeSchemaObject(paramSession, (SchemaObject)index);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public Row getTemplateRow() {
/*  625 */     return this.database.createRow(new Value[this.columns.length], -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SearchRow getTemplateSimpleRow(boolean paramBoolean) {
/*  635 */     if (paramBoolean) {
/*  636 */       return (SearchRow)new SimpleRowValue(this.columns.length);
/*      */     }
/*  638 */     return (SearchRow)new SimpleRow(new Value[this.columns.length]);
/*      */   }
/*      */   
/*      */   Row getNullRow() {
/*  642 */     Row row = this.nullRow;
/*  643 */     if (row == null) {
/*      */ 
/*      */       
/*  646 */       Value[] arrayOfValue = new Value[this.columns.length];
/*  647 */       Arrays.fill((Object[])arrayOfValue, ValueNull.INSTANCE);
/*  648 */       this.nullRow = row = this.database.createRow(arrayOfValue, 1);
/*      */     } 
/*  650 */     return row;
/*      */   }
/*      */   
/*      */   public Column[] getColumns() {
/*  654 */     return this.columns;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getType() {
/*  659 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Column getColumn(int paramInt) {
/*  669 */     return this.columns[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Column getColumn(String paramString) {
/*  680 */     Column column = this.columnMap.get(paramString);
/*  681 */     if (column == null) {
/*  682 */       throw DbException.get(42122, paramString);
/*      */     }
/*  684 */     return column;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doesColumnExist(String paramString) {
/*  694 */     return this.columnMap.containsKey(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PlanItem getBestPlanItem(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/*  712 */     PlanItem planItem = new PlanItem();
/*  713 */     planItem.setIndex(getScanIndex(paramSession));
/*  714 */     planItem.cost = planItem.getIndex().getCost(paramSession, null, paramArrayOfTableFilter, paramInt, null, paramHashSet);
/*  715 */     Trace trace = paramSession.getTrace();
/*  716 */     if (trace.isDebugEnabled()) {
/*  717 */       trace.debug("Table      :     potential plan item cost {0} index {1}", new Object[] { Double.valueOf(planItem.cost), planItem.getIndex().getPlanSQL() });
/*      */     }
/*      */     
/*  720 */     ArrayList<Index> arrayList = getIndexes();
/*  721 */     if (arrayList != null && paramArrayOfint != null) {
/*  722 */       byte b; int i; for (b = 1, i = arrayList.size(); b < i; b++) {
/*  723 */         Index index = arrayList.get(b);
/*  724 */         double d = index.getCost(paramSession, paramArrayOfint, paramArrayOfTableFilter, paramInt, paramSortOrder, paramHashSet);
/*      */         
/*  726 */         if (trace.isDebugEnabled()) {
/*  727 */           trace.debug("Table      :     potential plan item cost {0} index {1}", new Object[] { Double.valueOf(d), index.getPlanSQL() });
/*      */         }
/*      */         
/*  730 */         if (d < planItem.cost) {
/*  731 */           planItem.cost = d;
/*  732 */           planItem.setIndex(index);
/*      */         } 
/*      */       } 
/*      */     } 
/*  736 */     return planItem;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Index findPrimaryKey() {
/*  745 */     ArrayList<Index> arrayList = getIndexes();
/*  746 */     if (arrayList != null) {
/*  747 */       byte b; int i; for (b = 0, i = arrayList.size(); b < i; b++) {
/*  748 */         Index index = arrayList.get(b);
/*  749 */         if (index.getIndexType().isPrimaryKey()) {
/*  750 */           return index;
/*      */         }
/*      */       } 
/*      */     } 
/*  754 */     return null;
/*      */   }
/*      */   
/*      */   public Index getPrimaryKey() {
/*  758 */     Index index = findPrimaryKey();
/*  759 */     if (index != null) {
/*  760 */       return index;
/*      */     }
/*  762 */     throw DbException.get(42112, "PRIMARY_KEY_");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void validateConvertUpdateSequence(Session paramSession, Row paramRow) {
/*  775 */     for (byte b = 0; b < this.columns.length; b++) {
/*  776 */       Value value1 = paramRow.getValue(b);
/*  777 */       Column column = this.columns[b];
/*      */       
/*  779 */       if (column.getComputed()) {
/*      */         
/*  781 */         value1 = null;
/*  782 */         Value value = column.computeValue(paramSession, paramRow);
/*      */       } 
/*  784 */       Value value2 = column.validateConvertUpdateSequence(paramSession, value1);
/*  785 */       if (value2 != value1) {
/*  786 */         paramRow.setValue(b, value2);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void remove(ArrayList<? extends DbObject> paramArrayList, DbObject paramDbObject) {
/*  792 */     if (paramArrayList != null) {
/*  793 */       int i = paramArrayList.indexOf(paramDbObject);
/*  794 */       if (i >= 0) {
/*  795 */         paramArrayList.remove(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeIndex(Index paramIndex) {
/*  806 */     ArrayList<Index> arrayList = getIndexes();
/*  807 */     if (arrayList != null) {
/*  808 */       remove((ArrayList)arrayList, (DbObject)paramIndex);
/*  809 */       if (paramIndex.getIndexType().isPrimaryKey()) {
/*  810 */         for (Column column : paramIndex.getColumns()) {
/*  811 */           column.setPrimaryKey(false);
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeView(TableView paramTableView) {
/*  823 */     remove((ArrayList)this.views, (DbObject)paramTableView);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeConstraint(Constraint paramConstraint) {
/*  832 */     remove((ArrayList)this.constraints, (DbObject)paramConstraint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void removeSequence(Sequence paramSequence) {
/*  841 */     remove((ArrayList)this.sequences, (DbObject)paramSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeTrigger(TriggerObject paramTriggerObject) {
/*  850 */     remove((ArrayList)this.triggers, (DbObject)paramTriggerObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addView(TableView paramTableView) {
/*  859 */     this.views = add(this.views, paramTableView);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addConstraint(Constraint paramConstraint) {
/*  868 */     if (this.constraints == null || this.constraints.indexOf(paramConstraint) < 0) {
/*  869 */       this.constraints = add(this.constraints, paramConstraint);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Constraint> getConstraints() {
/*  874 */     return this.constraints;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSequence(Sequence paramSequence) {
/*  883 */     this.sequences = add(this.sequences, paramSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTrigger(TriggerObject paramTriggerObject) {
/*  892 */     this.triggers = add(this.triggers, paramTriggerObject);
/*      */   }
/*      */   
/*      */   private static <T> ArrayList<T> add(ArrayList<T> paramArrayList, T paramT) {
/*  896 */     if (paramArrayList == null) {
/*  897 */       paramArrayList = New.arrayList();
/*      */     }
/*      */     
/*  900 */     paramArrayList.add(paramT);
/*  901 */     return paramArrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fire(Session paramSession, int paramInt, boolean paramBoolean) {
/*  912 */     if (this.triggers != null) {
/*  913 */       for (TriggerObject triggerObject : this.triggers) {
/*  914 */         triggerObject.fire(paramSession, paramInt, paramBoolean);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasSelectTrigger() {
/*  925 */     if (this.triggers != null) {
/*  926 */       for (TriggerObject triggerObject : this.triggers) {
/*  927 */         if (triggerObject.isSelectTrigger()) {
/*  928 */           return true;
/*      */         }
/*      */       } 
/*      */     }
/*  932 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean fireRow() {
/*  942 */     return ((this.constraints != null && this.constraints.size() > 0) || (this.triggers != null && this.triggers.size() > 0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean fireBeforeRow(Session paramSession, Row paramRow1, Row paramRow2) {
/*  955 */     boolean bool = fireRow(paramSession, paramRow1, paramRow2, true, false);
/*  956 */     fireConstraints(paramSession, paramRow1, paramRow2, true);
/*  957 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private void fireConstraints(Session paramSession, Row paramRow1, Row paramRow2, boolean paramBoolean) {
/*  962 */     if (this.constraints != null) {
/*      */       byte b; int i;
/*  964 */       for (b = 0, i = this.constraints.size(); b < i; b++) {
/*  965 */         Constraint constraint = this.constraints.get(b);
/*  966 */         if (constraint.isBefore() == paramBoolean) {
/*  967 */           constraint.checkRow(paramSession, this, paramRow1, paramRow2);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fireAfterRow(Session paramSession, Row paramRow1, Row paramRow2, boolean paramBoolean) {
/*  983 */     fireRow(paramSession, paramRow1, paramRow2, false, paramBoolean);
/*  984 */     if (!paramBoolean) {
/*  985 */       fireConstraints(paramSession, paramRow1, paramRow2, false);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean fireRow(Session paramSession, Row paramRow1, Row paramRow2, boolean paramBoolean1, boolean paramBoolean2) {
/*  991 */     if (this.triggers != null) {
/*  992 */       for (TriggerObject triggerObject : this.triggers) {
/*  993 */         boolean bool = triggerObject.fireRow(paramSession, paramRow1, paramRow2, paramBoolean1, paramBoolean2);
/*  994 */         if (bool) {
/*  995 */           return true;
/*      */         }
/*      */       } 
/*      */     }
/*  999 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isGlobalTemporary() {
/* 1003 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canTruncate() {
/* 1012 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCheckForeignKeyConstraints(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/* 1025 */     if (paramBoolean1 && paramBoolean2 && 
/* 1026 */       this.constraints != null) {
/* 1027 */       for (Constraint constraint : this.constraints) {
/* 1028 */         constraint.checkExistingData(paramSession);
/*      */       }
/*      */     }
/*      */     
/* 1032 */     this.checkForeignKeyConstraints = paramBoolean1;
/*      */   }
/*      */   
/*      */   public boolean getCheckForeignKeyConstraints() {
/* 1036 */     return this.checkForeignKeyConstraints;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Index getIndexForColumn(Column paramColumn) {
/* 1047 */     ArrayList<Index> arrayList = getIndexes();
/* 1048 */     if (arrayList != null) {
/* 1049 */       byte b; int i; for (b = 1, i = arrayList.size(); b < i; b++) {
/* 1050 */         Index index = arrayList.get(b);
/* 1051 */         if (index.canGetFirstOrLast()) {
/* 1052 */           int j = index.getColumnIndex(paramColumn);
/* 1053 */           if (j == 0) {
/* 1054 */             return index;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 1059 */     return null;
/*      */   }
/*      */   
/*      */   public boolean getOnCommitDrop() {
/* 1063 */     return this.onCommitDrop;
/*      */   }
/*      */   
/*      */   public void setOnCommitDrop(boolean paramBoolean) {
/* 1067 */     this.onCommitDrop = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean getOnCommitTruncate() {
/* 1071 */     return this.onCommitTruncate;
/*      */   }
/*      */   
/*      */   public void setOnCommitTruncate(boolean paramBoolean) {
/* 1075 */     this.onCommitTruncate = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeIndexOrTransferOwnership(Session paramSession, Index paramIndex) {
/* 1086 */     boolean bool = false;
/* 1087 */     if (this.constraints != null) {
/* 1088 */       for (Constraint constraint : this.constraints) {
/* 1089 */         if (constraint.usesIndex(paramIndex)) {
/* 1090 */           constraint.setIndexOwner(paramIndex);
/* 1091 */           this.database.updateMeta(paramSession, (DbObject)constraint);
/* 1092 */           bool = true;
/*      */         } 
/*      */       } 
/*      */     }
/* 1096 */     if (!bool) {
/* 1097 */       this.database.removeSchemaObject(paramSession, (SchemaObject)paramIndex);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<Session> checkDeadlock(Session paramSession1, Session paramSession2, Set<Session> paramSet) {
/* 1119 */     return null;
/*      */   }
/*      */   
/*      */   public boolean isPersistIndexes() {
/* 1123 */     return this.persistIndexes;
/*      */   }
/*      */   
/*      */   public boolean isPersistData() {
/* 1127 */     return this.persistData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int compareTypeSafe(Value paramValue1, Value paramValue2) {
/* 1140 */     if (paramValue1 == paramValue2) {
/* 1141 */       return 0;
/*      */     }
/* 1143 */     int i = Value.getHigherOrder(paramValue1.getType(), paramValue2.getType());
/* 1144 */     paramValue1 = paramValue1.convertTo(i);
/* 1145 */     paramValue2 = paramValue2.convertTo(i);
/* 1146 */     return paramValue1.compareTypeSafe(paramValue2, this.compareMode);
/*      */   }
/*      */   
/*      */   public CompareMode getCompareMode() {
/* 1150 */     return this.compareMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkWritingAllowed() {
/* 1159 */     this.database.checkWritingAllowed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Value getDefaultValue(Session paramSession, Column paramColumn) {
/*      */     Value value;
/* 1170 */     Expression expression = paramColumn.getDefaultExpression();
/*      */     
/* 1172 */     if (expression == null) {
/* 1173 */       value = paramColumn.validateConvertUpdateSequence(paramSession, null);
/*      */     } else {
/* 1175 */       value = expression.getValue(paramSession);
/*      */     } 
/* 1177 */     return paramColumn.convert(value);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isHidden() {
/* 1182 */     return this.isHidden;
/*      */   }
/*      */   
/*      */   public void setHidden(boolean paramBoolean) {
/* 1186 */     this.isHidden = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isMVStore() {
/* 1190 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\Table.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */