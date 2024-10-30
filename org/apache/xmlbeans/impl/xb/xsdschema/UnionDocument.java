/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface UnionDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("union5866doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Union getUnion();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setUnion(Union paramUnion);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Union addNewUnion();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Union
/*     */     extends Annotated
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((UnionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union == null) ? (UnionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union = UnionDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$Union")) : UnionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("union498belemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType[] getSimpleTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType getSimpleTypeArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfSimpleTypeArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSimpleTypeArray(LocalSimpleType[] param1ArrayOfLocalSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setSimpleTypeArray(int param1Int, LocalSimpleType param1LocalSimpleType);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType insertNewSimpleType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LocalSimpleType addNewSimpleType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeSimpleType(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     List getMemberTypes();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MemberTypes xgetMemberTypes();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isSetMemberTypes();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setMemberTypes(List param1List);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void xsetMemberTypes(MemberTypes param1MemberTypes);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void unsetMemberTypes();
/*     */ 
/*     */ 
/*     */     
/*     */     public static interface MemberTypes
/*     */       extends XmlAnySimpleType
/*     */     {
/*     */       List getListValue();
/*     */ 
/*     */ 
/*     */       
/*     */       List xgetListValue();
/*     */ 
/*     */ 
/*     */       
/*     */       void setListValue(List param2List);
/*     */ 
/*     */ 
/*     */       
/* 133 */       public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((UnionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes == null) ? (UnionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes = UnionDocument.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$Union$MemberTypes")) : UnionDocument.null.class$org$apache$xmlbeans$impl$xb$xsdschema$UnionDocument$Union$MemberTypes).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("membertypes2404attrtype");
/*     */       
/*     */       List listValue();
/*     */       
/*     */       List xlistValue();
/*     */       
/*     */       void set(List param2List);
/*     */       
/*     */       public static final class Factory
/*     */       {
/*     */         public static UnionDocument.Union.MemberTypes newValue(Object param3Object) {
/* 144 */           return (UnionDocument.Union.MemberTypes)UnionDocument.Union.MemberTypes.type.newValue(param3Object);
/*     */         }
/*     */         public static UnionDocument.Union.MemberTypes newInstance() {
/* 147 */           return (UnionDocument.Union.MemberTypes)XmlBeans.getContextTypeLoader().newInstance(UnionDocument.Union.MemberTypes.type, null);
/*     */         }
/*     */         public static UnionDocument.Union.MemberTypes newInstance(XmlOptions param3XmlOptions) {
/* 150 */           return (UnionDocument.Union.MemberTypes)XmlBeans.getContextTypeLoader().newInstance(UnionDocument.Union.MemberTypes.type, param3XmlOptions);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static UnionDocument.Union newInstance() {
/* 164 */         return (UnionDocument.Union)XmlBeans.getContextTypeLoader().newInstance(UnionDocument.Union.type, null);
/*     */       }
/*     */       public static UnionDocument.Union newInstance(XmlOptions param2XmlOptions) {
/* 167 */         return (UnionDocument.Union)XmlBeans.getContextTypeLoader().newInstance(UnionDocument.Union.type, param2XmlOptions);
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
/*     */     public static UnionDocument newInstance() {
/* 181 */       return (UnionDocument)XmlBeans.getContextTypeLoader().newInstance(UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument newInstance(XmlOptions param1XmlOptions) {
/* 184 */       return (UnionDocument)XmlBeans.getContextTypeLoader().newInstance(UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static UnionDocument parse(String param1String) throws XmlException {
/* 188 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1String, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 191 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1String, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static UnionDocument parse(File param1File) throws XmlException, IOException {
/* 195 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1File, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 198 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1File, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UnionDocument parse(URL param1URL) throws XmlException, IOException {
/* 201 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1URL, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 204 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1URL, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UnionDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 207 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 210 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UnionDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 213 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 216 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UnionDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 219 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 222 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static UnionDocument parse(Node param1Node) throws XmlException {
/* 225 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1Node, UnionDocument.type, null);
/*     */     }
/*     */     public static UnionDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 228 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1Node, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static UnionDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 232 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, UnionDocument.type, null);
/*     */     }
/*     */     
/*     */     public static UnionDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 236 */       return (UnionDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 240 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, UnionDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 244 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, UnionDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\UnionDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */