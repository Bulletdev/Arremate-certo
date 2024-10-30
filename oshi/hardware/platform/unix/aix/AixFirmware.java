/*    */ package oshi.hardware.platform.unix.aix;
/*    */ 
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.common.AbstractFirmware;
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
/*    */ final class AixFirmware
/*    */   extends AbstractFirmware
/*    */ {
/*    */   private final String manufacturer;
/*    */   private final String name;
/*    */   private final String version;
/*    */   
/*    */   AixFirmware(String paramString1, String paramString2, String paramString3) {
/* 40 */     this.manufacturer = paramString1;
/* 41 */     this.name = paramString2;
/* 42 */     this.version = paramString3;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 47 */     return this.manufacturer;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 52 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 57 */     return this.version;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */