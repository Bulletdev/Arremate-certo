/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*    */ import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
/*    */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NarrowMaxMinImpl
/*    */   extends LocalElementImpl
/*    */   implements NarrowMaxMin
/*    */ {
/*    */   public NarrowMaxMinImpl(SchemaType paramSchemaType) {
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
/*    */     implements NarrowMaxMin.MinOccurs
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
/*    */     implements XmlNonNegativeInteger, AllNNI.Member, NarrowMaxMin.MaxOccurs
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


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\NarrowMaxMinImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */