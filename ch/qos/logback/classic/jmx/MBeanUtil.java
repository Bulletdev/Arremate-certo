/*    */ package ch.qos.logback.classic.jmx;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.status.StatusUtil;
/*    */ import javax.management.InstanceNotFoundException;
/*    */ import javax.management.MBeanRegistrationException;
/*    */ import javax.management.MBeanServer;
/*    */ import javax.management.MalformedObjectNameException;
/*    */ import javax.management.ObjectName;
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
/*    */ public class MBeanUtil
/*    */ {
/*    */   static final String DOMAIN = "ch.qos.logback.classic";
/*    */   
/*    */   public static String getObjectNameFor(String paramString, Class paramClass) {
/* 31 */     return "ch.qos.logback.classic:Name=" + paramString + ",Type=" + paramClass.getName();
/*    */   }
/*    */   
/*    */   public static ObjectName string2ObjectName(Context paramContext, Object paramObject, String paramString) {
/* 35 */     String str = "Failed to convert [" + paramString + "] to ObjectName";
/*    */     
/* 37 */     StatusUtil statusUtil = new StatusUtil(paramContext);
/*    */     try {
/* 39 */       return new ObjectName(paramString);
/* 40 */     } catch (MalformedObjectNameException malformedObjectNameException) {
/* 41 */       statusUtil.addError(paramObject, str, malformedObjectNameException);
/* 42 */       return null;
/* 43 */     } catch (NullPointerException nullPointerException) {
/* 44 */       statusUtil.addError(paramObject, str, nullPointerException);
/* 45 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isRegistered(MBeanServer paramMBeanServer, ObjectName paramObjectName) {
/* 50 */     return paramMBeanServer.isRegistered(paramObjectName);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void createAndRegisterJMXConfigurator(MBeanServer paramMBeanServer, LoggerContext paramLoggerContext, JMXConfigurator paramJMXConfigurator, ObjectName paramObjectName, Object paramObject) {
/*    */     try {
/* 56 */       paramMBeanServer.registerMBean(paramJMXConfigurator, paramObjectName);
/* 57 */     } catch (Exception exception) {
/* 58 */       StatusUtil statusUtil = new StatusUtil((Context)paramLoggerContext);
/* 59 */       statusUtil.addError(paramObject, "Failed to create mbean", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void unregister(LoggerContext paramLoggerContext, MBeanServer paramMBeanServer, ObjectName paramObjectName, Object paramObject) {
/* 65 */     StatusUtil statusUtil = new StatusUtil((Context)paramLoggerContext);
/* 66 */     if (paramMBeanServer.isRegistered(paramObjectName)) {
/*    */       try {
/* 68 */         statusUtil.addInfo(paramObject, "Unregistering mbean [" + paramObjectName + "]");
/* 69 */         paramMBeanServer.unregisterMBean(paramObjectName);
/* 70 */       } catch (InstanceNotFoundException instanceNotFoundException) {
/*    */         
/* 72 */         statusUtil.addError(paramObject, "Failed to unregister mbean" + paramObjectName, instanceNotFoundException);
/* 73 */       } catch (MBeanRegistrationException mBeanRegistrationException) {
/*    */         
/* 75 */         statusUtil.addError(paramObject, "Failed to unregister mbean" + paramObjectName, mBeanRegistrationException);
/*    */       } 
/*    */     } else {
/* 78 */       statusUtil.addInfo(paramObject, "mbean [" + paramObjectName + "] does not seem to be registered");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\jmx\MBeanUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */