/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.security.GeneralSecurityException;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.common.POIFSConstants;
/*     */ import org.apache.poi.poifs.crypt.Decryptor;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentFactoryHelper
/*     */ {
/*     */   public static InputStream getDecryptedStream(final NPOIFSFileSystem fs, String paramString) throws IOException {
/*  48 */     EncryptionInfo encryptionInfo = new EncryptionInfo(fs);
/*  49 */     Decryptor decryptor = Decryptor.getInstance(encryptionInfo);
/*     */     
/*     */     try {
/*  52 */       boolean bool = false;
/*  53 */       if (paramString != null && decryptor.verifyPassword(paramString)) {
/*  54 */         bool = true;
/*     */       }
/*  56 */       if (!bool && decryptor.verifyPassword("VelvetSweatshop")) {
/*  57 */         bool = true;
/*     */       }
/*     */       
/*  60 */       if (bool)
/*     */       {
/*     */         
/*  63 */         return new FilterInputStream(decryptor.getDataStream(fs.getRoot()))
/*     */           {
/*     */             public void close() throws IOException {
/*  66 */               fs.close();
/*     */               
/*  68 */               super.close();
/*     */             }
/*     */           };
/*     */       }
/*  72 */       if (paramString != null) {
/*  73 */         throw new EncryptedDocumentException("Password incorrect");
/*     */       }
/*  75 */       throw new EncryptedDocumentException("The supplied spreadsheet is protected, but no password was supplied");
/*     */     }
/*  77 */     catch (GeneralSecurityException generalSecurityException) {
/*  78 */       throw new IOException(generalSecurityException);
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
/*     */   public static boolean hasOOXMLHeader(InputStream paramInputStream) throws IOException {
/*  93 */     paramInputStream.mark(4);
/*     */     
/*  95 */     byte[] arrayOfByte = new byte[4];
/*  96 */     int i = IOUtils.readFully(paramInputStream, arrayOfByte);
/*     */ 
/*     */     
/*  99 */     if (paramInputStream instanceof PushbackInputStream) {
/* 100 */       PushbackInputStream pushbackInputStream = (PushbackInputStream)paramInputStream;
/* 101 */       pushbackInputStream.unread(arrayOfByte, 0, i);
/*     */     } else {
/* 103 */       paramInputStream.reset();
/*     */     } 
/*     */ 
/*     */     
/* 107 */     return (i == 4 && arrayOfByte[0] == POIFSConstants.OOXML_FILE_HEADER[0] && arrayOfByte[1] == POIFSConstants.OOXML_FILE_HEADER[1] && arrayOfByte[2] == POIFSConstants.OOXML_FILE_HEADER[2] && arrayOfByte[3] == POIFSConstants.OOXML_FILE_HEADER[3]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\DocumentFactoryHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */