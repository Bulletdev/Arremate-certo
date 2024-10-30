/*     */ package org.apache.poi.dev;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipException;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.apache.poi.openxml4j.opc.internal.ZipHelper;
/*     */ import org.apache.poi.openxml4j.util.ZipSecureFile;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.w3c.dom.Document;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OOXMLPrettyPrint
/*     */ {
/*  56 */   private final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/*     */   
/*     */   private final DocumentBuilder documentBuilder;
/*     */   
/*     */   public OOXMLPrettyPrint() throws ParserConfigurationException {
/*  61 */     ZipSecureFile.setMinInflateRatio(1.0E-5D);
/*     */     
/*  63 */     this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  67 */     if (paramArrayOfString.length <= 1 || paramArrayOfString.length % 2 != 0) {
/*  68 */       System.err.println("Use:");
/*  69 */       System.err.println("\tjava OOXMLPrettyPrint [<filename> <outfilename>] ...");
/*  70 */       System.exit(1);
/*     */     } 
/*     */     
/*  73 */     for (byte b = 0; b < paramArrayOfString.length; b += 2) {
/*  74 */       File file = new File(paramArrayOfString[b]);
/*  75 */       if (!file.exists()) {
/*  76 */         System.err.println("Error, file not found!");
/*  77 */         System.err.println("\t" + file.toString());
/*  78 */         System.exit(2);
/*     */       } 
/*     */       
/*  81 */       handleFile(file, new File(paramArrayOfString[b + 1]));
/*     */     } 
/*  83 */     System.out.println("Done.");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void handleFile(File paramFile1, File paramFile2) throws ZipException, IOException, TransformerException, ParserConfigurationException {
/*  88 */     System.out.println("Reading zip-file " + paramFile1 + " and writing pretty-printed XML to " + paramFile2);
/*     */     
/*  90 */     ZipFile zipFile = ZipHelper.openZipFile(paramFile1);
/*     */     try {
/*  92 */       ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile2)));
/*     */       try {
/*  94 */         (new OOXMLPrettyPrint()).handle(zipFile, zipOutputStream);
/*     */       } finally {
/*  96 */         zipOutputStream.close();
/*     */       } 
/*     */     } finally {
/*  99 */       zipFile.close();
/*     */       
/* 101 */       System.out.println();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void handle(ZipFile paramZipFile, ZipOutputStream paramZipOutputStream) throws IOException, TransformerException {
/* 106 */     Enumeration<? extends ZipEntry> enumeration = paramZipFile.entries();
/* 107 */     while (enumeration.hasMoreElements()) {
/* 108 */       ZipEntry zipEntry = enumeration.nextElement();
/*     */       
/* 110 */       String str = zipEntry.getName();
/* 111 */       paramZipOutputStream.putNextEntry(new ZipEntry(str));
/*     */       try {
/* 113 */         if (str.endsWith(".xml") || str.endsWith(".rels")) {
/* 114 */           Document document = this.documentBuilder.parse(new InputSource(paramZipFile.getInputStream(zipEntry)));
/* 115 */           document.setXmlStandalone(true);
/* 116 */           pretty(document, paramZipOutputStream, 2);
/*     */         } else {
/* 118 */           System.out.println("Not pretty-printing non-XML file " + str);
/* 119 */           IOUtils.copy(paramZipFile.getInputStream(zipEntry), paramZipOutputStream);
/*     */         } 
/* 121 */       } catch (Exception exception) {
/* 122 */         throw new IOException("While handling entry " + str, exception);
/*     */       } finally {
/* 124 */         paramZipOutputStream.closeEntry();
/*     */       } 
/* 126 */       System.out.print(".");
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void pretty(Document paramDocument, OutputStream paramOutputStream, int paramInt) throws TransformerException {
/* 131 */     TransformerFactory transformerFactory = TransformerFactory.newInstance();
/* 132 */     Transformer transformer = transformerFactory.newTransformer();
/* 133 */     transformer.setOutputProperty("encoding", "UTF-8");
/* 134 */     if (paramInt > 0) {
/*     */       
/* 136 */       transformer.setOutputProperty("indent", "yes");
/* 137 */       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(paramInt));
/*     */     } 
/* 139 */     StreamResult streamResult = new StreamResult(paramOutputStream);
/* 140 */     DOMSource dOMSource = new DOMSource(paramDocument);
/* 141 */     transformer.transform(dOMSource, streamResult);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\dev\OOXMLPrettyPrint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */