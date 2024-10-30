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
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface NotationDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("notation3381doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Notation getNotation();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNotation(Notation paramNotation);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Notation addNewNotation();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Notation
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((NotationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation == null) ? (NotationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation = NotationDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument$Notation")) : NotationDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$NotationDocument$Notation).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("notation8b1felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlNCName xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setName(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetName(XmlNCName param1XmlNCName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getPublic();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Public xgetPublic();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetPublic();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setPublic(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetPublic(Public param1Public);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetPublic();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     String getSystem();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlAnyURI xgetSystem();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetSystem();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSystem(String param1String);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetSystem(XmlAnyURI param1XmlAnyURI);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetSystem();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static NotationDocument.Notation newInstance() {
/* 135 */         return (NotationDocument.Notation)XmlBeans.getContextTypeLoader().newInstance(NotationDocument.Notation.type, null);
/*     */       }
/*     */       public static NotationDocument.Notation newInstance(XmlOptions param2XmlOptions) {
/* 138 */         return (NotationDocument.Notation)XmlBeans.getContextTypeLoader().newInstance(NotationDocument.Notation.type, param2XmlOptions);
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
/*     */     public static NotationDocument newInstance() {
/* 152 */       return (NotationDocument)XmlBeans.getContextTypeLoader().newInstance(NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument newInstance(XmlOptions param1XmlOptions) {
/* 155 */       return (NotationDocument)XmlBeans.getContextTypeLoader().newInstance(NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NotationDocument parse(String param1String) throws XmlException {
/* 159 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1String, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 162 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1String, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NotationDocument parse(File param1File) throws XmlException, IOException {
/* 166 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1File, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 169 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1File, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static NotationDocument parse(URL param1URL) throws XmlException, IOException {
/* 172 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 175 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1URL, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static NotationDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 178 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 181 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static NotationDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 184 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 187 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static NotationDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 190 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 193 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static NotationDocument parse(Node param1Node) throws XmlException {
/* 196 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, NotationDocument.type, null);
/*     */     }
/*     */     public static NotationDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 199 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1Node, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static NotationDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 203 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NotationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static NotationDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 207 */       return (NotationDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 211 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NotationDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 215 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NotationDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NotationDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */