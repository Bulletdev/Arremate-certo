/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.property.Property;
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
/*     */ public final class PropertyBlock
/*     */   extends BigBlock
/*     */ {
/*     */   private Property[] _properties;
/*     */   
/*     */   private PropertyBlock(POIFSBigBlockSize paramPOIFSBigBlockSize, Property[] paramArrayOfProperty, int paramInt) {
/*  44 */     super(paramPOIFSBigBlockSize);
/*     */     
/*  46 */     this._properties = new Property[paramPOIFSBigBlockSize.getPropertiesPerBlock()];
/*  47 */     for (byte b = 0; b < this._properties.length; b++)
/*     */     {
/*  49 */       this._properties[b] = paramArrayOfProperty[b + paramInt];
/*     */     }
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
/*     */   public static BlockWritable[] createPropertyBlockArray(POIFSBigBlockSize paramPOIFSBigBlockSize, List<Property> paramList) {
/*  67 */     int i = paramPOIFSBigBlockSize.getPropertiesPerBlock();
/*  68 */     int j = (paramList.size() + i - 1) / i;
/*     */ 
/*     */     
/*  71 */     Property[] arrayOfProperty = new Property[j * i];
/*     */ 
/*     */     
/*  74 */     System.arraycopy(paramList.toArray(new Property[0]), 0, arrayOfProperty, 0, paramList.size());
/*     */     
/*  76 */     for (int k = paramList.size(); k < arrayOfProperty.length; k++) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  81 */       arrayOfProperty[k] = new Property()
/*     */         {
/*     */           protected void preWrite() {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isDirectory() {
/*  89 */             return false;
/*     */           }
/*     */         };
/*     */     } 
/*  93 */     BlockWritable[] arrayOfBlockWritable = new BlockWritable[j];
/*     */     
/*  95 */     for (byte b = 0; b < j; b++)
/*     */     {
/*  97 */       arrayOfBlockWritable[b] = new PropertyBlock(paramPOIFSBigBlockSize, arrayOfProperty, b * i);
/*     */     }
/*     */     
/* 100 */     return arrayOfBlockWritable;
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
/*     */   void writeData(OutputStream paramOutputStream) throws IOException {
/* 118 */     int i = this.bigBlockSize.getPropertiesPerBlock();
/* 119 */     for (byte b = 0; b < i; b++)
/*     */     {
/* 121 */       this._properties[b].writeData(paramOutputStream);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\PropertyBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */