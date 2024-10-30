/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.platform.mac.CoreFoundation;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
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
/*     */ public class MacUsbDevice
/*     */   extends AbstractUsbDevice
/*     */ {
/*  51 */   private static final CoreFoundation CF = CoreFoundation.INSTANCE;
/*     */   
/*     */   private static final String IOUSB = "IOUSB";
/*     */   
/*     */   private static final String IOSERVICE = "IOService";
/*     */   
/*     */   public MacUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  58 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
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
/*  77 */     List<UsbDevice> list = getUsbDevices();
/*  78 */     if (paramBoolean) {
/*  79 */       return list;
/*     */     }
/*  81 */     ArrayList<UsbDevice> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  84 */     for (UsbDevice usbDevice : list) {
/*  85 */       addDevicesToList(arrayList, usbDevice.getConnectedDevices());
/*     */     }
/*  87 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<UsbDevice> getUsbDevices() {
/*  92 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  93 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  94 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  95 */     HashMap<Object, Object> hashMap4 = new HashMap<>();
/*  96 */     HashMap<Object, Object> hashMap5 = new HashMap<>();
/*  97 */     HashMap<Object, Object> hashMap6 = new HashMap<>();
/*     */     
/*  99 */     ArrayList<Long> arrayList = new ArrayList();
/* 100 */     IOKit.IORegistryEntry iORegistryEntry = IOKitUtil.getRoot();
/*     */ 
/*     */     
/* 103 */     IOKit.IOIterator iOIterator = iORegistryEntry.getChildIterator("IOUSB");
/* 104 */     if (iOIterator != null) {
/*     */       
/* 106 */       CoreFoundation.CFStringRef cFStringRef1 = CoreFoundation.CFStringRef.createCFString("locationID");
/* 107 */       CoreFoundation.CFStringRef cFStringRef2 = CoreFoundation.CFStringRef.createCFString("IOPropertyMatch");
/*     */ 
/*     */       
/* 110 */       IOKit.IORegistryEntry iORegistryEntry1 = iOIterator.next();
/* 111 */       while (iORegistryEntry1 != null) {
/* 112 */         long l = 0L;
/*     */         
/* 114 */         IOKit.IORegistryEntry iORegistryEntry2 = iORegistryEntry1.getParentEntry("IOService");
/* 115 */         if (iORegistryEntry2 != null) {
/*     */           
/* 117 */           l = iORegistryEntry2.getRegistryEntryID();
/*     */           
/* 119 */           hashMap1.put(Long.valueOf(l), iORegistryEntry2.getName());
/*     */ 
/*     */ 
/*     */           
/* 123 */           CoreFoundation.CFTypeRef cFTypeRef = iORegistryEntry2.createCFProperty(cFStringRef1);
/* 124 */           if (cFTypeRef != null) {
/* 125 */             getControllerIdByLocation(l, cFTypeRef, cFStringRef1, cFStringRef2, (Map)hashMap3, (Map)hashMap4);
/*     */             
/* 127 */             cFTypeRef.release();
/*     */           } 
/* 129 */           iORegistryEntry2.release();
/*     */         } 
/* 131 */         arrayList.add(Long.valueOf(l));
/*     */ 
/*     */ 
/*     */         
/* 135 */         addDeviceAndChildrenToMaps(iORegistryEntry1, l, (Map)hashMap1, (Map)hashMap2, (Map)hashMap3, (Map)hashMap4, (Map)hashMap5, (Map)hashMap6);
/*     */ 
/*     */         
/* 138 */         iORegistryEntry1.release();
/* 139 */         iORegistryEntry1 = iOIterator.next();
/*     */       } 
/* 141 */       cFStringRef1.release();
/* 142 */       cFStringRef2.release();
/* 143 */       iOIterator.release();
/*     */     } 
/* 145 */     iORegistryEntry.release();
/*     */ 
/*     */     
/* 148 */     ArrayList<MacUsbDevice> arrayList1 = new ArrayList();
/* 149 */     for (Long long_ : arrayList) {
/* 150 */       arrayList1.add(getDeviceAndChildren(long_, "0000", "0000", (Map)hashMap1, (Map)hashMap2, (Map)hashMap3, (Map)hashMap4, (Map)hashMap5, (Map)hashMap6));
/*     */     }
/*     */     
/* 153 */     return (List)arrayList1;
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
/*     */   private static void addDeviceAndChildrenToMaps(IOKit.IORegistryEntry paramIORegistryEntry, long paramLong, Map<Long, String> paramMap1, Map<Long, String> paramMap2, Map<Long, String> paramMap3, Map<Long, String> paramMap4, Map<Long, String> paramMap5, Map<Long, List<Long>> paramMap) {
/* 181 */     long l = paramIORegistryEntry.getRegistryEntryID();
/*     */     
/* 183 */     ((List<Long>)paramMap.computeIfAbsent(Long.valueOf(paramLong), paramLong -> new ArrayList())).add(Long.valueOf(l));
/*     */     
/* 185 */     paramMap1.put(Long.valueOf(l), paramIORegistryEntry.getName().trim());
/*     */     
/* 187 */     String str1 = paramIORegistryEntry.getStringProperty("USB Vendor Name");
/* 188 */     if (str1 != null) {
/* 189 */       paramMap2.put(Long.valueOf(l), str1.trim());
/*     */     }
/*     */     
/* 192 */     Long long_1 = paramIORegistryEntry.getLongProperty("idVendor");
/* 193 */     if (long_1 != null) {
/* 194 */       paramMap3.put(Long.valueOf(l), String.format("%04x", new Object[] { Long.valueOf(0xFFFFL & long_1.longValue()) }));
/*     */     }
/*     */     
/* 197 */     Long long_2 = paramIORegistryEntry.getLongProperty("idProduct");
/* 198 */     if (long_2 != null) {
/* 199 */       paramMap4.put(Long.valueOf(l), String.format("%04x", new Object[] { Long.valueOf(0xFFFFL & long_2.longValue()) }));
/*     */     }
/*     */     
/* 202 */     String str2 = paramIORegistryEntry.getStringProperty("USB Serial Number");
/* 203 */     if (str2 != null) {
/* 204 */       paramMap5.put(Long.valueOf(l), str2.trim());
/*     */     }
/*     */ 
/*     */     
/* 208 */     IOKit.IOIterator iOIterator = paramIORegistryEntry.getChildIterator("IOUSB");
/* 209 */     IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/* 210 */     while (iORegistryEntry != null) {
/* 211 */       addDeviceAndChildrenToMaps(iORegistryEntry, l, paramMap1, paramMap2, paramMap3, paramMap4, paramMap5, paramMap);
/*     */ 
/*     */       
/* 214 */       iORegistryEntry.release();
/* 215 */       iORegistryEntry = iOIterator.next();
/*     */     } 
/* 217 */     iOIterator.release();
/*     */   }
/*     */   
/*     */   private static void addDevicesToList(List<UsbDevice> paramList1, List<UsbDevice> paramList2) {
/* 221 */     for (UsbDevice usbDevice : paramList2) {
/* 222 */       paramList1.add(new MacUsbDevice(usbDevice
/* 223 */             .getName(), usbDevice.getVendor(), usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice
/* 224 */             .getSerialNumber(), usbDevice.getUniqueDeviceId(), Collections.emptyList()));
/* 225 */       addDevicesToList(paramList1, usbDevice.getConnectedDevices());
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
/*     */   private static void getControllerIdByLocation(long paramLong, CoreFoundation.CFTypeRef paramCFTypeRef, CoreFoundation.CFStringRef paramCFStringRef1, CoreFoundation.CFStringRef paramCFStringRef2, Map<Long, String> paramMap1, Map<Long, String> paramMap2) {
/* 250 */     CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef1 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
/*     */     
/* 252 */     cFMutableDictionaryRef1.setValue((PointerType)paramCFStringRef1, (PointerType)paramCFTypeRef);
/* 253 */     CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef2 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
/*     */     
/* 255 */     cFMutableDictionaryRef2.setValue((PointerType)paramCFStringRef2, (PointerType)cFMutableDictionaryRef1);
/*     */ 
/*     */     
/* 258 */     IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices((CoreFoundation.CFDictionaryRef)cFMutableDictionaryRef2);
/*     */     
/* 260 */     cFMutableDictionaryRef1.release();
/*     */ 
/*     */ 
/*     */     
/* 264 */     boolean bool = false;
/* 265 */     if (iOIterator != null) {
/* 266 */       IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/* 267 */       while (iORegistryEntry != null && !bool) {
/*     */         
/* 269 */         IOKit.IORegistryEntry iORegistryEntry1 = iORegistryEntry.getParentEntry("IOService");
/*     */ 
/*     */         
/* 272 */         if (iORegistryEntry1 != null) {
/* 273 */           byte[] arrayOfByte1 = iORegistryEntry1.getByteArrayProperty("vendor-id");
/* 274 */           if (arrayOfByte1 != null && arrayOfByte1.length >= 2) {
/* 275 */             paramMap1.put(Long.valueOf(paramLong), String.format("%02x%02x", new Object[] { Byte.valueOf(arrayOfByte1[1]), Byte.valueOf(arrayOfByte1[0]) }));
/* 276 */             bool = true;
/*     */           } 
/*     */ 
/*     */           
/* 280 */           byte[] arrayOfByte2 = iORegistryEntry1.getByteArrayProperty("device-id");
/* 281 */           if (arrayOfByte2 != null && arrayOfByte2.length >= 2) {
/* 282 */             paramMap2.put(Long.valueOf(paramLong), String.format("%02x%02x", new Object[] { Byte.valueOf(arrayOfByte2[1]), Byte.valueOf(arrayOfByte2[0]) }));
/* 283 */             bool = true;
/*     */           } 
/* 285 */           iORegistryEntry1.release();
/*     */         } 
/*     */         
/* 288 */         iORegistryEntry.release();
/* 289 */         iORegistryEntry = iOIterator.next();
/*     */       } 
/* 291 */       iOIterator.release();
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
/*     */   private static MacUsbDevice getDeviceAndChildren(Long paramLong, String paramString1, String paramString2, Map<Long, String> paramMap1, Map<Long, String> paramMap2, Map<Long, String> paramMap3, Map<Long, String> paramMap4, Map<Long, String> paramMap5, Map<Long, List<Long>> paramMap) {
/* 322 */     String str1 = paramMap3.getOrDefault(paramLong, paramString1);
/* 323 */     String str2 = paramMap4.getOrDefault(paramLong, paramString2);
/* 324 */     List list = paramMap.getOrDefault(paramLong, new ArrayList<>());
/* 325 */     ArrayList<MacUsbDevice> arrayList = new ArrayList();
/* 326 */     for (Long long_ : list) {
/* 327 */       arrayList.add(getDeviceAndChildren(long_, str1, str2, paramMap1, paramMap2, paramMap3, paramMap4, paramMap5, paramMap));
/*     */     }
/*     */     
/* 330 */     Collections.sort(arrayList);
/* 331 */     return new MacUsbDevice(paramMap1.getOrDefault(paramLong, str1 + ":" + str2), paramMap2
/* 332 */         .getOrDefault(paramLong, ""), str1, str2, paramMap5
/* 333 */         .getOrDefault(paramLong, ""), "0x" + Long.toHexString(paramLong.longValue()), (List)arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */