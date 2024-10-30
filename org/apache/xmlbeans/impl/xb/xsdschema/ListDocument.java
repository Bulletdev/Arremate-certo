/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface ListDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ListDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ListDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ListDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ListDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("listcde5doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List getList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setList(List paramList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List addNewList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface List
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((ListDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ListDocument$List == null) ? (ListDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ListDocument$List = ListDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ListDocument$List")) : ListDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ListDocument$List).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("list391felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType getSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSimpleType(LocalSimpleType param1LocalSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     b getItemType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlQName xgetItemType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetItemType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setItemType(b param1b);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetItemType(XmlQName param1XmlQName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetItemType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static ListDocument.List newInstance() {
/* 110 */         return (ListDocument.List)XmlBeans.getContextTypeLoader().newInstance(ListDocument.List.type, null);
/*     */       }
/*     */       public static ListDocument.List newInstance(XmlOptions param2XmlOptions) {
/* 113 */         return (ListDocument.List)XmlBeans.getContextTypeLoader().newInstance(ListDocument.List.type, param2XmlOptions);
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
/*     */     public static ListDocument newInstance() {
/* 127 */       return (ListDocument)XmlBeans.getContextTypeLoader().newInstance(ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument newInstance(XmlOptions param1XmlOptions) {
/* 130 */       return (ListDocument)XmlBeans.getContextTypeLoader().newInstance(ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ListDocument parse(String param1String) throws XmlException {
/* 134 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1String, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 137 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1String, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ListDocument parse(File param1File) throws XmlException, IOException {
/* 141 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1File, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 144 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1File, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ListDocument parse(URL param1URL) throws XmlException, IOException {
/* 147 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 150 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ListDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 153 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 156 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ListDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 159 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 162 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ListDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 165 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 168 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ListDocument parse(Node param1Node) throws XmlException {
/* 171 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ListDocument.type, null);
/*     */     }
/*     */     public static ListDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 174 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ListDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 178 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ListDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ListDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 182 */       return (ListDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 186 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ListDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 190 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ListDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ListDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */