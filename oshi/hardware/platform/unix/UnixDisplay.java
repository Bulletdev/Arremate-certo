/*    */ package oshi.hardware.platform.unix;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.function.Function;
/*    */ import java.util.stream.Collectors;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.driver.unix.Xrandr;
/*    */ import oshi.hardware.Display;
/*    */ import oshi.hardware.common.AbstractDisplay;
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
/*    */ @ThreadSafe
/*    */ public final class UnixDisplay
/*    */   extends AbstractDisplay
/*    */ {
/*    */   UnixDisplay(byte[] paramArrayOfbyte) {
/* 47 */     super(paramArrayOfbyte);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<Display> getDisplays() {
/* 56 */     return (List<Display>)Xrandr.getEdidArrays().stream().map(UnixDisplay::new).collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\UnixDisplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */