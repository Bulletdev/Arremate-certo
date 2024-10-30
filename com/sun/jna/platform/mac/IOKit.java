/*     */ package com.sun.jna.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Library;
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.LongByReference;
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
/*     */ public interface IOKit
/*     */   extends Library
/*     */ {
/*     */   public static final int kIORegistryIterateRecursively = 1;
/*     */   public static final int kIORegistryIterateParents = 2;
/*     */   public static final int kIOReturnNoDevice = -536870208;
/*     */   public static final double kIOPSTimeRemainingUnlimited = -2.0D;
/*     */   public static final double kIOPSTimeRemainingUnknown = -1.0D;
/*     */   
/*     */   int IOMasterPort(int paramInt, IntByReference paramIntByReference);
/*     */   
/*     */   CoreFoundation.CFMutableDictionaryRef IOServiceMatching(String paramString);
/*     */   
/*     */   CoreFoundation.CFMutableDictionaryRef IOServiceNameMatching(String paramString);
/*     */   
/*     */   CoreFoundation.CFMutableDictionaryRef IOBSDNameMatching(int paramInt1, int paramInt2, String paramString);
/*     */   
/*     */   IOService IOServiceGetMatchingService(int paramInt, CoreFoundation.CFDictionaryRef paramCFDictionaryRef);
/*     */   
/*     */   int IOServiceGetMatchingServices(int paramInt, CoreFoundation.CFDictionaryRef paramCFDictionaryRef, PointerByReference paramPointerByReference);
/*     */   
/*     */   IORegistryEntry IOIteratorNext(IOIterator paramIOIterator);
/*     */   
/*     */   CoreFoundation.CFTypeRef IORegistryEntryCreateCFProperty(IORegistryEntry paramIORegistryEntry, CoreFoundation.CFStringRef paramCFStringRef, CoreFoundation.CFAllocatorRef paramCFAllocatorRef, int paramInt);
/*     */   
/*     */   int IORegistryEntryCreateCFProperties(IORegistryEntry paramIORegistryEntry, PointerByReference paramPointerByReference, CoreFoundation.CFAllocatorRef paramCFAllocatorRef, int paramInt);
/*     */   
/*     */   CoreFoundation.CFTypeRef IORegistryEntrySearchCFProperty(IORegistryEntry paramIORegistryEntry, String paramString, CoreFoundation.CFStringRef paramCFStringRef, CoreFoundation.CFAllocatorRef paramCFAllocatorRef, int paramInt);
/*     */   
/*  51 */   public static final IOKit INSTANCE = (IOKit)Native.load("IOKit", IOKit.class);
/*     */ 
/*     */   
/*     */   int IORegistryEntryGetRegistryEntryID(IORegistryEntry paramIORegistryEntry, LongByReference paramLongByReference);
/*     */   
/*     */   int IORegistryEntryGetName(IORegistryEntry paramIORegistryEntry, Pointer paramPointer);
/*     */   
/*     */   int IORegistryEntryGetChildIterator(IORegistryEntry paramIORegistryEntry, String paramString, PointerByReference paramPointerByReference);
/*     */   
/*     */   int IORegistryEntryGetChildEntry(IORegistryEntry paramIORegistryEntry, String paramString, PointerByReference paramPointerByReference);
/*     */   
/*     */   int IORegistryEntryGetParentEntry(IORegistryEntry paramIORegistryEntry, String paramString, PointerByReference paramPointerByReference);
/*     */   
/*     */   IORegistryEntry IORegistryGetRootEntry(int paramInt);
/*     */   
/*     */   boolean IOObjectConformsTo(IOObject paramIOObject, String paramString);
/*     */   
/*     */   int IOObjectRelease(IOObject paramIOObject);
/*     */   
/*     */   int IOServiceOpen(IOService paramIOService, int paramInt1, int paramInt2, PointerByReference paramPointerByReference);
/*     */   
/*     */   int IOServiceGetBusyState(IOService paramIOService, IntByReference paramIntByReference);
/*     */   
/*     */   int IOServiceClose(IOConnect paramIOConnect);
/*     */   
/*     */   CoreFoundation.CFTypeRef IOPSCopyPowerSourcesInfo();
/*     */   
/*     */   CoreFoundation.CFArrayRef IOPSCopyPowerSourcesList(CoreFoundation.CFTypeRef paramCFTypeRef);
/*     */   
/*     */   CoreFoundation.CFDictionaryRef IOPSGetPowerSourceDescription(CoreFoundation.CFTypeRef paramCFTypeRef1, CoreFoundation.CFTypeRef paramCFTypeRef2);
/*     */   
/*     */   double IOPSGetTimeRemainingEstimate();
/*     */   
/*     */   public static class IOObject
/*     */     extends PointerType
/*     */   {
/*     */     public IOObject(Pointer param1Pointer) {
/*  88 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IOObject() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean conformsTo(String param1String) {
/* 100 */       return IOKit.INSTANCE.IOObjectConformsTo(this, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int release() {
/* 109 */       return IOKit.INSTANCE.IOObjectRelease(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IOIterator
/*     */     extends IOObject
/*     */   {
/*     */     public IOIterator() {}
/*     */ 
/*     */     
/*     */     public IOIterator(Pointer param1Pointer) {
/* 122 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IOKit.IORegistryEntry next() {
/* 133 */       return IOKit.INSTANCE.IOIteratorNext(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IORegistryEntry
/*     */     extends IOObject
/*     */   {
/*     */     public IORegistryEntry() {}
/*     */ 
/*     */     
/*     */     public IORegistryEntry(Pointer param1Pointer) {
/* 146 */       super(param1Pointer);
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
/*     */     public long getRegistryEntryID() {
/* 158 */       LongByReference longByReference = new LongByReference();
/* 159 */       int i = IOKit.INSTANCE.IORegistryEntryGetRegistryEntryID(this, longByReference);
/* 160 */       if (i != 0) {
/* 161 */         throw new IOReturnException(i);
/*     */       }
/* 163 */       return longByReference.getValue();
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
/*     */     public String getName() {
/* 175 */       Memory memory = new Memory(128L);
/* 176 */       int i = IOKit.INSTANCE.IORegistryEntryGetName(this, (Pointer)memory);
/* 177 */       if (i != 0) {
/* 178 */         throw new IOReturnException(i);
/*     */       }
/* 180 */       return memory.getString(0L);
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
/*     */ 
/*     */     
/*     */     public IOKit.IOIterator getChildIterator(String param1String) {
/* 197 */       PointerByReference pointerByReference = new PointerByReference();
/* 198 */       int i = IOKit.INSTANCE.IORegistryEntryGetChildIterator(this, param1String, pointerByReference);
/* 199 */       if (i != 0) {
/* 200 */         throw new IOReturnException(i);
/*     */       }
/* 202 */       return new IOKit.IOIterator(pointerByReference.getValue());
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
/*     */     public IORegistryEntry getChildEntry(String param1String) {
/* 216 */       PointerByReference pointerByReference = new PointerByReference();
/* 217 */       int i = IOKit.INSTANCE.IORegistryEntryGetChildEntry(this, param1String, pointerByReference);
/* 218 */       if (i == -536870208)
/* 219 */         return null; 
/* 220 */       if (i != 0) {
/* 221 */         throw new IOReturnException(i);
/*     */       }
/* 223 */       return new IORegistryEntry(pointerByReference.getValue());
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
/*     */     public IORegistryEntry getParentEntry(String param1String) {
/* 237 */       PointerByReference pointerByReference = new PointerByReference();
/* 238 */       int i = IOKit.INSTANCE.IORegistryEntryGetParentEntry(this, param1String, pointerByReference);
/* 239 */       if (i == -536870208)
/* 240 */         return null; 
/* 241 */       if (i != 0) {
/* 242 */         throw new IOReturnException(i);
/*     */       }
/* 244 */       return new IORegistryEntry(pointerByReference.getValue());
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
/*     */     public CoreFoundation.CFTypeRef createCFProperty(CoreFoundation.CFStringRef param1CFStringRef) {
/* 258 */       return IOKit.INSTANCE.IORegistryEntryCreateCFProperty(this, param1CFStringRef, CoreFoundation.INSTANCE.CFAllocatorGetDefault(), 0);
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
/*     */ 
/*     */     
/*     */     public CoreFoundation.CFMutableDictionaryRef createCFProperties() {
/* 275 */       PointerByReference pointerByReference = new PointerByReference();
/* 276 */       int i = IOKit.INSTANCE.IORegistryEntryCreateCFProperties(this, pointerByReference, CoreFoundation.INSTANCE
/* 277 */           .CFAllocatorGetDefault(), 0);
/* 278 */       if (i != 0) {
/* 279 */         throw new IOReturnException(i);
/*     */       }
/* 281 */       return new CoreFoundation.CFMutableDictionaryRef(pointerByReference.getValue());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CoreFoundation.CFTypeRef searchCFProperty(String param1String, CoreFoundation.CFStringRef param1CFStringRef, int param1Int) {
/* 304 */       return IOKit.INSTANCE.IORegistryEntrySearchCFProperty(this, param1String, param1CFStringRef, CoreFoundation.INSTANCE
/* 305 */           .CFAllocatorGetDefault(), param1Int);
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
/*     */     public String getStringProperty(String param1String) {
/* 317 */       String str = null;
/* 318 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(param1String);
/* 319 */       CoreFoundation.CFTypeRef cFTypeRef = createCFProperty(cFStringRef);
/* 320 */       cFStringRef.release();
/* 321 */       if (cFTypeRef != null) {
/* 322 */         CoreFoundation.CFStringRef cFStringRef1 = new CoreFoundation.CFStringRef(cFTypeRef.getPointer());
/* 323 */         str = cFStringRef1.stringValue();
/* 324 */         cFTypeRef.release();
/*     */       } 
/* 326 */       return str;
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
/*     */ 
/*     */     
/*     */     public Long getLongProperty(String param1String) {
/* 343 */       Long long_ = null;
/* 344 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(param1String);
/* 345 */       CoreFoundation.CFTypeRef cFTypeRef = createCFProperty(cFStringRef);
/* 346 */       cFStringRef.release();
/* 347 */       if (cFTypeRef != null) {
/* 348 */         CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(cFTypeRef.getPointer());
/* 349 */         long_ = Long.valueOf(cFNumberRef.longValue());
/* 350 */         cFTypeRef.release();
/*     */       } 
/* 352 */       return long_;
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
/*     */ 
/*     */     
/*     */     public Integer getIntegerProperty(String param1String) {
/* 369 */       Integer integer = null;
/* 370 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(param1String);
/* 371 */       CoreFoundation.CFTypeRef cFTypeRef = createCFProperty(cFStringRef);
/* 372 */       cFStringRef.release();
/* 373 */       if (cFTypeRef != null) {
/* 374 */         CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(cFTypeRef.getPointer());
/* 375 */         integer = Integer.valueOf(cFNumberRef.intValue());
/* 376 */         cFTypeRef.release();
/*     */       } 
/* 378 */       return integer;
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
/*     */ 
/*     */     
/*     */     public Double getDoubleProperty(String param1String) {
/* 395 */       Double double_ = null;
/* 396 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(param1String);
/* 397 */       CoreFoundation.CFTypeRef cFTypeRef = createCFProperty(cFStringRef);
/* 398 */       cFStringRef.release();
/* 399 */       if (cFTypeRef != null) {
/* 400 */         CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(cFTypeRef.getPointer());
/* 401 */         double_ = Double.valueOf(cFNumberRef.doubleValue());
/* 402 */         cFTypeRef.release();
/*     */       } 
/* 404 */       return double_;
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
/*     */     public Boolean getBooleanProperty(String param1String) {
/* 416 */       Boolean bool = null;
/* 417 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(param1String);
/* 418 */       CoreFoundation.CFTypeRef cFTypeRef = createCFProperty(cFStringRef);
/* 419 */       cFStringRef.release();
/* 420 */       if (cFTypeRef != null) {
/* 421 */         CoreFoundation.CFBooleanRef cFBooleanRef = new CoreFoundation.CFBooleanRef(cFTypeRef.getPointer());
/* 422 */         bool = Boolean.valueOf(cFBooleanRef.booleanValue());
/* 423 */         cFTypeRef.release();
/*     */       } 
/* 425 */       return bool;
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
/*     */     public byte[] getByteArrayProperty(String param1String) {
/* 437 */       byte[] arrayOfByte = null;
/* 438 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString(param1String);
/* 439 */       CoreFoundation.CFTypeRef cFTypeRef = createCFProperty(cFStringRef);
/* 440 */       cFStringRef.release();
/* 441 */       if (cFTypeRef != null) {
/* 442 */         CoreFoundation.CFDataRef cFDataRef = new CoreFoundation.CFDataRef(cFTypeRef.getPointer());
/* 443 */         int i = cFDataRef.getLength();
/* 444 */         Pointer pointer = cFDataRef.getBytePtr();
/* 445 */         arrayOfByte = pointer.getByteArray(0L, i);
/* 446 */         cFTypeRef.release();
/*     */       } 
/* 448 */       return arrayOfByte;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IOService
/*     */     extends IORegistryEntry
/*     */   {
/*     */     public IOService() {}
/*     */ 
/*     */     
/*     */     public IOService(Pointer param1Pointer) {
/* 461 */       super(param1Pointer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IOConnect
/*     */     extends IOService
/*     */   {
/*     */     public IOConnect() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public IOConnect(Pointer param1Pointer) {
/* 476 */       super(param1Pointer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\IOKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */