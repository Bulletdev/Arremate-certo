/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.common.AbstractBaseboard;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.tuples.Quartet;
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
/*     */ final class MacBaseboard
/*     */   extends AbstractBaseboard
/*     */ {
/*  47 */   private final Supplier<Quartet<String, String, String, String>> manufModelVersSerial = Memoizer.memoize(MacBaseboard::queryPlatform);
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  52 */     return (String)((Quartet)this.manufModelVersSerial.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  57 */     return (String)((Quartet)this.manufModelVersSerial.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  62 */     return (String)((Quartet)this.manufModelVersSerial.get()).getC();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  67 */     return (String)((Quartet)this.manufModelVersSerial.get()).getD();
/*     */   }
/*     */   
/*     */   private static Quartet<String, String, String, String> queryPlatform() {
/*  71 */     String str1 = null;
/*  72 */     String str2 = null;
/*  73 */     String str3 = null;
/*  74 */     String str4 = null;
/*     */     
/*  76 */     IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
/*  77 */     if (iOService != null) {
/*  78 */       byte[] arrayOfByte = iOService.getByteArrayProperty("manufacturer");
/*  79 */       if (arrayOfByte != null) {
/*  80 */         str1 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/*  82 */       arrayOfByte = iOService.getByteArrayProperty("board-id");
/*  83 */       if (arrayOfByte != null) {
/*  84 */         str2 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/*  86 */       if (Util.isBlank(str2)) {
/*  87 */         arrayOfByte = iOService.getByteArrayProperty("model-number");
/*  88 */         if (arrayOfByte != null) {
/*  89 */           str2 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */         }
/*     */       } 
/*  92 */       arrayOfByte = iOService.getByteArrayProperty("version");
/*  93 */       if (arrayOfByte != null) {
/*  94 */         str3 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/*  96 */       arrayOfByte = iOService.getByteArrayProperty("mlb-serial-number");
/*  97 */       if (arrayOfByte != null) {
/*  98 */         str4 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/* 100 */       if (Util.isBlank(str4)) {
/* 101 */         str4 = iOService.getStringProperty("IOPlatformSerialNumber");
/*     */       }
/* 103 */       iOService.release();
/*     */     } 
/* 105 */     return new Quartet(Util.isBlank(str1) ? "Apple Inc." : str1, 
/* 106 */         Util.isBlank(str2) ? "unknown" : str2, Util.isBlank(str3) ? "unknown" : str3, 
/* 107 */         Util.isBlank(str4) ? "unknown" : str4);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacBaseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */