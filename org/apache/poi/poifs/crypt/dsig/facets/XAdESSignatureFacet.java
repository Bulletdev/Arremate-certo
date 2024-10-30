/*     */ package org.apache.poi.poifs.crypt.dsig.facets;
/*     */ 
/*     */ import java.security.MessageDigest;
/*     */ import java.security.cert.CertificateEncodingException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import javax.xml.crypto.dom.DOMStructure;
/*     */ import javax.xml.crypto.dsig.Reference;
/*     */ import javax.xml.crypto.dsig.Transform;
/*     */ import javax.xml.crypto.dsig.XMLObject;
/*     */ import javax.xml.crypto.dsig.XMLSignatureException;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.b.a.a.a.e;
/*     */ import org.b.a.a.a.f;
/*     */ import org.b.a.a.a.j;
/*     */ import org.b.a.a.a.q;
/*     */ import org.b.a.a.a.r;
/*     */ import org.b.a.a.a.u;
/*     */ import org.b.a.a.a.v;
/*     */ import org.b.a.a.a.w;
/*     */ import org.etsi.uri.x01903.v13.AnyType;
/*     */ import org.etsi.uri.x01903.v13.ClaimedRolesListType;
/*     */ import org.etsi.uri.x01903.v13.DataObjectFormatType;
/*     */ import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
/*     */ import org.etsi.uri.x01903.v13.IdentifierType;
/*     */ import org.etsi.uri.x01903.v13.ObjectIdentifierType;
/*     */ import org.etsi.uri.x01903.v13.SigPolicyQualifiersListType;
/*     */ import org.etsi.uri.x01903.v13.SignaturePolicyIdType;
/*     */ import org.etsi.uri.x01903.v13.SignedDataObjectPropertiesType;
/*     */ import org.etsi.uri.x01903.v13.SignerRoleType;
/*     */ import org.f.a.a.a.b;
/*     */ import org.f.a.a.a.k;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
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
/*     */ public class XAdESSignatureFacet
/*     */   extends SignatureFacet
/*     */ {
/*  91 */   private static final POILogger LOG = POILogFactory.getLogger(XAdESSignatureFacet.class);
/*     */   
/*     */   private static final String XADES_TYPE = "http://uri.etsi.org/01903#SignedProperties";
/*     */   
/*  95 */   private Map<String, String> dataObjectFormatMimeTypes = new HashMap<String, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void preSign(Document paramDocument, List<Reference> paramList, List<XMLObject> paramList1) throws XMLSignatureException {
/* 104 */     LOG.log(1, new Object[] { "preSign" });
/*     */ 
/*     */     
/* 107 */     q q = q.a.a();
/* 108 */     r r = q.b();
/* 109 */     r.setTarget("#" + this.signatureConfig.getPackageSignatureId());
/*     */ 
/*     */     
/* 112 */     v v = r.b();
/* 113 */     v.setId(this.signatureConfig.getXadesSignatureId());
/*     */ 
/*     */     
/* 116 */     w w = v.b();
/*     */ 
/*     */     
/* 119 */     Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
/* 120 */     calendar.setTime(this.signatureConfig.getExecutionTime());
/* 121 */     calendar.clear(14);
/* 122 */     w.e(calendar);
/*     */ 
/*     */     
/* 125 */     if (this.signatureConfig.getSigningCertificateChain() == null || this.signatureConfig.getSigningCertificateChain().isEmpty())
/*     */     {
/* 127 */       throw new RuntimeException("no signing certificate chain available");
/*     */     }
/* 129 */     e e = w.e();
/* 130 */     f f = e.a();
/* 131 */     X509Certificate x509Certificate = this.signatureConfig.getSigningCertificateChain().get(0);
/* 132 */     setCertID(f, this.signatureConfig, this.signatureConfig.isXadesIssuerNameNoReverseOrder(), x509Certificate);
/*     */ 
/*     */     
/* 135 */     String str = this.signatureConfig.getXadesRole();
/* 136 */     if (str != null && !str.isEmpty()) {
/* 137 */       SignerRoleType signerRoleType = w.b();
/* 138 */       w.a(signerRoleType);
/* 139 */       ClaimedRolesListType claimedRolesListType = signerRoleType.addNewClaimedRoles();
/* 140 */       AnyType anyType = claimedRolesListType.addNewClaimedRole();
/* 141 */       XmlString xmlString = XmlString.Factory.newInstance();
/* 142 */       xmlString.setStringValue(str);
/* 143 */       insertXChild((XmlObject)anyType, (XmlObject)xmlString);
/*     */     } 
/*     */ 
/*     */     
/* 147 */     SignaturePolicyService signaturePolicyService = this.signatureConfig.getSignaturePolicyService();
/* 148 */     if (signaturePolicyService != null) {
/* 149 */       u u = w.c();
/*     */ 
/*     */       
/* 152 */       SignaturePolicyIdType signaturePolicyIdType = u.b();
/*     */       
/* 154 */       ObjectIdentifierType objectIdentifierType = signaturePolicyIdType.addNewSigPolicyId();
/* 155 */       objectIdentifierType.setDescription(signaturePolicyService.getSignaturePolicyDescription());
/*     */       
/* 157 */       IdentifierType identifierType = objectIdentifierType.addNewIdentifier();
/* 158 */       identifierType.setStringValue(signaturePolicyService.getSignaturePolicyIdentifier());
/*     */       
/* 160 */       byte[] arrayOfByte = signaturePolicyService.getSignaturePolicyDocument();
/* 161 */       DigestAlgAndValueType digestAlgAndValueType = signaturePolicyIdType.addNewSigPolicyHash();
/* 162 */       setDigestAlgAndValue((j)digestAlgAndValueType, arrayOfByte, this.signatureConfig.getDigestAlgo());
/*     */       
/* 164 */       String str1 = signaturePolicyService.getSignaturePolicyDownloadUrl();
/* 165 */       if (null != str1) {
/* 166 */         SigPolicyQualifiersListType sigPolicyQualifiersListType = signaturePolicyIdType.addNewSigPolicyQualifiers();
/* 167 */         AnyType anyType = sigPolicyQualifiersListType.addNewSigPolicyQualifier();
/* 168 */         XmlString xmlString = XmlString.Factory.newInstance();
/* 169 */         xmlString.setStringValue(str1);
/* 170 */         insertXChild((XmlObject)anyType, (XmlObject)xmlString);
/*     */       } 
/* 172 */     } else if (this.signatureConfig.isXadesSignaturePolicyImplied()) {
/* 173 */       u u = w.c();
/*     */       
/* 175 */       u.b();
/*     */     } 
/*     */ 
/*     */     
/* 179 */     if (!this.dataObjectFormatMimeTypes.isEmpty()) {
/* 180 */       SignedDataObjectPropertiesType signedDataObjectPropertiesType = v.b();
/*     */ 
/*     */       
/* 183 */       List<DataObjectFormatType> list = signedDataObjectPropertiesType.getDataObjectFormatList();
/*     */       
/* 185 */       for (Map.Entry<String, String> entry : this.dataObjectFormatMimeTypes.entrySet()) {
/*     */         
/* 187 */         DataObjectFormatType dataObjectFormatType = DataObjectFormatType.Factory.newInstance();
/* 188 */         dataObjectFormatType.setObjectReference("#" + (String)entry.getKey());
/* 189 */         dataObjectFormatType.setMimeType((String)entry.getValue());
/* 190 */         list.add(dataObjectFormatType);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 195 */     ArrayList<DOMStructure> arrayList = new ArrayList();
/* 196 */     Element element1 = (Element)r.getDomNode();
/* 197 */     Element element2 = (Element)paramDocument.importNode(element1, true);
/* 198 */     arrayList.add(new DOMStructure(element2));
/* 199 */     XMLObject xMLObject = getSignatureFactory().newXMLObject(arrayList, null, null, null);
/* 200 */     paramList1.add(xMLObject);
/*     */ 
/*     */     
/* 203 */     ArrayList<Transform> arrayList1 = new ArrayList();
/* 204 */     Transform transform = newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
/* 205 */     arrayList1.add(transform);
/* 206 */     Reference reference = newReference("#" + this.signatureConfig.getXadesSignatureId(), arrayList1, "http://uri.etsi.org/01903#SignedProperties", null, null);
/*     */     
/* 208 */     paramList.add(reference);
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
/*     */   protected static void setDigestAlgAndValue(j paramj, byte[] paramArrayOfbyte, HashAlgorithm paramHashAlgorithm) {
/* 222 */     b b = paramj.b();
/* 223 */     b.setAlgorithm(SignatureConfig.getDigestMethodUri(paramHashAlgorithm));
/*     */     
/* 225 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(paramHashAlgorithm);
/* 226 */     byte[] arrayOfByte = messageDigest.digest(paramArrayOfbyte);
/* 227 */     paramj.f(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void setCertID(f paramf, SignatureConfig paramSignatureConfig, boolean paramBoolean, X509Certificate paramX509Certificate) {
/*     */     String str;
/*     */     byte[] arrayOfByte;
/* 235 */     k k = paramf.b();
/*     */     
/* 237 */     if (paramBoolean) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 247 */       str = paramX509Certificate.getIssuerDN().getName().replace(",", ", ");
/*     */     } else {
/* 249 */       str = paramX509Certificate.getIssuerX500Principal().toString();
/*     */     } 
/* 251 */     k.bQ(str);
/* 252 */     k.b(paramX509Certificate.getSerialNumber());
/*     */ 
/*     */     
/*     */     try {
/* 256 */       arrayOfByte = paramX509Certificate.getEncoded();
/* 257 */     } catch (CertificateEncodingException certificateEncodingException) {
/* 258 */       throw new RuntimeException("certificate encoding error: " + certificateEncodingException.getMessage(), certificateEncodingException);
/*     */     } 
/*     */     
/* 261 */     j j = paramf.d();
/* 262 */     setDigestAlgAndValue(j, arrayOfByte, paramSignatureConfig.getXadesDigestAlgo());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMimeType(String paramString1, String paramString2) {
/* 273 */     this.dataObjectFormatMimeTypes.put(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   protected static void insertXChild(XmlObject paramXmlObject1, XmlObject paramXmlObject2) {
/* 277 */     XmlCursor xmlCursor1 = paramXmlObject1.newCursor();
/* 278 */     xmlCursor1.toEndToken();
/* 279 */     XmlCursor xmlCursor2 = paramXmlObject2.newCursor();
/* 280 */     xmlCursor2.toNextToken();
/* 281 */     xmlCursor2.moveXml(xmlCursor1);
/* 282 */     xmlCursor2.dispose();
/* 283 */     xmlCursor1.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\XAdESSignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */