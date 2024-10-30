/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.LastErrorException;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Advapi32;
/*     */ import com.sun.jna.platform.win32.Advapi32Util;
/*     */ import com.sun.jna.platform.win32.Kernel32Util;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.W32Errors;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.platform.win32.WinReg;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class COMUtils
/*     */ {
/*     */   public static final int S_OK = 0;
/*     */   public static final int S_FALSE = 1;
/*     */   public static final int E_UNEXPECTED = -2147418113;
/*     */   
/*     */   public static boolean SUCCEEDED(WinNT.HRESULT paramHRESULT) {
/*  66 */     return SUCCEEDED(paramHRESULT.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean SUCCEEDED(int paramInt) {
/*  77 */     return (paramInt >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean FAILED(WinNT.HRESULT paramHRESULT) {
/*  88 */     return FAILED(paramHRESULT.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean FAILED(int paramInt) {
/*  99 */     return (paramInt < 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void checkRC(WinNT.HRESULT paramHRESULT) {
/* 109 */     if (FAILED(paramHRESULT)) {
/*     */       String str;
/*     */       try {
/* 112 */         str = Kernel32Util.formatMessage(paramHRESULT) + "(HRESULT: " + Integer.toHexString(paramHRESULT.intValue()) + ")";
/* 113 */       } catch (LastErrorException lastErrorException) {
/*     */         
/* 115 */         str = "(HRESULT: " + Integer.toHexString(paramHRESULT.intValue()) + ")";
/*     */       } 
/* 117 */       throw new COMException(str, paramHRESULT);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void checkRC(WinNT.HRESULT paramHRESULT, OaIdl.EXCEPINFO paramEXCEPINFO, IntByReference paramIntByReference) {
/* 139 */     Object object = null;
/*     */     
/* 141 */     if (FAILED(paramHRESULT)) {
/* 142 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 144 */       Integer integer1 = null;
/* 145 */       Integer integer2 = null;
/* 146 */       Integer integer3 = null;
/* 147 */       String str1 = null;
/* 148 */       String str2 = null;
/* 149 */       Integer integer4 = null;
/* 150 */       String str3 = null;
/*     */       
/* 152 */       if (paramIntByReference != null) {
/* 153 */         integer1 = Integer.valueOf(paramIntByReference.getValue());
/*     */       }
/*     */       
/*     */       try {
/* 157 */         stringBuilder.append(Kernel32Util.formatMessage(paramHRESULT));
/* 158 */       } catch (LastErrorException lastErrorException) {}
/*     */ 
/*     */ 
/*     */       
/* 162 */       stringBuilder.append("(HRESULT: ");
/* 163 */       stringBuilder.append(Integer.toHexString(paramHRESULT.intValue()));
/* 164 */       stringBuilder.append(")");
/*     */       
/* 166 */       if (paramEXCEPINFO != null) {
/* 167 */         integer2 = Integer.valueOf(paramEXCEPINFO.wCode.intValue());
/* 168 */         integer3 = Integer.valueOf(paramEXCEPINFO.scode.intValue());
/* 169 */         integer4 = Integer.valueOf(paramEXCEPINFO.dwHelpContext.intValue());
/*     */         
/* 171 */         if (paramEXCEPINFO.bstrSource != null) {
/* 172 */           str3 = paramEXCEPINFO.bstrSource.getValue();
/* 173 */           stringBuilder.append("\nSource:      ");
/* 174 */           stringBuilder.append(str3);
/*     */         } 
/* 176 */         if (paramEXCEPINFO.bstrDescription != null) {
/* 177 */           str1 = paramEXCEPINFO.bstrDescription.getValue();
/* 178 */           stringBuilder.append("\nDescription: ");
/* 179 */           stringBuilder.append(str1);
/*     */         } 
/* 181 */         if (paramEXCEPINFO.bstrHelpFile != null) {
/* 182 */           str2 = paramEXCEPINFO.bstrHelpFile.getValue();
/*     */         }
/*     */       } 
/*     */       
/* 186 */       throw new COMInvokeException(stringBuilder
/* 187 */           .toString(), paramHRESULT, integer1, str1, integer4, str2, integer3, str3, integer2);
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
/* 199 */     if (paramEXCEPINFO != null) {
/* 200 */       if (paramEXCEPINFO.bstrSource != null) {
/* 201 */         OleAuto.INSTANCE.SysFreeString(paramEXCEPINFO.bstrSource);
/*     */       }
/* 203 */       if (paramEXCEPINFO.bstrDescription != null) {
/* 204 */         OleAuto.INSTANCE.SysFreeString(paramEXCEPINFO.bstrDescription);
/*     */       }
/* 206 */       if (paramEXCEPINFO.bstrHelpFile != null) {
/* 207 */         OleAuto.INSTANCE.SysFreeString(paramEXCEPINFO.bstrHelpFile);
/*     */       }
/*     */     } 
/*     */     
/* 211 */     if (object != null) {
/* 212 */       throw object;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<COMInfo> getAllCOMInfoOnSystem() {
/* 222 */     WinReg.HKEYByReference hKEYByReference1 = new WinReg.HKEYByReference();
/* 223 */     WinReg.HKEYByReference hKEYByReference2 = new WinReg.HKEYByReference();
/*     */     
/* 225 */     ArrayList<COMInfo> arrayList = new ArrayList();
/*     */ 
/*     */     
/*     */     try {
/* 229 */       hKEYByReference1 = Advapi32Util.registryGetKey(WinReg.HKEY_CLASSES_ROOT, "CLSID", 131097);
/*     */ 
/*     */       
/* 232 */       Advapi32Util.InfoKey infoKey = Advapi32Util.registryQueryInfoKey(hKEYByReference1
/* 233 */           .getValue(), 131097);
/*     */       
/* 235 */       for (byte b = 0; b < infoKey.lpcSubKeys.getValue(); b++) {
/* 236 */         Advapi32Util.EnumKey enumKey = Advapi32Util.registryRegEnumKey(hKEYByReference1
/* 237 */             .getValue(), b);
/* 238 */         String str = Native.toString(enumKey.lpName);
/*     */         
/* 240 */         COMInfo cOMInfo = new COMInfo(str);
/*     */         
/* 242 */         hKEYByReference2 = Advapi32Util.registryGetKey(hKEYByReference1.getValue(), str, 131097);
/*     */         
/* 244 */         Advapi32Util.InfoKey infoKey1 = Advapi32Util.registryQueryInfoKey(hKEYByReference2
/* 245 */             .getValue(), 131097);
/*     */         
/* 247 */         for (byte b1 = 0; b1 < infoKey1.lpcSubKeys.getValue(); b1++) {
/* 248 */           Advapi32Util.EnumKey enumKey1 = Advapi32Util.registryRegEnumKey(hKEYByReference2
/* 249 */               .getValue(), b1);
/* 250 */           String str1 = Native.toString(enumKey1.lpName);
/*     */           
/* 252 */           if (str1.equals("InprocHandler32")) {
/* 253 */             cOMInfo
/* 254 */               .inprocHandler32 = (String)Advapi32Util.registryGetValue(hKEYByReference2.getValue(), str1, null);
/*     */           }
/* 256 */           else if (str1.equals("InprocServer32")) {
/* 257 */             cOMInfo
/* 258 */               .inprocServer32 = (String)Advapi32Util.registryGetValue(hKEYByReference2.getValue(), str1, null);
/*     */           }
/* 260 */           else if (str1.equals("LocalServer32")) {
/* 261 */             cOMInfo
/* 262 */               .localServer32 = (String)Advapi32Util.registryGetValue(hKEYByReference2.getValue(), str1, null);
/*     */           }
/* 264 */           else if (str1.equals("ProgID")) {
/* 265 */             cOMInfo
/* 266 */               .progID = (String)Advapi32Util.registryGetValue(hKEYByReference2.getValue(), str1, null);
/*     */           }
/* 268 */           else if (str1.equals("TypeLib")) {
/* 269 */             cOMInfo
/* 270 */               .typeLib = (String)Advapi32Util.registryGetValue(hKEYByReference2.getValue(), str1, null);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 275 */         Advapi32.INSTANCE.RegCloseKey(hKEYByReference2.getValue());
/* 276 */         arrayList.add(cOMInfo);
/*     */       } 
/*     */     } finally {
/* 279 */       Advapi32.INSTANCE.RegCloseKey(hKEYByReference1.getValue());
/* 280 */       Advapi32.INSTANCE.RegCloseKey(hKEYByReference2.getValue());
/*     */     } 
/*     */     
/* 283 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean comIsInitialized() {
/* 294 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, 0);
/* 295 */     if (hRESULT.equals(W32Errors.S_OK)) {
/*     */       
/* 297 */       Ole32.INSTANCE.CoUninitialize();
/* 298 */       return false;
/* 299 */     }  if (hRESULT.equals(W32Errors.S_FALSE)) {
/*     */ 
/*     */ 
/*     */       
/* 303 */       Ole32.INSTANCE.CoUninitialize();
/* 304 */       return true;
/* 305 */     }  if (hRESULT.intValue() == -2147417850) {
/* 306 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 311 */     checkRC(hRESULT);
/*     */     
/* 313 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class COMInfo
/*     */   {
/*     */     public String clsid;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String inprocHandler32;
/*     */ 
/*     */ 
/*     */     
/*     */     public String inprocServer32;
/*     */ 
/*     */ 
/*     */     
/*     */     public String localServer32;
/*     */ 
/*     */ 
/*     */     
/*     */     public String progID;
/*     */ 
/*     */ 
/*     */     
/*     */     public String typeLib;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public COMInfo() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public COMInfo(String param1String) {
/* 354 */       this.clsid = param1String;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\COMUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */