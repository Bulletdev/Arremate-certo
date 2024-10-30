/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
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
/*    */ public abstract class Ole32Util
/*    */ {
/*    */   public static Guid.GUID getGUIDFromString(String paramString) {
/* 44 */     Guid.GUID gUID = new Guid.GUID();
/* 45 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.IIDFromString(paramString, gUID);
/* 46 */     if (!hRESULT.equals(W32Errors.S_OK)) {
/* 47 */       throw new RuntimeException(hRESULT.toString());
/*    */     }
/* 49 */     return gUID;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getStringFromGUID(Guid.GUID paramGUID) {
/* 60 */     Guid.GUID gUID = new Guid.GUID(paramGUID.getPointer());
/* 61 */     byte b = 39;
/* 62 */     char[] arrayOfChar = new char[b];
/* 63 */     int i = Ole32.INSTANCE.StringFromGUID2(gUID, arrayOfChar, b);
/* 64 */     if (i == 0) {
/* 65 */       throw new RuntimeException("StringFromGUID2");
/*    */     }
/* 67 */     arrayOfChar[i - 1] = Character.MIN_VALUE;
/* 68 */     return Native.toString(arrayOfChar);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Guid.GUID generateGUID() {
/* 77 */     Guid.GUID gUID = new Guid.GUID();
/* 78 */     WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoCreateGuid(gUID);
/* 79 */     if (!hRESULT.equals(W32Errors.S_OK)) {
/* 80 */       throw new RuntimeException(hRESULT.toString());
/*    */     }
/* 82 */     return gUID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Ole32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */