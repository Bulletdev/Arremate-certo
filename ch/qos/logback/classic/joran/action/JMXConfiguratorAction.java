/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.jmx.JMXConfigurator;
/*    */ import ch.qos.logback.classic.jmx.MBeanUtil;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.lang.management.ManagementFactory;
/*    */ import javax.management.MBeanServer;
/*    */ import javax.management.ObjectName;
/*    */ import org.xml.sax.Attributes;
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
/*    */ public class JMXConfiguratorAction
/*    */   extends Action
/*    */ {
/*    */   static final String OBJECT_NAME_ATTRIBUTE_NAME = "objectName";
/*    */   static final String CONTEXT_NAME_ATTRIBUTE_NAME = "contextName";
/*    */   static final char JMX_NAME_SEPARATOR = ',';
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/*    */     String str3;
/* 39 */     addInfo("begin");
/*    */     
/* 41 */     String str1 = this.context.getName();
/* 42 */     String str2 = paramAttributes.getValue("contextName");
/* 43 */     if (!OptionHelper.isEmpty(str2)) {
/* 44 */       str1 = str2;
/*    */     }
/*    */ 
/*    */     
/* 48 */     String str4 = paramAttributes.getValue("objectName");
/* 49 */     if (OptionHelper.isEmpty(str4)) {
/* 50 */       str3 = MBeanUtil.getObjectNameFor(str1, JMXConfigurator.class);
/*    */     } else {
/* 52 */       str3 = str4;
/*    */     } 
/*    */     
/* 55 */     ObjectName objectName = MBeanUtil.string2ObjectName(this.context, this, str3);
/* 56 */     if (objectName == null) {
/* 57 */       addError("Failed construct ObjectName for [" + str3 + "]");
/*    */       
/*    */       return;
/*    */     } 
/* 61 */     MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
/* 62 */     if (!MBeanUtil.isRegistered(mBeanServer, objectName)) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 67 */       JMXConfigurator jMXConfigurator = new JMXConfigurator((LoggerContext)this.context, mBeanServer, objectName);
/*    */       try {
/* 69 */         mBeanServer.registerMBean(jMXConfigurator, objectName);
/* 70 */       } catch (Exception exception) {
/* 71 */         addError("Failed to create mbean", exception);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\JMXConfiguratorAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */