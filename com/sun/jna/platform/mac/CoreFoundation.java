/*     */ package com.sun.jna.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Library;
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.NativeLong;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.ptr.ByReference;
/*     */ import com.sun.jna.ptr.ByteByReference;
/*     */ import com.sun.jna.ptr.DoubleByReference;
/*     */ import com.sun.jna.ptr.FloatByReference;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.LongByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import com.sun.jna.ptr.ShortByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface CoreFoundation
/*     */   extends Library
/*     */ {
/*  61 */   public static final CoreFoundation INSTANCE = (CoreFoundation)Native.load("CoreFoundation", CoreFoundation.class);
/*     */   
/*     */   public static final int kCFNotFound = -1;
/*     */   
/*     */   public static final int kCFStringEncodingASCII = 1536;
/*     */   
/*     */   public static final int kCFStringEncodingUTF8 = 134217984;
/*  68 */   public static final CFTypeID ARRAY_TYPE_ID = INSTANCE.CFArrayGetTypeID();
/*  69 */   public static final CFTypeID BOOLEAN_TYPE_ID = INSTANCE.CFBooleanGetTypeID();
/*  70 */   public static final CFTypeID DATA_TYPE_ID = INSTANCE.CFDataGetTypeID();
/*  71 */   public static final CFTypeID DATE_TYPE_ID = INSTANCE.CFDateGetTypeID();
/*  72 */   public static final CFTypeID DICTIONARY_TYPE_ID = INSTANCE.CFDictionaryGetTypeID();
/*  73 */   public static final CFTypeID NUMBER_TYPE_ID = INSTANCE.CFNumberGetTypeID(); CFStringRef CFStringCreateWithCharacters(CFAllocatorRef paramCFAllocatorRef, char[] paramArrayOfchar, CFIndex paramCFIndex); CFNumberRef CFNumberCreate(CFAllocatorRef paramCFAllocatorRef, CFIndex paramCFIndex, ByReference paramByReference); CFArrayRef CFArrayCreate(CFAllocatorRef paramCFAllocatorRef, Pointer paramPointer1, CFIndex paramCFIndex, Pointer paramPointer2); CFDataRef CFDataCreate(CFAllocatorRef paramCFAllocatorRef, Pointer paramPointer, CFIndex paramCFIndex); CFMutableDictionaryRef CFDictionaryCreateMutable(CFAllocatorRef paramCFAllocatorRef, CFIndex paramCFIndex, Pointer paramPointer1, Pointer paramPointer2); CFStringRef CFCopyDescription(CFTypeRef paramCFTypeRef); void CFRelease(CFTypeRef paramCFTypeRef); CFTypeRef CFRetain(CFTypeRef paramCFTypeRef); CFIndex CFGetRetainCount(CFTypeRef paramCFTypeRef); Pointer CFDictionaryGetValue(CFDictionaryRef paramCFDictionaryRef, PointerType paramPointerType); byte CFDictionaryGetValueIfPresent(CFDictionaryRef paramCFDictionaryRef, PointerType paramPointerType, PointerByReference paramPointerByReference); void CFDictionarySetValue(CFMutableDictionaryRef paramCFMutableDictionaryRef, PointerType paramPointerType1, PointerType paramPointerType2); byte CFStringGetCString(CFStringRef paramCFStringRef, Pointer paramPointer, CFIndex paramCFIndex, int paramInt); byte CFBooleanGetValue(CFBooleanRef paramCFBooleanRef); CFIndex CFArrayGetCount(CFArrayRef paramCFArrayRef); Pointer CFArrayGetValueAtIndex(CFArrayRef paramCFArrayRef, CFIndex paramCFIndex);
/*  74 */   public static final CFTypeID STRING_TYPE_ID = INSTANCE.CFStringGetTypeID(); CFIndex CFNumberGetType(CFNumberRef paramCFNumberRef); byte CFNumberGetValue(CFNumberRef paramCFNumberRef, CFIndex paramCFIndex, ByReference paramByReference); CFIndex CFStringGetLength(CFStringRef paramCFStringRef);
/*     */   CFIndex CFStringGetMaximumSizeForEncoding(CFIndex paramCFIndex, int paramInt);
/*     */   CFAllocatorRef CFAllocatorGetDefault();
/*     */   CFIndex CFDataGetLength(CFDataRef paramCFDataRef);
/*     */   Pointer CFDataGetBytePtr(CFDataRef paramCFDataRef);
/*     */   CFTypeID CFGetTypeID(CFTypeRef paramCFTypeRef);
/*     */   CFTypeID CFArrayGetTypeID();
/*     */   CFTypeID CFBooleanGetTypeID();
/*     */   CFTypeID CFDateGetTypeID();
/*     */   CFTypeID CFDataGetTypeID();
/*     */   CFTypeID CFDictionaryGetTypeID();
/*     */   CFTypeID CFNumberGetTypeID();
/*     */   CFTypeID CFStringGetTypeID();
/*     */   public static class CFTypeRef extends PointerType { public CFTypeRef(Pointer param1Pointer) {
/*  88 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CFTypeRef() {}
/*     */ 
/*     */     
/*     */     public CoreFoundation.CFTypeID getTypeID() {
/*  97 */       if (getPointer() == null) {
/*  98 */         return new CoreFoundation.CFTypeID(0L);
/*     */       }
/* 100 */       return CoreFoundation.INSTANCE.CFGetTypeID(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isTypeID(CoreFoundation.CFTypeID param1CFTypeID) {
/* 111 */       return getTypeID().equals(param1CFTypeID);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void retain() {
/* 118 */       CoreFoundation.INSTANCE.CFRetain(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void release() {
/* 125 */       CoreFoundation.INSTANCE.CFRelease(this);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFAllocatorRef
/*     */     extends CFTypeRef {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFNumberRef
/*     */     extends CFTypeRef
/*     */   {
/*     */     public CFNumberRef() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public CFNumberRef(Pointer param1Pointer) {
/* 146 */       super(param1Pointer);
/* 147 */       if (!isTypeID(CoreFoundation.NUMBER_TYPE_ID)) {
/* 148 */         throw new ClassCastException("Unable to cast to CFNumber. Type ID: " + getTypeID());
/*     */       }
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
/*     */     public long longValue() {
/* 164 */       LongByReference longByReference = new LongByReference();
/* 165 */       CoreFoundation.INSTANCE.CFNumberGetValue(this, CoreFoundation.CFNumberType.kCFNumberLongLongType.typeIndex(), (ByReference)longByReference);
/* 166 */       return longByReference.getValue();
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
/*     */     public int intValue() {
/* 181 */       IntByReference intByReference = new IntByReference();
/* 182 */       CoreFoundation.INSTANCE.CFNumberGetValue(this, CoreFoundation.CFNumberType.kCFNumberIntType.typeIndex(), (ByReference)intByReference);
/* 183 */       return intByReference.getValue();
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
/*     */     public short shortValue() {
/* 198 */       ShortByReference shortByReference = new ShortByReference();
/* 199 */       CoreFoundation.INSTANCE.CFNumberGetValue(this, CoreFoundation.CFNumberType.kCFNumberShortType.typeIndex(), (ByReference)shortByReference);
/* 200 */       return shortByReference.getValue();
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
/*     */     public byte byteValue() {
/* 215 */       ByteByReference byteByReference = new ByteByReference();
/* 216 */       CoreFoundation.INSTANCE.CFNumberGetValue(this, CoreFoundation.CFNumberType.kCFNumberCharType.typeIndex(), (ByReference)byteByReference);
/* 217 */       return byteByReference.getValue();
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
/*     */     public double doubleValue() {
/* 232 */       DoubleByReference doubleByReference = new DoubleByReference();
/* 233 */       CoreFoundation.INSTANCE.CFNumberGetValue(this, CoreFoundation.CFNumberType.kCFNumberDoubleType.typeIndex(), (ByReference)doubleByReference);
/* 234 */       return doubleByReference.getValue();
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
/*     */     public float floatValue() {
/* 249 */       FloatByReference floatByReference = new FloatByReference();
/* 250 */       CoreFoundation.INSTANCE.CFNumberGetValue(this, CoreFoundation.CFNumberType.kCFNumberFloatType.typeIndex(), (ByReference)floatByReference);
/* 251 */       return floatByReference.getValue();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum CFNumberType
/*     */   {
/* 261 */     unusedZero, kCFNumberSInt8Type, kCFNumberSInt16Type, kCFNumberSInt32Type, kCFNumberSInt64Type,
/* 262 */     kCFNumberFloat32Type, kCFNumberFloat64Type, kCFNumberCharType, kCFNumberShortType, kCFNumberIntType,
/* 263 */     kCFNumberLongType, kCFNumberLongLongType, kCFNumberFloatType, kCFNumberDoubleType, kCFNumberCFIndexType,
/* 264 */     kCFNumberNSIntegerType, kCFNumberCGFloatType, kCFNumberMaxType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CoreFoundation.CFIndex typeIndex() {
/* 272 */       return new CoreFoundation.CFIndex(ordinal());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFBooleanRef
/*     */     extends CFTypeRef
/*     */   {
/*     */     public CFBooleanRef() {}
/*     */ 
/*     */     
/*     */     public CFBooleanRef(Pointer param1Pointer) {
/* 285 */       super(param1Pointer);
/* 286 */       if (!isTypeID(CoreFoundation.BOOLEAN_TYPE_ID)) {
/* 287 */         throw new ClassCastException("Unable to cast to CFBoolean. Type ID: " + getTypeID());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean booleanValue() {
/* 297 */       return (0 != CoreFoundation.INSTANCE.CFBooleanGetValue(this));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFArrayRef
/*     */     extends CFTypeRef
/*     */   {
/*     */     public CFArrayRef() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CFArrayRef(Pointer param1Pointer) {
/* 314 */       super(param1Pointer);
/* 315 */       if (!isTypeID(CoreFoundation.ARRAY_TYPE_ID)) {
/* 316 */         throw new ClassCastException("Unable to cast to CFArray. Type ID: " + getTypeID());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getCount() {
/* 326 */       return CoreFoundation.INSTANCE.CFArrayGetCount(this).intValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Pointer getValueAtIndex(int param1Int) {
/* 337 */       return CoreFoundation.INSTANCE.CFArrayGetValueAtIndex(this, new CoreFoundation.CFIndex(param1Int));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFDataRef
/*     */     extends CFTypeRef
/*     */   {
/*     */     public CFDataRef() {}
/*     */ 
/*     */     
/*     */     public CFDataRef(Pointer param1Pointer) {
/* 350 */       super(param1Pointer);
/* 351 */       if (!isTypeID(CoreFoundation.DATA_TYPE_ID)) {
/* 352 */         throw new ClassCastException("Unable to cast to CFData. Type ID: " + getTypeID());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getLength() {
/* 363 */       return CoreFoundation.INSTANCE.CFDataGetLength(this).intValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Pointer getBytePtr() {
/* 372 */       return CoreFoundation.INSTANCE.CFDataGetBytePtr(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFDictionaryRef
/*     */     extends CFTypeRef
/*     */   {
/*     */     public CFDictionaryRef() {}
/*     */ 
/*     */     
/*     */     public CFDictionaryRef(Pointer param1Pointer) {
/* 385 */       super(param1Pointer);
/* 386 */       if (!isTypeID(CoreFoundation.DICTIONARY_TYPE_ID)) {
/* 387 */         throw new ClassCastException("Unable to cast to CFDictionary. Type ID: " + getTypeID());
/*     */       }
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
/*     */     public Pointer getValue(PointerType param1PointerType) {
/* 401 */       return CoreFoundation.INSTANCE.CFDictionaryGetValue(this, param1PointerType);
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
/*     */     public boolean getValueIfPresent(PointerType param1PointerType, PointerByReference param1PointerByReference) {
/* 417 */       return (CoreFoundation.INSTANCE.CFDictionaryGetValueIfPresent(this, param1PointerType, param1PointerByReference) > 0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFMutableDictionaryRef
/*     */     extends CFDictionaryRef
/*     */   {
/*     */     public CFMutableDictionaryRef() {}
/*     */ 
/*     */     
/*     */     public CFMutableDictionaryRef(Pointer param1Pointer) {
/* 430 */       super(param1Pointer);
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
/*     */     public void setValue(PointerType param1PointerType1, PointerType param1PointerType2) {
/* 443 */       CoreFoundation.INSTANCE.CFDictionarySetValue(this, param1PointerType1, param1PointerType2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFStringRef
/*     */     extends CFTypeRef
/*     */   {
/*     */     public CFStringRef() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public CFStringRef(Pointer param1Pointer) {
/* 458 */       super(param1Pointer);
/* 459 */       if (!isTypeID(CoreFoundation.STRING_TYPE_ID)) {
/* 460 */         throw new ClassCastException("Unable to cast to CFString. Type ID: " + getTypeID());
/*     */       }
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
/*     */     public static CFStringRef createCFString(String param1String) {
/* 478 */       char[] arrayOfChar = param1String.toCharArray();
/* 479 */       return CoreFoundation.INSTANCE.CFStringCreateWithCharacters(null, arrayOfChar, new CoreFoundation.CFIndex(arrayOfChar.length));
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
/*     */     public String stringValue() {
/* 492 */       CoreFoundation.CFIndex cFIndex1 = CoreFoundation.INSTANCE.CFStringGetLength(this);
/* 493 */       if (cFIndex1.longValue() == 0L) {
/* 494 */         return "";
/*     */       }
/*     */ 
/*     */       
/* 498 */       CoreFoundation.CFIndex cFIndex2 = CoreFoundation.INSTANCE.CFStringGetMaximumSizeForEncoding(cFIndex1, 134217984);
/* 499 */       if (cFIndex2.intValue() == -1) {
/* 500 */         throw new StringIndexOutOfBoundsException("CFString maximum number of bytes exceeds LONG_MAX.");
/*     */       }
/*     */       
/* 503 */       cFIndex2.setValue(cFIndex2.longValue() + 1L);
/* 504 */       Memory memory = new Memory(cFIndex2.longValue());
/* 505 */       if (0 != CoreFoundation.INSTANCE.CFStringGetCString(this, (Pointer)memory, cFIndex2, 134217984)) {
/* 506 */         return memory.getString(0L, "UTF8");
/*     */       }
/* 508 */       throw new IllegalArgumentException("CFString conversion fails or the provided buffer is too small.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFIndex
/*     */     extends NativeLong
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public CFIndex() {}
/*     */ 
/*     */     
/*     */     public CFIndex(long param1Long) {
/* 524 */       super(param1Long);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CFTypeID
/*     */     extends NativeLong
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CFTypeID() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CFTypeID(long param1Long) {
/* 545 */       super(param1Long);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 550 */       if (equals(CoreFoundation.ARRAY_TYPE_ID))
/* 551 */         return "CFArray"; 
/* 552 */       if (equals(CoreFoundation.BOOLEAN_TYPE_ID))
/* 553 */         return "CFBoolean"; 
/* 554 */       if (equals(CoreFoundation.DATA_TYPE_ID))
/* 555 */         return "CFData"; 
/* 556 */       if (equals(CoreFoundation.DATE_TYPE_ID))
/* 557 */         return "CFDate"; 
/* 558 */       if (equals(CoreFoundation.DICTIONARY_TYPE_ID))
/* 559 */         return "CFDictionary"; 
/* 560 */       if (equals(CoreFoundation.NUMBER_TYPE_ID))
/* 561 */         return "CFNumber"; 
/* 562 */       if (equals(CoreFoundation.STRING_TYPE_ID)) {
/* 563 */         return "CFString";
/*     */       }
/* 565 */       return super.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\CoreFoundation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */