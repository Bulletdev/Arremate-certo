/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ddf.EscherDgRecord;
/*     */ import org.apache.poi.ddf.EscherDggRecord;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrawingManager2
/*     */ {
/*     */   EscherDggRecord dgg;
/*  33 */   List<EscherDgRecord> drawingGroups = new ArrayList<EscherDgRecord>();
/*     */ 
/*     */ 
/*     */   
/*     */   public DrawingManager2(EscherDggRecord paramEscherDggRecord) {
/*  38 */     this.dgg = paramEscherDggRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearDrawingGroups() {
/*  45 */     this.drawingGroups.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherDgRecord createDgRecord() {
/*  55 */     EscherDgRecord escherDgRecord = new EscherDgRecord();
/*  56 */     escherDgRecord.setRecordId((short)-4088);
/*  57 */     short s = findNewDrawingGroupId();
/*  58 */     escherDgRecord.setOptions((short)(s << 4));
/*  59 */     escherDgRecord.setNumShapes(0);
/*  60 */     escherDgRecord.setLastMSOSPID(-1);
/*  61 */     this.drawingGroups.add(escherDgRecord);
/*  62 */     this.dgg.addCluster(s, 0);
/*  63 */     this.dgg.setDrawingsSaved(this.dgg.getDrawingsSaved() + 1);
/*  64 */     return escherDgRecord;
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
/*     */   public int allocateShapeId(short paramShort) {
/*  76 */     EscherDgRecord escherDgRecord = getDrawingGroup(paramShort);
/*  77 */     return allocateShapeId(paramShort, escherDgRecord);
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
/*     */   public int allocateShapeId(short paramShort, EscherDgRecord paramEscherDgRecord) {
/*  90 */     this.dgg.setNumShapesSaved(this.dgg.getNumShapesSaved() + 1);
/*     */     
/*     */     int i;
/*  93 */     for (i = 0; i < (this.dgg.getFileIdClusters()).length; i++) {
/*     */       
/*  95 */       EscherDggRecord.FileIdCluster fileIdCluster = this.dgg.getFileIdClusters()[i];
/*  96 */       if (fileIdCluster.getDrawingGroupId() == paramShort && fileIdCluster.getNumShapeIdsUsed() != 1024) {
/*     */         
/*  98 */         int j = fileIdCluster.getNumShapeIdsUsed() + 1024 * (i + 1);
/*  99 */         fileIdCluster.incrementShapeId();
/* 100 */         paramEscherDgRecord.setNumShapes(paramEscherDgRecord.getNumShapes() + 1);
/* 101 */         paramEscherDgRecord.setLastMSOSPID(j);
/* 102 */         if (j >= this.dgg.getShapeIdMax())
/* 103 */           this.dgg.setShapeIdMax(j + 1); 
/* 104 */         return j;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 109 */     this.dgg.addCluster(paramShort, 0);
/* 110 */     this.dgg.getFileIdClusters()[(this.dgg.getFileIdClusters()).length - 1].incrementShapeId();
/* 111 */     paramEscherDgRecord.setNumShapes(paramEscherDgRecord.getNumShapes() + 1);
/* 112 */     i = 1024 * (this.dgg.getFileIdClusters()).length;
/* 113 */     paramEscherDgRecord.setLastMSOSPID(i);
/* 114 */     if (i >= this.dgg.getShapeIdMax())
/* 115 */       this.dgg.setShapeIdMax(i + 1); 
/* 116 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short findNewDrawingGroupId() {
/* 127 */     short s = 1;
/* 128 */     while (drawingGroupExists(s))
/* 129 */       s = (short)(s + 1); 
/* 130 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   EscherDgRecord getDrawingGroup(int paramInt) {
/* 135 */     return this.drawingGroups.get(paramInt - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean drawingGroupExists(short paramShort) {
/* 140 */     for (byte b = 0; b < (this.dgg.getFileIdClusters()).length; b++) {
/*     */       
/* 142 */       if (this.dgg.getFileIdClusters()[b].getDrawingGroupId() == paramShort)
/* 143 */         return true; 
/*     */     } 
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   int findFreeSPIDBlock() {
/* 150 */     int i = this.dgg.getShapeIdMax();
/* 151 */     return (i / 1024 + 1) * 1024;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherDggRecord getDgg() {
/* 162 */     return this.dgg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void incrementDrawingsSaved() {
/* 169 */     this.dgg.setDrawingsSaved(this.dgg.getDrawingsSaved() + 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\DrawingManager2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */