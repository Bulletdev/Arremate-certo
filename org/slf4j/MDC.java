/*     */ package org.slf4j;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.util.Map;
/*     */ import org.slf4j.helpers.NOPMDCAdapter;
/*     */ import org.slf4j.helpers.Util;
/*     */ import org.slf4j.impl.StaticMDCBinder;
/*     */ import org.slf4j.spi.MDCAdapter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MDC
/*     */ {
/*     */   static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
/*     */   static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
/*     */   static MDCAdapter mdcAdapter;
/*     */   
/*     */   public static class MDCCloseable
/*     */     implements Closeable
/*     */   {
/*     */     private final String key;
/*     */     
/*     */     private MDCCloseable(String param1String) {
/*  77 */       this.key = param1String;
/*     */     }
/*     */     
/*     */     public void close() {
/*  81 */       MDC.remove(this.key);
/*     */     }
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
/*     */   private static MDCAdapter bwCompatibleGetMDCAdapterFromBinder() throws NoClassDefFoundError {
/*     */     try {
/*  99 */       return StaticMDCBinder.getSingleton().getMDCA();
/* 100 */     } catch (NoSuchMethodError noSuchMethodError) {
/*     */       
/* 102 */       return StaticMDCBinder.SINGLETON.getMDCA();
/*     */     } 
/*     */   }
/*     */   
/*     */   static {
/*     */     try {
/* 108 */       mdcAdapter = bwCompatibleGetMDCAdapterFromBinder();
/* 109 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/* 110 */       mdcAdapter = (MDCAdapter)new NOPMDCAdapter();
/* 111 */       String str = noClassDefFoundError.getMessage();
/* 112 */       if (str != null && str.contains("StaticMDCBinder")) {
/* 113 */         Util.report("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
/* 114 */         Util.report("Defaulting to no-operation MDCAdapter implementation.");
/* 115 */         Util.report("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
/*     */       } else {
/* 117 */         throw noClassDefFoundError;
/*     */       } 
/* 119 */     } catch (Exception exception) {
/*     */       
/* 121 */       Util.report("MDC binding unsuccessful.", exception);
/*     */     } 
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
/*     */   public static void put(String paramString1, String paramString2) throws IllegalArgumentException {
/* 141 */     if (paramString1 == null) {
/* 142 */       throw new IllegalArgumentException("key parameter cannot be null");
/*     */     }
/* 144 */     if (mdcAdapter == null) {
/* 145 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 147 */     mdcAdapter.put(paramString1, paramString2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MDCCloseable putCloseable(String paramString1, String paramString2) throws IllegalArgumentException {
/* 179 */     put(paramString1, paramString2);
/* 180 */     return new MDCCloseable(paramString1);
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
/*     */   public static String get(String paramString) throws IllegalArgumentException {
/* 196 */     if (paramString == null) {
/* 197 */       throw new IllegalArgumentException("key parameter cannot be null");
/*     */     }
/*     */     
/* 200 */     if (mdcAdapter == null) {
/* 201 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 203 */     return mdcAdapter.get(paramString);
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
/*     */   public static void remove(String paramString) throws IllegalArgumentException {
/* 217 */     if (paramString == null) {
/* 218 */       throw new IllegalArgumentException("key parameter cannot be null");
/*     */     }
/*     */     
/* 221 */     if (mdcAdapter == null) {
/* 222 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 224 */     mdcAdapter.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear() {
/* 231 */     if (mdcAdapter == null) {
/* 232 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 234 */     mdcAdapter.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> getCopyOfContextMap() {
/* 245 */     if (mdcAdapter == null) {
/* 246 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 248 */     return mdcAdapter.getCopyOfContextMap();
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
/*     */   public static void setContextMap(Map<String, String> paramMap) {
/* 261 */     if (mdcAdapter == null) {
/* 262 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 264 */     mdcAdapter.setContextMap(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MDCAdapter getMDCAdapter() {
/* 274 */     return mdcAdapter;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\MDC.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */