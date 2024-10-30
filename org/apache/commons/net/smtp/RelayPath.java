/*    */ package org.apache.commons.net.smtp;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
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
/*    */ public final class RelayPath
/*    */ {
/*    */   private final Vector<String> path;
/*    */   private final String emailAddress;
/*    */   
/*    */   public RelayPath(String paramString) {
/* 45 */     this.path = new Vector<>();
/* 46 */     this.emailAddress = paramString;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addRelay(String paramString) {
/* 63 */     this.path.addElement(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder stringBuilder = new StringBuilder();
/*    */ 
/*    */     
/* 77 */     stringBuilder.append('<');
/*    */     
/* 79 */     Enumeration<String> enumeration = this.path.elements();
/*    */     
/* 81 */     if (enumeration.hasMoreElements()) {
/*    */       
/* 83 */       stringBuilder.append('@');
/* 84 */       stringBuilder.append(enumeration.nextElement());
/*    */       
/* 86 */       while (enumeration.hasMoreElements()) {
/*    */         
/* 88 */         stringBuilder.append(",@");
/* 89 */         stringBuilder.append(enumeration.nextElement());
/*    */       } 
/* 91 */       stringBuilder.append(':');
/*    */     } 
/*    */     
/* 94 */     stringBuilder.append(this.emailAddress);
/* 95 */     stringBuilder.append('>');
/*    */     
/* 97 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\smtp\RelayPath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */