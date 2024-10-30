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
/*    */ public final class Win32PhysicalMemory
/*    */ {
/*    */   private static final String WIN32_PHYSICAL_MEMORY = "Win32_PhysicalMemory";
/*    */   
/*    */   public enum PhysicalMemoryProperty
/*    */   {
/* 44 */     BANKLABEL, CAPACITY, SPEED, MANUFACTURER, SMBIOSMEMORYTYPE;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public enum PhysicalMemoryPropertyWin8
/*    */   {
/* 51 */     BANKLABEL, CAPACITY, SPEED, MANUFACTURER, MEMORYTYPE;
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
/*    */   public static WbemcliUtil.WmiResult<PhysicalMemoryProperty> queryphysicalMemory() {
/* 63 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_PhysicalMemory", PhysicalMemoryProperty.class);
/*    */     
/* 65 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WbemcliUtil.WmiResult<PhysicalMemoryPropertyWin8> queryphysicalMemoryWin8() {
/* 74 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_PhysicalMemory", PhysicalMemoryPropertyWin8.class);
/*    */     
/* 76 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32PhysicalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */