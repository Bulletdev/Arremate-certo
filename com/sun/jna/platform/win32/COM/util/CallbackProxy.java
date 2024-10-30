/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.COMUtils;
/*     */ import com.sun.jna.platform.win32.COM.Dispatch;
/*     */ import com.sun.jna.platform.win32.COM.DispatchListener;
/*     */ import com.sun.jna.platform.win32.COM.IDispatchCallback;
/*     */ import com.sun.jna.platform.win32.COM.Unknown;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComEventCallback;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComInterface;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinError;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CallbackProxy
/*     */   implements IDispatchCallback
/*     */ {
/*     */   private static boolean DEFAULT_BOOLEAN;
/*     */   private static byte DEFAULT_BYTE;
/*     */   private static short DEFAULT_SHORT;
/*     */   private static int DEFAULT_INT;
/*     */   private static long DEFAULT_LONG;
/*     */   private static float DEFAULT_FLOAT;
/*     */   private static double DEFAULT_DOUBLE;
/*     */   ObjectFactory factory;
/*     */   Class<?> comEventCallbackInterface;
/*     */   IComEventCallbackListener comEventCallbackListener;
/*     */   Guid.REFIID listenedToRiid;
/*     */   public DispatchListener dispatchListener;
/*     */   Map<OaIdl.DISPID, Method> dsipIdMap;
/*     */   
/*     */   public CallbackProxy(ObjectFactory paramObjectFactory, Class<?> paramClass, IComEventCallbackListener paramIComEventCallbackListener) {
/*  73 */     this.factory = paramObjectFactory;
/*  74 */     this.comEventCallbackInterface = paramClass;
/*  75 */     this.comEventCallbackListener = paramIComEventCallbackListener;
/*  76 */     this.listenedToRiid = createRIID(paramClass);
/*  77 */     this.dsipIdMap = createDispIdMap(paramClass);
/*  78 */     this.dispatchListener = new DispatchListener(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Guid.REFIID createRIID(Class<?> paramClass) {
/*  89 */     ComInterface comInterface = paramClass.<ComInterface>getAnnotation(ComInterface.class);
/*  90 */     if (null == comInterface) {
/*  91 */       throw new COMException("advise: Interface must define a value for either iid via the ComInterface annotation");
/*     */     }
/*     */     
/*  94 */     String str = comInterface.iid();
/*  95 */     if (null == str || str.isEmpty()) {
/*  96 */       throw new COMException("ComInterface must define a value for iid");
/*     */     }
/*  98 */     return new Guid.REFIID((new Guid.IID(str)).getPointer());
/*     */   }
/*     */   
/*     */   Map<OaIdl.DISPID, Method> createDispIdMap(Class<?> paramClass) {
/* 102 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 104 */     for (Method method : paramClass.getMethods()) {
/* 105 */       ComEventCallback comEventCallback = method.<ComEventCallback>getAnnotation(ComEventCallback.class);
/* 106 */       ComMethod comMethod = method.<ComMethod>getAnnotation(ComMethod.class);
/* 107 */       if (comMethod != null) {
/* 108 */         int i = comMethod.dispId();
/* 109 */         if (-1 == i) {
/* 110 */           i = fetchDispIdFromName(comEventCallback);
/*     */         }
/* 112 */         if (i == -1) {
/* 113 */           this.comEventCallbackListener.errorReceivingCallbackEvent("DISPID for " + method
/* 114 */               .getName() + " not found", null);
/*     */         }
/*     */         
/* 117 */         hashMap.put(new OaIdl.DISPID(i), method);
/* 118 */       } else if (null != comEventCallback) {
/* 119 */         int i = comEventCallback.dispid();
/* 120 */         if (-1 == i) {
/* 121 */           i = fetchDispIdFromName(comEventCallback);
/*     */         }
/* 123 */         if (i == -1) {
/* 124 */           this.comEventCallbackListener.errorReceivingCallbackEvent("DISPID for " + method
/* 125 */               .getName() + " not found", null);
/*     */         }
/*     */         
/* 128 */         hashMap.put(new OaIdl.DISPID(i), method);
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   int fetchDispIdFromName(ComEventCallback paramComEventCallback) {
/* 137 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void invokeOnThread(OaIdl.DISPID paramDISPID, Guid.REFIID paramREFIID, WinDef.LCID paramLCID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference) {
/* 143 */     Variant.VARIANT[] arrayOfVARIANT = paramByReference.getArgs();
/*     */     
/* 145 */     Method method = this.dsipIdMap.get(paramDISPID);
/* 146 */     if (method == null) {
/* 147 */       this.comEventCallbackListener.errorReceivingCallbackEvent("No method found with dispId = " + paramDISPID, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
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
/* 185 */     OaIdl.DISPID[] arrayOfDISPID = paramByReference.getRgdispidNamedArgs();
/*     */     
/* 187 */     Class[] arrayOfClass = method.getParameterTypes();
/* 188 */     Object[] arrayOfObject = new Object[arrayOfClass.length];
/*     */     
/*     */     byte b;
/* 191 */     for (b = 0; b < arrayOfObject.length && arrayOfVARIANT.length - arrayOfDISPID.length - b > 0; b++) {
/* 192 */       Class<?> clazz = arrayOfClass[b];
/* 193 */       Variant.VARIANT vARIANT = arrayOfVARIANT[arrayOfVARIANT.length - b - 1];
/* 194 */       arrayOfObject[b] = Convert.toJavaObject(vARIANT, clazz, this.factory, true, false);
/*     */     } 
/*     */     
/* 197 */     for (b = 0; b < arrayOfDISPID.length; b++) {
/* 198 */       int i = arrayOfDISPID[b].intValue();
/* 199 */       if (i < arrayOfObject.length) {
/*     */ 
/*     */ 
/*     */         
/* 203 */         Class<?> clazz = arrayOfClass[i];
/* 204 */         Variant.VARIANT vARIANT = arrayOfVARIANT[b];
/* 205 */         arrayOfObject[i] = Convert.toJavaObject(vARIANT, clazz, this.factory, true, false);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     for (b = 0; b < arrayOfObject.length; b++) {
/* 212 */       if (arrayOfObject[b] == null && arrayOfClass[b].isPrimitive()) {
/* 213 */         if (arrayOfClass[b].equals(boolean.class)) {
/* 214 */           arrayOfObject[b] = Boolean.valueOf(DEFAULT_BOOLEAN);
/* 215 */         } else if (arrayOfClass[b].equals(byte.class)) {
/* 216 */           arrayOfObject[b] = Byte.valueOf(DEFAULT_BYTE);
/* 217 */         } else if (arrayOfClass[b].equals(short.class)) {
/* 218 */           arrayOfObject[b] = Short.valueOf(DEFAULT_SHORT);
/* 219 */         } else if (arrayOfClass[b].equals(int.class)) {
/* 220 */           arrayOfObject[b] = Integer.valueOf(DEFAULT_INT);
/* 221 */         } else if (arrayOfClass[b].equals(long.class)) {
/* 222 */           arrayOfObject[b] = Long.valueOf(DEFAULT_LONG);
/* 223 */         } else if (arrayOfClass[b].equals(float.class)) {
/* 224 */           arrayOfObject[b] = Float.valueOf(DEFAULT_FLOAT);
/* 225 */         } else if (arrayOfClass[b].equals(double.class)) {
/* 226 */           arrayOfObject[b] = Double.valueOf(DEFAULT_DOUBLE);
/*     */         } else {
/* 228 */           throw new IllegalArgumentException("Class type " + arrayOfClass[b].getName() + " not mapped to primitive default value.");
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*     */     try {
/* 234 */       method.invoke(this.comEventCallbackListener, arrayOfObject);
/* 235 */     } catch (Exception exception) {
/* 236 */       ArrayList<String> arrayList = new ArrayList(arrayOfObject.length);
/* 237 */       for (Object object : arrayOfObject) {
/* 238 */         if (object == null) {
/* 239 */           arrayList.add("NULL");
/*     */         } else {
/* 241 */           arrayList.add(object.getClass().getName());
/*     */         } 
/*     */       } 
/* 244 */       this.comEventCallbackListener.errorReceivingCallbackEvent("Exception invoking method " + method + " supplied: " + arrayList
/* 245 */           .toString(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Pointer getPointer() {
/* 251 */     return this.dispatchListener.getPointer();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetTypeInfoCount(WinDef.UINTByReference paramUINTByReference) {
/* 257 */     return new WinNT.HRESULT(-2147467263);
/*     */   }
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetTypeInfo(WinDef.UINT paramUINT, WinDef.LCID paramLCID, PointerByReference paramPointerByReference) {
/* 262 */     return new WinNT.HRESULT(-2147467263);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetIDsOfNames(Guid.REFIID paramREFIID, WString[] paramArrayOfWString, int paramInt, WinDef.LCID paramLCID, OaIdl.DISPIDByReference paramDISPIDByReference) {
/* 268 */     return new WinNT.HRESULT(-2147467263);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT Invoke(OaIdl.DISPID paramDISPID, Guid.REFIID paramREFIID, WinDef.LCID paramLCID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference, Variant.VARIANT.ByReference paramByReference1, OaIdl.EXCEPINFO.ByReference paramByReference2, IntByReference paramIntByReference) {
/* 276 */     assert COMUtils.comIsInitialized() : "Assumption about COM threading broken.";
/*     */     
/* 278 */     invokeOnThread(paramDISPID, paramREFIID, paramLCID, paramWORD, paramByReference);
/*     */     
/* 280 */     return WinError.S_OK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT QueryInterface(Guid.REFIID paramREFIID, PointerByReference paramPointerByReference) {
/* 286 */     if (null == paramPointerByReference)
/* 287 */       return new WinNT.HRESULT(-2147467261); 
/* 288 */     if (paramREFIID.equals(this.listenedToRiid)) {
/* 289 */       paramPointerByReference.setValue(getPointer());
/* 290 */       return WinError.S_OK;
/* 291 */     }  if (paramREFIID.getValue().equals(Unknown.IID_IUNKNOWN)) {
/* 292 */       paramPointerByReference.setValue(getPointer());
/* 293 */       return WinError.S_OK;
/* 294 */     }  if (paramREFIID.getValue().equals(Dispatch.IID_IDISPATCH)) {
/* 295 */       paramPointerByReference.setValue(getPointer());
/* 296 */       return WinError.S_OK;
/*     */     } 
/*     */     
/* 299 */     return new WinNT.HRESULT(-2147467262);
/*     */   }
/*     */   
/*     */   public int AddRef() {
/* 303 */     return 0;
/*     */   }
/*     */   
/*     */   public int Release() {
/* 307 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\CallbackProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */