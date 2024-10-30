/*    */ package org.apache.commons.io;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
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
/*    */ public class IOExceptionList
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final List<? extends Throwable> causeList;
/*    */   
/*    */   public IOExceptionList(List<? extends Throwable> paramList) {
/* 44 */     super(String.format("%,d exceptions: %s", new Object[] { Integer.valueOf((paramList == null) ? 0 : paramList.size()), paramList }), (paramList == null) ? null : paramList
/* 45 */         .get(0));
/* 46 */     this.causeList = (paramList == null) ? Collections.<Throwable>emptyList() : paramList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T extends Throwable> List<T> getCauseList() {
/* 56 */     return (List)this.causeList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T extends Throwable> T getCause(int paramInt) {
/* 67 */     return (T)this.causeList.get(paramInt);
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
/*    */   public <T extends Throwable> T getCause(int paramInt, Class<T> paramClass) {
/* 79 */     return (T)this.causeList.get(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T extends Throwable> List<T> getCauseList(Class<T> paramClass) {
/* 90 */     return (List)this.causeList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\IOExceptionList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */