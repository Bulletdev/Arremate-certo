/*     */ package org.apache.poi.sl.usermodel;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.OldFileFormatException;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SlideShowFactory
/*     */ {
/*     */   public static SlideShow<?, ?> create(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*  44 */     return create(paramNPOIFSFileSystem, (String)null);
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
/*     */   public static SlideShow<?, ?> create(NPOIFSFileSystem paramNPOIFSFileSystem, String paramString) throws IOException {
/*  59 */     DirectoryNode directoryNode = paramNPOIFSFileSystem.getRoot();
/*     */ 
/*     */     
/*  62 */     if (directoryNode.hasEntry("EncryptedPackage")) {
/*  63 */       InputStream inputStream = null;
/*     */       try {
/*  65 */         inputStream = DocumentFactoryHelper.getDecryptedStream(paramNPOIFSFileSystem, paramString);
/*     */         
/*  67 */         return createXSLFSlideShow(new Object[] { inputStream });
/*     */       } finally {
/*  69 */         if (inputStream != null) inputStream.close();
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  75 */     if (paramString != null) {
/*  76 */       Biff8EncryptionKey.setCurrentUserPassword(paramString);
/*     */     }
/*     */     try {
/*  79 */       return createHSLFSlideShow(new Object[] { paramNPOIFSFileSystem });
/*     */     } finally {
/*  81 */       Biff8EncryptionKey.setCurrentUserPassword(null);
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
/*     */   
/*     */   public static SlideShow<?, ?> create(InputStream paramInputStream) throws IOException, EncryptedDocumentException {
/* 107 */     return create(paramInputStream, (String)null);
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
/*     */   public static SlideShow<?, ?> create(InputStream paramInputStream, String paramString) throws IOException, EncryptedDocumentException {
/* 133 */     if (!paramInputStream.markSupported()) {
/* 134 */       paramInputStream = new PushbackInputStream(paramInputStream, 8);
/*     */     }
/*     */ 
/*     */     
/* 138 */     byte[] arrayOfByte = IOUtils.peekFirst8Bytes(paramInputStream);
/*     */ 
/*     */     
/* 141 */     if (NPOIFSFileSystem.hasPOIFSHeader(arrayOfByte)) {
/* 142 */       NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(paramInputStream);
/* 143 */       return create(nPOIFSFileSystem, paramString);
/*     */     } 
/* 145 */     if (DocumentFactoryHelper.hasOOXMLHeader(paramInputStream)) {
/* 146 */       return createXSLFSlideShow(new Object[] { paramInputStream });
/*     */     }
/* 148 */     throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
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
/*     */   public static SlideShow<?, ?> create(File paramFile) throws IOException, EncryptedDocumentException {
/* 165 */     return create(paramFile, (String)null);
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
/*     */   public static SlideShow<?, ?> create(File paramFile, String paramString) throws IOException, EncryptedDocumentException {
/* 184 */     return create(paramFile, paramString, false);
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
/*     */   public static SlideShow<?, ?> create(File paramFile, String paramString, boolean paramBoolean) throws IOException, EncryptedDocumentException {
/* 205 */     if (!paramFile.exists()) {
/* 206 */       throw new FileNotFoundException(paramFile.toString());
/*     */     }
/*     */     
/* 209 */     NPOIFSFileSystem nPOIFSFileSystem = null;
/*     */     try {
/* 211 */       nPOIFSFileSystem = new NPOIFSFileSystem(paramFile, paramBoolean);
/* 212 */       return create(nPOIFSFileSystem, paramString);
/* 213 */     } catch (OfficeXmlFileException officeXmlFileException) {
/* 214 */       if (nPOIFSFileSystem != null) {
/* 215 */         nPOIFSFileSystem.close();
/*     */       }
/* 217 */       return createXSLFSlideShow(new Object[] { paramFile, Boolean.valueOf(paramBoolean) });
/* 218 */     } catch (RuntimeException runtimeException) {
/* 219 */       if (nPOIFSFileSystem != null) {
/* 220 */         nPOIFSFileSystem.close();
/*     */       }
/* 222 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected static SlideShow<?, ?> createHSLFSlideShow(Object... paramVarArgs) throws IOException, EncryptedDocumentException {
/* 227 */     return createSlideShow("org.apache.poi.hslf.usermodel.HSLFSlideShowFactory", paramVarArgs);
/*     */   }
/*     */   
/*     */   protected static SlideShow<?, ?> createXSLFSlideShow(Object... paramVarArgs) throws IOException, EncryptedDocumentException {
/* 231 */     return createSlideShow("org.apache.poi.xslf.usermodel.XSLFSlideShowFactory", paramVarArgs);
/*     */   }
/*     */   
/*     */   protected static SlideShow<?, ?> createSlideShow(String paramString, Object[] paramArrayOfObject) throws IOException, EncryptedDocumentException {
/*     */     try {
/* 236 */       Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(paramString);
/* 237 */       Class[] arrayOfClass = new Class[paramArrayOfObject.length];
/* 238 */       byte b = 0;
/* 239 */       for (Object object : paramArrayOfObject) {
/* 240 */         Class<?> clazz1 = object.getClass();
/* 241 */         if (Boolean.class.isAssignableFrom(clazz1)) {
/* 242 */           clazz1 = boolean.class;
/* 243 */         } else if (InputStream.class.isAssignableFrom(clazz1)) {
/* 244 */           clazz1 = InputStream.class;
/*     */         } 
/* 246 */         arrayOfClass[b++] = clazz1;
/*     */       } 
/* 248 */       Method method = clazz.getMethod("createSlideShow", arrayOfClass);
/* 249 */       return (SlideShow<?, ?>)method.invoke(null, paramArrayOfObject);
/* 250 */     } catch (InvocationTargetException invocationTargetException) {
/* 251 */       Throwable throwable = invocationTargetException.getCause();
/* 252 */       if (throwable instanceof IOException)
/* 253 */         throw (IOException)throwable; 
/* 254 */       if (throwable instanceof EncryptedDocumentException)
/* 255 */         throw (EncryptedDocumentException)throwable; 
/* 256 */       if (throwable instanceof OldFileFormatException) {
/* 257 */         throw (OldFileFormatException)throwable;
/*     */       }
/* 259 */       throw new IOException(throwable);
/*     */     }
/* 261 */     catch (Exception exception) {
/* 262 */       throw new IOException(exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\SlideShowFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */