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
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface FieldDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("field3f9bdoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Field getField();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setField(Field paramField);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Field addNewField();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Field
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((FieldDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field == null) ? (FieldDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field = FieldDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument$Field")) : FieldDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("field12f5elemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getXpath();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Xpath xgetXpath();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setXpath(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetXpath(Xpath param1Xpath);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface Xpath
/*     */       extends XmlToken
/*     */     {
/*  74 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((FieldDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath == null) ? (FieldDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath = FieldDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument$Field$Xpath")) : FieldDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$FieldDocument$Field$Xpath).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("xpath7f90attrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static FieldDocument.Field.Xpath newValue(Object param3Object) {
/*  85 */           return (FieldDocument.Field.Xpath)FieldDocument.Field.Xpath.type.newValue(param3Object);
/*     */         }
/*     */         public static FieldDocument.Field.Xpath newInstance() {
/*  88 */           return (FieldDocument.Field.Xpath)XmlBeans.getContextTypeLoader().newInstance(FieldDocument.Field.Xpath.type, null);
/*     */         }
/*     */         public static FieldDocument.Field.Xpath newInstance(XmlOptions param3XmlOptions) {
/*  91 */           return (FieldDocument.Field.Xpath)XmlBeans.getContextTypeLoader().newInstance(FieldDocument.Field.Xpath.type, param3XmlOptions);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static FieldDocument.Field newInstance() {
/* 105 */         return (FieldDocument.Field)XmlBeans.getContextTypeLoader().newInstance(FieldDocument.Field.type, null);
/*     */       }
/*     */       public static FieldDocument.Field newInstance(XmlOptions param2XmlOptions) {
/* 108 */         return (FieldDocument.Field)XmlBeans.getContextTypeLoader().newInstance(FieldDocument.Field.type, param2XmlOptions);
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
/*     */     public static FieldDocument newInstance() {
/* 122 */       return (FieldDocument)XmlBeans.getContextTypeLoader().newInstance(FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument newInstance(XmlOptions param1XmlOptions) {
/* 125 */       return (FieldDocument)XmlBeans.getContextTypeLoader().newInstance(FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FieldDocument parse(String param1String) throws XmlException {
/* 129 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1String, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 132 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1String, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FieldDocument parse(File param1File) throws XmlException, IOException {
/* 136 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1File, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 139 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1File, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FieldDocument parse(URL param1URL) throws XmlException, IOException {
/* 142 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1URL, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 145 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1URL, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FieldDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 148 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 151 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FieldDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 154 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 157 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FieldDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 160 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 163 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static FieldDocument parse(Node param1Node) throws XmlException {
/* 166 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1Node, FieldDocument.type, null);
/*     */     }
/*     */     public static FieldDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 169 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1Node, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FieldDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 173 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FieldDocument.type, null);
/*     */     }
/*     */     
/*     */     public static FieldDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 177 */       return (FieldDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 181 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FieldDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 185 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FieldDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\FieldDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */