/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.internal.ReflectionUtils;
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.COMUtils;
/*     */ import com.sun.jna.platform.win32.COM.ConnectionPoint;
/*     */ import com.sun.jna.platform.win32.COM.ConnectionPointContainer;
/*     */ import com.sun.jna.platform.win32.COM.Dispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatchCallback;
/*     */ import com.sun.jna.platform.win32.COM.IUnknown;
/*     */ import com.sun.jna.platform.win32.COM.IUnknownCallback;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComInterface;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComProperty;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.Kernel32Util;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
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
/*     */ public class ProxyObject
/*     */   implements IConnectionPoint, IDispatch, IRawDispatchHandle, InvocationHandler
/*     */ {
/*     */   private long unknownId;
/*     */   private final Class<?> theInterface;
/*     */   private final ObjectFactory factory;
/*     */   private final IDispatch rawDispatch;
/*     */   
/*     */   public ProxyObject(Class<?> paramClass, IDispatch paramIDispatch, ObjectFactory paramObjectFactory) {
/*  87 */     this.unknownId = -1L;
/*  88 */     this.rawDispatch = paramIDispatch;
/*  89 */     this.theInterface = paramClass;
/*  90 */     this.factory = paramObjectFactory;
/*     */ 
/*     */     
/*  93 */     int i = this.rawDispatch.AddRef();
/*  94 */     getUnknownId();
/*  95 */     paramObjectFactory.register(this);
/*     */   }
/*     */   
/*     */   private long getUnknownId() {
/*  99 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 101 */     if (-1L == this.unknownId) {
/*     */       try {
/* 103 */         PointerByReference pointerByReference = new PointerByReference();
/*     */         
/* 105 */         Thread thread = Thread.currentThread();
/* 106 */         String str = thread.getName();
/*     */         
/* 108 */         Guid.IID iID = IUnknown.IID_IUNKNOWN;
/* 109 */         WinNT.HRESULT hRESULT = getRawDispatch().QueryInterface(new Guid.REFIID(iID), pointerByReference);
/*     */         
/* 111 */         if (WinNT.S_OK.equals(hRESULT)) {
/* 112 */           Dispatch dispatch = new Dispatch(pointerByReference.getValue());
/* 113 */           this.unknownId = Pointer.nativeValue(dispatch.getPointer());
/*     */ 
/*     */ 
/*     */           
/* 117 */           int i = dispatch.Release();
/*     */         } else {
/* 119 */           String str1 = Kernel32Util.formatMessage(hRESULT);
/* 120 */           throw new COMException("getUnknownId: " + str1, hRESULT);
/*     */         } 
/* 122 */       } catch (RuntimeException runtimeException) {
/*     */         
/* 124 */         if (runtimeException instanceof COMException) {
/* 125 */           throw runtimeException;
/*     */         }
/* 127 */         throw new COMException("Error occured when trying get Unknown Id ", runtimeException);
/*     */       } 
/*     */     }
/*     */     
/* 131 */     return this.unknownId;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 136 */     dispose();
/* 137 */     super.finalize();
/*     */   }
/*     */   
/*     */   public synchronized void dispose() {
/* 141 */     if (((Dispatch)this.rawDispatch).getPointer() != Pointer.NULL) {
/* 142 */       this.rawDispatch.Release();
/* 143 */       ((Dispatch)this.rawDispatch).setPointer(Pointer.NULL);
/* 144 */       this.factory.unregister(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public IDispatch getRawDispatch() {
/* 150 */     return this.rawDispatch;
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
/*     */   public boolean equals(Object paramObject) {
/* 165 */     if (null == paramObject)
/* 166 */       return false; 
/* 167 */     if (paramObject instanceof ProxyObject) {
/* 168 */       ProxyObject proxyObject = (ProxyObject)paramObject;
/* 169 */       return (getUnknownId() == proxyObject.getUnknownId());
/* 170 */     }  if (Proxy.isProxyClass(paramObject.getClass())) {
/* 171 */       InvocationHandler invocationHandler = Proxy.getInvocationHandler(paramObject);
/* 172 */       if (invocationHandler instanceof ProxyObject) {
/*     */         try {
/* 174 */           ProxyObject proxyObject = (ProxyObject)invocationHandler;
/* 175 */           return (getUnknownId() == proxyObject.getUnknownId());
/* 176 */         } catch (Exception exception) {
/*     */ 
/*     */           
/* 179 */           return false;
/*     */         } 
/*     */       }
/* 182 */       return false;
/*     */     } 
/*     */     
/* 185 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 191 */     long l = getUnknownId();
/* 192 */     return (int)(l >>> 32L & 0xFFFFFFFFFFFFFFFFL) + (int)(l & 0xFFFFFFFFFFFFFFFFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     return this.theInterface.getName() + "{unk=" + hashCode() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable {
/* 206 */     boolean bool = (paramMethod.getAnnotation(ComMethod.class) != null || paramMethod.getAnnotation(ComProperty.class) != null) ? true : false;
/*     */     
/* 208 */     if (!bool && (paramMethod.getDeclaringClass().equals(Object.class) || paramMethod
/* 209 */       .getDeclaringClass().equals(IRawDispatchHandle.class) || paramMethod
/* 210 */       .getDeclaringClass().equals(IUnknown.class) || paramMethod
/* 211 */       .getDeclaringClass().equals(IDispatch.class) || paramMethod
/* 212 */       .getDeclaringClass().equals(IConnectionPoint.class))) {
/*     */       try {
/* 214 */         return paramMethod.invoke(this, paramArrayOfObject);
/* 215 */       } catch (InvocationTargetException invocationTargetException) {
/* 216 */         throw invocationTargetException.getCause();
/*     */       } 
/*     */     }
/*     */     
/* 220 */     if (!bool && ReflectionUtils.isDefault(paramMethod)) {
/* 221 */       Object object = ReflectionUtils.getMethodHandle(paramMethod);
/* 222 */       return ReflectionUtils.invokeDefaultMethod(paramObject, object, paramArrayOfObject);
/*     */     } 
/*     */     
/* 225 */     Class<?> clazz = paramMethod.getReturnType();
/* 226 */     boolean bool1 = void.class.equals(clazz);
/*     */     
/* 228 */     ComProperty comProperty = paramMethod.<ComProperty>getAnnotation(ComProperty.class);
/* 229 */     if (null != comProperty) {
/* 230 */       int i = comProperty.dispId();
/* 231 */       Object[] arrayOfObject = unfoldWhenVarargs(paramMethod, paramArrayOfObject);
/* 232 */       if (bool1) {
/* 233 */         if (i != -1) {
/* 234 */           setProperty(new OaIdl.DISPID(i), arrayOfObject);
/* 235 */           return null;
/*     */         } 
/* 237 */         String str1 = getMutatorName(paramMethod, comProperty);
/* 238 */         setProperty(str1, arrayOfObject);
/* 239 */         return null;
/*     */       } 
/*     */       
/* 242 */       if (i != -1) {
/* 243 */         return getProperty(clazz, new OaIdl.DISPID(i), paramArrayOfObject);
/*     */       }
/* 245 */       String str = getAccessorName(paramMethod, comProperty);
/* 246 */       return getProperty(clazz, str, paramArrayOfObject);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 251 */     ComMethod comMethod = paramMethod.<ComMethod>getAnnotation(ComMethod.class);
/* 252 */     if (null != comMethod) {
/* 253 */       Object[] arrayOfObject = unfoldWhenVarargs(paramMethod, paramArrayOfObject);
/* 254 */       int i = comMethod.dispId();
/* 255 */       if (i != -1) {
/* 256 */         return invokeMethod(clazz, new OaIdl.DISPID(i), arrayOfObject);
/*     */       }
/* 258 */       String str = getMethodName(paramMethod, comMethod);
/* 259 */       return invokeMethod(clazz, str, arrayOfObject);
/*     */     } 
/*     */ 
/*     */     
/* 263 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ConnectionPoint fetchRawConnectionPoint(Guid.IID paramIID) {
/* 268 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */ 
/*     */     
/* 271 */     IConnectionPointContainer iConnectionPointContainer = queryInterface(IConnectionPointContainer.class);
/* 272 */     Dispatch dispatch = (Dispatch)iConnectionPointContainer.getRawDispatch();
/* 273 */     ConnectionPointContainer connectionPointContainer = new ConnectionPointContainer(dispatch.getPointer());
/*     */ 
/*     */     
/* 276 */     Guid.REFIID rEFIID = new Guid.REFIID(paramIID.getPointer());
/* 277 */     PointerByReference pointerByReference = new PointerByReference();
/* 278 */     WinNT.HRESULT hRESULT = connectionPointContainer.FindConnectionPoint(rEFIID, pointerByReference);
/* 279 */     COMUtils.checkRC(hRESULT);
/* 280 */     return new ConnectionPoint(pointerByReference.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IComEventCallbackCookie advise(Class<?> paramClass, IComEventCallbackListener paramIComEventCallbackListener) throws COMException {
/* 288 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*     */     try {
/* 291 */       ComInterface comInterface = paramClass.<ComInterface>getAnnotation(ComInterface.class);
/* 292 */       if (null == comInterface) {
/* 293 */         throw new COMException("advise: Interface must define a value for either iid via the ComInterface annotation");
/*     */       }
/*     */       
/* 296 */       Guid.IID iID = getIID(comInterface);
/*     */       
/* 298 */       ConnectionPoint connectionPoint = fetchRawConnectionPoint(iID);
/*     */ 
/*     */       
/* 301 */       IDispatchCallback iDispatchCallback = this.factory.createDispatchCallback(paramClass, paramIComEventCallbackListener);
/*     */ 
/*     */       
/* 304 */       paramIComEventCallbackListener.setDispatchCallbackListener(iDispatchCallback);
/*     */ 
/*     */       
/* 307 */       WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
/* 308 */       WinNT.HRESULT hRESULT = connectionPoint.Advise((IUnknownCallback)iDispatchCallback, dWORDByReference);
/* 309 */       int i = connectionPoint.Release();
/*     */       
/* 311 */       COMUtils.checkRC(hRESULT);
/*     */ 
/*     */       
/* 314 */       return new ComEventCallbackCookie(dWORDByReference.getValue());
/*     */     }
/* 316 */     catch (RuntimeException runtimeException) {
/*     */       
/* 318 */       if (runtimeException instanceof COMException) {
/* 319 */         throw runtimeException;
/*     */       }
/* 321 */       throw new COMException("Error occured in advise when trying to connect the listener " + paramIComEventCallbackListener, runtimeException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unadvise(Class<?> paramClass, IComEventCallbackCookie paramIComEventCallbackCookie) throws COMException {
/* 328 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*     */     try {
/* 331 */       ComInterface comInterface = paramClass.<ComInterface>getAnnotation(ComInterface.class);
/* 332 */       if (null == comInterface) {
/* 333 */         throw new COMException("unadvise: Interface must define a value for iid via the ComInterface annotation");
/*     */       }
/*     */       
/* 336 */       Guid.IID iID = getIID(comInterface);
/*     */       
/* 338 */       ConnectionPoint connectionPoint = fetchRawConnectionPoint(iID);
/*     */       
/* 340 */       WinNT.HRESULT hRESULT = connectionPoint.Unadvise(((ComEventCallbackCookie)paramIComEventCallbackCookie).getValue());
/*     */       
/* 342 */       connectionPoint.Release();
/* 343 */       COMUtils.checkRC(hRESULT);
/*     */     }
/* 345 */     catch (RuntimeException runtimeException) {
/*     */       
/* 347 */       if (runtimeException instanceof COMException) {
/* 348 */         throw runtimeException;
/*     */       }
/* 350 */       throw new COMException("Error occured in unadvise when trying to disconnect the listener from " + this, runtimeException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> void setProperty(String paramString, T paramT) {
/* 358 */     OaIdl.DISPID dISPID = resolveDispId(getRawDispatch(), paramString);
/* 359 */     setProperty(dISPID, paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> void setProperty(OaIdl.DISPID paramDISPID, T paramT) {
/* 364 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 366 */     Variant.VARIANT vARIANT = Convert.toVariant(paramT);
/* 367 */     WinNT.HRESULT hRESULT = oleMethod(4, (Variant.VARIANT.ByReference)null, getRawDispatch(), paramDISPID, vARIANT);
/* 368 */     Convert.free(vARIANT, paramT);
/* 369 */     COMUtils.checkRC(hRESULT);
/*     */   }
/*     */   
/*     */   private void setProperty(String paramString, Object... paramVarArgs) {
/* 373 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/* 374 */     OaIdl.DISPID dISPID = resolveDispId(getRawDispatch(), paramString);
/* 375 */     setProperty(dISPID, paramVarArgs);
/*     */   }
/*     */   private void setProperty(OaIdl.DISPID paramDISPID, Object... paramVarArgs) {
/*     */     Variant.VARIANT[] arrayOfVARIANT;
/* 379 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */ 
/*     */     
/* 382 */     if (null == paramVarArgs) {
/* 383 */       arrayOfVARIANT = new Variant.VARIANT[0];
/*     */     } else {
/* 385 */       arrayOfVARIANT = new Variant.VARIANT[paramVarArgs.length];
/*     */     } 
/* 387 */     for (byte b1 = 0; b1 < arrayOfVARIANT.length; b1++) {
/* 388 */       arrayOfVARIANT[b1] = Convert.toVariant(paramVarArgs[b1]);
/*     */     }
/* 390 */     WinNT.HRESULT hRESULT = oleMethod(4, (Variant.VARIANT.ByReference)null, getRawDispatch(), paramDISPID, arrayOfVARIANT);
/*     */     
/* 392 */     for (byte b2 = 0; b2 < arrayOfVARIANT.length; b2++)
/*     */     {
/* 394 */       Convert.free(arrayOfVARIANT[b2], paramVarArgs[b2]);
/*     */     }
/*     */     
/* 397 */     COMUtils.checkRC(hRESULT);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T getProperty(Class<T> paramClass, String paramString, Object... paramVarArgs) {
/* 402 */     OaIdl.DISPID dISPID = resolveDispId(getRawDispatch(), paramString);
/* 403 */     return getProperty(paramClass, dISPID, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T getProperty(Class<T> paramClass, OaIdl.DISPID paramDISPID, Object... paramVarArgs) {
/*     */     Variant.VARIANT[] arrayOfVARIANT;
/* 409 */     if (null == paramVarArgs) {
/* 410 */       arrayOfVARIANT = new Variant.VARIANT[0];
/*     */     } else {
/* 412 */       arrayOfVARIANT = new Variant.VARIANT[paramVarArgs.length];
/*     */     } 
/* 414 */     for (byte b1 = 0; b1 < arrayOfVARIANT.length; b1++) {
/* 415 */       arrayOfVARIANT[b1] = Convert.toVariant(paramVarArgs[b1]);
/*     */     }
/* 417 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 418 */     WinNT.HRESULT hRESULT = oleMethod(2, byReference, getRawDispatch(), paramDISPID, arrayOfVARIANT);
/*     */     
/* 420 */     for (byte b2 = 0; b2 < arrayOfVARIANT.length; b2++)
/*     */     {
/* 422 */       Convert.free(arrayOfVARIANT[b2], paramVarArgs[b2]);
/*     */     }
/*     */     
/* 425 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 427 */     return (T)Convert.toJavaObject((Variant.VARIANT)byReference, paramClass, this.factory, false, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T invokeMethod(Class<T> paramClass, String paramString, Object... paramVarArgs) {
/* 432 */     OaIdl.DISPID dISPID = resolveDispId(getRawDispatch(), paramString);
/* 433 */     return invokeMethod(paramClass, dISPID, paramVarArgs);
/*     */   }
/*     */   
/*     */   public <T> T invokeMethod(Class<T> paramClass, OaIdl.DISPID paramDISPID, Object... paramVarArgs) {
/*     */     Variant.VARIANT[] arrayOfVARIANT;
/* 438 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */ 
/*     */     
/* 441 */     if (null == paramVarArgs) {
/* 442 */       arrayOfVARIANT = new Variant.VARIANT[0];
/*     */     } else {
/* 444 */       arrayOfVARIANT = new Variant.VARIANT[paramVarArgs.length];
/*     */     } 
/* 446 */     for (byte b1 = 0; b1 < arrayOfVARIANT.length; b1++) {
/* 447 */       arrayOfVARIANT[b1] = Convert.toVariant(paramVarArgs[b1]);
/*     */     }
/* 449 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 450 */     WinNT.HRESULT hRESULT = oleMethod(1, byReference, getRawDispatch(), paramDISPID, arrayOfVARIANT);
/*     */     
/* 452 */     for (byte b2 = 0; b2 < arrayOfVARIANT.length; b2++)
/*     */     {
/* 454 */       Convert.free(arrayOfVARIANT[b2], paramVarArgs[b2]);
/*     */     }
/*     */     
/* 457 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 459 */     return (T)Convert.toJavaObject((Variant.VARIANT)byReference, paramClass, this.factory, false, true);
/*     */   }
/*     */   
/*     */   private Object[] unfoldWhenVarargs(Method paramMethod, Object[] paramArrayOfObject) {
/* 463 */     if (null == paramArrayOfObject) {
/* 464 */       return null;
/*     */     }
/* 466 */     if (paramArrayOfObject.length == 0 || !paramMethod.isVarArgs() || !(paramArrayOfObject[paramArrayOfObject.length - 1] instanceof Object[])) {
/* 467 */       return paramArrayOfObject;
/*     */     }
/*     */     
/* 470 */     Object[] arrayOfObject1 = (Object[])paramArrayOfObject[paramArrayOfObject.length - 1];
/* 471 */     Object[] arrayOfObject2 = new Object[paramArrayOfObject.length - 1 + arrayOfObject1.length];
/* 472 */     System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, 0, paramArrayOfObject.length - 1);
/* 473 */     System.arraycopy(arrayOfObject1, 0, arrayOfObject2, paramArrayOfObject.length - 1, arrayOfObject1.length);
/* 474 */     return arrayOfObject2;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T queryInterface(Class<T> paramClass) throws COMException {
/* 479 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*     */     try {
/* 482 */       ComInterface comInterface = paramClass.<ComInterface>getAnnotation(ComInterface.class);
/* 483 */       if (null == comInterface) {
/* 484 */         throw new COMException("queryInterface: Interface must define a value for iid via the ComInterface annotation");
/*     */       }
/*     */       
/* 487 */       Guid.IID iID = getIID(comInterface);
/* 488 */       PointerByReference pointerByReference = new PointerByReference();
/*     */       
/* 490 */       WinNT.HRESULT hRESULT = getRawDispatch().QueryInterface(new Guid.REFIID(iID), pointerByReference);
/*     */       
/* 492 */       if (WinNT.S_OK.equals(hRESULT)) {
/* 493 */         Dispatch dispatch = new Dispatch(pointerByReference.getValue());
/* 494 */         T t = (T)this.factory.createProxy((Class)paramClass, (IDispatch)dispatch);
/*     */ 
/*     */ 
/*     */         
/* 498 */         int i = dispatch.Release();
/* 499 */         return t;
/*     */       } 
/* 501 */       String str = Kernel32Util.formatMessage(hRESULT);
/* 502 */       throw new COMException("queryInterface: " + str, hRESULT);
/*     */     }
/* 504 */     catch (RuntimeException runtimeException) {
/*     */       
/* 506 */       if (runtimeException instanceof COMException) {
/* 507 */         throw runtimeException;
/*     */       }
/* 509 */       throw new COMException("Error occured when trying to query for interface " + paramClass.getName(), runtimeException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Guid.IID getIID(ComInterface paramComInterface) {
/* 515 */     String str = paramComInterface.iid();
/* 516 */     if (null != str && !str.isEmpty()) {
/* 517 */       return new Guid.IID(str);
/*     */     }
/* 519 */     throw new COMException("ComInterface must define a value for iid");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getAccessorName(Method paramMethod, ComProperty paramComProperty) {
/* 526 */     if (paramComProperty.name().isEmpty()) {
/* 527 */       String str = paramMethod.getName();
/* 528 */       if (str.startsWith("get")) {
/* 529 */         return str.replaceFirst("get", "");
/*     */       }
/* 531 */       throw new RuntimeException("Property Accessor name must start with 'get', or set the anotation 'name' value");
/*     */     } 
/*     */ 
/*     */     
/* 535 */     return paramComProperty.name();
/*     */   }
/*     */ 
/*     */   
/*     */   private String getMutatorName(Method paramMethod, ComProperty paramComProperty) {
/* 540 */     if (paramComProperty.name().isEmpty()) {
/* 541 */       String str = paramMethod.getName();
/* 542 */       if (str.startsWith("set")) {
/* 543 */         return str.replaceFirst("set", "");
/*     */       }
/* 545 */       throw new RuntimeException("Property Mutator name must start with 'set', or set the anotation 'name' value");
/*     */     } 
/*     */ 
/*     */     
/* 549 */     return paramComProperty.name();
/*     */   }
/*     */ 
/*     */   
/*     */   private String getMethodName(Method paramMethod, ComMethod paramComMethod) {
/* 554 */     if (paramComMethod.name().isEmpty()) {
/* 555 */       return paramMethod.getName();
/*     */     }
/*     */     
/* 558 */     return paramComMethod.name();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected OaIdl.DISPID resolveDispId(String paramString) {
/* 564 */     return resolveDispId(getRawDispatch(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, String paramString, Variant.VARIANT paramVARIANT) throws COMException {
/* 569 */     return oleMethod(paramInt, paramByReference, paramString, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, OaIdl.DISPID paramDISPID, Variant.VARIANT paramVARIANT) throws COMException {
/* 574 */     return oleMethod(paramInt, paramByReference, paramDISPID, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, String paramString) throws COMException {
/* 579 */     return oleMethod(paramInt, paramByReference, paramString, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, OaIdl.DISPID paramDISPID) throws COMException {
/* 585 */     return oleMethod(paramInt, paramByReference, paramDISPID, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, String paramString, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/* 591 */     return oleMethod(paramInt, paramByReference, resolveDispId(paramString), paramArrayOfVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, OaIdl.DISPID paramDISPID, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/* 597 */     return oleMethod(paramInt, paramByReference, getRawDispatch(), paramDISPID, paramArrayOfVARIANT);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   protected OaIdl.DISPID resolveDispId(IDispatch paramIDispatch, String paramString) {
/* 602 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 604 */     if (paramIDispatch == null) {
/* 605 */       throw new COMException("pDisp (IDispatch) parameter is null!");
/*     */     }
/*     */     
/* 608 */     WString[] arrayOfWString = { new WString(paramString) };
/* 609 */     OaIdl.DISPIDByReference dISPIDByReference = new OaIdl.DISPIDByReference();
/*     */     
/* 611 */     WinNT.HRESULT hRESULT = paramIDispatch.GetIDsOfNames(new Guid.REFIID(Guid.IID_NULL), arrayOfWString, 1, this.factory
/*     */ 
/*     */ 
/*     */         
/* 615 */         .getLCID(), dISPIDByReference);
/*     */ 
/*     */     
/* 618 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 620 */     return dISPIDByReference.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, String paramString, Variant.VARIANT paramVARIANT) throws COMException {
/* 626 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramString, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, OaIdl.DISPID paramDISPID, Variant.VARIANT paramVARIANT) throws COMException {
/* 632 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramDISPID, new Variant.VARIANT[] { paramVARIANT });
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, String paramString) throws COMException {
/* 638 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramString, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, OaIdl.DISPID paramDISPID) throws COMException {
/* 645 */     return oleMethod(paramInt, paramByReference, paramIDispatch, paramDISPID, (Variant.VARIANT[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, String paramString, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/* 652 */     return oleMethod(paramInt, paramByReference, paramIDispatch, resolveDispId(paramIDispatch, paramString), paramArrayOfVARIANT);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected WinNT.HRESULT oleMethod(int paramInt, Variant.VARIANT.ByReference paramByReference, IDispatch paramIDispatch, OaIdl.DISPID paramDISPID, Variant.VARIANT[] paramArrayOfVARIANT) throws COMException {
/*     */     int j;
/* 659 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 661 */     if (paramIDispatch == null) {
/* 662 */       throw new COMException("pDisp (IDispatch) parameter is null!");
/*     */     }
/*     */ 
/*     */     
/* 666 */     int i = 0;
/* 667 */     Variant.VARIANT[] arrayOfVARIANT = null;
/* 668 */     OleAuto.DISPPARAMS.ByReference byReference = new OleAuto.DISPPARAMS.ByReference();
/* 669 */     OaIdl.EXCEPINFO.ByReference byReference1 = new OaIdl.EXCEPINFO.ByReference();
/* 670 */     IntByReference intByReference = new IntByReference();
/*     */ 
/*     */     
/* 673 */     if (paramArrayOfVARIANT != null && paramArrayOfVARIANT.length > 0) {
/* 674 */       i = paramArrayOfVARIANT.length;
/* 675 */       arrayOfVARIANT = new Variant.VARIANT[i];
/*     */       
/* 677 */       j = i;
/* 678 */       for (byte b = 0; b < i; b++) {
/* 679 */         arrayOfVARIANT[b] = paramArrayOfVARIANT[--j];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 684 */     if (paramInt == 4) {
/* 685 */       byReference.setRgdispidNamedArgs(new OaIdl.DISPID[] { OaIdl.DISPID_PROPERTYPUT });
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
/* 712 */     if (paramInt == 1 || paramInt == 2) {
/* 713 */       j = 3;
/*     */     } else {
/* 715 */       j = paramInt;
/*     */     } 
/*     */ 
/*     */     
/* 719 */     if (i > 0) {
/* 720 */       byReference.setArgs(arrayOfVARIANT);
/*     */ 
/*     */       
/* 723 */       byReference.write();
/*     */     } 
/*     */     
/* 726 */     WinNT.HRESULT hRESULT = paramIDispatch.Invoke(paramDISPID, new Guid.REFIID(Guid.IID_NULL), this.factory
/*     */ 
/*     */         
/* 729 */         .getLCID(), new WinDef.WORD(j), byReference, paramByReference, byReference1, intByReference);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 736 */     COMUtils.checkRC(hRESULT, (OaIdl.EXCEPINFO)byReference1, intByReference);
/* 737 */     return hRESULT;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\ProxyObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */