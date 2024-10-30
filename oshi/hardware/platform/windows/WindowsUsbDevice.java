/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.driver.windows.DeviceTree;
/*     */ import oshi.hardware.UsbDevice;
/*     */ import oshi.hardware.common.AbstractUsbDevice;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Quintet;
/*     */ import oshi.util.tuples.Triplet;
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
/*     */ public class WindowsUsbDevice
/*     */   extends AbstractUsbDevice
/*     */ {
/*  50 */   private static final Guid.GUID GUID_DEVINTERFACE_USB_HOST_CONTROLLER = new Guid.GUID("{3ABF6F2D-71C4-462A-8A92-1E6861E6AF27}");
/*     */ 
/*     */ 
/*     */   
/*     */   public WindowsUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  55 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
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
/*  74 */     List<UsbDevice> list = queryUsbDevices();
/*  75 */     if (paramBoolean) {
/*  76 */       return list;
/*     */     }
/*  78 */     ArrayList<UsbDevice> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  81 */     for (UsbDevice usbDevice : list)
/*     */     {
/*  83 */       addDevicesToList(arrayList, usbDevice.getConnectedDevices());
/*     */     }
/*  85 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static void addDevicesToList(List<UsbDevice> paramList1, List<UsbDevice> paramList2) {
/*  89 */     for (UsbDevice usbDevice : paramList2) {
/*  90 */       paramList1.add(new WindowsUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice
/*  91 */             .getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), 
/*  92 */             Collections.emptyList()));
/*  93 */       addDevicesToList(paramList1, usbDevice.getConnectedDevices());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<UsbDevice> queryUsbDevices() {
/*  99 */     Quintet quintet = DeviceTree.queryDeviceTree(GUID_DEVINTERFACE_USB_HOST_CONTROLLER);
/* 100 */     Map<Integer, Integer> map = (Map)quintet.getB();
/* 101 */     Map<Integer, String> map1 = (Map)quintet.getC();
/* 102 */     Map<Integer, String> map2 = (Map)quintet.getD();
/* 103 */     Map<Integer, String> map3 = (Map)quintet.getE();
/*     */     
/* 105 */     ArrayList<WindowsUsbDevice> arrayList = new ArrayList();
/*     */     
/* 107 */     for (Integer integer : quintet.getA()) {
/* 108 */       WindowsUsbDevice windowsUsbDevice = queryDeviceAndChildren(integer, map, map1, map2, map3, "0000", "0000", "");
/*     */       
/* 110 */       if (windowsUsbDevice != null) {
/* 111 */         arrayList.add(windowsUsbDevice);
/*     */       }
/*     */     } 
/* 114 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static WindowsUsbDevice queryDeviceAndChildren(Integer paramInteger, Map<Integer, Integer> paramMap, Map<Integer, String> paramMap1, Map<Integer, String> paramMap2, Map<Integer, String> paramMap3, String paramString1, String paramString2, String paramString3) {
/* 122 */     String str1 = paramString1;
/* 123 */     String str2 = paramString2;
/* 124 */     String str3 = paramString3;
/*     */     
/* 126 */     Triplet triplet = ParseUtil.parseDeviceIdToVendorProductSerial(paramMap2.get(paramInteger));
/* 127 */     if (triplet != null) {
/* 128 */       str1 = (String)triplet.getA();
/* 129 */       str2 = (String)triplet.getB();
/* 130 */       str3 = (String)triplet.getC();
/* 131 */       if (str3.isEmpty() && str1.equals(paramString1) && str2.equals(paramString2)) {
/* 132 */         str3 = paramString3;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 137 */     Set set = (Set)paramMap.entrySet().stream().filter(paramEntry -> ((Integer)paramEntry.getValue()).equals(paramInteger)).map(Map.Entry::getKey).collect(Collectors.toSet());
/*     */     
/* 139 */     ArrayList<WindowsUsbDevice> arrayList = new ArrayList();
/* 140 */     for (Integer integer : set) {
/* 141 */       WindowsUsbDevice windowsUsbDevice = queryDeviceAndChildren(integer, paramMap, paramMap1, paramMap2, paramMap3, str1, str2, str3);
/*     */       
/* 143 */       if (windowsUsbDevice != null) {
/* 144 */         arrayList.add(windowsUsbDevice);
/*     */       }
/*     */     } 
/* 147 */     Collections.sort(arrayList);
/*     */     
/* 149 */     if (paramMap1.containsKey(paramInteger)) {
/* 150 */       String str4 = paramMap1.get(paramInteger);
/* 151 */       if (str4.isEmpty()) {
/* 152 */         str4 = str1 + ":" + str2;
/*     */       }
/* 154 */       String str5 = paramMap2.get(paramInteger);
/* 155 */       String str6 = paramMap3.get(paramInteger);
/* 156 */       return new WindowsUsbDevice(str4, str6, str1, str2, str3, str5, (List)arrayList);
/*     */     } 
/* 158 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */