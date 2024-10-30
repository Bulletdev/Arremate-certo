/*    */ package oshi.driver.windows;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.DesktopWindow;
/*    */ import com.sun.jna.platform.WindowUtils;
/*    */ import com.sun.jna.platform.win32.User32;
/*    */ import com.sun.jna.platform.win32.WinDef;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.software.os.OSDesktopWindow;
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
/*    */ public final class EnumWindows
/*    */ {
/* 48 */   private static final WinDef.DWORD GW_HWNDNEXT = new WinDef.DWORD(2L);
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
/*    */   public static List<OSDesktopWindow> queryDesktopWindows(boolean paramBoolean) {
/* 63 */     List list = WindowUtils.getAllWindows(true);
/*    */     
/* 65 */     ArrayList<OSDesktopWindow> arrayList = new ArrayList();
/*    */     
/* 67 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 68 */     for (DesktopWindow desktopWindow : list) {
/* 69 */       WinDef.HWND hWND = desktopWindow.getHWND();
/* 70 */       if (hWND != null) {
/* 71 */         boolean bool = User32.INSTANCE.IsWindowVisible(hWND);
/* 72 */         if (!paramBoolean || bool) {
/* 73 */           if (!hashMap.containsKey(hWND)) {
/* 74 */             updateWindowZOrderMap(hWND, (Map)hashMap);
/*    */           }
/* 76 */           IntByReference intByReference = new IntByReference();
/* 77 */           User32.INSTANCE.GetWindowThreadProcessId(hWND, intByReference);
/* 78 */           arrayList.add(new OSDesktopWindow(Pointer.nativeValue(hWND.getPointer()), desktopWindow.getTitle(), desktopWindow
/* 79 */                 .getFilePath(), desktopWindow.getLocAndSize(), intByReference.getValue(), ((Integer)hashMap.get(hWND)).intValue(), bool));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 84 */     return arrayList;
/*    */   }
/*    */   
/*    */   private static void updateWindowZOrderMap(WinDef.HWND paramHWND, Map<WinDef.HWND, Integer> paramMap) {
/* 88 */     if (paramHWND != null) {
/* 89 */       byte b = 1;
/* 90 */       WinDef.HWND hWND = new WinDef.HWND(paramHWND.getPointer());
/*    */       
/*    */       do {
/* 93 */         paramMap.put(hWND, Integer.valueOf(--b));
/* 94 */       } while ((hWND = User32.INSTANCE.GetWindow(hWND, GW_HWNDNEXT)) != null);
/*    */       
/* 96 */       int i = b * -1;
/* 97 */       paramMap.replaceAll((paramHWND, paramInteger) -> Integer.valueOf(paramInteger.intValue() + paramInt));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\EnumWindows.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */