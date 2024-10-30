/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.Union;
/*     */ import com.sun.jna.ptr.IntByReference;
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
/*     */ public interface Wincon
/*     */ {
/*     */   public static final int ATTACH_PARENT_PROCESS = -1;
/*     */   public static final int CTRL_C_EVENT = 0;
/*     */   public static final int CTRL_BREAK_EVENT = 1;
/*     */   public static final int STD_INPUT_HANDLE = -10;
/*     */   public static final int STD_OUTPUT_HANDLE = -11;
/*     */   public static final int STD_ERROR_HANDLE = -12;
/*     */   public static final int CONSOLE_FULLSCREEN = 1;
/*     */   public static final int CONSOLE_FULLSCREEN_HARDWARE = 2;
/*     */   public static final int ENABLE_PROCESSED_INPUT = 1;
/*     */   public static final int ENABLE_LINE_INPUT = 2;
/*     */   public static final int ENABLE_ECHO_INPUT = 4;
/*     */   public static final int ENABLE_WINDOW_INPUT = 8;
/*     */   public static final int ENABLE_MOUSE_INPUT = 16;
/*     */   public static final int ENABLE_INSERT_MODE = 32;
/*     */   public static final int ENABLE_QUICK_EDIT_MODE = 64;
/*     */   public static final int ENABLE_EXTENDED_FLAGS = 128;
/*     */   public static final int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
/*     */   public static final int DISABLE_NEWLINE_AUTO_RETURN = 8;
/*     */   public static final int ENABLE_VIRTUAL_TERMINAL_INPUT = 512;
/*     */   public static final int ENABLE_PROCESSED_OUTPUT = 1;
/*     */   public static final int ENABLE_WRAP_AT_EOL_OUTPUT = 2;
/*     */   public static final int MAX_CONSOLE_TITLE_LENGTH = 65536;
/*     */   
/*     */   boolean AllocConsole();
/*     */   
/*     */   boolean FreeConsole();
/*     */   
/*     */   boolean AttachConsole(int paramInt);
/*     */   
/*     */   boolean FlushConsoleInputBuffer(WinNT.HANDLE paramHANDLE);
/*     */   
/*     */   boolean GenerateConsoleCtrlEvent(int paramInt1, int paramInt2);
/*     */   
/*     */   int GetConsoleCP();
/*     */   
/*     */   boolean SetConsoleCP(int paramInt);
/*     */   
/*     */   int GetConsoleOutputCP();
/*     */   
/*     */   boolean SetConsoleOutputCP(int paramInt);
/*     */   
/*     */   WinDef.HWND GetConsoleWindow();
/*     */   
/*     */   boolean GetNumberOfConsoleInputEvents(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*     */   
/*     */   boolean GetNumberOfConsoleMouseButtons(IntByReference paramIntByReference);
/*     */   
/*     */   WinNT.HANDLE GetStdHandle(int paramInt);
/*     */   
/*     */   boolean SetStdHandle(int paramInt, WinNT.HANDLE paramHANDLE);
/*     */   
/*     */   boolean GetConsoleDisplayMode(IntByReference paramIntByReference);
/*     */   
/*     */   boolean GetConsoleMode(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*     */   
/*     */   boolean SetConsoleMode(WinNT.HANDLE paramHANDLE, int paramInt);
/*     */   
/*     */   int GetConsoleTitle(char[] paramArrayOfchar, int paramInt);
/*     */   
/*     */   int GetConsoleOriginalTitle(char[] paramArrayOfchar, int paramInt);
/*     */   
/*     */   boolean SetConsoleTitle(String paramString);
/*     */   
/*     */   boolean GetConsoleScreenBufferInfo(WinNT.HANDLE paramHANDLE, CONSOLE_SCREEN_BUFFER_INFO paramCONSOLE_SCREEN_BUFFER_INFO);
/*     */   
/*     */   boolean ReadConsoleInput(WinNT.HANDLE paramHANDLE, INPUT_RECORD[] paramArrayOfINPUT_RECORD, int paramInt, IntByReference paramIntByReference);
/*     */   
/*     */   boolean WriteConsole(WinNT.HANDLE paramHANDLE, String paramString, int paramInt, IntByReference paramIntByReference, WinDef.LPVOID paramLPVOID);
/*     */   
/*     */   @FieldOrder({"X", "Y"})
/*     */   public static class COORD
/*     */     extends Structure
/*     */   {
/*     */     public short X;
/*     */     public short Y;
/*     */     
/*     */     public String toString() {
/* 306 */       return String.format("COORD(%s,%s)", new Object[] { Short.valueOf(this.X), Short.valueOf(this.Y) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"Left", "Top", "Right", "Bottom"})
/*     */   public static class SMALL_RECT
/*     */     extends Structure
/*     */   {
/*     */     public short Left;
/*     */     
/*     */     public short Top;
/*     */     
/*     */     public short Right;
/*     */     public short Bottom;
/*     */     
/*     */     public String toString() {
/* 323 */       return String.format("SMALL_RECT(%s,%s)(%s,%s)", new Object[] { Short.valueOf(this.Left), Short.valueOf(this.Top), Short.valueOf(this.Right), Short.valueOf(this.Bottom) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize", "dwCursorPosition", "wAttributes", "srWindow", "dwMaximumWindowSize"})
/*     */   public static class CONSOLE_SCREEN_BUFFER_INFO
/*     */     extends Structure
/*     */   {
/*     */     public Wincon.COORD dwSize;
/*     */     
/*     */     public Wincon.COORD dwCursorPosition;
/*     */     
/*     */     public short wAttributes;
/*     */     public Wincon.SMALL_RECT srWindow;
/*     */     public Wincon.COORD dwMaximumWindowSize;
/*     */     
/*     */     public String toString() {
/* 341 */       return String.format("CONSOLE_SCREEN_BUFFER_INFO(%s,%s,%s,%s,%s)", new Object[] { this.dwSize, this.dwCursorPosition, Short.valueOf(this.wAttributes), this.srWindow, this.dwMaximumWindowSize });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"EventType", "Event"})
/*     */   public static class INPUT_RECORD
/*     */     extends Structure
/*     */   {
/*     */     public static final short KEY_EVENT = 1;
/*     */     
/*     */     public static final short MOUSE_EVENT = 2;
/*     */     public static final short WINDOW_BUFFER_SIZE_EVENT = 4;
/*     */     public short EventType;
/*     */     public Event Event;
/*     */     
/*     */     public static class Event
/*     */       extends Union
/*     */     {
/*     */       public Wincon.KEY_EVENT_RECORD KeyEvent;
/*     */       public Wincon.MOUSE_EVENT_RECORD MouseEvent;
/*     */       public Wincon.WINDOW_BUFFER_SIZE_RECORD WindowBufferSizeEvent;
/*     */     }
/*     */     
/*     */     public void read() {
/* 366 */       super.read();
/* 367 */       switch (this.EventType) {
/*     */         case 1:
/* 369 */           this.Event.setType("KeyEvent");
/*     */           break;
/*     */         case 2:
/* 372 */           this.Event.setType("MouseEvent");
/*     */           break;
/*     */         case 4:
/* 375 */           this.Event.setType("WindowBufferSizeEvent");
/*     */           break;
/*     */       } 
/* 378 */       this.Event.read();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 383 */       return String.format("INPUT_RECORD(%s)", new Object[] { Short.valueOf(this.EventType) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"bKeyDown", "wRepeatCount", "wVirtualKeyCode", "wVirtualScanCode", "uChar", "dwControlKeyState"})
/*     */   public static class KEY_EVENT_RECORD
/*     */     extends Structure
/*     */   {
/*     */     public boolean bKeyDown;
/*     */     
/*     */     public short wRepeatCount;
/*     */     
/*     */     public short wVirtualKeyCode;
/*     */     public short wVirtualScanCode;
/*     */     public char uChar;
/*     */     public int dwControlKeyState;
/*     */     
/*     */     public String toString() {
/* 402 */       return String.format("KEY_EVENT_RECORD(%s,%s,%s,%s,%s,%s)", new Object[] { Boolean.valueOf(this.bKeyDown), Short.valueOf(this.wRepeatCount), Short.valueOf(this.wVirtualKeyCode), Short.valueOf(this.wVirtualKeyCode), Short.valueOf(this.wVirtualScanCode), Character.valueOf(this.uChar), Integer.valueOf(this.dwControlKeyState) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwMousePosition", "dwButtonState", "dwControlKeyState", "dwEventFlags"})
/*     */   public static class MOUSE_EVENT_RECORD
/*     */     extends Structure
/*     */   {
/*     */     public Wincon.COORD dwMousePosition;
/*     */     
/*     */     public int dwButtonState;
/*     */     
/*     */     public int dwControlKeyState;
/*     */     public int dwEventFlags;
/*     */     
/*     */     public String toString() {
/* 419 */       return String.format("MOUSE_EVENT_RECORD(%s,%s,%s,%s)", new Object[] { this.dwMousePosition, Integer.valueOf(this.dwButtonState), Integer.valueOf(this.dwControlKeyState), Integer.valueOf(this.dwEventFlags) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"dwSize"})
/*     */   public static class WINDOW_BUFFER_SIZE_RECORD
/*     */     extends Structure
/*     */   {
/*     */     public Wincon.COORD dwSize;
/*     */ 
/*     */     
/*     */     public String toString() {
/* 433 */       return String.format("WINDOW_BUFFER_SIZE_RECORD(%s)", new Object[] { this.dwSize });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Wincon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */