/*     */ package org.apache.commons.net.telnet;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InterruptedIOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class TelnetInputStream
/*     */   extends BufferedInputStream
/*     */   implements Runnable
/*     */ {
/*     */   private static final int EOF = -1;
/*     */   private static final int WOULD_BLOCK = -2;
/*     */   static final int STATE_DATA = 0;
/*     */   static final int STATE_IAC = 1;
/*     */   static final int STATE_WILL = 2;
/*     */   static final int STATE_WONT = 3;
/*     */   static final int STATE_DO = 4;
/*     */   static final int STATE_DONT = 5;
/*     */   static final int STATE_SB = 6;
/*     */   static final int STATE_SE = 7;
/*     */   static final int STATE_CR = 8;
/*     */   static final int STATE_IAC_SB = 9;
/*     */   private boolean hasReachedEOF;
/*     */   private volatile boolean isClosed;
/*     */   private boolean readIsWaiting;
/*     */   private int receiveState;
/*     */   private int queueHead;
/*     */   private int queueTail;
/*     */   private int bytesAvailable;
/*     */   private final int[] queue;
/*     */   private final TelnetClient client;
/*     */   private final Thread thread;
/*     */   private IOException ioException;
/*     */   private final int[] suboption;
/*     */   private int suboptionCount;
/*     */   private volatile boolean threaded;
/*     */   
/*     */   TelnetInputStream(InputStream paramInputStream, TelnetClient paramTelnetClient, boolean paramBoolean) {
/*  57 */     super(paramInputStream);
/*  58 */     this.client = paramTelnetClient;
/*  59 */     this.receiveState = 0;
/*  60 */     this.isClosed = true;
/*  61 */     this.hasReachedEOF = false;
/*     */ 
/*     */     
/*  64 */     this.queue = new int[2049];
/*  65 */     this.queueHead = 0;
/*  66 */     this.queueTail = 0;
/*  67 */     this.suboption = new int[paramTelnetClient.maxSubnegotiationLength];
/*  68 */     this.bytesAvailable = 0;
/*  69 */     this.ioException = null;
/*  70 */     this.readIsWaiting = false;
/*  71 */     this.threaded = false;
/*  72 */     if (paramBoolean) {
/*  73 */       this.thread = new Thread(this);
/*     */     } else {
/*  75 */       this.thread = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   TelnetInputStream(InputStream paramInputStream, TelnetClient paramTelnetClient) {
/*  80 */     this(paramInputStream, paramTelnetClient, true);
/*     */   }
/*     */ 
/*     */   
/*     */   void start() {
/*  85 */     if (this.thread == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  90 */     this.isClosed = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     int i = Thread.currentThread().getPriority() + 1;
/*  96 */     if (i > 10) {
/*  97 */       i = 10;
/*     */     }
/*  99 */     this.thread.setPriority(i);
/* 100 */     this.thread.setDaemon(true);
/* 101 */     this.thread.start();
/* 102 */     this.threaded = true;
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
/*     */   private int read(boolean paramBoolean) throws IOException {
/*     */     int i;
/*     */     while (true) {
/* 128 */       if (!paramBoolean && super.available() == 0) {
/* 129 */         return -2;
/*     */       }
/*     */ 
/*     */       
/* 133 */       if ((i = super.read()) < 0) {
/* 134 */         return -1;
/*     */       }
/*     */       
/* 137 */       i &= 0xFF;
/*     */ 
/*     */       
/* 140 */       synchronized (this.client) {
/*     */         
/* 142 */         this.client.processAYTResponse();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 147 */       this.client.spyRead(i);
/*     */ 
/*     */       
/* 150 */       switch (this.receiveState) {
/*     */ 
/*     */         
/*     */         case 8:
/* 154 */           if (i == 0) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 0:
/* 166 */           if (i == 255) {
/*     */             
/* 168 */             this.receiveState = 1;
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 173 */           if (i == 13) {
/*     */             
/* 175 */             synchronized (this.client) {
/*     */               
/* 177 */               if (this.client.requestedDont(0)) {
/* 178 */                 this.receiveState = 8;
/*     */               } else {
/* 180 */                 this.receiveState = 0;
/*     */               } 
/*     */             }  break;
/*     */           } 
/* 184 */           this.receiveState = 0;
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 189 */           switch (i) {
/*     */             
/*     */             case 251:
/* 192 */               this.receiveState = 2;
/*     */               continue;
/*     */             case 252:
/* 195 */               this.receiveState = 3;
/*     */               continue;
/*     */             case 253:
/* 198 */               this.receiveState = 4;
/*     */               continue;
/*     */             case 254:
/* 201 */               this.receiveState = 5;
/*     */               continue;
/*     */             
/*     */             case 250:
/* 205 */               this.suboptionCount = 0;
/* 206 */               this.receiveState = 6;
/*     */               continue;
/*     */             
/*     */             case 255:
/* 210 */               this.receiveState = 0;
/*     */               break;
/*     */             case 240:
/* 213 */               this.receiveState = 0;
/*     */               continue;
/*     */           } 
/* 216 */           this.receiveState = 0;
/* 217 */           this.client.processCommand(i);
/*     */           continue;
/*     */ 
/*     */         
/*     */         case 2:
/* 222 */           synchronized (this.client) {
/*     */             
/* 224 */             this.client.processWill(i);
/* 225 */             this.client.flushOutputStream();
/*     */           } 
/* 227 */           this.receiveState = 0;
/*     */           continue;
/*     */         case 3:
/* 230 */           synchronized (this.client) {
/*     */             
/* 232 */             this.client.processWont(i);
/* 233 */             this.client.flushOutputStream();
/*     */           } 
/* 235 */           this.receiveState = 0;
/*     */           continue;
/*     */         case 4:
/* 238 */           synchronized (this.client) {
/*     */             
/* 240 */             this.client.processDo(i);
/* 241 */             this.client.flushOutputStream();
/*     */           } 
/* 243 */           this.receiveState = 0;
/*     */           continue;
/*     */         case 5:
/* 246 */           synchronized (this.client) {
/*     */             
/* 248 */             this.client.processDont(i);
/* 249 */             this.client.flushOutputStream();
/*     */           } 
/* 251 */           this.receiveState = 0;
/*     */           continue;
/*     */         
/*     */         case 6:
/* 255 */           switch (i) {
/*     */             
/*     */             case 255:
/* 258 */               this.receiveState = 9;
/*     */               continue;
/*     */           } 
/*     */           
/* 262 */           if (this.suboptionCount < this.suboption.length) {
/* 263 */             this.suboption[this.suboptionCount++] = i;
/*     */           }
/*     */ 
/*     */           
/* 267 */           this.receiveState = 6;
/*     */           continue;
/*     */         case 9:
/* 270 */           switch (i) {
/*     */             
/*     */             case 240:
/* 273 */               synchronized (this.client) {
/*     */                 
/* 275 */                 this.client.processSuboption(this.suboption, this.suboptionCount);
/* 276 */                 this.client.flushOutputStream();
/*     */               } 
/* 278 */               this.receiveState = 0;
/*     */               continue;
/*     */             case 255:
/* 281 */               if (this.suboptionCount < this.suboption.length) {
/* 282 */                 this.suboption[this.suboptionCount++] = i;
/*     */               }
/*     */               break;
/*     */           } 
/*     */ 
/*     */           
/* 288 */           this.receiveState = 6;
/*     */           continue;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       break;
/*     */     } 
/* 296 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean processChar(int paramInt) throws InterruptedException {
/*     */     boolean bool;
/* 308 */     synchronized (this.queue) {
/*     */       
/* 310 */       bool = (this.bytesAvailable == 0) ? true : false;
/* 311 */       while (this.bytesAvailable >= this.queue.length - 1) {
/*     */ 
/*     */ 
/*     */         
/* 315 */         if (this.threaded) {
/*     */           
/* 317 */           this.queue.notify();
/*     */           
/*     */           try {
/* 320 */             this.queue.wait();
/*     */           }
/* 322 */           catch (InterruptedException interruptedException) {
/*     */             
/* 324 */             throw interruptedException;
/*     */           } 
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 331 */         throw new IllegalStateException("Queue is full! Cannot process another character.");
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 336 */       if (this.readIsWaiting && this.threaded)
/*     */       {
/* 338 */         this.queue.notify();
/*     */       }
/*     */       
/* 341 */       this.queue[this.queueTail] = paramInt;
/* 342 */       this.bytesAvailable++;
/*     */       
/* 344 */       if (++this.queueTail >= this.queue.length) {
/* 345 */         this.queueTail = 0;
/*     */       }
/*     */     } 
/* 348 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 357 */     synchronized (this.queue) {
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         
/* 362 */         if (this.ioException != null) {
/*     */ 
/*     */           
/* 365 */           IOException iOException = this.ioException;
/* 366 */           this.ioException = null;
/* 367 */           throw iOException;
/*     */         } 
/*     */         
/* 370 */         if (this.bytesAvailable == 0) {
/*     */ 
/*     */           
/* 373 */           if (this.hasReachedEOF) {
/* 374 */             return -1;
/*     */           }
/*     */ 
/*     */           
/* 378 */           if (this.threaded) {
/*     */             
/* 380 */             this.queue.notify();
/*     */             
/*     */             try {
/* 383 */               this.readIsWaiting = true;
/* 384 */               this.queue.wait();
/* 385 */               this.readIsWaiting = false;
/*     */             }
/* 387 */             catch (InterruptedException interruptedException) {
/*     */               
/* 389 */               throw new InterruptedIOException("Fatal thread interruption during read.");
/*     */             } 
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 395 */           this.readIsWaiting = true;
/*     */           
/* 397 */           boolean bool = true;
/*     */           
/*     */           do {
/*     */             int j;
/*     */             
/*     */             try {
/* 403 */               if ((j = read(bool)) < 0 && 
/* 404 */                 j != -2) {
/* 405 */                 return j;
/*     */               
/*     */               }
/*     */             }
/* 409 */             catch (InterruptedIOException interruptedIOException) {
/*     */               
/* 411 */               synchronized (this.queue) {
/*     */                 
/* 413 */                 this.ioException = interruptedIOException;
/* 414 */                 this.queue.notifyAll();
/*     */                 
/*     */                 try {
/* 417 */                   this.queue.wait(100L);
/*     */                 }
/* 419 */                 catch (InterruptedException interruptedException) {}
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 424 */               return -1;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/*     */             try {
/* 430 */               if (j != -2)
/*     */               {
/* 432 */                 processChar(j);
/*     */               }
/*     */             }
/* 435 */             catch (InterruptedException interruptedException) {
/*     */               
/* 437 */               if (this.isClosed) {
/* 438 */                 return -1;
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 444 */             bool = false;
/*     */ 
/*     */           
/*     */           }
/* 448 */           while (super.available() > 0 && this.bytesAvailable < this.queue.length - 1);
/*     */           
/* 450 */           this.readIsWaiting = false;
/*     */           
/*     */           continue;
/*     */         } 
/*     */         break;
/*     */       } 
/* 456 */       int i = this.queue[this.queueHead];
/*     */       
/* 458 */       if (++this.queueHead >= this.queue.length) {
/* 459 */         this.queueHead = 0;
/*     */       }
/*     */       
/* 462 */       this.bytesAvailable--;
/*     */ 
/*     */       
/* 465 */       if (this.bytesAvailable == 0 && this.threaded) {
/* 466 */         this.queue.notify();
/*     */       }
/*     */       
/* 469 */       return i;
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 489 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 513 */     if (paramInt2 < 1) {
/* 514 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 518 */     synchronized (this.queue) {
/*     */       
/* 520 */       if (paramInt2 > this.bytesAvailable) {
/* 521 */         paramInt2 = this.bytesAvailable;
/*     */       }
/*     */     } 
/*     */     int i;
/* 525 */     if ((i = read()) == -1) {
/* 526 */       return -1;
/*     */     }
/*     */     
/* 529 */     int j = paramInt1;
/*     */ 
/*     */     
/*     */     do {
/* 533 */       paramArrayOfbyte[paramInt1++] = (byte)i;
/*     */     }
/* 535 */     while (--paramInt2 > 0 && (i = read()) != -1);
/*     */ 
/*     */     
/* 538 */     return paramInt1 - j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 546 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/* 553 */     synchronized (this.queue) {
/*     */       
/* 555 */       if (this.threaded) {
/* 556 */         return this.bytesAvailable;
/*     */       }
/* 558 */       return this.bytesAvailable + super.available();
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
/*     */   public void close() throws IOException {
/* 572 */     super.close();
/*     */     
/* 574 */     synchronized (this.queue) {
/*     */       
/* 576 */       this.hasReachedEOF = true;
/* 577 */       this.isClosed = true;
/*     */       
/* 579 */       if (this.thread != null && this.thread.isAlive())
/*     */       {
/* 581 */         this.thread.interrupt();
/*     */       }
/*     */       
/* 584 */       this.queue.notifyAll();
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
/*     */   public void run() {
/*     */     try {
/* 597 */       while (!this.isClosed) {
/*     */         int i;
/*     */         
/*     */         try {
/* 601 */           if ((i = read(true)) < 0) {
/*     */             break;
/*     */           }
/*     */         }
/* 605 */         catch (InterruptedIOException interruptedIOException) {
/*     */           
/* 607 */           synchronized (this.queue) {
/*     */             
/* 609 */             this.ioException = interruptedIOException;
/* 610 */             this.queue.notifyAll();
/*     */             
/*     */             try {
/* 613 */               this.queue.wait(100L);
/*     */             }
/* 615 */             catch (InterruptedException interruptedException) {
/*     */               
/* 617 */               if (this.isClosed) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */           } 
/*     */           continue;
/* 623 */         } catch (RuntimeException runtimeException) {
/*     */ 
/*     */ 
/*     */           
/* 627 */           super.close();
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */ 
/*     */         
/* 634 */         boolean bool = false;
/*     */         
/*     */         try {
/* 637 */           bool = processChar(i);
/*     */         }
/* 639 */         catch (InterruptedException interruptedException) {
/*     */           
/* 641 */           if (this.isClosed) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 647 */         if (bool) {
/* 648 */           this.client.notifyInputListener();
/*     */         }
/*     */       }
/*     */     
/* 652 */     } catch (IOException iOException) {
/*     */       
/* 654 */       synchronized (this.queue) {
/*     */         
/* 656 */         this.ioException = iOException;
/*     */       } 
/* 658 */       this.client.notifyInputListener();
/*     */     } 
/*     */     
/* 661 */     synchronized (this.queue) {
/*     */       
/* 663 */       this.isClosed = true;
/* 664 */       this.hasReachedEOF = true;
/* 665 */       this.queue.notify();
/*     */     } 
/*     */     
/* 668 */     this.threaded = false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\TelnetInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */