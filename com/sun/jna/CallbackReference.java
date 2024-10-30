/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
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
/*     */ public class CallbackReference
/*     */   extends WeakReference<Callback>
/*     */ {
/*  52 */   static final Map<Callback, CallbackReference> callbackMap = new WeakHashMap<Callback, CallbackReference>();
/*  53 */   static final Map<Callback, CallbackReference> directCallbackMap = new WeakHashMap<Callback, CallbackReference>();
/*     */   
/*  55 */   static final Map<Pointer, Reference<Callback>[]> pointerCallbackMap = (Map)new WeakHashMap<Pointer, Reference<Callback>>();
/*     */ 
/*     */   
/*  58 */   static final Map<Object, Object> allocations = Collections.synchronizedMap(new WeakHashMap<Object, Object>());
/*     */ 
/*     */   
/*  61 */   private static final Map<CallbackReference, Reference<CallbackReference>> allocatedMemory = Collections.synchronizedMap(new WeakHashMap<CallbackReference, Reference<CallbackReference>>()); private static final Method PROXY_CALLBACK_METHOD;
/*     */   private static final Class<?> DLL_CALLBACK_CLASS;
/*     */   
/*     */   static {
/*     */     try {
/*  66 */       PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod("callback", new Class[] { Object[].class });
/*  67 */     } catch (Exception exception) {
/*  68 */       throw new Error("Error looking up CallbackProxy.callback() method");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (Platform.isWindows()) {
/*     */       try {
/*  77 */         DLL_CALLBACK_CLASS = Class.forName("com.sun.jna.win32.DLLCallback");
/*  78 */       } catch (ClassNotFoundException classNotFoundException) {
/*  79 */         throw new Error("Error loading DLLCallback class", classNotFoundException);
/*     */       } 
/*     */     } else {
/*  82 */       DLL_CALLBACK_CLASS = null;
/*     */     } 
/*     */   }
/*     */   
/*  86 */   private static final Map<Callback, CallbackThreadInitializer> initializers = new WeakHashMap<Callback, CallbackThreadInitializer>();
/*     */   Pointer cbstruct;
/*     */   Pointer trampoline;
/*     */   CallbackProxy proxy;
/*     */   Method method;
/*     */   int callingConvention;
/*     */   
/*     */   static CallbackThreadInitializer setCallbackThreadInitializer(Callback paramCallback, CallbackThreadInitializer paramCallbackThreadInitializer) {
/*  94 */     synchronized (initializers) {
/*  95 */       if (paramCallbackThreadInitializer != null) {
/*  96 */         return initializers.put(paramCallback, paramCallbackThreadInitializer);
/*     */       }
/*  98 */       return initializers.remove(paramCallback);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class AttachOptions
/*     */     extends Structure
/*     */   {
/*     */     AttachOptions() {
/* 110 */       setStringEncoding("utf8");
/*     */     }
/*     */     public static final List<String> FIELDS = createFieldsOrder(new String[] { "daemon", "detach", "name" }); public boolean daemon;
/*     */     
/*     */     protected List<String> getFieldOrder() {
/* 115 */       return FIELDS;
/*     */     }
/*     */     public boolean detach;
/*     */     public String name; }
/*     */   
/*     */   private static ThreadGroup initializeThread(Callback paramCallback, AttachOptions paramAttachOptions) {
/* 121 */     CallbackThreadInitializer callbackThreadInitializer = null;
/* 122 */     if (paramCallback instanceof DefaultCallbackProxy) {
/* 123 */       paramCallback = ((DefaultCallbackProxy)paramCallback).getCallback();
/*     */     }
/* 125 */     synchronized (initializers) {
/* 126 */       callbackThreadInitializer = initializers.get(paramCallback);
/*     */     } 
/* 128 */     ThreadGroup threadGroup = null;
/* 129 */     if (callbackThreadInitializer != null) {
/* 130 */       threadGroup = callbackThreadInitializer.getThreadGroup(paramCallback);
/* 131 */       paramAttachOptions.name = callbackThreadInitializer.getName(paramCallback);
/* 132 */       paramAttachOptions.daemon = callbackThreadInitializer.isDaemon(paramCallback);
/* 133 */       paramAttachOptions.detach = callbackThreadInitializer.detach(paramCallback);
/* 134 */       paramAttachOptions.write();
/*     */     } 
/* 136 */     return threadGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Callback getCallback(Class<?> paramClass, Pointer paramPointer) {
/* 147 */     return getCallback(paramClass, paramPointer, false);
/*     */   }
/*     */   
/*     */   private static Callback getCallback(Class<?> paramClass, Pointer paramPointer, boolean paramBoolean) {
/* 151 */     if (paramPointer == null) {
/* 152 */       return null;
/*     */     }
/*     */     
/* 155 */     if (!paramClass.isInterface())
/* 156 */       throw new IllegalArgumentException("Callback type must be an interface"); 
/* 157 */     Map<Callback, CallbackReference> map = paramBoolean ? directCallbackMap : callbackMap;
/* 158 */     synchronized (pointerCallbackMap) {
/* 159 */       Reference[] arrayOfReference = (Reference[])pointerCallbackMap.get(paramPointer);
/* 160 */       Callback callback = getTypeAssignableCallback(paramClass, (Reference<Callback>[])arrayOfReference);
/* 161 */       if (callback != null) {
/* 162 */         return callback;
/*     */       }
/* 164 */       callback = createCallback(paramClass, paramPointer);
/* 165 */       pointerCallbackMap.put(paramPointer, addCallbackToArray(callback, (Reference<Callback>[])arrayOfReference));
/*     */ 
/*     */       
/* 168 */       map.remove(callback);
/* 169 */       return callback;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Callback getTypeAssignableCallback(Class<?> paramClass, Reference<Callback>[] paramArrayOfReference) {
/* 174 */     if (paramArrayOfReference != null) {
/* 175 */       for (byte b = 0; b < paramArrayOfReference.length; b++) {
/* 176 */         Callback callback = paramArrayOfReference[b].get();
/* 177 */         if (callback != null && paramClass.isAssignableFrom(callback.getClass())) {
/* 178 */           return callback;
/*     */         }
/*     */       } 
/*     */     }
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Reference<Callback>[] addCallbackToArray(Callback paramCallback, Reference<Callback>[] paramArrayOfReference) {
/* 187 */     byte b1 = 1;
/* 188 */     if (paramArrayOfReference != null)
/*     */     {
/* 190 */       for (byte b = 0; b < paramArrayOfReference.length; b++) {
/* 191 */         if (paramArrayOfReference[b].get() == null) {
/* 192 */           paramArrayOfReference[b] = null;
/*     */         } else {
/*     */           
/* 195 */           b1++;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 200 */     Reference[] arrayOfReference = new Reference[b1];
/* 201 */     byte b2 = 0;
/* 202 */     if (paramArrayOfReference != null)
/*     */     {
/* 204 */       for (byte b = 0; b < paramArrayOfReference.length; b++) {
/* 205 */         if (paramArrayOfReference[b] != null) {
/* 206 */           arrayOfReference[b2++] = paramArrayOfReference[b];
/*     */         }
/*     */       } 
/*     */     }
/* 210 */     arrayOfReference[b2] = new WeakReference<Callback>(paramCallback);
/* 211 */     return (Reference<Callback>[])arrayOfReference;
/*     */   }
/*     */   
/*     */   private static Callback createCallback(Class<?> paramClass, Pointer paramPointer) {
/* 215 */     boolean bool = AltCallingConvention.class.isAssignableFrom(paramClass) ? true : false;
/*     */     
/* 217 */     HashMap<String, Object> hashMap = new HashMap<String, Object>(Native.getLibraryOptions(paramClass));
/* 218 */     hashMap.put("invoking-method", getCallbackMethod(paramClass));
/* 219 */     NativeFunctionHandler nativeFunctionHandler = new NativeFunctionHandler(paramPointer, bool, hashMap);
/* 220 */     return (Callback)Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, nativeFunctionHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CallbackReference(Callback paramCallback, int paramInt, boolean paramBoolean) {
/* 230 */     super(paramCallback);
/* 231 */     TypeMapper typeMapper = Native.getTypeMapper(paramCallback.getClass());
/* 232 */     this.callingConvention = paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     boolean bool = Platform.isPPC();
/* 239 */     if (paramBoolean) {
/* 240 */       Method method = getCallbackMethod(paramCallback);
/* 241 */       Class[] arrayOfClass = method.getParameterTypes();
/* 242 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/*     */         
/* 244 */         if (bool && (arrayOfClass[b] == float.class || arrayOfClass[b] == double.class)) {
/*     */           
/* 246 */           paramBoolean = false;
/*     */           
/*     */           break;
/*     */         } 
/* 250 */         if (typeMapper != null && typeMapper
/* 251 */           .getFromNativeConverter(arrayOfClass[b]) != null) {
/* 252 */           paramBoolean = false;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 257 */       if (typeMapper != null && typeMapper
/* 258 */         .getToNativeConverter(method.getReturnType()) != null) {
/* 259 */         paramBoolean = false;
/*     */       }
/*     */     } 
/*     */     
/* 263 */     String str = Native.getStringEncoding(paramCallback.getClass());
/* 264 */     long l = 0L;
/* 265 */     if (paramBoolean) {
/* 266 */       this.method = getCallbackMethod(paramCallback);
/* 267 */       Class[] arrayOfClass = this.method.getParameterTypes();
/* 268 */       Class<?> clazz = this.method.getReturnType();
/* 269 */       int i = 1;
/* 270 */       if (DLL_CALLBACK_CLASS != null && DLL_CALLBACK_CLASS
/* 271 */         .isInstance(paramCallback)) {
/* 272 */         i |= 0x2;
/*     */       }
/* 274 */       l = Native.createNativeCallback(paramCallback, this.method, arrayOfClass, clazz, paramInt, i, str);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 279 */       if (paramCallback instanceof CallbackProxy) {
/* 280 */         this.proxy = (CallbackProxy)paramCallback;
/*     */       } else {
/*     */         
/* 283 */         this.proxy = new DefaultCallbackProxy(getCallbackMethod(paramCallback), typeMapper, str);
/*     */       } 
/* 285 */       Class[] arrayOfClass = this.proxy.getParameterTypes();
/* 286 */       Class<?> clazz = this.proxy.getReturnType();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 291 */       if (typeMapper != null) {
/* 292 */         for (byte b1 = 0; b1 < arrayOfClass.length; b1++) {
/* 293 */           FromNativeConverter fromNativeConverter = typeMapper.getFromNativeConverter(arrayOfClass[b1]);
/* 294 */           if (fromNativeConverter != null) {
/* 295 */             arrayOfClass[b1] = fromNativeConverter.nativeType();
/*     */           }
/*     */         } 
/* 298 */         ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(clazz);
/* 299 */         if (toNativeConverter != null)
/* 300 */           clazz = toNativeConverter.nativeType(); 
/*     */       } 
/*     */       byte b;
/* 303 */       for (b = 0; b < arrayOfClass.length; b++) {
/* 304 */         arrayOfClass[b] = getNativeType(arrayOfClass[b]);
/* 305 */         if (!isAllowableNativeType(arrayOfClass[b])) {
/* 306 */           String str1 = "Callback argument " + arrayOfClass[b] + " requires custom type conversion";
/*     */           
/* 308 */           throw new IllegalArgumentException(str1);
/*     */         } 
/*     */       } 
/* 311 */       clazz = getNativeType(clazz);
/* 312 */       if (!isAllowableNativeType(clazz)) {
/* 313 */         String str1 = "Callback return type " + clazz + " requires custom type conversion";
/*     */         
/* 315 */         throw new IllegalArgumentException(str1);
/*     */       } 
/*     */       
/* 318 */       b = (DLL_CALLBACK_CLASS != null && DLL_CALLBACK_CLASS.isInstance(paramCallback)) ? 2 : 0;
/*     */       
/* 320 */       l = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, arrayOfClass, clazz, paramInt, b, str);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 325 */     this.cbstruct = (l != 0L) ? new Pointer(l) : null;
/* 326 */     allocatedMemory.put(this, new WeakReference<CallbackReference>(this));
/*     */   }
/*     */   
/*     */   private Class<?> getNativeType(Class<?> paramClass) {
/* 330 */     if (Structure.class.isAssignableFrom(paramClass))
/*     */     
/* 332 */     { Structure.validate((Class)paramClass);
/* 333 */       if (!Structure.ByValue.class.isAssignableFrom(paramClass))
/* 334 */         return Pointer.class;  }
/* 335 */     else { if (NativeMapped.class.isAssignableFrom(paramClass))
/* 336 */         return NativeMappedConverter.getInstance(paramClass).nativeType(); 
/* 337 */       if (paramClass == String.class || paramClass == WString.class || paramClass == String[].class || paramClass == WString[].class || Callback.class
/*     */ 
/*     */ 
/*     */         
/* 341 */         .isAssignableFrom(paramClass))
/* 342 */         return Pointer.class;  }
/*     */     
/* 344 */     return paramClass;
/*     */   }
/*     */   
/*     */   private static Method checkMethod(Method paramMethod) {
/* 348 */     if ((paramMethod.getParameterTypes()).length > 256) {
/* 349 */       String str = "Method signature exceeds the maximum parameter count: " + paramMethod;
/*     */       
/* 351 */       throw new UnsupportedOperationException(str);
/*     */     } 
/* 353 */     return paramMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Class<?> findCallbackClass(Class<?> paramClass) {
/* 362 */     if (!Callback.class.isAssignableFrom(paramClass)) {
/* 363 */       throw new IllegalArgumentException(paramClass.getName() + " is not derived from com.sun.jna.Callback");
/*     */     }
/* 365 */     if (paramClass.isInterface()) {
/* 366 */       return paramClass;
/*     */     }
/* 368 */     Class[] arrayOfClass = paramClass.getInterfaces();
/* 369 */     for (byte b = 0; b < arrayOfClass.length; b++) {
/* 370 */       if (Callback.class.isAssignableFrom(arrayOfClass[b])) {
/*     */         
/*     */         try {
/* 373 */           getCallbackMethod(arrayOfClass[b]);
/* 374 */           return arrayOfClass[b];
/*     */         }
/* 376 */         catch (IllegalArgumentException illegalArgumentException) {
/*     */           break;
/*     */         } 
/*     */       }
/*     */     } 
/* 381 */     if (Callback.class.isAssignableFrom(paramClass.getSuperclass())) {
/* 382 */       return findCallbackClass(paramClass.getSuperclass());
/*     */     }
/* 384 */     return paramClass;
/*     */   }
/*     */   
/*     */   private static Method getCallbackMethod(Callback paramCallback) {
/* 388 */     return getCallbackMethod(findCallbackClass(paramCallback.getClass()));
/*     */   }
/*     */ 
/*     */   
/*     */   private static Method getCallbackMethod(Class<?> paramClass) {
/* 393 */     Method[] arrayOfMethod1 = paramClass.getDeclaredMethods();
/* 394 */     Method[] arrayOfMethod2 = paramClass.getMethods();
/* 395 */     HashSet hashSet = new HashSet(Arrays.asList((Object[])arrayOfMethod1));
/* 396 */     hashSet.retainAll(Arrays.asList((Object[])arrayOfMethod2));
/*     */ 
/*     */     
/* 399 */     for (Iterator<Method> iterator = hashSet.iterator(); iterator.hasNext(); ) {
/* 400 */       Method method = iterator.next();
/* 401 */       if (Callback.FORBIDDEN_NAMES.contains(method.getName())) {
/* 402 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */     
/* 406 */     Method[] arrayOfMethod3 = (Method[])hashSet.toArray((Object[])new Method[0]);
/* 407 */     if (arrayOfMethod3.length == 1) {
/* 408 */       return checkMethod(arrayOfMethod3[0]);
/*     */     }
/* 410 */     for (byte b = 0; b < arrayOfMethod3.length; b++) {
/* 411 */       Method method = arrayOfMethod3[b];
/* 412 */       if ("callback".equals(method.getName())) {
/* 413 */         return checkMethod(method);
/*     */       }
/*     */     } 
/* 416 */     String str = "Callback must implement a single public method, or one public method named 'callback'";
/*     */     
/* 418 */     throw new IllegalArgumentException(str);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setCallbackOptions(int paramInt) {
/* 423 */     this.cbstruct.setInt(Native.POINTER_SIZE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Pointer getTrampoline() {
/* 428 */     if (this.trampoline == null) {
/* 429 */       this.trampoline = this.cbstruct.getPointer(0L);
/*     */     }
/* 431 */     return this.trampoline;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void finalize() {
/* 437 */     dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   protected synchronized void dispose() {
/* 442 */     if (this.cbstruct != null) {
/*     */       try {
/* 444 */         Native.freeNativeCallback(this.cbstruct.peer);
/*     */       } finally {
/* 446 */         this.cbstruct.peer = 0L;
/* 447 */         this.cbstruct = null;
/* 448 */         allocatedMemory.remove(this);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void disposeAll() {
/* 456 */     LinkedList linkedList = new LinkedList(allocatedMemory.keySet());
/* 457 */     for (CallbackReference callbackReference : linkedList) {
/* 458 */       callbackReference.dispose();
/*     */     }
/*     */   }
/*     */   
/*     */   private Callback getCallback() {
/* 463 */     return get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Pointer getNativeFunctionPointer(Callback paramCallback) {
/* 470 */     if (Proxy.isProxyClass(paramCallback.getClass())) {
/* 471 */       InvocationHandler invocationHandler = Proxy.getInvocationHandler(paramCallback);
/* 472 */       if (invocationHandler instanceof NativeFunctionHandler) {
/* 473 */         return ((NativeFunctionHandler)invocationHandler).getPointer();
/*     */       }
/*     */     } 
/* 476 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pointer getFunctionPointer(Callback paramCallback) {
/* 483 */     return getFunctionPointer(paramCallback, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Pointer getFunctionPointer(Callback paramCallback, boolean paramBoolean) {
/* 488 */     Pointer pointer = null;
/* 489 */     if (paramCallback == null) {
/* 490 */       return null;
/*     */     }
/* 492 */     if ((pointer = getNativeFunctionPointer(paramCallback)) != null) {
/* 493 */       return pointer;
/*     */     }
/* 495 */     Map<String, Object> map = Native.getLibraryOptions(paramCallback.getClass());
/*     */ 
/*     */ 
/*     */     
/* 499 */     boolean bool = (paramCallback instanceof AltCallingConvention) ? true : ((map != null && map.containsKey("calling-convention")) ? ((Integer)map.get("calling-convention")).intValue() : false);
/*     */ 
/*     */     
/* 502 */     Map<Callback, CallbackReference> map1 = paramBoolean ? directCallbackMap : callbackMap;
/* 503 */     synchronized (pointerCallbackMap) {
/* 504 */       CallbackReference callbackReference = map1.get(paramCallback);
/* 505 */       if (callbackReference == null) {
/* 506 */         callbackReference = new CallbackReference(paramCallback, bool, paramBoolean);
/* 507 */         map1.put(paramCallback, callbackReference);
/* 508 */         pointerCallbackMap.put(callbackReference.getTrampoline(), 
/* 509 */             addCallbackToArray(paramCallback, null));
/*     */         
/* 511 */         if (initializers.containsKey(paramCallback)) {
/* 512 */           callbackReference.setCallbackOptions(1);
/*     */         }
/*     */       } 
/* 515 */       return callbackReference.getTrampoline();
/*     */     } 
/*     */   }
/*     */   
/*     */   private class DefaultCallbackProxy implements CallbackProxy { private final Method callbackMethod;
/*     */     private ToNativeConverter toNative;
/*     */     private final FromNativeConverter[] fromNative;
/*     */     private final String encoding;
/*     */     
/*     */     public DefaultCallbackProxy(Method param1Method, TypeMapper param1TypeMapper, String param1String) {
/* 525 */       this.callbackMethod = param1Method;
/* 526 */       this.encoding = param1String;
/* 527 */       Class[] arrayOfClass = param1Method.getParameterTypes();
/* 528 */       Class<?> clazz = param1Method.getReturnType();
/* 529 */       this.fromNative = new FromNativeConverter[arrayOfClass.length];
/* 530 */       if (NativeMapped.class.isAssignableFrom(clazz)) {
/* 531 */         this.toNative = NativeMappedConverter.getInstance(clazz);
/*     */       }
/* 533 */       else if (param1TypeMapper != null) {
/* 534 */         this.toNative = param1TypeMapper.getToNativeConverter(clazz);
/*     */       } 
/* 536 */       for (byte b = 0; b < this.fromNative.length; b++) {
/* 537 */         if (NativeMapped.class.isAssignableFrom(arrayOfClass[b])) {
/* 538 */           this.fromNative[b] = new NativeMappedConverter(arrayOfClass[b]);
/*     */         }
/* 540 */         else if (param1TypeMapper != null) {
/* 541 */           this.fromNative[b] = param1TypeMapper.getFromNativeConverter(arrayOfClass[b]);
/*     */         } 
/*     */       } 
/* 544 */       if (!param1Method.isAccessible()) {
/*     */         try {
/* 546 */           param1Method.setAccessible(true);
/*     */         }
/* 548 */         catch (SecurityException securityException) {
/* 549 */           throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + param1Method);
/*     */         } 
/*     */       }
/*     */     }
/*     */     
/*     */     public Callback getCallback() {
/* 555 */       return CallbackReference.this.getCallback();
/*     */     }
/*     */     
/*     */     private Object invokeCallback(Object[] param1ArrayOfObject) {
/* 559 */       Class[] arrayOfClass = this.callbackMethod.getParameterTypes();
/* 560 */       Object[] arrayOfObject = new Object[param1ArrayOfObject.length];
/*     */ 
/*     */       
/* 563 */       for (byte b1 = 0; b1 < param1ArrayOfObject.length; b1++) {
/* 564 */         Class<?> clazz = arrayOfClass[b1];
/* 565 */         Object object1 = param1ArrayOfObject[b1];
/* 566 */         if (this.fromNative[b1] != null) {
/* 567 */           CallbackParameterContext callbackParameterContext = new CallbackParameterContext(clazz, this.callbackMethod, param1ArrayOfObject, b1);
/*     */           
/* 569 */           arrayOfObject[b1] = this.fromNative[b1].fromNative(object1, callbackParameterContext);
/*     */         } else {
/* 571 */           arrayOfObject[b1] = convertArgument(object1, clazz);
/*     */         } 
/*     */       } 
/*     */       
/* 575 */       Object object = null;
/* 576 */       Callback callback = getCallback();
/* 577 */       if (callback != null) {
/*     */         try {
/* 579 */           object = convertResult(this.callbackMethod.invoke(callback, arrayOfObject));
/*     */         }
/* 581 */         catch (IllegalArgumentException illegalArgumentException) {
/* 582 */           Native.getCallbackExceptionHandler().uncaughtException(callback, illegalArgumentException);
/*     */         }
/* 584 */         catch (IllegalAccessException illegalAccessException) {
/* 585 */           Native.getCallbackExceptionHandler().uncaughtException(callback, illegalAccessException);
/*     */         }
/* 587 */         catch (InvocationTargetException invocationTargetException) {
/* 588 */           Native.getCallbackExceptionHandler().uncaughtException(callback, invocationTargetException.getTargetException());
/*     */         } 
/*     */       }
/*     */       
/* 592 */       for (byte b2 = 0; b2 < arrayOfObject.length; b2++) {
/* 593 */         if (arrayOfObject[b2] instanceof Structure && !(arrayOfObject[b2] instanceof Structure.ByValue))
/*     */         {
/* 595 */           ((Structure)arrayOfObject[b2]).autoWrite();
/*     */         }
/*     */       } 
/*     */       
/* 599 */       return object;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object callback(Object[] param1ArrayOfObject) {
/*     */       try {
/* 610 */         return invokeCallback(param1ArrayOfObject);
/*     */       }
/* 612 */       catch (Throwable throwable) {
/* 613 */         Native.getCallbackExceptionHandler().uncaughtException(getCallback(), throwable);
/* 614 */         return null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object convertArgument(Object param1Object, Class<?> param1Class) {
/* 622 */       if (param1Object instanceof Pointer) {
/* 623 */         if (param1Class == String.class) {
/* 624 */           param1Object = ((Pointer)param1Object).getString(0L, this.encoding);
/*     */         }
/* 626 */         else if (param1Class == WString.class) {
/* 627 */           param1Object = new WString(((Pointer)param1Object).getWideString(0L));
/*     */         }
/* 629 */         else if (param1Class == String[].class) {
/* 630 */           param1Object = ((Pointer)param1Object).getStringArray(0L, this.encoding);
/*     */         }
/* 632 */         else if (param1Class == WString[].class) {
/* 633 */           param1Object = ((Pointer)param1Object).getWideStringArray(0L);
/*     */         }
/* 635 */         else if (Callback.class.isAssignableFrom(param1Class)) {
/* 636 */           param1Object = CallbackReference.getCallback(param1Class, (Pointer)param1Object);
/*     */         }
/* 638 */         else if (Structure.class.isAssignableFrom(param1Class)) {
/*     */ 
/*     */           
/* 641 */           if (Structure.ByValue.class.isAssignableFrom(param1Class)) {
/* 642 */             Structure structure = (Structure)Structure.newInstance((Class)param1Class);
/* 643 */             byte[] arrayOfByte = new byte[structure.size()];
/* 644 */             ((Pointer)param1Object).read(0L, arrayOfByte, 0, arrayOfByte.length);
/* 645 */             structure.getPointer().write(0L, arrayOfByte, 0, arrayOfByte.length);
/* 646 */             structure.read();
/* 647 */             param1Object = structure;
/*     */           } else {
/* 649 */             Structure structure = (Structure)Structure.newInstance((Class)param1Class, (Pointer)param1Object);
/* 650 */             structure.conditionalAutoRead();
/* 651 */             param1Object = structure;
/*     */           }
/*     */         
/*     */         } 
/* 655 */       } else if ((boolean.class == param1Class || Boolean.class == param1Class) && param1Object instanceof Number) {
/*     */         
/* 657 */         param1Object = Function.valueOf((((Number)param1Object).intValue() != 0));
/*     */       } 
/* 659 */       return param1Object;
/*     */     }
/*     */     
/*     */     private Object convertResult(Object param1Object) {
/* 663 */       if (this.toNative != null) {
/* 664 */         param1Object = this.toNative.toNative(param1Object, new CallbackResultContext(this.callbackMethod));
/*     */       }
/* 666 */       if (param1Object == null) {
/* 667 */         return null;
/*     */       }
/*     */       
/* 670 */       Class<?> clazz = param1Object.getClass();
/* 671 */       if (Structure.class.isAssignableFrom(clazz)) {
/* 672 */         if (Structure.ByValue.class.isAssignableFrom(clazz)) {
/* 673 */           return param1Object;
/*     */         }
/* 675 */         return ((Structure)param1Object).getPointer();
/* 676 */       }  if (clazz == boolean.class || clazz == Boolean.class) {
/* 677 */         return Boolean.TRUE.equals(param1Object) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
/*     */       }
/* 679 */       if (clazz == String.class || clazz == WString.class)
/* 680 */         return CallbackReference.getNativeString(param1Object, (clazz == WString.class)); 
/* 681 */       if (clazz == String[].class || clazz == WString[].class) {
/* 682 */         StringArray stringArray = (clazz == String[].class) ? new StringArray((String[])param1Object, this.encoding) : new StringArray((WString[])param1Object);
/*     */ 
/*     */ 
/*     */         
/* 686 */         CallbackReference.allocations.put(param1Object, stringArray);
/* 687 */         return stringArray;
/* 688 */       }  if (Callback.class.isAssignableFrom(clazz)) {
/* 689 */         return CallbackReference.getFunctionPointer((Callback)param1Object);
/*     */       }
/* 691 */       return param1Object;
/*     */     }
/*     */     
/*     */     public Class<?>[] getParameterTypes() {
/* 695 */       return this.callbackMethod.getParameterTypes();
/*     */     }
/*     */     
/*     */     public Class<?> getReturnType() {
/* 699 */       return this.callbackMethod.getReturnType();
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class NativeFunctionHandler
/*     */     implements InvocationHandler
/*     */   {
/*     */     private final Function function;
/*     */     
/*     */     private final Map<String, ?> options;
/*     */     
/*     */     public NativeFunctionHandler(Pointer param1Pointer, int param1Int, Map<String, ?> param1Map) {
/* 712 */       this.options = param1Map;
/* 713 */       this.function = new Function(param1Pointer, param1Int, (String)param1Map.get("string-encoding"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/* 719 */       if (Library.Handler.OBJECT_TOSTRING.equals(param1Method)) {
/* 720 */         String str = "Proxy interface to " + this.function;
/* 721 */         Method method = (Method)this.options.get("invoking-method");
/* 722 */         Class<?> clazz = CallbackReference.findCallbackClass(method.getDeclaringClass());
/* 723 */         str = str + " (" + clazz.getName() + ")";
/*     */         
/* 725 */         return str;
/* 726 */       }  if (Library.Handler.OBJECT_HASHCODE.equals(param1Method))
/* 727 */         return Integer.valueOf(hashCode()); 
/* 728 */       if (Library.Handler.OBJECT_EQUALS.equals(param1Method)) {
/* 729 */         Object object = param1ArrayOfObject[0];
/* 730 */         if (object != null && Proxy.isProxyClass(object.getClass())) {
/* 731 */           return Function.valueOf((Proxy.getInvocationHandler(object) == this));
/*     */         }
/* 733 */         return Boolean.FALSE;
/*     */       } 
/* 735 */       if (Function.isVarArgs(param1Method)) {
/* 736 */         param1ArrayOfObject = Function.concatenateVarArgs(param1ArrayOfObject);
/*     */       }
/* 738 */       return this.function.invoke(param1Method.getReturnType(), param1ArrayOfObject, this.options);
/*     */     }
/*     */     
/*     */     public Pointer getPointer() {
/* 742 */       return this.function;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isAllowableNativeType(Class<?> paramClass) {
/* 750 */     return (paramClass == void.class || paramClass == Void.class || paramClass == boolean.class || paramClass == Boolean.class || paramClass == byte.class || paramClass == Byte.class || paramClass == short.class || paramClass == Short.class || paramClass == char.class || paramClass == Character.class || paramClass == int.class || paramClass == Integer.class || paramClass == long.class || paramClass == Long.class || paramClass == float.class || paramClass == Float.class || paramClass == double.class || paramClass == Double.class || (Structure.ByValue.class
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 759 */       .isAssignableFrom(paramClass) && Structure.class
/* 760 */       .isAssignableFrom(paramClass)) || Pointer.class
/* 761 */       .isAssignableFrom(paramClass));
/*     */   }
/*     */   
/*     */   private static Pointer getNativeString(Object paramObject, boolean paramBoolean) {
/* 765 */     if (paramObject != null) {
/* 766 */       NativeString nativeString = new NativeString(paramObject.toString(), paramBoolean);
/*     */       
/* 768 */       allocations.put(paramObject, nativeString);
/* 769 */       return nativeString.getPointer();
/*     */     } 
/* 771 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\CallbackReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */