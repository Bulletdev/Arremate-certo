/*     */ package oshi.driver.windows.wmi;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.platform.windows.WmiQueryHandler;
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
/*     */ public final class MSFTStorage
/*     */ {
/*     */   private static final String STORAGE_NAMESPACE = "ROOT\\Microsoft\\Windows\\Storage";
/*     */   private static final String MSFT_STORAGE_POOL_WHERE_IS_PRIMORDIAL_FALSE = "MSFT_StoragePool WHERE IsPrimordial=FALSE";
/*     */   private static final String MSFT_STORAGE_POOL_TO_PHYSICAL_DISK = "MSFT_StoragePoolToPhysicalDisk";
/*     */   private static final String MSFT_PHYSICAL_DISK = "MSFT_PhysicalDisk";
/*     */   private static final String MSFT_VIRTUAL_DISK = "MSFT_VirtualDisk";
/*     */   
/*     */   public enum StoragePoolProperty
/*     */   {
/*  50 */     FRIENDLYNAME, OBJECTID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum StoragePoolToPhysicalDiskProperty
/*     */   {
/*  58 */     STORAGEPOOL, PHYSICALDISK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum PhysicalDiskProperty
/*     */   {
/*  65 */     FRIENDLYNAME, PHYSICALLOCATION, OBJECTID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum VirtualDiskProperty
/*     */   {
/*  72 */     FRIENDLYNAME, OBJECTID;
/*     */   }
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
/*     */   public static WbemcliUtil.WmiResult<StoragePoolProperty> queryStoragePools(WmiQueryHandler paramWmiQueryHandler) {
/*  88 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("ROOT\\Microsoft\\Windows\\Storage", "MSFT_StoragePool WHERE IsPrimordial=FALSE", StoragePoolProperty.class);
/*     */     
/*  90 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*     */   }
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
/*     */   public static WbemcliUtil.WmiResult<StoragePoolToPhysicalDiskProperty> queryStoragePoolPhysicalDisks(WmiQueryHandler paramWmiQueryHandler) {
/* 104 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("ROOT\\Microsoft\\Windows\\Storage", "MSFT_StoragePoolToPhysicalDisk", StoragePoolToPhysicalDiskProperty.class);
/*     */     
/* 106 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WbemcliUtil.WmiResult<PhysicalDiskProperty> queryPhysicalDisks(WmiQueryHandler paramWmiQueryHandler) {
/* 118 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("ROOT\\Microsoft\\Windows\\Storage", "MSFT_PhysicalDisk", PhysicalDiskProperty.class);
/*     */     
/* 120 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WbemcliUtil.WmiResult<VirtualDiskProperty> queryVirtualDisks(WmiQueryHandler paramWmiQueryHandler) {
/* 132 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("ROOT\\Microsoft\\Windows\\Storage", "MSFT_VirtualDisk", VirtualDiskProperty.class);
/*     */     
/* 134 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\MSFTStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */