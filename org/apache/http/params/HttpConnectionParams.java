/*     */ package org.apache.http.params;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public final class HttpConnectionParams
/*     */   implements CoreConnectionPNames
/*     */ {
/*     */   public static int getSoTimeout(HttpParams paramHttpParams) {
/*  55 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  56 */     return paramHttpParams.getIntParameter("http.socket.timeout", 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setSoTimeout(HttpParams paramHttpParams, int paramInt) {
/*  66 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  67 */     paramHttpParams.setIntParameter("http.socket.timeout", paramInt);
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
/*     */   public static boolean getSoReuseaddr(HttpParams paramHttpParams) {
/*  81 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  82 */     return paramHttpParams.getBooleanParameter("http.socket.reuseaddr", false);
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
/*     */   public static void setSoReuseaddr(HttpParams paramHttpParams, boolean paramBoolean) {
/*  94 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  95 */     paramHttpParams.setBooleanParameter("http.socket.reuseaddr", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean getTcpNoDelay(HttpParams paramHttpParams) {
/* 106 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 107 */     return paramHttpParams.getBooleanParameter("http.tcp.nodelay", true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setTcpNoDelay(HttpParams paramHttpParams, boolean paramBoolean) {
/* 117 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 118 */     paramHttpParams.setBooleanParameter("http.tcp.nodelay", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSocketBufferSize(HttpParams paramHttpParams) {
/* 129 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 130 */     return paramHttpParams.getIntParameter("http.socket.buffer-size", -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setSocketBufferSize(HttpParams paramHttpParams, int paramInt) {
/* 141 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 142 */     paramHttpParams.setIntParameter("http.socket.buffer-size", paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getLinger(HttpParams paramHttpParams) {
/* 153 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 154 */     return paramHttpParams.getIntParameter("http.socket.linger", -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLinger(HttpParams paramHttpParams, int paramInt) {
/* 164 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 165 */     paramHttpParams.setIntParameter("http.socket.linger", paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getConnectionTimeout(HttpParams paramHttpParams) {
/* 176 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 177 */     return paramHttpParams.getIntParameter("http.connection.timeout", 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setConnectionTimeout(HttpParams paramHttpParams, int paramInt) {
/* 188 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 189 */     paramHttpParams.setIntParameter("http.connection.timeout", paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isStaleCheckingEnabled(HttpParams paramHttpParams) {
/* 200 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 201 */     return paramHttpParams.getBooleanParameter("http.connection.stalecheck", true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setStaleCheckingEnabled(HttpParams paramHttpParams, boolean paramBoolean) {
/* 212 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 213 */     paramHttpParams.setBooleanParameter("http.connection.stalecheck", paramBoolean);
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
/*     */   public static boolean getSoKeepalive(HttpParams paramHttpParams) {
/* 226 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 227 */     return paramHttpParams.getBooleanParameter("http.socket.keepalive", false);
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
/*     */   public static void setSoKeepalive(HttpParams paramHttpParams, boolean paramBoolean) {
/* 239 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 240 */     paramHttpParams.setBooleanParameter("http.socket.keepalive", paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\HttpConnectionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */