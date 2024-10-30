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
/*    */ public interface SchemaModelGroup
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
/*    */     public Ref(SchemaModelGroup param1SchemaModelGroup) {
/* 51 */       super(param1SchemaModelGroup);
/*    */     }
/*    */     public Ref(SchemaTypeSystem param1SchemaTypeSystem, String param1String) {
/* 54 */       super(param1SchemaTypeSystem, param1String);
/*    */     }
/*    */     public final int getComponentType() {
/* 57 */       return 6;
/*    */     }
/*    */     public final SchemaModelGroup get() {
/* 60 */       return (SchemaModelGroup)getComponent();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaModelGroup.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */