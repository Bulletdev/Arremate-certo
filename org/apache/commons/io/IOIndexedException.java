/*    */ package org.apache.commons.io;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class IOIndexedException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final int index;
/*    */   
/*    */   public IOIndexedException(int paramInt, Throwable paramThrowable) {
/* 39 */     super(toMessage(paramInt, paramThrowable), paramThrowable);
/* 40 */     this.index = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected static String toMessage(int paramInt, Throwable paramThrowable) {
/* 52 */     String str1 = "Null";
/* 53 */     String str2 = (paramThrowable == null) ? "Null" : paramThrowable.getClass().getSimpleName();
/* 54 */     String str3 = (paramThrowable == null) ? "Null" : paramThrowable.getMessage();
/* 55 */     return String.format("%s #%,d: %s", new Object[] { str2, Integer.valueOf(paramInt), str3 });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getIndex() {
/* 64 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\IOIndexedException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */