/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt;
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
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface TestCase extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestCase == null) ? (null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestCase = null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.TestCase")) : null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestCase).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("testcase939btype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getDescription();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlString xgetDescription();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetDescription();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDescription(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetDescription(XmlString paramXmlString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetDescription();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Files getFiles();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFiles(Files paramFiles);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Files addNewFiles();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlID xgetId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setId(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetId(XmlID paramXmlID);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getOrigin();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetOrigin();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetOrigin();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setOrigin(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetOrigin(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetOrigin();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getModified();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlBoolean xgetModified();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetModified();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setModified(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetModified(XmlBoolean paramXmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetModified();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Files
/*     */     extends XmlObject
/*     */   {
/* 163 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((TestCase.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestCase$Files == null) ? (TestCase.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestCase$Files = TestCase.null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.TestCase$Files")) : TestCase.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestCase$Files).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("files7c3eelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FileDesc[] getFileArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FileDesc getFileArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfFileArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setFileArray(FileDesc[] param1ArrayOfFileDesc);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setFileArray(int param1Int, FileDesc param1FileDesc);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FileDesc insertNewFile(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FileDesc addNewFile();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeFile(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static TestCase.Files newInstance() {
/* 214 */         return (TestCase.Files)XmlBeans.getContextTypeLoader().newInstance(TestCase.Files.type, null);
/*     */       }
/*     */       public static TestCase.Files newInstance(XmlOptions param2XmlOptions) {
/* 217 */         return (TestCase.Files)XmlBeans.getContextTypeLoader().newInstance(TestCase.Files.type, param2XmlOptions);
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
/*     */     public static TestCase newInstance() {
/* 231 */       return (TestCase)XmlBeans.getContextTypeLoader().newInstance(TestCase.type, null);
/*     */     }
/*     */     public static TestCase newInstance(XmlOptions param1XmlOptions) {
/* 234 */       return (TestCase)XmlBeans.getContextTypeLoader().newInstance(TestCase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TestCase parse(String param1String) throws XmlException {
/* 238 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1String, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 241 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1String, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TestCase parse(File param1File) throws XmlException, IOException {
/* 245 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1File, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 248 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1File, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     public static TestCase parse(URL param1URL) throws XmlException, IOException {
/* 251 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1URL, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 254 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1URL, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     public static TestCase parse(InputStream param1InputStream) throws XmlException, IOException {
/* 257 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1InputStream, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 260 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1InputStream, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     public static TestCase parse(Reader param1Reader) throws XmlException, IOException {
/* 263 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1Reader, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 266 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1Reader, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     public static TestCase parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 269 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 272 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     public static TestCase parse(Node param1Node) throws XmlException {
/* 275 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1Node, TestCase.type, null);
/*     */     }
/*     */     public static TestCase parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 278 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1Node, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TestCase parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 282 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TestCase.type, null);
/*     */     }
/*     */     
/*     */     public static TestCase parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 286 */       return (TestCase)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TestCase.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 290 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TestCase.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 294 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TestCase.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\TestCase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */