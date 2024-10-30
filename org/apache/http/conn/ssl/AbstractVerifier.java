/*     */ package org.apache.http.conn.ssl;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import javax.net.ssl.SSLException;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import javax.security.auth.x500.X500Principal;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.conn.util.InetAddressUtils;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public abstract class AbstractVerifier
/*     */   implements X509HostnameVerifier
/*     */ {
/*  61 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*  63 */   static final String[] BAD_COUNTRY_2LDS = new String[] { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  69 */     Arrays.sort((Object[])BAD_COUNTRY_2LDS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void verify(String paramString, SSLSocket paramSSLSocket) throws IOException {
/*  75 */     Args.notNull(paramString, "Host");
/*  76 */     SSLSession sSLSession = paramSSLSocket.getSession();
/*  77 */     if (sSLSession == null) {
/*     */ 
/*     */ 
/*     */       
/*  81 */       InputStream inputStream = paramSSLSocket.getInputStream();
/*  82 */       inputStream.available();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       sSLSession = paramSSLSocket.getSession();
/* 102 */       if (sSLSession == null) {
/*     */ 
/*     */         
/* 105 */         paramSSLSocket.startHandshake();
/*     */ 
/*     */ 
/*     */         
/* 109 */         sSLSession = paramSSLSocket.getSession();
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     Certificate[] arrayOfCertificate = sSLSession.getPeerCertificates();
/* 114 */     X509Certificate x509Certificate = (X509Certificate)arrayOfCertificate[0];
/* 115 */     verify(paramString, x509Certificate);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean verify(String paramString, SSLSession paramSSLSession) {
/*     */     try {
/* 121 */       Certificate[] arrayOfCertificate = paramSSLSession.getPeerCertificates();
/* 122 */       X509Certificate x509Certificate = (X509Certificate)arrayOfCertificate[0];
/* 123 */       verify(paramString, x509Certificate);
/* 124 */       return true;
/* 125 */     } catch (SSLException sSLException) {
/* 126 */       if (this.log.isDebugEnabled()) {
/* 127 */         this.log.debug(sSLException.getMessage(), sSLException);
/*     */       }
/* 129 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void verify(String paramString, X509Certificate paramX509Certificate) throws SSLException {
/* 136 */     List<SubjectName> list = DefaultHostnameVerifier.getSubjectAltNames(paramX509Certificate);
/* 137 */     ArrayList<String> arrayList = new ArrayList();
/* 138 */     if (InetAddressUtils.isIPv4Address(paramString) || InetAddressUtils.isIPv6Address(paramString)) {
/* 139 */       for (SubjectName subjectName : list) {
/* 140 */         if (subjectName.getType() == 7) {
/* 141 */           arrayList.add(subjectName.getValue());
/*     */         }
/*     */       } 
/*     */     } else {
/* 145 */       for (SubjectName subjectName : list) {
/* 146 */         if (subjectName.getType() == 2) {
/* 147 */           arrayList.add(subjectName.getValue());
/*     */         }
/*     */       } 
/*     */     } 
/* 151 */     X500Principal x500Principal = paramX509Certificate.getSubjectX500Principal();
/* 152 */     String str = DefaultHostnameVerifier.extractCN(x500Principal.getName("RFC2253"));
/* 153 */     (new String[1])[0] = str; verify(paramString, (str != null) ? new String[1] : null, (arrayList != null && !arrayList.isEmpty()) ? arrayList.<String>toArray(new String[arrayList.size()]) : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean) throws SSLException {
/* 163 */     String str1 = (paramArrayOfString1 != null && paramArrayOfString1.length > 0) ? paramArrayOfString1[0] : null;
/* 164 */     List<T> list = (paramArrayOfString2 != null && paramArrayOfString2.length > 0) ? Arrays.<T>asList((T[])paramArrayOfString2) : null;
/*     */     
/* 166 */     String str2 = InetAddressUtils.isIPv6Address(paramString) ? DefaultHostnameVerifier.normaliseAddress(paramString.toLowerCase(Locale.ROOT)) : paramString;
/*     */ 
/*     */     
/* 169 */     if (list != null) {
/* 170 */       for (String str3 : list) {
/* 171 */         String str4 = InetAddressUtils.isIPv6Address(str3) ? DefaultHostnameVerifier.normaliseAddress(str3) : str3;
/*     */         
/* 173 */         if (matchIdentity(str2, str4, paramBoolean)) {
/*     */           return;
/*     */         }
/*     */       } 
/* 177 */       throw new SSLException("Certificate for <" + paramString + "> doesn't match any " + "of the subject alternative names: " + list);
/*     */     } 
/* 179 */     if (str1 != null) {
/* 180 */       String str = InetAddressUtils.isIPv6Address(str1) ? DefaultHostnameVerifier.normaliseAddress(str1) : str1;
/*     */       
/* 182 */       if (matchIdentity(str2, str, paramBoolean)) {
/*     */         return;
/*     */       }
/* 185 */       throw new SSLException("Certificate for <" + paramString + "> doesn't match " + "common name of the certificate subject: " + str1);
/*     */     } 
/*     */     
/* 188 */     throw new SSLException("Certificate subject for <" + paramString + "> doesn't contain " + "a common name and does not have alternative names");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean matchIdentity(String paramString1, String paramString2, boolean paramBoolean) {
/* 194 */     if (paramString1 == null) {
/* 195 */       return false;
/*     */     }
/* 197 */     String str1 = paramString1.toLowerCase(Locale.ROOT);
/* 198 */     String str2 = paramString2.toLowerCase(Locale.ROOT);
/*     */ 
/*     */ 
/*     */     
/* 202 */     String[] arrayOfString = str2.split("\\.");
/* 203 */     boolean bool = (arrayOfString.length >= 3 && arrayOfString[0].endsWith("*") && (!paramBoolean || validCountryWildcard(arrayOfString))) ? true : false;
/*     */     
/* 205 */     if (bool) {
/*     */       boolean bool1;
/* 207 */       String str = arrayOfString[0];
/* 208 */       if (str.length() > 1) {
/* 209 */         String str3 = str.substring(0, str.length() - 1);
/* 210 */         String str4 = str2.substring(str.length());
/* 211 */         String str5 = str1.substring(str3.length());
/* 212 */         bool1 = (str1.startsWith(str3) && str5.endsWith(str4));
/*     */       } else {
/* 214 */         bool1 = str1.endsWith(str2.substring(1));
/*     */       } 
/* 216 */       return (bool1 && (!paramBoolean || countDots(str1) == countDots(str2)));
/*     */     } 
/* 218 */     return str1.equals(str2);
/*     */   }
/*     */   
/*     */   private static boolean validCountryWildcard(String[] paramArrayOfString) {
/* 222 */     if (paramArrayOfString.length != 3 || paramArrayOfString[2].length() != 2) {
/* 223 */       return true;
/*     */     }
/* 225 */     return (Arrays.binarySearch((Object[])BAD_COUNTRY_2LDS, paramArrayOfString[1]) < 0);
/*     */   }
/*     */   
/*     */   public static boolean acceptableCountryWildcard(String paramString) {
/* 229 */     return validCountryWildcard(paramString.split("\\."));
/*     */   }
/*     */   
/*     */   public static String[] getCNs(X509Certificate paramX509Certificate) {
/* 233 */     String str = paramX509Certificate.getSubjectX500Principal().toString();
/*     */     try {
/* 235 */       String str1 = DefaultHostnameVerifier.extractCN(str);
/* 236 */       (new String[1])[0] = str1; return (str1 != null) ? new String[1] : null;
/* 237 */     } catch (SSLException sSLException) {
/* 238 */       return null;
/*     */     } 
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
/*     */   public static String[] getDNSSubjectAlts(X509Certificate paramX509Certificate) {
/* 259 */     List<SubjectName> list = DefaultHostnameVerifier.getSubjectAltNames(paramX509Certificate);
/* 260 */     if (list == null) {
/* 261 */       return null;
/*     */     }
/* 263 */     ArrayList<String> arrayList = new ArrayList();
/* 264 */     for (SubjectName subjectName : list) {
/* 265 */       if (subjectName.getType() == 2) {
/* 266 */         arrayList.add(subjectName.getValue());
/*     */       }
/*     */     } 
/* 269 */     return arrayList.isEmpty() ? arrayList.<String>toArray(new String[arrayList.size()]) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int countDots(String paramString) {
/* 278 */     byte b1 = 0;
/* 279 */     for (byte b2 = 0; b2 < paramString.length(); b2++) {
/* 280 */       if (paramString.charAt(b2) == '.') {
/* 281 */         b1++;
/*     */       }
/*     */     } 
/* 284 */     return b1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\AbstractVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */