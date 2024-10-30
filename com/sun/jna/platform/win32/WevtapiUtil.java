/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class WevtapiUtil
/*     */ {
/*     */   public static String EvtGetExtendedStatus() {
/*  46 */     IntByReference intByReference = new IntByReference();
/*  47 */     int i = Wevtapi.INSTANCE.EvtGetExtendedStatus(0, null, intByReference);
/*  48 */     if (i != 0 && i != 122) {
/*  49 */       throw new Win32Exception(i);
/*     */     }
/*  51 */     if (intByReference.getValue() == 0) {
/*  52 */       return "";
/*     */     }
/*  54 */     char[] arrayOfChar = new char[intByReference.getValue()];
/*  55 */     i = Wevtapi.INSTANCE.EvtGetExtendedStatus(arrayOfChar.length, arrayOfChar, intByReference);
/*  56 */     if (i != 0) {
/*  57 */       throw new Win32Exception(i);
/*     */     }
/*  59 */     return Native.toString(arrayOfChar);
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
/*     */   public static Memory EvtRender(Winevt.EVT_HANDLE paramEVT_HANDLE1, Winevt.EVT_HANDLE paramEVT_HANDLE2, int paramInt, IntByReference paramIntByReference) {
/*  86 */     IntByReference intByReference = new IntByReference();
/*  87 */     boolean bool = Wevtapi.INSTANCE.EvtRender(paramEVT_HANDLE1, paramEVT_HANDLE2, paramInt, 0, null, intByReference, paramIntByReference);
/*  88 */     int i = Kernel32.INSTANCE.GetLastError();
/*  89 */     if (!bool && i != 122) {
/*  90 */       throw new Win32Exception(i);
/*     */     }
/*  92 */     Memory memory = new Memory(intByReference.getValue());
/*  93 */     bool = Wevtapi.INSTANCE.EvtRender(paramEVT_HANDLE1, paramEVT_HANDLE2, paramInt, (int)memory.size(), (Pointer)memory, intByReference, paramIntByReference);
/*  94 */     if (!bool) {
/*  95 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*  97 */     return memory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String EvtFormatMessage(Winevt.EVT_HANDLE paramEVT_HANDLE1, Winevt.EVT_HANDLE paramEVT_HANDLE2, int paramInt1, int paramInt2, Winevt.EVT_VARIANT[] paramArrayOfEVT_VARIANT, int paramInt3) {
/* 141 */     IntByReference intByReference = new IntByReference();
/* 142 */     boolean bool = Wevtapi.INSTANCE.EvtFormatMessage(paramEVT_HANDLE1, paramEVT_HANDLE2, paramInt1, paramInt2, paramArrayOfEVT_VARIANT, paramInt3, 0, null, intByReference);
/* 143 */     int i = Kernel32.INSTANCE.GetLastError();
/* 144 */     if (!bool && i != 122) {
/* 145 */       throw new Win32Exception(i);
/*     */     }
/*     */     
/* 148 */     char[] arrayOfChar = new char[intByReference.getValue()];
/* 149 */     bool = Wevtapi.INSTANCE.EvtFormatMessage(paramEVT_HANDLE1, paramEVT_HANDLE2, paramInt1, paramInt2, paramArrayOfEVT_VARIANT, paramInt3, arrayOfChar.length, arrayOfChar, intByReference);
/*     */     
/* 151 */     if (!bool) {
/* 152 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 154 */     return Native.toString(arrayOfChar);
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
/*     */   public static Winevt.EVT_VARIANT EvtGetChannelConfigProperty(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt) {
/* 167 */     IntByReference intByReference = new IntByReference();
/* 168 */     boolean bool = Wevtapi.INSTANCE.EvtGetChannelConfigProperty(paramEVT_HANDLE, paramInt, 0, 0, null, intByReference);
/* 169 */     int i = Kernel32.INSTANCE.GetLastError();
/* 170 */     if (!bool && i != 122) {
/* 171 */       throw new Win32Exception(i);
/*     */     }
/*     */     
/* 174 */     Memory memory = new Memory(intByReference.getValue());
/* 175 */     bool = Wevtapi.INSTANCE.EvtGetChannelConfigProperty(paramEVT_HANDLE, paramInt, 0, (int)memory.size(), (Pointer)memory, intByReference);
/*     */     
/* 177 */     if (!bool) {
/* 178 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 180 */     Winevt.EVT_VARIANT eVT_VARIANT = new Winevt.EVT_VARIANT((Pointer)memory);
/* 181 */     eVT_VARIANT.read();
/* 182 */     return eVT_VARIANT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String EvtNextPublisherId(Winevt.EVT_HANDLE paramEVT_HANDLE) {
/* 193 */     IntByReference intByReference = new IntByReference();
/* 194 */     boolean bool = Wevtapi.INSTANCE.EvtNextPublisherId(paramEVT_HANDLE, 0, null, intByReference);
/* 195 */     int i = Kernel32.INSTANCE.GetLastError();
/* 196 */     if (!bool && i != 122) {
/* 197 */       throw new Win32Exception(i);
/*     */     }
/*     */     
/* 200 */     char[] arrayOfChar = new char[intByReference.getValue()];
/* 201 */     bool = Wevtapi.INSTANCE.EvtNextPublisherId(paramEVT_HANDLE, arrayOfChar.length, arrayOfChar, intByReference);
/* 202 */     if (!bool) {
/* 203 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 205 */     return Native.toString(arrayOfChar);
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
/*     */   public static Memory EvtGetPublisherMetadataProperty(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2) {
/* 220 */     IntByReference intByReference = new IntByReference();
/* 221 */     boolean bool = Wevtapi.INSTANCE.EvtGetPublisherMetadataProperty(paramEVT_HANDLE, paramInt1, paramInt2, 0, null, intByReference);
/*     */     
/* 223 */     int i = Kernel32.INSTANCE.GetLastError();
/* 224 */     if (!bool && i != 122) {
/* 225 */       throw new Win32Exception(i);
/*     */     }
/* 227 */     Memory memory = new Memory(intByReference.getValue());
/* 228 */     bool = Wevtapi.INSTANCE.EvtGetPublisherMetadataProperty(paramEVT_HANDLE, paramInt1, paramInt2, 
/* 229 */         (int)memory.size(), (Pointer)memory, intByReference);
/* 230 */     if (!bool) {
/* 231 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/* 233 */     return memory;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WevtapiUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */