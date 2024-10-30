/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.DOMImplementation;
/*     */ import org.w3c.dom.Node;
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
/*     */ 
/*     */ 
/*     */ public interface XmlObject
/*     */   extends XmlTokenSource
/*     */ {
/* 139 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anyType");
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
/*     */   public static final int LESS_THAN = -1;
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
/*     */   public static final int EQUAL = 0;
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
/*     */   public static final int GREATER_THAN = 1;
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
/*     */   public static final int NOT_EQUAL = 2;
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
/*     */   SchemaType schemaType();
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
/*     */   boolean validate();
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
/*     */   boolean validate(XmlOptions paramXmlOptions);
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
/*     */   XmlObject[] selectPath(String paramString);
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
/*     */   XmlObject[] selectPath(String paramString, XmlOptions paramXmlOptions);
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
/*     */   XmlObject[] execQuery(String paramString);
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
/*     */   XmlObject[] execQuery(String paramString, XmlOptions paramXmlOptions);
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
/*     */   XmlObject changeType(SchemaType paramSchemaType);
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
/*     */   XmlObject substitute(b paramb, SchemaType paramSchemaType);
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
/*     */   boolean isNil();
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
/*     */   void setNil();
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
/*     */   String toString();
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
/*     */   boolean isImmutable();
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
/*     */   XmlObject set(XmlObject paramXmlObject);
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
/*     */   XmlObject copy();
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
/*     */   XmlObject copy(XmlOptions paramXmlOptions);
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
/*     */   boolean valueEquals(XmlObject paramXmlObject);
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
/*     */   int valueHashCode();
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
/*     */   int compareTo(Object paramObject);
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
/*     */   int compareValue(XmlObject paramXmlObject);
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
/*     */   XmlObject[] selectChildren(b paramb);
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
/*     */   XmlObject[] selectChildren(String paramString1, String paramString2);
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
/*     */   XmlObject[] selectChildren(QNameSet paramQNameSet);
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
/*     */   XmlObject selectAttribute(b paramb);
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
/*     */   XmlObject selectAttribute(String paramString1, String paramString2);
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
/*     */   XmlObject[] selectAttributes(QNameSet paramQNameSet);
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlObject newInstance() {
/* 566 */       return XmlBeans.getContextTypeLoader().newInstance(null, null);
/*     */     }
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
/*     */     public static XmlObject newInstance(XmlOptions param1XmlOptions) {
/* 592 */       return XmlBeans.getContextTypeLoader().newInstance(null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject newValue(Object param1Object) {
/* 599 */       return XmlObject.type.newValue(param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(String param1String) throws XmlException {
/* 605 */       return XmlBeans.getContextTypeLoader().parse(param1String, (SchemaType)null, (XmlOptions)null);
/*     */     }
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
/*     */ 
/*     */     
/*     */     public static XmlObject parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 658 */       return XmlBeans.getContextTypeLoader().parse(param1String, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(File param1File) throws XmlException, IOException {
/* 664 */       return XmlBeans.getContextTypeLoader().parse(param1File, (SchemaType)null, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 670 */       return XmlBeans.getContextTypeLoader().parse(param1File, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(URL param1URL) throws XmlException, IOException {
/* 676 */       return XmlBeans.getContextTypeLoader().parse(param1URL, (SchemaType)null, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 682 */       return XmlBeans.getContextTypeLoader().parse(param1URL, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(InputStream param1InputStream) throws XmlException, IOException {
/* 688 */       return XmlBeans.getContextTypeLoader().parse(param1InputStream, (SchemaType)null, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 694 */       return XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, (SchemaType)null, (XmlOptions)null);
/*     */     }
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
/*     */ 
/*     */     
/*     */     public static XmlObject parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 747 */       return XmlBeans.getContextTypeLoader().parse(param1InputStream, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 753 */       return XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(Reader param1Reader) throws XmlException, IOException {
/* 759 */       return XmlBeans.getContextTypeLoader().parse(param1Reader, (SchemaType)null, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 765 */       return XmlBeans.getContextTypeLoader().parse(param1Reader, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(Node param1Node) throws XmlException {
/* 771 */       return XmlBeans.getContextTypeLoader().parse(param1Node, (SchemaType)null, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 777 */       return XmlBeans.getContextTypeLoader().parse(param1Node, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 784 */       return XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, (SchemaType)null, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlObject parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 791 */       return XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, (SchemaType)null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlSaxHandler newXmlSaxHandler() {
/* 797 */       return XmlBeans.getContextTypeLoader().newXmlSaxHandler(null, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlSaxHandler newXmlSaxHandler(XmlOptions param1XmlOptions) {
/* 803 */       return XmlBeans.getContextTypeLoader().newXmlSaxHandler(null, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static DOMImplementation newDomImplementation() {
/* 809 */       return XmlBeans.getContextTypeLoader().newDomImplementation(null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static DOMImplementation newDomImplementation(XmlOptions param1XmlOptions) {
/* 815 */       return XmlBeans.getContextTypeLoader().newDomImplementation(param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 822 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, null, null);
/*     */     }
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
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 845 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, null, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlObject.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */