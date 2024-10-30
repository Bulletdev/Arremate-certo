/*     */ package org.h2.constraint;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConstraintCheck
/*     */   extends Constraint
/*     */ {
/*     */   private TableFilter filter;
/*     */   private Expression expr;
/*     */   
/*     */   public ConstraintCheck(Schema paramSchema, int paramInt, String paramString, Table paramTable) {
/*  35 */     super(paramSchema, paramInt, paramString, paramTable);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getConstraintType() {
/*  40 */     return "CHECK";
/*     */   }
/*     */   
/*     */   public void setTableFilter(TableFilter paramTableFilter) {
/*  44 */     this.filter = paramTableFilter;
/*     */   }
/*     */   
/*     */   public void setExpression(Expression paramExpression) {
/*  48 */     this.expr = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  53 */     StringBuilder stringBuilder = new StringBuilder("ALTER TABLE ");
/*  54 */     stringBuilder.append(paramTable.getSQL()).append(" ADD CONSTRAINT ");
/*  55 */     if (paramTable.isHidden()) {
/*  56 */       stringBuilder.append("IF NOT EXISTS ");
/*     */     }
/*  58 */     stringBuilder.append(paramString);
/*  59 */     if (this.comment != null) {
/*  60 */       stringBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/*  62 */     stringBuilder.append(" CHECK").append(StringUtils.enclose(this.expr.getSQL())).append(" NOCHECK");
/*     */     
/*  64 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String getShortDescription() {
/*  68 */     return getName() + ": " + this.expr.getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLWithoutIndexes() {
/*  73 */     return getCreateSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  78 */     return getCreateSQLForCopy(this.table, getSQL());
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/*  83 */     this.table.removeConstraint(this);
/*  84 */     this.database.removeMeta(paramSession, getId());
/*  85 */     this.filter = null;
/*  86 */     this.expr = null;
/*  87 */     this.table = null;
/*  88 */     invalidate();
/*     */   }
/*     */   
/*     */   public void checkRow(Session paramSession, Table paramTable, Row paramRow1, Row paramRow2) {
/*     */     Boolean bool;
/*  93 */     if (paramRow2 == null) {
/*     */       return;
/*     */     }
/*  96 */     this.filter.set(paramRow2);
/*     */     
/*     */     try {
/*  99 */       bool = this.expr.getValue(paramSession).getBoolean();
/* 100 */     } catch (DbException dbException) {
/* 101 */       throw DbException.get(23514, dbException, new String[] { getShortDescription() });
/*     */     } 
/*     */ 
/*     */     
/* 105 */     if (Boolean.FALSE.equals(bool)) {
/* 106 */       throw DbException.get(23513, getShortDescription());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesIndex(Index paramIndex) {
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIndexOwner(Index paramIndex) {
/* 118 */     DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public HashSet<Column> getReferencedColumns(Table paramTable) {
/* 123 */     HashSet<Column> hashSet = New.hashSet();
/* 124 */     this.expr.isEverything(ExpressionVisitor.getColumnsVisitor(hashSet));
/* 125 */     for (Iterator<Column> iterator = hashSet.iterator(); iterator.hasNext();) {
/* 126 */       if (((Column)iterator.next()).getTable() != paramTable) {
/* 127 */         iterator.remove();
/*     */       }
/*     */     } 
/* 130 */     return hashSet;
/*     */   }
/*     */   
/*     */   public Expression getExpression() {
/* 134 */     return this.expr;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBefore() {
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkExistingData(Session paramSession) {
/* 144 */     if (paramSession.getDatabase().isStarting()) {
/*     */       return;
/*     */     }
/*     */     
/* 148 */     String str = "SELECT 1 FROM " + this.filter.getTable().getSQL() + " WHERE NOT(" + this.expr.getSQL() + ")";
/*     */     
/* 150 */     ResultInterface resultInterface = paramSession.prepare(str).query(1);
/* 151 */     if (resultInterface.next()) {
/* 152 */       throw DbException.get(23513, getName());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rebuild() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 168 */     return this.expr.isEverything(paramExpressionVisitor);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\constraint\ConstraintCheck.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */