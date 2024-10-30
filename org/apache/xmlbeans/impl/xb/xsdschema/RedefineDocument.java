/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface RedefineDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$RedefineDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$RedefineDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$RedefineDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("redefine3f55doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Redefine getRedefine();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRedefine(Redefine paramRedefine);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Redefine addNewRedefine();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Redefine
/*     */     extends OpenAttrs
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((RedefineDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$RedefineDocument$Redefine == null) ? (RedefineDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$RedefineDocument$Redefine = RedefineDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument$Redefine")) : RedefineDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$RedefineDocument$Redefine).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("redefine9e9felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationDocument.Annotation[] getAnnotationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationDocument.Annotation getAnnotationArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfAnnotationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAnnotationArray(AnnotationDocument.Annotation[] param1ArrayOfAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAnnotationArray(int param1Int, AnnotationDocument.Annotation param1Annotation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationDocument.Annotation insertNewAnnotation(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationDocument.Annotation addNewAnnotation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeAnnotation(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelSimpleType[] getSimpleTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelSimpleType getSimpleTypeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfSimpleTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSimpleTypeArray(TopLevelSimpleType[] param1ArrayOfTopLevelSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSimpleTypeArray(int param1Int, TopLevelSimpleType param1TopLevelSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelSimpleType insertNewSimpleType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeSimpleType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelComplexType[] getComplexTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelComplexType getComplexTypeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfComplexTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setComplexTypeArray(TopLevelComplexType[] param1ArrayOfTopLevelComplexType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setComplexTypeArray(int param1Int, TopLevelComplexType param1TopLevelComplexType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelComplexType insertNewComplexType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelComplexType addNewComplexType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeComplexType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedGroup[] getGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedGroup getGroupArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setGroupArray(NamedGroup[] param1ArrayOfNamedGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setGroupArray(int param1Int, NamedGroup param1NamedGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedGroup insertNewGroup(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedGroup addNewGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeGroup(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedAttributeGroup[] getAttributeGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedAttributeGroup getAttributeGroupArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfAttributeGroupArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAttributeGroupArray(NamedAttributeGroup[] param1ArrayOfNamedAttributeGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAttributeGroupArray(int param1Int, NamedAttributeGroup param1NamedAttributeGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedAttributeGroup insertNewAttributeGroup(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NamedAttributeGroup addNewAttributeGroup();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeAttributeGroup(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetSchemaLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSchemaLocation(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetSchemaLocation(XmlAnyURI param1XmlAnyURI);
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
/*     */       public static RedefineDocument.Redefine newInstance() {
/* 305 */         return (RedefineDocument.Redefine)XmlBeans.getContextTypeLoader().newInstance(RedefineDocument.Redefine.type, null);
/*     */       }
/*     */       public static RedefineDocument.Redefine newInstance(XmlOptions param2XmlOptions) {
/* 308 */         return (RedefineDocument.Redefine)XmlBeans.getContextTypeLoader().newInstance(RedefineDocument.Redefine.type, param2XmlOptions);
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
/*     */     public static RedefineDocument newInstance() {
/* 322 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().newInstance(RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument newInstance(XmlOptions param1XmlOptions) {
/* 325 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().newInstance(RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RedefineDocument parse(String param1String) throws XmlException {
/* 329 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1String, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 332 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1String, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RedefineDocument parse(File param1File) throws XmlException, IOException {
/* 336 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1File, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 339 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1File, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RedefineDocument parse(URL param1URL) throws XmlException, IOException {
/* 342 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1URL, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 345 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1URL, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RedefineDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 348 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 351 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RedefineDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 354 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 357 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RedefineDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 360 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 363 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static RedefineDocument parse(Node param1Node) throws XmlException {
/* 366 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1Node, RedefineDocument.type, null);
/*     */     }
/*     */     public static RedefineDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 369 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1Node, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RedefineDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 373 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RedefineDocument.type, null);
/*     */     }
/*     */     
/*     */     public static RedefineDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 377 */       return (RedefineDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 381 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RedefineDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 385 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RedefineDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\RedefineDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */