/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import javax.xml.stream.Location;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StreamInstanceValidator
/*     */ {
/*  42 */   private static final XMLInputFactory XML_INPUT_FACTORY = XMLInputFactory.newInstance();
/*     */ 
/*     */   
/*     */   public static void printUsage() {
/*  46 */     System.out.println("Validates the specified instance against the specified schema.");
/*  47 */     System.out.println("A streaming validation useful for validating very large instance ");
/*  48 */     System.out.println("documents with less memory. Contrast with the validate tool.");
/*  49 */     System.out.println("Usage: svalidate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
/*  50 */     System.out.println("Options:");
/*  51 */     System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
/*  52 */     System.out.println("    -noupa - do not enforce the unique particle attribution rule");
/*  53 */     System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
/*  54 */     System.out.println("    -license - prints license information");
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*     */     SchemaTypeSystem schemaTypeSystem;
/*  59 */     HashSet hashSet = new HashSet();
/*  60 */     hashSet.add("h");
/*  61 */     hashSet.add("help");
/*  62 */     hashSet.add("usage");
/*  63 */     hashSet.add("license");
/*  64 */     hashSet.add("version");
/*  65 */     hashSet.add("dl");
/*  66 */     hashSet.add("noupr");
/*  67 */     hashSet.add("noupa");
/*     */     
/*  69 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Collections.EMPTY_SET);
/*  70 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || paramArrayOfString.length < 1) {
/*     */       
/*  72 */       printUsage();
/*  73 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  77 */     String[] arrayOfString = commandLine.getBadOpts();
/*  78 */     if (arrayOfString.length > 0) {
/*     */       
/*  80 */       for (byte b1 = 0; b1 < arrayOfString.length; b1++)
/*  81 */         System.out.println("Unrecognized option: " + arrayOfString[b1]); 
/*  82 */       printUsage();
/*  83 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     if (commandLine.getOpt("license") != null) {
/*  88 */       CommandLine.printLicense();
/*  89 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  93 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  95 */       CommandLine.printVersion();
/*  96 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 100 */     if ((commandLine.args()).length == 0) {
/* 101 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/* 105 */     boolean bool1 = (commandLine.getOpt("dl") != null) ? true : false;
/* 106 */     boolean bool2 = (commandLine.getOpt("nopvr") != null) ? true : false;
/* 107 */     boolean bool3 = (commandLine.getOpt("noupa") != null) ? true : false;
/*     */     
/* 109 */     File[] arrayOfFile1 = commandLine.filesEndingWith(".xsd");
/* 110 */     File[] arrayOfFile2 = commandLine.filesEndingWith(".xml");
/* 111 */     File[] arrayOfFile3 = commandLine.filesEndingWith(".jar");
/*     */     
/* 113 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 115 */     XmlOptions xmlOptions1 = (new XmlOptions()).setLoadLineNumbers();
/* 116 */     for (byte b = 0; b < arrayOfFile1.length; b++) {
/*     */       try {
/* 118 */         arrayList.add(XmlObject.Factory.parse(arrayOfFile1[b], xmlOptions1.setLoadMessageDigest()));
/*     */ 
/*     */       
/*     */       }
/* 122 */       catch (Exception exception) {
/* 123 */         System.err.println(arrayOfFile1[b] + " not loadable: " + exception);
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     XmlObject[] arrayOfXmlObject = arrayList.<XmlObject>toArray(new XmlObject[0]);
/*     */     
/* 129 */     SchemaTypeLoader schemaTypeLoader = null;
/* 130 */     ArrayList arrayList1 = new ArrayList();
/* 131 */     XmlOptions xmlOptions2 = new XmlOptions();
/* 132 */     xmlOptions2.setErrorListener(arrayList1);
/* 133 */     if (bool1)
/* 134 */       xmlOptions2.setCompileDownloadUrls(); 
/* 135 */     if (bool2)
/* 136 */       xmlOptions2.setCompileNoPvrRule(); 
/* 137 */     if (bool3) {
/* 138 */       xmlOptions2.setCompileNoUpaRule();
/*     */     }
/* 140 */     if (arrayOfFile3 != null && arrayOfFile3.length > 0) {
/* 141 */       schemaTypeLoader = XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(arrayOfFile3));
/*     */     }
/*     */     try {
/* 144 */       if (arrayOfXmlObject != null && arrayOfXmlObject.length > 0) {
/* 145 */         schemaTypeSystem = XmlBeans.compileXsd(arrayOfXmlObject, schemaTypeLoader, xmlOptions2);
/*     */       }
/* 147 */     } catch (Exception exception) {
/* 148 */       if (arrayList1.isEmpty() || !(exception instanceof org.apache.xmlbeans.XmlException)) {
/* 149 */         exception.printStackTrace(System.err);
/*     */       }
/* 151 */       System.out.println("Schema invalid");
/* 152 */       for (Iterator iterator = arrayList1.iterator(); iterator.hasNext();) {
/* 153 */         System.out.println(iterator.next());
/*     */       }
/*     */       return;
/*     */     } 
/* 157 */     validateFiles(arrayOfFile2, (SchemaTypeLoader)schemaTypeSystem, xmlOptions1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateFiles(File[] paramArrayOfFile, SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions) {
/* 165 */     ValidatingXMLStreamReader validatingXMLStreamReader = new ValidatingXMLStreamReader();
/* 166 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 168 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 169 */       File file = paramArrayOfFile[b];
/* 170 */       String str = file.getPath();
/* 171 */       long l = 0L;
/*     */       
/* 173 */       arrayList.clear();
/*     */       
/*     */       try {
/* 176 */         FileInputStream fileInputStream = new FileInputStream(file);
/* 177 */         XMLStreamReader xMLStreamReader = XML_INPUT_FACTORY.createXMLStreamReader(str, fileInputStream);
/*     */ 
/*     */ 
/*     */         
/* 181 */         while (!xMLStreamReader.isStartElement()) {
/* 182 */           xMLStreamReader.next();
/*     */         }
/*     */         
/* 185 */         l = System.currentTimeMillis();
/* 186 */         validatingXMLStreamReader.init(xMLStreamReader, true, null, paramSchemaTypeLoader, paramXmlOptions, arrayList);
/*     */         
/* 188 */         while (validatingXMLStreamReader.hasNext()) {
/* 189 */           validatingXMLStreamReader.next();
/*     */         }
/*     */         
/* 192 */         l = System.currentTimeMillis() - l;
/* 193 */         validatingXMLStreamReader.close();
/* 194 */         fileInputStream.close();
/*     */       }
/* 196 */       catch (XMLStreamException xMLStreamException) {
/* 197 */         Location location = xMLStreamException.getLocation();
/* 198 */         XmlError xmlError = XmlError.forLocation(xMLStreamException.getMessage(), str, location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
/*     */ 
/*     */ 
/*     */         
/* 202 */         arrayList.add(xmlError);
/*     */       }
/* 204 */       catch (Exception exception) {
/* 205 */         System.err.println("error for file: " + file + ": " + exception);
/* 206 */         exception.printStackTrace(System.err);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 211 */       if (arrayList.isEmpty()) {
/* 212 */         System.out.println(file + " valid. (" + l + " ms)");
/*     */       } else {
/* 214 */         System.out.println(file + " NOT valid (" + l + " ms):");
/* 215 */         for (XmlError xmlError : arrayList)
/*     */         {
/* 217 */           System.out.println(stringFromError(xmlError, str));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String stringFromError(XmlError paramXmlError, String paramString) {
/* 227 */     return XmlError.severityAsString(paramXmlError.getSeverity()) + ": " + paramString + ":" + paramXmlError.getLine() + ":" + paramXmlError.getColumn() + " " + paramXmlError.getMessage() + " ";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\StreamInstanceValidator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */