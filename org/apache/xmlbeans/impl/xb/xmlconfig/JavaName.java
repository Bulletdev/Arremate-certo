/*    */ package org.apache.xmlbeans.impl.xb.xmlconfig;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.Reader;
/*    */ import java.net.URL;
/*    */ import javax.xml.stream.XMLStreamReader;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlBeans;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.apache.xmlbeans.XmlOptions;
/*    */ import org.apache.xmlbeans.XmlToken;
/*    */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*    */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*    */ import org.w3c.dom.Node;
/*    */ 
/*    */ public interface JavaName extends XmlToken {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.JavaName")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaName).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("javanamee640type");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static JavaName newValue(Object param1Object) {
/* 29 */       return (JavaName)JavaName.type.newValue(param1Object);
/*    */     }
/*    */     public static JavaName newInstance() {
/* 32 */       return (JavaName)XmlBeans.getContextTypeLoader().newInstance(JavaName.type, null);
/*    */     }
/*    */     public static JavaName newInstance(XmlOptions param1XmlOptions) {
/* 35 */       return (JavaName)XmlBeans.getContextTypeLoader().newInstance(JavaName.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static JavaName parse(String param1String) throws XmlException {
/* 39 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1String, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 42 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1String, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static JavaName parse(File param1File) throws XmlException, IOException {
/* 46 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1File, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 49 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1File, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     public static JavaName parse(URL param1URL) throws XmlException, IOException {
/* 52 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1URL, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 55 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1URL, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     public static JavaName parse(InputStream param1InputStream) throws XmlException, IOException {
/* 58 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1InputStream, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 61 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1InputStream, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     public static JavaName parse(Reader param1Reader) throws XmlException, IOException {
/* 64 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1Reader, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 67 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1Reader, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     public static JavaName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 70 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 73 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     public static JavaName parse(Node param1Node) throws XmlException {
/* 76 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1Node, JavaName.type, null);
/*    */     }
/*    */     public static JavaName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 79 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1Node, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static JavaName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 83 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, JavaName.type, null);
/*    */     }
/*    */     
/*    */     public static JavaName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 87 */       return (JavaName)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, JavaName.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 91 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, JavaName.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 95 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, JavaName.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\JavaName.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */