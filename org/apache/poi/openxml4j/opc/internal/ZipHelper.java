/*     */ package org.apache.poi.openxml4j.opc.internal;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
/*     */ import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.ZipPackage;
/*     */ import org.apache.poi.openxml4j.util.ZipSecureFile;
/*     */ import org.apache.poi.poifs.common.POIFSConstants;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ZipHelper
/*     */ {
/*     */   private static final String FORWARD_SLASH = "/";
/*     */   public static final int READ_WRITE_FILE_BUFFER_SIZE = 8192;
/*     */   
/*     */   public static ZipEntry getCorePropertiesZipEntry(ZipPackage paramZipPackage) {
/*  74 */     PackageRelationship packageRelationship = paramZipPackage.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").getRelationship(0);
/*     */ 
/*     */     
/*  77 */     if (packageRelationship == null) {
/*  78 */       return null;
/*     */     }
/*  80 */     return new ZipEntry(packageRelationship.getTargetURI().getPath());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ZipEntry getContentTypeZipEntry(ZipPackage paramZipPackage) {
/*  87 */     Enumeration<ZipEntry> enumeration = paramZipPackage.getZipArchive().getEntries();
/*     */ 
/*     */ 
/*     */     
/*  91 */     while (enumeration.hasMoreElements()) {
/*  92 */       ZipEntry zipEntry = enumeration.nextElement();
/*  93 */       if (zipEntry.getName().equals("[Content_Types].xml"))
/*     */       {
/*  95 */         return zipEntry; } 
/*     */     } 
/*  97 */     return null;
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
/*     */   public static String getOPCNameFromZipItemName(String paramString) {
/* 109 */     if (paramString == null)
/* 110 */       throw new IllegalArgumentException("zipItemName"); 
/* 111 */     if (paramString.startsWith("/")) {
/* 112 */       return paramString;
/*     */     }
/* 114 */     return "/" + paramString;
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
/*     */   public static String getZipItemNameFromOPCName(String paramString) {
/* 126 */     if (paramString == null) {
/* 127 */       throw new IllegalArgumentException("opcItemName");
/*     */     }
/* 129 */     String str = paramString;
/* 130 */     while (str.startsWith("/"))
/* 131 */       str = str.substring(1); 
/* 132 */     return str;
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
/*     */   public static URI getZipURIFromOPCName(String paramString) {
/* 144 */     if (paramString == null) {
/* 145 */       throw new IllegalArgumentException("opcItemName");
/*     */     }
/* 147 */     String str = paramString;
/* 148 */     while (str.startsWith("/"))
/* 149 */       str = str.substring(1); 
/*     */     try {
/* 151 */       return new URI(str);
/* 152 */     } catch (URISyntaxException uRISyntaxException) {
/* 153 */       return null;
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
/*     */   public static void verifyZipHeader(InputStream paramInputStream) throws NotOfficeXmlFileException, IOException {
/* 166 */     byte[] arrayOfByte1 = new byte[8];
/* 167 */     IOUtils.readFully(paramInputStream, arrayOfByte1);
/*     */ 
/*     */     
/* 170 */     long l = LittleEndian.getLong(arrayOfByte1);
/* 171 */     if (l == -2226271756974174256L) {
/* 172 */       throw new OLE2NotOfficeXmlFileException("The supplied data appears to be in the OLE2 Format. You are calling the part of POI that deals with OOXML (Office Open XML) Documents. You need to call a different part of POI to process this data (eg HSSF instead of XSSF)");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     byte[] arrayOfByte2 = POIFSConstants.RAW_XML_FILE_HEADER;
/* 181 */     if (arrayOfByte1[0] == arrayOfByte2[0] && arrayOfByte1[1] == arrayOfByte2[1] && arrayOfByte1[2] == arrayOfByte2[2] && arrayOfByte1[3] == arrayOfByte2[3] && arrayOfByte1[4] == arrayOfByte2[4])
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 186 */       throw new NotOfficeXmlFileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     if (paramInputStream instanceof PushbackInputStream) {
/* 197 */       ((PushbackInputStream)paramInputStream).unread(arrayOfByte1);
/* 198 */     } else if (paramInputStream.markSupported()) {
/* 199 */       paramInputStream.reset();
/* 200 */     } else if (paramInputStream instanceof FileInputStream) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static InputStream prepareToCheckHeader(InputStream paramInputStream) {
/* 208 */     if (paramInputStream instanceof PushbackInputStream) {
/* 209 */       return paramInputStream;
/*     */     }
/* 211 */     if (paramInputStream.markSupported()) {
/* 212 */       paramInputStream.mark(8);
/* 213 */       return paramInputStream;
/*     */     } 
/* 215 */     return new PushbackInputStream(paramInputStream, 8);
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
/*     */   public static ZipSecureFile.ThresholdInputStream openZipStream(InputStream paramInputStream) throws IOException {
/* 228 */     InputStream inputStream = prepareToCheckHeader(paramInputStream);
/* 229 */     verifyZipHeader(inputStream);
/*     */ 
/*     */     
/* 232 */     ZipInputStream zipInputStream = new ZipInputStream(inputStream);
/* 233 */     return ZipSecureFile.addThreshold(zipInputStream);
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
/*     */   public static ZipFile openZipFile(File paramFile) throws IOException, NotOfficeXmlFileException {
/* 247 */     if (!paramFile.exists()) {
/* 248 */       throw new FileNotFoundException("File does not exist");
/*     */     }
/* 250 */     if (paramFile.isDirectory()) {
/* 251 */       throw new IOException("File is a directory");
/*     */     }
/*     */ 
/*     */     
/* 255 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/* 257 */       verifyZipHeader(fileInputStream);
/*     */     } finally {
/* 259 */       fileInputStream.close();
/*     */     } 
/*     */ 
/*     */     
/* 263 */     return (ZipFile)new ZipSecureFile(paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ZipFile openZipFile(String paramString) throws IOException {
/* 274 */     return openZipFile(new File(paramString));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\ZipHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */