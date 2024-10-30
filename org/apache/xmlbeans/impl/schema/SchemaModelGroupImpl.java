/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaModelGroup;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaModelGroupImpl
/*     */   implements SchemaModelGroup
/*     */ {
/*     */   private SchemaContainer _container;
/*     */   private b _name;
/*     */   private XmlObject _parseObject;
/*     */   private Object _userData;
/*     */   private String _parseTNS;
/*     */   private boolean _chameleon;
/*     */   private String _elemFormDefault;
/*     */   private String _attFormDefault;
/*     */   private boolean _redefinition;
/*     */   private SchemaAnnotation _annotation;
/*     */   private String _filename;
/*     */   private SchemaModelGroup.Ref _selfref;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public SchemaModelGroupImpl(SchemaContainer paramSchemaContainer) {
/* 109 */     this._selfref = new SchemaModelGroup.Ref(this); this._container = paramSchemaContainer; } public SchemaModelGroupImpl(SchemaContainer paramSchemaContainer, b paramb) { this._selfref = new SchemaModelGroup.Ref(this); this._container = paramSchemaContainer; this._name = paramb; }
/*     */   public void init(b paramb, String paramString1, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2, XmlObject paramXmlObject, SchemaAnnotation paramSchemaAnnotation, Object paramObject) { assert this._name == null || paramb.equals(this._name); this._name = paramb; this._parseTNS = paramString1; this._chameleon = paramBoolean1; this._elemFormDefault = paramString2; this._attFormDefault = paramString3; this._redefinition = paramBoolean2; this._parseObject = paramXmlObject; this._annotation = paramSchemaAnnotation; this._userData = paramObject; }
/*     */   public SchemaTypeSystem getTypeSystem() { return this._container.getTypeSystem(); }
/* 112 */   SchemaContainer getContainer() { return this._container; } public int getComponentType() { return 6; } public void setFilename(String paramString) { this._filename = paramString; } public String getSourceName() { return this._filename; } public b getName() { return this._name; } public SchemaModelGroup.Ref getRef() { return this._selfref; }
/*     */   public XmlObject getParseObject() { return this._parseObject; }
/*     */   public String getTargetNamespace() { return this._parseTNS; }
/* 115 */   public String getChameleonNamespace() { return this._chameleon ? this._parseTNS : null; } public String getElemFormDefault() { return this._elemFormDefault; } public String getAttFormDefault() { return this._attFormDefault; } public boolean isRedefinition() { return this._redefinition; } public SchemaAnnotation getAnnotation() { return this._annotation; } public SchemaComponent.Ref getComponentRef() { return (SchemaComponent.Ref)getRef(); }
/*     */   
/*     */   public Object getUserData() {
/* 118 */     return this._userData;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaModelGroupImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */