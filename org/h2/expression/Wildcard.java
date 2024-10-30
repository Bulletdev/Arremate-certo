/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Value;
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
/*     */ public class Wildcard
/*     */   extends Expression
/*     */ {
/*     */   private final String schema;
/*     */   private final String table;
/*     */   
/*     */   public Wildcard(String paramString1, String paramString2) {
/*  26 */     this.schema = paramString1;
/*  27 */     this.table = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWildcard() {
/*  32 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  37 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  42 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  47 */     throw DbException.get(42000, this.table);
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  52 */     throw DbException.get(42000, this.table);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/*  57 */     DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  62 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  67 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  72 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableAlias() {
/*  77 */     return this.table;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSchemaName() {
/*  82 */     return this.schema;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  87 */     if (this.table == null) {
/*  88 */       return "*";
/*     */     }
/*  90 */     return StringUtils.quoteIdentifier(this.table) + ".*";
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/*  95 */     DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 100 */     if (paramExpressionVisitor.getType() == 8) {
/* 101 */       return true;
/*     */     }
/* 103 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 108 */     throw DbException.throwInternalError();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Wildcard.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */