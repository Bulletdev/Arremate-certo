/*     */ package oshi.util.platform.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.FormatUtil;
/*     */ import oshi.util.Util;
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
/*     */ public final class KstatUtil
/*     */ {
/*  51 */   private static final Logger LOG = LoggerFactory.getLogger(KstatUtil.class);
/*     */   
/*  53 */   private static final LibKstat KS = LibKstat.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static final LibKstat.KstatCtl KC = KS.kstat_open();
/*  59 */   private static final ReentrantLock CHAIN = new ReentrantLock();
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
/*     */   public static final class KstatChain
/*     */     implements AutoCloseable
/*     */   {
/*     */     private KstatChain() {
/*  77 */       KstatUtil.CHAIN.lock();
/*  78 */       update();
/*     */     }
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
/*     */     public static boolean read(LibKstat.Kstat param1Kstat) {
/*  95 */       byte b = 0;
/*  96 */       while (0 > KstatUtil.KS.kstat_read(KstatUtil.KC, param1Kstat, null)) {
/*  97 */         if (11 != Native.getLastError() || 5 <= ++b) {
/*  98 */           if (KstatUtil.LOG.isDebugEnabled())
/*  99 */             KstatUtil.LOG.debug("Failed to read kstat {}:{}:{}", new Object[] {
/* 100 */                   Native.toString(param1Kstat.ks_module, StandardCharsets.US_ASCII), Integer.valueOf(param1Kstat.ks_instance), 
/* 101 */                   Native.toString(param1Kstat.ks_name, StandardCharsets.US_ASCII)
/*     */                 }); 
/* 103 */           return false;
/*     */         } 
/* 105 */         Util.sleep((8 << b));
/*     */       } 
/* 107 */       return true;
/*     */     }
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
/*     */     public static LibKstat.Kstat lookup(String param1String1, int param1Int, String param1String2) {
/* 127 */       return KstatUtil.KS.kstat_lookup(KstatUtil.KC, param1String1, param1Int, param1String2);
/*     */     }
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
/*     */     public static List<LibKstat.Kstat> lookupAll(String param1String1, int param1Int, String param1String2) {
/* 148 */       ArrayList<LibKstat.Kstat> arrayList = new ArrayList();
/* 149 */       for (LibKstat.Kstat kstat = KstatUtil.KS.kstat_lookup(KstatUtil.KC, param1String1, param1Int, param1String2); kstat != null; kstat = kstat.next()) {
/* 150 */         if ((param1String1 == null || param1String1.equals(Native.toString(kstat.ks_module, StandardCharsets.US_ASCII))) && (param1Int < 0 || param1Int == kstat.ks_instance) && (param1String2 == null || param1String2
/*     */           
/* 152 */           .equals(Native.toString(kstat.ks_name, StandardCharsets.US_ASCII)))) {
/* 153 */           arrayList.add(kstat);
/*     */         }
/*     */       } 
/* 156 */       return arrayList;
/*     */     }
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
/*     */     public static int update() {
/* 170 */       return KstatUtil.KS.kstat_chain_update(KstatUtil.KC);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void close() {
/* 178 */       KstatUtil.CHAIN.unlock();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KstatChain openChain() {
/* 189 */     return new KstatChain();
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
/*     */   public static String dataLookupString(LibKstat.Kstat paramKstat, String paramString) {
/* 207 */     if (paramKstat.ks_type != 1 && paramKstat.ks_type != 4) {
/* 208 */       throw new IllegalArgumentException("Not a kstat_named or kstat_timer kstat.");
/*     */     }
/* 210 */     Pointer pointer = KS.kstat_data_lookup(paramKstat, paramString);
/* 211 */     if (pointer == null) {
/* 212 */       LOG.debug("Failed to lookup kstat value for key {}", paramString);
/* 213 */       return "";
/*     */     } 
/* 215 */     LibKstat.KstatNamed kstatNamed = new LibKstat.KstatNamed(pointer);
/* 216 */     switch (kstatNamed.data_type) {
/*     */       case 0:
/* 218 */         return Native.toString(kstatNamed.value.charc, StandardCharsets.UTF_8);
/*     */       case 1:
/* 220 */         return Integer.toString(kstatNamed.value.i32);
/*     */       case 2:
/* 222 */         return FormatUtil.toUnsignedString(kstatNamed.value.ui32);
/*     */       case 3:
/* 224 */         return Long.toString(kstatNamed.value.i64);
/*     */       case 4:
/* 226 */         return FormatUtil.toUnsignedString(kstatNamed.value.ui64);
/*     */       case 9:
/* 228 */         return kstatNamed.value.str.addr.getString(0L);
/*     */     } 
/* 230 */     LOG.error("Unimplemented kstat data type {}", Byte.valueOf(kstatNamed.data_type));
/* 231 */     return "";
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
/*     */   public static long dataLookupLong(LibKstat.Kstat paramKstat, String paramString) {
/* 251 */     if (paramKstat.ks_type != 1 && paramKstat.ks_type != 4) {
/* 252 */       throw new IllegalArgumentException("Not a kstat_named or kstat_timer kstat.");
/*     */     }
/* 254 */     Pointer pointer = KS.kstat_data_lookup(paramKstat, paramString);
/* 255 */     if (pointer == null) {
/* 256 */       if (LOG.isErrorEnabled())
/* 257 */         LOG.error("Failed lo lookup kstat value on {}:{}:{} for key {}", new Object[] {
/* 258 */               Native.toString(paramKstat.ks_module, StandardCharsets.US_ASCII), Integer.valueOf(paramKstat.ks_instance), 
/* 259 */               Native.toString(paramKstat.ks_name, StandardCharsets.US_ASCII), paramString
/*     */             }); 
/* 261 */       return 0L;
/*     */     } 
/* 263 */     LibKstat.KstatNamed kstatNamed = new LibKstat.KstatNamed(pointer);
/* 264 */     switch (kstatNamed.data_type) {
/*     */       case 1:
/* 266 */         return kstatNamed.value.i32;
/*     */       case 2:
/* 268 */         return FormatUtil.getUnsignedInt(kstatNamed.value.ui32);
/*     */       case 3:
/* 270 */         return kstatNamed.value.i64;
/*     */       case 4:
/* 272 */         return kstatNamed.value.ui64;
/*     */     } 
/* 274 */     LOG.error("Unimplemented or non-numeric kstat data type {}", Byte.valueOf(kstatNamed.data_type));
/* 275 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platfor\\unix\solaris\KstatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */