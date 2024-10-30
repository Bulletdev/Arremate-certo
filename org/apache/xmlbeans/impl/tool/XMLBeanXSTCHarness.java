/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XMLBeanXSTCHarness
/*     */   implements XSTCTester.Harness
/*     */ {
/*     */   public void runTestCase(XSTCTester.TestCaseResult paramTestCaseResult) {
/*  35 */     XSTCTester.TestCase testCase = paramTestCaseResult.getTestCase();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  41 */       ArrayList arrayList = new ArrayList();
/*  42 */       boolean bool1 = true;
/*  43 */       boolean bool2 = true;
/*     */       
/*  45 */       if (testCase.getSchemaFile() == null) {
/*     */         return;
/*     */       }
/*     */       
/*  49 */       SchemaTypeLoader schemaTypeLoader = null;
/*     */       
/*     */       try {
/*  52 */         XmlObject xmlObject1 = XmlObject.Factory.parse(testCase.getSchemaFile(), (new XmlOptions()).setErrorListener(arrayList).setLoadLineNumbers());
/*  53 */         XmlObject xmlObject2 = null;
/*  54 */         if (testCase.getResourceFile() != null)
/*  55 */           xmlObject2 = XmlObject.Factory.parse(testCase.getResourceFile(), (new XmlOptions()).setErrorListener(arrayList).setLoadLineNumbers()); 
/*  56 */         (new XmlObject[1])[0] = xmlObject1; (new XmlObject[2])[0] = xmlObject1; (new XmlObject[2])[1] = xmlObject2; XmlObject[] arrayOfXmlObject = (xmlObject2 == null) ? new XmlObject[1] : new XmlObject[2];
/*  57 */         SchemaTypeSystem schemaTypeSystem = XmlBeans.compileXsd(arrayOfXmlObject, (SchemaTypeLoader)XmlBeans.getBuiltinTypeSystem(), (new XmlOptions()).setErrorListener(arrayList));
/*  58 */         schemaTypeLoader = XmlBeans.typeLoaderUnion(new SchemaTypeLoader[] { (SchemaTypeLoader)schemaTypeSystem, (SchemaTypeLoader)XmlBeans.getBuiltinTypeSystem() });
/*     */       }
/*  60 */       catch (Exception exception) {
/*     */         
/*  62 */         bool1 = false;
/*  63 */         if (!(exception instanceof org.apache.xmlbeans.XmlException) || arrayList.isEmpty()) {
/*     */           
/*  65 */           paramTestCaseResult.setCrash(true);
/*  66 */           StringWriter stringWriter = new StringWriter();
/*  67 */           exception.printStackTrace(new PrintWriter(stringWriter));
/*  68 */           paramTestCaseResult.addSvMessages(Collections.singleton(stringWriter.toString()));
/*     */         } 
/*     */       } 
/*     */       
/*  72 */       paramTestCaseResult.addSvMessages(arrayList);
/*  73 */       paramTestCaseResult.setSvActual(bool1);
/*  74 */       arrayList.clear();
/*     */       
/*  76 */       if (schemaTypeLoader == null) {
/*     */         return;
/*     */       }
/*  79 */       if (testCase.getInstanceFile() == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/*  85 */         XmlObject xmlObject = schemaTypeLoader.parse(testCase.getInstanceFile(), null, (new XmlOptions()).setErrorListener(arrayList).setLoadLineNumbers());
/*  86 */         if (!xmlObject.validate((new XmlOptions()).setErrorListener(arrayList))) {
/*  87 */           bool2 = false;
/*     */         }
/*  89 */       } catch (Exception exception) {
/*     */         
/*  91 */         bool2 = false;
/*  92 */         if (!(exception instanceof org.apache.xmlbeans.XmlException) || arrayList.isEmpty()) {
/*     */           
/*  94 */           paramTestCaseResult.setCrash(true);
/*  95 */           StringWriter stringWriter = new StringWriter();
/*  96 */           exception.printStackTrace(new PrintWriter(stringWriter));
/*  97 */           paramTestCaseResult.addIvMessages(Collections.singleton(stringWriter.toString()));
/*     */         } 
/*     */       } 
/* 100 */       paramTestCaseResult.addIvMessages(arrayList);
/* 101 */       paramTestCaseResult.setIvActual(bool2);
/*     */     } finally {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\XMLBeanXSTCHarness.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */