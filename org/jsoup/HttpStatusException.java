/*    */ package org.jsoup;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public class HttpStatusException
/*    */   extends IOException
/*    */ {
/*    */   private int statusCode;
/*    */   private String url;
/*    */   
/*    */   public HttpStatusException(String paramString1, int paramInt, String paramString2) {
/* 13 */     super(paramString1);
/* 14 */     this.statusCode = paramInt;
/* 15 */     this.url = paramString2;
/*    */   }
/*    */   
/*    */   public int getStatusCode() {
/* 19 */     return this.statusCode;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 23 */     return this.url;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 28 */     return super.toString() + ". Status=" + this.statusCode + ", URL=" + this.url;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\HttpStatusException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */