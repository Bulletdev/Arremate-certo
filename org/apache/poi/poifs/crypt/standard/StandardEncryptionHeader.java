/*     */ package org.apache.poi.poifs.crypt.standard;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.CipherProvider;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandardEncryptionHeader
/*     */   extends EncryptionHeader
/*     */   implements EncryptionRecord
/*     */ {
/*     */   protected StandardEncryptionHeader(LittleEndianInput paramLittleEndianInput) throws IOException {
/*  39 */     setFlags(paramLittleEndianInput.readInt());
/*  40 */     setSizeExtra(paramLittleEndianInput.readInt());
/*  41 */     setCipherAlgorithm(CipherAlgorithm.fromEcmaId(paramLittleEndianInput.readInt()));
/*  42 */     setHashAlgorithm(HashAlgorithm.fromEcmaId(paramLittleEndianInput.readInt()));
/*  43 */     int i = paramLittleEndianInput.readInt();
/*  44 */     if (i == 0)
/*     */     {
/*     */ 
/*     */       
/*  48 */       i = 40;
/*     */     }
/*  50 */     setKeySize(i);
/*  51 */     setBlockSize(getKeySize());
/*  52 */     setCipherProvider(CipherProvider.fromEcmaId(paramLittleEndianInput.readInt()));
/*     */     
/*  54 */     paramLittleEndianInput.readLong();
/*     */ 
/*     */ 
/*     */     
/*  58 */     ((InputStream)paramLittleEndianInput).mark(5);
/*  59 */     int j = paramLittleEndianInput.readInt();
/*  60 */     ((InputStream)paramLittleEndianInput).reset();
/*     */     
/*  62 */     if (j == 16) {
/*  63 */       setCspName("");
/*     */     } else {
/*  65 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       while (true) {
/*  67 */         char c = (char)paramLittleEndianInput.readShort();
/*  68 */         if (c == '\000')
/*  69 */           break;  stringBuilder.append(c);
/*     */       } 
/*  71 */       setCspName(stringBuilder.toString());
/*     */     } 
/*     */     
/*  74 */     setChainingMode(ChainingMode.ecb);
/*  75 */     setKeySalt(null);
/*     */   }
/*     */   
/*     */   protected StandardEncryptionHeader(CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*  79 */     setCipherAlgorithm(paramCipherAlgorithm);
/*  80 */     setHashAlgorithm(paramHashAlgorithm);
/*  81 */     setKeySize(paramInt1);
/*  82 */     setBlockSize(paramInt2);
/*  83 */     setCipherProvider(paramCipherAlgorithm.provider);
/*  84 */     setFlags(EncryptionInfo.flagCryptoAPI.setBoolean(0, true) | EncryptionInfo.flagAES.setBoolean(0, (paramCipherAlgorithm.provider == CipherProvider.aes)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(LittleEndianByteArrayOutputStream paramLittleEndianByteArrayOutputStream) {
/*  94 */     int i = paramLittleEndianByteArrayOutputStream.getWriteIndex();
/*  95 */     LittleEndianOutput littleEndianOutput = paramLittleEndianByteArrayOutputStream.createDelayedOutput(4);
/*  96 */     paramLittleEndianByteArrayOutputStream.writeInt(getFlags());
/*  97 */     paramLittleEndianByteArrayOutputStream.writeInt(0);
/*  98 */     paramLittleEndianByteArrayOutputStream.writeInt((getCipherAlgorithm()).ecmaId);
/*  99 */     paramLittleEndianByteArrayOutputStream.writeInt((getHashAlgorithmEx()).ecmaId);
/* 100 */     paramLittleEndianByteArrayOutputStream.writeInt(getKeySize());
/* 101 */     paramLittleEndianByteArrayOutputStream.writeInt((getCipherProvider()).ecmaId);
/* 102 */     paramLittleEndianByteArrayOutputStream.writeInt(0);
/* 103 */     paramLittleEndianByteArrayOutputStream.writeInt(0);
/* 104 */     String str = getCspName();
/* 105 */     if (str == null) str = (getCipherProvider()).cipherProviderName; 
/* 106 */     paramLittleEndianByteArrayOutputStream.write(StringUtil.getToUnicodeLE(str));
/* 107 */     paramLittleEndianByteArrayOutputStream.writeShort(0);
/* 108 */     int j = paramLittleEndianByteArrayOutputStream.getWriteIndex() - i - 4;
/* 109 */     littleEndianOutput.writeInt(j);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\standard\StandardEncryptionHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */