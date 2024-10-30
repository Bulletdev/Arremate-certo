/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import javax.xml.namespace.b;
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
/*     */ public interface SchemaComponent
/*     */ {
/*     */   public static final int TYPE = 0;
/*     */   public static final int ELEMENT = 1;
/*     */   public static final int ATTRIBUTE = 3;
/*     */   public static final int ATTRIBUTE_GROUP = 4;
/*     */   public static final int IDENTITY_CONSTRAINT = 5;
/*     */   public static final int MODEL_GROUP = 6;
/*     */   public static final int NOTATION = 7;
/*     */   public static final int ANNOTATION = 8;
/*     */   
/*     */   int getComponentType();
/*     */   
/*     */   SchemaTypeSystem getTypeSystem();
/*     */   
/*     */   b getName();
/*     */   
/*     */   String getSourceName();
/*     */   
/*     */   Ref getComponentRef();
/*     */   
/*     */   public static abstract class Ref
/*     */   {
/*     */     private volatile SchemaComponent _schemaComponent;
/*     */     private SchemaTypeSystem _schemaTypeSystem;
/*     */     public String _handle;
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     protected Ref(SchemaComponent param1SchemaComponent) {
/*  91 */       this._schemaComponent = param1SchemaComponent;
/*     */     }
/*     */     protected Ref(SchemaTypeSystem param1SchemaTypeSystem, String param1String) {
/*  94 */       assert param1String != null; this._schemaTypeSystem = param1SchemaTypeSystem; this._handle = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract int getComponentType();
/*     */ 
/*     */     
/*     */     public final SchemaTypeSystem getTypeSystem() {
/* 103 */       return this._schemaTypeSystem;
/*     */     }
/*     */     
/*     */     public final SchemaComponent getComponent() {
/* 107 */       if (this._schemaComponent == null && this._handle != null)
/*     */       {
/* 109 */         synchronized (this) {
/*     */           
/* 111 */           if (this._schemaComponent == null && this._handle != null) {
/*     */             
/* 113 */             this._schemaComponent = this._schemaTypeSystem.resolveHandle(this._handle);
/* 114 */             this._schemaTypeSystem = null;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 119 */       return this._schemaComponent;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaComponent.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */