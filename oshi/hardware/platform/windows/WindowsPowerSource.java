/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Platform;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.SetupApi;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.win32.W32APITypeMapper;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.time.LocalDate;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.common.AbstractPowerSource;
/*     */ import oshi.jna.platform.windows.PowrProf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class WindowsPowerSource
/*     */   extends AbstractPowerSource
/*     */ {
/*  62 */   private static final Guid.GUID GUID_DEVCLASS_BATTERY = Guid.GUID.fromString("{72631E54-78A4-11D0-BCF7-00AA00B7B32A}");
/*  63 */   private static final int CHAR_WIDTH = (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) ? 2 : 1;
/*  64 */   private static final boolean X64 = Platform.is64Bit();
/*     */   
/*     */   private static final int BATTERY_SYSTEM_BATTERY = -2147483648;
/*     */   
/*     */   private static final int BATTERY_IS_SHORT_TERM = 536870912;
/*     */   
/*     */   private static final int BATTERY_POWER_ON_LINE = 1;
/*     */   
/*     */   private static final int BATTERY_DISCHARGING = 2;
/*     */   
/*     */   private static final int BATTERY_CHARGING = 4;
/*     */   
/*     */   private static final int BATTERY_CAPACITY_RELATIVE = 1073741824;
/*     */   
/*     */   private static final int IOCTL_BATTERY_QUERY_TAG = 2703424;
/*     */   private static final int IOCTL_BATTERY_QUERY_STATUS = 2703436;
/*     */   private static final int IOCTL_BATTERY_QUERY_INFORMATION = 2703428;
/*     */   
/*     */   public WindowsPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) {
/*  83 */     super(paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramBoolean1, paramBoolean2, paramBoolean3, paramCapacityUnits, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramLocalDate, paramString4, paramString5, paramDouble7);
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
/*  95 */     return Arrays.asList(new PowerSource[] { (PowerSource)getPowerSource("System Battery") });
/*     */   }
/*     */   
/*     */   private static WindowsPowerSource getPowerSource(String paramString) {
/*  99 */     String str1 = paramString;
/* 100 */     String str2 = "unknown";
/* 101 */     double d1 = 1.0D;
/* 102 */     double d2 = -1.0D;
/* 103 */     double d3 = 0.0D;
/* 104 */     int i = 0;
/* 105 */     double d4 = -1.0D;
/* 106 */     double d5 = 0.0D;
/* 107 */     boolean bool1 = false;
/* 108 */     boolean bool2 = false;
/* 109 */     boolean bool3 = false;
/* 110 */     PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
/* 111 */     int j = 0;
/* 112 */     int k = 1;
/* 113 */     int m = 1;
/* 114 */     int n = -1;
/* 115 */     String str3 = "unknown";
/* 116 */     LocalDate localDate = null;
/* 117 */     String str4 = "unknown";
/* 118 */     String str5 = "unknown";
/* 119 */     double d6 = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     int i1 = (new PowrProf.SystemBatteryState()).size();
/* 131 */     Memory memory = new Memory(i1);
/* 132 */     if (0 == PowrProf.INSTANCE.CallNtPowerInformation(5, null, 0, (Pointer)memory, i1)) {
/*     */       
/* 134 */       PowrProf.SystemBatteryState systemBatteryState = new PowrProf.SystemBatteryState((Pointer)memory);
/* 135 */       if (systemBatteryState.batteryPresent > 0) {
/* 136 */         if (systemBatteryState.acOnLine == 0 && systemBatteryState.charging == 0 && systemBatteryState.discharging > 0) {
/* 137 */           d2 = systemBatteryState.estimatedTime;
/* 138 */         } else if (systemBatteryState.charging > 0) {
/* 139 */           d2 = -2.0D;
/*     */         } 
/* 141 */         k = systemBatteryState.maxCapacity;
/* 142 */         j = systemBatteryState.remainingCapacity;
/* 143 */         d1 = Math.min(1.0D, j / k);
/* 144 */         i = systemBatteryState.rate;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     WinNT.HANDLE hANDLE = SetupApi.INSTANCE.SetupDiGetClassDevs(GUID_DEVCLASS_BATTERY, null, null, 18);
/*     */     
/* 154 */     if (WinBase.INVALID_HANDLE_VALUE != hANDLE) {
/* 155 */       boolean bool = false;
/*     */       
/* 157 */       for (byte b = 0; !bool && b < 100; b++) {
/* 158 */         SetupApi.SP_DEVICE_INTERFACE_DATA sP_DEVICE_INTERFACE_DATA = new SetupApi.SP_DEVICE_INTERFACE_DATA();
/* 159 */         sP_DEVICE_INTERFACE_DATA.cbSize = sP_DEVICE_INTERFACE_DATA.size();
/*     */         
/* 161 */         if (SetupApi.INSTANCE.SetupDiEnumDeviceInterfaces(hANDLE, null, GUID_DEVCLASS_BATTERY, b, sP_DEVICE_INTERFACE_DATA)) {
/* 162 */           IntByReference intByReference = new IntByReference(0);
/* 163 */           SetupApi.INSTANCE.SetupDiGetDeviceInterfaceDetail(hANDLE, sP_DEVICE_INTERFACE_DATA, null, 0, intByReference, null);
/* 164 */           if (122 == Kernel32.INSTANCE.GetLastError()) {
/*     */             
/* 166 */             Memory memory1 = new Memory(intByReference.getValue());
/*     */ 
/*     */ 
/*     */             
/* 170 */             memory1.setInt(0L, 4 + (X64 ? 4 : CHAR_WIDTH));
/*     */             
/* 172 */             if (SetupApi.INSTANCE.SetupDiGetDeviceInterfaceDetail(hANDLE, sP_DEVICE_INTERFACE_DATA, (Pointer)memory1, (int)memory1.size(), intByReference, null)) {
/*     */ 
/*     */ 
/*     */               
/* 176 */               String str = (CHAR_WIDTH > 1) ? memory1.getWideString(4L) : memory1.getString(4L);
/* 177 */               WinNT.HANDLE hANDLE1 = Kernel32.INSTANCE.CreateFile(str, -1073741824, 3, null, 3, 128, null);
/*     */ 
/*     */ 
/*     */               
/* 181 */               if (!WinBase.INVALID_HANDLE_VALUE.equals(hANDLE1)) {
/*     */                 
/* 183 */                 PowrProf.BATTERY_QUERY_INFORMATION bATTERY_QUERY_INFORMATION = new PowrProf.BATTERY_QUERY_INFORMATION();
/* 184 */                 IntByReference intByReference1 = new IntByReference(0);
/* 185 */                 IntByReference intByReference2 = new IntByReference();
/* 186 */                 IntByReference intByReference3 = new IntByReference();
/*     */                 
/* 188 */                 if (Kernel32.INSTANCE.DeviceIoControl(hANDLE1, 2703424, intByReference1
/* 189 */                     .getPointer(), 4, intByReference2.getPointer(), 4, intByReference3, null)) {
/*     */                   
/* 191 */                   bATTERY_QUERY_INFORMATION.BatteryTag = intByReference2.getValue();
/* 192 */                   if (bATTERY_QUERY_INFORMATION.BatteryTag > 0) {
/*     */                     
/* 194 */                     bATTERY_QUERY_INFORMATION
/* 195 */                       .InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryInformation.ordinal();
/* 196 */                     bATTERY_QUERY_INFORMATION.write();
/* 197 */                     PowrProf.BATTERY_INFORMATION bATTERY_INFORMATION = new PowrProf.BATTERY_INFORMATION();
/* 198 */                     if (Kernel32.INSTANCE.DeviceIoControl(hANDLE1, 2703428, bATTERY_QUERY_INFORMATION
/* 199 */                         .getPointer(), bATTERY_QUERY_INFORMATION.size(), bATTERY_INFORMATION.getPointer(), bATTERY_INFORMATION.size(), intByReference3, null)) {
/*     */ 
/*     */                       
/* 202 */                       bATTERY_INFORMATION.read();
/* 203 */                       if (0 != (bATTERY_INFORMATION.Capabilities & Integer.MIN_VALUE) && 0 == (bATTERY_INFORMATION.Capabilities & 0x20000000)) {
/*     */ 
/*     */                         
/* 206 */                         if (0 == (bATTERY_INFORMATION.Capabilities & 0x40000000)) {
/* 207 */                           capacityUnits = PowerSource.CapacityUnits.MWH;
/*     */                         }
/* 209 */                         str3 = Native.toString(bATTERY_INFORMATION.Chemistry, StandardCharsets.US_ASCII);
/* 210 */                         m = bATTERY_INFORMATION.DesignedCapacity;
/* 211 */                         k = bATTERY_INFORMATION.FullChargedCapacity;
/* 212 */                         n = bATTERY_INFORMATION.CycleCount;
/*     */ 
/*     */                         
/* 215 */                         PowrProf.BATTERY_WAIT_STATUS bATTERY_WAIT_STATUS = new PowrProf.BATTERY_WAIT_STATUS();
/* 216 */                         bATTERY_WAIT_STATUS.BatteryTag = bATTERY_QUERY_INFORMATION.BatteryTag;
/* 217 */                         bATTERY_WAIT_STATUS.write();
/* 218 */                         PowrProf.BATTERY_STATUS bATTERY_STATUS = new PowrProf.BATTERY_STATUS();
/* 219 */                         if (Kernel32.INSTANCE.DeviceIoControl(hANDLE1, 2703436, bATTERY_WAIT_STATUS
/* 220 */                             .getPointer(), bATTERY_WAIT_STATUS.size(), bATTERY_STATUS
/* 221 */                             .getPointer(), bATTERY_STATUS.size(), intByReference3, null)) {
/* 222 */                           bATTERY_STATUS.read();
/* 223 */                           if (0 != (bATTERY_STATUS.PowerState & 0x1)) {
/* 224 */                             bool1 = true;
/*     */                           }
/* 226 */                           if (0 != (bATTERY_STATUS.PowerState & 0x2)) {
/* 227 */                             bool3 = true;
/*     */                           }
/* 229 */                           if (0 != (bATTERY_STATUS.PowerState & 0x4)) {
/* 230 */                             bool2 = true;
/*     */                           }
/* 232 */                           j = bATTERY_STATUS.Capacity;
/* 233 */                           d4 = (bATTERY_STATUS.Voltage > 0) ? (bATTERY_STATUS.Voltage / 1000.0D) : bATTERY_STATUS.Voltage;
/* 234 */                           i = bATTERY_STATUS.Rate;
/* 235 */                           if (d4 > 0.0D) {
/* 236 */                             d5 = i / d4;
/*     */                           }
/*     */                         } 
/*     */                       } 
/*     */                       
/* 241 */                       str2 = batteryQueryString(hANDLE1, intByReference2.getValue(), PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryDeviceName
/*     */                           
/* 243 */                           .ordinal());
/* 244 */                       str4 = batteryQueryString(hANDLE1, intByReference2.getValue(), PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryManufactureName
/*     */                           
/* 246 */                           .ordinal());
/* 247 */                       str5 = batteryQueryString(hANDLE1, intByReference2.getValue(), PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatterySerialNumber
/*     */                           
/* 249 */                           .ordinal());
/*     */                       
/* 251 */                       bATTERY_QUERY_INFORMATION
/* 252 */                         .InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryManufactureDate.ordinal();
/* 253 */                       bATTERY_QUERY_INFORMATION.write();
/* 254 */                       PowrProf.BATTERY_MANUFACTURE_DATE bATTERY_MANUFACTURE_DATE = new PowrProf.BATTERY_MANUFACTURE_DATE();
/* 255 */                       if (Kernel32.INSTANCE.DeviceIoControl(hANDLE1, 2703428, bATTERY_QUERY_INFORMATION
/* 256 */                           .getPointer(), bATTERY_QUERY_INFORMATION.size(), bATTERY_MANUFACTURE_DATE
/* 257 */                           .getPointer(), bATTERY_MANUFACTURE_DATE.size(), intByReference3, null)) {
/* 258 */                         bATTERY_MANUFACTURE_DATE.read();
/*     */                         
/* 260 */                         if (bATTERY_MANUFACTURE_DATE.Year > 1900 && bATTERY_MANUFACTURE_DATE.Month > 0 && bATTERY_MANUFACTURE_DATE.Day > 0) {
/* 261 */                           localDate = LocalDate.of(bATTERY_MANUFACTURE_DATE.Year, bATTERY_MANUFACTURE_DATE.Month, bATTERY_MANUFACTURE_DATE.Day);
/*     */                         }
/*     */                       } 
/*     */                       
/* 265 */                       bATTERY_QUERY_INFORMATION
/* 266 */                         .InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryTemperature.ordinal();
/* 267 */                       bATTERY_QUERY_INFORMATION.write();
/* 268 */                       IntByReference intByReference4 = new IntByReference();
/* 269 */                       if (Kernel32.INSTANCE.DeviceIoControl(hANDLE1, 2703428, bATTERY_QUERY_INFORMATION
/* 270 */                           .getPointer(), bATTERY_QUERY_INFORMATION.size(), intByReference4
/* 271 */                           .getPointer(), 4, intByReference3, null)) {
/* 272 */                         d6 = intByReference4.getValue() / 10.0D - 273.15D;
/*     */                       }
/*     */ 
/*     */                       
/* 276 */                       bATTERY_QUERY_INFORMATION
/* 277 */                         .InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryEstimatedTime.ordinal();
/* 278 */                       if (i != 0) {
/* 279 */                         bATTERY_QUERY_INFORMATION.AtRate = i;
/*     */                       }
/* 281 */                       bATTERY_QUERY_INFORMATION.write();
/* 282 */                       IntByReference intByReference5 = new IntByReference();
/* 283 */                       if (Kernel32.INSTANCE.DeviceIoControl(hANDLE1, 2703428, bATTERY_QUERY_INFORMATION
/* 284 */                           .getPointer(), bATTERY_QUERY_INFORMATION.size(), intByReference5
/* 285 */                           .getPointer(), 4, intByReference3, null)) {
/* 286 */                         d3 = intByReference5.getValue();
/*     */                       }
/*     */                       
/* 289 */                       if (d3 < 0.0D && i != 0) {
/* 290 */                         d3 = (k - j) * 3600.0D / i;
/*     */                         
/* 292 */                         if (d3 < 0.0D) {
/* 293 */                           d3 *= -1.0D;
/*     */                         }
/*     */                       } 
/*     */                       
/* 297 */                       bool = true;
/*     */                     } 
/*     */                   } 
/*     */                 } 
/* 301 */                 Kernel32.INSTANCE.CloseHandle(hANDLE1);
/*     */               } 
/*     */             } 
/*     */           } 
/* 305 */         } else if (259 == Kernel32.INSTANCE.GetLastError()) {
/*     */           break;
/*     */         } 
/*     */       } 
/* 309 */       SetupApi.INSTANCE.SetupDiDestroyDeviceInfoList(hANDLE);
/*     */     } 
/*     */     
/* 312 */     return new WindowsPowerSource(str1, str2, d1, d2, d3, i, d4, d5, bool1, bool2, bool3, capacityUnits, j, k, m, n, str3, localDate, str4, str5, d6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String batteryQueryString(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2) {
/*     */     Memory memory;
/* 319 */     PowrProf.BATTERY_QUERY_INFORMATION bATTERY_QUERY_INFORMATION = new PowrProf.BATTERY_QUERY_INFORMATION();
/* 320 */     bATTERY_QUERY_INFORMATION.BatteryTag = paramInt1;
/* 321 */     bATTERY_QUERY_INFORMATION.InformationLevel = paramInt2;
/* 322 */     bATTERY_QUERY_INFORMATION.write();
/* 323 */     IntByReference intByReference = new IntByReference();
/* 324 */     boolean bool = false;
/* 325 */     long l = 0L;
/*     */ 
/*     */     
/*     */     do {
/* 329 */       l += 256L;
/* 330 */       memory = new Memory(l);
/* 331 */       bool = Kernel32.INSTANCE.DeviceIoControl(paramHANDLE, 2703428, bATTERY_QUERY_INFORMATION.getPointer(), bATTERY_QUERY_INFORMATION
/* 332 */           .size(), (Pointer)memory, (int)memory.size(), intByReference, null);
/* 333 */     } while (!bool && l < 4096L);
/* 334 */     return (CHAR_WIDTH > 1) ? memory.getWideString(0L) : memory.getString(0L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */