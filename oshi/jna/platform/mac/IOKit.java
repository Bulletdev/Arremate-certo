/*    */ package oshi.jna.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.NativeLong;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.platform.mac.IOKit;
/*    */ import com.sun.jna.ptr.NativeLongByReference;
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
/*    */ public interface IOKit
/*    */   extends IOKit
/*    */ {
/* 37 */   public static final IOKit INSTANCE = (IOKit)Native.load("IOKit", IOKit.class);
/*    */   
/*    */   int IOConnectCallStructMethod(IOKit.IOConnect paramIOConnect, int paramInt, Structure paramStructure1, NativeLong paramNativeLong, Structure paramStructure2, NativeLongByReference paramNativeLongByReference);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\mac\IOKit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */