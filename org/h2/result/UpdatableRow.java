/*     */ package org.h2.result;
/*     */ 
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
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
/*     */ public class UpdatableRow
/*     */ {
/*     */   private final JdbcConnection conn;
/*     */   private final ResultInterface result;
/*     */   private final int columnCount;
/*     */   private String schemaName;
/*     */   private String tableName;
/*     */   private ArrayList<String> key;
/*     */   private boolean isUpdatable;
/*     */   
/*     */   public UpdatableRow(JdbcConnection paramJdbcConnection, ResultInterface paramResultInterface) throws SQLException {
/*  47 */     this.conn = paramJdbcConnection;
/*  48 */     this.result = paramResultInterface;
/*  49 */     this.columnCount = paramResultInterface.getVisibleColumnCount();
/*  50 */     for (byte b = 0; b < this.columnCount; b++) {
/*  51 */       String str1 = paramResultInterface.getTableName(b);
/*  52 */       String str2 = paramResultInterface.getSchemaName(b);
/*  53 */       if (str1 == null || str2 == null) {
/*     */         return;
/*     */       }
/*  56 */       if (this.tableName == null) {
/*  57 */         this.tableName = str1;
/*  58 */       } else if (!this.tableName.equals(str1)) {
/*     */         return;
/*     */       } 
/*  61 */       if (this.schemaName == null) {
/*  62 */         this.schemaName = str2;
/*  63 */       } else if (!this.schemaName.equals(str2)) {
/*     */         return;
/*     */       } 
/*     */     } 
/*  67 */     DatabaseMetaData databaseMetaData = paramJdbcConnection.getMetaData();
/*  68 */     ResultSet resultSet = databaseMetaData.getTables(null, StringUtils.escapeMetaDataPattern(this.schemaName), StringUtils.escapeMetaDataPattern(this.tableName), new String[] { "TABLE" });
/*     */ 
/*     */ 
/*     */     
/*  72 */     if (!resultSet.next()) {
/*     */       return;
/*     */     }
/*  75 */     if (resultSet.getString("SQL") == null) {
/*     */       return;
/*     */     }
/*     */     
/*  79 */     String str = resultSet.getString("TABLE_NAME");
/*     */ 
/*     */ 
/*     */     
/*  83 */     boolean bool = (!str.equals(this.tableName) && str.equalsIgnoreCase(this.tableName)) ? true : false;
/*  84 */     this.key = New.arrayList();
/*  85 */     resultSet = databaseMetaData.getPrimaryKeys(null, StringUtils.escapeMetaDataPattern(this.schemaName), this.tableName);
/*     */ 
/*     */     
/*  88 */     while (resultSet.next()) {
/*  89 */       String str1 = resultSet.getString("COLUMN_NAME");
/*  90 */       this.key.add(bool ? StringUtils.toUpperEnglish(str1) : str1);
/*     */     } 
/*  92 */     if (isIndexUsable(this.key)) {
/*  93 */       this.isUpdatable = true;
/*     */       return;
/*     */     } 
/*  96 */     this.key.clear();
/*  97 */     resultSet = databaseMetaData.getIndexInfo(null, StringUtils.escapeMetaDataPattern(this.schemaName), this.tableName, true, true);
/*     */ 
/*     */     
/* 100 */     while (resultSet.next()) {
/* 101 */       short s = resultSet.getShort("ORDINAL_POSITION");
/* 102 */       if (s == 1) {
/*     */         
/* 104 */         if (isIndexUsable(this.key)) {
/* 105 */           this.isUpdatable = true;
/*     */           return;
/*     */         } 
/* 108 */         this.key.clear();
/*     */       } 
/* 110 */       String str1 = resultSet.getString("COLUMN_NAME");
/* 111 */       this.key.add(bool ? StringUtils.toUpperEnglish(str1) : str1);
/*     */     } 
/* 113 */     if (isIndexUsable(this.key)) {
/* 114 */       this.isUpdatable = true;
/*     */       return;
/*     */     } 
/* 117 */     this.key = null;
/*     */   }
/*     */   
/*     */   private boolean isIndexUsable(ArrayList<String> paramArrayList) {
/* 121 */     if (paramArrayList.size() == 0) {
/* 122 */       return false;
/*     */     }
/* 124 */     for (String str : paramArrayList) {
/* 125 */       if (findColumnIndex(str) < 0) {
/* 126 */         return false;
/*     */       }
/*     */     } 
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUpdatable() {
/* 138 */     return this.isUpdatable;
/*     */   }
/*     */   
/*     */   private int findColumnIndex(String paramString) {
/* 142 */     for (byte b = 0; b < this.columnCount; b++) {
/* 143 */       String str = this.result.getColumnName(b);
/* 144 */       if (str.equals(paramString)) {
/* 145 */         return b;
/*     */       }
/*     */     } 
/* 148 */     return -1;
/*     */   }
/*     */   
/*     */   private int getColumnIndex(String paramString) {
/* 152 */     int i = findColumnIndex(paramString);
/* 153 */     if (i < 0) {
/* 154 */       throw DbException.get(42122, paramString);
/*     */     }
/* 156 */     return i;
/*     */   }
/*     */   
/*     */   private void appendColumnList(StatementBuilder paramStatementBuilder, boolean paramBoolean) {
/* 160 */     paramStatementBuilder.resetCount();
/* 161 */     for (byte b = 0; b < this.columnCount; b++) {
/* 162 */       paramStatementBuilder.appendExceptFirst(",");
/* 163 */       String str = this.result.getColumnName(b);
/* 164 */       paramStatementBuilder.append(StringUtils.quoteIdentifier(str));
/* 165 */       if (paramBoolean) {
/* 166 */         paramStatementBuilder.append("=? ");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendKeyCondition(StatementBuilder paramStatementBuilder) {
/* 172 */     paramStatementBuilder.append(" WHERE ");
/* 173 */     paramStatementBuilder.resetCount();
/* 174 */     for (String str : this.key) {
/* 175 */       paramStatementBuilder.appendExceptFirst(" AND ");
/* 176 */       paramStatementBuilder.append(StringUtils.quoteIdentifier(str)).append("=?");
/*     */     } 
/*     */   }
/*     */   private void setKey(PreparedStatement paramPreparedStatement, int paramInt, Value[] paramArrayOfValue) throws SQLException {
/*     */     byte b;
/*     */     int i;
/* 182 */     for (b = 0, i = this.key.size(); b < i; b++) {
/* 183 */       String str = this.key.get(b);
/* 184 */       int j = getColumnIndex(str);
/* 185 */       Value value = paramArrayOfValue[j];
/* 186 */       if (value == null || value == ValueNull.INSTANCE)
/*     */       {
/*     */         
/* 189 */         throw DbException.get(2000);
/*     */       }
/* 191 */       value.set(paramPreparedStatement, paramInt + b);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendTableName(StatementBuilder paramStatementBuilder) {
/* 208 */     if (this.schemaName != null && this.schemaName.length() > 0) {
/* 209 */       paramStatementBuilder.append(StringUtils.quoteIdentifier(this.schemaName)).append('.');
/*     */     }
/* 211 */     paramStatementBuilder.append(StringUtils.quoteIdentifier(this.tableName));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value[] readRow(Value[] paramArrayOfValue) throws SQLException {
/* 221 */     StatementBuilder statementBuilder = new StatementBuilder("SELECT ");
/* 222 */     appendColumnList(statementBuilder, false);
/* 223 */     statementBuilder.append(" FROM ");
/* 224 */     appendTableName(statementBuilder);
/* 225 */     appendKeyCondition(statementBuilder);
/* 226 */     PreparedStatement preparedStatement = this.conn.prepareStatement(statementBuilder.toString());
/* 227 */     setKey(preparedStatement, 1, paramArrayOfValue);
/* 228 */     ResultSet resultSet = preparedStatement.executeQuery();
/* 229 */     if (!resultSet.next()) {
/* 230 */       throw DbException.get(2000);
/*     */     }
/* 232 */     Value[] arrayOfValue = new Value[this.columnCount];
/* 233 */     for (byte b = 0; b < this.columnCount; b++) {
/* 234 */       int i = this.result.getColumnType(b);
/* 235 */       arrayOfValue[b] = DataType.readValue(this.conn.getSession(), resultSet, b + 1, i);
/*     */     } 
/* 237 */     return arrayOfValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteRow(Value[] paramArrayOfValue) throws SQLException {
/* 247 */     StatementBuilder statementBuilder = new StatementBuilder("DELETE FROM ");
/* 248 */     appendTableName(statementBuilder);
/* 249 */     appendKeyCondition(statementBuilder);
/* 250 */     PreparedStatement preparedStatement = this.conn.prepareStatement(statementBuilder.toString());
/* 251 */     setKey(preparedStatement, 1, paramArrayOfValue);
/* 252 */     int i = preparedStatement.executeUpdate();
/* 253 */     if (i != 1)
/*     */     {
/* 255 */       throw DbException.get(2000);
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
/*     */   public void updateRow(Value[] paramArrayOfValue1, Value[] paramArrayOfValue2) throws SQLException {
/* 267 */     StatementBuilder statementBuilder = new StatementBuilder("UPDATE ");
/* 268 */     appendTableName(statementBuilder);
/* 269 */     statementBuilder.append(" SET ");
/* 270 */     appendColumnList(statementBuilder, true);
/*     */ 
/*     */ 
/*     */     
/* 274 */     appendKeyCondition(statementBuilder);
/* 275 */     PreparedStatement preparedStatement = this.conn.prepareStatement(statementBuilder.toString());
/* 276 */     byte b = 1; int i;
/* 277 */     for (i = 0; i < this.columnCount; i++) {
/* 278 */       Value value = paramArrayOfValue2[i];
/* 279 */       if (value == null) {
/* 280 */         value = paramArrayOfValue1[i];
/*     */       }
/* 282 */       value.set(preparedStatement, b++);
/*     */     } 
/* 284 */     setKey(preparedStatement, b, paramArrayOfValue1);
/* 285 */     i = preparedStatement.executeUpdate();
/* 286 */     if (i != 1)
/*     */     {
/* 288 */       throw DbException.get(2000);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertRow(Value[] paramArrayOfValue) throws SQLException {
/* 299 */     StatementBuilder statementBuilder = new StatementBuilder("INSERT INTO ");
/* 300 */     appendTableName(statementBuilder);
/* 301 */     statementBuilder.append('(');
/* 302 */     appendColumnList(statementBuilder, false);
/* 303 */     statementBuilder.append(")VALUES(");
/* 304 */     statementBuilder.resetCount();
/* 305 */     for (byte b1 = 0; b1 < this.columnCount; b1++) {
/* 306 */       statementBuilder.appendExceptFirst(",");
/* 307 */       Value value = paramArrayOfValue[b1];
/* 308 */       if (value == null) {
/* 309 */         statementBuilder.append("DEFAULT");
/*     */       } else {
/* 311 */         statementBuilder.append('?');
/*     */       } 
/*     */     } 
/* 314 */     statementBuilder.append(')');
/* 315 */     PreparedStatement preparedStatement = this.conn.prepareStatement(statementBuilder.toString()); int i; byte b2;
/* 316 */     for (i = 0, b2 = 0; i < this.columnCount; i++) {
/* 317 */       Value value = paramArrayOfValue[i];
/* 318 */       if (value != null) {
/* 319 */         value.set(preparedStatement, b2++ + 1);
/*     */       }
/*     */     } 
/* 322 */     i = preparedStatement.executeUpdate();
/* 323 */     if (i != 1)
/* 324 */       throw DbException.get(2000); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\UpdatableRow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */