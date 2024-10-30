/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.NativeLong;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
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
/*     */ public interface WinGDI
/*     */ {
/*     */   public static final int RDH_RECTANGLES = 1;
/*     */   
/*     */   @FieldOrder({"dwSize", "iType", "nCount", "nRgnSize", "rcBound"})
/*     */   public static class RGNDATAHEADER
/*     */     extends Structure
/*     */   {
/*  45 */     public int dwSize = size();
/*  46 */     public int iType = 1;
/*     */     public int nCount;
/*     */     public int nRgnSize;
/*     */     public WinDef.RECT rcBound;
/*     */   }
/*     */   
/*     */   @FieldOrder({"rdh", "Buffer"})
/*     */   public static class RGNDATA extends Structure {
/*     */     public WinGDI.RGNDATAHEADER rdh;
/*     */     public byte[] Buffer;
/*     */     
/*     */     public RGNDATA() {
/*  58 */       this(1);
/*     */     }
/*     */     public RGNDATA(int param1Int) {
/*  61 */       this.Buffer = new byte[param1Int];
/*  62 */       allocateMemory();
/*     */     }
/*     */   }
/*     */   
/*  66 */   public static final WinNT.HANDLE HGDI_ERROR = new WinNT.HANDLE(Pointer.createConstant(-1));
/*     */   
/*     */   public static final int RGN_AND = 1;
/*     */   
/*     */   public static final int RGN_OR = 2;
/*     */   
/*     */   public static final int RGN_XOR = 3;
/*     */   
/*     */   public static final int RGN_DIFF = 4;
/*     */   
/*     */   public static final int RGN_COPY = 5;
/*     */   public static final int ERROR = 0;
/*     */   public static final int NULLREGION = 1;
/*     */   public static final int SIMPLEREGION = 2;
/*     */   public static final int COMPLEXREGION = 3;
/*     */   public static final int ALTERNATE = 1;
/*     */   public static final int WINDING = 2;
/*     */   public static final int BI_RGB = 0;
/*     */   public static final int BI_RLE8 = 1;
/*     */   public static final int BI_RLE4 = 2;
/*     */   public static final int BI_BITFIELDS = 3;
/*     */   public static final int BI_JPEG = 4;
/*     */   public static final int BI_PNG = 5;
/*     */   public static final int PFD_TYPE_RGBA = 0;
/*     */   public static final int PFD_TYPE_COLORINDEX = 1;
/*     */   public static final int PFD_MAIN_PLANE = 0;
/*     */   public static final int PFD_OVERLAY_PLANE = 1;
/*     */   public static final int PFD_UNDERLAY_PLANE = -1;
/*     */   public static final int PFD_DOUBLEBUFFER = 1;
/*     */   public static final int PFD_STEREO = 2;
/*     */   public static final int PFD_DRAW_TO_WINDOW = 4;
/*     */   public static final int PFD_DRAW_TO_BITMAP = 8;
/*     */   public static final int PFD_SUPPORT_GDI = 16;
/*     */   public static final int PFD_SUPPORT_OPENGL = 32;
/*     */   public static final int PFD_GENERIC_FORMAT = 64;
/*     */   public static final int PFD_NEED_PALETTE = 128;
/*     */   public static final int PFD_NEED_SYSTEM_PALETTE = 256;
/*     */   public static final int PFD_SWAP_EXCHANGE = 512;
/*     */   public static final int PFD_SWAP_COPY = 1024;
/*     */   public static final int PFD_SWAP_LAYER_BUFFERS = 2048;
/*     */   public static final int PFD_GENERIC_ACCELERATED = 4096;
/*     */   public static final int PFD_SUPPORT_DIRECTDRAW = 8192;
/*     */   public static final int DIB_RGB_COLORS = 0;
/*     */   public static final int DIB_PAL_COLORS = 1;
/*     */   
/*     */   @FieldOrder({"biSize", "biWidth", "biHeight", "biPlanes", "biBitCount", "biCompression", "biSizeImage", "biXPelsPerMeter", "biYPelsPerMeter", "biClrUsed", "biClrImportant"})
/*     */   public static class BITMAPINFOHEADER
/*     */     extends Structure
/*     */   {
/* 115 */     public int biSize = size();
/*     */     public int biWidth;
/*     */     public int biHeight;
/*     */     public short biPlanes;
/*     */     public short biBitCount;
/*     */     public int biCompression;
/*     */     public int biSizeImage;
/*     */     public int biXPelsPerMeter;
/*     */     public int biYPelsPerMeter;
/*     */     public int biClrUsed;
/*     */     public int biClrImportant;
/*     */   }
/*     */   
/*     */   @FieldOrder({"rgbBlue", "rgbGreen", "rgbRed", "rgbReserved"})
/*     */   public static class RGBQUAD extends Structure {
/*     */     public byte rgbBlue;
/*     */     public byte rgbGreen;
/*     */     public byte rgbRed;
/* 133 */     public byte rgbReserved = 0;
/*     */   }
/*     */   
/*     */   @FieldOrder({"bmiHeader", "bmiColors"})
/*     */   public static class BITMAPINFO
/*     */     extends Structure {
/* 139 */     public WinGDI.BITMAPINFOHEADER bmiHeader = new WinGDI.BITMAPINFOHEADER();
/* 140 */     public WinGDI.RGBQUAD[] bmiColors = new WinGDI.RGBQUAD[1];
/*     */     public BITMAPINFO() {
/* 142 */       this(1);
/*     */     }
/*     */     public BITMAPINFO(int param1Int) {
/* 145 */       this.bmiColors = new WinGDI.RGBQUAD[param1Int];
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"fIcon", "xHotspot", "yHotspot", "hbmMask", "hbmColor"})
/*     */   public static class ICONINFO extends Structure {
/*     */     public boolean fIcon;
/*     */     public int xHotspot;
/*     */     public int yHotspot;
/*     */     public WinDef.HBITMAP hbmMask;
/*     */     public WinDef.HBITMAP hbmColor;
/*     */   }
/*     */   
/*     */   @FieldOrder({"bmType", "bmWidth", "bmHeight", "bmWidthBytes", "bmPlanes", "bmBitsPixel", "bmBits"})
/*     */   public static class BITMAP extends Structure {
/*     */     public NativeLong bmType;
/*     */     public NativeLong bmWidth;
/*     */     public NativeLong bmHeight;
/*     */     public NativeLong bmWidthBytes;
/*     */     public short bmPlanes;
/*     */     public short bmBitsPixel;
/*     */     public Pointer bmBits;
/*     */   }
/*     */   
/*     */   @FieldOrder({"dsBm", "dsBmih", "dsBitfields", "dshSection", "dsOffset"})
/*     */   public static class DIBSECTION extends Structure {
/*     */     public WinGDI.BITMAP dsBm;
/*     */     public WinGDI.BITMAPINFOHEADER dsBmih;
/* 173 */     public int[] dsBitfields = new int[3]; public WinNT.HANDLE dshSection; public int dsOffset; }
/*     */   @FieldOrder({"nSize", "nVersion", "dwFlags", "iPixelType", "cColorBits", "cRedBits", "cRedShift", "cGreenBits", "cGreenShift", "cBlueBits", "cBlueShift", "cAlphaBits", "cAlphaShift", "cAccumBits", "cAccumRedBits", "cAccumGreenBits", "cAccumBlueBits", "cAccumAlphaBits", "cDepthBits", "cStencilBits", "cAuxBuffers", "iLayerType", "bReserved", "dwLayerMask", "dwVisibleMask", "dwDamageMask"})
/*     */   public static class PIXELFORMATDESCRIPTOR extends Structure { public short nSize;
/*     */     public short nVersion;
/*     */     public int dwFlags;
/*     */     public byte iPixelType;
/*     */     public byte cColorBits;
/*     */     public byte cRedBits;
/*     */     public byte cRedShift;
/*     */     public byte cGreenBits;
/*     */     public byte cGreenShift;
/*     */     public byte cBlueBits;
/*     */     public byte cBlueShift;
/*     */     public byte cAlphaBits;
/*     */     public byte cAlphaShift;
/*     */     
/*     */     public PIXELFORMATDESCRIPTOR() {
/* 190 */       this.nSize = (short)size();
/*     */     }
/*     */     public byte cAccumBits; public byte cAccumRedBits; public byte cAccumGreenBits; public byte cAccumBlueBits; public byte cAccumAlphaBits; public byte cDepthBits; public byte cStencilBits; public byte cAuxBuffers; public byte iLayerType; public byte bReserved; public int dwLayerMask; public int dwVisibleMask; public int dwDamageMask;
/*     */     public PIXELFORMATDESCRIPTOR(Pointer param1Pointer) {
/* 194 */       super(param1Pointer);
/* 195 */       read();
/*     */     }
/*     */     
/*     */     public static class ByReference extends PIXELFORMATDESCRIPTOR implements Structure.ByReference {} }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinGDI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */