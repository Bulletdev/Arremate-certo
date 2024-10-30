/*    */ package org.apache.poi.poifs.crypt.binaryrc4;
/*    */ 
/*    */ import org.apache.poi.EncryptedDocumentException;
/*    */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
/*    */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*    */ import org.apache.poi.util.LittleEndianInput;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BinaryRC4EncryptionVerifier
/*    */   extends EncryptionVerifier
/*    */   implements EncryptionRecord
/*    */ {
/*    */   protected BinaryRC4EncryptionVerifier() {
/* 29 */     setSpinCount(-1);
/* 30 */     setCipherAlgorithm(CipherAlgorithm.rc4);
/* 31 */     setChainingMode(null);
/* 32 */     setEncryptedKey(null);
/* 33 */     setHashAlgorithm(HashAlgorithm.md5);
/*    */   }
/*    */   
/*    */   protected BinaryRC4EncryptionVerifier(LittleEndianInput paramLittleEndianInput) {
/* 37 */     byte[] arrayOfByte1 = new byte[16];
/* 38 */     paramLittleEndianInput.readFully(arrayOfByte1);
/* 39 */     setSalt(arrayOfByte1);
/* 40 */     byte[] arrayOfByte2 = new byte[16];
/* 41 */     paramLittleEndianInput.readFully(arrayOfByte2);
/* 42 */     setEncryptedVerifier(arrayOfByte2);
/* 43 */     byte[] arrayOfByte3 = new byte[16];
/* 44 */     paramLittleEndianInput.readFully(arrayOfByte3);
/* 45 */     setEncryptedVerifierHash(arrayOfByte3);
/* 46 */     setSpinCount(-1);
/* 47 */     setCipherAlgorithm(CipherAlgorithm.rc4);
/* 48 */     setChainingMode(null);
/* 49 */     setEncryptedKey(null);
/* 50 */     setHashAlgorithm(HashAlgorithm.md5);
/*    */   }
/*    */   
/*    */   protected void setSalt(byte[] paramArrayOfbyte) {
/* 54 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/* 55 */       throw new EncryptedDocumentException("invalid verifier salt");
/*    */     }
/*    */     
/* 58 */     super.setSalt(paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   protected void setEncryptedVerifier(byte[] paramArrayOfbyte) {
/* 62 */     super.setEncryptedVerifier(paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   protected void setEncryptedVerifierHash(byte[] paramArrayOfbyte) {
/* 66 */     super.setEncryptedVerifierHash(paramArrayOfbyte);
/*    */   }
/*    */   
/*    */   public void write(LittleEndianByteArrayOutputStream paramLittleEndianByteArrayOutputStream) {
/* 70 */     byte[] arrayOfByte1 = getSalt();
/* 71 */     assert arrayOfByte1.length == 16;
/* 72 */     paramLittleEndianByteArrayOutputStream.write(arrayOfByte1);
/* 73 */     byte[] arrayOfByte2 = getEncryptedVerifier();
/* 74 */     assert arrayOfByte2.length == 16;
/* 75 */     paramLittleEndianByteArrayOutputStream.write(arrayOfByte2);
/* 76 */     byte[] arrayOfByte3 = getEncryptedVerifierHash();
/* 77 */     assert arrayOfByte3.length == 16;
/* 78 */     paramLittleEndianByteArrayOutputStream.write(arrayOfByte3);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\binaryrc4\BinaryRC4EncryptionVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */