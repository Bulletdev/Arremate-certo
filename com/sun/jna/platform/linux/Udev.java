/*     */ package com.sun.jna.platform.linux;
/*     */ 
/*     */ import com.sun.jna.Library;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.PointerType;
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
/*     */ public interface Udev
/*     */   extends Library
/*     */ {
/*     */   UdevContext udev_new();
/*     */   
/*     */   UdevContext udev_ref(UdevContext paramUdevContext);
/*     */   
/*     */   UdevContext udev_unref(UdevContext paramUdevContext);
/*     */   
/*     */   UdevDevice udev_device_new_from_syspath(UdevContext paramUdevContext, String paramString);
/*     */   
/*     */   UdevEnumerate udev_enumerate_new(UdevContext paramUdevContext);
/*     */   
/*     */   UdevEnumerate udev_enumerate_ref(UdevEnumerate paramUdevEnumerate);
/*     */   
/*     */   UdevEnumerate udev_enumerate_unref(UdevEnumerate paramUdevEnumerate);
/*     */   
/*     */   int udev_enumerate_add_match_subsystem(UdevEnumerate paramUdevEnumerate, String paramString);
/*     */   
/*     */   int udev_enumerate_scan_devices(UdevEnumerate paramUdevEnumerate);
/*     */   
/*  37 */   public static final Udev INSTANCE = (Udev)Native.load("udev", Udev.class);
/*     */   UdevListEntry udev_enumerate_get_list_entry(UdevEnumerate paramUdevEnumerate);
/*     */   UdevListEntry udev_list_entry_get_next(UdevListEntry paramUdevListEntry);
/*     */   String udev_list_entry_get_name(UdevListEntry paramUdevListEntry);
/*     */   UdevDevice udev_device_ref(UdevDevice paramUdevDevice);
/*     */   UdevDevice udev_device_unref(UdevDevice paramUdevDevice);
/*     */   UdevDevice udev_device_get_parent(UdevDevice paramUdevDevice);
/*     */   UdevDevice udev_device_get_parent_with_subsystem_devtype(UdevDevice paramUdevDevice, String paramString1, String paramString2);
/*     */   String udev_device_get_syspath(UdevDevice paramUdevDevice);
/*     */   String udev_device_get_sysname(UdevDevice paramUdevDevice);
/*     */   String udev_device_get_devnode(UdevDevice paramUdevDevice);
/*     */   String udev_device_get_devtype(UdevDevice paramUdevDevice);
/*     */   String udev_device_get_subsystem(UdevDevice paramUdevDevice);
/*     */   String udev_device_get_sysattr_value(UdevDevice paramUdevDevice, String paramString);
/*     */   
/*     */   String udev_device_get_property_value(UdevDevice paramUdevDevice, String paramString);
/*     */   
/*     */   public static class UdevContext extends PointerType { public UdevContext ref() {
/*  55 */       return Udev.INSTANCE.udev_ref(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unref() {
/*  63 */       Udev.INSTANCE.udev_unref(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Udev.UdevEnumerate enumerateNew() {
/*  74 */       return Udev.INSTANCE.udev_enumerate_new(this);
/*     */     }
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
/*     */     public Udev.UdevDevice deviceNewFromSyspath(String param1String) {
/*  88 */       return Udev.INSTANCE.udev_device_new_from_syspath(this, param1String);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class UdevEnumerate
/*     */     extends PointerType
/*     */   {
/*     */     public UdevEnumerate ref() {
/* 103 */       return Udev.INSTANCE.udev_enumerate_ref(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unref() {
/* 111 */       Udev.INSTANCE.udev_enumerate_unref(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int addMatchSubsystem(String param1String) {
/* 122 */       return Udev.INSTANCE.udev_enumerate_add_match_subsystem(this, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int scanDevices() {
/* 132 */       return Udev.INSTANCE.udev_enumerate_scan_devices(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Udev.UdevListEntry getListEntry() {
/* 142 */       return Udev.INSTANCE.udev_enumerate_get_list_entry(this);
/*     */     }
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
/*     */   public static class UdevListEntry
/*     */     extends PointerType
/*     */   {
/*     */     public UdevListEntry getNext() {
/* 158 */       return Udev.INSTANCE.udev_list_entry_get_next(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 167 */       return Udev.INSTANCE.udev_list_entry_get_name(this);
/*     */     }
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
/*     */   public static class UdevDevice
/*     */     extends PointerType
/*     */   {
/*     */     public UdevDevice ref() {
/* 184 */       return Udev.INSTANCE.udev_device_ref(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unref() {
/* 192 */       Udev.INSTANCE.udev_device_unref(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public UdevDevice getParent() {
/* 203 */       return Udev.INSTANCE.udev_device_get_parent(this);
/*     */     }
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
/*     */     public UdevDevice getParentWithSubsystemDevtype(String param1String1, String param1String2) {
/* 218 */       return Udev.INSTANCE.udev_device_get_parent_with_subsystem_devtype(this, param1String1, param1String2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSyspath() {
/* 227 */       return Udev.INSTANCE.udev_device_get_syspath(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSysname() {
/* 236 */       return Udev.INSTANCE.udev_device_get_syspath(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDevnode() {
/* 245 */       return Udev.INSTANCE.udev_device_get_devnode(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDevtype() {
/* 254 */       return Udev.INSTANCE.udev_device_get_devtype(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSubsystem() {
/* 263 */       return Udev.INSTANCE.udev_device_get_subsystem(this);
/*     */     }
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
/*     */     public String getSysattrValue(String param1String) {
/* 277 */       return Udev.INSTANCE.udev_device_get_sysattr_value(this, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPropertyValue(String param1String) {
/* 288 */       return Udev.INSTANCE.udev_device_get_property_value(this, param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\linux\Udev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */