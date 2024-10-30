/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface VerRsrc
/*     */ {
/*     */   @FieldOrder({"dwSignature", "dwStrucVersion", "dwFileVersionMS", "dwFileVersionLS", "dwProductVersionMS", "dwProductVersionLS", "dwFileFlagsMask", "dwFileFlags", "dwFileOS", "dwFileType", "dwFileSubtype", "dwFileDateMS", "dwFileDateLS"})
/*     */   public static class VS_FIXEDFILEINFO
/*     */     extends Structure
/*     */   {
/*     */     public WinDef.DWORD dwSignature;
/*     */     public WinDef.DWORD dwStrucVersion;
/*     */     public WinDef.DWORD dwFileVersionMS;
/*     */     public WinDef.DWORD dwFileVersionLS;
/*     */     public WinDef.DWORD dwProductVersionMS;
/*     */     public WinDef.DWORD dwProductVersionLS;
/*     */     public WinDef.DWORD dwFileFlagsMask;
/*     */     public WinDef.DWORD dwFileFlags;
/*     */     public WinDef.DWORD dwFileOS;
/*     */     public WinDef.DWORD dwFileType;
/*     */     public WinDef.DWORD dwFileSubtype;
/*     */     public WinDef.DWORD dwFileDateMS;
/*     */     public WinDef.DWORD dwFileDateLS;
/*     */     
/*     */     public static class ByReference
/*     */       extends VS_FIXEDFILEINFO
/*     */       implements Structure.ByReference
/*     */     {
/*     */       public ByReference() {}
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/*  51 */         super(param2Pointer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public VS_FIXEDFILEINFO() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public VS_FIXEDFILEINFO(Pointer param1Pointer) {
/* 133 */       super(param1Pointer);
/* 134 */       read();
/*     */     }
/*     */     
/*     */     public int getFileVersionMajor() {
/* 138 */       return this.dwFileVersionMS.intValue() >>> 16;
/*     */     }
/*     */     
/*     */     public int getFileVersionMinor() {
/* 142 */       return this.dwFileVersionMS.intValue() & 0xFFFF;
/*     */     }
/*     */     
/*     */     public int getFileVersionRevision() {
/* 146 */       return this.dwFileVersionLS.intValue() >>> 16;
/*     */     }
/*     */     
/*     */     public int getFileVersionBuild() {
/* 150 */       return this.dwFileVersionLS.intValue() & 0xFFFF;
/*     */     }
/*     */     
/*     */     public int getProductVersionMajor() {
/* 154 */       return this.dwProductVersionMS.intValue() >>> 16;
/*     */     }
/*     */     
/*     */     public int getProductVersionMinor() {
/* 158 */       return this.dwProductVersionMS.intValue() & 0xFFFF;
/*     */     }
/*     */     
/*     */     public int getProductVersionRevision() {
/* 162 */       return this.dwProductVersionLS.intValue() >>> 16;
/*     */     }
/*     */     
/*     */     public int getProductVersionBuild() {
/* 166 */       return this.dwProductVersionLS.intValue() & 0xFFFF;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\VerRsrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */