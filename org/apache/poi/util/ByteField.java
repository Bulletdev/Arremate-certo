/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.BufferUnderflowException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteField
/*     */   implements FixedField
/*     */ {
/*     */   private static final byte _default_value = 0;
/*     */   private byte _value;
/*     */   private final int _offset;
/*     */   
/*     */   public ByteField(int paramInt) throws ArrayIndexOutOfBoundsException {
/*  53 */     this(paramInt, (byte)0);
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
/*     */   public ByteField(int paramInt, byte paramByte) throws ArrayIndexOutOfBoundsException {
/*  69 */     if (paramInt < 0)
/*     */     {
/*  71 */       throw new ArrayIndexOutOfBoundsException("offset cannot be negative");
/*     */     }
/*     */     
/*  74 */     this._offset = paramInt;
/*  75 */     set(paramByte);
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
/*     */   public ByteField(int paramInt, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/*  92 */     this(paramInt);
/*  93 */     readFromBytes(paramArrayOfbyte);
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
/*     */   public ByteField(int paramInt, byte paramByte, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 112 */     this(paramInt, paramByte);
/* 113 */     writeToBytes(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte get() {
/* 124 */     return this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(byte paramByte) {
/* 135 */     this._value = paramByte;
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
/*     */   public void set(byte paramByte, byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException {
/* 151 */     set(paramByte);
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
/* 169 */     this._value = paramArrayOfbyte[this._offset];
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
/*     */   public void readFromStream(InputStream paramInputStream) throws IOException {
/* 188 */     int i = paramInputStream.read();
/* 189 */     if (i < 0) {
/* 190 */       throw new BufferUnderflowException();
/*     */     }
/* 192 */     this._value = (byte)i;
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
/* 209 */     paramArrayOfbyte[this._offset] = this._value;
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
/* 220 */     return String.valueOf(this._value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\ByteField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */