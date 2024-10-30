/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.I;
/*     */ import com.google.a.b.w;
/*     */ import com.google.a.b.z;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.g.Q;
/*     */ import com.google.a.g.R;
/*     */ import com.google.a.h.n;
/*     */ import com.google.a.h.o;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.MappedByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
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
/*     */ @c
/*     */ public final class s
/*     */ {
/*     */   private static final int fU = 10000;
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static BufferedReader a(File paramFile, Charset paramCharset) throws FileNotFoundException {
/*  87 */     D.checkNotNull(paramFile);
/*  88 */     D.checkNotNull(paramCharset);
/*  89 */     return new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), paramCharset));
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
/*     */   @com.google.a.a.a
/*     */   public static BufferedWriter a(File paramFile, Charset paramCharset) throws FileNotFoundException {
/* 106 */     D.checkNotNull(paramFile);
/* 107 */     D.checkNotNull(paramCharset);
/* 108 */     return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramCharset));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a(File paramFile) {
/* 117 */     return new b(paramFile);
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     extends g {
/*     */     private final File file;
/*     */     
/*     */     private b(File param1File) {
/* 125 */       this.file = (File)D.checkNotNull(param1File);
/*     */     }
/*     */ 
/*     */     
/*     */     public FileInputStream a() throws IOException {
/* 130 */       return new FileInputStream(this.file);
/*     */     }
/*     */ 
/*     */     
/*     */     public z<Long> e() {
/* 135 */       if (this.file.isFile()) {
/* 136 */         return z.a(Long.valueOf(this.file.length()));
/*     */       }
/* 138 */       return z.b();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public long size() throws IOException {
/* 144 */       if (!this.file.isFile()) {
/* 145 */         throw new FileNotFoundException(this.file.toString());
/*     */       }
/* 147 */       return this.file.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] h() throws IOException {
/* 152 */       n n = n.a();
/*     */       try {
/* 154 */         FileInputStream fileInputStream = n.<FileInputStream>a(a());
/* 155 */         return h.toByteArray(fileInputStream, fileInputStream.getChannel().size());
/* 156 */       } catch (Throwable throwable) {
/* 157 */         throw n.rethrow(throwable);
/*     */       } finally {
/* 159 */         n.close();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 165 */       String str = String.valueOf(this.file); return (new StringBuilder(20 + String.valueOf(str).length())).append("Files.asByteSource(").append(str).append(")").toString();
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
/*     */   public static f a(File paramFile, r... paramVarArgs) {
/* 178 */     return new a(paramFile, paramVarArgs);
/*     */   }
/*     */   
/*     */   private static final class a
/*     */     extends f {
/*     */     private final File file;
/*     */     private final bt<r> g;
/*     */     
/*     */     private a(File param1File, r... param1VarArgs) {
/* 187 */       this.file = (File)D.checkNotNull(param1File);
/* 188 */       this.g = bt.a((Object[])param1VarArgs);
/*     */     }
/*     */ 
/*     */     
/*     */     public FileOutputStream a() throws IOException {
/* 193 */       return new FileOutputStream(this.file, this.g.contains(r.a));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 198 */       String str1 = String.valueOf(this.file), str2 = String.valueOf(this.g); return (new StringBuilder(20 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Files.asByteSink(").append(str1).append(", ").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static k a(File paramFile, Charset paramCharset) {
/* 209 */     return a(paramFile).a(paramCharset);
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
/*     */   public static j a(File paramFile, Charset paramCharset, r... paramVarArgs) {
/* 221 */     return a(paramFile, paramVarArgs).a(paramCharset);
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
/*     */   @com.google.a.a.a
/*     */   public static byte[] a(File paramFile) throws IOException {
/* 237 */     return a(paramFile).h();
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static String a(File paramFile, Charset paramCharset) throws IOException {
/* 254 */     return a(paramFile, paramCharset).dm();
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
/*     */   @com.google.a.a.a
/*     */   public static void a(byte[] paramArrayOfbyte, File paramFile) throws IOException {
/* 269 */     a(paramFile, new r[0]).write(paramArrayOfbyte);
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static void a(CharSequence paramCharSequence, File paramFile, Charset paramCharset) throws IOException {
/* 286 */     a(paramFile, paramCharset, new r[0]).a(paramCharSequence);
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
/*     */   @com.google.a.a.a
/*     */   public static void a(File paramFile, OutputStream paramOutputStream) throws IOException {
/* 301 */     a(paramFile).a(paramOutputStream);
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
/*     */   @com.google.a.a.a
/*     */   public static void a(File paramFile1, File paramFile2) throws IOException {
/* 325 */     D.a(!paramFile1.equals(paramFile2), "Source %s and destination %s must be different", paramFile1, paramFile2);
/* 326 */     a(paramFile1).a(a(paramFile2, new r[0]));
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static void a(File paramFile, Charset paramCharset, Appendable paramAppendable) throws IOException {
/* 344 */     a(paramFile, paramCharset).a(paramAppendable);
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static void b(CharSequence paramCharSequence, File paramFile, Charset paramCharset) throws IOException {
/* 362 */     a(paramFile, paramCharset, new r[] { (r)r.a }).a(paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static boolean b(File paramFile1, File paramFile2) throws IOException {
/* 372 */     D.checkNotNull(paramFile1);
/* 373 */     D.checkNotNull(paramFile2);
/* 374 */     if (paramFile1 == paramFile2 || paramFile1.equals(paramFile2)) {
/* 375 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 383 */     long l1 = paramFile1.length();
/* 384 */     long l2 = paramFile2.length();
/* 385 */     if (l1 != 0L && l2 != 0L && l1 != l2) {
/* 386 */       return false;
/*     */     }
/* 388 */     return a(paramFile1).a(a(paramFile2));
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static File createTempDir() {
/* 424 */     File file = new File(System.getProperty("java.io.tmpdir"));
/*     */     
/* 426 */     long l = System.currentTimeMillis(); String str = (new StringBuilder(21)).append(l).append("-").toString();
/*     */     
/* 428 */     for (byte b = 0; b < '✐'; b++) {
/* 429 */       byte b1 = b; File file1 = new File(file, (new StringBuilder(11 + String.valueOf(str).length())).append(str).append(b1).toString());
/* 430 */       if (file1.mkdir()) {
/* 431 */         return file1;
/*     */       }
/*     */     } 
/* 434 */     throw new IllegalStateException((new StringBuilder(66 + String.valueOf(str).length() + String.valueOf(str).length())).append("Failed to create directory within 10000 attempts (tried ").append(str).append("0 to ").append(str).append(9999).append(')').toString());
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
/*     */   @com.google.a.a.a
/*     */   public static void touch(File paramFile) throws IOException {
/* 455 */     D.checkNotNull(paramFile);
/* 456 */     if (!paramFile.createNewFile() && !paramFile.setLastModified(System.currentTimeMillis())) {
/* 457 */       String str = String.valueOf(paramFile); throw new IOException((new StringBuilder(38 + String.valueOf(str).length())).append("Unable to update modification time of ").append(str).toString());
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
/*     */   @com.google.a.a.a
/*     */   public static void b(File paramFile) throws IOException {
/* 472 */     D.checkNotNull(paramFile);
/* 473 */     File file = paramFile.getCanonicalFile().getParentFile();
/* 474 */     if (file == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 483 */     file.mkdirs();
/* 484 */     if (!file.isDirectory()) {
/* 485 */       String str = String.valueOf(paramFile); throw new IOException((new StringBuilder(39 + String.valueOf(str).length())).append("Unable to create parent directories of ").append(str).toString());
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
/*     */   @com.google.a.a.a
/*     */   public static void b(File paramFile1, File paramFile2) throws IOException {
/* 503 */     D.checkNotNull(paramFile1);
/* 504 */     D.checkNotNull(paramFile2);
/* 505 */     D.a(!paramFile1.equals(paramFile2), "Source %s and destination %s must be different", paramFile1, paramFile2);
/*     */     
/* 507 */     if (!paramFile1.renameTo(paramFile2)) {
/* 508 */       a(paramFile1, paramFile2);
/* 509 */       if (!paramFile1.delete()) {
/* 510 */         if (!paramFile2.delete()) {
/* 511 */           String str1 = String.valueOf(paramFile2); throw new IOException((new StringBuilder(17 + String.valueOf(str1).length())).append("Unable to delete ").append(str1).toString());
/*     */         } 
/* 513 */         String str = String.valueOf(paramFile1); throw new IOException((new StringBuilder(17 + String.valueOf(str).length())).append("Unable to delete ").append(str).toString());
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static String b(File paramFile, Charset paramCharset) throws IOException {
/* 534 */     return a(paramFile, paramCharset).dn();
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
/*     */   @com.google.a.a.a
/*     */   public static List<String> readLines(File paramFile, Charset paramCharset) throws IOException {
/* 557 */     return a(paramFile, paramCharset)
/* 558 */       .<List<String>>a(new x<List<String>>()
/*     */         {
/* 560 */           final List<String> result = bS.a();
/*     */ 
/*     */           
/*     */           public boolean t(String param1String) {
/* 564 */             this.result.add(param1String);
/* 565 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public List<String> Z() {
/* 570 */             return this.result;
/*     */           }
/*     */         });
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static <T> T a(File paramFile, Charset paramCharset, x<T> paramx) throws IOException {
/* 593 */     return a(paramFile, paramCharset).a(paramx);
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static <T> T a(File paramFile, e<T> parame) throws IOException {
/* 613 */     return a(paramFile).a(parame);
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
/*     */   @Deprecated
/*     */   @com.google.a.a.a
/*     */   public static n a(File paramFile, o paramo) throws IOException {
/* 631 */     return a(paramFile).a(paramo);
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
/*     */   @com.google.a.a.a
/*     */   public static MappedByteBuffer a(File paramFile) throws IOException {
/* 651 */     D.checkNotNull(paramFile);
/* 652 */     return a(paramFile, FileChannel.MapMode.READ_ONLY);
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
/*     */   @com.google.a.a.a
/*     */   public static MappedByteBuffer a(File paramFile, FileChannel.MapMode paramMapMode) throws IOException {
/* 674 */     return b(paramFile, paramMapMode, -1L);
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
/*     */   @com.google.a.a.a
/*     */   public static MappedByteBuffer a(File paramFile, FileChannel.MapMode paramMapMode, long paramLong) throws IOException {
/* 698 */     D.a((paramLong >= 0L), "size (%s) may not be negative", paramLong);
/* 699 */     return b(paramFile, paramMapMode, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   private static MappedByteBuffer b(File paramFile, FileChannel.MapMode paramMapMode, long paramLong) throws IOException {
/* 704 */     D.checkNotNull(paramFile);
/* 705 */     D.checkNotNull(paramMapMode);
/*     */     
/* 707 */     n n = n.a();
/*     */     
/*     */     try {
/* 710 */       RandomAccessFile randomAccessFile = n.<RandomAccessFile>a(new RandomAccessFile(paramFile, (paramMapMode == FileChannel.MapMode.READ_ONLY) ? "r" : "rw"));
/* 711 */       FileChannel fileChannel = n.<FileChannel>a(randomAccessFile.getChannel());
/* 712 */       return fileChannel.map(paramMapMode, 0L, (paramLong == -1L) ? fileChannel.size() : paramLong);
/* 713 */     } catch (Throwable throwable) {
/* 714 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 716 */       n.close();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static String ar(String paramString) {
/* 742 */     D.checkNotNull(paramString);
/* 743 */     if (paramString.length() == 0) {
/* 744 */       return ".";
/*     */     }
/*     */ 
/*     */     
/* 748 */     Iterable iterable = I.a('/').a().a(paramString);
/* 749 */     ArrayList<String> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 752 */     for (String str1 : iterable) {
/* 753 */       switch (str1) {
/*     */         case ".":
/*     */           continue;
/*     */         case "..":
/* 757 */           if (arrayList.size() > 0 && !((String)arrayList.get(arrayList.size() - 1)).equals("..")) {
/* 758 */             arrayList.remove(arrayList.size() - 1); continue;
/*     */           } 
/* 760 */           arrayList.add("..");
/*     */           continue;
/*     */       } 
/*     */       
/* 764 */       arrayList.add(str1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 770 */     String str = w.a('/').a(arrayList);
/* 771 */     if (paramString.charAt(0) == '/') {
/* 772 */       String.valueOf(str); str = (String.valueOf(str).length() != 0) ? "/".concat(String.valueOf(str)) : new String("/");
/*     */     } 
/*     */     
/* 775 */     while (str.startsWith("/../")) {
/* 776 */       str = str.substring(3);
/*     */     }
/* 778 */     if (str.equals("/..")) {
/* 779 */       str = "/";
/* 780 */     } else if ("".equals(str)) {
/* 781 */       str = ".";
/*     */     } 
/*     */     
/* 784 */     return str;
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
/*     */   @com.google.a.a.a
/*     */   public static String as(String paramString) {
/* 803 */     D.checkNotNull(paramString);
/* 804 */     String str = (new File(paramString)).getName();
/* 805 */     int i = str.lastIndexOf('.');
/* 806 */     return (i == -1) ? "" : str.substring(i + 1);
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
/*     */   @com.google.a.a.a
/*     */   public static String at(String paramString) {
/* 821 */     D.checkNotNull(paramString);
/* 822 */     String str = (new File(paramString)).getName();
/* 823 */     int i = str.lastIndexOf('.');
/* 824 */     return (i == -1) ? str : str.substring(0, i);
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
/*     */   @com.google.a.a.a
/*     */   public static R<File> a() {
/* 851 */     return R.b(d);
/*     */   }
/*     */   
/* 854 */   private static final Q<File> d = new Q<File>()
/*     */     {
/*     */       
/*     */       public Iterable<File> a(File param1File)
/*     */       {
/* 859 */         if (param1File.isDirectory()) {
/* 860 */           File[] arrayOfFile = param1File.listFiles();
/* 861 */           if (arrayOfFile != null) {
/* 862 */             return Collections.unmodifiableList(Arrays.asList(arrayOfFile));
/*     */           }
/*     */         } 
/*     */         
/* 866 */         return (Iterable<File>)bh.e();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static E<File> g() {
/* 877 */     return (E<File>)c.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static E<File> h() {
/* 887 */     return c.b;
/*     */   }
/*     */   
/*     */   private enum c implements E<File> {
/* 891 */     a
/*     */     {
/*     */       public boolean a(File param2File) {
/* 894 */         return param2File.isDirectory();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 899 */         return "Files.isDirectory()";
/*     */       }
/*     */     },
/*     */     
/* 903 */     b
/*     */     {
/*     */       public boolean a(File param2File) {
/* 906 */         return param2File.isFile();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 911 */         return "Files.isFile()";
/*     */       }
/*     */     };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */