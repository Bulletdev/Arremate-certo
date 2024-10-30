/*     */ package org.apache.http.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
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
/*     */ public class VersionInfo
/*     */ {
/*     */   public static final String UNAVAILABLE = "UNAVAILABLE";
/*     */   public static final String VERSION_PROPERTY_FILE = "version.properties";
/*     */   public static final String PROPERTY_MODULE = "info.module";
/*     */   public static final String PROPERTY_RELEASE = "info.release";
/*     */   public static final String PROPERTY_TIMESTAMP = "info.timestamp";
/*     */   private final String infoPackage;
/*     */   private final String infoModule;
/*     */   private final String infoRelease;
/*     */   private final String infoTimestamp;
/*     */   private final String infoClassloader;
/*     */   
/*     */   protected VersionInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
/*  91 */     Args.notNull(paramString1, "Package identifier");
/*  92 */     this.infoPackage = paramString1;
/*  93 */     this.infoModule = (paramString2 != null) ? paramString2 : "UNAVAILABLE";
/*  94 */     this.infoRelease = (paramString3 != null) ? paramString3 : "UNAVAILABLE";
/*  95 */     this.infoTimestamp = (paramString4 != null) ? paramString4 : "UNAVAILABLE";
/*  96 */     this.infoClassloader = (paramString5 != null) ? paramString5 : "UNAVAILABLE";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getPackage() {
/* 107 */     return this.infoPackage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getModule() {
/* 117 */     return this.infoModule;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getRelease() {
/* 127 */     return this.infoRelease;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getTimestamp() {
/* 137 */     return this.infoTimestamp;
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
/*     */   public final String getClassloader() {
/* 149 */     return this.infoClassloader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     StringBuilder stringBuilder = new StringBuilder(20 + this.infoPackage.length() + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     stringBuilder.append("VersionInfo(").append(this.infoPackage).append(':').append(this.infoModule);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     if (!"UNAVAILABLE".equals(this.infoRelease)) {
/* 171 */       stringBuilder.append(':').append(this.infoRelease);
/*     */     }
/* 173 */     if (!"UNAVAILABLE".equals(this.infoTimestamp)) {
/* 174 */       stringBuilder.append(':').append(this.infoTimestamp);
/*     */     }
/*     */     
/* 177 */     stringBuilder.append(')');
/*     */     
/* 179 */     if (!"UNAVAILABLE".equals(this.infoClassloader)) {
/* 180 */       stringBuilder.append('@').append(this.infoClassloader);
/*     */     }
/*     */     
/* 183 */     return stringBuilder.toString();
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
/*     */   public static VersionInfo[] loadVersionInfo(String[] paramArrayOfString, ClassLoader paramClassLoader) {
/* 199 */     Args.notNull(paramArrayOfString, "Package identifier array");
/* 200 */     ArrayList<VersionInfo> arrayList = new ArrayList(paramArrayOfString.length);
/* 201 */     for (String str : paramArrayOfString) {
/* 202 */       VersionInfo versionInfo = loadVersionInfo(str, paramClassLoader);
/* 203 */       if (versionInfo != null) {
/* 204 */         arrayList.add(versionInfo);
/*     */       }
/*     */     } 
/*     */     
/* 208 */     return arrayList.<VersionInfo>toArray(new VersionInfo[arrayList.size()]);
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
/*     */   public static VersionInfo loadVersionInfo(String paramString, ClassLoader paramClassLoader) {
/* 226 */     Args.notNull(paramString, "Package identifier");
/* 227 */     ClassLoader classLoader = (paramClassLoader != null) ? paramClassLoader : Thread.currentThread().getContextClassLoader();
/*     */     
/* 229 */     Properties properties = null;
/*     */ 
/*     */     
/*     */     try {
/* 233 */       InputStream inputStream = classLoader.getResourceAsStream(paramString.replace('.', '/') + "/" + "version.properties");
/*     */       
/* 235 */       if (inputStream != null) {
/*     */         try {
/* 237 */           Properties properties1 = new Properties();
/* 238 */           properties1.load(inputStream);
/* 239 */           properties = properties1;
/*     */         } finally {
/* 241 */           inputStream.close();
/*     */         } 
/*     */       }
/* 244 */     } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */     
/* 248 */     VersionInfo versionInfo = null;
/* 249 */     if (properties != null) {
/* 250 */       versionInfo = fromMap(paramString, properties, classLoader);
/*     */     }
/*     */     
/* 253 */     return versionInfo;
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
/*     */   protected static VersionInfo fromMap(String paramString, Map<?, ?> paramMap, ClassLoader paramClassLoader) {
/* 269 */     Args.notNull(paramString, "Package identifier");
/* 270 */     String str1 = null;
/* 271 */     String str2 = null;
/* 272 */     String str3 = null;
/*     */     
/* 274 */     if (paramMap != null) {
/* 275 */       str1 = (String)paramMap.get("info.module");
/* 276 */       if (str1 != null && str1.length() < 1) {
/* 277 */         str1 = null;
/*     */       }
/*     */       
/* 280 */       str2 = (String)paramMap.get("info.release");
/* 281 */       if (str2 != null && (str2.length() < 1 || str2.equals("${pom.version}")))
/*     */       {
/* 283 */         str2 = null;
/*     */       }
/*     */       
/* 286 */       str3 = (String)paramMap.get("info.timestamp");
/* 287 */       if (str3 != null && (str3.length() < 1 || str3.equals("${mvn.timestamp}")))
/*     */       {
/*     */ 
/*     */         
/* 291 */         str3 = null;
/*     */       }
/*     */     } 
/*     */     
/* 295 */     String str4 = null;
/* 296 */     if (paramClassLoader != null) {
/* 297 */       str4 = paramClassLoader.toString();
/*     */     }
/*     */     
/* 300 */     return new VersionInfo(paramString, str1, str2, str3, str4);
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
/*     */   public static String getUserAgent(String paramString1, String paramString2, Class<?> paramClass) {
/* 319 */     VersionInfo versionInfo = loadVersionInfo(paramString2, paramClass.getClassLoader());
/* 320 */     String str1 = (versionInfo != null) ? versionInfo.getRelease() : "UNAVAILABLE";
/* 321 */     String str2 = System.getProperty("java.version");
/*     */     
/* 323 */     return String.format("%s/%s (Java/%s)", new Object[] { paramString1, str1, str2 });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\VersionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */