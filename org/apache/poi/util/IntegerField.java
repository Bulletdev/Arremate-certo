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
/*     */ 
/*     */ public class IntegerField
/*     */   implements FixedField
/*     */ {
/*     */   private int _value;
/*     */   private final int _offset;
/*     */   
/*     */   public IntegerField(int paramInt) throws ArrayIndexOutOfBoundsException {
/*  52 */     if (paramInt < 0)
/*     */     {
/*  54 */       throw new ArrayIndexOutOfBoundsException("negative offset");
/*     */     }
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
/*     */   
/*     */   public IntegerField(int paramInt1, int paramInt2) throws ArrayIndexOutOfBoundsException {
/*  73 */     this(paramInt1);
/*  74 */     set(paramInt2);
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
/*     */   public IntegerField(int paramInt, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/*  91 */     this(paramInt);
/*  92 */     readFromBytes(paramArrayOfbyte);
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
/*     */   
/*     */   public IntegerField(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 111 */     this(paramInt1);
/* 112 */     set(paramInt2, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get() {
/* 123 */     return this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int paramInt) {
/* 134 */     this._value = paramInt;
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
/*     */   public void set(int paramInt, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 151 */     this._value = paramInt;
/* 152 */     writeToBytes(paramArrayOfbyte);
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
/* 169 */     this._value = LittleEndian.getInt(paramArrayOfbyte, this._offset);
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
/* 187 */     this._value = LittleEndian.readInt(paramInputStream);
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
/* 204 */     LittleEndian.putInt(paramArrayOfbyte, this._offset, this._value);
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
/* 215 */     return String.valueOf(this._value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\IntegerField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */