/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.hslf.blip.EMF;
/*     */ import org.apache.poi.hslf.blip.PICT;
/*     */ import org.apache.poi.hslf.blip.WMF;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.Units;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XSLFPictureData
/*     */   extends POIXMLDocumentPart
/*     */   implements PictureData
/*     */ {
/*  52 */   private static final POILogger logger = POILogFactory.getLogger(XSLFPictureData.class);
/*     */   
/*  54 */   private Long checksum = null;
/*     */ 
/*     */   
/*  57 */   private Dimension origSize = null;
/*  58 */   private int index = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSLFPictureData() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFPictureData(PackagePart paramPackagePart) {
/*  75 */     super(paramPackagePart);
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
/*     */   @Deprecated
/*     */   public XSLFPictureData(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/*  88 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() throws IOException {
/*  98 */     return getPackagePart().getInputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getData() {
/*     */     try {
/* 110 */       return IOUtils.toByteArray(getInputStream());
/* 111 */     } catch (IOException iOException) {
/* 112 */       throw new POIXMLException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 122 */     String str = getPackagePart().getPartName().getName();
/* 123 */     return str.substring(str.lastIndexOf('/') + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String suggestFileExtension() {
/* 132 */     return getPackagePart().getPartName().getExtension();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getChecksum() {
/* 137 */     cacheProperties();
/* 138 */     byte[] arrayOfByte = new byte[8];
/* 139 */     LittleEndian.putLong(arrayOfByte, 0, this.checksum.longValue());
/* 140 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getImageDimension() {
/* 145 */     cacheProperties();
/* 146 */     return this.origSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public Dimension getImageDimensionInPixels() {
/* 151 */     Dimension dimension = getImageDimension();
/* 152 */     return new Dimension(Units.pointsToPixel(dimension.getWidth()), Units.pointsToPixel(dimension.getHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cacheProperties() {
/* 162 */     if (this.origSize == null || this.checksum == null) {
/* 163 */       byte[] arrayOfByte = getData();
/* 164 */       this.checksum = Long.valueOf(IOUtils.calculateChecksum(arrayOfByte));
/*     */       
/* 166 */       PictureData.PictureType pictureType = getType();
/* 167 */       if (pictureType == null) {
/* 168 */         this.origSize = new Dimension(1, 1);
/*     */         
/*     */         return;
/*     */       } 
/* 172 */       switch (pictureType) {
/*     */         case EMF:
/* 174 */           this.origSize = (new EMF.NativeHeader(arrayOfByte, 0)).getSize();
/*     */           return;
/*     */ 
/*     */         
/*     */         case WMF:
/* 179 */           this.origSize = (new WMF.NativeHeader(arrayOfByte, 0)).getSize();
/*     */           return;
/*     */         case PICT:
/* 182 */           this.origSize = (new PICT.NativeHeader(arrayOfByte, 0)).getSize();
/*     */           return;
/*     */       } 
/* 185 */       BufferedImage bufferedImage = null;
/*     */       try {
/* 187 */         bufferedImage = ImageIO.read(new ByteArrayInputStream(arrayOfByte));
/* 188 */       } catch (IOException iOException) {
/* 189 */         logger.log(5, new Object[] { "Can't determine image dimensions", iOException });
/*     */       } 
/*     */       
/* 192 */       this.origSize = (bufferedImage == null) ? new Dimension(200, 200) : new Dimension((int)Units.pixelToPoints(bufferedImage.getWidth()), (int)Units.pixelToPoints(bufferedImage.getHeight()));
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
/*     */   protected void prepareForCommit() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/* 214 */     return getPackagePart().getContentType();
/*     */   }
/*     */   
/*     */   public void setData(byte[] paramArrayOfbyte) throws IOException {
/* 218 */     OutputStream outputStream = getPackagePart().getOutputStream();
/* 219 */     outputStream.write(paramArrayOfbyte);
/* 220 */     outputStream.close();
/*     */     
/* 222 */     this.checksum = Long.valueOf(IOUtils.calculateChecksum(paramArrayOfbyte));
/*     */     
/* 224 */     this.origSize = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public PictureData.PictureType getType() {
/* 229 */     String str = getContentType();
/* 230 */     if (XSLFRelation.IMAGE_EMF.getContentType().equals(str))
/* 231 */       return PictureData.PictureType.EMF; 
/* 232 */     if (XSLFRelation.IMAGE_WMF.getContentType().equals(str))
/* 233 */       return PictureData.PictureType.WMF; 
/* 234 */     if (XSLFRelation.IMAGE_PICT.getContentType().equals(str))
/* 235 */       return PictureData.PictureType.PICT; 
/* 236 */     if (XSLFRelation.IMAGE_JPEG.getContentType().equals(str))
/* 237 */       return PictureData.PictureType.JPEG; 
/* 238 */     if (XSLFRelation.IMAGE_PNG.getContentType().equals(str))
/* 239 */       return PictureData.PictureType.PNG; 
/* 240 */     if (XSLFRelation.IMAGE_DIB.getContentType().equals(str))
/* 241 */       return PictureData.PictureType.DIB; 
/* 242 */     if (XSLFRelation.IMAGE_GIF.getContentType().equals(str))
/* 243 */       return PictureData.PictureType.GIF; 
/* 244 */     if (XSLFRelation.IMAGE_EPS.getContentType().equals(str))
/* 245 */       return PictureData.PictureType.EPS; 
/* 246 */     if (XSLFRelation.IMAGE_BMP.getContentType().equals(str))
/* 247 */       return PictureData.PictureType.BMP; 
/* 248 */     if (XSLFRelation.IMAGE_WPG.getContentType().equals(str))
/* 249 */       return PictureData.PictureType.WPG; 
/* 250 */     if (XSLFRelation.IMAGE_WDP.getContentType().equals(str))
/* 251 */       return PictureData.PictureType.WDP; 
/* 252 */     if (XSLFRelation.IMAGE_TIFF.getContentType().equals(str)) {
/* 253 */       return PictureData.PictureType.TIFF;
/*     */     }
/* 255 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   static XSLFRelation getRelationForType(PictureData.PictureType paramPictureType) {
/* 260 */     switch (paramPictureType) { case EMF:
/* 261 */         return XSLFRelation.IMAGE_EMF;
/* 262 */       case WMF: return XSLFRelation.IMAGE_WMF;
/* 263 */       case PICT: return XSLFRelation.IMAGE_PICT;
/* 264 */       case JPEG: return XSLFRelation.IMAGE_JPEG;
/* 265 */       case PNG: return XSLFRelation.IMAGE_PNG;
/* 266 */       case DIB: return XSLFRelation.IMAGE_DIB;
/* 267 */       case GIF: return XSLFRelation.IMAGE_GIF;
/* 268 */       case EPS: return XSLFRelation.IMAGE_EPS;
/* 269 */       case BMP: return XSLFRelation.IMAGE_BMP;
/* 270 */       case WPG: return XSLFRelation.IMAGE_WPG;
/* 271 */       case WDP: return XSLFRelation.IMAGE_WDP;
/* 272 */       case TIFF: return XSLFRelation.IMAGE_TIFF; }
/* 273 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndex() {
/* 281 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndex(int paramInt) {
/* 288 */     this.index = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFPictureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */