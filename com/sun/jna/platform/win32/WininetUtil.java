/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WininetUtil
/*     */ {
/*     */   public static Map<String, String> getCache() {
/*     */     Win32Exception win32Exception;
/*  50 */     ArrayList<Wininet.INTERNET_CACHE_ENTRY_INFO> arrayList = new ArrayList();
/*     */     
/*  52 */     WinNT.HANDLE hANDLE = null;
/*  53 */     Throwable throwable = null;
/*  54 */     int i = 0;
/*     */ 
/*     */     
/*  57 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*     */     
/*     */     try {
/*  60 */       IntByReference intByReference = new IntByReference();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  65 */       hANDLE = Wininet.INSTANCE.FindFirstUrlCacheEntry(null, null, intByReference);
/*  66 */       i = Native.getLastError();
/*     */ 
/*     */       
/*  69 */       if (i == 259)
/*  70 */         return (Map)linkedHashMap; 
/*  71 */       if (i != 0 && i != 122) {
/*  72 */         throw new Win32Exception(i);
/*     */       }
/*     */       
/*  75 */       Wininet.INTERNET_CACHE_ENTRY_INFO iNTERNET_CACHE_ENTRY_INFO = new Wininet.INTERNET_CACHE_ENTRY_INFO(intByReference.getValue());
/*  76 */       hANDLE = Wininet.INSTANCE.FindFirstUrlCacheEntry(null, iNTERNET_CACHE_ENTRY_INFO, intByReference);
/*     */       
/*  78 */       if (hANDLE == null) {
/*  79 */         throw new Win32Exception(Native.getLastError());
/*     */       }
/*     */       
/*  82 */       arrayList.add(iNTERNET_CACHE_ENTRY_INFO);
/*     */       
/*     */       while (true) {
/*  85 */         intByReference = new IntByReference();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  90 */         boolean bool = Wininet.INSTANCE.FindNextUrlCacheEntry(hANDLE, null, intByReference);
/*     */         
/*  92 */         if (!bool) {
/*  93 */           i = Native.getLastError();
/*  94 */           if (i == 259)
/*     */             break; 
/*  96 */           if (i != 0 && i != 122) {
/*  97 */             throw new Win32Exception(i);
/*     */           }
/*     */         } 
/*     */         
/* 101 */         iNTERNET_CACHE_ENTRY_INFO = new Wininet.INTERNET_CACHE_ENTRY_INFO(intByReference.getValue());
/* 102 */         bool = Wininet.INSTANCE.FindNextUrlCacheEntry(hANDLE, iNTERNET_CACHE_ENTRY_INFO, intByReference);
/*     */         
/* 104 */         if (!bool) {
/* 105 */           i = Native.getLastError();
/* 106 */           if (i == 259)
/*     */             break; 
/* 108 */           if (i != 0 && i != 122) {
/* 109 */             throw new Win32Exception(i);
/*     */           }
/*     */         } 
/* 112 */         arrayList.add(iNTERNET_CACHE_ENTRY_INFO);
/*     */       } 
/*     */       
/* 115 */       for (Wininet.INTERNET_CACHE_ENTRY_INFO iNTERNET_CACHE_ENTRY_INFO1 : arrayList) {
/* 116 */         linkedHashMap.put(iNTERNET_CACHE_ENTRY_INFO1.lpszSourceUrlName.getWideString(0L), (iNTERNET_CACHE_ENTRY_INFO1.lpszLocalFileName == null) ? "" : iNTERNET_CACHE_ENTRY_INFO1.lpszLocalFileName.getWideString(0L));
/*     */       }
/*     */     }
/* 119 */     catch (Win32Exception win32Exception1) {
/* 120 */       win32Exception = win32Exception1;
/*     */     } finally {
/* 122 */       if (hANDLE != null && 
/* 123 */         !Wininet.INSTANCE.FindCloseUrlCache(hANDLE) && 
/* 124 */         win32Exception != null) {
/* 125 */         Win32Exception win32Exception1 = new Win32Exception(Native.getLastError());
/* 126 */         win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/* 127 */         win32Exception = win32Exception1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 132 */     if (win32Exception != null) {
/* 133 */       throw win32Exception;
/*     */     }
/* 135 */     return (Map)linkedHashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WininetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */