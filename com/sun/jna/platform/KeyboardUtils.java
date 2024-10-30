/*     */ package com.sun.jna.platform;
/*     */ 
/*     */ import com.sun.jna.Platform;
/*     */ import com.sun.jna.platform.unix.X11;
/*     */ import com.sun.jna.platform.win32.User32;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.HeadlessException;
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
/*     */ public class KeyboardUtils
/*     */ {
/*     */   static final NativeKeyboardUtils INSTANCE;
/*     */   
/*     */   static {
/*  48 */     if (GraphicsEnvironment.isHeadless()) {
/*  49 */       throw new HeadlessException("KeyboardUtils requires a keyboard");
/*     */     }
/*  51 */     if (Platform.isWindows()) {
/*  52 */       INSTANCE = new W32KeyboardUtils();
/*     */     } else {
/*  54 */       if (Platform.isMac()) {
/*  55 */         INSTANCE = new MacKeyboardUtils();
/*  56 */         throw new UnsupportedOperationException("No support (yet) for " + 
/*  57 */             System.getProperty("os.name"));
/*     */       } 
/*     */       
/*  60 */       INSTANCE = new X11KeyboardUtils();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean isPressed(int paramInt1, int paramInt2) {
/*  65 */     return INSTANCE.isPressed(paramInt1, paramInt2);
/*     */   }
/*     */   public static boolean isPressed(int paramInt) {
/*  68 */     return INSTANCE.isPressed(paramInt);
/*     */   }
/*     */   
/*     */   private static abstract class NativeKeyboardUtils { private NativeKeyboardUtils() {}
/*     */     
/*     */     public boolean isPressed(int param1Int) {
/*  74 */       return isPressed(param1Int, 0);
/*     */     }
/*     */     
/*     */     public abstract boolean isPressed(int param1Int1, int param1Int2); }
/*     */   
/*     */   private static class W32KeyboardUtils extends NativeKeyboardUtils { private int toNative(int param1Int1, int param1Int2) {
/*  80 */       if ((param1Int1 >= 65 && param1Int1 <= 90) || (param1Int1 >= 48 && param1Int1 <= 57))
/*     */       {
/*  82 */         return param1Int1;
/*     */       }
/*  84 */       if (param1Int1 == 16) {
/*  85 */         if ((param1Int2 & 0x3) != 0) {
/*  86 */           return 161;
/*     */         }
/*  88 */         if ((param1Int2 & 0x2) != 0) {
/*  89 */           return 160;
/*     */         }
/*  91 */         return 16;
/*     */       } 
/*  93 */       if (param1Int1 == 17) {
/*  94 */         if ((param1Int2 & 0x3) != 0) {
/*  95 */           return 163;
/*     */         }
/*  97 */         if ((param1Int2 & 0x2) != 0) {
/*  98 */           return 162;
/*     */         }
/* 100 */         return 17;
/*     */       } 
/* 102 */       if (param1Int1 == 18) {
/* 103 */         if ((param1Int2 & 0x3) != 0) {
/* 104 */           return 165;
/*     */         }
/* 106 */         if ((param1Int2 & 0x2) != 0) {
/* 107 */           return 164;
/*     */         }
/* 109 */         return 18;
/*     */       } 
/* 111 */       return 0;
/*     */     } private W32KeyboardUtils() {}
/*     */     public boolean isPressed(int param1Int1, int param1Int2) {
/* 114 */       User32 user32 = User32.INSTANCE;
/* 115 */       return ((user32.GetAsyncKeyState(toNative(param1Int1, param1Int2)) & 0x8000) != 0);
/*     */     } }
/*     */   private static class MacKeyboardUtils extends NativeKeyboardUtils { private MacKeyboardUtils() {}
/*     */     
/*     */     public boolean isPressed(int param1Int1, int param1Int2) {
/* 120 */       return false;
/*     */     } }
/*     */   
/*     */   private static class X11KeyboardUtils extends NativeKeyboardUtils {
/*     */     private X11KeyboardUtils() {}
/*     */     
/*     */     private int toKeySym(int param1Int1, int param1Int2) {
/* 127 */       if (param1Int1 >= 65 && param1Int1 <= 90)
/* 128 */         return 97 + param1Int1 - 65; 
/* 129 */       if (param1Int1 >= 48 && param1Int1 <= 57)
/* 130 */         return 48 + param1Int1 - 48; 
/* 131 */       if (param1Int1 == 16) {
/* 132 */         if ((param1Int2 & 0x3) != 0)
/* 133 */           return 65505; 
/* 134 */         return 65505;
/*     */       } 
/* 136 */       if (param1Int1 == 17) {
/* 137 */         if ((param1Int2 & 0x3) != 0)
/* 138 */           return 65508; 
/* 139 */         return 65507;
/*     */       } 
/* 141 */       if (param1Int1 == 18) {
/* 142 */         if ((param1Int2 & 0x3) != 0)
/* 143 */           return 65514; 
/* 144 */         return 65513;
/*     */       } 
/* 146 */       if (param1Int1 == 157) {
/* 147 */         if ((param1Int2 & 0x3) != 0)
/* 148 */           return 65512; 
/* 149 */         return 65511;
/*     */       } 
/* 151 */       return 0;
/*     */     }
/*     */     public boolean isPressed(int param1Int1, int param1Int2) {
/* 154 */       X11 x11 = X11.INSTANCE;
/* 155 */       X11.Display display = x11.XOpenDisplay(null);
/* 156 */       if (display == null) {
/* 157 */         throw new Error("Can't open X Display");
/*     */       }
/*     */       try {
/* 160 */         byte[] arrayOfByte = new byte[32];
/*     */         
/* 162 */         x11.XQueryKeymap(display, arrayOfByte);
/* 163 */         int i = toKeySym(param1Int1, param1Int2);
/* 164 */         for (byte b = 5; b < 'Ā'; b++) {
/* 165 */           int j = b / 8;
/* 166 */           int k = b % 8;
/* 167 */           if ((arrayOfByte[j] & 1 << k) != 0) {
/* 168 */             int m = x11.XKeycodeToKeysym(display, (byte)b, 0).intValue();
/* 169 */             if (m == i) {
/* 170 */               return true;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } finally {
/* 175 */         x11.XCloseDisplay(display);
/*     */       } 
/* 177 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\KeyboardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */