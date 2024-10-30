/*     */ package oshi.hardware;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public interface CentralProcessor
/*     */ {
/*     */   ProcessorIdentifier getProcessorIdentifier();
/*     */   
/*     */   long getMaxFreq();
/*     */   
/*     */   long[] getCurrentFreq();
/*     */   
/*     */   List<LogicalProcessor> getLogicalProcessors();
/*     */   
/*     */   double getSystemCpuLoadBetweenTicks(long[] paramArrayOflong);
/*     */   
/*     */   long[] getSystemCpuLoadTicks();
/*     */   
/*     */   double[] getSystemLoadAverage(int paramInt);
/*     */   
/*     */   double[] getProcessorCpuLoadBetweenTicks(long[][] paramArrayOflong);
/*     */   
/*     */   long[][] getProcessorCpuLoadTicks();
/*     */   
/*     */   int getLogicalProcessorCount();
/*     */   
/*     */   int getPhysicalProcessorCount();
/*     */   
/*     */   int getPhysicalPackageCount();
/*     */   
/*     */   long getContextSwitches();
/*     */   
/*     */   long getInterrupts();
/*     */   
/*     */   public enum TickType
/*     */   {
/* 257 */     USER(0),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 262 */     NICE(1),
/*     */ 
/*     */ 
/*     */     
/* 266 */     SYSTEM(2),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     IDLE(3),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 276 */     IOWAIT(4),
/*     */ 
/*     */ 
/*     */     
/* 280 */     IRQ(5),
/*     */ 
/*     */ 
/*     */     
/* 284 */     SOFTIRQ(6),
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     STEAL(7);
/*     */     
/*     */     private int index;
/*     */     
/*     */     TickType(int param1Int1) {
/* 294 */       this.index = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getIndex() {
/* 302 */       return this.index;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class LogicalProcessor
/*     */   {
/*     */     private final int processorNumber;
/*     */ 
/*     */     
/*     */     private final int physicalProcessorNumber;
/*     */ 
/*     */     
/*     */     private final int physicalPackageNumber;
/*     */ 
/*     */     
/*     */     private final int numaNode;
/*     */ 
/*     */     
/*     */     private final int processorGroup;
/*     */ 
/*     */ 
/*     */     
/*     */     public LogicalProcessor(int param1Int1, int param1Int2, int param1Int3) {
/* 328 */       this(param1Int1, param1Int2, param1Int3, 0, 0);
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
/*     */     public LogicalProcessor(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 343 */       this(param1Int1, param1Int2, param1Int3, param1Int4, 0);
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
/*     */     public LogicalProcessor(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
/* 360 */       this.processorNumber = param1Int1;
/* 361 */       this.physicalProcessorNumber = param1Int2;
/* 362 */       this.physicalPackageNumber = param1Int3;
/* 363 */       this.numaNode = param1Int4;
/* 364 */       this.processorGroup = param1Int5;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getProcessorNumber() {
/* 374 */       return this.processorNumber;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPhysicalProcessorNumber() {
/* 385 */       return this.physicalProcessorNumber;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPhysicalPackageNumber() {
/* 396 */       return this.physicalPackageNumber;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getNumaNode() {
/* 407 */       return this.numaNode;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getProcessorGroup() {
/* 418 */       return this.processorGroup;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 423 */       return "LogicalProcessor [processorNumber=" + this.processorNumber + ", coreNumber=" + this.physicalProcessorNumber + ", packageNumber=" + this.physicalPackageNumber + ", numaNode=" + this.numaNode + ", processorGroup=" + this.processorGroup + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static final class ProcessorIdentifier
/*     */   {
/*     */     private static final String OSHI_ARCHITECTURE_PROPERTIES = "oshi.architecture.properties";
/*     */     
/*     */     private final String cpuVendor;
/*     */     
/*     */     private final String cpuName;
/*     */     
/*     */     private final String cpuFamily;
/*     */     
/*     */     private final String cpuModel;
/*     */     
/*     */     private final String cpuStepping;
/*     */     
/*     */     private final String processorID;
/*     */     
/*     */     private final String cpuIdentifier;
/*     */     private final boolean cpu64bit;
/*     */     private final long cpuVendorFreq;
/* 448 */     private final Supplier<String> microArchictecture = Memoizer.memoize(this::queryMicroarchitecture);
/*     */ 
/*     */     
/*     */     public ProcessorIdentifier(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, boolean param1Boolean) {
/* 452 */       this(param1String1, param1String2, param1String3, param1String4, param1String5, param1String6, param1Boolean, -1L);
/*     */     }
/*     */ 
/*     */     
/*     */     public ProcessorIdentifier(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, boolean param1Boolean, long param1Long) {
/* 457 */       this.cpuVendor = param1String1;
/* 458 */       this.cpuName = param1String2;
/* 459 */       this.cpuFamily = param1String3;
/* 460 */       this.cpuModel = param1String4;
/* 461 */       this.cpuStepping = param1String5;
/* 462 */       this.processorID = param1String6;
/* 463 */       this.cpu64bit = param1Boolean;
/*     */ 
/*     */       
/* 466 */       StringBuilder stringBuilder = new StringBuilder();
/* 467 */       if (param1String1.contentEquals("GenuineIntel")) {
/* 468 */         stringBuilder.append(param1Boolean ? "Intel64" : "x86");
/*     */       } else {
/* 470 */         stringBuilder.append(param1String1);
/*     */       } 
/* 472 */       stringBuilder.append(" Family ").append(param1String3);
/* 473 */       stringBuilder.append(" Model ").append(param1String4);
/* 474 */       stringBuilder.append(" Stepping ").append(param1String5);
/* 475 */       this.cpuIdentifier = stringBuilder.toString();
/*     */       
/* 477 */       if (param1Long > 0L) {
/* 478 */         this.cpuVendorFreq = param1Long;
/*     */       } else {
/*     */         
/* 481 */         Pattern pattern = Pattern.compile("@ (.*)$");
/* 482 */         Matcher matcher = pattern.matcher(param1String2);
/* 483 */         if (matcher.find()) {
/* 484 */           String str = matcher.group(1);
/* 485 */           this.cpuVendorFreq = ParseUtil.parseHertz(str);
/*     */         } else {
/* 487 */           this.cpuVendorFreq = -1L;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getVendor() {
/* 498 */       return this.cpuVendor;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 507 */       return this.cpuName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getFamily() {
/* 517 */       return this.cpuFamily;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getModel() {
/* 527 */       return this.cpuModel;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getStepping() {
/* 537 */       return this.cpuStepping;
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
/*     */ 
/*     */     
/*     */     public String getProcessorID() {
/* 562 */       return this.processorID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getIdentifier() {
/* 572 */       return this.cpuIdentifier;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isCpu64bit() {
/* 581 */       return this.cpu64bit;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getVendorFreq() {
/* 591 */       return this.cpuVendorFreq;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getMicroarchitecture() {
/* 601 */       return this.microArchictecture.get();
/*     */     }
/*     */     
/*     */     private String queryMicroarchitecture() {
/* 605 */       String str1 = null;
/* 606 */       Properties properties = FileUtil.readPropertiesFromFilename("oshi.architecture.properties");
/*     */       
/* 608 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 610 */       String str2 = this.cpuVendor.toUpperCase();
/* 611 */       if (str2.contains("AMD")) {
/* 612 */         stringBuilder.append("amd.");
/* 613 */       } else if (str2.contains("ARM")) {
/* 614 */         stringBuilder.append("arm.");
/* 615 */       } else if (str2.contains("IBM")) {
/*     */         
/* 617 */         int i = this.cpuName.indexOf("_POWER");
/* 618 */         if (i > 0) {
/* 619 */           str1 = this.cpuName.substring(i + 1);
/*     */         }
/* 621 */       } else if (str2.contains("APPLE")) {
/* 622 */         stringBuilder.append("apple.");
/*     */       } 
/* 624 */       if (Util.isBlank(str1) && !stringBuilder.toString().equals("arm.")) {
/*     */         
/* 626 */         stringBuilder.append(this.cpuFamily);
/* 627 */         str1 = properties.getProperty(stringBuilder.toString());
/*     */       } 
/*     */       
/* 630 */       if (Util.isBlank(str1)) {
/*     */         
/* 632 */         stringBuilder.append('.').append(this.cpuModel);
/* 633 */         str1 = properties.getProperty(stringBuilder.toString());
/*     */       } 
/*     */       
/* 636 */       if (Util.isBlank(str1)) {
/*     */         
/* 638 */         stringBuilder.append('.').append(this.cpuStepping);
/* 639 */         str1 = properties.getProperty(stringBuilder.toString());
/*     */       } 
/*     */       
/* 642 */       return Util.isBlank(str1) ? "unknown" : str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 647 */       return getIdentifier();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\CentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */