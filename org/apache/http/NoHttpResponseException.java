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
/*    */ public class NoHttpResponseException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = -7658940387386078766L;
/*    */   
/*    */   public NoHttpResponseException(String paramString) {
/* 47 */     super(HttpException.clean(paramString));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\NoHttpResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */