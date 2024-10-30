/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Native;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Secur32Util
/*     */ {
/*     */   public static class SecurityPackage
/*     */   {
/*     */     public String name;
/*     */     public String comment;
/*     */   }
/*     */   
/*     */   public static String getUserNameEx(int paramInt) {
/*  61 */     char[] arrayOfChar = new char[128];
/*  62 */     IntByReference intByReference = new IntByReference(arrayOfChar.length);
/*  63 */     boolean bool = Secur32.INSTANCE.GetUserNameEx(paramInt, arrayOfChar, intByReference);
/*     */     
/*  65 */     if (!bool) {
/*     */       
/*  67 */       int i = Kernel32.INSTANCE.GetLastError();
/*     */       
/*  69 */       switch (i) {
/*     */         case 234:
/*  71 */           arrayOfChar = new char[intByReference.getValue() + 1];
/*     */           break;
/*     */         default:
/*  74 */           throw new Win32Exception(Native.getLastError());
/*     */       } 
/*     */       
/*  77 */       bool = Secur32.INSTANCE.GetUserNameEx(paramInt, arrayOfChar, intByReference);
/*     */     } 
/*     */     
/*  80 */     if (!bool) {
/*  81 */       throw new Win32Exception(Native.getLastError());
/*     */     }
/*     */     
/*  84 */     return Native.toString(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SecurityPackage[] getSecurityPackages() {
/*  93 */     IntByReference intByReference = new IntByReference();
/*  94 */     Sspi.PSecPkgInfo pSecPkgInfo = new Sspi.PSecPkgInfo();
/*  95 */     int i = Secur32.INSTANCE.EnumerateSecurityPackages(intByReference, pSecPkgInfo);
/*  96 */     if (0 != i) {
/*  97 */       throw new Win32Exception(i);
/*     */     }
/*  99 */     Sspi.SecPkgInfo.ByReference[] arrayOfByReference = pSecPkgInfo.toArray(intByReference.getValue());
/* 100 */     ArrayList<SecurityPackage> arrayList = new ArrayList(intByReference.getValue());
/* 101 */     for (Sspi.SecPkgInfo.ByReference byReference : arrayOfByReference) {
/* 102 */       SecurityPackage securityPackage = new SecurityPackage();
/* 103 */       securityPackage.name = byReference.Name.toString();
/* 104 */       securityPackage.comment = byReference.Comment.toString();
/* 105 */       arrayList.add(securityPackage);
/*     */     } 
/* 107 */     i = Secur32.INSTANCE.FreeContextBuffer(pSecPkgInfo.pPkgInfo.getPointer());
/* 108 */     if (0 != i) {
/* 109 */       throw new Win32Exception(i);
/*     */     }
/* 111 */     return arrayList.<SecurityPackage>toArray(new SecurityPackage[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Secur32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */