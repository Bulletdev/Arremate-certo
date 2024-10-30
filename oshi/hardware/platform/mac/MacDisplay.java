/*    */ package oshi.hardware.platform.mac;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.mac.CoreFoundation;
/*    */ import com.sun.jna.platform.mac.IOKit;
/*    */ import com.sun.jna.platform.mac.IOKitUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import oshi.annotation.concurrent.Immutable;
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
/*    */ @Immutable
/*    */ final class MacDisplay
/*    */   extends AbstractDisplay
/*    */ {
/* 50 */   private static final Logger LOG = LoggerFactory.getLogger(MacDisplay.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   MacDisplay(byte[] paramArrayOfbyte) {
/* 59 */     super(paramArrayOfbyte);
/* 60 */     LOG.debug("Initialized MacDisplay");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<Display> getDisplays() {
/* 69 */     ArrayList<MacDisplay> arrayList = new ArrayList();
/*    */     
/* 71 */     IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices("IODisplayConnect");
/* 72 */     if (iOIterator != null) {
/* 73 */       CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("IODisplayEDID");
/* 74 */       IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/* 75 */       while (iORegistryEntry != null) {
/*    */         
/* 77 */         IOKit.IORegistryEntry iORegistryEntry1 = iORegistryEntry.getChildEntry("IOService");
/* 78 */         if (iORegistryEntry1 != null) {
/*    */           
/* 80 */           CoreFoundation.CFTypeRef cFTypeRef = iORegistryEntry1.createCFProperty(cFStringRef);
/* 81 */           if (cFTypeRef != null) {
/* 82 */             CoreFoundation.CFDataRef cFDataRef = new CoreFoundation.CFDataRef(cFTypeRef.getPointer());
/*    */             
/* 84 */             int i = cFDataRef.getLength();
/* 85 */             Pointer pointer = cFDataRef.getBytePtr();
/* 86 */             arrayList.add(new MacDisplay(pointer.getByteArray(0L, i)));
/* 87 */             cFDataRef.release();
/*    */           } 
/* 89 */           iORegistryEntry1.release();
/*    */         } 
/*    */         
/* 92 */         iORegistryEntry.release();
/* 93 */         iORegistryEntry = iOIterator.next();
/*    */       } 
/* 95 */       iOIterator.release();
/* 96 */       cFStringRef.release();
/*    */     } 
/* 98 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacDisplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */