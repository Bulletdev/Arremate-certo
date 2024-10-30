/*     */ package org.apache.poi.poifs.crypt;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import javax.crypto.Cipher;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public abstract class ChunkedCipherInputStream
/*     */   extends LittleEndianInputStream
/*     */ {
/*     */   private final int chunkSize;
/*     */   private final int chunkMask;
/*     */   private final int chunkBits;
/*  36 */   private int _lastIndex = 0;
/*  37 */   private long _pos = 0L;
/*     */   
/*     */   private long _size;
/*     */   private byte[] _chunk;
/*     */   private Cipher _cipher;
/*     */   
/*     */   public ChunkedCipherInputStream(LittleEndianInput paramLittleEndianInput, long paramLong, int paramInt) throws GeneralSecurityException {
/*  44 */     super((InputStream)paramLittleEndianInput);
/*  45 */     this._size = paramLong;
/*  46 */     this.chunkSize = paramInt;
/*  47 */     this.chunkMask = paramInt - 1;
/*  48 */     this.chunkBits = Integer.bitCount(this.chunkMask);
/*     */     
/*  50 */     this._cipher = initCipherForBlock(null, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract Cipher initCipherForBlock(Cipher paramCipher, int paramInt) throws GeneralSecurityException;
/*     */   
/*     */   public int read() throws IOException {
/*  57 */     byte[] arrayOfByte = new byte[1];
/*  58 */     if (read(arrayOfByte) == 1)
/*  59 */       return arrayOfByte[0]; 
/*  60 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  67 */     int i = 0;
/*     */     
/*  69 */     if (available() <= 0) return -1;
/*     */     
/*  71 */     while (paramInt2 > 0) {
/*  72 */       if (this._chunk == null) {
/*     */         try {
/*  74 */           this._chunk = nextChunk();
/*  75 */         } catch (GeneralSecurityException generalSecurityException) {
/*  76 */           throw new EncryptedDocumentException(generalSecurityException.getMessage(), generalSecurityException);
/*     */         } 
/*     */       }
/*  79 */       int j = (int)(this.chunkSize - (this._pos & this.chunkMask));
/*  80 */       int k = available();
/*  81 */       if (k == 0) {
/*  82 */         return i;
/*     */       }
/*  84 */       j = Math.min(k, Math.min(j, paramInt2));
/*  85 */       System.arraycopy(this._chunk, (int)(this._pos & this.chunkMask), paramArrayOfbyte, paramInt1, j);
/*  86 */       paramInt1 += j;
/*  87 */       paramInt2 -= j;
/*  88 */       this._pos += j;
/*  89 */       if ((this._pos & this.chunkMask) == 0L)
/*  90 */         this._chunk = null; 
/*  91 */       i += j;
/*     */     } 
/*     */     
/*  94 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/*  99 */     long l1 = this._pos;
/* 100 */     long l2 = Math.min(available(), paramLong);
/*     */     
/* 102 */     if (((this._pos + l2 ^ l1) & (this.chunkMask ^ 0xFFFFFFFF)) != 0L)
/* 103 */       this._chunk = null; 
/* 104 */     this._pos += l2;
/* 105 */     return l2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 110 */     return (int)(this._size - this._pos);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 120 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/* 125 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   private byte[] nextChunk() throws GeneralSecurityException, IOException {
/* 129 */     int i = (int)(this._pos >> this.chunkBits);
/* 130 */     initCipherForBlock(this._cipher, i);
/*     */     
/* 132 */     if (this._lastIndex != i) {
/* 133 */       super.skip((i - this._lastIndex << this.chunkBits));
/*     */     }
/*     */     
/* 136 */     byte[] arrayOfByte = new byte[Math.min(super.available(), this.chunkSize)];
/* 137 */     super.read(arrayOfByte, 0, arrayOfByte.length);
/* 138 */     this._lastIndex = i + 1;
/* 139 */     return this._cipher.doFinal(arrayOfByte);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\ChunkedCipherInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */