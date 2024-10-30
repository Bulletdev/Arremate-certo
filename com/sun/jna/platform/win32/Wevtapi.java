/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Callback;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import com.sun.jna.win32.W32APIOptions;
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
/*    */ public interface Wevtapi
/*    */   extends StdCallLibrary
/*    */ {
/* 41 */   public static final Wevtapi INSTANCE = (Wevtapi)Native.load("wevtapi", Wevtapi.class, W32APIOptions.UNICODE_OPTIONS);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenSession(int paramInt1, Winevt.EVT_RPC_LOGIN paramEVT_RPC_LOGIN, int paramInt2, int paramInt3);
/*    */   
/*    */   boolean EvtClose(Winevt.EVT_HANDLE paramEVT_HANDLE);
/*    */   
/*    */   boolean EvtCancel(Winevt.EVT_HANDLE paramEVT_HANDLE);
/*    */   
/*    */   int EvtGetExtendedStatus(int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtQuery(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString1, String paramString2, int paramInt);
/*    */   
/*    */   boolean EvtNext(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, Winevt.EVT_HANDLE[] paramArrayOfEVT_HANDLE, int paramInt2, int paramInt3, IntByReference paramIntByReference);
/*    */   
/*    */   boolean EvtSeek(Winevt.EVT_HANDLE paramEVT_HANDLE1, long paramLong, Winevt.EVT_HANDLE paramEVT_HANDLE2, int paramInt1, int paramInt2);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtSubscribe(Winevt.EVT_HANDLE paramEVT_HANDLE1, Winevt.EVT_HANDLE paramEVT_HANDLE2, String paramString1, String paramString2, Winevt.EVT_HANDLE paramEVT_HANDLE3, Pointer paramPointer, Callback paramCallback, int paramInt);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtCreateRenderContext(int paramInt1, String[] paramArrayOfString, int paramInt2);
/*    */   
/*    */   boolean EvtRender(Winevt.EVT_HANDLE paramEVT_HANDLE1, Winevt.EVT_HANDLE paramEVT_HANDLE2, int paramInt1, int paramInt2, Pointer paramPointer, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   
/*    */   boolean EvtFormatMessage(Winevt.EVT_HANDLE paramEVT_HANDLE1, Winevt.EVT_HANDLE paramEVT_HANDLE2, int paramInt1, int paramInt2, Winevt.EVT_VARIANT[] paramArrayOfEVT_VARIANT, int paramInt3, int paramInt4, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenLog(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString, int paramInt);
/*    */   
/*    */   boolean EvtGetLogInfo(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   boolean EvtClearLog(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString1, String paramString2, int paramInt);
/*    */   
/*    */   boolean EvtExportLog(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString1, String paramString2, String paramString3, int paramInt);
/*    */   
/*    */   boolean EvtArchiveExportedLog(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString, int paramInt1, int paramInt2);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenChannelEnum(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt);
/*    */   
/*    */   boolean EvtNextChannelPath(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenChannelConfig(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString, int paramInt);
/*    */   
/*    */   boolean EvtSaveChannelConfig(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt);
/*    */   
/*    */   boolean EvtSetChannelConfigProperty(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, Winevt.EVT_VARIANT paramEVT_VARIANT);
/*    */   
/*    */   boolean EvtGetChannelConfigProperty(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenPublisherEnum(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt);
/*    */   
/*    */   boolean EvtNextPublisherId(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenPublisherMetadata(Winevt.EVT_HANDLE paramEVT_HANDLE, String paramString1, String paramString2, int paramInt1, int paramInt2);
/*    */   
/*    */   boolean EvtGetPublisherMetadataProperty(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtOpenEventMetadataEnum(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtNextEventMetadata(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt);
/*    */   
/*    */   boolean EvtGetEventMetadataProperty(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   boolean EvtGetObjectArraySize(Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   boolean EvtGetObjectArrayProperty(Pointer paramPointer1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Pointer paramPointer2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean EvtGetQueryInfo(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   Winevt.EVT_HANDLE EvtCreateBookmark(String paramString);
/*    */   
/*    */   boolean EvtUpdateBookmark(Winevt.EVT_HANDLE paramEVT_HANDLE1, Winevt.EVT_HANDLE paramEVT_HANDLE2);
/*    */   
/*    */   boolean EvtGetEventInfo(Winevt.EVT_HANDLE paramEVT_HANDLE, int paramInt1, int paramInt2, Pointer paramPointer, IntByReference paramIntByReference);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Wevtapi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */