/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.BindException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.security.CipherFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NetUtils
/*     */ {
/*     */   private static final int CACHE_MILLIS = 1000;
/*     */   private static InetAddress cachedBindAddress;
/*     */   private static String cachedLocalAddress;
/*     */   private static long cachedLocalAddressTime;
/*     */   
/*     */   public static Socket createLoopbackSocket(int paramInt, boolean paramBoolean) throws IOException {
/*  46 */     InetAddress inetAddress = getBindAddress();
/*  47 */     if (inetAddress == null) {
/*  48 */       inetAddress = InetAddress.getLocalHost();
/*     */     }
/*     */     try {
/*  51 */       return createSocket(getHostAddress(inetAddress), paramInt, paramBoolean);
/*  52 */     } catch (IOException iOException) {
/*     */       try {
/*  54 */         return createSocket("localhost", paramInt, paramBoolean);
/*  55 */       } catch (IOException iOException1) {
/*     */         
/*  57 */         throw iOException;
/*     */       } 
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
/*     */   private static String getHostAddress(InetAddress paramInetAddress) {
/*  70 */     String str = paramInetAddress.getHostAddress();
/*  71 */     if (paramInetAddress instanceof java.net.Inet6Address && 
/*  72 */       str.indexOf(':') >= 0 && !str.startsWith("[")) {
/*  73 */       str = "[" + str + "]";
/*     */     }
/*     */     
/*  76 */     return str;
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
/*     */   public static Socket createSocket(String paramString, int paramInt, boolean paramBoolean) throws IOException {
/*  90 */     int i = paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     boolean bool = paramString.startsWith("[") ? paramString.indexOf(']') : false;
/*  96 */     int j = paramString.indexOf(':', bool);
/*  97 */     if (j >= 0) {
/*  98 */       i = Integer.decode(paramString.substring(j + 1)).intValue();
/*  99 */       paramString = paramString.substring(0, j);
/*     */     } 
/* 101 */     InetAddress inetAddress = InetAddress.getByName(paramString);
/* 102 */     return createSocket(inetAddress, i, paramBoolean);
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
/*     */   public static Socket createSocket(InetAddress paramInetAddress, int paramInt, boolean paramBoolean) throws IOException {
/* 115 */     long l = System.currentTimeMillis();
/* 116 */     for (byte b = 0;; b++) {
/*     */       try {
/* 118 */         if (paramBoolean) {
/* 119 */           return CipherFactory.createSocket(paramInetAddress, paramInt);
/*     */         }
/* 121 */         Socket socket = new Socket();
/* 122 */         socket.connect(new InetSocketAddress(paramInetAddress, paramInt), SysProperties.SOCKET_CONNECT_TIMEOUT);
/*     */         
/* 124 */         return socket;
/* 125 */       } catch (IOException iOException) {
/* 126 */         if (System.currentTimeMillis() - l >= SysProperties.SOCKET_CONNECT_TIMEOUT)
/*     */         {
/*     */ 
/*     */           
/* 130 */           throw iOException;
/*     */         }
/* 132 */         if (b >= SysProperties.SOCKET_CONNECT_RETRY) {
/* 133 */           throw iOException;
/*     */         }
/*     */ 
/*     */         
/*     */         try {
/* 138 */           long l1 = Math.min(256, b * b);
/* 139 */           Thread.sleep(l1);
/* 140 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
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
/*     */   public static ServerSocket createServerSocket(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 162 */       return createServerSocketTry(paramInt, paramBoolean);
/* 163 */     } catch (Exception exception) {
/*     */       
/* 165 */       return createServerSocketTry(paramInt, paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static InetAddress getBindAddress() throws UnknownHostException {
/* 176 */     String str = SysProperties.BIND_ADDRESS;
/* 177 */     if (str == null || str.length() == 0) {
/* 178 */       return null;
/*     */     }
/* 180 */     synchronized (NetUtils.class) {
/* 181 */       if (cachedBindAddress == null) {
/* 182 */         cachedBindAddress = InetAddress.getByName(str);
/*     */       }
/*     */     } 
/* 185 */     return cachedBindAddress;
/*     */   }
/*     */   
/*     */   private static ServerSocket createServerSocketTry(int paramInt, boolean paramBoolean) {
/*     */     try {
/* 190 */       InetAddress inetAddress = getBindAddress();
/* 191 */       if (paramBoolean) {
/* 192 */         return CipherFactory.createServerSocket(paramInt, inetAddress);
/*     */       }
/* 194 */       if (inetAddress == null) {
/* 195 */         return new ServerSocket(paramInt);
/*     */       }
/* 197 */       return new ServerSocket(paramInt, 0, inetAddress);
/* 198 */     } catch (BindException bindException) {
/* 199 */       throw DbException.get(90061, bindException, new String[] { "" + paramInt, bindException.toString() });
/*     */     }
/* 201 */     catch (IOException iOException) {
/* 202 */       throw DbException.convertIOException(iOException, "port: " + paramInt + " ssl: " + paramBoolean);
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
/*     */   public static boolean isLocalAddress(Socket paramSocket) throws UnknownHostException {
/* 214 */     InetAddress inetAddress1 = paramSocket.getInetAddress();
/* 215 */     if (inetAddress1.isLoopbackAddress()) {
/* 216 */       return true;
/*     */     }
/* 218 */     InetAddress inetAddress2 = InetAddress.getLocalHost();
/*     */     
/* 220 */     String str = inetAddress2.getHostAddress();
/* 221 */     for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
/* 222 */       if (inetAddress1.equals(inetAddress)) {
/* 223 */         return true;
/*     */       }
/*     */     } 
/* 226 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ServerSocket closeSilently(ServerSocket paramServerSocket) {
/* 236 */     if (paramServerSocket != null) {
/*     */       try {
/* 238 */         paramServerSocket.close();
/* 239 */       } catch (IOException iOException) {}
/*     */     }
/*     */ 
/*     */     
/* 243 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized String getLocalAddress() {
/* 253 */     long l = System.currentTimeMillis();
/* 254 */     if (cachedLocalAddress != null && 
/* 255 */       cachedLocalAddressTime + 1000L > l) {
/* 256 */       return cachedLocalAddress;
/*     */     }
/*     */     
/* 259 */     InetAddress inetAddress = null;
/* 260 */     boolean bool = false;
/*     */     try {
/* 262 */       inetAddress = getBindAddress();
/* 263 */       if (inetAddress == null) {
/* 264 */         bool = true;
/*     */       }
/* 266 */     } catch (UnknownHostException unknownHostException) {}
/*     */ 
/*     */     
/* 269 */     if (bool) {
/*     */       try {
/* 271 */         inetAddress = InetAddress.getLocalHost();
/* 272 */       } catch (UnknownHostException unknownHostException) {
/* 273 */         throw DbException.convert(unknownHostException);
/*     */       } 
/*     */     }
/* 276 */     String str = (inetAddress == null) ? "localhost" : getHostAddress(inetAddress);
/* 277 */     if (str.equals("127.0.0.1")) {
/* 278 */       str = "localhost";
/*     */     }
/* 280 */     cachedLocalAddress = str;
/* 281 */     cachedLocalAddressTime = l;
/* 282 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getHostName(String paramString) {
/*     */     try {
/* 293 */       InetAddress inetAddress = InetAddress.getByName(paramString);
/* 294 */       return inetAddress.getHostName();
/* 295 */     } catch (Exception exception) {
/* 296 */       return "unknown";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\NetUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */