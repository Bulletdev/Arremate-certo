/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.Baseboard;
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
/*    */ public abstract class AbstractBaseboard
/*    */   implements Baseboard
/*    */ {
/*    */   public String toString() {
/* 37 */     StringBuilder stringBuilder = new StringBuilder();
/* 38 */     stringBuilder.append("manufacturer=").append(getManufacturer()).append(", ");
/* 39 */     stringBuilder.append("model=").append(getModel()).append(", ");
/* 40 */     stringBuilder.append("version=").append(getVersion()).append(", ");
/* 41 */     stringBuilder.append("serial number=").append(getSerialNumber());
/* 42 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractBaseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */