/*     */ package org.apache.commons.net.imap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.net.MalformedServerReplyException;
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
/*     */ public final class IMAPReply
/*     */ {
/*     */   public static final int OK = 0;
/*     */   public static final int NO = 1;
/*     */   public static final int BAD = 2;
/*     */   public static final int CONT = 3;
/*     */   public static final int PARTIAL = 3;
/*     */   private static final String IMAP_OK = "OK";
/*     */   private static final String IMAP_NO = "NO";
/*     */   private static final String IMAP_BAD = "BAD";
/*     */   private static final String IMAP_UNTAGGED_PREFIX = "* ";
/*     */   private static final String IMAP_CONTINUATION_PREFIX = "+";
/*     */   private static final String TAGGED_RESPONSE = "^\\w+ (\\S+).*";
/*     */   
/*     */   public static boolean isUntagged(String paramString) {
/*  77 */     return paramString.startsWith("* ");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isContinuation(String paramString) {
/*  86 */     return paramString.startsWith("+");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  91 */   private static final Pattern TAGGED_PATTERN = Pattern.compile("^\\w+ (\\S+).*");
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String UNTAGGED_RESPONSE = "^\\* (\\S+).*";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getReplyCode(String paramString) throws IOException {
/* 101 */     return getReplyCode(paramString, TAGGED_PATTERN);
/*     */   }
/*     */ 
/*     */   
/* 105 */   private static final Pattern UNTAGGED_PATTERN = Pattern.compile("^\\* (\\S+).*");
/*     */   
/* 107 */   private static final Pattern LITERAL_PATTERN = Pattern.compile("\\{(\\d+)\\}$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int literalCount(String paramString) {
/* 116 */     Matcher matcher = LITERAL_PATTERN.matcher(paramString);
/* 117 */     if (matcher.find()) {
/* 118 */       return Integer.parseInt(matcher.group(1));
/*     */     }
/* 120 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getUntaggedReplyCode(String paramString) throws IOException {
/* 131 */     return getReplyCode(paramString, UNTAGGED_PATTERN);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getReplyCode(String paramString, Pattern paramPattern) throws IOException {
/* 136 */     if (isContinuation(paramString)) {
/* 137 */       return 3;
/*     */     }
/* 139 */     Matcher matcher = paramPattern.matcher(paramString);
/* 140 */     if (matcher.matches()) {
/* 141 */       String str = matcher.group(1);
/* 142 */       if (str.equals("OK")) {
/* 143 */         return 0;
/*     */       }
/* 145 */       if (str.equals("BAD")) {
/* 146 */         return 2;
/*     */       }
/* 148 */       if (str.equals("NO")) {
/* 149 */         return 1;
/*     */       }
/*     */     } 
/* 152 */     throw new MalformedServerReplyException("Received unexpected IMAP protocol response from server: '" + paramString + "'.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSuccess(int paramInt) {
/* 163 */     return (paramInt == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isContinuation(int paramInt) {
/* 171 */     return (paramInt == 3);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\imap\IMAPReply.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */