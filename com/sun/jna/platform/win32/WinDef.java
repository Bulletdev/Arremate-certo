/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.IntegerType;
/*      */ import com.sun.jna.Native;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.PointerType;
/*      */ import com.sun.jna.Structure;
/*      */ import com.sun.jna.Structure.FieldOrder;
/*      */ import java.awt.Rectangle;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface WinDef
/*      */ {
/*      */   public static final int MAX_PATH = 260;
/*      */   
/*      */   public static class WORD
/*      */     extends IntegerType
/*      */     implements Comparable<WORD>
/*      */   {
/*      */     public static final int SIZE = 2;
/*      */     
/*      */     public WORD() {
/*   62 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WORD(long param1Long) {
/*   72 */       super(2, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(WORD param1WORD) {
/*   77 */       return compare(this, param1WORD);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class WORDByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public WORDByReference() {
/*   90 */       this(new WinDef.WORD(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WORDByReference(WinDef.WORD param1WORD) {
/*   99 */       super(2);
/*  100 */       setValue(param1WORD);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.WORD param1WORD) {
/*  109 */       getPointer().setShort(0L, param1WORD.shortValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.WORD getValue() {
/*  118 */       return new WinDef.WORD(getPointer().getShort(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class DWORD
/*      */     extends IntegerType
/*      */     implements Comparable<DWORD>
/*      */   {
/*      */     public static final int SIZE = 4;
/*      */ 
/*      */ 
/*      */     
/*      */     public DWORD() {
/*  134 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DWORD(long param1Long) {
/*  144 */       super(4, param1Long, true);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.WORD getLow() {
/*  153 */       return new WinDef.WORD(longValue() & 0xFFFFL);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.WORD getHigh() {
/*  162 */       return new WinDef.WORD(longValue() >> 16L & 0xFFFFL);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(DWORD param1DWORD) {
/*  167 */       return compare(this, param1DWORD);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class DWORDByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public DWORDByReference() {
/*  180 */       this(new WinDef.DWORD(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DWORDByReference(WinDef.DWORD param1DWORD) {
/*  189 */       super(4);
/*  190 */       setValue(param1DWORD);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.DWORD param1DWORD) {
/*  199 */       getPointer().setInt(0L, param1DWORD.intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.DWORD getValue() {
/*  208 */       return new WinDef.DWORD(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LONG
/*      */     extends IntegerType
/*      */     implements Comparable<LONG>
/*      */   {
/*  218 */     public static final int SIZE = Native.LONG_SIZE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LONG() {
/*  224 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LONG(long param1Long) {
/*  233 */       super(SIZE, param1Long);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(LONG param1LONG) {
/*  238 */       return compare(this, param1LONG);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LONGByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public LONGByReference() {
/*  251 */       this(new WinDef.LONG(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LONGByReference(WinDef.LONG param1LONG) {
/*  260 */       super(WinDef.LONG.SIZE);
/*  261 */       setValue(param1LONG);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.LONG param1LONG) {
/*  270 */       getPointer().setInt(0L, param1LONG.intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.LONG getValue() {
/*  279 */       return new WinDef.LONG(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LONGLONG
/*      */     extends IntegerType
/*      */     implements Comparable<LONGLONG>
/*      */   {
/*  289 */     public static final int SIZE = Native.LONG_SIZE * 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LONGLONG() {
/*  295 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LONGLONG(long param1Long) {
/*  304 */       super(8, param1Long, false);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(LONGLONG param1LONGLONG) {
/*  309 */       return compare(this, param1LONGLONG);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LONGLONGByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public LONGLONGByReference() {
/*  322 */       this(new WinDef.LONGLONG(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LONGLONGByReference(WinDef.LONGLONG param1LONGLONG) {
/*  331 */       super(WinDef.LONGLONG.SIZE);
/*  332 */       setValue(param1LONGLONG);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.LONGLONG param1LONGLONG) {
/*  341 */       getPointer().setLong(0L, param1LONGLONG.longValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.LONGLONG getValue() {
/*  350 */       return new WinDef.LONGLONG(getPointer().getLong(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HDC
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HDC() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HDC(Pointer param1Pointer) {
/*  373 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HICON
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HICON() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HICON(WinNT.HANDLE param1HANDLE) {
/*  398 */       this(param1HANDLE.getPointer());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HICON(Pointer param1Pointer) {
/*  408 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HCURSOR
/*      */     extends HICON
/*      */   {
/*      */     public HCURSOR() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HCURSOR(Pointer param1Pointer) {
/*  431 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HMENU
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HMENU() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HMENU(Pointer param1Pointer) {
/*  454 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HPEN
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HPEN() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HPEN(Pointer param1Pointer) {
/*  477 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HRSRC
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HRSRC() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HRSRC(Pointer param1Pointer) {
/*  500 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HPALETTE
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HPALETTE() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HPALETTE(Pointer param1Pointer) {
/*  523 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HBITMAP
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HBITMAP() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HBITMAP(Pointer param1Pointer) {
/*  546 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HRGN
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HRGN() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HRGN(Pointer param1Pointer) {
/*  569 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HWND
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HWND() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HWND(Pointer param1Pointer) {
/*  592 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HINSTANCE
/*      */     extends WinNT.HANDLE {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HMODULE
/*      */     extends HINSTANCE {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HFONT
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HFONT() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HFONT(Pointer param1Pointer) {
/*  629 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HKL
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HKL() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HKL(Pointer param1Pointer) {
/*  652 */       super(param1Pointer);
/*      */     }
/*      */     
/*      */     public HKL(int param1Int) {
/*  656 */       super(Pointer.createConstant(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLanguageIdentifier() {
/*  663 */       return (int)(Pointer.nativeValue(getPointer()) & 0xFFFFL);
/*      */     }
/*      */     
/*      */     public int getDeviceHandle() {
/*  667 */       return (int)(Pointer.nativeValue(getPointer()) >> 16L & 0xFFFFL);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  672 */       return String.format("%08x", new Object[] { Long.valueOf(Pointer.nativeValue(getPointer())) });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LPARAM
/*      */     extends BaseTSD.LONG_PTR
/*      */   {
/*      */     public LPARAM() {
/*  685 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LPARAM(long param1Long) {
/*  695 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LRESULT
/*      */     extends BaseTSD.LONG_PTR
/*      */   {
/*      */     public LRESULT() {
/*  708 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LRESULT(long param1Long) {
/*  718 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class INT_PTR
/*      */     extends IntegerType
/*      */   {
/*      */     public INT_PTR() {
/*  729 */       super(Native.POINTER_SIZE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public INT_PTR(long param1Long) {
/*  739 */       super(Native.POINTER_SIZE, param1Long);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer toPointer() {
/*  748 */       return Pointer.createConstant(longValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class UINT_PTR
/*      */     extends IntegerType
/*      */   {
/*      */     public UINT_PTR() {
/*  761 */       super(Native.POINTER_SIZE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UINT_PTR(long param1Long) {
/*  771 */       super(Native.POINTER_SIZE, param1Long, true);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pointer toPointer() {
/*  780 */       return Pointer.createConstant(longValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class WPARAM
/*      */     extends UINT_PTR
/*      */   {
/*      */     public WPARAM() {
/*  793 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WPARAM(long param1Long) {
/*  803 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"left", "top", "right", "bottom"})
/*      */   public static class RECT
/*      */     extends Structure
/*      */   {
/*      */     public int left;
/*      */ 
/*      */ 
/*      */     
/*      */     public int top;
/*      */ 
/*      */ 
/*      */     
/*      */     public int right;
/*      */ 
/*      */     
/*      */     public int bottom;
/*      */ 
/*      */ 
/*      */     
/*      */     public Rectangle toRectangle() {
/*  830 */       return new Rectangle(this.left, this.top, this.right - this.left, this.bottom - this.top);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  835 */       return "[(" + this.left + "," + this.top + ")(" + this.right + "," + this.bottom + ")]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ULONG
/*      */     extends IntegerType
/*      */     implements Comparable<ULONG>
/*      */   {
/*  845 */     public static final int SIZE = Native.LONG_SIZE;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ULONG() {
/*  851 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ULONG(long param1Long) {
/*  861 */       super(SIZE, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(ULONG param1ULONG) {
/*  866 */       return compare(this, param1ULONG);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ULONGByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public ULONGByReference() {
/*  879 */       this(new WinDef.ULONG(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ULONGByReference(WinDef.ULONG param1ULONG) {
/*  888 */       super(WinDef.ULONG.SIZE);
/*  889 */       setValue(param1ULONG);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.ULONG param1ULONG) {
/*  898 */       getPointer().setInt(0L, param1ULONG.intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.ULONG getValue() {
/*  907 */       return new WinDef.ULONG(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ULONGLONG
/*      */     extends IntegerType
/*      */     implements Comparable<ULONGLONG>
/*      */   {
/*      */     public static final int SIZE = 8;
/*      */ 
/*      */ 
/*      */     
/*      */     public ULONGLONG() {
/*  923 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ULONGLONG(long param1Long) {
/*  932 */       super(8, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(ULONGLONG param1ULONGLONG) {
/*  937 */       return compare(this, param1ULONGLONG);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ULONGLONGByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public ULONGLONGByReference() {
/*  950 */       this(new WinDef.ULONGLONG(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ULONGLONGByReference(WinDef.ULONGLONG param1ULONGLONG) {
/*  959 */       super(8);
/*  960 */       setValue(param1ULONGLONG);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.ULONGLONG param1ULONGLONG) {
/*  969 */       getPointer().setLong(0L, param1ULONGLONG.longValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.ULONGLONG getValue() {
/*  978 */       return new WinDef.ULONGLONG(getPointer().getLong(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class DWORDLONG
/*      */     extends IntegerType
/*      */     implements Comparable<DWORDLONG>
/*      */   {
/*      */     public static final int SIZE = 8;
/*      */ 
/*      */ 
/*      */     
/*      */     public DWORDLONG() {
/*  994 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DWORDLONG(long param1Long) {
/* 1004 */       super(8, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(DWORDLONG param1DWORDLONG) {
/* 1009 */       return compare(this, param1DWORDLONG);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HBRUSH
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HBRUSH() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HBRUSH(Pointer param1Pointer) {
/* 1032 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ATOM
/*      */     extends WORD
/*      */   {
/*      */     public ATOM() {
/* 1045 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ATOM(long param1Long) {
/* 1055 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class PVOID
/*      */     extends PointerType
/*      */   {
/*      */     public PVOID() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PVOID(Pointer param1Pointer) {
/* 1074 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LPVOID
/*      */     extends PointerType
/*      */   {
/*      */     public LPVOID() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LPVOID(Pointer param1Pointer) {
/* 1095 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @FieldOrder({"x", "y"})
/*      */   public static class POINT
/*      */     extends Structure
/*      */   {
/*      */     public int x;
/*      */     public int y;
/*      */     
/*      */     public static class ByReference
/*      */       extends POINT
/*      */       implements Structure.ByReference
/*      */     {
/*      */       public ByReference() {}
/*      */       
/*      */       public ByReference(Pointer param2Pointer) {
/* 1114 */         super(param2Pointer);
/*      */       }
/*      */       
/*      */       public ByReference(int param2Int1, int param2Int2) {
/* 1118 */         super(param2Int1, param2Int2);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByValue
/*      */       extends POINT
/*      */       implements Structure.ByValue
/*      */     {
/*      */       public ByValue() {}
/*      */ 
/*      */       
/*      */       public ByValue(Pointer param2Pointer) {
/* 1132 */         super(param2Pointer);
/*      */       }
/*      */       
/*      */       public ByValue(int param2Int1, int param2Int2) {
/* 1136 */         super(param2Int1, param2Int2);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public POINT() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public POINT(Pointer param1Pointer) {
/* 1159 */       super(param1Pointer);
/* 1160 */       read();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public POINT(int param1Int1, int param1Int2) {
/* 1172 */       this.x = param1Int1;
/* 1173 */       this.y = param1Int2;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class USHORT
/*      */     extends IntegerType
/*      */     implements Comparable<USHORT>
/*      */   {
/*      */     public static final int SIZE = 2;
/*      */ 
/*      */ 
/*      */     
/*      */     public USHORT() {
/* 1189 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public USHORT(long param1Long) {
/* 1199 */       super(2, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(USHORT param1USHORT) {
/* 1204 */       return compare(this, param1USHORT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class USHORTByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public USHORTByReference() {
/* 1217 */       this(new WinDef.USHORT(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public USHORTByReference(WinDef.USHORT param1USHORT) {
/* 1226 */       super(2);
/* 1227 */       setValue(param1USHORT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public USHORTByReference(short param1Short) {
/* 1236 */       super(2);
/* 1237 */       setValue(new WinDef.USHORT(param1Short));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.USHORT param1USHORT) {
/* 1246 */       getPointer().setShort(0L, param1USHORT.shortValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.USHORT getValue() {
/* 1255 */       return new WinDef.USHORT(getPointer().getShort(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SHORT
/*      */     extends IntegerType
/*      */     implements Comparable<SHORT>
/*      */   {
/*      */     public static final int SIZE = 2;
/*      */ 
/*      */ 
/*      */     
/*      */     public SHORT() {
/* 1271 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SHORT(long param1Long) {
/* 1281 */       super(2, param1Long, false);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(SHORT param1SHORT) {
/* 1286 */       return compare(this, param1SHORT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class UINT
/*      */     extends IntegerType
/*      */     implements Comparable<UINT>
/*      */   {
/*      */     public static final int SIZE = 4;
/*      */ 
/*      */ 
/*      */     
/*      */     public UINT() {
/* 1302 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UINT(long param1Long) {
/* 1312 */       super(4, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(UINT param1UINT) {
/* 1317 */       return compare(this, param1UINT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class UINTByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public UINTByReference() {
/* 1330 */       this(new WinDef.UINT(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UINTByReference(WinDef.UINT param1UINT) {
/* 1339 */       super(4);
/* 1340 */       setValue(param1UINT);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.UINT param1UINT) {
/* 1349 */       getPointer().setInt(0L, param1UINT.intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.UINT getValue() {
/* 1358 */       return new WinDef.UINT(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SCODE
/*      */     extends ULONG
/*      */   {
/*      */     public SCODE() {
/* 1371 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SCODE(long param1Long) {
/* 1381 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SCODEByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public SCODEByReference() {
/* 1394 */       this(new WinDef.SCODE(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SCODEByReference(WinDef.SCODE param1SCODE) {
/* 1403 */       super(WinDef.SCODE.SIZE);
/* 1404 */       setValue(param1SCODE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.SCODE param1SCODE) {
/* 1413 */       getPointer().setInt(0L, param1SCODE.intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.SCODE getValue() {
/* 1422 */       return new WinDef.SCODE(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LCID
/*      */     extends DWORD
/*      */   {
/*      */     public LCID() {
/* 1435 */       super(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LCID(long param1Long) {
/* 1444 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class BOOL
/*      */     extends IntegerType
/*      */     implements Comparable<BOOL>
/*      */   {
/*      */     public static final int SIZE = 4;
/*      */ 
/*      */ 
/*      */     
/*      */     public BOOL() {
/* 1460 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public BOOL(boolean param1Boolean) {
/* 1469 */       this(param1Boolean ? 1L : 0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public BOOL(long param1Long) {
/* 1478 */       super(4, param1Long, false);
/* 1479 */       assert param1Long == 0L || param1Long == 1L;
/*      */     }
/*      */     
/*      */     public boolean booleanValue() {
/* 1483 */       if (intValue() > 0) {
/* 1484 */         return true;
/*      */       }
/* 1486 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1492 */       return Boolean.toString(booleanValue());
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(BOOL param1BOOL) {
/* 1497 */       return compare(this, param1BOOL);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static int compare(BOOL param1BOOL1, BOOL param1BOOL2) {
/* 1514 */       if (param1BOOL1 == param1BOOL2)
/* 1515 */         return 0; 
/* 1516 */       if (param1BOOL1 == null)
/* 1517 */         return 1; 
/* 1518 */       if (param1BOOL2 == null) {
/* 1519 */         return -1;
/*      */       }
/* 1521 */       return compare(param1BOOL1.booleanValue(), param1BOOL2.booleanValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static int compare(BOOL param1BOOL, boolean param1Boolean) {
/* 1537 */       if (param1BOOL == null) {
/* 1538 */         return 1;
/*      */       }
/* 1540 */       return compare(param1BOOL.booleanValue(), param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static int compare(boolean param1Boolean1, boolean param1Boolean2) {
/* 1546 */       if (param1Boolean1 == param1Boolean2)
/* 1547 */         return 0; 
/* 1548 */       if (param1Boolean1) {
/* 1549 */         return 1;
/*      */       }
/* 1551 */       return -1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class BOOLByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public BOOLByReference() {
/* 1565 */       this(new WinDef.BOOL(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public BOOLByReference(WinDef.BOOL param1BOOL) {
/* 1574 */       super(4);
/* 1575 */       setValue(param1BOOL);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.BOOL param1BOOL) {
/* 1584 */       getPointer().setInt(0L, param1BOOL.intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.BOOL getValue() {
/* 1593 */       return new WinDef.BOOL(getPointer().getInt(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class UCHAR
/*      */     extends IntegerType
/*      */     implements Comparable<UCHAR>
/*      */   {
/*      */     public static final int SIZE = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     public UCHAR() {
/* 1609 */       this(0L);
/*      */     }
/*      */     
/*      */     public UCHAR(char param1Char) {
/* 1613 */       this((param1Char & 0xFF));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public UCHAR(long param1Long) {
/* 1622 */       super(1, param1Long, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(UCHAR param1UCHAR) {
/* 1627 */       return compare(this, param1UCHAR);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class BYTE
/*      */     extends UCHAR
/*      */   {
/*      */     public BYTE() {
/* 1640 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public BYTE(long param1Long) {
/* 1649 */       super(param1Long);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class CHAR
/*      */     extends IntegerType
/*      */     implements Comparable<CHAR>
/*      */   {
/*      */     public static final int SIZE = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     public CHAR() {
/* 1665 */       this(0L);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public CHAR(byte param1Byte) {
/* 1674 */       this((param1Byte & 0xFF));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public CHAR(long param1Long) {
/* 1683 */       super(1, param1Long, false);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(CHAR param1CHAR) {
/* 1688 */       return compare(this, param1CHAR);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class CHARByReference
/*      */     extends com.sun.jna.ptr.ByReference
/*      */   {
/*      */     public CHARByReference() {
/* 1701 */       this(new WinDef.CHAR(0L));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public CHARByReference(WinDef.CHAR param1CHAR) {
/* 1710 */       super(1);
/* 1711 */       setValue(param1CHAR);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(WinDef.CHAR param1CHAR) {
/* 1720 */       getPointer().setByte(0L, param1CHAR.byteValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.CHAR getValue() {
/* 1729 */       return new WinDef.CHAR(getPointer().getByte(0L));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HGLRC
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public HGLRC() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HGLRC(Pointer param1Pointer) {
/* 1751 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class HGLRCByReference
/*      */     extends WinNT.HANDLEByReference
/*      */   {
/*      */     public HGLRCByReference() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HGLRCByReference(WinDef.HGLRC param1HGLRC) {
/* 1774 */       super(param1HGLRC);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */