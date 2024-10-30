/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ import org.apache.poi.poifs.filesystem.BATManaged;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
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
/*     */ public abstract class PropertyTableBase
/*     */   implements BATManaged
/*     */ {
/*     */   private final HeaderBlock _header_block;
/*     */   protected final List<Property> _properties;
/*     */   
/*     */   public PropertyTableBase(HeaderBlock paramHeaderBlock) {
/*  41 */     this._header_block = paramHeaderBlock;
/*  42 */     this._properties = new ArrayList<Property>();
/*  43 */     addProperty(new RootProperty());
/*     */   }
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
/*     */   public PropertyTableBase(HeaderBlock paramHeaderBlock, List<Property> paramList) throws IOException {
/*  61 */     this._header_block = paramHeaderBlock;
/*  62 */     this._properties = paramList;
/*  63 */     populatePropertyTree((DirectoryProperty)this._properties.get(0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProperty(Property paramProperty) {
/*  73 */     this._properties.add(paramProperty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeProperty(Property paramProperty) {
/*  83 */     this._properties.remove(paramProperty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RootProperty getRoot() {
/*  94 */     return (RootProperty)this._properties.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void populatePropertyTree(DirectoryProperty paramDirectoryProperty) throws IOException {
/* 100 */     int i = paramDirectoryProperty.getChildIndex();
/*     */     
/* 102 */     if (!Property.isValidIndex(i)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 108 */     Stack<Property> stack = new Stack();
/*     */     
/* 110 */     stack.push(this._properties.get(i));
/* 111 */     while (!stack.empty()) {
/*     */       
/* 113 */       Property property = stack.pop();
/* 114 */       if (property == null) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 120 */       paramDirectoryProperty.addChild(property);
/* 121 */       if (property.isDirectory())
/*     */       {
/* 123 */         populatePropertyTree((DirectoryProperty)property);
/*     */       }
/* 125 */       i = property.getPreviousChildIndex();
/* 126 */       if (Property.isValidIndex(i))
/*     */       {
/* 128 */         stack.push(this._properties.get(i));
/*     */       }
/* 130 */       i = property.getNextChildIndex();
/* 131 */       if (Property.isValidIndex(i))
/*     */       {
/* 133 */         stack.push(this._properties.get(i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartBlock() {
/* 145 */     return this._header_block.getPropertyStart();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartBlock(int paramInt) {
/* 156 */     this._header_block.setPropertyStart(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\PropertyTableBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */