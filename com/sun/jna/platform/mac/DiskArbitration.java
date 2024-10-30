/*    */ package com.sun.jna.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
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
/*    */ public interface DiskArbitration
/*    */   extends Library
/*    */ {
/* 41 */   public static final DiskArbitration INSTANCE = (DiskArbitration)Native.load("DiskArbitration", DiskArbitration.class);
/*    */   
/*    */   DASessionRef DASessionCreate(CoreFoundation.CFAllocatorRef paramCFAllocatorRef);
/*    */   
/*    */   DADiskRef DADiskCreateFromBSDName(CoreFoundation.CFAllocatorRef paramCFAllocatorRef, DASessionRef paramDASessionRef, String paramString);
/*    */   
/*    */   DADiskRef DADiskCreateFromIOMedia(CoreFoundation.CFAllocatorRef paramCFAllocatorRef, DASessionRef paramDASessionRef, IOKit.IOObject paramIOObject);
/*    */   
/*    */   CoreFoundation.CFDictionaryRef DADiskCopyDescription(DADiskRef paramDADiskRef);
/*    */   
/*    */   String DADiskGetBSDName(DADiskRef paramDADiskRef);
/*    */   
/*    */   public static class DASessionRef extends CoreFoundation.CFTypeRef {}
/*    */   
/*    */   public static class DADiskRef extends CoreFoundation.CFTypeRef {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\DiskArbitration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */