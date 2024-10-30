/*     */ package org.apache.poi.poifs.crypt.dsig;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import javax.xml.crypto.Data;
/*     */ import javax.xml.crypto.OctetStreamData;
/*     */ import javax.xml.crypto.URIDereferencer;
/*     */ import javax.xml.crypto.URIReference;
/*     */ import javax.xml.crypto.URIReferenceException;
/*     */ import javax.xml.crypto.XMLCryptoContext;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
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
/*     */ 
/*     */ public class OOXMLURIDereferencer
/*     */   implements URIDereferencer, SignatureConfig.SignatureConfigurable
/*     */ {
/*  54 */   private static final POILogger LOG = POILogFactory.getLogger(OOXMLURIDereferencer.class);
/*     */   
/*     */   private SignatureConfig signatureConfig;
/*     */   private URIDereferencer baseUriDereferencer;
/*     */   
/*     */   public void setSignatureConfig(SignatureConfig paramSignatureConfig) {
/*  60 */     this.signatureConfig = paramSignatureConfig;
/*     */   } public Data dereference(URIReference paramURIReference, XMLCryptoContext paramXMLCryptoContext) throws URIReferenceException {
/*     */     URI uRI;
/*     */     InputStream inputStream;
/*  64 */     if (this.baseUriDereferencer == null) {
/*  65 */       this.baseUriDereferencer = this.signatureConfig.getSignatureFactory().getURIDereferencer();
/*     */     }
/*     */     
/*  68 */     if (null == paramURIReference) {
/*  69 */       throw new NullPointerException("URIReference cannot be null");
/*     */     }
/*  71 */     if (null == paramXMLCryptoContext) {
/*  72 */       throw new NullPointerException("XMLCrytoContext cannot be null");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  77 */       uRI = new URI(paramURIReference.getURI());
/*  78 */     } catch (URISyntaxException uRISyntaxException) {
/*  79 */       throw new URIReferenceException("could not URL decode the uri: " + paramURIReference.getURI(), uRISyntaxException);
/*     */     } 
/*     */     
/*  82 */     PackagePart packagePart = findPart(uRI);
/*  83 */     if (packagePart == null) {
/*  84 */       LOG.log(1, new Object[] { "cannot resolve, delegating to base DOM URI dereferencer", uRI });
/*  85 */       return this.baseUriDereferencer.dereference(paramURIReference, paramXMLCryptoContext);
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  90 */       inputStream = packagePart.getInputStream();
/*     */ 
/*     */       
/*  93 */       if (packagePart.getPartName().toString().endsWith(".rels")) {
/*     */ 
/*     */ 
/*     */         
/*  97 */         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); int i;
/*  98 */         while ((i = inputStream.read()) != -1) {
/*  99 */           if (i == 10 || i == 13)
/* 100 */             continue;  byteArrayOutputStream.write(i);
/*     */         } 
/* 102 */         inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*     */       } 
/* 104 */     } catch (IOException iOException) {
/* 105 */       throw new URIReferenceException("I/O error: " + iOException.getMessage(), iOException);
/*     */     } 
/*     */     
/* 108 */     return new OctetStreamData(inputStream, uRI.toString(), null);
/*     */   }
/*     */   private PackagePart findPart(URI paramURI) {
/*     */     PackagePartName packagePartName;
/* 112 */     LOG.log(1, new Object[] { "dereference", paramURI });
/*     */     
/* 114 */     String str = paramURI.getPath();
/* 115 */     if (str == null || "".equals(str)) {
/* 116 */       LOG.log(1, new Object[] { "illegal part name (expected)", paramURI });
/* 117 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 122 */       packagePartName = PackagingURIHelper.createPartName(str);
/* 123 */     } catch (InvalidFormatException invalidFormatException) {
/* 124 */       LOG.log(5, new Object[] { "illegal part name (not expected)", paramURI });
/* 125 */       return null;
/*     */     } 
/*     */     
/* 128 */     return this.signatureConfig.getOpcPackage().getPart(packagePartName);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\OOXMLURIDereferencer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */