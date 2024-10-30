/*     */ package org.apache.poi.poifs.crypt.dsig.facets;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.security.AccessController;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.security.Provider;
/*     */ import java.security.Security;
/*     */ import java.util.List;
/*     */ import javax.xml.crypto.MarshalException;
/*     */ import javax.xml.crypto.dsig.DigestMethod;
/*     */ import javax.xml.crypto.dsig.Reference;
/*     */ import javax.xml.crypto.dsig.Transform;
/*     */ import javax.xml.crypto.dsig.XMLObject;
/*     */ import javax.xml.crypto.dsig.XMLSignatureException;
/*     */ import javax.xml.crypto.dsig.XMLSignatureFactory;
/*     */ import javax.xml.crypto.dsig.spec.TransformParameterSpec;
/*     */ import org.apache.jcp.xml.dsig.internal.dom.DOMDigestMethod;
/*     */ import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
/*     */ import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.SuppressForbidden;
/*     */ import org.w3c.dom.Document;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SignatureFacet
/*     */   implements SignatureConfig.SignatureConfigurable
/*     */ {
/*  63 */   private static final POILogger LOG = POILogFactory.getLogger(SignatureFacet.class);
/*     */   
/*     */   public static final String XML_NS = "http://www.w3.org/2000/xmlns/";
/*     */   
/*     */   public static final String XML_DIGSIG_NS = "http://www.w3.org/2000/09/xmldsig#";
/*     */   public static final String OO_DIGSIG_NS = "http://schemas.openxmlformats.org/package/2006/digital-signature";
/*     */   public static final String MS_DIGSIG_NS = "http://schemas.microsoft.com/office/2006/digsig";
/*     */   public static final String XADES_132_NS = "http://uri.etsi.org/01903/v1.3.2#";
/*     */   public static final String XADES_141_NS = "http://uri.etsi.org/01903/v1.4.1#";
/*     */   protected SignatureConfig signatureConfig;
/*     */   
/*     */   public void setSignatureConfig(SignatureConfig paramSignatureConfig) {
/*  75 */     this.signatureConfig = paramSignatureConfig;
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
/*     */   public void preSign(Document paramDocument, List<Reference> paramList, List<XMLObject> paramList1) throws XMLSignatureException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void postSign(Document paramDocument) throws MarshalException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XMLSignatureFactory getSignatureFactory() {
/* 109 */     return this.signatureConfig.getSignatureFactory();
/*     */   }
/*     */   
/*     */   protected Transform newTransform(String paramString) throws XMLSignatureException {
/* 113 */     return newTransform(paramString, null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Transform newTransform(String paramString, TransformParameterSpec paramTransformParameterSpec) throws XMLSignatureException {
/*     */     try {
/* 119 */       return getSignatureFactory().newTransform(paramString, paramTransformParameterSpec);
/* 120 */     } catch (GeneralSecurityException generalSecurityException) {
/* 121 */       throw new XMLSignatureException("unknown canonicalization method: " + paramString, generalSecurityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Reference newReference(String paramString1, List<Transform> paramList, String paramString2, String paramString3, byte[] paramArrayOfbyte) throws XMLSignatureException {
/* 127 */     return newReference(paramString1, paramList, paramString2, paramString3, paramArrayOfbyte, this.signatureConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Reference newReference(String paramString1, List<Transform> paramList, String paramString2, String paramString3, byte[] paramArrayOfbyte, SignatureConfig paramSignatureConfig) throws XMLSignatureException {
/*     */     DigestMethod digestMethod;
/*     */     Reference reference;
/* 140 */     String str = paramSignatureConfig.getDigestMethodUri();
/* 141 */     XMLSignatureFactory xMLSignatureFactory = paramSignatureConfig.getSignatureFactory();
/*     */     
/*     */     try {
/* 144 */       digestMethod = xMLSignatureFactory.newDigestMethod(str, null);
/* 145 */     } catch (GeneralSecurityException generalSecurityException) {
/* 146 */       throw new XMLSignatureException("unknown digest method uri: " + str, generalSecurityException);
/*     */     } 
/*     */ 
/*     */     
/* 150 */     if (paramArrayOfbyte == null) {
/* 151 */       reference = xMLSignatureFactory.newReference(paramString1, digestMethod, paramList, paramString2, paramString3);
/*     */     } else {
/* 153 */       reference = xMLSignatureFactory.newReference(paramString1, digestMethod, paramList, paramString2, paramString3, paramArrayOfbyte);
/*     */     } 
/*     */     
/* 156 */     brokenJvmWorkaround(reference);
/*     */     
/* 158 */     return reference;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void brokenJvmWorkaround(final Reference reference) {
/* 163 */     final DigestMethod digestMethod = reference.getDigestMethod();
/* 164 */     String str = digestMethod.getAlgorithm();
/*     */     
/* 166 */     final Provider bcProv = Security.getProvider("BC");
/* 167 */     if (provider != null && !"http://www.w3.org/2000/09/xmldsig#sha1".equals(str))
/*     */     {
/*     */       
/* 170 */       AccessController.doPrivileged(new PrivilegedAction<Void>()
/*     */           {
/*     */             @SuppressForbidden("Workaround for a bug, needs access to private JDK members (may fail in Java 9): https://bugzilla.redhat.com/show_bug.cgi?id=1155012")
/*     */             public Void run() {
/*     */               try {
/* 175 */                 Method method = DOMDigestMethod.class.getDeclaredMethod("getMessageDigestAlgorithm", new Class[0]);
/* 176 */                 method.setAccessible(true);
/* 177 */                 String str = (String)method.invoke(digestMethod, new Object[0]);
/* 178 */                 MessageDigest messageDigest = MessageDigest.getInstance(str, bcProv);
/* 179 */                 Field field = DOMReference.class.getDeclaredField("md");
/* 180 */                 field.setAccessible(true);
/* 181 */                 field.set(reference, messageDigest);
/* 182 */               } catch (Exception exception) {
/* 183 */                 SignatureFacet.LOG.log(5, new Object[] { "Can't overwrite message digest (workaround for https://bugzilla.redhat.com/show_bug.cgi?id=1155012)", exception });
/*     */               } 
/* 185 */               return null;
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\SignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */