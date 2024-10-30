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
/*    */ public interface NoFixedFacet extends Facet {
/* 18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$NoFixedFacet == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$NoFixedFacet = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$NoFixedFacet).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("nofixedfacet250ftype");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class Factory
/*    */   {
/*    */     public static NoFixedFacet newInstance() {
/* 29 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().newInstance(NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet newInstance(XmlOptions param1XmlOptions) {
/* 32 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().newInstance(NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static NoFixedFacet parse(String param1String) throws XmlException {
/* 36 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1String, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 39 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1String, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static NoFixedFacet parse(File param1File) throws XmlException, IOException {
/* 43 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1File, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 46 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1File, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NoFixedFacet parse(URL param1URL) throws XmlException, IOException {
/* 49 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1URL, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 52 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1URL, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NoFixedFacet parse(InputStream param1InputStream) throws XmlException, IOException {
/* 55 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1InputStream, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 58 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1InputStream, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NoFixedFacet parse(Reader param1Reader) throws XmlException, IOException {
/* 61 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1Reader, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 64 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1Reader, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NoFixedFacet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 67 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 70 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     public static NoFixedFacet parse(Node param1Node) throws XmlException {
/* 73 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1Node, NoFixedFacet.type, null);
/*    */     }
/*    */     public static NoFixedFacet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 76 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1Node, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static NoFixedFacet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 80 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NoFixedFacet.type, null);
/*    */     }
/*    */     
/*    */     public static NoFixedFacet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 84 */       return (NoFixedFacet)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 88 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NoFixedFacet.type, null);
/*    */     }
/*    */     
/*    */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 92 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, NoFixedFacet.type, param1XmlOptions);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\NoFixedFacet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */