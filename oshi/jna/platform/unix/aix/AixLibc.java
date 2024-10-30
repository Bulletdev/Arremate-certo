/*    */ package oshi.jna.platform.unix.aix;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import oshi.jna.platform.unix.CLibrary;
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
/*    */ public interface AixLibc
/*    */   extends CLibrary
/*    */ {
/* 36 */   public static final AixLibc INSTANCE = (AixLibc)Native.load("c", AixLibc.class);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platfor\\unix\aix\AixLibc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */