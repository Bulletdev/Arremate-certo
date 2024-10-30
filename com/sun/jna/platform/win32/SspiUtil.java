/*    */ package com.sun.jna.platform.win32;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SspiUtil
/*    */ {
/*    */   public static class ManagedSecBufferDesc
/*    */     extends Sspi.SecBufferDesc
/*    */   {
/*    */     private final Sspi.SecBuffer[] secBuffers;
/*    */     
/*    */     public ManagedSecBufferDesc(int param1Int, byte[] param1ArrayOfbyte) {
/* 56 */       this.secBuffers = new Sspi.SecBuffer[] { new Sspi.SecBuffer(param1Int, param1ArrayOfbyte) };
/* 57 */       this.pBuffers = this.secBuffers[0].getPointer();
/* 58 */       this.cBuffers = this.secBuffers.length;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public ManagedSecBufferDesc(int param1Int1, int param1Int2) {
/* 67 */       this.secBuffers = new Sspi.SecBuffer[] { new Sspi.SecBuffer(param1Int1, param1Int2) };
/* 68 */       this.pBuffers = this.secBuffers[0].getPointer();
/* 69 */       this.cBuffers = this.secBuffers.length;
/*    */     }
/*    */     
/*    */     public ManagedSecBufferDesc(int param1Int) {
/* 73 */       this.cBuffers = param1Int;
/* 74 */       this.secBuffers = (Sspi.SecBuffer[])(new Sspi.SecBuffer()).toArray(param1Int);
/* 75 */       this.pBuffers = this.secBuffers[0].getPointer();
/* 76 */       this.cBuffers = this.secBuffers.length;
/*    */     }
/*    */     
/*    */     public Sspi.SecBuffer getBuffer(int param1Int) {
/* 80 */       return this.secBuffers[param1Int];
/*    */     }
/*    */ 
/*    */     
/*    */     public void write() {
/* 85 */       for (Sspi.SecBuffer secBuffer : this.secBuffers) {
/* 86 */         secBuffer.write();
/*    */       }
/* 88 */       writeField("ulVersion");
/* 89 */       writeField("pBuffers");
/* 90 */       writeField("cBuffers");
/*    */     }
/*    */ 
/*    */     
/*    */     public void read() {
/* 95 */       for (Sspi.SecBuffer secBuffer : this.secBuffers)
/* 96 */         secBuffer.read(); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\SspiUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */