/*     */ package org.h2.table;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.FunctionCall;
/*     */ import org.h2.expression.TableFunction;
/*     */ import org.h2.index.FunctionIndex;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueResultSet;
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
/*     */ public class FunctionTable
/*     */   extends Table
/*     */ {
/*     */   private final FunctionCall function;
/*     */   private final long rowCount;
/*     */   private Expression functionExpr;
/*     */   private LocalResult cachedResult;
/*     */   private Value cachedValue;
/*     */   
/*     */   public FunctionTable(Schema paramSchema, Session paramSession, Expression paramExpression, FunctionCall paramFunctionCall) {
/*  45 */     super(paramSchema, 0, paramFunctionCall.getName(), false, true);
/*  46 */     this.functionExpr = paramExpression;
/*  47 */     this.function = paramFunctionCall;
/*  48 */     if (paramFunctionCall instanceof TableFunction) {
/*  49 */       this.rowCount = ((TableFunction)paramFunctionCall).getRowCount();
/*     */     } else {
/*  51 */       this.rowCount = Long.MAX_VALUE;
/*     */     } 
/*  53 */     paramFunctionCall.optimize(paramSession);
/*  54 */     int i = paramFunctionCall.getType();
/*  55 */     if (i != 18) {
/*  56 */       throw DbException.get(90000, paramFunctionCall.getName());
/*     */     }
/*     */     
/*  59 */     Expression[] arrayOfExpression1 = paramFunctionCall.getArgs();
/*  60 */     int j = arrayOfExpression1.length;
/*  61 */     Expression[] arrayOfExpression2 = new Expression[j];
/*  62 */     for (byte b = 0; b < j; b++) {
/*  63 */       arrayOfExpression1[b] = arrayOfExpression1[b].optimize(paramSession);
/*  64 */       arrayOfExpression2[b] = arrayOfExpression1[b];
/*     */     } 
/*  66 */     ValueResultSet valueResultSet = paramFunctionCall.getValueForColumnList(paramSession, arrayOfExpression2);
/*     */     
/*  68 */     if (valueResultSet == null) {
/*  69 */       throw DbException.get(90000, paramFunctionCall.getName());
/*     */     }
/*     */     
/*  72 */     ResultSet resultSet = valueResultSet.getResultSet();
/*     */     try {
/*  74 */       ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/*  75 */       int k = resultSetMetaData.getColumnCount();
/*  76 */       Column[] arrayOfColumn = new Column[k];
/*  77 */       for (byte b1 = 0; b1 < k; b1++) {
/*  78 */         arrayOfColumn[b1] = new Column(resultSetMetaData.getColumnName(b1 + 1), DataType.getValueTypeFromResultSet(resultSetMetaData, b1 + 1), resultSetMetaData.getPrecision(b1 + 1), resultSetMetaData.getScale(b1 + 1), resultSetMetaData.getColumnDisplaySize(b1 + 1));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  83 */       setColumns(arrayOfColumn);
/*  84 */     } catch (SQLException sQLException) {
/*  85 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/*  92 */     return false;
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
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/* 114 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRow(Session paramSession, Row paramRow) {
/* 119 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 124 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/* 129 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Session paramSession, Row paramRow) {
/* 134 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkSupportAlter() {
/* 139 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableType() {
/* 144 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession) {
/* 149 */     return (Index)new FunctionIndex(this, IndexColumn.wrap(this.columns));
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Index> getIndexes() {
/* 154 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetRowCount() {
/* 159 */     return (this.rowCount != Long.MAX_VALUE);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 164 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 179 */     throw DbException.getUnsupportedException("ALIAS");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultInterface getResult(Session paramSession) {
/* 190 */     ValueResultSet valueResultSet = getValueResultSet(paramSession);
/* 191 */     if (valueResultSet == null) {
/* 192 */       return null;
/*     */     }
/* 194 */     if (this.cachedResult != null && this.cachedValue == valueResultSet) {
/* 195 */       this.cachedResult.reset();
/* 196 */       return (ResultInterface)this.cachedResult;
/*     */     } 
/* 198 */     LocalResult localResult = LocalResult.read(paramSession, valueResultSet.getResultSet(), 0);
/* 199 */     if (this.function.isDeterministic()) {
/* 200 */       this.cachedResult = localResult;
/* 201 */       this.cachedValue = (Value)valueResultSet;
/*     */     } 
/* 203 */     return (ResultInterface)localResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet getResultSet(Session paramSession) {
/* 213 */     ValueResultSet valueResultSet = getValueResultSet(paramSession);
/* 214 */     return (valueResultSet == null) ? null : valueResultSet.getResultSet();
/*     */   }
/*     */   
/*     */   private ValueResultSet getValueResultSet(Session paramSession) {
/* 218 */     this.functionExpr = this.functionExpr.optimize(paramSession);
/* 219 */     Value value = this.functionExpr.getValue(paramSession);
/* 220 */     if (value == ValueNull.INSTANCE) {
/* 221 */       return null;
/*     */     }
/* 223 */     return (ValueResultSet)value;
/*     */   }
/*     */   
/*     */   public boolean isBufferResultSetToLocalTemp() {
/* 227 */     return this.function.isBufferResultSetToLocalTemp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 234 */     return Long.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 239 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 244 */     return this.function.getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 249 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 254 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 259 */     return this.function.isDeterministic();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canReference() {
/* 264 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\FunctionTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */