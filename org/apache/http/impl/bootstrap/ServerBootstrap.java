/*     */ package org.apache.http.impl.bootstrap;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import javax.net.ServerSocketFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.ExceptionLogger;
/*     */ import org.apache.http.HttpConnectionFactory;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponseFactory;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.config.ConnectionConfig;
/*     */ import org.apache.http.config.SocketConfig;
/*     */ import org.apache.http.impl.DefaultBHttpServerConnection;
/*     */ import org.apache.http.impl.DefaultBHttpServerConnectionFactory;
/*     */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*     */ import org.apache.http.impl.DefaultHttpResponseFactory;
/*     */ import org.apache.http.protocol.HttpExpectationVerifier;
/*     */ import org.apache.http.protocol.HttpProcessor;
/*     */ import org.apache.http.protocol.HttpProcessorBuilder;
/*     */ import org.apache.http.protocol.HttpRequestHandler;
/*     */ import org.apache.http.protocol.HttpRequestHandlerMapper;
/*     */ import org.apache.http.protocol.HttpService;
/*     */ import org.apache.http.protocol.ResponseConnControl;
/*     */ import org.apache.http.protocol.ResponseContent;
/*     */ import org.apache.http.protocol.ResponseDate;
/*     */ import org.apache.http.protocol.ResponseServer;
/*     */ import org.apache.http.protocol.UriHttpRequestHandlerMapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServerBootstrap
/*     */ {
/*     */   private int listenerPort;
/*     */   private InetAddress localAddress;
/*     */   private SocketConfig socketConfig;
/*     */   private ConnectionConfig connectionConfig;
/*     */   private LinkedList<HttpRequestInterceptor> requestFirst;
/*     */   private LinkedList<HttpRequestInterceptor> requestLast;
/*     */   private LinkedList<HttpResponseInterceptor> responseFirst;
/*     */   private LinkedList<HttpResponseInterceptor> responseLast;
/*     */   private String serverInfo;
/*     */   private HttpProcessor httpProcessor;
/*     */   private ConnectionReuseStrategy connStrategy;
/*     */   private HttpResponseFactory responseFactory;
/*     */   private HttpRequestHandlerMapper handlerMapper;
/*     */   private Map<String, HttpRequestHandler> handlerMap;
/*     */   private HttpExpectationVerifier expectationVerifier;
/*     */   private ServerSocketFactory serverSocketFactory;
/*     */   private SSLContext sslContext;
/*     */   private SSLServerSetupHandler sslSetupHandler;
/*     */   private HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
/*     */   private ExceptionLogger exceptionLogger;
/*     */   
/*     */   public static ServerBootstrap bootstrap() {
/*  91 */     return new ServerBootstrap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setListenerPort(int paramInt) {
/* 100 */     this.listenerPort = paramInt;
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setLocalAddress(InetAddress paramInetAddress) {
/* 110 */     this.localAddress = paramInetAddress;
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setSocketConfig(SocketConfig paramSocketConfig) {
/* 120 */     this.socketConfig = paramSocketConfig;
/* 121 */     return this;
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
/*     */   public final ServerBootstrap setConnectionConfig(ConnectionConfig paramConnectionConfig) {
/* 134 */     this.connectionConfig = paramConnectionConfig;
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setHttpProcessor(HttpProcessor paramHttpProcessor) {
/* 144 */     this.httpProcessor = paramHttpProcessor;
/* 145 */     return this;
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
/*     */   public final ServerBootstrap addInterceptorFirst(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 158 */     if (paramHttpResponseInterceptor == null) {
/* 159 */       return this;
/*     */     }
/* 161 */     if (this.responseFirst == null) {
/* 162 */       this.responseFirst = new LinkedList<HttpResponseInterceptor>();
/*     */     }
/* 164 */     this.responseFirst.addFirst(paramHttpResponseInterceptor);
/* 165 */     return this;
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
/*     */   public final ServerBootstrap addInterceptorLast(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 178 */     if (paramHttpResponseInterceptor == null) {
/* 179 */       return this;
/*     */     }
/* 181 */     if (this.responseLast == null) {
/* 182 */       this.responseLast = new LinkedList<HttpResponseInterceptor>();
/*     */     }
/* 184 */     this.responseLast.addLast(paramHttpResponseInterceptor);
/* 185 */     return this;
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
/*     */   public final ServerBootstrap addInterceptorFirst(HttpRequestInterceptor paramHttpRequestInterceptor) {
/* 198 */     if (paramHttpRequestInterceptor == null) {
/* 199 */       return this;
/*     */     }
/* 201 */     if (this.requestFirst == null) {
/* 202 */       this.requestFirst = new LinkedList<HttpRequestInterceptor>();
/*     */     }
/* 204 */     this.requestFirst.addFirst(paramHttpRequestInterceptor);
/* 205 */     return this;
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
/*     */   public final ServerBootstrap addInterceptorLast(HttpRequestInterceptor paramHttpRequestInterceptor) {
/* 218 */     if (paramHttpRequestInterceptor == null) {
/* 219 */       return this;
/*     */     }
/* 221 */     if (this.requestLast == null) {
/* 222 */       this.requestLast = new LinkedList<HttpRequestInterceptor>();
/*     */     }
/* 224 */     this.requestLast.addLast(paramHttpRequestInterceptor);
/* 225 */     return this;
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
/*     */   public final ServerBootstrap setServerInfo(String paramString) {
/* 238 */     this.serverInfo = paramString;
/* 239 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy paramConnectionReuseStrategy) {
/* 248 */     this.connStrategy = paramConnectionReuseStrategy;
/* 249 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setResponseFactory(HttpResponseFactory paramHttpResponseFactory) {
/* 258 */     this.responseFactory = paramHttpResponseFactory;
/* 259 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setHandlerMapper(HttpRequestHandlerMapper paramHttpRequestHandlerMapper) {
/* 268 */     this.handlerMapper = paramHttpRequestHandlerMapper;
/* 269 */     return this;
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
/*     */   public final ServerBootstrap registerHandler(String paramString, HttpRequestHandler paramHttpRequestHandler) {
/* 285 */     if (paramString == null || paramHttpRequestHandler == null) {
/* 286 */       return this;
/*     */     }
/* 288 */     if (this.handlerMap == null) {
/* 289 */       this.handlerMap = new HashMap<String, HttpRequestHandler>();
/*     */     }
/* 291 */     this.handlerMap.put(paramString, paramHttpRequestHandler);
/* 292 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setExpectationVerifier(HttpExpectationVerifier paramHttpExpectationVerifier) {
/* 301 */     this.expectationVerifier = paramHttpExpectationVerifier;
/* 302 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setConnectionFactory(HttpConnectionFactory<? extends DefaultBHttpServerConnection> paramHttpConnectionFactory) {
/* 312 */     this.connectionFactory = paramHttpConnectionFactory;
/* 313 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setSslSetupHandler(SSLServerSetupHandler paramSSLServerSetupHandler) {
/* 322 */     this.sslSetupHandler = paramSSLServerSetupHandler;
/* 323 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setServerSocketFactory(ServerSocketFactory paramServerSocketFactory) {
/* 332 */     this.serverSocketFactory = paramServerSocketFactory;
/* 333 */     return this;
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
/*     */   public final ServerBootstrap setSslContext(SSLContext paramSSLContext) {
/* 346 */     this.sslContext = paramSSLContext;
/* 347 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ServerBootstrap setExceptionLogger(ExceptionLogger paramExceptionLogger) {
/* 356 */     this.exceptionLogger = paramExceptionLogger;
/* 357 */     return this; } public HttpServer create() {
/*     */     UriHttpRequestHandlerMapper uriHttpRequestHandlerMapper;
/*     */     DefaultConnectionReuseStrategy defaultConnectionReuseStrategy;
/*     */     DefaultHttpResponseFactory defaultHttpResponseFactory;
/*     */     DefaultBHttpServerConnectionFactory defaultBHttpServerConnectionFactory;
/* 362 */     HttpProcessor httpProcessor = this.httpProcessor;
/* 363 */     if (httpProcessor == null) {
/*     */       
/* 365 */       HttpProcessorBuilder httpProcessorBuilder = HttpProcessorBuilder.create();
/* 366 */       if (this.requestFirst != null) {
/* 367 */         for (HttpRequestInterceptor httpRequestInterceptor : this.requestFirst) {
/* 368 */           httpProcessorBuilder.addFirst(httpRequestInterceptor);
/*     */         }
/*     */       }
/* 371 */       if (this.responseFirst != null) {
/* 372 */         for (HttpResponseInterceptor httpResponseInterceptor : this.responseFirst) {
/* 373 */           httpProcessorBuilder.addFirst(httpResponseInterceptor);
/*     */         }
/*     */       }
/*     */       
/* 377 */       String str = this.serverInfo;
/* 378 */       if (str == null) {
/* 379 */         str = "Apache-HttpCore/1.1";
/*     */       }
/*     */       
/* 382 */       httpProcessorBuilder.addAll(new HttpResponseInterceptor[] { (HttpResponseInterceptor)new ResponseDate(), (HttpResponseInterceptor)new ResponseServer(str), (HttpResponseInterceptor)new ResponseContent(), (HttpResponseInterceptor)new ResponseConnControl() });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 387 */       if (this.requestLast != null) {
/* 388 */         for (HttpRequestInterceptor httpRequestInterceptor : this.requestLast) {
/* 389 */           httpProcessorBuilder.addLast(httpRequestInterceptor);
/*     */         }
/*     */       }
/* 392 */       if (this.responseLast != null) {
/* 393 */         for (HttpResponseInterceptor httpResponseInterceptor : this.responseLast) {
/* 394 */           httpProcessorBuilder.addLast(httpResponseInterceptor);
/*     */         }
/*     */       }
/* 397 */       httpProcessor = httpProcessorBuilder.build();
/*     */     } 
/*     */     
/* 400 */     HttpRequestHandlerMapper httpRequestHandlerMapper = this.handlerMapper;
/* 401 */     if (httpRequestHandlerMapper == null) {
/* 402 */       UriHttpRequestHandlerMapper uriHttpRequestHandlerMapper1 = new UriHttpRequestHandlerMapper();
/* 403 */       if (this.handlerMap != null) {
/* 404 */         for (Map.Entry<String, HttpRequestHandler> entry : this.handlerMap.entrySet()) {
/* 405 */           uriHttpRequestHandlerMapper1.register((String)entry.getKey(), (HttpRequestHandler)entry.getValue());
/*     */         }
/*     */       }
/* 408 */       uriHttpRequestHandlerMapper = uriHttpRequestHandlerMapper1;
/*     */     } 
/*     */     
/* 411 */     ConnectionReuseStrategy connectionReuseStrategy = this.connStrategy;
/* 412 */     if (connectionReuseStrategy == null) {
/* 413 */       defaultConnectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
/*     */     }
/*     */     
/* 416 */     HttpResponseFactory httpResponseFactory = this.responseFactory;
/* 417 */     if (httpResponseFactory == null) {
/* 418 */       defaultHttpResponseFactory = DefaultHttpResponseFactory.INSTANCE;
/*     */     }
/*     */     
/* 421 */     HttpService httpService = new HttpService(httpProcessor, (ConnectionReuseStrategy)defaultConnectionReuseStrategy, (HttpResponseFactory)defaultHttpResponseFactory, (HttpRequestHandlerMapper)uriHttpRequestHandlerMapper, this.expectationVerifier);
/*     */ 
/*     */ 
/*     */     
/* 425 */     ServerSocketFactory serverSocketFactory = this.serverSocketFactory;
/* 426 */     if (serverSocketFactory == null) {
/* 427 */       if (this.sslContext != null) {
/* 428 */         serverSocketFactory = this.sslContext.getServerSocketFactory();
/*     */       } else {
/* 430 */         serverSocketFactory = ServerSocketFactory.getDefault();
/*     */       } 
/*     */     }
/*     */     
/* 434 */     HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory = this.connectionFactory;
/* 435 */     if (httpConnectionFactory == null) {
/* 436 */       if (this.connectionConfig != null) {
/* 437 */         defaultBHttpServerConnectionFactory = new DefaultBHttpServerConnectionFactory(this.connectionConfig);
/*     */       } else {
/* 439 */         defaultBHttpServerConnectionFactory = DefaultBHttpServerConnectionFactory.INSTANCE;
/*     */       } 
/*     */     }
/*     */     
/* 443 */     ExceptionLogger exceptionLogger = this.exceptionLogger;
/* 444 */     if (exceptionLogger == null) {
/* 445 */       exceptionLogger = ExceptionLogger.NO_OP;
/*     */     }
/*     */     
/* 448 */     return new HttpServer((this.listenerPort > 0) ? this.listenerPort : 0, this.localAddress, (this.socketConfig != null) ? this.socketConfig : SocketConfig.DEFAULT, serverSocketFactory, httpService, (HttpConnectionFactory<? extends DefaultBHttpServerConnection>)defaultBHttpServerConnectionFactory, this.sslSetupHandler, exceptionLogger);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\bootstrap\ServerBootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */