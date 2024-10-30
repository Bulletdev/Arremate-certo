/*    */ package oshi.hardware.platform.windows;
/*    */ 
/*    */ import com.sun.jna.platform.win32.Advapi32Util;
/*    */ import com.sun.jna.platform.win32.Win32Exception;
/*    */ import com.sun.jna.platform.win32.WinReg;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.SoundCard;
/*    */ import oshi.hardware.common.AbstractSoundCard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Immutable
/*    */ final class WindowsSoundCard
/*    */   extends AbstractSoundCard
/*    */ {
/*    */   private static final String REGISTRY_SOUNDCARDS = "SYSTEM\\CurrentControlSet\\Control\\Class\\{4d36e96c-e325-11ce-bfc1-08002be10318}\\";
/*    */   
/*    */   WindowsSoundCard(String paramString1, String paramString2, String paramString3) {
/* 57 */     super(paramString1, paramString2, paramString3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<SoundCard> getSoundCards() {
/* 72 */     ArrayList<WindowsSoundCard> arrayList = new ArrayList();
/* 73 */     String[] arrayOfString = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE, "SYSTEM\\CurrentControlSet\\Control\\Class\\{4d36e96c-e325-11ce-bfc1-08002be10318}\\");
/* 74 */     for (String str1 : arrayOfString) {
/* 75 */       String str2 = "SYSTEM\\CurrentControlSet\\Control\\Class\\{4d36e96c-e325-11ce-bfc1-08002be10318}\\" + str1;
/*    */       try {
/* 77 */         if (Advapi32Util.registryValueExists(WinReg.HKEY_LOCAL_MACHINE, str2, "Driver")) {
/* 78 */           arrayList.add(new WindowsSoundCard(
/* 79 */                 Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str2, "Driver") + " " + 
/* 80 */                 Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str2, "DriverVersion"), 
/*    */                 
/* 82 */                 Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str2, "ProviderName") + " " + 
/*    */                 
/* 84 */                 Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str2, "DriverDesc"), 
/*    */                 
/* 86 */                 Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str2, "DriverDesc")));
/*    */         }
/* 88 */       } catch (Win32Exception win32Exception) {
/* 89 */         if (win32Exception.getErrorCode() != 5)
/*    */         {
/* 91 */           throw win32Exception;
/*    */         }
/*    */       } 
/*    */     } 
/* 95 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */