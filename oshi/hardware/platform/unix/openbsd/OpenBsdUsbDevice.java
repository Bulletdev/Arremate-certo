/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.UsbDevice;
/*     */ import oshi.hardware.common.AbstractUsbDevice;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ public class OpenBsdUsbDevice
/*     */   extends AbstractUsbDevice
/*     */ {
/*     */   public OpenBsdUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  45 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
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
/*  64 */     List<UsbDevice> list = getUsbDevices();
/*  65 */     if (paramBoolean) {
/*  66 */       return list;
/*     */     }
/*  68 */     ArrayList<OpenBsdUsbDevice> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  71 */     for (UsbDevice usbDevice : list) {
/*  72 */       arrayList.add(new OpenBsdUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice
/*  73 */             .getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), 
/*  74 */             Collections.emptyList()));
/*  75 */       addDevicesToList((List)arrayList, usbDevice.getConnectedDevices());
/*     */     } 
/*  77 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<UsbDevice> getUsbDevices() {
/*  83 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  84 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  85 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  86 */     HashMap<Object, Object> hashMap4 = new HashMap<>();
/*  87 */     HashMap<Object, Object> hashMap5 = new HashMap<>();
/*  88 */     HashMap<Object, Object> hashMap6 = new HashMap<>();
/*     */     
/*  90 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  92 */     String str1 = "";
/*     */ 
/*     */     
/*  95 */     String str2 = "";
/*     */ 
/*     */     
/*  98 */     for (String str : ExecutingCommand.runNative("usbdevs -v")) {
/*  99 */       if (str.startsWith("Controller ")) {
/* 100 */         str2 = str.substring(11); continue;
/* 101 */       }  if (str.startsWith("addr ")) {
/*     */         
/* 103 */         if (str.indexOf(':') == 7 && str.indexOf(',') >= 18) {
/* 104 */           str1 = str2 + str.substring(0, 7);
/* 105 */           String[] arrayOfString = str.substring(8).trim().split(",");
/* 106 */           if (arrayOfString.length > 1) {
/*     */             
/* 108 */             String str3 = arrayOfString[0].trim();
/* 109 */             int i = str3.indexOf(':');
/* 110 */             int j = str3.indexOf(' ');
/* 111 */             if (i >= 0 && j >= 0) {
/* 112 */               hashMap3.put(str1, str3.substring(0, i));
/* 113 */               hashMap4.put(str1, str3.substring(i + 1, j));
/* 114 */               hashMap2.put(str1, str3.substring(j + 1));
/*     */             } 
/*     */             
/* 117 */             hashMap1.put(str1, arrayOfString[1].trim());
/*     */             
/* 119 */             ((List<String>)hashMap6.computeIfAbsent(str2, paramString -> new ArrayList())).add(str1);
/*     */             
/* 121 */             if (!str2.contains("addr")) {
/* 122 */               str2 = str1;
/* 123 */               arrayList.add(str2);
/*     */             } 
/*     */           } 
/*     */         }  continue;
/* 127 */       }  if (!str1.isEmpty()) {
/*     */ 
/*     */ 
/*     */         
/* 131 */         int i = str.indexOf("iSerial ");
/* 132 */         if (i >= 0) {
/* 133 */           hashMap5.put(str1, str.substring(i + 8).trim());
/*     */         }
/* 135 */         str1 = "";
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 140 */     ArrayList<OpenBsdUsbDevice> arrayList1 = new ArrayList();
/* 141 */     for (String str : arrayList) {
/* 142 */       arrayList1.add(getDeviceAndChildren(str, "0000", "0000", (Map)hashMap1, (Map)hashMap2, (Map)hashMap3, (Map)hashMap4, (Map)hashMap5, (Map)hashMap6));
/*     */     }
/*     */     
/* 145 */     return (List)arrayList1;
/*     */   }
/*     */   
/*     */   private static void addDevicesToList(List<UsbDevice> paramList1, List<UsbDevice> paramList2) {
/* 149 */     for (UsbDevice usbDevice : paramList2) {
/* 150 */       paramList1.add(usbDevice);
/* 151 */       addDevicesToList(paramList1, usbDevice.getConnectedDevices());
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
/*     */   private static OpenBsdUsbDevice getDeviceAndChildren(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5, Map<String, List<String>> paramMap) {
/* 182 */     String str1 = paramMap3.getOrDefault(paramString1, paramString2);
/* 183 */     String str2 = paramMap4.getOrDefault(paramString1, paramString3);
/* 184 */     List list = paramMap.getOrDefault(paramString1, new ArrayList<>());
/* 185 */     ArrayList<OpenBsdUsbDevice> arrayList = new ArrayList();
/* 186 */     for (String str : list) {
/* 187 */       arrayList.add(getDeviceAndChildren(str, str1, str2, paramMap1, paramMap2, paramMap3, paramMap4, paramMap5, paramMap));
/*     */     }
/*     */     
/* 190 */     Collections.sort(arrayList);
/* 191 */     return new OpenBsdUsbDevice(paramMap1.getOrDefault(paramString1, str1 + ":" + str2), paramMap2
/* 192 */         .getOrDefault(paramString1, ""), str1, str2, paramMap5.getOrDefault(paramString1, ""), paramString1, (List)arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */