/*     */ package org.c.a.b.h;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class d
/*     */ {
/*     */   private final Connection d;
/*     */   private final int iE;
/*     */   
/*     */   public d(Connection paramConnection) {
/*  51 */     this.d = paramConnection;
/*  52 */     this.iE = a.a(paramConnection).bO();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() {
/*  59 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Map<String, String>> a(String paramString, Object... paramVarArgs) throws SQLException {
/*     */     ArrayList<LinkedHashMap<Object, Object>> arrayList;
/*  71 */     PreparedStatement preparedStatement = null;
/*  72 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/*  76 */       preparedStatement = a(paramString, paramVarArgs);
/*  77 */       resultSet = preparedStatement.executeQuery();
/*     */       
/*  79 */       arrayList = new ArrayList();
/*  80 */       while (resultSet.next()) {
/*  81 */         LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*  82 */         for (byte b = 1; b <= resultSet.getMetaData().getColumnCount(); b++) {
/*  83 */           linkedHashMap.put(resultSet.getMetaData().getColumnLabel(b), resultSet.getString(b));
/*     */         }
/*  85 */         arrayList.add(linkedHashMap);
/*     */       } 
/*     */     } finally {
/*  88 */       e.a(resultSet);
/*  89 */       e.a(preparedStatement);
/*     */     } 
/*     */     
/*  92 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> a(String paramString, String... paramVarArgs) throws SQLException {
/*     */     ArrayList<String> arrayList;
/* 104 */     PreparedStatement preparedStatement = null;
/* 105 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/* 109 */       preparedStatement = a(paramString, (Object[])paramVarArgs);
/* 110 */       resultSet = preparedStatement.executeQuery();
/*     */       
/* 112 */       arrayList = new ArrayList();
/* 113 */       while (resultSet.next()) {
/* 114 */         arrayList.add(resultSet.getString(1));
/*     */       }
/*     */     } finally {
/* 117 */       e.a(resultSet);
/* 118 */       e.a(preparedStatement);
/*     */     } 
/*     */     
/* 121 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int b(String paramString, String... paramVarArgs) throws SQLException {
/*     */     int i;
/* 133 */     PreparedStatement preparedStatement = null;
/* 134 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/* 138 */       preparedStatement = a(paramString, (Object[])paramVarArgs);
/* 139 */       resultSet = preparedStatement.executeQuery();
/* 140 */       resultSet.next();
/* 141 */       i = resultSet.getInt(1);
/*     */     } finally {
/* 143 */       e.a(resultSet);
/* 144 */       e.a(preparedStatement);
/*     */     } 
/*     */     
/* 147 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean b(String paramString, String... paramVarArgs) throws SQLException {
/*     */     boolean bool;
/* 159 */     PreparedStatement preparedStatement = null;
/* 160 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/* 164 */       preparedStatement = a(paramString, (Object[])paramVarArgs);
/* 165 */       resultSet = preparedStatement.executeQuery();
/* 166 */       resultSet.next();
/* 167 */       bool = resultSet.getBoolean(1);
/*     */     } finally {
/* 169 */       e.a(resultSet);
/* 170 */       e.a(preparedStatement);
/*     */     } 
/*     */     
/* 173 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String b(String paramString, String... paramVarArgs) throws SQLException {
/*     */     String str;
/* 185 */     PreparedStatement preparedStatement = null;
/* 186 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/* 190 */       preparedStatement = a(paramString, (Object[])paramVarArgs);
/* 191 */       resultSet = preparedStatement.executeQuery();
/* 192 */       str = null;
/* 193 */       if (resultSet.next()) {
/* 194 */         str = resultSet.getString(1);
/*     */       }
/*     */     } finally {
/* 197 */       e.a(resultSet);
/* 198 */       e.a(preparedStatement);
/*     */     } 
/*     */     
/* 201 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(String paramString, Object... paramVarArgs) throws SQLException {
/* 212 */     PreparedStatement preparedStatement = null;
/*     */     try {
/* 214 */       preparedStatement = a(paramString, paramVarArgs);
/* 215 */       preparedStatement.execute();
/*     */     } finally {
/* 217 */       e.a(preparedStatement);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g a(String paramString) {
/* 228 */     g g = new g();
/* 229 */     Statement statement = null; try {
/*     */       boolean bool;
/* 231 */       statement = this.d.createStatement();
/* 232 */       statement.setEscapeProcessing(false);
/*     */       
/*     */       try {
/* 235 */         bool = statement.execute(paramString);
/*     */       } finally {
/* 237 */         a(g, statement);
/*     */       } 
/* 239 */       a(g, statement, bool);
/* 240 */     } catch (SQLException sQLException) {
/* 241 */       a(g, sQLException);
/*     */     } finally {
/* 243 */       e.a(statement);
/*     */     } 
/* 245 */     return g;
/*     */   }
/*     */   
/*     */   private void a(g paramg, Statement paramStatement) throws SQLException {
/* 249 */     SQLWarning sQLWarning = paramStatement.getWarnings();
/* 250 */     while (sQLWarning != null) {
/* 251 */       paramg.a(new j(sQLWarning.getErrorCode(), sQLWarning.getSQLState(), sQLWarning.getMessage()));
/* 252 */       sQLWarning = sQLWarning.getNextWarning();
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
/*     */   public void a(g paramg, SQLException paramSQLException) {
/* 264 */     paramg.a(paramSQLException);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(g paramg, Statement paramStatement, boolean paramBoolean) throws SQLException {
/* 269 */     int i = -1;
/* 270 */     while (paramBoolean || (i = paramStatement.getUpdateCount()) != -1) {
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
/* 298 */       paramg.a(new f(i));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 303 */       paramBoolean = paramStatement.getMoreResults();
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
/*     */   public void b(String paramString, Object... paramVarArgs) throws SQLException {
/* 315 */     PreparedStatement preparedStatement = null;
/*     */     try {
/* 317 */       preparedStatement = a(paramString, paramVarArgs);
/* 318 */       preparedStatement.executeUpdate();
/*     */     } finally {
/* 320 */       e.a(preparedStatement);
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
/*     */   private PreparedStatement a(String paramString, Object[] paramArrayOfObject) throws SQLException {
/* 333 */     PreparedStatement preparedStatement = this.d.prepareStatement(paramString);
/* 334 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 335 */       if (paramArrayOfObject[b] == null) {
/* 336 */         preparedStatement.setNull(b + 1, this.iE);
/* 337 */       } else if (paramArrayOfObject[b] instanceof Integer) {
/* 338 */         preparedStatement.setInt(b + 1, ((Integer)paramArrayOfObject[b]).intValue());
/* 339 */       } else if (paramArrayOfObject[b] instanceof Boolean) {
/* 340 */         preparedStatement.setBoolean(b + 1, ((Boolean)paramArrayOfObject[b]).booleanValue());
/*     */       } else {
/* 342 */         preparedStatement.setString(b + 1, paramArrayOfObject[b].toString());
/*     */       } 
/*     */     } 
/* 345 */     return preparedStatement;
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
/*     */   public <T> List<T> a(String paramString, h<T> paramh) throws SQLException {
/*     */     ArrayList<T> arrayList;
/* 358 */     Statement statement = null;
/* 359 */     ResultSet resultSet = null;
/*     */ 
/*     */     
/*     */     try {
/* 363 */       statement = this.d.createStatement();
/* 364 */       resultSet = statement.executeQuery(paramString);
/*     */       
/* 366 */       arrayList = new ArrayList();
/* 367 */       while (resultSet.next()) {
/* 368 */         arrayList.add(paramh.a(resultSet));
/*     */       }
/*     */     } finally {
/* 371 */       e.a(resultSet);
/* 372 */       e.a(statement);
/*     */     } 
/*     */     
/* 375 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\h\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */