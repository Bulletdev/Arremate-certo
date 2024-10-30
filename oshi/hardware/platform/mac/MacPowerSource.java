/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.platform.mac.CoreFoundation;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import java.time.LocalDate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.common.AbstractPowerSource;
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
/*     */ @ThreadSafe
/*     */ public final class MacPowerSource
/*     */   extends AbstractPowerSource
/*     */ {
/*  54 */   private static final CoreFoundation CF = CoreFoundation.INSTANCE;
/*  55 */   private static final IOKit IO = IOKit.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MacPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) {
/*  63 */     super(paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramBoolean1, paramBoolean2, paramBoolean3, paramCapacityUnits, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramLocalDate, paramString4, paramString5, paramDouble7);
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
/*     */   public static List<PowerSource> getPowerSources() {
/*  75 */     String str1 = "unknown";
/*  76 */     double d1 = 0.0D;
/*  77 */     double d2 = 0.0D;
/*  78 */     double d3 = -1.0D;
/*  79 */     double d4 = 0.0D;
/*  80 */     boolean bool1 = false;
/*  81 */     boolean bool2 = false;
/*  82 */     boolean bool = false;
/*  83 */     PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
/*  84 */     int i = 0;
/*  85 */     int j = 1;
/*  86 */     int k = 1;
/*  87 */     int m = -1;
/*  88 */     String str2 = "unknown";
/*  89 */     LocalDate localDate = null;
/*  90 */     String str3 = "unknown";
/*  91 */     String str4 = "unknown";
/*  92 */     double d5 = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     IOKit.IOService iOService = IOKitUtil.getMatchingService("AppleSmartBattery");
/* 103 */     if (iOService != null) {
/* 104 */       String str = iOService.getStringProperty("DeviceName");
/* 105 */       if (str != null) {
/* 106 */         str1 = str;
/*     */       }
/* 108 */       str = iOService.getStringProperty("Manufacturer");
/* 109 */       if (str != null) {
/* 110 */         str3 = str;
/*     */       }
/* 112 */       str = iOService.getStringProperty("BatterySerialNumber");
/* 113 */       if (str != null) {
/* 114 */         str4 = str;
/*     */       }
/*     */       
/* 117 */       Integer integer = iOService.getIntegerProperty("ManufactureDate");
/* 118 */       if (integer != null) {
/*     */ 
/*     */ 
/*     */         
/* 122 */         int i1 = integer.intValue() & 0x1F;
/* 123 */         int i2 = integer.intValue() >> 5 & 0xF;
/* 124 */         int i3 = integer.intValue() >> 9 & 0x7F;
/* 125 */         localDate = LocalDate.of(1980 + i3, i2, i1);
/*     */       } 
/*     */       
/* 128 */       integer = iOService.getIntegerProperty("DesignCapacity");
/* 129 */       if (integer != null) {
/* 130 */         k = integer.intValue();
/*     */       }
/* 132 */       integer = iOService.getIntegerProperty("MaxCapacity");
/* 133 */       if (integer != null) {
/* 134 */         j = integer.intValue();
/*     */       }
/* 136 */       integer = iOService.getIntegerProperty("CurrentCapacity");
/* 137 */       if (integer != null) {
/* 138 */         i = integer.intValue();
/*     */       }
/* 140 */       capacityUnits = PowerSource.CapacityUnits.MAH;
/*     */       
/* 142 */       integer = iOService.getIntegerProperty("TimeRemaining");
/* 143 */       if (integer != null) {
/* 144 */         d1 = integer.intValue() * 60.0D;
/*     */       }
/* 146 */       integer = iOService.getIntegerProperty("CycleCount");
/* 147 */       if (integer != null) {
/* 148 */         m = integer.intValue();
/*     */       }
/* 150 */       integer = iOService.getIntegerProperty("Temperature");
/* 151 */       if (integer != null) {
/* 152 */         d5 = integer.intValue() / 100.0D;
/*     */       }
/* 154 */       integer = iOService.getIntegerProperty("Voltage");
/* 155 */       if (integer != null) {
/* 156 */         d3 = integer.intValue() / 1000.0D;
/*     */       }
/* 158 */       integer = iOService.getIntegerProperty("Amperage");
/* 159 */       if (integer != null) {
/* 160 */         d4 = integer.intValue();
/*     */       }
/* 162 */       d2 = d3 * d4;
/*     */       
/* 164 */       Boolean bool3 = iOService.getBooleanProperty("ExternalConnected");
/* 165 */       if (bool3 != null) {
/* 166 */         bool1 = bool3.booleanValue();
/*     */       }
/* 168 */       bool3 = iOService.getBooleanProperty("IsCharging");
/* 169 */       if (bool3 != null) {
/* 170 */         bool2 = bool3.booleanValue();
/*     */       }
/* 172 */       bool = !bool2 ? true : false;
/*     */       
/* 174 */       iOService.release();
/*     */     } 
/*     */ 
/*     */     
/* 178 */     CoreFoundation.CFTypeRef cFTypeRef = IO.IOPSCopyPowerSourcesInfo();
/* 179 */     CoreFoundation.CFArrayRef cFArrayRef = IO.IOPSCopyPowerSourcesList(cFTypeRef);
/* 180 */     int n = cFArrayRef.getCount();
/*     */ 
/*     */ 
/*     */     
/* 184 */     double d6 = IO.IOPSGetTimeRemainingEstimate();
/*     */     
/* 186 */     CoreFoundation.CFStringRef cFStringRef1 = CoreFoundation.CFStringRef.createCFString("Name");
/* 187 */     CoreFoundation.CFStringRef cFStringRef2 = CoreFoundation.CFStringRef.createCFString("Is Present");
/* 188 */     CoreFoundation.CFStringRef cFStringRef3 = CoreFoundation.CFStringRef.createCFString("Current Capacity");
/* 189 */     CoreFoundation.CFStringRef cFStringRef4 = CoreFoundation.CFStringRef.createCFString("Max Capacity");
/*     */     
/* 191 */     ArrayList<MacPowerSource> arrayList = new ArrayList(n);
/* 192 */     for (byte b = 0; b < n; b++) {
/*     */       
/* 194 */       Pointer pointer1 = cFArrayRef.getValueAtIndex(b);
/* 195 */       CoreFoundation.CFTypeRef cFTypeRef1 = new CoreFoundation.CFTypeRef();
/* 196 */       cFTypeRef1.setPointer(pointer1);
/* 197 */       CoreFoundation.CFDictionaryRef cFDictionaryRef = IO.IOPSGetPowerSourceDescription(cFTypeRef, cFTypeRef1);
/*     */ 
/*     */ 
/*     */       
/* 201 */       Pointer pointer2 = cFDictionaryRef.getValue((PointerType)cFStringRef2);
/* 202 */       if (pointer2 != null) {
/* 203 */         CoreFoundation.CFBooleanRef cFBooleanRef = new CoreFoundation.CFBooleanRef(pointer2);
/* 204 */         if (0 != CF.CFBooleanGetValue(cFBooleanRef)) {
/*     */           
/* 206 */           pointer2 = cFDictionaryRef.getValue((PointerType)cFStringRef1);
/* 207 */           String str = CFUtil.cfPointerToString(pointer2);
/*     */           
/* 209 */           double d7 = 0.0D;
/* 210 */           if (cFDictionaryRef.getValueIfPresent((PointerType)cFStringRef3, null)) {
/* 211 */             pointer2 = cFDictionaryRef.getValue((PointerType)cFStringRef3);
/* 212 */             CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(pointer2);
/* 213 */             d7 = cFNumberRef.intValue();
/*     */           } 
/* 215 */           double d8 = 1.0D;
/* 216 */           if (cFDictionaryRef.getValueIfPresent((PointerType)cFStringRef4, null)) {
/* 217 */             pointer2 = cFDictionaryRef.getValue((PointerType)cFStringRef4);
/* 218 */             CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(pointer2);
/* 219 */             d8 = cFNumberRef.intValue();
/*     */           } 
/* 221 */           double d9 = Math.min(1.0D, d7 / d8);
/*     */           
/* 223 */           arrayList.add(new MacPowerSource(str, str1, d9, d6, d1, d2, d3, d4, bool1, bool2, bool, capacityUnits, i, j, k, m, str2, localDate, str3, str4, d5));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     cFStringRef2.release();
/* 232 */     cFStringRef1.release();
/* 233 */     cFStringRef3.release();
/* 234 */     cFStringRef4.release();
/*     */     
/* 236 */     cFArrayRef.release();
/* 237 */     cFTypeRef.release();
/*     */     
/* 239 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */