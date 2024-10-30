/*    */ package oshi.hardware.platform.unix.solaris;
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
/*    */ final class SolarisFirmware
/*    */   extends AbstractFirmware
/*    */ {
/*    */   private final String manufacturer;
/*    */   private final String version;
/*    */   private final String releaseDate;
/*    */   
/*    */   SolarisFirmware(String paramString1, String paramString2, String paramString3) {
/* 40 */     this.manufacturer = paramString1;
/* 41 */     this.version = paramString2;
/* 42 */     this.releaseDate = paramString3;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 47 */     return this.manufacturer;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 52 */     return this.version;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getReleaseDate() {
/* 57 */     return this.releaseDate;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */