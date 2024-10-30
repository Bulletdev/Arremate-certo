/*    */ package org.apache.xmlbeans.impl.schema;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaComponent;
/*    */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*    */ import org.apache.xmlbeans.SchemaTypeSystem;
/*    */ import org.apache.xmlbeans.XmlObject;
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
/*    */ public class SchemaGlobalAttributeImpl
/*    */   extends SchemaLocalAttributeImpl
/*    */   implements SchemaGlobalAttribute
/*    */ {
/*    */   SchemaContainer _container;
/*    */   String _filename;
/*    */   private String _parseTNS;
/*    */   private boolean _chameleon;
/*    */   private SchemaGlobalAttribute.Ref _selfref;
/*    */   
/*    */   public SchemaTypeSystem getTypeSystem() {
/*    */     return this._container.getTypeSystem();
/*    */   }
/*    */   
/*    */   SchemaContainer getContainer() {
/*    */     return this._container;
/*    */   }
/*    */   
/*    */   public int getComponentType() {
/*    */     return 3;
/*    */   }
/*    */   
/*    */   public String getSourceName() {
/*    */     return this._filename;
/*    */   }
/*    */   
/*    */   public void setFilename(String paramString) {
/*    */     this._filename = paramString;
/*    */   }
/*    */   
/*    */   public void setParseContext(XmlObject paramXmlObject, String paramString, boolean paramBoolean) {
/*    */     this._parseObject = paramXmlObject;
/*    */     this._parseTNS = paramString;
/*    */     this._chameleon = paramBoolean;
/*    */   }
/*    */   
/*    */   public XmlObject getParseObject() {
/*    */     return this._parseObject;
/*    */   }
/*    */   
/*    */   public String getTargetNamespace() {
/*    */     return this._parseTNS;
/*    */   }
/*    */   
/*    */   public String getChameleonNamespace() {
/*    */     return this._chameleon ? this._parseTNS : null;
/*    */   }
/*    */   
/*    */   public SchemaGlobalAttributeImpl(SchemaContainer paramSchemaContainer) {
/* 78 */     this._selfref = new SchemaGlobalAttribute.Ref(this);
/*    */     this._container = paramSchemaContainer;
/*    */   } public SchemaGlobalAttribute.Ref getRef() {
/* 81 */     return this._selfref;
/*    */   }
/*    */   public SchemaComponent.Ref getComponentRef() {
/* 84 */     return (SchemaComponent.Ref)getRef();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaGlobalAttributeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */