/*      */ package org.apache.commons.io;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.CharArrayWriter;
/*      */ import java.io.Closeable;
/*      */ import java.io.EOFException;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.Reader;
/*      */ import java.io.Writer;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.ServerSocket;
/*      */ import java.net.Socket;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.CharBuffer;
/*      */ import java.nio.channels.ReadableByteChannel;
/*      */ import java.nio.channels.Selector;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import java.util.function.Consumer;
/*      */ import org.apache.commons.io.function.IOConsumer;
/*      */ import org.apache.commons.io.output.AppendableWriter;
/*      */ import org.apache.commons.io.output.ByteArrayOutputStream;
/*      */ import org.apache.commons.io.output.NullOutputStream;
/*      */ import org.apache.commons.io.output.StringBuilderWriter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class IOUtils
/*      */ {
/*  108 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int DEFAULT_BUFFER_SIZE = 8192;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  118 */   public static final char DIR_SEPARATOR = File.separatorChar;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final char DIR_SEPARATOR_UNIX = '/';
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final char DIR_SEPARATOR_WINDOWS = '\\';
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int EOF = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  142 */   public static final String LINE_SEPARATOR = System.lineSeparator();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String LINE_SEPARATOR_UNIX = "\n";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  157 */   private static final byte[] SKIP_BYTE_BUFFER = new byte[8192];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static char[] SKIP_CHAR_BUFFER;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedInputStream buffer(InputStream paramInputStream) {
/*  185 */     Objects.requireNonNull(paramInputStream, "inputStream");
/*  186 */     return (paramInputStream instanceof BufferedInputStream) ? (BufferedInputStream)paramInputStream : new BufferedInputStream(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedInputStream buffer(InputStream paramInputStream, int paramInt) {
/*  204 */     Objects.requireNonNull(paramInputStream, "inputStream");
/*  205 */     return (paramInputStream instanceof BufferedInputStream) ? (BufferedInputStream)paramInputStream : new BufferedInputStream(paramInputStream, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedOutputStream buffer(OutputStream paramOutputStream) {
/*  222 */     Objects.requireNonNull(paramOutputStream, "outputStream");
/*  223 */     return (paramOutputStream instanceof BufferedOutputStream) ? (BufferedOutputStream)paramOutputStream : new BufferedOutputStream(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedOutputStream buffer(OutputStream paramOutputStream, int paramInt) {
/*  241 */     Objects.requireNonNull(paramOutputStream, "outputStream");
/*  242 */     return (paramOutputStream instanceof BufferedOutputStream) ? (BufferedOutputStream)paramOutputStream : new BufferedOutputStream(paramOutputStream, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader buffer(Reader paramReader) {
/*  256 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader buffer(Reader paramReader, int paramInt) {
/*  270 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedWriter buffer(Writer paramWriter) {
/*  283 */     return (paramWriter instanceof BufferedWriter) ? (BufferedWriter)paramWriter : new BufferedWriter(paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedWriter buffer(Writer paramWriter, int paramInt) {
/*  297 */     return (paramWriter instanceof BufferedWriter) ? (BufferedWriter)paramWriter : new BufferedWriter(paramWriter, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void close(Closeable paramCloseable) throws IOException {
/*  308 */     if (paramCloseable != null) {
/*  309 */       paramCloseable.close();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void close(Closeable... paramVarArgs) throws IOException {
/*  321 */     if (paramVarArgs != null) {
/*  322 */       for (Closeable closeable : paramVarArgs) {
/*  323 */         close(closeable);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void close(Closeable paramCloseable, IOConsumer<IOException> paramIOConsumer) throws IOException {
/*  337 */     if (paramCloseable != null) {
/*      */       try {
/*  339 */         paramCloseable.close();
/*  340 */       } catch (IOException iOException) {
/*  341 */         if (paramIOConsumer != null) {
/*  342 */           paramIOConsumer.accept(iOException);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void close(URLConnection paramURLConnection) {
/*  355 */     if (paramURLConnection instanceof HttpURLConnection) {
/*  356 */       ((HttpURLConnection)paramURLConnection).disconnect();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Closeable paramCloseable) {
/*  401 */     closeQuietly(paramCloseable, (Consumer<IOException>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Closeable... paramVarArgs) {
/*  453 */     if (paramVarArgs == null) {
/*      */       return;
/*      */     }
/*  456 */     for (Closeable closeable : paramVarArgs) {
/*  457 */       closeQuietly(closeable);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void closeQuietly(Closeable paramCloseable, Consumer<IOException> paramConsumer) {
/*  469 */     if (paramCloseable != null) {
/*      */       try {
/*  471 */         paramCloseable.close();
/*  472 */       } catch (IOException iOException) {
/*  473 */         if (paramConsumer != null) {
/*  474 */           paramConsumer.accept(iOException);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(InputStream paramInputStream) {
/*  509 */     closeQuietly(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(OutputStream paramOutputStream) {
/*  542 */     closeQuietly(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Reader paramReader) {
/*  574 */     closeQuietly(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Selector paramSelector) {
/*  606 */     closeQuietly(paramSelector);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(ServerSocket paramServerSocket) {
/*  638 */     closeQuietly(paramServerSocket);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Socket paramSocket) {
/*  670 */     closeQuietly(paramSocket);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Writer paramWriter) {
/*  701 */     closeQuietly(paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long consume(InputStream paramInputStream) throws IOException {
/*  717 */     return copyLarge(paramInputStream, (OutputStream)NullOutputStream.NULL_OUTPUT_STREAM, SKIP_BYTE_BUFFER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2) throws IOException {
/*  738 */     if (paramInputStream1 == paramInputStream2) {
/*  739 */       return true;
/*      */     }
/*  741 */     if ((((paramInputStream1 == null) ? 1 : 0) ^ ((paramInputStream2 == null) ? 1 : 0)) != 0) {
/*  742 */       return false;
/*      */     }
/*  744 */     BufferedInputStream bufferedInputStream1 = buffer(paramInputStream1);
/*  745 */     BufferedInputStream bufferedInputStream2 = buffer(paramInputStream2);
/*  746 */     int i = bufferedInputStream1.read();
/*  747 */     while (-1 != i) {
/*  748 */       int j = bufferedInputStream2.read();
/*  749 */       if (i != j) {
/*  750 */         return false;
/*      */       }
/*  752 */       i = bufferedInputStream1.read();
/*      */     } 
/*  754 */     return (bufferedInputStream2.read() == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEquals(Reader paramReader1, Reader paramReader2) throws IOException {
/*  776 */     if (paramReader1 == paramReader2) {
/*  777 */       return true;
/*      */     }
/*  779 */     if ((((paramReader1 == null) ? 1 : 0) ^ ((paramReader2 == null) ? 1 : 0)) != 0) {
/*  780 */       return false;
/*      */     }
/*  782 */     BufferedReader bufferedReader1 = toBufferedReader(paramReader1);
/*  783 */     BufferedReader bufferedReader2 = toBufferedReader(paramReader2);
/*      */     
/*  785 */     int i = bufferedReader1.read();
/*  786 */     while (-1 != i) {
/*  787 */       int j = bufferedReader2.read();
/*  788 */       if (i != j) {
/*  789 */         return false;
/*      */       }
/*  791 */       i = bufferedReader1.read();
/*      */     } 
/*      */     
/*  794 */     return (bufferedReader2.read() == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEqualsIgnoreEOL(Reader paramReader1, Reader paramReader2) throws IOException {
/*  814 */     if (paramReader1 == paramReader2) {
/*  815 */       return true;
/*      */     }
/*  817 */     if ((((paramReader1 == null) ? 1 : 0) ^ ((paramReader2 == null) ? 1 : 0)) != 0) {
/*  818 */       return false;
/*      */     }
/*  820 */     BufferedReader bufferedReader1 = toBufferedReader(paramReader1);
/*  821 */     BufferedReader bufferedReader2 = toBufferedReader(paramReader2);
/*      */     
/*  823 */     String str1 = bufferedReader1.readLine();
/*  824 */     String str2 = bufferedReader2.readLine();
/*  825 */     while (str1 != null && str1.equals(str2)) {
/*  826 */       str1 = bufferedReader1.readLine();
/*  827 */       str2 = bufferedReader2.readLine();
/*      */     } 
/*  829 */     return Objects.equals(str1, str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/*  854 */     long l = copyLarge(paramInputStream, paramOutputStream);
/*  855 */     if (l > 2147483647L) {
/*  856 */       return -1;
/*      */     }
/*  858 */     return (int)l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) throws IOException {
/*  878 */     return copyLarge(paramInputStream, paramOutputStream, new byte[paramInt]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void copy(InputStream paramInputStream, Writer paramWriter) throws IOException {
/*  900 */     copy(paramInputStream, paramWriter, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(InputStream paramInputStream, Writer paramWriter, Charset paramCharset) throws IOException {
/*  921 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset));
/*  922 */     copy(inputStreamReader, paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString) throws IOException {
/*  949 */     copy(paramInputStream, paramWriter, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copy(Reader paramReader, Appendable paramAppendable) throws IOException {
/*  971 */     return copy(paramReader, paramAppendable, CharBuffer.allocate(8192));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copy(Reader paramReader, Appendable paramAppendable, CharBuffer paramCharBuffer) throws IOException {
/*  990 */     long l = 0L;
/*      */     int i;
/*  992 */     while (-1 != (i = paramReader.read(paramCharBuffer))) {
/*  993 */       paramCharBuffer.flip();
/*  994 */       paramAppendable.append(paramCharBuffer, 0, i);
/*  995 */       l += i;
/*      */     } 
/*  997 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void copy(Reader paramReader, OutputStream paramOutputStream) throws IOException {
/* 1023 */     copy(paramReader, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(Reader paramReader, OutputStream paramOutputStream, Charset paramCharset) throws IOException {
/* 1051 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, Charsets.toCharset(paramCharset));
/* 1052 */     copy(paramReader, outputStreamWriter);
/*      */ 
/*      */     
/* 1055 */     outputStreamWriter.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString) throws IOException {
/* 1086 */     copy(paramReader, paramOutputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int copy(Reader paramReader, Writer paramWriter) throws IOException {
/* 1108 */     long l = copyLarge(paramReader, paramWriter);
/* 1109 */     if (l > 2147483647L) {
/* 1110 */       return -1;
/*      */     }
/* 1112 */     return (int)l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/* 1135 */     return copy(paramInputStream, paramOutputStream, 8192);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) throws IOException {
/* 1155 */     long l = 0L;
/* 1156 */     if (paramInputStream != null) {
/*      */       int i;
/* 1158 */       while (-1 != (i = paramInputStream.read(paramArrayOfbyte))) {
/* 1159 */         paramOutputStream.write(paramArrayOfbyte, 0, i);
/* 1160 */         l += i;
/*      */       } 
/*      */     } 
/* 1163 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2) throws IOException {
/* 1192 */     return copyLarge(paramInputStream, paramOutputStream, paramLong1, paramLong2, new byte[8192]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, byte[] paramArrayOfbyte) throws IOException {
/* 1221 */     if (paramLong1 > 0L) {
/* 1222 */       skipFully(paramInputStream, paramLong1);
/*      */     }
/* 1224 */     if (paramLong2 == 0L) {
/* 1225 */       return 0L;
/*      */     }
/* 1227 */     int i = paramArrayOfbyte.length;
/* 1228 */     int j = i;
/* 1229 */     if (paramLong2 > 0L && paramLong2 < i) {
/* 1230 */       j = (int)paramLong2;
/*      */     }
/*      */     
/* 1233 */     long l = 0L; int k;
/* 1234 */     while (j > 0 && -1 != (k = paramInputStream.read(paramArrayOfbyte, 0, j))) {
/* 1235 */       paramOutputStream.write(paramArrayOfbyte, 0, k);
/* 1236 */       l += k;
/* 1237 */       if (paramLong2 > 0L)
/*      */       {
/* 1239 */         j = (int)Math.min(paramLong2 - l, i);
/*      */       }
/*      */     } 
/* 1242 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter) throws IOException {
/* 1261 */     return copyLarge(paramReader, paramWriter, new char[8192]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter, char[] paramArrayOfchar) throws IOException {
/* 1280 */     long l = 0L;
/*      */     int i;
/* 1282 */     while (-1 != (i = paramReader.read(paramArrayOfchar))) {
/* 1283 */       paramWriter.write(paramArrayOfchar, 0, i);
/* 1284 */       l += i;
/*      */     } 
/* 1286 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2) throws IOException {
/* 1310 */     return copyLarge(paramReader, paramWriter, paramLong1, paramLong2, new char[8192]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2, char[] paramArrayOfchar) throws IOException {
/* 1335 */     if (paramLong1 > 0L) {
/* 1336 */       skipFully(paramReader, paramLong1);
/*      */     }
/* 1338 */     if (paramLong2 == 0L) {
/* 1339 */       return 0L;
/*      */     }
/* 1341 */     int i = paramArrayOfchar.length;
/* 1342 */     if (paramLong2 > 0L && paramLong2 < paramArrayOfchar.length) {
/* 1343 */       i = (int)paramLong2;
/*      */     }
/*      */     
/* 1346 */     long l = 0L; int j;
/* 1347 */     while (i > 0 && -1 != (j = paramReader.read(paramArrayOfchar, 0, i))) {
/* 1348 */       paramWriter.write(paramArrayOfchar, 0, j);
/* 1349 */       l += j;
/* 1350 */       if (paramLong2 > 0L)
/*      */       {
/* 1352 */         i = (int)Math.min(paramLong2 - l, paramArrayOfchar.length);
/*      */       }
/*      */     } 
/* 1355 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int length(byte[] paramArrayOfbyte) {
/* 1366 */     return (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int length(char[] paramArrayOfchar) {
/* 1377 */     return (paramArrayOfchar == null) ? 0 : paramArrayOfchar.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int length(CharSequence paramCharSequence) {
/* 1388 */     return (paramCharSequence == null) ? 0 : paramCharSequence.length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int length(Object[] paramArrayOfObject) {
/* 1399 */     return (paramArrayOfObject == null) ? 0 : paramArrayOfObject.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(InputStream paramInputStream, Charset paramCharset) throws IOException {
/* 1433 */     return new LineIterator(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(InputStream paramInputStream, String paramString) throws IOException {
/* 1470 */     return lineIterator(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(Reader paramReader) {
/* 1501 */     return new LineIterator(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
/* 1517 */     return read(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 1536 */     if (paramInt2 < 0) {
/* 1537 */       throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
/*      */     }
/* 1539 */     int i = paramInt2;
/* 1540 */     while (i > 0) {
/* 1541 */       int j = paramInt2 - i;
/* 1542 */       int k = paramInputStream.read(paramArrayOfbyte, paramInt1 + j, i);
/* 1543 */       if (-1 == k) {
/*      */         break;
/*      */       }
/* 1546 */       i -= k;
/*      */     } 
/* 1548 */     return paramInt2 - i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer) throws IOException {
/* 1565 */     int i = paramByteBuffer.remaining();
/* 1566 */     while (paramByteBuffer.remaining() > 0) {
/* 1567 */       int j = paramReadableByteChannel.read(paramByteBuffer);
/* 1568 */       if (-1 == j) {
/*      */         break;
/*      */       }
/*      */     } 
/* 1572 */     return i - paramByteBuffer.remaining();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(Reader paramReader, char[] paramArrayOfchar) throws IOException {
/* 1588 */     return read(paramReader, paramArrayOfchar, 0, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(Reader paramReader, char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 1607 */     if (paramInt2 < 0) {
/* 1608 */       throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
/*      */     }
/* 1610 */     int i = paramInt2;
/* 1611 */     while (i > 0) {
/* 1612 */       int j = paramInt2 - i;
/* 1613 */       int k = paramReader.read(paramArrayOfchar, paramInt1 + j, i);
/* 1614 */       if (-1 == k) {
/*      */         break;
/*      */       }
/* 1617 */       i -= k;
/*      */     } 
/* 1619 */     return paramInt2 - i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
/* 1637 */     readFully(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 1658 */     int i = read(paramInputStream, paramArrayOfbyte, paramInt1, paramInt2);
/* 1659 */     if (i != paramInt2) {
/* 1660 */       throw new EOFException("Length to read: " + paramInt2 + " actual: " + i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] readFully(InputStream paramInputStream, int paramInt) throws IOException {
/* 1679 */     byte[] arrayOfByte = new byte[paramInt];
/* 1680 */     readFully(paramInputStream, arrayOfByte, 0, arrayOfByte.length);
/* 1681 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer) throws IOException {
/* 1697 */     int i = paramByteBuffer.remaining();
/* 1698 */     int j = read(paramReadableByteChannel, paramByteBuffer);
/* 1699 */     if (j != i) {
/* 1700 */       throw new EOFException("Length to read: " + i + " actual: " + j);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(Reader paramReader, char[] paramArrayOfchar) throws IOException {
/* 1718 */     readFully(paramReader, paramArrayOfchar, 0, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(Reader paramReader, char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 1738 */     int i = read(paramReader, paramArrayOfchar, paramInt1, paramInt2);
/* 1739 */     if (i != paramInt2) {
/* 1740 */       throw new EOFException("Length to read: " + paramInt2 + " actual: " + i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static List<String> readLines(InputStream paramInputStream) throws IOException {
/* 1760 */     return readLines(paramInputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(InputStream paramInputStream, Charset paramCharset) throws IOException {
/* 1778 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset));
/* 1779 */     return readLines(inputStreamReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(InputStream paramInputStream, String paramString) throws IOException {
/* 1803 */     return readLines(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(Reader paramReader) throws IOException {
/* 1821 */     BufferedReader bufferedReader = toBufferedReader(paramReader);
/* 1822 */     ArrayList<String> arrayList = new ArrayList();
/*      */     String str;
/* 1824 */     while ((str = bufferedReader.readLine()) != null) {
/* 1825 */       arrayList.add(str);
/*      */     }
/* 1827 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] resourceToByteArray(String paramString) throws IOException {
/* 1845 */     return resourceToByteArray(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] resourceToByteArray(String paramString, ClassLoader paramClassLoader) throws IOException {
/* 1864 */     return toByteArray(resourceToURL(paramString, paramClassLoader));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String resourceToString(String paramString, Charset paramCharset) throws IOException {
/* 1884 */     return resourceToString(paramString, paramCharset, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String resourceToString(String paramString, Charset paramCharset, ClassLoader paramClassLoader) throws IOException {
/* 1905 */     return toString(resourceToURL(paramString, paramClassLoader), paramCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static URL resourceToURL(String paramString) throws IOException {
/* 1923 */     return resourceToURL(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static URL resourceToURL(String paramString, ClassLoader paramClassLoader) throws IOException {
/* 1944 */     URL uRL = (paramClassLoader == null) ? IOUtils.class.getResource(paramString) : paramClassLoader.getResource(paramString);
/*      */     
/* 1946 */     if (uRL == null) {
/* 1947 */       throw new IOException("Resource not found: " + paramString);
/*      */     }
/*      */     
/* 1950 */     return uRL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long skip(InputStream paramInputStream, long paramLong) throws IOException {
/* 1975 */     if (paramLong < 0L) {
/* 1976 */       throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1984 */     long l = paramLong;
/* 1985 */     while (l > 0L) {
/*      */       
/* 1987 */       long l1 = paramInputStream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l, SKIP_BYTE_BUFFER.length));
/* 1988 */       if (l1 < 0L) {
/*      */         break;
/*      */       }
/* 1991 */       l -= l1;
/*      */     } 
/* 1993 */     return paramLong - l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long skip(ReadableByteChannel paramReadableByteChannel, long paramLong) throws IOException {
/* 2009 */     if (paramLong < 0L) {
/* 2010 */       throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
/*      */     }
/* 2012 */     ByteBuffer byteBuffer = ByteBuffer.allocate((int)Math.min(paramLong, SKIP_BYTE_BUFFER.length));
/* 2013 */     long l = paramLong;
/* 2014 */     while (l > 0L) {
/* 2015 */       byteBuffer.position(0);
/* 2016 */       byteBuffer.limit((int)Math.min(l, SKIP_BYTE_BUFFER.length));
/* 2017 */       int i = paramReadableByteChannel.read(byteBuffer);
/* 2018 */       if (i == -1) {
/*      */         break;
/*      */       }
/* 2021 */       l -= i;
/*      */     } 
/* 2023 */     return paramLong - l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long skip(Reader paramReader, long paramLong) throws IOException {
/* 2048 */     if (paramLong < 0L) {
/* 2049 */       throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2056 */     if (SKIP_CHAR_BUFFER == null) {
/* 2057 */       SKIP_CHAR_BUFFER = new char[SKIP_BYTE_BUFFER.length];
/*      */     }
/* 2059 */     long l = paramLong;
/* 2060 */     while (l > 0L) {
/*      */       
/* 2062 */       long l1 = paramReader.read(SKIP_CHAR_BUFFER, 0, (int)Math.min(l, SKIP_BYTE_BUFFER.length));
/* 2063 */       if (l1 < 0L) {
/*      */         break;
/*      */       }
/* 2066 */       l -= l1;
/*      */     } 
/* 2068 */     return paramLong - l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void skipFully(InputStream paramInputStream, long paramLong) throws IOException {
/* 2091 */     if (paramLong < 0L) {
/* 2092 */       throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
/*      */     }
/* 2094 */     long l = skip(paramInputStream, paramLong);
/* 2095 */     if (l != paramLong) {
/* 2096 */       throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void skipFully(ReadableByteChannel paramReadableByteChannel, long paramLong) throws IOException {
/* 2111 */     if (paramLong < 0L) {
/* 2112 */       throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
/*      */     }
/* 2114 */     long l = skip(paramReadableByteChannel, paramLong);
/* 2115 */     if (l != paramLong) {
/* 2116 */       throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void skipFully(Reader paramReader, long paramLong) throws IOException {
/* 2140 */     long l = skip(paramReader, paramLong);
/* 2141 */     if (l != paramLong) {
/* 2142 */       throw new EOFException("Chars to skip: " + paramLong + " actual: " + l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toBufferedInputStream(InputStream paramInputStream) throws IOException {
/* 2168 */     return ByteArrayOutputStream.toBufferedInputStream(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt) throws IOException {
/* 2194 */     return ByteArrayOutputStream.toBufferedInputStream(paramInputStream, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader toBufferedReader(Reader paramReader) {
/* 2208 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader toBufferedReader(Reader paramReader, int paramInt) {
/* 2223 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
/* 2239 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream()) {
/* 2240 */       copy(paramInputStream, (OutputStream)byteArrayOutputStream);
/* 2241 */       return byteArrayOutputStream.toByteArray();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(InputStream paramInputStream, int paramInt) throws IOException {
/* 2260 */     if (paramInt < 0) {
/* 2261 */       throw new IllegalArgumentException("Size must be equal or greater than zero: " + paramInt);
/*      */     }
/*      */     
/* 2264 */     if (paramInt == 0) {
/* 2265 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/*      */     
/* 2268 */     byte[] arrayOfByte = new byte[paramInt];
/* 2269 */     int i = 0;
/*      */     
/*      */     int j;
/* 2272 */     while (i < paramInt && (j = paramInputStream.read(arrayOfByte, i, paramInt - i)) != -1) {
/* 2273 */       i += j;
/*      */     }
/*      */     
/* 2276 */     if (i != paramInt) {
/* 2277 */       throw new IOException("Unexpected read size. current: " + i + ", expected: " + paramInt);
/*      */     }
/*      */     
/* 2280 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(InputStream paramInputStream, long paramLong) throws IOException {
/* 2302 */     if (paramLong > 2147483647L) {
/* 2303 */       throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + paramLong);
/*      */     }
/*      */     
/* 2306 */     return toByteArray(paramInputStream, (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] toByteArray(Reader paramReader) throws IOException {
/* 2324 */     return toByteArray(paramReader, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(Reader paramReader, Charset paramCharset) throws IOException {
/* 2342 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream()) {
/* 2343 */       copy(paramReader, (OutputStream)byteArrayOutputStream, paramCharset);
/* 2344 */       return byteArrayOutputStream.toByteArray();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(Reader paramReader, String paramString) throws IOException {
/* 2369 */     return toByteArray(paramReader, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] toByteArray(String paramString) throws IOException {
/* 2387 */     return paramString.getBytes(Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(URI paramURI) throws IOException {
/* 2400 */     return toByteArray(paramURI.toURL());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(URL paramURL) throws IOException {
/* 2413 */     URLConnection uRLConnection = paramURL.openConnection();
/*      */     try {
/* 2415 */       return toByteArray(uRLConnection);
/*      */     } finally {
/* 2417 */       close(uRLConnection);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(URLConnection paramURLConnection) throws IOException {
/* 2431 */     try (InputStream null = paramURLConnection.getInputStream()) {
/* 2432 */       return toByteArray(inputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static char[] toCharArray(InputStream paramInputStream) throws IOException {
/* 2452 */     return toCharArray(paramInputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(InputStream paramInputStream, Charset paramCharset) throws IOException {
/* 2471 */     CharArrayWriter charArrayWriter = new CharArrayWriter();
/* 2472 */     copy(paramInputStream, charArrayWriter, paramCharset);
/* 2473 */     return charArrayWriter.toCharArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(InputStream paramInputStream, String paramString) throws IOException {
/* 2497 */     return toCharArray(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(Reader paramReader) throws IOException {
/* 2513 */     CharArrayWriter charArrayWriter = new CharArrayWriter();
/* 2514 */     copy(paramReader, charArrayWriter);
/* 2515 */     return charArrayWriter.toCharArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static InputStream toInputStream(CharSequence paramCharSequence) {
/* 2529 */     return toInputStream(paramCharSequence, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(CharSequence paramCharSequence, Charset paramCharset) {
/* 2542 */     return toInputStream(paramCharSequence.toString(), paramCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(CharSequence paramCharSequence, String paramString) throws IOException {
/* 2562 */     return toInputStream(paramCharSequence, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static InputStream toInputStream(String paramString) {
/* 2576 */     return toInputStream(paramString, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(String paramString, Charset paramCharset) {
/* 2589 */     return new ByteArrayInputStream(paramString.getBytes(Charsets.toCharset(paramCharset)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(String paramString1, String paramString2) throws IOException {
/* 2609 */     byte[] arrayOfByte = paramString1.getBytes(Charsets.toCharset(paramString2));
/* 2610 */     return new ByteArrayInputStream(arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(byte[] paramArrayOfbyte) throws IOException {
/* 2626 */     return new String(paramArrayOfbyte, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(byte[] paramArrayOfbyte, String paramString) throws IOException {
/* 2643 */     return new String(paramArrayOfbyte, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(InputStream paramInputStream) throws IOException {
/* 2661 */     return toString(paramInputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(InputStream paramInputStream, Charset paramCharset) throws IOException {
/* 2680 */     try (StringBuilderWriter null = new StringBuilderWriter()) {
/* 2681 */       copy(paramInputStream, (Writer)stringBuilderWriter, paramCharset);
/* 2682 */       return stringBuilderWriter.toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(InputStream paramInputStream, String paramString) throws IOException {
/* 2707 */     return toString(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Reader paramReader) throws IOException {
/* 2722 */     try (StringBuilderWriter null = new StringBuilderWriter()) {
/* 2723 */       copy(paramReader, (Writer)stringBuilderWriter);
/* 2724 */       return stringBuilderWriter.toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(URI paramURI) throws IOException {
/* 2739 */     return toString(paramURI, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URI paramURI, Charset paramCharset) throws IOException {
/* 2752 */     return toString(paramURI.toURL(), Charsets.toCharset(paramCharset));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URI paramURI, String paramString) throws IOException {
/* 2768 */     return toString(paramURI, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(URL paramURL) throws IOException {
/* 2782 */     return toString(paramURL, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URL paramURL, Charset paramCharset) throws IOException {
/* 2795 */     try (InputStream null = paramURL.openStream()) {
/* 2796 */       return toString(inputStream, paramCharset);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URL paramURL, String paramString) throws IOException {
/* 2813 */     return toString(paramURL, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(byte[] paramArrayOfbyte, OutputStream paramOutputStream) throws IOException {
/* 2828 */     if (paramArrayOfbyte != null) {
/* 2829 */       paramOutputStream.write(paramArrayOfbyte);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(byte[] paramArrayOfbyte, Writer paramWriter) throws IOException {
/* 2849 */     write(paramArrayOfbyte, paramWriter, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(byte[] paramArrayOfbyte, Writer paramWriter, Charset paramCharset) throws IOException {
/* 2867 */     if (paramArrayOfbyte != null) {
/* 2868 */       paramWriter.write(new String(paramArrayOfbyte, Charsets.toCharset(paramCharset)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(byte[] paramArrayOfbyte, Writer paramWriter, String paramString) throws IOException {
/* 2893 */     write(paramArrayOfbyte, paramWriter, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(char[] paramArrayOfchar, OutputStream paramOutputStream) throws IOException {
/* 2914 */     write(paramArrayOfchar, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(char[] paramArrayOfchar, OutputStream paramOutputStream, Charset paramCharset) throws IOException {
/* 2933 */     if (paramArrayOfchar != null) {
/* 2934 */       paramOutputStream.write((new String(paramArrayOfchar)).getBytes(Charsets.toCharset(paramCharset)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(char[] paramArrayOfchar, OutputStream paramOutputStream, String paramString) throws IOException {
/* 2960 */     write(paramArrayOfchar, paramOutputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(char[] paramArrayOfchar, Writer paramWriter) throws IOException {
/* 2974 */     if (paramArrayOfchar != null) {
/* 2975 */       paramWriter.write(paramArrayOfchar);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream) throws IOException {
/* 2996 */     write(paramCharSequence, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, Charset paramCharset) throws IOException {
/* 3014 */     if (paramCharSequence != null) {
/* 3015 */       write(paramCharSequence.toString(), paramOutputStream, paramCharset);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, String paramString) throws IOException {
/* 3039 */     write(paramCharSequence, paramOutputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(CharSequence paramCharSequence, Writer paramWriter) throws IOException {
/* 3052 */     if (paramCharSequence != null) {
/* 3053 */       write(paramCharSequence.toString(), paramWriter);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(String paramString, OutputStream paramOutputStream) throws IOException {
/* 3075 */     write(paramString, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(String paramString, OutputStream paramOutputStream, Charset paramCharset) throws IOException {
/* 3092 */     if (paramString != null) {
/* 3093 */       paramOutputStream.write(paramString.getBytes(Charsets.toCharset(paramCharset)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(String paramString1, OutputStream paramOutputStream, String paramString2) throws IOException {
/* 3117 */     write(paramString1, paramOutputStream, Charsets.toCharset(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(String paramString, Writer paramWriter) throws IOException {
/* 3130 */     if (paramString != null) {
/* 3131 */       paramWriter.write(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream) throws IOException {
/* 3152 */     write(paramStringBuffer, paramOutputStream, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream, String paramString) throws IOException {
/* 3177 */     if (paramStringBuffer != null) {
/* 3178 */       paramOutputStream.write(paramStringBuffer.toString().getBytes(Charsets.toCharset(paramString)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(StringBuffer paramStringBuffer, Writer paramWriter) throws IOException {
/* 3195 */     if (paramStringBuffer != null) {
/* 3196 */       paramWriter.write(paramStringBuffer.toString());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeChunked(byte[] paramArrayOfbyte, OutputStream paramOutputStream) throws IOException {
/* 3214 */     if (paramArrayOfbyte != null) {
/* 3215 */       int i = paramArrayOfbyte.length;
/* 3216 */       int j = 0;
/* 3217 */       while (i > 0) {
/* 3218 */         int k = Math.min(i, 8192);
/* 3219 */         paramOutputStream.write(paramArrayOfbyte, j, k);
/* 3220 */         i -= k;
/* 3221 */         j += k;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeChunked(char[] paramArrayOfchar, Writer paramWriter) throws IOException {
/* 3239 */     if (paramArrayOfchar != null) {
/* 3240 */       int i = paramArrayOfchar.length;
/* 3241 */       int j = 0;
/* 3242 */       while (i > 0) {
/* 3243 */         int k = Math.min(i, 8192);
/* 3244 */         paramWriter.write(paramArrayOfchar, j, k);
/* 3245 */         i -= k;
/* 3246 */         j += k;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream) throws IOException {
/* 3267 */     writeLines(paramCollection, paramString, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream, Charset paramCharset) throws IOException {
/* 3285 */     if (paramCollection == null) {
/*      */       return;
/*      */     }
/* 3288 */     if (paramString == null) {
/* 3289 */       paramString = System.lineSeparator();
/*      */     }
/* 3291 */     Charset charset = Charsets.toCharset(paramCharset);
/* 3292 */     for (Object object : paramCollection) {
/* 3293 */       if (object != null) {
/* 3294 */         paramOutputStream.write(object.toString().getBytes(charset));
/*      */       }
/* 3296 */       paramOutputStream.write(paramString.getBytes(charset));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString1, OutputStream paramOutputStream, String paramString2) throws IOException {
/* 3321 */     writeLines(paramCollection, paramString1, paramOutputStream, Charsets.toCharset(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString, Writer paramWriter) throws IOException {
/* 3337 */     if (paramCollection == null) {
/*      */       return;
/*      */     }
/* 3340 */     if (paramString == null) {
/* 3341 */       paramString = System.lineSeparator();
/*      */     }
/* 3343 */     for (Object object : paramCollection) {
/* 3344 */       if (object != null) {
/* 3345 */         paramWriter.write(object.toString());
/*      */       }
/* 3347 */       paramWriter.write(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Writer writer(Appendable paramAppendable) {
/* 3361 */     Objects.requireNonNull(paramAppendable, "appendable");
/* 3362 */     if (paramAppendable instanceof Writer) {
/* 3363 */       return (Writer)paramAppendable;
/*      */     }
/* 3365 */     if (paramAppendable instanceof StringBuilder) {
/* 3366 */       return (Writer)new StringBuilderWriter((StringBuilder)paramAppendable);
/*      */     }
/* 3368 */     return (Writer)new AppendableWriter(paramAppendable);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\IOUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */