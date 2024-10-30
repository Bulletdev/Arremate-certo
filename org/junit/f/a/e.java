/*    */ package org.junit.f.a;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ public class e
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final List<Throwable> ad;
/*    */   
/*    */   public e(List<Throwable> paramList) {
/* 26 */     this.ad = paramList;
/*    */   }
/*    */   
/*    */   public e(Throwable paramThrowable) {
/* 30 */     this(Arrays.asList(new Throwable[] { paramThrowable }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e(String paramString) {
/* 38 */     this(new Exception(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Throwable> bi() {
/* 45 */     return this.ad;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */