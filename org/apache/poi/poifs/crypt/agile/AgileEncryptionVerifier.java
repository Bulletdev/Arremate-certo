/*     */ package org.apache.poi.poifs.crypt.agile;
/*     */ 
/*     */ import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
/*     */ import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
/*     */ import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
/*     */ import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.cert.CertificateFactory;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.EncryptionVerifier;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
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
/*     */ public class AgileEncryptionVerifier
/*     */   extends EncryptionVerifier
/*     */ {
/*     */   private List<AgileCertificateEntry> certList;
/*     */   
/*     */   public static class AgileCertificateEntry
/*     */   {
/*     */     X509Certificate x509;
/*     */     byte[] encryptedKey;
/*     */     byte[] certVerifier;
/*     */   }
/*     */   
/*     */   public AgileEncryptionVerifier(String paramString) {
/*  53 */     this(AgileEncryptionInfoBuilder.parseDescriptor(paramString));
/*     */   } protected AgileEncryptionVerifier(EncryptionDocument paramEncryptionDocument) {
/*     */     CTPasswordKeyEncryptor cTPasswordKeyEncryptor;
/*     */     this.certList = new ArrayList<AgileCertificateEntry>();
/*  57 */     Iterator<CTKeyEncryptor> iterator = paramEncryptionDocument.getEncryption().getKeyEncryptors().getKeyEncryptorList().iterator();
/*     */     
/*     */     try {
/*  60 */       cTPasswordKeyEncryptor = ((CTKeyEncryptor)iterator.next()).getEncryptedPasswordKey();
/*  61 */       if (cTPasswordKeyEncryptor == null) {
/*  62 */         throw new NullPointerException("encryptedKey not set");
/*     */       }
/*  64 */     } catch (Exception exception) {
/*  65 */       throw new EncryptedDocumentException("Unable to parse keyData", exception);
/*     */     } 
/*     */     
/*  68 */     int i = (int)cTPasswordKeyEncryptor.getKeyBits();
/*     */     
/*  70 */     CipherAlgorithm cipherAlgorithm = CipherAlgorithm.fromXmlId(cTPasswordKeyEncryptor.getCipherAlgorithm().toString(), i);
/*  71 */     setCipherAlgorithm(cipherAlgorithm);
/*     */     
/*  73 */     int j = cTPasswordKeyEncryptor.getHashSize();
/*     */     
/*  75 */     HashAlgorithm hashAlgorithm = HashAlgorithm.fromEcmaId(cTPasswordKeyEncryptor.getHashAlgorithm().toString());
/*  76 */     setHashAlgorithm(hashAlgorithm);
/*     */     
/*  78 */     if ((getHashAlgorithm()).hashSize != j) {
/*  79 */       throw new EncryptedDocumentException("Unsupported hash algorithm: " + cTPasswordKeyEncryptor.getHashAlgorithm() + " @ " + j + " bytes");
/*     */     }
/*     */ 
/*     */     
/*  83 */     setSpinCount(cTPasswordKeyEncryptor.getSpinCount());
/*  84 */     setEncryptedVerifier(cTPasswordKeyEncryptor.getEncryptedVerifierHashInput());
/*  85 */     setSalt(cTPasswordKeyEncryptor.getSaltValue());
/*  86 */     setEncryptedKey(cTPasswordKeyEncryptor.getEncryptedKeyValue());
/*  87 */     setEncryptedVerifierHash(cTPasswordKeyEncryptor.getEncryptedVerifierHashValue());
/*     */     
/*  89 */     int k = cTPasswordKeyEncryptor.getSaltSize();
/*  90 */     if (k != (getSalt()).length) {
/*  91 */       throw new EncryptedDocumentException("Invalid salt size");
/*     */     }
/*  93 */     switch (cTPasswordKeyEncryptor.getCipherChaining().intValue()) {
/*     */       case 1:
/*  95 */         setChainingMode(ChainingMode.cbc);
/*     */         break;
/*     */       case 2:
/*  98 */         setChainingMode(ChainingMode.cfb);
/*     */         break;
/*     */       default:
/* 101 */         throw new EncryptedDocumentException("Unsupported chaining mode - " + cTPasswordKeyEncryptor.getCipherChaining().toString());
/*     */     } 
/*     */     
/* 104 */     if (!iterator.hasNext())
/*     */       return; 
/*     */     try {
/* 107 */       CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
/* 108 */       while (iterator.hasNext()) {
/* 109 */         CTCertificateKeyEncryptor cTCertificateKeyEncryptor = ((CTKeyEncryptor)iterator.next()).getEncryptedCertificateKey();
/* 110 */         AgileCertificateEntry agileCertificateEntry = new AgileCertificateEntry();
/* 111 */         agileCertificateEntry.certVerifier = cTCertificateKeyEncryptor.getCertVerifier();
/* 112 */         agileCertificateEntry.encryptedKey = cTCertificateKeyEncryptor.getEncryptedKeyValue();
/* 113 */         agileCertificateEntry.x509 = (X509Certificate)certificateFactory.generateCertificate(new ByteArrayInputStream(cTCertificateKeyEncryptor.getX509Certificate()));
/* 114 */         this.certList.add(agileCertificateEntry);
/*     */       } 
/* 116 */     } catch (GeneralSecurityException generalSecurityException) {
/* 117 */       throw new EncryptedDocumentException("can't parse X509 certificate", generalSecurityException);
/*     */     } 
/*     */   }
/*     */   public AgileEncryptionVerifier(CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode) {
/*     */     this.certList = new ArrayList<AgileCertificateEntry>();
/* 122 */     setCipherAlgorithm(paramCipherAlgorithm);
/* 123 */     setHashAlgorithm(paramHashAlgorithm);
/* 124 */     setChainingMode(paramChainingMode);
/* 125 */     setSpinCount(100000);
/*     */   }
/*     */   
/*     */   protected void setSalt(byte[] paramArrayOfbyte) {
/* 129 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != (getCipherAlgorithm()).blockSize) {
/* 130 */       throw new EncryptedDocumentException("invalid verifier salt");
/*     */     }
/* 132 */     super.setSalt(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setEncryptedVerifier(byte[] paramArrayOfbyte) {
/* 137 */     super.setEncryptedVerifier(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setEncryptedVerifierHash(byte[] paramArrayOfbyte) {
/* 142 */     super.setEncryptedVerifierHash(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setEncryptedKey(byte[] paramArrayOfbyte) {
/* 147 */     super.setEncryptedKey(paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   public void addCertificate(X509Certificate paramX509Certificate) {
/* 151 */     AgileCertificateEntry agileCertificateEntry = new AgileCertificateEntry();
/* 152 */     agileCertificateEntry.x509 = paramX509Certificate;
/* 153 */     this.certList.add(agileCertificateEntry);
/*     */   }
/*     */   
/*     */   public List<AgileCertificateEntry> getCertificates() {
/* 157 */     return this.certList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\agile\AgileEncryptionVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */