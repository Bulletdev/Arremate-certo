/*    */ package org.apache.http.auth;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.security.Principal;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.util.Args;
/*    */ import org.apache.http.util.LangUtils;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public final class BasicUserPrincipal
/*    */   implements Serializable, Principal
/*    */ {
/*    */   private static final long serialVersionUID = -2266305184969850467L;
/*    */   private final String username;
/*    */   
/*    */   public BasicUserPrincipal(String paramString) {
/* 51 */     Args.notNull(paramString, "User name");
/* 52 */     this.username = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 57 */     return this.username;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 62 */     int i = 17;
/* 63 */     i = LangUtils.hashCode(i, this.username);
/* 64 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 69 */     if (this == paramObject) {
/* 70 */       return true;
/*    */     }
/* 72 */     if (paramObject instanceof BasicUserPrincipal) {
/* 73 */       BasicUserPrincipal basicUserPrincipal = (BasicUserPrincipal)paramObject;
/* 74 */       if (LangUtils.equals(this.username, basicUserPrincipal.username)) {
/* 75 */         return true;
/*    */       }
/*    */     } 
/* 78 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder stringBuilder = new StringBuilder();
/* 84 */     stringBuilder.append("[principal: ");
/* 85 */     stringBuilder.append(this.username);
/* 86 */     stringBuilder.append("]");
/* 87 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\BasicUserPrincipal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */