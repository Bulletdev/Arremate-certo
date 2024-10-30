/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DataBufferInt;
/*     */ import java.awt.image.DirectColorModel;
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.WritableRaster;
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
/*     */ public class GDI32Util
/*     */ {
/*  55 */   private static final DirectColorModel SCREENSHOT_COLOR_MODEL = new DirectColorModel(24, 16711680, 65280, 255);
/*  56 */   private static final int[] SCREENSHOT_BAND_MASKS = new int[] { SCREENSHOT_COLOR_MODEL
/*  57 */       .getRedMask(), SCREENSHOT_COLOR_MODEL
/*  58 */       .getGreenMask(), SCREENSHOT_COLOR_MODEL
/*  59 */       .getBlueMask() };
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
/*     */   public static BufferedImage getScreenshot(WinDef.HWND paramHWND) {
/*     */     Win32Exception win32Exception;
/*  76 */     WinDef.RECT rECT = new WinDef.RECT();
/*  77 */     if (!User32.INSTANCE.GetWindowRect(paramHWND, rECT)) {
/*  78 */       throw new Win32Exception(Native.getLastError());
/*     */     }
/*  80 */     Rectangle rectangle = rECT.toRectangle();
/*  81 */     int i = rectangle.width;
/*  82 */     int j = rectangle.height;
/*     */     
/*  84 */     if (i == 0 || j == 0) {
/*  85 */       throw new IllegalStateException("Window width and/or height were 0 even though GetWindowRect did not appear to fail.");
/*     */     }
/*     */     
/*  88 */     WinDef.HDC hDC1 = User32.INSTANCE.GetDC(paramHWND);
/*  89 */     if (hDC1 == null) {
/*  90 */       throw new Win32Exception(Native.getLastError());
/*     */     }
/*     */     
/*  93 */     Throwable throwable = null;
/*     */ 
/*     */     
/*  96 */     WinDef.HDC hDC2 = null;
/*     */ 
/*     */     
/*  99 */     WinDef.HBITMAP hBITMAP = null;
/*     */ 
/*     */     
/* 102 */     WinNT.HANDLE hANDLE = null;
/*     */ 
/*     */     
/* 105 */     BufferedImage bufferedImage = null;
/*     */     
/*     */     try {
/* 108 */       hDC2 = GDI32.INSTANCE.CreateCompatibleDC(hDC1);
/* 109 */       if (hDC2 == null) {
/* 110 */         throw new Win32Exception(Native.getLastError());
/*     */       }
/*     */       
/* 113 */       hBITMAP = GDI32.INSTANCE.CreateCompatibleBitmap(hDC1, i, j);
/* 114 */       if (hBITMAP == null) {
/* 115 */         throw new Win32Exception(Native.getLastError());
/*     */       }
/*     */       
/* 118 */       hANDLE = GDI32.INSTANCE.SelectObject(hDC2, hBITMAP);
/* 119 */       if (hANDLE == null) {
/* 120 */         throw new Win32Exception(Native.getLastError());
/*     */       }
/*     */ 
/*     */       
/* 124 */       if (!GDI32.INSTANCE.BitBlt(hDC2, 0, 0, i, j, hDC1, 0, 0, 13369376)) {
/* 125 */         throw new Win32Exception(Native.getLastError());
/*     */       }
/*     */       
/* 128 */       WinGDI.BITMAPINFO bITMAPINFO = new WinGDI.BITMAPINFO();
/* 129 */       bITMAPINFO.bmiHeader.biWidth = i;
/* 130 */       bITMAPINFO.bmiHeader.biHeight = -j;
/* 131 */       bITMAPINFO.bmiHeader.biPlanes = 1;
/* 132 */       bITMAPINFO.bmiHeader.biBitCount = 32;
/* 133 */       bITMAPINFO.bmiHeader.biCompression = 0;
/*     */       
/* 135 */       Memory memory = new Memory((i * j * 4));
/* 136 */       int k = GDI32.INSTANCE.GetDIBits(hDC1, hBITMAP, 0, j, (Pointer)memory, bITMAPINFO, 0);
/*     */       
/* 138 */       if (k == 0 || k == 87) {
/* 139 */         throw new Win32Exception(Native.getLastError());
/*     */       }
/*     */       
/* 142 */       int m = i * j;
/* 143 */       DataBufferInt dataBufferInt = new DataBufferInt(memory.getIntArray(0L, m), m);
/* 144 */       WritableRaster writableRaster = Raster.createPackedRaster(dataBufferInt, i, j, i, SCREENSHOT_BAND_MASKS, (Point)null);
/*     */       
/* 146 */       bufferedImage = new BufferedImage(SCREENSHOT_COLOR_MODEL, writableRaster, false, null);
/*     */     }
/* 148 */     catch (Win32Exception win32Exception1) {
/* 149 */       win32Exception = win32Exception1;
/*     */     } finally {
/* 151 */       if (hANDLE != null) {
/*     */         
/* 153 */         WinNT.HANDLE hANDLE1 = GDI32.INSTANCE.SelectObject(hDC2, hANDLE);
/*     */         
/* 155 */         if (hANDLE1 == null || WinGDI.HGDI_ERROR.equals(hANDLE1)) {
/* 156 */           Win32Exception win32Exception1 = new Win32Exception(Native.getLastError());
/* 157 */           if (win32Exception != null) {
/* 158 */             win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/*     */           }
/* 160 */           win32Exception = win32Exception1;
/*     */         } 
/*     */       } 
/*     */       
/* 164 */       if (hBITMAP != null && 
/* 165 */         !GDI32.INSTANCE.DeleteObject(hBITMAP)) {
/* 166 */         Win32Exception win32Exception1 = new Win32Exception(Native.getLastError());
/* 167 */         if (win32Exception != null) {
/* 168 */           win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/*     */         }
/* 170 */         win32Exception = win32Exception1;
/*     */       } 
/*     */ 
/*     */       
/* 174 */       if (hDC2 != null)
/*     */       {
/* 176 */         if (!GDI32.INSTANCE.DeleteDC(hDC2)) {
/* 177 */           Win32Exception win32Exception1 = new Win32Exception(Native.getLastError());
/* 178 */           if (win32Exception != null) {
/* 179 */             win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/*     */           }
/* 181 */           win32Exception = win32Exception1;
/*     */         } 
/*     */       }
/*     */       
/* 185 */       if (hDC1 != null && 
/* 186 */         0 == User32.INSTANCE.ReleaseDC(paramHWND, hDC1)) {
/* 187 */         throw new IllegalStateException("Device context did not release properly.");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 192 */     if (win32Exception != null) {
/* 193 */       throw win32Exception;
/*     */     }
/* 195 */     return bufferedImage;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\GDI32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */