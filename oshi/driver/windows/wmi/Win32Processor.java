/*     */ package oshi.driver.windows.wmi;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.platform.windows.WmiQueryHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Win32Processor
/*     */ {
/*     */   private static final String WIN32_PROCESSOR = "Win32_Processor";
/*     */   
/*     */   public enum VoltProperty
/*     */   {
/*  44 */     CURRENTVOLTAGE, VOLTAGECAPS;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ProcessorIdProperty
/*     */   {
/*  51 */     PROCESSORID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum BitnessProperty
/*     */   {
/*  58 */     ADDRESSWIDTH;
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
/*     */   public static WbemcliUtil.WmiResult<VoltProperty> queryVoltage() {
/*  72 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_Processor", VoltProperty.class);
/*  73 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
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
/*     */   public static WbemcliUtil.WmiResult<ProcessorIdProperty> queryProcessorId() {
/*  91 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_Processor", ProcessorIdProperty.class);
/*  92 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WbemcliUtil.WmiResult<BitnessProperty> queryBitness() {
/* 102 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("Win32_Processor", BitnessProperty.class);
/* 103 */     return WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32Processor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */