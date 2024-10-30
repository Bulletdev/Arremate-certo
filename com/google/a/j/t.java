/*    */ package com.google.a.j;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.c;
/*    */ import java.io.Flushable;
/*    */ import java.io.IOException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
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
/*    */ @a
/*    */ @c
/*    */ public final class t
/*    */ {
/* 33 */   private static final Logger logger = Logger.getLogger(t.class.getName());
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
/*    */   public static void a(Flushable paramFlushable, boolean paramBoolean) throws IOException {
/*    */     try {
/* 52 */       paramFlushable.flush();
/* 53 */     } catch (IOException iOException) {
/* 54 */       if (paramBoolean) {
/* 55 */         logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", iOException);
/*    */       } else {
/* 57 */         throw iOException;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void a(Flushable paramFlushable) {
/*    */     try {
/* 70 */       a(paramFlushable, true);
/* 71 */     } catch (IOException iOException) {
/* 72 */       logger.log(Level.SEVERE, "IOException should not have been thrown.", iOException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */