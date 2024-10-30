/*    */ package oshi.hardware.platform.unix;
/*    */ 
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.common.AbstractBaseboard;
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
/*    */ public final class UnixBaseboard
/*    */   extends AbstractBaseboard
/*    */ {
/*    */   private final String manufacturer;
/*    */   private final String model;
/*    */   private final String serialNumber;
/*    */   private final String version;
/*    */   
/*    */   public UnixBaseboard(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 41 */     this.manufacturer = paramString1;
/* 42 */     this.model = paramString2;
/* 43 */     this.serialNumber = paramString3;
/* 44 */     this.version = paramString4;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 49 */     return this.manufacturer;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModel() {
/* 54 */     return this.model;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSerialNumber() {
/* 59 */     return this.serialNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 64 */     return this.version;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\UnixBaseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */