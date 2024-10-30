/*     */ package oshi.util.platform.unix.openbsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.unix.openbsd.OpenBsdLibc;
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
/*     */ @ThreadSafe
/*     */ public final class OpenBsdSysctlUtil
/*     */ {
/*     */   private static final String SYSCTL_N = "sysctl -n ";
/*  48 */   private static final Logger LOG = LoggerFactory.getLogger(OpenBsdSysctlUtil.class);
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
/*     */   public static int sysctl(int[] paramArrayOfint, int paramInt) {
/*  65 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(OpenBsdLibc.INT_SIZE));
/*  66 */     Memory memory = new Memory(byReference.longValue());
/*  67 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/*  68 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/*  69 */       return paramInt;
/*     */     } 
/*  71 */     return memory.getInt(0L);
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
/*     */   public static long sysctl(int[] paramArrayOfint, long paramLong) {
/*  84 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(OpenBsdLibc.UINT64_SIZE));
/*  85 */     Memory memory = new Memory(byReference.longValue());
/*  86 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/*  87 */       LOG.warn("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/*  88 */       return paramLong;
/*     */     } 
/*  90 */     return memory.getLong(0L);
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
/*     */   public static String sysctl(int[] paramArrayOfint, String paramString) {
/* 104 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
/* 105 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, null, byReference, null, LibCAPI.size_t.ZERO)) {
/* 106 */       LOG.warn("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/* 107 */       return paramString;
/*     */     } 
/*     */     
/* 110 */     Memory memory = new Memory(byReference.longValue() + 1L);
/* 111 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 112 */       LOG.warn("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/* 113 */       return paramString;
/*     */     } 
/* 115 */     return memory.getString(0L);
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
/*     */   public static boolean sysctl(int[] paramArrayOfint, Structure paramStructure) {
/* 128 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, paramStructure.getPointer(), new LibCAPI.size_t.ByReference(new LibCAPI.size_t(paramStructure
/* 129 */             .size())), null, LibCAPI.size_t.ZERO)) {
/* 130 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/* 131 */       return false;
/*     */     } 
/* 133 */     paramStructure.read();
/* 134 */     return true;
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
/*     */   public static Memory sysctl(int[] paramArrayOfint) {
/* 146 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
/* 147 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, null, byReference, null, LibCAPI.size_t.ZERO)) {
/* 148 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/* 149 */       return null;
/*     */     } 
/* 151 */     Memory memory = new Memory(byReference.longValue());
/* 152 */     if (0 != OpenBsdLibc.INSTANCE.sysctl(paramArrayOfint, paramArrayOfint.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 153 */       LOG.error("Failed sysctl call: {}, Error code: {}", paramArrayOfint, Integer.valueOf(Native.getLastError()));
/* 154 */       return null;
/*     */     } 
/* 156 */     return memory;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static int sysctl(String paramString, int paramInt) {
/* 173 */     return ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("sysctl -n " + paramString), paramInt);
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
/* 186 */     return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("sysctl -n " + paramString), paramLong);
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
/*     */   public static String sysctl(String paramString1, String paramString2) {
/* 199 */     String str = ExecutingCommand.getFirstAnswer("sysctl -n " + paramString1);
/* 200 */     if (null == str || str.isEmpty()) {
/* 201 */       return paramString2;
/*     */     }
/* 203 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platfor\\unix\openbsd\OpenBsdSysctlUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */