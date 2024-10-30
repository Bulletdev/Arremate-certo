/*    */ package oshi.hardware;@ThreadSafe
/*    */ public interface PowerSource { String getName();
/*    */   String getDeviceName();
/*    */   double getRemainingCapacityPercent();
/*    */   double getTimeRemainingEstimated();
/*    */   
/*    */   double getTimeRemainingInstant();
/*    */   
/*    */   double getPowerUsageRate();
/*    */   
/*    */   double getVoltage();
/*    */   
/*    */   double getAmperage();
/*    */   
/*    */   boolean isPowerOnLine();
/*    */   
/*    */   boolean isCharging();
/*    */   
/*    */   boolean isDischarging();
/*    */   
/*    */   CapacityUnits getCapacityUnits();
/*    */   
/*    */   int getCurrentCapacity();
/*    */   
/*    */   int getMaxCapacity();
/*    */   
/*    */   int getDesignCapacity();
/*    */   
/*    */   int getCycleCount();
/*    */   
/*    */   String getChemistry();
/*    */   
/*    */   LocalDate getManufactureDate();
/*    */   
/*    */   String getManufacturer();
/*    */   
/*    */   String getSerialNumber();
/*    */   
/*    */   double getTemperature();
/*    */   
/*    */   boolean updateAttributes();
/*    */   
/* 43 */   public enum CapacityUnits { MWH,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 48 */     MAH,
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 55 */     RELATIVE; }
/*    */    }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\PowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */