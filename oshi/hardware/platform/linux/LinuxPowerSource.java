/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.time.LocalDate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.common.AbstractPowerSource;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
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
/*     */ public final class LinuxPowerSource
/*     */   extends AbstractPowerSource
/*     */ {
/*     */   private static final String PS_PATH = "/sys/class/power_supply/";
/*     */   
/*     */   public LinuxPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) {
/*  54 */     super(paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramBoolean1, paramBoolean2, paramBoolean3, paramCapacityUnits, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramLocalDate, paramString4, paramString5, paramDouble7);
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
/*     */   
/*     */   public static List<PowerSource> getPowerSources() {
/*  68 */     double d1 = -1.0D;
/*  69 */     double d2 = -1.0D;
/*  70 */     double d3 = -1.0D;
/*  71 */     double d4 = 0.0D;
/*  72 */     double d5 = -1.0D;
/*  73 */     double d6 = 0.0D;
/*  74 */     boolean bool = false;
/*  75 */     boolean bool1 = false;
/*  76 */     boolean bool2 = false;
/*  77 */     PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
/*  78 */     int i = -1;
/*  79 */     int j = -1;
/*  80 */     byte b = -1;
/*  81 */     int k = -1;
/*     */     
/*  83 */     LocalDate localDate = null;
/*     */ 
/*     */     
/*  86 */     double d7 = 0.0D;
/*     */ 
/*     */     
/*  89 */     File file = new File("/sys/class/power_supply/");
/*  90 */     String[] arrayOfString = file.list();
/*  91 */     ArrayList<LinuxPowerSource> arrayList = new ArrayList();
/*     */     
/*  93 */     if (arrayOfString != null)
/*     */     {
/*  95 */       for (String str : arrayOfString) {
/*     */         
/*  97 */         if (!str.startsWith("ADP") && !str.startsWith("AC")) {
/*     */ 
/*     */           
/* 100 */           List list = FileUtil.readFile("/sys/class/power_supply/" + str + "/uevent", false);
/* 101 */           if (!list.isEmpty()) {
/*     */ 
/*     */             
/* 104 */             HashMap<Object, Object> hashMap = new HashMap<>();
/* 105 */             for (String str7 : list) {
/* 106 */               String[] arrayOfString1 = str7.split("=");
/* 107 */               if (arrayOfString1.length > 1 && !arrayOfString1[1].isEmpty()) {
/* 108 */                 hashMap.put(arrayOfString1[0], arrayOfString1[1]);
/*     */               }
/*     */             } 
/* 111 */             String str1 = (String)hashMap.getOrDefault("POWER_SUPPLY_NAME", str);
/* 112 */             String str6 = (String)hashMap.get("POWER_SUPPLY_STATUS");
/* 113 */             bool1 = "Charging".equals(str6);
/* 114 */             bool2 = "Discharging".equals(str6);
/* 115 */             if (hashMap.containsKey("POWER_SUPPLY_CAPACITY")) {
/* 116 */               d1 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CAPACITY"), -100) / 100.0D;
/*     */             }
/*     */             
/* 119 */             if (hashMap.containsKey("POWER_SUPPLY_ENERGY_NOW")) {
/* 120 */               i = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_ENERGY_NOW"), -1);
/* 121 */             } else if (hashMap.containsKey("POWER_SUPPLY_CHARGE_NOW")) {
/* 122 */               i = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CHARGE_NOW"), -1);
/*     */             } 
/* 124 */             if (hashMap.containsKey("POWER_SUPPLY_ENERGY_FULL")) {
/* 125 */               i = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_ENERGY_FULL"), 1);
/* 126 */             } else if (hashMap.containsKey("POWER_SUPPLY_CHARGE_FULL")) {
/* 127 */               i = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CHARGE_FULL"), 1);
/*     */             } 
/* 129 */             if (hashMap.containsKey("POWER_SUPPLY_ENERGY_FULL_DESIGN")) {
/* 130 */               j = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_ENERGY_FULL_DESIGN"), 1);
/* 131 */             } else if (hashMap.containsKey("POWER_SUPPLY_CHARGE_FULL_DESIGN")) {
/* 132 */               j = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CHARGE_FULL_DESIGN"), 1);
/*     */             } 
/* 134 */             if (hashMap.containsKey("POWER_SUPPLY_VOLTAGE_NOW")) {
/* 135 */               d5 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_VOLTAGE_NOW"), -1);
/*     */             }
/* 137 */             if (hashMap.containsKey("POWER_SUPPLY_POWER_NOW")) {
/* 138 */               d4 = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_POWER_NOW"), -1);
/*     */             }
/* 140 */             if (d5 > 0.0D) {
/* 141 */               d6 = d4 / d5;
/*     */             }
/* 143 */             if (hashMap.containsKey("POWER_SUPPLY_CYCLE_COUNT")) {
/* 144 */               k = ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_CYCLE_COUNT"), -1);
/*     */             }
/* 146 */             String str3 = (String)hashMap.getOrDefault("POWER_SUPPLY_TECHNOLOGY", "unknown");
/* 147 */             String str2 = (String)hashMap.getOrDefault("POWER_SUPPLY_MODEL_NAME", "unknown");
/* 148 */             String str4 = (String)hashMap.getOrDefault("POWER_SUPPLY_MANUFACTURER", "unknown");
/* 149 */             String str5 = (String)hashMap.getOrDefault("POWER_SUPPLY_SERIAL_NUMBER", "unknown");
/* 150 */             if (ParseUtil.parseIntOrDefault((String)hashMap.get("POWER_SUPPLY_PRESENT"), 1) > 0) {
/* 151 */               arrayList.add(new LinuxPowerSource(str1, str2, d1, d2, d3, d4, d5, d6, bool, bool1, bool2, capacityUnits, i, j, b, k, str3, localDate, str4, str5, d7));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 160 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */