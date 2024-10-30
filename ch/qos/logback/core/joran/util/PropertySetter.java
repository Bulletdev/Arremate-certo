/*     */ package ch.qos.logback.core.joran.util;
/*     */ 
/*     */ import ch.qos.logback.core.joran.spi.DefaultClass;
/*     */ import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
/*     */ import ch.qos.logback.core.joran.util.beans.BeanDescription;
/*     */ import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
/*     */ import ch.qos.logback.core.joran.util.beans.BeanUtil;
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.util.AggregationType;
/*     */ import ch.qos.logback.core.util.PropertySetterException;
/*     */ import java.lang.reflect.Method;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PropertySetter
/*     */   extends ContextAwareBase
/*     */ {
/*     */   protected final Object obj;
/*     */   protected final Class<?> objClass;
/*     */   protected final BeanDescription beanDescription;
/*     */   
/*     */   public PropertySetter(BeanDescriptionCache paramBeanDescriptionCache, Object paramObject) {
/*  66 */     this.obj = paramObject;
/*  67 */     this.objClass = paramObject.getClass();
/*  68 */     this.beanDescription = paramBeanDescriptionCache.getBeanDescription(this.objClass);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperty(String paramString1, String paramString2) {
/*  90 */     if (paramString2 == null) {
/*     */       return;
/*     */     }
/*  93 */     Method method = findSetterMethod(paramString1);
/*  94 */     if (method == null) {
/*  95 */       addWarn("No setter for property [" + paramString1 + "] in " + this.objClass.getName() + ".");
/*     */     } else {
/*     */       try {
/*  98 */         setProperty(method, paramString1, paramString2);
/*  99 */       } catch (PropertySetterException propertySetterException) {
/* 100 */         addWarn("Failed to set property [" + paramString1 + "] to value \"" + paramString2 + "\". ", (Throwable)propertySetterException);
/*     */       } 
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
/*     */   private void setProperty(Method paramMethod, String paramString1, String paramString2) throws PropertySetterException {
/*     */     Object object;
/* 117 */     Class[] arrayOfClass = paramMethod.getParameterTypes();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 122 */       object = StringToObjectConverter.convertArg((ContextAware)this, paramString2, arrayOfClass[0]);
/* 123 */     } catch (Throwable throwable) {
/* 124 */       throw new PropertySetterException("Conversion to type [" + arrayOfClass[0] + "] failed. ", throwable);
/*     */     } 
/*     */     
/* 127 */     if (object == null) {
/* 128 */       throw new PropertySetterException("Conversion to type [" + arrayOfClass[0] + "] failed.");
/*     */     }
/*     */     try {
/* 131 */       paramMethod.invoke(this.obj, new Object[] { object });
/* 132 */     } catch (Exception exception) {
/* 133 */       throw new PropertySetterException(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public AggregationType computeAggregationType(String paramString) {
/* 138 */     String str = capitalizeFirstLetter(paramString);
/*     */     
/* 140 */     Method method1 = findAdderMethod(str);
/*     */     
/* 142 */     if (method1 != null) {
/* 143 */       AggregationType aggregationType = computeRawAggregationType(method1);
/* 144 */       switch (null.q[aggregationType.ordinal()]) {
/*     */         case 1:
/* 146 */           return AggregationType.NOT_FOUND;
/*     */         case 2:
/* 148 */           return AggregationType.AS_BASIC_PROPERTY_COLLECTION;
/*     */         
/*     */         case 3:
/* 151 */           return AggregationType.AS_COMPLEX_PROPERTY_COLLECTION;
/*     */         case 4:
/*     */         case 5:
/* 154 */           addError("Unexpected AggregationType " + aggregationType);
/*     */           break;
/*     */       } 
/*     */     } 
/* 158 */     Method method2 = findSetterMethod(paramString);
/* 159 */     if (method2 != null) {
/* 160 */       return computeRawAggregationType(method2);
/*     */     }
/*     */     
/* 163 */     return AggregationType.NOT_FOUND;
/*     */   }
/*     */ 
/*     */   
/*     */   private Method findAdderMethod(String paramString) {
/* 168 */     String str = BeanUtil.toLowerCamelCase(paramString);
/* 169 */     return this.beanDescription.getAdder(str);
/*     */   }
/*     */   
/*     */   private Method findSetterMethod(String paramString) {
/* 173 */     String str = BeanUtil.toLowerCamelCase(paramString);
/* 174 */     return this.beanDescription.getSetter(str);
/*     */   }
/*     */   
/*     */   private Class<?> getParameterClassForMethod(Method paramMethod) {
/* 178 */     if (paramMethod == null) {
/* 179 */       return null;
/*     */     }
/* 181 */     Class[] arrayOfClass = paramMethod.getParameterTypes();
/* 182 */     if (arrayOfClass.length != 1) {
/* 183 */       return null;
/*     */     }
/* 185 */     return arrayOfClass[0];
/*     */   }
/*     */ 
/*     */   
/*     */   private AggregationType computeRawAggregationType(Method paramMethod) {
/* 190 */     Class<?> clazz = getParameterClassForMethod(paramMethod);
/* 191 */     if (clazz == null) {
/* 192 */       return AggregationType.NOT_FOUND;
/*     */     }
/* 194 */     if (StringToObjectConverter.canBeBuiltFromSimpleString(clazz)) {
/* 195 */       return AggregationType.AS_BASIC_PROPERTY;
/*     */     }
/* 197 */     return AggregationType.AS_COMPLEX_PROPERTY;
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
/*     */   private boolean isUnequivocallyInstantiable(Class<?> paramClass) {
/* 209 */     if (paramClass.isInterface()) {
/* 210 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 217 */       Object object = paramClass.newInstance();
/* 218 */       if (object != null) {
/* 219 */         return true;
/*     */       }
/* 221 */       return false;
/*     */     }
/* 223 */     catch (InstantiationException instantiationException) {
/* 224 */       return false;
/* 225 */     } catch (IllegalAccessException illegalAccessException) {
/* 226 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Class<?> getObjClass() {
/* 231 */     return this.objClass;
/*     */   }
/*     */   
/*     */   public void addComplexProperty(String paramString, Object paramObject) {
/* 235 */     Method method = findAdderMethod(paramString);
/*     */     
/* 237 */     if (method != null) {
/* 238 */       Class[] arrayOfClass = method.getParameterTypes();
/* 239 */       if (!isSanityCheckSuccessful(paramString, method, arrayOfClass, paramObject)) {
/*     */         return;
/*     */       }
/* 242 */       invokeMethodWithSingleParameterOnThisObject(method, paramObject);
/*     */     } else {
/* 244 */       addError("Could not find method [add" + paramString + "] in class [" + this.objClass.getName() + "].");
/*     */     } 
/*     */   }
/*     */   
/*     */   void invokeMethodWithSingleParameterOnThisObject(Method paramMethod, Object paramObject) {
/* 249 */     Class<?> clazz = paramObject.getClass();
/*     */     try {
/* 251 */       paramMethod.invoke(this.obj, new Object[] { paramObject });
/* 252 */     } catch (Exception exception) {
/* 253 */       addError("Could not invoke method " + paramMethod.getName() + " in class " + this.obj.getClass().getName() + " with parameter of type " + clazz.getName(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addBasicProperty(String paramString1, String paramString2) {
/*     */     Object object;
/* 259 */     if (paramString2 == null) {
/*     */       return;
/*     */     }
/*     */     
/* 263 */     paramString1 = capitalizeFirstLetter(paramString1);
/* 264 */     Method method = findAdderMethod(paramString1);
/*     */     
/* 266 */     if (method == null) {
/* 267 */       addError("No adder for property [" + paramString1 + "].");
/*     */       
/*     */       return;
/*     */     } 
/* 271 */     Class[] arrayOfClass = method.getParameterTypes();
/* 272 */     isSanityCheckSuccessful(paramString1, method, arrayOfClass, paramString2);
/*     */ 
/*     */     
/*     */     try {
/* 276 */       object = StringToObjectConverter.convertArg((ContextAware)this, paramString2, arrayOfClass[0]);
/* 277 */     } catch (Throwable throwable) {
/* 278 */       addError("Conversion to type [" + arrayOfClass[0] + "] failed. ", throwable);
/*     */       return;
/*     */     } 
/* 281 */     if (object != null) {
/* 282 */       invokeMethodWithSingleParameterOnThisObject(method, paramString2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setComplexProperty(String paramString, Object paramObject) {
/* 287 */     Method method = findSetterMethod(paramString);
/*     */     
/* 289 */     if (method == null) {
/* 290 */       addWarn("Not setter method for property [" + paramString + "] in " + this.obj.getClass().getName());
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 295 */     Class[] arrayOfClass = method.getParameterTypes();
/*     */     
/* 297 */     if (!isSanityCheckSuccessful(paramString, method, arrayOfClass, paramObject)) {
/*     */       return;
/*     */     }
/*     */     try {
/* 301 */       invokeMethodWithSingleParameterOnThisObject(method, paramObject);
/*     */     }
/* 303 */     catch (Exception exception) {
/* 304 */       addError("Could not set component " + this.obj + " for parent component " + this.obj, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isSanityCheckSuccessful(String paramString, Method paramMethod, Class<?>[] paramArrayOfClass, Object paramObject) {
/* 309 */     Class<?> clazz = paramObject.getClass();
/* 310 */     if (paramArrayOfClass.length != 1) {
/* 311 */       addError("Wrong number of parameters in setter method for property [" + paramString + "] in " + this.obj.getClass().getName());
/*     */       
/* 313 */       return false;
/*     */     } 
/*     */     
/* 316 */     if (!paramArrayOfClass[0].isAssignableFrom(paramObject.getClass())) {
/* 317 */       addError("A \"" + clazz.getName() + "\" object is not assignable to a \"" + paramArrayOfClass[0].getName() + "\" variable.");
/* 318 */       addError("The class \"" + paramArrayOfClass[0].getName() + "\" was loaded by ");
/* 319 */       addError("[" + paramArrayOfClass[0].getClassLoader() + "] whereas object of type ");
/* 320 */       addError("\"" + clazz.getName() + "\" was loaded by [" + clazz.getClassLoader() + "].");
/* 321 */       return false;
/*     */     } 
/*     */     
/* 324 */     return true;
/*     */   }
/*     */   
/*     */   private String capitalizeFirstLetter(String paramString) {
/* 328 */     return paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
/*     */   }
/*     */   
/*     */   public Object getObj() {
/* 332 */     return this.obj;
/*     */   }
/*     */   
/*     */   Method getRelevantMethod(String paramString, AggregationType paramAggregationType) {
/*     */     Method method;
/* 337 */     if (paramAggregationType == AggregationType.AS_COMPLEX_PROPERTY_COLLECTION) {
/* 338 */       method = findAdderMethod(paramString);
/* 339 */     } else if (paramAggregationType == AggregationType.AS_COMPLEX_PROPERTY) {
/* 340 */       method = findSetterMethod(paramString);
/*     */     } else {
/* 342 */       throw new IllegalStateException(paramAggregationType + " not allowed here");
/*     */     } 
/* 344 */     return method;
/*     */   }
/*     */ 
/*     */   
/*     */   <T extends java.lang.annotation.Annotation> T getAnnotation(String paramString, Class<T> paramClass, Method paramMethod) {
/* 349 */     if (paramMethod != null) {
/* 350 */       return paramMethod.getAnnotation(paramClass);
/*     */     }
/* 352 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> getDefaultClassNameByAnnonation(String paramString, Method paramMethod) {
/* 357 */     DefaultClass defaultClass = getAnnotation(paramString, DefaultClass.class, paramMethod);
/* 358 */     if (defaultClass != null) {
/* 359 */       return defaultClass.value();
/*     */     }
/* 361 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> getByConcreteType(String paramString, Method paramMethod) {
/* 366 */     Class<?> clazz = getParameterClassForMethod(paramMethod);
/* 367 */     if (clazz == null) {
/* 368 */       return null;
/*     */     }
/*     */     
/* 371 */     boolean bool = isUnequivocallyInstantiable(clazz);
/* 372 */     if (bool) {
/* 373 */       return clazz;
/*     */     }
/* 375 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getClassNameViaImplicitRules(String paramString, AggregationType paramAggregationType, DefaultNestedComponentRegistry paramDefaultNestedComponentRegistry) {
/* 382 */     Class<?> clazz1 = paramDefaultNestedComponentRegistry.findDefaultComponentType(this.obj.getClass(), paramString);
/* 383 */     if (clazz1 != null) {
/* 384 */       return clazz1;
/*     */     }
/*     */     
/* 387 */     Method method = getRelevantMethod(paramString, paramAggregationType);
/* 388 */     if (method == null) {
/* 389 */       return null;
/*     */     }
/* 391 */     Class<?> clazz2 = getDefaultClassNameByAnnonation(paramString, method);
/* 392 */     if (clazz2 != null) {
/* 393 */       return clazz2;
/*     */     }
/* 395 */     return getByConcreteType(paramString, method);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\PropertySetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */