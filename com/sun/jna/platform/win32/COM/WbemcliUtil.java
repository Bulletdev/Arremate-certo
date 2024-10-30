/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WbemcliUtil
/*     */ {
/*  58 */   public static final WbemcliUtil INSTANCE = new WbemcliUtil();
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String DEFAULT_NAMESPACE = "ROOT\\CIMV2";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum NamespaceProperty
/*     */   {
/*  69 */     NAME;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class WmiQuery<T extends Enum<T>>
/*     */   {
/*     */     private String nameSpace;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String wmiClassName;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Class<T> propertyEnum;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WmiQuery(String param1String1, String param1String2, Class<T> param1Class) {
/*  95 */       this.nameSpace = param1String1;
/*  96 */       this.wmiClassName = param1String2;
/*  97 */       this.propertyEnum = param1Class;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WmiQuery(String param1String, Class<T> param1Class) {
/* 108 */       this("ROOT\\CIMV2", param1String, param1Class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<T> getPropertyEnum() {
/* 115 */       return this.propertyEnum;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getNameSpace() {
/* 122 */       return this.nameSpace;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNameSpace(String param1String) {
/* 130 */       this.nameSpace = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getWmiClassName() {
/* 137 */       return this.wmiClassName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setWmiClassName(String param1String) {
/* 145 */       this.wmiClassName = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WbemcliUtil.WmiResult<T> execute() {
/*     */       try {
/* 156 */         return execute(-1);
/* 157 */       } catch (TimeoutException timeoutException) {
/* 158 */         throw new COMException("Got a WMI timeout when infinite wait was specified. This should never happen.");
/*     */       } 
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
/*     */     public WbemcliUtil.WmiResult<T> execute(int param1Int) throws TimeoutException {
/* 179 */       if (((Enum[])getPropertyEnum().getEnumConstants()).length < 1) {
/* 180 */         throw new IllegalArgumentException("The query's property enum has no values.");
/*     */       }
/*     */ 
/*     */       
/* 184 */       Wbemcli.IWbemServices iWbemServices = WbemcliUtil.connectServer(getNameSpace());
/*     */ 
/*     */       
/*     */       try {
/* 188 */         Wbemcli.IEnumWbemClassObject iEnumWbemClassObject = selectProperties(iWbemServices, this);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       finally {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 198 */         iWbemServices.Release();
/*     */       } 
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
/*     */     private static <T extends Enum<T>> Wbemcli.IEnumWbemClassObject selectProperties(Wbemcli.IWbemServices param1IWbemServices, WmiQuery<T> param1WmiQuery) {
/* 218 */       Enum[] arrayOfEnum = param1WmiQuery.getPropertyEnum().getEnumConstants();
/* 219 */       StringBuilder stringBuilder = new StringBuilder("SELECT ");
/*     */       
/* 221 */       stringBuilder.append(arrayOfEnum[0].name());
/* 222 */       for (byte b = 1; b < arrayOfEnum.length; b++) {
/* 223 */         stringBuilder.append(',').append(arrayOfEnum[b].name());
/*     */       }
/* 225 */       stringBuilder.append(" FROM ").append(param1WmiQuery.getWmiClassName());
/*     */ 
/*     */       
/* 228 */       return param1IWbemServices.ExecQuery("WQL", stringBuilder.toString().replaceAll("\\\\", "\\\\\\\\"), 48, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static <T extends Enum<T>> WbemcliUtil.WmiResult<T> enumerateProperties(Wbemcli.IEnumWbemClassObject param1IEnumWbemClassObject, Class<T> param1Class, int param1Int) throws TimeoutException {
/* 287 */       WbemcliUtil.INSTANCE.getClass(); WbemcliUtil.WmiResult<T> wmiResult = new WbemcliUtil.WmiResult<T>(param1Class);
/*     */ 
/*     */       
/* 290 */       Pointer[] arrayOfPointer = new Pointer[1];
/* 291 */       IntByReference intByReference = new IntByReference(0);
/* 292 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 293 */       WinNT.HRESULT hRESULT = null;
/* 294 */       for (Enum enum_ : (Enum[])param1Class.getEnumConstants()) {
/* 295 */         hashMap.put(enum_, new WString(enum_.name()));
/*     */       }
/* 297 */       while (param1IEnumWbemClassObject.getPointer() != Pointer.NULL) {
/*     */ 
/*     */         
/* 300 */         hRESULT = param1IEnumWbemClassObject.Next(param1Int, arrayOfPointer.length, arrayOfPointer, intByReference);
/*     */         
/* 302 */         if (hRESULT.intValue() == 1 || hRESULT.intValue() == 262149) {
/*     */           break;
/*     */         }
/*     */         
/* 306 */         if (hRESULT.intValue() == 262148) {
/* 307 */           throw new TimeoutException("No results after " + param1Int + " ms.");
/*     */         }
/*     */         
/* 310 */         if (COMUtils.FAILED(hRESULT)) {
/* 311 */           throw new COMException("Failed to enumerate results.", hRESULT);
/*     */         }
/*     */         
/* 314 */         Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 315 */         IntByReference intByReference1 = new IntByReference();
/*     */ 
/*     */         
/* 318 */         Wbemcli.IWbemClassObject iWbemClassObject = new Wbemcli.IWbemClassObject(arrayOfPointer[0]);
/* 319 */         for (Enum enum_ : (Enum[])param1Class.getEnumConstants()) {
/* 320 */           iWbemClassObject.Get((WString)hashMap.get(enum_), 0, byReference, intByReference1, (IntByReference)null);
/* 321 */           int i = ((byReference.getValue() == null) ? Integer.valueOf(1) : byReference.getVarType()).intValue();
/* 322 */           int j = intByReference1.getValue();
/* 323 */           switch (i) {
/*     */             case 8:
/* 325 */               wmiResult.add(i, j, (T)enum_, byReference.stringValue());
/*     */               break;
/*     */             case 3:
/* 328 */               wmiResult.add(i, j, (T)enum_, Integer.valueOf(byReference.intValue()));
/*     */               break;
/*     */             case 17:
/* 331 */               wmiResult.add(i, j, (T)enum_, Byte.valueOf(byReference.byteValue()));
/*     */               break;
/*     */             case 2:
/* 334 */               wmiResult.add(i, j, (T)enum_, Short.valueOf(byReference.shortValue()));
/*     */               break;
/*     */             case 11:
/* 337 */               wmiResult.add(i, j, (T)enum_, Boolean.valueOf(byReference.booleanValue()));
/*     */               break;
/*     */             case 4:
/* 340 */               wmiResult.add(i, j, (T)enum_, Float.valueOf(byReference.floatValue()));
/*     */               break;
/*     */             case 5:
/* 343 */               wmiResult.add(i, j, (T)enum_, Double.valueOf(byReference.doubleValue()));
/*     */               break;
/*     */             case 0:
/*     */             case 1:
/* 347 */               wmiResult.add(i, j, (T)enum_, null);
/*     */               break;
/*     */             
/*     */             default:
/* 351 */               if ((i & 0x2000) == 8192 || (i & 0xD) == 13 || (i & 0x9) == 9 || (i & 0x1000) == 4096) {
/*     */ 
/*     */ 
/*     */                 
/* 355 */                 wmiResult.add(i, j, (T)enum_, null); break;
/*     */               } 
/* 357 */               wmiResult.add(i, j, (T)enum_, byReference.getValue());
/*     */               break;
/*     */           } 
/* 360 */           OleAuto.INSTANCE.VariantClear((Variant.VARIANT)byReference);
/*     */         } 
/* 362 */         iWbemClassObject.Release();
/*     */         
/* 364 */         wmiResult.incrementResultCount();
/*     */       } 
/* 366 */       return wmiResult;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class WmiResult<T extends Enum<T>>
/*     */   {
/*     */     private Map<T, List<Object>> propertyMap;
/*     */     
/*     */     private Map<T, Integer> vtTypeMap;
/*     */     private Map<T, Integer> cimTypeMap;
/* 377 */     private int resultCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WmiResult(Class<T> param1Class) {
/* 384 */       this.propertyMap = new EnumMap<T, List<Object>>(param1Class);
/* 385 */       this.vtTypeMap = new EnumMap<T, Integer>(param1Class);
/* 386 */       this.cimTypeMap = new EnumMap<T, Integer>(param1Class);
/* 387 */       for (Enum enum_ : (Enum[])param1Class.getEnumConstants()) {
/* 388 */         this.propertyMap.put((T)enum_, new ArrayList());
/* 389 */         this.vtTypeMap.put((T)enum_, Integer.valueOf(1));
/* 390 */         this.cimTypeMap.put((T)enum_, Integer.valueOf(0));
/*     */       } 
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
/*     */     public Object getValue(T param1T, int param1Int) {
/* 408 */       return ((List)this.propertyMap.get(param1T)).get(param1Int);
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
/*     */     public int getVtType(T param1T) {
/* 421 */       return ((Integer)this.vtTypeMap.get(param1T)).intValue();
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
/*     */     public int getCIMType(T param1T) {
/* 433 */       return ((Integer)this.cimTypeMap.get(param1T)).intValue();
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
/*     */     private void add(int param1Int1, int param1Int2, T param1T, Object param1Object) {
/* 449 */       ((List<Object>)this.propertyMap.get(param1T)).add(param1Object);
/* 450 */       if (param1Int1 != 1 && ((Integer)this.vtTypeMap.get(param1T)).equals(Integer.valueOf(1))) {
/* 451 */         this.vtTypeMap.put(param1T, Integer.valueOf(param1Int1));
/*     */       }
/* 453 */       if (((Integer)this.cimTypeMap.get(param1T)).equals(Integer.valueOf(0))) {
/* 454 */         this.cimTypeMap.put(param1T, Integer.valueOf(param1Int2));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getResultCount() {
/* 462 */       return this.resultCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void incrementResultCount() {
/* 469 */       this.resultCount++;
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
/*     */   public static boolean hasNamespace(String paramString) {
/* 484 */     String str = paramString;
/* 485 */     if (paramString.toUpperCase().startsWith("ROOT\\")) {
/* 486 */       str = paramString.substring(5);
/*     */     }
/*     */     
/* 489 */     WmiQuery<NamespaceProperty> wmiQuery = new WmiQuery<NamespaceProperty>("ROOT", "__NAMESPACE", NamespaceProperty.class);
/* 490 */     WmiResult<NamespaceProperty> wmiResult = wmiQuery.execute();
/* 491 */     for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 492 */       if (str.equalsIgnoreCase((String)wmiResult.getValue(NamespaceProperty.NAME, b))) {
/* 493 */         return true;
/*     */       }
/*     */     } 
/* 496 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Wbemcli.IWbemServices connectServer(String paramString) {
/* 523 */     Wbemcli.IWbemLocator iWbemLocator = Wbemcli.IWbemLocator.create();
/* 524 */     if (iWbemLocator == null) {
/* 525 */       throw new COMException("Failed to create WbemLocator object.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 532 */     Wbemcli.IWbemServices iWbemServices = iWbemLocator.ConnectServer(paramString, (String)null, (String)null, (String)null, 0, (String)null, (Wbemcli.IWbemContext)null);
/*     */ 
/*     */     
/* 535 */     iWbemLocator.Release();
/*     */ 
/*     */ 
/*     */     
/* 539 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoSetProxyBlanket(iWbemServices, 10, 0, null, 3, 3, null, 0);
/*     */     
/* 541 */     if (COMUtils.FAILED(hRESULT)) {
/* 542 */       iWbemServices.Release();
/* 543 */       throw new COMException("Could not set proxy blanket.", hRESULT);
/*     */     } 
/* 545 */     return iWbemServices;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\WbemcliUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */