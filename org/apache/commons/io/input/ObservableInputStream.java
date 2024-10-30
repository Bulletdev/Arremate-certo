/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObservableInputStream
/*     */   extends ProxyInputStream
/*     */ {
/*     */   public static abstract class Observer
/*     */   {
/*     */     public void data(int param1Int) throws IOException {}
/*     */     
/*     */     public void data(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {}
/*     */     
/*     */     public void finished() throws IOException {}
/*     */     
/*     */     public void closed() throws IOException {}
/*     */     
/*     */     public void error(IOException param1IOException) throws IOException {
/*  95 */       throw param1IOException;
/*     */     } }
/*     */   
/*  98 */   private final List<Observer> observers = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObservableInputStream(InputStream paramInputStream) {
/* 105 */     super(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Observer paramObserver) {
/* 113 */     this.observers.add(paramObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Observer paramObserver) {
/* 121 */     this.observers.remove(paramObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllObservers() {
/* 128 */     this.observers.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 133 */     int i = 0;
/* 134 */     IOException iOException = null;
/*     */     try {
/* 136 */       i = super.read();
/* 137 */     } catch (IOException iOException1) {
/* 138 */       iOException = iOException1;
/*     */     } 
/* 140 */     if (iOException != null) {
/* 141 */       noteError(iOException);
/* 142 */     } else if (i == -1) {
/* 143 */       noteFinished();
/*     */     } else {
/* 145 */       noteDataByte(i);
/*     */     } 
/* 147 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 152 */     int i = 0;
/* 153 */     IOException iOException = null;
/*     */     try {
/* 155 */       i = super.read(paramArrayOfbyte);
/* 156 */     } catch (IOException iOException1) {
/* 157 */       iOException = iOException1;
/*     */     } 
/* 159 */     if (iOException != null) {
/* 160 */       noteError(iOException);
/* 161 */     } else if (i == -1) {
/* 162 */       noteFinished();
/* 163 */     } else if (i > 0) {
/* 164 */       noteDataBytes(paramArrayOfbyte, 0, i);
/*     */     } 
/* 166 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 171 */     int i = 0;
/* 172 */     IOException iOException = null;
/*     */     try {
/* 174 */       i = super.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 175 */     } catch (IOException iOException1) {
/* 176 */       iOException = iOException1;
/*     */     } 
/* 178 */     if (iOException != null) {
/* 179 */       noteError(iOException);
/* 180 */     } else if (i == -1) {
/* 181 */       noteFinished();
/* 182 */     } else if (i > 0) {
/* 183 */       noteDataBytes(paramArrayOfbyte, paramInt1, i);
/*     */     } 
/* 185 */     return i;
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
/*     */   protected void noteDataBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 197 */     for (Observer observer : getObservers()) {
/* 198 */       observer.data(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void noteFinished() throws IOException {
/* 207 */     for (Observer observer : getObservers()) {
/* 208 */       observer.finished();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void noteDataByte(int paramInt) throws IOException {
/* 219 */     for (Observer observer : getObservers()) {
/* 220 */       observer.data(paramInt);
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
/*     */   protected void noteError(IOException paramIOException) throws IOException {
/* 232 */     for (Observer observer : getObservers()) {
/* 233 */       observer.error(paramIOException);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void noteClosed() throws IOException {
/* 242 */     for (Observer observer : getObservers()) {
/* 243 */       observer.closed();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Observer> getObservers() {
/* 251 */     return this.observers;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 256 */     IOException iOException = null;
/*     */     try {
/* 258 */       super.close();
/* 259 */     } catch (IOException iOException1) {
/* 260 */       iOException = iOException1;
/*     */     } 
/* 262 */     if (iOException == null) {
/* 263 */       noteClosed();
/*     */     } else {
/* 265 */       noteError(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consume() throws IOException {
/*     */     int i;
/* 275 */     byte[] arrayOfByte = new byte[8192];
/*     */     do {
/* 277 */       i = read(arrayOfByte);
/* 278 */     } while (i != -1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\ObservableInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */