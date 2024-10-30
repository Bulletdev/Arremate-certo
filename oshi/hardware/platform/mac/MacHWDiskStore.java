/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.platform.mac.CoreFoundation;
/*     */ import com.sun.jna.platform.mac.DiskArbitration;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.mac.disk.Fsstat;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
/*     */ import oshi.util.platform.mac.CFUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class MacHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*  68 */   private static final CoreFoundation CF = CoreFoundation.INSTANCE;
/*  69 */   private static final DiskArbitration DA = DiskArbitration.INSTANCE;
/*     */   
/*  71 */   private static final Logger LOG = LoggerFactory.getLogger(MacHWDiskStore.class);
/*     */   
/*  73 */   private long reads = 0L;
/*  74 */   private long readBytes = 0L;
/*  75 */   private long writes = 0L;
/*  76 */   private long writeBytes = 0L;
/*  77 */   private long currentQueueLength = 0L;
/*  78 */   private long transferTime = 0L;
/*  79 */   private long timeStamp = 0L;
/*     */   
/*     */   private List<HWPartition> partitionList;
/*     */   
/*     */   private MacHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong, DiskArbitration.DASessionRef paramDASessionRef, Map<String, String> paramMap, Map<CFKey, CoreFoundation.CFStringRef> paramMap1) {
/*  84 */     super(paramString1, paramString2, paramString3, paramLong);
/*  85 */     updateDiskStats(paramDASessionRef, paramMap, paramMap1);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/*  90 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/*  95 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/* 100 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/* 105 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/* 110 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/* 115 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 120 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 125 */     return this.partitionList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 131 */     DiskArbitration.DASessionRef dASessionRef = DA.DASessionCreate(CF.CFAllocatorGetDefault());
/* 132 */     if (dASessionRef == null) {
/* 133 */       LOG.error("Unable to open session to DiskArbitration framework.");
/* 134 */       return false;
/*     */     } 
/* 136 */     Map<CFKey, CoreFoundation.CFStringRef> map = mapCFKeys();
/*     */     
/* 138 */     boolean bool = updateDiskStats(dASessionRef, Fsstat.queryPartitionToMountMap(), map);
/*     */     
/* 140 */     dASessionRef.release();
/* 141 */     for (CoreFoundation.CFTypeRef cFTypeRef : map.values()) {
/* 142 */       cFTypeRef.release();
/*     */     }
/*     */     
/* 145 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean updateDiskStats(DiskArbitration.DASessionRef paramDASessionRef, Map<String, String> paramMap, Map<CFKey, CoreFoundation.CFStringRef> paramMap1) {
/* 152 */     String str = getName();
/* 153 */     CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IOKitUtil.getBSDNameMatchingDict(str);
/* 154 */     if (cFMutableDictionaryRef != null) {
/*     */       
/* 156 */       IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices((CoreFoundation.CFDictionaryRef)cFMutableDictionaryRef);
/* 157 */       if (iOIterator != null) {
/*     */         
/* 159 */         IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/*     */         
/* 161 */         if (iORegistryEntry != null) {
/*     */ 
/*     */ 
/*     */           
/* 165 */           if (iORegistryEntry.conformsTo("IOMedia")) {
/* 166 */             IOKit.IORegistryEntry iORegistryEntry1 = iORegistryEntry.getParentEntry("IOService");
/* 167 */             if (iORegistryEntry1 != null && (iORegistryEntry1.conformsTo("IOBlockStorageDriver") || iORegistryEntry1
/* 168 */               .conformsTo("AppleAPFSContainerScheme"))) {
/* 169 */               CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef3 = iORegistryEntry1.createCFProperties();
/*     */ 
/*     */               
/* 172 */               Pointer pointer1 = cFMutableDictionaryRef3.getValue((PointerType)paramMap1.get(CFKey.STATISTICS));
/* 173 */               CoreFoundation.CFDictionaryRef cFDictionaryRef = new CoreFoundation.CFDictionaryRef(pointer1);
/* 174 */               this.timeStamp = System.currentTimeMillis();
/*     */ 
/*     */               
/* 177 */               pointer1 = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.READ_OPS));
/* 178 */               CoreFoundation.CFNumberRef cFNumberRef1 = new CoreFoundation.CFNumberRef(pointer1);
/* 179 */               this.reads = cFNumberRef1.longValue();
/* 180 */               pointer1 = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.READ_BYTES));
/* 181 */               cFNumberRef1.setPointer(pointer1);
/* 182 */               this.readBytes = cFNumberRef1.longValue();
/*     */               
/* 184 */               pointer1 = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.WRITE_OPS));
/* 185 */               cFNumberRef1.setPointer(pointer1);
/* 186 */               this.writes = cFNumberRef1.longValue();
/* 187 */               pointer1 = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.WRITE_BYTES));
/* 188 */               cFNumberRef1.setPointer(pointer1);
/* 189 */               this.writeBytes = cFNumberRef1.longValue();
/*     */ 
/*     */ 
/*     */               
/* 193 */               Pointer pointer2 = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.READ_TIME));
/* 194 */               Pointer pointer3 = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.WRITE_TIME));
/*     */               
/* 196 */               if (pointer2 != null && pointer3 != null) {
/* 197 */                 cFNumberRef1.setPointer(pointer2);
/* 198 */                 long l = cFNumberRef1.longValue();
/* 199 */                 cFNumberRef1.setPointer(pointer3);
/* 200 */                 l += cFNumberRef1.longValue();
/* 201 */                 this.transferTime = l / 1000000L;
/*     */               } 
/*     */               
/* 204 */               cFMutableDictionaryRef3.release();
/*     */             }
/*     */             else {
/*     */               
/* 208 */               LOG.debug("Unable to find block storage driver properties for {}", str);
/*     */             } 
/*     */             
/* 211 */             ArrayList<HWPartition> arrayList = new ArrayList();
/*     */             
/* 213 */             CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef1 = iORegistryEntry.createCFProperties();
/*     */             
/* 215 */             Pointer pointer = cFMutableDictionaryRef1.getValue((PointerType)paramMap1.get(CFKey.BSD_UNIT));
/* 216 */             CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(pointer);
/*     */ 
/*     */ 
/*     */             
/* 220 */             pointer = cFMutableDictionaryRef1.getValue((PointerType)paramMap1.get(CFKey.LEAF));
/* 221 */             CoreFoundation.CFBooleanRef cFBooleanRef = new CoreFoundation.CFBooleanRef(pointer);
/*     */             
/* 223 */             CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef2 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
/*     */             
/* 225 */             cFMutableDictionaryRef2.setValue((PointerType)paramMap1.get(CFKey.BSD_UNIT), (PointerType)cFNumberRef);
/* 226 */             cFMutableDictionaryRef2.setValue((PointerType)paramMap1.get(CFKey.WHOLE), (PointerType)cFBooleanRef);
/* 227 */             cFMutableDictionaryRef = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
/*     */             
/* 229 */             cFMutableDictionaryRef.setValue((PointerType)paramMap1.get(CFKey.IO_PROPERTY_MATCH), (PointerType)cFMutableDictionaryRef2);
/*     */ 
/*     */ 
/*     */             
/* 233 */             IOKit.IOIterator iOIterator1 = IOKitUtil.getMatchingServices((CoreFoundation.CFDictionaryRef)cFMutableDictionaryRef);
/*     */             
/* 235 */             cFMutableDictionaryRef1.release();
/* 236 */             cFMutableDictionaryRef2.release();
/*     */             
/* 238 */             if (iOIterator1 != null) {
/*     */               
/* 240 */               IOKit.IORegistryEntry iORegistryEntry2 = IOKit.INSTANCE.IOIteratorNext(iOIterator1);
/* 241 */               while (iORegistryEntry2 != null) {
/*     */                 
/* 243 */                 String str1 = iORegistryEntry2.getStringProperty("BSD Name");
/* 244 */                 String str2 = str1;
/* 245 */                 String str3 = "";
/*     */ 
/*     */                 
/* 248 */                 DiskArbitration.DADiskRef dADiskRef = DA.DADiskCreateFromBSDName(CF.CFAllocatorGetDefault(), paramDASessionRef, str1);
/*     */                 
/* 250 */                 if (dADiskRef != null) {
/* 251 */                   CoreFoundation.CFDictionaryRef cFDictionaryRef = DA.DADiskCopyDescription(dADiskRef);
/* 252 */                   if (cFDictionaryRef != null) {
/*     */                     
/* 254 */                     pointer = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.DA_MEDIA_NAME));
/* 255 */                     str3 = CFUtil.cfPointerToString(pointer);
/* 256 */                     pointer = cFDictionaryRef.getValue((PointerType)paramMap1.get(CFKey.DA_VOLUME_NAME));
/* 257 */                     if (pointer == null) {
/* 258 */                       str2 = str3;
/*     */                     } else {
/* 260 */                       str2 = CFUtil.cfPointerToString(pointer);
/*     */                     } 
/* 262 */                     cFDictionaryRef.release();
/*     */                   } 
/* 264 */                   dADiskRef.release();
/*     */                 } 
/* 266 */                 String str4 = paramMap.getOrDefault(str1, "");
/* 267 */                 Long long_ = iORegistryEntry2.getLongProperty("Size");
/* 268 */                 Integer integer1 = iORegistryEntry2.getIntegerProperty("BSD Major");
/* 269 */                 Integer integer2 = iORegistryEntry2.getIntegerProperty("BSD Minor");
/* 270 */                 String str5 = iORegistryEntry2.getStringProperty("UUID");
/* 271 */                 arrayList.add(new HWPartition(str1, str2, str3, 
/* 272 */                       (str5 == null) ? "unknown" : str5, (long_ == null) ? 0L : long_.longValue(), 
/* 273 */                       (integer1 == null) ? 0 : integer1.intValue(), (integer2 == null) ? 0 : integer2.intValue(), str4));
/*     */                 
/* 275 */                 iORegistryEntry2.release();
/* 276 */                 iORegistryEntry2 = IOKit.INSTANCE.IOIteratorNext(iOIterator1);
/*     */               } 
/* 278 */               iOIterator1.release();
/*     */             } 
/* 280 */             this.partitionList = Collections.unmodifiableList((List<? extends HWPartition>)arrayList.stream()
/* 281 */                 .sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
/* 282 */             if (iORegistryEntry1 != null) {
/* 283 */               iORegistryEntry1.release();
/*     */             }
/*     */           } else {
/* 286 */             LOG.error("Unable to find IOMedia device or parent for {}", str);
/*     */           } 
/* 288 */           iORegistryEntry.release();
/*     */         } 
/* 290 */         iOIterator.release();
/* 291 */         return true;
/*     */       } 
/*     */     } 
/* 294 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<HWDiskStore> getDisks() {
/* 303 */     Map<String, String> map = Fsstat.queryPartitionToMountMap();
/* 304 */     Map<CFKey, CoreFoundation.CFStringRef> map1 = mapCFKeys();
/*     */     
/* 306 */     ArrayList<MacHWDiskStore> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 309 */     DiskArbitration.DASessionRef dASessionRef = DA.DASessionCreate(CF.CFAllocatorGetDefault());
/* 310 */     if (dASessionRef == null) {
/* 311 */       LOG.error("Unable to open session to DiskArbitration framework.");
/* 312 */       return Collections.emptyList();
/*     */     } 
/*     */ 
/*     */     
/* 316 */     ArrayList<String> arrayList1 = new ArrayList();
/* 317 */     IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices("IOMedia");
/* 318 */     if (iOIterator != null) {
/* 319 */       IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/* 320 */       while (iORegistryEntry != null) {
/* 321 */         Boolean bool = iORegistryEntry.getBooleanProperty("Whole");
/* 322 */         if (bool != null && bool.booleanValue()) {
/* 323 */           DiskArbitration.DADiskRef dADiskRef = DA.DADiskCreateFromIOMedia(CF.CFAllocatorGetDefault(), dASessionRef, (IOKit.IOObject)iORegistryEntry);
/* 324 */           arrayList1.add(DA.DADiskGetBSDName(dADiskRef));
/* 325 */           dADiskRef.release();
/*     */         } 
/* 327 */         iORegistryEntry.release();
/* 328 */         iORegistryEntry = iOIterator.next();
/*     */       } 
/* 330 */       iOIterator.release();
/*     */     } 
/*     */ 
/*     */     
/* 334 */     for (String str1 : arrayList1) {
/* 335 */       String str2 = "";
/* 336 */       String str3 = "";
/* 337 */       long l = 0L;
/*     */ 
/*     */       
/* 340 */       String str4 = "/dev/" + str1;
/*     */ 
/*     */ 
/*     */       
/* 344 */       DiskArbitration.DADiskRef dADiskRef = DA.DADiskCreateFromBSDName(CF.CFAllocatorGetDefault(), dASessionRef, str4);
/* 345 */       if (dADiskRef != null) {
/* 346 */         CoreFoundation.CFDictionaryRef cFDictionaryRef = DA.DADiskCopyDescription(dADiskRef);
/* 347 */         if (cFDictionaryRef != null) {
/*     */           
/* 349 */           Pointer pointer = cFDictionaryRef.getValue((PointerType)map1.get(CFKey.DA_DEVICE_MODEL));
/* 350 */           str2 = CFUtil.cfPointerToString(pointer);
/* 351 */           pointer = cFDictionaryRef.getValue((PointerType)map1.get(CFKey.DA_MEDIA_SIZE));
/* 352 */           CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(pointer);
/* 353 */           l = cFNumberRef.longValue();
/* 354 */           cFDictionaryRef.release();
/*     */ 
/*     */           
/* 357 */           if (!"Disk Image".equals(str2)) {
/* 358 */             CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(str2);
/* 359 */             CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef1 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
/*     */             
/* 361 */             cFMutableDictionaryRef1.setValue((PointerType)map1.get(CFKey.MODEL), (PointerType)cFStringRef);
/* 362 */             CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef2 = CF.CFDictionaryCreateMutable(CF.CFAllocatorGetDefault(), new CoreFoundation.CFIndex(0L), null, null);
/*     */             
/* 364 */             cFMutableDictionaryRef2.setValue((PointerType)map1.get(CFKey.IO_PROPERTY_MATCH), (PointerType)cFMutableDictionaryRef1);
/*     */ 
/*     */             
/* 367 */             IOKit.IOIterator iOIterator1 = IOKitUtil.getMatchingServices((CoreFoundation.CFDictionaryRef)cFMutableDictionaryRef2);
/*     */             
/* 369 */             cFStringRef.release();
/* 370 */             cFMutableDictionaryRef1.release();
/*     */             
/* 372 */             if (iOIterator1 != null) {
/* 373 */               IOKit.IORegistryEntry iORegistryEntry = iOIterator1.next();
/* 374 */               while (iORegistryEntry != null) {
/*     */                 
/* 376 */                 str3 = iORegistryEntry.getStringProperty("Serial Number");
/* 377 */                 iORegistryEntry.release();
/* 378 */                 if (str3 != null) {
/*     */                   break;
/*     */                 }
/*     */                 
/* 382 */                 iORegistryEntry.release();
/* 383 */                 iORegistryEntry = iOIterator1.next();
/*     */               } 
/* 385 */               iOIterator1.release();
/*     */             } 
/* 387 */             if (str3 == null) {
/* 388 */               str3 = "";
/*     */             }
/*     */           } 
/*     */         } 
/* 392 */         dADiskRef.release();
/*     */ 
/*     */         
/* 395 */         if (l <= 0L) {
/*     */           continue;
/*     */         }
/* 398 */         MacHWDiskStore macHWDiskStore = new MacHWDiskStore(str1, str2.trim(), str3.trim(), l, dASessionRef, map, map1);
/*     */         
/* 400 */         arrayList.add(macHWDiskStore);
/*     */       } 
/*     */     } 
/*     */     
/* 404 */     dASessionRef.release();
/* 405 */     for (CoreFoundation.CFTypeRef cFTypeRef : map1.values()) {
/* 406 */       cFTypeRef.release();
/*     */     }
/* 408 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<CFKey, CoreFoundation.CFStringRef> mapCFKeys() {
/* 419 */     EnumMap<CFKey, Object> enumMap = new EnumMap<>(CFKey.class);
/* 420 */     for (CFKey cFKey : CFKey.values()) {
/* 421 */       enumMap.put(cFKey, CoreFoundation.CFStringRef.createCFString(cFKey.getKey()));
/*     */     }
/* 423 */     return (Map)enumMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private enum CFKey
/*     */   {
/* 430 */     IO_PROPERTY_MATCH("IOPropertyMatch"),
/*     */     
/* 432 */     STATISTICS("Statistics"),
/* 433 */     READ_OPS("Operations (Read)"), READ_BYTES("Bytes (Read)"), READ_TIME("Total Time (Read)"),
/* 434 */     WRITE_OPS("Operations (Write)"), WRITE_BYTES("Bytes (Write)"), WRITE_TIME("Total Time (Write)"),
/*     */     
/* 436 */     BSD_UNIT("BSD Unit"), LEAF("Leaf"), WHOLE("Whole"),
/*     */     
/* 438 */     DA_MEDIA_NAME("DAMediaName"), DA_VOLUME_NAME("DAVolumeName"), DA_MEDIA_SIZE("DAMediaSize"),
/* 439 */     DA_DEVICE_MODEL("DADeviceModel"), MODEL("Model");
/*     */     
/*     */     private final String key;
/*     */     
/*     */     CFKey(String param1String1) {
/* 444 */       this.key = param1String1;
/*     */     }
/*     */     
/*     */     public String getKey() {
/* 448 */       return this.key;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */