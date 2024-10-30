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
/*    */ public final class Win32DiskPartition
/*    */ {
/*    */   private static final String WIN32_DISK_PARTITION = "Win32_DiskPartition";
/*    */   
/*    */   public enum DiskPartitionProperty
/*    */   {
/* 44 */     INDEX, DESCRIPTION, DEVICEID, DISKINDEX, NAME, SIZE, TYPE;
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
/*    */   public static WbemcliUtil.WmiResult<DiskPartitionProperty> queryPartition(WmiQueryHandler paramWmiQueryHandler) {
/* 59 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_DiskPartition", DiskPartitionProperty.class);
/*    */     
/* 61 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32DiskPartition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */