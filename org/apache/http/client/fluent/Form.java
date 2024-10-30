/*    */ package org.apache.http.client.fluent;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.http.NameValuePair;
/*    */ import org.apache.http.message.BasicNameValuePair;
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
/*    */ public class Form
/*    */ {
/*    */   private final List<NameValuePair> params;
/*    */   
/*    */   public static Form form() {
/* 40 */     return new Form();
/*    */   }
/*    */ 
/*    */   
/*    */   Form() {
/* 45 */     this.params = new ArrayList<NameValuePair>();
/*    */   }
/*    */   
/*    */   public Form add(String paramString1, String paramString2) {
/* 49 */     this.params.add(new BasicNameValuePair(paramString1, paramString2));
/* 50 */     return this;
/*    */   }
/*    */   
/*    */   public List<NameValuePair> build() {
/* 54 */     return new ArrayList<NameValuePair>(this.params);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\Form.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */