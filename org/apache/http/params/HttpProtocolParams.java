/*     */ package org.apache.http.params;
/*     */ 
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.protocol.HTTP;
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
/*     */ 
/*     */ @Deprecated
/*     */ public final class HttpProtocolParams
/*     */   implements CoreProtocolPNames
/*     */ {
/*     */   public static String getHttpElementCharset(HttpParams paramHttpParams) {
/*  60 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  61 */     String str = (String)paramHttpParams.getParameter("http.protocol.element-charset");
/*     */     
/*  63 */     if (str == null) {
/*  64 */       str = HTTP.DEF_PROTOCOL_CHARSET.name();
/*     */     }
/*  66 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setHttpElementCharset(HttpParams paramHttpParams, String paramString) {
/*  76 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  77 */     paramHttpParams.setParameter("http.protocol.element-charset", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getContentCharset(HttpParams paramHttpParams) {
/*  88 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  89 */     String str = (String)paramHttpParams.getParameter("http.protocol.content-charset");
/*     */     
/*  91 */     if (str == null) {
/*  92 */       str = HTTP.DEF_CONTENT_CHARSET.name();
/*     */     }
/*  94 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setContentCharset(HttpParams paramHttpParams, String paramString) {
/* 104 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 105 */     paramHttpParams.setParameter("http.protocol.content-charset", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ProtocolVersion getVersion(HttpParams paramHttpParams) {
/* 116 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 117 */     Object object = paramHttpParams.getParameter("http.protocol.version");
/*     */     
/* 119 */     if (object == null) {
/* 120 */       return (ProtocolVersion)HttpVersion.HTTP_1_1;
/*     */     }
/* 122 */     return (ProtocolVersion)object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setVersion(HttpParams paramHttpParams, ProtocolVersion paramProtocolVersion) {
/* 132 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 133 */     paramHttpParams.setParameter("http.protocol.version", paramProtocolVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getUserAgent(HttpParams paramHttpParams) {
/* 144 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 145 */     return (String)paramHttpParams.getParameter("http.useragent");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setUserAgent(HttpParams paramHttpParams, String paramString) {
/* 155 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 156 */     paramHttpParams.setParameter("http.useragent", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean useExpectContinue(HttpParams paramHttpParams) {
/* 167 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 168 */     return paramHttpParams.getBooleanParameter("http.protocol.expect-continue", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setUseExpectContinue(HttpParams paramHttpParams, boolean paramBoolean) {
/* 178 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 179 */     paramHttpParams.setBooleanParameter("http.protocol.expect-continue", paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CodingErrorAction getMalformedInputAction(HttpParams paramHttpParams) {
/* 190 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 191 */     Object object = paramHttpParams.getParameter("http.malformed.input.action");
/* 192 */     if (object == null)
/*     */     {
/* 194 */       return CodingErrorAction.REPORT;
/*     */     }
/* 196 */     return (CodingErrorAction)object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setMalformedInputAction(HttpParams paramHttpParams, CodingErrorAction paramCodingErrorAction) {
/* 207 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 208 */     paramHttpParams.setParameter("http.malformed.input.action", paramCodingErrorAction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CodingErrorAction getUnmappableInputAction(HttpParams paramHttpParams) {
/* 219 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 220 */     Object object = paramHttpParams.getParameter("http.unmappable.input.action");
/* 221 */     if (object == null)
/*     */     {
/* 223 */       return CodingErrorAction.REPORT;
/*     */     }
/* 225 */     return (CodingErrorAction)object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setUnmappableInputAction(HttpParams paramHttpParams, CodingErrorAction paramCodingErrorAction) {
/* 236 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 237 */     paramHttpParams.setParameter("http.unmappable.input.action", paramCodingErrorAction);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\HttpProtocolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */