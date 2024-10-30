/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.WString;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import com.sun.jna.win32.W32APIOptions;
/*    */ import com.sun.jna.win32.W32APITypeMapper;
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
/*    */ public interface Netapi32
/*    */   extends StdCallLibrary
/*    */ {
/* 46 */   public static final Netapi32 INSTANCE = (Netapi32)Native.load("Netapi32", Netapi32.class, W32APIOptions.DEFAULT_OPTIONS); public static final int MAX_PREFERRED_LENGTH = -1; int NetSessionEnum(WString paramWString1, WString paramWString2, WString paramWString3, int paramInt1, PointerByReference paramPointerByReference, int paramInt2, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3); int NetGetJoinInformation(String paramString, PointerByReference paramPointerByReference, IntByReference paramIntByReference); int NetApiBufferFree(Pointer paramPointer); int NetLocalGroupEnum(String paramString, int paramInt1, PointerByReference paramPointerByReference, int paramInt2, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3); int NetGetDCName(String paramString1, String paramString2, PointerByReference paramPointerByReference); int NetGroupEnum(String paramString, int paramInt1, PointerByReference paramPointerByReference, int paramInt2, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3);
/*    */   int NetUserEnum(String paramString, int paramInt1, int paramInt2, PointerByReference paramPointerByReference, int paramInt3, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3);
/*    */   int NetUserGetGroups(String paramString1, String paramString2, int paramInt1, PointerByReference paramPointerByReference, int paramInt2, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   int NetUserGetLocalGroups(String paramString1, String paramString2, int paramInt1, int paramInt2, PointerByReference paramPointerByReference, int paramInt3, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   int NetUserAdd(String paramString, int paramInt, Structure paramStructure, IntByReference paramIntByReference);
/*    */   int NetUserDel(String paramString1, String paramString2);
/*    */   int NetUserChangePassword(String paramString1, String paramString2, String paramString3, String paramString4);
/*    */   int DsGetDcName(String paramString1, String paramString2, Guid.GUID paramGUID, String paramString3, int paramInt, DsGetDC.PDOMAIN_CONTROLLER_INFO paramPDOMAIN_CONTROLLER_INFO);
/*    */   int DsGetForestTrustInformation(String paramString1, String paramString2, int paramInt, NTSecApi.PLSA_FOREST_TRUST_INFORMATION paramPLSA_FOREST_TRUST_INFORMATION);
/*    */   int DsEnumerateDomainTrusts(String paramString, int paramInt, PointerByReference paramPointerByReference, IntByReference paramIntByReference);
/*    */   int NetUserGetInfo(String paramString1, String paramString2, int paramInt, PointerByReference paramPointerByReference);
/*    */   int NetShareAdd(String paramString, int paramInt, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   int NetShareDel(String paramString1, String paramString2, int paramInt);
/*    */   @FieldOrder({"sesi10_cname", "sesi10_username", "sesi10_time", "sesi10_idle_time"})
/*    */   public static class SESSION_INFO_10 extends Structure { public String sesi10_cname; public String sesi10_username;
/*    */     public SESSION_INFO_10() {
/* 62 */       super(W32APITypeMapper.UNICODE);
/*    */     }
/*    */     public int sesi10_time; public int sesi10_idle_time;
/*    */     public SESSION_INFO_10(Pointer param1Pointer) {
/* 66 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 67 */       read();
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Netapi32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */