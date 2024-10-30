/*     */ package ch.qos.logback.core.net.ssl;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import ch.qos.logback.core.util.StringCollectionUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSLParametersConfiguration
/*     */   extends ContextAwareBase
/*     */ {
/*     */   private String includedProtocols;
/*     */   private String excludedProtocols;
/*     */   private String includedCipherSuites;
/*     */   private String excludedCipherSuites;
/*     */   private Boolean needClientAuth;
/*     */   private Boolean wantClientAuth;
/*     */   private String[] enabledProtocols;
/*     */   private String[] enabledCipherSuites;
/*     */   private Boolean hostnameVerification;
/*     */   
/*     */   public void configure(SSLConfigurable paramSSLConfigurable) {
/*  51 */     paramSSLConfigurable.setEnabledProtocols(enabledProtocols(paramSSLConfigurable.getSupportedProtocols(), paramSSLConfigurable.getDefaultProtocols()));
/*  52 */     paramSSLConfigurable.setEnabledCipherSuites(enabledCipherSuites(paramSSLConfigurable.getSupportedCipherSuites(), paramSSLConfigurable.getDefaultCipherSuites()));
/*  53 */     if (isNeedClientAuth() != null) {
/*  54 */       paramSSLConfigurable.setNeedClientAuth(isNeedClientAuth().booleanValue());
/*     */     }
/*  56 */     if (isWantClientAuth() != null) {
/*  57 */       paramSSLConfigurable.setWantClientAuth(isWantClientAuth().booleanValue());
/*     */     }
/*  59 */     if (this.hostnameVerification != null) {
/*  60 */       addInfo("hostnameVerification=" + this.hostnameVerification);
/*  61 */       paramSSLConfigurable.setHostnameVerification(this.hostnameVerification.booleanValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getHostnameVerification() {
/*  67 */     if (this.hostnameVerification == null)
/*  68 */       return false; 
/*  69 */     return this.hostnameVerification.booleanValue();
/*     */   }
/*     */   
/*     */   public void setHostnameVerification(boolean paramBoolean) {
/*  73 */     this.hostnameVerification = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] enabledProtocols(String[] paramArrayOfString1, String[] paramArrayOfString2) {
/*  83 */     if (this.enabledProtocols == null) {
/*     */ 
/*     */       
/*  86 */       if (OptionHelper.isEmpty(getIncludedProtocols()) && OptionHelper.isEmpty(getExcludedProtocols())) {
/*  87 */         this.enabledProtocols = Arrays.<String>copyOf(paramArrayOfString2, paramArrayOfString2.length);
/*     */       } else {
/*  89 */         this.enabledProtocols = includedStrings(paramArrayOfString1, getIncludedProtocols(), getExcludedProtocols());
/*     */       } 
/*  91 */       for (String str : this.enabledProtocols) {
/*  92 */         addInfo("enabled protocol: " + str);
/*     */       }
/*     */     } 
/*  95 */     return this.enabledProtocols;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] enabledCipherSuites(String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 105 */     if (this.enabledCipherSuites == null) {
/*     */ 
/*     */       
/* 108 */       if (OptionHelper.isEmpty(getIncludedCipherSuites()) && OptionHelper.isEmpty(getExcludedCipherSuites())) {
/* 109 */         this.enabledCipherSuites = Arrays.<String>copyOf(paramArrayOfString2, paramArrayOfString2.length);
/*     */       } else {
/* 111 */         this.enabledCipherSuites = includedStrings(paramArrayOfString1, getIncludedCipherSuites(), getExcludedCipherSuites());
/*     */       } 
/* 113 */       for (String str : this.enabledCipherSuites) {
/* 114 */         addInfo("enabled cipher suite: " + str);
/*     */       }
/*     */     } 
/* 117 */     return this.enabledCipherSuites;
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
/*     */   private String[] includedStrings(String[] paramArrayOfString, String paramString1, String paramString2) {
/* 131 */     ArrayList arrayList = new ArrayList(paramArrayOfString.length);
/* 132 */     arrayList.addAll(Arrays.asList(paramArrayOfString));
/* 133 */     if (paramString1 != null) {
/* 134 */       StringCollectionUtil.retainMatching(arrayList, stringToArray(paramString1));
/*     */     }
/* 136 */     if (paramString2 != null) {
/* 137 */       StringCollectionUtil.removeMatching(arrayList, stringToArray(paramString2));
/*     */     }
/* 139 */     return (String[])arrayList.toArray((Object[])new String[arrayList.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] stringToArray(String paramString) {
/* 148 */     return paramString.split("\\s*,\\s*");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIncludedProtocols() {
/* 157 */     return this.includedProtocols;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludedProtocols(String paramString) {
/* 167 */     this.includedProtocols = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExcludedProtocols() {
/* 176 */     return this.excludedProtocols;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExcludedProtocols(String paramString) {
/* 186 */     this.excludedProtocols = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIncludedCipherSuites() {
/* 195 */     return this.includedCipherSuites;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIncludedCipherSuites(String paramString) {
/* 205 */     this.includedCipherSuites = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExcludedCipherSuites() {
/* 214 */     return this.excludedCipherSuites;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExcludedCipherSuites(String paramString) {
/* 224 */     this.excludedCipherSuites = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean isNeedClientAuth() {
/* 232 */     return this.needClientAuth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNeedClientAuth(Boolean paramBoolean) {
/* 240 */     this.needClientAuth = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean isWantClientAuth() {
/* 248 */     return this.wantClientAuth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWantClientAuth(Boolean paramBoolean) {
/* 256 */     this.wantClientAuth = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\ssl\SSLParametersConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */