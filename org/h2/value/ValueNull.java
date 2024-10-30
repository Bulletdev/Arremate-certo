/*     */ package org.h2.value;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import org.h2.message.DbException;
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
/*     */ public class ValueNull
/*     */   extends Value
/*     */ {
/*  27 */   public static final ValueNull INSTANCE = new ValueNull();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   public static final ValueNull DELETED = new ValueNull();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int PRECISION = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int DISPLAY_SIZE = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  51 */     return "NULL";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  56 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/*  61 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getBoolean() {
/*  66 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getDate() {
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Time getTime() {
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp() {
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getByte() {
/*  91 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getShort() {
/*  96 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal() {
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble() {
/* 106 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat() {
/* 111 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt() {
/* 116 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong() {
/* 121 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() {
/* 126 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Reader getReader() {
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertTo(int paramInt) {
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 141 */     throw DbException.throwInternalError("compare null");
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 146 */     return 1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 151 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 162 */     paramPreparedStatement.setNull(paramInt, DataType.convertTypeToSQLType(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 167 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 172 */     return (paramObject == this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueNull.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */