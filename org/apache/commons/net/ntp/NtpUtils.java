/*     */ package org.apache.commons.net.ntp;
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
/*     */ public final class NtpUtils
/*     */ {
/*     */   public static String getHostAddress(int paramInt) {
/*  34 */     return (paramInt >>> 24 & 0xFF) + "." + (paramInt >>> 16 & 0xFF) + "." + (paramInt >>> 8 & 0xFF) + "." + (paramInt >>> 0 & 0xFF);
/*     */   }
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
/*     */   public static String getRefAddress(NtpV3Packet paramNtpV3Packet) {
/*  48 */     boolean bool = (paramNtpV3Packet == null) ? false : paramNtpV3Packet.getReferenceId();
/*  49 */     return getHostAddress(bool);
/*     */   }
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
/*     */   public static String getReferenceClock(NtpV3Packet paramNtpV3Packet) {
/*  62 */     if (paramNtpV3Packet == null) {
/*  63 */       return "";
/*     */     }
/*  65 */     int i = paramNtpV3Packet.getReferenceId();
/*  66 */     if (i == 0) {
/*  67 */       return "";
/*     */     }
/*  69 */     StringBuilder stringBuilder = new StringBuilder(4);
/*     */     
/*  71 */     for (byte b = 24; b >= 0; b -= 8) {
/*     */       
/*  73 */       char c = (char)(i >>> b & 0xFF);
/*  74 */       if (c == '\000') {
/*     */         break;
/*     */       }
/*  77 */       if (!Character.isLetterOrDigit(c)) {
/*  78 */         return "";
/*     */       }
/*  80 */       stringBuilder.append(c);
/*     */     } 
/*  82 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getModeName(int paramInt) {
/*  93 */     switch (paramInt) {
/*     */       case 0:
/*  95 */         return "Reserved";
/*     */       case 1:
/*  97 */         return "Symmetric Active";
/*     */       case 2:
/*  99 */         return "Symmetric Passive";
/*     */       case 3:
/* 101 */         return "Client";
/*     */       case 4:
/* 103 */         return "Server";
/*     */       case 5:
/* 105 */         return "Broadcast";
/*     */       case 6:
/* 107 */         return "Control";
/*     */       case 7:
/* 109 */         return "Private";
/*     */     } 
/* 111 */     return "Unknown";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ntp\NtpUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */