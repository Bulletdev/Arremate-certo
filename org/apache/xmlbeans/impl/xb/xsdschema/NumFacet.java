/*    */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*    */ 
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
/*    */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*    */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*    */ import org.w3c.dom.Node;
/*    */ 
/*    */ public interface NumFacet extends Facet {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NumFacet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NumFacet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("numfacet93a2type");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static NumFacet newInstance() {
/* 29 */       return (NumFacet)XmlBeans.getContextTypeLoader().newInstance(NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (NumFacet)XmlBeans.getContextTypeLoader().newInstance(NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static NumFacet parse(String param1String) throws XmlException {
/* 36 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1String, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1String, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static NumFacet parse(File param1File) throws XmlException, IOException {
/* 43 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1File, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1File, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NumFacet parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1URL, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1URL, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NumFacet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1InputStream, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1InputStream, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NumFacet parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1Reader, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1Reader, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NumFacet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NumFacet parse(Node param1Node) throws XmlException {
/* 73 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1Node, NumFacet.type, null);
/*    */     }
/*    */     public static NumFacet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1Node, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static NumFacet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NumFacet.type, null);
/*    */     }
/*    */     
/*    */     public static NumFacet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (NumFacet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NumFacet.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NumFacet.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NumFacet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */