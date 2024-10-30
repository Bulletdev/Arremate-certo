/*     */ package oshi.hardware.platform.unix.solaris;
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
/*     */ import oshi.util.ParseUtil;
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
/*     */ public class SolarisUsbDevice
/*     */   extends AbstractUsbDevice
/*     */ {
/*     */   private static final String PCI_TYPE_USB = "000c";
/*     */   
/*     */   public SolarisUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  48 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
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
/*  67 */     List<UsbDevice> list = getUsbDevices();
/*  68 */     if (paramBoolean) {
/*  69 */       return list;
/*     */     }
/*  71 */     ArrayList<SolarisUsbDevice> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  74 */     for (UsbDevice usbDevice : list) {
/*  75 */       arrayList.add(new SolarisUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice
/*  76 */             .getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), 
/*  77 */             Collections.emptyList()));
/*  78 */       addDevicesToList((List)arrayList, usbDevice.getConnectedDevices());
/*     */     } 
/*  80 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static List<UsbDevice> getUsbDevices() {
/*  84 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  85 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  86 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  87 */     HashMap<Object, Object> hashMap4 = new HashMap<>();
/*  88 */     HashMap<Object, Object> hashMap5 = new HashMap<>();
/*     */ 
/*     */     
/*  91 */     List list = ExecutingCommand.runNative("prtconf -pv");
/*  92 */     if (list.isEmpty()) {
/*  93 */       return Collections.emptyList();
/*     */     }
/*     */     
/*  96 */     HashMap<Object, Object> hashMap6 = new HashMap<>();
/*  97 */     String str = "";
/*  98 */     int i = 0;
/*  99 */     ArrayList<String> arrayList = new ArrayList();
/* 100 */     for (String str1 : list) {
/*     */       
/* 102 */       if (str1.contains("Node 0x")) {
/*     */         
/* 104 */         str = str1.replaceFirst("^\\s*", "");
/*     */         
/* 106 */         int j = str1.length() - str.length();
/*     */         
/* 108 */         if (!i) {
/* 109 */           i = j;
/*     */         }
/*     */         
/* 112 */         hashMap6.put(Integer.valueOf(j), str);
/*     */         
/* 114 */         if (j > i) {
/*     */           
/* 116 */           ((List<String>)hashMap4.computeIfAbsent(hashMap6.get(Integer.valueOf(j - i)), paramString -> new ArrayList())).add(str);
/*     */           continue;
/*     */         } 
/* 119 */         arrayList.add(str); continue;
/*     */       } 
/* 121 */       if (!str.isEmpty()) {
/*     */ 
/*     */         
/* 124 */         str1 = str1.trim();
/* 125 */         if (str1.startsWith("model:")) {
/* 126 */           hashMap1.put(str, ParseUtil.getSingleQuoteStringValue(str1)); continue;
/* 127 */         }  if (str1.startsWith("name:")) {
/*     */ 
/*     */           
/* 130 */           hashMap1.putIfAbsent(str, ParseUtil.getSingleQuoteStringValue(str1)); continue;
/* 131 */         }  if (str1.startsWith("vendor-id:")) {
/*     */           
/* 133 */           hashMap2.put(str, str1.substring(str1.length() - 4)); continue;
/* 134 */         }  if (str1.startsWith("device-id:")) {
/*     */           
/* 136 */           hashMap3.put(str, str1.substring(str1.length() - 4)); continue;
/* 137 */         }  if (str1.startsWith("class-code:")) {
/*     */           
/* 139 */           hashMap5.putIfAbsent(str, str1.substring(str1.length() - 8, str1.length() - 4)); continue;
/* 140 */         }  if (str1.startsWith("device_type:"))
/*     */         {
/* 142 */           hashMap5.putIfAbsent(str, ParseUtil.getSingleQuoteStringValue(str1));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 148 */     ArrayList<SolarisUsbDevice> arrayList1 = new ArrayList();
/* 149 */     for (String str1 : arrayList) {
/*     */       
/* 151 */       if ("000c".equals(hashMap5.getOrDefault(str1, "")) || "usb"
/* 152 */         .equals(hashMap5.getOrDefault(str1, ""))) {
/* 153 */         arrayList1.add(
/* 154 */             getDeviceAndChildren(str1, "0000", "0000", (Map)hashMap1, (Map)hashMap2, (Map)hashMap3, (Map)hashMap4));
/*     */       }
/*     */     } 
/* 157 */     return (List)arrayList1;
/*     */   }
/*     */   
/*     */   private static void addDevicesToList(List<UsbDevice> paramList1, List<UsbDevice> paramList2) {
/* 161 */     for (UsbDevice usbDevice : paramList2) {
/* 162 */       paramList1.add(usbDevice);
/* 163 */       addDevicesToList(paramList1, usbDevice.getConnectedDevices());
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
/*     */   private static SolarisUsbDevice getDeviceAndChildren(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, Map<String, List<String>> paramMap) {
/* 190 */     String str1 = paramMap2.getOrDefault(paramString1, paramString2);
/* 191 */     String str2 = paramMap3.getOrDefault(paramString1, paramString3);
/* 192 */     List list = paramMap.getOrDefault(paramString1, new ArrayList<>());
/* 193 */     ArrayList<SolarisUsbDevice> arrayList = new ArrayList();
/* 194 */     for (String str : list) {
/* 195 */       arrayList.add(getDeviceAndChildren(str, str1, str2, paramMap1, paramMap2, paramMap3, paramMap));
/*     */     }
/* 197 */     Collections.sort(arrayList);
/* 198 */     return new SolarisUsbDevice(paramMap1.getOrDefault(paramString1, str1 + ":" + str2), "", str1, str2, "", paramString1, (List)arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */