/*     */ package oshi.driver.windows.registry;
/*     */ 
/*     */ import com.sun.jna.platform.win32.Advapi32Util;
/*     */ import com.sun.jna.platform.win32.Win32Exception;
/*     */ import com.sun.jna.platform.win32.WinReg;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.OSSession;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class HkeyUserData
/*     */ {
/*     */   private static final String PATH_DELIMITER = "\\";
/*     */   private static final String DEFAULT_DEVICE = "Console";
/*     */   private static final String VOLATILE_ENV_SUBKEY = "Volatile Environment";
/*     */   private static final String CLIENTNAME = "CLIENTNAME";
/*     */   private static final String SESSIONNAME = "SESSIONNAME";
/*  55 */   private static final Logger LOG = LoggerFactory.getLogger(HkeyUserData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<OSSession> queryUserSessions() {
/*  61 */     ArrayList<OSSession> arrayList = new ArrayList();
/*  62 */     for (String str : Advapi32Util.registryGetKeys(WinReg.HKEY_USERS)) {
/*  63 */       if (!str.startsWith(".") && !str.endsWith("_Classes")) {
/*     */         try {
/*  65 */           Advapi32Util.Account account = Advapi32Util.getAccountBySid(str);
/*  66 */           String str1 = account.name;
/*  67 */           String str2 = "Console";
/*  68 */           String str3 = account.domain;
/*  69 */           long l = 0L;
/*  70 */           String str4 = str + "\\" + "Volatile Environment";
/*  71 */           if (Advapi32Util.registryKeyExists(WinReg.HKEY_USERS, str4)) {
/*  72 */             WinReg.HKEY hKEY = Advapi32Util.registryGetKey(WinReg.HKEY_USERS, str4, 131097).getValue();
/*     */             
/*  74 */             Advapi32Util.InfoKey infoKey = Advapi32Util.registryQueryInfoKey(hKEY, 0);
/*  75 */             l = infoKey.lpftLastWriteTime.toTime();
/*  76 */             for (String str5 : Advapi32Util.registryGetKeys(hKEY)) {
/*  77 */               String str6 = str4 + "\\" + str5;
/*     */               
/*  79 */               if (Advapi32Util.registryValueExists(WinReg.HKEY_USERS, str6, "SESSIONNAME")) {
/*  80 */                 String str7 = Advapi32Util.registryGetStringValue(WinReg.HKEY_USERS, str6, "SESSIONNAME");
/*     */                 
/*  82 */                 if (!str7.isEmpty()) {
/*  83 */                   str2 = str7;
/*     */                 }
/*     */               } 
/*  86 */               if (Advapi32Util.registryValueExists(WinReg.HKEY_USERS, str6, "CLIENTNAME")) {
/*  87 */                 String str7 = Advapi32Util.registryGetStringValue(WinReg.HKEY_USERS, str6, "CLIENTNAME");
/*     */                 
/*  89 */                 if (!str7.isEmpty() && !"Console".equals(str7)) {
/*  90 */                   str3 = str7;
/*     */                 }
/*     */               } 
/*     */             } 
/*  94 */             Advapi32Util.registryCloseKey(hKEY);
/*     */           } 
/*  96 */           arrayList.add(new OSSession(str1, str2, l, str3));
/*  97 */         } catch (Win32Exception win32Exception) {
/*  98 */           LOG.warn("Error querying SID {} from registry: {}", str, win32Exception.getMessage());
/*     */         } 
/*     */       }
/*     */     } 
/* 102 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\HkeyUserData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */