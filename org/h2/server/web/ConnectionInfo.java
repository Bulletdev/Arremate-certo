/*    */ package org.h2.server.web;
/*    */ 
/*    */ import org.h2.util.MathUtils;
/*    */ import org.h2.util.StringUtils;
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
/*    */ public class ConnectionInfo
/*    */   implements Comparable<ConnectionInfo>
/*    */ {
/*    */   public String driver;
/*    */   public String url;
/*    */   public String user;
/*    */   String name;
/*    */   int lastAccess;
/*    */   
/*    */   ConnectionInfo() {}
/*    */   
/*    */   public ConnectionInfo(String paramString) {
/* 47 */     String[] arrayOfString = StringUtils.arraySplit(paramString, '|', false);
/* 48 */     this.name = get(arrayOfString, 0);
/* 49 */     this.driver = get(arrayOfString, 1);
/* 50 */     this.url = get(arrayOfString, 2);
/* 51 */     this.user = get(arrayOfString, 3);
/*    */   }
/*    */   
/*    */   private static String get(String[] paramArrayOfString, int paramInt) {
/* 55 */     return (paramArrayOfString != null && paramArrayOfString.length > paramInt) ? paramArrayOfString[paramInt] : "";
/*    */   }
/*    */   
/*    */   String getString() {
/* 59 */     return StringUtils.arrayCombine(new String[] { this.name, this.driver, this.url, this.user }, '|');
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(ConnectionInfo paramConnectionInfo) {
/* 64 */     return -MathUtils.compareInt(this.lastAccess, paramConnectionInfo.lastAccess);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\ConnectionInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */