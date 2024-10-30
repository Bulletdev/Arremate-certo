/*    */ package oshi.jna.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.mac.CoreFoundation;
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
/*    */ public interface SystemConfiguration
/*    */   extends Library
/*    */ {
/*    */   CoreFoundation.CFArrayRef SCNetworkInterfaceCopyAll();
/*    */   
/*    */   CoreFoundation.CFStringRef SCNetworkInterfaceGetBSDName(SCNetworkInterfaceRef paramSCNetworkInterfaceRef);
/*    */   
/* 40 */   public static final SystemConfiguration INSTANCE = (SystemConfiguration)Native.load("SystemConfiguration", SystemConfiguration.class);
/*    */   
/*    */   CoreFoundation.CFStringRef SCNetworkInterfaceGetLocalizedDisplayName(SCNetworkInterfaceRef paramSCNetworkInterfaceRef);
/*    */   
/*    */   public static class SCNetworkInterfaceRef
/*    */     extends CoreFoundation.CFTypeRef
/*    */   {
/*    */     public SCNetworkInterfaceRef(Pointer param1Pointer) {
/* 48 */       super(param1Pointer);
/*    */     }
/*    */     
/*    */     public SCNetworkInterfaceRef() {}
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\mac\SystemConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */