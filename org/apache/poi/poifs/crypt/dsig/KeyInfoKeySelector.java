/*     */ package org.apache.poi.poifs.crypt.dsig;
/*     */ 
/*     */ import java.security.Key;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.crypto.AlgorithmMethod;
/*     */ import javax.xml.crypto.KeySelector;
/*     */ import javax.xml.crypto.KeySelectorException;
/*     */ import javax.xml.crypto.KeySelectorResult;
/*     */ import javax.xml.crypto.XMLCryptoContext;
/*     */ import javax.xml.crypto.XMLStructure;
/*     */ import javax.xml.crypto.dsig.keyinfo.KeyInfo;
/*     */ import javax.xml.crypto.dsig.keyinfo.X509Data;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeyInfoKeySelector
/*     */   extends KeySelector
/*     */   implements KeySelectorResult
/*     */ {
/*  50 */   private static final POILogger LOG = POILogFactory.getLogger(KeyInfoKeySelector.class);
/*     */   
/*  52 */   private List<X509Certificate> certChain = new ArrayList<X509Certificate>();
/*     */ 
/*     */ 
/*     */   
/*     */   public KeySelectorResult select(KeyInfo paramKeyInfo, KeySelector.Purpose paramPurpose, AlgorithmMethod paramAlgorithmMethod, XMLCryptoContext paramXMLCryptoContext) throws KeySelectorException {
/*  57 */     LOG.log(1, new Object[] { "select key" });
/*  58 */     if (null == paramKeyInfo) {
/*  59 */       throw new KeySelectorException("no ds:KeyInfo present");
/*     */     }
/*  61 */     List list = paramKeyInfo.getContent();
/*  62 */     this.certChain.clear();
/*  63 */     for (XMLStructure xMLStructure : list) {
/*  64 */       if (!(xMLStructure instanceof X509Data)) {
/*     */         continue;
/*     */       }
/*  67 */       X509Data x509Data = (X509Data)xMLStructure;
/*  68 */       List list1 = x509Data.getContent();
/*  69 */       for (X509Certificate x509Certificate1 : list1) {
/*  70 */         if (!(x509Certificate1 instanceof X509Certificate)) {
/*     */           continue;
/*     */         }
/*  73 */         X509Certificate x509Certificate2 = x509Certificate1;
/*  74 */         LOG.log(1, new Object[] { "certificate", x509Certificate2.getSubjectX500Principal() });
/*  75 */         this.certChain.add(x509Certificate2);
/*     */       } 
/*     */     } 
/*  78 */     if (this.certChain.isEmpty()) {
/*  79 */       throw new KeySelectorException("No key found!");
/*     */     }
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Key getKey() {
/*  86 */     return this.certChain.isEmpty() ? null : ((X509Certificate)this.certChain.get(0)).getPublicKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public X509Certificate getSigner() {
/*  97 */     return this.certChain.isEmpty() ? null : this.certChain.get(0);
/*     */   }
/*     */   
/*     */   public List<X509Certificate> getCertChain() {
/* 101 */     return this.certChain;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\KeyInfoKeySelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */