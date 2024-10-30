/*     */ package org.h2.message;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Writer;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.concurrent.atomic.AtomicReferenceArray;
/*     */ import org.h2.api.ErrorCode;
/*     */ import org.h2.jdbc.JdbcSQLException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TraceSystem
/*     */   implements TraceWriter
/*     */ {
/*     */   public static final int PARENT = -1;
/*     */   public static final int OFF = 0;
/*     */   public static final int ERROR = 1;
/*     */   public static final int INFO = 2;
/*     */   public static final int DEBUG = 3;
/*     */   public static final int ADAPTER = 4;
/*     */   public static final int DEFAULT_TRACE_LEVEL_SYSTEM_OUT = 0;
/*     */   public static final int DEFAULT_TRACE_LEVEL_FILE = 1;
/*     */   private static final int DEFAULT_MAX_FILE_SIZE = 67108864;
/*     */   private static final int CHECK_SIZE_EACH_WRITES = 4096;
/*  79 */   private int levelSystemOut = 0;
/*  80 */   private int levelFile = 1;
/*     */   private int levelMax;
/*  82 */   private int maxFileSize = 67108864;
/*     */   private String fileName;
/*  84 */   private final AtomicReferenceArray<Trace> traces = new AtomicReferenceArray<>(Trace.MODULE_NAMES.length);
/*     */   
/*     */   private SimpleDateFormat dateFormat;
/*     */   private Writer fileWriter;
/*     */   private PrintWriter printWriter;
/*     */   private int checkSize;
/*     */   private boolean closed;
/*     */   private boolean writingErrorLogged;
/*  92 */   private TraceWriter writer = this;
/*  93 */   private PrintStream sysOut = System.out;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TraceSystem(String paramString) {
/* 101 */     this.fileName = paramString;
/* 102 */     updateLevel();
/*     */   }
/*     */   
/*     */   private void updateLevel() {
/* 106 */     this.levelMax = Math.max(this.levelSystemOut, this.levelFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSysOut(PrintStream paramPrintStream) {
/* 115 */     this.sysOut = paramPrintStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Trace getTrace(int paramInt) {
/* 126 */     Trace trace = this.traces.get(paramInt);
/* 127 */     if (trace == null) {
/* 128 */       trace = new Trace(this.writer, paramInt);
/* 129 */       if (!this.traces.compareAndSet(paramInt, null, trace)) {
/* 130 */         trace = this.traces.get(paramInt);
/*     */       }
/*     */     } 
/* 133 */     return trace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Trace getTrace(String paramString) {
/* 144 */     return new Trace(this.writer, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled(int paramInt) {
/* 149 */     return (paramInt <= this.levelMax);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileName(String paramString) {
/* 158 */     this.fileName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxFileSize(int paramInt) {
/* 167 */     this.maxFileSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelSystemOut(int paramInt) {
/* 176 */     this.levelSystemOut = paramInt;
/* 177 */     updateLevel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelFile(int paramInt) {
/* 186 */     if (paramInt == 4) {
/* 187 */       String str1 = "org.h2.message.TraceWriterAdapter";
/*     */       try {
/* 189 */         this.writer = (TraceWriter)Class.forName(str1).newInstance();
/* 190 */       } catch (Throwable throwable) {
/* 191 */         throwable = DbException.get(90086, throwable, new String[] { str1 });
/* 192 */         write(1, 2, str1, throwable);
/*     */         return;
/*     */       } 
/* 195 */       String str2 = this.fileName;
/* 196 */       if (str2 != null) {
/* 197 */         if (str2.endsWith(".trace.db")) {
/* 198 */           str2 = str2.substring(0, str2.length() - ".trace.db".length());
/*     */         }
/* 200 */         int i = Math.max(str2.lastIndexOf('/'), str2.lastIndexOf('\\'));
/* 201 */         if (i >= 0) {
/* 202 */           str2 = str2.substring(i + 1);
/*     */         }
/* 204 */         this.writer.setName(str2);
/*     */       } 
/*     */     } 
/* 207 */     this.levelFile = paramInt;
/* 208 */     updateLevel();
/*     */   }
/*     */   
/*     */   public int getLevelFile() {
/* 212 */     return this.levelFile;
/*     */   }
/*     */   
/*     */   private synchronized String format(String paramString1, String paramString2) {
/* 216 */     if (this.dateFormat == null) {
/* 217 */       this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
/*     */     }
/* 219 */     return this.dateFormat.format(Long.valueOf(System.currentTimeMillis())) + paramString1 + ": " + paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable) {
/* 224 */     write(paramInt1, Trace.MODULE_NAMES[paramInt2], paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
/* 229 */     if (paramInt <= this.levelSystemOut || paramInt > this.levelMax) {
/*     */ 
/*     */       
/* 232 */       this.sysOut.println(format(paramString1, paramString2));
/* 233 */       if (paramThrowable != null && this.levelSystemOut == 3) {
/* 234 */         paramThrowable.printStackTrace(this.sysOut);
/*     */       }
/*     */     } 
/* 237 */     if (this.fileName != null && 
/* 238 */       paramInt <= this.levelFile) {
/* 239 */       writeFile(format(paramString1, paramString2), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void writeFile(String paramString, Throwable paramThrowable) {
/*     */     try {
/* 246 */       if (this.checkSize++ >= 4096) {
/* 247 */         this.checkSize = 0;
/* 248 */         closeWriter();
/* 249 */         if (this.maxFileSize > 0 && FileUtils.size(this.fileName) > this.maxFileSize) {
/* 250 */           String str = this.fileName + ".old";
/* 251 */           FileUtils.delete(str);
/* 252 */           FileUtils.move(this.fileName, str);
/*     */         } 
/*     */       } 
/* 255 */       if (!openWriter()) {
/*     */         return;
/*     */       }
/* 258 */       this.printWriter.println(paramString);
/* 259 */       if (paramThrowable != null) {
/* 260 */         if (this.levelFile == 1 && paramThrowable instanceof JdbcSQLException) {
/* 261 */           JdbcSQLException jdbcSQLException = (JdbcSQLException)paramThrowable;
/* 262 */           int i = jdbcSQLException.getErrorCode();
/* 263 */           if (ErrorCode.isCommon(i)) {
/* 264 */             this.printWriter.println(paramThrowable.toString());
/*     */           } else {
/* 266 */             paramThrowable.printStackTrace(this.printWriter);
/*     */           } 
/*     */         } else {
/* 269 */           paramThrowable.printStackTrace(this.printWriter);
/*     */         } 
/*     */       }
/* 272 */       this.printWriter.flush();
/* 273 */       if (this.closed) {
/* 274 */         closeWriter();
/*     */       }
/* 276 */     } catch (Exception exception) {
/* 277 */       logWritingError(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void logWritingError(Exception paramException) {
/* 282 */     if (this.writingErrorLogged) {
/*     */       return;
/*     */     }
/* 285 */     this.writingErrorLogged = true;
/* 286 */     DbException dbException = DbException.get(90034, paramException, new String[] { this.fileName, paramException.toString() });
/*     */ 
/*     */     
/* 289 */     this.fileName = null;
/* 290 */     this.sysOut.println(dbException);
/* 291 */     dbException.printStackTrace();
/*     */   }
/*     */   
/*     */   private boolean openWriter() {
/* 295 */     if (this.printWriter == null) {
/*     */       try {
/* 297 */         FileUtils.createDirectories(FileUtils.getParent(this.fileName));
/* 298 */         if (FileUtils.exists(this.fileName) && !FileUtils.canWrite(this.fileName))
/*     */         {
/*     */           
/* 301 */           return false;
/*     */         }
/* 303 */         this.fileWriter = IOUtils.getBufferedWriter(FileUtils.newOutputStream(this.fileName, true));
/*     */         
/* 305 */         this.printWriter = new PrintWriter(this.fileWriter, true);
/* 306 */       } catch (Exception exception) {
/* 307 */         logWritingError(exception);
/* 308 */         return false;
/*     */       } 
/*     */     }
/* 311 */     return true;
/*     */   }
/*     */   
/*     */   private synchronized void closeWriter() {
/* 315 */     if (this.printWriter != null) {
/* 316 */       this.printWriter.flush();
/* 317 */       this.printWriter.close();
/* 318 */       this.printWriter = null;
/*     */     } 
/* 320 */     if (this.fileWriter != null) {
/*     */       try {
/* 322 */         this.fileWriter.close();
/* 323 */       } catch (IOException iOException) {}
/*     */ 
/*     */       
/* 326 */       this.fileWriter = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 336 */     closeWriter();
/* 337 */     this.closed = true;
/*     */   }
/*     */   
/*     */   public void setName(String paramString) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\message\TraceSystem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */