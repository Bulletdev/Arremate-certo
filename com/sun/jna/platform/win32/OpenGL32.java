/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.win32.StdCallLibrary;
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
/*    */ public interface OpenGL32
/*    */   extends StdCallLibrary
/*    */ {
/* 35 */   public static final OpenGL32 INSTANCE = (OpenGL32)Native.load("opengl32", OpenGL32.class);
/*    */   
/*    */   String glGetString(int paramInt);
/*    */   
/*    */   WinDef.HGLRC wglCreateContext(WinDef.HDC paramHDC);
/*    */   
/*    */   WinDef.HGLRC wglGetCurrentContext();
/*    */   
/*    */   boolean wglMakeCurrent(WinDef.HDC paramHDC, WinDef.HGLRC paramHGLRC);
/*    */   
/*    */   boolean wglDeleteContext(WinDef.HGLRC paramHGLRC);
/*    */   
/*    */   Pointer wglGetProcAddress(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\OpenGL32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */