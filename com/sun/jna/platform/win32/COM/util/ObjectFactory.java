/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.COMUtils;
/*     */ import com.sun.jna.platform.win32.COM.Dispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatchCallback;
/*     */ import com.sun.jna.platform.win32.COM.RunningObjectTable;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComObject;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObjectFactory
/*     */ {
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/*  60 */       disposeAll();
/*     */     } finally {
/*  62 */       super.finalize();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IRunningObjectTable getRunningObjectTable() {
/*  73 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*  75 */     PointerByReference pointerByReference = new PointerByReference();
/*     */     
/*  77 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.GetRunningObjectTable(new WinDef.DWORD(0L), pointerByReference);
/*     */     
/*  79 */     COMUtils.checkRC(hRESULT);
/*     */     
/*  81 */     RunningObjectTable runningObjectTable = new RunningObjectTable(pointerByReference.getValue());
/*  82 */     return new RunningObjectTable(runningObjectTable, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T createProxy(Class<T> paramClass, IDispatch paramIDispatch) {
/*  91 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*  93 */     ProxyObject proxyObject = new ProxyObject(paramClass, paramIDispatch, this);
/*  94 */     Object object = Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, proxyObject);
/*  95 */     return paramClass.cast(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T createObject(Class<T> paramClass) {
/* 104 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 106 */     ComObject comObject = paramClass.<ComObject>getAnnotation(ComObject.class);
/* 107 */     if (null == comObject) {
/* 108 */       throw new COMException("createObject: Interface must define a value for either clsId or progId via the ComInterface annotation");
/*     */     }
/*     */     
/* 111 */     Guid.GUID gUID = discoverClsId(comObject);
/*     */     
/* 113 */     PointerByReference pointerByReference = new PointerByReference();
/* 114 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoCreateInstance(gUID, null, 21, (Guid.GUID)IDispatch.IID_IDISPATCH, pointerByReference);
/*     */ 
/*     */     
/* 117 */     COMUtils.checkRC(hRESULT);
/* 118 */     Dispatch dispatch = new Dispatch(pointerByReference.getValue());
/* 119 */     T t = (T)createProxy((Class)paramClass, (IDispatch)dispatch);
/*     */ 
/*     */     
/* 122 */     int i = dispatch.Release();
/* 123 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T fetchObject(Class<T> paramClass) throws COMException {
/* 131 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 133 */     ComObject comObject = paramClass.<ComObject>getAnnotation(ComObject.class);
/* 134 */     if (null == comObject) {
/* 135 */       throw new COMException("createObject: Interface must define a value for either clsId or progId via the ComInterface annotation");
/*     */     }
/*     */     
/* 138 */     Guid.GUID gUID = discoverClsId(comObject);
/*     */     
/* 140 */     PointerByReference pointerByReference = new PointerByReference();
/* 141 */     WinNT.HRESULT hRESULT = OleAuto.INSTANCE.GetActiveObject(gUID, null, pointerByReference);
/*     */     
/* 143 */     COMUtils.checkRC(hRESULT);
/* 144 */     Dispatch dispatch = new Dispatch(pointerByReference.getValue());
/* 145 */     T t = (T)createProxy((Class)paramClass, (IDispatch)dispatch);
/*     */ 
/*     */     
/* 148 */     dispatch.Release();
/*     */     
/* 150 */     return t;
/*     */   }
/*     */   
/*     */   Guid.GUID discoverClsId(ComObject paramComObject) {
/* 154 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/* 156 */     String str1 = paramComObject.clsId();
/* 157 */     String str2 = paramComObject.progId();
/* 158 */     if (null != str1 && !str1.isEmpty())
/* 159 */       return (Guid.GUID)new Guid.CLSID(str1); 
/* 160 */     if (null != str2 && !str2.isEmpty()) {
/* 161 */       Guid.CLSID.ByReference byReference = new Guid.CLSID.ByReference();
/*     */       
/* 163 */       WinNT.HRESULT hRESULT = Ole32.INSTANCE.CLSIDFromProgID(str2, byReference);
/*     */       
/* 165 */       COMUtils.checkRC(hRESULT);
/* 166 */       return (Guid.GUID)byReference;
/*     */     } 
/* 168 */     throw new COMException("ComObject must define a value for either clsId or progId");
/*     */   }
/*     */ 
/*     */   
/*     */   IDispatchCallback createDispatchCallback(Class<?> paramClass, IComEventCallbackListener paramIComEventCallbackListener) {
/* 173 */     return new CallbackProxy(this, paramClass, paramIComEventCallbackListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   private final List<WeakReference<ProxyObject>> registeredObjects = new LinkedList<WeakReference<ProxyObject>>();
/*     */   
/*     */   public void register(ProxyObject paramProxyObject) {
/* 186 */     synchronized (this.registeredObjects) {
/* 187 */       this.registeredObjects.add(new WeakReference<ProxyObject>(paramProxyObject));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void unregister(ProxyObject paramProxyObject) {
/* 192 */     synchronized (this.registeredObjects) {
/* 193 */       Iterator<WeakReference<ProxyObject>> iterator = this.registeredObjects.iterator();
/* 194 */       while (iterator.hasNext()) {
/* 195 */         WeakReference<ProxyObject> weakReference = iterator.next();
/* 196 */         ProxyObject proxyObject = weakReference.get();
/* 197 */         if (proxyObject == null || proxyObject == paramProxyObject) {
/* 198 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void disposeAll() {
/* 205 */     synchronized (this.registeredObjects) {
/* 206 */       ArrayList<WeakReference<ProxyObject>> arrayList = new ArrayList<WeakReference<ProxyObject>>(this.registeredObjects);
/* 207 */       for (WeakReference<ProxyObject> weakReference : arrayList) {
/* 208 */         ProxyObject proxyObject = weakReference.get();
/* 209 */         if (proxyObject != null) {
/* 210 */           proxyObject.dispose();
/*     */         }
/*     */       } 
/* 213 */       this.registeredObjects.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 220 */   private static final WinDef.LCID LOCALE_USER_DEFAULT = Kernel32.INSTANCE.GetUserDefaultLCID();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WinDef.LCID LCID;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinDef.LCID getLCID() {
/* 231 */     if (this.LCID != null) {
/* 232 */       return this.LCID;
/*     */     }
/* 234 */     return LOCALE_USER_DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLCID(WinDef.LCID paramLCID) {
/* 244 */     this.LCID = paramLCID;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */