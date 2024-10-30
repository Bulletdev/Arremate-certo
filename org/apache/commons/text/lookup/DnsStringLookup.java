/*     */ package org.apache.commons.text.lookup;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class DnsStringLookup
/*     */   extends AbstractStringLookup
/*     */ {
/*  64 */   static final DnsStringLookup INSTANCE = new DnsStringLookup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String lookup(String paramString) {
/*  81 */     if (paramString == null) {
/*  82 */       return null;
/*     */     }
/*  84 */     String[] arrayOfString = paramString.trim().split("\\|");
/*  85 */     int i = arrayOfString.length;
/*  86 */     String str1 = arrayOfString[0].trim();
/*  87 */     String str2 = (i < 2) ? paramString : arrayOfString[1].trim();
/*     */     try {
/*  89 */       InetAddress inetAddress = InetAddress.getByName(str2);
/*  90 */       switch (str1) {
/*     */         case "name":
/*  92 */           return inetAddress.getHostName();
/*     */         case "canonical-name":
/*  94 */           return inetAddress.getCanonicalHostName();
/*     */         case "address":
/*  96 */           return inetAddress.getHostAddress();
/*     */       } 
/*  98 */       return inetAddress.getHostAddress();
/*     */     }
/* 100 */     catch (UnknownHostException unknownHostException) {
/* 101 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\DnsStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */