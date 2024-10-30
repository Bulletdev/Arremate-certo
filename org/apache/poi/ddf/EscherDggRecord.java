/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.RecordFormatException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EscherDggRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4090;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtDgg";
/*     */   private int field_1_shapeIdMax;
/*     */   private int field_3_numShapesSaved;
/*     */   private int field_4_drawingsSaved;
/*     */   private FileIdCluster[] field_5_fileIdClusters;
/*     */   private int maxDgId;
/*     */   
/*     */   public static class FileIdCluster
/*     */   {
/*     */     private int field_1_drawingGroupId;
/*     */     private int field_2_numShapeIdsUsed;
/*     */     
/*     */     public FileIdCluster(int param1Int1, int param1Int2) {
/*  44 */       this.field_1_drawingGroupId = param1Int1;
/*  45 */       this.field_2_numShapeIdsUsed = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getDrawingGroupId() {
/*  53 */       return this.field_1_drawingGroupId;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getNumShapeIdsUsed() {
/*  58 */       return this.field_2_numShapeIdsUsed;
/*     */     }
/*     */ 
/*     */     
/*     */     public void incrementShapeId() {
/*  63 */       this.field_2_numShapeIdsUsed++;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  69 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  70 */     int j = paramInt + 8;
/*  71 */     byte b1 = 0;
/*  72 */     this.field_1_shapeIdMax = LittleEndian.getInt(paramArrayOfbyte, j + b1); b1 += 4;
/*     */     
/*  74 */     b1 += 4;
/*  75 */     this.field_3_numShapesSaved = LittleEndian.getInt(paramArrayOfbyte, j + b1); b1 += 4;
/*  76 */     this.field_4_drawingsSaved = LittleEndian.getInt(paramArrayOfbyte, j + b1); b1 += 4;
/*  77 */     this.field_5_fileIdClusters = new FileIdCluster[(i - b1) / 8];
/*  78 */     for (byte b2 = 0; b2 < this.field_5_fileIdClusters.length; b2++) {
/*     */       
/*  80 */       this.field_5_fileIdClusters[b2] = new FileIdCluster(LittleEndian.getInt(paramArrayOfbyte, j + b1), LittleEndian.getInt(paramArrayOfbyte, j + b1 + 4));
/*  81 */       this.maxDgId = Math.max(this.maxDgId, this.field_5_fileIdClusters[b2].getDrawingGroupId());
/*  82 */       b1 += 8;
/*     */     } 
/*  84 */     i -= b1;
/*  85 */     if (i != 0)
/*  86 */       throw new RecordFormatException("Expecting no remaining data but got " + i + " byte(s)."); 
/*  87 */     return 8 + b1 + i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  92 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  94 */     int i = paramInt;
/*  95 */     LittleEndian.putShort(paramArrayOfbyte, i, getOptions()); i += 2;
/*  96 */     LittleEndian.putShort(paramArrayOfbyte, i, getRecordId()); i += 2;
/*  97 */     int j = getRecordSize() - 8;
/*  98 */     LittleEndian.putInt(paramArrayOfbyte, i, j); i += 4;
/*     */     
/* 100 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_1_shapeIdMax); i += 4;
/* 101 */     LittleEndian.putInt(paramArrayOfbyte, i, getNumIdClusters()); i += 4;
/* 102 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_numShapesSaved); i += 4;
/* 103 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_drawingsSaved); i += 4;
/* 104 */     for (byte b = 0; b < this.field_5_fileIdClusters.length; b++) {
/* 105 */       LittleEndian.putInt(paramArrayOfbyte, i, (this.field_5_fileIdClusters[b]).field_1_drawingGroupId); i += 4;
/* 106 */       LittleEndian.putInt(paramArrayOfbyte, i, (this.field_5_fileIdClusters[b]).field_2_numShapeIdsUsed); i += 4;
/*     */     } 
/*     */     
/* 109 */     paramEscherSerializationListener.afterRecordSerialize(i, getRecordId(), getRecordSize(), this);
/* 110 */     return getRecordSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 115 */     return 24 + 8 * this.field_5_fileIdClusters.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/* 120 */     return -4090;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 125 */     return "Dgg";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuilder stringBuilder = new StringBuilder();
/* 132 */     if (this.field_5_fileIdClusters != null) for (byte b = 0; b < this.field_5_fileIdClusters.length; b++) {
/* 133 */         stringBuilder.append("  DrawingGroupId").append(b + 1).append(": ");
/* 134 */         stringBuilder.append((this.field_5_fileIdClusters[b]).field_1_drawingGroupId);
/* 135 */         stringBuilder.append('\n');
/* 136 */         stringBuilder.append("  NumShapeIdsUsed").append(b + 1).append(": ");
/* 137 */         stringBuilder.append((this.field_5_fileIdClusters[b]).field_2_numShapeIdsUsed);
/* 138 */         stringBuilder.append('\n');
/*     */       }  
/* 140 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex((short)-4090) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  ShapeIdMax: " + this.field_1_shapeIdMax + '\n' + "  NumIdClusters: " + getNumIdClusters() + '\n' + "  NumShapesSaved: " + this.field_3_numShapesSaved + '\n' + "  DrawingsSaved: " + this.field_4_drawingsSaved + '\n' + "" + stringBuilder.toString();
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
/*     */   public String toXml(String paramString) {
/* 154 */     StringBuilder stringBuilder = new StringBuilder();
/* 155 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<ShapeIdMax>").append(this.field_1_shapeIdMax).append("</ShapeIdMax>\n").append(paramString).append("\t").append("<NumIdClusters>").append(getNumIdClusters()).append("</NumIdClusters>\n").append(paramString).append("\t").append("<NumShapesSaved>").append(this.field_3_numShapesSaved).append("</NumShapesSaved>\n").append(paramString).append("\t").append("<DrawingsSaved>").append(this.field_4_drawingsSaved).append("</DrawingsSaved>\n");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 161 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShapeIdMax() {
/* 170 */     return this.field_1_shapeIdMax;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeIdMax(int paramInt) {
/* 179 */     this.field_1_shapeIdMax = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumIdClusters() {
/* 188 */     return (this.field_5_fileIdClusters == null) ? 0 : (this.field_5_fileIdClusters.length + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumShapesSaved() {
/* 197 */     return this.field_3_numShapesSaved;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumShapesSaved(int paramInt) {
/* 206 */     this.field_3_numShapesSaved = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDrawingsSaved() {
/* 215 */     return this.field_4_drawingsSaved;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDrawingsSaved(int paramInt) {
/* 224 */     this.field_4_drawingsSaved = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDrawingGroupId() {
/* 233 */     return this.maxDgId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxDrawingGroupId(int paramInt) {
/* 242 */     this.maxDgId = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileIdCluster[] getFileIdClusters() {
/* 249 */     return this.field_5_fileIdClusters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileIdClusters(FileIdCluster[] paramArrayOfFileIdCluster) {
/* 258 */     this.field_5_fileIdClusters = (FileIdCluster[])paramArrayOfFileIdCluster.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCluster(int paramInt1, int paramInt2) {
/* 269 */     addCluster(paramInt1, paramInt2, true);
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
/*     */   public void addCluster(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 281 */     ArrayList<FileIdCluster> arrayList = new ArrayList(Arrays.asList((Object[])this.field_5_fileIdClusters));
/* 282 */     arrayList.add(new FileIdCluster(paramInt1, paramInt2));
/* 283 */     if (paramBoolean) Collections.sort(arrayList, MY_COMP); 
/* 284 */     this.maxDgId = Math.min(this.maxDgId, paramInt1);
/* 285 */     this.field_5_fileIdClusters = arrayList.<FileIdCluster>toArray(new FileIdCluster[arrayList.size()]);
/*     */   }
/*     */   
/* 288 */   private static final Comparator<FileIdCluster> MY_COMP = new Comparator<FileIdCluster>()
/*     */     {
/*     */       public int compare(EscherDggRecord.FileIdCluster param1FileIdCluster1, EscherDggRecord.FileIdCluster param1FileIdCluster2) {
/* 291 */         if (param1FileIdCluster1.getDrawingGroupId() == param1FileIdCluster2.getDrawingGroupId()) {
/* 292 */           return 0;
/*     */         }
/* 294 */         if (param1FileIdCluster1.getDrawingGroupId() < param1FileIdCluster2.getDrawingGroupId()) {
/* 295 */           return -1;
/*     */         }
/* 297 */         return 1;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherDggRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */