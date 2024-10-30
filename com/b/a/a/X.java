/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.CertificateParsingException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLException;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.security.auth.x500.X500Principal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class x
/*     */   implements HostnameVerifier
/*     */ {
/*  39 */   public static final x a = new x();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
/*     */ 
/*     */   
/*     */   private static final int hb = 2;
/*     */ 
/*     */   
/*     */   private static final int hc = 7;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean verify(String paramString, SSLSession paramSSLSession) {
/*     */     try {
/*  64 */       Certificate[] arrayOfCertificate = paramSSLSession.getPeerCertificates();
/*  65 */       return a(paramString, (X509Certificate)arrayOfCertificate[0]);
/*  66 */     } catch (SSLException sSLException) {
/*  67 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean a(String paramString, X509Certificate paramX509Certificate) {
/*  72 */     return B(paramString) ? 
/*  73 */       b(paramString, paramX509Certificate) : 
/*  74 */       c(paramString, paramX509Certificate);
/*     */   }
/*     */   
/*     */   static boolean B(String paramString) {
/*  78 */     return b.matcher(paramString).matches();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean b(String paramString, X509Certificate paramX509Certificate) {
/*  85 */     List<String> list = a(paramX509Certificate, 7); byte b; int i;
/*  86 */     for (b = 0, i = list.size(); b < i; b++) {
/*  87 */       if (paramString.equalsIgnoreCase(list.get(b))) {
/*  88 */         return true;
/*     */       }
/*     */     } 
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean c(String paramString, X509Certificate paramX509Certificate) {
/*  98 */     paramString = paramString.toLowerCase(Locale.US);
/*  99 */     boolean bool = false;
/* 100 */     List<String> list = a(paramX509Certificate, 2); byte b; int i;
/* 101 */     for (b = 0, i = list.size(); b < i; b++) {
/* 102 */       bool = true;
/* 103 */       if (g(paramString, list.get(b))) {
/* 104 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 108 */     if (!bool) {
/* 109 */       X500Principal x500Principal = paramX509Certificate.getSubjectX500Principal();
/*     */       
/* 111 */       String str = (new j(x500Principal)).ay("cn");
/* 112 */       if (str != null) {
/* 113 */         return g(paramString, str);
/*     */       }
/*     */     } 
/*     */     
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   public static List<String> a(X509Certificate paramX509Certificate) {
/* 121 */     List<String> list1 = a(paramX509Certificate, 7);
/* 122 */     List<String> list2 = a(paramX509Certificate, 2);
/* 123 */     ArrayList<String> arrayList = new ArrayList(list1.size() + list2.size());
/* 124 */     arrayList.addAll(list1);
/* 125 */     arrayList.addAll(list2);
/* 126 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static List<String> a(X509Certificate paramX509Certificate, int paramInt) {
/* 130 */     ArrayList<String> arrayList = new ArrayList();
/*     */     try {
/* 132 */       Collection<List<?>> collection = paramX509Certificate.getSubjectAlternativeNames();
/* 133 */       if (collection == null) {
/* 134 */         return Collections.emptyList();
/*     */       }
/* 136 */       for (List<?> list : collection) {
/* 137 */         List<Integer> list1 = (List)list;
/* 138 */         if (list1 == null || list1.size() < 2) {
/*     */           continue;
/*     */         }
/* 141 */         Integer integer = list1.get(0);
/* 142 */         if (integer == null) {
/*     */           continue;
/*     */         }
/* 145 */         if (integer.intValue() == paramInt) {
/* 146 */           String str = (String)list1.get(1);
/* 147 */           if (str != null) {
/* 148 */             arrayList.add(str);
/*     */           }
/*     */         } 
/*     */       } 
/* 152 */       return arrayList;
/* 153 */     } catch (CertificateParsingException certificateParsingException) {
/* 154 */       return Collections.emptyList();
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
/*     */   private boolean g(String paramString1, String paramString2) {
/* 168 */     if (paramString1 == null || paramString1.length() == 0 || paramString1.startsWith(".") || paramString1
/* 169 */       .endsWith(".."))
/*     */     {
/* 171 */       return false;
/*     */     }
/* 173 */     if (paramString2 == null || paramString2.length() == 0 || paramString2.startsWith(".") || paramString2
/* 174 */       .endsWith(".."))
/*     */     {
/* 176 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     if (!paramString1.endsWith(".")) {
/* 189 */       paramString1 = paramString1 + '.';
/*     */     }
/* 191 */     if (!paramString2.endsWith(".")) {
/* 192 */       paramString2 = paramString2 + '.';
/*     */     }
/*     */ 
/*     */     
/* 196 */     paramString2 = paramString2.toLowerCase(Locale.US);
/*     */ 
/*     */     
/* 199 */     if (!paramString2.contains("*"))
/*     */     {
/* 201 */       return paramString1.equals(paramString2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     if (!paramString2.startsWith("*.") || paramString2.indexOf('*', 1) != -1)
/*     */     {
/*     */       
/* 218 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     if (paramString1.length() < paramString2.length())
/*     */     {
/* 226 */       return false;
/*     */     }
/*     */     
/* 229 */     if ("*.".equals(paramString2))
/*     */     {
/* 231 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 235 */     String str = paramString2.substring(1);
/* 236 */     if (!paramString1.endsWith(str))
/*     */     {
/* 238 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 242 */     int i = paramString1.length() - str.length();
/* 243 */     if (i > 0 && paramString1
/* 244 */       .lastIndexOf('.', i - 1) != -1)
/*     */     {
/* 246 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 250 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\x.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */