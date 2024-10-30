/*    */ package oshi.hardware.platform.unix.openbsd;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.Baseboard;
/*    */ import oshi.hardware.Firmware;
/*    */ import oshi.hardware.common.AbstractComputerSystem;
/*    */ import oshi.hardware.platform.unix.UnixBaseboard;
/*    */ import oshi.util.Memoizer;
/*    */ import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Immutable
/*    */ public class OpenBsdComputerSystem
/*    */   extends AbstractComputerSystem
/*    */ {
/* 44 */   private final Supplier<String> manufacturer = Memoizer.memoize(OpenBsdComputerSystem::queryManufacturer);
/*    */   
/* 46 */   private final Supplier<String> model = Memoizer.memoize(OpenBsdComputerSystem::queryModel);
/*    */   
/* 48 */   private final Supplier<String> serialNumber = Memoizer.memoize(OpenBsdComputerSystem::querySerialNumber);
/*    */   
/* 50 */   private final Supplier<String> uuid = Memoizer.memoize(OpenBsdComputerSystem::queryUUID);
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 54 */     return this.manufacturer.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModel() {
/* 59 */     return this.model.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSerialNumber() {
/* 64 */     return this.serialNumber.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHardwareUUID() {
/* 69 */     return this.uuid.get();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Firmware createFirmware() {
/* 74 */     return (Firmware)new OpenBsdFirmware();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Baseboard createBaseboard() {
/* 79 */     return (Baseboard)new UnixBaseboard(this.manufacturer.get(), this.model.get(), this.serialNumber.get(), 
/* 80 */         OpenBsdSysctlUtil.sysctl("hw.product", "unknown"));
/*    */   }
/*    */   
/*    */   private static String queryManufacturer() {
/* 84 */     return OpenBsdSysctlUtil.sysctl("hw.vendor", "unknown");
/*    */   }
/*    */   
/*    */   private static String queryModel() {
/* 88 */     return OpenBsdSysctlUtil.sysctl("hw.version", "unknown");
/*    */   }
/*    */   
/*    */   private static String querySerialNumber() {
/* 92 */     return OpenBsdSysctlUtil.sysctl("hw.serialno", "unknown");
/*    */   }
/*    */   
/*    */   private static String queryUUID() {
/* 96 */     return OpenBsdSysctlUtil.sysctl("hw.uuid", "unknown");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */