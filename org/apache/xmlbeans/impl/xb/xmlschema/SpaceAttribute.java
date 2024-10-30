/*     */ package org.apache.xmlbeans.impl.xb.xmlschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface SpaceAttribute extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute = null.class$("org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute")) : null.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("space9344attrtypetype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Space.Enum getSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Space xgetSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setSpace(Space.Enum paramEnum);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetSpace(Space paramSpace);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetSpace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Space
/*     */     extends XmlNCName
/*     */   {
/*  59 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((SpaceAttribute.null.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space == null) ? (SpaceAttribute.null.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space = SpaceAttribute.null.class$("org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute$Space")) : SpaceAttribute.null.class$org$apache$xmlbeans$impl$xb$xmlschema$SpaceAttribute$Space).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLLANG").resolveHandle("spaceb986attrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     public static final Enum DEFAULT = Enum.forString("default");
/*  66 */     public static final Enum PRESERVE = Enum.forString("preserve");
/*     */ 
/*     */     
/*     */     public static final int INT_DEFAULT = 1;
/*     */ 
/*     */     
/*     */     public static final int INT_PRESERVE = 2;
/*     */ 
/*     */ 
/*     */     
/*     */     StringEnumAbstractBase enumValue();
/*     */ 
/*     */ 
/*     */     
/*     */     void set(StringEnumAbstractBase param1StringEnumAbstractBase);
/*     */ 
/*     */     
/*     */     public static final class Enum
/*     */       extends StringEnumAbstractBase
/*     */     {
/*     */       static final int INT_DEFAULT = 1;
/*     */       
/*     */       static final int INT_PRESERVE = 2;
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/*  92 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/*  97 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/* 100 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 105 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("default", 1), new Enum("preserve", 2) });
/*     */ 
/*     */ 
/*     */       
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private Object readResolve() {
/* 115 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static SpaceAttribute.Space newValue(Object param2Object) {
/* 126 */         return (SpaceAttribute.Space)SpaceAttribute.Space.type.newValue(param2Object);
/*     */       }
/*     */       public static SpaceAttribute.Space newInstance() {
/* 129 */         return (SpaceAttribute.Space)XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.Space.type, null);
/*     */       }
/*     */       public static SpaceAttribute.Space newInstance(XmlOptions param2XmlOptions) {
/* 132 */         return (SpaceAttribute.Space)XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.Space.type, param2XmlOptions);
/*     */       } }
/*     */   } public static final class Enum extends StringEnumAbstractBase { static final int INT_DEFAULT = 1; static final int INT_PRESERVE = 2; public static Enum forString(String param1String) {
/*     */       return (Enum)table.forString(param1String);
/*     */     } public static Enum forInt(int param1Int) {
/*     */       return (Enum)table.forInt(param1Int);
/*     */     } private Enum(String param1String, int param1Int) {
/*     */       super(param1String, param1Int);
/*     */     }
/*     */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("default", 1), new Enum("preserve", 2) }); private static final long serialVersionUID = 1L;
/*     */     private Object readResolve() {
/*     */       return forInt(intValue());
/*     */     } }
/*     */   public static final class Factory { public static SpaceAttribute newInstance() {
/* 146 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute newInstance(XmlOptions param1XmlOptions) {
/* 149 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().newInstance(SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SpaceAttribute parse(String param1String) throws XmlException {
/* 153 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1String, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 156 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1String, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SpaceAttribute parse(File param1File) throws XmlException, IOException {
/* 160 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1File, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 163 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1File, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static SpaceAttribute parse(URL param1URL) throws XmlException, IOException {
/* 166 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 169 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1URL, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static SpaceAttribute parse(InputStream param1InputStream) throws XmlException, IOException {
/* 172 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 175 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1InputStream, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static SpaceAttribute parse(Reader param1Reader) throws XmlException, IOException {
/* 178 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 181 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1Reader, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static SpaceAttribute parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 184 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 187 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     public static SpaceAttribute parse(Node param1Node) throws XmlException {
/* 190 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, SpaceAttribute.type, null);
/*     */     }
/*     */     public static SpaceAttribute parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 193 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1Node, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static SpaceAttribute parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 197 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SpaceAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static SpaceAttribute parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 201 */       return (SpaceAttribute)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, SpaceAttribute.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 205 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SpaceAttribute.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 209 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, SpaceAttribute.type, param1XmlOptions);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlschema\SpaceAttribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */