/*     */ package oshi.hardware.platform.unix.aix;
/*     */ 
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.Lscfg;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatDisk;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.ComputerSystem;
/*     */ import oshi.hardware.Display;
/*     */ import oshi.hardware.GlobalMemory;
/*     */ import oshi.hardware.GraphicsCard;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.Sensors;
/*     */ import oshi.hardware.SoundCard;
/*     */ import oshi.hardware.UsbDevice;
/*     */ import oshi.hardware.common.AbstractHardwareAbstractionLayer;
/*     */ import oshi.hardware.platform.unix.UnixDisplay;
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
/*     */ @ThreadSafe
/*     */ public final class AixHardwareAbstractionLayer
/*     */   extends AbstractHardwareAbstractionLayer
/*     */ {
/*  58 */   private final Supplier<List<String>> lscfg = Memoizer.memoize(Lscfg::queryAllDevices, Memoizer.defaultExpiration());
/*     */   
/*  60 */   private final Supplier<Perfstat.perfstat_disk_t[]> diskStats = Memoizer.memoize(PerfstatDisk::queryDiskStats, Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*     */   public ComputerSystem createComputerSystem() {
/*  64 */     return (ComputerSystem)new AixComputerSystem(this.lscfg);
/*     */   }
/*     */ 
/*     */   
/*     */   public GlobalMemory createMemory() {
/*  69 */     return (GlobalMemory)new AixGlobalMemory(this.lscfg);
/*     */   }
/*     */ 
/*     */   
/*     */   public CentralProcessor createProcessor() {
/*  74 */     return (CentralProcessor)new AixCentralProcessor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Sensors createSensors() {
/*  79 */     return (Sensors)new AixSensors(this.lscfg);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PowerSource> getPowerSources() {
/*  84 */     return AixPowerSource.getPowerSources();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWDiskStore> getDiskStores() {
/*  89 */     return AixHWDiskStore.getDisks(this.diskStats);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Display> getDisplays() {
/*  94 */     return UnixDisplay.getDisplays();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<NetworkIF> getNetworkIFs(boolean paramBoolean) {
/*  99 */     return AixNetworkIF.getNetworks(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<UsbDevice> getUsbDevices(boolean paramBoolean) {
/* 104 */     return AixUsbDevice.getUsbDevices(paramBoolean, this.lscfg);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<SoundCard> getSoundCards() {
/* 109 */     return AixSoundCard.getSoundCards(this.lscfg);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<GraphicsCard> getGraphicsCards() {
/* 114 */     return AixGraphicsCard.getGraphicsCards(this.lscfg);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixHardwareAbstractionLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */