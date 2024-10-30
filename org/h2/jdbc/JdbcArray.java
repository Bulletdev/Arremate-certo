/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.sql.Array;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Map;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.tools.SimpleResultSet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JdbcArray
/*     */   extends TraceObject
/*     */   implements Array
/*     */ {
/*     */   private Value value;
/*     */   private final JdbcConnection conn;
/*     */   
/*     */   JdbcArray(JdbcConnection paramJdbcConnection, Value paramValue, int paramInt) {
/*  32 */     setTrace(paramJdbcConnection.getSession().getTrace(), 16, paramInt);
/*  33 */     this.conn = paramJdbcConnection;
/*  34 */     this.value = paramValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getArray() throws SQLException {
/*     */     try {
/*  46 */       debugCodeCall("getArray");
/*  47 */       checkClosed();
/*  48 */       return get();
/*  49 */     } catch (Exception exception) {
/*  50 */       throw logAndConvert(exception);
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
/*     */   public Object getArray(Map<String, Class<?>> paramMap) throws SQLException {
/*     */     try {
/*  64 */       if (isDebugEnabled()) {
/*  65 */         debugCode("getArray(" + quoteMap(paramMap) + ");");
/*     */       }
/*  67 */       JdbcConnection.checkMap(paramMap);
/*  68 */       checkClosed();
/*  69 */       return get();
/*  70 */     } catch (Exception exception) {
/*  71 */       throw logAndConvert(exception);
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
/*     */   public Object getArray(long paramLong, int paramInt) throws SQLException {
/*     */     try {
/*  87 */       if (isDebugEnabled()) {
/*  88 */         debugCode("getArray(" + paramLong + ", " + paramInt + ");");
/*     */       }
/*  90 */       checkClosed();
/*  91 */       return get(paramLong, paramInt);
/*  92 */     } catch (Exception exception) {
/*  93 */       throw logAndConvert(exception);
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
/*     */   public Object getArray(long paramLong, int paramInt, Map<String, Class<?>> paramMap) throws SQLException {
/*     */     try {
/* 111 */       if (isDebugEnabled()) {
/* 112 */         debugCode("getArray(" + paramLong + ", " + paramInt + ", " + quoteMap(paramMap) + ");");
/*     */       }
/* 114 */       checkClosed();
/* 115 */       JdbcConnection.checkMap(paramMap);
/* 116 */       return get(paramLong, paramInt);
/* 117 */     } catch (Exception exception) {
/* 118 */       throw logAndConvert(exception);
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
/*     */   public int getBaseType() throws SQLException {
/*     */     try {
/* 131 */       debugCodeCall("getBaseType");
/* 132 */       checkClosed();
/* 133 */       return 0;
/* 134 */     } catch (Exception exception) {
/* 135 */       throw logAndConvert(exception);
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
/*     */   public String getBaseTypeName() throws SQLException {
/*     */     try {
/* 148 */       debugCodeCall("getBaseTypeName");
/* 149 */       checkClosed();
/* 150 */       return "NULL";
/* 151 */     } catch (Exception exception) {
/* 152 */       throw logAndConvert(exception);
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
/*     */   public ResultSet getResultSet() throws SQLException {
/*     */     try {
/* 166 */       debugCodeCall("getResultSet");
/* 167 */       checkClosed();
/* 168 */       return getResultSet(get(), 0L);
/* 169 */     } catch (Exception exception) {
/* 170 */       throw logAndConvert(exception);
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
/*     */   public ResultSet getResultSet(Map<String, Class<?>> paramMap) throws SQLException {
/*     */     try {
/* 184 */       if (isDebugEnabled()) {
/* 185 */         debugCode("getResultSet(" + quoteMap(paramMap) + ");");
/*     */       }
/* 187 */       checkClosed();
/* 188 */       JdbcConnection.checkMap(paramMap);
/* 189 */       return getResultSet(get(), 0L);
/* 190 */     } catch (Exception exception) {
/* 191 */       throw logAndConvert(exception);
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
/*     */   public ResultSet getResultSet(long paramLong, int paramInt) throws SQLException {
/*     */     try {
/* 208 */       if (isDebugEnabled()) {
/* 209 */         debugCode("getResultSet(" + paramLong + ", " + paramInt + ");");
/*     */       }
/* 211 */       checkClosed();
/* 212 */       return getResultSet(get(paramLong, paramInt), paramLong - 1L);
/* 213 */     } catch (Exception exception) {
/* 214 */       throw logAndConvert(exception);
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
/*     */ 
/*     */   
/*     */   public ResultSet getResultSet(long paramLong, int paramInt, Map<String, Class<?>> paramMap) throws SQLException {
/*     */     try {
/* 234 */       if (isDebugEnabled()) {
/* 235 */         debugCode("getResultSet(" + paramLong + ", " + paramInt + ", " + quoteMap(paramMap) + ");");
/*     */       }
/* 237 */       checkClosed();
/* 238 */       JdbcConnection.checkMap(paramMap);
/* 239 */       return getResultSet(get(paramLong, paramInt), paramLong - 1L);
/* 240 */     } catch (Exception exception) {
/* 241 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/* 250 */     debugCodeCall("free");
/* 251 */     this.value = null;
/*     */   }
/*     */   
/*     */   private static ResultSet getResultSet(Object[] paramArrayOfObject, long paramLong) {
/* 255 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 256 */     simpleResultSet.addColumn("INDEX", -5, 0, 0);
/*     */     
/* 258 */     simpleResultSet.addColumn("VALUE", 0, 0, 0);
/* 259 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 260 */       simpleResultSet.addRow(new Object[] { Long.valueOf(paramLong + b + 1L), paramArrayOfObject[b] });
/*     */     } 
/* 262 */     return (ResultSet)simpleResultSet;
/*     */   }
/*     */   
/*     */   private void checkClosed() {
/* 266 */     this.conn.checkClosed();
/* 267 */     if (this.value == null) {
/* 268 */       throw DbException.get(90007);
/*     */     }
/*     */   }
/*     */   
/*     */   private Object[] get() {
/* 273 */     return (Object[])this.value.convertTo(17).getObject();
/*     */   }
/*     */   
/*     */   private Object[] get(long paramLong, int paramInt) {
/* 277 */     Object[] arrayOfObject1 = get();
/* 278 */     if (paramInt < 0 || paramInt > arrayOfObject1.length) {
/* 279 */       throw DbException.getInvalidValueException("count (1.." + arrayOfObject1.length + ")", Integer.valueOf(paramInt));
/*     */     }
/*     */     
/* 282 */     if (paramLong < 1L || paramLong > arrayOfObject1.length) {
/* 283 */       throw DbException.getInvalidValueException("index (1.." + arrayOfObject1.length + ")", Long.valueOf(paramLong));
/*     */     }
/*     */     
/* 286 */     Object[] arrayOfObject2 = new Object[paramInt];
/* 287 */     System.arraycopy(arrayOfObject1, (int)(paramLong - 1L), arrayOfObject2, 0, paramInt);
/* 288 */     return arrayOfObject2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 296 */     return (this.value == null) ? "null" : (getTraceObjectName() + ": " + this.value.getTraceSQL());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */