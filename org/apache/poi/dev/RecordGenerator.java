/*     */ package org.apache.poi.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import java.util.Properties;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import javax.xml.transform.stream.StreamSource;
/*     */ import org.apache.poi.util.XMLHelper;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RecordGenerator
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  57 */     Class.forName("org.apache.poi.generator.FieldIterator");
/*     */     
/*  59 */     if (paramArrayOfString.length != 4) {
/*  60 */       System.out.println("Usage:");
/*  61 */       System.out.println("  java org.apache.poi.hssf.util.RecordGenerator RECORD_DEFINTIONS RECORD_STYLES DEST_SRC_PATH TEST_SRC_PATH");
/*     */     } else {
/*  63 */       generateRecords(paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void generateRecords(String paramString1, String paramString2, String paramString3, String paramString4) throws Exception {
/*  70 */     File[] arrayOfFile = (new File(paramString1)).listFiles();
/*  71 */     if (arrayOfFile == null) {
/*  72 */       System.err.println(paramString1 + " is not a directory.");
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     for (File file : arrayOfFile) {
/*  77 */       if (file.isFile() && (file.getName().endsWith("_record.xml") || file.getName().endsWith("_type.xml"))) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  83 */         DocumentBuilderFactory documentBuilderFactory = XMLHelper.getDocumentBuilderFactory();
/*  84 */         DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
/*  85 */         Document document = documentBuilder.parse(file);
/*  86 */         Element element = document.getDocumentElement();
/*  87 */         String str1 = element.getElementsByTagName("extends").item(0).getFirstChild().getNodeValue();
/*  88 */         String str2 = element.getElementsByTagName("suffix").item(0).getFirstChild().getNodeValue();
/*  89 */         String str3 = element.getAttributes().getNamedItem("name").getNodeValue();
/*  90 */         String str4 = element.getAttributes().getNamedItem("package").getNodeValue();
/*  91 */         str4 = str4.replace('.', '/');
/*     */ 
/*     */         
/*  94 */         String str5 = paramString3 + "/" + str4;
/*  95 */         File file1 = new File(str5);
/*  96 */         if (!file1.mkdirs()) {
/*  97 */           throw new IOException("Could not create directory " + file1);
/*     */         }
/*  99 */         System.out.println("Created destination directory: " + str5);
/*     */         
/* 101 */         String str6 = str5 + "/" + str3 + str2 + ".java";
/* 102 */         transform(file, new File(str6), new File(paramString2 + "/" + str1.toLowerCase(Locale.ROOT) + ".xsl"));
/*     */         
/* 104 */         System.out.println("Generated " + str2 + ": " + str6);
/*     */ 
/*     */         
/* 107 */         str5 = paramString4 + "/" + str4;
/* 108 */         file1 = new File(str5);
/* 109 */         if (!file1.mkdirs()) {
/* 110 */           throw new IOException("Could not create directory " + file1);
/*     */         }
/* 112 */         System.out.println("Created destination directory: " + str5);
/*     */         
/* 114 */         str6 = str5 + "/Test" + str3 + str2 + ".java";
/* 115 */         if (!(new File(str6)).exists()) {
/* 116 */           String str = paramString2 + "/" + str1.toLowerCase(Locale.ROOT) + "_test.xsl";
/* 117 */           transform(file, new File(str6), new File(str));
/* 118 */           System.out.println("Generated test: " + str6);
/*     */         } else {
/* 120 */           System.out.println("Skipped test generation: " + str6);
/*     */         } 
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
/*     */   private static void transform(File paramFile1, File paramFile2, File paramFile3) throws FileNotFoundException, TransformerException {
/*     */     Transformer transformer;
/* 141 */     StreamSource streamSource = new StreamSource(paramFile3);
/* 142 */     TransformerFactory transformerFactory = TransformerFactory.newInstance();
/*     */ 
/*     */     
/*     */     try {
/* 146 */       transformer = transformerFactory.newTransformer(streamSource);
/*     */     }
/* 148 */     catch (TransformerException transformerException) {
/*     */       
/* 150 */       System.err.println("Error compiling XSL style sheet " + paramFile3);
/* 151 */       throw transformerException;
/*     */     } 
/* 153 */     Properties properties = new Properties();
/* 154 */     properties.setProperty("method", "text");
/* 155 */     transformer.setOutputProperties(properties);
/* 156 */     StreamResult streamResult = new StreamResult(paramFile2);
/* 157 */     transformer.transform(new StreamSource(paramFile1), streamResult);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\dev\RecordGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */