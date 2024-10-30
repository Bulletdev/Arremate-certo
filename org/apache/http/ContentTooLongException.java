/*    */ package org.apache.http;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContentTooLongException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = -924287689552495383L;
/*    */   
/*    */   public ContentTooLongException(String paramString) {
/* 47 */     super(paramString);
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
/*    */   public ContentTooLongException(String paramString, Object... paramVarArgs) {
/* 59 */     super(HttpException.clean(String.format(paramString, paramVarArgs)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ContentTooLongException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */