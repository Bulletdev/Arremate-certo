/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.UnknownHostException;
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
/*    */ final class LocalHostStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 40 */   static final LocalHostStringLookup INSTANCE = new LocalHostStringLookup();
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
/*    */   public String lookup(String paramString) {
/* 57 */     if (paramString == null) {
/* 58 */       return null;
/*    */     }
/*    */     try {
/* 61 */       switch (paramString) {
/*    */         case "name":
/* 63 */           return InetAddress.getLocalHost().getHostName();
/*    */         case "canonical-name":
/* 65 */           return InetAddress.getLocalHost().getCanonicalHostName();
/*    */         case "address":
/* 67 */           return InetAddress.getLocalHost().getHostAddress();
/*    */       } 
/* 69 */       throw new IllegalArgumentException(paramString);
/*    */     }
/* 71 */     catch (UnknownHostException unknownHostException) {
/* 72 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\LocalHostStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */