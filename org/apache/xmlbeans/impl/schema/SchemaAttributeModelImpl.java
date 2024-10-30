/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.QNameSet;
/*     */ import org.apache.xmlbeans.SchemaAttributeModel;
/*     */ import org.apache.xmlbeans.SchemaLocalAttribute;
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
/*     */ public class SchemaAttributeModelImpl
/*     */   implements SchemaAttributeModel
/*     */ {
/*     */   private Map attrMap;
/*     */   private QNameSet wcSet;
/*     */   private int wcProcess;
/*     */   
/*     */   public SchemaAttributeModelImpl() {
/*  36 */     this.attrMap = new LinkedHashMap();
/*  37 */     this.wcSet = null;
/*  38 */     this.wcProcess = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAttributeModelImpl(SchemaAttributeModel paramSchemaAttributeModel) {
/*  43 */     this.attrMap = new LinkedHashMap();
/*  44 */     if (paramSchemaAttributeModel == null) {
/*     */       
/*  46 */       this.wcSet = null;
/*  47 */       this.wcProcess = 0;
/*     */     }
/*     */     else {
/*     */       
/*  51 */       SchemaLocalAttribute[] arrayOfSchemaLocalAttribute = paramSchemaAttributeModel.getAttributes();
/*  52 */       for (byte b = 0; b < arrayOfSchemaLocalAttribute.length; b++)
/*     */       {
/*  54 */         this.attrMap.put(arrayOfSchemaLocalAttribute[b].getName(), arrayOfSchemaLocalAttribute[b]);
/*     */       }
/*     */       
/*  57 */       if (paramSchemaAttributeModel.getWildcardProcess() != 0) {
/*     */         
/*  59 */         this.wcSet = paramSchemaAttributeModel.getWildcardSet();
/*  60 */         this.wcProcess = paramSchemaAttributeModel.getWildcardProcess();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*  65 */   private static final SchemaLocalAttribute[] EMPTY_SLA_ARRAY = new SchemaLocalAttribute[0];
/*     */ 
/*     */   
/*     */   public SchemaLocalAttribute[] getAttributes() {
/*  69 */     return (SchemaLocalAttribute[])this.attrMap.values().toArray((Object[])EMPTY_SLA_ARRAY);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaLocalAttribute getAttribute(b paramb) {
/*  74 */     return (SchemaLocalAttribute)this.attrMap.get(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAttribute(SchemaLocalAttribute paramSchemaLocalAttribute) {
/*  79 */     this.attrMap.put(paramSchemaLocalAttribute.getName(), paramSchemaLocalAttribute);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeProhibitedAttribute(b paramb) {
/*  84 */     this.attrMap.remove(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public QNameSet getWildcardSet() {
/*  89 */     return (this.wcSet == null) ? QNameSet.EMPTY : this.wcSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWildcardSet(QNameSet paramQNameSet) {
/*  94 */     this.wcSet = paramQNameSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWildcardProcess() {
/*  99 */     return this.wcProcess;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWildcardProcess(int paramInt) {
/* 104 */     this.wcProcess = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaAttributeModelImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */