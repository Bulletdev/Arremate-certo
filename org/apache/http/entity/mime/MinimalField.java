/*    */ package org.apache.http.entity.mime;
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
/*    */ public class MinimalField
/*    */ {
/*    */   private final String name;
/*    */   private final String value;
/*    */   
/*    */   public MinimalField(String paramString1, String paramString2) {
/* 42 */     this.name = paramString1;
/* 43 */     this.value = paramString2;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 47 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getBody() {
/* 51 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder stringBuilder = new StringBuilder();
/* 57 */     stringBuilder.append(this.name);
/* 58 */     stringBuilder.append(": ");
/* 59 */     stringBuilder.append(this.value);
/* 60 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\MinimalField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */