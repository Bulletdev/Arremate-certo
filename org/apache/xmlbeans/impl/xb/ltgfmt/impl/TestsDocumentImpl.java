/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TestsDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements TestsDocument
/*     */ {
/*     */   public TestsDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b TESTS$0 = new b("http://www.bea.com/2003/05/xmlbean/ltgfmt", "tests");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TestsDocument.Tests getTests() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       TestsDocument.Tests tests = null;
/*  36 */       tests = (TestsDocument.Tests)get_store().find_element_user(TESTS$0, 0);
/*  37 */       if (tests == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return tests;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTests(TestsDocument.Tests paramTests) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       TestsDocument.Tests tests = null;
/*  54 */       tests = (TestsDocument.Tests)get_store().find_element_user(TESTS$0, 0);
/*  55 */       if (tests == null)
/*     */       {
/*  57 */         tests = (TestsDocument.Tests)get_store().add_element_user(TESTS$0);
/*     */       }
/*  59 */       tests.set((XmlObject)paramTests);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TestsDocument.Tests addNewTests() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       TestsDocument.Tests tests = null;
/*  72 */       tests = (TestsDocument.Tests)get_store().add_element_user(TESTS$0);
/*  73 */       return tests;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TestsImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements TestsDocument.Tests
/*     */   {
/*     */     public TestsImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b TEST$0 = new b("http://www.bea.com/2003/05/xmlbean/ltgfmt", "test");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TestCase[] getTestArray() {
/*  98 */       synchronized (monitor()) {
/*     */         
/* 100 */         check_orphaned();
/* 101 */         ArrayList arrayList = new ArrayList();
/* 102 */         get_store().find_all_element_users(TEST$0, arrayList);
/* 103 */         TestCase[] arrayOfTestCase = new TestCase[arrayList.size()];
/* 104 */         arrayList.toArray((Object[])arrayOfTestCase);
/* 105 */         return arrayOfTestCase;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TestCase getTestArray(int param1Int) {
/* 114 */       synchronized (monitor()) {
/*     */         
/* 116 */         check_orphaned();
/* 117 */         TestCase testCase = null;
/* 118 */         testCase = (TestCase)get_store().find_element_user(TEST$0, param1Int);
/* 119 */         if (testCase == null)
/*     */         {
/* 121 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 123 */         return testCase;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfTestArray() {
/* 132 */       synchronized (monitor()) {
/*     */         
/* 134 */         check_orphaned();
/* 135 */         return get_store().count_elements(TEST$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTestArray(TestCase[] param1ArrayOfTestCase) {
/* 144 */       synchronized (monitor()) {
/*     */         
/* 146 */         check_orphaned();
/* 147 */         arraySetterHelper((XmlObject[])param1ArrayOfTestCase, TEST$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTestArray(int param1Int, TestCase param1TestCase) {
/* 156 */       synchronized (monitor()) {
/*     */         
/* 158 */         check_orphaned();
/* 159 */         TestCase testCase = null;
/* 160 */         testCase = (TestCase)get_store().find_element_user(TEST$0, param1Int);
/* 161 */         if (testCase == null)
/*     */         {
/* 163 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 165 */         testCase.set((XmlObject)param1TestCase);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TestCase insertNewTest(int param1Int) {
/* 174 */       synchronized (monitor()) {
/*     */         
/* 176 */         check_orphaned();
/* 177 */         TestCase testCase = null;
/* 178 */         testCase = (TestCase)get_store().insert_element_user(TEST$0, param1Int);
/* 179 */         return testCase;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TestCase addNewTest() {
/* 188 */       synchronized (monitor()) {
/*     */         
/* 190 */         check_orphaned();
/* 191 */         TestCase testCase = null;
/* 192 */         testCase = (TestCase)get_store().add_element_user(TEST$0);
/* 193 */         return testCase;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeTest(int param1Int) {
/* 202 */       synchronized (monitor()) {
/*     */         
/* 204 */         check_orphaned();
/* 205 */         get_store().remove_element(TEST$0, param1Int);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\impl\TestsDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */