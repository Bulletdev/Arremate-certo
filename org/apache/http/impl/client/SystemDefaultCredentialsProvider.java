/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.net.Authenticator;
/*     */ import java.net.PasswordAuthentication;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.NTCredentials;
/*     */ import org.apache.http.auth.UsernamePasswordCredentials;
/*     */ import org.apache.http.client.CredentialsProvider;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class SystemDefaultCredentialsProvider
/*     */   implements CredentialsProvider
/*     */ {
/*  58 */   private static final Map<String, String> SCHEME_MAP = new ConcurrentHashMap<String, String>(); static {
/*  59 */     SCHEME_MAP.put("Basic".toUpperCase(Locale.ROOT), "Basic");
/*  60 */     SCHEME_MAP.put("Digest".toUpperCase(Locale.ROOT), "Digest");
/*  61 */     SCHEME_MAP.put("NTLM".toUpperCase(Locale.ROOT), "NTLM");
/*  62 */     SCHEME_MAP.put("Negotiate".toUpperCase(Locale.ROOT), "SPNEGO");
/*  63 */     SCHEME_MAP.put("Kerberos".toUpperCase(Locale.ROOT), "Kerberos");
/*     */   }
/*     */   private final BasicCredentialsProvider internal;
/*     */   private static String translateScheme(String paramString) {
/*  67 */     if (paramString == null) {
/*  68 */       return null;
/*     */     }
/*  70 */     String str = SCHEME_MAP.get(paramString);
/*  71 */     return (str != null) ? str : paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SystemDefaultCredentialsProvider() {
/*  81 */     this.internal = new BasicCredentialsProvider();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials) {
/*  86 */     this.internal.setCredentials(paramAuthScope, paramCredentials);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PasswordAuthentication getSystemCreds(String paramString, AuthScope paramAuthScope, Authenticator.RequestorType paramRequestorType) {
/*  93 */     return Authenticator.requestPasswordAuthentication(paramAuthScope.getHost(), null, paramAuthScope.getPort(), paramString, null, translateScheme(paramAuthScope.getScheme()), null, paramRequestorType);
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
/*     */   public Credentials getCredentials(AuthScope paramAuthScope) {
/* 106 */     Args.notNull(paramAuthScope, "Auth scope");
/* 107 */     Credentials credentials = this.internal.getCredentials(paramAuthScope);
/* 108 */     if (credentials != null) {
/* 109 */       return credentials;
/*     */     }
/* 111 */     String str = paramAuthScope.getHost();
/* 112 */     if (str != null) {
/* 113 */       HttpHost httpHost = paramAuthScope.getOrigin();
/* 114 */       String str1 = (httpHost != null) ? httpHost.getSchemeName() : ((paramAuthScope.getPort() == 443) ? "https" : "http");
/* 115 */       PasswordAuthentication passwordAuthentication = getSystemCreds(str1, paramAuthScope, Authenticator.RequestorType.SERVER);
/* 116 */       if (passwordAuthentication == null) {
/* 117 */         passwordAuthentication = getSystemCreds(str1, paramAuthScope, Authenticator.RequestorType.PROXY);
/*     */       }
/* 119 */       if (passwordAuthentication == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 124 */         passwordAuthentication = getProxyCredentials("http", paramAuthScope);
/* 125 */         if (passwordAuthentication == null) {
/* 126 */           passwordAuthentication = getProxyCredentials("https", paramAuthScope);
/*     */         }
/*     */       } 
/* 129 */       if (passwordAuthentication != null) {
/* 130 */         String str2 = System.getProperty("http.auth.ntlm.domain");
/* 131 */         if (str2 != null) {
/* 132 */           return (Credentials)new NTCredentials(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()), null, str2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 137 */         return "NTLM".equalsIgnoreCase(paramAuthScope.getScheme()) ? (Credentials)new NTCredentials(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()), null, null) : (Credentials)new UsernamePasswordCredentials(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     return null;
/*     */   }
/*     */   
/*     */   private static PasswordAuthentication getProxyCredentials(String paramString, AuthScope paramAuthScope) {
/* 149 */     String str1 = System.getProperty(paramString + ".proxyHost");
/* 150 */     if (str1 == null) {
/* 151 */       return null;
/*     */     }
/* 153 */     String str2 = System.getProperty(paramString + ".proxyPort");
/* 154 */     if (str2 == null) {
/* 155 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 159 */       AuthScope authScope = new AuthScope(str1, Integer.parseInt(str2));
/* 160 */       if (paramAuthScope.match(authScope) >= 0) {
/* 161 */         String str3 = System.getProperty(paramString + ".proxyUser");
/* 162 */         if (str3 == null) {
/* 163 */           return null;
/*     */         }
/* 165 */         String str4 = System.getProperty(paramString + ".proxyPassword");
/*     */         
/* 167 */         return new PasswordAuthentication(str3, (str4 != null) ? str4.toCharArray() : new char[0]);
/*     */       }
/*     */     
/* 170 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */     
/* 173 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 178 */     this.internal.clear();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\SystemDefaultCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */