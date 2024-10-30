/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.ReasonPhraseCatalog;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class EnglishReasonPhraseCatalog
/*     */   implements ReasonPhraseCatalog
/*     */ {
/*  55 */   public static final EnglishReasonPhraseCatalog INSTANCE = new EnglishReasonPhraseCatalog();
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
/*     */   public String getReason(int paramInt, Locale paramLocale) {
/*  77 */     Args.check((paramInt >= 100 && paramInt < 600), "Unknown category for status code " + paramInt);
/*  78 */     int i = paramInt / 100;
/*  79 */     int j = paramInt - 100 * i;
/*     */     
/*  81 */     String str = null;
/*  82 */     if ((REASON_PHRASES[i]).length > j) {
/*  83 */       str = REASON_PHRASES[i][j];
/*     */     }
/*     */     
/*  86 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  91 */   private static final String[][] REASON_PHRASES = new String[][] { null, new String[3], new String[8], new String[8], new String[30], new String[8] };
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
/*     */   private static void setReason(int paramInt, String paramString) {
/* 110 */     int i = paramInt / 100;
/* 111 */     int j = paramInt - 100 * i;
/* 112 */     REASON_PHRASES[i][j] = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 121 */     setReason(200, "OK");
/*     */     
/* 123 */     setReason(201, "Created");
/*     */     
/* 125 */     setReason(202, "Accepted");
/*     */     
/* 127 */     setReason(204, "No Content");
/*     */     
/* 129 */     setReason(301, "Moved Permanently");
/*     */     
/* 131 */     setReason(302, "Moved Temporarily");
/*     */     
/* 133 */     setReason(304, "Not Modified");
/*     */     
/* 135 */     setReason(400, "Bad Request");
/*     */     
/* 137 */     setReason(401, "Unauthorized");
/*     */     
/* 139 */     setReason(403, "Forbidden");
/*     */     
/* 141 */     setReason(404, "Not Found");
/*     */     
/* 143 */     setReason(429, "Too Many Requests");
/*     */     
/* 145 */     setReason(500, "Internal Server Error");
/*     */     
/* 147 */     setReason(501, "Not Implemented");
/*     */     
/* 149 */     setReason(502, "Bad Gateway");
/*     */     
/* 151 */     setReason(503, "Service Unavailable");
/*     */ 
/*     */ 
/*     */     
/* 155 */     setReason(100, "Continue");
/*     */     
/* 157 */     setReason(307, "Temporary Redirect");
/*     */     
/* 159 */     setReason(405, "Method Not Allowed");
/*     */     
/* 161 */     setReason(409, "Conflict");
/*     */     
/* 163 */     setReason(412, "Precondition Failed");
/*     */     
/* 165 */     setReason(413, "Request Too Long");
/*     */     
/* 167 */     setReason(414, "Request-URI Too Long");
/*     */     
/* 169 */     setReason(415, "Unsupported Media Type");
/*     */     
/* 171 */     setReason(300, "Multiple Choices");
/*     */     
/* 173 */     setReason(303, "See Other");
/*     */     
/* 175 */     setReason(305, "Use Proxy");
/*     */     
/* 177 */     setReason(402, "Payment Required");
/*     */     
/* 179 */     setReason(406, "Not Acceptable");
/*     */     
/* 181 */     setReason(407, "Proxy Authentication Required");
/*     */     
/* 183 */     setReason(408, "Request Timeout");
/*     */ 
/*     */     
/* 186 */     setReason(101, "Switching Protocols");
/*     */     
/* 188 */     setReason(203, "Non Authoritative Information");
/*     */     
/* 190 */     setReason(205, "Reset Content");
/*     */     
/* 192 */     setReason(206, "Partial Content");
/*     */     
/* 194 */     setReason(504, "Gateway Timeout");
/*     */     
/* 196 */     setReason(505, "Http Version Not Supported");
/*     */     
/* 198 */     setReason(410, "Gone");
/*     */     
/* 200 */     setReason(411, "Length Required");
/*     */     
/* 202 */     setReason(416, "Requested Range Not Satisfiable");
/*     */     
/* 204 */     setReason(417, "Expectation Failed");
/*     */ 
/*     */ 
/*     */     
/* 208 */     setReason(102, "Processing");
/*     */     
/* 210 */     setReason(207, "Multi-Status");
/*     */     
/* 212 */     setReason(422, "Unprocessable Entity");
/*     */     
/* 214 */     setReason(419, "Insufficient Space On Resource");
/*     */     
/* 216 */     setReason(420, "Method Failure");
/*     */     
/* 218 */     setReason(423, "Locked");
/*     */     
/* 220 */     setReason(507, "Insufficient Storage");
/*     */     
/* 222 */     setReason(424, "Failed Dependency");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\EnglishReasonPhraseCatalog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */