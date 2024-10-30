/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
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
/*    */ public interface Wdm
/*    */ {
/*    */   @FieldOrder({"LastWriteTime", "TitleIndex", "NameLength", "Name"})
/*    */   public static class KEY_BASIC_INFORMATION
/*    */     extends Structure
/*    */   {
/*    */     public long LastWriteTime;
/*    */     public int TitleIndex;
/*    */     public int NameLength;
/*    */     public char[] Name;
/*    */     
/*    */     public KEY_BASIC_INFORMATION() {}
/*    */     
/*    */     public KEY_BASIC_INFORMATION(int param1Int) {
/* 69 */       this.NameLength = param1Int - 16;
/* 70 */       this.Name = new char[this.NameLength];
/* 71 */       allocateMemory();
/*    */     }
/*    */     
/*    */     public KEY_BASIC_INFORMATION(Pointer param1Pointer) {
/* 75 */       super(param1Pointer);
/* 76 */       read();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public String getName() {
/* 84 */       return Native.toString(this.Name);
/*    */     }
/*    */ 
/*    */     
/*    */     public void read() {
/* 89 */       super.read();
/* 90 */       this.Name = new char[this.NameLength / 2];
/* 91 */       readField("Name");
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract class KEY_INFORMATION_CLASS {
/*    */     public static final int KeyBasicInformation = 0;
/*    */     public static final int KeyNodeInformation = 1;
/*    */     public static final int KeyFullInformation = 2;
/*    */     public static final int KeyNameInformation = 3;
/*    */     public static final int KeyCachedInformation = 4;
/*    */     public static final int KeyVirtualizationInformation = 5;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Wdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */