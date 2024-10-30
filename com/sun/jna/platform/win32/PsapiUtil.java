/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PsapiUtil
/*    */ {
/*    */   public static int[] enumProcesses() {
/* 46 */     byte b = 0;
/* 47 */     int[] arrayOfInt = null;
/* 48 */     IntByReference intByReference = new IntByReference();
/*    */     do {
/* 50 */       b += true;
/* 51 */       arrayOfInt = new int[b];
/* 52 */       if (!Psapi.INSTANCE.EnumProcesses(arrayOfInt, b * 4, intByReference)) {
/* 53 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*    */       }
/* 55 */     } while (b == intByReference.getValue() / 4);
/*    */     
/* 57 */     return Arrays.copyOf(arrayOfInt, intByReference.getValue() / 4);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String GetProcessImageFileName(WinNT.HANDLE paramHANDLE) {
/*    */     char[] arrayOfChar;
/* 75 */     char c = 'ࠀ';
/*    */     while (true) {
/* 77 */       arrayOfChar = new char[c];
/* 78 */       int i = Psapi.INSTANCE.GetProcessImageFileName(paramHANDLE, arrayOfChar, arrayOfChar.length);
/*    */       
/* 80 */       if (i == 0) {
/* 81 */         if (Native.getLastError() != 122) {
/* 82 */           throw new Win32Exception(Native.getLastError());
/*    */         }
/* 84 */         c += 'ࠀ'; continue;
/*    */       }  break;
/* 86 */     }  return Native.toString(arrayOfChar);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\PsapiUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */