/*     */ package org.apache.http.conn.scheme;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.LangUtils;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public final class Scheme
/*     */ {
/*     */   private final String name;
/*     */   private final SchemeSocketFactory socketFactory;
/*     */   private final int defaultPort;
/*     */   private final boolean layered;
/*     */   private String stringRep;
/*     */   
/*     */   public Scheme(String paramString, int paramInt, SchemeSocketFactory paramSchemeSocketFactory) {
/*  92 */     Args.notNull(paramString, "Scheme name");
/*  93 */     Args.check((paramInt > 0 && paramInt <= 65535), "Port is invalid");
/*  94 */     Args.notNull(paramSchemeSocketFactory, "Socket factory");
/*  95 */     this.name = paramString.toLowerCase(Locale.ENGLISH);
/*  96 */     this.defaultPort = paramInt;
/*  97 */     if (paramSchemeSocketFactory instanceof SchemeLayeredSocketFactory) {
/*  98 */       this.layered = true;
/*  99 */       this.socketFactory = paramSchemeSocketFactory;
/* 100 */     } else if (paramSchemeSocketFactory instanceof LayeredSchemeSocketFactory) {
/* 101 */       this.layered = true;
/* 102 */       this.socketFactory = new SchemeLayeredSocketFactoryAdaptor2((LayeredSchemeSocketFactory)paramSchemeSocketFactory);
/*     */     } else {
/* 104 */       this.layered = false;
/* 105 */       this.socketFactory = paramSchemeSocketFactory;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Scheme(String paramString, SocketFactory paramSocketFactory, int paramInt) {
/* 127 */     Args.notNull(paramString, "Scheme name");
/* 128 */     Args.notNull(paramSocketFactory, "Socket factory");
/* 129 */     Args.check((paramInt > 0 && paramInt <= 65535), "Port is invalid");
/*     */     
/* 131 */     this.name = paramString.toLowerCase(Locale.ENGLISH);
/* 132 */     if (paramSocketFactory instanceof LayeredSocketFactory) {
/* 133 */       this.socketFactory = new SchemeLayeredSocketFactoryAdaptor((LayeredSocketFactory)paramSocketFactory);
/*     */       
/* 135 */       this.layered = true;
/*     */     } else {
/* 137 */       this.socketFactory = new SchemeSocketFactoryAdaptor(paramSocketFactory);
/* 138 */       this.layered = false;
/*     */     } 
/* 140 */     this.defaultPort = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultPort() {
/* 149 */     return this.defaultPort;
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
/*     */   @Deprecated
/*     */   public SocketFactory getSocketFactory() {
/* 164 */     if (this.socketFactory instanceof SchemeSocketFactoryAdaptor) {
/* 165 */       return ((SchemeSocketFactoryAdaptor)this.socketFactory).getFactory();
/*     */     }
/* 167 */     return this.layered ? new LayeredSocketFactoryAdaptor((LayeredSchemeSocketFactory)this.socketFactory) : new SocketFactoryAdaptor(this.socketFactory);
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
/*     */ 
/*     */   
/*     */   public SchemeSocketFactory getSchemeSocketFactory() {
/* 183 */     return this.socketFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 192 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLayered() {
/* 202 */     return this.layered;
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
/*     */   public int resolvePort(int paramInt) {
/* 215 */     return (paramInt <= 0) ? this.defaultPort : paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 225 */     if (this.stringRep == null) {
/* 226 */       StringBuilder stringBuilder = new StringBuilder();
/* 227 */       stringBuilder.append(this.name);
/* 228 */       stringBuilder.append(':');
/* 229 */       stringBuilder.append(Integer.toString(this.defaultPort));
/* 230 */       this.stringRep = stringBuilder.toString();
/*     */     } 
/* 232 */     return this.stringRep;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 237 */     if (this == paramObject) {
/* 238 */       return true;
/*     */     }
/* 240 */     if (paramObject instanceof Scheme) {
/* 241 */       Scheme scheme = (Scheme)paramObject;
/* 242 */       return (this.name.equals(scheme.name) && this.defaultPort == scheme.defaultPort && this.layered == scheme.layered);
/*     */     } 
/*     */ 
/*     */     
/* 246 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 251 */     int i = 17;
/* 252 */     i = LangUtils.hashCode(i, this.defaultPort);
/* 253 */     i = LangUtils.hashCode(i, this.name);
/* 254 */     i = LangUtils.hashCode(i, this.layered);
/* 255 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\Scheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */