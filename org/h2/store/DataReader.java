/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import org.h2.util.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataReader
/*     */   extends Reader
/*     */ {
/*     */   private final InputStream in;
/*     */   
/*     */   public DataReader(InputStream paramInputStream) {
/*  28 */     this.in = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte readByte() throws IOException {
/*  37 */     int i = this.in.read();
/*  38 */     if (i < 0) {
/*  39 */       throw new FastEOFException();
/*     */     }
/*  41 */     return (byte)i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readVarInt() throws IOException {
/*  50 */     byte b = readByte();
/*  51 */     if (b >= 0) {
/*  52 */       return b;
/*     */     }
/*  54 */     int i = b & Byte.MAX_VALUE;
/*  55 */     b = readByte();
/*  56 */     if (b >= 0) {
/*  57 */       return i | b << 7;
/*     */     }
/*  59 */     i |= (b & Byte.MAX_VALUE) << 7;
/*  60 */     b = readByte();
/*  61 */     if (b >= 0) {
/*  62 */       return i | b << 14;
/*     */     }
/*  64 */     i |= (b & Byte.MAX_VALUE) << 14;
/*  65 */     b = readByte();
/*  66 */     if (b >= 0) {
/*  67 */       return i | b << 21;
/*     */     }
/*  69 */     return i | (b & Byte.MAX_VALUE) << 21 | readByte() << 28;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readVarLong() throws IOException {
/*  78 */     long l = readByte();
/*  79 */     if (l >= 0L) {
/*  80 */       return l;
/*     */     }
/*  82 */     l &= 0x7FL;
/*  83 */     for (byte b = 7;; b += 7) {
/*  84 */       long l1 = readByte();
/*  85 */       l |= (l1 & 0x7FL) << b;
/*  86 */       if (l1 >= 0L) {
/*  87 */         return l;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt) throws IOException {
/* 118 */     int i = IOUtils.readFully(this.in, paramArrayOfbyte, paramInt);
/* 119 */     if (i < paramInt) {
/* 120 */       throw new FastEOFException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readString() throws IOException {
/* 130 */     int i = readVarInt();
/* 131 */     return readString(i);
/*     */   }
/*     */   
/*     */   private String readString(int paramInt) throws IOException {
/* 135 */     char[] arrayOfChar = new char[paramInt];
/* 136 */     for (byte b = 0; b < paramInt; b++) {
/* 137 */       arrayOfChar[b] = readChar();
/*     */     }
/* 139 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char readChar() throws IOException {
/* 148 */     int i = readByte() & 0xFF;
/* 149 */     if (i < 128)
/* 150 */       return (char)i; 
/* 151 */     if (i >= 224) {
/* 152 */       return (char)(((i & 0xF) << 12) + ((readByte() & 0x3F) << 6) + (readByte() & 0x3F));
/*     */     }
/*     */ 
/*     */     
/* 156 */     return (char)(((i & 0x1F) << 6) + (readByte() & 0x3F));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 168 */     if (paramInt2 == 0) {
/* 169 */       return 0;
/*     */     }
/* 171 */     byte b = 0;
/*     */     try {
/* 173 */       for (; b < paramInt2; b++) {
/* 174 */         paramArrayOfchar[b] = readChar();
/*     */       }
/* 176 */       return paramInt2;
/* 177 */     } catch (EOFException eOFException) {
/* 178 */       if (b == 0) {
/* 179 */         return -1;
/*     */       }
/* 181 */       return b;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class FastEOFException
/*     */     extends EOFException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public synchronized Throwable fillInStackTrace() {
/* 196 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\DataReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */