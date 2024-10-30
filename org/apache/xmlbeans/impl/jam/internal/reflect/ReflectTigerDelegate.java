/*    */ package org.apache.xmlbeans.impl.jam.internal.reflect;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import org.apache.xmlbeans.impl.jam.internal.TigerDelegate;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MMember;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
/*    */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
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
/*    */ public abstract class ReflectTigerDelegate
/*    */   extends TigerDelegate
/*    */ {
/*    */   private static final String IMPL_NAME = "org.apache.xmlbeans.impl.jam.internal.reflect.ReflectTigerDelegateImpl_150";
/*    */   
/*    */   public static ReflectTigerDelegate create(JamLogger paramJamLogger) {
/* 45 */     if (!isTigerReflectionAvailable(paramJamLogger)) return null;
/*    */     
/*    */     try {
/* 48 */       ReflectTigerDelegate reflectTigerDelegate = (ReflectTigerDelegate)Class.forName("org.apache.xmlbeans.impl.jam.internal.reflect.ReflectTigerDelegateImpl_150").newInstance();
/*    */       
/* 50 */       reflectTigerDelegate.init(paramJamLogger);
/* 51 */       return reflectTigerDelegate;
/* 52 */     } catch (ClassNotFoundException classNotFoundException) {
/* 53 */       issue14BuildWarning(classNotFoundException, paramJamLogger);
/* 54 */     } catch (IllegalAccessException illegalAccessException) {
/* 55 */       paramJamLogger.error(illegalAccessException);
/* 56 */     } catch (InstantiationException instantiationException) {
/* 57 */       paramJamLogger.error(instantiationException);
/*    */     } 
/* 59 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ReflectTigerDelegate create(ElementContext paramElementContext) {
/* 66 */     if (!isTigerReflectionAvailable(paramElementContext.getLogger())) return null;
/*    */     
/*    */     try {
/* 69 */       ReflectTigerDelegate reflectTigerDelegate = (ReflectTigerDelegate)Class.forName("org.apache.xmlbeans.impl.jam.internal.reflect.ReflectTigerDelegateImpl_150").newInstance();
/*    */       
/* 71 */       reflectTigerDelegate.init(paramElementContext);
/* 72 */       return reflectTigerDelegate;
/* 73 */     } catch (ClassNotFoundException classNotFoundException) {
/* 74 */       issue14BuildWarning(classNotFoundException, paramElementContext.getLogger());
/* 75 */     } catch (IllegalAccessException illegalAccessException) {
/* 76 */       paramElementContext.getLogger().error(illegalAccessException);
/* 77 */     } catch (InstantiationException instantiationException) {
/* 78 */       paramElementContext.getLogger().error(instantiationException);
/*    */     } 
/* 80 */     return null;
/*    */   }
/*    */   
/*    */   public abstract void populateAnnotationTypeIfNecessary(Class paramClass, MClass paramMClass, ReflectClassBuilder paramReflectClassBuilder);
/*    */   
/*    */   public abstract boolean isEnum(Class paramClass);
/*    */   
/*    */   public abstract Constructor getEnclosingConstructor(Class paramClass);
/*    */   
/*    */   public abstract Method getEnclosingMethod(Class paramClass);
/*    */   
/*    */   public abstract void extractAnnotations(MMember paramMMember, Method paramMethod);
/*    */   
/*    */   public abstract void extractAnnotations(MConstructor paramMConstructor, Constructor paramConstructor);
/*    */   
/*    */   public abstract void extractAnnotations(MField paramMField, Field paramField);
/*    */   
/*    */   public abstract void extractAnnotations(MClass paramMClass, Class paramClass);
/*    */   
/*    */   public abstract void extractAnnotations(MParameter paramMParameter, Method paramMethod, int paramInt);
/*    */   
/*    */   public abstract void extractAnnotations(MParameter paramMParameter, Constructor paramConstructor, int paramInt);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\reflect\ReflectTigerDelegate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */