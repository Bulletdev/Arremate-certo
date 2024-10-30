/*    */ package com.google.a.h;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import java.nio.Buffer;
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
/*    */ @c
/*    */ final class u
/*    */ {
/*    */   static void a(Buffer paramBuffer) {
/* 27 */     paramBuffer.clear();
/*    */   }
/*    */   
/*    */   static void b(Buffer paramBuffer) {
/* 31 */     paramBuffer.flip();
/*    */   }
/*    */   
/*    */   static void a(Buffer paramBuffer, int paramInt) {
/* 35 */     paramBuffer.limit(paramInt);
/*    */   }
/*    */   
/*    */   static void b(Buffer paramBuffer, int paramInt) {
/* 39 */     paramBuffer.position(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */