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
/*     */ import org.apache.xmlbeans.XmlLanguage;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface SchemaDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("schema0782doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Schema getSchema();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSchema(Schema paramSchema);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Schema addNewSchema();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Schema
/*     */     extends OpenAttrs
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SchemaDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument$Schema == null) ? (SchemaDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument$Schema = SchemaDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument$Schema")) : SchemaDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument$Schema).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("schemad77felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IncludeDocument.Include[] getIncludeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IncludeDocument.Include getIncludeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfIncludeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setIncludeArray(IncludeDocument.Include[] param1ArrayOfInclude);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setIncludeArray(int param1Int, IncludeDocument.Include param1Include);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IncludeDocument.Include insertNewInclude(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     IncludeDocument.Include addNewInclude();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeInclude(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ImportDocument.Import[] getImportArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ImportDocument.Import getImportArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfImportArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setImportArray(ImportDocument.Import[] param1ArrayOfImport);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setImportArray(int param1Int, ImportDocument.Import param1Import);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ImportDocument.Import insertNewImport(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ImportDocument.Import addNewImport();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeImport(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RedefineDocument.Redefine[] getRedefineArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RedefineDocument.Redefine getRedefineArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfRedefineArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setRedefineArray(RedefineDocument.Redefine[] param1ArrayOfRedefine);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setRedefineArray(int param1Int, RedefineDocument.Redefine param1Redefine);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RedefineDocument.Redefine insertNewRedefine(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RedefineDocument.Redefine addNewRedefine();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeRedefine(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationDocument.Annotation[] getAnnotationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     AnnotationDocument.Annotation getAnnotationArray(int param1Int);
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
/*     */     TopLevelElement[] getElementArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelElement getElementArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfElementArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setElementArray(TopLevelElement[] param1ArrayOfTopLevelElement);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setElementArray(int param1Int, TopLevelElement param1TopLevelElement);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelElement insertNewElement(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelElement addNewElement();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeElement(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelAttribute[] getAttributeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelAttribute getAttributeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfAttributeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAttributeArray(TopLevelAttribute[] param1ArrayOfTopLevelAttribute);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAttributeArray(int param1Int, TopLevelAttribute param1TopLevelAttribute);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelAttribute insertNewAttribute(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TopLevelAttribute addNewAttribute();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeAttribute(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NotationDocument.Notation[] getNotationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NotationDocument.Notation getNotationArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfNotationArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setNotationArray(NotationDocument.Notation[] param1ArrayOfNotation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setNotationArray(int param1Int, NotationDocument.Notation param1Notation);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NotationDocument.Notation insertNewNotation(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     NotationDocument.Notation addNewNotation();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeNotation(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getTargetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetTargetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetTargetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTargetNamespace(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetTargetNamespace(XmlAnyURI param1XmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetTargetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlToken xgetVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setVersion(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetVersion(XmlToken param1XmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetVersion();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object getFinalDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FullDerivationSet xgetFinalDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetFinalDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setFinalDefault(Object param1Object);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetFinalDefault(FullDerivationSet param1FullDerivationSet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetFinalDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object getBlockDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     BlockSet xgetBlockDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetBlockDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setBlockDefault(Object param1Object);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetBlockDefault(BlockSet param1BlockSet);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetBlockDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FormChoice.Enum getAttributeFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FormChoice xgetAttributeFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetAttributeFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setAttributeFormDefault(FormChoice.Enum param1Enum);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetAttributeFormDefault(FormChoice param1FormChoice);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetAttributeFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FormChoice.Enum getElementFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FormChoice xgetElementFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetElementFormDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setElementFormDefault(FormChoice.Enum param1Enum);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetElementFormDefault(FormChoice param1FormChoice);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetElementFormDefault();
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
/*     */     String getLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlLanguage xgetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setLang(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetLang(XmlLanguage param1XmlLanguage);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetLang();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static SchemaDocument.Schema newInstance() {
/* 735 */         return (SchemaDocument.Schema)XmlBeans.getContextTypeLoader().newInstance(SchemaDocument.Schema.type, null);
/*     */       }
/*     */       public static SchemaDocument.Schema newInstance(XmlOptions param2XmlOptions) {
/* 738 */         return (SchemaDocument.Schema)XmlBeans.getContextTypeLoader().newInstance(SchemaDocument.Schema.type, param2XmlOptions);
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
/*     */     public static SchemaDocument newInstance() {
/* 752 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().newInstance(SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument newInstance(XmlOptions param1XmlOptions) {
/* 755 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().newInstance(SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SchemaDocument parse(String param1String) throws XmlException {
/* 759 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1String, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 762 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1String, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SchemaDocument parse(File param1File) throws XmlException, IOException {
/* 766 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1File, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 769 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1File, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SchemaDocument parse(URL param1URL) throws XmlException, IOException {
/* 772 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 775 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1URL, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SchemaDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 778 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 781 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SchemaDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 784 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 787 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SchemaDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 790 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 793 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static SchemaDocument parse(Node param1Node) throws XmlException {
/* 796 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SchemaDocument.type, null);
/*     */     }
/*     */     public static SchemaDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 799 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1Node, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SchemaDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 803 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SchemaDocument.type, null);
/*     */     }
/*     */     
/*     */     public static SchemaDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 807 */       return (SchemaDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 811 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SchemaDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 815 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SchemaDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\SchemaDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */