/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
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
/*    */ @Internal
/*    */ class VersionedStream
/*    */ {
/*    */   private GUID _versionGuid;
/*    */   private IndirectPropertyName _streamName;
/*    */   
/*    */   VersionedStream(byte[] paramArrayOfbyte, int paramInt) {
/* 31 */     this._versionGuid = new GUID(paramArrayOfbyte, paramInt);
/* 32 */     this._streamName = new IndirectPropertyName(paramArrayOfbyte, paramInt + 16);
/*    */   }
/*    */ 
/*    */   
/*    */   int getSize() {
/* 37 */     return 16 + this._streamName.getSize();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\VersionedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */