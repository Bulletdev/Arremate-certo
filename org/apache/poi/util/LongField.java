/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LongField
/*     */   implements FixedField
/*     */ {
/*     */   private long _value;
/*     */   private final int _offset;
/*     */   
/*     */   public LongField(int paramInt) throws ArrayIndexOutOfBoundsException {
/*  51 */     if (paramInt < 0)
/*     */     {
/*  53 */       throw new ArrayIndexOutOfBoundsException("Illegal offset: " + paramInt);
/*     */     }
/*     */     
/*  56 */     this._offset = paramInt;
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
/*     */   public LongField(int paramInt, long paramLong) throws ArrayIndexOutOfBoundsException {
/*  72 */     this(paramInt);
/*  73 */     set(paramLong);
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
/*     */   public LongField(int paramInt, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/*  90 */     this(paramInt);
/*  91 */     readFromBytes(paramArrayOfbyte);
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
/*     */   public LongField(int paramInt, long paramLong, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 109 */     this(paramInt);
/* 110 */     set(paramLong, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long get() {
/* 121 */     return this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(long paramLong) {
/* 132 */     this._value = paramLong;
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
/*     */   public void set(long paramLong, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 148 */     this._value = paramLong;
/* 149 */     writeToBytes(paramArrayOfbyte);
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
/*     */   public void readFromBytes(byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 166 */     this._value = LittleEndian.getLong(paramArrayOfbyte, this._offset);
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
/*     */   public void readFromStream(InputStream paramInputStream) throws IOException {
/* 184 */     this._value = LittleEndian.readLong(paramInputStream);
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
/*     */   public void writeToBytes(byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 201 */     LittleEndian.putLong(paramArrayOfbyte, this._offset, this._value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 212 */     return String.valueOf(this._value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LongField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */