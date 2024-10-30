/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.ComputerSystem;
/*     */ import oshi.hardware.GlobalMemory;
/*     */ import oshi.hardware.HardwareAbstractionLayer;
/*     */ import oshi.hardware.NetworkIF;
/*     */ import oshi.hardware.Sensors;
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
/*     */ @ThreadSafe
/*     */ public abstract class AbstractHardwareAbstractionLayer
/*     */   implements HardwareAbstractionLayer
/*     */ {
/*  46 */   private final Supplier<ComputerSystem> computerSystem = Memoizer.memoize(this::createComputerSystem);
/*     */   
/*  48 */   private final Supplier<CentralProcessor> processor = Memoizer.memoize(this::createProcessor);
/*     */   
/*  50 */   private final Supplier<GlobalMemory> memory = Memoizer.memoize(this::createMemory);
/*     */   
/*  52 */   private final Supplier<Sensors> sensors = Memoizer.memoize(this::createSensors);
/*     */ 
/*     */   
/*     */   public ComputerSystem getComputerSystem() {
/*  56 */     return this.computerSystem.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract ComputerSystem createComputerSystem();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CentralProcessor getProcessor() {
/*  68 */     return this.processor.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CentralProcessor createProcessor();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GlobalMemory getMemory() {
/*  80 */     return this.memory.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract GlobalMemory createMemory();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sensors getSensors() {
/*  92 */     return this.sensors.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Sensors createSensors();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<NetworkIF> getNetworkIFs() {
/* 104 */     return getNetworkIFs(false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractHardwareAbstractionLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */