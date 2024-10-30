/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.net.URL;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.poi.util.DocumentHelper;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POIXMLTypeLoader
/*     */ {
/*  51 */   public static final XmlOptions DEFAULT_XML_OPTIONS = new XmlOptions(); static {
/*  52 */     DEFAULT_XML_OPTIONS.setSaveOuter();
/*  53 */     DEFAULT_XML_OPTIONS.setUseDefaultNamespace();
/*  54 */     DEFAULT_XML_OPTIONS.setSaveAggressiveNamespaces();
/*  55 */     DEFAULT_XML_OPTIONS.setCharacterEncoding("UTF-8");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*  62 */     hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
/*  63 */     hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/chart", "c");
/*  64 */     hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
/*  65 */     hashMap.put("http://schemas.openxmlformats.org/markup-compatibility/2006", "ve");
/*  66 */     hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
/*  67 */     hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "r");
/*  68 */     hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vt");
/*  69 */     hashMap.put("http://schemas.openxmlformats.org/presentationml/2006/main", "p");
/*  70 */     hashMap.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
/*  71 */     hashMap.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
/*  72 */     hashMap.put("urn:schemas-microsoft-com:office:office", "o");
/*  73 */     hashMap.put("urn:schemas-microsoft-com:office:excel", "x");
/*  74 */     hashMap.put("urn:schemas-microsoft-com:office:word", "w10");
/*  75 */     hashMap.put("urn:schemas-microsoft-com:vml", "v");
/*  76 */     DEFAULT_XML_OPTIONS.setSaveSuggestedPrefixes(Collections.unmodifiableMap(hashMap));
/*     */   }
/*     */   
/*     */   private static XmlOptions getXmlOptions(XmlOptions paramXmlOptions) {
/*  80 */     return (paramXmlOptions == null) ? DEFAULT_XML_OPTIONS : paramXmlOptions;
/*     */   }
/*     */   
/*     */   public static XmlObject newInstance(SchemaType paramSchemaType, XmlOptions paramXmlOptions) {
/*  84 */     return XmlBeans.getContextTypeLoader().newInstance(paramSchemaType, getXmlOptions(paramXmlOptions));
/*     */   }
/*     */   
/*     */   public static XmlObject parse(String paramString, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException {
/*     */     try {
/*  89 */       return parse(new StringReader(paramString), paramSchemaType, paramXmlOptions);
/*  90 */     } catch (IOException iOException) {
/*  91 */       throw new XmlException("Unable to parse xml bean", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlObject parse(File paramFile, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/*  96 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */     try {
/*  98 */       return parse(fileInputStream, paramSchemaType, paramXmlOptions);
/*     */     } finally {
/* 100 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlObject parse(URL paramURL, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/* 105 */     InputStream inputStream = paramURL.openStream();
/*     */     try {
/* 107 */       return parse(inputStream, paramSchemaType, paramXmlOptions);
/*     */     } finally {
/* 109 */       inputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlObject parse(InputStream paramInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/*     */     try {
/* 115 */       Document document = DocumentHelper.readDocument(paramInputStream);
/* 116 */       return XmlBeans.getContextTypeLoader().parse(document.getDocumentElement(), paramSchemaType, getXmlOptions(paramXmlOptions));
/* 117 */     } catch (SAXException sAXException) {
/* 118 */       throw new IOException("Unable to parse xml bean", sAXException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlObject parse(XMLStreamReader paramXMLStreamReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException {
/* 123 */     return XmlBeans.getContextTypeLoader().parse(paramXMLStreamReader, paramSchemaType, getXmlOptions(paramXmlOptions));
/*     */   }
/*     */   
/*     */   public static XmlObject parse(Reader paramReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/*     */     try {
/* 128 */       Document document = DocumentHelper.readDocument(new InputSource(paramReader));
/* 129 */       return XmlBeans.getContextTypeLoader().parse(document.getDocumentElement(), paramSchemaType, getXmlOptions(paramXmlOptions));
/* 130 */     } catch (SAXException sAXException) {
/* 131 */       throw new XmlException("Unable to parse xml bean", sAXException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlObject parse(Node paramNode, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException {
/* 136 */     return XmlBeans.getContextTypeLoader().parse(paramNode, paramSchemaType, getXmlOptions(paramXmlOptions));
/*     */   }
/*     */   
/*     */   public static XmlObject parse(XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException {
/* 140 */     return XmlBeans.getContextTypeLoader().parse(paramXMLInputStream, paramSchemaType, getXmlOptions(paramXmlOptions));
/*     */   }
/*     */   
/*     */   public static XMLInputStream newValidatingXMLInputStream(XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException {
/* 144 */     return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(paramXMLInputStream, paramSchemaType, getXmlOptions(paramXmlOptions));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLTypeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */