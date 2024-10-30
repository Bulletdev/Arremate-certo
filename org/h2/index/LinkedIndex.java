/*     */ package org.h2.index;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.table.TableLink;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
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
/*     */ public class LinkedIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private final TableLink link;
/*     */   private final String targetTableName;
/*     */   private long rowCount;
/*     */   
/*     */   public LinkedIndex(TableLink paramTableLink, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  39 */     initBaseIndex((Table)paramTableLink, paramInt, null, paramArrayOfIndexColumn, paramIndexType);
/*  40 */     this.link = paramTableLink;
/*  41 */     this.targetTableName = this.link.getQualifiedTable();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */   
/*     */   private static boolean isNull(Value paramValue) {
/*  55 */     return (paramValue == null || paramValue == ValueNull.INSTANCE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  60 */     ArrayList<Value> arrayList = New.arrayList();
/*  61 */     StatementBuilder statementBuilder = new StatementBuilder("INSERT INTO ");
/*  62 */     statementBuilder.append(this.targetTableName).append(" VALUES(");
/*  63 */     for (byte b = 0; b < paramRow.getColumnCount(); b++) {
/*  64 */       Value value = paramRow.getValue(b);
/*  65 */       statementBuilder.appendExceptFirst(", ");
/*  66 */       if (value == null) {
/*  67 */         statementBuilder.append("DEFAULT");
/*  68 */       } else if (isNull(value)) {
/*  69 */         statementBuilder.append("NULL");
/*     */       } else {
/*  71 */         statementBuilder.append('?');
/*  72 */         arrayList.add(value);
/*     */       } 
/*     */     } 
/*  75 */     statementBuilder.append(')');
/*  76 */     String str = statementBuilder.toString();
/*     */     try {
/*  78 */       this.link.execute(str, arrayList, true);
/*  79 */       this.rowCount++;
/*  80 */     } catch (Exception exception) {
/*  81 */       throw TableLink.wrapException(str, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  87 */     ArrayList<Value> arrayList = New.arrayList();
/*  88 */     StatementBuilder statementBuilder = new StatementBuilder("SELECT * FROM ");
/*  89 */     statementBuilder.append(this.targetTableName).append(" T"); byte b;
/*  90 */     for (b = 0; paramSearchRow1 != null && b < paramSearchRow1.getColumnCount(); b++) {
/*  91 */       Value value = paramSearchRow1.getValue(b);
/*  92 */       if (value != null) {
/*  93 */         statementBuilder.appendOnlyFirst(" WHERE ");
/*  94 */         statementBuilder.appendExceptFirst(" AND ");
/*  95 */         Column column = this.table.getColumn(b);
/*  96 */         statementBuilder.append(column.getSQL());
/*  97 */         if (value == ValueNull.INSTANCE) {
/*  98 */           statementBuilder.append(" IS NULL");
/*     */         } else {
/* 100 */           statementBuilder.append(">=");
/* 101 */           addParameter(statementBuilder, column);
/* 102 */           arrayList.add(value);
/*     */         } 
/*     */       } 
/*     */     } 
/* 106 */     for (b = 0; paramSearchRow2 != null && b < paramSearchRow2.getColumnCount(); b++) {
/* 107 */       Value value = paramSearchRow2.getValue(b);
/* 108 */       if (value != null) {
/* 109 */         statementBuilder.appendOnlyFirst(" WHERE ");
/* 110 */         statementBuilder.appendExceptFirst(" AND ");
/* 111 */         Column column = this.table.getColumn(b);
/* 112 */         statementBuilder.append(column.getSQL());
/* 113 */         if (value == ValueNull.INSTANCE) {
/* 114 */           statementBuilder.append(" IS NULL");
/*     */         } else {
/* 116 */           statementBuilder.append("<=");
/* 117 */           addParameter(statementBuilder, column);
/* 118 */           arrayList.add(value);
/*     */         } 
/*     */       } 
/*     */     } 
/* 122 */     String str = statementBuilder.toString();
/*     */     try {
/* 124 */       PreparedStatement preparedStatement = this.link.execute(str, arrayList, false);
/* 125 */       ResultSet resultSet = preparedStatement.getResultSet();
/* 126 */       return new LinkedCursor(this.link, resultSet, paramSession, str, preparedStatement);
/* 127 */     } catch (Exception exception) {
/* 128 */       throw TableLink.wrapException(str, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addParameter(StatementBuilder paramStatementBuilder, Column paramColumn) {
/* 133 */     if (paramColumn.getType() == 21 && this.link.isOracle()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       paramStatementBuilder.append("CAST(? AS CHAR(").append(paramColumn.getPrecision()).append("))");
/*     */     } else {
/* 140 */       paramStatementBuilder.append('?');
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 148 */     return (100L + getCostRangeIndex(paramArrayOfint, this.rowCount + 1000L, paramArrayOfTableFilter, paramInt, paramSortOrder, false, paramHashSet));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 164 */     throw DbException.getUnsupportedException("LINKED");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 181 */     throw DbException.getUnsupportedException("LINKED");
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 186 */     ArrayList<Value> arrayList = New.arrayList();
/* 187 */     StatementBuilder statementBuilder = new StatementBuilder("DELETE FROM ");
/* 188 */     statementBuilder.append(this.targetTableName).append(" WHERE ");
/* 189 */     for (byte b = 0; b < paramRow.getColumnCount(); b++) {
/* 190 */       statementBuilder.appendExceptFirst("AND ");
/* 191 */       Column column = this.table.getColumn(b);
/* 192 */       statementBuilder.append(column.getSQL());
/* 193 */       Value value = paramRow.getValue(b);
/* 194 */       if (isNull(value)) {
/* 195 */         statementBuilder.append(" IS NULL ");
/*     */       } else {
/* 197 */         statementBuilder.append('=');
/* 198 */         addParameter(statementBuilder, column);
/* 199 */         arrayList.add(value);
/* 200 */         statementBuilder.append(' ');
/*     */       } 
/*     */     } 
/* 203 */     String str = statementBuilder.toString();
/*     */     try {
/* 205 */       PreparedStatement preparedStatement = this.link.execute(str, arrayList, false);
/* 206 */       int i = preparedStatement.executeUpdate();
/* 207 */       this.link.reusePreparedStatement(preparedStatement, str);
/* 208 */       this.rowCount -= i;
/* 209 */     } catch (Exception exception) {
/* 210 */       throw TableLink.wrapException(str, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Row paramRow1, Row paramRow2) {
/* 222 */     ArrayList<Value> arrayList = New.arrayList();
/* 223 */     StatementBuilder statementBuilder = new StatementBuilder("UPDATE ");
/* 224 */     statementBuilder.append(this.targetTableName).append(" SET "); byte b;
/* 225 */     for (b = 0; b < paramRow2.getColumnCount(); b++) {
/* 226 */       statementBuilder.appendExceptFirst(", ");
/* 227 */       statementBuilder.append(this.table.getColumn(b).getSQL()).append('=');
/* 228 */       Value value = paramRow2.getValue(b);
/* 229 */       if (value == null) {
/* 230 */         statementBuilder.append("DEFAULT");
/*     */       } else {
/* 232 */         statementBuilder.append('?');
/* 233 */         arrayList.add(value);
/*     */       } 
/*     */     } 
/* 236 */     statementBuilder.append(" WHERE ");
/* 237 */     statementBuilder.resetCount();
/* 238 */     for (b = 0; b < paramRow1.getColumnCount(); b++) {
/* 239 */       Column column = this.table.getColumn(b);
/* 240 */       statementBuilder.appendExceptFirst(" AND ");
/* 241 */       statementBuilder.append(column.getSQL());
/* 242 */       Value value = paramRow1.getValue(b);
/* 243 */       if (isNull(value)) {
/* 244 */         statementBuilder.append(" IS NULL");
/*     */       } else {
/* 246 */         statementBuilder.append('=');
/* 247 */         arrayList.add(value);
/* 248 */         addParameter(statementBuilder, column);
/*     */       } 
/*     */     } 
/* 251 */     String str = statementBuilder.toString();
/*     */     try {
/* 253 */       this.link.execute(str, arrayList, true);
/* 254 */     } catch (Exception exception) {
/* 255 */       throw TableLink.wrapException(str, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 261 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 266 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 271 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\LinkedIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */