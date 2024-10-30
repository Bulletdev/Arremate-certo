/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
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
/*     */ public interface XmlENTITIES
/*     */   extends XmlAnySimpleType
/*     */ {
/*  34 */   public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITIES");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List getListValue();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List xgetListValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void setListValue(List paramList);
/*     */ 
/*     */ 
/*     */   
/*     */   List listValue();
/*     */ 
/*     */ 
/*     */   
/*     */   List xlistValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(List paramList);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static XmlENTITIES newInstance() {
/*  67 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().newInstance(XmlENTITIES.type, null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES newInstance(XmlOptions param1XmlOptions) {
/*  71 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().newInstance(XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES newValue(Object param1Object) {
/*  75 */       return (XmlENTITIES)XmlENTITIES.type.newValue(param1Object);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(String param1String) throws XmlException {
/*  79 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1String, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  83 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1String, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(File param1File) throws XmlException, IOException {
/*  87 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1File, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  91 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1File, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(URL param1URL) throws XmlException, IOException {
/*  95 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1URL, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  99 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1URL, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(InputStream param1InputStream) throws XmlException, IOException {
/* 103 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 107 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1InputStream, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(Reader param1Reader) throws XmlException, IOException {
/* 111 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 115 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1Reader, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(Node param1Node) throws XmlException {
/* 119 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1Node, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 123 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1Node, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlENTITIES parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 129 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XmlENTITIES parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 135 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 139 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlENTITIES.type, (XmlOptions)null);
/*     */     }
/*     */     
/*     */     public static XmlENTITIES parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 143 */       return (XmlENTITIES)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 149 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlENTITIES.type, null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 155 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, XmlENTITIES.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlENTITIES.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */