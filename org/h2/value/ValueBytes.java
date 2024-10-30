/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
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
/*     */ public class ValueBytes
/*     */   extends Value
/*     */ {
/*  23 */   private static final ValueBytes EMPTY = new ValueBytes(Utils.EMPTY_BYTES);
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] value;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int hash;
/*     */ 
/*     */ 
/*     */   
/*     */   protected ValueBytes(byte[] paramArrayOfbyte) {
/*  36 */     this.value = paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueBytes get(byte[] paramArrayOfbyte) {
/*  47 */     if (paramArrayOfbyte.length == 0) {
/*  48 */       return EMPTY;
/*     */     }
/*  50 */     paramArrayOfbyte = Utils.cloneByteArray(paramArrayOfbyte);
/*  51 */     return getNoCopy(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueBytes getNoCopy(byte[] paramArrayOfbyte) {
/*  62 */     if (paramArrayOfbyte.length == 0) {
/*  63 */       return EMPTY;
/*     */     }
/*  65 */     ValueBytes valueBytes = new ValueBytes(paramArrayOfbyte);
/*  66 */     if (paramArrayOfbyte.length > SysProperties.OBJECT_CACHE_MAX_PER_ELEMENT_SIZE) {
/*  67 */       return valueBytes;
/*     */     }
/*  69 */     return (ValueBytes)Value.cache(valueBytes);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  74 */     return 12;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  79 */     return "X'" + StringUtils.convertBytesToHex(getBytesNoCopy()) + "'";
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytesNoCopy() {
/*  84 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/*  89 */     return Utils.cloneByteArray(getBytesNoCopy());
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/*  94 */     byte[] arrayOfByte = ((ValueBytes)paramValue).value;
/*  95 */     if (paramCompareMode.isBinaryUnsigned()) {
/*  96 */       return Utils.compareNotNullUnsigned(this.value, arrayOfByte);
/*     */     }
/*  98 */     return Utils.compareNotNullSigned(this.value, arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/* 103 */     return StringUtils.convertBytesToHex(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 108 */     return this.value.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 113 */     if (this.hash == 0) {
/* 114 */       this.hash = Utils.getByteArrayHash(this.value);
/*     */     }
/* 116 */     return this.hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 121 */     return getBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 127 */     paramPreparedStatement.setBytes(paramInt, this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 132 */     return MathUtils.convertLongToInt(this.value.length * 2L);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 137 */     return this.value.length + 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 142 */     return (paramObject instanceof ValueBytes && Arrays.equals(this.value, ((ValueBytes)paramObject).value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/* 148 */     if (this.value.length <= paramLong) {
/* 149 */       return this;
/*     */     }
/* 151 */     int i = MathUtils.convertLongToInt(paramLong);
/* 152 */     byte[] arrayOfByte = new byte[i];
/* 153 */     System.arraycopy(this.value, 0, arrayOfByte, 0, i);
/* 154 */     return get(arrayOfByte);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueBytes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */