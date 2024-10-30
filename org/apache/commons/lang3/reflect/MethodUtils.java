/*      */ package org.apache.commons.lang3.reflect;
/*      */ 
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MethodUtils
/*      */ {
/*   63 */   private static final Comparator<Method> METHOD_BY_SIGNATURE = Comparator.comparing(Method::toString);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object paramObject, String paramString) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*   98 */     return invokeMethod(paramObject, paramString, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[])null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object paramObject, boolean paramBoolean, String paramString) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  121 */     return invokeMethod(paramObject, paramBoolean, paramString, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object paramObject, String paramString, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  149 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/*  150 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/*  151 */     return invokeMethod(paramObject, paramString, paramVarArgs, arrayOfClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object paramObject, boolean paramBoolean, String paramString, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  180 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/*  181 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/*  182 */     return invokeMethod(paramObject, paramBoolean, paramString, paramVarArgs, arrayOfClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object paramObject, boolean paramBoolean, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*      */     String str;
/*  207 */     paramArrayOfClass = ArrayUtils.nullToEmpty(paramArrayOfClass);
/*  208 */     paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
/*      */ 
/*      */     
/*  211 */     Method method = null;
/*      */     
/*  213 */     if (paramBoolean) {
/*  214 */       str = "No such method: ";
/*  215 */       method = getMatchingMethod(paramObject.getClass(), paramString, paramArrayOfClass);
/*      */       
/*  217 */       if (method != null && !method.isAccessible()) {
/*  218 */         method.setAccessible(true);
/*      */       }
/*      */     } else {
/*  221 */       str = "No such accessible method: ";
/*  222 */       method = getMatchingAccessibleMethod(paramObject.getClass(), paramString, paramArrayOfClass);
/*      */     } 
/*      */ 
/*      */     
/*  226 */     if (method == null) {
/*  227 */       throw new NoSuchMethodException(str + paramString + "() on object: " + paramObject
/*      */           
/*  229 */           .getClass().getName());
/*      */     }
/*  231 */     paramArrayOfObject = toVarArgs(method, paramArrayOfObject);
/*      */     
/*  233 */     return method.invoke(paramObject, paramArrayOfObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  259 */     return invokeMethod(paramObject, false, paramString, paramArrayOfObject, paramArrayOfClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeExactMethod(Object paramObject, String paramString) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  283 */     return invokeExactMethod(paramObject, paramString, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeExactMethod(Object paramObject, String paramString, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  306 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/*  307 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/*  308 */     return invokeExactMethod(paramObject, paramString, paramVarArgs, arrayOfClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  334 */     paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
/*  335 */     paramArrayOfClass = ArrayUtils.nullToEmpty(paramArrayOfClass);
/*  336 */     Method method = getAccessibleMethod(paramObject.getClass(), paramString, paramArrayOfClass);
/*      */     
/*  338 */     if (method == null) {
/*  339 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject
/*      */           
/*  341 */           .getClass().getName());
/*      */     }
/*  343 */     return method.invoke(paramObject, paramArrayOfObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeExactStaticMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  369 */     paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
/*  370 */     paramArrayOfClass = ArrayUtils.nullToEmpty(paramArrayOfClass);
/*  371 */     Method method = getAccessibleMethod(paramClass, paramString, paramArrayOfClass);
/*  372 */     if (method == null) {
/*  373 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass
/*  374 */           .getName());
/*      */     }
/*  376 */     return method.invoke((Object)null, paramArrayOfObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  406 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/*  407 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/*  408 */     return invokeStaticMethod(paramClass, paramString, paramVarArgs, arrayOfClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeStaticMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  437 */     paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
/*  438 */     paramArrayOfClass = ArrayUtils.nullToEmpty(paramArrayOfClass);
/*  439 */     Method method = getMatchingAccessibleMethod(paramClass, paramString, paramArrayOfClass);
/*      */     
/*  441 */     if (method == null) {
/*  442 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass
/*  443 */           .getName());
/*      */     }
/*  445 */     paramArrayOfObject = toVarArgs(method, paramArrayOfObject);
/*  446 */     return method.invoke((Object)null, paramArrayOfObject);
/*      */   }
/*      */   
/*      */   private static Object[] toVarArgs(Method paramMethod, Object[] paramArrayOfObject) {
/*  450 */     if (paramMethod.isVarArgs()) {
/*  451 */       Class[] arrayOfClass = paramMethod.getParameterTypes();
/*  452 */       paramArrayOfObject = getVarArgs(paramArrayOfObject, arrayOfClass);
/*      */     } 
/*  454 */     return paramArrayOfObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Object[] getVarArgs(Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) {
/*  468 */     if (paramArrayOfObject.length == paramArrayOfClass.length && (paramArrayOfObject[paramArrayOfObject.length - 1] == null || paramArrayOfObject[paramArrayOfObject.length - 1]
/*  469 */       .getClass().equals(paramArrayOfClass[paramArrayOfClass.length - 1])))
/*      */     {
/*  471 */       return paramArrayOfObject;
/*      */     }
/*      */ 
/*      */     
/*  475 */     Object[] arrayOfObject = new Object[paramArrayOfClass.length];
/*      */ 
/*      */     
/*  478 */     System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramArrayOfClass.length - 1);
/*      */ 
/*      */     
/*  481 */     Class<?> clazz = paramArrayOfClass[paramArrayOfClass.length - 1].getComponentType();
/*  482 */     int i = paramArrayOfObject.length - paramArrayOfClass.length + 1;
/*      */     
/*  484 */     Object object = Array.newInstance(ClassUtils.primitiveToWrapper(clazz), i);
/*      */     
/*  486 */     System.arraycopy(paramArrayOfObject, paramArrayOfClass.length - 1, object, 0, i);
/*      */     
/*  488 */     if (clazz.isPrimitive())
/*      */     {
/*  490 */       object = ArrayUtils.toPrimitive(object);
/*      */     }
/*      */ 
/*      */     
/*  494 */     arrayOfObject[paramArrayOfClass.length - 1] = object;
/*      */ 
/*      */     
/*  497 */     return arrayOfObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeExactStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  521 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/*  522 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/*  523 */     return invokeExactStaticMethod(paramClass, paramString, paramVarArgs, arrayOfClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method getAccessibleMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/*      */     try {
/*  541 */       return getAccessibleMethod(paramClass.getMethod(paramString, paramVarArgs));
/*      */     }
/*  543 */     catch (NoSuchMethodException noSuchMethodException) {
/*  544 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method getAccessibleMethod(Method paramMethod) {
/*  557 */     if (!MemberUtils.isAccessible(paramMethod)) {
/*  558 */       return null;
/*      */     }
/*      */     
/*  561 */     Class<?> clazz = paramMethod.getDeclaringClass();
/*  562 */     if (Modifier.isPublic(clazz.getModifiers())) {
/*  563 */       return paramMethod;
/*      */     }
/*  565 */     String str = paramMethod.getName();
/*  566 */     Class[] arrayOfClass = paramMethod.getParameterTypes();
/*      */ 
/*      */     
/*  569 */     paramMethod = getAccessibleMethodFromInterfaceNest(clazz, str, arrayOfClass);
/*      */ 
/*      */ 
/*      */     
/*  573 */     if (paramMethod == null) {
/*  574 */       paramMethod = getAccessibleMethodFromSuperclass(clazz, str, arrayOfClass);
/*      */     }
/*      */     
/*  577 */     return paramMethod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Method getAccessibleMethodFromSuperclass(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/*  592 */     Class<?> clazz = paramClass.getSuperclass();
/*  593 */     while (clazz != null) {
/*  594 */       if (Modifier.isPublic(clazz.getModifiers())) {
/*      */         try {
/*  596 */           return clazz.getMethod(paramString, paramVarArgs);
/*  597 */         } catch (NoSuchMethodException noSuchMethodException) {
/*  598 */           return null;
/*      */         } 
/*      */       }
/*  601 */       clazz = clazz.getSuperclass();
/*      */     } 
/*  603 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Method getAccessibleMethodFromInterfaceNest(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/*  624 */     for (; paramClass != null; paramClass = paramClass.getSuperclass()) {
/*      */ 
/*      */       
/*  627 */       Class[] arrayOfClass = paramClass.getInterfaces();
/*  628 */       for (Class<?> clazz : arrayOfClass) {
/*      */         
/*  630 */         if (Modifier.isPublic(clazz.getModifiers()))
/*      */           
/*      */           try {
/*      */ 
/*      */             
/*  635 */             return clazz.getDeclaredMethod(paramString, paramVarArgs);
/*      */           }
/*  637 */           catch (NoSuchMethodException noSuchMethodException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  644 */             Method method = getAccessibleMethodFromInterfaceNest(clazz, paramString, paramVarArgs);
/*      */             
/*  646 */             if (method != null)
/*  647 */               return method; 
/*      */           }  
/*      */       } 
/*      */     } 
/*  651 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method getMatchingAccessibleMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/*      */     try {
/*  679 */       Method method = paramClass.getMethod(paramString, paramVarArgs);
/*  680 */       MemberUtils.setAccessibleWorkaround(method);
/*  681 */       return method;
/*  682 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */ 
/*      */       
/*  685 */       Method[] arrayOfMethod = paramClass.getMethods();
/*  686 */       ArrayList<Method> arrayList = new ArrayList();
/*  687 */       for (Method method1 : arrayOfMethod) {
/*      */         
/*  689 */         if (method1.getName().equals(paramString) && 
/*  690 */           MemberUtils.isMatchingMethod(method1, paramVarArgs)) {
/*  691 */           arrayList.add(method1);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  696 */       arrayList.sort(METHOD_BY_SIGNATURE);
/*      */       
/*  698 */       Method method = null;
/*  699 */       for (Method method1 : arrayList) {
/*      */         
/*  701 */         Method method2 = getAccessibleMethod(method1);
/*  702 */         if (method2 != null && (method == null || MemberUtils.compareMethodFit(method2, method, paramVarArgs) < 0))
/*      */         {
/*      */ 
/*      */           
/*  706 */           method = method2;
/*      */         }
/*      */       } 
/*  709 */       if (method != null) {
/*  710 */         MemberUtils.setAccessibleWorkaround(method);
/*      */       }
/*      */       
/*  713 */       if (method != null && method.isVarArgs() && (method.getParameterTypes()).length > 0 && paramVarArgs.length > 0) {
/*  714 */         Class[] arrayOfClass = method.getParameterTypes();
/*  715 */         Class<?> clazz1 = arrayOfClass[arrayOfClass.length - 1].getComponentType();
/*  716 */         String str1 = ClassUtils.primitiveToWrapper(clazz1).getName();
/*      */         
/*  718 */         Class<?> clazz2 = paramVarArgs[paramVarArgs.length - 1];
/*  719 */         String str2 = (clazz2 == null) ? null : clazz2.getName();
/*  720 */         String str3 = (clazz2 == null) ? null : clazz2.getSuperclass().getName();
/*      */         
/*  722 */         if (str2 != null && str3 != null && !str1.equals(str2) && 
/*  723 */           !str1.equals(str3)) {
/*  724 */           return null;
/*      */         }
/*      */       } 
/*      */       
/*  728 */       return method;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method getMatchingMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/*  743 */     Validate.notNull(paramClass, "Null class not allowed.", new Object[0]);
/*  744 */     Validate.notEmpty(paramString, "Null or blank methodName not allowed.", new Object[0]);
/*      */ 
/*      */     
/*  747 */     Method[] arrayOfMethod = paramClass.getDeclaredMethods();
/*  748 */     List list = ClassUtils.getAllSuperclasses(paramClass);
/*  749 */     for (Class clazz : list) {
/*  750 */       arrayOfMethod = (Method[])ArrayUtils.addAll((Object[])arrayOfMethod, (Object[])clazz.getDeclaredMethods());
/*      */     }
/*      */     
/*  753 */     Method method = null;
/*  754 */     for (Method method1 : arrayOfMethod) {
/*  755 */       if (paramString.equals(method1.getName()) && 
/*  756 */         Objects.deepEquals(paramVarArgs, method1.getParameterTypes()))
/*  757 */         return method1; 
/*  758 */       if (paramString.equals(method1.getName()) && 
/*  759 */         ClassUtils.isAssignable(paramVarArgs, method1.getParameterTypes(), true) && (
/*  760 */         method == null || distance(paramVarArgs, method1.getParameterTypes()) < 
/*  761 */         distance(paramVarArgs, method.getParameterTypes()))) {
/*  762 */         method = method1;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  767 */     return method;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int distance(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2) {
/*  778 */     int i = 0;
/*      */     
/*  780 */     if (!ClassUtils.isAssignable(paramArrayOfClass1, paramArrayOfClass2, true)) {
/*  781 */       return -1;
/*      */     }
/*  783 */     for (byte b = 0; b < paramArrayOfClass1.length; b++) {
/*      */       
/*  785 */       if (!paramArrayOfClass1[b].equals(paramArrayOfClass2[b]))
/*      */       {
/*  787 */         if (ClassUtils.isAssignable(paramArrayOfClass1[b], paramArrayOfClass2[b], true) && 
/*  788 */           !ClassUtils.isAssignable(paramArrayOfClass1[b], paramArrayOfClass2[b], false)) {
/*  789 */           i++;
/*      */         } else {
/*  791 */           i += 2;
/*      */         } 
/*      */       }
/*      */     } 
/*  795 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Set<Method> getOverrideHierarchy(Method paramMethod, ClassUtils.Interfaces paramInterfaces) {
/*  807 */     Validate.notNull(paramMethod);
/*  808 */     LinkedHashSet<Method> linkedHashSet = new LinkedHashSet();
/*  809 */     linkedHashSet.add(paramMethod);
/*      */     
/*  811 */     Class[] arrayOfClass = paramMethod.getParameterTypes();
/*      */     
/*  813 */     Class<?> clazz = paramMethod.getDeclaringClass();
/*      */     
/*  815 */     Iterator<Class<?>> iterator = ClassUtils.hierarchy(clazz, paramInterfaces).iterator();
/*      */     
/*  817 */     iterator.next();
/*  818 */     label21: while (iterator.hasNext()) {
/*  819 */       Class<?> clazz1 = iterator.next();
/*  820 */       Method method = getMatchingAccessibleMethod(clazz1, paramMethod.getName(), arrayOfClass);
/*  821 */       if (method == null) {
/*      */         continue;
/*      */       }
/*  824 */       if (Arrays.equals((Object[])method.getParameterTypes(), (Object[])arrayOfClass)) {
/*      */         
/*  826 */         linkedHashSet.add(method);
/*      */         
/*      */         continue;
/*      */       } 
/*  830 */       Map<TypeVariable<?>, Type> map = TypeUtils.getTypeArguments(clazz, method.getDeclaringClass());
/*  831 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/*  832 */         Type type1 = TypeUtils.unrollVariables(map, paramMethod.getGenericParameterTypes()[b]);
/*  833 */         Type type2 = TypeUtils.unrollVariables(map, method.getGenericParameterTypes()[b]);
/*  834 */         if (!TypeUtils.equals(type1, type2)) {
/*      */           continue label21;
/*      */         }
/*      */       } 
/*  838 */       linkedHashSet.add(method);
/*      */     } 
/*  840 */     return linkedHashSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method[] getMethodsWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1) {
/*  854 */     return getMethodsWithAnnotation(paramClass, paramClass1, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Method> getMethodsListWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1) {
/*  869 */     return getMethodsListWithAnnotation(paramClass, paramClass1, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method[] getMethodsWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1, boolean paramBoolean1, boolean paramBoolean2) {
/*  888 */     List<Method> list = getMethodsListWithAnnotation(paramClass, paramClass1, paramBoolean1, paramBoolean2);
/*      */     
/*  890 */     return list.<Method>toArray(ArrayUtils.EMPTY_METHOD_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Method> getMethodsListWithAnnotation(Class<?> paramClass, Class<? extends Annotation> paramClass1, boolean paramBoolean1, boolean paramBoolean2) {
/*  911 */     Validate.notNull(paramClass, "The class must not be null", new Object[0]);
/*  912 */     Validate.notNull(paramClass1, "The annotation class must not be null", new Object[0]);
/*  913 */     List<Class<?>> list = paramBoolean1 ? getAllSuperclassesAndInterfaces(paramClass) : new ArrayList();
/*      */     
/*  915 */     list.add(0, paramClass);
/*  916 */     ArrayList<Method> arrayList = new ArrayList();
/*  917 */     for (Class<?> clazz : list) {
/*  918 */       Method[] arrayOfMethod = paramBoolean2 ? clazz.getDeclaredMethods() : clazz.getMethods();
/*  919 */       for (Method method : arrayOfMethod) {
/*  920 */         if (method.getAnnotation(paramClass1) != null) {
/*  921 */           arrayList.add(method);
/*      */         }
/*      */       } 
/*      */     } 
/*  925 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <A extends Annotation> A getAnnotation(Method paramMethod, Class<A> paramClass, boolean paramBoolean1, boolean paramBoolean2) {
/*  953 */     Validate.notNull(paramMethod, "The method must not be null", new Object[0]);
/*  954 */     Validate.notNull(paramClass, "The annotation class must not be null", new Object[0]);
/*  955 */     if (!paramBoolean2 && !MemberUtils.isAccessible(paramMethod)) {
/*  956 */       return null;
/*      */     }
/*      */     
/*  959 */     A a = (A)paramMethod.getAnnotation((Class)paramClass);
/*      */     
/*  961 */     if (a == null && paramBoolean1) {
/*  962 */       Class<?> clazz = paramMethod.getDeclaringClass();
/*  963 */       List<Class<?>> list = getAllSuperclassesAndInterfaces(clazz);
/*  964 */       for (Class<?> clazz1 : list) {
/*      */         
/*  966 */         Method method = paramBoolean2 ? getMatchingMethod(clazz1, paramMethod.getName(), paramMethod.getParameterTypes()) : getMatchingAccessibleMethod(clazz1, paramMethod.getName(), paramMethod.getParameterTypes());
/*  967 */         if (method != null) {
/*  968 */           a = method.getAnnotation((Class)paramClass);
/*  969 */           if (a != null) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  976 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> paramClass) {
/*  990 */     if (paramClass == null) {
/*  991 */       return null;
/*      */     }
/*      */     
/*  994 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*  995 */     List<Class<?>> list1 = ClassUtils.getAllSuperclasses(paramClass);
/*  996 */     byte b1 = 0;
/*  997 */     List<Class<?>> list2 = ClassUtils.getAllInterfaces(paramClass);
/*  998 */     byte b2 = 0;
/*  999 */     while (b2 < list2.size() || b1 < list1
/* 1000 */       .size()) {
/*      */       Class<?> clazz;
/* 1002 */       if (b2 >= list2.size()) {
/* 1003 */         clazz = list1.get(b1++);
/* 1004 */       } else if (b1 >= list1.size() || b2 < b1 || b1 >= b2) {
/* 1005 */         clazz = list2.get(b2++);
/*      */       } else {
/* 1007 */         clazz = list1.get(b1++);
/*      */       } 
/* 1009 */       arrayList.add(clazz);
/*      */     } 
/* 1011 */     return arrayList;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\reflect\MethodUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */