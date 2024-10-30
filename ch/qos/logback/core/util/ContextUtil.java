/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.rolling.helper.FileNamePattern;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import java.net.InetAddress;
/*     */ import java.net.NetworkInterface;
/*     */ import java.net.SocketException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class ContextUtil
/*     */   extends ContextAwareBase
/*     */ {
/*     */   public ContextUtil(Context paramContext) {
/*  37 */     setContext(paramContext);
/*     */   }
/*     */   
/*     */   public static String getLocalHostName() throws UnknownHostException, SocketException {
/*     */     try {
/*  42 */       InetAddress inetAddress = InetAddress.getLocalHost();
/*  43 */       return inetAddress.getHostName();
/*  44 */     } catch (UnknownHostException unknownHostException) {
/*  45 */       return getLocalAddressAsString();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String getLocalAddressAsString() throws UnknownHostException, SocketException {
/*  50 */     Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
/*  51 */     while (enumeration != null && enumeration.hasMoreElements()) {
/*  52 */       Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
/*  53 */       while (enumeration1 != null && enumeration1.hasMoreElements()) {
/*  54 */         InetAddress inetAddress = enumeration1.nextElement();
/*  55 */         if (acceptableAddress(inetAddress)) {
/*  56 */           return inetAddress.getHostAddress();
/*     */         }
/*     */       } 
/*     */     } 
/*  60 */     throw new UnknownHostException();
/*     */   }
/*     */   
/*     */   private static boolean acceptableAddress(InetAddress paramInetAddress) {
/*  64 */     return (paramInetAddress != null && !paramInetAddress.isLoopbackAddress() && !paramInetAddress.isAnyLocalAddress() && !paramInetAddress.isLinkLocalAddress());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String safelyGetLocalHostName() {
/*     */     try {
/*  72 */       return getLocalHostName();
/*     */     }
/*  74 */     catch (UnknownHostException unknownHostException) {
/*  75 */       addError("Failed to get local hostname", unknownHostException);
/*  76 */     } catch (SocketException socketException) {
/*  77 */       addError("Failed to get local hostname", socketException);
/*  78 */     } catch (SecurityException securityException) {
/*  79 */       addError("Failed to get local hostname", securityException);
/*     */     } 
/*  81 */     return "UNKNOWN_LOCALHOST";
/*     */   }
/*     */   
/*     */   public void addProperties(Properties paramProperties) {
/*  85 */     if (paramProperties == null) {
/*     */       return;
/*     */     }
/*     */     
/*  89 */     Iterator<String> iterator = paramProperties.keySet().iterator();
/*  90 */     while (iterator.hasNext()) {
/*  91 */       String str = iterator.next();
/*  92 */       this.context.putProperty(str, paramProperties.getProperty(str));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Map<String, String> getFilenameCollisionMap(Context paramContext) {
/*  97 */     if (paramContext == null) {
/*  98 */       return null;
/*     */     }
/* 100 */     return (Map)paramContext.getObject("FA_FILENAME_COLLISION_MAP");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Map<String, FileNamePattern> getFilenamePatternCollisionMap(Context paramContext) {
/* 105 */     if (paramContext == null) {
/* 106 */       return null;
/*     */     }
/* 108 */     return (Map)paramContext.getObject("RFA_FILENAME_PATTERN_COLLISION_MAP");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addGroovyPackages(List<String> paramList) {
/* 114 */     addFrameworkPackage(paramList, "org.codehaus.groovy.runtime");
/*     */   }
/*     */   
/*     */   public void addFrameworkPackage(List<String> paramList, String paramString) {
/* 118 */     if (!paramList.contains(paramString))
/* 119 */       paramList.add(paramString); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\ContextUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */