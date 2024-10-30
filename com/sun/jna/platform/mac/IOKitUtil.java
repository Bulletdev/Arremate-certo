/*     */ package com.sun.jna.platform.mac;
/*     */ 
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IOKitUtil
/*     */ {
/*  39 */   private static final IOKit IO = IOKit.INSTANCE;
/*  40 */   private static final SystemB SYS = SystemB.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMasterPort() {
/*  57 */     IntByReference intByReference = new IntByReference();
/*  58 */     IO.IOMasterPort(0, intByReference);
/*  59 */     return intByReference.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOKit.IORegistryEntry getRoot() {
/*  69 */     int i = getMasterPort();
/*  70 */     IOKit.IORegistryEntry iORegistryEntry = IO.IORegistryGetRootEntry(i);
/*  71 */     SYS.mach_port_deallocate(SYS.mach_task_self(), i);
/*  72 */     return iORegistryEntry;
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
/*     */   public static IOKit.IOService getMatchingService(String paramString) {
/*  85 */     CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IO.IOServiceMatching(paramString);
/*  86 */     if (cFMutableDictionaryRef != null) {
/*  87 */       return getMatchingService(cFMutableDictionaryRef);
/*     */     }
/*  89 */     return null;
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
/*     */   public static IOKit.IOService getMatchingService(CoreFoundation.CFDictionaryRef paramCFDictionaryRef) {
/* 103 */     int i = getMasterPort();
/* 104 */     IOKit.IOService iOService = IO.IOServiceGetMatchingService(i, paramCFDictionaryRef);
/* 105 */     SYS.mach_port_deallocate(SYS.mach_task_self(), i);
/* 106 */     return iOService;
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
/*     */   public static IOKit.IOIterator getMatchingServices(String paramString) {
/* 119 */     CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IO.IOServiceMatching(paramString);
/* 120 */     if (cFMutableDictionaryRef != null) {
/* 121 */       return getMatchingServices(cFMutableDictionaryRef);
/*     */     }
/* 123 */     return null;
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
/*     */   public static IOKit.IOIterator getMatchingServices(CoreFoundation.CFDictionaryRef paramCFDictionaryRef) {
/* 137 */     int i = getMasterPort();
/* 138 */     PointerByReference pointerByReference = new PointerByReference();
/* 139 */     int j = IO.IOServiceGetMatchingServices(i, paramCFDictionaryRef, pointerByReference);
/* 140 */     SYS.mach_port_deallocate(SYS.mach_task_self(), i);
/* 141 */     if (j == 0 && pointerByReference.getValue() != null) {
/* 142 */       return new IOKit.IOIterator(pointerByReference.getValue());
/*     */     }
/* 144 */     return null;
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
/*     */   public static CoreFoundation.CFMutableDictionaryRef getBSDNameMatchingDict(String paramString) {
/* 156 */     int i = getMasterPort();
/* 157 */     CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IO.IOBSDNameMatching(i, 0, paramString);
/* 158 */     SYS.mach_port_deallocate(SYS.mach_task_self(), i);
/* 159 */     return cFMutableDictionaryRef;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\IOKitUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */