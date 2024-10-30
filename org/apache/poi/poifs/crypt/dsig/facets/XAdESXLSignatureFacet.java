/*     */ package org.apache.poi.poifs.crypt.dsig.facets;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.math.BigInteger;
/*     */ import java.security.cert.CRLException;
/*     */ import java.security.cert.CertificateEncodingException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.CertificateFactory;
/*     */ import java.security.cert.X509CRL;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import java.util.UUID;
/*     */ import javax.xml.crypto.MarshalException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.poifs.crypt.dsig.services.RevocationData;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.xml.security.c14n.Canonicalizer;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.b.a.a.a.a;
/*     */ import org.b.a.a.a.b;
/*     */ import org.b.a.a.a.c;
/*     */ import org.b.a.a.a.d;
/*     */ import org.b.a.a.a.e;
/*     */ import org.b.a.a.a.f;
/*     */ import org.b.a.a.a.g;
/*     */ import org.b.a.a.a.h;
/*     */ import org.b.a.a.a.i;
/*     */ import org.b.a.a.a.j;
/*     */ import org.b.a.a.a.k;
/*     */ import org.b.a.a.a.m;
/*     */ import org.b.a.a.a.n;
/*     */ import org.b.a.a.a.o;
/*     */ import org.b.a.a.a.p;
/*     */ import org.b.a.a.a.q;
/*     */ import org.b.a.a.a.r;
/*     */ import org.b.a.a.a.s;
/*     */ import org.b.a.a.a.t;
/*     */ import org.b.a.a.a.x;
/*     */ import org.b.a.a.a.y;
/*     */ import org.b.a.a.a.z;
/*     */ import org.b.a.a.b.a;
/*     */ import org.bouncycastle.asn1.ASN1InputStream;
/*     */ import org.bouncycastle.asn1.ASN1Integer;
/*     */ import org.bouncycastle.asn1.ASN1OctetString;
/*     */ import org.bouncycastle.asn1.DERTaggedObject;
/*     */ import org.bouncycastle.asn1.ocsp.ResponderID;
/*     */ import org.bouncycastle.asn1.x500.X500Name;
/*     */ import org.bouncycastle.asn1.x509.Extension;
/*     */ import org.bouncycastle.cert.ocsp.BasicOCSPResp;
/*     */ import org.bouncycastle.cert.ocsp.OCSPResp;
/*     */ import org.bouncycastle.cert.ocsp.RespID;
/*     */ import org.f.a.a.a.a;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XAdESXLSignatureFacet
/*     */   extends SignatureFacet
/*     */ {
/* 109 */   private static final POILogger LOG = POILogFactory.getLogger(XAdESXLSignatureFacet.class);
/*     */   
/*     */   private final CertificateFactory certificateFactory;
/*     */   
/*     */   public XAdESXLSignatureFacet() {
/*     */     try {
/* 115 */       this.certificateFactory = CertificateFactory.getInstance("X.509");
/* 116 */     } catch (CertificateException certificateException) {
/* 117 */       throw new RuntimeException("X509 JCA error: " + certificateException.getMessage(), certificateException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void postSign(Document paramDocument) throws MarshalException {
/* 123 */     LOG.log(1, new Object[] { "XAdES-X-L post sign phase" });
/*     */     
/* 125 */     q q = null;
/* 126 */     r r = null;
/*     */ 
/*     */     
/* 129 */     NodeList nodeList1 = paramDocument.getElementsByTagNameNS("http://uri.etsi.org/01903/v1.3.2#", "QualifyingProperties");
/* 130 */     if (nodeList1.getLength() == 1) {
/*     */       try {
/* 132 */         q = q.a.a(nodeList1.item(0), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 133 */       } catch (XmlException xmlException) {
/* 134 */         throw new MarshalException(xmlException);
/*     */       } 
/* 136 */       r = q.a();
/*     */     } else {
/* 138 */       throw new MarshalException("no XAdES-BES extension present");
/*     */     } 
/*     */ 
/*     */     
/* 142 */     x x = r.a();
/* 143 */     if (x == null) {
/* 144 */       x = r.b();
/*     */     }
/* 146 */     y y = x.a();
/* 147 */     if (y == null) {
/* 148 */       y = x.b();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 153 */     NodeList nodeList2 = paramDocument.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "SignatureValue");
/* 154 */     if (nodeList2.getLength() != 1) {
/* 155 */       throw new IllegalArgumentException("SignatureValue is not set.");
/*     */     }
/*     */     
/* 158 */     RevocationData revocationData1 = new RevocationData();
/* 159 */     LOG.log(1, new Object[] { "creating XAdES-T time-stamp" });
/* 160 */     z z1 = createXAdESTimeStamp(Collections.singletonList(nodeList2.item(0)), revocationData1);
/*     */ 
/*     */ 
/*     */     
/* 164 */     y.a().set((XmlObject)z1);
/*     */ 
/*     */     
/* 167 */     if (revocationData1.hasRevocationDataEntries()) {
/* 168 */       a a = createValidationData(revocationData1);
/* 169 */       XAdESSignatureFacet.insertXChild((XmlObject)y, (XmlObject)a);
/*     */     } 
/*     */     
/* 172 */     if (this.signatureConfig.getRevocationDataService() == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     h h = y.b();
/*     */ 
/*     */     
/* 184 */     e e = h.c();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     List list = this.signatureConfig.getSigningCertificateChain();
/* 190 */     int i = list.size();
/* 191 */     if (i > 1) {
/* 192 */       for (X509Certificate x509Certificate : list.subList(1, i)) {
/* 193 */         f f = e.a();
/* 194 */         XAdESSignatureFacet.setCertID(f, this.signatureConfig, false, x509Certificate);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 199 */     i i1 = y.b();
/*     */     
/* 201 */     RevocationData revocationData2 = this.signatureConfig.getRevocationDataService().getRevocationData(list);
/*     */     
/* 203 */     if (revocationData2.hasCRLs()) {
/* 204 */       c c = i1.c();
/* 205 */       i1.a(c);
/*     */       
/* 207 */       for (byte[] arrayOfByte : revocationData2.getCRLs()) {
/* 208 */         X509CRL x509CRL; b b = c.b();
/*     */         
/*     */         try {
/* 211 */           x509CRL = (X509CRL)this.certificateFactory.generateCRL(new ByteArrayInputStream(arrayOfByte));
/*     */         }
/* 213 */         catch (CRLException cRLException) {
/* 214 */           throw new RuntimeException("CRL parse error: " + cRLException.getMessage(), cRLException);
/*     */         } 
/*     */ 
/*     */         
/* 218 */         a a = b.c();
/* 219 */         String str = x509CRL.getIssuerDN().getName().replace(",", ", ");
/* 220 */         a.bi(str);
/* 221 */         Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
/* 222 */         calendar.setTime(x509CRL.getThisUpdate());
/* 223 */         a.c(calendar);
/* 224 */         a.a(getCrlNumber(x509CRL));
/*     */         
/* 226 */         j j = b.b();
/* 227 */         XAdESSignatureFacet.setDigestAlgAndValue(j, arrayOfByte, this.signatureConfig.getDigestAlgo());
/*     */       } 
/*     */     } 
/* 230 */     if (revocationData2.hasOCSPs()) {
/* 231 */       o o = i1.b();
/* 232 */       for (byte[] arrayOfByte : revocationData2.getOCSPs()) {
/*     */         try {
/* 234 */           n n = o.b();
/*     */           
/* 236 */           j j = n.b();
/* 237 */           XAdESSignatureFacet.setDigestAlgAndValue(j, arrayOfByte, this.signatureConfig.getDigestAlgo());
/*     */           
/* 239 */           m m = n.c();
/*     */           
/* 241 */           OCSPResp oCSPResp = new OCSPResp(arrayOfByte);
/*     */           
/* 243 */           BasicOCSPResp basicOCSPResp = (BasicOCSPResp)oCSPResp.getResponseObject();
/*     */           
/* 245 */           Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
/* 246 */           calendar.setTime(basicOCSPResp.getProducedAt());
/* 247 */           m.d(calendar);
/*     */           
/* 249 */           s s = m.b();
/*     */           
/* 251 */           RespID respID = basicOCSPResp.getResponderId();
/* 252 */           ResponderID responderID = respID.toASN1Primitive();
/* 253 */           DERTaggedObject dERTaggedObject = (DERTaggedObject)responderID.toASN1Primitive();
/* 254 */           if (2 == dERTaggedObject.getTagNo()) {
/* 255 */             ASN1OctetString aSN1OctetString = (ASN1OctetString)dERTaggedObject.getObject();
/* 256 */             byte[] arrayOfByte1 = aSN1OctetString.getOctets();
/* 257 */             s.g(arrayOfByte1); continue;
/*     */           } 
/* 259 */           X500Name x500Name = X500Name.getInstance(dERTaggedObject.getObject());
/* 260 */           String str = x500Name.toString();
/* 261 */           s.bk(str);
/*     */         }
/* 263 */         catch (Exception exception) {
/* 264 */           throw new RuntimeException("OCSP decoding error: " + exception.getMessage(), exception);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     ArrayList<Node> arrayList = new ArrayList();
/* 273 */     arrayList.add(nodeList2.item(0));
/* 274 */     arrayList.add(z1.getDomNode());
/* 275 */     arrayList.add(h.getDomNode());
/* 276 */     arrayList.add(i1.getDomNode());
/*     */     
/* 278 */     RevocationData revocationData3 = new RevocationData();
/* 279 */     LOG.log(1, new Object[] { "creating XAdES-X time-stamp" });
/* 280 */     z z2 = createXAdESTimeStamp(arrayList, revocationData3);
/*     */     
/* 282 */     if (revocationData3.hasRevocationDataEntries()) {
/* 283 */       a a = createValidationData(revocationData3);
/* 284 */       XAdESSignatureFacet.insertXChild((XmlObject)y, (XmlObject)a);
/*     */     } 
/*     */ 
/*     */     
/* 288 */     y.b().set((XmlObject)z2);
/*     */ 
/*     */     
/* 291 */     g g = y.b();
/* 292 */     for (X509Certificate x509Certificate : list) {
/* 293 */       k k = g.b();
/*     */       try {
/* 295 */         k.setByteArrayValue(x509Certificate.getEncoded());
/* 296 */       } catch (CertificateEncodingException certificateEncodingException) {
/* 297 */         throw new RuntimeException("certificate encoding error: " + certificateEncodingException.getMessage(), certificateEncodingException);
/*     */       } 
/*     */     } 
/*     */     
/* 301 */     t t = y.b();
/* 302 */     createRevocationValues(t, revocationData2);
/*     */ 
/*     */     
/* 305 */     Node node = paramDocument.importNode(r.getDomNode(), true);
/* 306 */     nodeList1.item(0).getParentNode().replaceChild(node, nodeList1.item(0));
/*     */   }
/*     */   
/*     */   public static byte[] getC14nValue(List<Node> paramList, String paramString) {
/* 310 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 312 */       for (Node node : paramList) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 317 */         Canonicalizer canonicalizer = Canonicalizer.getInstance(paramString);
/* 318 */         byteArrayOutputStream.write(canonicalizer.canonicalizeSubtree(node));
/*     */       } 
/* 320 */     } catch (RuntimeException runtimeException) {
/* 321 */       throw runtimeException;
/* 322 */     } catch (Exception exception) {
/* 323 */       throw new RuntimeException("c14n error: " + exception.getMessage(), exception);
/*     */     } 
/* 325 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */   
/*     */   private BigInteger getCrlNumber(X509CRL paramX509CRL) {
/* 329 */     byte[] arrayOfByte = paramX509CRL.getExtensionValue(Extension.cRLNumber.getId());
/* 330 */     if (null == arrayOfByte) {
/* 331 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 335 */       ASN1InputStream aSN1InputStream1 = null, aSN1InputStream2 = null;
/*     */       try {
/* 337 */         aSN1InputStream1 = new ASN1InputStream(arrayOfByte);
/* 338 */         ASN1OctetString aSN1OctetString = (ASN1OctetString)aSN1InputStream1.readObject();
/* 339 */         byte[] arrayOfByte1 = aSN1OctetString.getOctets();
/* 340 */         aSN1InputStream2 = new ASN1InputStream(arrayOfByte1);
/* 341 */         ASN1Integer aSN1Integer = (ASN1Integer)aSN1InputStream2.readObject();
/* 342 */         return aSN1Integer.getPositiveValue();
/*     */       } finally {
/* 344 */         aSN1InputStream2.close();
/* 345 */         aSN1InputStream1.close();
/*     */       } 
/* 347 */     } catch (IOException iOException) {
/* 348 */       throw new RuntimeException("I/O error: " + iOException.getMessage(), iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private z createXAdESTimeStamp(List<Node> paramList, RevocationData paramRevocationData) {
/* 355 */     byte[] arrayOfByte = getC14nValue(paramList, this.signatureConfig.getXadesCanonicalizationMethod());
/*     */     
/* 357 */     return createXAdESTimeStamp(arrayOfByte, paramRevocationData);
/*     */   }
/*     */ 
/*     */   
/*     */   private z createXAdESTimeStamp(byte[] paramArrayOfbyte, RevocationData paramRevocationData) {
/*     */     byte[] arrayOfByte;
/*     */     try {
/* 364 */       arrayOfByte = this.signatureConfig.getTspService().timeStamp(paramArrayOfbyte, paramRevocationData);
/* 365 */     } catch (Exception exception) {
/* 366 */       throw new RuntimeException("error while creating a time-stamp: " + exception.getMessage(), exception);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 371 */     z z = z.a.e();
/* 372 */     z.setId("time-stamp-" + UUID.randomUUID().toString());
/* 373 */     a a = z.b();
/* 374 */     a.setAlgorithm(this.signatureConfig.getXadesCanonicalizationMethod());
/*     */ 
/*     */     
/* 377 */     k k = z.d();
/* 378 */     k.setByteArrayValue(arrayOfByte);
/* 379 */     k.setId("time-stamp-token-" + UUID.randomUUID().toString());
/*     */     
/* 381 */     return z;
/*     */   }
/*     */ 
/*     */   
/*     */   private a createValidationData(RevocationData paramRevocationData) {
/* 386 */     a a = a.a.a();
/* 387 */     t t = a.b();
/* 388 */     createRevocationValues(t, paramRevocationData);
/* 389 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createRevocationValues(t paramt, RevocationData paramRevocationData) {
/* 394 */     if (paramRevocationData.hasCRLs()) {
/* 395 */       d d = paramt.c();
/* 396 */       for (byte[] arrayOfByte : paramRevocationData.getCRLs()) {
/* 397 */         k k = d.a();
/* 398 */         k.setByteArrayValue(arrayOfByte);
/*     */       } 
/*     */     } 
/* 401 */     if (paramRevocationData.hasOCSPs()) {
/* 402 */       p p = paramt.c();
/* 403 */       for (byte[] arrayOfByte : paramRevocationData.getOCSPs()) {
/* 404 */         k k = p.e();
/* 405 */         k.setByteArrayValue(arrayOfByte);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\XAdESXLSignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */