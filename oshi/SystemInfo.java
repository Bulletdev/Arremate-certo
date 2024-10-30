/*     */ package oshi;
/*     */ 
/*     */ import com.sun.jna.Platform;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.hardware.HardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.linux.LinuxHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.mac.MacHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.unix.aix.AixHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.unix.freebsd.FreeBsdHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.unix.openbsd.OpenBsdHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.unix.solaris.SolarisHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.windows.WindowsHardwareAbstractionLayer;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.software.os.linux.LinuxOperatingSystem;
/*     */ import oshi.software.os.mac.MacOperatingSystem;
/*     */ import oshi.software.os.unix.aix.AixOperatingSystem;
/*     */ import oshi.software.os.unix.freebsd.FreeBsdOperatingSystem;
/*     */ import oshi.software.os.unix.openbsd.OpenBsdOperatingSystem;
/*     */ import oshi.software.os.unix.solaris.SolarisOperatingSystem;
/*     */ import oshi.software.os.windows.WindowsOperatingSystem;
/*     */ import oshi.util.Memoizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SystemInfo
/*     */ {
/*  62 */   private static final PlatformEnum currentPlatform = PlatformEnum.getValue(Platform.getOSType());
/*     */   
/*     */   private static final String NOT_SUPPORTED = "Operating system not supported: ";
/*     */   
/*  66 */   private final Supplier<OperatingSystem> os = Memoizer.memoize(SystemInfo::createOperatingSystem);
/*     */   
/*  68 */   private final Supplier<HardwareAbstractionLayer> hardware = Memoizer.memoize(SystemInfo::createHardware);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PlatformEnum getCurrentPlatform() {
/*  90 */     return currentPlatform;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static PlatformEnum getCurrentPlatformEnum() {
/* 101 */     PlatformEnum platformEnum = getCurrentPlatform();
/* 102 */     return platformEnum.equals(PlatformEnum.MACOS) ? PlatformEnum.MACOSX : platformEnum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OperatingSystem getOperatingSystem() {
/* 112 */     return this.os.get();
/*     */   }
/*     */   
/*     */   private static OperatingSystem createOperatingSystem() {
/* 116 */     switch (currentPlatform) {
/*     */       case WINDOWS:
/* 118 */         return (OperatingSystem)new WindowsOperatingSystem();
/*     */       case LINUX:
/* 120 */         return (OperatingSystem)new LinuxOperatingSystem();
/*     */       case MACOS:
/* 122 */         return (OperatingSystem)new MacOperatingSystem();
/*     */       case SOLARIS:
/* 124 */         return (OperatingSystem)new SolarisOperatingSystem();
/*     */       case FREEBSD:
/* 126 */         return (OperatingSystem)new FreeBsdOperatingSystem();
/*     */       case AIX:
/* 128 */         return (OperatingSystem)new AixOperatingSystem();
/*     */       case OPENBSD:
/* 130 */         return (OperatingSystem)new OpenBsdOperatingSystem();
/*     */     } 
/* 132 */     throw new UnsupportedOperationException("Operating system not supported: " + currentPlatform.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HardwareAbstractionLayer getHardware() {
/* 143 */     return this.hardware.get();
/*     */   }
/*     */   
/*     */   private static HardwareAbstractionLayer createHardware() {
/* 147 */     switch (currentPlatform) {
/*     */       case WINDOWS:
/* 149 */         return (HardwareAbstractionLayer)new WindowsHardwareAbstractionLayer();
/*     */       case LINUX:
/* 151 */         return (HardwareAbstractionLayer)new LinuxHardwareAbstractionLayer();
/*     */       case MACOS:
/* 153 */         return (HardwareAbstractionLayer)new MacHardwareAbstractionLayer();
/*     */       case SOLARIS:
/* 155 */         return (HardwareAbstractionLayer)new SolarisHardwareAbstractionLayer();
/*     */       case FREEBSD:
/* 157 */         return (HardwareAbstractionLayer)new FreeBsdHardwareAbstractionLayer();
/*     */       case AIX:
/* 159 */         return (HardwareAbstractionLayer)new AixHardwareAbstractionLayer();
/*     */       case OPENBSD:
/* 161 */         return (HardwareAbstractionLayer)new OpenBsdHardwareAbstractionLayer();
/*     */     } 
/* 163 */     throw new UnsupportedOperationException("Operating system not supported: " + currentPlatform.getName());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\SystemInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */