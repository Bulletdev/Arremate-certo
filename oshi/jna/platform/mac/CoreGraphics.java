/*    */ package oshi.jna.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface CoreGraphics
/*    */   extends Library
/*    */ {
/* 46 */   public static final CoreGraphics INSTANCE = (CoreGraphics)Native.load("CoreGraphics", CoreGraphics.class);
/*    */   public static final int kCGNullWindowID = 0;
/*    */   public static final int kCGWindowListOptionAll = 0;
/*    */   public static final int kCGWindowListOptionOnScreenOnly = 1;
/*    */   public static final int kCGWindowListOptionOnScreenAboveWindow = 2;
/*    */   public static final int kCGWindowListOptionOnScreenBelowWindow = 4;
/*    */   public static final int kCGWindowListOptionIncludingWindow = 8;
/*    */   public static final int kCGWindowListExcludeDesktopElements = 16;
/*    */   
/*    */   CoreFoundation.CFArrayRef CGWindowListCopyWindowInfo(int paramInt1, int paramInt2);
/*    */   
/*    */   boolean CGRectMakeWithDictionaryRepresentation(CoreFoundation.CFDictionaryRef paramCFDictionaryRef, CGRect paramCGRect);
/*    */   
/*    */   @FieldOrder({"x", "y"})
/*    */   public static class CGPoint extends Structure {
/*    */     public double x;
/*    */     public double y;
/*    */   }
/*    */   
/*    */   @FieldOrder({"width", "height"})
/*    */   public static class CGSize extends Structure {
/*    */     public double width;
/*    */     public double height;
/*    */   }
/*    */   
/*    */   @FieldOrder({"origin", "size"})
/*    */   public static class CGRect extends Structure {
/*    */     public CoreGraphics.CGPoint origin;
/*    */     public CoreGraphics.CGSize size;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\mac\CoreGraphics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */