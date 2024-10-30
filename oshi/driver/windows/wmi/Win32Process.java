/*     */ package oshi.driver.windows.wmi;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.platform.windows.WmiQueryHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Win32Process
/*     */ {
/*     */   private static final String WIN32_PROCESS = "Win32_Process";
/*     */   
/*     */   public enum CommandLineProperty
/*     */   {
/*  47 */     PROCESSID, COMMANDLINE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ProcessXPProperty
/*     */   {
/*  54 */     PROCESSID, NAME, KERNELMODETIME, USERMODETIME, THREADCOUNT, PAGEFILEUSAGE, HANDLECOUNT, EXECUTABLEPATH;
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
/*     */   public static WbemcliUtil.WmiResult<CommandLineProperty> queryCommandLines(Set<Integer> paramSet) {
/*  70 */     StringBuilder stringBuilder = new StringBuilder("Win32_Process");
/*  71 */     if (paramSet != null) {
/*  72 */       boolean bool = true;
/*  73 */       for (Integer integer : paramSet) {
/*  74 */         if (bool) {
/*  75 */           stringBuilder.append(" WHERE ProcessID=");
/*  76 */           bool = false;
/*     */         } else {
/*  78 */           stringBuilder.append(" OR ProcessID=");
/*     */         } 
/*  80 */         stringBuilder.append(integer);
/*     */       } 
/*     */     } 
/*  83 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery(stringBuilder.toString(), CommandLineProperty.class);
/*  84 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WbemcliUtil.WmiResult<ProcessXPProperty> queryProcesses(Collection<Integer> paramCollection) {
/*  95 */     StringBuilder stringBuilder = new StringBuilder("Win32_Process");
/*  96 */     if (paramCollection != null) {
/*  97 */       boolean bool = true;
/*  98 */       for (Integer integer : paramCollection) {
/*  99 */         if (bool) {
/* 100 */           stringBuilder.append(" WHERE ProcessID=");
/* 101 */           bool = false;
/*     */         } else {
/* 103 */           stringBuilder.append(" OR ProcessID=");
/*     */         } 
/* 105 */         stringBuilder.append(integer);
/*     */       } 
/*     */     } 
/* 108 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery(stringBuilder.toString(), ProcessXPProperty.class);
/* 109 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32Process.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */