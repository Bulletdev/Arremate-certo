/*     */ package oshi.hardware.platform.unix.freebsd;
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
/*     */ public class FreeBsdUsbDevice
/*     */   extends AbstractUsbDevice
/*     */ {
/*     */   public FreeBsdUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  46 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
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
/*  65 */     List<UsbDevice> list = getUsbDevices();
/*  66 */     if (paramBoolean) {
/*  67 */       return list;
/*     */     }
/*  69 */     ArrayList<FreeBsdUsbDevice> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  72 */     for (UsbDevice usbDevice : list) {
/*  73 */       arrayList.add(new FreeBsdUsbDevice(usbDevice.getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice
/*  74 */             .getProductId(), usbDevice.getSerialNumber(), usbDevice.getUniqueDeviceId(), 
/*  75 */             Collections.emptyList()));
/*  76 */       addDevicesToList((List)arrayList, usbDevice.getConnectedDevices());
/*     */     } 
/*  78 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<UsbDevice> getUsbDevices() {
/*  83 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  84 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  85 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  86 */     HashMap<Object, Object> hashMap4 = new HashMap<>();
/*  87 */     HashMap<Object, Object> hashMap5 = new HashMap<>();
/*  88 */     HashMap<Object, Object> hashMap6 = new HashMap<>();
/*  89 */     HashMap<Object, Object> hashMap7 = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     List list = ExecutingCommand.runNative("lshal");
/*  96 */     if (list.isEmpty()) {
/*  97 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 100 */     String str = "";
/* 101 */     ArrayList<String> arrayList = new ArrayList();
/* 102 */     for (String str1 : list) {
/*     */       
/* 104 */       if (str1.startsWith("udi =")) {
/*     */         
/* 106 */         str = ParseUtil.getSingleQuoteStringValue(str1); continue;
/* 107 */       }  if (!str.isEmpty()) {
/*     */ 
/*     */         
/* 110 */         str1 = str1.trim();
/* 111 */         if (!str1.isEmpty()) {
/* 112 */           if (str1.startsWith("freebsd.driver =") && "usbus"
/* 113 */             .equals(ParseUtil.getSingleQuoteStringValue(str1))) {
/* 114 */             arrayList.add(str); continue;
/* 115 */           }  if (str1.contains(".parent =")) {
/* 116 */             String str2 = ParseUtil.getSingleQuoteStringValue(str1);
/*     */             
/* 118 */             if (str.replace(str2, "").startsWith("_if")) {
/*     */               continue;
/*     */             }
/*     */             
/* 122 */             hashMap6.put(str, str2);
/*     */             
/* 124 */             ((List<String>)hashMap7.computeIfAbsent(str2, paramString -> new ArrayList())).add(str); continue;
/* 125 */           }  if (str1.contains(".product =")) {
/* 126 */             hashMap1.put(str, ParseUtil.getSingleQuoteStringValue(str1)); continue;
/* 127 */           }  if (str1.contains(".vendor =")) {
/* 128 */             hashMap2.put(str, ParseUtil.getSingleQuoteStringValue(str1)); continue;
/* 129 */           }  if (str1.contains(".serial =")) {
/* 130 */             String str2 = ParseUtil.getSingleQuoteStringValue(str1);
/* 131 */             hashMap5.put(str, 
/* 132 */                 str2.startsWith("0x") ? ParseUtil.hexStringToString(str2.replace("0x", "")) : 
/* 133 */                 str2); continue;
/* 134 */           }  if (str1.contains(".vendor_id =")) {
/* 135 */             hashMap3.put(str, String.format("%04x", new Object[] { Integer.valueOf(ParseUtil.getFirstIntValue(str1)) })); continue;
/* 136 */           }  if (str1.contains(".product_id =")) {
/* 137 */             hashMap4.put(str, String.format("%04x", new Object[] { Integer.valueOf(ParseUtil.getFirstIntValue(str1)) }));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 144 */     ArrayList<FreeBsdUsbDevice> arrayList1 = new ArrayList();
/* 145 */     for (String str1 : arrayList) {
/*     */ 
/*     */       
/* 148 */       String str2 = (String)hashMap6.get(str1);
/* 149 */       hashMap7.put(str2, hashMap7.get(str1));
/* 150 */       arrayList1.add(getDeviceAndChildren(str2, "0000", "0000", (Map)hashMap1, (Map)hashMap2, (Map)hashMap3, (Map)hashMap4, (Map)hashMap5, (Map)hashMap7));
/*     */     } 
/*     */     
/* 153 */     return (List)arrayList1;
/*     */   }
/*     */   
/*     */   private static void addDevicesToList(List<UsbDevice> paramList1, List<UsbDevice> paramList2) {
/* 157 */     for (UsbDevice usbDevice : paramList2) {
/* 158 */       paramList1.add(usbDevice);
/* 159 */       addDevicesToList(paramList1, usbDevice.getConnectedDevices());
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
/*     */   private static FreeBsdUsbDevice getDeviceAndChildren(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5, Map<String, List<String>> paramMap) {
/* 190 */     String str1 = paramMap3.getOrDefault(paramString1, paramString2);
/* 191 */     String str2 = paramMap4.getOrDefault(paramString1, paramString3);
/* 192 */     List list = paramMap.getOrDefault(paramString1, new ArrayList<>());
/* 193 */     ArrayList<FreeBsdUsbDevice> arrayList = new ArrayList();
/* 194 */     for (String str : list) {
/* 195 */       arrayList.add(getDeviceAndChildren(str, str1, str2, paramMap1, paramMap2, paramMap3, paramMap4, paramMap5, paramMap));
/*     */     }
/*     */     
/* 198 */     Collections.sort(arrayList);
/* 199 */     return new FreeBsdUsbDevice(paramMap1.getOrDefault(paramString1, str1 + ":" + str2), paramMap2
/* 200 */         .getOrDefault(paramString1, ""), str1, str2, paramMap5.getOrDefault(paramString1, ""), paramString1, (List)arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */