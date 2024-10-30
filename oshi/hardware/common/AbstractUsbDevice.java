/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.UsbDevice;
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
/*     */ public abstract class AbstractUsbDevice
/*     */   implements UsbDevice
/*     */ {
/*     */   private final String name;
/*     */   private final String vendor;
/*     */   private final String vendorId;
/*     */   private final String productId;
/*     */   private final String serialNumber;
/*     */   private final String uniqueDeviceId;
/*     */   private final List<UsbDevice> connectedDevices;
/*     */   
/*     */   protected AbstractUsbDevice(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<UsbDevice> paramList) {
/*  48 */     this.name = paramString1;
/*  49 */     this.vendor = paramString2;
/*  50 */     this.vendorId = paramString3;
/*  51 */     this.productId = paramString4;
/*  52 */     this.serialNumber = paramString5;
/*  53 */     this.uniqueDeviceId = paramString6;
/*  54 */     this.connectedDevices = Collections.unmodifiableList(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  59 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVendor() {
/*  64 */     return this.vendor;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVendorId() {
/*  69 */     return this.vendorId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getProductId() {
/*  74 */     return this.productId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  79 */     return this.serialNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUniqueDeviceId() {
/*  84 */     return this.uniqueDeviceId;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<UsbDevice> getConnectedDevices() {
/*  89 */     return this.connectedDevices;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(UsbDevice paramUsbDevice) {
/*  95 */     return getName().compareTo(paramUsbDevice.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     return indentUsb(this, 1);
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
/*     */   
/*     */   private static String indentUsb(UsbDevice paramUsbDevice, int paramInt) {
/* 113 */     String str = (paramInt > 4) ? String.format("%%%ds|-- ", new Object[] { Integer.valueOf(paramInt - 4) }) : String.format("%%%ds", new Object[] { Integer.valueOf(paramInt) });
/* 114 */     StringBuilder stringBuilder = new StringBuilder(String.format(str, new Object[] { "" }));
/* 115 */     stringBuilder.append(paramUsbDevice.getName());
/* 116 */     if (!paramUsbDevice.getVendor().isEmpty()) {
/* 117 */       stringBuilder.append(" (").append(paramUsbDevice.getVendor()).append(')');
/*     */     }
/* 119 */     if (!paramUsbDevice.getSerialNumber().isEmpty()) {
/* 120 */       stringBuilder.append(" [s/n: ").append(paramUsbDevice.getSerialNumber()).append(']');
/*     */     }
/* 122 */     for (UsbDevice usbDevice : paramUsbDevice.getConnectedDevices()) {
/* 123 */       stringBuilder.append('\n').append(indentUsb(usbDevice, paramInt + 4));
/*     */     }
/* 125 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractUsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */