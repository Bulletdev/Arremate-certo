/*    */ package oshi.driver.windows.wmi;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.platform.windows.WmiQueryHandler;
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
/*    */ public final class OhmSensor
/*    */ {
/*    */   private static final String SENSOR = "Sensor";
/*    */   
/*    */   public enum ValueProperty
/*    */   {
/* 45 */     VALUE;
/*    */   }
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
/*    */   public static WbemcliUtil.WmiResult<ValueProperty> querySensorValue(WmiQueryHandler paramWmiQueryHandler, String paramString1, String paramString2) {
/* 64 */     StringBuilder stringBuilder = new StringBuilder("Sensor");
/* 65 */     stringBuilder.append(" WHERE Parent = \"").append(paramString1);
/* 66 */     stringBuilder.append("\" AND SensorType=\"").append(paramString2).append('"');
/* 67 */     WbemcliUtil.WmiQuery wmiQuery = new WbemcliUtil.WmiQuery("ROOT\\OpenHardwareMonitor", stringBuilder.toString(), ValueProperty.class);
/*    */     
/* 69 */     return paramWmiQueryHandler.queryWMI(wmiQuery, false);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\OhmSensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */