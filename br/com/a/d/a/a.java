/*    */ package br.com.a.d.a;
/*    */ 
/*    */ public abstract class a
/*    */   extends Exception {
/*    */   public a() {
/*  6 */     super("");
/*    */   }
/*    */   
/*    */   public a(Throwable paramThrowable) {
/* 10 */     super(paramThrowable);
/*    */   }
/*    */   
/*    */   public a(String paramString) {
/* 14 */     super(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 19 */     if (!super.getMessage().isEmpty()) {
/* 20 */       return super.getMessage();
/*    */     }
/* 22 */     return da();
/*    */   }
/*    */   
/*    */   protected abstract String da();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\d\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */