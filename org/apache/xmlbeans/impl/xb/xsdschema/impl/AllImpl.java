/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*    */ import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
/*    */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.All;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllImpl
/*    */   extends ExplicitGroupImpl
/*    */   implements All
/*    */ {
/*    */   public AllImpl(SchemaType paramSchemaType) {
/* 19 */     super(paramSchemaType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MinOccursImpl
/*    */     extends JavaIntegerHolderEx
/*    */     implements All.MinOccurs
/*    */   {
/*    */     public MinOccursImpl(SchemaType param1SchemaType) {
/* 33 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MinOccursImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 38 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MaxOccursImpl
/*    */     extends XmlUnionImpl
/*    */     implements XmlNonNegativeInteger, All.MaxOccurs, AllNNI.Member
/*    */   {
/*    */     public MaxOccursImpl(SchemaType param1SchemaType) {
/* 53 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MaxOccursImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 58 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AllImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */