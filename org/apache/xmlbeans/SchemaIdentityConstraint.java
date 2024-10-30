/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface SchemaIdentityConstraint
/*    */   extends SchemaAnnotated, SchemaComponent
/*    */ {
/*    */   public static final int CC_KEY = 1;
/*    */   public static final int CC_KEYREF = 2;
/*    */   public static final int CC_UNIQUE = 3;
/*    */   
/*    */   String getSelector();
/*    */   
/*    */   Object getSelectorPath();
/*    */   
/*    */   String[] getFields();
/*    */   
/*    */   Object getFieldPath(int paramInt);
/*    */   
/*    */   Map getNSMap();
/*    */   
/*    */   int getConstraintCategory();
/*    */   
/*    */   SchemaIdentityConstraint getReferencedKey();
/*    */   
/*    */   Object getUserData();
/*    */   
/*    */   public static final class Ref
/*    */     extends SchemaComponent.Ref
/*    */   {
/*    */     public Ref(SchemaIdentityConstraint param1SchemaIdentityConstraint) {
/* 80 */       super(param1SchemaIdentityConstraint);
/*    */     }
/*    */     public Ref(SchemaTypeSystem param1SchemaTypeSystem, String param1String) {
/* 83 */       super(param1SchemaTypeSystem, param1String);
/*    */     }
/*    */     public final int getComponentType() {
/* 86 */       return 5;
/*    */     }
/*    */     public final SchemaIdentityConstraint get() {
/* 89 */       return (SchemaIdentityConstraint)getComponent();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaIdentityConstraint.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */