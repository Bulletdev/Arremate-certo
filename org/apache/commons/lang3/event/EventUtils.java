/*     */ package org.apache.commons.lang3.event;
/*     */ 
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.reflect.MethodUtils;
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
/*     */ public class EventUtils
/*     */ {
/*     */   public static <L> void addEventListener(Object paramObject, Class<L> paramClass, L paramL) {
/*     */     try {
/*  49 */       MethodUtils.invokeMethod(paramObject, "add" + paramClass.getSimpleName(), new Object[] { paramL });
/*  50 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  51 */       throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have a public add" + paramClass
/*  52 */           .getSimpleName() + " method which takes a parameter of type " + paramClass
/*  53 */           .getName() + ".");
/*  54 */     } catch (IllegalAccessException illegalAccessException) {
/*  55 */       throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have an accessible add" + paramClass
/*  56 */           .getSimpleName() + " method which takes a parameter of type " + paramClass
/*  57 */           .getName() + ".");
/*  58 */     } catch (InvocationTargetException invocationTargetException) {
/*  59 */       throw new RuntimeException("Unable to add listener.", invocationTargetException.getCause());
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
/*     */   public static <L> void bindEventsToMethod(Object paramObject1, String paramString, Object paramObject2, Class<L> paramClass, String... paramVarArgs) {
/*  76 */     L l = paramClass.cast(Proxy.newProxyInstance(paramObject1.getClass().getClassLoader(), new Class[] { paramClass }, new EventBindingInvocationHandler(paramObject1, paramString, paramVarArgs)));
/*     */     
/*  78 */     addEventListener(paramObject2, paramClass, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class EventBindingInvocationHandler
/*     */     implements InvocationHandler
/*     */   {
/*     */     private final Object target;
/*     */     
/*     */     private final String methodName;
/*     */     
/*     */     private final Set<String> eventTypes;
/*     */ 
/*     */     
/*     */     EventBindingInvocationHandler(Object param1Object, String param1String, String[] param1ArrayOfString) {
/*  94 */       this.target = param1Object;
/*  95 */       this.methodName = param1String;
/*  96 */       this.eventTypes = new HashSet<>(Arrays.asList(param1ArrayOfString));
/*     */     }
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
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/* 110 */       if (this.eventTypes.isEmpty() || this.eventTypes.contains(param1Method.getName())) {
/* 111 */         if (hasMatchingParametersMethod(param1Method)) {
/* 112 */           return MethodUtils.invokeMethod(this.target, this.methodName, param1ArrayOfObject);
/*     */         }
/* 114 */         return MethodUtils.invokeMethod(this.target, this.methodName);
/*     */       } 
/* 116 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean hasMatchingParametersMethod(Method param1Method) {
/* 126 */       return (MethodUtils.getAccessibleMethod(this.target.getClass(), this.methodName, param1Method.getParameterTypes()) != null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\event\EventUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */