/*     */ package org.h2.jdbc;
/*     */ 
/*     */ import java.sql.ParameterMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.CommandInterface;
/*     */ import org.h2.expression.ParameterInterface;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.message.TraceObject;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.value.DataType;
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
/*     */ public class JdbcParameterMetaData
/*     */   extends TraceObject
/*     */   implements ParameterMetaData
/*     */ {
/*     */   private final JdbcPreparedStatement prep;
/*     */   private final int paramCount;
/*     */   private final ArrayList<? extends ParameterInterface> parameters;
/*     */   
/*     */   JdbcParameterMetaData(Trace paramTrace, JdbcPreparedStatement paramJdbcPreparedStatement, CommandInterface paramCommandInterface, int paramInt) {
/*  32 */     setTrace(paramTrace, 11, paramInt);
/*  33 */     this.prep = paramJdbcPreparedStatement;
/*  34 */     this.parameters = paramCommandInterface.getParameters();
/*  35 */     this.paramCount = this.parameters.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getParameterCount() throws SQLException {
/*     */     try {
/*  46 */       debugCodeCall("getParameterCount");
/*  47 */       checkClosed();
/*  48 */       return this.paramCount;
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
/*     */   public int getParameterMode(int paramInt) throws SQLException {
/*     */     try {
/*  64 */       debugCodeCall("getParameterMode", paramInt);
/*  65 */       getParameter(paramInt);
/*  66 */       return 1;
/*  67 */     } catch (Exception exception) {
/*  68 */       throw logAndConvert(exception);
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
/*     */   public int getParameterType(int paramInt) throws SQLException {
/*     */     try {
/*  82 */       debugCodeCall("getParameterType", paramInt);
/*  83 */       ParameterInterface parameterInterface = getParameter(paramInt);
/*  84 */       int i = parameterInterface.getType();
/*  85 */       if (i == -1) {
/*  86 */         i = 13;
/*     */       }
/*  88 */       return (DataType.getDataType(i)).sqlType;
/*  89 */     } catch (Exception exception) {
/*  90 */       throw logAndConvert(exception);
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
/*     */   public int getPrecision(int paramInt) throws SQLException {
/*     */     try {
/* 104 */       debugCodeCall("getPrecision", paramInt);
/* 105 */       ParameterInterface parameterInterface = getParameter(paramInt);
/* 106 */       return MathUtils.convertLongToInt(parameterInterface.getPrecision());
/* 107 */     } catch (Exception exception) {
/* 108 */       throw logAndConvert(exception);
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
/*     */   public int getScale(int paramInt) throws SQLException {
/*     */     try {
/* 122 */       debugCodeCall("getScale", paramInt);
/* 123 */       ParameterInterface parameterInterface = getParameter(paramInt);
/* 124 */       return parameterInterface.getScale();
/* 125 */     } catch (Exception exception) {
/* 126 */       throw logAndConvert(exception);
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
/*     */   public int isNullable(int paramInt) throws SQLException {
/*     */     try {
/* 140 */       debugCodeCall("isNullable", paramInt);
/* 141 */       return getParameter(paramInt).getNullable();
/* 142 */     } catch (Exception exception) {
/* 143 */       throw logAndConvert(exception);
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
/*     */   public boolean isSigned(int paramInt) throws SQLException {
/*     */     try {
/* 157 */       debugCodeCall("isSigned", paramInt);
/* 158 */       getParameter(paramInt);
/* 159 */       return true;
/* 160 */     } catch (Exception exception) {
/* 161 */       throw logAndConvert(exception);
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
/*     */   public String getParameterClassName(int paramInt) throws SQLException {
/*     */     try {
/* 175 */       debugCodeCall("getParameterClassName", paramInt);
/* 176 */       ParameterInterface parameterInterface = getParameter(paramInt);
/* 177 */       int i = parameterInterface.getType();
/* 178 */       if (i == -1) {
/* 179 */         i = 13;
/*     */       }
/* 181 */       return DataType.getTypeClassName(i);
/* 182 */     } catch (Exception exception) {
/* 183 */       throw logAndConvert(exception);
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
/*     */   public String getParameterTypeName(int paramInt) throws SQLException {
/*     */     try {
/* 197 */       debugCodeCall("getParameterTypeName", paramInt);
/* 198 */       ParameterInterface parameterInterface = getParameter(paramInt);
/* 199 */       int i = parameterInterface.getType();
/* 200 */       if (i == -1) {
/* 201 */         i = 13;
/*     */       }
/* 203 */       return (DataType.getDataType(i)).name;
/* 204 */     } catch (Exception exception) {
/* 205 */       throw logAndConvert(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ParameterInterface getParameter(int paramInt) {
/* 210 */     checkClosed();
/* 211 */     if (paramInt < 1 || paramInt > this.paramCount) {
/* 212 */       throw DbException.getInvalidValueException("param", Integer.valueOf(paramInt));
/*     */     }
/* 214 */     return this.parameters.get(paramInt - 1);
/*     */   }
/*     */   
/*     */   private void checkClosed() {
/* 218 */     this.prep.checkClosed();
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
/*     */   public <T> T unwrap(Class<T> paramClass) throws SQLException {
/* 230 */     if (isWrapperFor(paramClass)) {
/* 231 */       return (T)this;
/*     */     }
/* 233 */     throw DbException.getInvalidValueException("iface", paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
/* 244 */     return (paramClass != null && paramClass.isAssignableFrom(getClass()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     return getTraceObjectName() + ": parameterCount=" + this.paramCount;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbc\JdbcParameterMetaData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */