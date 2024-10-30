/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaAttributeGroupImpl
/*     */   implements SchemaAttributeGroup
/*     */ {
/*     */   private SchemaContainer _container;
/*     */   private b _name;
/*     */   private XmlObject _parseObject;
/*     */   private Object _userData;
/*     */   private String _parseTNS;
/*     */   private String _formDefault;
/*     */   private boolean _chameleon;
/*     */   private boolean _redefinition;
/*     */   private SchemaAnnotation _annotation;
/*     */   private String _filename;
/*     */   private SchemaAttributeGroup.Ref _selfref;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public SchemaAttributeGroupImpl(SchemaContainer paramSchemaContainer) {
/* 100 */     this._selfref = new SchemaAttributeGroup.Ref(this); this._container = paramSchemaContainer; } public SchemaAttributeGroupImpl(SchemaContainer paramSchemaContainer, b paramb) { this._selfref = new SchemaAttributeGroup.Ref(this); this._container = paramSchemaContainer; this._name = paramb; }
/*     */   public void init(b paramb, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, XmlObject paramXmlObject, SchemaAnnotation paramSchemaAnnotation, Object paramObject) { assert this._name == null || paramb.equals(this._name); this._name = paramb; this._parseTNS = paramString1; this._chameleon = paramBoolean1; this._formDefault = paramString2; this._redefinition = paramBoolean2; this._parseObject = paramXmlObject; this._annotation = paramSchemaAnnotation; this._userData = paramObject; }
/*     */   public SchemaTypeSystem getTypeSystem() { return this._container.getTypeSystem(); }
/* 103 */   SchemaContainer getContainer() { return this._container; } public int getComponentType() { return 4; } public void setFilename(String paramString) { this._filename = paramString; } public String getSourceName() { return this._filename; } public SchemaAttributeGroup.Ref getRef() { return this._selfref; }
/*     */   public b getName() { return this._name; }
/*     */   public XmlObject getParseObject() { return this._parseObject; }
/* 106 */   public String getTargetNamespace() { return this._parseTNS; } public String getChameleonNamespace() { return this._chameleon ? this._parseTNS : null; } public String getFormDefault() { return this._formDefault; } public SchemaAnnotation getAnnotation() { return this._annotation; } public SchemaComponent.Ref getComponentRef() { return (SchemaComponent.Ref)getRef(); }
/*     */   
/*     */   public boolean isRedefinition() {
/* 109 */     return this._redefinition;
/*     */   }
/*     */   public Object getUserData() {
/* 112 */     return this._userData;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaAttributeGroupImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */