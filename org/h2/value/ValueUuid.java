/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.util.UUID;
/*     */ import org.h2.message.DbException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ValueUuid
/*     */   extends Value
/*     */ {
/*     */   private static final int PRECISION = 16;
/*     */   private static final int DISPLAY_SIZE = 36;
/*     */   private final long high;
/*     */   private final long low;
/*     */   
/*     */   private ValueUuid(long paramLong1, long paramLong2) {
/*  37 */     this.high = paramLong1;
/*  38 */     this.low = paramLong2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  43 */     return (int)(this.high >>> 32L ^ this.high ^ this.low >>> 32L ^ this.low);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueUuid getNewRandom() {
/*  52 */     long l1 = MathUtils.secureRandomLong();
/*  53 */     long l2 = MathUtils.secureRandomLong();
/*     */     
/*  55 */     l1 = l1 & 0xFFFFFFFFFFFF0FFFL | 0x4000L;
/*     */     
/*  57 */     l2 = l2 & 0x3FFFFFFFFFFFFFFFL | Long.MIN_VALUE;
/*  58 */     return new ValueUuid(l1, l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueUuid get(byte[] paramArrayOfbyte) {
/*  68 */     if (paramArrayOfbyte.length < 16) {
/*  69 */       return get(StringUtils.convertBytesToHex(paramArrayOfbyte));
/*     */     }
/*  71 */     long l1 = Utils.readLong(paramArrayOfbyte, 0);
/*  72 */     long l2 = Utils.readLong(paramArrayOfbyte, 8);
/*  73 */     return (ValueUuid)Value.cache(new ValueUuid(l1, l2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueUuid get(long paramLong1, long paramLong2) {
/*  84 */     return (ValueUuid)Value.cache(new ValueUuid(paramLong1, paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueUuid get(String paramString) {
/*  94 */     long l1 = 0L, l2 = 0L; byte b1, b2; int i;
/*  95 */     for (b1 = 0, b2 = 0, i = paramString.length(); b1 < i; b1++) {
/*  96 */       char c = paramString.charAt(b1);
/*  97 */       if (c >= '0' && c <= '9')
/*  98 */       { l1 = l1 << 4L | (c - 48); }
/*  99 */       else if (c >= 'a' && c <= 'f')
/* 100 */       { l1 = l1 << 4L | (c - 97 + 10); }
/* 101 */       else { if (c == '-')
/*     */           continue; 
/* 103 */         if (c >= 'A' && c <= 'F')
/* 104 */         { l1 = l1 << 4L | (c - 65 + 10); }
/* 105 */         else { if (c > ' ')
/*     */           {
/*     */             
/* 108 */             throw DbException.get(22018, paramString); }  continue; }
/*     */          }
/* 110 */        if (b2++ == 15) {
/* 111 */         l2 = l1;
/* 112 */         l1 = 0L;
/*     */       }  continue;
/*     */     } 
/* 115 */     return (ValueUuid)Value.cache(new ValueUuid(l2, l1));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 120 */     return StringUtils.quoteStringSQL(getString());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 125 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 130 */     return 16L;
/*     */   }
/*     */   
/*     */   private static void appendHex(StringBuilder paramStringBuilder, long paramLong, int paramInt) {
/* 134 */     for (int i = paramInt * 8 - 4; i >= 0; i -= 8) {
/* 135 */       paramStringBuilder.append(Integer.toHexString((int)(paramLong >> i) & 0xF)).append(Integer.toHexString((int)(paramLong >> i - 4) & 0xF));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 142 */     StringBuilder stringBuilder = new StringBuilder(36);
/* 143 */     appendHex(stringBuilder, this.high >> 32L, 4);
/* 144 */     stringBuilder.append('-');
/* 145 */     appendHex(stringBuilder, this.high >> 16L, 2);
/* 146 */     stringBuilder.append('-');
/* 147 */     appendHex(stringBuilder, this.high, 2);
/* 148 */     stringBuilder.append('-');
/* 149 */     appendHex(stringBuilder, this.low >> 48L, 2);
/* 150 */     stringBuilder.append('-');
/* 151 */     appendHex(stringBuilder, this.low, 6);
/* 152 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 157 */     if (paramValue == this) {
/* 158 */       return 0;
/*     */     }
/* 160 */     ValueUuid valueUuid = (ValueUuid)paramValue;
/* 161 */     if (this.high == valueUuid.high) {
/* 162 */       return MathUtils.compareLong(this.low, valueUuid.low);
/*     */     }
/* 164 */     return (this.high > valueUuid.high) ? 1 : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 169 */     return (paramObject instanceof ValueUuid && compareSecure((Value)paramObject, null) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/* 174 */     return new UUID(this.high, this.low);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 179 */     byte[] arrayOfByte = new byte[16];
/* 180 */     for (byte b = 0; b < 8; b++) {
/* 181 */       arrayOfByte[b] = (byte)(int)(this.high >> 8 * (7 - b) & 0xFFL);
/* 182 */       arrayOfByte[8 + b] = (byte)(int)(this.low >> 8 * (7 - b) & 0xFFL);
/*     */     } 
/* 184 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/* 190 */     paramPreparedStatement.setBytes(paramInt, getBytes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getHigh() {
/* 199 */     return this.high;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLow() {
/* 208 */     return this.low;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 213 */     return 36;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueUuid.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */