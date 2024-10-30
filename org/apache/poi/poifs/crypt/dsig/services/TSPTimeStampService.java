/*     */ package org.apache.poi.poifs.crypt.dsig.services;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.math.BigInteger;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.Charset;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import javax.xml.bind.DatatypeConverter;
/*     */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*     */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*     */ import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.bouncycastle.asn1.ASN1ObjectIdentifier;
/*     */ import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/*     */ import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
/*     */ import org.bouncycastle.asn1.x500.X500Name;
/*     */ import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
/*     */ import org.bouncycastle.cert.X509CertificateHolder;
/*     */ import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
/*     */ import org.bouncycastle.cms.CMSSignatureAlgorithmNameGenerator;
/*     */ import org.bouncycastle.cms.DefaultCMSSignatureAlgorithmNameGenerator;
/*     */ import org.bouncycastle.cms.SignerId;
/*     */ import org.bouncycastle.cms.SignerInformationVerifier;
/*     */ import org.bouncycastle.cms.bc.BcRSASignerInfoVerifierBuilder;
/*     */ import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
/*     */ import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
/*     */ import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
/*     */ import org.bouncycastle.operator.DigestCalculatorProvider;
/*     */ import org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;
/*     */ import org.bouncycastle.operator.bc.BcDigestCalculatorProvider;
/*     */ import org.bouncycastle.tsp.TimeStampRequest;
/*     */ import org.bouncycastle.tsp.TimeStampRequestGenerator;
/*     */ import org.bouncycastle.tsp.TimeStampResponse;
/*     */ import org.bouncycastle.tsp.TimeStampToken;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TSPTimeStampService
/*     */   implements TimeStampService
/*     */ {
/*  82 */   private static final POILogger LOG = POILogFactory.getLogger(TSPTimeStampService.class);
/*     */ 
/*     */   
/*     */   private SignatureConfig signatureConfig;
/*     */ 
/*     */ 
/*     */   
/*     */   public ASN1ObjectIdentifier mapDigestAlgoToOID(HashAlgorithm paramHashAlgorithm) {
/*  90 */     switch (paramHashAlgorithm) { case sha1:
/*  91 */         return X509ObjectIdentifiers.id_SHA1;
/*  92 */       case sha256: return NISTObjectIdentifiers.id_sha256;
/*  93 */       case sha384: return NISTObjectIdentifiers.id_sha384;
/*  94 */       case sha512: return NISTObjectIdentifiers.id_sha512; }
/*     */     
/*  96 */     throw new IllegalArgumentException("unsupported digest algo: " + paramHashAlgorithm);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] timeStamp(byte[] paramArrayOfbyte, RevocationData paramRevocationData) throws Exception {
/* 104 */     MessageDigest messageDigest = CryptoFunctions.getMessageDigest(this.signatureConfig.getTspDigestAlgo());
/* 105 */     byte[] arrayOfByte1 = messageDigest.digest(paramArrayOfbyte);
/*     */ 
/*     */     
/* 108 */     BigInteger bigInteger1 = new BigInteger(128, new SecureRandom());
/* 109 */     TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
/* 110 */     timeStampRequestGenerator.setCertReq(true);
/* 111 */     String str1 = this.signatureConfig.getTspRequestPolicy();
/* 112 */     if (str1 != null) {
/* 113 */       timeStampRequestGenerator.setReqPolicy(new ASN1ObjectIdentifier(str1));
/*     */     }
/* 115 */     ASN1ObjectIdentifier aSN1ObjectIdentifier = mapDigestAlgoToOID(this.signatureConfig.getTspDigestAlgo());
/* 116 */     TimeStampRequest timeStampRequest = timeStampRequestGenerator.generate(aSN1ObjectIdentifier, arrayOfByte1, bigInteger1);
/* 117 */     byte[] arrayOfByte2 = timeStampRequest.getEncoded();
/*     */ 
/*     */     
/* 120 */     Proxy proxy = Proxy.NO_PROXY;
/* 121 */     if (this.signatureConfig.getProxyUrl() != null) {
/* 122 */       URL uRL = new URL(this.signatureConfig.getProxyUrl());
/* 123 */       String str = uRL.getHost();
/* 124 */       int j = uRL.getPort();
/* 125 */       proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByName(str), (j == -1) ? 80 : j));
/*     */     } 
/*     */     
/* 128 */     HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(this.signatureConfig.getTspUrl())).openConnection(proxy);
/*     */     
/* 130 */     if (this.signatureConfig.getTspUser() != null) {
/* 131 */       String str3 = this.signatureConfig.getTspUser() + ":" + this.signatureConfig.getTspPass();
/* 132 */       String str4 = DatatypeConverter.printBase64Binary(str3.getBytes(Charset.forName("iso-8859-1")));
/* 133 */       httpURLConnection.setRequestProperty("Authorization", "Basic " + str4);
/*     */     } 
/*     */     
/* 136 */     httpURLConnection.setRequestMethod("POST");
/* 137 */     httpURLConnection.setConnectTimeout(20000);
/* 138 */     httpURLConnection.setReadTimeout(20000);
/* 139 */     httpURLConnection.setDoOutput(true);
/* 140 */     httpURLConnection.setRequestProperty("User-Agent", this.signatureConfig.getUserAgent());
/* 141 */     httpURLConnection.setRequestProperty("Content-Type", this.signatureConfig.isTspOldProtocol() ? "application/timestamp-request" : "application/timestamp-query");
/*     */ 
/*     */ 
/*     */     
/* 145 */     OutputStream outputStream = httpURLConnection.getOutputStream();
/* 146 */     outputStream.write(arrayOfByte2);
/*     */ 
/*     */     
/* 149 */     httpURLConnection.connect();
/*     */     
/* 151 */     int i = httpURLConnection.getResponseCode();
/* 152 */     if (i != 200) {
/* 153 */       LOG.log(7, new Object[] { "Error contacting TSP server ", this.signatureConfig.getTspUrl() + ", had status code " + i + "/" + httpURLConnection.getResponseMessage() });
/*     */       
/* 155 */       throw new IOException("Error contacting TSP server " + this.signatureConfig.getTspUrl() + ", had status code " + i + "/" + httpURLConnection.getResponseMessage());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 160 */     String str2 = httpURLConnection.getHeaderField("Content-Type");
/* 161 */     if (null == str2) {
/* 162 */       throw new RuntimeException("missing Content-Type header");
/*     */     }
/*     */     
/* 165 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 166 */     IOUtils.copy(httpURLConnection.getInputStream(), byteArrayOutputStream);
/* 167 */     LOG.log(1, new Object[] { "response content: ", HexDump.dump(byteArrayOutputStream.toByteArray(), 0L, 0) });
/*     */     
/* 169 */     if (!str2.startsWith(this.signatureConfig.isTspOldProtocol() ? "application/timestamp-response" : "application/timestamp-reply"))
/*     */     {
/*     */ 
/*     */       
/* 173 */       throw new RuntimeException("invalid Content-Type: " + str2 + ": " + HexDump.dump(byteArrayOutputStream.toByteArray(), 0L, 0, 200));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (byteArrayOutputStream.size() == 0) {
/* 179 */       throw new RuntimeException("Content-Length is zero");
/*     */     }
/*     */ 
/*     */     
/* 183 */     TimeStampResponse timeStampResponse = new TimeStampResponse(byteArrayOutputStream.toByteArray());
/* 184 */     timeStampResponse.validate(timeStampRequest);
/*     */     
/* 186 */     if (0 != timeStampResponse.getStatus()) {
/* 187 */       LOG.log(1, new Object[] { "status: " + timeStampResponse.getStatus() });
/* 188 */       LOG.log(1, new Object[] { "status string: " + timeStampResponse.getStatusString() });
/* 189 */       PKIFailureInfo pKIFailureInfo = timeStampResponse.getFailInfo();
/* 190 */       if (null != pKIFailureInfo) {
/* 191 */         LOG.log(1, new Object[] { "fail info int value: " + pKIFailureInfo.intValue() });
/* 192 */         if (256 == pKIFailureInfo.intValue()) {
/* 193 */           LOG.log(1, new Object[] { "unaccepted policy" });
/*     */         }
/*     */       } 
/* 196 */       throw new RuntimeException("timestamp response status != 0: " + timeStampResponse.getStatus());
/*     */     } 
/*     */     
/* 199 */     TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
/* 200 */     SignerId signerId = timeStampToken.getSID();
/* 201 */     BigInteger bigInteger2 = signerId.getSerialNumber();
/* 202 */     X500Name x500Name = signerId.getIssuer();
/* 203 */     LOG.log(1, new Object[] { "signer cert serial number: " + bigInteger2 });
/* 204 */     LOG.log(1, new Object[] { "signer cert issuer: " + x500Name });
/*     */ 
/*     */     
/* 207 */     Collection collection = timeStampToken.getCertificates().getMatches(null);
/*     */     
/* 209 */     X509CertificateHolder x509CertificateHolder1 = null;
/* 210 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 211 */     for (X509CertificateHolder x509CertificateHolder : collection) {
/* 212 */       if (x500Name.equals(x509CertificateHolder.getIssuer()) && bigInteger2.equals(x509CertificateHolder.getSerialNumber()))
/*     */       {
/* 214 */         x509CertificateHolder1 = x509CertificateHolder;
/*     */       }
/* 216 */       hashMap.put(x509CertificateHolder.getSubject(), x509CertificateHolder);
/*     */     } 
/*     */ 
/*     */     
/* 220 */     if (x509CertificateHolder1 == null) {
/* 221 */       throw new RuntimeException("TSP response token has no signer certificate");
/*     */     }
/* 223 */     ArrayList<X509Certificate> arrayList = new ArrayList();
/* 224 */     JcaX509CertificateConverter jcaX509CertificateConverter = new JcaX509CertificateConverter();
/* 225 */     jcaX509CertificateConverter.setProvider("BC");
/* 226 */     X509CertificateHolder x509CertificateHolder2 = x509CertificateHolder1;
/*     */     do {
/* 228 */       LOG.log(1, new Object[] { "adding to certificate chain: " + x509CertificateHolder2.getSubject() });
/* 229 */       arrayList.add(jcaX509CertificateConverter.getCertificate(x509CertificateHolder2));
/* 230 */       if (x509CertificateHolder2.getSubject().equals(x509CertificateHolder2.getIssuer())) {
/*     */         break;
/*     */       }
/* 233 */       x509CertificateHolder2 = (X509CertificateHolder)hashMap.get(x509CertificateHolder2.getIssuer());
/* 234 */     } while (null != x509CertificateHolder2);
/*     */ 
/*     */     
/* 237 */     X509CertificateHolder x509CertificateHolder3 = new X509CertificateHolder(((X509Certificate)arrayList.get(0)).getEncoded());
/* 238 */     DefaultCMSSignatureAlgorithmNameGenerator defaultCMSSignatureAlgorithmNameGenerator = new DefaultCMSSignatureAlgorithmNameGenerator();
/* 239 */     DefaultSignatureAlgorithmIdentifierFinder defaultSignatureAlgorithmIdentifierFinder = new DefaultSignatureAlgorithmIdentifierFinder();
/* 240 */     DefaultDigestAlgorithmIdentifierFinder defaultDigestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
/* 241 */     BcDigestCalculatorProvider bcDigestCalculatorProvider = new BcDigestCalculatorProvider();
/* 242 */     BcRSASignerInfoVerifierBuilder bcRSASignerInfoVerifierBuilder = new BcRSASignerInfoVerifierBuilder((CMSSignatureAlgorithmNameGenerator)defaultCMSSignatureAlgorithmNameGenerator, (SignatureAlgorithmIdentifierFinder)defaultSignatureAlgorithmIdentifierFinder, (DigestAlgorithmIdentifierFinder)defaultDigestAlgorithmIdentifierFinder, (DigestCalculatorProvider)bcDigestCalculatorProvider);
/* 243 */     SignerInformationVerifier signerInformationVerifier = bcRSASignerInfoVerifierBuilder.build(x509CertificateHolder3);
/*     */     
/* 245 */     timeStampToken.validate(signerInformationVerifier);
/*     */ 
/*     */     
/* 248 */     if (this.signatureConfig.getTspValidator() != null) {
/* 249 */       this.signatureConfig.getTspValidator().validate(arrayList, paramRevocationData);
/*     */     }
/*     */     
/* 252 */     LOG.log(1, new Object[] { "time-stamp token time: " + timeStampToken.getTimeStampInfo().getGenTime() });
/*     */ 
/*     */     
/* 255 */     return timeStampToken.getEncoded();
/*     */   }
/*     */   
/*     */   public void setSignatureConfig(SignatureConfig paramSignatureConfig) {
/* 259 */     this.signatureConfig = paramSignatureConfig;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\TSPTimeStampService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */