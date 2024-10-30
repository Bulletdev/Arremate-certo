/*     */ package org.apache.poi.poifs.crypt.dsig;
/*     */ 
/*     */ import java.security.PrivateKey;
/*     */ import java.security.Provider;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import javax.xml.crypto.URIDereferencer;
/*     */ import javax.xml.crypto.dsig.XMLSignatureFactory;
/*     */ import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.dsig.facets.KeyInfoSignatureFacet;
/*     */ import org.apache.poi.poifs.crypt.dsig.facets.OOXMLSignatureFacet;
/*     */ import org.apache.poi.poifs.crypt.dsig.facets.Office2010SignatureFacet;
/*     */ import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
/*     */ import org.apache.poi.poifs.crypt.dsig.facets.XAdESSignatureFacet;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.RevocationDataService;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.TimeStampService;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.TimeStampServiceValidator;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.w3c.dom.events.EventListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignatureConfig
/*     */ {
/*  65 */   private static final POILogger LOG = POILogFactory.getLogger(SignatureConfig.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private ThreadLocal<OPCPackage> opcPackage = new ThreadLocal<OPCPackage>();
/*  72 */   private ThreadLocal<XMLSignatureFactory> signatureFactory = new ThreadLocal<XMLSignatureFactory>();
/*  73 */   private ThreadLocal<KeyInfoFactory> keyInfoFactory = new ThreadLocal<KeyInfoFactory>();
/*  74 */   private ThreadLocal<Provider> provider = new ThreadLocal<Provider>();
/*     */   
/*  76 */   private List<SignatureFacet> signatureFacets = new ArrayList<SignatureFacet>();
/*  77 */   private HashAlgorithm digestAlgo = HashAlgorithm.sha1;
/*  78 */   private Date executionTime = new Date();
/*     */   
/*     */   private PrivateKey key;
/*     */   
/*     */   private List<X509Certificate> signingCertificateChain;
/*     */   
/*     */   private SignaturePolicyService signaturePolicyService;
/*     */   
/*  86 */   private URIDereferencer uriDereferencer = null;
/*  87 */   private String canonicalizationMethod = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
/*     */ 
/*     */   
/*     */   private boolean includeEntireCertificateChain = true;
/*     */   
/*     */   private boolean includeIssuerSerial = false;
/*     */   
/*     */   private boolean includeKeyValue = false;
/*     */   
/*  96 */   private TimeStampService tspService = (TimeStampService)new TSPTimeStampService();
/*     */ 
/*     */   
/*     */   private String tspUrl;
/*     */ 
/*     */   
/*     */   private boolean tspOldProtocol = false;
/*     */ 
/*     */   
/* 105 */   private HashAlgorithm tspDigestAlgo = null;
/*     */   
/*     */   private String tspUser;
/*     */   
/*     */   private String tspPass;
/*     */   
/*     */   private TimeStampServiceValidator tspValidator;
/* 112 */   private String tspRequestPolicy = "1.3.6.1.4.1.13762.3";
/* 113 */   private String userAgent = "POI XmlSign Service TSP Client";
/*     */ 
/*     */ 
/*     */   
/*     */   private String proxyUrl;
/*     */ 
/*     */ 
/*     */   
/*     */   private RevocationDataService revocationDataService;
/*     */ 
/*     */   
/* 124 */   private HashAlgorithm xadesDigestAlgo = null;
/* 125 */   private String xadesRole = null;
/* 126 */   private String xadesSignatureId = "idSignedProperties";
/*     */   private boolean xadesSignaturePolicyImplied = true;
/* 128 */   private String xadesCanonicalizationMethod = "http://www.w3.org/2001/10/xml-exc-c14n#";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean xadesIssuerNameNoReverseOrder = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   private String packageSignatureId = "idPackageSignature";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   private String signatureDescription = "Office OpenXML Document";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   EventListener signatureMarshalListener = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   Map<String, String> namespacePrefixes = new HashMap<String, String>();
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
/*     */   protected void init(boolean paramBoolean) {
/* 171 */     if (this.opcPackage == null) {
/* 172 */       throw new EncryptedDocumentException("opcPackage is null");
/*     */     }
/* 174 */     if (this.uriDereferencer == null) {
/* 175 */       this.uriDereferencer = new OOXMLURIDereferencer();
/*     */     }
/* 177 */     if (this.uriDereferencer instanceof SignatureConfigurable) {
/* 178 */       ((SignatureConfigurable)this.uriDereferencer).setSignatureConfig(this);
/*     */     }
/* 180 */     if (this.namespacePrefixes.isEmpty()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       this.namespacePrefixes.put("http://schemas.openxmlformats.org/package/2006/digital-signature", "mdssi");
/* 186 */       this.namespacePrefixes.put("http://uri.etsi.org/01903/v1.3.2#", "xd");
/*     */     } 
/*     */     
/* 189 */     if (paramBoolean)
/*     */       return; 
/* 191 */     if (this.signatureMarshalListener == null) {
/* 192 */       this.signatureMarshalListener = new SignatureMarshalListener();
/*     */     }
/*     */     
/* 195 */     if (this.signatureMarshalListener instanceof SignatureConfigurable) {
/* 196 */       ((SignatureConfigurable)this.signatureMarshalListener).setSignatureConfig(this);
/*     */     }
/*     */     
/* 199 */     if (this.tspService != null) {
/* 200 */       this.tspService.setSignatureConfig(this);
/*     */     }
/*     */     
/* 203 */     if (this.signatureFacets.isEmpty()) {
/* 204 */       addSignatureFacet((SignatureFacet)new OOXMLSignatureFacet());
/* 205 */       addSignatureFacet((SignatureFacet)new KeyInfoSignatureFacet());
/* 206 */       addSignatureFacet((SignatureFacet)new XAdESSignatureFacet());
/* 207 */       addSignatureFacet((SignatureFacet)new Office2010SignatureFacet());
/*     */     } 
/*     */     
/* 210 */     for (SignatureFacet signatureFacet : this.signatureFacets) {
/* 211 */       signatureFacet.setSignatureConfig(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSignatureFacet(SignatureFacet paramSignatureFacet) {
/* 219 */     this.signatureFacets.add(paramSignatureFacet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<SignatureFacet> getSignatureFacets() {
/* 226 */     return this.signatureFacets;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignatureFacets(List<SignatureFacet> paramList) {
/* 233 */     this.signatureFacets = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashAlgorithm getDigestAlgo() {
/* 240 */     return this.digestAlgo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDigestAlgo(HashAlgorithm paramHashAlgorithm) {
/* 247 */     this.digestAlgo = paramHashAlgorithm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPCPackage getOpcPackage() {
/* 254 */     return this.opcPackage.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOpcPackage(OPCPackage paramOPCPackage) {
/* 261 */     this.opcPackage.set(paramOPCPackage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrivateKey getKey() {
/* 268 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(PrivateKey paramPrivateKey) {
/* 275 */     this.key = paramPrivateKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<X509Certificate> getSigningCertificateChain() {
/* 283 */     return this.signingCertificateChain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSigningCertificateChain(List<X509Certificate> paramList) {
/* 292 */     this.signingCertificateChain = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExecutionTime() {
/* 300 */     return this.executionTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExecutionTime(Date paramDate) {
/* 307 */     this.executionTime = paramDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignaturePolicyService getSignaturePolicyService() {
/* 314 */     return this.signaturePolicyService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignaturePolicyService(SignaturePolicyService paramSignaturePolicyService) {
/* 321 */     this.signaturePolicyService = paramSignaturePolicyService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIDereferencer getUriDereferencer() {
/* 328 */     return this.uriDereferencer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUriDereferencer(URIDereferencer paramURIDereferencer) {
/* 335 */     this.uriDereferencer = paramURIDereferencer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSignatureDescription() {
/* 343 */     return this.signatureDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignatureDescription(String paramString) {
/* 351 */     this.signatureDescription = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCanonicalizationMethod() {
/* 358 */     return this.canonicalizationMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCanonicalizationMethod(String paramString) {
/* 365 */     this.canonicalizationMethod = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPackageSignatureId() {
/* 373 */     return this.packageSignatureId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPackageSignatureId(String paramString) {
/* 381 */     this.packageSignatureId = nvl(paramString, "xmldsig-" + UUID.randomUUID());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTspUrl() {
/* 388 */     return this.tspUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspUrl(String paramString) {
/* 395 */     this.tspUrl = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTspOldProtocol() {
/* 403 */     return this.tspOldProtocol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspOldProtocol(boolean paramBoolean) {
/* 411 */     this.tspOldProtocol = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashAlgorithm getTspDigestAlgo() {
/* 419 */     return nvl(this.tspDigestAlgo, this.digestAlgo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspDigestAlgo(HashAlgorithm paramHashAlgorithm) {
/* 427 */     this.tspDigestAlgo = paramHashAlgorithm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProxyUrl() {
/* 435 */     return this.proxyUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProxyUrl(String paramString) {
/* 443 */     this.proxyUrl = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeStampService getTspService() {
/* 450 */     return this.tspService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspService(TimeStampService paramTimeStampService) {
/* 457 */     this.tspService = paramTimeStampService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTspUser() {
/* 464 */     return this.tspUser;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspUser(String paramString) {
/* 471 */     this.tspUser = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTspPass() {
/* 478 */     return this.tspPass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspPass(String paramString) {
/* 485 */     this.tspPass = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeStampServiceValidator getTspValidator() {
/* 492 */     return this.tspValidator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspValidator(TimeStampServiceValidator paramTimeStampServiceValidator) {
/* 499 */     this.tspValidator = paramTimeStampServiceValidator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RevocationDataService getRevocationDataService() {
/* 507 */     return this.revocationDataService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRevocationDataService(RevocationDataService paramRevocationDataService) {
/* 515 */     this.revocationDataService = paramRevocationDataService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashAlgorithm getXadesDigestAlgo() {
/* 522 */     return nvl(this.xadesDigestAlgo, this.digestAlgo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXadesDigestAlgo(HashAlgorithm paramHashAlgorithm) {
/* 530 */     this.xadesDigestAlgo = paramHashAlgorithm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUserAgent() {
/* 537 */     return this.userAgent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserAgent(String paramString) {
/* 544 */     this.userAgent = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTspRequestPolicy() {
/* 552 */     return this.tspRequestPolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTspRequestPolicy(String paramString) {
/* 559 */     this.tspRequestPolicy = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncludeEntireCertificateChain() {
/* 567 */     return this.includeEntireCertificateChain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeEntireCertificateChain(boolean paramBoolean) {
/* 575 */     this.includeEntireCertificateChain = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncludeIssuerSerial() {
/* 582 */     return this.includeIssuerSerial;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeIssuerSerial(boolean paramBoolean) {
/* 589 */     this.includeIssuerSerial = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIncludeKeyValue() {
/* 596 */     return this.includeKeyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludeKeyValue(boolean paramBoolean) {
/* 603 */     this.includeKeyValue = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXadesRole() {
/* 611 */     return this.xadesRole;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXadesRole(String paramString) {
/* 618 */     this.xadesRole = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXadesSignatureId() {
/* 626 */     return nvl(this.xadesSignatureId, "idSignedProperties");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXadesSignatureId(String paramString) {
/* 634 */     this.xadesSignatureId = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isXadesSignaturePolicyImplied() {
/* 642 */     return this.xadesSignaturePolicyImplied;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXadesSignaturePolicyImplied(boolean paramBoolean) {
/* 649 */     this.xadesSignaturePolicyImplied = paramBoolean;
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
/*     */   public boolean isXadesIssuerNameNoReverseOrder() {
/* 662 */     return this.xadesIssuerNameNoReverseOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXadesIssuerNameNoReverseOrder(boolean paramBoolean) {
/* 669 */     this.xadesIssuerNameNoReverseOrder = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EventListener getSignatureMarshalListener() {
/* 679 */     return this.signatureMarshalListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignatureMarshalListener(EventListener paramEventListener) {
/* 687 */     this.signatureMarshalListener = paramEventListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getNamespacePrefixes() {
/* 694 */     return this.namespacePrefixes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNamespacePrefixes(Map<String, String> paramMap) {
/* 701 */     this.namespacePrefixes = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static <T> T nvl(T paramT1, T paramT2) {
/* 711 */     return (paramT1 == null) ? paramT2 : paramT1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getHashMagic() {
/*     */     byte[] arrayOfByte;
/* 723 */     switch (getDigestAlgo()) { case sha1:
/* 724 */         arrayOfByte = new byte[] { 48, 31, 48, 7, 6, 5, 43, 14, 3, 2, 26, 4, 20 };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 760 */         return arrayOfByte;case sha224: arrayOfByte = new byte[] { 48, 43, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 4, 4, 28 }; return arrayOfByte;case sha256: arrayOfByte = new byte[] { 48, 47, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 1, 4, 32 }; return arrayOfByte;case sha384: arrayOfByte = new byte[] { 48, 63, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 2, 4, 48 }; return arrayOfByte;case sha512: arrayOfByte = new byte[] { 48, 79, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 3, 4, 64 }; return arrayOfByte;case ripemd128: arrayOfByte = new byte[] { 48, 27, 48, 7, 6, 5, 43, 36, 3, 2, 2, 4, 16 }; return arrayOfByte;case ripemd160: arrayOfByte = new byte[] { 48, 31, 48, 7, 6, 5, 43, 36, 3, 2, 1, 4, 20 }; return arrayOfByte; }
/*     */     
/*     */     throw new EncryptedDocumentException("Hash algorithm " + getDigestAlgo() + " not supported for signing.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSignatureMethodUri() {
/* 768 */     switch (getDigestAlgo()) { case sha1:
/* 769 */         return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
/* 770 */       case sha224: return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha224";
/* 771 */       case sha256: return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
/* 772 */       case sha384: return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384";
/* 773 */       case sha512: return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
/* 774 */       case ripemd160: return "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160"; }
/* 775 */      throw new EncryptedDocumentException("Hash algorithm " + getDigestAlgo() + " not supported for signing.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDigestMethodUri() {
/* 784 */     return getDigestMethodUri(getDigestAlgo());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDigestMethodUri(HashAlgorithm paramHashAlgorithm) {
/* 792 */     switch (paramHashAlgorithm) { case sha1:
/* 793 */         return "http://www.w3.org/2000/09/xmldsig#sha1";
/* 794 */       case sha224: return "http://www.w3.org/2001/04/xmldsig-more#sha224";
/* 795 */       case sha256: return "http://www.w3.org/2001/04/xmlenc#sha256";
/* 796 */       case sha384: return "http://www.w3.org/2001/04/xmldsig-more#sha384";
/* 797 */       case sha512: return "http://www.w3.org/2001/04/xmlenc#sha512";
/* 798 */       case ripemd160: return "http://www.w3.org/2001/04/xmlenc#ripemd160"; }
/* 799 */      throw new EncryptedDocumentException("Hash algorithm " + paramHashAlgorithm + " not supported for signing.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignatureFactory(XMLSignatureFactory paramXMLSignatureFactory) {
/* 808 */     this.signatureFactory.set(paramXMLSignatureFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLSignatureFactory getSignatureFactory() {
/* 815 */     XMLSignatureFactory xMLSignatureFactory = this.signatureFactory.get();
/* 816 */     if (xMLSignatureFactory == null) {
/* 817 */       xMLSignatureFactory = XMLSignatureFactory.getInstance("DOM", getProvider());
/* 818 */       setSignatureFactory(xMLSignatureFactory);
/*     */     } 
/* 820 */     return xMLSignatureFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyInfoFactory(KeyInfoFactory paramKeyInfoFactory) {
/* 827 */     this.keyInfoFactory.set(paramKeyInfoFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyInfoFactory getKeyInfoFactory() {
/* 834 */     KeyInfoFactory keyInfoFactory = this.keyInfoFactory.get();
/* 835 */     if (keyInfoFactory == null) {
/* 836 */       keyInfoFactory = KeyInfoFactory.getInstance("DOM", getProvider());
/* 837 */       setKeyInfoFactory(keyInfoFactory);
/*     */     } 
/* 839 */     return keyInfoFactory;
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
/*     */   public Provider getProvider() {
/* 856 */     Provider provider = this.provider.get();
/* 857 */     if (provider == null) {
/* 858 */       String[] arrayOfString = { System.getProperty("jsr105Provider"), "org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI", "org.jcp.xml.dsig.internal.dom.XMLDSigRI" };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 863 */       for (String str : arrayOfString) {
/* 864 */         if (str != null) {
/*     */           try {
/* 866 */             provider = (Provider)Class.forName(str).newInstance();
/*     */             break;
/* 868 */           } catch (Exception exception) {
/* 869 */             LOG.log(1, new Object[] { "XMLDsig-Provider '" + str + "' can't be found - trying next." });
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 874 */     if (provider == null) {
/* 875 */       throw new RuntimeException("JRE doesn't support default xml signature provider - set jsr105Provider system property!");
/*     */     }
/*     */     
/* 878 */     return provider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXadesCanonicalizationMethod() {
/* 887 */     return this.xadesCanonicalizationMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXadesCanonicalizationMethod(String paramString) {
/* 895 */     this.xadesCanonicalizationMethod = paramString;
/*     */   }
/*     */   
/*     */   public static interface SignatureConfigurable {
/*     */     void setSignatureConfig(SignatureConfig param1SignatureConfig);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\SignatureConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */