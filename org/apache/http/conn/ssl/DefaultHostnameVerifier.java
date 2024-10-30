/*     */ package org.apache.http.conn.ssl;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.CertificateParsingException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import javax.naming.InvalidNameException;
/*     */ import javax.naming.NamingException;
/*     */ import javax.naming.directory.Attribute;
/*     */ import javax.naming.directory.Attributes;
/*     */ import javax.naming.ldap.LdapName;
/*     */ import javax.naming.ldap.Rdn;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLException;
/*     */ import javax.net.ssl.SSLPeerUnverifiedException;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.security.auth.x500.X500Principal;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.util.DnsUtils;
/*     */ import org.apache.http.conn.util.DomainType;
/*     */ import org.apache.http.conn.util.InetAddressUtils;
/*     */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public final class DefaultHostnameVerifier
/*     */   implements HostnameVerifier
/*     */ {
/*     */   enum HostNameType
/*     */   {
/*  72 */     IPv4(7), IPv6(7), DNS(2);
/*     */     
/*     */     final int subjectType;
/*     */     
/*     */     HostNameType(int param1Int1) {
/*  77 */       this.subjectType = param1Int1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  82 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final PublicSuffixMatcher publicSuffixMatcher;
/*     */   
/*     */   public DefaultHostnameVerifier(PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  87 */     this.publicSuffixMatcher = paramPublicSuffixMatcher;
/*     */   }
/*     */   
/*     */   public DefaultHostnameVerifier() {
/*  91 */     this(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean verify(String paramString, SSLSession paramSSLSession) {
/*     */     try {
/*  97 */       Certificate[] arrayOfCertificate = paramSSLSession.getPeerCertificates();
/*  98 */       X509Certificate x509Certificate = (X509Certificate)arrayOfCertificate[0];
/*  99 */       verify(paramString, x509Certificate);
/* 100 */       return true;
/* 101 */     } catch (SSLException sSLException) {
/* 102 */       if (this.log.isDebugEnabled()) {
/* 103 */         this.log.debug(sSLException.getMessage(), sSLException);
/*     */       }
/* 105 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void verify(String paramString, X509Certificate paramX509Certificate) throws SSLException {
/* 111 */     HostNameType hostNameType = determineHostFormat(paramString);
/* 112 */     List<SubjectName> list = getSubjectAltNames(paramX509Certificate);
/* 113 */     if (list != null && !list.isEmpty()) {
/* 114 */       switch (hostNameType) {
/*     */         case IPv4:
/* 116 */           matchIPAddress(paramString, list);
/*     */           return;
/*     */         case IPv6:
/* 119 */           matchIPv6Address(paramString, list);
/*     */           return;
/*     */       } 
/* 122 */       matchDNSName(paramString, list, this.publicSuffixMatcher);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 127 */       X500Principal x500Principal = paramX509Certificate.getSubjectX500Principal();
/* 128 */       String str = extractCN(x500Principal.getName("RFC2253"));
/* 129 */       if (str == null) {
/* 130 */         throw new SSLException("Certificate subject for <" + paramString + "> doesn't contain " + "a common name and does not have alternative names");
/*     */       }
/*     */       
/* 133 */       matchCN(paramString, str, this.publicSuffixMatcher);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void matchIPAddress(String paramString, List<SubjectName> paramList) throws SSLException {
/* 138 */     for (byte b = 0; b < paramList.size(); b++) {
/* 139 */       SubjectName subjectName = paramList.get(b);
/* 140 */       if (subjectName.getType() == 7 && 
/* 141 */         paramString.equals(subjectName.getValue())) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 146 */     throw new SSLPeerUnverifiedException("Certificate for <" + paramString + "> doesn't match any " + "of the subject alternative names: " + paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   static void matchIPv6Address(String paramString, List<SubjectName> paramList) throws SSLException {
/* 151 */     String str = normaliseAddress(paramString);
/* 152 */     for (byte b = 0; b < paramList.size(); b++) {
/* 153 */       SubjectName subjectName = paramList.get(b);
/* 154 */       if (subjectName.getType() == 7) {
/* 155 */         String str1 = normaliseAddress(subjectName.getValue());
/* 156 */         if (str.equals(str1)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/* 161 */     throw new SSLPeerUnverifiedException("Certificate for <" + paramString + "> doesn't match any " + "of the subject alternative names: " + paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void matchDNSName(String paramString, List<SubjectName> paramList, PublicSuffixMatcher paramPublicSuffixMatcher) throws SSLException {
/* 167 */     String str = DnsUtils.normalize(paramString);
/* 168 */     for (byte b = 0; b < paramList.size(); b++) {
/* 169 */       SubjectName subjectName = paramList.get(b);
/* 170 */       if (subjectName.getType() == 2) {
/* 171 */         String str1 = DnsUtils.normalize(subjectName.getValue());
/* 172 */         if (matchIdentityStrict(str, str1, paramPublicSuffixMatcher)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/* 177 */     throw new SSLPeerUnverifiedException("Certificate for <" + paramString + "> doesn't match any " + "of the subject alternative names: " + paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void matchCN(String paramString1, String paramString2, PublicSuffixMatcher paramPublicSuffixMatcher) throws SSLException {
/* 183 */     String str1 = DnsUtils.normalize(paramString1);
/* 184 */     String str2 = DnsUtils.normalize(paramString2);
/* 185 */     if (!matchIdentityStrict(str1, str2, paramPublicSuffixMatcher)) {
/* 186 */       throw new SSLPeerUnverifiedException("Certificate for <" + paramString1 + "> doesn't match " + "common name of the certificate subject: " + paramString2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean matchDomainRoot(String paramString1, String paramString2) {
/* 192 */     if (paramString2 == null) {
/* 193 */       return false;
/*     */     }
/* 195 */     return (paramString1.endsWith(paramString2) && (paramString1.length() == paramString2.length() || paramString1.charAt(paramString1.length() - paramString2.length() - 1) == '.'));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean matchIdentity(String paramString1, String paramString2, PublicSuffixMatcher paramPublicSuffixMatcher, DomainType paramDomainType, boolean paramBoolean) {
/* 203 */     if (paramPublicSuffixMatcher != null && paramString1.contains(".") && 
/* 204 */       !matchDomainRoot(paramString1, paramPublicSuffixMatcher.getDomainRoot(paramString2, paramDomainType))) {
/* 205 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     int i = paramString2.indexOf('*');
/* 215 */     if (i != -1) {
/* 216 */       String str1 = paramString2.substring(0, i);
/* 217 */       String str2 = paramString2.substring(i + 1);
/* 218 */       if (!str1.isEmpty() && !paramString1.startsWith(str1)) {
/* 219 */         return false;
/*     */       }
/* 221 */       if (!str2.isEmpty() && !paramString1.endsWith(str2)) {
/* 222 */         return false;
/*     */       }
/*     */       
/* 225 */       if (paramBoolean) {
/* 226 */         String str = paramString1.substring(str1.length(), paramString1.length() - str2.length());
/*     */         
/* 228 */         if (str.contains(".")) {
/* 229 */           return false;
/*     */         }
/*     */       } 
/* 232 */       return true;
/*     */     } 
/* 234 */     return paramString1.equalsIgnoreCase(paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean matchIdentity(String paramString1, String paramString2, PublicSuffixMatcher paramPublicSuffixMatcher) {
/* 239 */     return matchIdentity(paramString1, paramString2, paramPublicSuffixMatcher, null, false);
/*     */   }
/*     */   
/*     */   static boolean matchIdentity(String paramString1, String paramString2) {
/* 243 */     return matchIdentity(paramString1, paramString2, null, null, false);
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean matchIdentityStrict(String paramString1, String paramString2, PublicSuffixMatcher paramPublicSuffixMatcher) {
/* 248 */     return matchIdentity(paramString1, paramString2, paramPublicSuffixMatcher, null, true);
/*     */   }
/*     */   
/*     */   static boolean matchIdentityStrict(String paramString1, String paramString2) {
/* 252 */     return matchIdentity(paramString1, paramString2, null, null, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean matchIdentity(String paramString1, String paramString2, PublicSuffixMatcher paramPublicSuffixMatcher, DomainType paramDomainType) {
/* 258 */     return matchIdentity(paramString1, paramString2, paramPublicSuffixMatcher, paramDomainType, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean matchIdentityStrict(String paramString1, String paramString2, PublicSuffixMatcher paramPublicSuffixMatcher, DomainType paramDomainType) {
/* 264 */     return matchIdentity(paramString1, paramString2, paramPublicSuffixMatcher, paramDomainType, true);
/*     */   }
/*     */   
/*     */   static String extractCN(String paramString) throws SSLException {
/* 268 */     if (paramString == null) {
/* 269 */       return null;
/*     */     }
/*     */     try {
/* 272 */       LdapName ldapName = new LdapName(paramString);
/* 273 */       List<Rdn> list = ldapName.getRdns();
/* 274 */       for (int i = list.size() - 1; i >= 0; i--) {
/* 275 */         Rdn rdn = list.get(i);
/* 276 */         Attributes attributes = rdn.toAttributes();
/* 277 */         Attribute attribute = attributes.get("cn");
/* 278 */         if (attribute != null) {
/*     */           try {
/* 280 */             Object object = attribute.get();
/* 281 */             if (object != null) {
/* 282 */               return object.toString();
/*     */             }
/* 284 */           } catch (NoSuchElementException noSuchElementException) {
/*     */           
/* 286 */           } catch (NamingException namingException) {}
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 291 */       return null;
/* 292 */     } catch (InvalidNameException invalidNameException) {
/* 293 */       throw new SSLException(paramString + " is not a valid X500 distinguished name");
/*     */     } 
/*     */   }
/*     */   
/*     */   static HostNameType determineHostFormat(String paramString) {
/* 298 */     if (InetAddressUtils.isIPv4Address(paramString)) {
/* 299 */       return HostNameType.IPv4;
/*     */     }
/* 301 */     String str = paramString;
/* 302 */     if (str.startsWith("[") && str.endsWith("]")) {
/* 303 */       str = paramString.substring(1, paramString.length() - 1);
/*     */     }
/* 305 */     if (InetAddressUtils.isIPv6Address(str)) {
/* 306 */       return HostNameType.IPv6;
/*     */     }
/* 308 */     return HostNameType.DNS;
/*     */   }
/*     */   
/*     */   static List<SubjectName> getSubjectAltNames(X509Certificate paramX509Certificate) {
/*     */     try {
/* 313 */       Collection<List<?>> collection = paramX509Certificate.getSubjectAlternativeNames();
/* 314 */       if (collection == null) {
/* 315 */         return Collections.emptyList();
/*     */       }
/* 317 */       ArrayList<SubjectName> arrayList = new ArrayList();
/* 318 */       for (List<Integer> list : collection) {
/* 319 */         Integer integer = (list.size() >= 2) ? list.get(0) : null;
/* 320 */         if (integer != null && (
/* 321 */           integer.intValue() == 2 || integer.intValue() == 7)) {
/* 322 */           String str = (String)list.get(1);
/* 323 */           if (str instanceof String) {
/* 324 */             arrayList.add(new SubjectName(str, integer.intValue())); continue;
/* 325 */           }  if (str instanceof byte[]);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 331 */       return arrayList;
/* 332 */     } catch (CertificateParsingException certificateParsingException) {
/* 333 */       return Collections.emptyList();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String normaliseAddress(String paramString) {
/* 341 */     if (paramString == null) {
/* 342 */       return paramString;
/*     */     }
/*     */     try {
/* 345 */       InetAddress inetAddress = InetAddress.getByName(paramString);
/* 346 */       return inetAddress.getHostAddress();
/* 347 */     } catch (UnknownHostException unknownHostException) {
/* 348 */       return paramString;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\ssl\DefaultHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */