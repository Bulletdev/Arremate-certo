/*    */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.Reader;
/*    */ import java.net.URL;
/*    */ import javax.xml.stream.XMLStreamReader;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlBeans;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.XmlOptions;
/*    */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*    */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*    */ import org.w3c.dom.Node;
/*    */ 
/*    */ public interface OpenAttrs extends XmlObject {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.OpenAttrs")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$OpenAttrs).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("openattrs2d4dtype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static OpenAttrs newInstance() {
/* 29 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().newInstance(OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().newInstance(OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static OpenAttrs parse(String param1String) throws XmlException {
/* 36 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1String, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1String, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static OpenAttrs parse(File param1File) throws XmlException, IOException {
/* 43 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1File, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1File, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     public static OpenAttrs parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1URL, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1URL, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     public static OpenAttrs parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1InputStream, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1InputStream, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     public static OpenAttrs parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1Reader, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1Reader, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     public static OpenAttrs parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     public static OpenAttrs parse(Node param1Node) throws XmlException {
/* 73 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1Node, OpenAttrs.type, null);
/*    */     }
/*    */     public static OpenAttrs parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1Node, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static OpenAttrs parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, OpenAttrs.type, null);
/*    */     }
/*    */     
/*    */     public static OpenAttrs parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (OpenAttrs)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, OpenAttrs.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, OpenAttrs.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\OpenAttrs.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */