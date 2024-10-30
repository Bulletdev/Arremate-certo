/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.charset.Charset;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tailer
/*     */   implements Runnable
/*     */ {
/*     */   private static final int DEFAULT_DELAY_MILLIS = 1000;
/*     */   private static final String RAF_MODE = "r";
/* 131 */   private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] inbuf;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final File file;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Charset charset;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final long delayMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean end;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TailerListener listener;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean reOpen;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean run = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener) {
/* 179 */     this(paramFile, paramTailerListener, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong) {
/* 189 */     this(paramFile, paramTailerListener, paramLong, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean) {
/* 200 */     this(paramFile, paramTailerListener, paramLong, paramBoolean, 8192);
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
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 213 */     this(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 8192);
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
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt) {
/* 226 */     this(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
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
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 240 */     this(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
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
/*     */   public Tailer(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 256 */     this.file = paramFile;
/* 257 */     this.delayMillis = paramLong;
/* 258 */     this.end = paramBoolean1;
/*     */     
/* 260 */     this.inbuf = new byte[paramInt];
/*     */ 
/*     */     
/* 263 */     this.listener = paramTailerListener;
/* 264 */     paramTailerListener.init(this);
/* 265 */     this.reOpen = paramBoolean2;
/* 266 */     this.charset = paramCharset;
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt) {
/* 281 */     return create(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 298 */     return create(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
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
/*     */   public static Tailer create(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 316 */     Tailer tailer = new Tailer(paramFile, paramCharset, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
/* 317 */     Thread thread = new Thread(tailer);
/* 318 */     thread.setDaemon(true);
/* 319 */     thread.start();
/* 320 */     return tailer;
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean) {
/* 334 */     return create(paramFile, paramTailerListener, paramLong, paramBoolean, 8192);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 349 */     return create(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 8192);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong) {
/* 361 */     return create(paramFile, paramTailerListener, paramLong, false);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener) {
/* 373 */     return create(paramFile, paramTailerListener, 1000L, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/* 382 */     return this.file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean getRun() {
/* 392 */     return this.run;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDelay() {
/* 401 */     return this.delayMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 409 */     RandomAccessFile randomAccessFile = null;
/*     */     try {
/* 411 */       long l1 = 0L;
/* 412 */       long l2 = 0L;
/*     */       
/* 414 */       while (getRun() && randomAccessFile == null) {
/*     */         try {
/* 416 */           randomAccessFile = new RandomAccessFile(this.file, "r");
/* 417 */         } catch (FileNotFoundException fileNotFoundException) {
/* 418 */           this.listener.fileNotFound();
/*     */         } 
/* 420 */         if (randomAccessFile == null) {
/* 421 */           Thread.sleep(this.delayMillis);
/*     */           continue;
/*     */         } 
/* 424 */         l2 = this.end ? this.file.length() : 0L;
/* 425 */         l1 = this.file.lastModified();
/* 426 */         randomAccessFile.seek(l2);
/*     */       } 
/*     */       
/* 429 */       while (getRun()) {
/* 430 */         boolean bool = FileUtils.isFileNewer(this.file, l1);
/*     */         
/* 432 */         long l = this.file.length();
/* 433 */         if (l < l2) {
/*     */           
/* 435 */           this.listener.fileRotated();
/*     */ 
/*     */           
/* 438 */           try (RandomAccessFile null = randomAccessFile) {
/* 439 */             randomAccessFile = new RandomAccessFile(this.file, "r");
/*     */ 
/*     */             
/*     */             try {
/* 443 */               readLines(randomAccessFile1);
/* 444 */             } catch (IOException iOException) {
/* 445 */               this.listener.handle(iOException);
/*     */             } 
/* 447 */             l2 = 0L;
/* 448 */           } catch (FileNotFoundException fileNotFoundException) {
/*     */             
/* 450 */             this.listener.fileNotFound();
/* 451 */             Thread.sleep(this.delayMillis);
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 457 */         if (l > l2) {
/*     */           
/* 459 */           l2 = readLines(randomAccessFile);
/* 460 */           l1 = this.file.lastModified();
/* 461 */         } else if (bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 466 */           l2 = 0L;
/* 467 */           randomAccessFile.seek(l2);
/*     */ 
/*     */           
/* 470 */           l2 = readLines(randomAccessFile);
/* 471 */           l1 = this.file.lastModified();
/*     */         } 
/* 473 */         if (this.reOpen && randomAccessFile != null) {
/* 474 */           randomAccessFile.close();
/*     */         }
/* 476 */         Thread.sleep(this.delayMillis);
/* 477 */         if (getRun() && this.reOpen) {
/* 478 */           randomAccessFile = new RandomAccessFile(this.file, "r");
/* 479 */           randomAccessFile.seek(l2);
/*     */         } 
/*     */       } 
/* 482 */     } catch (InterruptedException interruptedException) {
/* 483 */       Thread.currentThread().interrupt();
/* 484 */       this.listener.handle(interruptedException);
/* 485 */     } catch (Exception exception) {
/* 486 */       this.listener.handle(exception);
/*     */     } finally {
/*     */       try {
/* 489 */         if (randomAccessFile != null) {
/* 490 */           randomAccessFile.close();
/*     */         }
/*     */       }
/* 493 */       catch (IOException iOException) {
/* 494 */         this.listener.handle(iOException);
/*     */       } 
/* 496 */       stop();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 504 */     this.run = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long readLines(RandomAccessFile paramRandomAccessFile) throws IOException {
/* 515 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream(64)) {
/* 516 */       long l1 = paramRandomAccessFile.getFilePointer();
/* 517 */       long l2 = l1;
/*     */       
/* 519 */       boolean bool = false; int i;
/* 520 */       while (getRun() && (i = paramRandomAccessFile.read(this.inbuf)) != -1) {
/* 521 */         for (byte b = 0; b < i; b++) {
/* 522 */           byte b1 = this.inbuf[b];
/* 523 */           switch (b1) {
/*     */             case 10:
/* 525 */               bool = false;
/* 526 */               this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.charset));
/* 527 */               byteArrayOutputStream.reset();
/* 528 */               l2 = l1 + b + 1L;
/*     */               break;
/*     */             case 13:
/* 531 */               if (bool) {
/* 532 */                 byteArrayOutputStream.write(13);
/*     */               }
/* 534 */               bool = true;
/*     */               break;
/*     */             default:
/* 537 */               if (bool) {
/* 538 */                 bool = false;
/* 539 */                 this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.charset));
/* 540 */                 byteArrayOutputStream.reset();
/* 541 */                 l2 = l1 + b + 1L;
/*     */               } 
/* 543 */               byteArrayOutputStream.write(b1); break;
/*     */           } 
/*     */         } 
/* 546 */         l1 = paramRandomAccessFile.getFilePointer();
/*     */       } 
/*     */       
/* 549 */       paramRandomAccessFile.seek(l2);
/*     */       
/* 551 */       if (this.listener instanceof TailerListenerAdapter) {
/* 552 */         ((TailerListenerAdapter)this.listener).endOfFileReached();
/*     */       }
/*     */       
/* 555 */       return l2;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\Tailer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */