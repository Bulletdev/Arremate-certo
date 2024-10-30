/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ @Deprecated
/*     */ public class DrawingManager
/*     */ {
/*     */   EscherDggRecord dgg;
/*  35 */   Map<Short, EscherDgRecord> dgMap = new HashMap<Short, EscherDgRecord>();
/*     */ 
/*     */   
/*     */   public DrawingManager(EscherDggRecord paramEscherDggRecord) {
/*  39 */     this.dgg = paramEscherDggRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   public EscherDgRecord createDgRecord() {
/*  44 */     EscherDgRecord escherDgRecord = new EscherDgRecord();
/*  45 */     escherDgRecord.setRecordId((short)-4088);
/*  46 */     short s = findNewDrawingGroupId();
/*  47 */     escherDgRecord.setOptions((short)(s << 4));
/*  48 */     escherDgRecord.setNumShapes(0);
/*  49 */     escherDgRecord.setLastMSOSPID(-1);
/*  50 */     this.dgg.addCluster(s, 0);
/*  51 */     this.dgg.setDrawingsSaved(this.dgg.getDrawingsSaved() + 1);
/*  52 */     this.dgMap.put(Short.valueOf(s), escherDgRecord);
/*  53 */     return escherDgRecord;
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
/*  65 */     EscherDgRecord escherDgRecord = this.dgMap.get(Short.valueOf(paramShort));
/*  66 */     int i = escherDgRecord.getLastMSOSPID();
/*     */ 
/*     */ 
/*     */     
/*  70 */     int j = 0;
/*  71 */     if (i % 1024 == 1023) {
/*     */ 
/*     */ 
/*     */       
/*  75 */       j = findFreeSPIDBlock();
/*     */       
/*  77 */       this.dgg.addCluster(paramShort, 1);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/*  83 */       for (byte b = 0; b < (this.dgg.getFileIdClusters()).length; b++) {
/*     */         
/*  85 */         EscherDggRecord.FileIdCluster fileIdCluster = this.dgg.getFileIdClusters()[b];
/*  86 */         if (fileIdCluster.getDrawingGroupId() == paramShort)
/*     */         {
/*  88 */           if (fileIdCluster.getNumShapeIdsUsed() != 1024)
/*     */           {
/*     */             
/*  91 */             fileIdCluster.incrementShapeId();
/*     */           }
/*     */         }
/*     */         
/*  95 */         if (escherDgRecord.getLastMSOSPID() == -1) {
/*     */           
/*  97 */           j = findFreeSPIDBlock();
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 102 */           j = escherDgRecord.getLastMSOSPID() + 1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 107 */     this.dgg.setNumShapesSaved(this.dgg.getNumShapesSaved() + 1);
/*     */     
/* 109 */     if (j >= this.dgg.getShapeIdMax())
/*     */     {
/*     */ 
/*     */       
/* 113 */       this.dgg.setShapeIdMax(j + 1);
/*     */     }
/*     */     
/* 116 */     escherDgRecord.setLastMSOSPID(j);
/*     */     
/* 118 */     escherDgRecord.incrementShapeCount();
/*     */ 
/*     */     
/* 121 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   short findNewDrawingGroupId() {
/* 127 */     short s = 1;
/* 128 */     while (drawingGroupExists(s))
/* 129 */       s = (short)(s + 1); 
/* 130 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean drawingGroupExists(short paramShort) {
/* 135 */     for (byte b = 0; b < (this.dgg.getFileIdClusters()).length; b++) {
/*     */       
/* 137 */       if (this.dgg.getFileIdClusters()[b].getDrawingGroupId() == paramShort)
/* 138 */         return true; 
/*     */     } 
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   int findFreeSPIDBlock() {
/* 145 */     int i = this.dgg.getShapeIdMax();
/* 146 */     return (i / 1024 + 1) * 1024;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherDggRecord getDgg() {
/* 152 */     return this.dgg;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\DrawingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */