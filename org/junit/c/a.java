/*    */ package org.junit.c;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
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
/*    */ public class a
/*    */   extends AssertionError
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private final List<Integer> aB = new ArrayList<Integer>();
/*    */ 
/*    */ 
/*    */   
/*    */   private final String ma;
/*    */ 
/*    */ 
/*    */   
/*    */   private final AssertionError a;
/*    */ 
/*    */ 
/*    */   
/*    */   public a(String paramString, AssertionError paramAssertionError, int paramInt) {
/* 35 */     this.ma = paramString;
/* 36 */     this.a = paramAssertionError;
/* 37 */     initCause(this.a);
/* 38 */     bt(paramInt);
/*    */   }
/*    */   
/*    */   public void bt(int paramInt) {
/* 42 */     this.aB.add(0, Integer.valueOf(paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Throwable getCause() {
/* 47 */     return (super.getCause() == null) ? this.a : super.getCause();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 52 */     StringBuilder stringBuilder = new StringBuilder();
/* 53 */     if (this.ma != null) {
/* 54 */       stringBuilder.append(this.ma);
/*    */     }
/* 56 */     stringBuilder.append("arrays first differed at element ");
/* 57 */     for (Iterator<Integer> iterator = this.aB.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 58 */       stringBuilder.append("[");
/* 59 */       stringBuilder.append(i);
/* 60 */       stringBuilder.append("]"); }
/*    */     
/* 62 */     stringBuilder.append("; ");
/* 63 */     stringBuilder.append(getCause().getMessage());
/* 64 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     return getMessage();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */