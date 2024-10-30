/*    */ package junit.b;
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
/*    */ public class b
/*    */   extends AssertionError
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public b() {}
/*    */   
/*    */   public b(String paramString) {
/* 23 */     super(defaultString(paramString));
/*    */   }
/*    */   
/*    */   private static String defaultString(String paramString) {
/* 27 */     return (paramString == null) ? "" : paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */