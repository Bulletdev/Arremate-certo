/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import org.apache.poi.ddf.DefaultEscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherBSERecord;
/*     */ import org.apache.poi.ddf.EscherBlipRecord;
/*     */ import org.apache.poi.ddf.EscherComplexProperty;
/*     */ import org.apache.poi.ddf.EscherContainerRecord;
/*     */ import org.apache.poi.ddf.EscherOptRecord;
/*     */ import org.apache.poi.ddf.EscherProperty;
/*     */ import org.apache.poi.ddf.EscherRecordFactory;
/*     */ import org.apache.poi.ddf.EscherSimpleProperty;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
/*     */ import org.apache.poi.hssf.record.EscherAggregate;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Picture;
/*     */ import org.apache.poi.ss.usermodel.PictureData;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.ImageUtils;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFPicture
/*     */   extends HSSFSimpleShape
/*     */   implements Picture
/*     */ {
/*  49 */   private static POILogger logger = POILogFactory.getLogger(HSSFPicture.class);
/*     */   
/*     */   public static final int PICTURE_TYPE_EMF = 2;
/*     */   public static final int PICTURE_TYPE_WMF = 3;
/*     */   public static final int PICTURE_TYPE_PICT = 4;
/*     */   public static final int PICTURE_TYPE_JPEG = 5;
/*     */   public static final int PICTURE_TYPE_PNG = 6;
/*     */   public static final int PICTURE_TYPE_DIB = 7;
/*     */   
/*     */   public HSSFPicture(EscherContainerRecord paramEscherContainerRecord, ObjRecord paramObjRecord) {
/*  59 */     super(paramEscherContainerRecord, paramObjRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPicture(HSSFShape paramHSSFShape, HSSFAnchor paramHSSFAnchor) {
/*  67 */     super(paramHSSFShape, paramHSSFAnchor);
/*  68 */     super.setShapeType(75);
/*  69 */     CommonObjectDataSubRecord commonObjectDataSubRecord = getObjRecord().getSubRecords().get(0);
/*  70 */     commonObjectDataSubRecord.setObjectType((short)8);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPictureIndex() {
/*  75 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)getOptRecord().lookup(260);
/*  76 */     if (null == escherSimpleProperty) {
/*  77 */       return -1;
/*     */     }
/*  79 */     return escherSimpleProperty.getPropertyValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPictureIndex(int paramInt) {
/*  84 */     setPropertyValue((EscherProperty)new EscherSimpleProperty((short)260, false, true, paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   protected EscherContainerRecord createSpContainer() {
/*  89 */     EscherContainerRecord escherContainerRecord = super.createSpContainer();
/*  90 */     EscherOptRecord escherOptRecord = (EscherOptRecord)escherContainerRecord.getChildById((short)-4085);
/*  91 */     escherOptRecord.removeEscherProperty(462);
/*  92 */     escherOptRecord.removeEscherProperty(511);
/*  93 */     escherContainerRecord.removeChildRecord(escherContainerRecord.getChildById((short)-4083));
/*  94 */     return escherContainerRecord;
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
/*     */   public void resize() {
/* 107 */     resize(Double.MAX_VALUE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(double paramDouble) {
/* 116 */     resize(paramDouble, paramDouble);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(double paramDouble1, double paramDouble2) {
/* 137 */     HSSFClientAnchor hSSFClientAnchor1 = getClientAnchor();
/* 138 */     hSSFClientAnchor1.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
/*     */     
/* 140 */     HSSFClientAnchor hSSFClientAnchor2 = getPreferredSize(paramDouble1, paramDouble2);
/*     */     
/* 142 */     int i = hSSFClientAnchor1.getRow1() + hSSFClientAnchor2.getRow2() - hSSFClientAnchor2.getRow1();
/* 143 */     int j = hSSFClientAnchor1.getCol1() + hSSFClientAnchor2.getCol2() - hSSFClientAnchor2.getCol1();
/*     */     
/* 145 */     hSSFClientAnchor1.setCol2((short)j);
/*     */     
/* 147 */     hSSFClientAnchor1.setDx2(hSSFClientAnchor2.getDx2());
/*     */     
/* 149 */     hSSFClientAnchor1.setRow2(i);
/*     */     
/* 151 */     hSSFClientAnchor1.setDy2(hSSFClientAnchor2.getDy2());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFClientAnchor getPreferredSize() {
/* 161 */     return getPreferredSize(1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFClientAnchor getPreferredSize(double paramDouble) {
/* 172 */     return getPreferredSize(paramDouble, paramDouble);
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
/*     */   public HSSFClientAnchor getPreferredSize(double paramDouble1, double paramDouble2) {
/* 184 */     ImageUtils.setPreferredSize(this, paramDouble1, paramDouble2);
/* 185 */     return getClientAnchor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getImageDimension() {
/* 194 */     InternalWorkbook internalWorkbook = getPatriarch().getSheet().getWorkbook().getWorkbook();
/* 195 */     EscherBSERecord escherBSERecord = internalWorkbook.getBSERecord(getPictureIndex());
/* 196 */     byte[] arrayOfByte = escherBSERecord.getBlipRecord().getPicturedata();
/* 197 */     byte b = escherBSERecord.getBlipTypeWin32();
/* 198 */     return ImageUtils.getImageDimension(new ByteArrayInputStream(arrayOfByte), b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPictureData getPictureData() {
/* 207 */     InternalWorkbook internalWorkbook = getPatriarch().getSheet().getWorkbook().getWorkbook();
/* 208 */     EscherBSERecord escherBSERecord = internalWorkbook.getBSERecord(getPictureIndex());
/* 209 */     EscherBlipRecord escherBlipRecord = escherBSERecord.getBlipRecord();
/* 210 */     return new HSSFPictureData(escherBlipRecord);
/*     */   }
/*     */ 
/*     */   
/*     */   void afterInsert(HSSFPatriarch paramHSSFPatriarch) {
/* 215 */     EscherAggregate escherAggregate = paramHSSFPatriarch.getBoundAggregate();
/* 216 */     escherAggregate.associateShapeToObjRecord(getEscherContainer().getChildById((short)-4079), (Record)getObjRecord());
/* 217 */     if (getPictureIndex() != -1) {
/* 218 */       EscherBSERecord escherBSERecord = paramHSSFPatriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
/*     */       
/* 220 */       escherBSERecord.setRef(escherBSERecord.getRef() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 228 */     EscherComplexProperty escherComplexProperty = (EscherComplexProperty)getOptRecord().lookup(261);
/*     */     
/* 230 */     return (null == escherComplexProperty) ? "" : StringUtil.getFromUnicodeLE(escherComplexProperty.getComplexData()).trim();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileName(String paramString) {
/* 237 */     byte[] arrayOfByte = StringUtil.getToUnicodeLE(paramString);
/* 238 */     EscherComplexProperty escherComplexProperty = new EscherComplexProperty((short)261, true, arrayOfByte);
/* 239 */     setPropertyValue((EscherProperty)escherComplexProperty);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShapeType(int paramInt) {
/* 244 */     throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
/*     */   }
/*     */ 
/*     */   
/*     */   protected HSSFShape cloneShape() {
/* 249 */     EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
/* 250 */     byte[] arrayOfByte = getEscherContainer().serialize();
/* 251 */     escherContainerRecord.fillFields(arrayOfByte, 0, (EscherRecordFactory)new DefaultEscherRecordFactory());
/* 252 */     ObjRecord objRecord = (ObjRecord)getObjRecord().cloneViaReserialise();
/* 253 */     return new HSSFPicture(escherContainerRecord, objRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFClientAnchor getClientAnchor() {
/* 261 */     HSSFAnchor hSSFAnchor = getAnchor();
/* 262 */     return (hSSFAnchor instanceof HSSFClientAnchor) ? (HSSFClientAnchor)hSSFAnchor : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFSheet getSheet() {
/* 271 */     return getPatriarch().getSheet();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */