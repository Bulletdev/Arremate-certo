/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.DefaultTypeMapper;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.TypeConverter;
/*    */ import com.sun.jna.platform.EnumConverter;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Dxva2
/*    */   extends HighLevelMonitorConfigurationAPI, LowLevelMonitorConfigurationAPI, PhysicalMonitorEnumerationAPI, StdCallLibrary
/*    */ {
/* 51 */   public static final Map<String, Object> DXVA_OPTIONS = Collections.unmodifiableMap(new HashMap<String, Object>()
/*    */       {
/*    */         private static final long serialVersionUID = -1987971664975780480L;
/*    */       });
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
/* 69 */   public static final Dxva2 INSTANCE = (Dxva2)Native.load("Dxva2", Dxva2.class, DXVA_OPTIONS);
/*    */   
/*    */   WinDef.BOOL GetMonitorCapabilities(WinNT.HANDLE paramHANDLE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2);
/*    */   
/*    */   WinDef.BOOL SaveCurrentMonitorSettings(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.BOOL GetMonitorTechnologyType(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_DISPLAY_TECHNOLOGY_TYPE.ByReference paramByReference);
/*    */   
/*    */   WinDef.BOOL GetMonitorBrightness(WinNT.HANDLE paramHANDLE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3);
/*    */   
/*    */   WinDef.BOOL GetMonitorContrast(WinNT.HANDLE paramHANDLE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3);
/*    */   
/*    */   WinDef.BOOL GetMonitorColorTemperature(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE.ByReference paramByReference);
/*    */   
/*    */   WinDef.BOOL GetMonitorRedGreenOrBlueDrive(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_DRIVE_TYPE paramMC_DRIVE_TYPE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3);
/*    */   
/*    */   WinDef.BOOL GetMonitorRedGreenOrBlueGain(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_GAIN_TYPE paramMC_GAIN_TYPE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3);
/*    */   
/*    */   WinDef.BOOL SetMonitorBrightness(WinNT.HANDLE paramHANDLE, int paramInt);
/*    */   
/*    */   WinDef.BOOL SetMonitorContrast(WinNT.HANDLE paramHANDLE, int paramInt);
/*    */   
/*    */   WinDef.BOOL SetMonitorColorTemperature(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_COLOR_TEMPERATURE paramMC_COLOR_TEMPERATURE);
/*    */   
/*    */   WinDef.BOOL SetMonitorRedGreenOrBlueDrive(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_DRIVE_TYPE paramMC_DRIVE_TYPE, int paramInt);
/*    */   
/*    */   WinDef.BOOL SetMonitorRedGreenOrBlueGain(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_GAIN_TYPE paramMC_GAIN_TYPE, int paramInt);
/*    */   
/*    */   WinDef.BOOL DegaussMonitor(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.BOOL GetMonitorDisplayAreaSize(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_SIZE_TYPE paramMC_SIZE_TYPE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3);
/*    */   
/*    */   WinDef.BOOL GetMonitorDisplayAreaPosition(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_POSITION_TYPE paramMC_POSITION_TYPE, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3);
/*    */   
/*    */   WinDef.BOOL SetMonitorDisplayAreaSize(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_SIZE_TYPE paramMC_SIZE_TYPE, int paramInt);
/*    */   
/*    */   WinDef.BOOL SetMonitorDisplayAreaPosition(WinNT.HANDLE paramHANDLE, HighLevelMonitorConfigurationAPI.MC_POSITION_TYPE paramMC_POSITION_TYPE, int paramInt);
/*    */   
/*    */   WinDef.BOOL RestoreMonitorFactoryColorDefaults(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.BOOL RestoreMonitorFactoryDefaults(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.BOOL GetVCPFeatureAndVCPFeatureReply(WinNT.HANDLE paramHANDLE, WinDef.BYTE paramBYTE, LowLevelMonitorConfigurationAPI.MC_VCP_CODE_TYPE.ByReference paramByReference, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2);
/*    */   
/*    */   WinDef.BOOL SetVCPFeature(WinNT.HANDLE paramHANDLE, WinDef.BYTE paramBYTE, WinDef.DWORD paramDWORD);
/*    */   
/*    */   WinDef.BOOL SaveCurrentSettings(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.BOOL GetCapabilitiesStringLength(WinNT.HANDLE paramHANDLE, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   WinDef.BOOL CapabilitiesRequestAndCapabilitiesReply(WinNT.HANDLE paramHANDLE, WTypes.LPSTR paramLPSTR, WinDef.DWORD paramDWORD);
/*    */   
/*    */   WinDef.BOOL GetTimingReport(WinNT.HANDLE paramHANDLE, LowLevelMonitorConfigurationAPI.MC_TIMING_REPORT paramMC_TIMING_REPORT);
/*    */   
/*    */   WinDef.BOOL GetNumberOfPhysicalMonitorsFromHMONITOR(WinUser.HMONITOR paramHMONITOR, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   WinDef.BOOL GetPhysicalMonitorsFromHMONITOR(WinUser.HMONITOR paramHMONITOR, int paramInt, PhysicalMonitorEnumerationAPI.PHYSICAL_MONITOR[] paramArrayOfPHYSICAL_MONITOR);
/*    */   
/*    */   WinDef.BOOL DestroyPhysicalMonitor(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.BOOL DestroyPhysicalMonitors(int paramInt, PhysicalMonitorEnumerationAPI.PHYSICAL_MONITOR[] paramArrayOfPHYSICAL_MONITOR);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Dxva2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */