/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import javax.servlet.ServletContextEvent;
/*     */ import javax.servlet.ServletContextListener;
/*     */ import org.apache.commons.logging.LogFactory;
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
/*     */ public class ServletContextCleaner
/*     */   implements ServletContextListener
/*     */ {
/*  52 */   private static final Class[] RELEASE_SIGNATURE = new Class[] { ClassLoader.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
/*  60 */     ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
/*     */     
/*  62 */     Object[] arrayOfObject = new Object[1];
/*  63 */     arrayOfObject[0] = classLoader1;
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
/*  95 */     ClassLoader classLoader2 = classLoader1;
/*  96 */     while (classLoader2 != null) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 101 */         Class clazz = classLoader2.loadClass("org.apache.commons.logging.LogFactory");
/* 102 */         Method method = clazz.getMethod("release", RELEASE_SIGNATURE);
/* 103 */         method.invoke(null, arrayOfObject);
/* 104 */         classLoader2 = clazz.getClassLoader().getParent();
/* 105 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */ 
/*     */         
/* 108 */         classLoader2 = null;
/* 109 */       } catch (NoSuchMethodException noSuchMethodException) {
/*     */         
/* 111 */         System.err.println("LogFactory instance found which does not support release method!");
/* 112 */         classLoader2 = null;
/* 113 */       } catch (IllegalAccessException illegalAccessException) {
/*     */         
/* 115 */         System.err.println("LogFactory instance found which is not accessable!");
/* 116 */         classLoader2 = null;
/* 117 */       } catch (InvocationTargetException invocationTargetException) {
/*     */         
/* 119 */         System.err.println("LogFactory instance release method failed!");
/* 120 */         classLoader2 = null;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     LogFactory.release(classLoader1);
/*     */   }
/*     */   
/*     */   public void contextInitialized(ServletContextEvent paramServletContextEvent) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\ServletContextCleaner.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */