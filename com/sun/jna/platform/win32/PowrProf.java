/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
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
/*    */ public interface PowrProf
/*    */   extends Library
/*    */ {
/* 34 */   public static final PowrProf INSTANCE = (PowrProf)Native.load("PowrProf", PowrProf.class);
/*    */   
/*    */   int CallNtPowerInformation(int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, int paramInt3);
/*    */   
/*    */   public static interface POWER_INFORMATION_LEVEL {
/*    */     public static final int LastSleepTime = 15;
/*    */     public static final int LastWakeTime = 14;
/*    */     public static final int ProcessorInformation = 11;
/*    */     public static final int SystemBatteryState = 5;
/*    */     public static final int SystemExecutionState = 16;
/*    */     public static final int SystemPowerCapabilities = 4;
/*    */     public static final int SystemPowerInformation = 12;
/*    */     public static final int SystemPowerPolicyAc = 0;
/*    */     public static final int SystemPowerPolicyCurrent = 8;
/*    */     public static final int SystemPowerPolicyDc = 1;
/*    */     public static final int SystemReserveHiberFile = 10;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\PowrProf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */