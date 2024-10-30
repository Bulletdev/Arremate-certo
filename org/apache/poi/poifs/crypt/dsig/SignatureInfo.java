/*     */ package org.apache.poi.poifs.crypt.dsig;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.Provider;
/*     */ import java.security.Security;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.xml.crypto.MarshalException;
/*     */ import javax.xml.crypto.URIDereferencer;
/*     */ import javax.xml.crypto.XMLStructure;
/*     */ import javax.xml.crypto.dsig.CanonicalizationMethod;
/*     */ import javax.xml.crypto.dsig.Manifest;
/*     */ import javax.xml.crypto.dsig.Reference;
/*     */ import javax.xml.crypto.dsig.SignatureMethod;
/*     */ import javax.xml.crypto.dsig.SignedInfo;
/*     */ import javax.xml.crypto.dsig.XMLObject;
/*     */ import javax.xml.crypto.dsig.XMLSignContext;
/*     */ import javax.xml.crypto.dsig.XMLSignature;
/*     */ import javax.xml.crypto.dsig.XMLSignatureException;
/*     */ import javax.xml.crypto.dsig.XMLSignatureFactory;
/*     */ import javax.xml.crypto.dsig.XMLValidateContext;
/*     */ import javax.xml.crypto.dsig.dom.DOMSignContext;
/*     */ import javax.xml.crypto.dsig.dom.DOMValidateContext;
/*     */ import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.xpath.XPath;
/*     */ import javax.xml.xpath.XPathConstants;
/*     */ import javax.xml.xpath.XPathExpressionException;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
/*     */ import org.apache.jcp.xml.dsig.internal.dom.DOMSignedInfo;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.openxml4j.opc.TargetMode;
/*     */ import org.apache.poi.poifs.crypt.ChainingMode;
/*     */ import org.apache.poi.poifs.crypt.CipherAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.xml.security.Init;
/*     */ import org.apache.xml.security.utils.Base64;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.f.a.a.a.f;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.events.EventListener;
/*     */ import org.w3c.dom.events.EventTarget;
/*     */ import org.xml.sax.SAXException;
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
/*     */ public class SignatureInfo
/*     */   implements SignatureConfig.SignatureConfigurable
/*     */ {
/* 173 */   private static final POILogger LOG = POILogFactory.getLogger(SignatureInfo.class);
/*     */   private static boolean isInitialized = false;
/*     */   private SignatureConfig signatureConfig;
/*     */   
/*     */   public class SignaturePart
/*     */   {
/*     */     private final PackagePart signaturePart;
/*     */     private X509Certificate signer;
/*     */     private List<X509Certificate> certChain;
/*     */     
/*     */     private SignaturePart(PackagePart param1PackagePart) {
/* 184 */       this.signaturePart = param1PackagePart;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PackagePart getPackagePart() {
/* 191 */       return this.signaturePart;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public X509Certificate getSigner() {
/* 198 */       return this.signer;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<X509Certificate> getCertChain() {
/* 205 */       return this.certChain;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public f getSignatureDocument() throws IOException, XmlException {
/* 217 */       return f.a.a(this.signaturePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean validate() {
/* 227 */       KeyInfoKeySelector keyInfoKeySelector = new KeyInfoKeySelector();
/*     */       try {
/* 229 */         Document document = DocumentHelper.readDocument(this.signaturePart.getInputStream());
/* 230 */         XPath xPath = XPathFactory.newInstance().newXPath();
/* 231 */         NodeList nodeList = (NodeList)xPath.compile("//*[@Id]").evaluate(document, (b)XPathConstants.NODESET);
/* 232 */         int i = nodeList.getLength();
/* 233 */         for (byte b = 0; b < i; b++) {
/* 234 */           ((Element)nodeList.item(b)).setIdAttribute("Id", true);
/*     */         }
/*     */         
/* 237 */         DOMValidateContext dOMValidateContext = new DOMValidateContext(keyInfoKeySelector, document);
/* 238 */         dOMValidateContext.setProperty("org.jcp.xml.dsig.validateManifests", Boolean.TRUE);
/* 239 */         dOMValidateContext.setURIDereferencer(SignatureInfo.this.signatureConfig.getUriDereferencer());
/* 240 */         SignatureInfo.this.brokenJvmWorkaround(dOMValidateContext);
/*     */         
/* 242 */         XMLSignatureFactory xMLSignatureFactory = SignatureInfo.this.signatureConfig.getSignatureFactory();
/* 243 */         XMLSignature xMLSignature = xMLSignatureFactory.unmarshalXMLSignature(dOMValidateContext);
/*     */ 
/*     */ 
/*     */         
/* 247 */         for (Reference reference : xMLSignature.getSignedInfo().getReferences()) {
/* 248 */           SignatureFacet.brokenJvmWorkaround(reference);
/*     */         }
/* 250 */         for (XMLObject xMLObject : xMLSignature.getObjects()) {
/* 251 */           for (XMLStructure xMLStructure : xMLObject.getContent()) {
/* 252 */             if (xMLStructure instanceof Manifest) {
/* 253 */               for (Reference reference : ((Manifest)xMLStructure).getReferences()) {
/* 254 */                 SignatureFacet.brokenJvmWorkaround(reference);
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 260 */         boolean bool = xMLSignature.validate(dOMValidateContext);
/*     */         
/* 262 */         if (bool) {
/* 263 */           this.signer = keyInfoKeySelector.getSigner();
/* 264 */           this.certChain = keyInfoKeySelector.getCertChain();
/*     */         } 
/*     */         
/* 267 */         return bool;
/* 268 */       } catch (IOException iOException) {
/* 269 */         String str = "error in reading document";
/* 270 */         SignatureInfo.LOG.log(7, new Object[] { str, iOException });
/* 271 */         throw new EncryptedDocumentException(str, iOException);
/* 272 */       } catch (SAXException sAXException) {
/* 273 */         String str = "error in parsing document";
/* 274 */         SignatureInfo.LOG.log(7, new Object[] { str, sAXException });
/* 275 */         throw new EncryptedDocumentException(str, sAXException);
/* 276 */       } catch (XPathExpressionException xPathExpressionException) {
/* 277 */         String str = "error in searching document with xpath expression";
/* 278 */         SignatureInfo.LOG.log(7, new Object[] { str, xPathExpressionException });
/* 279 */         throw new EncryptedDocumentException(str, xPathExpressionException);
/* 280 */       } catch (MarshalException marshalException) {
/* 281 */         String str = "error in unmarshalling the signature";
/* 282 */         SignatureInfo.LOG.log(7, new Object[] { str, marshalException });
/* 283 */         throw new EncryptedDocumentException(str, marshalException);
/* 284 */       } catch (XMLSignatureException xMLSignatureException) {
/* 285 */         String str = "error in validating the signature";
/* 286 */         SignatureInfo.LOG.log(7, new Object[] { str, xMLSignatureException });
/* 287 */         throw new EncryptedDocumentException(str, xMLSignatureException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignatureInfo() {
/* 296 */     initXmlProvider();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SignatureConfig getSignatureConfig() {
/* 303 */     return this.signatureConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSignatureConfig(SignatureConfig paramSignatureConfig) {
/* 310 */     this.signatureConfig = paramSignatureConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean verifySignature() {
/* 318 */     Iterator<SignaturePart> iterator = getSignatureParts().iterator(); if (iterator.hasNext()) { SignaturePart signaturePart = iterator.next();
/*     */       
/* 320 */       return signaturePart.validate(); }
/*     */     
/* 322 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void confirmSignature() throws XMLSignatureException, MarshalException {
/* 332 */     Document document = DocumentHelper.createDocument();
/*     */ 
/*     */     
/* 335 */     DigestInfo digestInfo = preSign(document, null);
/*     */ 
/*     */     
/* 338 */     byte[] arrayOfByte = signDigest(digestInfo.digestValue);
/*     */ 
/*     */     
/* 341 */     postSign(document, arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] signDigest(byte[] paramArrayOfbyte) {
/* 352 */     Cipher cipher = CryptoFunctions.getCipher(this.signatureConfig.getKey(), CipherAlgorithm.rsa, ChainingMode.ecb, null, 1, "PKCS1Padding");
/*     */ 
/*     */     
/*     */     try {
/* 356 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 357 */       byteArrayOutputStream.write(this.signatureConfig.getHashMagic());
/* 358 */       byteArrayOutputStream.write(paramArrayOfbyte);
/* 359 */       byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 360 */       return cipher.doFinal(arrayOfByte);
/*     */     }
/* 362 */     catch (Exception exception) {
/* 363 */       throw new EncryptedDocumentException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<SignaturePart> getSignatureParts() {
/* 372 */     this.signatureConfig.init(true);
/* 373 */     return new Iterable<SignaturePart>() {
/*     */         public Iterator<SignatureInfo.SignaturePart> iterator() {
/* 375 */           return new Iterator<SignatureInfo.SignaturePart>() {
/* 376 */               OPCPackage pkg = SignatureInfo.this.signatureConfig.getOpcPackage();
/* 377 */               Iterator<PackageRelationship> sigOrigRels = this.pkg.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/origin").iterator();
/*     */               
/* 379 */               Iterator<PackageRelationship> sigRels = null;
/* 380 */               PackagePart sigPart = null;
/*     */               
/*     */               public boolean hasNext() {
/* 383 */                 while (this.sigRels == null || !this.sigRels.hasNext()) {
/* 384 */                   if (!this.sigOrigRels.hasNext()) return false; 
/* 385 */                   this.sigPart = this.pkg.getPart(this.sigOrigRels.next());
/* 386 */                   SignatureInfo.LOG.log(1, new Object[] { "Digital Signature Origin part", this.sigPart });
/*     */                   try {
/* 388 */                     this.sigRels = this.sigPart.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/signature").iterator();
/* 389 */                   } catch (InvalidFormatException invalidFormatException) {
/* 390 */                     SignatureInfo.LOG.log(5, new Object[] { "Reference to signature is invalid.", invalidFormatException });
/*     */                   } 
/*     */                 } 
/* 393 */                 return true;
/*     */               }
/*     */               
/*     */               public SignatureInfo.SignaturePart next() {
/* 397 */                 PackagePart packagePart = null;
/*     */                 while (true) {
/*     */                   try {
/* 400 */                     if (!hasNext()) throw new NoSuchElementException(); 
/* 401 */                     packagePart = this.sigPart.getRelatedPart(this.sigRels.next());
/* 402 */                     SignatureInfo.LOG.log(1, new Object[] { "XML Signature part", packagePart });
/* 403 */                   } catch (InvalidFormatException invalidFormatException) {
/* 404 */                     SignatureInfo.LOG.log(5, new Object[] { "Reference to signature is invalid.", invalidFormatException });
/*     */                   } 
/* 406 */                   if (this.sigPart != null)
/* 407 */                     return new SignatureInfo.SignaturePart(packagePart); 
/*     */                 } 
/*     */               }
/*     */               public void remove() {
/* 411 */                 throw new UnsupportedOperationException();
/*     */               }
/*     */             };
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static synchronized void initXmlProvider() {
/* 422 */     if (isInitialized)
/* 423 */       return;  isInitialized = true;
/*     */     
/*     */     try {
/* 426 */       Init.init();
/* 427 */       RelationshipTransformService.registerDsigProvider();
/* 428 */       CryptoFunctions.registerBouncyCastle();
/* 429 */     } catch (Exception exception) {
/* 430 */       throw new RuntimeException("Xml & BouncyCastle-Provider initialization failed", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DigestInfo preSign(Document paramDocument, List<DigestInfo> paramList) throws XMLSignatureException, MarshalException {
/*     */     SignedInfo signedInfo;
/* 441 */     this.signatureConfig.init(false);
/*     */ 
/*     */ 
/*     */     
/* 445 */     EventTarget eventTarget = (EventTarget)paramDocument;
/* 446 */     EventListener eventListener = this.signatureConfig.getSignatureMarshalListener();
/* 447 */     if (eventListener != null) {
/* 448 */       if (eventListener instanceof SignatureMarshalListener) {
/* 449 */         ((SignatureMarshalListener)eventListener).setEventTarget(eventTarget);
/*     */       }
/* 451 */       SignatureMarshalListener.setListener(eventTarget, eventListener, true);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     DOMSignContext dOMSignContext = new DOMSignContext(this.signatureConfig.getKey(), paramDocument);
/* 458 */     URIDereferencer uRIDereferencer = this.signatureConfig.getUriDereferencer();
/* 459 */     if (null != uRIDereferencer) {
/* 460 */       dOMSignContext.setURIDereferencer(uRIDereferencer);
/*     */     }
/*     */     
/* 463 */     for (Map.Entry<String, String> entry : this.signatureConfig.getNamespacePrefixes().entrySet()) {
/* 464 */       dOMSignContext.putNamespacePrefix((String)entry.getKey(), (String)entry.getValue());
/*     */     }
/* 466 */     dOMSignContext.setDefaultNamespacePrefix("");
/*     */ 
/*     */     
/* 469 */     brokenJvmWorkaround(dOMSignContext);
/*     */     
/* 471 */     XMLSignatureFactory xMLSignatureFactory = this.signatureConfig.getSignatureFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 476 */     ArrayList<Reference> arrayList = new ArrayList();
/* 477 */     for (DigestInfo digestInfo : safe(paramList)) {
/* 478 */       byte[] arrayOfByte = digestInfo.digestValue;
/*     */       
/* 480 */       String str = (new File(digestInfo.description)).getName();
/* 481 */       Reference reference = SignatureFacet.newReference(str, null, null, null, arrayOfByte, this.signatureConfig);
/*     */       
/* 483 */       arrayList.add(reference);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 489 */     ArrayList arrayList1 = new ArrayList();
/* 490 */     for (SignatureFacet signatureFacet : this.signatureConfig.getSignatureFacets()) {
/* 491 */       LOG.log(1, new Object[] { "invoking signature facet: " + signatureFacet.getClass().getSimpleName() });
/* 492 */       signatureFacet.preSign(paramDocument, arrayList, arrayList1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 500 */       SignatureMethod signatureMethod = xMLSignatureFactory.newSignatureMethod(this.signatureConfig.getSignatureMethodUri(), null);
/*     */       
/* 502 */       CanonicalizationMethod canonicalizationMethod = xMLSignatureFactory.newCanonicalizationMethod(this.signatureConfig.getCanonicalizationMethod(), (C14NMethodParameterSpec)null);
/*     */ 
/*     */       
/* 505 */       signedInfo = xMLSignatureFactory.newSignedInfo(canonicalizationMethod, signatureMethod, arrayList);
/*     */     }
/* 507 */     catch (GeneralSecurityException generalSecurityException) {
/* 508 */       throw new XMLSignatureException(generalSecurityException);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 514 */     String str1 = this.signatureConfig.getPackageSignatureId() + "-signature-value";
/* 515 */     XMLSignature xMLSignature = xMLSignatureFactory.newXMLSignature(signedInfo, null, arrayList1, this.signatureConfig.getPackageSignatureId(), str1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 522 */     xMLSignature.sign(dOMSignContext);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 527 */     for (XMLObject xMLObject : arrayList1) {
/* 528 */       LOG.log(1, new Object[] { "object java type: " + xMLObject.getClass().getName() });
/* 529 */       List list1 = xMLObject.getContent();
/* 530 */       for (XMLStructure xMLStructure : list1) {
/* 531 */         LOG.log(1, new Object[] { "object content java type: " + xMLStructure.getClass().getName() });
/* 532 */         if (!(xMLStructure instanceof Manifest))
/* 533 */           continue;  Manifest manifest = (Manifest)xMLStructure;
/* 534 */         List list2 = manifest.getReferences();
/* 535 */         for (Reference reference : list2) {
/* 536 */           if (reference.getDigestValue() != null)
/*     */             continue; 
/* 538 */           DOMReference dOMReference = (DOMReference)reference;
/* 539 */           dOMReference.digest(dOMSignContext);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 547 */     List list = signedInfo.getReferences();
/* 548 */     for (Reference reference : list) {
/* 549 */       DOMReference dOMReference = (DOMReference)reference;
/*     */ 
/*     */       
/* 552 */       if (dOMReference.getDigestValue() != null)
/*     */         continue; 
/* 554 */       dOMReference.digest(dOMSignContext);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 560 */     DOMSignedInfo dOMSignedInfo = (DOMSignedInfo)signedInfo;
/* 561 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 562 */     dOMSignedInfo.canonicalize(dOMSignContext, byteArrayOutputStream);
/* 563 */     byte[] arrayOfByte1 = byteArrayOutputStream.toByteArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 570 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(this.signatureConfig.getDigestAlgo());
/* 571 */     byte[] arrayOfByte2 = messageDigest.digest(arrayOfByte1);
/*     */ 
/*     */     
/* 574 */     String str2 = this.signatureConfig.getSignatureDescription();
/* 575 */     return new DigestInfo(arrayOfByte2, this.signatureConfig.getDigestAlgo(), str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void postSign(Document paramDocument, byte[] paramArrayOfbyte) throws MarshalException {
/* 584 */     LOG.log(1, new Object[] { "postSign" });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 589 */     String str = this.signatureConfig.getPackageSignatureId();
/* 590 */     if (!str.equals(paramDocument.getDocumentElement().getAttribute("Id"))) {
/* 591 */       throw new RuntimeException("ds:Signature not found for @Id: " + str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 597 */     NodeList nodeList = paramDocument.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "SignatureValue");
/* 598 */     if (nodeList.getLength() != 1) {
/* 599 */       throw new RuntimeException("preSign has to be called before postSign");
/*     */     }
/* 601 */     nodeList.item(0).setTextContent(Base64.encode(paramArrayOfbyte));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 606 */     for (SignatureFacet signatureFacet : this.signatureConfig.getSignatureFacets()) {
/* 607 */       signatureFacet.postSign(paramDocument);
/*     */     }
/*     */     
/* 610 */     writeDocument(paramDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeDocument(Document paramDocument) throws MarshalException {
/*     */     PackagePartName packagePartName1, packagePartName2;
/* 620 */     XmlOptions xmlOptions = new XmlOptions();
/* 621 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 622 */     for (Map.Entry<String, String> entry : this.signatureConfig.getNamespacePrefixes().entrySet()) {
/* 623 */       hashMap.put(entry.getValue(), entry.getKey());
/*     */     }
/* 625 */     xmlOptions.setSaveSuggestedPrefixes(hashMap);
/* 626 */     xmlOptions.setUseDefaultNamespace();
/*     */     
/* 628 */     LOG.log(1, new Object[] { "output signed Office OpenXML document" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 634 */     OPCPackage oPCPackage = this.signatureConfig.getOpcPackage();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 639 */       packagePartName1 = PackagingURIHelper.createPartName("/_xmlsignatures/sig1.xml");
/*     */       
/* 641 */       packagePartName2 = PackagingURIHelper.createPartName("/_xmlsignatures/origin.sigs");
/* 642 */     } catch (InvalidFormatException invalidFormatException) {
/* 643 */       throw new MarshalException(invalidFormatException);
/*     */     } 
/*     */     
/* 646 */     PackagePart packagePart1 = oPCPackage.getPart(packagePartName1);
/* 647 */     if (packagePart1 == null) {
/* 648 */       packagePart1 = oPCPackage.createPart(packagePartName1, "application/vnd.openxmlformats-package.digital-signature-xmlsignature+xml");
/*     */     }
/*     */     
/*     */     try {
/* 652 */       OutputStream outputStream = packagePart1.getOutputStream();
/* 653 */       f f = f.a.a(paramDocument, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 654 */       f.save(outputStream, xmlOptions);
/* 655 */       outputStream.close();
/* 656 */     } catch (Exception exception) {
/* 657 */       throw new MarshalException("Unable to write signature document", exception);
/*     */     } 
/*     */     
/* 660 */     PackagePart packagePart2 = oPCPackage.getPart(packagePartName2);
/* 661 */     if (packagePart2 == null)
/*     */     {
/* 663 */       packagePart2 = oPCPackage.createPart(packagePartName2, "application/vnd.openxmlformats-package.digital-signature-origin");
/*     */     }
/*     */     
/* 666 */     PackageRelationshipCollection packageRelationshipCollection = oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/origin");
/* 667 */     for (PackageRelationship packageRelationship : packageRelationshipCollection) {
/* 668 */       oPCPackage.removeRelationship(packageRelationship.getId());
/*     */     }
/* 670 */     oPCPackage.addRelationship(packagePartName2, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/origin");
/*     */     
/* 672 */     packagePart2.addRelationship(packagePartName1, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/digital-signature/signature");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> List<T> safe(List<T> paramList) {
/* 682 */     List<?> list = Collections.emptyList();
/* 683 */     return (paramList == null) ? (List)list : paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   private void brokenJvmWorkaround(XMLSignContext paramXMLSignContext) {
/* 688 */     Provider provider = Security.getProvider("BC");
/* 689 */     if (provider != null) {
/* 690 */       paramXMLSignContext.setProperty("org.jcp.xml.dsig.internal.dom.SignatureProvider", provider);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void brokenJvmWorkaround(XMLValidateContext paramXMLValidateContext) {
/* 696 */     Provider provider = Security.getProvider("BC");
/* 697 */     if (provider != null)
/* 698 */       paramXMLValidateContext.setProperty("org.jcp.xml.dsig.internal.dom.SignatureProvider", provider); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\SignatureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */