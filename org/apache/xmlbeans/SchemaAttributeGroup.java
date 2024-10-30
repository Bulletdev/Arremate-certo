/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface SchemaAttributeGroup
/*    */   extends SchemaAnnotated, SchemaComponent
/*    */ {
/*    */   int getComponentType();
/*    */   
/*    */   b getName();
/*    */   
/*    */   Object getUserData();
/*    */   
/*    */   public static final class Ref
/*    */     extends SchemaComponent.Ref
/*    */   {
/*    */     public Ref(SchemaAttributeGroup param1SchemaAttributeGroup) {
/* 53 */       super(param1SchemaAttributeGroup);
/*    */     }
/*    */     public Ref(SchemaTypeSystem param1SchemaTypeSystem, String param1String) {
/* 56 */       super(param1SchemaTypeSystem, param1String);
/*    */     }
/*    */     public final int getComponentType() {
/* 59 */       return 4;
/*    */     }
/*    */     public final SchemaAttributeGroup get() {
/* 62 */       return (SchemaAttributeGroup)getComponent();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaAttributeGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */