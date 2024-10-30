/*     */ package oshi.hardware.platform.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*     */ import java.time.LocalDate;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.common.AbstractPowerSource;
/*     */ import oshi.util.platform.unix.solaris.KstatUtil;
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
/*     */ public final class SolarisPowerSource
/*     */   extends AbstractPowerSource
/*     */ {
/*  46 */   private static final String[] KSTAT_BATT_MOD = new String[] { null, "battery", "acpi_drv" };
/*     */   
/*     */   private static final int KSTAT_BATT_IDX;
/*     */   
/*     */   static {
/*  51 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); try {
/*  52 */       if (KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[1], 0, null) != null) {
/*  53 */         KSTAT_BATT_IDX = 1;
/*  54 */       } else if (KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[2], 0, null) != null) {
/*  55 */         KSTAT_BATT_IDX = 2;
/*     */       } else {
/*  57 */         KSTAT_BATT_IDX = 0;
/*     */       } 
/*  59 */       if (kstatChain != null) kstatChain.close(); 
/*     */     } catch (Throwable throwable) {
/*     */       if (kstatChain != null)
/*     */         try {
/*     */           kstatChain.close();
/*     */         } catch (Throwable throwable1) {
/*     */           throwable.addSuppressed(throwable1);
/*     */         }  
/*     */       throw throwable;
/*  68 */     }  } public SolarisPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) { super(paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramBoolean1, paramBoolean2, paramBoolean3, paramCapacityUnits, paramInt1, paramInt2, paramInt3, paramInt4, paramString3, paramLocalDate, paramString4, paramString5, paramDouble7); }
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
/*  80 */     return Arrays.asList(new PowerSource[] { (PowerSource)getPowerSource("BAT0") });
/*     */   }
/*     */   
/*     */   private static SolarisPowerSource getPowerSource(String paramString) {
/*  84 */     String str1 = paramString;
/*  85 */     String str2 = "unknown";
/*  86 */     double d1 = 1.0D;
/*  87 */     double d2 = -1.0D;
/*  88 */     double d3 = 0.0D;
/*  89 */     double d4 = 0.0D;
/*  90 */     double d5 = -1.0D;
/*  91 */     double d6 = 0.0D;
/*  92 */     boolean bool1 = false;
/*  93 */     boolean bool2 = false;
/*  94 */     boolean bool3 = false;
/*  95 */     PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
/*  96 */     int i = 0;
/*  97 */     int j = 1;
/*  98 */     boolean bool4 = true;
/*  99 */     byte b = -1;
/* 100 */     String str3 = "unknown";
/* 101 */     LocalDate localDate = null;
/* 102 */     String str4 = "unknown";
/* 103 */     String str5 = "unknown";
/* 104 */     double d7 = 0.0D;
/*     */ 
/*     */     
/* 107 */     if (KSTAT_BATT_IDX > 0) {
/*     */       
/* 109 */       KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 110 */       try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[KSTAT_BATT_IDX], 0, "battery BIF0");
/* 111 */         if (kstat != null) {
/*     */           
/* 113 */           long l1 = KstatUtil.dataLookupLong(kstat, "bif_last_cap");
/* 114 */           if (l1 == -1L || l1 <= 0L) {
/* 115 */             l1 = KstatUtil.dataLookupLong(kstat, "bif_design_cap");
/*     */           }
/* 117 */           if (l1 != -1L && l1 > 0L) {
/* 118 */             j = (int)l1;
/*     */           }
/* 120 */           long l2 = KstatUtil.dataLookupLong(kstat, "bif_unit");
/* 121 */           if (l2 == 0L) {
/* 122 */             capacityUnits = PowerSource.CapacityUnits.MWH;
/* 123 */           } else if (l2 == 1L) {
/* 124 */             capacityUnits = PowerSource.CapacityUnits.MAH;
/*     */           } 
/* 126 */           str2 = KstatUtil.dataLookupString(kstat, "bif_model");
/* 127 */           str5 = KstatUtil.dataLookupString(kstat, "bif_serial");
/* 128 */           str3 = KstatUtil.dataLookupString(kstat, "bif_type");
/* 129 */           str4 = KstatUtil.dataLookupString(kstat, "bif_oem_info");
/*     */         } 
/*     */ 
/*     */         
/* 133 */         kstat = KstatUtil.KstatChain.lookup(KSTAT_BATT_MOD[KSTAT_BATT_IDX], 0, "battery BST0");
/* 134 */         if (kstat != null) {
/*     */           
/* 136 */           long l1 = KstatUtil.dataLookupLong(kstat, "bst_rem_cap");
/* 137 */           if (l1 >= 0L) {
/* 138 */             i = (int)l1;
/*     */           }
/*     */           
/* 141 */           long l2 = KstatUtil.dataLookupLong(kstat, "bst_rate");
/* 142 */           if (l2 == -1L) {
/* 143 */             l2 = 0L;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 149 */           boolean bool = ((KstatUtil.dataLookupLong(kstat, "bst_state") & 0x10L) > 0L) ? true : false;
/*     */           
/* 151 */           if (!bool) {
/* 152 */             d2 = (l2 > 0L) ? (3600.0D * l1 / l2) : -1.0D;
/*     */           }
/*     */           
/* 155 */           long l3 = KstatUtil.dataLookupLong(kstat, "bst_voltage");
/* 156 */           if (l3 > 0L) {
/* 157 */             d5 = l3 / 1000.0D;
/* 158 */             d6 = d4 * 1000.0D / l3;
/*     */           } 
/*     */         } 
/* 161 */         if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/*     */           try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }
/*     */     
/* 164 */     }  return new SolarisPowerSource(str1, str2, d1, d2, d3, d4, d5, d6, bool1, bool2, bool3, capacityUnits, i, j, bool4, b, str3, localDate, str4, str5, d7);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */