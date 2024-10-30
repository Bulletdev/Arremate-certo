/*    */ package org.h2.message;
/*    */ 
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
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
/*    */ public class TraceWriterAdapter
/*    */   implements TraceWriter
/*    */ {
/*    */   private String name;
/* 27 */   private final Logger logger = LoggerFactory.getLogger("h2database");
/*    */ 
/*    */   
/*    */   public void setName(String paramString) {
/* 31 */     this.name = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEnabled(int paramInt) {
/* 36 */     switch (paramInt) {
/*    */       case 3:
/* 38 */         return this.logger.isDebugEnabled();
/*    */       case 2:
/* 40 */         return this.logger.isInfoEnabled();
/*    */       case 1:
/* 42 */         return this.logger.isErrorEnabled();
/*    */     } 
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable) {
/* 50 */     write(paramInt1, Trace.MODULE_NAMES[paramInt2], paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
/* 55 */     if (isEnabled(paramInt)) {
/* 56 */       if (this.name != null) {
/* 57 */         paramString2 = this.name + ":" + paramString1 + " " + paramString2;
/*    */       } else {
/* 59 */         paramString2 = paramString1 + " " + paramString2;
/*    */       } 
/* 61 */       switch (paramInt) {
/*    */         case 3:
/* 63 */           this.logger.debug(paramString2, paramThrowable);
/*    */           break;
/*    */         case 2:
/* 66 */           this.logger.info(paramString2, paramThrowable);
/*    */           break;
/*    */         case 1:
/* 69 */           this.logger.error(paramString2, paramThrowable);
/*    */           break;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\message\TraceWriterAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */