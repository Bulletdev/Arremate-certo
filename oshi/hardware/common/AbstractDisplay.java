/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.Display;
/*    */ import oshi.util.EdidUtil;
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
/*    */ @Immutable
/*    */ public abstract class AbstractDisplay
/*    */   implements Display
/*    */ {
/*    */   private final byte[] edid;
/*    */   
/*    */   protected AbstractDisplay(byte[] paramArrayOfbyte) {
/* 47 */     this.edid = Arrays.copyOf(paramArrayOfbyte, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte[] getEdid() {
/* 52 */     return Arrays.copyOf(this.edid, this.edid.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     return EdidUtil.toString(this.edid);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractDisplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */