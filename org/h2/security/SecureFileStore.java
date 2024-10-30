/*     */ package org.h2.security;
/*     */ 
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.util.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SecureFileStore
/*     */   extends FileStore
/*     */ {
/*     */   private byte[] key;
/*     */   private final BlockCipher cipher;
/*     */   private final BlockCipher cipherForInitVector;
/*  23 */   private byte[] buffer = new byte[4];
/*     */   
/*     */   private long pos;
/*     */   private final byte[] bufferForInitVector;
/*     */   private final int keyIterations;
/*     */   
/*     */   public SecureFileStore(DataHandler paramDataHandler, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte, int paramInt) {
/*  30 */     super(paramDataHandler, paramString1, paramString2);
/*  31 */     this.key = paramArrayOfbyte;
/*  32 */     this.cipher = CipherFactory.getBlockCipher(paramString3);
/*  33 */     this.cipherForInitVector = CipherFactory.getBlockCipher(paramString3);
/*  34 */     this.keyIterations = paramInt;
/*  35 */     this.bufferForInitVector = new byte[16];
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateSalt() {
/*  40 */     return MathUtils.secureRandomBytes(16);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void initKey(byte[] paramArrayOfbyte) {
/*  45 */     this.key = SHA256.getHashWithSalt(this.key, paramArrayOfbyte);
/*  46 */     for (byte b = 0; b < this.keyIterations; b++) {
/*  47 */       this.key = SHA256.getHash(this.key, true);
/*     */     }
/*  49 */     this.cipher.setKey(this.key);
/*  50 */     this.key = SHA256.getHash(this.key, true);
/*  51 */     this.cipherForInitVector.setKey(this.key);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeDirect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  56 */     super.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  57 */     this.pos += paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  62 */     if (this.buffer.length < paramArrayOfbyte.length) {
/*  63 */       this.buffer = new byte[paramInt2];
/*     */     }
/*  65 */     System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, 0, paramInt2);
/*  66 */     xorInitVector(this.buffer, 0, paramInt2, this.pos);
/*  67 */     this.cipher.encrypt(this.buffer, 0, paramInt2);
/*  68 */     super.write(this.buffer, 0, paramInt2);
/*  69 */     this.pos += paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void readFullyDirect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  74 */     super.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*  75 */     this.pos += paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  80 */     super.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*  81 */     for (byte b = 0; b < paramInt2; b++) {
/*  82 */       if (paramArrayOfbyte[b] != 0) {
/*  83 */         this.cipher.decrypt(paramArrayOfbyte, paramInt1, paramInt2);
/*  84 */         xorInitVector(paramArrayOfbyte, paramInt1, paramInt2, this.pos);
/*     */         break;
/*     */       } 
/*     */     } 
/*  88 */     this.pos += paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void seek(long paramLong) {
/*  93 */     this.pos = paramLong;
/*  94 */     super.seek(paramLong);
/*     */   }
/*     */   
/*     */   private void xorInitVector(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong) {
/*  98 */     byte[] arrayOfByte = this.bufferForInitVector;
/*  99 */     while (paramInt2 > 0) {
/* 100 */       byte b; for (b = 0; b < 16; b += 8) {
/* 101 */         long l = paramLong + b >>> 3L;
/* 102 */         arrayOfByte[b] = (byte)(int)(l >> 56L);
/* 103 */         arrayOfByte[b + 1] = (byte)(int)(l >> 48L);
/* 104 */         arrayOfByte[b + 2] = (byte)(int)(l >> 40L);
/* 105 */         arrayOfByte[b + 3] = (byte)(int)(l >> 32L);
/* 106 */         arrayOfByte[b + 4] = (byte)(int)(l >> 24L);
/* 107 */         arrayOfByte[b + 5] = (byte)(int)(l >> 16L);
/* 108 */         arrayOfByte[b + 6] = (byte)(int)(l >> 8L);
/* 109 */         arrayOfByte[b + 7] = (byte)(int)l;
/*     */       } 
/* 111 */       this.cipherForInitVector.encrypt(arrayOfByte, 0, 16);
/* 112 */       for (b = 0; b < 16; b++) {
/* 113 */         paramArrayOfbyte[paramInt1 + b] = (byte)(paramArrayOfbyte[paramInt1 + b] ^ arrayOfByte[b]);
/*     */       }
/* 115 */       paramLong += 16L;
/* 116 */       paramInt1 += 16;
/* 117 */       paramInt2 -= 16;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\security\SecureFileStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */