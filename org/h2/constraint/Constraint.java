/*     */ package org.h2.constraint;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObjectBase;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
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
/*     */ public abstract class Constraint
/*     */   extends SchemaObjectBase
/*     */   implements Comparable<Constraint>
/*     */ {
/*     */   public static final String CHECK = "CHECK";
/*     */   public static final String REFERENTIAL = "REFERENTIAL";
/*     */   public static final String UNIQUE = "UNIQUE";
/*     */   public static final String PRIMARY_KEY = "PRIMARY KEY";
/*     */   protected Table table;
/*     */   
/*     */   Constraint(Schema paramSchema, int paramInt, String paramString, Table paramTable) {
/*  53 */     initSchemaObjectBase(paramSchema, paramInt, paramString, 1);
/*  54 */     this.table = paramTable;
/*  55 */     setTemporary(paramTable.isTemporary());
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
/*     */   public void checkRename() {}
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
/*     */   public int getType() {
/* 142 */     return 5;
/*     */   }
/*     */   
/*     */   public Table getTable() {
/* 146 */     return this.table;
/*     */   }
/*     */   
/*     */   public Table getRefTable() {
/* 150 */     return this.table;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 155 */     return null;
/*     */   }
/*     */   
/*     */   private int getConstraintTypeOrder() {
/* 159 */     String str = getConstraintType();
/* 160 */     if ("CHECK".equals(str))
/* 161 */       return 0; 
/* 162 */     if ("PRIMARY KEY".equals(str))
/* 163 */       return 1; 
/* 164 */     if ("UNIQUE".equals(str))
/* 165 */       return 2; 
/* 166 */     if ("REFERENTIAL".equals(str)) {
/* 167 */       return 3;
/*     */     }
/* 169 */     throw DbException.throwInternalError("type: " + str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Constraint paramConstraint) {
/* 175 */     if (this == paramConstraint) {
/* 176 */       return 0;
/*     */     }
/* 178 */     int i = getConstraintTypeOrder();
/* 179 */     int j = paramConstraint.getConstraintTypeOrder();
/* 180 */     return i - j;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHidden() {
/* 185 */     return this.table.isHidden();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 196 */     return true;
/*     */   }
/*     */   
/*     */   public abstract String getConstraintType();
/*     */   
/*     */   public abstract void checkRow(Session paramSession, Table paramTable, Row paramRow1, Row paramRow2);
/*     */   
/*     */   public abstract boolean usesIndex(Index paramIndex);
/*     */   
/*     */   public abstract void setIndexOwner(Index paramIndex);
/*     */   
/*     */   public abstract HashSet<Column> getReferencedColumns(Table paramTable);
/*     */   
/*     */   public abstract String getCreateSQLWithoutIndexes();
/*     */   
/*     */   public abstract boolean isBefore();
/*     */   
/*     */   public abstract void checkExistingData(Session paramSession);
/*     */   
/*     */   public abstract void rebuild();
/*     */   
/*     */   public abstract Index getUniqueIndex();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\constraint\Constraint.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */