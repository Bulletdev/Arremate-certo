/*     */ package org.apache.poi.openxml4j.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipException;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.SuppressForbidden;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZipSecureFile
/*     */   extends ZipFile
/*     */ {
/*  48 */   private static POILogger logger = POILogFactory.getLogger(ZipSecureFile.class);
/*     */   
/*  50 */   private static double MIN_INFLATE_RATIO = 0.01D;
/*  51 */   private static long MAX_ENTRY_SIZE = 4294967295L;
/*     */ 
/*     */   
/*     */   private static final long GRACE_ENTRY_SIZE = 102400L;
/*     */ 
/*     */   
/*  57 */   private static long MAX_TEXT_SIZE = 10485760L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setMinInflateRatio(double paramDouble) {
/*  68 */     MIN_INFLATE_RATIO = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getMinInflateRatio() {
/*  79 */     return MIN_INFLATE_RATIO;
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
/*     */   public static void setMaxEntrySize(long paramLong) {
/*  92 */     if (paramLong < 0L || paramLong > 4294967295L) {
/*  93 */       throw new IllegalArgumentException("Max entry size is bounded [0-4GB], but had " + paramLong);
/*     */     }
/*  95 */     MAX_ENTRY_SIZE = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getMaxEntrySize() {
/* 106 */     return MAX_ENTRY_SIZE;
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
/*     */   public static void setMaxTextSize(long paramLong) {
/* 120 */     if (paramLong < 0L || paramLong > 4294967295L) {
/* 121 */       throw new IllegalArgumentException("Max text size is bounded [0-4GB], but had " + paramLong);
/*     */     }
/* 123 */     MAX_TEXT_SIZE = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getMaxTextSize() {
/* 134 */     return MAX_TEXT_SIZE;
/*     */   }
/*     */   
/*     */   public ZipSecureFile(File paramFile, int paramInt) throws ZipException, IOException {
/* 138 */     super(paramFile, paramInt);
/*     */   }
/*     */   
/*     */   public ZipSecureFile(File paramFile) throws ZipException, IOException {
/* 142 */     super(paramFile);
/*     */   }
/*     */   
/*     */   public ZipSecureFile(String paramString) throws ZipException, IOException {
/* 146 */     super(paramString);
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
/*     */   public InputStream getInputStream(ZipEntry paramZipEntry) throws IOException {
/* 165 */     InputStream inputStream = super.getInputStream(paramZipEntry);
/* 166 */     return addThreshold(inputStream);
/*     */   }
/*     */   
/*     */   public static ThresholdInputStream addThreshold(final InputStream zipIS) throws IOException {
/*     */     ThresholdInputStream thresholdInputStream;
/* 171 */     if (zipIS instanceof java.util.zip.InflaterInputStream) {
/* 172 */       thresholdInputStream = AccessController.<ThresholdInputStream>doPrivileged(new PrivilegedAction<ThresholdInputStream>()
/*     */           {
/*     */             @SuppressForbidden("TODO: Fix this to not use reflection (it will break in Java 9)! Better would be to wrap *before* instead of tyring to insert wrapper afterwards.")
/*     */             public ZipSecureFile.ThresholdInputStream run() {
/*     */               try {
/* 177 */                 Field field = FilterInputStream.class.getDeclaredField("in");
/* 178 */                 field.setAccessible(true);
/* 179 */                 InputStream inputStream = (InputStream)field.get(zipIS);
/* 180 */                 ZipSecureFile.ThresholdInputStream thresholdInputStream = new ZipSecureFile.ThresholdInputStream(inputStream, null);
/* 181 */                 field.set(zipIS, thresholdInputStream);
/* 182 */                 return thresholdInputStream;
/* 183 */               } catch (Exception exception) {
/* 184 */                 ZipSecureFile.logger.log(5, new Object[] { "SecurityManager doesn't allow manipulation via reflection for zipbomb detection - continue with original input stream", exception });
/*     */                 
/* 186 */                 return null;
/*     */               } 
/*     */             }
/*     */           });
/*     */     } else {
/* 191 */       thresholdInputStream = null;
/*     */     } 
/*     */     
/* 194 */     return new ThresholdInputStream(zipIS, thresholdInputStream);
/*     */   }
/*     */   
/*     */   public static class ThresholdInputStream extends PushbackInputStream {
/* 198 */     long counter = 0L;
/*     */     ThresholdInputStream cis;
/*     */     
/*     */     public ThresholdInputStream(InputStream param1InputStream, ThresholdInputStream param1ThresholdInputStream) {
/* 202 */       super(param1InputStream, 1);
/* 203 */       this.cis = param1ThresholdInputStream;
/*     */     }
/*     */     
/*     */     public int read() throws IOException {
/* 207 */       int i = this.in.read();
/* 208 */       if (i > -1) advance(1); 
/* 209 */       return i;
/*     */     }
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 213 */       int i = this.in.read(param1ArrayOfbyte, param1Int1, param1Int2);
/* 214 */       if (i > -1) advance(i); 
/* 215 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public long skip(long param1Long) throws IOException {
/* 220 */       this.counter = 0L;
/* 221 */       return this.in.skip(param1Long);
/*     */     }
/*     */     
/*     */     public synchronized void reset() throws IOException {
/* 225 */       this.counter = 0L;
/* 226 */       this.in.reset();
/*     */     }
/*     */     
/*     */     public void advance(int param1Int) throws IOException {
/* 230 */       this.counter += param1Int;
/*     */ 
/*     */       
/* 233 */       if (this.counter > ZipSecureFile.MAX_ENTRY_SIZE) {
/* 234 */         throw new IOException("Zip bomb detected! The file would exceed the max size of the expanded data in the zip-file. This may indicates that the file is used to inflate memory usage and thus could pose a security risk. You can adjust this limit via ZipSecureFile.setMaxEntrySize() if you need to work with files which are very large. Counter: " + this.counter + ", cis.counter: " + ((this.cis == null) ? 0L : this.cis.counter) + "Limits: MAX_ENTRY_SIZE: " + ZipSecureFile.MAX_ENTRY_SIZE);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 242 */       if (this.cis == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 247 */       if (this.counter <= 102400L) {
/*     */         return;
/*     */       }
/*     */       
/* 251 */       double d = this.cis.counter / this.counter;
/* 252 */       if (d >= ZipSecureFile.MIN_INFLATE_RATIO) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 257 */       throw new IOException("Zip bomb detected! The file would exceed the max. ratio of compressed file size to the size of the expanded data. This may indicate that the file is used to inflate memory usage and thus could pose a security risk. You can adjust this limit via ZipSecureFile.setMinInflateRatio() if you need to work with files which exceed this limit. Counter: " + this.counter + ", cis.counter: " + this.cis.counter + ", ratio: " + (this.cis.counter / this.counter) + "Limits: MIN_INFLATE_RATIO: " + ZipSecureFile.MIN_INFLATE_RATIO);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ZipEntry getNextEntry() throws IOException {
/* 265 */       if (!(this.in instanceof ZipInputStream)) {
/* 266 */         throw new UnsupportedOperationException("underlying stream is not a ZipInputStream");
/*     */       }
/* 268 */       this.counter = 0L;
/* 269 */       return ((ZipInputStream)this.in).getNextEntry();
/*     */     }
/*     */     
/*     */     public void closeEntry() throws IOException {
/* 273 */       if (!(this.in instanceof ZipInputStream)) {
/* 274 */         throw new UnsupportedOperationException("underlying stream is not a ZipInputStream");
/*     */       }
/* 276 */       this.counter = 0L;
/* 277 */       ((ZipInputStream)this.in).closeEntry();
/*     */     }
/*     */     
/*     */     public void unread(int param1Int) throws IOException {
/* 281 */       if (!(this.in instanceof PushbackInputStream)) {
/* 282 */         throw new UnsupportedOperationException("underlying stream is not a PushbackInputStream");
/*     */       }
/* 284 */       if (--this.counter < 0L) this.counter = 0L; 
/* 285 */       ((PushbackInputStream)this.in).unread(param1Int);
/*     */     }
/*     */     
/*     */     public void unread(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 289 */       if (!(this.in instanceof PushbackInputStream)) {
/* 290 */         throw new UnsupportedOperationException("underlying stream is not a PushbackInputStream");
/*     */       }
/* 292 */       this.counter -= param1Int2;
/* 293 */       if (--this.counter < 0L) this.counter = 0L; 
/* 294 */       ((PushbackInputStream)this.in).unread(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     public int available() throws IOException {
/* 298 */       return this.in.available();
/*     */     }
/*     */     
/*     */     public boolean markSupported() {
/* 302 */       return this.in.markSupported();
/*     */     }
/*     */     
/*     */     public synchronized void mark(int param1Int) {
/* 306 */       this.in.mark(param1Int);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4\\util\ZipSecureFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */