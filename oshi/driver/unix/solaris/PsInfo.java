/*     */ package oshi.driver.unix.solaris;
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
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.unix.solaris.SolarisLibc;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Pair;
/*     */ import oshi.util.tuples.Quartet;
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
/*  60 */   private static final Logger LOG = LoggerFactory.getLogger(PsInfo.class);
/*     */   
/*  62 */   private static final boolean IS_LITTLE_ENDIAN = "little".equals(System.getProperty("sun.cpu.endian"));
/*     */   
/*  64 */   private static final SolarisLibc LIBC = SolarisLibc.INSTANCE;
/*     */   
/*  66 */   private static final long PAGE_SIZE = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("pagesize"), 4096L);
/*     */   
/*     */   enum LwpsInfoT
/*     */   {
/*  70 */     PR_FLAG(4),
/*  71 */     PR_LWPID(4),
/*  72 */     PR_ADDR(Native.POINTER_SIZE),
/*  73 */     PR_WCHAN(Native.POINTER_SIZE),
/*  74 */     PR_STYPE(1),
/*  75 */     PR_STATE(1),
/*  76 */     PR_SNAME(1),
/*  77 */     PR_NICE(1),
/*  78 */     PR_SYSCALL(2),
/*  79 */     PR_OLDPRI(1),
/*  80 */     PR_CPU(1),
/*  81 */     PR_PRI(4),
/*  82 */     PR_PCTCPU(2),
/*  83 */     PAD(2),
/*  84 */     PR_START(2 * NativeLong.SIZE),
/*  85 */     PR_TIME(2 * NativeLong.SIZE),
/*  86 */     PR_CLNAME(8),
/*  87 */     PR_NAME(16),
/*  88 */     PR_ONPRO(4),
/*  89 */     PR_BINDPRO(4),
/*  90 */     PR_BINDPSET(4),
/*  91 */     PR_LGRP(4),
/*  92 */     PR_LAST_ONPROC(8),
/*  93 */     SIZE(0);
/*     */     
/*     */     private int size;
/*     */     
/*     */     LwpsInfoT(int param1Int1) {
/*  98 */       this.size = param1Int1;
/*     */     }
/*     */     
/*     */     public int size() {
/* 102 */       return this.size;
/*     */     }
/*     */   }
/*     */   
/* 106 */   private static Map<LwpsInfoT, Integer> lwpsInfoOffsets = initLwpsOffsets();
/*     */   
/*     */   enum PsInfoT {
/* 109 */     PR_FLAG(4),
/* 110 */     PR_NLWP(4),
/* 111 */     PR_NZOMB(4),
/* 112 */     PR_PID(4),
/* 113 */     PR_PPID(4),
/* 114 */     PR_PGID(4),
/* 115 */     PR_SID(4),
/* 116 */     PR_UID(4),
/* 117 */     PR_EUID(4),
/* 118 */     PR_GID(4),
/* 119 */     PR_EGID(4),
/* 120 */     PAD1(Native.POINTER_SIZE - 4),
/* 121 */     PR_ADDR(Native.POINTER_SIZE),
/* 122 */     PR_SIZE(Native.SIZE_T_SIZE),
/* 123 */     PR_RSSIZE(Native.SIZE_T_SIZE),
/* 124 */     PR_TTYDEV(NativeLong.SIZE),
/* 125 */     PR_PCTCPU(2),
/* 126 */     PR_PCTMEM(2),
/* 127 */     PAD2(Native.POINTER_SIZE - 4),
/* 128 */     PR_START(2 * NativeLong.SIZE),
/* 129 */     PR_TIME(2 * NativeLong.SIZE),
/* 130 */     PR_CTIME(2 * NativeLong.SIZE),
/* 131 */     PR_FNAME(16),
/* 132 */     PR_PSARGS(80),
/* 133 */     PR_WSTAT(4),
/* 134 */     PR_ARGC(4),
/* 135 */     PR_ARGV(Native.POINTER_SIZE),
/* 136 */     PR_ENVP(Native.POINTER_SIZE),
/* 137 */     PR_DMODEL(1),
/* 138 */     PAD3(7),
/* 139 */     PR_LWP(((Integer)PsInfo.lwpsInfoOffsets.get(PsInfo.LwpsInfoT.SIZE)).intValue()),
/* 140 */     PR_TASKID(4),
/* 141 */     PR_PROJID(4),
/* 142 */     PR_POOLID(4),
/* 143 */     PR_ZONEID(4),
/* 144 */     PR_CONTRACT(4),
/* 145 */     SIZE(0);
/*     */     
/*     */     private int size;
/*     */     
/*     */     PsInfoT(int param1Int1) {
/* 150 */       this.size = param1Int1;
/*     */     }
/*     */     
/*     */     public int size() {
/* 154 */       return this.size;
/*     */     }
/*     */   }
/*     */   
/* 158 */   private static Map<PsInfoT, Integer> psInfoOffsets = initPsOffsets();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<LwpsInfoT, Integer> initLwpsOffsets() {
/* 164 */     EnumMap<LwpsInfoT, Object> enumMap = new EnumMap<>(LwpsInfoT.class);
/* 165 */     int i = 0;
/* 166 */     for (LwpsInfoT lwpsInfoT : LwpsInfoT.values()) {
/* 167 */       enumMap.put(lwpsInfoT, Integer.valueOf(i));
/* 168 */       i += lwpsInfoT.size;
/*     */     } 
/* 170 */     return (Map)enumMap;
/*     */   }
/*     */   
/*     */   private static Map<PsInfoT, Integer> initPsOffsets() {
/* 174 */     EnumMap<PsInfoT, Object> enumMap = new EnumMap<>(PsInfoT.class);
/* 175 */     int i = 0;
/* 176 */     for (PsInfoT psInfoT : PsInfoT.values()) {
/* 177 */       enumMap.put(psInfoT, Integer.valueOf(i));
/* 178 */       i += psInfoT.size;
/*     */     } 
/* 180 */     return (Map)enumMap;
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
/*     */   public static Quartet<Integer, Long, Long, Byte> queryArgsEnvAddrs(int paramInt) {
/* 193 */     File file = new File("/proc/" + paramInt + "/psinfo"); 
/* 194 */     try { RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r"); 
/* 195 */       try { FileChannel fileChannel = randomAccessFile.getChannel(); 
/* 196 */         try { ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); 
/* 197 */           try { int i = ((Integer)psInfoOffsets.get(PsInfoT.SIZE)).intValue();
/* 198 */             if (i > fileChannel.size()) {
/* 199 */               i = (int)fileChannel.size();
/*     */             }
/*     */             
/* 202 */             ByteBuffer byteBuffer = ByteBuffer.allocate(i);
/* 203 */             if (fileChannel.read(byteBuffer) > ((Integer)psInfoOffsets.get(PsInfoT.PR_DMODEL)).intValue())
/*     */             
/* 205 */             { if (IS_LITTLE_ENDIAN) {
/* 206 */                 byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
/*     */               }
/*     */               
/* 209 */               int j = byteBuffer.getInt(((Integer)psInfoOffsets.get(PsInfoT.PR_ARGC)).intValue());
/*     */               
/* 211 */               if (j > 0)
/*     */               
/* 213 */               { long l1 = (Native.POINTER_SIZE == 8) ? byteBuffer.getLong(((Integer)psInfoOffsets.get(PsInfoT.PR_ARGV)).intValue()) : byteBuffer.getInt(((Integer)psInfoOffsets.get(PsInfoT.PR_ARGV)).intValue());
/*     */                 
/* 215 */                 long l2 = (Native.POINTER_SIZE == 8) ? byteBuffer.getLong(((Integer)psInfoOffsets.get(PsInfoT.PR_ENVP)).intValue()) : byteBuffer.getInt(((Integer)psInfoOffsets.get(PsInfoT.PR_ENVP)).intValue());
/*     */                 
/* 217 */                 byte b = byteBuffer.get(((Integer)psInfoOffsets.get(PsInfoT.PR_DMODEL)).intValue());
/*     */                 
/* 219 */                 if ((b * 4) != (l2 - l1) / (j + 1))
/* 220 */                 { LOG.trace("Failed data model and offset increment sanity check: dm={} diff={}", Byte.valueOf(b), 
/* 221 */                       Long.valueOf(l2 - l1));
/* 222 */                   Quartet quartet1 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 228 */                   byteArrayOutputStream.close(); if (fileChannel != null) fileChannel.close();  randomAccessFile.close(); return quartet1; }  Quartet<Integer, Long, Long, Byte> quartet = new Quartet(Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Byte.valueOf(b)); byteArrayOutputStream.close(); if (fileChannel != null) fileChannel.close();  randomAccessFile.close(); return quartet; }  LOG.trace("No permission to read file: {} ", file); }  byteArrayOutputStream.close(); } catch (Throwable throwable) { try { byteArrayOutputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  if (fileChannel != null) fileChannel.close();  } catch (Throwable throwable) { if (fileChannel != null) try { fileChannel.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  randomAccessFile.close(); } catch (Throwable throwable) { try { randomAccessFile.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (IOException iOException)
/* 229 */     { LOG.debug("Failed to read file: {} ", file); }
/*     */     
/* 231 */     return null;
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
/* 243 */     ArrayList<String> arrayList = new ArrayList();
/* 244 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */ 
/*     */     
/* 247 */     Quartet<Integer, Long, Long, Byte> quartet = queryArgsEnvAddrs(paramInt);
/* 248 */     if (quartet != null) {
/*     */       
/* 250 */       String str = "/proc/" + paramInt + "/as";
/* 251 */       int i = LIBC.open(str, 0);
/* 252 */       if (i < 0) {
/* 253 */         LOG.trace("No permission to read file: {} ", str);
/* 254 */         return new Pair(arrayList, linkedHashMap);
/*     */       } 
/*     */       
/*     */       try {
/* 258 */         int j = ((Integer)quartet.getA()).intValue();
/* 259 */         long l1 = ((Long)quartet.getB()).longValue();
/* 260 */         long l2 = ((Long)quartet.getC()).longValue();
/* 261 */         long l3 = ((Byte)quartet.getD()).byteValue() * 4L;
/*     */ 
/*     */         
/* 264 */         long l4 = 0L;
/* 265 */         Memory memory = new Memory(PAGE_SIZE * 2L);
/* 266 */         LibCAPI.size_t size_t = new LibCAPI.size_t(memory.size());
/*     */ 
/*     */ 
/*     */         
/* 270 */         long[] arrayOfLong = new long[j];
/* 271 */         long l5 = l1;
/* 272 */         for (byte b1 = 0; b1 < j; b1++) {
/* 273 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, l5);
/* 274 */           arrayOfLong[b1] = (l4 == 0L) ? 0L : getOffsetFromBuffer(memory, l5 - l4, l3);
/* 275 */           l5 += l3;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 280 */         ArrayList<Long> arrayList1 = new ArrayList();
/* 281 */         l5 = l2;
/* 282 */         long l6 = 0L;
/* 283 */         char c = 'Ǵ';
/*     */         do {
/* 285 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, l5);
/* 286 */           l6 = (l4 == 0L) ? 0L : getOffsetFromBuffer(memory, l5 - l4, l3);
/* 287 */           if (l6 != 0L) {
/* 288 */             arrayList1.add(Long.valueOf(l6));
/*     */           }
/* 290 */           l5 += l3;
/* 291 */         } while (l6 != 0L && --c > '\000');
/*     */ 
/*     */         
/* 294 */         for (byte b2 = 0; b2 < arrayOfLong.length && arrayOfLong[b2] != 0L; b2++) {
/* 295 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, arrayOfLong[b2]);
/* 296 */           if (l4 != 0L) {
/* 297 */             String str1 = memory.getString(arrayOfLong[b2] - l4);
/* 298 */             if (!str1.isEmpty()) {
/* 299 */               arrayList.add(str1);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 305 */         for (Long long_ : arrayList1) {
/* 306 */           l4 = conditionallyReadBufferFromStartOfPage(i, memory, size_t, l4, long_.longValue());
/* 307 */           if (l4 != 0L) {
/* 308 */             String str1 = memory.getString(long_.longValue() - l4);
/* 309 */             int k = str1.indexOf('=');
/* 310 */             if (k > 0) {
/* 311 */               linkedHashMap.put(str1.substring(0, k), str1.substring(k + 1));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } finally {
/* 316 */         LIBC.close(i);
/*     */       } 
/*     */     } 
/* 319 */     return new Pair(arrayList, linkedHashMap);
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
/* 342 */     if (paramLong2 < paramLong1 || paramLong2 - paramLong1 > PAGE_SIZE) {
/* 343 */       long l = Math.floorDiv(paramLong2, PAGE_SIZE) * PAGE_SIZE;
/* 344 */       LibCAPI.ssize_t ssize_t = LIBC.pread(paramInt, (Pointer)paramMemory, paramsize_t, new NativeLong(l));
/*     */       
/* 346 */       if (ssize_t.longValue() < PAGE_SIZE) {
/* 347 */         LOG.debug("Failed to read page from address space: {} bytes read", Long.valueOf(ssize_t.longValue()));
/* 348 */         return 0L;
/*     */       } 
/* 350 */       return l;
/*     */     } 
/* 352 */     return paramLong1;
/*     */   }
/*     */   
/*     */   private static long getOffsetFromBuffer(Memory paramMemory, long paramLong1, long paramLong2) {
/* 356 */     return (paramLong2 == 8L) ? paramMemory.getLong(paramLong1) : paramMemory.getInt(paramLong1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\solaris\PsInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */