/*    */ package javax.xml.stream;
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
/*    */ public class FactoryConfigurationError
/*    */   extends Error
/*    */ {
/*    */   Exception nested;
/*    */   
/*    */   public FactoryConfigurationError() {}
/*    */   
/*    */   public FactoryConfigurationError(Exception paramException) {
/* 24 */     this.nested = paramException;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FactoryConfigurationError(Exception paramException, String paramString) {
/* 35 */     super(paramString);
/* 36 */     this.nested = paramException;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FactoryConfigurationError(String paramString, Exception paramException) {
/* 47 */     super(paramString);
/* 48 */     this.nested = paramException;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FactoryConfigurationError(String paramString) {
/* 58 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Exception getException() {
/* 67 */     return this.nested;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 77 */     String str = super.getMessage();
/* 78 */     if (str != null)
/* 79 */       return str; 
/* 80 */     if (this.nested != null) {
/* 81 */       str = this.nested.getMessage();
/* 82 */       if (str == null)
/* 83 */         str = this.nested.getClass().toString(); 
/*    */     } 
/* 85 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\FactoryConfigurationError.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */