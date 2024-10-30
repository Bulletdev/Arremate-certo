/*     */ package org.apache.poi.hssf.record.crypto;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.hssf.record.BiffHeaderInput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Biff8DecryptingStream
/*     */   implements BiffHeaderInput, LittleEndianInput
/*     */ {
/*     */   private final LittleEndianInput _le;
/*     */   private final Biff8Cipher _cipher;
/*     */   
/*     */   public Biff8DecryptingStream(InputStream paramInputStream, int paramInt, Biff8EncryptionKey paramBiff8EncryptionKey) {
/*  37 */     if (paramBiff8EncryptionKey instanceof Biff8RC4Key) {
/*  38 */       this._cipher = new Biff8RC4(paramInt, (Biff8RC4Key)paramBiff8EncryptionKey);
/*  39 */     } else if (paramBiff8EncryptionKey instanceof Biff8XORKey) {
/*  40 */       this._cipher = new Biff8XOR(paramInt, (Biff8XORKey)paramBiff8EncryptionKey);
/*     */     } else {
/*  42 */       throw new EncryptedDocumentException("Crypto API not supported yet.");
/*     */     } 
/*     */     
/*  45 */     if (paramInputStream instanceof LittleEndianInput) {
/*     */       
/*  47 */       this._le = (LittleEndianInput)paramInputStream;
/*     */     } else {
/*     */       
/*  50 */       this._le = (LittleEndianInput)new LittleEndianInputStream(paramInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int available() {
/*  55 */     return this._le.available();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readRecordSID() {
/*  62 */     int i = this._le.readUShort();
/*  63 */     this._cipher.skipTwoBytes();
/*  64 */     this._cipher.startRecord(i);
/*  65 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readDataSize() {
/*  72 */     int i = this._le.readUShort();
/*  73 */     this._cipher.skipTwoBytes();
/*  74 */     this._cipher.setNextRecordSize(i);
/*  75 */     return i;
/*     */   }
/*     */   
/*     */   public double readDouble() {
/*  79 */     long l = readLong();
/*  80 */     double d = Double.longBitsToDouble(l);
/*  81 */     if (Double.isNaN(d)) {
/*  82 */       throw new RuntimeException("Did not expect to read NaN");
/*     */     }
/*  84 */     return d;
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/*  88 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  92 */     this._le.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*  93 */     this._cipher.xor(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUByte() {
/*  98 */     return readByte() & 0xFF;
/*     */   }
/*     */   public byte readByte() {
/* 101 */     return (byte)this._cipher.xorByte(this._le.readUByte());
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUShort() {
/* 106 */     return readShort() & 0xFFFF;
/*     */   }
/*     */   public short readShort() {
/* 109 */     return (short)this._cipher.xorShort(this._le.readUShort());
/*     */   }
/*     */   
/*     */   public int readInt() {
/* 113 */     return this._cipher.xorInt(this._le.readInt());
/*     */   }
/*     */   
/*     */   public long readLong() {
/* 117 */     return this._cipher.xorLong(this._le.readLong());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8DecryptingStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */