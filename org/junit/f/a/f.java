/*    */ package org.junit.f.a;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class f
/*    */   extends e
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String message;
/*    */   
/*    */   public f(Class<?> paramClass, List<Throwable> paramList) {
/* 18 */     super(paramList);
/* 19 */     this.message = a(paramClass, paramList);
/*    */   }
/*    */   
/*    */   private static String a(Class<?> paramClass, List<Throwable> paramList) {
/* 23 */     StringBuilder stringBuilder = new StringBuilder();
/* 24 */     stringBuilder.append(String.format("Invalid test class '%s':", new Object[] { paramClass.getName() }));
/* 25 */     byte b = 1;
/* 26 */     for (Throwable throwable : paramList) {
/* 27 */       stringBuilder.append("\n  " + b++ + ". " + throwable.getMessage());
/*    */     }
/* 29 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 37 */     return this.message;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */