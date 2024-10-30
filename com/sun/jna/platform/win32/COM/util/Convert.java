/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.Dispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatch;
/*     */ import com.sun.jna.platform.win32.COM.IUnknown;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WTypes;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Date;
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
/*     */ class Convert
/*     */ {
/*     */   public static Variant.VARIANT toVariant(Object paramObject) {
/*  92 */     if (paramObject instanceof Variant.VARIANT)
/*  93 */       return (Variant.VARIANT)paramObject; 
/*  94 */     if (paramObject instanceof Byte)
/*  95 */       return new Variant.VARIANT(((Byte)paramObject).byteValue()); 
/*  96 */     if (paramObject instanceof Character)
/*  97 */       return new Variant.VARIANT(((Character)paramObject).charValue()); 
/*  98 */     if (paramObject instanceof Short)
/*  99 */       return new Variant.VARIANT(((Short)paramObject).shortValue()); 
/* 100 */     if (paramObject instanceof Integer)
/* 101 */       return new Variant.VARIANT(((Integer)paramObject).intValue()); 
/* 102 */     if (paramObject instanceof Long)
/* 103 */       return new Variant.VARIANT(((Long)paramObject).longValue()); 
/* 104 */     if (paramObject instanceof Float)
/* 105 */       return new Variant.VARIANT(((Float)paramObject).floatValue()); 
/* 106 */     if (paramObject instanceof Double)
/* 107 */       return new Variant.VARIANT(((Double)paramObject).doubleValue()); 
/* 108 */     if (paramObject instanceof String)
/* 109 */       return new Variant.VARIANT((String)paramObject); 
/* 110 */     if (paramObject instanceof Boolean)
/* 111 */       return new Variant.VARIANT(((Boolean)paramObject).booleanValue()); 
/* 112 */     if (paramObject instanceof Dispatch)
/* 113 */       return new Variant.VARIANT((Dispatch)paramObject); 
/* 114 */     if (paramObject instanceof Date)
/* 115 */       return new Variant.VARIANT((Date)paramObject); 
/* 116 */     if (paramObject instanceof Proxy) {
/* 117 */       InvocationHandler invocationHandler = Proxy.getInvocationHandler(paramObject);
/* 118 */       ProxyObject proxyObject = (ProxyObject)invocationHandler;
/* 119 */       return new Variant.VARIANT(proxyObject.getRawDispatch());
/* 120 */     }  if (paramObject instanceof IComEnum) {
/* 121 */       IComEnum iComEnum = (IComEnum)paramObject;
/* 122 */       return new Variant.VARIANT(new WinDef.LONG(iComEnum.getValue()));
/*     */     } 
/* 124 */     Constructor<Variant.VARIANT> constructor = null;
/* 125 */     if (paramObject != null) {
/* 126 */       for (Constructor constructor1 : (Constructor[])Variant.VARIANT.class.getConstructors()) {
/* 127 */         Class[] arrayOfClass = constructor1.getParameterTypes();
/* 128 */         if (arrayOfClass.length == 1 && arrayOfClass[0]
/* 129 */           .isAssignableFrom(paramObject.getClass())) {
/* 130 */           constructor = constructor1;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 135 */     if (constructor != null) {
/*     */       try {
/* 137 */         return constructor.newInstance(new Object[] { paramObject });
/* 138 */       } catch (Exception exception) {
/* 139 */         throw new RuntimeException(exception);
/*     */       } 
/*     */     }
/* 142 */     return null;
/*     */   }
/*     */   
/*     */   public static Object toJavaObject(Variant.VARIANT paramVARIANT, Class<?> paramClass, ObjectFactory paramObjectFactory, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     Object object;
/* 147 */     int i = (paramVARIANT != null) ? paramVARIANT.getVarType().intValue() : 1;
/*     */     
/* 149 */     if (!i || i == 1) {
/* 150 */       return null;
/*     */     }
/*     */     
/* 153 */     if (paramClass != null && !paramClass.isAssignableFrom(Object.class)) {
/* 154 */       if (paramClass.isAssignableFrom(paramVARIANT.getClass())) {
/* 155 */         return paramVARIANT;
/*     */       }
/*     */       
/* 158 */       Object object1 = paramVARIANT.getValue();
/* 159 */       if (object1 != null && paramClass.isAssignableFrom(object1.getClass())) {
/* 160 */         return object1;
/*     */       }
/*     */     } 
/*     */     
/* 164 */     Variant.VARIANT vARIANT = paramVARIANT;
/*     */     
/* 166 */     if (i == 16396) {
/* 167 */       paramVARIANT = (Variant.VARIANT)paramVARIANT.getValue();
/* 168 */       i = paramVARIANT.getVarType().intValue();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 173 */     if (paramClass == null || paramClass.isAssignableFrom(Object.class)) {
/*     */       
/* 175 */       paramClass = null;
/*     */       
/* 177 */       switch (i) {
/*     */         case 16:
/*     */         case 17:
/* 180 */           paramClass = Byte.class;
/*     */           break;
/*     */         case 2:
/* 183 */           paramClass = Short.class;
/*     */           break;
/*     */         case 18:
/* 186 */           paramClass = Character.class;
/*     */           break;
/*     */         case 3:
/*     */         case 19:
/*     */         case 22:
/*     */         case 23:
/* 192 */           paramClass = Integer.class;
/*     */           break;
/*     */         case 20:
/*     */         case 21:
/* 196 */           paramClass = Long.class;
/*     */           break;
/*     */         case 4:
/* 199 */           paramClass = Float.class;
/*     */           break;
/*     */         case 5:
/* 202 */           paramClass = Double.class;
/*     */           break;
/*     */         case 11:
/* 205 */           paramClass = Boolean.class;
/*     */           break;
/*     */         case 10:
/* 208 */           paramClass = WinDef.SCODE.class;
/*     */           break;
/*     */         case 6:
/* 211 */           paramClass = OaIdl.CURRENCY.class;
/*     */           break;
/*     */         case 7:
/* 214 */           paramClass = Date.class;
/*     */           break;
/*     */         case 8:
/* 217 */           paramClass = String.class;
/*     */           break;
/*     */         case 13:
/* 220 */           paramClass = IUnknown.class;
/*     */           break;
/*     */         case 9:
/* 223 */           paramClass = IDispatch.class;
/*     */           break;
/*     */         case 16396:
/* 226 */           paramClass = Variant.class;
/*     */           break;
/*     */         case 16384:
/* 229 */           paramClass = WinDef.PVOID.class;
/*     */           break;
/*     */         case 16398:
/* 232 */           paramClass = OaIdl.DECIMAL.class;
/*     */           break;
/*     */         
/*     */         default:
/* 236 */           if ((i & 0x2000) > 0) {
/* 237 */             paramClass = OaIdl.SAFEARRAY.class;
/*     */           }
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 243 */     if (Byte.class.equals(paramClass) || byte.class.equals(paramClass)) {
/* 244 */       object = Byte.valueOf(paramVARIANT.byteValue());
/* 245 */     } else if (Short.class.equals(paramClass) || short.class.equals(paramClass)) {
/* 246 */       object = Short.valueOf(paramVARIANT.shortValue());
/* 247 */     } else if (Character.class.equals(paramClass) || char.class.equals(paramClass)) {
/* 248 */       object = Character.valueOf((char)paramVARIANT.intValue());
/* 249 */     } else if (Integer.class.equals(paramClass) || int.class.equals(paramClass)) {
/* 250 */       object = Integer.valueOf(paramVARIANT.intValue());
/* 251 */     } else if (Long.class.equals(paramClass) || long.class.equals(paramClass) || IComEnum.class.isAssignableFrom(paramClass)) {
/* 252 */       object = Long.valueOf(paramVARIANT.longValue());
/* 253 */     } else if (Float.class.equals(paramClass) || float.class.equals(paramClass)) {
/* 254 */       object = Float.valueOf(paramVARIANT.floatValue());
/* 255 */     } else if (Double.class.equals(paramClass) || double.class.equals(paramClass)) {
/* 256 */       object = Double.valueOf(paramVARIANT.doubleValue());
/* 257 */     } else if (Boolean.class.equals(paramClass) || boolean.class.equals(paramClass)) {
/* 258 */       object = Boolean.valueOf(paramVARIANT.booleanValue());
/* 259 */     } else if (Date.class.equals(paramClass)) {
/* 260 */       object = paramVARIANT.dateValue();
/* 261 */     } else if (String.class.equals(paramClass)) {
/* 262 */       object = paramVARIANT.stringValue();
/*     */     } else {
/* 264 */       object = paramVARIANT.getValue();
/* 265 */       if (object instanceof Dispatch) {
/* 266 */         Dispatch dispatch = (Dispatch)object;
/* 267 */         if (paramClass != null && paramClass.isInterface()) {
/* 268 */           Object object1 = paramObjectFactory.createProxy((Class)paramClass, (IDispatch)dispatch);
/*     */ 
/*     */           
/* 271 */           if (!paramBoolean1) {
/* 272 */             int j = dispatch.Release();
/*     */           }
/* 274 */           object = object1;
/*     */         } else {
/* 276 */           object = dispatch;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 281 */     if (IComEnum.class.isAssignableFrom(paramClass)) {
/* 282 */       object = paramClass.cast(toComEnum(paramClass, object));
/*     */     }
/*     */     
/* 285 */     if (paramBoolean2) {
/* 286 */       free(vARIANT, object);
/*     */     }
/*     */     
/* 289 */     return object;
/*     */   }
/*     */   
/*     */   public static <T extends IComEnum> T toComEnum(Class<T> paramClass, Object paramObject) {
/*     */     
/* 294 */     try { Method method = paramClass.getMethod("values", new Class[0]);
/* 295 */       IComEnum[] arrayOfIComEnum = (IComEnum[])method.invoke(null, new Object[0]);
/* 296 */       for (IComEnum iComEnum : arrayOfIComEnum) {
/* 297 */         if (paramObject.equals(Long.valueOf(iComEnum.getValue()))) {
/* 298 */           return (T)iComEnum;
/*     */         }
/*     */       }  }
/* 301 */     catch (NoSuchMethodException noSuchMethodException) {  }
/* 302 */     catch (IllegalAccessException illegalAccessException) {  }
/* 303 */     catch (IllegalArgumentException illegalArgumentException) {  }
/* 304 */     catch (InvocationTargetException invocationTargetException) {}
/*     */     
/* 306 */     return null;
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
/*     */   public static void free(Variant.VARIANT paramVARIANT, Class<?> paramClass) {
/* 320 */     if ((paramClass == null || !WTypes.BSTR.class.isAssignableFrom(paramClass)) && paramVARIANT != null && paramVARIANT
/*     */       
/* 322 */       .getVarType().intValue() == 8) {
/* 323 */       Object object = paramVARIANT.getValue();
/* 324 */       if (object instanceof WTypes.BSTR) {
/* 325 */         OleAuto.INSTANCE.SysFreeString((WTypes.BSTR)object);
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
/*     */   public static void free(Variant.VARIANT paramVARIANT, Object paramObject) {
/* 341 */     free(paramVARIANT, (paramObject == null) ? null : paramObject.getClass());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\Convert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */