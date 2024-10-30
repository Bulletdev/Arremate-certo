/*    */ package oshi.util.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.mac.CoreFoundation;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
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
/*    */ @ThreadSafe
/*    */ public final class CFUtil
/*    */ {
/*    */   public static String cfPointerToString(Pointer paramPointer) {
/* 49 */     return cfPointerToString(paramPointer, true);
/*    */   }
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
/*    */   public static String cfPointerToString(Pointer paramPointer, boolean paramBoolean) {
/* 63 */     String str = "";
/* 64 */     if (paramPointer != null) {
/* 65 */       CoreFoundation.CFStringRef cFStringRef = new CoreFoundation.CFStringRef(paramPointer);
/* 66 */       str = cFStringRef.stringValue();
/*    */     } 
/* 68 */     if (paramBoolean && str.isEmpty()) {
/* 69 */       return "unknown";
/*    */     }
/* 71 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\mac\CFUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */