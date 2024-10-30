/*    */ package oshi.hardware.platform.unix.aix;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.driver.unix.aix.Lscfg;
/*    */ import oshi.hardware.common.AbstractBaseboard;
/*    */ import oshi.util.Util;
/*    */ import oshi.util.tuples.Triplet;
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
/*    */ final class AixBaseboard
/*    */   extends AbstractBaseboard
/*    */ {
/*    */   private static final String IBM = "IBM";
/*    */   private final String model;
/*    */   private final String serialNumber;
/*    */   private final String version;
/*    */   
/*    */   AixBaseboard(Supplier<List<String>> paramSupplier) {
/* 48 */     Triplet triplet = Lscfg.queryBackplaneModelSerialVersion(paramSupplier.get());
/* 49 */     this.model = Util.isBlank((String)triplet.getA()) ? "unknown" : (String)triplet.getA();
/* 50 */     this.serialNumber = Util.isBlank((String)triplet.getB()) ? "unknown" : (String)triplet.getB();
/* 51 */     this.version = Util.isBlank((String)triplet.getC()) ? "unknown" : (String)triplet.getC();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 56 */     return "IBM";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModel() {
/* 61 */     return this.model;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSerialNumber() {
/* 66 */     return this.serialNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 71 */     return this.version;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixBaseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */