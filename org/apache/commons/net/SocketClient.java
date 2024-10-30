/*     */ package org.apache.commons.net;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketException;
/*     */ import java.nio.charset.Charset;
/*     */ import javax.net.ServerSocketFactory;
/*     */ import javax.net.SocketFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SocketClient
/*     */ {
/*     */   public static final String NETASCII_EOL = "\r\n";
/*  65 */   private static final SocketFactory DEFAULT_SOCKET_FACTORY = SocketFactory.getDefault();
/*     */ 
/*     */ 
/*     */   
/*  69 */   private static final ServerSocketFactory DEFAULT_SERVER_SOCKET_FACTORY = ServerSocketFactory.getDefault();
/*     */ 
/*     */ 
/*     */   
/*     */   private ProtocolCommandSupport commandSupport;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int _timeout_;
/*     */ 
/*     */   
/*     */   protected Socket _socket_;
/*     */ 
/*     */   
/*     */   protected String _hostname_;
/*     */ 
/*     */   
/*     */   protected int _defaultPort_;
/*     */ 
/*     */   
/*     */   protected InputStream _input_;
/*     */ 
/*     */   
/*     */   protected OutputStream _output_;
/*     */ 
/*     */   
/*     */   protected SocketFactory _socketFactory_;
/*     */ 
/*     */   
/*     */   protected ServerSocketFactory _serverSocketFactory_;
/*     */ 
/*     */   
/*     */   private static final int DEFAULT_CONNECT_TIMEOUT = 60000;
/*     */ 
/*     */   
/* 104 */   protected int connectTimeout = 60000;
/*     */ 
/*     */   
/* 107 */   private int receiveBufferSize = -1;
/*     */ 
/*     */   
/* 110 */   private int sendBufferSize = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private Proxy connProxy;
/*     */ 
/*     */ 
/*     */   
/* 118 */   private Charset charset = Charset.defaultCharset();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SocketClient() {
/* 129 */     this._socket_ = null;
/* 130 */     this._hostname_ = null;
/* 131 */     this._input_ = null;
/* 132 */     this._output_ = null;
/* 133 */     this._timeout_ = 0;
/* 134 */     this._defaultPort_ = 0;
/* 135 */     this._socketFactory_ = DEFAULT_SOCKET_FACTORY;
/* 136 */     this._serverSocketFactory_ = DEFAULT_SERVER_SOCKET_FACTORY;
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void _connectAction_() throws IOException {
/* 159 */     applySocketAttributes();
/* 160 */     this._input_ = this._socket_.getInputStream();
/* 161 */     this._output_ = this._socket_.getOutputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applySocketAttributes() throws SocketException {
/* 171 */     this._socket_.setSoTimeout(this._timeout_);
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
/*     */   public void connect(InetAddress paramInetAddress, int paramInt) throws SocketException, IOException {
/* 190 */     this._hostname_ = null;
/* 191 */     _connect(paramInetAddress, paramInt, null, -1);
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
/*     */   public void connect(String paramString, int paramInt) throws SocketException, IOException {
/* 211 */     this._hostname_ = paramString;
/* 212 */     _connect(InetAddress.getByName(paramString), paramInt, null, -1);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws SocketException, IOException {
/* 235 */     this._hostname_ = null;
/* 236 */     _connect(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void _connect(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws SocketException, IOException {
/* 243 */     this._socket_ = this._socketFactory_.createSocket();
/* 244 */     if (this.receiveBufferSize != -1) {
/* 245 */       this._socket_.setReceiveBufferSize(this.receiveBufferSize);
/*     */     }
/* 247 */     if (this.sendBufferSize != -1) {
/* 248 */       this._socket_.setSendBufferSize(this.sendBufferSize);
/*     */     }
/* 250 */     if (paramInetAddress2 != null) {
/* 251 */       this._socket_.bind(new InetSocketAddress(paramInetAddress2, paramInt2));
/*     */     }
/* 253 */     this._socket_.connect(new InetSocketAddress(paramInetAddress1, paramInt1), this.connectTimeout);
/* 254 */     _connectAction_();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws SocketException, IOException {
/* 277 */     this._hostname_ = paramString;
/* 278 */     _connect(InetAddress.getByName(paramString), paramInt1, paramInetAddress, paramInt2);
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
/*     */   public void connect(InetAddress paramInetAddress) throws SocketException, IOException {
/* 296 */     this._hostname_ = null;
/* 297 */     connect(paramInetAddress, this._defaultPort_);
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
/*     */   public void connect(String paramString) throws SocketException, IOException {
/* 316 */     connect(paramString, this._defaultPort_);
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
/*     */   public void disconnect() throws IOException {
/* 332 */     closeQuietly(this._socket_);
/* 333 */     closeQuietly(this._input_);
/* 334 */     closeQuietly(this._output_);
/* 335 */     this._socket_ = null;
/* 336 */     this._hostname_ = null;
/* 337 */     this._input_ = null;
/* 338 */     this._output_ = null;
/*     */   }
/*     */   
/*     */   private void closeQuietly(Socket paramSocket) {
/* 342 */     if (paramSocket != null) {
/*     */       try {
/* 344 */         paramSocket.close();
/* 345 */       } catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void closeQuietly(Closeable paramCloseable) {
/* 352 */     if (paramCloseable != null) {
/*     */       try {
/* 354 */         paramCloseable.close();
/* 355 */       } catch (IOException iOException) {}
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
/*     */   public boolean isConnected() {
/* 369 */     if (this._socket_ == null) {
/* 370 */       return false;
/*     */     }
/*     */     
/* 373 */     return this._socket_.isConnected();
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
/*     */   public boolean isAvailable() {
/* 386 */     if (isConnected()) {
/*     */       
/*     */       try {
/* 389 */         if (this._socket_.getInetAddress() == null) {
/* 390 */           return false;
/*     */         }
/* 392 */         if (this._socket_.getPort() == 0) {
/* 393 */           return false;
/*     */         }
/* 395 */         if (this._socket_.getRemoteSocketAddress() == null) {
/* 396 */           return false;
/*     */         }
/* 398 */         if (this._socket_.isClosed()) {
/* 399 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 404 */         if (this._socket_.isInputShutdown()) {
/* 405 */           return false;
/*     */         }
/* 407 */         if (this._socket_.isOutputShutdown()) {
/* 408 */           return false;
/*     */         }
/*     */ 
/*     */         
/* 412 */         this._socket_.getInputStream();
/*     */         
/* 414 */         this._socket_.getOutputStream();
/*     */       }
/* 416 */       catch (IOException iOException) {
/*     */         
/* 418 */         return false;
/*     */       } 
/* 420 */       return true;
/*     */     } 
/* 422 */     return false;
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
/*     */   public void setDefaultPort(int paramInt) {
/* 435 */     this._defaultPort_ = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultPort() {
/* 446 */     return this._defaultPort_;
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
/*     */   public void setDefaultTimeout(int paramInt) {
/* 463 */     this._timeout_ = paramInt;
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
/*     */   public int getDefaultTimeout() {
/* 476 */     return this._timeout_;
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
/*     */   public void setSoTimeout(int paramInt) throws SocketException {
/* 494 */     this._socket_.setSoTimeout(paramInt);
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
/*     */   public void setSendBufferSize(int paramInt) throws SocketException {
/* 506 */     this.sendBufferSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getSendBufferSize() {
/* 515 */     return this.sendBufferSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReceiveBufferSize(int paramInt) throws SocketException {
/* 526 */     this.receiveBufferSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getReceiveBufferSize() {
/* 535 */     return this.receiveBufferSize;
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
/*     */   public int getSoTimeout() throws SocketException {
/* 547 */     return this._socket_.getSoTimeout();
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
/*     */   public void setTcpNoDelay(boolean paramBoolean) throws SocketException {
/* 560 */     this._socket_.setTcpNoDelay(paramBoolean);
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
/*     */   public boolean getTcpNoDelay() throws SocketException {
/* 575 */     return this._socket_.getTcpNoDelay();
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
/*     */   public void setKeepAlive(boolean paramBoolean) throws SocketException {
/* 591 */     this._socket_.setKeepAlive(paramBoolean);
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
/*     */   public boolean getKeepAlive() throws SocketException {
/* 603 */     return this._socket_.getKeepAlive();
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
/*     */   public void setSoLinger(boolean paramBoolean, int paramInt) throws SocketException {
/* 616 */     this._socket_.setSoLinger(paramBoolean, paramInt);
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
/*     */   public int getSoLinger() throws SocketException {
/* 630 */     return this._socket_.getSoLinger();
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
/*     */   public int getLocalPort() {
/* 645 */     return this._socket_.getLocalPort();
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
/*     */   public InetAddress getLocalAddress() {
/* 658 */     return this._socket_.getLocalAddress();
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
/*     */   public int getRemotePort() {
/* 672 */     return this._socket_.getPort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 683 */     return this._socket_.getInetAddress();
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
/*     */   public boolean verifyRemote(Socket paramSocket) {
/* 702 */     InetAddress inetAddress1 = paramSocket.getInetAddress();
/* 703 */     InetAddress inetAddress2 = getRemoteAddress();
/*     */     
/* 705 */     return inetAddress1.equals(inetAddress2);
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
/*     */   public void setSocketFactory(SocketFactory paramSocketFactory) {
/* 720 */     if (paramSocketFactory == null) {
/* 721 */       this._socketFactory_ = DEFAULT_SOCKET_FACTORY;
/*     */     } else {
/* 723 */       this._socketFactory_ = paramSocketFactory;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 728 */     this.connProxy = null;
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
/*     */   public void setServerSocketFactory(ServerSocketFactory paramServerSocketFactory) {
/* 741 */     if (paramServerSocketFactory == null) {
/* 742 */       this._serverSocketFactory_ = DEFAULT_SERVER_SOCKET_FACTORY;
/*     */     } else {
/* 744 */       this._serverSocketFactory_ = paramServerSocketFactory;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConnectTimeout(int paramInt) {
/* 755 */     this.connectTimeout = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConnectTimeout() {
/* 764 */     return this.connectTimeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServerSocketFactory getServerSocketFactory() {
/* 773 */     return this._serverSocketFactory_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProtocolCommandListener(ProtocolCommandListener paramProtocolCommandListener) {
/* 784 */     getCommandSupport().addProtocolCommandListener(paramProtocolCommandListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeProtocolCommandListener(ProtocolCommandListener paramProtocolCommandListener) {
/* 794 */     getCommandSupport().removeProtocolCommandListener(paramProtocolCommandListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fireReplyReceived(int paramInt, String paramString) {
/* 805 */     if (getCommandSupport().getListenerCount() > 0) {
/* 806 */       getCommandSupport().fireReplyReceived(paramInt, paramString);
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
/*     */   protected void fireCommandSent(String paramString1, String paramString2) {
/* 818 */     if (getCommandSupport().getListenerCount() > 0) {
/* 819 */       getCommandSupport().fireCommandSent(paramString1, paramString2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createCommandSupport() {
/* 827 */     this.commandSupport = new ProtocolCommandSupport(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ProtocolCommandSupport getCommandSupport() {
/* 838 */     return this.commandSupport;
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
/*     */   public void setProxy(Proxy paramProxy) {
/* 850 */     setSocketFactory(new DefaultSocketFactory(paramProxy));
/* 851 */     this.connProxy = paramProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Proxy getProxy() {
/* 859 */     return this.connProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String getCharsetName() {
/* 871 */     return this.charset.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 881 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharset(Charset paramCharset) {
/* 891 */     this.charset = paramCharset;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\SocketClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */