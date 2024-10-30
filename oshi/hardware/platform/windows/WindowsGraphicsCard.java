/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.driver.windows.wmi.Win32VideoController;
/*     */ import oshi.hardware.GraphicsCard;
/*     */ import oshi.hardware.common.AbstractGraphicsCard;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.platform.windows.WmiUtil;
/*     */ import oshi.util.tuples.Triplet;
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
/*     */ final class WindowsGraphicsCard
/*     */   extends AbstractGraphicsCard
/*     */ {
/*  49 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
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
/*     */   WindowsGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  66 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<GraphicsCard> getGraphicsCards() {
/*  78 */     ArrayList<WindowsGraphicsCard> arrayList = new ArrayList();
/*  79 */     if (IS_VISTA_OR_GREATER) {
/*  80 */       WbemcliUtil.WmiResult wmiResult = Win32VideoController.queryVideoController();
/*  81 */       for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/*  82 */         String str1 = WmiUtil.getString(wmiResult, (Enum)Win32VideoController.VideoControllerProperty.NAME, b);
/*  83 */         Triplet triplet = ParseUtil.parseDeviceIdToVendorProductSerial(
/*  84 */             WmiUtil.getString(wmiResult, (Enum)Win32VideoController.VideoControllerProperty.PNPDEVICEID, b));
/*  85 */         String str2 = (triplet == null) ? "unknown" : (String)triplet.getB();
/*  86 */         String str3 = WmiUtil.getString(wmiResult, (Enum)Win32VideoController.VideoControllerProperty.ADAPTERCOMPATIBILITY, b);
/*  87 */         if (triplet != null) {
/*  88 */           if (Util.isBlank(str3)) {
/*  89 */             str2 = (String)triplet.getA();
/*     */           } else {
/*  91 */             str3 = str3 + " (" + (String)triplet.getA() + ")";
/*     */           } 
/*     */         }
/*  94 */         String str4 = WmiUtil.getString(wmiResult, (Enum)Win32VideoController.VideoControllerProperty.DRIVERVERSION, b);
/*  95 */         if (!Util.isBlank(str4)) {
/*  96 */           str4 = "DriverVersion=" + str4;
/*     */         } else {
/*  98 */           str4 = "unknown";
/*     */         } 
/* 100 */         long l = WmiUtil.getUint32asLong(wmiResult, (Enum)Win32VideoController.VideoControllerProperty.ADAPTERRAM, b);
/* 101 */         arrayList.add(new WindowsGraphicsCard(Util.isBlank(str1) ? "unknown" : str1, str2, 
/* 102 */               Util.isBlank(str3) ? "unknown" : str3, str4, l));
/*     */       } 
/*     */     } 
/* 105 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */