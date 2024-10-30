/*     */ package oshi;
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
/*     */ public enum PlatformEnum
/*     */ {
/*  34 */   MACOS("macOS"),
/*     */ 
/*     */ 
/*     */   
/*  38 */   LINUX("Linux"),
/*     */ 
/*     */ 
/*     */   
/*  42 */   WINDOWS("Windows"),
/*     */ 
/*     */ 
/*     */   
/*  46 */   SOLARIS("Solaris"),
/*     */ 
/*     */ 
/*     */   
/*  50 */   FREEBSD("FreeBSD"),
/*     */ 
/*     */ 
/*     */   
/*  54 */   OPENBSD("OpenBSD"),
/*     */ 
/*     */ 
/*     */   
/*  58 */   WINDOWSCE("Windows CE"),
/*     */ 
/*     */ 
/*     */   
/*  62 */   AIX("AIX"),
/*     */ 
/*     */ 
/*     */   
/*  66 */   ANDROID("Android"),
/*     */ 
/*     */ 
/*     */   
/*  70 */   GNU("GNU"),
/*     */ 
/*     */ 
/*     */   
/*  74 */   KFREEBSD("kFreeBSD"),
/*     */ 
/*     */ 
/*     */   
/*  78 */   NETBSD("NetBSD"),
/*     */ 
/*     */ 
/*     */   
/*  82 */   UNKNOWN("Unknown"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   MACOSX("macOS");
/*     */   
/*     */   private String name;
/*     */ 
/*     */   
/*     */   PlatformEnum(String paramString1) {
/*  94 */     this.name = paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 103 */     return this.name;
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
/*     */   public static String getName(int paramInt) {
/* 115 */     return getValue(paramInt).getName();
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
/*     */   public static PlatformEnum getValue(int paramInt) {
/* 127 */     if (paramInt < 0 || paramInt >= UNKNOWN.ordinal()) {
/* 128 */       return UNKNOWN;
/*     */     }
/* 130 */     return values()[paramInt];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\PlatformEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */