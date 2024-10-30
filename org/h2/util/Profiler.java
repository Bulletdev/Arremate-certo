/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.LineNumberReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.StringReader;
/*     */ import java.lang.instrument.Instrumentation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Profiler
/*     */   implements Runnable
/*     */ {
/*     */   private static Instrumentation instrumentation;
/*  32 */   private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");
/*     */   
/*     */   private static final int MAX_ELEMENTS = 1000;
/*     */   
/*  36 */   public int interval = 2;
/*  37 */   public int depth = 48;
/*     */   
/*     */   public boolean paused;
/*     */   
/*     */   public boolean sumClasses;
/*     */   public boolean sumMethods;
/*     */   private int pid;
/*  44 */   private final String[] ignoreLines = "java,sun,com.sun.,com.google.common.,com.mongodb.,org.bson.,".split(",");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private final String[] ignorePackages = "java,sun,com.sun.,com.google.common.,com.mongodb.,org.bson".split(",");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private final String[] ignoreThreads = "java.lang.Object.wait,java.lang.Thread.dumpThreads,java.lang.Thread.getThreads,java.lang.Thread.sleep,java.lang.UNIXProcess.waitForProcessExit,java.net.PlainDatagramSocketImpl.receive0,java.net.PlainSocketImpl.accept,java.net.PlainSocketImpl.socketAccept,java.net.SocketInputStream.socketRead,java.net.SocketOutputStream.socketWrite,org.eclipse.jetty.io.nio.SelectorManager$SelectSet.doSelect,sun.awt.windows.WToolkit.eventLoop,sun.misc.Unsafe.park,sun.nio.ch.EPollArrayWrapper.epollWait,sun.nio.ch.KQueueArrayWrapper.kevent0,sun.nio.ch.ServerSocketChannelImpl.accept,dalvik.system.VMStack.getThreadStackTrace,dalvik.system.NativeStart.run".split(",");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean stop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   private final HashMap<String, Integer> counts = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   private final HashMap<String, Integer> summary = new HashMap<>();
/*     */   
/*  91 */   private int minCount = 1;
/*     */   
/*     */   private int total;
/*     */   
/*     */   private Thread thread;
/*     */   
/*     */   private long start;
/*     */   
/*     */   private long time;
/*     */   
/*     */   private int threadDumps;
/*     */ 
/*     */   
/*     */   public static void premain(String paramString, Instrumentation paramInstrumentation) {
/* 105 */     instrumentation = paramInstrumentation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Instrumentation getInstrumentation() {
/* 114 */     return instrumentation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String... paramVarArgs) {
/* 125 */     (new Profiler()).run(paramVarArgs);
/*     */   }
/*     */   
/*     */   private void run(String... paramVarArgs) {
/* 129 */     if (paramVarArgs.length == 0) {
/* 130 */       System.out.println("Show profiling data");
/* 131 */       System.out.println("Usage: java " + getClass().getName() + " <pid> | <stackTraceFileNames>");
/*     */       
/* 133 */       System.out.println("Processes:");
/* 134 */       String str = exec(new String[] { "jps", "-l" });
/* 135 */       System.out.println(str);
/*     */       return;
/*     */     } 
/* 138 */     this.start = System.currentTimeMillis();
/* 139 */     if (paramVarArgs[0].matches("\\d+")) {
/* 140 */       this.pid = Integer.parseInt(paramVarArgs[0]);
/* 141 */       long l = 0L;
/*     */       while (true) {
/* 143 */         tick();
/* 144 */         long l1 = System.currentTimeMillis();
/* 145 */         if (l1 - l > 5000L) {
/* 146 */           this.time = System.currentTimeMillis() - this.start;
/* 147 */           System.out.println(getTopTraces(3));
/* 148 */           l = l1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     try {
/* 153 */       for (String str : paramVarArgs) {
/* 154 */         if (str.startsWith("-")) {
/* 155 */           if ("-classes".equals(str)) {
/* 156 */             this.sumClasses = true;
/* 157 */           } else if ("-methods".equals(str)) {
/* 158 */             this.sumMethods = true;
/* 159 */           } else if ("-packages".equals(str)) {
/* 160 */             this.sumClasses = false;
/* 161 */             this.sumMethods = false;
/*     */           } else {
/* 163 */             throw new IllegalArgumentException(str);
/*     */           } 
/*     */         } else {
/*     */           
/* 167 */           String str1 = str;
/*     */ 
/*     */           
/* 170 */           InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(str1), "CP1252");
/*     */           
/* 172 */           LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
/*     */           while (true) {
/* 174 */             String str2 = lineNumberReader.readLine();
/* 175 */             if (str2 == null)
/*     */               break; 
/* 177 */             if (str2.startsWith("Full thread dump")) {
/* 178 */               this.threadDumps++;
/*     */             }
/*     */           } 
/* 181 */           inputStreamReader.close();
/* 182 */           inputStreamReader = new InputStreamReader(new FileInputStream(str1), "CP1252");
/*     */           
/* 184 */           lineNumberReader = new LineNumberReader(inputStreamReader);
/* 185 */           processList(readStackTrace(lineNumberReader));
/* 186 */           inputStreamReader.close();
/*     */         } 
/* 188 */       }  System.out.println(getTopTraces(5));
/* 189 */     } catch (IOException iOException) {
/* 190 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static List<Object[]> getRunnableStackTraces() {
/* 195 */     ArrayList<StackTraceElement[]> arrayList = new ArrayList();
/* 196 */     Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
/* 197 */     for (Map.Entry<Thread, StackTraceElement> entry : map.entrySet()) {
/* 198 */       Thread thread = (Thread)entry.getKey();
/* 199 */       if (thread.getState() != Thread.State.RUNNABLE) {
/*     */         continue;
/*     */       }
/* 202 */       StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])entry.getValue();
/* 203 */       if (arrayOfStackTraceElement == null || arrayOfStackTraceElement.length == 0) {
/*     */         continue;
/*     */       }
/* 206 */       arrayList.add(arrayOfStackTraceElement);
/*     */     } 
/* 208 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static List<Object[]> readRunnableStackTraces(int paramInt) {
/*     */     try {
/* 213 */       String str = exec(new String[] { "jstack", "" + paramInt });
/* 214 */       LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str));
/*     */       
/* 216 */       return readStackTrace(lineNumberReader);
/* 217 */     } catch (IOException iOException) {
/* 218 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<Object[]> readStackTrace(LineNumberReader paramLineNumberReader) throws IOException {
/* 224 */     ArrayList<String[]> arrayList = new ArrayList();
/*     */     while (true) {
/* 226 */       String str = paramLineNumberReader.readLine();
/* 227 */       if (str == null) {
/*     */         break;
/*     */       }
/* 230 */       if (!str.startsWith("\"")) {
/*     */         continue;
/*     */       }
/*     */       
/* 234 */       str = paramLineNumberReader.readLine();
/* 235 */       if (str == null) {
/*     */         break;
/*     */       }
/* 238 */       str = str.trim();
/* 239 */       if (!str.startsWith("java.lang.Thread.State: RUNNABLE")) {
/*     */         continue;
/*     */       }
/* 242 */       ArrayList<String> arrayList1 = new ArrayList();
/*     */       while (true) {
/* 244 */         str = paramLineNumberReader.readLine();
/* 245 */         if (str == null) {
/*     */           break;
/*     */         }
/* 248 */         str = str.trim();
/* 249 */         if (str.startsWith("- ")) {
/*     */           continue;
/*     */         }
/* 252 */         if (!str.startsWith("at ")) {
/*     */           break;
/*     */         }
/* 255 */         str = str.substring(3).trim();
/* 256 */         arrayList1.add(str);
/*     */       } 
/* 258 */       if (arrayList1.size() > 0) {
/* 259 */         String[] arrayOfString = arrayList1.<String>toArray(new String[arrayList1.size()]);
/* 260 */         arrayList.add(arrayOfString);
/*     */       } 
/*     */     } 
/* 263 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static String exec(String... paramVarArgs) {
/* 267 */     ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
/* 268 */     ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
/*     */     try {
/* 270 */       Process process = Runtime.getRuntime().exec(paramVarArgs);
/* 271 */       copyInThread(process.getInputStream(), byteArrayOutputStream2);
/* 272 */       copyInThread(process.getErrorStream(), byteArrayOutputStream1);
/* 273 */       process.waitFor();
/* 274 */       String str = new String(byteArrayOutputStream1.toByteArray(), "UTF-8");
/* 275 */       if (str.length() > 0) {
/* 276 */         throw new RuntimeException(str);
/*     */       }
/* 278 */       return new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
/*     */     }
/* 280 */     catch (Exception exception) {
/* 281 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void copyInThread(final InputStream in, final OutputStream out) {
/* 287 */     (new Thread("Profiler stream copy")
/*     */       {
/*     */         public void run() {
/* 290 */           byte[] arrayOfByte = new byte[4096];
/*     */           try {
/*     */             while (true) {
/* 293 */               int i = in.read(arrayOfByte, 0, arrayOfByte.length);
/* 294 */               if (i < 0) {
/*     */                 break;
/*     */               }
/* 297 */               out.write(arrayOfByte, 0, i);
/*     */             } 
/* 299 */           } catch (Exception exception) {
/* 300 */             throw new RuntimeException(exception);
/*     */           } 
/*     */         }
/*     */       }).start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Profiler startCollecting() {
/* 312 */     this.thread = new Thread(this, "Profiler");
/* 313 */     this.thread.setDaemon(true);
/* 314 */     this.thread.start();
/* 315 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Profiler stopCollecting() {
/* 324 */     this.stop = true;
/* 325 */     if (this.thread != null) {
/*     */       try {
/* 327 */         this.thread.join();
/* 328 */       } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */       
/* 331 */       this.thread = null;
/*     */     } 
/* 333 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 338 */     this.start = System.currentTimeMillis();
/* 339 */     while (!this.stop) {
/*     */       try {
/* 341 */         tick();
/* 342 */       } catch (Throwable throwable) {
/*     */         break;
/*     */       } 
/*     */     } 
/* 346 */     this.time = System.currentTimeMillis() - this.start;
/*     */   }
/*     */   private void tick() {
/*     */     List<Object[]> list;
/* 350 */     if (this.interval > 0) {
/* 351 */       if (this.paused) {
/*     */         return;
/*     */       }
/*     */       try {
/* 355 */         Thread.sleep(this.interval);
/* 356 */       } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 362 */     if (this.pid != 0) {
/* 363 */       list = readRunnableStackTraces(this.pid);
/*     */     } else {
/* 365 */       list = getRunnableStackTraces();
/*     */     } 
/* 367 */     this.threadDumps++;
/* 368 */     processList(list);
/*     */   }
/*     */   
/*     */   private void processList(List<Object[]> paramList) {
/* 372 */     for (Object[] arrayOfObject : paramList) {
/* 373 */       if (startsWithAny(arrayOfObject[0].toString(), this.ignoreThreads)) {
/*     */         continue;
/*     */       }
/* 376 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 378 */       String str = null;
/* 379 */       boolean bool = false;
/* 380 */       for (byte b1 = 0, b2 = 0; b2 < arrayOfObject.length && b1 < this.depth; b2++) {
/* 381 */         String str1 = arrayOfObject[b2].toString();
/* 382 */         if (!str1.equals(str) && !startsWithAny(str1, this.ignoreLines)) {
/* 383 */           str = str1;
/* 384 */           stringBuilder.append("at ").append(str1).append(LINE_SEPARATOR);
/* 385 */           if (!bool && !startsWithAny(str1, this.ignorePackages)) {
/* 386 */             bool = true;
/* 387 */             byte b = 0;
/* 388 */             for (; b < str1.length(); b++) {
/* 389 */               char c = str1.charAt(b);
/* 390 */               if (c == '(' || Character.isUpperCase(c)) {
/*     */                 break;
/*     */               }
/*     */             } 
/* 394 */             if (b > 0 && str1.charAt(b - 1) == '.') {
/* 395 */               b--;
/*     */             }
/* 397 */             if (this.sumClasses) {
/* 398 */               int i = str1.indexOf('.', b + 1);
/* 399 */               b = (i >= 0) ? i : b;
/*     */             } 
/* 401 */             if (this.sumMethods) {
/* 402 */               int i = str1.indexOf('(', b + 1);
/* 403 */               b = (i >= 0) ? i : b;
/*     */             } 
/* 405 */             String str2 = str1.substring(0, b);
/* 406 */             increment(this.summary, str2, 0);
/*     */           } 
/* 408 */           b1++;
/*     */         } 
/*     */       } 
/* 411 */       if (stringBuilder.length() > 0) {
/* 412 */         this.minCount = increment(this.counts, stringBuilder.toString().trim(), this.minCount);
/* 413 */         this.total++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean startsWithAny(String paramString, String[] paramArrayOfString) {
/* 419 */     for (String str : paramArrayOfString) {
/* 420 */       if (str.length() > 0 && paramString.startsWith(str)) {
/* 421 */         return true;
/*     */       }
/*     */     } 
/* 424 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int increment(HashMap<String, Integer> paramHashMap, String paramString, int paramInt) {
/* 429 */     Integer integer = paramHashMap.get(paramString);
/* 430 */     if (integer == null) {
/* 431 */       paramHashMap.put(paramString, Integer.valueOf(1));
/*     */     } else {
/* 433 */       paramHashMap.put(paramString, Integer.valueOf(integer.intValue() + 1));
/*     */     } 
/* 435 */     while (paramHashMap.size() > 1000) {
/* 436 */       Iterator<Map.Entry> iterator = paramHashMap.entrySet().iterator();
/* 437 */       while (iterator.hasNext()) {
/* 438 */         Map.Entry entry = iterator.next();
/* 439 */         if (((Integer)entry.getValue()).intValue() <= paramInt) {
/* 440 */           iterator.remove();
/*     */         }
/*     */       } 
/* 443 */       if (paramHashMap.size() > 1000) {
/* 444 */         paramInt++;
/*     */       }
/*     */     } 
/* 447 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTop(int paramInt) {
/* 457 */     stopCollecting();
/* 458 */     return getTopTraces(paramInt);
/*     */   }
/*     */   
/*     */   private String getTopTraces(int paramInt) {
/* 462 */     StringBuilder stringBuilder = new StringBuilder();
/* 463 */     stringBuilder.append("Profiler: top ").append(paramInt).append(" stack trace(s) of ");
/* 464 */     if (this.time > 0L) {
/* 465 */       stringBuilder.append(" of ").append(this.time).append(" ms");
/*     */     }
/* 467 */     if (this.threadDumps > 0) {
/* 468 */       stringBuilder.append(" of ").append(this.threadDumps).append(" thread dumps");
/*     */     }
/* 470 */     stringBuilder.append(":").append(LINE_SEPARATOR);
/* 471 */     if (this.counts.size() == 0) {
/* 472 */       stringBuilder.append("(none)").append(LINE_SEPARATOR);
/*     */     }
/* 474 */     HashMap<String, Integer> hashMap = new HashMap<>(this.counts);
/* 475 */     appendTop(stringBuilder, hashMap, paramInt, this.total, false);
/* 476 */     stringBuilder.append("summary:").append(LINE_SEPARATOR);
/* 477 */     hashMap = new HashMap<>(this.summary);
/* 478 */     appendTop(stringBuilder, hashMap, paramInt, this.total, true);
/* 479 */     stringBuilder.append('.');
/* 480 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void appendTop(StringBuilder paramStringBuilder, HashMap<String, Integer> paramHashMap, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 485 */     byte b = 0; int i = 0; while (true) {
/* 486 */       int j = 0;
/* 487 */       Map.Entry<String, Integer> entry = null;
/* 488 */       for (Map.Entry<String, Integer> entry1 : paramHashMap.entrySet()) {
/* 489 */         if (((Integer)entry1.getValue()).intValue() > j) {
/* 490 */           entry = entry1;
/* 491 */           j = ((Integer)entry1.getValue()).intValue();
/*     */         } 
/*     */       } 
/* 494 */       if (entry == null) {
/*     */         break;
/*     */       }
/* 497 */       paramHashMap.remove(entry.getKey());
/* 498 */       if (++b >= paramInt1) {
/* 499 */         if (((Integer)entry.getValue()).intValue() < i) {
/*     */           break;
/*     */         }
/* 502 */         i = ((Integer)entry.getValue()).intValue();
/*     */       } 
/* 504 */       int k = ((Integer)entry.getValue()).intValue();
/* 505 */       int m = 100 * k / Math.max(paramInt2, 1);
/* 506 */       if (paramBoolean) {
/* 507 */         if (m > 1) {
/* 508 */           paramStringBuilder.append(m).append("%: ").append(entry.getKey()).append(LINE_SEPARATOR);
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/* 513 */       paramStringBuilder.append(k).append('/').append(paramInt2).append(" (").append(m).append("%):").append(LINE_SEPARATOR).append(entry.getKey()).append(LINE_SEPARATOR);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\Profiler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */