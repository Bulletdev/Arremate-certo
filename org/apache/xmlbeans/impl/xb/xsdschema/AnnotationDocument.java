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
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface AnnotationDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotationb034doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Annotation getAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAnnotation(Annotation paramAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Annotation addNewAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Annotation
/*     */     extends OpenAttrs
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((AnnotationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation == null) ? (AnnotationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation = AnnotationDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument$Annotation")) : AnnotationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AnnotationDocument$Annotation).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("annotation5abfelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AppinfoDocument.Appinfo[] getAppinfoArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AppinfoDocument.Appinfo getAppinfoArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfAppinfoArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAppinfoArray(AppinfoDocument.Appinfo[] param1ArrayOfAppinfo);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAppinfoArray(int param1Int, AppinfoDocument.Appinfo param1Appinfo);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AppinfoDocument.Appinfo insertNewAppinfo(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AppinfoDocument.Appinfo addNewAppinfo();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeAppinfo(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DocumentationDocument.Documentation[] getDocumentationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DocumentationDocument.Documentation getDocumentationArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfDocumentationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setDocumentationArray(DocumentationDocument.Documentation[] param1ArrayOfDocumentation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setDocumentationArray(int param1Int, DocumentationDocument.Documentation param1Documentation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DocumentationDocument.Documentation insertNewDocumentation(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DocumentationDocument.Documentation addNewDocumentation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeDocumentation(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getId();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlID xgetId();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetId();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setId(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetId(XmlID param1XmlID);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetId();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static AnnotationDocument.Annotation newInstance() {
/* 165 */         return (AnnotationDocument.Annotation)XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.Annotation.type, null);
/*     */       }
/*     */       public static AnnotationDocument.Annotation newInstance(XmlOptions param2XmlOptions) {
/* 168 */         return (AnnotationDocument.Annotation)XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.Annotation.type, param2XmlOptions);
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static AnnotationDocument newInstance() {
/* 182 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument newInstance(XmlOptions param1XmlOptions) {
/* 185 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().newInstance(AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnnotationDocument parse(String param1String) throws XmlException {
/* 189 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1String, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 192 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1String, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnnotationDocument parse(File param1File) throws XmlException, IOException {
/* 196 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1File, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 199 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1File, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnnotationDocument parse(URL param1URL) throws XmlException, IOException {
/* 202 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 205 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnnotationDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 208 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 211 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnnotationDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 214 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 217 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnnotationDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 220 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 223 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static AnnotationDocument parse(Node param1Node) throws XmlException {
/* 226 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AnnotationDocument.type, null);
/*     */     }
/*     */     public static AnnotationDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 229 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AnnotationDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 233 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AnnotationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static AnnotationDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 237 */       return (AnnotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 241 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AnnotationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 245 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AnnotationDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AnnotationDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */