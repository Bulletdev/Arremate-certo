/*     */ package oshi.hardware.platform.unix.freebsd;
/*     */ 
/*     */ import java.time.LocalDate;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.common.AbstractPowerSource;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*     */ @ThreadSafe
/*     */ public final class FreeBsdPowerSource
/*     */   extends AbstractPowerSource
/*     */ {
/*     */   public FreeBsdPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) {
/*  52 */     super(paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramBoolean1, paramBoolean2, paramBoolean3, paramCapacityUnits, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramLocalDate, paramString4, paramString5, paramDouble7);
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
/*     */   public static List<PowerSource> getPowerSources() {
/*  64 */     return Arrays.asList(new PowerSource[] { (PowerSource)getPowerSource("BAT0") });
/*     */   }
/*     */   
/*     */   private static FreeBsdPowerSource getPowerSource(String paramString) {
/*  68 */     String str1 = paramString;
/*  69 */     double d1 = 1.0D;
/*  70 */     double d2 = -1.0D;
/*  71 */     double d3 = 0.0D;
/*  72 */     int i = -1;
/*  73 */     double d4 = 0.0D;
/*  74 */     boolean bool1 = false;
/*  75 */     boolean bool2 = false;
/*  76 */     boolean bool3 = false;
/*  77 */     PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
/*  78 */     boolean bool4 = false;
/*  79 */     int j = 1;
/*  80 */     int k = 1;
/*  81 */     byte b = -1;
/*  82 */     LocalDate localDate = null;
/*     */     
/*  84 */     double d5 = 0.0D;
/*     */ 
/*     */     
/*  87 */     int m = BsdSysctlUtil.sysctl("hw.acpi.battery.state", 0);
/*  88 */     if (m == 2) {
/*  89 */       bool2 = true;
/*     */     } else {
/*  91 */       int i1 = BsdSysctlUtil.sysctl("hw.acpi.battery.time", -1);
/*     */       
/*  93 */       d2 = (i1 < 0) ? -1.0D : (60.0D * i1);
/*  94 */       if (m == 1) {
/*  95 */         bool3 = true;
/*     */       }
/*     */     } 
/*     */     
/*  99 */     int n = BsdSysctlUtil.sysctl("hw.acpi.battery.life", -1);
/* 100 */     if (n > 0) {
/* 101 */       d1 = n / 100.0D;
/*     */     }
/* 103 */     List list = ExecutingCommand.runNative("acpiconf -i 0");
/* 104 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 105 */     for (String str : list) {
/* 106 */       String[] arrayOfString = str.split(":", 2);
/* 107 */       if (arrayOfString.length > 1) {
/* 108 */         String str10 = arrayOfString[1].trim();
/* 109 */         if (!str10.isEmpty()) {
/* 110 */           hashMap.put(arrayOfString[0], str10);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     String str2 = (String)hashMap.getOrDefault("Model number", "unknown");
/* 116 */     String str3 = (String)hashMap.getOrDefault("Serial number", "unknown");
/* 117 */     String str4 = (String)hashMap.getOrDefault("Type", "unknown");
/* 118 */     String str5 = (String)hashMap.getOrDefault("OEM info", "unknown");
/* 119 */     String str6 = (String)hashMap.get("Design capacity");
/* 120 */     if (str6 != null) {
/* 121 */       k = ParseUtil.getFirstIntValue(str6);
/* 122 */       if (str6.toLowerCase().contains("mah")) {
/* 123 */         capacityUnits = PowerSource.CapacityUnits.MAH;
/* 124 */       } else if (str6.toLowerCase().contains("mwh")) {
/* 125 */         capacityUnits = PowerSource.CapacityUnits.MWH;
/*     */       } 
/*     */     } 
/* 128 */     str6 = (String)hashMap.get("Last full capacity");
/* 129 */     if (str6 != null) {
/* 130 */       j = ParseUtil.getFirstIntValue(str6);
/*     */     } else {
/* 132 */       j = k;
/*     */     } 
/* 134 */     double d6 = d2;
/* 135 */     String str7 = (String)hashMap.get("Remaining time");
/* 136 */     if (str7 != null) {
/* 137 */       String[] arrayOfString = str7.split(":");
/* 138 */       if (arrayOfString.length == 2)
/*     */       {
/* 140 */         d6 = 3600.0D * ParseUtil.parseIntOrDefault(arrayOfString[0], 0) + 60.0D * ParseUtil.parseIntOrDefault(arrayOfString[1], 0);
/*     */       }
/*     */     } 
/* 143 */     String str8 = (String)hashMap.get("Present rate");
/* 144 */     if (str8 != null) {
/* 145 */       d3 = ParseUtil.getFirstIntValue(str8);
/*     */     }
/* 147 */     String str9 = (String)hashMap.get("Present voltage");
/* 148 */     if (str9 != null) {
/* 149 */       i = ParseUtil.getFirstIntValue(str9);
/* 150 */       if (i != 0) {
/* 151 */         d4 = d3 / i;
/*     */       }
/*     */     } 
/*     */     
/* 155 */     return new FreeBsdPowerSource(str1, str2, d1, d2, d6, d3, i, d4, bool1, bool2, bool3, capacityUnits, bool4, j, k, b, str4, localDate, str5, str3, d5);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */