/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Annotated extends OpenAttrs {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Annotated == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Annotated = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Annotated")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Annotated).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotateda52dtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnnotationDocument.Annotation getAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAnnotation(AnnotationDocument.Annotation paramAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AnnotationDocument.Annotation addNewAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlID xgetId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setId(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetId(XmlID paramXmlID);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Annotated newInstance() {
/*  84 */       return (Annotated)XmlBeans.getContextTypeLoader().newInstance(Annotated.type, null);
/*     */     }
/*     */     public static Annotated newInstance(XmlOptions param1XmlOptions) {
/*  87 */       return (Annotated)XmlBeans.getContextTypeLoader().newInstance(Annotated.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Annotated parse(String param1String) throws XmlException {
/*  91 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1String, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  94 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1String, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Annotated parse(File param1File) throws XmlException, IOException {
/*  98 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1File, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 101 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1File, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     public static Annotated parse(URL param1URL) throws XmlException, IOException {
/* 104 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1URL, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1URL, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     public static Annotated parse(InputStream param1InputStream) throws XmlException, IOException {
/* 110 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1InputStream, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 113 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1InputStream, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     public static Annotated parse(Reader param1Reader) throws XmlException, IOException {
/* 116 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1Reader, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 119 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1Reader, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     public static Annotated parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 122 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 125 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     public static Annotated parse(Node param1Node) throws XmlException {
/* 128 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1Node, Annotated.type, null);
/*     */     }
/*     */     public static Annotated parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 131 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1Node, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Annotated parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 135 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Annotated.type, null);
/*     */     }
/*     */     
/*     */     public static Annotated parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 139 */       return (Annotated)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Annotated.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 143 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Annotated.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 147 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Annotated.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Annotated.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */