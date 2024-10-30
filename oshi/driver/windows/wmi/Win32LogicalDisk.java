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
/*    */ public final class Win32LogicalDisk
/*    */ {
/*    */   private static final String WIN32_LOGICAL_DISK = "Win32_LogicalDisk";
/*    */   
/*    */   public enum LogicalDiskProperty
/*    */   {
/* 44 */     ACCESS, DESCRIPTION, DRIVETYPE, FILESYSTEM, FREESPACE, NAME, PROVIDERNAME, SIZE, VOLUMENAME;
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
/*    */   
/*    */   public static WbemcliUtil.WmiResult<LogicalDiskProperty> queryLogicalDisk(String paramString, boolean paramBoolean) {
/* 60 */     StringBuilder stringBuilder = new StringBuilder("Win32_LogicalDisk");
/* 61 */     boolean bool = false;
/* 62 */     if (paramBoolean) {
/* 63 */       stringBuilder.append(" WHERE DriveType != 4");
/* 64 */       bool = true;
/*    */     } 
/* 66 */     if (paramString != null) {
/* 67 */       stringBuilder.append(bool ? " AND" : " WHERE").append(" Name=\"").append(paramString).append('"');
/*    */     }
/* 69 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery(stringBuilder.toString(), LogicalDiskProperty.class);
/*    */     
/* 71 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32LogicalDisk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */