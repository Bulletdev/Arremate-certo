/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.k;
/*     */ import com.google.a.m.m;
/*     */ import com.google.b.a.a;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.FilterInputStream;
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
/*     */ @a
/*     */ @c
/*     */ public final class z
/*     */   extends FilterInputStream
/*     */   implements DataInput
/*     */ {
/*     */   public z(InputStream paramInputStream) {
/*  51 */     super((InputStream)D.checkNotNull(paramInputStream));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public String readLine() {
/*  58 */     throw new UnsupportedOperationException("readLine is not supported");
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) throws IOException {
/*  63 */     h.readFully(this, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  68 */     h.readFully(this, paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int skipBytes(int paramInt) throws IOException {
/*  73 */     return (int)this.in.skip(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public int readUnsignedByte() throws IOException {
/*  79 */     int i = this.in.read();
/*  80 */     if (0 > i) {
/*  81 */       throw new EOFException();
/*     */     }
/*     */     
/*  84 */     return i;
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
/*     */   @a
/*     */   public int readUnsignedShort() throws IOException {
/*  98 */     byte b1 = a();
/*  99 */     byte b2 = a();
/*     */     
/* 101 */     return k.a((byte)0, (byte)0, b2, b1);
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
/*     */   @a
/*     */   public int readInt() throws IOException {
/* 115 */     byte b1 = a();
/* 116 */     byte b2 = a();
/* 117 */     byte b3 = a();
/* 118 */     byte b4 = a();
/*     */     
/* 120 */     return k.a(b4, b3, b2, b1);
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
/*     */   @a
/*     */   public long readLong() throws IOException {
/* 134 */     byte b1 = a();
/* 135 */     byte b2 = a();
/* 136 */     byte b3 = a();
/* 137 */     byte b4 = a();
/* 138 */     byte b5 = a();
/* 139 */     byte b6 = a();
/* 140 */     byte b7 = a();
/* 141 */     byte b8 = a();
/*     */     
/* 143 */     return m.a(b8, b7, b6, b5, b4, b3, b2, b1);
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
/*     */   @a
/*     */   public float readFloat() throws IOException {
/* 157 */     return Float.intBitsToFloat(readInt());
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
/*     */   @a
/*     */   public double readDouble() throws IOException {
/* 171 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public String readUTF() throws IOException {
/* 177 */     return (new DataInputStream(this.in)).readUTF();
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
/*     */   @a
/*     */   public short readShort() throws IOException {
/* 191 */     return (short)readUnsignedShort();
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
/*     */   @a
/*     */   public char readChar() throws IOException {
/* 205 */     return (char)readUnsignedShort();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public byte readByte() throws IOException {
/* 211 */     return (byte)readUnsignedByte();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean readBoolean() throws IOException {
/* 217 */     return (readUnsignedByte() != 0);
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
/*     */   private byte a() throws IOException, EOFException {
/* 229 */     int i = this.in.read();
/*     */     
/* 231 */     if (-1 == i) {
/* 232 */       throw new EOFException();
/*     */     }
/*     */     
/* 235 */     return (byte)i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */