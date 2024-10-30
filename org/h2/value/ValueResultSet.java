/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.tools.SimpleResultSet;
/*     */ import org.h2.util.StatementBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueResultSet
/*     */   extends Value
/*     */ {
/*     */   private final ResultSet result;
/*     */   
/*     */   private ValueResultSet(ResultSet paramResultSet) {
/*  24 */     this.result = paramResultSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueResultSet get(ResultSet paramResultSet) {
/*  35 */     return new ValueResultSet(paramResultSet);
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
/*     */   public static ValueResultSet getCopy(ResultSet paramResultSet, int paramInt) {
/*     */     try {
/*  50 */       ResultSetMetaData resultSetMetaData = paramResultSet.getMetaData();
/*  51 */       int i = resultSetMetaData.getColumnCount();
/*  52 */       SimpleResultSet simpleResultSet = new SimpleResultSet();
/*  53 */       simpleResultSet.setAutoClose(false);
/*  54 */       ValueResultSet valueResultSet = new ValueResultSet((ResultSet)simpleResultSet); byte b;
/*  55 */       for (b = 0; b < i; b++) {
/*  56 */         String str = resultSetMetaData.getColumnLabel(b + 1);
/*  57 */         int j = resultSetMetaData.getColumnType(b + 1);
/*  58 */         int k = resultSetMetaData.getPrecision(b + 1);
/*  59 */         int m = resultSetMetaData.getScale(b + 1);
/*  60 */         simpleResultSet.addColumn(str, j, k, m);
/*     */       } 
/*  62 */       for (b = 0; b < paramInt && paramResultSet.next(); b++) {
/*  63 */         Object[] arrayOfObject = new Object[i];
/*  64 */         for (byte b1 = 0; b1 < i; b1++) {
/*  65 */           arrayOfObject[b1] = paramResultSet.getObject(b1 + 1);
/*     */         }
/*  67 */         simpleResultSet.addRow(arrayOfObject);
/*     */       } 
/*  69 */       return valueResultSet;
/*  70 */     } catch (SQLException sQLException) {
/*  71 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  77 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  82 */     return 2147483647L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  88 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/*     */     try {
/*  94 */       StatementBuilder statementBuilder = new StatementBuilder("(");
/*  95 */       this.result.beforeFirst();
/*  96 */       ResultSetMetaData resultSetMetaData = this.result.getMetaData();
/*  97 */       int i = resultSetMetaData.getColumnCount();
/*  98 */       for (byte b = 0; this.result.next(); b++) {
/*  99 */         if (b) {
/* 100 */           statementBuilder.append(", ");
/*     */         }
/* 102 */         statementBuilder.append('(');
/* 103 */         statementBuilder.resetCount();
/* 104 */         for (byte b1 = 0; b1 < i; b1++) {
/* 105 */           statementBuilder.appendExceptFirst(", ");
/* 106 */           int j = DataType.getValueTypeFromResultSet(resultSetMetaData, b1 + 1);
/* 107 */           Value value = DataType.readValue(null, this.result, b1 + 1, j);
/* 108 */           statementBuilder.append(value.getString());
/*     */         } 
/* 110 */         statementBuilder.append(')');
/*     */       } 
/* 112 */       this.result.beforeFirst();
/* 113 */       return statementBuilder.append(')').toString();
/* 114 */     } catch (SQLException sQLException) {
/* 115 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 121 */     return (this == paramValue) ? 0 : toString().compareTo(paramValue.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 126 */     return (paramObject == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 136 */     return this.result;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultSet getResultSet() {
/* 141 */     return this.result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) {
/* 146 */     throw throwUnsupportedExceptionForType("PreparedStatement.set");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 151 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/* 156 */     if (!paramBoolean) {
/* 157 */       return this;
/*     */     }
/* 159 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 160 */     simpleResultSet.setAutoClose(false);
/* 161 */     return get((ResultSet)simpleResultSet);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueResultSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */