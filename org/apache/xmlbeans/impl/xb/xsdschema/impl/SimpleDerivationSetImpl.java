/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*    */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*    */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleDerivationSetImpl
/*    */   extends XmlUnionImpl
/*    */   implements SimpleDerivationSet, SimpleDerivationSet.Member, SimpleDerivationSet.Member2
/*    */ {
/*    */   public SimpleDerivationSetImpl(SchemaType paramSchemaType) {
/* 21 */     super(paramSchemaType, false);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SimpleDerivationSetImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 26 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MemberImpl
/*    */     extends JavaStringEnumerationHolderEx
/*    */     implements SimpleDerivationSet.Member
/*    */   {
/*    */     public MemberImpl(SchemaType param1SchemaType) {
/* 38 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MemberImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 43 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MemberImpl2
/*    */     extends XmlListImpl
/*    */     implements SimpleDerivationSet.Member2
/*    */   {
/*    */     public MemberImpl2(SchemaType param1SchemaType) {
/* 56 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MemberImpl2(SchemaType param1SchemaType, boolean param1Boolean) {
/* 61 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static class ItemImpl
/*    */       extends JavaStringEnumerationHolderEx
/*    */       implements SimpleDerivationSet.Member2.Item
/*    */     {
/*    */       public ItemImpl(SchemaType param2SchemaType) {
/* 73 */         super(param2SchemaType, false);
/*    */       }
/*    */ 
/*    */       
/*    */       protected ItemImpl(SchemaType param2SchemaType, boolean param2Boolean) {
/* 78 */         super(param2SchemaType, param2Boolean);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SimpleDerivationSetImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */