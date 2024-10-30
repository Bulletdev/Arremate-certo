/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.driver.linux.Sysfs;
/*     */ import oshi.driver.linux.proc.CpuInfo;
/*     */ import oshi.hardware.common.AbstractBaseboard;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.tuples.Quartet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class LinuxBaseboard
/*     */   extends AbstractBaseboard
/*     */ {
/*  43 */   private final Supplier<String> manufacturer = Memoizer.memoize(this::queryManufacturer);
/*  44 */   private final Supplier<String> model = Memoizer.memoize(this::queryModel);
/*  45 */   private final Supplier<String> version = Memoizer.memoize(this::queryVersion);
/*  46 */   private final Supplier<String> serialNumber = Memoizer.memoize(this::querySerialNumber);
/*  47 */   private final Supplier<Quartet<String, String, String, String>> manufacturerModelVersionSerial = Memoizer.memoize(CpuInfo::queryBoardInfo);
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  52 */     return this.manufacturer.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  57 */     return this.model.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  62 */     return this.version.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  67 */     return this.serialNumber.get();
/*     */   }
/*     */   
/*     */   private String queryManufacturer() {
/*  71 */     String str = null;
/*  72 */     if ((str = Sysfs.queryBoardVendor()) == null && (
/*  73 */       str = (String)((Quartet)this.manufacturerModelVersionSerial.get()).getA()) == null) {
/*  74 */       return "unknown";
/*     */     }
/*  76 */     return str;
/*     */   }
/*     */   
/*     */   private String queryModel() {
/*  80 */     String str = null;
/*  81 */     if ((str = Sysfs.queryBoardModel()) == null && (
/*  82 */       str = (String)((Quartet)this.manufacturerModelVersionSerial.get()).getB()) == null) {
/*  83 */       return "unknown";
/*     */     }
/*  85 */     return str;
/*     */   }
/*     */   
/*     */   private String queryVersion() {
/*  89 */     String str = null;
/*  90 */     if ((str = Sysfs.queryBoardVersion()) == null && (
/*  91 */       str = (String)((Quartet)this.manufacturerModelVersionSerial.get()).getC()) == null) {
/*  92 */       return "unknown";
/*     */     }
/*  94 */     return str;
/*     */   }
/*     */   
/*     */   private String querySerialNumber() {
/*  98 */     String str = null;
/*  99 */     if ((str = Sysfs.queryBoardSerial()) == null && (
/* 100 */       str = (String)((Quartet)this.manufacturerModelVersionSerial.get()).getD()) == null) {
/* 101 */       return "unknown";
/*     */     }
/* 103 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxBaseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */