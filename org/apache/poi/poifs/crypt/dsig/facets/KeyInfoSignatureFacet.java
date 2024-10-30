/*     */ package org.apache.poi.poifs.crypt.dsig.facets;
/*     */ 
/*     */ import java.security.Key;
/*     */ import java.security.KeyException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import javax.xml.crypto.MarshalException;
/*     */ import javax.xml.crypto.dom.DOMStructure;
/*     */ import javax.xml.crypto.dsig.dom.DOMSignContext;
/*     */ import javax.xml.crypto.dsig.keyinfo.KeyInfo;
/*     */ import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
/*     */ import javax.xml.crypto.dsig.keyinfo.KeyValue;
/*     */ import javax.xml.crypto.dsig.keyinfo.X509Data;
/*     */ import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
/*     */ import org.apache.jcp.xml.dsig.internal.dom.DOMKeyInfo;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
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
/*     */ public class KeyInfoSignatureFacet
/*     */   extends SignatureFacet
/*     */ {
/*  59 */   private static final POILogger LOG = POILogFactory.getLogger(KeyInfoSignatureFacet.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public void postSign(Document paramDocument) throws MarshalException {
/*  64 */     LOG.log(1, new Object[] { "postSign" });
/*     */     
/*  66 */     NodeList nodeList = paramDocument.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Object");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     Node node = (nodeList.getLength() == 0) ? null : nodeList.item(0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     KeyInfoFactory keyInfoFactory = this.signatureConfig.getKeyInfoFactory();
/*  78 */     ArrayList<X509IssuerSerial> arrayList = new ArrayList();
/*  79 */     X509Certificate x509Certificate = this.signatureConfig.getSigningCertificateChain().get(0);
/*     */     
/*  81 */     ArrayList<KeyValue> arrayList1 = new ArrayList();
/*     */     
/*  83 */     if (this.signatureConfig.isIncludeKeyValue()) {
/*     */       KeyValue keyValue;
/*     */       try {
/*  86 */         keyValue = keyInfoFactory.newKeyValue(x509Certificate.getPublicKey());
/*  87 */       } catch (KeyException keyException) {
/*  88 */         throw new RuntimeException("key exception: " + keyException.getMessage(), keyException);
/*     */       } 
/*  90 */       arrayList1.add(keyValue);
/*     */     } 
/*     */     
/*  93 */     if (this.signatureConfig.isIncludeIssuerSerial()) {
/*  94 */       arrayList.add(keyInfoFactory.newX509IssuerSerial(x509Certificate.getIssuerX500Principal().toString(), x509Certificate.getSerialNumber()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  99 */     if (this.signatureConfig.isIncludeEntireCertificateChain()) {
/* 100 */       arrayList.addAll(this.signatureConfig.getSigningCertificateChain());
/*     */     } else {
/* 102 */       arrayList.add(x509Certificate);
/*     */     } 
/*     */     
/* 105 */     if (!arrayList.isEmpty()) {
/* 106 */       X509Data x509Data = keyInfoFactory.newX509Data(arrayList);
/* 107 */       arrayList1.add(x509Data);
/*     */     } 
/* 109 */     KeyInfo keyInfo = keyInfoFactory.newKeyInfo(arrayList1);
/* 110 */     DOMKeyInfo dOMKeyInfo = (DOMKeyInfo)keyInfo;
/*     */     
/* 112 */     Key key = new Key() {
/*     */         private static final long serialVersionUID = 1L;
/*     */         
/*     */         public String getAlgorithm() {
/* 116 */           return null;
/*     */         }
/*     */         
/*     */         public byte[] getEncoded() {
/* 120 */           return null;
/*     */         }
/*     */         
/*     */         public String getFormat() {
/* 124 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 128 */     Element element = paramDocument.getDocumentElement();
/* 129 */     DOMSignContext dOMSignContext = (node == null) ? new DOMSignContext(key, element) : new DOMSignContext(key, element, node);
/*     */ 
/*     */     
/* 132 */     for (Map.Entry entry : this.signatureConfig.getNamespacePrefixes().entrySet()) {
/* 133 */       dOMSignContext.putNamespacePrefix((String)entry.getKey(), (String)entry.getValue());
/*     */     }
/*     */     
/* 136 */     DOMStructure dOMStructure = new DOMStructure(element);
/* 137 */     dOMKeyInfo.marshal(dOMStructure, dOMSignContext);
/*     */ 
/*     */     
/* 140 */     if (node != null) {
/* 141 */       NodeList nodeList1 = paramDocument.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "KeyInfo");
/* 142 */       if (nodeList1.getLength() != 1) {
/* 143 */         throw new RuntimeException("KeyInfo wasn't set");
/*     */       }
/* 145 */       node.getParentNode().insertBefore(nodeList1.item(0), node);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\KeyInfoSignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */