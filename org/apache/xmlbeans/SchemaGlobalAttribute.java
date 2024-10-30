/*    */ package org.apache.xmlbeans;
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
/*    */ public interface SchemaGlobalAttribute
/*    */   extends SchemaComponent, SchemaLocalAttribute
/*    */ {
/*    */   Ref getRef();
/*    */   
/*    */   public static final class Ref
/*    */     extends SchemaComponent.Ref
/*    */   {
/*    */     public Ref(SchemaGlobalAttribute param1SchemaGlobalAttribute) {
/* 33 */       super(param1SchemaGlobalAttribute);
/*    */     }
/*    */     public Ref(SchemaTypeSystem param1SchemaTypeSystem, String param1String) {
/* 36 */       super(param1SchemaTypeSystem, param1String);
/*    */     }
/*    */     public final int getComponentType() {
/* 39 */       return 3;
/*    */     }
/*    */     public final SchemaGlobalAttribute get() {
/* 42 */       return (SchemaGlobalAttribute)getComponent();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaGlobalAttribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */