/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.time.LocalDate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.common.AbstractPowerSource;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ public final class OpenBsdPowerSource
/*     */   extends AbstractPowerSource
/*     */ {
/*     */   public OpenBsdPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) {
/*  51 */     super(paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramBoolean1, paramBoolean2, paramBoolean3, paramCapacityUnits, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramLocalDate, paramString4, paramString5, paramDouble7);
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
/*  63 */     HashSet<String> hashSet = new HashSet();
/*  64 */     for (String str : ExecutingCommand.runNative("systat -ab sensors")) {
/*  65 */       if (str.contains(".amphour") || str.contains(".watthour")) {
/*  66 */         int i = str.indexOf('.');
/*  67 */         hashSet.add(str.substring(0, i));
/*     */       } 
/*     */     } 
/*  70 */     ArrayList<OpenBsdPowerSource> arrayList = new ArrayList();
/*  71 */     for (String str : hashSet) {
/*  72 */       arrayList.add(getPowerSource(str));
/*     */     }
/*  74 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static OpenBsdPowerSource getPowerSource(String paramString) {
/*  78 */     String str1 = paramString.startsWith("acpi") ? paramString.substring(4) : paramString;
/*  79 */     double d1 = 1.0D;
/*  80 */     double d2 = -1.0D;
/*  81 */     double d3 = 0.0D;
/*  82 */     double d4 = -1.0D;
/*  83 */     double d5 = 0.0D;
/*  84 */     boolean bool1 = false;
/*  85 */     boolean bool2 = false;
/*  86 */     boolean bool3 = false;
/*  87 */     PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
/*  88 */     int i = 0;
/*  89 */     int j = 1;
/*  90 */     int k = 1;
/*  91 */     byte b = -1;
/*  92 */     LocalDate localDate = null;
/*     */     
/*  94 */     double d6 = 0.0D;
/*     */     
/*  96 */     for (String str : ExecutingCommand.runNative("systat -ab sensors")) {
/*  97 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*  98 */       if (arrayOfString.length > 1 && arrayOfString[0].startsWith(paramString)) {
/*  99 */         if (arrayOfString[0].contains("volt0") || (arrayOfString[0].contains("volt") && str.contains("current"))) {
/* 100 */           d4 = ParseUtil.parseDoubleOrDefault(arrayOfString[1], -1.0D); continue;
/* 101 */         }  if (arrayOfString[0].contains("current0")) {
/* 102 */           d5 = ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D); continue;
/* 103 */         }  if (arrayOfString[0].contains("temp0")) {
/* 104 */           d6 = ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D); continue;
/* 105 */         }  if (arrayOfString[0].contains("watthour") || arrayOfString[0].contains("amphour")) {
/* 106 */           capacityUnits = arrayOfString[0].contains("watthour") ? PowerSource.CapacityUnits.MWH : PowerSource.CapacityUnits.MAH;
/* 107 */           if (str.contains("remaining")) {
/* 108 */             i = (int)(1000.0D * ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D)); continue;
/* 109 */           }  if (str.contains("full")) {
/* 110 */             j = (int)(1000.0D * ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D)); continue;
/* 111 */           }  if (str.contains("new") || str.contains("design")) {
/* 112 */             k = (int)(1000.0D * ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 118 */     int m = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("apm -b"), 255);
/*     */     
/* 120 */     if (m < 4) {
/* 121 */       bool1 = true;
/* 122 */       if (m == 3) {
/* 123 */         bool2 = true;
/*     */       } else {
/* 125 */         int i1 = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("apm -m"), -1);
/*     */         
/* 127 */         d2 = (i1 < 0) ? -1.0D : (60.0D * i1);
/* 128 */         bool3 = true;
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     int n = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("apm -l"), -1);
/* 133 */     if (n > 0) {
/* 134 */       d1 = n / 100.0D;
/*     */     }
/* 136 */     if (j < k && j < i) {
/* 137 */       j = k;
/* 138 */     } else if (k < j && k < i) {
/* 139 */       k = j;
/*     */     } 
/*     */     
/* 142 */     String str2 = "unknown";
/* 143 */     String str3 = "unknown";
/* 144 */     String str4 = "unknown";
/* 145 */     String str5 = "unknown";
/*     */     
/* 147 */     double d7 = d2;
/* 148 */     if (d4 > 0.0D) {
/* 149 */       if (d5 > 0.0D && d3 == 0.0D) {
/* 150 */         d3 = d5 * d4;
/* 151 */       } else if (d5 == 0.0D && d3 > 0.0D) {
/* 152 */         d5 = d3 / d4;
/*     */       } 
/*     */     }
/*     */     
/* 156 */     return new OpenBsdPowerSource(str1, str2, d1, d2, d7, d3, d4, d5, bool1, bool2, bool3, capacityUnits, i, j, k, b, str4, localDate, str5, str3, d6);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */