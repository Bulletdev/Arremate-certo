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
/*     */ public class ShortField
/*     */   implements FixedField
/*     */ {
/*     */   private short _value;
/*     */   private final int _offset;
/*     */   
/*     */   public ShortField(int paramInt) throws ArrayIndexOutOfBoundsException {
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
/*     */   public ShortField(int paramInt, short paramShort) throws ArrayIndexOutOfBoundsException {
/*  72 */     this(paramInt);
/*  73 */     set(paramShort);
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
/*     */   public ShortField(int paramInt, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
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
/*     */   public ShortField(int paramInt, short paramShort, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 109 */     this(paramInt);
/* 110 */     set(paramShort, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short get() {
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
/*     */   public void set(short paramShort) {
/* 132 */     this._value = paramShort;
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
/*     */   public void set(short paramShort, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 148 */     this._value = paramShort;
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
/* 166 */     this._value = LittleEndian.getShort(paramArrayOfbyte, this._offset);
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
/* 184 */     this._value = LittleEndian.readShort(paramInputStream);
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
/* 201 */     LittleEndian.putShort(paramArrayOfbyte, this._offset, this._value);
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


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\ShortField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */