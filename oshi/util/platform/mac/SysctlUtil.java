/*     */ package oshi.util.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.mac.SystemB;
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
/*     */ public final class SysctlUtil
/*     */ {
/*  44 */   private static final Logger LOG = LoggerFactory.getLogger(SysctlUtil.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String SYSCTL_FAIL = "Failed sysctl call: {}, Error code: {}";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int sysctl(String paramString, int paramInt) {
/*  61 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(SystemB.INT_SIZE);
/*  62 */     Memory memory = new Memory(byReference.longValue());
/*  63 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/*  64 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString, Integer.valueOf(Native.getLastError()));
/*  65 */       return paramInt;
/*     */     } 
/*  67 */     return memory.getInt(0L);
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
/*     */   public static long sysctl(String paramString, long paramLong) {
/*  80 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(SystemB.UINT64_SIZE);
/*  81 */     Memory memory = new Memory(byReference.longValue());
/*  82 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/*  83 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString, Integer.valueOf(Native.getLastError()));
/*  84 */       return paramLong;
/*     */     } 
/*  86 */     return memory.getLong(0L);
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
/*     */   public static String sysctl(String paramString1, String paramString2) {
/* 100 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
/* 101 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString1, null, byReference, null, LibCAPI.size_t.ZERO)) {
/* 102 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString1, Integer.valueOf(Native.getLastError()));
/* 103 */       return paramString2;
/*     */     } 
/*     */     
/* 106 */     Memory memory = new Memory(byReference.longValue() + 1L);
/* 107 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString1, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 108 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString1, Integer.valueOf(Native.getLastError()));
/* 109 */       return paramString2;
/*     */     } 
/* 111 */     return memory.getString(0L);
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
/*     */   public static boolean sysctl(String paramString, Structure paramStructure) {
/* 124 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString, paramStructure.getPointer(), new LibCAPI.size_t.ByReference(paramStructure.size()), null, LibCAPI.size_t.ZERO)) {
/*     */       
/* 126 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString, Integer.valueOf(Native.getLastError()));
/* 127 */       return false;
/*     */     } 
/* 129 */     paramStructure.read();
/* 130 */     return true;
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
/*     */   public static Memory sysctl(String paramString) {
/* 142 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
/* 143 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString, null, byReference, null, LibCAPI.size_t.ZERO)) {
/* 144 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString, Integer.valueOf(Native.getLastError()));
/* 145 */       return null;
/*     */     } 
/* 147 */     Memory memory = new Memory(byReference.longValue());
/* 148 */     if (0 != SystemB.INSTANCE.sysctlbyname(paramString, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 149 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramString, Integer.valueOf(Native.getLastError()));
/* 150 */       return null;
/*     */     } 
/* 152 */     return memory;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\mac\SysctlUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */