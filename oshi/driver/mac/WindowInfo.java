/*     */ package oshi.driver.mac;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.platform.mac.CoreFoundation;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.mac.CoreGraphics;
/*     */ import oshi.software.os.OSDesktopWindow;
/*     */ import oshi.util.FormatUtil;
/*     */ import oshi.util.platform.mac.CFUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class WindowInfo
/*     */ {
/*     */   public static List<OSDesktopWindow> queryDesktopWindows(boolean paramBoolean) {
/*  67 */     CoreFoundation.CFArrayRef cFArrayRef = CoreGraphics.INSTANCE.CGWindowListCopyWindowInfo(
/*  68 */         paramBoolean ? 17 : 
/*  69 */         0, 0);
/*     */     
/*  71 */     int i = cFArrayRef.getCount();
/*     */     
/*  73 */     ArrayList<OSDesktopWindow> arrayList = new ArrayList();
/*     */     
/*  75 */     CoreFoundation.CFStringRef cFStringRef1 = CoreFoundation.CFStringRef.createCFString("kCGWindowIsOnscreen");
/*  76 */     CoreFoundation.CFStringRef cFStringRef2 = CoreFoundation.CFStringRef.createCFString("kCGWindowNumber");
/*  77 */     CoreFoundation.CFStringRef cFStringRef3 = CoreFoundation.CFStringRef.createCFString("kCGWindowOwnerPID");
/*  78 */     CoreFoundation.CFStringRef cFStringRef4 = CoreFoundation.CFStringRef.createCFString("kCGWindowLayer");
/*  79 */     CoreFoundation.CFStringRef cFStringRef5 = CoreFoundation.CFStringRef.createCFString("kCGWindowBounds");
/*  80 */     CoreFoundation.CFStringRef cFStringRef6 = CoreFoundation.CFStringRef.createCFString("kCGWindowName");
/*  81 */     CoreFoundation.CFStringRef cFStringRef7 = CoreFoundation.CFStringRef.createCFString("kCGWindowOwnerName");
/*     */     
/*     */     try {
/*  84 */       for (byte b = 0; b < i; b++) {
/*     */         
/*  86 */         Pointer pointer = cFArrayRef.getValueAtIndex(b);
/*  87 */         CoreFoundation.CFDictionaryRef cFDictionaryRef = new CoreFoundation.CFDictionaryRef(pointer);
/*     */         
/*  89 */         pointer = cFDictionaryRef.getValue((PointerType)cFStringRef1);
/*  90 */         boolean bool = (pointer == null || (new CoreFoundation.CFBooleanRef(pointer)).booleanValue()) ? true : false;
/*  91 */         if (!paramBoolean || bool) {
/*  92 */           pointer = cFDictionaryRef.getValue((PointerType)cFStringRef2);
/*  93 */           long l1 = (new CoreFoundation.CFNumberRef(pointer)).longValue();
/*     */           
/*  95 */           pointer = cFDictionaryRef.getValue((PointerType)cFStringRef3);
/*  96 */           long l2 = (new CoreFoundation.CFNumberRef(pointer)).longValue();
/*     */           
/*  98 */           pointer = cFDictionaryRef.getValue((PointerType)cFStringRef4);
/*  99 */           int j = (new CoreFoundation.CFNumberRef(pointer)).intValue();
/*     */           
/* 101 */           pointer = cFDictionaryRef.getValue((PointerType)cFStringRef5);
/* 102 */           CoreGraphics.CGRect cGRect = new CoreGraphics.CGRect();
/* 103 */           CoreGraphics.INSTANCE.CGRectMakeWithDictionaryRepresentation(new CoreFoundation.CFDictionaryRef(pointer), cGRect);
/*     */ 
/*     */           
/* 106 */           Rectangle rectangle = new Rectangle(FormatUtil.roundToInt(cGRect.origin.x), FormatUtil.roundToInt(cGRect.origin.y), FormatUtil.roundToInt(cGRect.size.width), FormatUtil.roundToInt(cGRect.size.height));
/*     */ 
/*     */           
/* 109 */           pointer = cFDictionaryRef.getValue((PointerType)cFStringRef6);
/* 110 */           String str1 = CFUtil.cfPointerToString(pointer, false);
/*     */ 
/*     */           
/* 113 */           pointer = cFDictionaryRef.getValue((PointerType)cFStringRef7);
/* 114 */           String str2 = CFUtil.cfPointerToString(pointer, false);
/* 115 */           if (str1.isEmpty()) {
/* 116 */             str1 = str2;
/*     */           } else {
/* 118 */             str1 = str1 + "(" + str2 + ")";
/*     */           } 
/*     */           
/* 121 */           arrayList.add(new OSDesktopWindow(l1, str1, str2, rectangle, l2, j, bool));
/*     */         }
/*     */       
/*     */       } 
/*     */     } finally {
/*     */       
/* 127 */       cFStringRef1.release();
/* 128 */       cFStringRef2.release();
/* 129 */       cFStringRef3.release();
/* 130 */       cFStringRef4.release();
/* 131 */       cFStringRef5.release();
/* 132 */       cFStringRef6.release();
/* 133 */       cFStringRef7.release();
/* 134 */       cFArrayRef.release();
/*     */     } 
/*     */     
/* 137 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\mac\WindowInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */