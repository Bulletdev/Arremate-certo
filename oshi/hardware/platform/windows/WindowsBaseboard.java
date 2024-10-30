/*    */ package oshi.hardware.platform.windows;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.driver.windows.wmi.Win32BaseBoard;
/*    */ import oshi.hardware.common.AbstractBaseboard;
/*    */ import oshi.util.Memoizer;
/*    */ import oshi.util.Util;
/*    */ import oshi.util.platform.windows.WmiUtil;
/*    */ import oshi.util.tuples.Quartet;
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
/*    */ final class WindowsBaseboard
/*    */   extends AbstractBaseboard
/*    */ {
/* 47 */   private final Supplier<Quartet<String, String, String, String>> manufModelVersSerial = Memoizer.memoize(WindowsBaseboard::queryManufModelVersSerial);
/*    */ 
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 52 */     return (String)((Quartet)this.manufModelVersSerial.get()).getA();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModel() {
/* 57 */     return (String)((Quartet)this.manufModelVersSerial.get()).getB();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 62 */     return (String)((Quartet)this.manufModelVersSerial.get()).getC();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSerialNumber() {
/* 67 */     return (String)((Quartet)this.manufModelVersSerial.get()).getD();
/*    */   }
/*    */   
/*    */   private static Quartet<String, String, String, String> queryManufModelVersSerial() {
/* 71 */     String str1 = null;
/* 72 */     String str2 = null;
/* 73 */     String str3 = null;
/* 74 */     String str4 = null;
/* 75 */     WbemcliUtil.WmiResult wmiResult = Win32BaseBoard.queryBaseboardInfo();
/* 76 */     if (wmiResult.getResultCount() > 0) {
/* 77 */       str1 = WmiUtil.getString(wmiResult, (Enum)Win32BaseBoard.BaseBoardProperty.MANUFACTURER, 0);
/* 78 */       str2 = WmiUtil.getString(wmiResult, (Enum)Win32BaseBoard.BaseBoardProperty.MODEL, 0);
/* 79 */       str3 = WmiUtil.getString(wmiResult, (Enum)Win32BaseBoard.BaseBoardProperty.VERSION, 0);
/* 80 */       str4 = WmiUtil.getString(wmiResult, (Enum)Win32BaseBoard.BaseBoardProperty.SERIALNUMBER, 0);
/*    */     } 
/* 82 */     return new Quartet(Util.isBlank(str1) ? "unknown" : str1, 
/* 83 */         Util.isBlank(str2) ? "unknown" : str2, Util.isBlank(str3) ? "unknown" : str3, 
/* 84 */         Util.isBlank(str4) ? "unknown" : str4);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsBaseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */