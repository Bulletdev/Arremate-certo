/*    */ package oshi.hardware.platform.windows;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.driver.windows.wmi.Win32Bios;
/*    */ import oshi.hardware.common.AbstractFirmware;
/*    */ import oshi.util.Memoizer;
/*    */ import oshi.util.Util;
/*    */ import oshi.util.platform.windows.WmiUtil;
/*    */ import oshi.util.tuples.Quintet;
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
/*    */ final class WindowsFirmware
/*    */   extends AbstractFirmware
/*    */ {
/* 47 */   private final Supplier<Quintet<String, String, String, String, String>> manufNameDescVersRelease = Memoizer.memoize(WindowsFirmware::queryManufNameDescVersRelease);
/*    */ 
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 52 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getA();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 57 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getB();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 62 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getC();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 67 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getD();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getReleaseDate() {
/* 72 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getE();
/*    */   }
/*    */   
/*    */   private static Quintet<String, String, String, String, String> queryManufNameDescVersRelease() {
/* 76 */     String str1 = null;
/* 77 */     String str2 = null;
/* 78 */     String str3 = null;
/* 79 */     String str4 = null;
/* 80 */     String str5 = null;
/* 81 */     WbemcliUtil.WmiResult wmiResult = Win32Bios.queryBiosInfo();
/* 82 */     if (wmiResult.getResultCount() > 0) {
/* 83 */       str1 = WmiUtil.getString(wmiResult, (Enum)Win32Bios.BiosProperty.MANUFACTURER, 0);
/* 84 */       str2 = WmiUtil.getString(wmiResult, (Enum)Win32Bios.BiosProperty.NAME, 0);
/* 85 */       str3 = WmiUtil.getString(wmiResult, (Enum)Win32Bios.BiosProperty.DESCRIPTION, 0);
/* 86 */       str4 = WmiUtil.getString(wmiResult, (Enum)Win32Bios.BiosProperty.VERSION, 0);
/* 87 */       str5 = WmiUtil.getDateString(wmiResult, (Enum)Win32Bios.BiosProperty.RELEASEDATE, 0);
/*    */     } 
/* 89 */     return new Quintet(Util.isBlank(str1) ? "unknown" : str1, 
/* 90 */         Util.isBlank(str2) ? "unknown" : str2, 
/* 91 */         Util.isBlank(str3) ? "unknown" : str3, 
/* 92 */         Util.isBlank(str4) ? "unknown" : str4, 
/* 93 */         Util.isBlank(str5) ? "unknown" : str5);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */