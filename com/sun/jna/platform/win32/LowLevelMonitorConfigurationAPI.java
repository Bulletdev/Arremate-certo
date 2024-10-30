/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.platform.EnumUtils;
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
/*     */ public interface LowLevelMonitorConfigurationAPI
/*     */ {
/*     */   @FieldOrder({"dwHorizontalFrequencyInHZ", "dwVerticalFrequencyInHZ", "bTimingStatusByte"})
/*     */   public static class MC_TIMING_REPORT
/*     */     extends Structure
/*     */   {
/*     */     public WinDef.DWORD dwHorizontalFrequencyInHZ;
/*     */     public WinDef.DWORD dwVerticalFrequencyInHZ;
/*     */     public WinDef.BYTE bTimingStatusByte;
/*     */   }
/*     */   
/*     */   public enum MC_VCP_CODE_TYPE
/*     */   {
/*  71 */     MC_MOMENTARY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     MC_SET_PARAMETER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends com.sun.jna.ptr.ByReference
/*     */     {
/*     */       public ByReference() {
/*  87 */         super(4);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference(LowLevelMonitorConfigurationAPI.MC_VCP_CODE_TYPE param2MC_VCP_CODE_TYPE) {
/*  95 */         super(4);
/*  96 */         setValue(param2MC_VCP_CODE_TYPE);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setValue(LowLevelMonitorConfigurationAPI.MC_VCP_CODE_TYPE param2MC_VCP_CODE_TYPE) {
/* 104 */         getPointer().setInt(0L, EnumUtils.toInteger(param2MC_VCP_CODE_TYPE));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public LowLevelMonitorConfigurationAPI.MC_VCP_CODE_TYPE getValue() {
/* 112 */         return (LowLevelMonitorConfigurationAPI.MC_VCP_CODE_TYPE)EnumUtils.fromInteger(getPointer().getInt(0L), LowLevelMonitorConfigurationAPI.MC_VCP_CODE_TYPE.class);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\LowLevelMonitorConfigurationAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */