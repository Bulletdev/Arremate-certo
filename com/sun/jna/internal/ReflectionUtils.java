/*     */ package com.sun.jna.internal;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class ReflectionUtils
/*     */ {
/*  45 */   private static final Logger LOG = Logger.getLogger(ReflectionUtils.class.getName());
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
/*     */   private static Constructor getConstructorLookupClass() {
/*  59 */     if (CONSTRUCTOR_LOOKUP_CLASS == null) {
/*  60 */       Class clazz = lookupClass("java.lang.invoke.MethodHandles$Lookup");
/*  61 */       CONSTRUCTOR_LOOKUP_CLASS = lookupDeclaredConstructor(clazz, new Class[] { Class.class });
/*     */     } 
/*  63 */     return CONSTRUCTOR_LOOKUP_CLASS;
/*     */   }
/*     */   
/*     */   static {
/*  67 */     Class clazz1 = lookupClass("java.lang.invoke.MethodHandles");
/*  68 */     Class clazz2 = lookupClass("java.lang.invoke.MethodHandle");
/*  69 */     Class clazz3 = lookupClass("java.lang.invoke.MethodHandles$Lookup");
/*  70 */     Class clazz4 = lookupClass("java.lang.invoke.MethodType");
/*     */   }
/*  72 */   private static final Method METHOD_IS_DEFAULT = lookupMethod(Method.class, "isDefault", new Class[0]); private static final Method METHOD_HANDLES_LOOKUP; private static final Method METHOD_HANDLES_LOOKUP_IN; private static final Method METHOD_HANDLES_PRIVATE_LOOKUP_IN; private static final Method METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL; static {
/*  73 */     METHOD_HANDLES_LOOKUP = lookupMethod(clazz1, "lookup", new Class[0]);
/*  74 */     METHOD_HANDLES_LOOKUP_IN = lookupMethod(clazz3, "in", new Class[] { Class.class });
/*  75 */     METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL = lookupMethod(clazz3, "unreflectSpecial", new Class[] { Method.class, Class.class });
/*  76 */     METHOD_HANDLES_LOOKUP_FIND_SPECIAL = lookupMethod(clazz3, "findSpecial", new Class[] { Class.class, String.class, clazz4, Class.class });
/*  77 */     METHOD_HANDLES_BIND_TO = lookupMethod(clazz2, "bindTo", new Class[] { Object.class });
/*  78 */     METHOD_HANDLES_INVOKE_WITH_ARGUMENTS = lookupMethod(clazz2, "invokeWithArguments", new Class[] { Object[].class });
/*  79 */     METHOD_HANDLES_PRIVATE_LOOKUP_IN = lookupMethod(clazz1, "privateLookupIn", new Class[] { Class.class, clazz3 });
/*  80 */     METHOD_TYPE = lookupMethod(clazz4, "methodType", new Class[] { Class.class, Class[].class });
/*     */   }
/*     */   private static final Method METHOD_HANDLES_LOOKUP_FIND_SPECIAL; private static final Method METHOD_HANDLES_BIND_TO; private static final Method METHOD_HANDLES_INVOKE_WITH_ARGUMENTS; private static final Method METHOD_TYPE; private static Constructor CONSTRUCTOR_LOOKUP_CLASS;
/*     */   private static Constructor lookupDeclaredConstructor(Class paramClass, Class... paramVarArgs) {
/*  84 */     if (paramClass == null) {
/*  85 */       LOG.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[] { paramClass, 
/*  86 */             Arrays.toString((Object[])paramVarArgs) });
/*  87 */       return null;
/*     */     } 
/*     */     try {
/*  90 */       Constructor constructor = paramClass.getDeclaredConstructor(paramVarArgs);
/*  91 */       constructor.setAccessible(true);
/*  92 */       return constructor;
/*  93 */     } catch (Exception exception) {
/*  94 */       LOG.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[] { paramClass, 
/*  95 */             Arrays.toString((Object[])paramVarArgs) });
/*  96 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Method lookupMethod(Class paramClass, String paramString, Class... paramVarArgs) {
/* 101 */     if (paramClass == null) {
/* 102 */       LOG.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[] { paramClass, paramString, 
/* 103 */             Arrays.toString((Object[])paramVarArgs) });
/* 104 */       return null;
/*     */     } 
/*     */     try {
/* 107 */       return paramClass.getMethod(paramString, paramVarArgs);
/* 108 */     } catch (Exception exception) {
/* 109 */       LOG.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[] { paramClass, paramString, 
/* 110 */             Arrays.toString((Object[])paramVarArgs) });
/* 111 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Class lookupClass(String paramString) {
/*     */     try {
/* 117 */       return Class.forName(paramString);
/* 118 */     } catch (ClassNotFoundException classNotFoundException) {
/* 119 */       LOG.log(Level.FINE, "Failed to lookup class: " + paramString, classNotFoundException);
/* 120 */       return null;
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
/*     */   public static boolean isDefault(Method paramMethod) {
/* 134 */     if (METHOD_IS_DEFAULT == null) {
/* 135 */       return false;
/*     */     }
/*     */     try {
/* 138 */       return ((Boolean)METHOD_IS_DEFAULT.invoke(paramMethod, new Object[0])).booleanValue();
/* 139 */     } catch (IllegalAccessException illegalAccessException) {
/* 140 */       throw new RuntimeException(illegalAccessException);
/* 141 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 142 */       throw new RuntimeException(illegalArgumentException);
/* 143 */     } catch (InvocationTargetException invocationTargetException) {
/* 144 */       Throwable throwable = invocationTargetException.getCause();
/* 145 */       if (throwable instanceof RuntimeException)
/* 146 */         throw (RuntimeException)throwable; 
/* 147 */       if (throwable instanceof Error) {
/* 148 */         throw (Error)throwable;
/*     */       }
/* 150 */       throw new RuntimeException(throwable);
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
/*     */   public static Object getMethodHandle(Method paramMethod) throws Exception {
/* 165 */     assert isDefault(paramMethod);
/* 166 */     Object object = createLookup();
/*     */     try {
/* 168 */       Object object1 = createPrivateLookupIn(paramMethod.getDeclaringClass(), object);
/* 169 */       return mhViaFindSpecial(object1, paramMethod);
/*     */     }
/* 171 */     catch (Exception exception) {
/* 172 */       Object object1 = getConstructorLookupClass().newInstance(new Object[] { paramMethod.getDeclaringClass() });
/* 173 */       return mhViaUnreflectSpecial(object1, paramMethod);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object mhViaFindSpecial(Object paramObject, Method paramMethod) throws Exception {
/* 179 */     return METHOD_HANDLES_LOOKUP_FIND_SPECIAL.invoke(paramObject, new Object[] { paramMethod
/*     */           
/* 181 */           .getDeclaringClass(), paramMethod
/* 182 */           .getName(), METHOD_TYPE
/* 183 */           .invoke(null, new Object[] { paramMethod.getReturnType(), paramMethod.getParameterTypes() }), paramMethod
/* 184 */           .getDeclaringClass() });
/*     */   }
/*     */   
/*     */   private static Object mhViaUnreflectSpecial(Object paramObject, Method paramMethod) throws Exception {
/* 188 */     Object object = METHOD_HANDLES_LOOKUP_IN.invoke(paramObject, new Object[] { paramMethod.getDeclaringClass() });
/* 189 */     return METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL.invoke(object, new Object[] { paramMethod, paramMethod.getDeclaringClass() });
/*     */   }
/*     */   
/*     */   private static Object createPrivateLookupIn(Class paramClass, Object paramObject) throws Exception {
/* 193 */     return METHOD_HANDLES_PRIVATE_LOOKUP_IN.invoke(null, new Object[] { paramClass, paramObject });
/*     */   }
/*     */   
/*     */   private static Object createLookup() throws Exception {
/* 197 */     return METHOD_HANDLES_LOOKUP.invoke(null, new Object[0]);
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
/*     */   public static Object invokeDefaultMethod(Object paramObject1, Object paramObject2, Object... paramVarArgs) throws Throwable {
/* 211 */     Object object = METHOD_HANDLES_BIND_TO.invoke(paramObject2, new Object[] { paramObject1 });
/* 212 */     return METHOD_HANDLES_INVOKE_WITH_ARGUMENTS.invoke(object, new Object[] { paramVarArgs });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\internal\ReflectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */