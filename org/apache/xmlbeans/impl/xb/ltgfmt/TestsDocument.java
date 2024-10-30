/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt;
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
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface TestsDocument extends XmlObject {
/*  19 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument == null) ? (null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument = null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument")) : null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("tests5621doctype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Tests getTests();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTests(Tests paramTests);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Tests addNewTests();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Tests
/*     */     extends XmlObject
/*     */   {
/*  44 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((TestsDocument.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests == null) ? (TestsDocument.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests = TestsDocument.null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument$Tests")) : TestsDocument.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("tests9d6eelemtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TestCase[] getTestArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TestCase getTestArray(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int sizeOfTestArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTestArray(TestCase[] param1ArrayOfTestCase);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void setTestArray(int param1Int, TestCase param1TestCase);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TestCase insertNewTest(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TestCase addNewTest();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void removeTest(int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static TestsDocument.Tests newInstance() {
/*  95 */         return (TestsDocument.Tests)XmlBeans.getContextTypeLoader().newInstance(TestsDocument.Tests.type, null);
/*     */       }
/*     */       public static TestsDocument.Tests newInstance(XmlOptions param2XmlOptions) {
/*  98 */         return (TestsDocument.Tests)XmlBeans.getContextTypeLoader().newInstance(TestsDocument.Tests.type, param2XmlOptions);
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
/*     */     public static TestsDocument newInstance() {
/* 112 */       return (TestsDocument)XmlBeans.getContextTypeLoader().newInstance(TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument newInstance(XmlOptions param1XmlOptions) {
/* 115 */       return (TestsDocument)XmlBeans.getContextTypeLoader().newInstance(TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TestsDocument parse(String param1String) throws XmlException {
/* 119 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1String, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 122 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1String, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TestsDocument parse(File param1File) throws XmlException, IOException {
/* 126 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1File, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 129 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1File, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TestsDocument parse(URL param1URL) throws XmlException, IOException {
/* 132 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 135 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1URL, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TestsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
/* 138 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 141 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1InputStream, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TestsDocument parse(Reader param1Reader) throws XmlException, IOException {
/* 144 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 147 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1Reader, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TestsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 150 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 153 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     public static TestsDocument parse(Node param1Node) throws XmlException {
/* 156 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, TestsDocument.type, null);
/*     */     }
/*     */     public static TestsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 159 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1Node, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TestsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 163 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TestsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static TestsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 167 */       return (TestsDocument)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 171 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TestsDocument.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 175 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TestsDocument.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\TestsDocument.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */