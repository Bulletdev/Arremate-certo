/*     */ package org.h2.constraint;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
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
/*     */ public class ConstraintUnique
/*     */   extends Constraint
/*     */ {
/*     */   private Index index;
/*     */   private boolean indexOwner;
/*     */   private IndexColumn[] columns;
/*     */   private final boolean primaryKey;
/*     */   
/*     */   public ConstraintUnique(Schema paramSchema, int paramInt, String paramString, Table paramTable, boolean paramBoolean) {
/*  33 */     super(paramSchema, paramInt, paramString, paramTable);
/*  34 */     this.primaryKey = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getConstraintType() {
/*  39 */     return this.primaryKey ? "PRIMARY KEY" : "UNIQUE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  44 */     return getCreateSQLForCopy(paramTable, paramString, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private String getCreateSQLForCopy(Table paramTable, String paramString, boolean paramBoolean) {
/*  49 */     StatementBuilder statementBuilder = new StatementBuilder("ALTER TABLE ");
/*  50 */     statementBuilder.append(paramTable.getSQL()).append(" ADD CONSTRAINT ");
/*  51 */     if (paramTable.isHidden()) {
/*  52 */       statementBuilder.append("IF NOT EXISTS ");
/*     */     }
/*  54 */     statementBuilder.append(paramString);
/*  55 */     if (this.comment != null) {
/*  56 */       statementBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/*  58 */     statementBuilder.append(' ').append(getTypeName()).append('(');
/*  59 */     for (IndexColumn indexColumn : this.columns) {
/*  60 */       statementBuilder.appendExceptFirst(", ");
/*  61 */       statementBuilder.append(Parser.quoteIdentifier(indexColumn.column.getName()));
/*     */     } 
/*  63 */     statementBuilder.append(')');
/*  64 */     if (paramBoolean && this.indexOwner && paramTable == this.table) {
/*  65 */       statementBuilder.append(" INDEX ").append(this.index.getSQL());
/*     */     }
/*  67 */     return statementBuilder.toString();
/*     */   }
/*     */   
/*     */   private String getTypeName() {
/*  71 */     if (this.primaryKey) {
/*  72 */       return "PRIMARY KEY";
/*     */     }
/*  74 */     return "UNIQUE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLWithoutIndexes() {
/*  79 */     return getCreateSQLForCopy(this.table, getSQL(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  84 */     return getCreateSQLForCopy(this.table, getSQL());
/*     */   }
/*     */   
/*     */   public void setColumns(IndexColumn[] paramArrayOfIndexColumn) {
/*  88 */     this.columns = paramArrayOfIndexColumn;
/*     */   }
/*     */   
/*     */   public IndexColumn[] getColumns() {
/*  92 */     return this.columns;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndex(Index paramIndex, boolean paramBoolean) {
/* 103 */     this.index = paramIndex;
/* 104 */     this.indexOwner = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 109 */     this.table.removeConstraint(this);
/* 110 */     if (this.indexOwner) {
/* 111 */       this.table.removeIndexOrTransferOwnership(paramSession, this.index);
/*     */     }
/* 113 */     this.database.removeMeta(paramSession, getId());
/* 114 */     this.index = null;
/* 115 */     this.columns = null;
/* 116 */     this.table = null;
/* 117 */     invalidate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRow(Session paramSession, Table paramTable, Row paramRow1, Row paramRow2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesIndex(Index paramIndex) {
/* 127 */     return (paramIndex == this.index);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIndexOwner(Index paramIndex) {
/* 132 */     this.indexOwner = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public HashSet<Column> getReferencedColumns(Table paramTable) {
/* 137 */     HashSet<Column> hashSet = New.hashSet();
/* 138 */     for (IndexColumn indexColumn : this.columns) {
/* 139 */       hashSet.add(indexColumn.column);
/*     */     }
/* 141 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBefore() {
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkExistingData(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 157 */     return this.index;
/*     */   }
/*     */   
/*     */   public void rebuild() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\constraint\ConstraintUnique.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */