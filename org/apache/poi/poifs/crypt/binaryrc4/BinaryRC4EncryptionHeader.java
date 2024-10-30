/*    */ package org.apache.poi.poifs.crypt.binaryrc4;
/*    */ 
/*    */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.CipherProvider;
/*    */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*    */ import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
/*    */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BinaryRC4EncryptionHeader
/*    */   extends EncryptionHeader
/*    */   implements EncryptionRecord
/*    */ {
/*    */   protected BinaryRC4EncryptionHeader() {
/* 31 */     setCipherAlgorithm(CipherAlgorithm.rc4);
/* 32 */     setKeySize(40);
/* 33 */     setBlockSize(-1);
/* 34 */     setCipherProvider(CipherProvider.rc4);
/* 35 */     setHashAlgorithm(HashAlgorithm.md5);
/* 36 */     setSizeExtra(0);
/* 37 */     setFlags(0);
/* 38 */     setCspName("");
/* 39 */     setChainingMode(null);
/*    */   }
/*    */   
/*    */   public void write(LittleEndianByteArrayOutputStream paramLittleEndianByteArrayOutputStream) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\binaryrc4\BinaryRC4EncryptionHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */