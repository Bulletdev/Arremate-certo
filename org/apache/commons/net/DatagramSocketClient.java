/*     */ package org.apache.commons.net;
/*     */ 
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.InetAddress;
/*     */ import java.net.SocketException;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DatagramSocketClient
/*     */ {
/*  56 */   private static final DatagramSocketFactory DEFAULT_SOCKET_FACTORY = new DefaultDatagramSocketFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private Charset charset = Charset.defaultCharset();
/*     */ 
/*     */ 
/*     */   
/*     */   protected int _timeout_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected DatagramSocket _socket_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean _isOpen_;
/*     */ 
/*     */ 
/*     */   
/*     */   protected DatagramSocketFactory _socketFactory_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DatagramSocketClient() {
/*  84 */     this._socket_ = null;
/*  85 */     this._timeout_ = 0;
/*  86 */     this._isOpen_ = false;
/*  87 */     this._socketFactory_ = DEFAULT_SOCKET_FACTORY;
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
/*     */   public void open() throws SocketException {
/* 104 */     this._socket_ = this._socketFactory_.createDatagramSocket();
/* 105 */     this._socket_.setSoTimeout(this._timeout_);
/* 106 */     this._isOpen_ = true;
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
/*     */   public void open(int paramInt) throws SocketException {
/* 124 */     this._socket_ = this._socketFactory_.createDatagramSocket(paramInt);
/* 125 */     this._socket_.setSoTimeout(this._timeout_);
/* 126 */     this._isOpen_ = true;
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
/*     */   public void open(int paramInt, InetAddress paramInetAddress) throws SocketException {
/* 146 */     this._socket_ = this._socketFactory_.createDatagramSocket(paramInt, paramInetAddress);
/* 147 */     this._socket_.setSoTimeout(this._timeout_);
/* 148 */     this._isOpen_ = true;
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
/*     */   public void close() {
/* 161 */     if (this._socket_ != null) {
/* 162 */       this._socket_.close();
/*     */     }
/* 164 */     this._socket_ = null;
/* 165 */     this._isOpen_ = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 176 */     return this._isOpen_;
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
/* 193 */     this._timeout_ = paramInt;
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
/* 206 */     return this._timeout_;
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
/*     */   public void setSoTimeout(int paramInt) throws SocketException {
/* 221 */     this._socket_.setSoTimeout(paramInt);
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
/*     */   public int getSoTimeout() throws SocketException {
/* 235 */     return this._socket_.getSoTimeout();
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
/*     */   public int getLocalPort() {
/* 249 */     return this._socket_.getLocalPort();
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
/* 262 */     return this._socket_.getLocalAddress();
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
/*     */   public void setDatagramSocketFactory(DatagramSocketFactory paramDatagramSocketFactory) {
/* 277 */     if (paramDatagramSocketFactory == null) {
/* 278 */       this._socketFactory_ = DEFAULT_SOCKET_FACTORY;
/*     */     } else {
/* 280 */       this._socketFactory_ = paramDatagramSocketFactory;
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
/*     */   @Deprecated
/*     */   public String getCharsetName() {
/* 293 */     return this.charset.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 303 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharset(Charset paramCharset) {
/* 313 */     this.charset = paramCharset;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\DatagramSocketClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */