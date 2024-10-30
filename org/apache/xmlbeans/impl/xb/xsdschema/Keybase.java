/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface Keybase extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Keybase == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Keybase = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Keybase")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Keybase).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("keybase3955type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SelectorDocument.Selector getSelector();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSelector(SelectorDocument.Selector paramSelector);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SelectorDocument.Selector addNewSelector();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldDocument.Field[] getFieldArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldDocument.Field getFieldArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfFieldArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFieldArray(FieldDocument.Field[] paramArrayOfField);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFieldArray(int paramInt, FieldDocument.Field paramField);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldDocument.Field insertNewField(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldDocument.Field addNewField();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeField(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlNCName xgetName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetName(XmlNCName paramXmlNCName);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Keybase newInstance() {
/* 104 */       return (Keybase)XmlBeans.getContextTypeLoader().newInstance(Keybase.type, null);
/*     */     }
/*     */     public static Keybase newInstance(XmlOptions param1XmlOptions) {
/* 107 */       return (Keybase)XmlBeans.getContextTypeLoader().newInstance(Keybase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Keybase parse(String param1String) throws XmlException {
/* 111 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1String, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 114 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1String, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Keybase parse(File param1File) throws XmlException, IOException {
/* 118 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1File, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 121 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1File, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     public static Keybase parse(URL param1URL) throws XmlException, IOException {
/* 124 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1URL, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 127 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1URL, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     public static Keybase parse(InputStream param1InputStream) throws XmlException, IOException {
/* 130 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1InputStream, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 133 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1InputStream, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     public static Keybase parse(Reader param1Reader) throws XmlException, IOException {
/* 136 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1Reader, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 139 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1Reader, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     public static Keybase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 142 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 145 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     public static Keybase parse(Node param1Node) throws XmlException {
/* 148 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1Node, Keybase.type, null);
/*     */     }
/*     */     public static Keybase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 151 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1Node, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Keybase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 155 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Keybase.type, null);
/*     */     }
/*     */     
/*     */     public static Keybase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 159 */       return (Keybase)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Keybase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 163 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Keybase.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 167 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Keybase.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Keybase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */