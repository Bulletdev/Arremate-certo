/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.Firmware;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Immutable
/*    */ public abstract class AbstractFirmware
/*    */   implements Firmware
/*    */ {
/*    */   public String getName() {
/* 42 */     return "unknown";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 47 */     return "unknown";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getReleaseDate() {
/* 52 */     return "unknown";
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder stringBuilder = new StringBuilder();
/* 58 */     stringBuilder.append("manufacturer=").append(getManufacturer()).append(", ");
/* 59 */     stringBuilder.append("name=").append(getName()).append(", ");
/* 60 */     stringBuilder.append("description=").append(getDescription()).append(", ");
/* 61 */     stringBuilder.append("version=").append(getVersion()).append(", ");
/* 62 */     stringBuilder.append("release date=").append((getReleaseDate() == null) ? "unknown" : getReleaseDate());
/* 63 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */