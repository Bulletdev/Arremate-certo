/*    */ package oshi.driver.unix.solaris.kstat;
/*    */ 
/*    */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.platform.unix.solaris.KstatUtil;
/*    */ import oshi.util.tuples.Pair;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class SystemPages
/*    */ {
/*    */   public static Pair<Long, Long> queryAvailableTotal() {
/* 50 */     long l1 = 0L;
/* 51 */     long l2 = 0L;
/*    */     
/* 53 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 54 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, -1, "system_pages");
/*    */       
/* 56 */       if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
/* 57 */         l1 = KstatUtil.dataLookupLong(kstat, "availrmem");
/* 58 */         l2 = KstatUtil.dataLookupLong(kstat, "physmem");
/*    */       } 
/* 60 */       if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 61 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return new Pair(Long.valueOf(l1), Long.valueOf(l2));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\solaris\kstat\SystemPages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */