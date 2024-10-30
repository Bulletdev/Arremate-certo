/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LengthDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements LengthDocument
/*    */ {
/*    */   public LengthDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b LENGTH$0 = new b("http://www.w3.org/2001/XMLSchema", "length");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumFacet getLength() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       NumFacet numFacet = null;
/* 36 */       numFacet = (NumFacet)get_store().find_element_user(LENGTH$0, 0);
/* 37 */       if (numFacet == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return numFacet;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLength(NumFacet paramNumFacet) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       NumFacet numFacet = null;
/* 54 */       numFacet = (NumFacet)get_store().find_element_user(LENGTH$0, 0);
/* 55 */       if (numFacet == null)
/*    */       {
/* 57 */         numFacet = (NumFacet)get_store().add_element_user(LENGTH$0);
/*    */       }
/* 59 */       numFacet.set((XmlObject)paramNumFacet);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumFacet addNewLength() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       NumFacet numFacet = null;
/* 72 */       numFacet = (NumFacet)get_store().add_element_user(LENGTH$0);
/* 73 */       return numFacet;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\LengthDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */