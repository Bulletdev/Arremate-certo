/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.storage.BlockWritable;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
/*     */ import org.apache.poi.poifs.storage.PropertyBlock;
/*     */ import org.apache.poi.poifs.storage.RawDataBlockList;
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
/*     */ public final class PropertyTable
/*     */   extends PropertyTableBase
/*     */   implements BlockWritable
/*     */ {
/*     */   private POIFSBigBlockSize _bigBigBlockSize;
/*     */   private BlockWritable[] _blocks;
/*     */   
/*     */   public PropertyTable(HeaderBlock paramHeaderBlock) {
/*  42 */     super(paramHeaderBlock);
/*  43 */     this._bigBigBlockSize = paramHeaderBlock.getBigBlockSize();
/*  44 */     this._blocks = null;
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
/*     */   public PropertyTable(HeaderBlock paramHeaderBlock, RawDataBlockList paramRawDataBlockList) throws IOException {
/*  62 */     super(paramHeaderBlock, PropertyFactory.convertToProperties(paramRawDataBlockList.fetchBlocks(paramHeaderBlock.getPropertyStart(), -1)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     this._bigBigBlockSize = paramHeaderBlock.getBigBlockSize();
/*  69 */     this._blocks = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void preWrite() {
/*  77 */     Property[] arrayOfProperty = this._properties.<Property>toArray(new Property[this._properties.size()]);
/*     */     
/*     */     byte b;
/*  80 */     for (b = 0; b < arrayOfProperty.length; b++)
/*     */     {
/*  82 */       arrayOfProperty[b].setIndex(b);
/*     */     }
/*     */ 
/*     */     
/*  86 */     this._blocks = PropertyBlock.createPropertyBlockArray(this._bigBigBlockSize, this._properties);
/*     */ 
/*     */     
/*  89 */     for (b = 0; b < arrayOfProperty.length; b++)
/*     */     {
/*  91 */       arrayOfProperty[b].preWrite();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countBlocks() {
/* 102 */     return (this._blocks == null) ? 0 : this._blocks.length;
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
/*     */   public void writeBlocks(OutputStream paramOutputStream) throws IOException {
/* 118 */     if (this._blocks != null)
/*     */     {
/* 120 */       for (byte b = 0; b < this._blocks.length; b++)
/*     */       {
/* 122 */         this._blocks[b].writeBlocks(paramOutputStream);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\PropertyTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */