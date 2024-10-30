/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.Advapi32;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.SetupApi;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.platform.win32.WinReg;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.Display;
/*     */ import oshi.hardware.common.AbstractDisplay;
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
/*     */ @Immutable
/*     */ final class WindowsDisplay
/*     */   extends AbstractDisplay
/*     */ {
/*  53 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsDisplay.class);
/*     */   
/*  55 */   private static final SetupApi SU = SetupApi.INSTANCE;
/*  56 */   private static final Advapi32 ADV = Advapi32.INSTANCE;
/*     */   
/*  58 */   private static final Guid.GUID GUID_DEVINTERFACE_MONITOR = new Guid.GUID("E6F07B5F-EE97-4a90-B076-33F57BF4EAA7");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WindowsDisplay(byte[] paramArrayOfbyte) {
/*  67 */     super(paramArrayOfbyte);
/*  68 */     LOG.debug("Initialized WindowsDisplay");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Display> getDisplays() {
/*  77 */     ArrayList<WindowsDisplay> arrayList = new ArrayList();
/*     */     
/*  79 */     WinNT.HANDLE hANDLE = SU.SetupDiGetClassDevs(GUID_DEVINTERFACE_MONITOR, null, null, 18);
/*     */     
/*  81 */     if (!hANDLE.equals(WinBase.INVALID_HANDLE_VALUE)) {
/*  82 */       SetupApi.SP_DEVICE_INTERFACE_DATA sP_DEVICE_INTERFACE_DATA = new SetupApi.SP_DEVICE_INTERFACE_DATA();
/*  83 */       sP_DEVICE_INTERFACE_DATA.cbSize = sP_DEVICE_INTERFACE_DATA.size();
/*     */ 
/*     */       
/*  86 */       SetupApi.SP_DEVINFO_DATA sP_DEVINFO_DATA = new SetupApi.SP_DEVINFO_DATA();
/*     */       
/*  88 */       for (byte b = 0; SU.SetupDiEnumDeviceInfo(hANDLE, b, sP_DEVINFO_DATA); b++) {
/*  89 */         WinReg.HKEY hKEY = SU.SetupDiOpenDevRegKey(hANDLE, sP_DEVINFO_DATA, 1, 0, 1, 1);
/*     */ 
/*     */         
/*  92 */         byte[] arrayOfByte = new byte[1];
/*     */         
/*  94 */         IntByReference intByReference1 = new IntByReference();
/*  95 */         IntByReference intByReference2 = new IntByReference();
/*     */         
/*  97 */         if (ADV.RegQueryValueEx(hKEY, "EDID", 0, intByReference1, arrayOfByte, intByReference2) == 234) {
/*  98 */           arrayOfByte = new byte[intByReference2.getValue()];
/*  99 */           if (ADV.RegQueryValueEx(hKEY, "EDID", 0, intByReference1, arrayOfByte, intByReference2) == 0) {
/* 100 */             WindowsDisplay windowsDisplay = new WindowsDisplay(arrayOfByte);
/* 101 */             arrayList.add(windowsDisplay);
/*     */           } 
/*     */         } 
/* 104 */         Advapi32.INSTANCE.RegCloseKey(hKEY);
/*     */       } 
/* 106 */       SU.SetupDiDestroyDeviceInfoList(hANDLE);
/*     */     } 
/* 108 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsDisplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */