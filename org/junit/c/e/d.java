/*    */ package org.junit.c.e;
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
/*    */ @Deprecated
/*    */ public class d
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final List<Throwable> ad;
/*    */   
/*    */   public d(List<Throwable> paramList) {
/* 23 */     this.ad = paramList;
/*    */   }
/*    */   
/*    */   public d(Throwable... paramVarArgs) {
/* 27 */     this(Arrays.asList(paramVarArgs));
/*    */   }
/*    */   
/*    */   public d(String paramString) {
/* 31 */     this(new Throwable[] { new Exception(paramString) });
/*    */   }
/*    */   
/*    */   public List<Throwable> bi() {
/* 35 */     return this.ad;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */