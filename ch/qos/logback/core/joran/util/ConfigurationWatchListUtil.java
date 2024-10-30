/*     */ package ch.qos.logback.core.joran.util;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
/*     */ import ch.qos.logback.core.status.InfoStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ import java.net.URL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConfigurationWatchListUtil
/*     */ {
/*  31 */   static final ConfigurationWatchListUtil origin = new ConfigurationWatchListUtil();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerConfigurationWatchList(Context paramContext, ConfigurationWatchList paramConfigurationWatchList) {
/*  38 */     paramContext.putObject("CONFIGURATION_WATCH_LIST", paramConfigurationWatchList);
/*     */   }
/*     */   public static void setMainWatchURL(Context paramContext, URL paramURL) {
/*  41 */     ConfigurationWatchList configurationWatchList = getConfigurationWatchList(paramContext);
/*  42 */     if (configurationWatchList == null) {
/*  43 */       configurationWatchList = new ConfigurationWatchList();
/*  44 */       configurationWatchList.setContext(paramContext);
/*  45 */       paramContext.putObject("CONFIGURATION_WATCH_LIST", configurationWatchList);
/*     */     } else {
/*  47 */       configurationWatchList.clear();
/*     */     } 
/*     */     
/*  50 */     configurationWatchList.setMainURL(paramURL);
/*     */   }
/*     */   
/*     */   public static URL getMainWatchURL(Context paramContext) {
/*  54 */     ConfigurationWatchList configurationWatchList = getConfigurationWatchList(paramContext);
/*  55 */     if (configurationWatchList == null) {
/*  56 */       return null;
/*     */     }
/*  58 */     return configurationWatchList.getMainURL();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addToWatchList(Context paramContext, URL paramURL) {
/*  63 */     ConfigurationWatchList configurationWatchList = getConfigurationWatchList(paramContext);
/*  64 */     if (configurationWatchList == null) {
/*  65 */       addWarn(paramContext, "Null ConfigurationWatchList. Cannot add " + paramURL);
/*     */     } else {
/*  67 */       addInfo(paramContext, "Adding [" + paramURL + "] to configuration watch list.");
/*  68 */       configurationWatchList.addToWatchList(paramURL);
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
/*     */   public static ConfigurationWatchList getConfigurationWatchList(Context paramContext) {
/*  86 */     return (ConfigurationWatchList)paramContext.getObject("CONFIGURATION_WATCH_LIST");
/*     */   }
/*     */   
/*     */   static void addStatus(Context paramContext, Status paramStatus) {
/*  90 */     if (paramContext == null) {
/*  91 */       System.out.println("Null context in " + ConfigurationWatchList.class.getName());
/*     */       return;
/*     */     } 
/*  94 */     StatusManager statusManager = paramContext.getStatusManager();
/*  95 */     if (statusManager == null)
/*     */       return; 
/*  97 */     statusManager.add(paramStatus);
/*     */   }
/*     */   
/*     */   static void addInfo(Context paramContext, String paramString) {
/* 101 */     addStatus(paramContext, (Status)new InfoStatus(paramString, origin));
/*     */   }
/*     */   
/*     */   static void addWarn(Context paramContext, String paramString) {
/* 105 */     addStatus(paramContext, (Status)new WarnStatus(paramString, origin));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\ConfigurationWatchListUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */