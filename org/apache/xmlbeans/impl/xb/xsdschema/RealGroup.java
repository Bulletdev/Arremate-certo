/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
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
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface RealGroup extends Group {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$RealGroup == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$RealGroup = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.RealGroup")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$RealGroup).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("realgroup1f64type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All[] getAllArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All getAllArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfAllArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAllArray(All[] paramArrayOfAll);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setAllArray(int paramInt, All paramAll);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All insertNewAll(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   All addNewAll();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeAll(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup[] getChoiceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getChoiceArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfChoiceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChoiceArray(ExplicitGroup[] paramArrayOfExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setChoiceArray(int paramInt, ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup insertNewChoice(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewChoice();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeChoice(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup[] getSequenceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup getSequenceArray(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int sizeOfSequenceArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSequenceArray(ExplicitGroup[] paramArrayOfExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSequenceArray(int paramInt, ExplicitGroup paramExplicitGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup insertNewSequence(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ExplicitGroup addNewSequence();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeSequence(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static RealGroup newInstance() {
/* 149 */       return (RealGroup)XmlBeans.getContextTypeLoader().newInstance(RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup newInstance(XmlOptions param1XmlOptions) {
/* 152 */       return (RealGroup)XmlBeans.getContextTypeLoader().newInstance(RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RealGroup parse(String param1String) throws XmlException {
/* 156 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1String, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 159 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1String, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RealGroup parse(File param1File) throws XmlException, IOException {
/* 163 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1File, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 166 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1File, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static RealGroup parse(URL param1URL) throws XmlException, IOException {
/* 169 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1URL, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 172 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1URL, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static RealGroup parse(InputStream param1InputStream) throws XmlException, IOException {
/* 175 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 178 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1InputStream, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static RealGroup parse(Reader param1Reader) throws XmlException, IOException {
/* 181 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 184 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1Reader, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static RealGroup parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 187 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 190 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     public static RealGroup parse(Node param1Node) throws XmlException {
/* 193 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1Node, RealGroup.type, null);
/*     */     }
/*     */     public static RealGroup parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 196 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1Node, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static RealGroup parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 200 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RealGroup.type, null);
/*     */     }
/*     */     
/*     */     public static RealGroup parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 204 */       return (RealGroup)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 208 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RealGroup.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 212 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, RealGroup.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\RealGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */