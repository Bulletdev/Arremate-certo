/*     */ package org.apache.xmlbeans.impl.xb.substwsdl;
/*     */ 
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
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface DefinitionsDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$substwsdl$DefinitionsDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$substwsdl$DefinitionsDocument = null.class$("org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument")) : null.class$org$apache$xmlbeans$impl$xb$substwsdl$DefinitionsDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("definitionsc7f1doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Definitions getDefinitions();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDefinitions(Definitions paramDefinitions);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Definitions addNewDefinitions();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Definitions
/*     */     extends XmlObject
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((DefinitionsDocument.null.class$org$apache$xmlbeans$impl$xb$substwsdl$DefinitionsDocument$Definitions == null) ? (DefinitionsDocument.null.class$org$apache$xmlbeans$impl$xb$substwsdl$DefinitionsDocument$Definitions = DefinitionsDocument.null.class$("org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument$Definitions")) : DefinitionsDocument.null.class$org$apache$xmlbeans$impl$xb$substwsdl$DefinitionsDocument$Definitions).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("definitions05ddelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TImport[] getImportArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TImport getImportArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfImportArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setImportArray(TImport[] param1ArrayOfTImport);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setImportArray(int param1Int, TImport param1TImport);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TImport insertNewImport(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TImport addNewImport();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeImport(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject[] getTypesArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject getTypesArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfTypesArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTypesArray(XmlObject[] param1ArrayOfXmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTypesArray(int param1Int, XmlObject param1XmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject insertNewTypes(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject addNewTypes();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeTypes(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject[] getMessageArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject getMessageArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfMessageArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMessageArray(XmlObject[] param1ArrayOfXmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMessageArray(int param1Int, XmlObject param1XmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject insertNewMessage(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject addNewMessage();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeMessage(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject[] getBindingArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject getBindingArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfBindingArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setBindingArray(XmlObject[] param1ArrayOfXmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setBindingArray(int param1Int, XmlObject param1XmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject insertNewBinding(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject addNewBinding();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeBinding(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject[] getPortTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject getPortTypeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfPortTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setPortTypeArray(XmlObject[] param1ArrayOfXmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setPortTypeArray(int param1Int, XmlObject param1XmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject insertNewPortType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject addNewPortType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removePortType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject[] getServiceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject getServiceArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfServiceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setServiceArray(XmlObject[] param1ArrayOfXmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setServiceArray(int param1Int, XmlObject param1XmlObject);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject insertNewService(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlObject addNewService();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeService(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static DefinitionsDocument.Definitions newInstance() {
/* 295 */         return (DefinitionsDocument.Definitions)XmlBeans.getContextTypeLoader().newInstance(DefinitionsDocument.Definitions.type, null);
/*     */       }
/*     */       public static DefinitionsDocument.Definitions newInstance(XmlOptions param2XmlOptions) {
/* 298 */         return (DefinitionsDocument.Definitions)XmlBeans.getContextTypeLoader().newInstance(DefinitionsDocument.Definitions.type, param2XmlOptions);
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
/*     */     public static DefinitionsDocument newInstance() {
/* 312 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().newInstance(DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument newInstance(XmlOptions param1XmlOptions) {
/* 315 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().newInstance(DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DefinitionsDocument parse(String param1String) throws XmlException {
/* 319 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1String, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 322 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1String, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DefinitionsDocument parse(File param1File) throws XmlException, IOException {
/* 326 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1File, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 329 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1File, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DefinitionsDocument parse(URL param1URL) throws XmlException, IOException {
/* 332 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 335 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DefinitionsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 338 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 341 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DefinitionsDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 344 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 347 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DefinitionsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 350 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 353 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static DefinitionsDocument parse(Node param1Node) throws XmlException {
/* 356 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, DefinitionsDocument.type, null);
/*     */     }
/*     */     public static DefinitionsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 359 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DefinitionsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 363 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DefinitionsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static DefinitionsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 367 */       return (DefinitionsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 371 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DefinitionsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 375 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DefinitionsDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\substwsdl\DefinitionsDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */