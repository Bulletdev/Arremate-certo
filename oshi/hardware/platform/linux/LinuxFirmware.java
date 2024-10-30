/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.time.format.DateTimeParseException;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.driver.linux.Dmidecode;
/*     */ import oshi.driver.linux.Sysfs;
/*     */ import oshi.hardware.common.AbstractFirmware;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ final class LinuxFirmware
/*     */   extends AbstractFirmware
/*     */ {
/*  49 */   private static final DateTimeFormatter VCGEN_FORMATTER = DateTimeFormatter.ofPattern("MMM d uuuu HH:mm:ss", Locale.ENGLISH);
/*     */ 
/*     */   
/*  52 */   private final Supplier<String> manufacturer = Memoizer.memoize(this::queryManufacturer);
/*     */   
/*  54 */   private final Supplier<String> description = Memoizer.memoize(this::queryDescription);
/*     */   
/*  56 */   private final Supplier<String> version = Memoizer.memoize(this::queryVersion);
/*     */   
/*  58 */   private final Supplier<String> releaseDate = Memoizer.memoize(this::queryReleaseDate);
/*     */   
/*  60 */   private final Supplier<String> name = Memoizer.memoize(this::queryName);
/*     */   
/*  62 */   private final Supplier<VcGenCmdStrings> vcGenCmd = Memoizer.memoize(LinuxFirmware::queryVcGenCmd);
/*     */   
/*  64 */   private final Supplier<Pair<String, String>> biosNameRev = Memoizer.memoize(Dmidecode::queryBiosNameRev);
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  68 */     return this.manufacturer.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  73 */     return this.description.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  78 */     return this.version.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getReleaseDate() {
/*  83 */     return this.releaseDate.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  88 */     return this.name.get();
/*     */   }
/*     */   
/*     */   private String queryManufacturer() {
/*  92 */     String str = null;
/*  93 */     if ((str = Sysfs.queryBiosVendor()) == null && (str = (this.vcGenCmd.get()).manufacturer) == null) {
/*  94 */       return "unknown";
/*     */     }
/*  96 */     return str;
/*     */   }
/*     */   
/*     */   private String queryDescription() {
/* 100 */     String str = null;
/* 101 */     if ((str = Sysfs.queryBiosDescription()) == null && (str = (this.vcGenCmd.get()).description) == null) {
/* 102 */       return "unknown";
/*     */     }
/* 104 */     return str;
/*     */   }
/*     */   
/*     */   private String queryVersion() {
/* 108 */     String str = null;
/* 109 */     if ((str = Sysfs.queryBiosVersion((String)((Pair)this.biosNameRev.get()).getB())) == null && (
/* 110 */       str = (this.vcGenCmd.get()).version) == null) {
/* 111 */       return "unknown";
/*     */     }
/* 113 */     return str;
/*     */   }
/*     */   
/*     */   private String queryReleaseDate() {
/* 117 */     String str = null;
/* 118 */     if ((str = Sysfs.queryBiosReleaseDate()) == null && (str = (this.vcGenCmd.get()).releaseDate) == null) {
/* 119 */       return "unknown";
/*     */     }
/* 121 */     return str;
/*     */   }
/*     */   
/*     */   private String queryName() {
/* 125 */     String str = null;
/* 126 */     if ((str = (String)((Pair)this.biosNameRev.get()).getA()) == null && (str = (this.vcGenCmd.get()).name) == null) {
/* 127 */       return "unknown";
/*     */     }
/* 129 */     return str;
/*     */   }
/*     */   
/*     */   private static VcGenCmdStrings queryVcGenCmd() {
/* 133 */     String str1 = null;
/* 134 */     String str2 = null;
/* 135 */     String str3 = null;
/*     */     
/* 137 */     List<CharSequence> list = ExecutingCommand.runNative("vcgencmd version");
/* 138 */     if (list.size() >= 3) {
/*     */       
/*     */       try {
/* 141 */         str1 = DateTimeFormatter.ISO_LOCAL_DATE.format(VCGEN_FORMATTER.parse(list.get(0)));
/* 142 */       } catch (DateTimeParseException dateTimeParseException) {
/* 143 */         str1 = "unknown";
/*     */       } 
/*     */       
/* 146 */       String[] arrayOfString = ParseUtil.whitespaces.split(list.get(1));
/* 147 */       str2 = arrayOfString[arrayOfString.length - 1];
/*     */       
/* 149 */       str3 = ((String)list.get(2)).replace("version ", "");
/* 150 */       return new VcGenCmdStrings(str1, str2, str3, "RPi", "Bootloader");
/*     */     } 
/* 152 */     return new VcGenCmdStrings(null, null, null, null, null);
/*     */   }
/*     */   
/*     */   private static final class VcGenCmdStrings
/*     */   {
/*     */     private final String releaseDate;
/*     */     private final String manufacturer;
/*     */     private final String version;
/*     */     private final String name;
/*     */     private final String description;
/*     */     
/*     */     private VcGenCmdStrings(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
/* 164 */       this.releaseDate = param1String1;
/* 165 */       this.manufacturer = param1String2;
/* 166 */       this.version = param1String3;
/* 167 */       this.name = param1String4;
/* 168 */       this.description = param1String5;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */