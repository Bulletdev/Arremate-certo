/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import com.sun.jna.platform.linux.Udev;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.UsbDevice;
/*     */ import oshi.hardware.common.AbstractUsbDevice;
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
/*     */ @Immutable
/*     */ public class LinuxUsbDevice
/*     */   extends AbstractUsbDevice
/*     */ {
/*     */   private static final String SUBSYSTEM_USB = "usb";
/*     */   private static final String DEVTYPE_USB_DEVICE = "usb_device";
/*     */   private static final String ATTR_PRODUCT = "product";
/*     */   private static final String ATTR_MANUFACTURER = "manufacturer";
/*     */   private static final String ATTR_VENDOR_ID = "idVendor";
/*     */   private static final String ATTR_PRODUCT_ID = "idProduct";
/*     */   private static final String ATTR_SERIAL = "serial";
/*     */   
/*     */   public LinuxUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  57 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<UsbDevice> getUsbDevices(boolean paramBoolean) {
/*  76 */     List<UsbDevice> list = getUsbDevices();
/*  77 */     if (paramBoolean) {
/*  78 */       return list;
/*     */     }
/*  80 */     ArrayList<LinuxUsbDevice> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  83 */     for (UsbDevice usbDevice : list) {
/*  84 */       arrayList.add(new LinuxUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice
/*  85 */             .getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), 
/*  86 */             Collections.emptyList()));
/*  87 */       addDevicesToList((List)arrayList, usbDevice.getConnectedDevices());
/*     */     } 
/*  89 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<UsbDevice> getUsbDevices() {
/*  94 */     ArrayList<String> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  97 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  98 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  99 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/* 100 */     HashMap<Object, Object> hashMap4 = new HashMap<>();
/* 101 */     HashMap<Object, Object> hashMap5 = new HashMap<>();
/* 102 */     HashMap<Object, Object> hashMap6 = new HashMap<>();
/*     */ 
/*     */     
/* 105 */     Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
/*     */     try {
/* 107 */       Udev.UdevEnumerate udevEnumerate = udevContext.enumerateNew();
/*     */       try {
/* 109 */         udevEnumerate.addMatchSubsystem("usb");
/* 110 */         udevEnumerate.scanDevices();
/*     */ 
/*     */         
/* 113 */         for (Udev.UdevListEntry udevListEntry = udevEnumerate.getListEntry(); udevListEntry != null; udevListEntry = udevListEntry.getNext()) {
/* 114 */           String str = udevListEntry.getName();
/* 115 */           Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath(str);
/* 116 */           if (udevDevice != null) {
/*     */ 
/*     */             
/* 119 */             try { if ("usb_device".equals(udevDevice.getDevtype())) {
/* 120 */                 String str1 = udevDevice.getSysattrValue("product");
/* 121 */                 if (str1 != null) {
/* 122 */                   hashMap1.put(str, str1);
/*     */                 }
/* 124 */                 str1 = udevDevice.getSysattrValue("manufacturer");
/* 125 */                 if (str1 != null) {
/* 126 */                   hashMap2.put(str, str1);
/*     */                 }
/* 128 */                 str1 = udevDevice.getSysattrValue("idVendor");
/* 129 */                 if (str1 != null) {
/* 130 */                   hashMap3.put(str, str1);
/*     */                 }
/* 132 */                 str1 = udevDevice.getSysattrValue("idProduct");
/* 133 */                 if (str1 != null) {
/* 134 */                   hashMap4.put(str, str1);
/*     */                 }
/* 136 */                 str1 = udevDevice.getSysattrValue("serial");
/* 137 */                 if (str1 != null) {
/* 138 */                   hashMap5.put(str, str1);
/*     */                 }
/*     */                 
/* 141 */                 Udev.UdevDevice udevDevice1 = udevDevice.getParentWithSubsystemDevtype("usb", "usb_device");
/*     */                 
/* 143 */                 if (udevDevice1 == null) {
/*     */                   
/* 145 */                   arrayList.add(str);
/*     */                 } else {
/*     */                   
/* 148 */                   String str2 = udevDevice1.getSyspath();
/* 149 */                   ((List<String>)hashMap6.computeIfAbsent(str2, paramString -> new ArrayList())).add(str);
/*     */                 } 
/*     */               } 
/*     */               
/* 153 */               udevDevice.unref(); } finally { udevDevice.unref(); }
/*     */           
/*     */           }
/*     */         } 
/*     */       } finally {
/* 158 */         udevEnumerate.unref();
/*     */       } 
/*     */     } finally {
/* 161 */       udevContext.unref();
/*     */     } 
/*     */ 
/*     */     
/* 165 */     ArrayList<LinuxUsbDevice> arrayList1 = new ArrayList();
/* 166 */     for (String str : arrayList) {
/* 167 */       arrayList1.add(getDeviceAndChildren(str, "0000", "0000", (Map)hashMap1, (Map)hashMap2, (Map)hashMap3, (Map)hashMap4, (Map)hashMap5, (Map)hashMap6));
/*     */     }
/*     */     
/* 170 */     return (List)arrayList1;
/*     */   }
/*     */   
/*     */   private static void addDevicesToList(List<UsbDevice> paramList1, List<UsbDevice> paramList2) {
/* 174 */     for (UsbDevice usbDevice : paramList2) {
/* 175 */       paramList1.add(usbDevice);
/* 176 */       addDevicesToList(paramList1, usbDevice.getConnectedDevices());
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
/*     */   private static LinuxUsbDevice getDeviceAndChildren(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5, Map<String, List<String>> paramMap) {
/* 207 */     String str1 = paramMap3.getOrDefault(paramString1, paramString2);
/* 208 */     String str2 = paramMap4.getOrDefault(paramString1, paramString3);
/* 209 */     List list = paramMap.getOrDefault(paramString1, new ArrayList<>());
/* 210 */     ArrayList<LinuxUsbDevice> arrayList = new ArrayList();
/* 211 */     for (String str : list) {
/* 212 */       arrayList.add(getDeviceAndChildren(str, str1, str2, paramMap1, paramMap2, paramMap3, paramMap4, paramMap5, paramMap));
/*     */     }
/*     */     
/* 215 */     Collections.sort(arrayList);
/* 216 */     return new LinuxUsbDevice(paramMap1.getOrDefault(paramString1, str1 + ":" + str2), paramMap2
/* 217 */         .getOrDefault(paramString1, ""), str1, str2, paramMap5.getOrDefault(paramString1, ""), paramString1, (List)arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */