/*     */ package org.apache.poi.poifs.crypt.agile;
/*     */ 
/*     */ import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.Decryptor;
/*     */ import org.apache.poi.poifs.crypt.EncryptionHeader;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
/*     */ import org.apache.poi.poifs.crypt.EncryptionMode;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.Encryptor;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.xmlbeans.XmlException;
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
/*     */ public class AgileEncryptionInfoBuilder
/*     */   implements EncryptionInfoBuilder
/*     */ {
/*     */   EncryptionInfo info;
/*     */   AgileEncryptionHeader header;
/*     */   AgileEncryptionVerifier verifier;
/*     */   AgileDecryptor decryptor;
/*     */   AgileEncryptor encryptor;
/*     */   
/*     */   public void initialize(EncryptionInfo paramEncryptionInfo, LittleEndianInput paramLittleEndianInput) throws IOException {
/*  46 */     this.info = paramEncryptionInfo;
/*     */     
/*  48 */     EncryptionDocument encryptionDocument = parseDescriptor((InputStream)paramLittleEndianInput);
/*  49 */     this.header = new AgileEncryptionHeader(encryptionDocument);
/*  50 */     this.verifier = new AgileEncryptionVerifier(encryptionDocument);
/*  51 */     if (paramEncryptionInfo.getVersionMajor() == EncryptionMode.agile.versionMajor && paramEncryptionInfo.getVersionMinor() == EncryptionMode.agile.versionMinor) {
/*     */       
/*  53 */       this.decryptor = new AgileDecryptor(this);
/*  54 */       this.encryptor = new AgileEncryptor(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void initialize(EncryptionInfo paramEncryptionInfo, CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*  60 */     this.info = paramEncryptionInfo;
/*     */     
/*  62 */     if (paramCipherAlgorithm == null) {
/*  63 */       paramCipherAlgorithm = CipherAlgorithm.aes128;
/*     */     }
/*  65 */     if (paramCipherAlgorithm == CipherAlgorithm.rc4) {
/*  66 */       throw new EncryptedDocumentException("RC4 must not be used with agile encryption.");
/*     */     }
/*  68 */     if (paramHashAlgorithm == null) {
/*  69 */       paramHashAlgorithm = HashAlgorithm.sha1;
/*     */     }
/*  71 */     if (paramChainingMode == null) {
/*  72 */       paramChainingMode = ChainingMode.cbc;
/*     */     }
/*  74 */     if (paramChainingMode != ChainingMode.cbc && paramChainingMode != ChainingMode.cfb) {
/*  75 */       throw new EncryptedDocumentException("Agile encryption only supports CBC/CFB chaining.");
/*     */     }
/*  77 */     if (paramInt1 == -1) {
/*  78 */       paramInt1 = paramCipherAlgorithm.defaultKeySize;
/*     */     }
/*  80 */     if (paramInt2 == -1) {
/*  81 */       paramInt2 = paramCipherAlgorithm.blockSize;
/*     */     }
/*  83 */     int i = 0;
/*  84 */     for (int j : paramCipherAlgorithm.allowedKeySize) {
/*  85 */       i |= (j == paramInt1) ? 1 : 0;
/*     */     }
/*  87 */     if (i == 0) {
/*  88 */       throw new EncryptedDocumentException("KeySize " + paramInt1 + " not allowed for Cipher " + paramCipherAlgorithm.toString());
/*     */     }
/*  90 */     this.header = new AgileEncryptionHeader(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*  91 */     this.verifier = new AgileEncryptionVerifier(paramCipherAlgorithm, paramHashAlgorithm, paramInt1, paramInt2, paramChainingMode);
/*  92 */     this.decryptor = new AgileDecryptor(this);
/*  93 */     this.encryptor = new AgileEncryptor(this);
/*     */   }
/*     */   
/*     */   public AgileEncryptionHeader getHeader() {
/*  97 */     return this.header;
/*     */   }
/*     */   
/*     */   public AgileEncryptionVerifier getVerifier() {
/* 101 */     return this.verifier;
/*     */   }
/*     */   
/*     */   public AgileDecryptor getDecryptor() {
/* 105 */     return this.decryptor;
/*     */   }
/*     */   
/*     */   public AgileEncryptor getEncryptor() {
/* 109 */     return this.encryptor;
/*     */   }
/*     */   
/*     */   protected EncryptionInfo getInfo() {
/* 113 */     return this.info;
/*     */   }
/*     */   
/*     */   protected static EncryptionDocument parseDescriptor(String paramString) {
/*     */     try {
/* 118 */       return EncryptionDocument.Factory.parse(paramString, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 119 */     } catch (XmlException xmlException) {
/* 120 */       throw new EncryptedDocumentException("Unable to parse encryption descriptor", xmlException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static EncryptionDocument parseDescriptor(InputStream paramInputStream) {
/*     */     try {
/* 126 */       return EncryptionDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 127 */     } catch (Exception exception) {
/* 128 */       throw new EncryptedDocumentException("Unable to parse encryption descriptor", exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\agile\AgileEncryptionInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */