/*     */ package oshi.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.PlatformEnum;
/*     */ import oshi.SystemInfo;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class ExecutingCommand
/*     */ {
/*  48 */   private static final Logger LOG = LoggerFactory.getLogger(ExecutingCommand.class);
/*     */   
/*  50 */   private static final String[] DEFAULT_ENV = getDefaultEnv();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] getDefaultEnv() {
/*  56 */     PlatformEnum platformEnum = SystemInfo.getCurrentPlatform();
/*  57 */     if (platformEnum == PlatformEnum.WINDOWS)
/*  58 */       return new String[] { "LANGUAGE=C" }; 
/*  59 */     if (platformEnum != PlatformEnum.UNKNOWN) {
/*  60 */       return new String[] { "LC_ALL=C" };
/*     */     }
/*  62 */     return null;
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
/*     */   public static List<String> runNative(String paramString) {
/*  79 */     String[] arrayOfString = paramString.split(" ");
/*  80 */     return runNative(arrayOfString);
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
/*     */   public static List<String> runNative(String[] paramArrayOfString) {
/*  97 */     return runNative(paramArrayOfString, DEFAULT_ENV);
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
/*     */   
/*     */   public static List<String> runNative(String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 118 */     Process process = null;
/*     */     try {
/* 120 */       process = Runtime.getRuntime().exec(paramArrayOfString1, paramArrayOfString2);
/* 121 */     } catch (SecurityException|IOException securityException) {
/* 122 */       LOG.trace("Couldn't run command {}: {}", Arrays.toString((Object[])paramArrayOfString1), securityException.getMessage());
/* 123 */       return new ArrayList<>(0);
/*     */     } 
/*     */     
/* 126 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 128 */     try { BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.defaultCharset())); 
/*     */       try { String str;
/* 130 */         while ((str = bufferedReader.readLine()) != null) {
/* 131 */           arrayList.add(str);
/*     */         }
/* 133 */         process.waitFor();
/* 134 */         bufferedReader.close(); } catch (Throwable throwable) { try { bufferedReader.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (IOException iOException)
/* 135 */     { LOG.trace("Problem reading output from {}: {}", Arrays.toString((Object[])paramArrayOfString1), iOException.getMessage());
/* 136 */       return new ArrayList<>(0); }
/* 137 */     catch (InterruptedException interruptedException)
/* 138 */     { LOG.trace("Interrupted while reading output from {}: {}", Arrays.toString((Object[])paramArrayOfString1), interruptedException
/* 139 */           .getMessage());
/* 140 */       Thread.currentThread().interrupt(); }
/*     */     
/* 142 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFirstAnswer(String paramString) {
/* 153 */     return getAnswerAt(paramString, 0);
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
/*     */   public static String getAnswerAt(String paramString, int paramInt) {
/* 168 */     List<String> list = runNative(paramString);
/*     */     
/* 170 */     if (paramInt >= 0 && paramInt < list.size()) {
/* 171 */       return list.get(paramInt);
/*     */     }
/* 173 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\ExecutingCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */