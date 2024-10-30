/*     */ package ch.qos.logback.core;
/*     */ 
/*     */ import ch.qos.logback.core.encoder.Encoder;
/*     */ import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
/*     */ import ch.qos.logback.core.spi.DeferredProcessingAware;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OutputStreamAppender<E>
/*     */   extends UnsynchronizedAppenderBase<E>
/*     */ {
/*     */   protected Encoder<E> encoder;
/*  47 */   protected final ReentrantLock lock = new ReentrantLock(false);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private OutputStream outputStream;
/*     */ 
/*     */ 
/*     */   
/*     */   boolean immediateFlush = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream getOutputStream() {
/*  62 */     return this.outputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  70 */     byte b = 0;
/*  71 */     if (this.encoder == null) {
/*  72 */       addStatus((Status)new ErrorStatus("No encoder set for the appender named \"" + this.name + "\".", this));
/*  73 */       b++;
/*     */     } 
/*     */     
/*  76 */     if (this.outputStream == null) {
/*  77 */       addStatus((Status)new ErrorStatus("No output stream set for the appender named \"" + this.name + "\".", this));
/*  78 */       b++;
/*     */     } 
/*     */     
/*  81 */     if (b == 0) {
/*  82 */       super.start();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setLayout(Layout<E> paramLayout) {
/*  87 */     addWarn("This appender no longer admits a layout as a sub-component, set an encoder instead.");
/*  88 */     addWarn("To ensure compatibility, wrapping your layout in LayoutWrappingEncoder.");
/*  89 */     addWarn("See also http://logback.qos.ch/codes.html#layoutInsteadOfEncoder for details");
/*  90 */     LayoutWrappingEncoder layoutWrappingEncoder = new LayoutWrappingEncoder();
/*  91 */     layoutWrappingEncoder.setLayout(paramLayout);
/*  92 */     layoutWrappingEncoder.setContext(this.context);
/*  93 */     this.encoder = (Encoder<E>)layoutWrappingEncoder;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void append(E paramE) {
/*  98 */     if (!isStarted()) {
/*     */       return;
/*     */     }
/*     */     
/* 102 */     subAppend(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 113 */     this.lock.lock();
/*     */     try {
/* 115 */       closeOutputStream();
/* 116 */       super.stop();
/*     */     } finally {
/* 118 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void closeOutputStream() {
/* 126 */     if (this.outputStream != null) {
/*     */       
/*     */       try {
/* 129 */         encoderClose();
/* 130 */         this.outputStream.close();
/* 131 */         this.outputStream = null;
/* 132 */       } catch (IOException iOException) {
/* 133 */         addStatus((Status)new ErrorStatus("Could not close output stream for OutputStreamAppender.", this, iOException));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   void encoderClose() {
/* 139 */     if (this.encoder != null && this.outputStream != null) {
/*     */       try {
/* 141 */         byte[] arrayOfByte = this.encoder.footerBytes();
/* 142 */         writeBytes(arrayOfByte);
/* 143 */       } catch (IOException iOException) {
/* 144 */         this.started = false;
/* 145 */         addStatus((Status)new ErrorStatus("Failed to write footer for appender named [" + this.name + "].", this, iOException));
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
/*     */   public void setOutputStream(OutputStream paramOutputStream) {
/* 161 */     this.lock.lock();
/*     */     
/*     */     try {
/* 164 */       closeOutputStream();
/* 165 */       this.outputStream = paramOutputStream;
/* 166 */       if (this.encoder == null) {
/* 167 */         addWarn("Encoder has not been set. Cannot invoke its init method.");
/*     */         
/*     */         return;
/*     */       } 
/* 171 */       encoderInit();
/*     */     } finally {
/* 173 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   void encoderInit() {
/* 178 */     if (this.encoder != null && this.outputStream != null)
/*     */       try {
/* 180 */         byte[] arrayOfByte = this.encoder.headerBytes();
/* 181 */         writeBytes(arrayOfByte);
/* 182 */       } catch (IOException iOException) {
/* 183 */         this.started = false;
/* 184 */         addStatus((Status)new ErrorStatus("Failed to initialize encoder for appender named [" + this.name + "].", this, iOException));
/*     */       }  
/*     */   }
/*     */   
/*     */   protected void writeOut(E paramE) throws IOException {
/* 189 */     byte[] arrayOfByte = this.encoder.encode(paramE);
/* 190 */     writeBytes(arrayOfByte);
/*     */   }
/*     */   
/*     */   private void writeBytes(byte[] paramArrayOfbyte) throws IOException {
/* 194 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/*     */       return;
/*     */     }
/* 197 */     this.lock.lock();
/*     */     try {
/* 199 */       this.outputStream.write(paramArrayOfbyte);
/* 200 */       if (this.immediateFlush) {
/* 201 */         this.outputStream.flush();
/*     */       }
/*     */     } finally {
/* 204 */       this.lock.unlock();
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
/*     */   protected void subAppend(E paramE) {
/* 217 */     if (!isStarted()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 222 */       if (paramE instanceof DeferredProcessingAware) {
/* 223 */         ((DeferredProcessingAware)paramE).prepareForDeferredProcessing();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 230 */       byte[] arrayOfByte = this.encoder.encode(paramE);
/* 231 */       writeBytes(arrayOfByte);
/*     */     }
/* 233 */     catch (IOException iOException) {
/*     */ 
/*     */       
/* 236 */       this.started = false;
/* 237 */       addStatus((Status)new ErrorStatus("IO failure in appender", this, iOException));
/*     */     } 
/*     */   }
/*     */   
/*     */   public Encoder<E> getEncoder() {
/* 242 */     return this.encoder;
/*     */   }
/*     */   
/*     */   public void setEncoder(Encoder<E> paramEncoder) {
/* 246 */     this.encoder = paramEncoder;
/*     */   }
/*     */   
/*     */   public boolean isImmediateFlush() {
/* 250 */     return this.immediateFlush;
/*     */   }
/*     */   
/*     */   public void setImmediateFlush(boolean paramBoolean) {
/* 254 */     this.immediateFlush = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\OutputStreamAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */