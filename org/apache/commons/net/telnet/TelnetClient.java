/*     */ package org.apache.commons.net.telnet;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TelnetClient
/*     */   extends Telnet
/*     */ {
/*     */   private static final int DEFAULT_MAX_SUBNEGOTIATION_LENGTH = 512;
/*     */   final int maxSubnegotiationLength;
/*     */   private InputStream input;
/*     */   private OutputStream output;
/*     */   protected boolean readerThread = true;
/*     */   private TelnetInputListener inputListener;
/*     */   
/*     */   public TelnetClient() {
/*  59 */     this("VT100", 512);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TelnetClient(String paramString) {
/*  69 */     this(paramString, 512);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TelnetClient(int paramInt) {
/*  80 */     this("VT100", paramInt);
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
/*     */   public TelnetClient(String paramString, int paramInt) {
/*  94 */     super(paramString);
/*     */     
/*  96 */     this.input = null;
/*  97 */     this.output = null;
/*  98 */     this.maxSubnegotiationLength = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   void flushOutputStream() throws IOException {
/* 103 */     if (this._output_ == null) {
/* 104 */       throw new IOException("Stream closed");
/*     */     }
/* 106 */     this._output_.flush();
/*     */   }
/*     */   
/*     */   void closeOutputStream() throws IOException {
/* 110 */     if (this._output_ == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 114 */       this._output_.close();
/*     */     } finally {
/* 116 */       this._output_ = null;
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
/*     */   protected void _connectAction_() throws IOException {
/* 128 */     super._connectAction_();
/* 129 */     TelnetInputStream telnetInputStream = new TelnetInputStream(this._input_, this, this.readerThread);
/* 130 */     if (this.readerThread)
/*     */     {
/* 132 */       telnetInputStream.start();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     this.input = new BufferedInputStream(telnetInputStream);
/* 141 */     this.output = new TelnetOutputStream(this);
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
/*     */   public void disconnect() throws IOException {
/*     */     try {
/* 155 */       if (this.input != null) {
/* 156 */         this.input.close();
/*     */       }
/* 158 */       if (this.output != null) {
/* 159 */         this.output.close();
/*     */       }
/*     */     } finally {
/* 162 */       this.output = null;
/* 163 */       this.input = null;
/* 164 */       super.disconnect();
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
/*     */   public OutputStream getOutputStream() {
/* 177 */     return this.output;
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
/*     */   public InputStream getInputStream() {
/* 189 */     return this.input;
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
/*     */   public boolean getLocalOptionState(int paramInt) {
/* 202 */     return (stateIsWill(paramInt) && requestedWill(paramInt));
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
/*     */   public boolean getRemoteOptionState(int paramInt) {
/* 216 */     return (stateIsDo(paramInt) && requestedDo(paramInt));
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
/*     */   public boolean sendAYT(long paramLong) throws IOException, IllegalArgumentException, InterruptedException {
/* 237 */     return _sendAYT(paramLong);
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
/*     */   
/*     */   public void sendSubnegotiation(int[] paramArrayOfint) throws IOException, IllegalArgumentException {
/* 261 */     if (paramArrayOfint.length < 1) {
/* 262 */       throw new IllegalArgumentException("zero length message");
/*     */     }
/* 264 */     _sendSubnegotiation(paramArrayOfint);
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
/*     */   public void sendCommand(byte paramByte) throws IOException, IllegalArgumentException {
/* 284 */     _sendCommand(paramByte);
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
/*     */   public void addOptionHandler(TelnetOptionHandler paramTelnetOptionHandler) throws InvalidTelnetOptionException, IOException {
/* 301 */     super.addOptionHandler(paramTelnetOptionHandler);
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
/*     */   public void deleteOptionHandler(int paramInt) throws InvalidTelnetOptionException, IOException {
/* 317 */     super.deleteOptionHandler(paramInt);
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
/*     */   public void registerSpyStream(OutputStream paramOutputStream) {
/* 330 */     _registerSpyStream(paramOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopSpyStream() {
/* 339 */     _stopSpyStream();
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
/*     */   public void registerNotifHandler(TelnetNotificationHandler paramTelnetNotificationHandler) {
/* 352 */     super.registerNotifHandler(paramTelnetNotificationHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterNotifHandler() {
/* 362 */     super.unregisterNotifHandler();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReaderThread(boolean paramBoolean) {
/* 393 */     this.readerThread = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getReaderThread() {
/* 403 */     return this.readerThread;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void registerInputListener(TelnetInputListener paramTelnetInputListener) {
/* 430 */     this.inputListener = paramTelnetInputListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void unregisterInputListener() {
/* 440 */     this.inputListener = null;
/*     */   }
/*     */ 
/*     */   
/*     */   void notifyInputListener() {
/*     */     TelnetInputListener telnetInputListener;
/* 446 */     synchronized (this) {
/* 447 */       telnetInputListener = this.inputListener;
/*     */     } 
/* 449 */     if (telnetInputListener != null)
/* 450 */       telnetInputListener.telnetInputAvailable(); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\TelnetClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */