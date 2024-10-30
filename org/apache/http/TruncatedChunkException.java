/*    */ package org.apache.http;
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
/*    */ public class TruncatedChunkException
/*    */   extends MalformedChunkCodingException
/*    */ {
/*    */   private static final long serialVersionUID = -23506263930279460L;
/*    */   
/*    */   public TruncatedChunkException(String paramString) {
/* 45 */     super(paramString);
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
/*    */   public TruncatedChunkException(String paramString, Object... paramVarArgs) {
/* 57 */     super(HttpException.clean(String.format(paramString, paramVarArgs)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\TruncatedChunkException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */