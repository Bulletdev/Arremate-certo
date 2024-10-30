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
/*    */ public final class Win32LogicalDiskToPartition
/*    */ {
/*    */   private static final String WIN32_LOGICAL_DISK_TO_PARTITION = "Win32_LogicalDiskToPartition";
/*    */   
/*    */   public enum DiskToPartitionProperty
/*    */   {
/* 44 */     ANTECEDENT, DEPENDENT, ENDINGADDRESS, STARTINGADDRESS;
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
/*    */   public static WbemcliUtil.WmiResult<DiskToPartitionProperty> queryDiskToPartition(WmiQueryHandler paramWmiQueryHandler) {
/* 59 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_LogicalDiskToPartition", DiskToPartitionProperty.class);
/*    */     
/* 61 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32LogicalDiskToPartition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */