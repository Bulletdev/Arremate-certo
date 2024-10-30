/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.client.AuthCache;
/*     */ import org.apache.http.conn.SchemePortResolver;
/*     */ import org.apache.http.conn.UnsupportedSchemeException;
/*     */ import org.apache.http.impl.conn.DefaultSchemePortResolver;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class BasicAuthCache
/*     */   implements AuthCache
/*     */ {
/*  63 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */   
/*     */   private final Map<HttpHost, byte[]> map;
/*     */ 
/*     */   
/*     */   private final SchemePortResolver schemePortResolver;
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicAuthCache(SchemePortResolver paramSchemePortResolver) {
/*  75 */     this.map = (Map)new ConcurrentHashMap<HttpHost, byte>();
/*  76 */     this.schemePortResolver = (paramSchemePortResolver != null) ? paramSchemePortResolver : (SchemePortResolver)DefaultSchemePortResolver.INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   public BasicAuthCache() {
/*  81 */     this(null);
/*     */   }
/*     */   
/*     */   protected HttpHost getKey(HttpHost paramHttpHost) {
/*  85 */     if (paramHttpHost.getPort() <= 0) {
/*     */       int i;
/*     */       try {
/*  88 */         i = this.schemePortResolver.resolve(paramHttpHost);
/*  89 */       } catch (UnsupportedSchemeException unsupportedSchemeException) {
/*  90 */         return paramHttpHost;
/*     */       } 
/*  92 */       return new HttpHost(paramHttpHost.getHostName(), i, paramHttpHost.getSchemeName());
/*     */     } 
/*  94 */     return paramHttpHost;
/*     */   }
/*     */ 
/*     */   
/*     */   public void put(HttpHost paramHttpHost, AuthScheme paramAuthScheme) {
/*  99 */     Args.notNull(paramHttpHost, "HTTP host");
/* 100 */     if (paramAuthScheme == null) {
/*     */       return;
/*     */     }
/* 103 */     if (paramAuthScheme instanceof java.io.Serializable) {
/*     */       try {
/* 105 */         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 106 */         ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
/* 107 */         objectOutputStream.writeObject(paramAuthScheme);
/* 108 */         objectOutputStream.close();
/* 109 */         this.map.put(getKey(paramHttpHost), byteArrayOutputStream.toByteArray());
/* 110 */       } catch (IOException iOException) {
/* 111 */         if (this.log.isWarnEnabled()) {
/* 112 */           this.log.warn("Unexpected I/O error while serializing auth scheme", iOException);
/*     */         }
/*     */       }
/*     */     
/* 116 */     } else if (this.log.isDebugEnabled()) {
/* 117 */       this.log.debug("Auth scheme " + paramAuthScheme.getClass() + " is not serializable");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthScheme get(HttpHost paramHttpHost) {
/* 124 */     Args.notNull(paramHttpHost, "HTTP host");
/* 125 */     byte[] arrayOfByte = this.map.get(getKey(paramHttpHost));
/* 126 */     if (arrayOfByte != null) {
/*     */       try {
/* 128 */         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/* 129 */         ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
/* 130 */         AuthScheme authScheme = (AuthScheme)objectInputStream.readObject();
/* 131 */         objectInputStream.close();
/* 132 */         return authScheme;
/* 133 */       } catch (IOException iOException) {
/* 134 */         if (this.log.isWarnEnabled()) {
/* 135 */           this.log.warn("Unexpected I/O error while de-serializing auth scheme", iOException);
/*     */         }
/* 137 */       } catch (ClassNotFoundException classNotFoundException) {
/* 138 */         if (this.log.isWarnEnabled()) {
/* 139 */           this.log.warn("Unexpected error while de-serializing auth scheme", classNotFoundException);
/*     */         }
/*     */       } 
/*     */     }
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(HttpHost paramHttpHost) {
/* 148 */     Args.notNull(paramHttpHost, "HTTP host");
/* 149 */     this.map.remove(getKey(paramHttpHost));
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 154 */     this.map.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 159 */     return this.map.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\BasicAuthCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */