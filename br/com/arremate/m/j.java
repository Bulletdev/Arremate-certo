/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.SystemInfo;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.GlobalMemory;
/*     */ import oshi.hardware.HardwareAbstractionLayer;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.FormatUtil;
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
/*     */ public class j
/*     */ {
/*     */   private final String ez;
/*     */   private final String eA;
/*     */   private final long S;
/*     */   private final String eB;
/*     */   private double q;
/*     */   
/*     */   public j() throws Exception {
/*  52 */     SystemInfo systemInfo = new SystemInfo();
/*  53 */     HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
/*     */     
/*  55 */     OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
/*  56 */     this.ez = String.join(" ", new CharSequence[] { operatingSystem.getFamily(), operatingSystem.getVersionInfo().getVersion(), operatingSystem.getVersionInfo().getCodeName() });
/*     */     
/*  58 */     CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();
/*  59 */     this.eA = centralProcessor.getProcessorIdentifier().getName();
/*     */     
/*  61 */     GlobalMemory globalMemory = hardwareAbstractionLayer.getMemory();
/*  62 */     this.S = globalMemory.getTotal();
/*     */     
/*  64 */     this.eB = System.getProperty("java.version");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bC() throws Exception {
/*  74 */     return b(null);
/*     */   }
/*     */   
/*     */   public boolean b(e.a parama) throws Exception {
/*  78 */     return e.a().a(paramDouble -> {
/*     */           this.q = paramDouble.doubleValue();
/*     */           if (parama != null) {
/*     */             parama.getInternetSpeed(paramDouble);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOperatingSystem() {
/*  92 */     return this.ez;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ct() {
/* 101 */     return this.eA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cu() {
/* 110 */     return String.join(" ", new CharSequence[] { FormatUtil.formatBytes(this.S), "Utilizável" });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cv() {
/* 119 */     return this.eB;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cw() {
/* 128 */     DecimalFormat decimalFormat = new DecimalFormat("#.## mb");
/* 129 */     return decimalFormat.format(this.q);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bD() {
/* 138 */     String str = getOperatingSystem().toLowerCase();
/* 139 */     return (str.contains("windows 8.1") || str
/* 140 */       .contains("windows 10") || str
/* 141 */       .contains("windows 11") || str
/* 142 */       .contains("macosx ") || 
/* 143 */       bE());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bE() {
/* 152 */     String str = getOperatingSystem().toLowerCase();
/* 153 */     return (str.contains("windows 10") || str
/* 154 */       .contains("windows 11") || str
/* 155 */       .contains("macos "));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bF() {
/* 164 */     return j(5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bG() {
/* 173 */     return j(7);
/*     */   }
/*     */   
/*     */   private boolean j(int paramInt) {
/* 177 */     String str = ct().toLowerCase();
/*     */     
/* 179 */     if (str.contains("i5") || str.contains("i9") || str.contains("i7")) {
/* 180 */       int i = 0;
/*     */       
/* 182 */       if (str.contains("cpu")) {
/* 183 */         str = str.substring(str.indexOf("i5") + 3, str.indexOf("cpu"));
/* 184 */         str = str.replaceAll("\\D", "");
/*     */         
/* 186 */         if (str.length() <= 4) {
/* 187 */           i = Integer.parseInt(str.substring(0, 1));
/*     */         } else {
/* 189 */           i = Integer.parseInt(str.substring(0, 2));
/*     */         } 
/*     */       } else {
/* 192 */         Pattern pattern = Pattern.compile("\\b(\\d+)(st|nd|rd|th)\\b");
/* 193 */         Matcher matcher = pattern.matcher(str);
/*     */         
/* 195 */         if (matcher.find()) {
/* 196 */           String str1 = matcher.group(1);
/* 197 */           i = Integer.parseInt(str1);
/*     */         } 
/*     */       } 
/*     */       
/* 201 */       return (i >= paramInt);
/*     */     } 
/*     */     
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bH() {
/* 213 */     BigInteger bigInteger = new BigInteger("8053063680");
/* 214 */     return (this.S >= bigInteger.longValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bI() {
/* 223 */     BigInteger bigInteger = new BigInteger("3758096384");
/* 224 */     return (this.S >= bigInteger.longValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bJ() {
/* 233 */     double d = Double.parseDouble(cv().substring(0, 3));
/* 234 */     int i = Integer.parseInt(cv().split("_")[1]);
/*     */     
/* 236 */     return (d == 1.8D && i > 212);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bK() {
/* 245 */     return (cv().contains("1.8") || bJ());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bL() {
/* 254 */     return (this.q >= 10.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bM() {
/* 263 */     return (this.q >= 5.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWindows() {
/* 272 */     return getOperatingSystem().toLowerCase().contains("windows");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIntel() {
/* 281 */     return ct().toLowerCase().contains("intel");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bN() {
/* 290 */     return (bF() && bM() && bI() && bD() && bK());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bO() {
/* 299 */     return (bG() && bL() && bH() && bE() && bJ());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */