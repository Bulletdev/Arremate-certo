/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.apache.http.cookie.SetCookie2;
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
/*    */ 
/*    */ 
/*    */ public class BasicClientCookie2
/*    */   extends BasicClientCookie
/*    */   implements SetCookie2
/*    */ {
/*    */   private static final long serialVersionUID = -7744598295706617057L;
/*    */   private String commentURL;
/*    */   private int[] ports;
/*    */   private boolean discard;
/*    */   
/*    */   public BasicClientCookie2(String paramString1, String paramString2) {
/* 54 */     super(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] getPorts() {
/* 59 */     return this.ports;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPorts(int[] paramArrayOfint) {
/* 64 */     this.ports = paramArrayOfint;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommentURL() {
/* 69 */     return this.commentURL;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCommentURL(String paramString) {
/* 74 */     this.commentURL = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setDiscard(boolean paramBoolean) {
/* 79 */     this.discard = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPersistent() {
/* 84 */     return (!this.discard && super.isPersistent());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isExpired(Date paramDate) {
/* 89 */     return (this.discard || super.isExpired(paramDate));
/*    */   }
/*    */ 
/*    */   
/*    */   public Object clone() throws CloneNotSupportedException {
/* 94 */     BasicClientCookie2 basicClientCookie2 = (BasicClientCookie2)super.clone();
/* 95 */     if (this.ports != null) {
/* 96 */       basicClientCookie2.ports = (int[])this.ports.clone();
/*    */     }
/* 98 */     return basicClientCookie2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicClientCookie2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */