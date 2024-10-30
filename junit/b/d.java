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
/*    */ public class d
/*    */   extends b
/*    */ {
/*    */   private static final int hR = 20;
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String jD;
/*    */   private String jE;
/*    */   
/*    */   public d(String paramString1, String paramString2, String paramString3) {
/* 23 */     super(paramString1);
/* 24 */     this.jD = paramString2;
/* 25 */     this.jE = paramString3;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 36 */     return (new c(20, this.jD, this.jE)).aD(super.getMessage());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String dW() {
/* 45 */     return this.jE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String dX() {
/* 54 */     return this.jD;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */