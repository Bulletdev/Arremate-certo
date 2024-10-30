/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.VirtualMemory;
/*    */ import oshi.util.FormatUtil;
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
/*    */ @ThreadSafe
/*    */ public abstract class AbstractVirtualMemory
/*    */   implements VirtualMemory
/*    */ {
/*    */   public String toString() {
/* 38 */     StringBuilder stringBuilder = new StringBuilder();
/* 39 */     stringBuilder.append("Swap Used/Avail: ");
/* 40 */     stringBuilder.append(FormatUtil.formatBytes(getSwapUsed()));
/* 41 */     stringBuilder.append("/");
/* 42 */     stringBuilder.append(FormatUtil.formatBytes(getSwapTotal()));
/* 43 */     stringBuilder.append(", Virtual Memory In Use/Max=");
/* 44 */     stringBuilder.append(FormatUtil.formatBytes(getVirtualInUse()));
/* 45 */     stringBuilder.append("/");
/* 46 */     stringBuilder.append(FormatUtil.formatBytes(getVirtualMax()));
/* 47 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractVirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */