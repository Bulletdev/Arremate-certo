/*    */ package org.h2.jmx;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.Properties;
/*    */ import javax.management.MBeanAttributeInfo;
/*    */ import javax.management.MBeanInfo;
/*    */ import javax.management.MBeanOperationInfo;
/*    */ import javax.management.NotCompliantMBeanException;
/*    */ import javax.management.StandardMBean;
/*    */ import org.h2.util.Utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocumentedMBean
/*    */   extends StandardMBean
/*    */ {
/*    */   private final String interfaceName;
/*    */   private Properties resources;
/*    */   
/*    */   public <T> DocumentedMBean(T paramT, Class<T> paramClass) throws NotCompliantMBeanException {
/* 28 */     super(paramT, paramClass);
/* 29 */     this.interfaceName = paramT.getClass().getName() + "MBean";
/*    */   }
/*    */   
/*    */   private Properties getResources() {
/* 33 */     if (this.resources == null) {
/* 34 */       this.resources = new Properties();
/* 35 */       String str = "/org/h2/res/javadoc.properties";
/*    */       try {
/* 37 */         byte[] arrayOfByte = Utils.getResource(str);
/* 38 */         if (arrayOfByte != null) {
/* 39 */           this.resources.load(new ByteArrayInputStream(arrayOfByte));
/*    */         }
/* 41 */       } catch (IOException iOException) {}
/*    */     } 
/*    */ 
/*    */     
/* 45 */     return this.resources;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getDescription(MBeanInfo paramMBeanInfo) {
/* 50 */     String str = getResources().getProperty(this.interfaceName);
/* 51 */     return (str == null) ? super.getDescription(paramMBeanInfo) : str;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getDescription(MBeanOperationInfo paramMBeanOperationInfo) {
/* 56 */     String str = getResources().getProperty(this.interfaceName + "." + paramMBeanOperationInfo.getName());
/* 57 */     return (str == null) ? super.getDescription(paramMBeanOperationInfo) : str;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getDescription(MBeanAttributeInfo paramMBeanAttributeInfo) {
/* 62 */     String str1 = paramMBeanAttributeInfo.isIs() ? "is" : "get";
/* 63 */     String str2 = getResources().getProperty(this.interfaceName + "." + str1 + paramMBeanAttributeInfo.getName());
/*    */     
/* 65 */     return (str2 == null) ? super.getDescription(paramMBeanAttributeInfo) : str2;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getImpact(MBeanOperationInfo paramMBeanOperationInfo) {
/* 70 */     if (paramMBeanOperationInfo.getName().startsWith("list")) {
/* 71 */       return 0;
/*    */     }
/* 73 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jmx\DocumentedMBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */