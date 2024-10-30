/*    */ package com.sun.jna;
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
/*    */ public class CallbackThreadInitializer
/*    */ {
/*    */   private boolean daemon;
/*    */   private boolean detach;
/*    */   private String name;
/*    */   private ThreadGroup group;
/*    */   
/*    */   public CallbackThreadInitializer() {
/* 54 */     this(true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CallbackThreadInitializer(boolean paramBoolean) {
/* 60 */     this(paramBoolean, false);
/*    */   }
/*    */   
/*    */   public CallbackThreadInitializer(boolean paramBoolean1, boolean paramBoolean2) {
/* 64 */     this(paramBoolean1, paramBoolean2, null);
/*    */   }
/*    */   
/*    */   public CallbackThreadInitializer(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
/* 68 */     this(paramBoolean1, paramBoolean2, paramString, null);
/*    */   }
/*    */   
/*    */   public CallbackThreadInitializer(boolean paramBoolean1, boolean paramBoolean2, String paramString, ThreadGroup paramThreadGroup) {
/* 72 */     this.daemon = paramBoolean1;
/* 73 */     this.detach = paramBoolean2;
/* 74 */     this.name = paramString;
/* 75 */     this.group = paramThreadGroup;
/*    */   }
/*    */   
/*    */   public String getName(Callback paramCallback) {
/* 79 */     return this.name;
/*    */   } public ThreadGroup getThreadGroup(Callback paramCallback) {
/* 81 */     return this.group;
/*    */   } public boolean isDaemon(Callback paramCallback) {
/* 83 */     return this.daemon;
/*    */   }
/*    */   
/*    */   public boolean detach(Callback paramCallback) {
/* 87 */     return this.detach;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\CallbackThreadInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */