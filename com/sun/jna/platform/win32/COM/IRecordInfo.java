/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.WString;
/*    */ import com.sun.jna.platform.win32.Guid;
/*    */ import com.sun.jna.platform.win32.Variant;
/*    */ import com.sun.jna.platform.win32.WTypes;
/*    */ import com.sun.jna.platform.win32.WinDef;
/*    */ import com.sun.jna.platform.win32.WinNT;
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
/*    */ public interface IRecordInfo
/*    */   extends IUnknown
/*    */ {
/* 44 */   public static final Guid.IID IID_IRecordInfo = new Guid.IID("{0000002F-0000-0000-C000-000000000046}");
/*    */   
/*    */   WinNT.HRESULT RecordInit(WinDef.PVOID paramPVOID);
/*    */   
/*    */   WinNT.HRESULT RecordClear(WinDef.PVOID paramPVOID);
/*    */   
/*    */   WinNT.HRESULT RecordCopy(WinDef.PVOID paramPVOID1, WinDef.PVOID paramPVOID2);
/*    */   
/*    */   WinNT.HRESULT GetGuid(Guid.GUID paramGUID);
/*    */   
/*    */   WinNT.HRESULT GetName(WTypes.BSTR paramBSTR);
/*    */   
/*    */   WinNT.HRESULT GetSize(WinDef.ULONG paramULONG);
/*    */   
/*    */   WinNT.HRESULT GetTypeInfo(ITypeInfo paramITypeInfo);
/*    */   
/*    */   WinNT.HRESULT GetField(WinDef.PVOID paramPVOID, WString paramWString, Variant.VARIANT paramVARIANT);
/*    */   
/*    */   WinNT.HRESULT GetFieldNoCopy(WinDef.PVOID paramPVOID1, WString paramWString, Variant.VARIANT paramVARIANT, WinDef.PVOID paramPVOID2);
/*    */   
/*    */   WinNT.HRESULT PutField(WinDef.ULONG paramULONG, WinDef.PVOID paramPVOID, WString paramWString, Variant.VARIANT paramVARIANT);
/*    */   
/*    */   WinNT.HRESULT PutFieldNoCopy(WinDef.ULONG paramULONG, WinDef.PVOID paramPVOID, WString paramWString, Variant.VARIANT paramVARIANT);
/*    */   
/*    */   WinNT.HRESULT GetFieldNames(WinDef.ULONG paramULONG, WTypes.BSTR paramBSTR);
/*    */   
/*    */   WinDef.BOOL IsMatchingType(IRecordInfo paramIRecordInfo);
/*    */   
/*    */   WinDef.PVOID RecordCreate();
/*    */   
/*    */   WinNT.HRESULT RecordCreateCopy(WinDef.PVOID paramPVOID1, WinDef.PVOID paramPVOID2);
/*    */   
/*    */   WinNT.HRESULT RecordDestroy(WinDef.PVOID paramPVOID);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */