/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Crypt32Util
/*     */ {
/*     */   public static byte[] cryptProtectData(byte[] paramArrayOfbyte) {
/*  49 */     return cryptProtectData(paramArrayOfbyte, 0);
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
/*     */   public static byte[] cryptProtectData(byte[] paramArrayOfbyte, int paramInt) {
/*  62 */     return cryptProtectData(paramArrayOfbyte, null, paramInt, "", null);
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
/*     */   public static byte[] cryptProtectData(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt, String paramString, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT) {
/*  82 */     WinCrypt.DATA_BLOB dATA_BLOB1 = new WinCrypt.DATA_BLOB(paramArrayOfbyte1);
/*  83 */     WinCrypt.DATA_BLOB dATA_BLOB2 = new WinCrypt.DATA_BLOB();
/*  84 */     WinCrypt.DATA_BLOB dATA_BLOB3 = (paramArrayOfbyte2 == null) ? null : new WinCrypt.DATA_BLOB(paramArrayOfbyte2);
/*  85 */     Win32Exception win32Exception = null;
/*  86 */     byte[] arrayOfByte = null;
/*     */     try {
/*  88 */       if (!Crypt32.INSTANCE.CryptProtectData(dATA_BLOB1, paramString, dATA_BLOB3, null, paramCRYPTPROTECT_PROMPTSTRUCT, paramInt, dATA_BLOB2)) {
/*     */         
/*  90 */         win32Exception = new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       } else {
/*  92 */         arrayOfByte = dATA_BLOB2.getData();
/*     */       } 
/*     */     } finally {
/*  95 */       if (dATA_BLOB1.pbData != null) {
/*  96 */         dATA_BLOB1.pbData.clear(dATA_BLOB1.cbData);
/*     */       }
/*  98 */       if (dATA_BLOB3 != null && dATA_BLOB3.pbData != null) {
/*  99 */         dATA_BLOB3.pbData.clear(dATA_BLOB3.cbData);
/*     */       }
/* 101 */       if (dATA_BLOB2.pbData != null) {
/* 102 */         dATA_BLOB2.pbData.clear(dATA_BLOB2.cbData);
/*     */         try {
/* 104 */           Kernel32Util.freeLocalMemory(dATA_BLOB2.pbData);
/* 105 */         } catch (Win32Exception win32Exception1) {
/* 106 */           if (win32Exception == null) {
/* 107 */             win32Exception = win32Exception1;
/*     */           } else {
/* 109 */             win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     if (win32Exception != null) {
/* 116 */       if (arrayOfByte != null) {
/* 117 */         Arrays.fill(arrayOfByte, (byte)0);
/*     */       }
/* 119 */       throw win32Exception;
/*     */     } 
/*     */     
/* 122 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] cryptUnprotectData(byte[] paramArrayOfbyte) {
/* 133 */     return cryptUnprotectData(paramArrayOfbyte, 0);
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
/*     */   public static byte[] cryptUnprotectData(byte[] paramArrayOfbyte, int paramInt) {
/* 146 */     return cryptUnprotectData(paramArrayOfbyte, null, paramInt, null);
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
/*     */   public static byte[] cryptUnprotectData(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT) {
/* 164 */     WinCrypt.DATA_BLOB dATA_BLOB1 = new WinCrypt.DATA_BLOB(paramArrayOfbyte1);
/* 165 */     WinCrypt.DATA_BLOB dATA_BLOB2 = new WinCrypt.DATA_BLOB();
/* 166 */     WinCrypt.DATA_BLOB dATA_BLOB3 = (paramArrayOfbyte2 == null) ? null : new WinCrypt.DATA_BLOB(paramArrayOfbyte2);
/* 167 */     Win32Exception win32Exception = null;
/* 168 */     byte[] arrayOfByte = null;
/*     */     try {
/* 170 */       if (!Crypt32.INSTANCE.CryptUnprotectData(dATA_BLOB1, null, dATA_BLOB3, null, paramCRYPTPROTECT_PROMPTSTRUCT, paramInt, dATA_BLOB2)) {
/*     */         
/* 172 */         win32Exception = new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       } else {
/* 174 */         arrayOfByte = dATA_BLOB2.getData();
/*     */       } 
/*     */     } finally {
/* 177 */       if (dATA_BLOB1.pbData != null) {
/* 178 */         dATA_BLOB1.pbData.clear(dATA_BLOB1.cbData);
/*     */       }
/* 180 */       if (dATA_BLOB3 != null && dATA_BLOB3.pbData != null) {
/* 181 */         dATA_BLOB3.pbData.clear(dATA_BLOB3.cbData);
/*     */       }
/* 183 */       if (dATA_BLOB2.pbData != null) {
/* 184 */         dATA_BLOB2.pbData.clear(dATA_BLOB2.cbData);
/*     */         try {
/* 186 */           Kernel32Util.freeLocalMemory(dATA_BLOB2.pbData);
/* 187 */         } catch (Win32Exception win32Exception1) {
/* 188 */           if (win32Exception == null) {
/* 189 */             win32Exception = win32Exception1;
/*     */           } else {
/* 191 */             win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 197 */     if (win32Exception != null) {
/* 198 */       if (arrayOfByte != null) {
/* 199 */         Arrays.fill(arrayOfByte, (byte)0);
/*     */       }
/* 201 */       throw win32Exception;
/*     */     } 
/*     */     
/* 204 */     return arrayOfByte;
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
/*     */   public static String CertNameToStr(int paramInt1, int paramInt2, WinCrypt.DATA_BLOB paramDATA_BLOB) {
/* 222 */     byte b = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
/*     */ 
/*     */     
/* 225 */     int i = Crypt32.INSTANCE.CertNameToStr(paramInt1, paramDATA_BLOB, paramInt2, Pointer.NULL, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     Memory memory = new Memory((i * b));
/*     */ 
/*     */     
/* 235 */     int j = Crypt32.INSTANCE.CertNameToStr(paramInt1, paramDATA_BLOB, paramInt2, (Pointer)memory, i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     assert j == i;
/*     */     
/* 244 */     if (Boolean.getBoolean("w32.ascii")) {
/* 245 */       return memory.getString(0L);
/*     */     }
/* 247 */     return memory.getWideString(0L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Crypt32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */