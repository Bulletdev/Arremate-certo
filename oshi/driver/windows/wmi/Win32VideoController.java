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
/*    */ public final class Win32VideoController
/*    */ {
/*    */   private static final String WIN32_VIDEO_CONTROLLER = "Win32_VideoController";
/*    */   
/*    */   public enum VideoControllerProperty
/*    */   {
/* 44 */     ADAPTERCOMPATIBILITY, ADAPTERRAM, DRIVERVERSION, NAME, PNPDEVICEID;
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
/*    */   public static WbemcliUtil.WmiResult<VideoControllerProperty> queryVideoController() {
/* 56 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_VideoController", VideoControllerProperty.class);
/*    */     
/* 58 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32VideoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */