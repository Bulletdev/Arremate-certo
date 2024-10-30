/*     */ package org.h2.table;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.index.RangeIndex;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Schema;
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
/*     */ public class RangeTable
/*     */   extends Table
/*     */ {
/*     */   public static final String NAME = "SYSTEM_RANGE";
/*     */   public static final String ALIAS = "GENERATE_SERIES";
/*     */   private Expression min;
/*     */   private Expression max;
/*     */   private Expression step;
/*     */   private boolean optimized;
/*     */   
/*     */   public RangeTable(Schema paramSchema, Expression paramExpression1, Expression paramExpression2, boolean paramBoolean) {
/*  50 */     super(paramSchema, 0, "SYSTEM_RANGE", true, true);
/*  51 */     (new Column[1])[0] = new Column("X", 5); Column[] arrayOfColumn = paramBoolean ? new Column[0] : new Column[1];
/*     */     
/*  53 */     this.min = paramExpression1;
/*  54 */     this.max = paramExpression2;
/*  55 */     setColumns(arrayOfColumn);
/*     */   }
/*     */ 
/*     */   
/*     */   public RangeTable(Schema paramSchema, Expression paramExpression1, Expression paramExpression2, Expression paramExpression3, boolean paramBoolean) {
/*  60 */     this(paramSchema, paramExpression1, paramExpression2, paramBoolean);
/*  61 */     this.step = paramExpression3;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  76 */     String str = "SYSTEM_RANGE(" + this.min.getSQL() + ", " + this.max.getSQL();
/*  77 */     if (this.step != null) {
/*  78 */       str = str + ", " + this.step.getSQL();
/*     */     }
/*  80 */     return str + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void unlock(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusively() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/* 108 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRow(Session paramSession, Row paramRow) {
/* 113 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Session paramSession, Row paramRow) {
/* 118 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkSupportAlter() {
/* 123 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 128 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetRowCount() {
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/* 138 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 143 */     return Math.max(0L, getMax(paramSession) - getMin(paramSession) + 1L);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableType() {
/* 148 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession) {
/* 153 */     if (getStep(paramSession) == 0L) {
/* 154 */       throw DbException.get(90142);
/*     */     }
/* 156 */     return (Index)new RangeIndex(this, IndexColumn.wrap(this.columns));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMin(Session paramSession) {
/* 166 */     optimize(paramSession);
/* 167 */     return this.min.getValue(paramSession).getLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMax(Session paramSession) {
/* 177 */     optimize(paramSession);
/* 178 */     return this.max.getValue(paramSession).getLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getStep(Session paramSession) {
/* 188 */     optimize(paramSession);
/* 189 */     if (this.step == null) {
/* 190 */       return 1L;
/*     */     }
/* 192 */     return this.step.getValue(paramSession).getLong();
/*     */   }
/*     */   
/*     */   private void optimize(Session paramSession) {
/* 196 */     if (!this.optimized) {
/* 197 */       this.min = this.min.optimize(paramSession);
/* 198 */       this.max = this.max.optimize(paramSession);
/* 199 */       if (this.step != null) {
/* 200 */         this.step = this.step.optimize(paramSession);
/*     */       }
/* 202 */       this.optimized = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Index> getIndexes() {
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 213 */     throw DbException.getUnsupportedException("SYSTEM_RANGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 218 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 223 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 228 */     return 100L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 233 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canReference() {
/* 243 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\RangeTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */