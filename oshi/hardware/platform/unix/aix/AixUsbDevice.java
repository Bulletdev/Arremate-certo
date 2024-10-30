/*    */ package oshi.hardware.platform.unix.aix;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.UsbDevice;
/*    */ import oshi.hardware.common.AbstractUsbDevice;
/*    */ import oshi.util.ParseUtil;
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
/*    */ public class AixUsbDevice
/*    */   extends AbstractUsbDevice
/*    */ {
/*    */   public AixUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/* 46 */     super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramList);
/*    */   }
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
/*    */   public static List<UsbDevice> getUsbDevices(boolean paramBoolean, Supplier<List<String>> paramSupplier) {
/* 67 */     ArrayList<AixUsbDevice> arrayList = new ArrayList();
/* 68 */     for (String str1 : paramSupplier.get()) {
/* 69 */       String str2 = str1.trim();
/* 70 */       if (str2.startsWith("usb")) {
/* 71 */         String[] arrayOfString = ParseUtil.whitespaces.split(str2, 3);
/* 72 */         if (arrayOfString.length == 3) {
/* 73 */           arrayList.add(new AixUsbDevice(arrayOfString[2], "unknown", "unknown", "unknown", "unknown", arrayOfString[0], 
/* 74 */                 Collections.emptyList()));
/*    */         }
/*    */       } 
/*    */     } 
/* 78 */     if (paramBoolean) {
/* 79 */       return Arrays.asList(new UsbDevice[] { (UsbDevice)new AixUsbDevice("USB Controller", "", "0000", "0000", "", "", (List)arrayList) });
/*    */     }
/* 81 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */