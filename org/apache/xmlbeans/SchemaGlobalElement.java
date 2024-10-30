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
/*    */ public interface SchemaGlobalElement
/*    */   extends SchemaComponent, SchemaLocalElement
/*    */ {
/*    */   b[] substitutionGroupMembers();
/*    */   
/*    */   SchemaGlobalElement substitutionGroup();
/*    */   
/*    */   boolean finalExtension();
/*    */   
/*    */   boolean finalRestriction();
/*    */   
/*    */   Ref getRef();
/*    */   
/*    */   public static final class Ref
/*    */     extends SchemaComponent.Ref
/*    */   {
/*    */     public Ref(SchemaGlobalElement param1SchemaGlobalElement) {
/* 67 */       super(param1SchemaGlobalElement);
/*    */     }
/*    */     public Ref(SchemaTypeSystem param1SchemaTypeSystem, String param1String) {
/* 70 */       super(param1SchemaTypeSystem, param1String);
/*    */     }
/*    */     public final int getComponentType() {
/* 73 */       return 1;
/*    */     }
/*    */     public final SchemaGlobalElement get() {
/* 76 */       return (SchemaGlobalElement)getComponent();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaGlobalElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */