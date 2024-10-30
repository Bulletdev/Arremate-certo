/*     */ package oshi.driver.unix.aix;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.NativeLong;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.unix.aix.AixLibc;
/*     */ import oshi.util.tuples.Pair;
/*     */ import oshi.util.tuples.Triplet;
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
/*     */ public final class PsInfo
/*     */ {
/*  57 */   private static final Logger LOG = LoggerFactory.getLogger(PsInfo.class);
/*     */   
/*  59 */   private static final AixLibc LIBC = AixLibc.INSTANCE;
/*     */   
/*     */   private static final long PAGE_SIZE = 4096L;
/*     */ 
/*     */   
/*     */   enum LwpsInfoT
/*     */   {
/*  66 */     PR_LWPID(8),
/*  67 */     PR_ADDR(8),
/*  68 */     PR_WCHAN(8),
/*  69 */     PR_FLAG(4),
/*  70 */     PR_WTYPE(1),
/*  71 */     PR_STATE(1),
/*  72 */     PR_SNAME(1),
/*  73 */     PR_NICE(1),
/*  74 */     PR_PRI(4),
/*  75 */     PR_POLICY(4),
/*  76 */     PR_CLNAME(8),
/*  77 */     PR_ONPRO(Native.POINTER_SIZE),
/*  78 */     PR_BINDPRO(Native.POINTER_SIZE),
/*  79 */     SIZE(0);
/*     */     
/*     */     private int size;
/*     */     
/*     */     LwpsInfoT(int param1Int1) {
/*  84 */       this.size = param1Int1;
/*     */     }
/*     */     
/*     */     public int size() {
/*  88 */       return this.size;
/*     */     }
/*     */   }
/*     */   
/*  92 */   private static Map<LwpsInfoT, Integer> lwpsInfoOffsets = initLwpsOffsets();
/*     */   
/*     */   enum PsInfoT {
/*  95 */     PR_FLAG(4),
/*  96 */     PR_FLAG2(4),
/*  97 */     PR_NLWP(4),
/*  98 */     PR_PAD1(4),
/*  99 */     PR_UID(8),
/* 100 */     PR_EUID(8),
/* 101 */     PR_GID(8),
/* 102 */     PR_EGID(8),
/* 103 */     PR_PID(8),
/* 104 */     PR_PPID(8),
/* 105 */     PR_PGID(8),
/* 106 */     PR_SID(8),
/* 107 */     PR_TTYDEV(8),
/* 108 */     PR_ADDR(8),
/* 109 */     PR_SIZE(8),
/* 110 */     PR_RSSIZE(8),
/* 111 */     PR_START(16),
/* 112 */     PR_TIME(16),
/* 113 */     PR_CID(2),
/* 114 */     PR_PAD2(2),
/* 115 */     PR_ARGC(4),
/* 116 */     PR_ARGV(8),
/* 117 */     PR_ENVP(8),
/* 118 */     PR_FNAME(16),
/* 119 */     PR_PSARGS(80),
/* 120 */     PR_PAD(64),
/* 121 */     PR_LWP(((Integer)PsInfo.lwpsInfoOffsets.get(PsInfo.LwpsInfoT.SIZE)).intValue()),
/* 122 */     SIZE(0);
/*     */     
/*     */     private int size;
/*     */     
/*     */     PsInfoT(int param1Int1) {
/* 127 */       this.size = param1Int1;
/*     */     }
/*     */     
/*     */     public int size() {
/* 131 */       return this.size;
/*     */     }
/*     */   }
/*     */   
/* 135 */   private static Map<PsInfoT, Integer> psInfoOffsets = initPsOffsets();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<LwpsInfoT, Integer> initLwpsOffsets() {
/* 141 */     EnumMap<LwpsInfoT, Object> enumMap = new EnumMap<>(LwpsInfoT.class);
/* 142 */     int i = 0;
/* 143 */     for (LwpsInfoT lwpsInfoT : LwpsInfoT.values()) {
/* 144 */       enumMap.put(lwpsInfoT, Integer.valueOf(i));
/* 145 */       i += lwpsInfoT.size;
/*     */     } 
/* 147 */     return (Map)enumMap;
/*     */   }
/*     */   
/*     */   private static Map<PsInfoT, Integer> initPsOffsets() {
/* 151 */     EnumMap<PsInfoT, Object> enumMap = new EnumMap<>(PsInfoT.class);
/* 152 */     int i = 0;
/* 153 */     for (PsInfoT psInfoT : PsInfoT.values()) {
/* 154 */       enumMap.put(psInfoT, Integer.valueOf(i));
/* 155 */       i += psInfoT.size;
/*     */     } 
/* 157 */     return (Map)enumMap;
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
/*     */   public static Triplet<Integer, Long, Long> queryArgsEnvAddrs(int paramInt) {
/* 169 */     File file = new File("/proc/" + paramInt + "/psinfo"); 
/* 170 */     try { RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r"); 
/* 171 */       try { FileChannel fileChannel = randomAccessFile.getChannel(); 
/* 172 */         try { ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); 
/* 173 */           try { int i = ((Integer)psInfoOffsets.get(PsInfoT.SIZE)).intValue();
/* 174 */             if (i > fileChannel.size()) {
/* 175 */               i = (int)fileChannel.size();
/*     */             }
/*     */             
/* 178 */             ByteBuffer byteBuffer = ByteBuffer.allocate(i);
/* 179 */             if (fileChannel.read(byteBuffer) >= ((Integer)psInfoOffsets.get(PsInfoT.PR_FNAME)).intValue())
/*     */             
/*     */             { 
/* 182 */               int j = byteBuffer.getInt(((Integer)psInfoOffsets.get(PsInfoT.PR_ARGC)).intValue());
/* 183 */               long l1 = byteBuffer.getLong(((Integer)psInfoOffsets.get(PsInfoT.PR_ARGV)).intValue());
/* 184 */               long l2 = byteBuffer.getLong(((Integer)psInfoOffsets.get(PsInfoT.PR_ENVP)).intValue());
/* 185 */               Triplet<Integer, Long, Long> triplet = new Triplet(Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2));
/*     */               
/* 187 */               byteArrayOutputStream.close(); if (fileChannel != null) fileChannel.close();  randomAccessFile.close(); return triplet; }  byteArrayOutputStream.close(); } catch (Throwable throwable) { try { byteArrayOutputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  if (fileChannel != null) fileChannel.close();  } catch (Throwable throwable) { if (fileChannel != null) try { fileChannel.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  randomAccessFile.close(); } catch (Throwable throwable) { try { randomAccessFile.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (IOException iOException)
/* 188 */     { LOG.debug("Failed to read file: {} ", file); }
/*     */     
/* 190 */     return null;
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
/*     */   public static Pair<List<String>, Map<String, String>> queryArgsEnv(int paramInt) {
/* 202 */     ArrayList<String> arrayList = new ArrayList();
/* 203 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */ 
/*     */     
/* 206 */     Triplet<Integer, Long, Long> triplet = queryArgsEnvAddrs(paramInt);
/* 207 */     if (triplet != null) {
/*     */       
/* 209 */       String str = "/proc/" + paramInt + "/as";
/* 210 */       int i = LIBC.open(str, 0);
/* 211 */       if (i < 0) {
/* 212 */         LOG.trace("No permission to read file: {} ", str);
/* 213 */         return new Pair(arrayList, linkedHashMap);
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 218 */         int j = ((Integer)triplet.getA()).intValue();
/* 219 */         long l1 = ((Long)triplet.getB()).longValue();
/* 220 */         long l2 = ((Long)triplet.getC()).longValue();
/*     */ 
/*     */ 
/*     */         
/* 224 */         long l3 = (l2 - l1) / (j + 1);
/*     */ 
/*     */         
/* 227 */         long l4 = 0L;
/* 228 */         Memory memory = new Memory(8192L);
/* 229 */         LibCAPI.size_t size_t = new LibCAPI.size_t(memory.size());
/*     */ 
/*     */ 
/*     */         
/* 233 */         long[] arrayOfLong = new long[j];
/* 234 */         long l5 = l1;
/* 235 */         for (byte b1 = 0; b1 < j; b1++) {
/* 236 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, l5);
/* 237 */           arrayOfLong[b1] = (l4 == 0L) ? 0L : getOffsetFromBuffer(memory, l5 - l4, l3);
/* 238 */           l5 += l3;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 243 */         ArrayList<Long> arrayList1 = new ArrayList();
/* 244 */         l5 = l2;
/* 245 */         long l6 = 0L;
/* 246 */         char c = 'Ǵ';
/*     */         do {
/* 248 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, l5);
/* 249 */           l6 = (l4 == 0L) ? 0L : getOffsetFromBuffer(memory, l5 - l4, l3);
/* 250 */           if (l6 != 0L) {
/* 251 */             arrayList1.add(Long.valueOf(l6));
/*     */           }
/* 253 */           l5 += l3;
/* 254 */         } while (l6 != 0L && --c > '\000');
/*     */ 
/*     */         
/* 257 */         for (byte b2 = 0; b2 < arrayOfLong.length && arrayOfLong[b2] != 0L; b2++) {
/* 258 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, arrayOfLong[b2]);
/* 259 */           if (l4 != 0L) {
/* 260 */             String str1 = memory.getString(arrayOfLong[b2] - l4);
/* 261 */             if (!str1.isEmpty()) {
/* 262 */               arrayList.add(str1);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 268 */         for (Long long_ : arrayList1) {
/* 269 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, long_.longValue());
/* 270 */           if (l4 != 0L) {
/* 271 */             String str1 = memory.getString(long_.longValue() - l4);
/* 272 */             int k = str1.indexOf('=');
/* 273 */             if (k > 0) {
/* 274 */               linkedHashMap.put(str1.substring(0, k), str1.substring(k + 1));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } finally {
/* 279 */         LIBC.close(i);
/*     */       } 
/*     */     } 
/* 282 */     return new Pair(arrayList, linkedHashMap);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long conditionallyReadBufferFromStartOfPage(int paramInt, Memory paramMemory, LibCAPI.size_t paramsize_t, long paramLong1, long paramLong2) {
/* 305 */     if (paramLong2 < paramLong1 || paramLong2 - paramLong1 > 4096L) {
/* 306 */       long l = Math.floorDiv(paramLong2, 4096L) * 4096L;
/* 307 */       LibCAPI.ssize_t ssize_t = LIBC.pread(paramInt, (Pointer)paramMemory, paramsize_t, new NativeLong(l));
/*     */       
/* 309 */       if (ssize_t.longValue() < 4096L) {
/* 310 */         LOG.debug("Failed to read page from address space: {} bytes read", Long.valueOf(ssize_t.longValue()));
/* 311 */         return 0L;
/*     */       } 
/* 313 */       return l;
/*     */     } 
/* 315 */     return paramLong1;
/*     */   }
/*     */   
/*     */   private static long getOffsetFromBuffer(Memory paramMemory, long paramLong1, long paramLong2) {
/* 319 */     return (paramLong2 == 8L) ? paramMemory.getLong(paramLong1) : paramMemory.getInt(paramLong1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\PsInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */