/*     */ package oshi.util.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.COMUtils;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import java.util.HashSet;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.GlobalConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class WmiQueryHandler
/*     */ {
/*  52 */   private static final Logger LOG = LoggerFactory.getLogger(WmiQueryHandler.class);
/*     */   
/*  54 */   private static int globalTimeout = GlobalConfig.get("oshi.util.wmi.timeout", -1);
/*     */   
/*     */   static {
/*  57 */     if (globalTimeout == 0 || globalTimeout < -1) {
/*  58 */       throw new GlobalConfig.PropertyException("oshi.util.wmi.timeout");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  63 */   protected int wmiTimeout = globalTimeout;
/*     */ 
/*     */   
/*  66 */   protected final Set<String> failedWmiClassNames = new HashSet<>();
/*     */ 
/*     */   
/*  69 */   private int comThreading = 0;
/*     */ 
/*     */   
/*     */   private boolean securityInitialized = false;
/*     */   
/*  74 */   private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
/*  75 */   private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
/*     */ 
/*     */   
/*  78 */   private static Class<? extends WmiQueryHandler> customClass = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized WmiQueryHandler createInstance() {
/*  89 */     if (customClass == null) {
/*  90 */       return new WmiQueryHandler();
/*     */     }
/*     */     try {
/*  93 */       return customClass.getConstructor(EMPTY_CLASS_ARRAY).newInstance(EMPTY_OBJECT_ARRAY);
/*  94 */     } catch (NoSuchMethodException|SecurityException noSuchMethodException) {
/*  95 */       LOG.error("Failed to find or access a no-arg constructor for {}", customClass);
/*  96 */     } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException instantiationException) {
/*     */       
/*  98 */       LOG.error("Failed to create a new instance of {}", customClass);
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void setInstanceClass(Class<? extends WmiQueryHandler> paramClass) {
/* 111 */     customClass = paramClass;
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
/*     */   public <T extends Enum<T>> WbemcliUtil.WmiResult<T> queryWMI(WbemcliUtil.WmiQuery<T> paramWmiQuery) {
/* 127 */     return queryWMI(paramWmiQuery, true);
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
/*     */   public <T extends Enum<T>> WbemcliUtil.WmiResult<T> queryWMI(WbemcliUtil.WmiQuery<T> paramWmiQuery, boolean paramBoolean) {
/* 147 */     Objects.requireNonNull(WbemcliUtil.INSTANCE); WbemcliUtil.WmiResult<T> wmiResult = new WbemcliUtil.WmiResult(WbemcliUtil.INSTANCE, paramWmiQuery.getPropertyEnum());
/* 148 */     if (this.failedWmiClassNames.contains(paramWmiQuery.getWmiClassName())) {
/* 149 */       return wmiResult;
/*     */     }
/* 151 */     boolean bool = false;
/*     */     try {
/* 153 */       if (paramBoolean) {
/* 154 */         bool = initCOM();
/*     */       }
/* 156 */       wmiResult = paramWmiQuery.execute(this.wmiTimeout);
/* 157 */     } catch (COMException cOMException) {
/*     */       
/* 159 */       if (!"ROOT\\OpenHardwareMonitor".equals(paramWmiQuery.getNameSpace())) {
/* 160 */         boolean bool1 = (cOMException.getHresult() == null) ? true : cOMException.getHresult().intValue();
/* 161 */         switch (bool1) {
/*     */           case true:
/* 163 */             LOG.warn("COM exception: Invalid Namespace {}", paramWmiQuery.getNameSpace());
/*     */             break;
/*     */           case true:
/* 166 */             LOG.warn("COM exception: Invalid Class {}", paramWmiQuery.getWmiClassName());
/*     */             break;
/*     */           case true:
/* 169 */             LOG.warn("COM exception: Invalid Query: {}", WmiUtil.queryToString(paramWmiQuery));
/*     */             break;
/*     */           default:
/* 172 */             handleComException(paramWmiQuery, cOMException);
/*     */             break;
/*     */         } 
/* 175 */         this.failedWmiClassNames.add(paramWmiQuery.getWmiClassName());
/*     */       } 
/* 177 */     } catch (TimeoutException timeoutException) {
/* 178 */       LOG.warn("WMI query timed out after {} ms: {}", Integer.valueOf(this.wmiTimeout), WmiUtil.queryToString(paramWmiQuery));
/*     */     } 
/* 180 */     if (bool) {
/* 181 */       unInitCOM();
/*     */     }
/* 183 */     return wmiResult;
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
/*     */   protected void handleComException(WbemcliUtil.WmiQuery<?> paramWmiQuery, COMException paramCOMException) {
/* 196 */     LOG.warn("COM exception querying {}, which might not be on your system. Will not attempt to query it again. Error was {}: {}", new Object[] { paramWmiQuery
/*     */           
/* 198 */           .getWmiClassName(), Integer.valueOf(paramCOMException.getHresult().intValue()), paramCOMException.getMessage() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean initCOM() {
/* 208 */     boolean bool = false;
/*     */ 
/*     */     
/* 211 */     bool = initCOM(getComThreading());
/* 212 */     if (!bool) {
/* 213 */       bool = initCOM(switchComThreading());
/*     */     }
/*     */ 
/*     */     
/* 217 */     if (bool && !isSecurityInitialized()) {
/* 218 */       WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeSecurity(null, -1, null, null, 0, 3, null, 0, null);
/*     */ 
/*     */ 
/*     */       
/* 222 */       if (COMUtils.FAILED(hRESULT) && hRESULT.intValue() != -2147417831) {
/* 223 */         Ole32.INSTANCE.CoUninitialize();
/* 224 */         throw new COMException("Failed to initialize security.", hRESULT);
/*     */       } 
/* 226 */       this.securityInitialized = true;
/*     */     } 
/* 228 */     return bool;
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
/*     */   protected boolean initCOM(int paramInt) {
/* 240 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeEx(null, paramInt);
/* 241 */     switch (hRESULT.intValue()) {
/*     */ 
/*     */       
/*     */       case 0:
/*     */       case 1:
/* 246 */         return true;
/*     */       
/*     */       case -2147417850:
/* 249 */         return false;
/*     */     } 
/*     */     
/* 252 */     throw new COMException("Failed to initialize COM library.", hRESULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unInitCOM() {
/* 261 */     Ole32.INSTANCE.CoUninitialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getComThreading() {
/* 271 */     return this.comThreading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int switchComThreading() {
/* 281 */     if (this.comThreading == 2) {
/* 282 */       this.comThreading = 0;
/*     */     } else {
/* 284 */       this.comThreading = 2;
/*     */     } 
/* 286 */     return this.comThreading;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecurityInitialized() {
/* 296 */     return this.securityInitialized;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWmiTimeout() {
/* 306 */     return this.wmiTimeout;
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
/*     */   public void setWmiTimeout(int paramInt) {
/* 318 */     this.wmiTimeout = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\windows\WmiQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */