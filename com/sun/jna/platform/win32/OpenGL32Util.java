/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Function;
/*    */ import com.sun.jna.Pointer;
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
/*    */ public abstract class OpenGL32Util
/*    */ {
/*    */   public static Function wglGetProcAddress(String paramString) {
/* 44 */     Pointer pointer = OpenGL32.INSTANCE.wglGetProcAddress("wglEnumGpusNV");
/* 45 */     return (pointer == null) ? null : Function.getFunction(pointer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int countGpusNV() {
/* 54 */     WinDef.HWND hWND = User32Util.createWindow("Message", null, 0, 0, 0, 0, 0, null, null, null, null);
/* 55 */     WinDef.HDC hDC = User32.INSTANCE.GetDC(hWND);
/*    */ 
/*    */     
/* 58 */     WinGDI.PIXELFORMATDESCRIPTOR.ByReference byReference = new WinGDI.PIXELFORMATDESCRIPTOR.ByReference();
/* 59 */     byReference.nVersion = 1;
/* 60 */     byReference.dwFlags = 37;
/* 61 */     byReference.iPixelType = 0;
/* 62 */     byReference.cColorBits = 24;
/* 63 */     byReference.cDepthBits = 16;
/* 64 */     byReference.iLayerType = 0;
/* 65 */     GDI32.INSTANCE.SetPixelFormat(hDC, GDI32.INSTANCE.ChoosePixelFormat(hDC, byReference), byReference);
/*    */ 
/*    */     
/* 68 */     WinDef.HGLRC hGLRC = OpenGL32.INSTANCE.wglCreateContext(hDC);
/* 69 */     OpenGL32.INSTANCE.wglMakeCurrent(hDC, hGLRC);
/* 70 */     Pointer pointer = OpenGL32.INSTANCE.wglGetProcAddress("wglEnumGpusNV");
/* 71 */     Function function = (pointer == null) ? null : Function.getFunction(pointer);
/* 72 */     OpenGL32.INSTANCE.wglDeleteContext(hGLRC);
/*    */ 
/*    */     
/* 75 */     User32.INSTANCE.ReleaseDC(hWND, hDC);
/* 76 */     User32Util.destroyWindow(hWND);
/*    */ 
/*    */     
/* 79 */     if (function == null) return 0;
/*    */ 
/*    */     
/* 82 */     WinDef.HGLRCByReference hGLRCByReference = new WinDef.HGLRCByReference();
/* 83 */     for (byte b = 0; b < 16; b++) {
/* 84 */       Boolean bool = (Boolean)function.invoke(Boolean.class, new Object[] { Integer.valueOf(b), hGLRCByReference });
/* 85 */       if (!bool.booleanValue()) return b;
/*    */     
/*    */     } 
/* 88 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\OpenGL32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */