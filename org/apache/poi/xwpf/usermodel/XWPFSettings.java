/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.math.BigInteger;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;
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
/*     */ public class XWPFSettings
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTSettings ctSettings;
/*     */   
/*     */   public XWPFSettings(PackagePart paramPackagePart) throws IOException {
/*  56 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFSettings(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  64 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   public XWPFSettings() {
/*  69 */     this.ctSettings = CTSettings.Factory.newInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*  74 */     super.onDocumentRead();
/*  75 */     readFrom(getPackagePart().getInputStream());
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
/*     */   public long getZoomPercent() {
/*     */     CTZoom cTZoom;
/*  92 */     if (!this.ctSettings.isSetZoom()) {
/*  93 */       cTZoom = this.ctSettings.addNewZoom();
/*     */     } else {
/*  95 */       cTZoom = this.ctSettings.getZoom();
/*     */     } 
/*     */ 
/*     */     
/*  99 */     BigInteger bigInteger = cTZoom.getPercent();
/* 100 */     if (bigInteger == null) {
/* 101 */       return 100L;
/*     */     }
/* 103 */     return bigInteger.longValue();
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
/*     */   public void setZoomPercent(long paramLong) {
/* 117 */     if (!this.ctSettings.isSetZoom()) {
/* 118 */       this.ctSettings.addNewZoom();
/*     */     }
/* 120 */     CTZoom cTZoom = this.ctSettings.getZoom();
/* 121 */     cTZoom.setPercent(BigInteger.valueOf(paramLong));
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
/*     */   public boolean isEnforcedWith() {
/* 138 */     CTDocProtect cTDocProtect = this.ctSettings.getDocumentProtection();
/*     */     
/* 140 */     if (cTDocProtect == null) {
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     return cTDocProtect.getEnforcement().equals(STOnOff.X_1);
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
/*     */   public boolean isEnforcedWith(STDocProtect.Enum paramEnum) {
/* 162 */     CTDocProtect cTDocProtect = this.ctSettings.getDocumentProtection();
/*     */     
/* 164 */     if (cTDocProtect == null) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     return (cTDocProtect.getEnforcement().equals(STOnOff.X_1) && cTDocProtect.getEdit().equals(paramEnum));
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
/*     */   public void setEnforcementEditValue(STDocProtect.Enum paramEnum) {
/* 185 */     safeGetDocumentProtection().setEnforcement(STOnOff.X_1);
/* 186 */     safeGetDocumentProtection().setEdit(paramEnum);
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
/*     */   public void setEnforcementEditValue(STDocProtect.Enum paramEnum, String paramString, HashAlgorithm paramHashAlgorithm) {
/* 208 */     safeGetDocumentProtection().setEnforcement(STOnOff.X_1);
/* 209 */     safeGetDocumentProtection().setEdit(paramEnum);
/*     */     
/* 211 */     if (paramString == null) {
/* 212 */       if (safeGetDocumentProtection().isSetCryptProviderType()) {
/* 213 */         safeGetDocumentProtection().unsetCryptProviderType();
/*     */       }
/*     */       
/* 216 */       if (safeGetDocumentProtection().isSetCryptAlgorithmClass()) {
/* 217 */         safeGetDocumentProtection().unsetCryptAlgorithmClass();
/*     */       }
/*     */       
/* 220 */       if (safeGetDocumentProtection().isSetCryptAlgorithmType()) {
/* 221 */         safeGetDocumentProtection().unsetCryptAlgorithmType();
/*     */       }
/*     */       
/* 224 */       if (safeGetDocumentProtection().isSetCryptAlgorithmSid()) {
/* 225 */         safeGetDocumentProtection().unsetCryptAlgorithmSid();
/*     */       }
/*     */       
/* 228 */       if (safeGetDocumentProtection().isSetSalt()) {
/* 229 */         safeGetDocumentProtection().unsetSalt();
/*     */       }
/*     */       
/* 232 */       if (safeGetDocumentProtection().isSetCryptSpinCount()) {
/* 233 */         safeGetDocumentProtection().unsetCryptSpinCount();
/*     */       }
/*     */       
/* 236 */       if (safeGetDocumentProtection().isSetHash()) {
/* 237 */         safeGetDocumentProtection().unsetHash();
/*     */       }
/*     */     } else {
/*     */       STCryptProv.Enum enum_;
/*     */       byte b;
/* 242 */       if (paramHashAlgorithm == null) {
/* 243 */         paramHashAlgorithm = HashAlgorithm.sha1;
/*     */       }
/*     */       
/* 246 */       switch (paramHashAlgorithm) {
/*     */         case md2:
/* 248 */           enum_ = STCryptProv.RSA_FULL;
/* 249 */           b = 1;
/*     */           break;
/*     */         case md4:
/* 252 */           enum_ = STCryptProv.RSA_FULL;
/* 253 */           b = 2;
/*     */           break;
/*     */         case md5:
/* 256 */           enum_ = STCryptProv.RSA_FULL;
/* 257 */           b = 3;
/*     */           break;
/*     */         case sha1:
/* 260 */           enum_ = STCryptProv.RSA_FULL;
/* 261 */           b = 4;
/*     */           break;
/*     */         case sha256:
/* 264 */           enum_ = STCryptProv.RSA_AES;
/* 265 */           b = 12;
/*     */           break;
/*     */         case sha384:
/* 268 */           enum_ = STCryptProv.RSA_AES;
/* 269 */           b = 13;
/*     */           break;
/*     */         case sha512:
/* 272 */           enum_ = STCryptProv.RSA_AES;
/* 273 */           b = 14;
/*     */           break;
/*     */         default:
/* 276 */           throw new EncryptedDocumentException("Hash algorithm '" + paramHashAlgorithm + "' is not supported for document write protection.");
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 281 */       SecureRandom secureRandom = new SecureRandom();
/* 282 */       byte[] arrayOfByte1 = secureRandom.generateSeed(16);
/*     */ 
/*     */ 
/*     */       
/* 286 */       int i = 100000;
/*     */       
/* 288 */       String str = CryptoFunctions.xorHashPasswordReversed(paramString);
/*     */ 
/*     */ 
/*     */       
/* 292 */       byte[] arrayOfByte2 = CryptoFunctions.hashPassword(str, paramHashAlgorithm, arrayOfByte1, i, false);
/*     */       
/* 294 */       safeGetDocumentProtection().setSalt(arrayOfByte1);
/* 295 */       safeGetDocumentProtection().setHash(arrayOfByte2);
/* 296 */       safeGetDocumentProtection().setCryptSpinCount(BigInteger.valueOf(i));
/* 297 */       safeGetDocumentProtection().setCryptAlgorithmType(STAlgType.TYPE_ANY);
/* 298 */       safeGetDocumentProtection().setCryptAlgorithmClass(STAlgClass.HASH);
/* 299 */       safeGetDocumentProtection().setCryptProviderType(enum_);
/* 300 */       safeGetDocumentProtection().setCryptAlgorithmSid(BigInteger.valueOf(b));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean validateProtectionPassword(String paramString) {
/*     */     HashAlgorithm hashAlgorithm;
/*     */     String str;
/*     */     byte[] arrayOfByte3;
/* 311 */     BigInteger bigInteger1 = safeGetDocumentProtection().getCryptAlgorithmSid();
/* 312 */     byte[] arrayOfByte1 = safeGetDocumentProtection().getHash();
/* 313 */     byte[] arrayOfByte2 = safeGetDocumentProtection().getSalt();
/* 314 */     BigInteger bigInteger2 = safeGetDocumentProtection().getCryptSpinCount();
/*     */     
/* 316 */     if (bigInteger1 == null || arrayOfByte1 == null || arrayOfByte2 == null || bigInteger2 == null) return false;
/*     */ 
/*     */     
/* 319 */     switch (bigInteger1.intValue()) {
/*     */       case 1:
/* 321 */         hashAlgorithm = HashAlgorithm.md2;
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
/* 345 */         str = CryptoFunctions.xorHashPasswordReversed(paramString);
/*     */ 
/*     */ 
/*     */         
/* 349 */         arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false);
/*     */         
/* 351 */         return Arrays.equals(arrayOfByte1, arrayOfByte3);case 2: hashAlgorithm = HashAlgorithm.md4; str = CryptoFunctions.xorHashPasswordReversed(paramString); arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false); return Arrays.equals(arrayOfByte1, arrayOfByte3);case 3: hashAlgorithm = HashAlgorithm.md5; str = CryptoFunctions.xorHashPasswordReversed(paramString); arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false); return Arrays.equals(arrayOfByte1, arrayOfByte3);case 4: hashAlgorithm = HashAlgorithm.sha1; str = CryptoFunctions.xorHashPasswordReversed(paramString); arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false); return Arrays.equals(arrayOfByte1, arrayOfByte3);case 12: hashAlgorithm = HashAlgorithm.sha256; str = CryptoFunctions.xorHashPasswordReversed(paramString); arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false); return Arrays.equals(arrayOfByte1, arrayOfByte3);case 13: hashAlgorithm = HashAlgorithm.sha384; str = CryptoFunctions.xorHashPasswordReversed(paramString); arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false); return Arrays.equals(arrayOfByte1, arrayOfByte3);case 14: hashAlgorithm = HashAlgorithm.sha512; str = CryptoFunctions.xorHashPasswordReversed(paramString); arrayOfByte3 = CryptoFunctions.hashPassword(str, hashAlgorithm, arrayOfByte2, bigInteger2.intValue(), false); return Arrays.equals(arrayOfByte1, arrayOfByte3);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeEnforcement() {
/* 360 */     safeGetDocumentProtection().setEnforcement(STOnOff.X_0);
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
/*     */   public void setUpdateFields() {
/* 376 */     CTOnOff cTOnOff = CTOnOff.Factory.newInstance();
/* 377 */     cTOnOff.setVal(STOnOff.TRUE);
/* 378 */     this.ctSettings.setUpdateFields(cTOnOff);
/*     */   }
/*     */   
/*     */   boolean isUpdateFields() {
/* 382 */     return (this.ctSettings.isSetUpdateFields() && this.ctSettings.getUpdateFields().getVal() == STOnOff.TRUE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTrackRevisions() {
/* 391 */     return this.ctSettings.isSetTrackRevisions();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrackRevisions(boolean paramBoolean) {
/* 400 */     if (paramBoolean) {
/* 401 */       if (!this.ctSettings.isSetTrackRevisions()) {
/* 402 */         this.ctSettings.addNewTrackRevisions();
/*     */       }
/*     */     }
/* 405 */     else if (this.ctSettings.isSetTrackRevisions()) {
/* 406 */       this.ctSettings.unsetTrackRevisions();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 413 */     if (this.ctSettings == null) {
/* 414 */       throw new IllegalStateException("Unable to write out settings that were never read in!");
/*     */     }
/*     */     
/* 417 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 418 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTSettings.type.getName().getNamespaceURI(), "settings"));
/*     */     
/* 420 */     PackagePart packagePart = getPackagePart();
/* 421 */     OutputStream outputStream = packagePart.getOutputStream();
/* 422 */     this.ctSettings.save(outputStream, xmlOptions);
/* 423 */     outputStream.close();
/*     */   }
/*     */   
/*     */   private CTDocProtect safeGetDocumentProtection() {
/* 427 */     CTDocProtect cTDocProtect = this.ctSettings.getDocumentProtection();
/* 428 */     if (cTDocProtect == null) {
/* 429 */       cTDocProtect = CTDocProtect.Factory.newInstance();
/* 430 */       this.ctSettings.setDocumentProtection(cTDocProtect);
/*     */     } 
/* 432 */     return this.ctSettings.getDocumentProtection();
/*     */   }
/*     */   
/*     */   private void readFrom(InputStream paramInputStream) {
/*     */     try {
/* 437 */       this.ctSettings = SettingsDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSettings();
/* 438 */     } catch (Exception exception) {
/* 439 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */