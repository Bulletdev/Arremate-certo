/*    */ package com.sun.jna.platform.linux;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
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
/*    */ public interface LibRT
/*    */   extends Library
/*    */ {
/* 35 */   public static final LibRT INSTANCE = (LibRT)Native.load("rt", LibRT.class);
/*    */   
/*    */   int shm_open(String paramString, int paramInt1, int paramInt2);
/*    */   
/*    */   int shm_unlink(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\linux\LibRT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */