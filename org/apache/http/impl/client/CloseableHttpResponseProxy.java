/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ class CloseableHttpResponseProxy
/*     */   implements InvocationHandler
/*     */ {
/*     */   private static final Constructor<?> CONSTRUCTOR;
/*     */   private final HttpResponse original;
/*     */   
/*     */   static {
/*     */     try {
/*  52 */       CONSTRUCTOR = Proxy.getProxyClass(CloseableHttpResponseProxy.class.getClassLoader(), new Class[] { CloseableHttpResponse.class }).getConstructor(new Class[] { InvocationHandler.class });
/*     */     }
/*  54 */     catch (NoSuchMethodException noSuchMethodException) {
/*  55 */       throw new IllegalStateException(noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CloseableHttpResponseProxy(HttpResponse paramHttpResponse) {
/*  63 */     this.original = paramHttpResponse;
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/*  67 */     HttpEntity httpEntity = this.original.getEntity();
/*  68 */     EntityUtils.consume(httpEntity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable {
/*  74 */     String str = paramMethod.getName();
/*  75 */     if (str.equals("close")) {
/*  76 */       close();
/*  77 */       return null;
/*     */     } 
/*     */     try {
/*  80 */       return paramMethod.invoke(this.original, paramArrayOfObject);
/*  81 */     } catch (InvocationTargetException invocationTargetException) {
/*  82 */       Throwable throwable = invocationTargetException.getCause();
/*  83 */       if (throwable != null) {
/*  84 */         throw throwable;
/*     */       }
/*  86 */       throw invocationTargetException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CloseableHttpResponse newProxy(HttpResponse paramHttpResponse) {
/*     */     try {
/*  94 */       return (CloseableHttpResponse)CONSTRUCTOR.newInstance(new Object[] { new CloseableHttpResponseProxy(paramHttpResponse) });
/*  95 */     } catch (InstantiationException instantiationException) {
/*  96 */       throw new IllegalStateException(instantiationException);
/*  97 */     } catch (InvocationTargetException invocationTargetException) {
/*  98 */       throw new IllegalStateException(invocationTargetException);
/*  99 */     } catch (IllegalAccessException illegalAccessException) {
/* 100 */       throw new IllegalStateException(illegalAccessException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\CloseableHttpResponseProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */