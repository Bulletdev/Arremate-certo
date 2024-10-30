/*    */ package oshi.driver.windows.wmi;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.platform.windows.WmiQueryHandler;
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
/*    */ @ThreadSafe
/*    */ public final class Win32OperatingSystem
/*    */ {
/*    */   private static final String WIN32_OPERATING_SYSTEM = "Win32_OperatingSystem";
/*    */   
/*    */   public enum OSVersionProperty
/*    */   {
/* 44 */     VERSION, PRODUCTTYPE, BUILDNUMBER, CSDVERSION, SUITEMASK;
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
/*    */   public static WbemcliUtil.WmiResult<OSVersionProperty> queryOsVersion() {
/* 56 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_OperatingSystem", OSVersionProperty.class);
/* 57 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32OperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */