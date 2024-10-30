/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface ComplexContentDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexcontentc57adoctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ComplexContent getComplexContent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setComplexContent(ComplexContent paramComplexContent);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ComplexContent addNewComplexContent();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface ComplexContent
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((ComplexContentDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent == null) ? (ComplexContentDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent = ComplexContentDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument$ComplexContent")) : ComplexContentDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$ComplexContentDocument$ComplexContent).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complexcontentaa7felemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ComplexRestrictionType getRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setRestriction(ComplexRestrictionType param1ComplexRestrictionType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ComplexRestrictionType addNewRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetRestriction();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ExtensionType getExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setExtension(ExtensionType param1ExtensionType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ExtensionType addNewExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean getMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     XmlBoolean xgetMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMixed(boolean param1Boolean);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetMixed(XmlBoolean param1XmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetMixed();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static ComplexContentDocument.ComplexContent newInstance() {
/* 135 */         return (ComplexContentDocument.ComplexContent)XmlBeans.getContextTypeLoader().newInstance(ComplexContentDocument.ComplexContent.type, null);
/*     */       }
/*     */       public static ComplexContentDocument.ComplexContent newInstance(XmlOptions param2XmlOptions) {
/* 138 */         return (ComplexContentDocument.ComplexContent)XmlBeans.getContextTypeLoader().newInstance(ComplexContentDocument.ComplexContent.type, param2XmlOptions);
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
/*     */     public static ComplexContentDocument newInstance() {
/* 152 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().newInstance(ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument newInstance(XmlOptions param1XmlOptions) {
/* 155 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().newInstance(ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexContentDocument parse(String param1String) throws XmlException {
/* 159 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1String, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 162 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1String, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexContentDocument parse(File param1File) throws XmlException, IOException {
/* 166 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1File, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 169 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1File, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexContentDocument parse(URL param1URL) throws XmlException, IOException {
/* 172 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 175 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1URL, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexContentDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 178 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 181 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexContentDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 184 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 187 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexContentDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 190 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 193 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static ComplexContentDocument parse(Node param1Node) throws XmlException {
/* 196 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexContentDocument.type, null);
/*     */     }
/*     */     public static ComplexContentDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 199 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1Node, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ComplexContentDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 203 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexContentDocument.type, null);
/*     */     }
/*     */     
/*     */     public static ComplexContentDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 207 */       return (ComplexContentDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 211 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexContentDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 215 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ComplexContentDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ComplexContentDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */