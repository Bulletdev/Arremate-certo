/*    */ package oshi.hardware.platform.unix.openbsd;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.common.AbstractFirmware;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.Memoizer;
/*    */ import oshi.util.ParseUtil;
/*    */ import oshi.util.Util;
/*    */ import oshi.util.tuples.Triplet;
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
/*    */ public class OpenBsdFirmware
/*    */   extends AbstractFirmware
/*    */ {
/* 44 */   private final Supplier<Triplet<String, String, String>> manufVersRelease = Memoizer.memoize(OpenBsdFirmware::readDmesg);
/*    */ 
/*    */   
/*    */   public String getManufacturer() {
/* 48 */     return (String)((Triplet)this.manufVersRelease.get()).getA();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 53 */     return (String)((Triplet)this.manufVersRelease.get()).getB();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getReleaseDate() {
/* 58 */     return (String)((Triplet)this.manufVersRelease.get()).getC();
/*    */   }
/*    */   
/*    */   private static Triplet<String, String, String> readDmesg() {
/* 62 */     String str1 = null;
/* 63 */     String str2 = null;
/* 64 */     String str3 = "";
/*    */     
/* 66 */     List list = ExecutingCommand.runNative("dmesg");
/* 67 */     for (String str : list) {
/*    */ 
/*    */ 
/*    */       
/* 71 */       if (str.startsWith("bios0: vendor")) {
/* 72 */         str1 = ParseUtil.getStringBetween(str, '"');
/* 73 */         str3 = ParseUtil.parseMmDdYyyyToYyyyMmDD(ParseUtil.parseLastString(str));
/* 74 */         str2 = str.split("vendor")[1].trim();
/*    */       } 
/*    */     } 
/* 77 */     return new Triplet(Util.isBlank(str2) ? "unknown" : str2, 
/* 78 */         Util.isBlank(str1) ? "unknown" : str1, 
/* 79 */         Util.isBlank(str3) ? "unknown" : str3);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */